package io.github.redrain0o0.cccams.blocks.entity;

import io.github.redrain0o0.cccams.Cccams;
import io.github.redrain0o0.cccams.blocks.CccamsBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CccamsBlockEntities {
    public static final BlockEntityType<CameraBlockEntity> CAMERA_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Cccams.createId("camera"), FabricBlockEntityTypeBuilder.create(CameraBlockEntity::new, CccamsBlocks.CAMERA_2D).build());

    public static void initialize() {
        Cccams.LOGGER.info("Initializing block entities");
    }
}
