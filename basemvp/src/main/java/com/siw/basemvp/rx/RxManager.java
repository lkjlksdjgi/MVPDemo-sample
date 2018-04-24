package com.siw.basemvp.rx;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * 管理RX生命周期，防止内存泄漏
 */
public class RxManager {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();// 管理订阅者者

    public void add(Disposable disposable ){
        compositeDisposable.add(disposable);
    }
    public void clear(){
        compositeDisposable.dispose();
        compositeDisposable.clear();
    }
}