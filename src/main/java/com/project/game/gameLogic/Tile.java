package com.project.game.gameLogic;


import java.util.Random;

public class Tile {
    public static Tile generateRandomNewTile() {
        Random random = new Random();
        int probabilityOfRandomTile = random.nextInt(10 + 1);
        if (probabilityOfRandomTile > 8) return new Tile(4);
        return new Tile(2);
    }

    private int value;

    public Tile(int value) {
        this.value = value;
    }

    public int mergeWithPrev() {
        this.value = this.value * 2;
        return this.value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Tile{" +
                value +
                '}';
    }

}
