package com.example.lanhaidemo.activity;

import java.util.ArrayList;

import com.example.lanhaidemo.R;
import com.example.lanhaidemo.adapter.GoodcarsAdapter;
import com.example.lanhaidemo.view.scrollviewpager.ImageCycleView;
import com.example.lanhaidemo.view.scrollviewpager.ImageCycleView.ImageCycleViewListener;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * 首页
 * @author lw
 *
 */
public class IndexFragment extends Fragment {

	private static final String TAG = "IndexFragment";
	private GridView index_goodcars;
	private ScrollView index_scrollview;
	
	private ImageCycleView mAdView;

	private ArrayList<String> mImageUrl = null;

//	private String imageUrl1 = "http://imgs.xiuna.com/xiezhen/2014-9-25/2/5562900520140919100645087.jpg";
//	private String imageUrl2 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
//	private String imageUrl3 = "http://srimg1.meimei22.com/pic/suren/2014-9-24/1/8740_11329820378.jpg";
//	private String imageUrl4 = "http://imgs.xiuna.com/xiezhen/2013-3-20/1/12.jpg";
	
	private String imageUrl1 = "drawable://" + R.drawable.banner1;
	private String imageUrl2 = "drawable://" + R.drawable.banner2;
	private String imageUrl3 = "drawable://" + R.drawable.banner3;
	private String imageUrl4 = "drawable://" + R.drawable.banner4;
	
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.index, null);
		index_scrollview = (ScrollView) view.findViewById(R.id.index_scrollview);
		
		//轮播广告
		mImageUrl = new ArrayList<String>();
		mImageUrl.add(imageUrl1);
		mImageUrl.add(imageUrl2);
		mImageUrl.add(imageUrl3);
		mImageUrl.add(imageUrl4);
		mAdView = (ImageCycleView) view.findViewById(R.id.ad_view);
		mAdView.setImageResources(mImageUrl, mAdCycleViewListener);
		//好车推荐网格布局
		index_goodcars = (GridView) view.findViewById(R.id.index_goodcars);
		index_goodcars.setAdapter(new GoodcarsAdapter(getActivity()));
		index_goodcars.clearFocus();
		
		//scrollview的焦点固定在他里面的第一个控件上，解决scrollview中嵌套GridView时焦点跑到GridView上的问题
		index_scrollview.requestChildFocus(mAdView, null);
		
		return view;
	}
	
	/**
	 * 轮播图片
	 */
	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(int position, View imageView) {
			// TODO 单击图片处理事件
			Toast.makeText(getActivity(), "position->"+position, 0).show();
		}

		@Override
		public void displayImage(String imageURL, ImageView imageView) {
			ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
		}
	};
	
	
	
	
	
	
	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, TAG+"--onStart()");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG, TAG+"--onResume()");
		mAdView.startImageCycle();
	};

	@Override
	public void onPause() {
		super.onPause();
		mAdView.pushImageCycle();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mAdView.pushImageCycle();
	}
	
}
