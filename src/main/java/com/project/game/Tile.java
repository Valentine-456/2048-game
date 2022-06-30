package com.project.game;

import com.project.game.keys.Directions;

import java.util.Random;

public class Tile {
    public static Tile generateRandomNewTile () {
        Random random = new Random();
        int probabilityOfRandomTile = random.nextInt(10 + 1);
        if(probabilityOfRandomTile > 8) return new Tile(4);
        return new Tile(2);
    }

    private int value;

    public Tile(int value) {
        this.value = value;
    }

    // TODO: mergeWithPrev
    public int mergeWithPrev(Directions direction) {
        int newValue = 0;

        return newValue;
    }

    public int getValue() {
        return value;
    }
}
