package net.manufloso.item;

import net.manufloso.item.custom.FuelItem;
import net.manufloso.item.custom.LauncherItem;
import net.manufloso.supermodreborn;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(supermodreborn.MODID);

    public static final DeferredItem<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_LITHIUM = ITEMS.register("raw_lithium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LAUNCHER = ITEMS.register("launcher",
            () -> new LauncherItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final DeferredItem<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHEESE)));

    //public static final DeferredItem<Item> FUEL_ITEM = ITEMS.register("fuel_item",
    //        () -> new FuelItem(new Item.Properties(), 800));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
