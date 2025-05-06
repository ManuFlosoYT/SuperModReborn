package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
import net.manufloso.item.util.ModTags;
import net.manufloso.supermodreborn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
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
    }
}