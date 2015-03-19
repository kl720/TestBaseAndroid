package com.yulian.testbaseanroid.testbaseactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.RequestInfo;
import com.yulian.framework.activity.baseactivity.BASE_Activity;
import com.yulian.framework.activity.baseactivity.BASE_FragmentActivity;
import com.yulian.framework.activity.common.DataCallback;

@ContentView(R.layout.activity_main)
public class TestBaseActivity extends BASE_FragmentActivity {

	@ViewInject(R.id.txt_content)
	private TextView txt_content;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		txt_content.setText("testqq");
	}


	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processLogic() {
		Log.i("processLogic", "jin ru processLogic()");
		RequestInfo reqInfo=new RequestInfo();
		reqInfo.context=getApplicationContext();
		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/queryResourceNote";
		
		super.getDataFromServer(reqInfo, new DataCallback<String>() {

			@Override
			public void processData(String paramObject) {
				Log.i("paramObject", paramObject);
				txt_content.setText(paramObject);
			}
			@Override
			public void getDataFailed() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	

}
