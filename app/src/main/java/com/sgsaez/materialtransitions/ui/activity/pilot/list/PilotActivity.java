package com.sgsaez.materialtransitions.ui.activity.pilot.list;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Pilot;
import com.sgsaez.materialtransitions.ui.activity.pilot.detail.PilotDetailActivity;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.adapter.PilotAdapter;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.listener.OnPilotOnClickListener;

import java.util.List;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public class PilotActivity extends AppCompatActivity  implements PilotView, OnPilotOnClickListener {

    private RecyclerView rvPilots;
    private PilotAdapter pilotAdapter;
    private PilotPresenter pilotPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pilot);

        rvPilots = (RecyclerView) findViewById(R.id.activity_pilot_recycler_view);
        rvPilots.setLayoutManager(new LinearLayoutManager(this));
        pilotAdapter = new PilotAdapter(this);
        rvPilots.setAdapter(pilotAdapter);

        pilotPresenter = new PilotPresenterImpl(this);
        pilotPresenter.setView(this);
        pilotPresenter.getPilots();
    }

    @Override
    public void setPilots(List<Pilot> pilots) {
        pilotAdapter.setPilotList(pilots);
        pilotAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onPilotClicked(Pilot pilot, PilotAdapter.Holder holder) {
        Intent intent = new Intent(this, PilotDetailActivity.class);

        intent.putExtra(PilotDetailActivity.KEY_PILOT, pilot);

        Pair<View, String> p1 = Pair.create((View) holder.getIvPhoto(), getString(R.string.transition_photo));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1);

        startActivity(intent, options.toBundle());
    }
}
