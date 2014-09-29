package com.robotsandpencils.tictactoe.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by james_000 on 9/26/2014.
 */
public class GameBoard {

    private SpaceType board[][] = new SpaceType[3][3];
    private SpaceType currentTurn;
    private SpaceType gameWinner = SpaceType.Empty;

    // a played piece map gives us O(1) for solving a win
    private Map<SpaceType, int[]> playedSpaceMap;
    private int[] crossesPlayedSpaceMap = new int[8];
    private int[] noughtsPlayedSpaceMap = new int[8];

    public GameBoard()
    {
        InitializeBoard();
    }

    private void InitializeBoard() {
        for (int row= 0; row <3; row++)
            for (int col=0; col<3; col++)
                board[row][col] = SpaceType.Empty;

        currentTurn = SpaceType.Crosses;

        gameWinner = SpaceType.Empty;

        ResetPlayedSpaceMaps();
    }

    private void ResetPlayedSpaceMaps() {
        for (int i=0; i<8;i++) {
            crossesPlayedSpaceMap[i] = 0;
            noughtsPlayedSpaceMap[i] = 0;
        }
    }

    public void PlayPiece(int row, int col)
    {
        System.out.format("piece played at %d %d \n", row, col);

        // update the board
        board[row][col] = currentTurn;

        // check for win
        int totalPlaysAtIndex = UpdatePlaysAtIndex(currentTurn, row, col);
        System.out.format(" checked piece map (val %d)\n", totalPlaysAtIndex);
        if(totalPlaysAtIndex == 2)
        {
            gameWinner = currentTurn;
            return;
        }

        // switch player
        currentTurn = currentTurn == SpaceType.Crosses
                        ? SpaceType.Noughts
                        : SpaceType.Crosses;
    }

    // updates the correct plays for that row/column/diag and returns the updated value
    public int UpdatePlaysAtIndex(SpaceType player, int row, int col)
    {
        int rowMap = row;
//        int colMap = col + 3; // shift to upper part of array

        // fetch the count
        int newValue = player == SpaceType.Crosses
                ? crossesPlayedSpaceMap[rowMap]
                : noughtsPlayedSpaceMap[rowMap];

        // increment the count
        newValue++;

        // update the relevant map
        if(player == SpaceType.Crosses)
            crossesPlayedSpaceMap[rowMap] = newValue;
        else
            noughtsPlayedSpaceMap[rowMap] = newValue;

        return newValue;
    }




    public SpaceType getCurrentTurn()
    {
        return currentTurn;
    }

    public SpaceType[][] getBoard() {
        return board;
    }

    public boolean PlayerHasWon() {
        return gameWinner != SpaceType.Empty;
    }
}
