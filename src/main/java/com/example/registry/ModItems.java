package com.example.registry;

import com.example.ExampleMod;
import com.example.entity.ModEntityType;
import com.example.fluid.ModFluids;
import com.example.registry.item.ModItemTips;
import com.example.registry.item.SilverSword;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Supplier;

import static net.minecraft.item.Items.BUCKET;

public class ModItems{
    //加入银锭与粗银
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new ModItemTips("silver_ingot",new FabricItemSettings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings()));
    //加入银制工具
    public static final Item SILVER_SWORD = registerItem("silver_sword",new SilverSword(ModToolMaterials.SLIVER, 3, -2.4F, new FabricItemSettings()));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", new ShovelItem(ModToolMaterials.SLIVER, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", new PickaxeItem(ModToolMaterials.SLIVER, 1, -2.8F, new FabricItemSettings()));
    public static final Item SILVER_AXE = registerItem("silver_axe", new AxeItem(ModToolMaterials.SLIVER, 6.0F, -3.0F, new FabricItemSettings()));
    public static final Item SILVER_HOE = registerItem("silver_hoe", new HoeItem(ModToolMaterials.SLIVER, 0, -3.0F, new FabricItemSettings()));
    //加入银矛
    public static final Item SILVER_SPEAR = registerItem("silver_spear", new SpearItem(ModToolMaterials.SLIVER, 6, -3.4F, new FabricItemSettings()));

    //加入银盔甲:鞋子、裤子、胸甲、头盔
    public static final Item SILVER_BOOTS = registerItem("silver_boots", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SILVER_HELMET = registerItem("silver_helmet", new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET, new FabricItemSettings()));

    //加入银苹果
    public static final Item APPLE_SILVER = registerItem("apple_silver",new ModItemTips("apple_silver",new FabricItemSettings().rarity(Rarity.RARE).food(ModFood.SILVER_APPLE)));

    //加入煤球
    public static final Item COAL_BALL = registerItem("coal_ball",new Item(new FabricItemSettings()));

    //加入石油桶
    public static final Item PETROLEUM_BUCKET = registerItem("bucket_petroleum", new BucketItem(ModFluids.Petroleum, new FabricItemSettings().recipeRemainder(BUCKET).maxCount(1)));
    //加入蓝、红、黄史莱姆刷怪蛋
    public static final Item EGG_BLUE_SLIME = registerItem("egg_blue_slime",new SpawnEggItem(ModEntityType.BLUE_SLIME ,0xADD8E6,0x000080, new FabricItemSettings()));
    public static final Item EGG_RED_SLIME = registerItem("egg_red_slime",new SpawnEggItem(ModEntityType.RED_SLIME ,0xADD8E6,0x000080, new FabricItemSettings()));
    public static final Item EGG_YELLOW_SLIME = registerItem("egg_yellow_slime",new SpawnEggItem(ModEntityType.YELLOW_SLIME ,0xADD8E6,0x000080, new FabricItemSettings()));

    //加入蓝、红、黄色史莱姆球
    public static final Item BLUE_SLIMEBALL = registerItem("blue_slimeball",new Item(new FabricItemSettings()));
    public static final Item RED_SLIMEBALL = registerItem("red_slimeball",new Item(new FabricItemSettings()));
    public static final Item YELLOW_SLIMEBALL = registerItem("yellow_slimeball",new Item(new FabricItemSettings()));

    //加入卷心菜和卷心菜种子
    public static final Item CABBAGE = registerItem("cabbage",new Item(new FabricItemSettings().food(ModFood.CABBAGE)));
    public static final Item CABBAGE_SEEDS = registerItem("cabbage_seeds",new AliasedBlockItem(ModBlocks.CABBAGE_CROP,new FabricItemSettings()));

    // 注册
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }


    // 打印信息
    public static void registerModItems() {
        ExampleMod.LOGGER.info("Registering Mod Items for " + ExampleMod.MOD_ID);
    }
}
