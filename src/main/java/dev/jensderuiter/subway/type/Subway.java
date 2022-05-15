package dev.jensderuiter.subway.type;

import dev.jensderuiter.subway.component.Component;
import dev.jensderuiter.subway.track.PassingPoint;
import dev.jensderuiter.subway.track.Track;
import dev.jensderuiter.subway.util.Concrete;
import dev.jensderuiter.subway.util.SubwaySound;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public interface Subway {

    String getName();

    float getSpeed();
    void setSpeed(float speed);

    void setBaseColor(Concrete color);
    void setColor(Concrete color);
    Concrete getColor();
    Concrete getBaseColor();

    SubwaySound getSound();

    PassingPoint getNextPoint();
    void setNextPoint(PassingPoint location);

    void summon(Location location);
    void destroy();
    Track getTrack();
    void setTrack(Track track);
    void move(Location location);
    void tick();

    void addComponent(String name, Component component);
    void moveComponents(Location location);
    boolean takeSeat(Player player);

    Component getComponent(String name);
    void addTask(BukkitTask name);



}
