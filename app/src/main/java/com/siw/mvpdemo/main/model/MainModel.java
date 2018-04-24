package com.siw.mvpdemo.main.model;

import com.siw.basemvp.base.BaseModel;
import com.siw.basemvp.net.RxService;
import com.siw.basemvp.rx.RxUtil;
import com.siw.mvpdemo.main.GankApi;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.Observable;


public class MainModel implements BaseModel {
    public Observable<MainModelBean> getMainDataList(int count, int pager) {
        Observable<MainModelBean> compose = RxService.createApi(GankApi.class).getMainDataList(count, pager).compose(RxUtil.<MainModelBean>rxSchedulerHelper());
        return compose;
    }

    public Observable<MainClickBean> getMainClickList(String transMessage){
        Observable<MainClickBean> compose = RxService.createApi(GankApi.class, "http://c.zhcw.com/zhcwapp/").getMainClickList(transMessage).compose(RxUtil.<MainClickBean>rxSchedulerHelper());
        return compose;
    }

}
