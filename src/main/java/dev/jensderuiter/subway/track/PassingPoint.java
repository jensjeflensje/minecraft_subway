package dev.jensderuiter.subway.track;

import org.bukkit.Location;

import java.util.List;

public class PassingPoint {

    public boolean stop;
    public Location location;

    public PassingPoint(boolean stop, Location location) {
        this.stop = stop;
        this.location = location;
    }

}
