package com.project.game;

import com.project.game.keys.Directions;

import java.util.Arrays;

public class GameLogic {
    private Score score = new Score();
    private int gameBoardSize;
    private Tile[][] board;

    public GameLogic(int matrixSize) {
        this.gameBoardSize = matrixSize;
        this.board = new Tile[gameBoardSize][gameBoardSize];
    }

    // TODO: gameTurn
    public void gameTurn(Directions direction) {
        if (checkSameTilesInRow())
//            tileObj.mergeWithPrev(direction);
        moveTiles();
        updateScore();
        if (checkEmptyBoxes())
            addRandomTile();

    }

    public void initGame() {
        for (Tile[] array: board) {
            Arrays.fill(array, null);
        }
        this.addRandomTile();
        this.addRandomTile();
        this.score.resetScore();
    }

    public Tile[][] getRenderMatrix() {
        return this.board;
    }

    // TODO: addRandomTile
    private void addRandomTile() {}
    // TODO: checkSameTilesInRow
    private boolean checkSameTilesInRow() {
        for (int row = 0; row < gameBoardSize; row++) {
            for (int col = 0; col < gameBoardSize; col++) {
                if (board[row][col] == board[row][col + 1])
                    return true;
            }
        }
        return false;
    }
    // TODO: moveTiles
    private void moveTiles(){}
    private void updateScore(){
        this.score.updateScoreAfterMove(0);
    }
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
