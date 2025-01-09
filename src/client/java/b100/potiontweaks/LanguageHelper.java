package b100.potiontweaks;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;

public class LanguageHelper {
	
	public static void loadLanguages(List<String> languages, Map<String, String> map) {
		for(String lang : languages) {
			loadLanguage(lang, map);
		}
	}
	
	private static void loadLanguage(String name, Map<String, String> map) {
		InputStream stream = null;
		
		try {
			if(FabricLoader.getInstance().isModLoaded("fabric-api")) {
				String path = "lang/" + name + ".lang";
				Optional<Resource> resource = MinecraftClient.getInstance().getResourceManager().getResource(Identifier.of(PotionTweaksMod.MOD_ID, path));
				if(resource.isPresent()) {
					stream = resource.get().getInputStream();
				}
			}else {
				stream = LanguageHelper.class.getResourceAsStream("/assets/" + PotionTweaksMod.MOD_ID + "/lang/" + name + ".lang");
			}
			if(stream == null) {
				return;
			}
			ConfigUtil.loadConfig(stream, (key, value) -> map.put(key, value), '=');	
		}catch (Exception e) {
			throw new RuntimeException("Loading language: " + name, e);
		}
	}
}
