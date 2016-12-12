package com.sgsaez.materialtransitions.ui.fragment.list.listener;

import com.sgsaez.materialtransitions.model.Player;
import com.sgsaez.materialtransitions.ui.fragment.list.adapter.PlayerAdapter;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public interface OnPlayerClickListener {

    void onPlayerClicked(Player player, PlayerAdapter.Holder holder);
}
