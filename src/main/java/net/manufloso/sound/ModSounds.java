package net.manufloso.sound;

import net.manufloso.supermodreborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, supermodreborn.MODID);

    public static final Supplier<SoundEvent> BEEP = registerSoundEvent("beep");
    public static final Supplier<SoundEvent> TRANSACTION = registerSoundEvent("transaction");
    public static final Supplier<SoundEvent> COIN = registerSoundEvent("coin");
    public static final Supplier<SoundEvent> COINS = registerSoundEvent("coins");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}