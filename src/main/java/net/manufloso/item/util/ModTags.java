package net.manufloso.item.util;

import net.manufloso.supermodreborn;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> NEEDS_ENDIUM_TOOL = createTag("needs_endium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENDIUM_TOOL = createTag("incorrect_for_endium_tool");


        private static TagKey<Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> LITHIUM = createTag("lithium");

        private static TagKey<Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name));
        }
    }
}
