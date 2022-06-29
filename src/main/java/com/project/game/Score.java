package com.project.game;

public class Score {
    private int score;
    private int steps;

    public int getScore() {
        return score;
    }

    public int getNumOfSteps() {
        return steps;
    }

    public void resetScore() {
        this.score = 0;
        this.steps = 0;
    }

}
