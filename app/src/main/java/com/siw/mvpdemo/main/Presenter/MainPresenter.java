package com.siw.mvpdemo.main.Presenter;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.siw.basemvp.base.BasePresenter;
import com.siw.basemvp.net.CallBackListener;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.Body;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.Observable;


public class MainPresenter extends BasePresenter<MainModel, MainView> {

    public void getMainDatas(int count, int pager) {
        mRxManager.<MainModelBean>add(mModel.getMainDataLists(count, pager), new CallBackListener<MainModelBean>() {
            @Override
            public void onPre(boolean isDoSomething) {

            }

            @Override
            public void onSuccess(MainModelBean mainModelBean) {
                getView().showDatas(mainModelBean);
            }

            @Override
            public void onError(String str) {

            }
        });
    }

    public void getMainClickList(String transMessage) {
        mRxManager.<Body>add(mModel.getMainClickList(transMessage),Body.class , new CallBackListener<Body>() {
            @Override
            public void onPre(boolean isDoSomething) {

            }

            @Override
            public void onSuccess(Body body) {
                getView().showMainClickList(body);
            }

            @Override
            public void onError(String str) {
            }
        });
    }
}
