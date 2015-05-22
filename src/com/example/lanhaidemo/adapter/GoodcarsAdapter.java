package com.example.lanhaidemo.adapter;

import com.example.lanhaidemo.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GoodcarsAdapter extends BaseAdapter {

	private static final String TAG = "GoodcarsAdapter";
	
	private Context context;
	private Integer[] mThumbIds = { R.drawable.goodscar, R.drawable.goodscar, R.drawable.goodscar, R.drawable.goodscar,
			R.drawable.goodscar, R.drawable.goodscar, R.drawable.goodscar, R.drawable.goodscar };

	public GoodcarsAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		Log.d(TAG, "GoodcarsAdapter-->"+position);
		View view = null;
		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(R.layout.index_goodscars_item, null);
			// imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			// imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			// imageView.setPadding(8, 8, 8, 8);
		} else {
			view = convertView;
		}
		ImageView goodcars_item = (ImageView) view.findViewById(R.id.goodcars_iv_item);
		goodcars_item.setImageResource(mThumbIds[position]);
		return view;

	}

}
