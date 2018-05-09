package com.siw.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.siw.basemvp.utils.AppManager;

public class MainTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        AppManager.getAppManager().addActivity(this);
        MyFragment myFragment = new MyFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contain, myFragment).commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        for (int i = 0;i <permissions.length;i++){
            Log.e("Man", "requestCode : "+requestCode +"  MainTwoActivity permissions :" + permissions[i] + " grantResults :" + grantResults[i]);
        }

    }


}
