package com.siw.mvpdemo.main.View;

import com.siw.basemvp.base.BaseView;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

/**
 * Created by 童思伟 on 2017/12/12.
 */

public interface MainView extends BaseView{
    void showDatas(MainModelBean mainModelBean);
}
