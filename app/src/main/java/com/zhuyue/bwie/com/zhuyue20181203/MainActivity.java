package com.zhuyue.bwie.com.zhuyue20181203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhuyue.bwie.com.zhuyue20181203.SQLitem.MyDao;
import com.zhuyue.bwie.com.zhuyue20181203.weight.MyFloatLayout;
import com.zhuyue.bwie.com.zhuyue20181203.weight.MyXHView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = {"欧娜", "豆豆鞋", "电动牙刷", "石榴", "榴莲", "苹果", "香蕉", "哈蜜瓜", "橘子", "沐浴露", "牙膏"};
    private MyFloatLayout MyFloat_Layout;
    private MyFloatLayout mHistoryLayout;
    private MyXHView mHeadView;
    private MyDao mDao;
    private ArrayList<String> mList = new ArrayList<>();
    private ArrayList<String> mHistory = new ArrayList<>();
    private TextView mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDao = new MyDao(this);
        mHistory = mDao.selectName();
        initData();
        initViews();
        if (!mHistory.isEmpty()) {
            mHistoryLayout.setData(mHistory);
        }
    }


    private void initData() {
        for (int i = 0; i < data.length; i++) {
            mList.add(data[i]);
        }
    }

    private void initViews() {
        mDelete = findViewById(R.id.Delete_Text);
        mDelete.setOnClickListener(this);
        MyFloat_Layout = findViewById(R.id.MyFloat_Layout);
        MyFloat_Layout.setData(mList);
        mHistoryLayout = findViewById(R.id.MyFloat_Layout_History);
        mHeadView = findViewById(R.id.header_View);
        mHeadView.getmCancle().setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Cancel_Text:
                String name = mHeadView.getEditStr().trim();
                mDao.insertSqlite(mHeadView.getEditStr().trim());

                mHistoryLayout.removeChildView();
                mHistory.add(name);
                mHistoryLayout.setData(mHistory);
                break;
            case R.id.Delete_Text:
                mDao.delete();
                mHistoryLayout.removeChildView();
                mHistory.clear();
                break;
        }
    }
}
