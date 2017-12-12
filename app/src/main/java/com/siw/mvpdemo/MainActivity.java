package com.siw.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.siw.basemvp.base.BaseActivity;
import com.siw.mvpdemo.main.Presenter.MainPresenter;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainView {

    private TextView tv;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tv = (TextView) findViewById(R.id.tv);
        mPresenter.getMainDatas(10,1);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showDatas(MainModelBean mainModelBean) {
        tv.setText(mainModelBean.getResults().get(0).getDesc().toString());
    }
}
