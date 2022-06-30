package com.project.game;

import com.project.game.keys.Directions;

public class GameLogic {
    private Score score = new Score();
    private Tile tileObj = new Tile();
    private int numOfTurns = 0;
    private int gameBoardSize;
    private Tile board[][] = new Tile[gameBoardSize][gameBoardSize];

    public GameLogic(int matrixSize) {
        this.gameBoardSize = matrixSize;
    }

    public void gameTurn(Directions direction) {
        if (checkSameTilesInRow())
            tileObj.mergeWithPrev(direction);
        moveTiles();
        updateScore();
        if (checkEmptyBoxes())
            addRandomTile();
        numOfTurns++;

    }

    private void addRandomTile() {}

    private boolean checkSameTilesInRow() {
        for (int row = 0; row < gameBoardSize; row++) {
            for (int col = 0; col < gameBoardSize; col++) {
                if (board[row][col] == board[row][col + 1])
                    return true;
            }
        }
        return false;
    }

    private void moveTiles(){}
    private void updateScore(){}
    private boolean checkEmptyBoxes(){
        for (int row = 0; row < gameBoardSize; row++) {
            for (int col = 0; col < gameBoardSize; col++) {
                if (board[row][col] == null)
                    return true;
            }
        }
        return false;
    }
}
