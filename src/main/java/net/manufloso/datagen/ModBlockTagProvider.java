package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
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
        ;

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PALM_PLANKS.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LITHIUM_BLOCK.get())
                .add(ModBlocks.LITHIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get())

                .add(ModBlocks.CHUNK_LOADER.get())
        ;

    }
}