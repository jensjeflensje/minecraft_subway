package dev.jensderuiter.subway.util;

import dev.jensderuiter.subway.type.Subway;
import dev.jensderuiter.subway.SubwayPlugin;
import dev.jensderuiter.subway.track.PassingPoint;
import dev.jensderuiter.subway.track.Track;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Utils {

    public static void summonSubwayOnTrack(Class<? extends Subway> subwayType, Track track) {
        try {
            Subway subway = subwayType.getConstructor().newInstance();
            subway.setColor(track.color);
            subway.setBaseColor(track.baseColor);
            subway.summon(track.passingPoints.get(0).location);
            subway.setSpeed(track.speed);
            subway.setTrack(track);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeAllSubwaysFromTrack(String trackName) {
        for (Map.Entry<UUID, Subway> entry : SubwayPlugin.subwayMap.entrySet()) {
            Subway subway = entry.getValue();
            if (subway.getTrack().name.equals(trackName)) {
                subway.destroy();
            }
        }
    }

    public static void removeAllSubways() {
        for (Map.Entry<UUID, Subway> entry : SubwayPlugin.subwayMap.entrySet()) {
            Subway subway = entry.getValue();
            subway.destroy();
        }
    }

    public static Class<? extends Subway> getSubwayType(String subwayType) {
        return SubwayPlugin.subwayTypeMap.get(subwayType);
    }

    public static Track getTrackFromConfig(String track) {
        ConfigurationSection trackSection =  SubwayPlugin.instance.getConfig().getConfigurationSection("tracks." + track);
        if (trackSection == null) {
            return null;
        }
        List<PassingPoint> passingPoints = new ArrayList<>();
        for (String pointKey : trackSection.getConfigurationSection("points").getKeys(false)) {
            ConfigurationSection point = trackSection.getConfigurationSection("points." + pointKey);
            Location location = new Location(
                    SubwayPlugin.instance.getServer().getWorld(point.getString("world")),
                    point.getDouble("x"),
                    point.getDouble("y"),
                    point.getDouble("z")
            );
            passingPoints.add(new PassingPoint(point.getBoolean("stop"), location));
        }
        return new Track(
                track,
                passingPoints,
                (float) trackSection.getDouble("speed"),
                trackSection.getString("basecolor", ""),
                trackSection.getString("color", "")
        );
    }

}
