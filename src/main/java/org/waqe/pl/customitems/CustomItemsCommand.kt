package org.waqe.pl.customitems

import com.sun.org.apache.xerces.internal.xs.StringList
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.bukkit.inventory.meta.ItemMeta
import org.waqe.pl.customitems.CustomItems
import java.lang.Exception

class CustomItemsCommand(private val plugin: CustomItems) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Command only for player use.")
            return true
        }
        val player = sender as Player
        if (!player.hasPermission("customitems.main")) {
            player.sendMessage("You need the permission: customitems.main")
            return true
        }
        if (args.size < 1) {
            player.sendMessage("You need to specify arguments.")
            return true
        }
        try {
            player.sendMessage("arguments sent = ${args.size}")
            if (args.get(0).equals("awesomesword", ignoreCase = true)) {
                if (!player.hasPermission("customitems.summon.sword")) {
                    player.sendMessage("You need the permission: customitems.summon.sword")
                }
                val awesomeSword = ItemStack(Material.DIAMOND_SWORD)
                val swordMeta = awesomeSword.itemMeta
                swordMeta.displayName = "Awesome Sword"
                val lore = ArrayList<String>()
                lore.add(" ")
                lore.add("This word does NOT break!")
                swordMeta.lore = lore
                swordMeta.isUnbreakable = true
                swordMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
                awesomeSword.itemMeta = swordMeta
                player.inventory.addItem(awesomeSword)
                player.sendMessage("You have been given the item " + args[0])
            } else {
                player.sendMessage("Not valid item.")
            }
        } catch(e: Exception) {
            e.printStackTrace()
        }

        return true
    }
}