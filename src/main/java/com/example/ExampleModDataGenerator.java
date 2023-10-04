package com.example;

import com.example.gen.ModModelGen;
import com.example.registry.ModOreConfiguredFeatures;
import com.example.registry.ModOrePlacedFeatures;
import com.example.registry.ModWorldGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ExampleModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelGen::new);
//		pack.addProvider(ModWorldGen::new);
	}

//	@Override
//	public void buildRegistry(RegistryBuilder registryBuilder) {
//		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModOreConfiguredFeatures::bootstrap);
//		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModOrePlacedFeatures::bootstrap);
//	}
}
