package com.yulian.testbaseanroid.testCheckBoxInListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.testbaseandroid.R;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CBAdapter extends BaseAdapter {
	
	private List<Map<String, Object>> listMap;
	private Context cxt;
	private Map<Integer,Boolean> selectMap;
	
	
	
	public CBAdapter(List<Map<String, Object>> listMap, Context cxt) {
		super();
		this.listMap = listMap;
		this.cxt = cxt;
		this.selectMap = new HashMap<Integer, Boolean>();
		initNoCheck(false);
	}

	@Override
	public int getCount() {
		return listMap.size();
	}

	@Override
	public Map<String, Object> getItem(int arg0) {
		return listMap.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(final int position, View arg1, ViewGroup arg2) {
		
		Log.i(CBAdapter.class.toString(), "getView execute"+",position="+position+"selected="+selectMap.get(position));
		
		Map<String, Object> item=getItem(position);
		
		LinearLayout ll=(LinearLayout) LayoutInflater.from(cxt).inflate(R.layout.item_checkboxinlistview, null);
		
		
		CheckBox cblv_cb=(CheckBox) ll.findViewById(R.id.cblv_cb);
		TextView cblv_tv=(TextView) ll.findViewById(R.id.cblv_tv);
		
	
		cblv_cb.setChecked(selectMap.get(position));
		cblv_tv.setText(item.get("value").toString());
		
		cblv_cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				
				selectMap.put(position, arg1);
				Log.i("onCheckedChanged", selectMap.toString());
			}
		});
		
		if(position%2==1){
			ll.setBackgroundColor(Color.GREEN);
		}
			
		return ll;
	}
	
	public void initNoCheck(boolean bool){
		if(listMap==null){
			return;
		}
		for(int i=0;i<listMap.size();i++){
			selectMap.put(i, bool);
		}
	}
	
}
