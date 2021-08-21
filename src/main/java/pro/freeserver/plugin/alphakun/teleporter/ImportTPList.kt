package pro.freeserver.plugin.alphakun.teleporter

import org.bukkit.plugin.Plugin
import pro.freeserver.plugin.alphakun.teleporter.handlers.TPHandler

object ImportTPList {

    lateinit var plugin: Plugin
    lateinit var tpHandler: TPHandler

    fun importTPList() {
         tpHandler = TPHandler()
    }
}