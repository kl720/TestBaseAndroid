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
 * 旋转视图
 * @author Administrator
 *
 */
public class View_Retote extends View {

	public View_Retote(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public View_Retote(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public View_Retote(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		Paint paint=new Paint();
		Bitmap bg=BitmapFactory.decodeResource(getResources(),R.drawable.image_bg);
		
		Matrix matrix=new Matrix();
		matrix.setRotate(30);
		canvas.drawBitmap(bg, matrix, paint);
//		canvas.drawBitmap(bg, 0, 0, paint);
		
		matrix.setRotate(10, 300, 300);
		canvas.drawBitmap(bg, matrix, paint);
	}

}
