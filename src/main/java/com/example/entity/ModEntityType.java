package com.example.entity;

import com.example.ExampleMod;
import com.example.entity.mob.BlueSlimeEntity;
import com.example.entity.mob.RedSlimeEntity;
import com.example.entity.mob.YellowSlimeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityType {

    public static final EntityType<BlueSlimeEntity> BLUE_SLIME = registerEntity("blue_slime", FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,BlueSlimeEntity::new).dimensions(EntityDimensions.fixed(2.04f, 2.04f)).trackRangeBlocks(10).build());
    public static final EntityType<RedSlimeEntity> RED_SLIME = registerEntity("red_slime", FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,RedSlimeEntity::new).dimensions(EntityDimensions.fixed(2.04f, 2.04f)).trackRangeBlocks(10).build());
    public static final EntityType<YellowSlimeEntity> YELLOW_SLIME = registerEntity("yellow_slime", FabricEntityTypeBuilder.create(SpawnGroup.MONSTER,YellowSlimeEntity::new).dimensions(EntityDimensions.fixed(2.04f, 2.04f)).trackRangeBlocks(10).build());

    private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType entityType) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(ExampleMod.MOD_ID, name),entityType);
    }



    public static void registerModEntity() {
        FabricDefaultAttributeRegistry.register(BLUE_SLIME,BlueSlimeEntity.createBlueSlimeAttributes());
        FabricDefaultAttributeRegistry.register(RED_SLIME,RedSlimeEntity.createRedSlimeAttributes());
        FabricDefaultAttributeRegistry.register(YELLOW_SLIME,YellowSlimeEntity.createYellowSlimeAttributes());
        ExampleMod.LOGGER.info("Registering Mod Entity for " + ExampleMod.MOD_ID);
    }
}
