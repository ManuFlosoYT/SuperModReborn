package net.manufloso;

import net.manufloso.block.ModBlocks;
import net.manufloso.component.ModDataComponents;
import net.manufloso.enchantment.ModEnchantmentEffects;
import net.manufloso.item.ModCreativeModeTabs;
import net.manufloso.item.ModItems;
import net.manufloso.loot.ModLootModifiers;
import net.manufloso.sound.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;


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
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
