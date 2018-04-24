package com.siw.mvpdemo.main.Presenter;

import com.siw.basemvp.base.BasePresenter;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MainPresenter extends BasePresenter<MainModel, MainView> {

    public void getMainDatas(int count, int pager) {
        Disposable subscribe = mModel.getMainDataList(count, pager).subscribe(new Consumer<MainModelBean>() {
            @Override
            public void accept(MainModelBean mainModelBean) throws Exception {
                getView().showDatas(mainModelBean);
            }
        });
        mRxManager.add(subscribe);
    }

    public void getMainClickList(String transMessage) {
        mRxManager.add(mModel.getMainClickList(transMessage).subscribe(new Consumer<MainClickBean>() {
            @Override
            public void accept(MainClickBean mainClickBean) throws Exception {
                getView().showMainClickList(mainClickBean);
            }
        }));
    }

}
