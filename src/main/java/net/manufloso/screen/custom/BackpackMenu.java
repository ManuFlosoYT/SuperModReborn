package net.manufloso.screen.custom;

import net.manufloso.item.custom.BackpackItem;
import net.manufloso.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class BackpackMenu extends AbstractContainerMenu {
    public static final int BACKPACK_ROWS = 8;
    public static final int BACKPACK_COLS = 9;
    public static final int BACKPACK_SIZE = BACKPACK_ROWS * BACKPACK_COLS;

    private final ItemStack backpackStack;
    private final ItemStackHandler backpackInventory;
    private final Level level;

    public BackpackMenu(int containerId, Inventory playerInventory, ItemStack backpackItemStack) {
        super(ModMenuTypes.BACKPACK_MENU.get(), containerId);
        this.level = playerInventory.player.level();
        this.backpackStack = backpackItemStack;

        this.backpackInventory = BackpackItem.getInventory(this.backpackStack, this.level);

        // Backpack slots
        int backpackSlotX = 7;
        int backpackSlotY = 6;
        for (int row = 0; row < BACKPACK_ROWS; ++row) {
            for (int col = 0; col < BACKPACK_COLS; ++col) {
                this.addSlot(new SlotItemHandler(this.backpackInventory, col + row * BACKPACK_COLS,
                        backpackSlotX + col * 18, backpackSlotY + row * 18));
            }
        }

        // Player Inventory & Hotbar
        int playerInvYOffset = 6;
        int playerHotbarYOffset = 4;
        int playerInvY = backpackSlotY + BACKPACK_ROWS * 18 + playerInvYOffset;
        int playerHotbarY = playerInvY + 3 * 18 + playerHotbarYOffset;

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
        BackpackItem.saveInventory(this.backpackStack, this.backpackInventory, this.level);
    }
}