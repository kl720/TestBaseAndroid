package com.yulian.testbaseanroid.testImage;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 测试画笔的使用
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_main)
public class TestPaint extends Activity {
	@ViewInject(R.id.txt_content)
	private TextView txt_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		txt_content.setText("测试绘图");
	}
	
}
