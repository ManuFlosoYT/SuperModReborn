package net.manufloso.screen.custom;

import net.manufloso.item.custom.LargeBackpackItem;
import net.manufloso.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class LargeBackpackMenu extends AbstractContainerMenu {
    public static final int BACKPACK_ROWS = 8;
    public static final int BACKPACK_COLS = 23;
    public static final int BACKPACK_SLOTS = BACKPACK_ROWS * BACKPACK_COLS;
    public static final int EXTRA_ROWS = 4;
    public static final int EXTRA_COLS = 12;
    public static final int EXTRA_SLOTS = EXTRA_ROWS * EXTRA_COLS;
    public static final int BACKPACK_SIZE = BACKPACK_SLOTS + EXTRA_SLOTS;

    private final ItemStack backpackStack;
    private final ItemStackHandler backpackInventory;
    private final Level level;

    public LargeBackpackMenu(int containerId, Inventory playerInventory, ItemStack backpackItemStack) {
        super(ModMenuTypes.LARGE_BACKPACK_MENU.get(), containerId);
        this.level = playerInventory.player.level();
        this.backpackStack = backpackItemStack;

        this.backpackInventory = LargeBackpackItem.getInventory(this.backpackStack, this.level);

        // Backpack slots
        final int backpackSlotX = 49;
        final int backpackSlotY = 6;
        for (int row = 0; row < BACKPACK_ROWS; ++row) {
            for (int col = 0; col < BACKPACK_COLS; ++col) {
                this.addSlot(new SlotItemHandler(this.backpackInventory, col + row * BACKPACK_COLS,
                        backpackSlotX + col * 18, backpackSlotY + row * 18));
            }
        }

        int contador = BACKPACK_SLOTS-1;
        for (int row = BACKPACK_ROWS; row < BACKPACK_ROWS + EXTRA_ROWS; row++) {
            for (int col = 0; col < BACKPACK_COLS; col++) {
                if(col >= 6 && col < 17) continue; // Saltar las columnas que no se usan
                contador++;
                this.addSlot(new SlotItemHandler(this.backpackInventory, contador,
                        backpackSlotX + col * 18, backpackSlotY + row * 18));
            }
        }

        // Player Inventory & Hotbar
        final int playerInvYOffset = 6;
        final int playerHotbarYOffset = 4;
        final int playerInvY = backpackSlotY + BACKPACK_ROWS * 18 + playerInvYOffset;
        final int playerHotbarY = playerInvY + 3 * 18 + playerHotbarYOffset;
        final int playerInventoryOffsetX = 9 * 18;
        final int playerInventoryOffsetXEnd = playerInventoryOffsetX + 14;

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, playerInventoryOffsetXEnd + col * 18, playerInvY + row * 18));
            }
        }

        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, playerInventoryOffsetXEnd + col * 18, playerHotbarY));
        }
    }

    // Constructor para el cliente
    public LargeBackpackMenu(int containerId, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId, playerInventory, playerInventory.player.getMainHandItem());
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
        return player.getInventory().contains(this.backpackStack);
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        LargeBackpackItem.saveInventory(this.backpackStack, this.backpackInventory, this.level);
    }
}