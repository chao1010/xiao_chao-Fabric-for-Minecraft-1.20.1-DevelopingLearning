package com.example.registry;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    //加入银锭与粗银
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings()));
    //加入银制工具
    public static final Item SILVER_SWORD = registerItem("silver_sword",new SwordItem(ModToolMaterials.SLIVER, 3, -2.4F, new FabricItemSettings()));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", new ShovelItem(ModToolMaterials.SLIVER, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", new PickaxeItem(ModToolMaterials.SLIVER, 1, -2.8F, new FabricItemSettings()));
    public static final Item SILVER_AXE = registerItem("silver_axe", new AxeItem(ModToolMaterials.SLIVER, 6.0F, -3.0F, new FabricItemSettings()));
    public static final Item SILVER_HOE = registerItem("silver_hoe", new HoeItem(ModToolMaterials.SLIVER, 0, -3.0F, new FabricItemSettings()));
    //加入银矛
    public static final Item SILVER_SPEAR = registerItem("silver_spear", new TridentItem((new FabricItemSettings()).maxDamage(250)));

    //加入银苹果
    public static final Item APPLE_SILVER = registerItem("apple_silver",new Item(new FabricItemSettings().rarity(Rarity.RARE).food(ModFood.SILVER_APPLE)));
    // 注册
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }
    // 打印信息
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);
    }
}
