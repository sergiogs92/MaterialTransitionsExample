package com.sgsaez.materialtransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sgsaez.materialtransitions.ui.activity.TransitionTargetActivity;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.PilotActivity;
import com.sgsaez.materialtransitions.ui.fragment.PlayerActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonActivityTransition;
    private Button buttonFragmentTransition;
    private  Button buttonTransitionTargets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonActivityTransition = (Button) findViewById(R.id.activity_main_transition_activities_button);
        buttonFragmentTransition = (Button) findViewById(R.id.activity_main_transition_fragments_button);
        buttonTransitionTargets = (Button) findViewById(R.id.activity_main_transition_targets_activities_button);
        setUpButtons();
    }


    private void setUpButtons() {
        buttonActivityTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PilotActivity.class);
                startActivity(intent);
            }
        });

        buttonFragmentTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
        buttonTransitionTargets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransitionTargetActivity.class);
                startActivity(intent);
            }
        });
    }
}
