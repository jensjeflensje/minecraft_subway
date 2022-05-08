package dev.jensderuiter.subway.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public enum Concrete {

    WHITE(0),
    ORANGE(1),
    MAGENTA(2),
    LIGHT_BLUE(3),
    YELLOW(4),
    LIME(5),
    PINK(6),
    GRAY(7),
    LIGHT_GRAY(8),
    CYAN(9),
    PURPLE(10),
    BLUE(11),
    BROWN(12),
    GREEN(13),
    RED(14),
    BLACK(15);

    public ItemStack item;

    Concrete(int color) {
        this.item = new ItemStack(Material.CONCRETE, 1, (short) color);
        MaterialData data = item.getData();
        data.setData((byte)color);
        this.item.setData(data);
    }

}
