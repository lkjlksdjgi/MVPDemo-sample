package com.siw.mvpdemo.main;


import com.siw.basemvp.rx.BaseResponse;
import com.siw.mvpdemo.main.model.bean.Body;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 童思伟 on 2017/12/11.
 */

public interface GankApi {

    @GET("data/Android/{count}/{pager}")
    Observable<MainModelBean> getMainDataLists(@Path("count") int count, @Path("pager") int pager);

    @GET("serv.do?encry=0")
    Observable<BaseResponse<Body>> getMainClickList(@Query("transMessage") String transMessage);
}
