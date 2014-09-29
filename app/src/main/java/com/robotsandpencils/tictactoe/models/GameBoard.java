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

        playedSpaceMap = new HashMap<SpaceType, int[]>();
        playedSpaceMap.put(SpaceType.Crosses, new int[9]);
        playedSpaceMap.put(SpaceType.Noughts, new int[9]);
    }

    public void PlayPiece(int row, int col)
    {
        // update the board
        board[row][col] = currentTurn;

        // check for win
        int pieceIndex = row * 3 + col;
        int totalPlaysAtIndex = playedSpaceMap.get(currentTurn)[pieceIndex];
        if(++totalPlaysAtIndex == 2)
        {
            gameWinner = currentTurn;
            return;
        }
        playedSpaceMap.get(currentTurn)[pieceIndex] = totalPlaysAtIndex;

        // switch player
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

    public boolean PlayerHasWon() {
        return gameWinner != SpaceType.Empty;
    }
}
