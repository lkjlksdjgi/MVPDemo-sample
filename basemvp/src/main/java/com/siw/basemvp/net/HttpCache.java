package com.siw.basemvp.net;


import com.siw.basemvp.utils.CommonUtils;

import java.io.File;

import okhttp3.Cache;

/**
 * Created by 童思伟 on 2017/12/11.
 *
 */
public class HttpCache {

    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;

    public static Cache getCache() {
        return new Cache(new File(CommonUtils.getContext().getCacheDir().getAbsolutePath() + File.separator + "data/NetCache"),
                HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
}
