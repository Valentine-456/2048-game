package com.project.game;

import com.project.game.keys.Directions;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//      Test since the game crashes after 2-3 game turns:

        GameLogic gameLogic = new GameLogic(4);
        gameLogic.initGame();


        gameLogic.board = new Tile[][] {
                {new Tile(64), null, new Tile(8), new Tile(8)},
                {null, new Tile(32), new Tile(32), new Tile(4)},
                {new Tile(32), new Tile(32), new Tile(4), null},
                {null, new Tile(32), null, null}
        };
//        System.out.println(Arrays.deepToString(gameLogic.board));
//        System.out.println(Arrays.deepToString(UtilsFunctions.transposeMatrix(UtilsFunctions.transposeMatrix(gameLogic.board))));
        gameLogic.gameTurn(Directions.DOWN);
        gameLogic.gameTurn(Directions.RIGHT);
        gameLogic.gameTurn(Directions.LEFT);
        gameLogic.gameTurn(Directions.UP);
        gameLogic.gameTurn(Directions.RIGHT);
        gameLogic.gameTurn(Directions.DOWN);
        System.out.println(Arrays.deepToString(gameLogic.board));
        System.out.println(gameLogic.score.getScore());
        System.out.println(gameLogic.score.getNumOfSteps());
    }
}
