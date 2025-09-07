package io.github.redrain0o0.extraperipherals.block.entity;

import io.github.redrain0o0.extraperipherals.ExtraPeripherals;
import io.github.redrain0o0.extraperipherals.block.ExtraPeripheralsBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ExtraPeripheralsBlockEntities {
    public static final BlockEntityType<CameraBlockEntity> CAMERA_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ExtraPeripherals.createId("camera"), FabricBlockEntityTypeBuilder.create(CameraBlockEntity::new, ExtraPeripheralsBlocks.CAMERA_NORMAL).build());

    public static void initialize() {
        ExtraPeripherals.LOGGER.info("Initializing block entities");
    }
}
