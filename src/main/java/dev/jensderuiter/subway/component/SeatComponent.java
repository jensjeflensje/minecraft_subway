package dev.jensderuiter.subway.component;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.UUID;

public class SeatComponent implements Component {

    private ArmorStand armorStand;
    private Offset offset;

    public SeatComponent(Offset offset) {
        this.offset = offset;
    }

    public void init(UUID uuid, Location location) {
        this.armorStand = location.getWorld().spawn(location, ArmorStand.class);
        this.armorStand.setBasePlate(false);
        this.armorStand.setVisible(false);
        this.armorStand.setInvulnerable(true);
        this.armorStand.setCanPickupItems(false);
        this.armorStand.setGravity(true);
        this.armorStand.setSmall(true);
        this.armorStand.setMarker(true);
        this.armorStand.setCustomName(uuid.toString());
        move(location);
    }

    @Override
    public void move(Location location) {
        Location offsetLocation = location.clone();
        double sinus = Math.sin(location.getYaw() / 180 * Math.PI);
        double cosinus = Math.cos(location.getYaw() / 180 * Math.PI);
        double newX = this.offset.x * cosinus - this.offset.z * sinus;
        double newZ = this.offset.z * cosinus + this.offset.x * sinus;
        offsetLocation.add(newX, this.offset.y, newZ);
        offsetLocation.setYaw(location.getYaw() + this.offset.yaw);
        offsetLocation.setPitch(this.offset.pitch);
        if (this.offset.headPitch != 0 || this.offset.headYaw != 0) this.armorStand.setHeadPose(new EulerAngle(Math.toRadians(this.offset.headPitch), 0, Math.toRadians(this.offset.headYaw)));

        Vector vector = offsetLocation.toVector().subtract(this.armorStand.getLocation().toVector());
        this.armorStand.setVelocity(vector);


    }

    @Override
    public ArmorStand getArmorStand() {
        return this.armorStand;
    }

    @Override
    public void tilt(double pitch, double yaw) {
        getArmorStand().setHeadPose(new EulerAngle(Math.toRadians(pitch), 0, Math.toRadians(yaw)));
    }

    public boolean isTaken() {
        return this.armorStand.getPassengers().size() >= 1;
    }

    public Player getPassenger() {
        if (this.armorStand.getPassengers().size() >= 1) {
            return (Player) this.armorStand.getPassengers().get(0);
        }
        return null;
    }

    public void setPassenger(Player passenger) {
        this.armorStand.eject();
        this.armorStand.addPassenger(passenger);
    }
}
