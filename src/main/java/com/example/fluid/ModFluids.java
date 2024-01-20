package com.example.fluid;

import com.example.ExampleMod;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final Fluid FLOWING_Petroleum = registerFluid("flowing_petroleum", new PetroleumFluid.Flowing());
    public static final Fluid Petroleum = registerFluid("petroleum", new PetroleumFluid.Still());


    private static Fluid registerFluid(String name, Fluid fluid) {
        return Registry.register(Registries.FLUID, new Identifier(ExampleMod.MOD_ID,name), fluid);
    }

    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }

    public static void registerModFluids() {
        ExampleMod.LOGGER.info("Registering Mod Fluids for " + ExampleMod.MOD_ID);
    }
}
