package com.siw.mvpdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siw.basemvp.utils.aop.Permission;
import com.siw.basemvp.utils.PermissionUtils;


public class MyFragment extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragments, null);
        //两个
        view.findViewById(R.id.ddd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lala();
            }
        });
        //一个
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lalas();
            }
        });
        return view;
    }

    @Permission(value = {PermissionUtils.PermissionGroup.CALENDAR})
    private void lala() {
        Log.e("Man", "Thread :" + Thread.currentThread().getName());
    }

    @Permission(value = {PermissionUtils.PermissionGroup.CALENDAR,PermissionUtils.PermissionGroup.CAMERA},requestCode = 3)
    private void lalas() {
        Log.e("Man", "Thread :" + Thread.currentThread().getName());
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.e("Man", "MyFragment permissions :" + permissions.toString());
    }
}
