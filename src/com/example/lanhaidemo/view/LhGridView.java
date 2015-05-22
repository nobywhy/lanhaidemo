package com.example.lanhaidemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * �Զ���gridview�����ListView��Ƕ��gridview��ʾ������������
 */
public class LhGridView extends GridView{
	  public LhGridView(Context context, AttributeSet attrs) { 
	        super(context, attrs); 
	    } 
	 
	    public LhGridView(Context context) { 
	        super(context); 
	    } 
	 
	    public LhGridView(Context context, AttributeSet attrs, int defStyle) { 
	        super(context, attrs, defStyle); 
	    } 
	 
	    @Override 
	    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
	 
	        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, 
	                MeasureSpec.AT_MOST); 
	        super.onMeasure(widthMeasureSpec, expandSpec); 
	    } 
}