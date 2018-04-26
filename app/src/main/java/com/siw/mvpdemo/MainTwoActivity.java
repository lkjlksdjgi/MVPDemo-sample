package com.siw.mvpdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.siw.basemvp.rx.RxTools;
import com.siw.basemvp.rx.RxUtil;
import com.siw.mvpdemo.main.model.bean.MainModelBean;
import com.siw.mvpdemo.main.model.bean.MainTwoBena;

public class MainTwoActivity extends AppCompatActivity {

    private RxTools.RxToolsBuilder rxToolsBuilder;
    private Button ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        ss = (Button) findViewById(R.id.ss);
        rxToolsBuilder = RxTools.create().isClear(false);
        rxToolsBuilder.subscribe(new RxTools.RxTask<MainTwoBena>() {
            @Override
            public MainTwoBena doInBackgroud() {
                Log.e("RxToolsBuilder","doInBackgroud ThreadName :"+Thread.currentThread().getName());
                return new MainTwoBena("zhangsan",3);
            }

            @Override
            public void doInMainThread(MainTwoBena mainModelBean) {
                Log.e("RxToolsBuilder","doInMainThread ThreadName :"+Thread.currentThread().getName());
                Log.e("RxToolsBuilder","mainModelBean :"+mainModelBean.toString());
                ss.setText(rxToolsBuilder.hashCode()+"");
            }

            @Override
            public void onError(String str) {

            }
        });
    }

    public void click(final View view){
        rxToolsBuilder.clear();
    }
}
