package net.manufloso.item;

import net.manufloso.block.ModBlocks;
import net.manufloso.supermodreborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, supermodreborn.MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_EQUIPMENT = CREATIVE_MODE_TAB.register("creative_tab_equipment",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ENDIUM_HAMMER.get()))
                    .title(Component.translatable("creative_tab.supermodreborn.equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LAUNCHER);
                        output.accept(ModItems.TELEPORT_LINK);
                        output.accept(ModItems.ENDIUM_SWORD);
                        output.accept(ModItems.ENDIUM_PICKAXE);
                        output.accept(ModItems.ENDIUM_AXE);
                        output.accept(ModItems.ENDIUM_SHOVEL);
                        output.accept(ModItems.ENDIUM_HOE);
                        output.accept(ModItems.ENDIUM_HAMMER);
                        output.accept(ModItems.ENDIUM_HELMET);
                        output.accept(ModItems.ENDIUM_CHESTPLATE);
                        output.accept(ModItems.ENDIUM_LEGGINGS);
                        output.accept(ModItems.ENDIUM_BOOTS);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_FOOD = CREATIVE_MODE_TAB.register("creative_tab_food",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHEESE.get()))
                    .title(Component.translatable("creative_tab.supermodreborn.food"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHEESE);
                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.TOMATO_SEEDS);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_RESOURCES = CREATIVE_MODE_TAB.register("creative_tab_resources",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LITHIUM_INGOT.get()))
                    .title(Component.translatable("creative_tab.supermodreborn.resources"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LITHIUM_INGOT);
                        output.accept(ModItems.RAW_LITHIUM);
                        output.accept(ModBlocks.LITHIUM_BLOCK);
                        output.accept(ModBlocks.LITHIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_LITHIUM_ORE);
                        output.accept(ModBlocks.ENDIUM_ORE);
                        output.accept(ModItems.ENDIUM_SCRAP);
                        output.accept(ModItems.ENDIUM_INGOT);
                        output.accept(ModBlocks.ENDIUM_BLOCK);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_DECORATION = CREATIVE_MODE_TAB.register("creative_tab_decoration",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.decoration"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_resources"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.HOLLOW_OAK_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_OAK_LOG);
                        output.accept(ModBlocks.HOLLOW_BIRCH_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_BIRCH_LOG);
                        output.accept(ModBlocks.HOLLOW_SPRUCE_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_SPRUCE_LOG);
                        output.accept(ModBlocks.HOLLOW_ACACIA_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_ACACIA_LOG);
                        output.accept(ModBlocks.HOLLOW_JUNGLE_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_JUNGLE_LOG);
                        output.accept(ModBlocks.HOLLOW_DARK_OAK_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_DARK_OAK_LOG);
                        output.accept(ModBlocks.HOLLOW_MANGROVE_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_MANGROVE_LOG);
                        output.accept(ModBlocks.HOLLOW_CHERRY_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_CHERRY_LOG);
                        output.accept(ModBlocks.HOLLOW_BAMBOO_BLOCK);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_BAMBOO_BLOCK);
                        output.accept(ModBlocks.HOLLOW_CRIMSON_STEM);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_CRIMSON_STEM);
                        output.accept(ModBlocks.HOLLOW_WARPED_STEM);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_WARPED_STEM);
                        output.accept(ModBlocks.HOLLOW_PALM_LOG);
                        output.accept(ModBlocks.HOLLOW_STRIPPED_PALM_LOG);
                        output.accept(ModBlocks.PALM_LOG);
                        output.accept(ModBlocks.STRIPPED_PALM_LOG);
                        output.accept(ModBlocks.PALM_WOOD);
                        output.accept(ModBlocks.STRIPPED_PALM_WOOD);
                        output.accept(ModBlocks.PALM_LEAVES);
                        output.accept(ModBlocks.PALM_SAPLING);
                        output.accept(ModBlocks.PALM_PLANKS);
                        output.accept(ModBlocks.PALM_DOOR);
                        output.accept(ModBlocks.PALM_TRAPDOOR);
                        output.accept(ModBlocks.PALM_FENCE);
                        output.accept(ModBlocks.PALM_FENCE_GATE);
                        output.accept(ModBlocks.PALM_WALL);
                        output.accept(ModBlocks.PALM_BUTTON);
                        output.accept(ModBlocks.PALM_PRESSURE_PLATE);
                        output.accept(ModBlocks.PALM_SLAB);
                        output.accept(ModBlocks.PALM_STAIRS);
                        output.accept(ModBlocks.PEDESTAL.get());
                        output.accept(ModBlocks.END_LAMP);
                        output.accept(ModBlocks.DECO_1);
                        output.accept(ModBlocks.DECO_2);
                        output.accept(ModBlocks.DECO_3);
                        output.accept(ModBlocks.DECO_4);
                        output.accept(ModBlocks.DECO_5);
                        output.accept(ModBlocks.DECO_6);
                        output.accept(ModBlocks.DECO_7);
                        output.accept(ModBlocks.DECO_8);
                        output.accept(ModBlocks.DECO_9);
                        output.accept(ModBlocks.DECO_10);
                        output.accept(ModBlocks.DECO_11);
                        output.accept(ModBlocks.DECO_12);
                        output.accept(ModBlocks.DECO_13);
                        output.accept(ModBlocks.DECO_14);
                        output.accept(ModBlocks.DECO_15);
                        output.accept(ModBlocks.DECO_16);
                        output.accept(ModBlocks.DECO_17);
                        output.accept(ModBlocks.DECO_18);
                        output.accept(ModBlocks.DECO_19);
                        output.accept(ModBlocks.DECO_20);
                        output.accept(ModBlocks.DECO_21);
                        output.accept(ModBlocks.DECO_22);
                        output.accept(ModBlocks.DECO_23);
                        output.accept(ModBlocks.DECO_24);
                        output.accept(ModBlocks.DECO_25);
                        output.accept(ModBlocks.DECO_26);
                        output.accept(ModBlocks.DECO_27);
                        output.accept(ModBlocks.DECO_28);
                        output.accept(ModBlocks.DECO_29);
                        output.accept(ModBlocks.DECO_30);
                        output.accept(ModBlocks.DECO_31);
                        output.accept(ModBlocks.DECO_32);
                        output.accept(ModBlocks.DECO_33);
                        output.accept(ModBlocks.DECO_34);
                        output.accept(ModBlocks.DECO_35);
                        output.accept(ModBlocks.DECO_36);
                        output.accept(ModBlocks.DECO_37);
                        output.accept(ModBlocks.DECO_38);
                        output.accept(ModBlocks.DECO_39);
                        output.accept(ModBlocks.DECO_40);
                        output.accept(ModBlocks.DECO_41);
                        output.accept(ModBlocks.DECO_42);
                        output.accept(ModBlocks.DECO_43);
                        output.accept(ModBlocks.DECO_44);
                        output.accept(ModBlocks.DECO_45);
                        output.accept(ModBlocks.DECO_46);
                        output.accept(ModBlocks.DECO_47);
                        output.accept(ModBlocks.DECO_48);
                        output.accept(ModBlocks.DECO_49);
                        output.accept(ModBlocks.DECO_50);
                        output.accept(ModBlocks.DECO_51);
                        output.accept(ModBlocks.DECO_52);
                        output.accept(ModBlocks.DECO_53);
                        output.accept(ModBlocks.DECO_54);
                        output.accept(ModBlocks.DECO_55);
                        output.accept(ModBlocks.DECO_56);
                        output.accept(ModBlocks.DECO_57);
                        output.accept(ModBlocks.DECO_58);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_UTILITIES = CREATIVE_MODE_TAB.register("creative_tab_utilities",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.utilities"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_decoration"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CHUNK_LOADER);
                    })
                    .build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
