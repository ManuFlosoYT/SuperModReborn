package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.block.custom.EndLamp;
import net.manufloso.supermodreborn;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, supermodreborn.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LITHIUM_BLOCK);
        blockWithItem(ModBlocks.LITHIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LITHIUM_ORE);

        blockWithItem(ModBlocks.PALM_PLANKS);
        blockWithItem(ModBlocks.CHUNK_LOADER);


        stairsBlock(ModBlocks.PALM_STAIRS.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        slabBlock(ModBlocks.PALM_SLAB.get(), blockTexture(ModBlocks.PALM_PLANKS.get()), blockTexture(ModBlocks.PALM_PLANKS.get()));

        buttonBlock(ModBlocks.PALM_BUTTON.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PALM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));

        fenceBlock(ModBlocks.PALM_FENCE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        fenceGateBlock(ModBlocks.PALM_FENCE_GATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        wallBlock(ModBlocks.PALM_WALL.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.PALM_DOOR.get(), modLoc("block/palm_door_bottom"), modLoc("block/palm_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALM_TRAPDOOR.get(), modLoc("block/palm_trapdoor"), true, "cutout");

        blockItem(ModBlocks.PALM_STAIRS);
        blockItem(ModBlocks.PALM_SLAB);
        blockItem(ModBlocks.PALM_PRESSURE_PLATE);
        blockItem(ModBlocks.PALM_FENCE_GATE);
        blockItem(ModBlocks.PALM_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.END_LAMP.get()).forAllStates(state -> {
            if(state.getValue(EndLamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("end_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "block/" + "end_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("end_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "block/" + "end_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.END_LAMP.get(), models().cubeAll("end_lamp_on",
                ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "block/" + "end_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("supermodreborn:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("supermodreborn:block/" + deferredBlock.getId().getPath() + appendix));
    }
}