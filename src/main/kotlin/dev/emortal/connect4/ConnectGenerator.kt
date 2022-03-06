package dev.emortal.connect4

import net.minestom.server.instance.ChunkGenerator
import net.minestom.server.instance.ChunkPopulator
import net.minestom.server.instance.batch.ChunkBatch
import net.minestom.server.instance.block.Block

object ConnectGenerator : ChunkGenerator {
    override fun generateChunkData(batch: ChunkBatch, chunkX: Int, chunkZ: Int) {
        for (x in 0 until 16) {
            for (z in 0 until 16) {
                batch.setBlock(x, 0, z, Block.LIGHT_GRAY_CONCRETE)
            }
        }
    }

    override fun getPopulators(): MutableList<ChunkPopulator>? = null
}