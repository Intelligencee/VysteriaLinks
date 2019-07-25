package org.vysteria.links;

import org.bukkit.plugin.java.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.md_5.bungee.api.chat.*;

public class VysteriaLinks extends JavaPlugin {

    public void onEnable() {
        Bukkit.getServer().getLogger().info("VysteriaLinks v" + this.getDescription().getVersion());
    }

    public void onDisable() {
        Bukkit.getServer().getLogger().info("VysteriaLinks v" + this.getDescription().getVersion());
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] arg) {
        if (cmd.getName().equalsIgnoreCase("links") && sender instanceof Player) {
            final Player p = (Player)sender;
            for (final String msg : this.getConfig().getStringList("help")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }

        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("twitter")) {
            final TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3&l[!] &bClick me to view the link to our twitter!"));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://twitter.com/VysteriaMC"));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Click me to visit our twitter!").create()));
            p.spigot().sendMessage((BaseComponent)tc);
        }
        if (cmd.getName().equalsIgnoreCase("discord")) {
            final TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3&l[!] &bClick me to view the link to our discord!"));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/FNQ2grW"));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Click me to visit our discord server!").create()));
            p.spigot().sendMessage((BaseComponent)tc);
        }
        if (cmd.getName().equalsIgnoreCase("website")) {
            final TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&3&l[!] &bClick me to view the link to our forums!"));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.vysteria.org"));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Click me to visit our forums!").create()));
            p.spigot().sendMessage((BaseComponent)tc);
        }
        return true;
    }
}
