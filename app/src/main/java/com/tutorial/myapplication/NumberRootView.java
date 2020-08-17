package com.tutorial.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class NumberRootView extends RelativeLayout implements BaseInputViewChild.BaseChildChangeSizeListener {
    SquareRootView squareRootView;
    LayoutParams layoutParams;

    LinearLayout linearLayout;

    public NumberRootView(Context context) {
        super(context);
        init();
    }

    private void init() {
        linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        addView(linearLayout, relativeParams);
        squareRootView = new SquareRootView(getContext());
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 200;
        layoutParams.height = 200;
        squareRootView.setLayoutParams(layoutParams);
        squareRootView.requestLayout();
        linearLayout.addView(squareRootView);
        invalidate();
    }

    public NumberRootView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumberRootView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//        EditText editText = new EditText(getContext());
//        editText.setLayoutParams(new ViewGroup.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        addView(editText);
//        final BaseInputViewChild child = new BaseInputViewChild(getContext());
//        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        params.width = 200;
//        params.height = 200;
//        child.setLayoutParams(params);
//        Log.e("Chinh", "params.width: " + params.width);
//        Log.e("Chinh", "params.height: " + params.height);
//        child.setListener(this);
//        addView(child);
//        child.post(new Runnable() {
//            @Override
//            public void run() {
//                int width = child.getWidth();
//                squareRootView = new SquareRootView(getContext());
//                layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.leftMargin = width;
//                squareRootView.setLayoutParams(layoutParams);
//                addView(squareRootView);
//                squareRootView.requestLayout();
//            }
//        });

//        int width = child.getWidth();
        squareRootView = new SquareRootView(getContext());
        layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 200;
        layoutParams.height = 200;
        squareRootView.setLayoutParams(layoutParams);
        squareRootView.requestLayout();
        linearLayout.addView(squareRootView);
        invalidate();
    }

    @Override
    public void onChildChangedText(int width) {
//        layoutParams.leftMargin = width;
//        squareRootView.setLayoutParams(layoutParams);
//        squareRootView.requestLayout();
    }
}
