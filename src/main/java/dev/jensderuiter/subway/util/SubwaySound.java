package dev.jensderuiter.subway.util;

import org.bukkit.Sound;

public class SubwaySound {

    public Sound sound;
    public float duration;
    public float pitch;

    public SubwaySound(Sound sound, float duration, float pitch) {
        this.sound = sound;
        this.duration = duration;
        this.pitch = pitch;
    }
}
