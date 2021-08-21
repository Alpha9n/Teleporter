package pro.freeserver.plugin.alphakun.teleporter.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList
import pro.freeserver.plugin.alphakun.teleporter.api.JsonAPI

class SetPoint: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player && sender.isOp) {
            if (label.equals("setpoint", true)) {
                if(args.isEmpty()) {
                    sender.sendMessage("§c[BOT]§rTeleporter§a:§r" + "§cプレイヤーが見つかりません")
                    return false
                }
                if(Bukkit.getPlayer(args[0]) != null) {
                    ImportTPList.tpHandler.setTPAccount(Bukkit.getPlayer(args[0])!!.uniqueId, sender.getLocation())
                    JsonAPI.writeTPList()
                    sender.sendMessage("§c[BOT]§rTeleporter§a:§r" + "§9" + args[0] + "§aのテレポート地点を設定しました。")
                    return true
                } else if(Bukkit.getOfflinePlayer(args[0]).hasPlayedBefore()) {
                    ImportTPList.tpHandler.setTPAccount(Bukkit.getOfflinePlayer(args[0]).uniqueId, sender.getLocation())
                    JsonAPI.writeTPList()
                    sender.sendMessage("§c[BOT]§rTeleporter§a:§r" + "§9" + args[0] + "§aのテレポート地点を設定しました。")
                    return true
                } else {
                    sender.sendMessage("§c[BOT]§rTeleporter§a:§r" + "§cプレイヤーが見つかりません")
                }
                return false
            }
        }
        return false
    }
}