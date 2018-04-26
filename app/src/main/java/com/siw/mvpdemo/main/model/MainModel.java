package com.siw.mvpdemo.main.model;
import com.siw.basemvp.base.BaseModel;
import com.siw.basemvp.net.RxService;
import com.siw.basemvp.rx.BaseResponse;
import com.siw.basemvp.rx.RxUtil;
import com.siw.mvpdemo.main.GankApi;
import com.siw.mvpdemo.main.model.bean.Body;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.Observable;


public class MainModel implements BaseModel {
    public Observable<MainModelBean> getMainDataLists(int count, int pager) {
        return RxService.createApi(GankApi.class).getMainDataLists(count, pager);
    }

    public Observable<Body> getMainClickList(String transMessage){
        Observable<BaseResponse<Body>> mainClickList = RxService.createApi(GankApi.class, "http://c.zhcw.com/zhcwapp/").getMainClickList(transMessage);
        //返回结果统一处理，利用rxjava flatmap操作符
        Observable<Body> bodyObservable = mainClickList.flatMap(RxUtil.<Body>getUnifiedResult());
        return bodyObservable;
    }

}
