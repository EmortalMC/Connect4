package dev.emortal.connect4

import dev.emortal.immortal.game.GameManager
import dev.emortal.immortal.game.GameOptions
import dev.emortal.immortal.game.WhenToRegisterEvents
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.extensions.Extension

class ConnectExtension : Extension() {

    override fun initialize() {
        GameManager.registerGame<ConnectGame>(
            eventNode,
            "connect4",
            Component.text("Connect 4", NamedTextColor.GREEN),
            showsInSlashPlay = true,
            canSpectate = true,
            WhenToRegisterEvents.GAME_START,
            GameOptions(
                maxPlayers = 2,
                minPlayers = 2,
                countdownSeconds = 3
            )
        )

        logger.info("[${origin.name}] Initialized!")
    }

    override fun terminate() {
        logger.info("[${origin.name}] Terminated!")
    }

}