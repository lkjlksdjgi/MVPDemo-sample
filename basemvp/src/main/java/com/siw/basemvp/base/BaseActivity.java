package com.siw.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.siw.basemvp.utils.AppManager;
import com.siw.basemvp.utils.ReflexUtil;
import com.siw.basemvp.utils.barutils.ImmersionBar;


/**
 * Created by 童思伟 on 2017/12/11.
 *
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    protected P mPresenter;
    protected M mModel;

    /**沉浸式状态栏*/
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mPresenter = ReflexUtil.getClazz(this, 0);
        mModel = ReflexUtil.getClazz(this, 1);
        if (this instanceof BaseView) {
            mPresenter.attachVM(this, mModel);
        }
        //初始化沉浸式
        if (isImmersionBarEnabled()){
            initImmersionBar();
        }

        initView();
        AppManager.getAppManager().addActivity(this);
    }

    public abstract int getLayoutID();

    public abstract void initView();

    /**是否可以使用沉浸式*/
    protected boolean isImmersionBarEnabled() {
        //这里根据业务逻辑或者根据不同的系统版本去判断是否使用沉浸式
        return true;
    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
        if (mPresenter != null) {
            mPresenter.detachVM();
        }
        if (mImmersionBar != null){
            mImmersionBar.destroy();  //在BaseActivity里销毁
        }

    }
}
