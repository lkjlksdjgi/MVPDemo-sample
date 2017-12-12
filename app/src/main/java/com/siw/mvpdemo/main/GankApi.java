package com.siw.mvpdemo.main;


import com.siw.mvpdemo.main.model.bean.MainModelBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by 童思伟 on 2017/12/11.
 */

public interface GankApi {

    @GET("data/Android/{count}/{pager}")
    Observable<MainModelBean> getMainDataList(@Path("count") int count, @Path("pager") int pager);
}
