package net.manufloso.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LauncherItem extends Item
{
    public LauncherItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();

        // Ensure we have a player and are on the server side
        if (player != null && !level.isClientSide) {
            MobEffectInstance effectInstance = new MobEffectInstance(
                    MobEffects.SLOW_FALLING,    // The effect to apply
                    200,                        // Duration in ticks
                    0,                          // Amplifier (0 for level 1)
                    true,                       // Ambient? (Less noticeable particles)
                    false,                      // Show particles?
                    true                        // Show icon?
            );

            // Apply the effect to the player
            player.addEffect(effectInstance);

            player.setDeltaMovement(new Vec3(
                    player.getDeltaMovement().x(),
                    player.getDeltaMovement().y() + 8.0, // Use 8.0 for double precision
                    player.getDeltaMovement().z()
            ));

            // Let the entity know its movement changed drastically server-side
            player.hurtMarked = true; // Important for syncing movement changes!

            player.getCooldowns().addCooldown(itemstack.getItem(), 100);

            // Return SUCCESS to indicate the action was handled successfully on the server
            return InteractionResult.SUCCESS;
        }

        // Fall back to default behavior if the conditions aren't met
        return super.useOn(context);
    }
}
