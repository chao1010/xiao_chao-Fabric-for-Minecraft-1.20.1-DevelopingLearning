package com.example.registry;

import com.example.ExampleMod;
import com.example.fluid.ModFluids;
import com.example.registry.crop.CabbageCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModBlocks {
    //加入银块、粗银块、银矿、深层银矿
    public static final Block SILVER_BLOCK = registerBlock("silver_block",new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block SILVER_ORE_BLOCK = registerBlock("silver_ore_block",new ExperienceDroppingBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(3.0F,3.0F)));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).requiresTool().strength(5.0F, 6.0F)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",new ExperienceDroppingBlock(AbstractBlock.Settings.copy(SILVER_ORE_BLOCK).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)));
    //加入石油
    public static final Block PETROLEUM = registerBlock("petroleum", new FluidBlock((FlowableFluid) ModFluids.Petroleum, AbstractBlock.Settings.create().mapColor(MapColor.BLACK).replaceable().noCollision().strength(100.0f).pistonBehavior(PistonBehavior.DESTROY).dropsNothing().liquid().sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)));
    //加入卷心菜作物
    public static final Block CABBAGE_CROP = registerBlock("cabbages",new CabbageCropBlock());



    // 注册
    private static Block registerBlock(String name, Block block) {
        ModItems.registerItem(name,new BlockItem(block,new FabricItemSettings()));
        return Registry.register(Registries.BLOCK, new Identifier(ExampleMod.MOD_ID, name), block);
    }


    public static void registerModBlocks() {
        ExampleMod.LOGGER.info("Registering Mod Blocks for " + ExampleMod.MOD_ID);
    }
}
