package com.yulian.testbaseanroid.testHVScrollListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.view.hvscrolllistview.HVScrollListView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

@ContentView(R.layout.activity_test_hvscrolllistview)
public class TestHVScrollListView extends Activity {
	@ViewInject(R.id.hv_data1)
	private HVScrollListView hv_data1;
	@ViewInject(R.id.btn_selectitem)
	private Button btn_selectitem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		//数据初始化
		String[] arr_title=new String[]{"第0列","第1列","第2列","第3列","第4列","第5列","第6列","第7列","第8列","第9列"};
		String[] arr_key=new String[]{"key1","key2","key3","key4","key5","key6","key7","key8","key9","key10"};
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for(int i=0;i<60;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			for(int j=0;j<arr_key.length;j++){
				map.put(arr_key[j], "this is test content,"+i+"_"+j);
			}
			list.add(map);
		}
		
		hv_data1.setTitle(arr_title);
		hv_data1.setKey(arr_key);
		hv_data1.setData(list);
		
		hv_data1.init(this,false);
		
		
		
		btn_selectitem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				List<Map<String, Object>> selectList=hv_data1.getSelectItems();
				if(selectList==null){
					Log.i("selectList", "kong");
					return;
				}
				Log.i("selectList", selectList.toString());
			}
		});
		
		
	}
}
