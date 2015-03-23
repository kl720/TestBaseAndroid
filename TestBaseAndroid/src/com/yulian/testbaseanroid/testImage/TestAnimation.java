package com.yulian.testbaseanroid.testImage;

import com.example.testbaseandroid.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 测试动画效果
 * @author Administrator
 *
 */
@ContentView(R.layout.activity_test_animation)
public class TestAnimation extends Activity implements OnClickListener {
	@ViewInject(R.id.btn_an_rotate)
	private Button btn_an_rotate;
	@ViewInject(R.id.btn_an_scale)
	private Button btn_an_scale;
	@ViewInject(R.id.btn_an_skew)
	private Button btn_an_skew;
	@ViewInject(R.id.btn_an_translate)
	private Button btn_an_translate;
	@ViewInject(R.id.image_an_bg)
	private ImageView image_an_bg;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ViewUtils.inject(this);
		
		btn_an_skew.setOnClickListener(this);
		btn_an_rotate.setOnClickListener(this);
		btn_an_scale.setOnClickListener(this);
		btn_an_translate.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		
		Animation anim_alpha=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		Animation anim_rotate=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		Animation anim_scale=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
		Animation anim_translate=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
		
		switch (arg0.getId()) {
		case R.id.btn_an_skew:
			image_an_bg.startAnimation(anim_alpha);
			break;
		case R.id.btn_an_rotate:
			image_an_bg.startAnimation(anim_rotate);
			break;
		case R.id.btn_an_scale:
			image_an_bg.startAnimation(anim_scale);
			break;
		case R.id.btn_an_translate:
			image_an_bg.startAnimation(anim_translate);
			break;			
		default:
			break;
		}
	}
	


}
