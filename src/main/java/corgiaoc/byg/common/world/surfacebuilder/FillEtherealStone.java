package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class FillEtherealStone extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState SAND = Blocks.SAND.defaultBlockState();

    public FillEtherealStone(Codec<SurfaceBuilderConfig> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.END_STONE.defaultBlockState()) {
                chunkIn.setBlockState(block, BYGBlocks.ETHER_STONE.defaultBlockState(), false);
            }
        }
        SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
    }
}