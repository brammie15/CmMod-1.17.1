package com.brammie15.brammiecmmod.core.init;

import com.brammie15.brammiecmmod.CmMod;
import com.brammie15.brammiecmmod.common.effect.CmEnrichedEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectInit {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CmMod.MOD_ID);

    public static final RegistryObject<CmEnrichedEffect> CM_ENRICHED_EFFECT = EFFECTS.register("cm_enriched_effect", () -> new CmEnrichedEffect(MobEffectCategory.BENEFICIAL, 200));
}
