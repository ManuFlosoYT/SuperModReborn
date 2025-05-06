package net.manufloso.block;

import net.manufloso.block.custom.ChunkLoader;
import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(supermodreborn.MODID);

    public static final DeferredBlock<Block> LITHIUM_ORE = registerBlock("lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_LITHIUM_ORE = registerBlock("deepslate_lithium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            ));

    public static final DeferredBlock<Block> LITHIUM_BLOCK = registerBlock("lithium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
            ));

    public static final DeferredBlock<Block> CHUNK_LOADER = registerBlock("chunk_loader",
            () -> new ChunkLoader(BlockBehaviour.Properties.of()
                    .strength(2.5f)
                    .explosionResistance(15f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .explosionResistance(3f)
                    .ignitedByLava()
                    .sound(SoundType.WOOD)
            )
    );


    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(
                    ModBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );
    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
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
    );

    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(
                    WoodType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<WallBlock> PALM_WALL = registerBlock("palm_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
            )
    );

    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
                            .noOcclusion()
            )
    );

    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(
                    BlockSetType.OAK,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .explosionResistance(3f)
                            .ignitedByLava()
                            .sound(SoundType.WOOD)
                            .noOcclusion()
            )
    );

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
