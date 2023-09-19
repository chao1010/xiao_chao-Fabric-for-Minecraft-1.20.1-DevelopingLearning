package com.example.registry;


import com.example.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SILVER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExampleMod.MOD_ID, "silver"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.silver"))
                    .icon(() -> new ItemStack(ModItems.SILVER_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.SILVER_INGOT);
                        entries.add(ModItems.RAW_SILVER);
                        entries.add(ModBlocks.SILVER_ORE_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.RAW_SILVER_BLOCK);
                        entries.add(ModItems.SILVER_SWORD);
                        entries.add(ModItems.SILVER_PICKAXE);
                        entries.add(ModItems.SILVER_AXE);
                        entries.add(ModItems.SILVER_SHOVEL);
                        entries.add(ModItems.SILVER_HOE);
//                        entries.add(ModItems.SILVER_SPEAR);
                    }).build());

    public static void registerModItemGroup(){
        ExampleMod.LOGGER.debug("Registering mod item group for"+ ExampleMod.MOD_ID);
    }
}
