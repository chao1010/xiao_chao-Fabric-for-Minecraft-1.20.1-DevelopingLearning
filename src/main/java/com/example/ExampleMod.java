package com.example;

import com.example.enchantment.ModEnchantments;
import com.example.registry.ModBlocks;
import com.example.registry.ModItemGroup;
import com.example.registry.ModItems;
import com.example.registry.ModOreGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	//将mod登记信息设置成字符串
	public static final String MOD_ID="template-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("template-mod");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItemGroup.registerModItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOreGen.generateOres();
		ModEnchantments.registerModModEnchantments();
		FuelRegistry.INSTANCE.add(ModItems.COAL_BALL,14400);//9个煤炭块
	}
}