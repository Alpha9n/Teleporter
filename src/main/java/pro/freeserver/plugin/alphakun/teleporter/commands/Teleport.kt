package pro.freeserver.plugin.alphakun.teleporter.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList.tpHandler
import pro.freeserver.plugin.alphakun.teleporter.handlers.TPAccount

class Teleport : CommandExecutor{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (label.equals("kentikutp",true)){
                var pName:String = sender.name
                val tpAccount: TPAccount? = tpHandler.getAccountUser(Bukkit.getPlayer(pName)!!.uniqueId)
                if (args.isNotEmpty() && sender.isOp){
                    if (args[0].equals("debug",true)) {
                        println("tpHandler = ${tpHandler.tpAccounts}")
                        return true
                    } else if (Bukkit.getPlayer(args[0]) != null) {
                        sender.teleport(tpHandler.getAccountUser(Bukkit.getPlayer(args[0])!!.uniqueId)!!.getLocation())
                        return true
                    }
                }
                if (tpAccount != null){
                    sender.teleport(tpAccount.getLocation())
                } else {
                    sender.sendMessage("§c[BOT]§rTeleporter§a:§r" + "§cあなたはエントリーされていません")
                }
            }
        }
        return true
    }
}