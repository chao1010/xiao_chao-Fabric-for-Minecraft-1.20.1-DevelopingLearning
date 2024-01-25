package com.example.registry;

import com.example.ExampleMod;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeTags {

    public static final TagKey<Biome> ALLOWS_SURFACE_BLUE_SLIME_SPAWNS = ModBiomeTags.of("allows_surface_blue_slime_spawns");
    public static final TagKey<Biome> ALLOWS_SURFACE_RED_SLIME_SPAWNS = ModBiomeTags.of("allows_surface_red_slime_spawns");
    public static final TagKey<Biome> ALLOWS_SURFACE_YELLOW_SLIME_SPAWNS = ModBiomeTags.of("allows_surface_yellow_slime_spawns");

    private void BiomeTags() {
    }

    private static TagKey<Biome> of(String name) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(ExampleMod.MOD_ID,name));
    }

    public static void registerModBiomeTags() {
        ExampleMod.LOGGER.info("Registering Mod BiomeTags for " + ExampleMod.MOD_ID);
    }
}
