package pro.freeserver.plugin.alphakun.teleporter.handlers

import org.bukkit.Location
import pro.freeserver.plugin.alphakun.teleporter.api.JsonLocation
import java.util.*

class TPAccount {
    private val player: String
    private var tpLoc: JsonLocation

    constructor(player: UUID, tpLoc: Location) {
        this.player = player.toString()
        this.tpLoc = JsonLocation.toJsonLocation(tpLoc)
    }

    fun getPlayer(): UUID {
        return UUID.fromString(player)
    }

    fun setLocation(tpLoc: Location) {
        this.tpLoc = JsonLocation.toJsonLocation(tpLoc)
    }

    fun getLocation(): Location {
        return JsonLocation.toBukkitLocation(this.tpLoc)
    }
}