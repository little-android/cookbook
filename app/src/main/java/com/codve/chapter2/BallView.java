package com.codve.chapter2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BallView extends View {

    private boolean drawable = false;
    private float currentX = 50;
    private float currentY = 50;
    private Paint mPaint = new Paint();

    public BallView(Context context) {
        this(context, null);
    }

    public BallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.light_red));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (drawable) {
            canvas.drawCircle(currentX, currentY, 50, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawable = true;
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }
}
