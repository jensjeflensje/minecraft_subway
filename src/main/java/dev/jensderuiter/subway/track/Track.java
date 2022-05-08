package dev.jensderuiter.subway.track;

import java.util.List;

public class Track {

    public String name;
    public List<PassingPoint> passingPoints;
    public float speed;

    public Track(String name, List<PassingPoint> passingPoints, float speed) {
        this.name = name;
        this.passingPoints = passingPoints;
        this.speed = speed;
    }


}
