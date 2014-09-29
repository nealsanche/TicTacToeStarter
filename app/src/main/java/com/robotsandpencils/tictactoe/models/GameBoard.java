package com.robotsandpencils.tictactoe.models;

import java.util.Map;

/**
 * Created by james_000 on 9/26/2014.
 */
public class GameBoard {

    public static final int COL_OFFSET = 3;
    public static final int WIN_THRESHOLD = 3;
    public static final int BOARD_SIZE = 3;
    public static final int PLAYS_MAP_SIZE = 8;
    public static final int DOWN_DIAGONAL_MAP_INDEX = 6;
    public static final int UP_DIAGONAL_MAP_INDEX = 7;

    private SpaceType board[][] = new SpaceType[BOARD_SIZE][BOARD_SIZE];
    private SpaceType currentTurn;
    private SpaceType gameWinner = SpaceType.Empty;

    // a played piece map gives us O(1) for solving a win
    private Map<SpaceType, int[]> playedSpaceMap;
    private int[] crossesPlayedSpaceMap = new int[PLAYS_MAP_SIZE];
    private int[] noughtsPlayedSpaceMap = new int[PLAYS_MAP_SIZE];

    public GameBoard()
    {
        InitializeBoard();
    }

    private void InitializeBoard() {
        for (int row= 0; row < BOARD_SIZE; row++)
            for (int col=0; col< BOARD_SIZE; col++)
                board[row][col] = SpaceType.Empty;

        currentTurn = SpaceType.Crosses;

        gameWinner = SpaceType.Empty;

        ResetPlayedSpaceMaps();
    }

    private void ResetPlayedSpaceMaps() {
        for (int i=0; i< PLAYS_MAP_SIZE; i++) {
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
        if(totalPlaysAtIndex >= WIN_THRESHOLD)
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
        int spaceMap[] = player == SpaceType.Crosses
                ? crossesPlayedSpaceMap
                : noughtsPlayedSpaceMap;

        int rowMap = row;
        int colMap = col + COL_OFFSET; // shift to upper part of array

        // compute the horizontal value  "-"
        int rowMapCount = spaceMap[rowMap];
        rowMapCount++;
        spaceMap[rowMap] = rowMapCount;

        // compute the vertical value  "|"
        int colMapCount = spaceMap[colMap];
        colMapCount++;
        spaceMap[colMap] = colMapCount;

        // test/compute for down-diagonal line  "\"
        int downDiagonalMapCount = 0;
        if ((row == 0 & col == 0) || (row == 1 & col == 1) || (row == 2 & col == 2))
        {
            downDiagonalMapCount = spaceMap[DOWN_DIAGONAL_MAP_INDEX];
            spaceMap[DOWN_DIAGONAL_MAP_INDEX] = downDiagonalMapCount++;
        }

        // test/compute for up-diagonal line  "/"
        int upDiagonalMapCount = 0;
        if ((row == 2 & col == 0) || (row == 1 & col == 1) || (row == 0 & col == 2))
        {
            upDiagonalMapCount = spaceMap[UP_DIAGONAL_MAP_INDEX];
            spaceMap[UP_DIAGONAL_MAP_INDEX] = upDiagonalMapCount++;
        }


        System.out.format(" Row: %d | Map: %d | Value: %d", row, rowMap, rowMapCount);

        // we only need to know the highest of the values
        int highestValue = Math.max(rowMapCount, colMapCount);
        highestValue = Math.max(highestValue, 0);

        return highestValue;
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
