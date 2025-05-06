package net.manufloso.datagen;

import net.manufloso.block.ModBlocks;
import net.manufloso.item.ModItems;
import net.manufloso.supermodreborn;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        List<ItemLike> LITHIUM_SMELTABLES = List.of(
                ModItems.RAW_LITHIUM,
                ModBlocks.LITHIUM_ORE,
                ModBlocks.DEEPSLATE_LITHIUM_ORE
        );
        ItemStack lithiumResult = new ItemStack(ModItems.LITHIUM_INGOT.get(), 1);


        List<ItemLike> CHEESE = List.of(
                Items.MILK_BUCKET
        );
        ItemStack cheeseResult = new ItemStack(ModItems.CHEESE.get(), 8);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LITHIUM_BLOCK.get())
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModItems.LITHIUM_INGOT.get())
                .unlockedBy("has_lithium", has(ModItems.LITHIUM_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LITHIUM_INGOT.get(), 9)
                .requires(ModBlocks.LITHIUM_BLOCK)
                .unlockedBy("has_lithium_block", has(ModBlocks.LITHIUM_BLOCK)).save(recipeOutput);

        //ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LITHIUM_INGOT.get(), 18)
        //        .requires(ModBlocks.LITHIUM_BLOCK)
        //        .unlockedBy("has_magic_block", has(ModBlocks.LITHIUM_BLOCK))
        //        .save(recipeOutput, "tutorialmod:otra_receta");



        Smelting(recipeOutput, LITHIUM_SMELTABLES, RecipeCategory.MISC, lithiumResult, 0.25f, 200, "lithium");
        Blasting(recipeOutput, LITHIUM_SMELTABLES, RecipeCategory.MISC, lithiumResult, 0.25f, 100, "lithium");

        Smelting(recipeOutput, CHEESE, RecipeCategory.FOOD, cheeseResult, 0.25f, 200, "cheese");
        Smoking(recipeOutput, CHEESE, RecipeCategory.FOOD, cheeseResult, 0.25f, 100, "cheese");


        stairBuilder(ModBlocks.PALM_STAIRS.get(), Ingredient.of(ModBlocks.PALM_PLANKS)).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB.get(), ModBlocks.PALM_PLANKS.get());

        buttonBuilder(ModBlocks.PALM_BUTTON.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.PALM_PRESSURE_PLATE.get(), ModBlocks.PALM_PLANKS.get());

        fenceBuilder(ModBlocks.PALM_FENCE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.PALM_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_WALL.get(), ModBlocks.PALM_PLANKS.get());

        doorBuilder(ModBlocks.PALM_DOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        trapdoorBuilder(ModBlocks.PALM_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
    }

    protected static void Smelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemStack pResultStack,
                                   float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResultStack,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void Blasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemStack pResultStack,
                                   float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResultStack,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void Smoking(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemStack pResultStack,
                                  float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResultStack,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            @NotNull RecipeOutput recipeOutput,
            RecipeSerializer<T> pCookingSerializer,
            AbstractCookingRecipe.Factory<T> factory,
            List<ItemLike> pIngredients,
            @NotNull RecipeCategory pCategory, // This is RecipeCategory, used for advancement path
            @NotNull ItemStack pResultStack,
            float pExperience,
            int pCookingTime,
            @NotNull String pGroup,
            String pRecipeSuffix
    ) {
        for (ItemLike itemlikeIngredient : pIngredients)
        {
            Ingredient ingredient = Ingredient.of(itemlikeIngredient);
            CookingBookCategory cookingBookCategory = determineCookingBookCategory(pResultStack);

            // 1. Create the recipe instance directly using the factory
            // The factory interface matches: (String group, RecipeCategory category, Ingredient input, ItemStack result, float xp, int time) -> T
            T recipe = factory.create(
                    pGroup,
                    cookingBookCategory,
                    ingredient,
                    pResultStack, // Pass the ItemStack directly
                    pExperience,
                    pCookingTime
            );

            // 2. Construct the Recipe ID. Ensure YourMod.MODID is your actual mod ID.
            // This uses the static helpers from RecipeBuilder, assuming they are accessible.
            // If not, call them like RecipeBuilder.getItemName(...)
            String resultItemName = getItemName(pResultStack.getItem());
            String ingredientItemName = getItemName(itemlikeIngredient);
            ResourceLocation recipeId = ResourceLocation.fromNamespaceAndPath(
                    supermodreborn.MODID,
                    resultItemName + pRecipeSuffix + "_" + ingredientItemName
            );

            // 3. Build the Advancement criteria (replicating what SimpleCookingRecipeBuilder does)
            // Ensure getHasName and has been accessible (e.g., by extending RecipeProvider or using RecipeBuilder.has())
            String criterionName = getHasName(itemlikeIngredient); // e.g., "has_cobblestone"
            Criterion<?> unlockCriterion = has(itemlikeIngredient);     // e.g., InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBBLESTONE)

            Advancement.Builder advancementBuilder = Advancement.Builder.recipeAdvancement()
                    .addCriterion(criterionName, unlockCriterion)
                    .rewards(AdvancementRewards.Builder.recipe(recipeId))
                    .requirements(AdvancementRequirements.Strategy.OR); // Standard for single unlock criteria

            // 4. Save the recipe and its advancement
            recipeOutput.accept(
                    recipeId,
                    recipe,
                    advancementBuilder.build(recipeId.withPrefix("recipes/" + pCategory.getFolderName() + "/"))
            );
        }
    }

    protected static CookingBookCategory determineCookingBookCategory(ItemStack resultStack)
    {
        Item item = resultStack.getItem();

        if (item.getFoodProperties(resultStack, null) != null || (item.getFoodProperties(resultStack, null) != null))
        {
            return CookingBookCategory.FOOD;
        } else if (item instanceof BlockItem)
        {
            return CookingBookCategory.BLOCKS;
        } else
        {
            return CookingBookCategory.MISC;
        }
    }

}