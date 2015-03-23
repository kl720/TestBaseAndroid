package com.yulian.testbaseanroid.testImage;

import com.example.testbaseandroid.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 倾斜视图
 * @author Administrator
 *
 */
public class View_Skew extends View {

	public View_Skew(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public View_Skew(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public View_Skew(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		Paint paint=new Paint();
		
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.image_m);
		canvas.drawBitmap(bitmap, 0, 0, paint);//绘制原图
		
		Matrix matrix=new Matrix();
		matrix.setScale(0.2f, 0.2f);
		
		matrix.setSkew(0.2f, 0.8f);
		canvas.drawBitmap(bitmap, matrix, paint);//绘制倾斜图
		
		matrix.setSkew(0.2f, 0.8f,100,100);
		canvas.drawBitmap(bitmap, matrix, paint);//绘制倾斜图
	}

}
