package pro.freeserver.plugin.alphakun.teleporter.events

import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuit: Listener {

    @EventHandler
    fun playerQuit(e: PlayerQuitEvent) {
        if (e.player.gameMode.equals(GameMode.CREATIVE)) {
            e.player.gameMode = Bukkit.getDefaultGameMode()
        }
    }
}