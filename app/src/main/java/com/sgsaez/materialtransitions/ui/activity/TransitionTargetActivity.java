package com.sgsaez.materialtransitions.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sgsaez.materialtransitions.R;


/**
 * Created by sergiogarcia on 7/12/16.
 */

public class TransitionTargetActivity extends AppCompatActivity {

    private Scene current;
    private Scene other;
    private boolean isCurrentScene;
    private Transition transitionScenetoFirst;
    private Transition transitionScenetoSecond;
    private Button bChangeScenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_target);

        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        bChangeScenes = (Button) findViewById(R.id.bChangeScenes);
        setUpButton();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            transitionScenetoSecond = TransitionInflater.from(this)
                    .inflateTransition(R.transition.scene1_transition_scene2);

            transitionScenetoFirst = TransitionInflater.from(this)
                    .inflateTransition(R.transition.scene2_transition_scene1);

            current = Scene.getSceneForLayout(container,
                    R.layout.scene1,
                    this);
            other = Scene.getSceneForLayout(container,
                    R.layout.scene2,
                    this);
            current.enter();
        }

    }

    private void setUpButton() {
        bChangeScenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (isCurrentScene) {
                        TransitionManager.go(current, transitionScenetoFirst);
                        isCurrentScene = false;
                    } else {
                        TransitionManager.go(other, transitionScenetoSecond);
                        isCurrentScene = true;
                    }
                }
            }
        });
    }
}

