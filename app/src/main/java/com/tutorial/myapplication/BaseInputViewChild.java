package com.tutorial.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class BaseInputViewChild extends LinearLayout {
    private Paint paint;
    private int height;
    private int width;
    private boolean isRemoveBorder;
    private LinearLayout.LayoutParams params;
    private Path path;
    private EditText editText;
    private BaseChildChangeSizeListener listener;

    public BaseInputViewChild(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseInputViewChild(@NonNull Context context) {
        super(context);
        init();
    }

    public BaseInputViewChild(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setListener(BaseChildChangeSizeListener listener) {
        this.listener = listener;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e("Chinh", "onFinishInflate");
        editText = new EditText(getContext());
        params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.height = 70;
        params.width = 70;
        editText.setBackgroundResource(android.R.color.transparent);
        editText.setLayoutParams(params);
        editText.setTextSize(15);
        editText.setCursorVisible(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setPadding(0, 0, 0, 0);
        addView(editText);
        editText.post(new Runnable() {
            @Override
            public void run() {
                width = editText.getWidth();
                height = editText.getHeight();
                path.moveTo(0, 0);
                path.lineTo(0, height);
                path.lineTo(width, height);
                path.lineTo(width, 0);
                Log.e("Chinh", "post: width: " + width);
                Log.e("Chinh", "post height: " + height);
                path.close();
                editText.requestLayout();
                invalidate();

                SquareRootView view = new SquareRootView(getContext());
                LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = 300;
                view.setLayoutParams(layoutParams);
                addView(view);
                view.requestLayout();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                if (s.length() > 0) {
                    isRemoveBorder = true;
                } else {
                    isRemoveBorder = false;
                    params.width = 70;
                    params.height = 70;
                }
                invalidate();
                measure(0, 0);

                editText.setLayoutParams(params);
                if (s.length() > 0 && listener != null) {
                    listener.onChildChangedText(params.width);
                }
                editText.requestLayout();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        this.params = (LinearLayout.LayoutParams) params;
        super.setLayoutParams(params);
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        setBackgroundResource(android.R.color.transparent);
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = h;
        width = w;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isRemoveBorder) {
            Log.e("Chinh", "onDraw");
            canvas.drawPath(path, paint);
        }
    }

    public interface BaseChildChangeSizeListener {
        void onChildChangedText(int width);
    }
}
