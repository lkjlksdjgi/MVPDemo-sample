package com.siw.basemvp.rx;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class RxTools<T> {

    //子线程到主线程
    public static final int THREAD_TO_MAIN = 0;
    //主线程到子线程
    public static final int MAIN_TO_THREAD = 1;
    //主线程到子线程
    public static final int THREAD_TO_THREAD = 2;

    private static RxToolsBuilder rxToolsBuilder;

    public static RxToolsBuilder create() {
        return create(THREAD_TO_MAIN);
    }

    public static RxToolsBuilder create(int flag) {
        rxToolsBuilder = new RxToolsBuilder(flag);
        return rxToolsBuilder;
    }

    public static class RxToolsBuilder<T> {
        private RxTask<T> mRxTask;
        private Observable<T> observable = null;
        private CompositeDisposable compositeDisposable = new CompositeDisposable();// 管理订阅者者
        private boolean isClear = true;

        public RxToolsBuilder() {
            this(RxTools.THREAD_TO_MAIN);
        }

        public RxToolsBuilder(int flag) {
            observable = Observable.create(new ObservableOnSubscribe<T>() {
                @Override
                public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                    T t = mRxTask.doInBackgroud();
                    emitter.onNext(t);
                }
            }).compose(RxUtil.<T>rxSchedulerHelper(flag));
        }

        public RxToolsBuilder isClear(boolean isClear){
            this.isClear = isClear;
            return this;
        }
        public RxToolsBuilder subscribe(RxTask rxTask) {
            this.mRxTask = rxTask;
            Disposable disposable = observable.subscribe(new Consumer<T>() {
                @Override
                public void accept(T t) throws Exception {
                    mRxTask.doInMainThread(t);
                    if(isClear){
                        clear();
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    mRxTask.onError(throwable.toString());
                    if(isClear){
                        clear();
                    }
                }
            });
            compositeDisposable.add(disposable);
            return this;
        }

        public void clear() {
            if (compositeDisposable != null) {
                compositeDisposable.dispose();
                compositeDisposable.clear();
                compositeDisposable = null;
                mRxTask = null;
                observable = null;
                rxToolsBuilder = null;
            }
        }
    }

    public interface RxTask<T> {
        T doInBackgroud();

        void doInMainThread(T t);

        void onError(String str);
    }
}
