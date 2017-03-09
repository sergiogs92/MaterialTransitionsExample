package com.sgsaez.materialtransitions.ui.fragment.detail;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sgsaez.materialtransitions.R;
import com.sgsaez.materialtransitions.model.Player;
import com.sgsaez.materialtransitions.utils.BitmapUtil;

/**
 * Created by sergiogarcia on 4/12/16.
 */

public class PlayerDetailFragment extends Fragment {

    private ImageView ivPhoto;
    private ImageView ivShield;
    private TextView tvName;
    private TextView tvDescription;
	private View lContainerView;
    private static final String KEY_PLAYER = "PLAYER";

	public static PlayerDetailFragment newInstance(Player player, Bundle args) {
		args.putSerializable(KEY_PLAYER, player);
		PlayerDetailFragment fragment = new PlayerDetailFragment();
		fragment.setArguments(args);
		return fragment;
	}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_player, container, false);
		lContainerView = view.findViewById(R.id.view);
        ivPhoto = (ImageView) view.findViewById(R.id.detail_player_fragment_photo_image_view);
        ivShield = (ImageView) view.findViewById(R.id.detail_player_fragment_shield_image_view);
        tvName = (TextView) view.findViewById(R.id.detail_player_fragment_name_text_view);
        tvDescription = (TextView) view.findViewById(R.id.detail_player_fragment_description_text_view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

		lContainerView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().getSupportFragmentManager().popBackStack();
			}
		});

		if (getArguments().getString("bitmap_id") != null) {
			String bitmap_id = getArguments().getString("bitmap_id");
			Drawable drawable = new BitmapDrawable(getResources(), BitmapUtil.getBitmapFromMemoryCache(bitmap_id));
			lContainerView.setVisibility(View.VISIBLE);
			lContainerView.setAlpha(0.5f);
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				lContainerView.setBackground(drawable);
			}
		}

        Player player = (Player) getArguments().getSerializable(KEY_PLAYER);
        if (player != null) {
            ivPhoto.setImageResource(player.getPhoto());
            ivShield.setImageResource(player.getShield());
            tvName.setText(player.getName());
            tvDescription.setText(player.getDescription());
        }
    }
}
