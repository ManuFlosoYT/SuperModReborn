package net.manufloso.block.custom;

import com.mojang.serialization.MapCodec;
import net.manufloso.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ModHollowLogBlock extends RotatedPillarBlock {
    public static final MapCodec<ModHollowLogBlock> CODEC = simpleCodec(ModHollowLogBlock::new);
    // --- VoxelShape para el eje Y (vertical) ---
    private static final VoxelShape SHAPE_Y_OUTER = Shapes.block();
    private static final VoxelShape SHAPE_Y_INNER_HOLE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    public static final VoxelShape SHAPE_Y = Shapes.join(SHAPE_Y_OUTER, SHAPE_Y_INNER_HOLE, BooleanOp.ONLY_FIRST);

    // --- VoxelShape para el eje X (horizontal) ---
    private static final VoxelShape SHAPE_X_OUTER = Shapes.block();
    private static final VoxelShape SHAPE_X_INNER_HOLE = Block.box(0.0, 1.0, 1.0, 16.0, 15.0, 15.0);
    public static final VoxelShape SHAPE_X = Shapes.join(SHAPE_X_OUTER, SHAPE_X_INNER_HOLE, BooleanOp.ONLY_FIRST);

    // --- VoxelShape para el eje Z (horizontal) ---
    private static final VoxelShape SHAPE_Z_OUTER = Shapes.block();
    private static final VoxelShape SHAPE_Z_INNER_HOLE = Block.box(1.0, 1.0, 0.0, 15.0, 15.0, 16.0);
    public static final VoxelShape SHAPE_Z = Shapes.join(SHAPE_Z_OUTER, SHAPE_Z_INNER_HOLE, BooleanOp.ONLY_FIRST);

    public ModHollowLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable( @NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return true;
    }

    @Override
    public int getFlammability( @NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed( @NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction.Axis axis = state.getValue(RotatedPillarBlock.AXIS);
        return switch (axis) {
            case X -> SHAPE_X;
            case Z -> SHAPE_Z;
            default -> SHAPE_Y;
        };
    }

    @Override
    public @NotNull MapCodec<? extends RotatedPillarBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(@NotNull BlockState state, UseOnContext context,
                                                     @NotNull ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.HOLLOW_OAK_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_BIRCH_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_BIRCH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_SPRUCE_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_SPRUCE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_JUNGLE_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_JUNGLE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_ACACIA_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_ACACIA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_MANGROVE_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_MANGROVE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_DARK_OAK_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_DARK_OAK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_CHERRY_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_CHERRY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_BAMBOO_BLOCK)) {
                return ModBlocks.HOLLOW_STRIPPED_BAMBOO_BLOCK.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_CRIMSON_STEM)) {
                return ModBlocks.HOLLOW_STRIPPED_CRIMSON_STEM.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_WARPED_STEM)) {
                return ModBlocks.HOLLOW_STRIPPED_WARPED_STEM.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            else if(state.is(ModBlocks.HOLLOW_PALM_LOG)) {
                return ModBlocks.HOLLOW_STRIPPED_PALM_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
