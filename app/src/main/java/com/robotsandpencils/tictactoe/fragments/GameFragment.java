package com.robotsandpencils.tictactoe.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robotsandpencils.tictactoe.R;

/**
 * A fragment that should be used to implement the game display. This will probably be where
 * much of the UI work will be done.
 */
public class GameFragment extends Fragment {

    public GameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        // Hook up the elements of the view using findViewById, or by using Jake Wharton's awesome
        // ButterKnife project which is already added as a dependency.

        return rootView;
    }
}
