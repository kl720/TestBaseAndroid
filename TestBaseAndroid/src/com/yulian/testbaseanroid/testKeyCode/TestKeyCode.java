package com.yulian.testbaseanroid.testKeyCode;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.yulian.framework.utils.ViewUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 测试键盘事件
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_keycode)
public class TestKeyCode extends Activity  implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
	}
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if(keyCode==KeyEvent.KEYCODE_BACK){
			return true;
		}
		
		if(keyCode==KeyEvent.KEYCODE_VOLUME_UP){
			ViewUtil.showLongToast(this, "音量增加");
			return false;
		}
		if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
			ViewUtil.showLongToast(this, "音量减小");
			return false;
		}
		
		return super.onKeyDown(keyCode, event);
	}


	@Override
	public void onClick(View arg0) {
		
	}
}
