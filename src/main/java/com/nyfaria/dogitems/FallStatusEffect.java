package com.nyfaria.dogitems;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class FallStatusEffect extends StatusEffect {
    protected FallStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0x98D982);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
