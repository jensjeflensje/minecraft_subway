package dev.jensderuiter.subway.command;

import dev.jensderuiter.subway.type.Subway;
import dev.jensderuiter.subway.SubwayPlugin;
import dev.jensderuiter.subway.track.Track;
import dev.jensderuiter.subway.type.DefaultSubway;
import dev.jensderuiter.subway.util.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Set;

public class SubwayCommand implements CommandExecutor {

    private void sendHelp(Player player) {
        player.sendMessage("Subway commands:");
        player.sendMessage("/subway addpoint <track> [true|false]");
        player.sendMessage("/subway delpoint <track> <point_id>");
        player.sendMessage("/subway deltrack <track>");
        player.sendMessage("/subway settype <track> <subway_type>");
        player.sendMessage("/subway setspeed <track> <speed>");
        player.sendMessage("/subway setautospawn <track> <true|false>");
        player.sendMessage("/subway spawn <track>");
        player.sendMessage("/subway remove <track>");
    }

    private void sendNoPermission(Player player) {
        player.sendMessage("Subways - By Jens de Ruiter (jensjeflensje)");
        player.sendMessage("Copyright 2022, Licensed under the MIT License");
    }

    private void sendSuccess(Player player, String message) {
        player.sendMessage(ChatColor.GREEN + message);
    }

    private void sendError(Player player, String message) {
        player.sendMessage(ChatColor.RED + message);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("subway.admin")) {
                sendNoPermission(player);
                return true;
            }
            if (args.length <= 1) {
                sendHelp(player);
                return true;
            }
            Location location = player.getLocation();
            ConfigurationSection trackSection;
            switch (args[0].toLowerCase()) {
                case "addpoint":
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1] + ".points");
                    if (trackSection == null) {
                        trackSection = SubwayPlugin.instance.getConfig().createSection("tracks." + args[1] + ".points");
                        SubwayPlugin.instance.getConfig().set("tracks." + args[1] + ".type", "default");
                        SubwayPlugin.instance.getConfig().set("tracks." + args[1] + ".autospawn", false);
                        SubwayPlugin.instance.getConfig().set("tracks." + args[1] + ".speed", 0.2);
                    }

                    Set<String> keys = trackSection.getKeys(false);
                    int newKey = keys.size();
                    ConfigurationSection pointSection = trackSection.createSection(String.valueOf(newKey));
                    pointSection.set("x", location.getX());
                    pointSection.set("y", location.getY());
                    pointSection.set("z", location.getZ());
                    pointSection.set("world", location.getWorld().getName());
                    if (args.length == 3) {
                        pointSection.set("stop", Boolean.valueOf(args[2]));
                    } else {
                        pointSection.set("stop", false);
                    }

                    sendSuccess(player, "Point added with id " + newKey);
                    break;
                case "delpoint":
                    if (args.length != 3) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1] + ".points");
                    if (trackSection == null) {
                        sendError(player, "Track not found");
                        break;
                    }
                    trackSection.set(String.valueOf(args[2]), null);
                    sendSuccess(player, "Point deleted");
                    break;
                case "deltrack":
                    if (args.length != 2) {
                        sendHelp(player);
                        break;
                    }
                    SubwayPlugin.instance.getConfig().set("tracks." + args[1], null);
                    sendSuccess(player, "Track deleted");
                case "settype":
                    if (args.length != 3) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1]);
                    if (trackSection == null) {
                        sendError(player,"Track not found");
                        break;
                    }
                    trackSection.set("type", args[2]);
                    sendSuccess(player, "Type set");
                    break;
                case "setspeed":
                    if (args.length != 3) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1]);
                    if (trackSection == null) {
                        sendError(player, "Track not found");
                        break;
                    }
                    trackSection.set("speed", Float.valueOf(args[2]));
                    sendSuccess(player, "Speed set set");
                    break;
                case "setautospawn":
                    if (args.length != 3) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1]);
                    if (trackSection == null) {
                        sendError(player, "Track not found");
                        break;
                    }
                    trackSection.set("autospawn", Boolean.valueOf(args[2]));
                    sendSuccess(player, "Autospawn set");
                    break;
                case "spawn":
                    if (args.length != 2) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1]);
                    if (trackSection == null) {
                        sendError(player, "Track not found");
                        break;
                    }

                    Track track = Utils.getTrackFromConfig(args[1]);
                    if (track == null) {
                        sendError(player, "Track not found");
                        return true;
                    }

                    Subway subway = new DefaultSubway();
                    subway.summon(track.passingPoints.get(0).location);
                    subway.setTrack(track);
                    sendSuccess(player, "Subway spawned");
                    break;
                case "remove":
                    if (args.length != 2) {
                        sendHelp(player);
                        break;
                    }
                    trackSection = SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + args[1]);
                    if (trackSection == null) {
                        sendError(player, "Track not found");
                        break;
                    }
                    Utils.removeAllSubwaysFromTrack(args[1]);
                    sendSuccess(player, "All subways removed from track");
                    break;
                default:
                    sendHelp(player);
                    break;
            }

            SubwayPlugin.instance.saveConfig();
        }
        return true;
    }

}
