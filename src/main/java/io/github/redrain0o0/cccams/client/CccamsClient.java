package io.github.redrain0o0.cccams.client;

import io.github.redrain0o0.cccams.block.entity.CccamsBlockEntities;
import io.github.redrain0o0.cccams.block.entity.renderer.CameraBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class CccamsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(CccamsBlockEntities.CAMERA_BLOCK_ENTITY, CameraBlockEntityRenderer::new);
    }
}
