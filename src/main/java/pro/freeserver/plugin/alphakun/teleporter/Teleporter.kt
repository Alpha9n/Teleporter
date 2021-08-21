package pro.freeserver.plugin.alphakun.teleporter

import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList.plugin
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList.tpHandler
import pro.freeserver.plugin.alphakun.teleporter.api.JsonAPI
import pro.freeserver.plugin.alphakun.teleporter.commands.SetPoint
import pro.freeserver.plugin.alphakun.teleporter.commands.Teleport
import pro.freeserver.plugin.alphakun.teleporter.events.PlayerQuit
import pro.freeserver.plugin.alphakun.teleporter.handlers.TPAccount

class Teleporter : JavaPlugin() {

    override fun onEnable() {
        plugin = this
        generateCommands()
        generateEvents()
        reloadConfig()
        saveDefaultConfig()
        ImportTPList.importTPList()
        if (JsonAPI.readTPList()?.tpAccounts != null) {
            tpHandler.tpAccounts = JsonAPI.readTPList()?.tpAccounts as List<TPAccount>
        }
    }

    override fun onDisable() {
    }

    private fun generateCommands() {
        getCommand("kentikutp")!!.setExecutor(Teleport())
        getCommand("setpoint")!!.setExecutor(SetPoint())
    }

    private fun generateEvents() {
        val plm: PluginManager = server.pluginManager
        plm.registerEvents(PlayerQuit(), plugin)
    }
}