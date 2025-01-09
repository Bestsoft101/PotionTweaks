package b100.potiontweaks.mixin.client;

import java.util.List;
import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.sugar.Local;

import b100.potiontweaks.LanguageHelper;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.resource.ResourceManager;

@Mixin(value = TranslationStorage.class)
public class TranslationStorageMixin {
	
	@Inject(
		method = "load",
		at = @At(
			value = "INVOKE",
			target = "Lcom/google/common/collect/ImmutableMap;copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;"
		)
	)
	private static void onLoad(ResourceManager resourceManager, List<String> languages, boolean rtl, CallbackInfoReturnable<TranslationStorage> ci, @Local Map<String, String> map) {
		LanguageHelper.loadLanguages(languages, map);
	}
	
}
