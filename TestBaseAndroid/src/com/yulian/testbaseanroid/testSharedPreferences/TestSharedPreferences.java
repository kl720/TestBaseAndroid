package com.yulian.testbaseanroid.testSharedPreferences;

import com.example.testbaseandroid.R;
import com.yulian.framework.utils.PreferencesUtil;
import com.yulian.framework.utils.ViewUtil;
import android.app.Activity;
import android.os.Bundle;

public class TestSharedPreferences extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		PreferencesUtil.put(getApplicationContext(), "username", "zs");

		String username=(String) PreferencesUtil.get(getApplicationContext(), "username", "kong");
		
		ViewUtil.showToast(getApplicationContext(), username);
	}
}
