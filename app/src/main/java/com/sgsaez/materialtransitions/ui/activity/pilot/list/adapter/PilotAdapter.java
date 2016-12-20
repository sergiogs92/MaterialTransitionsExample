package com.sgsaez.materialtransitions.ui.activity.pilot.list.adapter;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Pilot;
import com.sgsaez.materialtransitions.ui.activity.pilot.list.listener.OnPilotOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergiogarcia on 7/12/16.
 */

public class PilotAdapter extends RecyclerView.Adapter<PilotAdapter.Holder> {

    private List<Pilot> mPilotList;
    private OnPilotOnClickListener mListener;

    public PilotAdapter(OnPilotOnClickListener listener){
        mPilotList = new ArrayList<>();
        this.mListener = listener;
    }

    public void setPilotList(List<Pilot> pilotList) {
        this.mPilotList = pilotList;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.pilot_item, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mPilotList.get(position),mListener);
        ViewCompat.setTransitionName(holder.getIvPhoto(), String.valueOf(position) + "_photo");
    }

    @Override
    public int getItemCount() {
        return mPilotList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivPhoto;
        private TextView tvDescription;

        public TextView getTvName() {
            return tvName;
        }

        public ImageView getIvPhoto() {
            return ivPhoto;
        }

        public TextView getTvDescription() {
            return tvDescription;
        }

        public Holder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById( R.id.pilot_item_name_text_view);
            tvDescription = (TextView) itemView.findViewById( R.id.pilot_item_body_text_view);
            ivPhoto = (ImageView) itemView.findViewById( R.id.pilot_item_photo_image_view);
        }

        public void bind(final Pilot pilot, final OnPilotOnClickListener listener) {
            tvName.setText(pilot.getName());
            tvDescription.setText(pilot.getDescription());
            ivPhoto.setImageResource(pilot.getPhoto());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onPilotClicked(pilot, Holder.this);
                }
            });
        }
    }
}
