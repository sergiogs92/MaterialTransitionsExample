package com.sgsaez.materialtransitions.ui.activity.pilot.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Pilot;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public class PilotDetailActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private TextView tvName;
    private TextView tvDescription;
    private Pilot pilot;
    public static final String KEY_PILOT = "PILOT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_pilot);
        ivPhoto = (ImageView) findViewById(R.id.activity_detail_pilot_photo_image_view);
        tvName = (TextView) findViewById(R.id.activity_detail_pilot_name_text_view);
        tvDescription = (TextView) findViewById(R.id.activity_detail_pilot_description_text_view);
        pilot = (Pilot) getIntent().getExtras().getSerializable(KEY_PILOT);
        setUpData();
    }

    private void setUpData(){
        ivPhoto.setImageResource(pilot.getPhoto());
        tvName.setText(pilot.getName());
        tvDescription.setText(pilot.getDescription());
    }
}
