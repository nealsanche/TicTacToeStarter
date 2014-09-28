package com.robotsandpencils.tictactoe.models;

/**
 * Created by james_000 on 9/26/2014.
 */
// @PresentationModel
public class GameHistory {

    private int crossScore;
    private int noughtScore;
    private int kittehScore;

    public GameHistory() {
        crossScore = 5;
        noughtScore = 3;
        kittehScore = 8;
    }

    public int getCrossScore() {
        return crossScore;
    }

    public int getNoughtScore() {
        return noughtScore;
    }

    public int getKittehScore() {
        return kittehScore;
    }
}
