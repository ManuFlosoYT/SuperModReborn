package net.manufloso.item.custom;

import net.manufloso.component.ModDataComponents;
import net.manufloso.screen.custom.BackpackMenu;
import net.minecraft.core.HolderLookup; // Importa HolderLookup
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class BackpackItem extends Item {
    public BackpackItem(Properties properties) {
        super(properties);
    }

    // Helper para obtener el inventario del stack
    // El Level es necesario para obtener el HolderLookup.Provider (RegistryAccess)
    public static ItemStackHandler getInventory(ItemStack backpackStack, Level level) {
        ItemStackHandler handler = new ItemStackHandler(BackpackMenu.BACKPACK_SIZE);
        CompoundTag nbt = backpackStack.get(ModDataComponents.BACKPACK_INVENTORY_NBT);
        if (nbt != null && level != null) { // Asegurarse que level no sea null
            handler.deserializeNBT(level.registryAccess(), nbt);
        } else if (nbt != null) {
            // Fallback si no hay level, aunque la deserialización podría ser incompleta para items complejos
            // Para inventarios simples de ItemStacks vanilla, esto podría funcionar sin registryAccess en algunos casos,
            // pero es mejor proveerlo siempre.
            // Considera registrar un error o manejar este caso si level es indispensable.
            // Para NeoForge reciente, el registryAccess es cada vez más importante.
            // Una opción es no deserializar si no hay registryAccess, dejando el handler vacío.
            handler.deserializeNBT(null, nbt); // OJO: Pasar null aquí puede no ser ideal.
        }
        return handler;
    }

    // Helper para guardar el inventario en el stack
    // El Level es necesario para obtener el HolderLookup.Provider (RegistryAccess)
    public static void saveInventory(ItemStack backpackStack, ItemStackHandler handler, Level level) {
        if (level != null) {
            backpackStack.set(ModDataComponents.BACKPACK_INVENTORY_NBT, handler.serializeNBT(level.registryAccess()));
        } else {
            // Si no hay level, se podría intentar serializar sin registryAccess,
            // o decidir no guardar para evitar corrupción si el acceso es vital.
            // Para la mayoría de los ItemStacks, el registryAccess no es estrictamente necesario para serializeNBT.
            backpackStack.set(ModDataComponents.BACKPACK_INVENTORY_NBT, handler.serializeNBT(null)); // OJO: Pasar null aquí.
        }
    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            if (stack.get(ModDataComponents.BACKPACK_INVENTORY_NBT) == null) {
                ItemStackHandler newHandler = new ItemStackHandler(BackpackMenu.BACKPACK_SIZE);
                saveInventory(stack, newHandler, level); // Pasar 'level'
            }

            serverPlayer.openMenu(new SimpleMenuProvider(
                    (id, playerInventory, p) -> new BackpackMenu(id, playerInventory, stack), // BackpackMenu necesitará el level también
                    Component.translatable("container.supermodreborn.backpack")
            ));
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}