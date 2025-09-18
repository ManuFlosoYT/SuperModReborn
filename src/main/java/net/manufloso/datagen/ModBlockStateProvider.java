package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.block.custom.EndLamp;
import net.manufloso.block.custom.TomatoCropBlock;
import net.manufloso.supermodreborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, supermodreborn.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LITHIUM_BLOCK);
        blockWithItem(ModBlocks.LITHIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LITHIUM_ORE);
        blockWithItem(ModBlocks.CHUNK_LOADER);
        blockWithItem(ModBlocks.PALM_PLANKS);

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

        // DECO BLOCKS

        blockWithItem(ModBlocks.DECO_1);
        blockWithItem(ModBlocks.DECO_2);
        blockWithItem(ModBlocks.DECO_3);
        blockWithItem(ModBlocks.DECO_4);
        blockWithItem(ModBlocks.DECO_5);
        blockWithItem(ModBlocks.DECO_6);
        blockWithItem(ModBlocks.DECO_7);
        blockWithItem(ModBlocks.DECO_8);
        blockWithItem(ModBlocks.DECO_9);
        blockWithItem(ModBlocks.DECO_10);
        blockWithItem(ModBlocks.DECO_11);
        blockWithItem(ModBlocks.DECO_12);
        blockWithItem(ModBlocks.DECO_13);
        blockWithItem(ModBlocks.DECO_14);
        blockWithItem(ModBlocks.DECO_15);
        blockWithItem(ModBlocks.DECO_16);
        blockWithItem(ModBlocks.DECO_17);
        blockWithItem(ModBlocks.DECO_18);
        blockWithItem(ModBlocks.DECO_19);
        blockWithItem(ModBlocks.DECO_20);
        blockWithItem(ModBlocks.DECO_21);
        blockWithItem(ModBlocks.DECO_22);
        blockWithItem(ModBlocks.DECO_23);
        blockWithItem(ModBlocks.DECO_24);
        blockWithItem(ModBlocks.DECO_25);
        blockWithItem(ModBlocks.DECO_26);
        blockWithItem(ModBlocks.DECO_27);
        blockWithItem(ModBlocks.DECO_28);
        blockWithItem(ModBlocks.DECO_29);
        blockWithItem(ModBlocks.DECO_30);
        blockWithItem(ModBlocks.DECO_31);
        blockWithItem(ModBlocks.DECO_32);
        blockWithItem(ModBlocks.DECO_33);
        blockWithItem(ModBlocks.DECO_34);
        blockWithItem(ModBlocks.DECO_35);
        blockWithItem(ModBlocks.DECO_36);
        blockWithItem(ModBlocks.DECO_37);
        blockWithItem(ModBlocks.DECO_38);
        blockWithItem(ModBlocks.DECO_39);
        blockWithItem(ModBlocks.DECO_40);
        blockWithItem(ModBlocks.DECO_41);
        blockWithItem(ModBlocks.DECO_42);
        blockWithItem(ModBlocks.DECO_43);
        blockWithItem(ModBlocks.DECO_44);
        blockWithItem(ModBlocks.DECO_45);
        blockWithItem(ModBlocks.DECO_46);
        blockWithItem(ModBlocks.DECO_47);
        blockWithItem(ModBlocks.DECO_48);
        blockWithItem(ModBlocks.DECO_49);
        blockWithItem(ModBlocks.DECO_50);
        blockWithItem(ModBlocks.DECO_51);
        blockWithItem(ModBlocks.DECO_52);
        blockWithItem(ModBlocks.DECO_53);
        blockWithItem(ModBlocks.DECO_54);
        blockWithItem(ModBlocks.DECO_55);
        blockWithItem(ModBlocks.DECO_56);
        blockWithItem(ModBlocks.DECO_57);
        blockWithItem(ModBlocks.DECO_58);

        blockWithItem(ModBlocks.ENDIUM_ORE);

        customLamp();
        makeCrop(((CropBlock) ModBlocks.TOMATO_CROP.get()), "tomato_crop_stage", "tomato_crop_stage");


        logBlock(((RotatedPillarBlock) ModBlocks.PALM_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PALM_WOOD.get()), blockTexture(ModBlocks.PALM_LOG.get()), blockTexture(ModBlocks.PALM_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALM_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALM_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PALM_LOG.get()), blockTexture(ModBlocks.STRIPPED_PALM_LOG.get()));

        blockItem(ModBlocks.PALM_LOG);
        blockItem(ModBlocks.PALM_WOOD);
        blockItem(ModBlocks.STRIPPED_PALM_LOG);
        blockItem(ModBlocks.STRIPPED_PALM_WOOD);



        leavesBlock(ModBlocks.PALM_LEAVES);
        saplingBlock(ModBlocks.PALM_SAPLING);
        blockWithItem(ModBlocks.CRACKED_ENDSTONE);
        blockWithItem(ModBlocks.ENDIUM_BLOCK);
        blockWithItem(ModBlocks.BURNT_NETHER_BRICKS);
        blockWithItem(ModBlocks.CHISELED_ENDSTONE_BRICKS);
        blockWithItem(ModBlocks.INFUSED_ENDSTONE_BRICKS);

    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
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