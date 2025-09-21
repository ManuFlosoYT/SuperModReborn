package net.manufloso.screen.custom;

import net.manufloso.supermodreborn;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class LargeBackpackScreen extends AbstractContainerScreen<LargeBackpackMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, "textures/gui/backpack/large_backpack_gui.png");
    public LargeBackpackScreen(LargeBackpackMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        imageWidth = 512;
        imageHeight = 235;
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        // --- CÁLCULO PARA CENTRAR (Esto ya lo tenías bien) ---
        int imageWidth = 425;
        int imageHeight = 235;
        int centeredX = (this.width - imageWidth) / 2;
        int centeredY = (this.height - imageHeight) / 2;

        // --- IMPORTANTE: Dimensiones REALES del archivo PNG ---
        // Aquí debes especificar el tamaño exacto de tu archivo de imagen.
        // Si tu "your_texture.png" mide 425x235, pon esos valores.
        // Si lo has puesto en una imagen más grande (ej. 512x256), pon esas dimensiones.
        int textureWidth = 425;
        int textureHeight = 235;


        // --- EL COMANDO BLIT CORRECTO PARA EVITAR EL TILING ---
        guiGraphics.blit(
                GUI_TEXTURE,     // La textura que quieres dibujar
                centeredX,          // Posición X en la pantalla
                centeredY,          // Posición Y en la pantalla
                0,                  // U: Coordenada X inicial en el ARCHIVO de textura (esquina superior izquierda)
                0,                  // V: Coordenada Y inicial en el ARCHIVO de textura (esquina superior izquierda)
                imageWidth,         // Ancho de la imagen a dibujar en PANTALLA
                imageHeight,        // Alto de la imagen a dibujar en PANTALLA
                textureWidth,       // Ancho TOTAL del archivo de textura PNG
                textureHeight       // Alto TOTAL del archivo de textura PNG
        );
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY) {}
}