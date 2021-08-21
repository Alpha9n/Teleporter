package pro.freeserver.plugin.alphakun.teleporter.handlers

import org.bukkit.Location
import java.util.*
import kotlin.collections.ArrayList

class TPHandler {

    var tpAccounts: List<TPAccount> = ArrayList()

    fun setTPAccount(user: UUID, pointOfTP: Location) {
        if(isContainedAccount(user)) {
            var tpAccount: TPAccount? = getAccountUser(user)
            tpAccount!!.setLocation(pointOfTP)
        } else {
            val tpAccount: TPAccount = TPAccount(user,pointOfTP)
            tpAccounts += tpAccount
        }
    }

    fun getAccountUser(user: UUID): TPAccount? {
        if (tpAccounts.isEmpty()) return null
        for (tpAccount: TPAccount in tpAccounts) {
            if (tpAccount.getPlayer().equals(user)) {
                return tpAccount
            }
        }
        return null
    }

    private fun isContainedAccount(user: UUID): Boolean {
        if (tpAccounts.isEmpty()) return false
        for (tpAccount: TPAccount in tpAccounts) {
            if (tpAccount.getPlayer().equals(user)) {
                return true
            }
        }
        return false
    }

}