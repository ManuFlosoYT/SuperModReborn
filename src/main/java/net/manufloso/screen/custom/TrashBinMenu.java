package net.manufloso.screen.custom;
import net.manufloso.block.ModBlocks;
import net.manufloso.block.entity.TrashBinBlockEntity;
import net.manufloso.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
public class TrashBinMenu extends AbstractContainerMenu {
    public final TrashBinBlockEntity blockEntity;
    private final ContainerLevelAccess levelAccess;
    public TrashBinMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }
    public TrashBinMenu(int id, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.TRASH_BIN_MENU.get(), id);
        checkContainerSize(inv, 27);
        this.blockEntity = (TrashBinBlockEntity) entity;
        this.levelAccess = ContainerLevelAccess.create(entity.getLevel(), entity.getBlockPos());
        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        int index = 0;
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new SlotItemHandler(this.blockEntity.itemHandler, index++, 7 + x * 18, 8 + y * 18));
            }
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();
        if (index < 36) { // Player inventory
            if (!moveItemStackTo(sourceStack, 36, 36 + 27, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index >= 36 && index < 36 + 27) { // Trash Bin inventory
            if (!moveItemStackTo(sourceStack, 0, 36, false)) {
                return ItemStack.EMPTY;
            }
        }
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }
    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.levelAccess, player, ModBlocks.TRASH_BIN.get());
    }
    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }
}
