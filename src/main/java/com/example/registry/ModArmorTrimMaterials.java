package com.example.registry;

import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;
import java.util.Optional;

public class ModArmorTrimMaterials {

    public static final RegistryKey<ArmorTrimMaterial> SILVER = ModArmorTrimMaterials.of("silver");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registry) {
        ModArmorTrimMaterials.register(registry, SILVER, ModItems.SILVER_INGOT, Style.EMPTY.withColor(12632256), 1.1f);
    }

    public static Optional<RegistryEntry.Reference<ArmorTrimMaterial>> get(DynamicRegistryManager registryManager, ItemStack stack) {
        return registryManager.get(RegistryKeys.TRIM_MATERIAL).streamEntries().filter(recipe -> stack.itemMatches(((ArmorTrimMaterial)recipe.value()).ingredient())).findFirst();
    }

    private static void register(Registerable<ArmorTrimMaterial> registry, RegistryKey<ArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex) {
        ModArmorTrimMaterials.register(registry, key, ingredient, style, itemModelIndex, Map.of());
    }

    private static void register(Registerable<ArmorTrimMaterial> registry, RegistryKey<ArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex, Map<ArmorMaterials, String> overrideArmorMaterials) {
        ArmorTrimMaterial armorTrimMaterial = ArmorTrimMaterial.of(key.getValue().getPath(), ingredient, itemModelIndex, Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style), overrideArmorMaterials);
        registry.register(key, armorTrimMaterial);
    }

    private static RegistryKey<ArmorTrimMaterial> of(String name) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, new Identifier(name));
    }
}
