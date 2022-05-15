package dev.jensderuiter.subway.runner;

import dev.jensderuiter.subway.track.PassingPoint;
import dev.jensderuiter.subway.type.Subway;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SubwayRunner extends BukkitRunnable {

    private Subway subway;
    private PassingPoint lastPoint;
    private Vector lastVector;
    private int countSameVector = 0;
    private int index = 1;
    private int STOPTICKS = 100;
    private float TURNSPEED = 3.5f;
    private int stopTicks = 100;
    private boolean stopped = false;
    private float soundTotalTicks;
    private float soundTicks = -1;
    private float aimedYaw = 0;
    private float currentYaw = -420;

    public SubwayRunner(Subway subway, Location location) {
        this.subway = subway;
        this.TURNSPEED = this.TURNSPEED + (this.subway.getSpeed() * 7);
        this.lastPoint = new PassingPoint(false, location);
    }

    @Override
    public void run() {
        if (soundTicks == -1) {
            soundTotalTicks = subway.getSound().duration * 20;
            playRidingSound();
        }

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
                playStopSound();
            }
            if (!this.stopped) {
                this.index++;
                if (this.index == subway.getTrack().passingPoints.size()) this.index = 1;
                this.lastPoint.stop = nextPoint.stop;
                nextPoint = subway.getTrack().passingPoints.get(this.index);
                subway.setNextPoint(nextPoint);
            }

        }

        soundTicks++;
        if (soundTicks >= soundTotalTicks) {
            playRidingSound();
            soundTicks = 0;
        }

        if (!this.stopped) {
            Vector vector = nextPoint.location.toVector().subtract(lastPoint.location.toVector());

            this.aimedYaw = (float) (Math.atan2(vector.getZ(), vector.getX()) * 180 / Math.PI) - 90;
            if (this.currentYaw == -420) this.currentYaw = aimedYaw;
            if (this.currentYaw + TURNSPEED < aimedYaw) {
                this.currentYaw += TURNSPEED;
            } else if (this.currentYaw - TURNSPEED > aimedYaw) {
                this.currentYaw -= TURNSPEED;
            }

            float yawDiff = Math.abs(Math.abs(this.currentYaw) - Math.abs(this.aimedYaw));
            System.out.println(yawDiff);
            if (yawDiff > TURNSPEED * 10) {
                this.currentYaw = aimedYaw;
            }

            // make the subway turn straight on straight movement
            if (this.lastVector != null && this.lastVector.normalize().equals(vector.normalize())) {
                this.countSameVector++;
                if (this.countSameVector >= 20) {
                    this.currentYaw = aimedYaw;
                }
            } else {
                this.countSameVector = 0;
            }

            this.lastPoint.location.setYaw(this.currentYaw);

            this.lastPoint.location = lastPoint.location.add(vector.normalize().multiply(subway.getSpeed()));
            this.lastVector = vector;

        }
        this.subway.move(this.lastPoint.location);
    }

    private void playRidingSound() {
        this.lastPoint.location.getWorld().playSound(this.lastPoint.location, subway.getSound().sound, 0.05f, subway.getSound().pitch);
    }

    private void playStopSound() {
        this.lastPoint.location.getWorld().playSound(this.lastPoint.location, Sound.BLOCK_ANVIL_PLACE, 0.4f, 0);
    }
}
