package net.manufloso.item.custom;

import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> ENDIUM_ARMOR_MATERIAL = register("endium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 100);
                attribute.put(ArmorItem.Type.LEGGINGS, 200);
                attribute.put(ArmorItem.Type.CHESTPLATE, 250);
                attribute.put(ArmorItem.Type.HELMET, 150);
                attribute.put(ArmorItem.Type.BODY, 200);
            }), 100, 10f, 1f, ModItems.ENDIUM_INGOT);

    public static final Holder<ArmorMaterial> SLIME_BOOT_MATERIAL = register("slime",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1); // Protección mínima, o 0 si lo prefieres
                attribute.put(ArmorItem.Type.LEGGINGS, 0);
                attribute.put(ArmorItem.Type.CHESTPLATE, 0);
                attribute.put(ArmorItem.Type.HELMET, 0);
                attribute.put(ArmorItem.Type.BODY, 0); // NeoForge 1.20.4+
            }),
            10, // Encantabilidad baja
            SoundEvents.ARMOR_EQUIP_GENERIC, // Sonido al equipar (puedes cambiarlo)
            0.0F, // Dureza
            0.0F, // Resistencia al knockback
            () -> Ingredient.of(Items.SLIME_BALL) // Ingrediente de reparación (opcional)
    );


//    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
//                                                  int enchantability, float toughness, float knockbackResistance,
//                                                  Supplier<Item> ingredientItem) {
//        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name);
//        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
//        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
//        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
//
//        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
//        for (ArmorItem.Type type : ArmorItem.Type.values()) {
//            typeMap.put(type, typeProtection.get(type));
//        }
//
//        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
//                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
//    }

    // Sobrecarga del método register para mantener compatibilidad con Endium
    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_GENERIC;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
        ArmorMaterial material = new ArmorMaterial(defense, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, material);
    }

    // Método register modificado para incluir sonido de equipar y simplificar durabilidad para este caso
    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense,
                                                  int enchantability, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance,
                                                  Supplier<Ingredient> repairIngredient) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(supermodreborn.MODID, name)));
        ArmorMaterial material = new ArmorMaterial(defense, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, material);
    }
}