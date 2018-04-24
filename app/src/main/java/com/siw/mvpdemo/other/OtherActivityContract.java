package com.siw.mvpdemo.other;

import com.siw.basemvp.base.BaseModel;

/**
 * Created by 童思伟 on 2018/1/3.
 */

public class OtherActivityContract {

    public interface OtherActivityModle extends BaseModel{
       void getMainDataList(int count, int pager);
    }


}
