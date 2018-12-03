package com.zhuyue.bwie.com.zhuyue20181203.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuyue.bwie.com.zhuyue20181203.R;

import java.util.ArrayList;

public class MyFloatLayout extends LinearLayout {

    private int mScreenWidth;
    private int mScreenHeigth;
    private String mColor;

    public MyFloatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mScreenWidth = metrics.widthPixels;
        mScreenHeigth = metrics.heightPixels;

        setOrientation(VERTICAL);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientColor);
        if (typedArray != null) {
            mColor = (String) typedArray.getText(R.styleable.GroupDemoView_textColor);
        }

    }
    public void removeChildView() {
        //移除所有子控件
        removeAllViews();

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    public void setData(ArrayList<String> data) {
        LinearLayout linearLayout = getLin();
        for (int i = 0; i < data.size(); i++) {
            final String tmp = data.get(i);
            int numWidth = 0;


            int childCount = linearLayout.getChildCount();
            for (int j = 0; j < childCount; j++) {

                TextView tv = (TextView) linearLayout.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
                int leftMargin = layoutParams.leftMargin;

                tv.measure(getMeasuredWidth(), getMeasuredHeight());
                numWidth += tv.getMeasuredWidth() + leftMargin + tv.getPaddingLeft() + getPaddingRight();
            }
            TextView dataText=getText();
            dataText.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),tmp,Toast.LENGTH_SHORT).show();
                }
            });

            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.leftMargin=15;
            params.topMargin=10;
            dataText.setLayoutParams(params);
            dataText.setText(tmp);
            dataText.measure(getMeasuredWidth(),getMeasuredHeight());
            int dataTextWidth=dataText.getMeasuredWidth()+dataText.getPaddingLeft()+dataText.getPaddingRight();

            if (mScreenWidth>=numWidth+dataTextWidth){
                linearLayout.addView(dataText);
            }else {

                linearLayout = getLin();
                linearLayout.addView(dataText);
            }

        }

    }

    //初始化子LinearLayout
    private LinearLayout getLin() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        //LayoutParams  控制组件大小的一个工具类
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);

        this.addView(linearLayout);
        return linearLayout;
    }

    private TextView getText() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(20);
        textView.setTextColor(Color.parseColor(mColor));
        textView.setBackgroundResource(R.drawable.text_style);
        textView.setPadding(10,3,10,3);
        return textView;
    }



}
