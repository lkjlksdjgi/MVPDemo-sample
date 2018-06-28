package com.siw.mvpdemo;

import android.app.Application;

import com.siw.basemvp.utils.CommonUtils;

/**
 * Created by 童思伟 on 2017/12/12.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CommonUtils.init(this);

    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}

