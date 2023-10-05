package com.example.enchantment;

import com.example.ExampleMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static final Enchantment POISONING = ModEnchantments.register("poisoning", new PoisoningEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(ExampleMod.MOD_ID, name), enchantment);
    }

    public static void registerModModEnchantments() {
        ExampleMod.LOGGER.info("Registering Mod ModEnchantments for " + ExampleMod.MOD_ID);
    }
}
