package com.yulian.testbaseanroid.testZDYTextView;

import com.example.testbaseandroid.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageTextView extends LinearLayout {
	
	private ImageView iv;
	private TextView tv;
	private Context context;
	
	public ImageTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ImageTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);	
	}

	public ImageTextView(Context context) {
		super(context);
		init(context);
	}
	private void init(Context context){
		
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);        
		inflater.inflate(R.layout.weight_zdy_imagetextview, this);       
		iv=(ImageView) findViewById(R.id.t_iv);        
		tv=(TextView)findViewById(R.id.t_tv);		

//		LinearLayout view=(LinearLayout) LayoutInflater.from(context).inflate(R.layout.weight_zdy_imagetextview, null);
//		this.iv=(ImageView)findViewById(R.id.t_iv);
//		this.tv=(TextView) findViewById(R.id.t_tv);
//		this.context=context;
	}
	
	public void setIamge(int imageid){
		iv.setBackgroundResource(imageid);
	}
	public void setText(String text){
		tv.setText(text);
	}
	
	
	
}
