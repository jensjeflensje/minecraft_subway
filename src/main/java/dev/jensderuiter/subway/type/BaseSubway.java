package dev.jensderuiter.subway.type;

import dev.jensderuiter.subway.SubwayPlugin;
import dev.jensderuiter.subway.component.Component;
import dev.jensderuiter.subway.component.SeatComponent;
import dev.jensderuiter.subway.runner.SubwayRunner;
import dev.jensderuiter.subway.track.PassingPoint;
import dev.jensderuiter.subway.track.Track;
import dev.jensderuiter.subway.util.Concrete;
import dev.jensderuiter.subway.util.SubwaySound;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public abstract class BaseSubway implements Subway {

    public Location location;
    public PassingPoint nextPoint;
    public Track track;
    public UUID uuid;
    public HashMap<String, Component> components = new HashMap<>();
    List<BukkitTask> tasks = new ArrayList<>();
    public float speed = 0.2f;

    public Concrete color = Concrete.GRAY;
    public Concrete baseColor = Concrete.GRAY;

    @Override
    public void summon(Location location) {
        this.location = location;
        uuid = UUID.randomUUID();
        SubwayPlugin.subwayMap.put(uuid, this);
    }

    public void setColor(Concrete color) {
        this.color = color;
    }

    public Concrete getColor() {
        return color;
    }

    public void setBaseColor(Concrete color) {
        this.baseColor = color;
    }

    public Concrete getBaseColor() {
        return baseColor;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void setTrack(Track track) {
        this.track = track;
        BukkitTask runnable = new SubwayRunner(this, location).runTaskTimer(
                SubwayPlugin.getPlugin(SubwayPlugin.class), 0, 1);
        addTask(runnable);
    }

    @Override
    public Track getTrack() {
        return this.track;
    }

    @Override
    public SubwaySound getSound() {
        return new SubwaySound(Sound.ENTITY_MINECART_INSIDE, 5f, 0) ;
    }

    @Override
    public PassingPoint getNextPoint() {
        return this.nextPoint;
    }

    @Override
    public void setNextPoint(PassingPoint nextPoint) {
        this.nextPoint = nextPoint;
    }

    @Override
    public void addTask(BukkitTask task) {
        tasks.add(task);
    }

    public void addComponent(String name, Component component) {
        component.init(this.uuid, this.location);
        components.put(name, component) ;
    }

    public void moveComponents(Location location) {
        components.forEach((key, value) -> {
            value.move(location);
        });
    }

    public Component getComponent(String name) {
        return components.get(name);
    }

    @Override
    public boolean takeSeat(Player player) {
        for (Map.Entry<String, Component> entry : components.entrySet()) {
            Component component = entry.getValue();
            if (component instanceof SeatComponent) {
                SeatComponent seat = (SeatComponent) component;
                if (seat.getPassenger() == player) {
                    return true;
                }
            }
        }
        for (Map.Entry<String, Component> entry : components.entrySet()) {
            Component component = entry.getValue();
            if (component instanceof SeatComponent) {
                SeatComponent seat = (SeatComponent) component;
                if (seat.isTaken()) continue;
                seat.setPassenger(player);
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        for (Component component : components.values()) {
            component.getArmorStand().remove();
        }
        for (BukkitTask task : tasks) {
            task.cancel();
        }
    }

    public void tick() {
        moveComponents(this.location);
    }

    @Override
    public void move(Location location) {
        this.location = location;
        tick();
    }

}
