package com.codve.chapter2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    private Paint mPaint = new Paint();

    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL); // 填充模式
        mPaint.setStrokeWidth(1); // 画笔宽度为 10px
    }

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(100, 100, 500, 500, mPaint);

//        Rect rect = new Rect(200, 200, 400, 400);

//        RectF rect = new RectF(100, 100, 500, 500);
//        canvas.drawRect(rect, mPaint);

        // 绘制圆角矩形, rx, ry 表示椭圆的半径
//        RectF rect = new RectF(100, 100, 800, 400);
//        canvas.drawRoundRect(rect, 30, 30, mPaint);

//        RectF rect = new RectF(100, 100, 800, 400);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rect, mPaint);
//
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRoundRect(rect, 700, 400, mPaint);

        // 绘制椭圆
//        RectF rect = new RectF(100, 100, 800, 400);
//        canvas.drawOval(rect, mPaint);
//
//        canvas.drawOval(100, 100, 800, 400, mPaint);

        // 绘制圆
//        canvas.drawCircle(500, 500, 300, mPaint);

        // 绘制椭圆
        // startAngle 起始角度, endAngle 结束角度, useCenter 表示是否连接中心点
//        RectF rect = new RectF(100, 100, 800, 400);
//        canvas.drawArc(rect, 0, 90, true, mPaint);

//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(50);
//        canvas.drawCircle(500, 500, 300, mPaint);


        // 绘制一个饼状图
        initPaint();
        RectF rect = new RectF(350, 350, 650, 650);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(rect, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(rect, -90, 180, true, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(rect, 180, 30, true, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(rect, 210, 20, true, mPaint);

        mPaint.setColor(Color.CYAN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(rect, 230, 40, true, mPaint);

    }
}
