package com.sgsaez.materialtransitions.ui.fragment.list.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Player;
import com.sgsaez.materialtransitions.ui.fragment.list.listener.OnPlayerClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.Holder> {

    private List<Player> mPlayerList;
    private OnPlayerClickListener mListener;

    public PlayerAdapter() {
        mPlayerList = new ArrayList<>();
    }

    public PlayerAdapter(OnPlayerClickListener mListener) {
        this.mListener = mListener;
    }

    public void setPlayerList(List<Player> playerList) {
        this.mPlayerList = playerList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    /*
       It is important that each shared element in the source screen has a unique transition name.
       For example, we can't just give all the images type "photo" in our recycler the transition
       name "transitionPhoto" because then we would have conflicting transition names.
     */

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mPlayerList.get(position), mListener);
		ViewCompat.setTransitionName(holder.getItemContainer(), String.valueOf(position) + "_container");
		ViewCompat.setTransitionName(holder.getIvPhoto(), String.valueOf(position) + "_photo");
        ViewCompat.setTransitionName(holder.getIvShield(), String.valueOf(position) + "_shield");
        ViewCompat.setTransitionName(holder.getTvName(), String.valueOf(position) + "_name");
    }

    @Override
    public int getItemCount() {
        return mPlayerList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

		private RelativeLayout itemContainer;
        private TextView tvName;
        private ImageView ivPhoto;
        private ImageView ivShield;

        public Holder(View itemView) {
            super(itemView);
			itemContainer = (RelativeLayout) itemView.findViewById(R.id.player_item_container);
            tvName = (TextView) itemView.findViewById(R.id.player_item_component_title_text_view);
            ivPhoto = (ImageView) itemView.findViewById(R.id.player_item_component_photo_image_view);
            ivShield = (ImageView) itemView.findViewById(R.id.player_item_component_shield_image_view);
        }

        public ImageView getIvShield() {
            return ivShield;
        }

        public ImageView getIvPhoto() {
            return ivPhoto;
        }

        public TextView getTvName() {
            return tvName;
        }

		public RelativeLayout getItemContainer() {
			return itemContainer;
		}

        public void bind(final Player player, final OnPlayerClickListener listener) {

            tvName.setText(player.getName());
            ivPhoto.setImageResource(player.getPhoto());
            ivShield.setImageResource(player.getShield());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlayerClicked(player, Holder.this);
                }
            });
        }
    }
}
