package dev.jensderuiter.subway.runner;

import dev.jensderuiter.subway.track.PassingPoint;
import dev.jensderuiter.subway.type.Subway;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SubwayRunner extends BukkitRunnable {

    private Subway subway;
    private PassingPoint lastPoint;
    private int index = 1;
    private int STOPTICKS = 100;
    private int stopTicks = 100;
    private boolean stopped = false;

    public SubwayRunner(Subway subway, Location location) {
        this.subway = subway;
        this.lastPoint = new PassingPoint(false, location);
    }

    @Override
    public void run() {
        PassingPoint nextPoint = subway.getNextPoint();
        if (nextPoint == null) {
            nextPoint = subway.getTrack().passingPoints.get(this.index);
            subway.setNextPoint(subway.getTrack().passingPoints.get(this.index));
        } else if (this.lastPoint.location.distance(nextPoint.location) < subway.getSpeed()) {
            if (this.stopped) {
                this.stopTicks--;
                if (this.stopTicks == 0) {
                    this.stopped = false;
                }
            } else if (nextPoint.stop) {
                this.stopTicks = STOPTICKS;
                this.stopped = true;
            }
            if (!this.stopped) {
                this.index++;
                if (this.index == subway.getTrack().passingPoints.size()) this.index = 1;
                this.lastPoint.stop = nextPoint.stop;
                nextPoint = subway.getTrack().passingPoints.get(this.index);
                subway.setNextPoint(nextPoint);
            }

        }
        if (!this.stopped) {
            Vector vector = nextPoint.location.toVector().subtract(lastPoint.location.toVector());
            this.lastPoint.location = lastPoint.location.add(vector.normalize().multiply(subway.getSpeed()));
            this.lastPoint.location.setYaw((float) (Math.atan2(vector.getZ(), vector.getX()) * 180 / Math.PI) - 90);
        }
        this.subway.move(this.lastPoint.location);
    }
}