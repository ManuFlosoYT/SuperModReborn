package net.manufloso.block;

import net.manufloso.block.custom.*;
import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.manufloso.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(supermodreborn.MODID);

    public static final DeferredBlock<Block> LITHIUM_ORE = registerBlock(
            "lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_LITHIUM_ORE = registerBlock(
            "deepslate_lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            ));

    public static final DeferredBlock<Block> LITHIUM_BLOCK = registerBlock(
            "lithium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
            ));

    public static final DeferredBlock<Block> ENDIUM_BLOCK = registerBlock(
            "endium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .explosionResistance(5000f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
            ));

    public static final DeferredBlock<Block> CHUNK_LOADER = registerBlock(
            "chunk_loader",
            () -> new ChunkLoader(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }
            });
    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlock(ModTreeGrowers.PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)) {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });


    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock(
            "palm_stairs",
            () -> new StairBlock(
                    ModBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock(
            "palm_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock(
            "palm_pressure_plate",
            () -> new PressurePlateBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock(
            "palm_button",
            () -> new ButtonBlock(
                    BlockSetType.OAK,
                    20,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
                            .noCollission()
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock(
            "palm_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock(
            "palm_fence_gate",
            () -> new FenceGateBlock(
                    WoodType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<WallBlock> PALM_WALL = registerBlock(
            "palm_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock(
            "palm_door",
            () -> new DoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
                            .noOcclusion()
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock(
            "palm_trapdoor",
            () -> new TrapDoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
                            .noOcclusion()
            )
            {
                @Override
                public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> END_LAMP = registerBlock(
            "end_lamp",
            () -> new EndLamp(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .lightLevel(
                                    state -> state.getValue(EndLamp.CLICKED) ? 15 : 0
                            )
            )
    );



    // DECO BLOCKS

    public static final DeferredBlock<Block> DECO_1 = registerBlock(
            "deco_1",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_2 = registerBlock(
            "deco_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_3 = registerBlock(
            "deco_3",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_4 = registerBlock(
            "deco_4",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_5 = registerBlock(
            "deco_5",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_6 = registerBlock(
            "deco_6",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_7 = registerBlock(
            "deco_7",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_8 = registerBlock(
            "deco_8",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_9 = registerBlock(
            "deco_9",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_10 = registerBlock(
            "deco_10",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_11 = registerBlock(
            "deco_11",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_12 = registerBlock(
            "deco_12",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_13 = registerBlock(
            "deco_13",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_14 = registerBlock(
            "deco_14",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_15 = registerBlock(
            "deco_15",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_16 = registerBlock(
            "deco_16",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_17 = registerBlock(
            "deco_17",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_18 = registerBlock(
            "deco_18",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_19 = registerBlock(
            "deco_19",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_20 = registerBlock(
            "deco_20",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_21 = registerBlock(
            "deco_21",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_22 = registerBlock(
            "deco_22",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_23 = registerBlock(
            "deco_23",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_24 = registerBlock(
            "deco_24",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_25 = registerBlock(
            "deco_25",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_26 = registerBlock(
            "deco_26",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_27 = registerBlock(
            "deco_27",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_28 = registerBlock(
            "deco_28",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_29 = registerBlock(
            "deco_29",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_30 = registerBlock(
            "deco_30",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_31 = registerBlock(
            "deco_31",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_32 = registerBlock(
            "deco_32",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_33 = registerBlock(
            "deco_33",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_34 = registerBlock(
            "deco_34",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_35 = registerBlock(
            "deco_35",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_36 = registerBlock(
            "deco_36",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_37 = registerBlock(
            "deco_37",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_38 = registerBlock(
            "deco_38",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_39 = registerBlock(
            "deco_39",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_40 = registerBlock(
            "deco_40",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_41 = registerBlock(
            "deco_41",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_42 = registerBlock(
            "deco_42",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_43 = registerBlock(
            "deco_43",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_44 = registerBlock(
            "deco_44",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_45 = registerBlock(
            "deco_45",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_46 = registerBlock(
            "deco_46",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_47 = registerBlock(
            "deco_47",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_48 = registerBlock(
            "deco_48",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_49 = registerBlock(
            "deco_49",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_50 = registerBlock(
            "deco_50",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_51 = registerBlock(
            "deco_51",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_52 = registerBlock(
            "deco_52",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_53 = registerBlock(
            "deco_53",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_54 = registerBlock(
            "deco_54",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_55 = registerBlock(
            "deco_55",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_56 = registerBlock(
            "deco_56",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_57 = registerBlock(
            "deco_57",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DECO_58 = registerBlock(
            "deco_58",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));

    public static final DeferredBlock<Block> ENDIUM_ORE = registerBlock(
            "endium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .sound(SoundType.STONE)
            ));


    public static final DeferredBlock<Block> HOLLOW_OAK_LOG = registerBlock("hollow_oak_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_OAK_LOG = registerBlock("hollow_stripped_oak_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_BIRCH_LOG = registerBlock("hollow_birch_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_BIRCH_LOG = registerBlock("hollow_stripped_birch_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_SPRUCE_LOG = registerBlock("hollow_spruce_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_SPRUCE_LOG = registerBlock("hollow_stripped_spruce_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_ACACIA_LOG = registerBlock("hollow_acacia_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_ACACIA_LOG = registerBlock("hollow_stripped_acacia_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_JUNGLE_LOG = registerBlock("hollow_jungle_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_JUNGLE_LOG = registerBlock("hollow_stripped_jungle_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_DARK_OAK_LOG = registerBlock("hollow_dark_oak_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_DARK_OAK_LOG = registerBlock("hollow_stripped_dark_oak_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_MANGROVE_LOG = registerBlock("hollow_mangrove_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_MANGROVE_LOG = registerBlock("hollow_stripped_mangrove_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_CHERRY_LOG = registerBlock("hollow_cherry_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_CHERRY_LOG = registerBlock("hollow_stripped_cherry_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_BAMBOO_BLOCK = registerBlock("hollow_bamboo_block",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_BAMBOO_BLOCK = registerBlock("hollow_stripped_bamboo_block",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_CRIMSON_STEM = registerBlock("hollow_crimson_stem",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_CRIMSON_STEM = registerBlock("hollow_stripped_crimson_stem",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_WARPED_STEM = registerBlock("hollow_warped_stem",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_WARPED_STEM = registerBlock("hollow_stripped_warped_stem",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_PALM_LOG = registerBlock("hollow_palm_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<Block> HOLLOW_STRIPPED_PALM_LOG = registerBlock("hollow_stripped_palm_log",
            () -> new ModHollowLogBlock(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.WOOD).noOcclusion()));





    public static final DeferredBlock<Block> PEDESTAL = registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of().noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
