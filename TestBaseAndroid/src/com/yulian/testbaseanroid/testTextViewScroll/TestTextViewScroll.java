package com.yulian.testbaseanroid.testTextViewScroll;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.os.Bundle;

//@ContentView(R.layout.activity_test_scrolltextview)
public class TestTextViewScroll extends Activity {
//	@ViewInject(R.id.vstx_content)
	private VerticalScrollTextView vstx_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_test_scrolltextview);
//		ViewUtils.inject(this);
		
		
		
		
	}
}
