package net.manufloso.event;

import net.manufloso.item.custom.HammerItem;
import net.manufloso.item.custom.LargeShovelItem;
import net.manufloso.supermodreborn;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

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
}