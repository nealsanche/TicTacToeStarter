package com.robotsandpencils.tictactoe.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.common.eventbus.Subscribe;
import com.robotsandpencils.tictactoe.R;
import com.robotsandpencils.tictactoe.fragments.GameFragment;
import com.robotsandpencils.tictactoe.models.GameBoard;
import com.robotsandpencils.tictactoe.models.GameOverEvent;

/**
 * This implements the main activity of the game. It simply starts and adds a GameFragment
 * to the view hierarchy and displays it.
 */
public class GameActivity extends Activity {

    private GameBoard board = new GameBoard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new GameFragment())
                    .commit();
        }
        board.RegisterEndGameHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void handleGameOverEvent(GameOverEvent event)
    {
        Context context = getApplicationContext();
        CharSequence text = null;

        switch (event.getWinner()) {
            case Empty:
                text = "Game over...that's one for the Kitteh!";
                break;
            case Noughts:
                text = "Noughts FTW!";
                break;
            case Crosses:
                text = "Game over. Because X.";
                break;
        }


        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void sendMessage(View view) {
        int xRow = 0;
        int yRow = 1;
        board.PlayPiece(xRow, 0);
        board.PlayPiece(yRow, 0);
        board.PlayPiece(xRow, 1);
        board.PlayPiece(yRow, 1);
        board.PlayPiece(xRow, 2);

    }
}
