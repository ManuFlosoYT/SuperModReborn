package net.manufloso.network;

import net.manufloso.block.entity.TrashBinBlockEntity;
import net.manufloso.supermodreborn;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record EmptyTrashPayload(BlockPos blockPos) implements CustomPacketPayload {

    public static final Type<EmptyTrashPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "empty_trash"));

    public static final StreamCodec<FriendlyByteBuf, EmptyTrashPayload> STREAM_CODEC = StreamCodec.of(
            (buf, payload) -> bufferWrite(buf, payload),
            EmptyTrashPayload::bufferRead
    );

    public static void bufferWrite(FriendlyByteBuf buf, EmptyTrashPayload payload) {
        buf.writeBlockPos(payload.blockPos());
    }

    public static EmptyTrashPayload bufferRead(FriendlyByteBuf buf) {
        return new EmptyTrashPayload(buf.readBlockPos());
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final EmptyTrashPayload message, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().level() instanceof Level level) {
                BlockEntity entity = level.getBlockEntity(message.blockPos());
                if (entity instanceof TrashBinBlockEntity trashBin) {
                    trashBin.emptyTrash();
                }
            }
        });
    }
}

