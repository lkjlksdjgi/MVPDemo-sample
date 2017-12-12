package com.siw.mvpdemo.main.Presenter;

import com.siw.basemvp.base.BasePresenter;
import com.siw.mvpdemo.main.View.MainView;
import com.siw.mvpdemo.main.model.MainModel;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import rx.functions.Action1;

/**
 * Created by 童思伟 on 2017/12/12.
 */

public class MainPresenter extends BasePresenter<MainModel,MainView> {

    public void getMainDatas(int count, int pager){
        mRxManager.add(mModel.getMainDataList(count,pager).subscribe(new Action1<MainModelBean>() {
            @Override
            public void call(MainModelBean mainModelBean) {
                getView().showDatas(mainModelBean);
            }
        }));
    }

}
