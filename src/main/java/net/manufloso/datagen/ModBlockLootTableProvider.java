package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.block.custom.TomatoCropBlock;
import net.manufloso.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LITHIUM_BLOCK.get());
        add(ModBlocks.LITHIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get()));
        add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get()));

        dropSelf(ModBlocks.CHUNK_LOADER.get());


        dropSelf(ModBlocks.PALM_STAIRS.get());
        add(ModBlocks.PALM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_SLAB.get()));

        dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PALM_BUTTON.get());

        dropSelf(ModBlocks.PALM_FENCE.get());
        dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        dropSelf(ModBlocks.PALM_WALL.get());
        dropSelf(ModBlocks.PALM_TRAPDOOR.get());

        add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));

        dropSelf(ModBlocks.END_LAMP.get());


        // DECO BLOCKS

        dropSelf(ModBlocks.DECO_1.get());
        dropSelf(ModBlocks.DECO_2.get());
        dropSelf(ModBlocks.DECO_3.get());
        dropSelf(ModBlocks.DECO_4.get());
        dropSelf(ModBlocks.DECO_5.get());
        dropSelf(ModBlocks.DECO_6.get());
        dropSelf(ModBlocks.DECO_7.get());
        dropSelf(ModBlocks.DECO_8.get());
        dropSelf(ModBlocks.DECO_9.get());
        dropSelf(ModBlocks.DECO_10.get());
        dropSelf(ModBlocks.DECO_11.get());
        dropSelf(ModBlocks.DECO_12.get());
        dropSelf(ModBlocks.DECO_13.get());
        dropSelf(ModBlocks.DECO_14.get());
        dropSelf(ModBlocks.DECO_15.get());
        dropSelf(ModBlocks.DECO_16.get());
        dropSelf(ModBlocks.DECO_17.get());
        dropSelf(ModBlocks.DECO_18.get());
        dropSelf(ModBlocks.DECO_19.get());
        dropSelf(ModBlocks.DECO_20.get());
        dropSelf(ModBlocks.DECO_21.get());
        dropSelf(ModBlocks.DECO_22.get());
        dropSelf(ModBlocks.DECO_23.get());
        dropSelf(ModBlocks.DECO_24.get());
        dropSelf(ModBlocks.DECO_25.get());
        dropSelf(ModBlocks.DECO_26.get());
        dropSelf(ModBlocks.DECO_27.get());
        dropSelf(ModBlocks.DECO_28.get());
        dropSelf(ModBlocks.DECO_29.get());
        dropSelf(ModBlocks.DECO_30.get());
        dropSelf(ModBlocks.DECO_31.get());
        dropSelf(ModBlocks.DECO_32.get());
        dropSelf(ModBlocks.DECO_33.get());
        dropSelf(ModBlocks.DECO_34.get());
        dropSelf(ModBlocks.DECO_35.get());
        dropSelf(ModBlocks.DECO_36.get());
        dropSelf(ModBlocks.DECO_37.get());
        dropSelf(ModBlocks.DECO_38.get());
        dropSelf(ModBlocks.DECO_39.get());
        dropSelf(ModBlocks.DECO_40.get());
        dropSelf(ModBlocks.DECO_41.get());
        dropSelf(ModBlocks.DECO_42.get());
        dropSelf(ModBlocks.DECO_43.get());
        dropSelf(ModBlocks.DECO_44.get());
        dropSelf(ModBlocks.DECO_45.get());
        dropSelf(ModBlocks.DECO_46.get());
        dropSelf(ModBlocks.DECO_47.get());
        dropSelf(ModBlocks.DECO_48.get());
        dropSelf(ModBlocks.DECO_49.get());
        dropSelf(ModBlocks.DECO_50.get());
        dropSelf(ModBlocks.DECO_51.get());
        dropSelf(ModBlocks.DECO_52.get());
        dropSelf(ModBlocks.DECO_53.get());
        dropSelf(ModBlocks.DECO_54.get());
        dropSelf(ModBlocks.DECO_55.get());
        dropSelf(ModBlocks.DECO_56.get());
        dropSelf(ModBlocks.DECO_57.get());
        dropSelf(ModBlocks.DECO_58.get());



        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 2));

        add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilder));

        add(ModBlocks.ENDIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ENDIUM_ORE.get(), ModItems.ENDIUM_SCRAP.get()));



        dropSelf(ModBlocks.PALM_LOG.get());
        dropSelf(ModBlocks.PALM_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(ModBlocks.PALM_PLANKS.get());
        dropSelf(ModBlocks.PALM_SAPLING.get());

        add(ModBlocks.PALM_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        
        dropSelf(ModBlocks.HOLLOW_OAK_LOG.get());
        dropSelf(ModBlocks.HOLLOW_STRIPPED_OAK_LOG.get());
        dropSelf(ModBlocks.ENDIUM_BLOCK.get());

        //add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
        //        block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get(), 1, 5));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(pBlock,
                applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}