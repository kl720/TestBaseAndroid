package com.yulian.testbaseanroid.testbaseactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.RequestInfo;
import com.yulian.framework.activity.baseactivity.XBASE_FragmentActivity;
import com.yulian.framework.activity.common.XDataCallback;

@ContentView(R.layout.activity_main)
public class TestXBaseActivity extends XBASE_FragmentActivity {

	@ViewInject(R.id.txt_content)
	private TextView txt_content;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		txt_content.setText("testqq");
		
		processLogic();
	}


	


	protected void processLogic() {
		Log.i("processLogic", "jin ru processLogic()");
//		RequestInfo reqInfo=new RequestInfo();
//		reqInfo.context=getApplicationContext();
//		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/queryResourceNote";
		
//		RequestInfo reqInfo=new RequestInfo();
//		reqInfo.context=getApplicationContext();
//		reqInfo.method="GET";
//		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/getQueryCondition";
//		reqInfo.params="{resclassname:'WIRELESS_QRCODE'}";
		
		RequestInfo reqInfo=new RequestInfo();
		reqInfo.context=getApplicationContext();
//		reqInfo.method="GET";
		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/getSelectValue";
		reqInfo.params="{page:"+1
				+",pageSize:"+20
				+",resclass:'"+"WIRELESS_QRCODE"
				+"',attributeenname:'"+"equiproom_id"
				+"',conditionValue:'"+""
				+"'}";
		
		super.getDataFromServer(reqInfo, new XDataCallback<String>() {
			@Override
			public void processData(String paramObject) {
				Log.i("paramObject", paramObject);
				txt_content.setText(paramObject);
			}
			@Override
			public void getDataFailed(HttpException httpException, String msg) {
				httpException.printStackTrace();
				Log.i("paramObject", "msg="+msg);
			}
		});
		
	}
	
	

}
