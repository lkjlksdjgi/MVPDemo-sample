package com.siw.mvpdemo;

import android.Manifest;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.siw.basemvp.base.BaseActivity;
import com.siw.basemvp.utils.aop.Permission;
import com.siw.basemvp.utils.aop.SingleClick;
import com.siw.mvpdemo.main.Presenter.MainPresenter;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.Body;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainView {

    private TextView tv;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }
    @Override
    public void initView() {
        mImmersionBar.statusBarColor(R.color.colorAccent).init();
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
    public void showMainClickList(Body body) {
        tv.setText(body.toString());
    }

    public void click(View view) {
        mPresenter.getMainClickList("{\"message\":{\"head\":{\"sysType\":\"Z\",\"transactionType\":\"600104\",\"messageID\":\"99992017121815192456\",\"timeStamp\":\"20171218151924\",\"imei\":\"866624024092207\",\"ua\":\"HM NOTE 1S\",\"src\":\"0000100001|0301005020\",\"deviceId\":\"78ACCECFC5216E6B9A3BCAB0677E0832\",\"messengerID\":\"9999\"},\"body\":{\"newFlag\":\"1513581071918\",\"type\":\"ALL\"}}}");
    }

    int count = 1;

    @SingleClick(intervalTime = 3000)
    public void gotoActivity(View view) {
        startActivity(new Intent(this, MainTwoActivity.class));
        finish();
        count = count + 1;
        Log.e("Man", "count :" + count);
    }


    public void login(View view) {
        lala();
    }


    @Permission(value = {Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR})
    private void lala() {
        Log.e("Man", "Thread :" + Thread.currentThread().getName());
    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        Toast.makeText(this, permissions.toString(), Toast.LENGTH_SHORT);
//    }
}
