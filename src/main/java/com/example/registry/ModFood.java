package com.example.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFood {
    public static final FoodComponent SILVER_APPLE = (new FoodComponent.Builder()).hunger(4).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1200, 0), 1.0F).alwaysEdible().build();
    public static final FoodComponent CABBAGE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.4f).build();
}
