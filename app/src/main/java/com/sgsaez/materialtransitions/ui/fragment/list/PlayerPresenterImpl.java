package com.sgsaez.materialtransitions.ui.fragment.list;

import android.content.Context;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class PlayerPresenterImpl implements PlayerPresenter {

    private PlayerView playerView;
    private Context context;

    public PlayerPresenterImpl(Context context) {
     this.context = context;
    }

    @Override
    public void setView(PlayerView view) {
        this.playerView = view;
    }

    @Override
    public void getPlayers() {
        List<Player> playerList = new ArrayList<>();

        playerList.add(addCr7Player());
        playerList.add(addLeoPlayer());
        playerList.add(addCr7Player());
        playerList.add(addLeoPlayer());
        playerList.add(addCr7Player());
        playerList.add(addLeoPlayer());
        playerList.add(addCr7Player());
        playerList.add(addLeoPlayer());
        playerList.add(addCr7Player());

        playerView.setPlayers(playerList);
    }


    private Player addCr7Player(){
        return new Player.PlayerBuilder()
                .setName(context.getString(R.string.cr7_name_player))
                .setDescription(context.getString(R.string.cr7_description_player))
                .setPhoto(R.drawable.cr7)
                .setShield(R.drawable.rm_shield).build();
    }

    private Player addLeoPlayer(){
        return new Player.PlayerBuilder()
                .setName(context.getString(R.string.leo_name_player))
                .setDescription(context.getString(R.string.leo_description_player))
                .setPhoto(R.drawable.leo)
                .setShield(R.drawable.fcb_shield).build();
    }
}
