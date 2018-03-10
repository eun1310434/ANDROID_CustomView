/*=====================================================================
□ Infomation
  ○ Data : 09.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 뷰를 상속하여 만든 뷰
  ○ 터치 이벤트
     - 터치한 위치에 원그리기
     - 처음 터치한 좌표, 터치 중인 좌표, 마지막 터치한 좌표를 출력

□ Study
  ○
=====================================================================*/

package com.eun1310434.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class CustomView extends View {
	
	//그리기할 때 사용하는 속성을 담고 있는 페인트 객체
	private TextView tv;
	private Paint paint;
	private Paint paint_txt;

	int widthMode;
	int heightMode;

	int width;
	int height;

	int startPointX = 0; //터치 시작 점X
	int startPointY = 0; //터치 시작 점Y

	int touchPointX = 0; //터치 움직이는 점X
	int touchPointY = 0; //터치 움직이는 점Y

	int finishPointX = 0; //터치 종료 점X
	int finishPointY = 0; //터치 종료 점Y




	public CustomView(Context context) {
		super(context);
		setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

		paint = new Paint();
		paint.setColor(getResources().getColor(R.color.colorAccent));

		paint_txt  = new Paint();
		paint_txt.setColor(Color.WHITE);
		paint_txt.setTextSize(80);
	}


	public CustomView(Context context, @Nullable AttributeSet attrs, Paint paint) {
		super(context, attrs);
		setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

		paint = new Paint();
		paint.setColor(getResources().getColor(R.color.colorAccent));

		paint_txt  = new Paint();
		paint_txt.setColor(Color.WHITE);
		paint_txt.setTextSize(80);
	}

	//그리기 - 그리기가 새롭게 정의되면 invalidate();를 호출시 업데이트 됨
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//canvas.drawRect(200, 200, 400, 400, paint);
		canvas.drawCircle(touchPointX-25, touchPointY-25, 50, paint); // 원그리기
		canvas.drawText("Start ("+startPointX+","+startPointX+")",20, height - paint_txt.getTextSize()*2 -30, paint_txt); //처음 터치한 곳에 원그리기
		canvas.drawText("Move ("+touchPointX+","+touchPointY+")",20, height - paint_txt.getTextSize() -30, paint_txt); // 터치중인 곳에 원그리기
		canvas.drawText("Finish ("+finishPointX+","+finishPointY+")",20, height -20 , paint_txt);// 마지막 터치한 곳에 원그리기
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		//모드(가로, 세로) 측정
		widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
		heightMode = View.MeasureSpec.getMode(heightMeasureSpec);

		//측정된 폭과 높이 측정
		width = View.MeasureSpec.getSize(widthMeasureSpec);
		height = View.MeasureSpec.getSize(heightMeasureSpec);
	}

	//터치 이벤트
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();
		touchPointX = (int) event.getX();
		touchPointY = (int) event.getY();

		if(action == MotionEvent.ACTION_UP){
			Log.e("onTouchEvent","ACTION_MOVE");
			finishPointX = touchPointX;
			finishPointY = touchPointY;
			paint.setColor(getResources().getColor(R.color.colorAccent));
		}else if (action == MotionEvent.ACTION_DOWN) {
			Log.e("onTouchEvent","ACTION_DOWN");
			startPointX = touchPointX;
			startPointY = touchPointY;
			finishPointX = 0;
			finishPointY = 0;
			paint.setColor(Color.RED);

		}else if(action == MotionEvent.ACTION_MOVE){
			Log.e("onTouchEvent","ACTION_MOVE");
		}


		//invalidate() - void onDraw(Canvas canvas)를 불러냄
		invalidate();

		return true;
		//return super.onTouchEvent(event);
	}

}
