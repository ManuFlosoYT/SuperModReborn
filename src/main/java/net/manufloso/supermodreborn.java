package net.manufloso;

import com.mojang.logging.LogUtils;
import net.manufloso.block.ModBlocks;
import net.manufloso.component.ModDataComponents;
import net.manufloso.enchantment.ModEnchantmentEffects;
import net.manufloso.item.ModCreativeModeTabs;
import net.manufloso.item.ModItems;
import net.manufloso.sound.ModSounds;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(supermodreborn.MODID)
public class supermodreborn
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "supermodreborn";

    public supermodreborn(IEventBus modEventBus, ModContainer modContainer)
    {
        //NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
