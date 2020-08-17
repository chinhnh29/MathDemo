package com.tutorial.myapplication.demo2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.tutorial.myapplication.R;

public class NumberRootView extends LinearLayout {
    private Paint paint;
    private boolean isDrawSymbol;
    private Path path;

    private EditText edtChild;
    private EditText edtBase;

    private int widthChildView = 50;
    private int heightChildView = 60;

    private int widthBaseView = 75;
    private int heightBaseView = 110;
    private int leftMgBaseView = (int) (0.5 * widthChildView);

    private int heightSymbol = 160;
    private int marginTopSymbol = 20;
    private int leftMgSymbol = (int) (leftMgBaseView + widthChildView - 0.2 * widthChildView);

    public NumberRootView(Context context) {
        super(context);
        init();
    }

    public NumberRootView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        drawInputChild();
        drawInputBase();
        edtChild.post(new Runnable() {
            @Override
            public void run() {
                drawSymbol(edtChild.getWidth());
                isDrawSymbol = true;
            }
        });
    }

    private void drawInputChild() {
        edtChild = new EditText(getContext());
        LayoutParams edtParam = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        edtParam.width = widthChildView;
        edtParam.height = heightChildView;
        edtParam.gravity = Gravity.START;
        edtChild.setLayoutParams(edtParam);

        edtChild.setBackground(getResources().getDrawable(R.drawable.bg_border));
        edtChild.setTextSize(15);
        edtChild.setCursorVisible(true);
        edtChild.setFocusable(true);
        edtChild.setFocusableInTouchMode(true);
        edtChild.setPadding(0, 0, 0, 0);
        edtChild.setTextColor(getResources().getColor(R.color.black));
        addView(edtChild);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isDrawSymbol) {
            canvas.drawPath(path, paint);
        }
    }

    private void drawInputBase() {
        edtBase = new EditText(getContext());
        LayoutParams edtParam = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        edtParam.width = widthBaseView;
        edtParam.height = heightBaseView;
        edtParam.topMargin = 35;
        edtParam.leftMargin = leftMgBaseView;
        edtBase.setLayoutParams(edtParam);

        edtBase.setBackground(getResources().getDrawable(R.drawable.bg_border));
        edtBase.setTextSize(15);
        edtBase.setCursorVisible(true);
        edtBase.setFocusable(true);
        edtBase.setFocusableInTouchMode(true);
        edtBase.setPadding(0, 0, 0, 0);
        edtBase.setTextColor(getResources().getColor(R.color.black));
        addView(edtBase);
        isDrawSymbol = true;
        invalidate();
    }

    private void drawSymbol(int width) {
        path.moveTo(0, heightSymbol / 1.8f);
        path.lineTo(width / 2f, heightSymbol / 2f);
        path.lineTo(width, heightSymbol);
        path.lineTo(leftMgSymbol, marginTopSymbol);
        path.lineTo(leftMgSymbol + width * 2, marginTopSymbol);
        path.lineTo(leftMgSymbol + width * 2, marginTopSymbol * 2);
        invalidate();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(7);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorPrimary));

        path = new Path();
    }
}
