package com.project.game;

import com.project.game.keys.Directions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    public Score score = new Score();
    private int gameBoardSize;
    public Tile[][] board;

    public GameLogic(int matrixSize) {
        this.gameBoardSize = matrixSize;
        this.board = new Tile[gameBoardSize][gameBoardSize];
    }

    // TODO: gameTurn
    public void gameTurn(Directions direction) {
        int scoreIncrement = mergeTiles(direction);
        moveTiles(direction);
        updateScore(scoreIncrement);
        if (checkEmptyBoxes())
            addRandomTile();

    }

    private int mergeTiles(Directions direction) {
        ArrayList<ArrayList<Tile>> duplicates = getTheSameTile(direction);
        ArrayList<Tile> tiles = UtilsFunctions.flattenListOfListsImperatively(duplicates);
        int scoreIncrementAfterTurn = 0;

        for (Tile tile : tiles) {
            scoreIncrementAfterTurn += (tile.getValue()*2);
            for (int row = 0; row < getRenderMatrix().length; row++) {
                for (int col = 0; col < getRenderMatrix().length; col++) {
                    if (board[row][col] == tile)
                        board[row][col] = null;
                }
            }
        }

        return scoreIncrementAfterTurn;
    }

    public void initGame() {
        for (Tile[] array : board) {
            Arrays.fill(array, null);
        }
        this.addRandomTile();
        this.addRandomTile();
        this.score.resetScore();
    }

    public Tile[][] getRenderMatrix() {
        return this.board;
    }

    private void addRandomTile() {
        ArrayList<int[]> emptyCells = new ArrayList<>();

        for (int i = 0; i < this.gameBoardSize; i++) {
            for (int j = 0; j < this.gameBoardSize; j++) {
                if (this.board[i][j] == null)
                    emptyCells.add(new int[]{i, j});
            }
        }

        Random random = new Random();
        if(emptyCells.size() > 0) {
            int randomEmptyCell = random.nextInt(emptyCells.size());
            int[] emptyCoordinates = emptyCells.get(randomEmptyCell);
            int i = emptyCoordinates[0];
            int j = emptyCoordinates[1];
            this.board[i][j] = Tile.generateRandomNewTile();
        }
    }

    public ArrayList<ArrayList<Tile>> getTheSameTile(Directions direction) {
        Tile tileToFind = null;
        ArrayList<ArrayList<Tile>> tilesToMergeList = new ArrayList<>();
        for (int i = 0; i < getRenderMatrix().length; i++)
            tilesToMergeList.add(new ArrayList<>());
        switch (direction) {
            case RIGHT -> getTheSameTileRight(tileToFind, tilesToMergeList);
            case LEFT -> getTheSameTileLeft(tileToFind, tilesToMergeList);
            case UP -> getTheSameTileUp(tileToFind, tilesToMergeList);
            case DOWN -> getTheSameTileDown(tileToFind, tilesToMergeList);
        }
        return tilesToMergeList;
    }

    private ArrayList<ArrayList<Tile>> getTheSameTileLeft(Tile tileToFind, ArrayList<ArrayList<Tile>> tilesToMergeList) {
        for (int row = 0; row < getRenderMatrix().length; row++) {
            int col = 0;
            while (board[row][col] == null)
                col++;
            tileToFind = board[row][col];
            for (col = 0; col < getRenderMatrix().length; col++) {
                if (board[row][col] != null && tileToFind != null) {
                    if (board[row][col].getValue() == tileToFind.getValue() && board[row][col] != tileToFind) {
                        tilesToMergeList.get(row).add(board[row][col]);
                        tileToFind.mergeWithPrev();
                        if (col != getRenderMatrix().length - 1)
                            tileToFind = board[row][col + 1];
                    } else if (board[row][col].getValue() != tileToFind.getValue() && board[row][col] != null)
                        tileToFind = board[row][col];
                }
            }
        }
        return tilesToMergeList;
    }

    private ArrayList<ArrayList<Tile>> getTheSameTileRight(Tile tileToFind, ArrayList<ArrayList<Tile>> tilesToMergeList) {
        for (int row = 0; row < getRenderMatrix().length; row++) {
            int col = getRenderMatrix().length - 1;
            while (board[row][col] == null)
                col--;
            tileToFind = board[row][col];

            for (col = getRenderMatrix().length - 1; col > -1; col--) {

                if (board[row][col] != null && tileToFind != null) {
                    if (board[row][col] != tileToFind && board[row][col].getValue() == tileToFind.getValue()) {
                        tilesToMergeList.get(row).add(board[row][col]);
                        tileToFind.mergeWithPrev();
                        if (col != 0)
                            tileToFind = board[row][col - 1];
                    } else if (board[row][col].getValue() != tileToFind.getValue() && board[row][col] != null)
                        tileToFind = board[row][col];
                }
            }
        }
        return tilesToMergeList;
    }

    private ArrayList<ArrayList<Tile>> getTheSameTileUp(Tile tileToFind, ArrayList<ArrayList<Tile>> tilesToMergeList) {
        Tile[][] newMatrix = new Tile[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            Tile[] newRow = new Tile[board.length];
            for (int j = 0; j < board.length; j++)
                newRow[j] = board[j][i];
            newMatrix[i] = newRow;
        }
        for (int row = 0; row < getRenderMatrix().length; row++) {
            int col = 0;
            while (newMatrix[row][col] == null)
                col++;
            tileToFind = newMatrix[row][col];
            for (col = 0; col < getRenderMatrix().length; col++) {
                if (newMatrix[row][col] != null && tileToFind != null) {
                    if (newMatrix[row][col].getValue() == tileToFind.getValue() && newMatrix[row][col] != tileToFind) {
                        tilesToMergeList.get(row).add(newMatrix[row][col]);
                        tileToFind.mergeWithPrev();
                        if (col != getRenderMatrix().length - 1)
                            tileToFind = newMatrix[row][col + 1];
                    } else if (newMatrix[row][col].getValue() != tileToFind.getValue() && newMatrix[row][col] != null)
                        tileToFind = newMatrix[row][col];
                }
            }
        }
        return tilesToMergeList;
    }

    private ArrayList<ArrayList<Tile>> getTheSameTileDown(Tile tileToFind, ArrayList<ArrayList<Tile>> tilesToMergeList) {
        Tile[][] newMatrix = new Tile[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            Tile[] newRow = new Tile[board.length];
            for (int j = 0; j < board.length; j++)
                newRow[j] = board[j][i];
            newMatrix[i] = newRow;
        }
        for (int row = 0; row < getRenderMatrix().length; row++) {
            int col = getRenderMatrix().length - 1;
            while (newMatrix[row][col] == null)
                col--;
            tileToFind = newMatrix[row][col];

            for (col = getRenderMatrix().length - 1; col > -1; col--) {

                if (newMatrix[row][col] != null && tileToFind != null) {
                    if (newMatrix[row][col] != tileToFind && newMatrix[row][col].getValue() == tileToFind.getValue()) {
                        tilesToMergeList.get(row).add(newMatrix[row][col]);
                        tileToFind.mergeWithPrev();
                        if (col != 0)
                            tileToFind = newMatrix[row][col - 1];
                    } else if (newMatrix[row][col].getValue() != tileToFind.getValue() && newMatrix[row][col] != null)
                        tileToFind = newMatrix[row][col];
                }
            }
        }
        return tilesToMergeList;
    }

    private void moveTiles(Directions direction){
        ArrayList<ArrayList<Tile>> notNullTiles = new ArrayList<>();
        for (int i = 0; i < getRenderMatrix().length; i++){
            ArrayList<Tile> notNullRow = new ArrayList<>();
            for (int j = 0; j < getRenderMatrix().length; j++) {
                if(this.board[i][j] != null)
                    notNullRow.add(this.board[i][j]);
            }
            notNullTiles.add(notNullRow);
        }

        switch (direction) {
            case RIGHT -> this.board = this.moveTilesRight(notNullTiles);
            case LEFT -> this.board = this.moveTilesLeft(notNullTiles);
            case UP -> this.board = this.moveTilesUp(this.board);
            case DOWN -> this.board = this.moveTilesDown(this.board);
        }
    }

    private Tile[][] moveTilesLeft(ArrayList<ArrayList<Tile>> notNullArrayList) {
        Tile[][] shiftedBoardMatrix = new Tile[this.gameBoardSize][this.gameBoardSize];
        for (Tile[] row: shiftedBoardMatrix) {
            Arrays.fill(row, null);
        }
        for (int i = 0; i < notNullArrayList.size(); i++) {
            if(notNullArrayList.get(i).size() == 0) continue;
            for (int j = 0; j < notNullArrayList.get(i).size(); j++) {
                shiftedBoardMatrix[i][j] = notNullArrayList.get(i).get(j);
            }
        }

        return shiftedBoardMatrix;
    }
    private Tile[][] moveTilesRight(ArrayList<ArrayList<Tile>> notNullArrayList) {
        Tile[][] shiftedBoardMatrix = new Tile[this.gameBoardSize][this.gameBoardSize];
        for (Tile[] row: shiftedBoardMatrix) {
            Arrays.fill(row, null);
        }
        for (int i = 0; i < notNullArrayList.size(); i++) {
            if(notNullArrayList.get(i).size() == 0) continue;
            for (int j = 0; j < notNullArrayList.get(i).size(); j++) {
                shiftedBoardMatrix[i][this.gameBoardSize - 1 - j] = notNullArrayList.get(i).get(j);
            }
        }

        return shiftedBoardMatrix;
    }
    private Tile[][] moveTilesUp(Tile[][] inputBoardMatrix) {
        Tile[][] newMatrix = UtilsFunctions.transposeMatrix(inputBoardMatrix);

        ArrayList<ArrayList<Tile>> notNullTiles = new ArrayList<>();
        for (int i = 0; i < newMatrix.length; i++){
            ArrayList<Tile> notNullRow = new ArrayList<>();
            for (int j = 0; j < newMatrix.length; j++) {
                if(newMatrix[i][j] != null)
                    notNullRow.add(this.board[i][j]);
            }
            notNullTiles.add(notNullRow);
        }

        Tile[][] shiftedTransposedMatrix = this.moveTilesLeft(notNullTiles);
        Tile[][] shiftedMatrix = UtilsFunctions.transposeMatrix(shiftedTransposedMatrix);

        return shiftedMatrix;
    }
    private Tile[][] moveTilesDown(Tile[][] inputBoardMatrix) {
        Tile[][] newMatrix = UtilsFunctions.transposeMatrix(inputBoardMatrix);

        ArrayList<ArrayList<Tile>> notNullTiles = new ArrayList<>();
        for (int i = 0; i < newMatrix.length; i++){
            ArrayList<Tile> notNullRow = new ArrayList<>();
            for (int j = 0; j < newMatrix.length; j++) {
                if(newMatrix[i][j] != null)
                    notNullRow.add(this.board[i][j]);
            }
            notNullTiles.add(notNullRow);
        }

        Tile[][] shiftedTransposedMatrix = this.moveTilesRight(notNullTiles);
        Tile[][] shiftedMatrix = UtilsFunctions.transposeMatrix(shiftedTransposedMatrix);

        return shiftedMatrix;
    }

    private void updateScore(int update){
        this.score.updateScoreAfterMove(update);
    }

    private boolean checkEmptyBoxes() {
        for (int row = 0; row < gameBoardSize; row++) {
            for (int col = 0; col < gameBoardSize; col++) {
                if (board[row][col] == null)
                    return true;
            }
        }
        return false;
    }
}
