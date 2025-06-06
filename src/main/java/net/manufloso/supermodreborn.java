package net.manufloso;

import net.manufloso.block.ModBlocks;
import net.manufloso.block.entity.ModBlockEntities;
import net.manufloso.block.entity.renderer.PedestalBlockEntityRenderer;
import net.manufloso.component.ModDataComponents;
import net.manufloso.enchantment.ModEnchantmentEffects;
import net.manufloso.item.ModCreativeModeTabs;
import net.manufloso.item.ModItems;
import net.manufloso.loot.ModLootModifiers;
import net.manufloso.screen.ModMenuTypes;
import net.manufloso.screen.custom.BackpackScreen;
import net.manufloso.screen.custom.PedestalScreen;
import net.manufloso.sound.ModSounds;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;


@Mod(supermodreborn.MODID)
public class supermodreborn
{
    public static final String MODID = "supermodreborn";

    public supermodreborn(IEventBus modEventBus, ModContainer modContainer)
    {
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
            event.register(ModMenuTypes.BACKPACK_MENU.get(), BackpackScreen::new);
        }

        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.getBlockColors().register((blockState, tintableBlockAccess, blockPos, tintIndex) -> {
                if (tintableBlockAccess != null && blockPos != null) {
                    return BiomeColors.getAverageFoliageColor(tintableBlockAccess, blockPos);
                }
                return FoliageColor.getDefaultColor();
            }, ModBlocks.PALM_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
            event.getItemColors().register((itemStack, tintIndex) -> {
                BlockState blockState = ((BlockItem) itemStack.getItem()).getBlock().defaultBlockState();
                return event.getBlockColors().getColor(blockState, null, null, tintIndex);
            }, ModBlocks.PALM_LEAVES.get().asItem());
        }
    }
}