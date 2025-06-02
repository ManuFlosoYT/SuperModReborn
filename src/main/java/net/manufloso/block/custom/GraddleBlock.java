package net.manufloso.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter; // Necesario para getFluidState
import net.minecraft.world.level.LevelAccessor; // Necesario para updateShape
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock; // Interfaz para bloques anegables
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty; // Para WATERLOGGED
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState; // Necesario para FluidState
import net.minecraft.world.level.material.Fluids; // Para Fluids.WATER y Fluids.EMPTY
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// Implementa SimpleWaterloggedBlock
public class GraddleBlock extends Block implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public static final MapCodec<GraddleBlock> CODEC = simpleCodec(GraddleBlock::new);

    // --- Definiciones de VoxelShape (asumiendo 3 píxeles de grosor) ---
    // FACING representa la cara del bloque de soporte a la que está unido el Graddle.

    // Unido a la cara SUPERIOR de un bloque (está en el suelo), ocupa los 3 píxeles inferiores de su propio espacio.
    protected static final VoxelShape SHAPE_UP = Block.box(0, 0, 0, 16, 3, 16);
    // Unido a la cara INFERIOR de un bloque (está en el techo), ocupa los 3 píxeles superiores de su propio espacio.
    protected static final VoxelShape SHAPE_DOWN = Block.box(0, 13, 0, 16, 16, 16);
    // Unido a la cara NORTE de un bloque, ocupa los 3 píxeles más al norte de su propio espacio.
    protected static final VoxelShape SHAPE_NORTH = Block.box(0, 0, 0, 16, 16, 3);
    // Unido a la cara SUR de un bloque, ocupa los 3 píxeles más al sur de su propio espacio.
    protected static final VoxelShape SHAPE_SOUTH = Block.box(0, 0, 13, 16, 16, 16);
    // Unido a la cara OESTE de un bloque, ocupa los 3 píxeles más al oeste de su propio espacio.
    protected static final VoxelShape SHAPE_WEST = Block.box(0, 0, 0, 3, 16, 16);
    // Unido a la cara ESTE de un bloque, ocupa los 3 píxeles más al este de su propio espacio.
    protected static final VoxelShape SHAPE_EAST = Block.box(13, 0, 0, 16, 16, 16);



    public GraddleBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE)); // Estado por defecto para WATERLOGGED
    }

    @Override
    protected @NotNull MapCodec<? extends GraddleBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos()); // Obtener estado del fluido
        Direction clickedFace = context.getClickedFace();

        // Orientación basada en la cara clickeada (como antes)
        Direction facingDirection = clickedFace.getOpposite();
        if (clickedFace == Direction.UP || clickedFace == Direction.DOWN) {
            // Si se coloca en suelo/techo, orientar según la mirada horizontal del jugador
            facingDirection = context.getNearestLookingVerticalDirection();
        }

        return this.defaultBlockState()
                .setValue(FACING, facingDirection.getOpposite())
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER); // Establecer WATERLOGGED si hay agua
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED); // Añadir WATERLOGGED a los estados
    }

    // --- Métodos para SimpleWaterloggedBlock ---
    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    // Este método se llama cuando un bloque vecino cambia, permitiendo al bloque reaccionar,
    // por ejemplo, si el agua se elimina o se añade cerca.
    @Override
    public @NotNull BlockState updateShape(BlockState stateIn, @NotNull Direction facing, @NotNull BlockState facingState,
                                           @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }
    // --- Fin de Métodos para SimpleWaterloggedBlock ---


    @Override
    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Direction facing = state.getValue(FACING);
        return switch (facing) {
            case UP -> // Unido a la cara superior de un bloque (en el suelo)
                    SHAPE_UP;
            case DOWN -> // Unido a la cara inferior de un bloque (en el techo)
                    SHAPE_DOWN;
            case NORTH -> // Unido a una pared (en la cara norte del bloque de soporte)
                    SHAPE_SOUTH;
            case SOUTH -> // Unido a una pared (en la cara sur del bloque de soporte)
                    SHAPE_NORTH;
            case WEST ->  // Unido a una pared (en la cara oeste del bloque de soporte)
                    SHAPE_EAST;
            case EAST ->  // Unido a una pared (en la cara este del bloque de soporte)
                    SHAPE_WEST;
            default -> // Esto no debería ocurrir con DirectionProperty
                    SHAPE_UP; // Un valor por defecto seguro
        };
    }
}