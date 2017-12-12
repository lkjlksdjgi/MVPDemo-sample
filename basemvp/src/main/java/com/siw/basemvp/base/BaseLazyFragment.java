package com.siw.basemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by 童思伟 on 2017/12/11.
 *
 * fragment 懒加载
 */

public abstract class BaseLazyFragment<P extends BasePresenter, M extends BaseModel> extends BaseFragment<P,M> {

    private static final String Fragment_IsHidden = "Fragment_IsHidden";
    private Bundle mSavedInstanceState;
    private boolean mInited = true;
    private boolean mIsHidden;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
        if (savedInstanceState == null) {
            if (!isHidden()) {
                mInited = true;
                initLazyView(null);
            }
        } else {
            mIsHidden = savedInstanceState.getBoolean(Fragment_IsHidden);
            if (!mIsHidden) {
                mInited = true;
                initLazyView(savedInstanceState);
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!mInited && !hidden) {
            mInited = true;
            initLazyView(mSavedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(Fragment_IsHidden, isHidden());
    }

    /**
     * 懒加载
     */
    protected abstract void initLazyView(@Nullable Bundle savedInstanceState);
}
