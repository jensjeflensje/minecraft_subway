package dev.jensderuiter.subway.component;

public class Offset {

    public float Y_MODIFIER = -1.3f;

    public double x;
    public double y;
    public double z;
    public float pitch;
    public float headPitch;
    public float yaw;
    public float headYaw;

    public Offset(double x, double y, double z) {
        this.x = x ;
        this.y = y - 1;
        this.z = z;
        this.pitch = 0;
        this.yaw = 0;
    }

    public Offset(double x, double y, double z, float pitch, float yaw) {
        this.x = x ;
        this.y = y + Y_MODIFIER;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Offset(double x, double y, double z, float pitch, float yaw, float headPitch, float headYaw) {
        this.x = x ;
        this.y = y + Y_MODIFIER;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.headPitch = headPitch;
        this.headYaw = headYaw;
    }

}
