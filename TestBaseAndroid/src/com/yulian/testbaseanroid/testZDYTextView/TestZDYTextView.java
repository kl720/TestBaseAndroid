package com.yulian.testbaseanroid.testZDYTextView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.utils.ViewUtil;

/**
 * 测试自定义TextView
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_zdyimagetextview)
public class TestZDYTextView extends Activity {
	@ViewInject(R.id.itv_t1)
	private ImageTextView itv_t1;
	@ViewInject(R.id.itv_t2)
	private ImageTextView itv_t2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		
		itv_t1.setIamge(R.drawable.ic_launcher);
		itv_t1.setText("加载");
		
		itv_t2.setIamge(R.drawable.ic_delete);
		itv_t2.setText("删除");
		
		itv_t1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ViewUtil.showToast(getApplicationContext(), "加载");
			}
		});
		itv_t2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ViewUtil.showToast(getApplicationContext(), "删除");
			}
		});
	}
	
}
