package com.siw.basemvp.base;


import com.siw.basemvp.rx.RxManager;

import java.lang.ref.WeakReference;

/**
 * Created by 童思伟 on 2017/12/11.
 */

public abstract class BasePresenter<M,V> {

    protected M mModel;
    protected WeakReference<V> mViewRef;

    public RxManager mRxManager = new RxManager();

    public void attachVM(V v, M m) {
        this.mViewRef = new WeakReference<V>(v);
        this.mModel = m;
    }

    public void detachVM() {
        mRxManager.clear();
        mModel = null;
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected V getView(){
        return mViewRef.get();
    }

}
