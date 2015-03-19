package com.yulian.testbaseanroid.testXListview;

import java.util.List;
import java.util.Map;

import com.example.testbaseandroid.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RoomAdapter extends BaseAdapter {
	
	private Context context;
	private List<Map<String,Object>> list;
	
	public RoomAdapter(Context context, List<Map<String, Object>> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Map<String,Object> getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		Map<String,Object> item=list.get(arg0);
		if(arg1==null){
			arg1=LayoutInflater.from(context).inflate(R.layout.adapter_test_xlistview, null);
		}
		TextView txt_room=(TextView) arg1.findViewById(R.id.txt_room);
		txt_room.setText(String.valueOf(item.containsKey("text")?item.get("text"):""));
		return arg1;
	}

}
