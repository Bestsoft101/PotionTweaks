package b100.potiontweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import b100.potiontweaks.PotionTweaksMod;
import net.minecraft.recipe.BrewingRecipeRegistry;

@Mixin(value = BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
	
	@Inject(
		method = "registerDefaults",
		at = @At("TAIL")
	)
	private static void onRegisterDefaults(BrewingRecipeRegistry.Builder builder, CallbackInfo ci) {
		PotionTweaksMod.registerPotionRecipes(builder);
	}
	
	
}
