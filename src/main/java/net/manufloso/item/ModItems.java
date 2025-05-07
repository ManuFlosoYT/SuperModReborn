package net.manufloso.item;

import net.manufloso.item.custom.FuelItem;
import net.manufloso.item.custom.HammerItem;
import net.manufloso.item.custom.LauncherItem;
import net.manufloso.item.custom.TeleportLinkItem;
import net.manufloso.supermodreborn;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.*;
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
            )
    );

    public static final DeferredItem<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHEESE
                    )
            )
    );

    public static final DeferredItem<Item> TELEPORT_LINK = ITEMS.register("teleport_link",
            () -> new TeleportLinkItem(new Item.Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
            )
    );

    public static final DeferredItem<Item> ENDIUM_INGOT = ITEMS.register("endium_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> ENDIUM_SWORD = ITEMS.register("endium_sword",
            () -> new SwordItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDIUM, 139, 0f))));
    public static final DeferredItem<PickaxeItem> ENDIUM_PICKAXE = ITEMS.register("endium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDIUM, 4F, -2.8f))));
    public static final DeferredItem<ShovelItem> ENDIUM_SHOVEL = ITEMS.register("endium_shovel",
            () -> new ShovelItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ENDIUM, 4F, -3.0f))));
    public static final DeferredItem<AxeItem> ENDIUM_AXE = ITEMS.register("endium_axe",
            () -> new AxeItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ENDIUM, 179F, -3.2f))));
    public static final DeferredItem<HoeItem> ENDIUM_HOE = ITEMS.register("endium_hoe",
            () -> new HoeItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ENDIUM, 4F, -3.0f))));

    public static final DeferredItem<HammerItem> ENDIUM_HAMMER = ITEMS.register("endium_hammer",
            () -> new HammerItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDIUM, 4F, -3.5f))));

    //public static final DeferredItem<Item> FUEL_ITEM = ITEMS.register("fuel_item",
    //        () -> new FuelItem(new Item.Properties(), 800));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
