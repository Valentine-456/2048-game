package com.project.game;

import com.project.game.keys.Directions;

public class GameLogic {
    private Score score = new Score();
    private Tile tileObj = new Tile();
    private int gameBoardSize;
    private Tile board[][] = new Tile[gameBoardSize][gameBoardSize];

    public GameLogic(int matrixSize) {
        this.gameBoardSize = matrixSize;
    }

    public void gameTurn(Directions direction) {

    }
}
