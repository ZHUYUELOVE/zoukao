package com.zhuyue.bwie.com.zhuyue20181203.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuyue.bwie.com.zhuyue20181203.R;

public class MyXHView extends LinearLayout {


    private EditText mEditText;
    private TextView mCancel;

    public MyXHView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.myxhview, this);
        mEditText = findViewById(R.id.Search_Edit);
        mCancel = findViewById(R.id.Cancel_Text);

    }

    public String getEditStr() {
        return mEditText.getText().toString();
    }

    public TextView getmCancle() {
        return mCancel;
    }
}
