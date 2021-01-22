package ru.skillbox.catfarm.model;

import java.util.List;
import java.util.function.Supplier;

public enum CatStatus {

    SLEEPING,
    PLAYING,
    EXPLODED,
    DEAD;

    public static boolean isALive(CatStatus status) {
        return status == SLEEPING || status == PLAYING;
    }
}
