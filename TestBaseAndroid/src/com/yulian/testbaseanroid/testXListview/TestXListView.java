package com.yulian.testbaseanroid.testXListview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.util.Log;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.Constant;
import com.yulian.framework.RequestInfo;
import com.yulian.framework.activity.baseactivity.XBASE_Activity;
import com.yulian.framework.activity.common.XDataCallback;
import com.yulian.framework.utils.JsonUtil;
import com.yulian.framework.utils.ViewUtil;
import com.yulian.framework.view.xlistview.XListView;
import com.yulian.framework.view.xlistview.XListView.IXListViewListener;

@ContentView(R.layout.activity_test_xlistview)
public class TestXListView extends XBASE_Activity implements IXListViewListener{
	
	@ViewInject(R.id.lv_list)
	private XListView lv_list;
	private RoomAdapter adapter;
	private List<Map<String, Object>> list;
	private int page;
	private int pagesize;
	private int totalpage;
	private SimpleDateFormat sdf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		//初始化
		init();
		lv_list.setXListViewListener(this);
		
		queryServiceData(page, pagesize);
		
		adapter=new RoomAdapter(getApplicationContext(), list);
		lv_list.setAdapter(adapter);
	}
	private void init(){
		list=new ArrayList<Map<String,Object>>();
		page=1;
		pagesize=20;
		totalpage=1;
		sdf=new SimpleDateFormat("yyy-MM-dd :HH:mm:ss");
	}
	/**
	 * 查询服务端，并获得返回数据
	 * @param page
	 * @param pagesize
	 */
	private void queryServiceData(final int page,int pagesize){
		RequestInfo reqInfo=new RequestInfo();
		reqInfo.context=getApplicationContext();
		reqInfo.requestUrl="http://211.139.58.223:8001/appservice/rest/app/labelPrint/getSelectValue";
		reqInfo.params="{page:"+page
				+",pageSize:"+pagesize
				+",resclass:'"+"WIRELESS_QRCODE"
				+"',attributeenname:'"+"equiproom_id"
				+"',conditionValue:'"+""
				+"'}";
//		reqInfo.method="GET";
		super.getDataFromServer(reqInfo, new XDataCallback<String>() {
			@Override
			public void getDataFailed(HttpException httpException, String msg) {
				//错误提示信息
				ViewUtil.showToast(getApplicationContext(), Constant.EXCEPTION_STATE.get(httpException.getExceptionCode()));
			}
			@Override
			public void processData(String resultData) {
				Log.i("resultData", resultData);
				try {
					parseData(resultData);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				onLoad();
				if(page>=totalpage){
					lv_list.setPullLoadEnable(false);
				} else {
					lv_list.setPullLoadEnable(true);
				}
//				Log.i("parseData", "list size="+list.size());
				
				for(int i=0;i<list.size();i++){
					Map<String, Object> item=list.get(i);
					Log.i("list", "list["+i+"]="+(item.containsKey("text")?item.get("text").toString():""));
				}
				
				adapter.notifyDataSetChanged();
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
		totalpage=jsonObject.getInt("totalPages");
//		list=JsonUtil.getList(dataList);
		list.addAll(0, JsonUtil.getList(dataList));
	}
	
	private void onLoad() {
		lv_list.stopRefresh();
		lv_list.stopLoadMore();
		lv_list.setRefreshTime(sdf.format(new Date()));
	}
	@Override
	public void onRefresh() {
		Log.i("onRefresh", "onRefresh");
		try {
			list.clear();
			queryServiceData(page, pagesize);
			//通知适配器数据改变
			adapter.notifyDataSetChanged();
		} catch (Exception e) {
			e.printStackTrace();
			ViewUtil.showToast(TestXListView.this, "刷新失败");
		}
	}

	@Override
	public void onLoadMore() {
		Log.i("onLoadMore", "onLoadMore");
		page++;
		if(page<=totalpage){
			try {
				queryServiceData(page, pagesize);
				//通知适配器数据改变
				adapter.notifyDataSetChanged();
			} catch (Exception e) {
				e.printStackTrace();
				ViewUtil.showToast(TestXListView.this, "刷新失败");
			}
		}else{
			lv_list.setPullLoadEnable(false);
			ViewUtil.showToast(TestXListView.this, "已到最后一页");
		}
	}

}
