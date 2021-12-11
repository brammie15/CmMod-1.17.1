package com.brammie15.brammiecmmod.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.Tags;

public class CmEnrichedEffect extends MobEffect {
    public CmEnrichedEffect(MobEffectCategory effectCategory, int color) {
        super(effectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int p_19468_) {
        super.applyEffectTick(entity, p_19468_);
    //Is not working? @wide
        if (entity.isAlive()) {
            entity.setHealth(2000);
        }
    }


}
