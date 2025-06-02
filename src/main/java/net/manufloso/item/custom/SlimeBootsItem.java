package net.manufloso.item.custom;

import net.minecraft.ChatFormatting; // Para el color del tooltip
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SlimeBootsItem extends ArmorItem {

    public SlimeBootsItem(Holder<ArmorMaterial> material, Item.Properties properties) {
        // Se pasa Type.BOOTS directamente en el constructor de ArmorItem
        super(material, ArmorItem.Type.BOOTS, properties);
    }

    // Para hacerlas irrompibles
    @Override
    public boolean isDamageable(@NotNull ItemStack stack) {
        return false; // El ítem no puede recibir daño
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return true; // Permite encantarlas (ej. con Unbreaking, aunque no lo necesiten)
    }

    @Override
    public int getEnchantmentValue() {
        // Devuelve la encantabilidad del material si quieres que se base en eso,
        // o un valor fijo. El material ya lo define.
        return this.material.value().enchantmentValue();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.slime_boots.description").withStyle(ChatFormatting.GREEN));
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.slime_boots.effect").withStyle(ChatFormatting.BLUE));
        if (tooltipFlag.isAdvanced()) {
            tooltipComponents.add(Component.literal("Irrompible").withStyle(ChatFormatting.DARK_GRAY));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}