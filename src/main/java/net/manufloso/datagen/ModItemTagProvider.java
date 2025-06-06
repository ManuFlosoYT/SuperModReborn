package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
import net.manufloso.util.ModTags;
import net.manufloso.supermodreborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, supermodreborn.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.Items.LITHIUM)
                .add(ModItems.LITHIUM_INGOT.get())
                .add(ModItems.RAW_LITHIUM.get())
                .add(ModBlocks.LITHIUM_BLOCK.asItem())
                .add(ModBlocks.LITHIUM_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.asItem())
        ;

        tag(ItemTags.SWORDS)
                .add(ModItems.ENDIUM_SWORD.get())
        ;

        tag(ItemTags.PICKAXES)
                .add(ModItems.ENDIUM_PICKAXE.get())
                .add(ModItems.ENDIUM_HAMMER.get())
                .add(ModItems.NETHERITE_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.IRON_HAMMER.get())
        ;

        tag(ItemTags.AXES)
                .add(ModItems.ENDIUM_AXE.get())
        ;

        tag(ItemTags.SHOVELS)
                .add(ModItems.ENDIUM_SHOVEL.get())
        ;

        tag(ItemTags.HOES)
                .add(ModItems.ENDIUM_HOE.get())
        ;

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDIUM_HELMET.get())
                .add(ModItems.ENDIUM_CHESTPLATE.get())
                .add(ModItems.ENDIUM_LEGGINGS.get())
                .add(ModItems.ENDIUM_BOOTS.get())
        ;



        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.get().asItem())
                .add(ModBlocks.PALM_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get().asItem())
                .add(ModBlocks.HOLLOW_BIRCH_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_BIRCH_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_SPRUCE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_SPRUCE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_ACACIA_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_ACACIA_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_JUNGLE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_JUNGLE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_DARK_OAK_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_DARK_OAK_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_MANGROVE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_MANGROVE_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_CHERRY_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_CHERRY_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_BAMBOO_BLOCK.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_BAMBOO_BLOCK.get().asItem())
                .add(ModBlocks.HOLLOW_CRIMSON_STEM.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_CRIMSON_STEM.get().asItem())
                .add(ModBlocks.HOLLOW_WARPED_STEM.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_WARPED_STEM.get().asItem())
                .add(ModBlocks.HOLLOW_PALM_LOG.get().asItem())
                .add(ModBlocks.HOLLOW_STRIPPED_PALM_LOG.get().asItem())
        ;

        tag(ItemTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS.asItem())
        ;
    }
}