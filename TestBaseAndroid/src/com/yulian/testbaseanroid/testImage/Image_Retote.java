package com.yulian.testbaseanroid.testImage;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import android.app.Activity;
import android.os.Bundle;

/**
 * 缩放
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_image_rotate)
public class Image_Retote extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
	}
}
