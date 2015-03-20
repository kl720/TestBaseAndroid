package com.yulian.testbaseanroid.testCheckBoxInListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 测试checkbox在listview中滑动导致状态消失
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_checkboxinlistview)
public class TestCheckBoxInListView extends Activity {
	@ViewInject(R.id.lv_test_cblv)
	private ListView lv_test_cblv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		List<Map<String, Object>> listMap=new ArrayList<Map<String,Object>>();
		for(int i=0;i<40;i++){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("value", "测试文本"+i);
			listMap.add(map);
		}
		
		CBAdapter adapter=new CBAdapter(listMap, this);
		
		lv_test_cblv.setAdapter(adapter);
	}
	
}
