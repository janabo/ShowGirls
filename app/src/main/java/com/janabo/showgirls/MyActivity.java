package com.janabo.showgirls;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：janabo on 2017/3/14 09:34
 */
public abstract class MyActivity extends AppCompatActivity{

    protected abstract
    @LayoutRes
    int getLayoutID();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        initData();
    }

    protected void initView(){};

    protected void initData(){};

}
