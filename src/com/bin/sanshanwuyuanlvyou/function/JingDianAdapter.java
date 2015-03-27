package com.bin.sanshanwuyuanlvyou.function;

import java.util.List;

import com.bin.sanshanwuyuanlvyou.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JingDianAdapter extends ArrayAdapter<JingDian> {
	public class ViewHolder {
		ImageView jingDianImage;
		TextView jingDianName;
	}

	private int resourceId;

	public JingDianAdapter(Context context, int textViewResourceId,
			List<JingDian> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		JingDian jingDian = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.jingDianImage = (ImageView) view
					.findViewById(R.id.image_jingdian);
			viewHolder.jingDianName = (TextView) view
					.findViewById(R.id.jingdian_name);
			view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		

		viewHolder.jingDianImage.setImageResource(jingDian.getImageId());
		viewHolder.jingDianName.setText(jingDian.getName());

		return view;

	}

}
