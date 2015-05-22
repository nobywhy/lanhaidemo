package com.example.lanhaidemo.activity;

import com.example.lanhaidemo.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ÎÒµÄº£´û
 * @author lw
 *
 */
public class MyFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.my, null);
	}
	
}
