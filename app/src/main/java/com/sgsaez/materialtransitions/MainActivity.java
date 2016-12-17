package com.sgsaez.materialtransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sgsaez.materialtransitions.ui.activity.TransitionTargetActivity1;
import com.sgsaez.materialtransitions.ui.activity.TransitionTargetActivity2;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.PilotActivity;
import com.sgsaez.materialtransitions.ui.fragment.PlayerActivity;

public class MainActivity extends AppCompatActivity {

    private Button bActivityTransition;
    private Button bFragmentTransition;
    private Button bTransitionTarget1;
    private Button bTransitionTarget2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bActivityTransition = (Button) findViewById(R.id.activity_main_transition_activities_button);
        bFragmentTransition = (Button) findViewById(R.id.activity_main_transition_fragments_button);
        bTransitionTarget1 = (Button) findViewById(R.id.activity_main_transition_target_1_activities_button);
        bTransitionTarget2 = (Button) findViewById(R.id.activity_main_transition_target_2_activities_button);
        setUpButtons();
    }


    private void setUpButtons() {
        bActivityTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PilotActivity.class);
                startActivity(intent);
            }
        });

        bFragmentTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
        bTransitionTarget1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransitionTargetActivity1.class);
                startActivity(intent);
            }
        });
        bTransitionTarget2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransitionTargetActivity2.class);
                startActivity(intent);
            }
        });
    }
}
