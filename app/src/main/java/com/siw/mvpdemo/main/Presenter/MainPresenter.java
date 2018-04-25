package com.siw.mvpdemo.main.Presenter;

import android.util.Log;

import com.siw.basemvp.base.BasePresenter;
import com.siw.basemvp.net.CallBackListener;
import com.siw.basemvp.rx.RxUtil;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter extends BasePresenter<MainModel, MainView> {

    public void getMainDatas(int count, int pager) {
        mRxManager.add(mModel.getMainDataList(count, pager), new CallBackListener<MainModelBean>() {
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
        mRxManager.add(mModel.getMainClickList(transMessage),new CallBackListener<MainClickBean>(){
            @Override
            public void onPre(boolean isDoSomething) {
            }

            @Override
            public void onSuccess(MainClickBean mainClickBean) {
                getView().showMainClickList(mainClickBean);
            }

            @Override
            public void onError(String str) {

            }
        });
    }

}
