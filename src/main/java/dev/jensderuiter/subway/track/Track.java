package dev.jensderuiter.subway.track;

import dev.jensderuiter.subway.util.Concrete;

import java.util.List;

public class Track {

    public String name;
    public List<PassingPoint> passingPoints;
    public float speed;
    public Concrete baseColor;
    public Concrete color;

    public Track(String name, List<PassingPoint> passingPoints, float speed, String baseColor, String color) {
        this.name = name;
        this.passingPoints = passingPoints;
        this.speed = speed;
        try {
            this.baseColor = Concrete.valueOf(baseColor);
        } catch (IllegalArgumentException e) {
            this.baseColor = Concrete.LIGHT_GRAY;
        }
        try {
            System.out.println(color);
            this.color = Concrete.valueOf(color);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.color = Concrete.LIGHT_GRAY;
        }
    }


}
