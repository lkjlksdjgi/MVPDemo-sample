package com.siw.basemvp.utils.aop;


import android.text.TextUtils;
import android.util.Log;

import com.siw.basemvp.base.BaseActivity;
import com.siw.basemvp.utils.AppManager;
import com.siw.basemvp.utils.persissionutils.PermissionUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Calendar;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 参考：
 * https://blog.csdn.net/woshimalingyi/article/details/51519851
 * https://www.jianshu.com/p/b96a68ba50db
 *
 * AOP切面的应用
 * 1、View在某一时间段内只能点击一次
 * 2、判断是否登录、判断是否验证邮箱等等
 * 3、打印方法耗时
 * 4、Android6.0运行权限的申请
 * 5、线程切换
 * 6、埋点，用户行为收集
 */
@Aspect
public class AspectUtils {

    //------------------------------------单次点击------------------------------------------------------------------
    private static final int MIN_CLICK_DELAY_TIME = 600;//间隔时间600ms
    private static long LAST_CLICKTIME = 0;//最后一次点击的时间

    @Pointcut("execution(@com.siw.basemvp.utils.aop.SingleClick * * (..))")//根据SingleClick注解找到方法切入点
    public void singleClick() {
    }

    @Around("singleClick()")//在连接点进行方法替换
    public void aroundSingleClickJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SingleClick singleClick = method.getAnnotation(SingleClick.class);
        int MIN_CLICK_DELAY_TIME = singleClick.intervalTime();
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - LAST_CLICKTIME > MIN_CLICK_DELAY_TIME) {
            LAST_CLICKTIME = currentTime;
            joinPoint.proceed();//这行代码就是执行原方法
        }
    }

    //-----------------------------检查是否登录----------------------------------------------------------------------
    @Pointcut("execution(@com.siw.basemvp.utils.aop.CheckLogin * * (..))")//方法切入点
    public void checkLogin() {
    }

    @Around("checkLogin()")
    public void aroundCheckLoginJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        //TODO 判断是否登录的逻辑
        if (true) {
            joinPoint.proceed();//这行代码就是执行原方法
        }
    }

    //---------------------------------打印方法耗时------------------------------------------------------------------------------
    @Pointcut("execution(@com.siw.basemvp.utils.aop.TimeConsuming * * (..))")//方法切入点
    public void timeConsuming() {

    }

    @Around("timeConsuming()")
    public void aroundTimeConsumingJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String canonicalName = methodSignature.getMethod().getDeclaringClass().getCanonicalName();
//        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        TimeConsuming timeConsuming = methodSignature.getMethod().getAnnotation(TimeConsuming.class);
        String TAG = timeConsuming.tag();
        if (TextUtils.isEmpty(TAG)) {
            TAG = methodName;
        }
        long startTime = Calendar.getInstance().getTimeInMillis();
        joinPoint.proceed();//执行原方法
        long endTime = Calendar.getInstance().getTimeInMillis();
        Log.e(TAG, canonicalName + "." + methodName + " Method time consuming : " + (endTime - startTime) + "ms");
    }

    //---------------------------------线程切换------------------------------------------------------------------------------
    @Pointcut("execution(@com.siw.basemvp.utils.aop.WhichThread * * (..))")//方法切入点
    public void async() {

    }

    @Around("async()")
    public void aroundAsyncJoinPoint(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        WhichThread async = methodSignature.getMethod().getAnnotation(WhichThread.class);
        WhichThread.WhichThreadEnum thread = async.thread();
        Scheduler scheduler = null;
        switch (thread) {
            case IO:
                scheduler = Schedulers.io();
                break;
            case MainThread:
                scheduler = AndroidSchedulers.mainThread();
                break;
            case NewThread:
                scheduler = Schedulers.newThread();
                break;
            case Single:
                scheduler = Schedulers.single();
                break;
        }
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }).subscribeOn(scheduler).subscribe();
    }

    //---------------------------------Android6.0运行权限的申请------------------------------------------------------------------------------
    @Pointcut("execution(@com.siw.basemvp.utils.aop.Permission * * (..))")//方法切入点
    public void permission() {

    }

    @Around("permission()")
    public void aroundPermissionJoinPoint(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Permission permission = methodSignature.getMethod().getAnnotation(Permission.class);
        final BaseActivity ac = (BaseActivity) AppManager.getAppManager().currentActivity();
        PermissionUtils.requestPermissions(ac, 1, permission.value(), new PermissionUtils.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                try {
                    joinPoint.proceed();//获得权限，执行原方法
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }

            @Override
            public void onPermissionDenied() {

            }
        });
    }
}
