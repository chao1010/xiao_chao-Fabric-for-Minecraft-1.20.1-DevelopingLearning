package com.example.registry;

import com.example.ExampleMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModOreConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SILVER = registerKey("ore_silver");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SILVER_BURIED = registerKey("ore_silver_buried");

    public ModOreConfiguredFeatures() {
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,new Identifier(ExampleMod.MOD_ID,name));
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable){
        RuleTest shallow = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworld_silver_ore = List.of(OreFeatureConfig.createTarget(shallow, ModBlocks.SILVER_ORE_BLOCK.getDefaultState()), OreFeatureConfig.createTarget(deepslate, ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));

        register(featureRegisterable, ORE_SILVER, Feature.ORE, new OreFeatureConfig(overworld_silver_ore, 9));
        register(featureRegisterable, ORE_SILVER_BURIED, Feature.ORE, new OreFeatureConfig(overworld_silver_ore, 9, 0.7F));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        registerable.register(key, new ConfiguredFeature<>(feature, config));
    }
}
