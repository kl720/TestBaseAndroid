package com.yulian.testbaseanroid.testshoushisb;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yulian.framework.utils.ViewUtil;
import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

@ContentView(R.layout.activity_test_shoushisb)
public class TestShoushiSB extends Activity implements OnTouchListener,OnGestureListener {
	@ViewInject(R.id.iv_test_iamge)
	private ImageView iv_test_iamge;
	
	private GestureDetector detector;
	private int[] iamges=new int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
	private int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		detector=new GestureDetector(this);
		index=0;
		
		//第一次打开，设置默认图片
		iv_test_iamge.setImageResource(0);
		//设置触摸监听事件
		iv_test_iamge.setOnTouchListener(this);
		//处理轻触以外的事件了，例如抛掷动作。
		iv_test_iamge.setLongClickable(true);
		//是否监听长按事件
		detector.setIsLongpressEnabled(true);
	}
	/**
	 * 返回上一张图片
	 */
	private void goback(){
		Log.i("goback", "index="+index);
		index--;
		if(index<=0){
			ViewUtil.showLongToast(getApplicationContext(), "已移动到第一张");
			return;
		}		
		index=Math.abs(index%iamges.length);
		iv_test_iamge.setImageResource(iamges[index]);
	}
	/**
	 * 下一张图片
	 */
	private void goNext(){
		Log.i("goNext", "index="+index);
		index++;
		if(index>=iamges.length){
			ViewUtil.showLongToast(getApplicationContext(), "已移动到最后一张");
			return;
		}	
		index=Math.abs(index%iamges.length);
		iv_test_iamge.setImageResource(iamges[index]);
	}
	@Override
	public boolean onDown(MotionEvent arg0) {//在按下动作时被调用

		Log.i("execute method", "onDown");
		return false;
	}
	
	int verticalMinDistance=50;//移动最小距离
	int minVelocity=0;//移动速度
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {//在抛掷动作时被调用
		
//		1.e1  手势起点的移动事件   
//		2.e2  当前手势点的移动事件   
//		3.velocityX 每秒x轴方向移动的像素   
//		4.velocityY 每秒y轴方向移动的像素 
		
		float xdistance1=e1.getX()-e2.getX();
		float xdistance2=e1.getRawX()-e2.getRawX();
		float ydistance1=e1.getY()-e2.getY();
		float ydistance2=e1.getRawY()-e2.getRawY();
		Log.i("execute method", "onFling");
		Log.i("平移距离", "xdistance1="+xdistance1+",xdistance2="+xdistance2);
		Log.i("垂直距离", "ydistance1="+ydistance1+",ydistance2="+ydistance2);
		
		//判断是否有滑动
		if(Math.abs(velocityX)<=0){//无滑动
			return false;
		}
		
		//判断左滑还是右滑
		if(xdistance1>0){//左滑
			//滑动距离判断
			if(Math.abs(xdistance1)>verticalMinDistance){
				goNext();
			}
		}else{//右滑
			//滑动距离判断
			if(Math.abs(xdistance1)>verticalMinDistance){
				goback();
			}
		}
		
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {//在长按时被调用

		Log.i("execute method", "onLongPress");

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {//在滚动时调用

		Log.i("execute method", "onScroll");
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {//在按住时被调用

		Log.i("execute method", "onShowPress");

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {//在抬起时被调用

		Log.i("execute method", "onSingleTapUp");
		return false;
	}
	
	//重写OnTouchListener的onTouch方法 
	//此方法在触摸屏被触摸，即发生触摸事件（接触和抚摸两个事件，挺形象）的时候被调用。
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		Log.i("execute method", "onTouch");

		return detector.onTouchEvent(arg1);
	}

}
