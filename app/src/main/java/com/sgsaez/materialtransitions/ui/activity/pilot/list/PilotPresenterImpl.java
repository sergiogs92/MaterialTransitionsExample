package com.sgsaez.materialtransitions.ui.activity.pilot.list;

import android.content.Context;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Pilot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public class PilotPresenterImpl implements PilotPresenter {

    private PilotView pilotView;
    private Context context;

    public PilotPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getPilots() {
        List<Pilot> pilotList = new ArrayList<>();

        pilotList.add(addAlonsoPilot());
        pilotList.add(addHamiltonPilot());
        pilotList.add(addAlonsoPilot());
        pilotList.add(addHamiltonPilot());
        pilotList.add(addAlonsoPilot());
        pilotList.add(addHamiltonPilot());
        pilotList.add(addAlonsoPilot());
        pilotList.add(addHamiltonPilot());
        pilotList.add(addAlonsoPilot());
        pilotList.add(addHamiltonPilot());

        pilotView.setPilots(pilotList);
    }

    @Override
    public void setView(PilotView view) {
        this.pilotView = view;
    }

    private Pilot addAlonsoPilot(){
        return new Pilot.PilotBuilder()
                .setName(context.getString(R.string.alonso_name_pilot))
                .setDescription(context.getString(R.string.alonso_description_pilot))
                .setPhoto(R.drawable.alonso)
                .setTeamCar(R.drawable.mcclaren_car).build();
    }

    private Pilot addHamiltonPilot(){
        return new Pilot.PilotBuilder()
                .setName(context.getString((R.string.hamilton_name_pilot)))
                .setDescription(context.getString(R.string.hamilton_description_pilot))
                .setPhoto(R.drawable.hamilton)
                .setTeamCar(R.drawable.mercedes_car).build();
    }
}
