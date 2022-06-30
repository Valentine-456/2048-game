package com.project.game;

import com.project.game.keys.Directions;

public class Tile {
    private int value;

    public Tile(int value) {
        this.value = value;
    }
    public Tile() {}

    public int mergeWithPrev(Directions direction) {
        int newValue = 0;

        return newValue;
    }

    public int getValue() {
        return value;
    }
}
