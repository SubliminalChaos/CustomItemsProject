package org.waqe.pl.customitems

import org.bukkit.plugin.java.JavaPlugin
import java.lang.Exception

class CustomItems : JavaPlugin() {

    override fun onEnable() {
        try {
            getCommand("customitems").setExecutor(CustomItemsCommand(this))
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
