package net.manufloso;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
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
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.DIRT);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_FOOD = CREATIVE_MODE_TAB.register("creative_tab_food",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.food"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.DIRT);
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
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_DECORATION = CREATIVE_MODE_TAB.register("creative_tab_decoration",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.decoration"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_resources"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.DIRT);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> CREATIVE_TAB_UTILITIES = CREATIVE_MODE_TAB.register("creative_tab_utilities",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.translatable("creative_tab.supermodreborn.utilities"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "creative_tab_decoration"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.DIRT);
                    })
                    .build());



    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
