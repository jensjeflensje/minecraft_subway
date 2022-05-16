package dev.jensderuiter.subway.type;

import dev.jensderuiter.subway.component.BaseComponent;
import dev.jensderuiter.subway.component.Offset;
import dev.jensderuiter.subway.component.SeatComponent;
import dev.jensderuiter.subway.util.Concrete;
import org.bukkit.Location;
import org.bukkit.Material;


public class DefaultSubway extends BaseSubway {


    @Override
    public String getName() {
        return "default";
    }

    @Override
    public void summon(Location location) {
        super.summon(location);

        // SEATS
        addComponent("seat1", new SeatComponent(new Offset(0, 1.3, 0.8, 0, 0)));
        addComponent("seat2", new SeatComponent(new Offset(0, 1.3, -0.1, 0, 0)));
        addComponent("seat3", new SeatComponent(new Offset(0, 1.3, -1, 0, 0)));
        addComponent("seat3", new SeatComponent(new Offset(0, 1.3, -1.8, 0, 0)));

        // THE OBJECT: front
        addComponent("front_base_1_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, 1.5, 0, 180)));
        addComponent("front_base_1_2", new BaseComponent(getColor().item, new Offset(-0.5, -0.13, 1.47, 0, 190)));
        addComponent("front_base_1_3", new BaseComponent(getColor().item, new Offset(0.5, -0.13, 1.47, 0, 170)));
        addComponent("front_base_2_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, 1.5, 0, 180)));
        addComponent("front_base_2_2", new BaseComponent(getColor().item, new Offset(-0.5, 1.7, 1.47, 0, 190)));
        addComponent("front_base_2_3", new BaseComponent(getColor().item, new Offset(0.5, 1.7, 1.47, 0, 170)));

        addComponent("front_glass_1_1", new BaseComponent(Material.THIN_GLASS, new Offset(0, 0, 1.5, 0, 180)));
        addComponent("front_glass_1_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.5, 0, 1.4, 0, 200)));
        addComponent("front_glass_1_3", new BaseComponent(Material.THIN_GLASS, new Offset(0.5, 0, 1.4, 0, 160)));
        addComponent("front_glass_2_1", new BaseComponent(Material.THIN_GLASS, new Offset(0, 0.6, 1.5, 0, 180)));
        addComponent("front_glass_2_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.5, 0.6, 1.4, 0, 200)));
        addComponent("front_glass_2_3", new BaseComponent(Material.THIN_GLASS, new Offset(0.5, 0.6, 1.4, 0, 160)));

        // THE OBJECT: top
        addComponent("electricity_beam_1_1", new BaseComponent(Material.STICK, new Offset(0.3, 2.2, 0.8, 0, 0, -30, -45)));
        addComponent("electricity_beam_1_2", new BaseComponent(Material.STICK, new Offset(-0.55, 2.6, -0.4, 0, -45, 90, 0)));
        addComponent("electricity_beam_2_1", new BaseComponent(Material.STICK, new Offset(0.3, 2.2, -0.8, 0, 0, -30, -45)));
        addComponent("electricity_beam_2_2", new BaseComponent(Material.STICK, new Offset(-0.55, 2.6, -2, 0, -45, 90, 0)));

        // THE OBJECT: sides
        addComponent("stepup_right", new BaseComponent(Material.STICK, new Offset(-0.45, -0.3, -1, 0, 45, 90, 0)));
        addComponent("stepup_left", new BaseComponent(Material.STICK, new Offset(1.45, -0.3, -1, 0, 45, 90, 0)));

        addComponent("left_glass_1_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, 1.3, 0, 270)));
        addComponent("left_glass_1_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, 1.3, 0, 270)));
        addComponent("left_glass_2_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, 0.7, 0, 270)));
        addComponent("left_glass_2_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, 0.7, 0, 270)));
        addComponent("left_glass_3_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, 0.1, 0, 270)));
        addComponent("left_glass_3_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, 0.1, 0, 270)));
        addComponent("left_glass_pole_1_1", new BaseComponent(Material.STICK, new Offset(-0.6, 0.2, 0.4, 0, 45, 0, -45)));
        addComponent("left_glass_pole_1_2", new BaseComponent(Material.STICK, new Offset(-0.6, 0.8, 0.4, 0, 45, 0, -45)));
        addComponent("left_glass_pole_2_1", new BaseComponent(Material.STICK, new Offset(-0.6, 0.2, -0.3, 0, 45, 0, -45)));
        addComponent("left_glass_pole_2_2", new BaseComponent(Material.STICK, new Offset(-0.6, 0.8, -0.3, 0, 45, 0, -45)));
        addComponent("left_glass_4_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, -0.5, 0, 270)));
        addComponent("left_glass_4_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, -0.5, 0, 270)));
        addComponent("left_glass_5_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, -1.1, 0, 270)));
        addComponent("left_glass_5_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, -1.1, 0, 270)));
        addComponent("left_glass_6_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, -1.7, 0, 270)));
        addComponent("left_glass_6_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, -1.7, 0, 270)));
        addComponent("left_glass_7_1", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, -2.3, 0, 270)));
        addComponent("left_glass_7_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, -2.3, 0, 270)));

        addComponent("right_glass_1_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, 1.3, 0, 90)));
        addComponent("right_glass_1_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, 1.3, 0, 90)));
        addComponent("right_glass_2_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, 0.7, 0, 90)));
        addComponent("right_glass_2_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, 0.7, 0, 90)));
        addComponent("right_glass_3_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, 0.1, 0, 90)));
        addComponent("right_glass_3_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, 0.1, 0, 90)));
        addComponent("right_glass_pole_1_1", new BaseComponent(Material.STICK, new Offset(0.85, 0.2, 0.4, 0, 45, 0, -45)));
        addComponent("right_glass_pole_1_2", new BaseComponent(Material.STICK, new Offset(0.85, 0.8, 0.4, 0, 45, 0, -45)));
        addComponent("right_glass_pole_2_1", new BaseComponent(Material.STICK, new Offset(0.85, 0.2, -0.3, 0, 45, 0, -45)));
        addComponent("right_glass_pole_2_2", new BaseComponent(Material.STICK, new Offset(0.85, 0.8, -0.3, 0, 45, 0, -45)));
        addComponent("right_glass_4_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, -0.5, 0, 90)));
        addComponent("right_glass_4_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, -0.5, 0, 90)));
        addComponent("right_glass_5_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, -1.1, 0, 90)));
        addComponent("right_glass_5_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, -1.1, 0, 90)));
        addComponent("right_glass_6_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, -1.7, 0, 90)));
        addComponent("right_glass_6_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, -1.7, 0, 90)));
        addComponent("right_glass_7_1", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, -2.3, 0, 90)));
        addComponent("right_glass_7_2", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, -2.3, 0, 90)));

        // THE OBJECT: base
        addComponent("middle_base_1_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, 1.4, 0, 180)));
        addComponent("middle_base_1_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, 1.4, 0, 180)));
        addComponent("middle_base_1_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, 1.4, 0, 180)));
        addComponent("middle_base_2_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, 0.9, 0, 180)));
        addComponent("middle_base_2_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, 0.9, 0, 180)));
        addComponent("middle_base_2_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, 0.9, 0, 180)));
        addComponent("middle_base_3_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, 0.4, 0, 180)));
        addComponent("middle_base_3_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, 0.4, 0, 180)));
        addComponent("middle_base_3_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, 0.4, 0, 180)));
        addComponent("middle_base_4_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -0.1, 0, 180)));
        addComponent("middle_base_4_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -0.1, 0, 180)));
        addComponent("middle_base_4_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -0.1, 0, 180)));
        addComponent("middle_base_5_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -0.6, 0, 180)));
        addComponent("middle_base_5_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -0.6, 0, 180)));
        addComponent("middle_base_5_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -0.6, 0, 180)));
        addComponent("middle_base_6_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -1.1, 0, 180)));
        addComponent("middle_base_6_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -1.1, 0, 180)));
        addComponent("middle_base_6_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -1.1, 0, 180)));
        addComponent("middle_base_7_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -1.6, 0, 180)));
        addComponent("middle_base_7_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -1.6, 0, 180)));
        addComponent("middle_base_7_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -1.6, 0, 180)));
        addComponent("middle_base_8_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -2.1, 0, 180)));
        addComponent("middle_base_8_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -2.1, 0, 180)));
        addComponent("middle_base_8_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -2.1, 0, 180)));
        addComponent("middle_base_9_1", new BaseComponent(getBaseColor().item, new Offset(0, -0.13, -2.6, 0, 180)));
        addComponent("middle_base_9_2", new BaseComponent(getColor().item, new Offset(-0.6, -0.13, -2.6, 0, 180)));
        addComponent("middle_base_9_3", new BaseComponent(getColor().item, new Offset(0.6, -0.13, -2.6, 0, 180)));

        addComponent("middle_top_1_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, 1.4, 0, 180)));
        addComponent("middle_top_1_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, 1.4, 0, 180)));
        addComponent("middle_top_1_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, 1.4, 0, 180)));
        addComponent("middle_top_2_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, 0.9, 0, 180)));
        addComponent("middle_top_2_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, 0.9, 0, 180)));
        addComponent("middle_top_2_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, 0.9, 0, 180)));
        addComponent("middle_top_3_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, 0.4, 0, 180)));
        addComponent("middle_top_3_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, 0.4, 0, 180)));
        addComponent("middle_top_3_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, 0.4, 0, 180)));
        addComponent("middle_top_4_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -0.1, 0, 180)));
        addComponent("middle_top_4_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -0.1, 0, 180)));
        addComponent("middle_top_4_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -0.1, 0, 180)));
        addComponent("middle_top_5_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -0.6, 0, 180)));
        addComponent("middle_top_5_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -0.6, 0, 180)));
        addComponent("middle_top_5_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -0.6, 0, 180)));
        addComponent("middle_top_6_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -1.1, 0, 180)));
        addComponent("middle_top_6_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -1.1, 0, 180)));
        addComponent("middle_top_6_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -1.1, 0, 180)));
        addComponent("middle_top_7_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -1.6, 0, 180)));
        addComponent("middle_top_7_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -1.6, 0, 180)));
        addComponent("middle_top_7_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -1.6, 0, 180)));
        addComponent("middle_top_8_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -2.1, 0, 180)));
        addComponent("middle_top_8_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -2.1, 0, 180)));
        addComponent("middle_top_8_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -2.1, 0, 180)));
        addComponent("middle_top_9_1", new BaseComponent(getBaseColor().item, new Offset(0, 1.7, -2.6, 0, 180)));
        addComponent("middle_top_9_2", new BaseComponent(getColor().item, new Offset(-0.6, 1.7, -2.6, 0, 180)));
        addComponent("middle_top_9_3", new BaseComponent(getColor().item, new Offset(0.6, 1.7, -2.6, 0, 180)));

        // THE OBJECT: back
        addComponent("back_glass_1_1", new BaseComponent(Material.THIN_GLASS, new Offset(0, 0, -2.9, 0, 180)));
        addComponent("back_glass_1_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0, -2.9, 0, 180)));
        addComponent("back_glass_1_3", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0, -2.9, 0, 180)));
        addComponent("back_glass_2_1", new BaseComponent(Material.THIN_GLASS, new Offset(0, 0.6, -2.9, 0, 180)));
        addComponent("back_glass_2_2", new BaseComponent(Material.THIN_GLASS, new Offset(-0.6, 0.6, -2.9, 0, 180)));
        addComponent("back_glass_2_3", new BaseComponent(Material.THIN_GLASS, new Offset(0.6, 0.6, -2.9, 0, 180)));
    }

}
