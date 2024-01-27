package com.example.registry.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItemTips extends Item {
    String name;

    public ModItemTips(String name,Settings settings) {
        super(settings);
        this.name = name;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasControlDown())
            tooltip.add(Text.translatable("item.template-mod."+ name +".tip").formatted(Formatting.GOLD));
        else
            tooltip.add(Text.translatable("item.template-mod.null.tip"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
