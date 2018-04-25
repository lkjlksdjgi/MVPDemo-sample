package com.siw.mvpdemo;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.siw.basemvp.base.BaseActivity;
import com.siw.basemvp.rx.RxTools;
import com.siw.basemvp.utils.StatusBarUtil;
import com.siw.mvpdemo.main.Presenter.MainPresenter;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainView {

    private TextView tv;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent));
        tv = (TextView) findViewById(R.id.tv);
        mPresenter.getMainDatas(10, 1);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showDatas(MainModelBean mainModelBean) {
        tv.setText(mainModelBean.getResults().get(0).getDesc().toString());
    }

    @Override
    public void showMainClickList(MainClickBean mainClickBean) {
        tv.setText(mainClickBean.toString());
    }

    public void click(View view) {
        mPresenter.getMainClickList("{\"message\":{\"head\":{\"sysType\":\"Z\",\"transactionType\":\"600104\",\"messageID\":\"99992017121815192456\",\"timeStamp\":\"20171218151924\",\"imei\":\"866624024092207\",\"ua\":\"HM NOTE 1S\",\"src\":\"0000100001|0301005020\",\"deviceId\":\"78ACCECFC5216E6B9A3BCAB0677E0832\",\"messengerID\":\"9999\"},\"body\":{\"newFlag\":\"1513581071918\",\"type\":\"ALL\"}}}");

    }

    public void gotoActivity(View view) {
        startActivity(new Intent(this, MainTwoActivity.class));
        finish();

    }
}
