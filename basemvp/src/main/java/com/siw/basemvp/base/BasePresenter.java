package com.siw.basemvp.base;


import com.siw.basemvp.rx.RxManager;

import java.lang.ref.SoftReference;


public abstract class BasePresenter<M,V> {

    protected M mModel;
    protected SoftReference<V> mViewRef;

    public RxManager mRxManager = new RxManager();

    public void attachVM(V v, M m) {
        this.mViewRef = new SoftReference<V>(v);
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
