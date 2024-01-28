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
                        entries.add(ModItems.SILVER_SPEAR);
                        entries.add(ModItems.SILVER_PICKAXE);
                        entries.add(ModItems.SILVER_AXE);
                        entries.add(ModItems.SILVER_SHOVEL);
                        entries.add(ModItems.SILVER_HOE);
                        entries.add(ModItems.SILVER_HELMET);
                        entries.add(ModItems.SILVER_CHESTPLATE);
                        entries.add(ModItems.SILVER_LEGGINGS);
                        entries.add(ModItems.SILVER_BOOTS);
                        entries.add(ModItems.APPLE_SILVER);
                    }).build());

    public static final ItemGroup MODOTHER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ExampleMod.MOD_ID, "modother"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.modother"))
                    .icon(() -> new ItemStack(ModItems.COAL_BALL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COAL_BALL);
                        entries.add(ModItems.PETROLEUM_BUCKET);
                        entries.add(ModItems.EGG_BLUE_SLIME);
                        entries.add(ModItems.EGG_RED_SLIME);
                        entries.add(ModItems.EGG_YELLOW_SLIME);
                        entries.add(ModItems.BLUE_SLIMEBALL);
                        entries.add(ModItems.RED_SLIMEBALL);
                        entries.add(ModItems.YELLOW_SLIMEBALL);
                        entries.add(ModItems.CABBAGE);
                        entries.add(ModItems.CABBAGE_SEEDS);
                    }).build());
    public static void registerModItemGroup(){
        ExampleMod.LOGGER.debug("Registering mod item group for"+ ExampleMod.MOD_ID);
    }
}
