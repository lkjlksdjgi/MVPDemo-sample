package com.siw.basemvp.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CommonUtils {

    private static Application mApplication;

    public static void init(Application application) {
        mApplication = application;
    }

    public static void clear() {
        mApplication = null;
    }

    public static Application getApplication() {
        if (mApplication == null) {
            throw new NullPointerException("mApplication is null,Please initialize the mApplication first");
        }
        return mApplication;
    }

    public static Context getContext() {
        if (mApplication == null) {
            throw new NullPointerException("mApplication is null,Please initialize the mApplication first");
        }
        return mApplication.getApplicationContext();
    }

    /**
     * 获取版本名称
     */
    public static String getAppVersionName() {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getContext().getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    /**
     * 获取版本号
     */
    public static int getAppVersionCode() {
        int versioncode = -1;
        try {
            // ---get the package info---
            PackageManager pm = getContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getContext().getPackageName(), 0);
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versioncode;
    }

    public static String getIMEI() {
        TelephonyManager tm = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

}
