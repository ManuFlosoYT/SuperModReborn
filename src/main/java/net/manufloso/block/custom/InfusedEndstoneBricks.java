package net.manufloso.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class InfusedEndstoneBricks extends Block {

    public InfusedEndstoneBricks(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        // Aplicar daño solo en el lado del servidor
        if (!level.isClientSide) {
            DamageSource magicDamageSource = level.damageSources().source(DamageTypes.MAGIC);
            entity.hurt(magicDamageSource, 2.0F);
        }
        super.stepOn(level, pos, state, entity);
    }
}
