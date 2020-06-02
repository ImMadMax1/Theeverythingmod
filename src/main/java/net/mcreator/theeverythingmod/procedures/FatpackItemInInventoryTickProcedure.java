package net.mcreator.theeverythingmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.theeverythingmod.TheEverythingModModElements;

@TheEverythingModModElements.ModElement.Tag
public class FatpackItemInInventoryTickProcedure extends TheEverythingModModElements.ModElement {
	public FatpackItemInInventoryTickProcedure(TheEverythingModModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FatpackItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 1, (int) 0));
	}
}
