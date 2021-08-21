package pro.freeserver.plugin.alphakun.teleporter.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList.plugin
import pro.freeserver.plugin.alphakun.teleporter.ImportTPList.tpHandler
import pro.freeserver.plugin.alphakun.teleporter.handlers.TPHandler
import java.io.*


object JsonAPI {

    var fileName: String = "TPList"

    fun writeTPList() {
        var file: File = File(plugin.dataFolder, "$fileName.json")
        try {
            OutputStreamWriter(
                FileOutputStream(file), "UTF-8"
            ).use { writer ->
                val gson = Gson()
                gson.toJson(tpHandler, writer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readTPList(): TPHandler? {
        var file: File = File(plugin.dataFolder, "$fileName.json")
        if(!file.exists()) {
            writeTPList()
            return tpHandler
        }
        try {
            InputStreamReader(
                FileInputStream(file), "UTF-8"
            ).use { reader ->
                val gson = Gson()
                return gson.fromJson(reader, TPHandler:: class.java)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}