package com.yulian.testbaseanroid.testSwipeListview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.RequestInfo;
import com.yulian.framework.activity.baseactivity.XBASE_FragmentActivity;
import com.yulian.framework.activity.common.XDataCallback;
import com.yulian.framework.utils.JsonUtil;
import com.yulian.framework.utils.PreferencesUtil;
import com.yulian.framework.utils.ViewUtil;
import com.yulian.framework.view.swipe.common.OnMenuItemClickListener;
import com.yulian.framework.view.swipe.common.SwipeMenu;
import com.yulian.framework.view.swipe.common.SwipeMenuCreator;
import com.yulian.framework.view.swipe.common.SwipeMenuItem;
import com.yulian.framework.view.swipe.swipelistview.SwipeMenuListView;
import com.yulian.testbaseanroid.testXListview.RoomAdapter;

@ContentView(R.layout.activity_test_swipelistview)
public class TestSwipeListview extends XBASE_FragmentActivity{
	
	@ViewInject(R.id.slv_room)
	private SwipeMenuListView slv_room;
	private RoomAdapter roomAdapter;
	private List<Map<String, Object>> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_test_swipelistview);
		ViewUtils.inject(this);
		
//		slv_room=(SwipeMenuListView) findViewById(R.id.slv_room);
		
		list=new ArrayList<Map<String,Object>>();
		queryServiceData();
		
		String username=(String) PreferencesUtil.get(getApplicationContext(), "usernames", "kong");
		ViewUtil.showToast(getApplicationContext(), username);
		
		SwipeMenuCreator creator=new SwipeMenuCreator() {			
			@Override
			public void create(SwipeMenu menu) {
				SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
				// set item background
				openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,0xCE)));
				// set item width
				openItem.setWidth(100);
				// set item title
				openItem.setTitle("Open");
				// set item title fontsize
				openItem.setTitleSize(25);
				// set item title font color
				openItem.setTitleColor(Color.WHITE);
				// add to menu
				menu.addMenuItem(openItem);

				// create "delete" item
				SwipeMenuItem deleteItem = new SwipeMenuItem(
						getApplicationContext());
				// set item background
				deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
						0x3F, 0x25)));
				// set item width
				deleteItem.setWidth(100);
				// set a icon
				deleteItem.setIcon(R.drawable.ic_delete);
				// add to menu
				menu.addMenuItem(deleteItem);
			}
		};
		
		slv_room.setMenuCreator(creator);
		
		slv_room.setOnMenuItemClickListener(new OnMenuItemClickListener() {	
			@Override
			public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

				switch (index) {
				case 0:
					open();
					break;
				case 1:
					delete(position);
					break;
				default:
					break;
				}
				return false;
			}
		});
	}
	 
	private void open(){
		ViewUtil.showToast(getApplicationContext(), "open");
	}
	private void delete(int position){
		list.remove(position);
		roomAdapter.notifyDataSetChanged();
		ViewUtil.showToast(getApplicationContext(), "delete");
	}
	
	private void queryServiceData(){
		RequestInfo reqInfo=new RequestInfo();
		reqInfo.context=getApplicationContext();
		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/getSelectValue";
		reqInfo.params="{page:"+1
				+",pageSize:"+2
				+",resclass:'"+"WIRELESS_QRCODE"
				+"',attributeenname:'"+"equiproom_id"
				+"',conditionValue:'"+""
				+"'}";
		super.getDataFromServer(reqInfo, new XDataCallback<String>() {
			@Override
			public void processData(String resultData) {
				Log.i("resultData", resultData);
				try {
					parseData(resultData);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				roomAdapter=new RoomAdapter(getApplicationContext(), list);
				roomAdapter.notifyDataSetChanged();
				slv_room.setAdapter(roomAdapter);	
			}
			@Override
			public void getDataFailed(HttpException httpException, String msg) {
				httpException.printStackTrace();
				ViewUtil.showToast(getApplicationContext(), msg);
			}
		});
	}
	/**
	 * 数据解析
	 * @param resultData
	 * @throws JSONException
	 */
	private void parseData(String resultData) throws JSONException{
		
		JSONObject jsonObject=new JSONObject(resultData);
		if(!jsonObject.getBoolean("success")){
			ViewUtil.showToast(getApplicationContext(), jsonObject.getString("msg"));
			return;
		}
		
		String dataList=jsonObject.getString("data");
		list=JsonUtil.getList(dataList);
	}
}
