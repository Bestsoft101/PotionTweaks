package b100.potiontweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;

import net.minecraft.item.Items;

@Mixin(Items.class)
public class ItemsMixin {
	
	@ModifyConstant(
		method = "<clinit>",
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=potion")),
		constant = @Constant(intValue = 1, ordinal = 0)
	)
	private static int modifyPotionStackSize(int prev) {
		return 16;
	}
	
}
