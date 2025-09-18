package net.manufloso.screen;

import net.manufloso.screen.custom.BackpackMenu;
import net.manufloso.screen.custom.LargeBackpackMenu;
import net.manufloso.screen.custom.PedestalMenu;
import net.manufloso.supermodreborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, supermodreborn.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<PedestalMenu>> PEDESTAL_MENU =
            registerMenuType("pedestal_menu", PedestalMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<BackpackMenu>> BACKPACK_MENU =
            registerMenuType("backpack_menu", BackpackMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<LargeBackpackMenu>> LARGE_BACKPACK_MENU =
            registerMenuType("large_backpack_menu", LargeBackpackMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}