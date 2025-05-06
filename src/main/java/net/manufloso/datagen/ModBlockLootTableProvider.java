package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
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
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
        dropSelf(ModBlocks.PALM_PLANKS.get());


        //add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(),
        //        block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get(), 1, 5));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}