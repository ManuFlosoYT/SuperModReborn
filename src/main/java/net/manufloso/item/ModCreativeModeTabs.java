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
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_FOOD = CREATIVE_MODE_TAB.register("creative_tab_food",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHEESE.get()))
                    .title(Component.translatable("creative_tab.supermodreborn.food"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHEESE);
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
                        output.accept(ModItems.ENDIUM_INGOT);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_DECORATION = CREATIVE_MODE_TAB.register("creative_tab_decoration",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.decoration"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_resources"))
                    .displayItems((itemDisplayParameters, output) -> {
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

                        output.accept(ModBlocks.END_LAMP);
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
