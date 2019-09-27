package com.codve.chapter2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

// 绘制文字和图片
public class WordView extends View {

    private Picture mPicture = new Picture();

    public WordView(Context context) {
        this(context, null);
    }

    public WordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        record();
    }

    // 开始录制内容
    private void record() {
        Canvas canvas = mPicture.beginRecording(500, 500);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.translate(250, 250);
        canvas.drawCircle(0, 0, 100, paint);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPicture(mPicture);

    }
}
