package net.manufloso.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BedrockBreakerItem extends Item {

    public BedrockBreakerItem(Properties properties) {
        // stacksTo(1) para que cada ítem sea de un solo uso visualmente en el inventario,
        // aunque la lógica de shrink(1) ya lo maneja.
        super(properties.stacksTo(1));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemInHand = context.getItemInHand();

        if (player == null) {
            return InteractionResult.PASS;
        }

        // Solo actuar si se hace clic derecho sobre Bedrock
        if (level.getBlockState(clickedPos).is(Blocks.BEDROCK)) {
            if (!level.isClientSide) {
                // Destruir el bloque de Bedrock
                level.setBlock(clickedPos, Blocks.AIR.defaultBlockState(), level.isClientSide ? 11 : 3); // Flag 3 = UPDATE_ALL | SEND_TO_CLIENTS

                // Aplicar penalización de comida y saturación
                FoodData foodData = player.getFoodData();
                foodData.setFoodLevel(0);
                foodData.setSaturation(0.0F);

                // Consumir el ítem "Bedrock Breaker"
                if (!player.getAbilities().instabuild) { // No consumir en creativo
                    itemInHand.shrink(1);
                }

                // Efectos visuales/sonoros (opcional pero recomendado)
                level.playSound(null, clickedPos, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                ((ServerLevel) level).sendParticles(ParticleTypes.EXPLOSION_EMITTER, clickedPos.getX() + 0.5, clickedPos.getY() + 0.5, clickedPos.getZ() + 0.5, 1, 0, 0, 0, 0);

                player.swing(context.getHand()); // Simular el swing del brazo

                return InteractionResult.SUCCESS; // Éxito en el servidor
            }
            return InteractionResult.sidedSuccess(level.isClientSide); // Éxito en el cliente para la animación
        }

        return InteractionResult.PASS; // Si no es Bedrock, pasar para otras interacciones
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.bedrock_breaker.description_line1"));
        tooltipComponents.add(Component.translatable("tooltip.supermodreborn.bedrock_breaker.description_line2"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    // Opcional: Si quieres que el ítem tenga un efecto de "encantado"
    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return true; // Hace que el ítem brille como si estuviera encantado
    }
}