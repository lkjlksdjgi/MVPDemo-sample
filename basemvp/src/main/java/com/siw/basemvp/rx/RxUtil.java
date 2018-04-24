package com.siw.basemvp.rx;


import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 童思伟 on 2017/12/11.
 *
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T,T>(){
            @Override
            public ObservableSource<T> apply(io.reactivex.Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
//    public static <T> Transformer<CoreDataResponse<T>, T> handleResult() {   //compose判断结果
//        return httpResponseObservable -> httpResponseObservable.flatMap(new Func1<CoreDataResponse<T>, Observable<T>>() {
//            @Override
//            public Observable<T> call(CoreDataResponse<T> tMyHttpResponse) {
//                if (tMyHttpResponse.getCode() == 200) {
//                    return createData(tMyHttpResponse.getNewslist());
//                } else {
//                    return Observable.error(new CoreApiException("服务器返回error"));
//                }
//            }
//        });
//    }

//    /**
//     * 生成Observable
//     *
//     * @param <T>
//     * @return
//     */
//    public static <T> Observable<T> createData(final T t) {
//        return Observable.create(new Observable.OnSubscribe<T>() {
//            @Override
//            public void call(Subscriber<? super T> subscriber) {
//                try {
//                    subscriber.onNext(t);
//                    subscriber.onCompleted();
//                } catch (Exception e) {
//                    subscriber.onError(e);
//                }
//            }
//        });
//    }
}
