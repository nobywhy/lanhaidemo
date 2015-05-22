package com.example.lanhaidemo.activity;

import com.example.lanhaidemo.R;
import com.example.lanhaidemo.R.id;
import com.example.lanhaidemo.R.layout;
import com.example.lanhaidemo.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private static final String TAG = "MainActivity";
	
	private LinearLayout tab_index;
	private LinearLayout tab_loan;
	private LinearLayout tab_calculator;
	private LinearLayout tab_my;

	private ImageView iv_menu_index;
	private ImageView iv_menu_loan;
	private ImageView iv_menu_calculator;
	private ImageView iv_menu_my;

	private TextView tv_menu_index;
	private TextView tv_menu_loan;
	private TextView tv_menu_calculator;
	private TextView tv_menu_my;

	private Fragment indexFragment;
	private Fragment loanFragment;
	private Fragment calculatorFragment;
	private Fragment myFragment;

	private FragmentManager fragmentManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		intiView();
		initEvent();
		setSelected(0);
	}

	/**
	 * 设置选中项
	 * 
	 * @param i
	 */
	private void setSelected(int i) {
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragment(transaction);
		switch (i) {
		case 0:
			if (indexFragment == null) {
				indexFragment = new IndexFragment();
				transaction.add(R.id.content, indexFragment);
			} else {
				transaction.show(indexFragment);
			}
			iv_menu_index.setImageResource(R.drawable.ic_menu_index_on);
			tv_menu_index.setTextColor(getResources().getColor(R.color.menu_blue));
			break;
		case 1:
			if (loanFragment == null) {
				loanFragment = new LoanFragment();
				transaction.add(R.id.content, loanFragment);
			} else {
				transaction.show(loanFragment);
			}
			iv_menu_loan.setImageResource(R.drawable.ic_menu_loan_on);
			tv_menu_loan.setTextColor(getResources().getColor(R.color.menu_blue));
			break;
		case 2:
			if (calculatorFragment == null) {
				calculatorFragment = new CalculatorFragment();
				transaction.add(R.id.content, calculatorFragment);
			} else {
				transaction.show(calculatorFragment);
			}
			iv_menu_calculator.setImageResource(R.drawable.ic_menu_calculator_on);
			tv_menu_calculator.setTextColor(getResources().getColor(R.color.menu_blue));
			break;
		case 3:
			if (myFragment == null) {
				myFragment = new MyFragment();
				transaction.add(R.id.content, myFragment);
			} else {
				transaction.show(myFragment);
			}
			iv_menu_my.setImageResource(R.drawable.ic_menu_my_on);
			tv_menu_my.setTextColor(getResources().getColor(R.color.menu_blue));
			break;
		}
		transaction.addToBackStack(null);
		transaction.commit();
	}

	/**
	 * 隐藏Fragment
	 * 
	 * @param transaction
	 */
	private void hideFragment(FragmentTransaction transaction) {
		if (indexFragment != null) {
			transaction.hide(indexFragment);
		}
		if (calculatorFragment != null) {
			transaction.hide(calculatorFragment);
		}
		if (loanFragment != null) {
			transaction.hide(loanFragment);
		}
		if (myFragment != null) {
			transaction.hide(myFragment);
		}
	}

	private void initEvent() {
		tab_index.setOnClickListener(this);
		tab_loan.setOnClickListener(this);
		tab_calculator.setOnClickListener(this);
		tab_my.setOnClickListener(this);
	}

	private void intiView() {
		tab_index = (LinearLayout) this.findViewById(R.id.tab_index);
		tab_loan = (LinearLayout) this.findViewById(R.id.tab_loan);
		tab_calculator = (LinearLayout) this.findViewById(R.id.tab_calculator);
		tab_my = (LinearLayout) this.findViewById(R.id.tab_my);

		iv_menu_index = (ImageView) this.findViewById(R.id.iv_menu_index);
		iv_menu_loan = (ImageView) this.findViewById(R.id.iv_menu_loan);
		iv_menu_calculator = (ImageView) this.findViewById(R.id.iv_menu_calculator);
		iv_menu_my = (ImageView) this.findViewById(R.id.iv_menu_my);

		tv_menu_index = (TextView) this.findViewById(R.id.tv_menu_index);
		tv_menu_loan = (TextView) this.findViewById(R.id.tv_menu_loan);
		tv_menu_calculator = (TextView) this.findViewById(R.id.tv_menu_calculator);
		tv_menu_my = (TextView) this.findViewById(R.id.tv_menu_my);

	}

	/**
	 * 将图片和文字设置成灰色
	 */
	private void reSet() {
		iv_menu_index.setImageResource(R.drawable.ic_menu_index_off);
		iv_menu_loan.setImageResource(R.drawable.ic_menu_loan_off);
		iv_menu_calculator.setImageResource(R.drawable.ic_menu_calculator_off);
		iv_menu_my.setImageResource(R.drawable.ic_menu_my_off);

		tv_menu_index.setTextColor(getResources().getColor(R.color.menu_gray));
		tv_menu_loan.setTextColor(getResources().getColor(R.color.menu_gray));
		tv_menu_calculator.setTextColor(getResources().getColor(R.color.menu_gray));
		tv_menu_my.setTextColor(getResources().getColor(R.color.menu_gray));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		reSet();
		switch (view.getId()) {
		case R.id.tab_index:
			setSelected(0);
			break;
		case R.id.tab_loan:
			setSelected(1);
			break;
		case R.id.tab_calculator:
			setSelected(2);
			break;
		case R.id.tab_my:
			setSelected(3);
			break;
		}
	}
	
	
	@Override
	protected void onStart() {
		super.onStart();
		
	}
	
}
