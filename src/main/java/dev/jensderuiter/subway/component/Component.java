package dev.jensderuiter.subway.component;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

public interface Component {

    void move(Location location);
    ArmorStand getArmorStand();
    void tilt(double pitch, double yaw);
    void init(UUID uuid, Location location);

}
