package com.project.game.gameLogic;

public class Score {
    private int score;
    private int steps;
    private boolean isGameOver = false;

    public int getScore() {
        return score;
    }

    public int getNumOfSteps() {
        return steps;
    }

    public void resetScore() {
        this.score = 0;
        this.steps = 0;
        this.isGameOver = false;
    }

    public void updateScoreAfterMove(int score) {
        this.score += score;
        this.steps++;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
