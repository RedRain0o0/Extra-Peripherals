package io.github.redrain0o0.extraperipherals.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.redrain0o0.extraperipherals.block.entity.CameraBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class CameraBlockEntityRenderer implements BlockEntityRenderer<CameraBlockEntity> {
    public CameraBlockEntityRenderer(BlockEntityRendererProvider.Context context) {}
    @Override
    public void render(CameraBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        poseStack.pushPose();
        // uhhhhh idk what im doing /shrug
        poseStack.popPose();
    }
}
