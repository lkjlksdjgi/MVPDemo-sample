package com.siw.mvpdemo.main.View;

import com.siw.basemvp.base.BaseView;
import com.siw.mvpdemo.main.model.bean.MainClickBean;
import com.siw.mvpdemo.main.model.bean.MainModelBean;

public interface MainView extends BaseView{
    void showDatas(MainModelBean mainModelBean);

    void showMainClickList(MainClickBean mainClickBean);
}
