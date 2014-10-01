package com.robotsandpencils.tictactoe.models;

/**
 * Created by james_000 on 9/30/2014.
 */
public class GameOverEvent {
    private SpaceType winner;

    public SpaceType getWinner() {
        return winner;
    }

    public void setWinner(SpaceType winner) {
        this.winner = winner;
    }
}
