package com.yulian.testbaseanroid.testImage;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 测试图像的旋转，缩放，倾斜，平移
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_image)
public class TestImage extends Activity implements OnClickListener{
	@ViewInject(R.id.btn_rotate)
	private Button btn_rotate;
	@ViewInject(R.id.btn_scale)
	private Button btn_scale;
	@ViewInject(R.id.btn_skew)
	private Button btn_skew;
	@ViewInject(R.id.btn_translate)
	private Button btn_translate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		btn_rotate.setOnClickListener(this);
		btn_scale.setOnClickListener(this);
		btn_skew.setOnClickListener(this);
		btn_translate.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent();
		switch (arg0.getId()) {
		case R.id.btn_rotate:
			intent.setClass(getApplicationContext(), Image_Retote.class);
			startActivity(intent);
			break;
		case R.id.btn_scale:
			intent.setClass(getApplicationContext(), Image_Scale.class);
			startActivity(intent);
			break;
		case R.id.btn_skew:
			intent.setClass(getApplicationContext(), Image_Skew.class);
			startActivity(intent);
			break;
		case R.id.btn_translate:
			intent.setClass(getApplicationContext(), Image_Translate.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		
	}
}
