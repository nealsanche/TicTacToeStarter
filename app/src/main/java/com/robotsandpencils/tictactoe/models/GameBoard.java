package com.robotsandpencils.tictactoe.models;

/**
 * Created by james_000 on 9/26/2014.
 */
public class GameBoard {

    private SpaceType board[][] = new SpaceType[3][3];
    private SpaceType currentTurn;

    public GameBoard()
    {
        InitializeBoard();
    }

    private void InitializeBoard() {
        for (int row= 0; row <3; row++)
            for (int col=0; col<3; col++)
                board[row][col] = SpaceType.Empty;

        currentTurn = SpaceType.Crosses;
    }

    public void PlayPiece(int row, int col)
    {
        board[row][col] = currentTurn;

        currentTurn = currentTurn == SpaceType.Crosses
                        ? SpaceType.Noughts
                        : SpaceType.Crosses;
    }

    public SpaceType getCurrentTurn()
    {
        return currentTurn;
    }

    public SpaceType[][] getBoard() {
        return board;
    }

}
