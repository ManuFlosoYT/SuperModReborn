package net.manufloso.item;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.custom.*;
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
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDIUM, 20F, -3.5f))));
    public static final DeferredItem<HammerItem> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new HammerItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 8F, -3.5f))));
    public static final DeferredItem<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 6F, -3.5f))));
    public static final DeferredItem<HammerItem> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.IRON, 4F, -3.5f))));

    public static final DeferredItem<LargeShovelItem> LARGE_ENDIUM_SHOVEL = ITEMS.register("large_endium_shovel",
            () -> new LargeShovelItem(ModToolTiers.ENDIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDIUM, 20F, -3.5f))));
    public static final DeferredItem<LargeShovelItem> LARGE_NETHERITE_SHOVEL = ITEMS.register("large_netherite_shovel",
            () -> new LargeShovelItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 8F, -3.5f))));
    public static final DeferredItem<LargeShovelItem> LARGE_DIAMOND_SHOVEL = ITEMS.register("large_diamond_shovel",
            () -> new LargeShovelItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 6F, -3.5f))));
    public static final DeferredItem<LargeShovelItem> LARGE_IRON_SHOVEL = ITEMS.register("large_iron_shovel",
            () -> new LargeShovelItem(Tiers.IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.IRON, 4F, -3.5f))));


    public static final DeferredItem<ArmorItem> ENDIUM_HELMET = ITEMS.register("endium_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ENDIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(200))));
    public static final DeferredItem<ArmorItem> ENDIUM_CHESTPLATE = ITEMS.register("endium_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ENDIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(200))));
    public static final DeferredItem<ArmorItem> ENDIUM_LEGGINGS = ITEMS.register("endium_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ENDIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(200))));
    public static final DeferredItem<ArmorItem> ENDIUM_BOOTS = ITEMS.register("endium_boots",
            () -> new ModArmorItem(ModArmorMaterials.ENDIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(200))));

    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.TOMATO
                    )
            )
    );
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> ENDIUM_SCRAP = ITEMS.register("endium_scrap",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BACKPACK = ITEMS.register("backpack",
            () -> new BackpackItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).fireResistant()));

    public static final DeferredItem<Item> LARGE_BACKPACK = ITEMS.register("large_backpack",
            () -> new LargeBackpackItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).fireResistant()));

    public static final DeferredItem<Item> SLINGSHOT = ITEMS.register("slingshot",
            () -> new SlingshotItem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final DeferredItem<Item> TORCHER = ITEMS.register("torcher",
            () -> new TorcherItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> BEDROCK_BREAKER = ITEMS.register("bedrock_breaker",
            () -> new BedrockBreakerItem(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredItem<ArmorItem> SLIME_BOOTS = ITEMS.register("slime_boots",
            () -> new SlimeBootsItem(ModArmorMaterials.SLIME_BOOT_MATERIAL,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PLATINUM_MINECOIN = ITEMS.register("platinum_minecoin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GOLD_MINECOIN = ITEMS.register("gold_minecoin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_MINECOIN = ITEMS.register("silver_minecoin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRONZE_MINECOIN = ITEMS.register("bronze_minecoin",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
