package net.manufloso.item.custom;

import net.manufloso.component.ModDataComponents;
import net.manufloso.sound.ModSounds;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeleportLinkItem extends Item
{
    public TeleportLinkItem(Properties properties)
    {
        super(properties);
    }

    public @NotNull InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();

        // Ensure we have a player and are on the server side
        if (player != null && !level.isClientSide)
        {
            player.getCooldowns().addCooldown(itemstack.getItem(), 20);

            if(player.isCrouching()){
                itemstack.set(ModDataComponents.COORDINATES, null);
                level.playSound(null, pos, ModSounds.BEEP.get(), SoundSource.PLAYERS, 1f, 1.8f);
            }
            else {
                itemstack.set(ModDataComponents.COORDINATES, pos);
                level.playSound(null, pos, ModSounds.BEEP.get(), SoundSource.PLAYERS, 1f, 2f);
            }

            // Return SUCCESS to indicate the action was handled successfully on the server
            return InteractionResult.SUCCESS;
        }

        // Fall back to default behavior if the conditions aren't met
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.teleport_link"));

        if(stack.get(ModDataComponents.COORDINATES) != null){
            tooltipComponents.add(Component.literal("Coordinates saved: " + stack.get(ModDataComponents.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
