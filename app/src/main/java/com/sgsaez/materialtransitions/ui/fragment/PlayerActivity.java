package com.sgsaez.materialtransitions.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.ui.fragment.list.PlayerFragment;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class PlayerActivity extends AppCompatActivity {

    FrameLayout flContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        flContainer = (FrameLayout) findViewById(R.id.player_container);
        if (savedInstanceState == null) {
            goToPlayerList();
        }
    }

    private void goToPlayerList() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.player_container, PlayerFragment.newInstance())
                .commit();
    }
}
