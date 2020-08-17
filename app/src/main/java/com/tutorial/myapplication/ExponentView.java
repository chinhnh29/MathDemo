package com.tutorial.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class ExponentView extends AppCompatEditText {
    private Paint paint;
    private int height = 83;
    private int width = 83;
    private boolean isRemoveBorder;

    public ExponentView(@NonNull Context context) {
        super(context);
        init();
    }

    public ExponentView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExponentView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        height = h;
//        Log.e("Chinh", "height ExponentView: " + height);
//        width = w;
//        Log.e("Chinh", "width ExponentView: " + width);
//        invalidate();
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        if (!isRemoveBorder) {
        height = 83;
        width = 83;
        canvas.drawLine(0, 0, 0, height, paint);
        canvas.drawLine(0, height, width, height, paint);
        canvas.drawLine(width, height, width, 0, paint);
        canvas.drawLine(width, 0, 0, 0, paint);
//        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
//        if (text.length() >= 1) {
//            isRemoveBorder = true;
//            measure(0, 0);
//            params.width = getMeasuredWidth();
//            if (text.length() > 1 && listener != null) {
//                listener.onChanged(getMeasuredWidth());
//                setLayoutParams(params);
//            }
//            invalidate();
//        } else {
//            if (params != null) {
//                params.width = 90;
//                setLayoutParams(params);
//            }
//            isRemoveBorder = false;
//            invalidate();
//        }
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        setBackgroundResource(android.R.color.transparent);
    }
}
