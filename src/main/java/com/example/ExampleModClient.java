package com.example;

import com.example.entity.ModEntityType;
import com.example.entity.mob.BlueSlimeEntityRenderer;
import com.example.entity.mob.RedSlimeEntityRenderer;
import com.example.entity.mob.YellowSlimeEntityRenderer;
import com.example.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class ExampleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.Petroleum, ModFluids.FLOWING_Petroleum, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/lava_still"),
                new Identifier("minecraft:block/lava_flow"),
                0x000000
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.Petroleum, ModFluids.FLOWING_Petroleum);

        EntityRendererRegistry.register(ModEntityType.BLUE_SLIME, BlueSlimeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.RED_SLIME, RedSlimeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityType.YELLOW_SLIME, YellowSlimeEntityRenderer::new);

    }
}
