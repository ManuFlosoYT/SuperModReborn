package net.manufloso.datagen;

import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}