package dev.emortal.connect4

import dev.emortal.immortal.game.Game
import dev.emortal.immortal.game.GameOptions
import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.Player
import net.minestom.server.event.player.PlayerUseItemEvent
import net.minestom.server.instance.Instance
import net.minestom.server.instance.batch.RelativeBlockBatch
import net.minestom.server.instance.block.Block
import net.minestom.server.utils.NamespaceID
import world.cepi.kstom.Manager
import world.cepi.kstom.event.listenOnly
import java.awt.Color.white

class ConnectGame(gameOptions: GameOptions) : Game(gameOptions) {

    val grid = Array(gridX) { IntArray(gridY) }

    companion object {
        val gridX = 7
        val gridY = 6
    }

    override fun playerJoin(player: Player) {

    }

    override fun playerLeave(player: Player) {

    }

    override fun gameStarted() {
        val batch = RelativeBlockBatch()
        var white = true
        for (x in 0..gridX*3) {
            for (y in 0..gridY*3) {
                if (x % 3 == 0) white = !white

                batch.setBlock(x, y, 0, if (white) Block.BLUE_CONCRETE else Block.LIGHT_BLUE_CONCRETE)
            }
        }

        batch.apply(instance, Pos(0.0, 1.0, 0.0)) {

        }
    }

    override fun gameDestroyed() {

    }

    override fun registerEvents() = with(eventNode) {
        listenOnly<PlayerUseItemEvent> {

        }
    }

    override fun instanceCreate(): Instance {
        val superbrightDimension = Manager.dimensionType.getDimension(NamespaceID.from("fullbright"))!!
        val newInstance = Manager.instance.createInstanceContainer(superbrightDimension)

        //newInstance.enableAutoChunkLoad(false)
        //for (x in -2..2) {
        //    for (z in -2..2) {
        //        newInstance.loadChunk(x, z)
        //    }
        //}
        newInstance.chunkGenerator = ConnectGenerator
        newInstance.timeRate = 0
        newInstance.worldBorder.diameter = 100.0

        return newInstance
    }

}