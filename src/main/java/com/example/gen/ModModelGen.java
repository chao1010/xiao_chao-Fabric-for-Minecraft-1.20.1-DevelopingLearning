package com.example.gen;

import com.example.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

public class ModModelGen extends FabricModelProvider {

    public ModModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILVER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILVER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILVER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILVER_BOOTS);
    }
}
