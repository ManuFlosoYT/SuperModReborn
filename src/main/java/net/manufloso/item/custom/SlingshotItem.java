package net.manufloso.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SlingshotItem extends Item {

    private static final int CHARGE_DURATION_TICKS = 20;
    private static final double LAUNCH_SPEED = 2.5D;
    private static final int COOLDOWN_TICKS = 60;

    public SlingshotItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CROSSBOW_QUICK_CHARGE_1, SoundSource.PLAYERS, 0.5F, 1.0F);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entityLiving, int ticksRemaining) {
        if (!(entityLiving instanceof Player player)) {
            return;
        }

        int chargeTime = this.getUseDuration(stack, player) - ticksRemaining;

        if (chargeTime >= CHARGE_DURATION_TICKS) {
            if (!level.isClientSide) {
                Vec3 lookVec = player.getViewVector(1.0F); // Dirección de la mirada
                Vec3 motion = lookVec.scale(LAUNCH_SPEED);

                // Aplicar un ligero impulso hacia arriba para un mejor arco de lanzamiento
                player.setDeltaMovement(motion.x, motion.y + 0.2D + Math.abs(motion.y * 0.3D) , motion.z);
                player.hurtMarked = true; // Notificar al cliente sobre el cambio de movimiento
                player.fallDistance = 0f; // Resetear daño por caída

                // Aplicar cooldown
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);

                // Sonido de lanzamiento
                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            }
        }
        else if (chargeTime > 5 && !level.isClientSide) { // Evitar sonido si apenas se hizo clic
             level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 0.5F, 1.5F);
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 72000; // Tiempo máximo de uso (como el arco), la lógica de carga real está en releaseUsing
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW; // Animación de tensar un arco mientras se carga
    }
}