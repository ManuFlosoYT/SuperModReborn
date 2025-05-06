package net.manufloso.block.custom;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChunkLoader extends Block
{
    public ChunkLoader(Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack)
    {
        super.setPlacedBy(level, pos, state, placer, stack);

        if (!level.isClientSide) {
            if (level instanceof ServerLevel serverLevel) {
                ChunkPos chunkPos = new ChunkPos(pos);

                serverLevel.getChunkSource().updateChunkForced(chunkPos, true);

            }
        }
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving)
    {
        if (!state.is(newState.getBlock()) && !level.isClientSide)
        {
            if (level instanceof ServerLevel serverLevel)
            {
                ChunkPos chunkPos = new ChunkPos(pos);
                serverLevel.getChunkSource().updateChunkForced(chunkPos, false);
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.chunk_loader"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
