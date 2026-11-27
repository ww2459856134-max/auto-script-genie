package com.bumptech.glide.load.x.i1;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
abstract class h {
    static int a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), iAvailableProcessors) : iAvailableProcessors;
    }

    private static int b() {
        File[] fileArrListFiles;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new g(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                fileArrListFiles = null;
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        }
        return Math.max(1, fileArrListFiles != null ? fileArrListFiles.length : 0);
    }
}
