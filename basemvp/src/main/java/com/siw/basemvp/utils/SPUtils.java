package com.siw.basemvp.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.HashMap;

public final class SPUtils {

    //默认的SharedPreferences文件名
    private final static String SP_Default_Name = "SharedPreference";
    private final SharedPreferences sp;
    private static HashMap<String, SPUtils> spUtilsMap = null;

    private SPUtils(String spName) {
        sp = CommonUtils.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        if (spUtilsMap == null) {
            spUtilsMap = new HashMap<>();
        }
    }
    public static SPUtils getInstance() {
        return getInstance(SP_Default_Name);
    }

    public static SPUtils getInstance(String spName) {
        SPUtils spUtils = spUtilsMap.get(spName);
        if (spUtils == null) {
            spUtils = new SPUtils(spName);
            spUtilsMap.put(spName, spUtils);
        }
        return spUtils;
    }



}
