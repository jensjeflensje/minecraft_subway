package dev.jensderuiter.subway.component;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

public class BaseComponent implements Component {

    private ArmorStand armorStand;
    private ItemStack item;
    private Offset offset;

    public BaseComponent(Material material, Offset offset) {
        this.item = new ItemStack(material);
        this.offset = offset;
    }

    public BaseComponent(ItemStack itemStack, Offset offset) {
        this.item = itemStack;
        this.offset = offset;
    }

    public void init(UUID uuid, Location location) {
        this.armorStand = location.getWorld().spawn(location, ArmorStand.class);
        this.armorStand.setBasePlate(false);
        this.armorStand.setVisible(false);
        this.armorStand.setInvulnerable(true);
        this.armorStand.setCanPickupItems(false);
        this.armorStand.setGravity(false);
        this.armorStand.setSmall(false);
        ItemMeta meta = this.item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        this.item.setItemMeta(meta);
        this.armorStand.setCustomName(uuid.toString());
        this.armorStand.setHelmet(this.item);
        this.armorStand.setMarker(false);
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

        this.armorStand.teleport(offsetLocation);
        this.armorStand.setGravity(false);


    }

    @Override
    public ArmorStand getArmorStand() {
        return this.armorStand;
    }

    @Override
    public void tilt(double pitch, double yaw) {
        getArmorStand().setHeadPose(new EulerAngle(Math.toRadians(pitch), 0, Math.toRadians(yaw)));
    }
}
