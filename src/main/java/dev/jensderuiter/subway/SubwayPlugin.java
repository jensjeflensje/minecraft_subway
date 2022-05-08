package dev.jensderuiter.subway;

import dev.jensderuiter.subway.command.SubwayCommand;
import dev.jensderuiter.subway.event.OnArmorStandPickup;
import dev.jensderuiter.subway.event.OnSubwaySeat;
import dev.jensderuiter.subway.track.Track;
import dev.jensderuiter.subway.type.DefaultSubway;
import dev.jensderuiter.subway.type.Subway;
import dev.jensderuiter.subway.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public final class SubwayPlugin extends JavaPlugin {

    public static HashMap<UUID, Subway> subwayMap = new HashMap<>();
    public static HashMap<String, Class<? extends Subway>> subwayTypeMap = new HashMap<>();
    public static SubwayPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        instance.saveDefaultConfig();

        // register commands and events
        getCommand("subway").setExecutor(new SubwayCommand());
        getServer().getPluginManager().registerEvents(new OnArmorStandPickup(), this);
        getServer().getPluginManager().registerEvents(new OnSubwaySeat(), this);

        // register subway types
        subwayTypeMap.put("default", DefaultSubway.class);

        // spawn all autospawn subways
        ConfigurationSection tracksSection = instance.getConfig().getConfigurationSection("tracks");
        for (String trackName : tracksSection.getKeys(false)) {
            if (tracksSection.getBoolean(trackName + ".autospawn")) {
                String subwayTypeName = tracksSection.getString(trackName + ".type");
                Class<? extends Subway> subwayType = Utils.getSubwayType(subwayTypeName);
                if (subwayType == null) {
                    Bukkit.getConsoleSender().sendMessage("Could not find subway type " + tracksSection + " for track " + trackName);
                    continue;
                }
                Track track = Utils.getTrackFromConfig(trackName);
                if (track == null) {
                    Bukkit.getConsoleSender().sendMessage("What? Data for track " + trackName + " is missing");
                    continue;
                }
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Utils.summonSubwayOnTrack(subwayType, track);
                    }
                }.runTaskLater(instance, 20);

            }
        }
    }

    @Override
    public void onDisable() {
        Utils.removeAllSubways();
    }
}
