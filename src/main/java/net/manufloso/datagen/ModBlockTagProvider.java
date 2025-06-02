package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.util.ModTags;
import net.manufloso.supermodreborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, supermodreborn.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LITHIUM_BLOCK.get())
                .add(ModBlocks.LITHIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get())

                .add(ModBlocks.CHUNK_LOADER.get())

                // DECO BLOCKS

                .add(ModBlocks.DECO_1.get())
                .add(ModBlocks.DECO_2.get())
                .add(ModBlocks.DECO_3.get())
                .add(ModBlocks.DECO_4.get())
                .add(ModBlocks.DECO_5.get())
                .add(ModBlocks.DECO_6.get())
                .add(ModBlocks.DECO_7.get())
                .add(ModBlocks.DECO_8.get())
                .add(ModBlocks.DECO_9.get())
                .add(ModBlocks.DECO_10.get())
                .add(ModBlocks.DECO_11.get())
                .add(ModBlocks.DECO_12.get())
                .add(ModBlocks.DECO_13.get())
                .add(ModBlocks.DECO_14.get())
                .add(ModBlocks.DECO_15.get())
                .add(ModBlocks.DECO_16.get())
                .add(ModBlocks.DECO_17.get())
                .add(ModBlocks.DECO_18.get())
                .add(ModBlocks.DECO_19.get())
                .add(ModBlocks.DECO_20.get())
                .add(ModBlocks.DECO_21.get())
                .add(ModBlocks.DECO_22.get())
                .add(ModBlocks.DECO_23.get())
                .add(ModBlocks.DECO_24.get())
                .add(ModBlocks.DECO_25.get())
                .add(ModBlocks.DECO_26.get())
                .add(ModBlocks.DECO_27.get())
                .add(ModBlocks.DECO_28.get())
                .add(ModBlocks.DECO_29.get())
                .add(ModBlocks.DECO_30.get())
                .add(ModBlocks.DECO_31.get())
                .add(ModBlocks.DECO_32.get())
                .add(ModBlocks.DECO_33.get())
                .add(ModBlocks.DECO_34.get())
                .add(ModBlocks.DECO_35.get())
                .add(ModBlocks.DECO_36.get())
                .add(ModBlocks.DECO_37.get())
                .add(ModBlocks.DECO_38.get())
                .add(ModBlocks.DECO_39.get())
                .add(ModBlocks.DECO_40.get())
                .add(ModBlocks.DECO_41.get())
                .add(ModBlocks.DECO_42.get())
                .add(ModBlocks.DECO_43.get())
                .add(ModBlocks.DECO_44.get())
                .add(ModBlocks.DECO_45.get())
                .add(ModBlocks.DECO_46.get())
                .add(ModBlocks.DECO_47.get())
                .add(ModBlocks.DECO_48.get())
                .add(ModBlocks.DECO_49.get())
                .add(ModBlocks.DECO_50.get())
                .add(ModBlocks.DECO_51.get())
                .add(ModBlocks.DECO_52.get())
                .add(ModBlocks.DECO_53.get())
                .add(ModBlocks.DECO_54.get())
                .add(ModBlocks.DECO_55.get())
                .add(ModBlocks.DECO_56.get())
                .add(ModBlocks.DECO_57.get())
                .add(ModBlocks.DECO_58.get())
                .add(ModBlocks.GRADDLE.get())
        ;

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PALM_PLANKS.get())
                .add(ModBlocks.PALM_STAIRS.get())
                .add(ModBlocks.PALM_SLAB.get())
                .add(ModBlocks.PALM_PRESSURE_PLATE.get())
                .add(ModBlocks.PALM_BUTTON.get())
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get())
                .add(ModBlocks.PALM_WALL.get())
                .add(ModBlocks.PALM_TRAPDOOR.get())
                .add(ModBlocks.PALM_DOOR.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LITHIUM_BLOCK.get())
                .add(ModBlocks.LITHIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get())
                .add(ModBlocks.GRADDLE.get())
                .add(ModBlocks.CHUNK_LOADER.get())
        ;


        tag(BlockTags.FENCES)
                .add(ModBlocks.PALM_FENCE.get())
        ;

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALM_FENCE_GATE.get())
        ;

        tag(BlockTags.WALLS)
                .add(ModBlocks.PALM_WALL.get())
        ;

        tag(ModTags.Blocks.NEEDS_ENDIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
        ;

        tag(ModTags.Blocks.INCORRECT_FOR_ENDIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_ENDIUM_TOOL)
        ;


        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.HOLLOW_OAK_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_OAK_LOG.get())
                .add(ModBlocks.HOLLOW_BIRCH_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_BIRCH_LOG.get())
                .add(ModBlocks.HOLLOW_SPRUCE_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_SPRUCE_LOG.get())
                .add(ModBlocks.HOLLOW_ACACIA_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_ACACIA_LOG.get())
                .add(ModBlocks.HOLLOW_JUNGLE_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_JUNGLE_LOG.get())
                .add(ModBlocks.HOLLOW_DARK_OAK_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_DARK_OAK_LOG.get())
                .add(ModBlocks.HOLLOW_MANGROVE_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_MANGROVE_LOG.get())
                .add(ModBlocks.HOLLOW_CHERRY_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.HOLLOW_BAMBOO_BLOCK.get())
                .add(ModBlocks.HOLLOW_STRIPPED_BAMBOO_BLOCK.get())
                .add(ModBlocks.HOLLOW_CRIMSON_STEM.get())
                .add(ModBlocks.HOLLOW_STRIPPED_CRIMSON_STEM.get())
                .add(ModBlocks.HOLLOW_WARPED_STEM.get())
                .add(ModBlocks.HOLLOW_STRIPPED_WARPED_STEM.get())
                .add(ModBlocks.HOLLOW_PALM_LOG.get())
                .add(ModBlocks.HOLLOW_STRIPPED_PALM_LOG.get())
        ;

    }
}