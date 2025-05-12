package net.manufloso.item;

import net.manufloso.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ENDIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ENDIUM_TOOL,
            69420, 100f, 20f, 50, () -> Ingredient.of(ModItems.ENDIUM_INGOT));

}
