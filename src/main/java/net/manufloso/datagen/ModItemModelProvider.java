package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, supermodreborn.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LITHIUM_INGOT.get());
        basicItem(ModItems.RAW_LITHIUM.get());

        basicItem(ModItems.CHEESE.get());
        basicItem(ModItems.LAUNCHER.get());

        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        wallItem(ModBlocks.PALM_WALL, ModBlocks.PALM_PLANKS);
        basicItem(ModBlocks.PALM_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }
}