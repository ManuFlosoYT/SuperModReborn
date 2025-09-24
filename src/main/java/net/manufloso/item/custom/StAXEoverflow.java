package net.manufloso.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;

public class StAXEoverflow extends AxeItem {
    final int MAX_BLOCKS = 128;
    final int HURT_PER_BLOCK = 1;

    public StAXEoverflow(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player && !entity.isShiftKeyDown()) {
            if (state.is(BlockTags.LOGS)) {
                breakSurroundingLogs(level, pos, (Player) entity, stack);
            }
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    private void breakSurroundingLogs(Level level, BlockPos startPos, Player player, ItemStack stack) {
        Queue<BlockPos> queue = new LinkedList<>();
        Set<BlockPos> visited = new HashSet<>();
        queue.add(startPos);
        visited.add(startPos);

        int brokenBlocks = 0;

        while (!queue.isEmpty() && brokenBlocks < MAX_BLOCKS) {

            BlockPos currentPos = queue.poll();

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    for (int z = -1; z <= 1; z++) {
                        if (x == 0 && y == 0 && z == 0) {
                            continue;
                        }

                        BlockPos neighborPos = currentPos.offset(x, y, z);
                        if (visited.contains(neighborPos)) {
                            continue;
                        }

                        BlockState neighborState = level.getBlockState(neighborPos);
                        if (neighborState.is(BlockTags.LOGS)) {
                            visited.add(neighborPos);
                            if (level.destroyBlock(neighborPos, true, player)) {
                                stack.hurtAndBreak(HURT_PER_BLOCK, player, EquipmentSlot.MAINHAND);
                                brokenBlocks++;
                                if (brokenBlocks >= MAX_BLOCKS) {
                                    break;
                                }
                                queue.add(neighborPos);
                            }
                        }
                    }
                    if (brokenBlocks >= MAX_BLOCKS) {
                        break;
                    }
                }
                if (brokenBlocks >= MAX_BLOCKS) {
                    break;
                }
            }
        }
    }
}
