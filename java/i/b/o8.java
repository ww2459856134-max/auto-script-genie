package i.b;

import android.text.TextUtils;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
public abstract class o8 {
    public static boolean a(String str, String str2) {
        return f(str) && f(str2);
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.contains("${");
    }

    public static String c(String str, String str2) {
        if (!d(str, str2)) {
            return g(str) + "ms";
        }
        return g(str) + ProcessIdUtil.DEFAULT_PROCESSID + g(str2) + "ms";
    }

    public static boolean d(String str, String str2) {
        return !e(str2);
    }

    public static boolean e(String str) {
        return TextUtils.isEmpty(str) || "0".equals(str.trim());
    }

    public static boolean f(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Long.parseLong(str.trim());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String g(String str) {
        return str == null ? "" : str;
    }

    public static long h(String str) {
        if (e(str)) {
            return 0L;
        }
        String strG = da.B().G(str.trim());
        if (TextUtils.isEmpty(strG)) {
            return 0L;
        }
        try {
            return Long.parseLong(strG.trim());
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long i(String str, String str2) {
        if (!d(str, str2)) {
            return h(str);
        }
        long jH = h(str);
        long jH2 = h(str2);
        if (jH2 <= 0) {
            return Math.max(jH, 0L);
        }
        if (jH2 < jH) {
            return Math.max(jH, 1L);
        }
        try {
            return com.frame.q1.m((int) jH, (int) jH2);
        } catch (Exception unused) {
            return Math.max(jH, 1L);
        }
    }

    public static boolean j(String str) {
        return b(str) || h(str) > 2000;
    }
}
