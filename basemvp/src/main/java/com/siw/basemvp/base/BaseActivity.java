package com.siw.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.siw.basemvp.utils.AppManager;
import com.siw.basemvp.utils.CommonUtils;
import com.siw.basemvp.utils.ReflexUtil;


/**
 * Created by 童思伟 on 2017/12/11.
 *
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    protected P mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        CommonUtils.init(BaseActivity.this.getApplicationContext());
        mPresenter = ReflexUtil.getClazz(this, 0);
        mModel = ReflexUtil.getClazz(this, 1);
        if (this instanceof BaseView) {
            mPresenter.attachVM(this, mModel);
        }
        initView();
        AppManager.getAppManager().addActivity(this);
    }

    public abstract int getLayoutID();

    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        if (mPresenter != null) {
            mPresenter.detachVM();
        }
    }
}
