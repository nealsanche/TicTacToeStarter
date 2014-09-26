package com.robotsandpencils.tictactoe.models;

/**
 * Created by james_000 on 9/26/2014.
 */
// @PresentationModel
public class GameInstance {

    private int crossScore;
    private int oughtScore;
    private int kittyScore;

    public GameInstance() {
        crossScore = 5;
        oughtScore = 3;
        kittyScore = 8;
    }

    public int getCrossScore() {
        return crossScore;
    }

    public int getOughtScore() {
        return oughtScore;
    }

    public int getKittyScore() {
        return kittyScore;
    }
}
