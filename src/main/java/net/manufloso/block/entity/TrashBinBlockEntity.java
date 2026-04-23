package net.manufloso.block.entity;
import net.manufloso.screen.custom.TrashBinMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
public class TrashBinBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler itemHandler = new ItemStackHandler(27) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    public TrashBinBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRASH_BIN_BE.get(), pos, state);
    }
    public void emptyTrash() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            itemHandler.extractItem(i, itemHandler.getStackInSlot(i).getCount(), false);
        }
        setChanged();
    }
    @Override
    public Component getDisplayName() {
        return Component.literal("Trash Bin"); // o Component.translatable("block.supermodreborn.trash_bin")
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new TrashBinMenu(id, inventory, this);
    }
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        super.saveAdditional(tag, registries);
    }
    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
    }
}
