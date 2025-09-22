package net.manufloso.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties
{
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(6).saturationModifier(3f).build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(4).saturationModifier(1.5f).build();
    public static final FoodProperties PIZZA = new FoodProperties.Builder().nutrition(20).saturationModifier(20f).build();
}
