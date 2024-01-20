package com.example.fluid;

import com.example.ExampleMod;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModFluidTags {
    public static final TagKey<Fluid> Petroleum = ModFluidTags.of("petroleum");

    private ModFluidTags() {
    }

    private static TagKey<Fluid> of(String id) {
        return TagKey.of(RegistryKeys.FLUID, new Identifier(ExampleMod.MOD_ID));
    }
}
