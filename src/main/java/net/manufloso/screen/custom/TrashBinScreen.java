package net.manufloso.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.manufloso.network.EmptyTrashPayload;
import net.manufloso.supermodreborn;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

public class TrashBinScreen extends AbstractContainerScreen<TrashBinMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "textures/gui/trash_bin_gui.png");

    public TrashBinScreen(TrashBinMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000; // Hide player inventory text usually
        this.titleLabelY = 10000; // Hide title text as requested

        this.addRenderableWidget(Button.builder(Component.literal("Vaciar"), button -> {
            PacketDistributor.sendToServer(new EmptyTrashPayload(this.menu.blockEntity.getBlockPos()));
        }).bounds(leftPos + 60, topPos + 63, 56, 14).build());
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
