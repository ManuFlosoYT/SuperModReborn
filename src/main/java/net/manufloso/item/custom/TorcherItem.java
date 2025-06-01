package net.manufloso.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TorcherItem extends Item {

    private static final int REQUIRED_LIGHT_LEVEL = 7;
    private static final int COOLDOWN_TICKS = 10; // 0.5 segundos

    public TorcherItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (!(entity instanceof Player player)) {
            return;
        }

        // Actuar solo en el lado del servidor y si el ítem está en alguna mano
        boolean isInMainHand = player.getMainHandItem() == stack;
        boolean isInOffHand = player.getOffhandItem() == stack;

        if (!level.isClientSide && (isInMainHand || isInOffHand) && player.isShiftKeyDown()) {
            // Verificar cooldown
            if (player.getCooldowns().isOnCooldown(this)) {
                return;
            }

            BlockPos feetPos = player.blockPosition(); // Posición del bloque donde están los pies del jugador

            // Comprobar nivel de luz. Level.getLightLevel(pos) es una buena opción moderna.
            if (level.getRawBrightness(feetPos, 0) < REQUIRED_LIGHT_LEVEL) {
                BlockState torchBlockState = Blocks.TORCH.defaultBlockState();
                BlockState currentBlockStateAtFeet = level.getBlockState(feetPos);

                // Comprobar si el lugar es reemplazable (ej. aire, hierba alta)
                // Y si una antorcha puede sobrevivir en esa posición (necesita un bloque sólido debajo)
                if (currentBlockStateAtFeet.canBeReplaced() && torchBlockState.canSurvive(level, feetPos)) {

//                    // Intentar consumir una antorcha del inventario del jugador
//                    boolean consumedTorch = false;
//                    Inventory inventory = player.getInventory();
//                    for (int i = 0; i < inventory.getContainerSize(); ++i) {
//                        ItemStack inventoryStack = inventory.getItem(i);
//                        if (inventoryStack.is(Items.TORCH)) {
//                            inventoryStack.shrink(1);
//                            // No es necesario inventory.setItem(i, ItemStack.EMPTY) si shrink lo maneja.
//                            // Pero es más seguro si el stack se vació completamente.
//                            if (inventoryStack.isEmpty()) {
//                                inventory.setItem(i, ItemStack.EMPTY);
//                            }
//                            consumedTorch = true;
//                            break;
//                        }
//                    }

                    // Colocar la antorcha
                    level.setBlock(feetPos, torchBlockState, Block.UPDATE_ALL_IMMEDIATE | Block.UPDATE_NEIGHBORS);

                    // Sonido de colocación
                    level.playSound(null, feetPos, torchBlockState.getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

                    // Aplicar cooldown al "Torcher"
                    player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
                }
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.torcher.description"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}