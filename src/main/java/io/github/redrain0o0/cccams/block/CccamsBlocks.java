package io.github.redrain0o0.cccams.block;

import io.github.redrain0o0.cccams.Cccams;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CccamsBlocks {
    public static final Block CAMERA_2D = register(
            new CameraBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)),
            "camera"
    );

    public static void initialize() {}

    public static Block register(Block block,String name) {
        ResourceLocation id = Cccams.createId(name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties());
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
