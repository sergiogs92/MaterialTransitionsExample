package com.sgsaez.materialtransitions.ui.fragment.list;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Player;
import com.sgsaez.materialtransitions.ui.fragment.detail.PlayerDetailFragment;
import com.sgsaez.materialtransitions.ui.fragment.list.adapter.PlayerAdapter;
import com.sgsaez.materialtransitions.ui.fragment.list.listener.OnPlayerClickListener;

import java.util.List;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class PlayerFragment extends Fragment implements PlayerView, OnPlayerClickListener {

    private PlayerPresenter mPlayerPresenter;
    private RecyclerView rvPlayers;
    private PlayerAdapter playerAdapter;

    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        rvPlayers = (RecyclerView) view.findViewById(R.id.fragment_player_recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPlayers.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        playerAdapter = new PlayerAdapter(this);
        rvPlayers.setAdapter(playerAdapter);

        mPlayerPresenter = new PlayerPresenterImpl(getContext());
        mPlayerPresenter.setView(this);
        mPlayerPresenter.getPlayers();
    }

    @Override
    public void setPlayers(List<Player> players) {
        playerAdapter.setPlayerList(players);
        playerAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onPlayerClicked(Player player, PlayerAdapter.Holder holder) {
        Transition changeTransformSharedElements = TransitionInflater.from(getActivity()).inflateTransition(R.transition.change_transform_shared_fragments);
        Transition slideBottomTransform = TransitionInflater.from(getActivity()).inflateTransition(R.transition.slide_bottom_not_shared_fragments);

        PlayerDetailFragment playerDetailFragment = PlayerDetailFragment.newInstance(player);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            // Setup enter transition on second fragment
            playerDetailFragment.setSharedElementEnterTransition(changeTransformSharedElements);
            playerDetailFragment.setEnterTransition(slideBottomTransform);

            playerDetailFragment.setSharedElementReturnTransition(changeTransformSharedElements);
            playerDetailFragment.setExitTransition(slideBottomTransform);
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.player_container, playerDetailFragment)
                .addSharedElement(holder.getIvPhoto(), getString(R.string.transition_photo))
                .addSharedElement(holder.getIvShield(), getString(R.string.transition_shield))
                .addSharedElement(holder.getTvName(), getString(R.string.transition_name))
                .commit();
    }
}
