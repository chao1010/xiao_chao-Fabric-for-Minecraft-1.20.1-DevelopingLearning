package com.example.registry.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SilverSword extends SwordItem {
    public SilverSword(ToolMaterial toolMaterial,int attackDamage, float attackSpeed, Settings settings){
        super(toolMaterial,attackDamage,attackSpeed,settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasControlDown())
            tooltip.add(Text.translatable("item.template-mod.silver_sword.tip").formatted(Formatting.GOLD));
        else
            tooltip.add(Text.translatable("item.template-mod.null.tip"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
