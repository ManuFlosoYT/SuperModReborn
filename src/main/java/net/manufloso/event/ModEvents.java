package net.manufloso.event;

import net.manufloso.command.ModCommands;
import net.manufloso.component.ModDataComponents;
import net.manufloso.item.ModItems;
import net.manufloso.item.custom.HammerItem;
import net.manufloso.item.custom.LargeShovelItem;
import net.manufloso.supermodreborn;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.minecraft.core.particles.ParticleTypes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = supermodreborn.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BY_HAMMER_BLOCKS = new HashSet<>();
    private static final Set<BlockPos> HARVESTED_BY_LARGE_SHOVEL_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player instanceof ServerPlayer serverPlayer) {
            ItemStack mainHandItem = player.getMainHandItem();
            Item item = mainHandItem.getItem();

            if (item instanceof HammerItem hammer) {
                handleAreaMine(event, serverPlayer, mainHandItem, hammer, HARVESTED_BY_HAMMER_BLOCKS, 1);
            } else if (item instanceof LargeShovelItem largeShovel) {
                handleAreaMine(event, serverPlayer, mainHandItem, largeShovel, HARVESTED_BY_LARGE_SHOVEL_BLOCKS, 1);
            }
        }
    }

    private static void handleAreaMine(BlockEvent.BreakEvent event, ServerPlayer serverPlayer, ItemStack tool,
                                       DiggerItem diggerItem, Set<BlockPos> harvestedBlocksSet, int range) {
        BlockPos initialBlockPos = event.getPos();
        if (harvestedBlocksSet.contains(initialBlockPos)) {
            return;
        }

        // Determinar los bloques a destruir
        List<BlockPos> blocksToDestroy;
        if (diggerItem instanceof HammerItem) {
            blocksToDestroy = HammerItem.getBlocksToBeDestroyed(range, initialBlockPos, serverPlayer);
        } else if (diggerItem instanceof LargeShovelItem) {
            blocksToDestroy = LargeShovelItem.getBlocksToBeDestroyed(range, initialBlockPos, serverPlayer);
        } else {
            return; // Tipo de herramienta no soportado por esta lógica
        }

        for (BlockPos pos : blocksToDestroy) {
            if (pos.equals(initialBlockPos) || !diggerItem.isCorrectToolForDrops(tool, event.getLevel().getBlockState(pos))) {
                continue;
            }

            harvestedBlocksSet.add(pos);
            serverPlayer.gameMode.destroyBlock(pos);
            harvestedBlocksSet.remove(pos); // Remover después para permitir recursión si fuera el caso, aunque aquí no es recursivo.
        }
    }

    @SubscribeEvent
    public static void onPlayerFall(LivingFallEvent event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Player player)) {
            return;
        }

        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        if (boots.is(ModItems.SLIME_BOOTS.get())) {
            // 1. Eliminar el daño por caída siempre
            event.setDamageMultiplier(0.0F); // Reduce el daño a 0
            event.setCanceled(true);         // Cancela el evento, lo que también previene el sonido de caída normal

            // 2. Efecto de rebote si no está agachado y la caída es > 2 bloques
            if (!player.isShiftKeyDown() && event.getDistance() > 2.0F) {
                Level level = player.level();

                // La lógica de rebote debe ejecutarse en ambos lados para una mejor sensación,
                // pero la generación de sonido y partículas principalmente en el servidor.
                // El cambio de deltaMovement se sincronizará.

                Vec3 currentVelocity = player.getDeltaMovement();
                Vec3 lookAngle = player.getViewVector(1.0F); // Dirección de la mirada

                // Calcula la fuerza del rebote basada en la distancia de caída (limitada)
                // y un factor de rebote base.
                float fallDistance = event.getDistance();
                double bounceFactor = 0.6D + fallDistance/2.0D;

                // Mantiene algo de la velocidad horizontal si la hay, o usa la dirección de la mirada
                double newX = lookAngle.x * bounceFactor * 1.5D;
                double newZ = lookAngle.z * bounceFactor * 1.5D;
                // Siempre rebota hacia arriba
                double newY = Math.abs(currentVelocity.y * -0.5D * bounceFactor) + (0.4D * bounceFactor);
                if (newY < 0.4D) newY = 0.4D; // Mínimo rebote vertical
                if (newY > 1.5D) newY = 1.5D; // Máximo rebote vertical para no lanzar demasiado alto

                player.setDeltaMovement(newX, newY, newZ);
                player.hurtMarked = true; // Importante para sincronizar el movimiento con el cliente

                // Resetear fallDistance aquí también es importante para el servidor
                player.fallDistance = 0.0F;

                if (!level.isClientSide) {
                    // Sonido de slime
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.SLIME_SQUISH_SMALL, SoundSource.PLAYERS,
                            0.8F, 0.8F + level.random.nextFloat() * 0.4F);

                    // Partículas de slime
                    if (level instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.ITEM_SLIME,
                                player.getX(), player.getY() + 0.1, player.getZ(), // Ligeramente arriba de los pies
                                15, // Cantidad
                                0.25D, 0.0D, 0.25D, // Dispersión en XZ
                                0.05D); // Velocidad de las partículas
                    }
                }
            }
            // Si está agachado o la caída es muy corta, solo se niega el daño, pero reseteamos fallDistance
            if(player.fallDistance > 0.0F) {
                player.fallDistance = 0.0F;
            }
        }
    }

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void copyOnDeath(PlayerEvent.Clone event)
    {
        if (event.isWasDeath() && event.getOriginal().hasData(ModDataComponents.MONEY)) {
            event.getEntity().setData(ModDataComponents.MONEY, event.getOriginal().getData(ModDataComponents.MONEY));
        }
    }
}