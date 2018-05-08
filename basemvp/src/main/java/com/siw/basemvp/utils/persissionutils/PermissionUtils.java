package com.siw.basemvp.utils.persissionutils;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.siw.basemvp.utils.AppManager;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {

    @TargetApi(Build.VERSION_CODES.M)
    public static void requestPermissions(Object object, int requestCode, String[] permissions,OnPermissionListener onPermissionListener) {
        FragmentActivity fragmentActivity = AppManager.getAppManager().currentActivity();
        if (checkPermissions(fragmentActivity, permissions)) {//都有权限
            onPermissionListener.onPermissionGranted();
        } else {
            List<String> deniedPermissions = getDeniedPermissions(fragmentActivity, permissions);
            if (deniedPermissions.size() > 0) {
                fragmentActivity.requestPermissions(deniedPermissions.toArray(new String[deniedPermissions.size()]),requestCode);
            }
        }
    }


    private static boolean checkPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                Log.e("Man",permission +" checkSelfPermission:" + ContextCompat.checkSelfPermission(context, permission));
                if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> getDeniedPermissions(Context context, String... permissions) {
        List<String> deniedPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission);
            }
        }
        return deniedPermissions;
    }

    public interface OnPermissionListener {
        void onPermissionGranted();

        void onPermissionDenied();
    }
}
