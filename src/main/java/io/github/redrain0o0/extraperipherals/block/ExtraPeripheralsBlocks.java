package io.github.redrain0o0.extraperipherals.block;

import io.github.redrain0o0.extraperipherals.ExtraPeripherals;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ExtraPeripheralsBlocks {
    public static final Block CAMERA_NORMAL = register(
            new CameraBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)),
            "camera_normal"
    );

    public static void initialize() {}

    public static Block register(Block block,String name) {
        ResourceLocation id = ExtraPeripherals.createId(name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties());
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
