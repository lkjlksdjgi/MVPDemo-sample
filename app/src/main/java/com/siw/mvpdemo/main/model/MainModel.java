package com.siw.mvpdemo.main.model;

import com.siw.basemvp.base.BaseModel;
import com.siw.basemvp.net.RxService;
import com.siw.basemvp.rx.RxUtil;
import com.siw.mvpdemo.main.GankApi;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import rx.Observable;


/**
 * Created by 童思伟 on 2017/12/12.
 */

public class MainModel implements BaseModel {
    public Observable<MainModelBean> getMainDataList(int count, int pager) {
        Observable<MainModelBean> compose = RxService.createApi(GankApi.class).getMainDataList(count, pager).compose(RxUtil.<MainModelBean>rxSchedulerHelper());
        return compose;
    }
}
