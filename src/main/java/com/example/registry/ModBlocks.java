package com.example.registry;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    //加入银块、粗银块、银矿、深层银矿
    public static final Block SILVER_BLOCK = registerBlock("silver_block",new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block SILVER_ORE_BLOCK = registerBlock("silver_ore_block",new ExperienceDroppingBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(3.0F,3.0F)));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.0F, 6.0F)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SILVER_ORE_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)));

    // 注册
    private static Block registerBlock(String name, Block block) {
        ModItems.registerItem(name,new BlockItem(block,new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering Mod Blocks for " + ExampleMod.MOD_ID);
    }
}
