package b100.potiontweaks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class PotionTweaksMod implements ModInitializer {
	public static final String MOD_ID = "potiontweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	public static RegistryEntry<Potion> HASTE_POTION;
	public static RegistryEntry<Potion> LONG_HASTE_POTION;
	public static RegistryEntry<Potion> STRONG_HASTE_POTION;
	
	@Override
	public void onInitialize() {
		HASTE_POTION = registerPotion("haste", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 10 * 60 * 20)));
		LONG_HASTE_POTION = registerPotion("long_haste", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 30 * 60 * 20)));
		STRONG_HASTE_POTION = registerPotion("strong_haste", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3 * 60 * 20, 1)));
	}
	
	public static void registerPotionRecipes(BrewingRecipeRegistry.Builder builder) {
		builder.registerPotionRecipe(Potions.AWKWARD, Items.GOLD_INGOT, PotionTweaksMod.HASTE_POTION);
		builder.registerPotionRecipe(PotionTweaksMod.HASTE_POTION, Items.GLOWSTONE_DUST, PotionTweaksMod.STRONG_HASTE_POTION);
		builder.registerPotionRecipe(PotionTweaksMod.HASTE_POTION, Items.REDSTONE, PotionTweaksMod.LONG_HASTE_POTION);
	}
	
	public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
		return Registry.registerReference(Registries.POTION, Identifier.of(MOD_ID, name), potion);
	}
	
	public static void print(String string) {
		LOGGER.info(string);
	}
}