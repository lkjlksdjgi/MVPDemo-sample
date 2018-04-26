package com.siw.mvpdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.siw.basemvp.rx.RxTools;
import com.siw.basemvp.rx.RxUtil;
import com.siw.basemvp.utils.GsonUtil;
import com.siw.mvpdemo.main.model.bean.MainModelBean;
import com.siw.mvpdemo.main.model.bean.MainTwoBena;

import java.util.ArrayList;
import java.util.List;

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
        List<MainTwoBena> list = new ArrayList<MainTwoBena>();
        list.add(new MainTwoBena("张三", 12));
        list.add(new MainTwoBena("李四", 15));
        list.add(new MainTwoBena("王五", 16));
        String s = GsonUtil.GsonString(list);
        List<MainTwoBena> mainTwoBenas = GsonUtil.GsonToList(s, MainTwoBena[].class);
        Log.e("Man",mainTwoBenas.toString());
//        rxToolsBuilder.clear();
    }

}
