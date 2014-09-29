package com.robotsandpencils.tictactoe;
import com.robotsandpencils.tictactoe.models.GameBoard;
import com.robotsandpencils.tictactoe.models.SpaceType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by james_000 on 9/28/2014.
 *
 * Comment template:
 // arrange
 // act
 // assert
 *
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class GameBoardShould {

    static {
        ShadowLog.stream = System.out;
    }

    @Test
    public void StartWithCrosses() {
        // arrange
        GameBoard board = new GameBoard();

        // act - nothing to do here, checking starting point

        // assert
        Assert.assertTrue(board.getCurrentTurn() == SpaceType.Crosses);
    }

    @Test
    public void StartWithNoWinner() {
        // arrange
        GameBoard board = new GameBoard();

        // act - nothing to do here, checking starting point

        // assert
        Assert.assertFalse(board.PlayerHasWon());
    }

    @Test
    public void AlternatePlayersAfterMove() {
        // arrange
        GameBoard board = new GameBoard();

        // act
        board.PlayPiece(0, 0);

        // assert
        Assert.assertTrue(board.getCurrentTurn() == SpaceType.Noughts);

        // act - testing alternation, need a second play...
        board.PlayPiece(0, 0);

        // assert - ...and assertion
        Assert.assertTrue(board.getCurrentTurn() == SpaceType.Crosses);
    }

    @Test
    public  void PlayPieceInCorrectPosition()
    {
        // arrange
        GameBoard board = new GameBoard();
        int centre = 1;

        // act
        board.PlayPiece(centre, centre);

        // assert
        Assert.assertTrue(board.getBoard()[centre][centre] == SpaceType.Crosses);
    }

    @Test
    public void DetectHorizontalWins() {
        System.out.println("Starting DetectHorizontalWins test...");
        // arrange
        GameBoard board = new GameBoard();
        int xRow = 0;
        int yRow = 1;

        // act
        board.PlayPiece(xRow, 0);
        board.PlayPiece(yRow, 0);
        board.PlayPiece(xRow, 1);
        board.PlayPiece(yRow, 1);
        board.PlayPiece(xRow, 2);

        // assert
        System.out.println("      ...DetectHorizontalWins");
        Assert.assertTrue(board.PlayerHasWon());
    }

    @Test
    public void DetectVerticalWins() {
        System.out.println("Starting DetectVerticalWins test...");
        // arrange
        GameBoard board = new GameBoard();
        int xCol = 0;
        int yCol = 1;

        // act
        board.PlayPiece(0, xCol); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(0, yCol); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, xCol); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, yCol); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(2, xCol);

        // assert
        System.out.println("      ...DetectVerticalWins");
        Assert.assertTrue(board.PlayerHasWon());
    }

    @Test
    public void DetectDownDiagonalWins() {
        System.out.println("Starting DetectDownDiagonalWins test...");
        // arrange
        GameBoard board = new GameBoard();

        // act
        board.PlayPiece(0, 0); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(0, 1); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, 1); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, 0); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(2, 2);

        // assert
        System.out.println("      ...DetectDownDiagonalWins");
        Assert.assertTrue(board.PlayerHasWon());
    }


    @Test
    public void DetectUpDiagonalWins() {
        System.out.println("Starting DetectUpDiagonalWins test...");
        // arrange
        GameBoard board = new GameBoard();

        // act
        board.PlayPiece(2, 0); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(0, 1); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, 1); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(1, 0); Assert.assertFalse(board.PlayerHasWon());
        board.PlayPiece(0, 2);

        // assert
        System.out.println("      ...DetectUpDiagonalWins");
        Assert.assertTrue(board.PlayerHasWon());
    }

    @Test
    public void ResetWhenResetActionInvoked() {
        // arrange

        // act

        // assert
        Assert.assertTrue(false);
    }

}
