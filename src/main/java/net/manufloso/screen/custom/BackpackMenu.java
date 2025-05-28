package net.manufloso.screen.custom;

import net.manufloso.item.custom.BackpackItem;
import net.manufloso.screen.ModMenuTypes;
import net.minecraft.core.HolderLookup; // Importar HolderLookup
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class BackpackMenu extends AbstractContainerMenu {
    public static final int BACKPACK_ROWS = 8;
    public static final int BACKPACK_COLS = 9;
    public static final int BACKPACK_SIZE = BACKPACK_ROWS * BACKPACK_COLS;

    private final ItemStack backpackStack;
    private final ItemStackHandler backpackInventory; // Cambiado a ItemStackHandler concreto para facilitar serializeNBT
    private final Level level;

    public BackpackMenu(int containerId, Inventory playerInventory, ItemStack backpackItemStack) {
        super(ModMenuTypes.BACKPACK_MENU.get(), containerId);
        this.level = playerInventory.player.level(); // Nivel obtenido del jugador
        this.backpackStack = backpackItemStack;

        this.backpackInventory = BackpackItem.getInventory(this.backpackStack, this.level); // Pasar this.level

        // Backpack slots
        int backpackSlotX = 8;
        int backpackSlotY = 18;
        for (int row = 0; row < BACKPACK_ROWS; ++row) {
            for (int col = 0; col < BACKPACK_COLS; ++col) {
                this.addSlot(new SlotItemHandler(this.backpackInventory, col + row * BACKPACK_COLS,
                        backpackSlotX + col * 18, backpackSlotY + row * 18));
            }
        }

        // Player Inventory & Hotbar (mismas coordenadas que antes)
        int playerInvY = backpackSlotY + BACKPACK_ROWS * 18 + 17;
        int playerHotbarY = playerInvY + 3 * 18 + 4;

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, playerInvY + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, playerHotbarY));
        }
    }

    // Constructor para el cliente
    public BackpackMenu(int containerId, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        // El ItemStack debe ser obtenido de alguna manera. NeoForge puede manejar esto
        // si el Item en sí mismo implementa alguna interfaz como `IMenuProviderItem`
        // o si se envía el slot del item en el `FriendlyByteBuf`.
        // Para el ejemplo, asumimos que el item está en la mano principal, lo cual es una simplificación.
        // Una implementación más robusta sería necesaria si el item puede no estar en la mano.
        this(containerId, playerInventory, playerInventory.player.getMainHandItem()); // Esta línea es una suposición para que compile.
        // Se debería pasar el stack de mochila correcto.
    }


    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        Slot sourceSlot = this.slots.get(index);
        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        final int playerInventoryStartSlot = BACKPACK_SIZE;
        final int playerHotbarStartSlot = playerInventoryStartSlot + 27;
        final int playerTotalSlotsEnd = playerHotbarStartSlot + 9;

        if (index < BACKPACK_SIZE) {
            if (!this.moveItemStackTo(sourceStack, playerInventoryStartSlot, playerTotalSlotsEnd, true)) {
                return ItemStack.EMPTY;
            }
        } else if (index < playerTotalSlotsEnd) {
            if (!this.moveItemStackTo(sourceStack, 0, BACKPACK_SIZE, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        if (sourceStack.getCount() == copyOfSourceStack.getCount()) {
            return ItemStack.EMPTY;
        }

        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return player.getInventory().contains(this.backpackStack); // O una comprobación más específica si es necesario
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        // Guardar el inventario en el NBT del ItemStack
        BackpackItem.saveInventory(this.backpackStack, this.backpackInventory, this.level); // Pasar this.level
    }

    // Opcional: Si quieres que los cambios se guarden inmediatamente cuando un slot cambia.
    // `SlotItemHandler` debería llamar a `IItemHandler.onContentsChanged` que, si el handler
    // es el `ItemStackHandler` del `PedestalBlockEntity`, llama a `setChanged()`.
    // Para nuestro `ItemStackHandler` en `BackpackMenu`, también podemos hacer que guarde
    // el NBT en el `ItemStack` cada vez que cambie, aunque `removed()` es el lugar más común.
    // Si no, se puede anular `setChanged()` en el menú para forzar el guardado.
    /*
    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        // Potencialmente guardar aquí en cada "tick" del menú, pero puede ser excesivo.
        // Es mejor en `removed` o cuando un slot cambia si es necesario.
    }
    */

    // Si usas `SlotItemHandler`, el `onContentsChanged` del `ItemStackHandler` debería ser suficiente
    // para marcarlo como "sucio". El guardado final en `removed` es clave.
}