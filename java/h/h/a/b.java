package h.h.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
abstract class b {
    public static boolean a(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String strE = e(context, uri);
        int iF = f(context, uri, "flags", 0);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        if ((iF & 4) != 0) {
            return true;
        }
        if (!"vnd.android.document/directory".equals(strE) || (iF & 8) == 0) {
            return (TextUtils.isEmpty(strE) || (iF & 2) == 0) ? false : true;
        }
        return true;
    }

    private static void b(AutoCloseable autoCloseable) throws Exception {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Context context, Uri uri) throws Exception {
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{"document_id"}, null, null, null);
            return cursorQuery.getCount() > 0;
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return false;
        } finally {
            b(cursorQuery);
        }
    }

    public static String d(Context context, Uri uri) {
        return h(context, uri, "_display_name", null);
    }

    private static String e(Context context, Uri uri) {
        return h(context, uri, "mime_type", null);
    }

    private static int f(Context context, Uri uri, String str, int i2) {
        return (int) g(context, uri, str, i2);
    }

    private static long g(Context context, Uri uri, String str, long j2) throws Exception {
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) ? j2 : cursorQuery.getLong(0);
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return j2;
        } finally {
            b(cursorQuery);
        }
    }

    private static String h(Context context, Uri uri, String str, String str2) throws Exception {
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            return (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) ? str2 : cursorQuery.getString(0);
        } catch (Exception e) {
            Log.w("DocumentFile", "Failed query: " + e);
            return str2;
        } finally {
            b(cursorQuery);
        }
    }
}
