package com.project.game.gameLogic;

import java.util.ArrayList;

public class UtilsFunctions {
    public static ArrayList<Tile> flattenListOfListsImperatively(ArrayList<ArrayList<Tile>> nestedList) {
        ArrayList<Tile> ls = new ArrayList<>();
        nestedList.forEach(ls::addAll);
        return ls;
    }

    public static Tile[][] transposeMatrix(Tile[][] inputMatrix) {
        Tile[][] newMatrix = new Tile[inputMatrix.length][inputMatrix.length];
        for (int i = 0; i < inputMatrix.length; i++) {
            Tile[] newRow = new Tile[inputMatrix.length];
            for (int j = 0; j < inputMatrix.length; j++)
                newRow[j] = inputMatrix[j][i];
            newMatrix[i] = newRow;
        }
        return newMatrix;
    }
}
