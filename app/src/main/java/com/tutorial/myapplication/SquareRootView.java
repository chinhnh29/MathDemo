package com.tutorial.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class SquareRootView extends LinearLayout implements BaseInputView.BaseChangeSizeListener, BaseInputViewChild.BaseChildChangeSizeListener {
    private Paint paint;
    private int heightInput;
    private int widthInput;

    private Path path;

    public SquareRootView(Context context) {
        super(context);
        init();
    }

    public SquareRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareRootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final BaseInputViewChild child = new BaseInputViewChild(getContext());
        final LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params1.width = 70;
        params1.height = 70;
        child.setLayoutParams(params1);
//        child.setListener(this);
        addView(child);
        final BaseInputView baseInputView2 = new BaseInputView(getContext());
        final LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.width = 190;
        params2.height =190;
        baseInputView2.setLayoutParams(params2);
        baseInputView2.setListener(this);
        addView(baseInputView2);
        final BaseInputView baseInputView = new BaseInputView(getContext());
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = 90;
        baseInputView.setLayoutParams(params);
        baseInputView.setListener(this);
        addView(baseInputView);
        baseInputView.post(new Runnable() {
            @Override
            public void run() {
                widthInput = baseInputView.getWidth();
                Log.e("Chinh", "widthInput: "  + widthInput);
                heightInput = baseInputView.getHeight();
                path.moveTo(0, heightInput / 2);
                path.lineTo(widthInput / 6, heightInput / 2);
                path.lineTo((float) (widthInput / 2.2), heightInput + heightInput / 7);
                path.lineTo((float) (widthInput / 2.2), 0);
                path.lineTo(widthInput + (int) (widthInput / 1.2), 0);
//                path.close();

                params.leftMargin = (int) (widthInput / 1.4);
                params.topMargin = heightInput / 7;
                params.bottomMargin = heightInput / 7;
                baseInputView.requestLayout();
                invalidate();

                Log.e("Chinh", "" + baseInputView.getHeight() + " " + baseInputView.getWidth());
            }
        });
        Log.e("Chinh", "onFinishInflate");
    }


    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(7);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorPrimary));

        path = new Path();
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawPath(path, paint);
        Log.e("Chinh", "dispatchDraw");
    }

    @Override
    public void onChangedText(int width) {
        Log.e("Chinh", "onChanged");
        path.moveTo(0, heightInput / 2);
        path.lineTo(widthInput / 6, heightInput / 2);
        path.lineTo((float) (widthInput / 2.2), heightInput + heightInput / 7);
        path.lineTo((float) (widthInput / 2.2), 0);
        path.lineTo(width + (int) (widthInput / 1.2), 0);
        invalidate();
    }

    @Override
    public void onChildChangedText(int width) {

    }
}
