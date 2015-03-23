package com.yulian.testbaseanroid.testImage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 
 * @author Administrator
 *
 */

public class MyView extends View {

	public MyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyView(Context context) {
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//创建画笔
		Paint p=new Paint();
		p.setAntiAlias(true);//设置使用抗锯齿功能
		p.setColor(Color.RED);
		p.setTextSize(18);
		p.setStyle(Style.STROKE);
		
		//创建路径
		Path path=new Path();
		path.addCircle(100, 100, 100, Path.Direction.CCW);//圆形路径
		//将该路径在画布上用画笔绘制
		canvas.drawPath(path, p);
		
		
		//圆环文字
		Path path1=new Path();
		path1.addCircle(300, 300, 100, Path.Direction.CW);//圆形路径
		p.setStyle(Style.FILL);
		String str="这是一段测试文本！这是一段测试文本！这是一段测试文本！这是一段测试文本！这是一段测试文本！";
		canvas.drawTextOnPath(str, path1, 0, -18, p);
		
		
		
	}
}
