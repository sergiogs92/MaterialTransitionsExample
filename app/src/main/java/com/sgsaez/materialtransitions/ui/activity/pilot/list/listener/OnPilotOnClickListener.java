package com.sgsaez.materialtransitions.ui.activity.pilot.list.listener;

import com.sgsaez.materialtransitions.model.Pilot;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.adapter.PilotAdapter;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public interface OnPilotOnClickListener {

    void onPilotClicked(Pilot pilot, PilotAdapter.Holder holder);
}
