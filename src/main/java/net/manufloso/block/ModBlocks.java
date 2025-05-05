package net.manufloso.block;

import net.manufloso.block.custom.ChunkLoader;
import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
