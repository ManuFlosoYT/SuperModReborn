package net.manufloso.component;

import com.mojang.serialization.Codec;
import net.manufloso.supermodreborn;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.entity.player.Player; // Import Player class
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, supermodreborn.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CompoundTag>> BACKPACK_INVENTORY_NBT =
            register("backpack_inventory_nbt", builder -> builder
                    .persistent(CompoundTag.CODEC)
                    .networkSynchronized(ByteBufCodecs.TRUSTED_COMPOUND_TAG));

    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }



    // Create the DeferredRegister for attachment types
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, supermodreborn.MODID);

    // Serialization via codec
    public static final Supplier<AttachmentType<Integer>> MONEY = ATTACHMENT_TYPES.register(
            "money", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public static int getMoney(Player player) {
        return player.getData(MONEY.get());
    }

    public static void setMoney(Player player, int amount) {
        player.setData(MONEY.get(), Math.max(0, amount)); // Ensure money doesn't go below 0
    }

    public static void addMoney(Player player, int amount) {
        int currentMoney = getMoney(player);
        setMoney(player, currentMoney + amount);
    }

    public static int removeMoney(Player player, int amount) {
        int currentMoney = getMoney(player);
        if (currentMoney >= amount) {
            setMoney(player, currentMoney - amount);
            return 1;
        }
        return 0;
    }

    public static int checkMoney(Player player, int amount) {
        int currentMoney = getMoney(player);
        if (currentMoney >= amount) {return 1;}
        return 0;
    }



    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
        ATTACHMENT_TYPES.register(eventBus);
    }
}