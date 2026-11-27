package i.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.frame.k0;
import com.frame.l1;
import com.frame.m1;
import com.frame.v0;
import com.frame.x0;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class l {
    private static String a = "content://com.android.calendar/calendars";
    private static String b = "content://com.android.calendar/events";
    private static String c = "content://com.android.calendar/reminders";
    private static String d = "autonomy";
    private static String e = v0.g().getPackageName();
    private static String f;

    static {
        v0.g().getPackageName();
        f = v0.g().getString(j.c.a.a);
    }

    private long a(Context context) {
        TimeZone timeZone = TimeZone.getDefault();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", d);
        contentValues.put("account_name", e);
        contentValues.put("account_type", "LOCAL");
        contentValues.put("calendar_displayName", f);
        contentValues.put("visible", (Integer) 1);
        contentValues.put("calendar_color", (Integer) (-16776961));
        contentValues.put("calendar_access_level", (Integer) 700);
        contentValues.put("sync_events", (Integer) 1);
        contentValues.put("calendar_timezone", timeZone.getID());
        contentValues.put("ownerAccount", e);
        contentValues.put("canOrganizerRespond", (Integer) 0);
        Uri uriInsert = context.getContentResolver().insert(Uri.parse(a).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", e).appendQueryParameter("account_type", "LOCAL").build(), contentValues);
        if (uriInsert == null) {
            return -1L;
        }
        return ContentUris.parseId(uriInsert);
    }

    private int e(Context context) {
        int iF = f(context);
        if (iF >= 0) {
            return iF;
        }
        if (a(context) >= 0) {
            return f(context);
        }
        return -1;
    }

    @SuppressLint({"Range"})
    private int f(Context context) {
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(Uri.parse(a), null, "calendar_displayName=?", new String[]{f}, null);
                if (cursorQuery == null) {
                    x0.a(cursorQuery);
                    return -1;
                }
                if (cursorQuery.getCount() <= 0) {
                    x0.a(cursorQuery);
                    return -1;
                }
                cursorQuery.moveToFirst();
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                x0.a(cursorQuery);
                return i2;
            } catch (Exception e2) {
                k0.r(e2);
                x0.a(null);
                return -1;
            }
        } catch (Throwable th) {
            x0.a(null);
            throw th;
        }
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT >= 23) {
            Activity activityD = v0.g().d();
            if (activityD == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (androidx.core.content.a.a(v0.g(), "android.permission.READ_CALENDAR") != 0) {
                arrayList.add("android.permission.READ_CALENDAR");
            }
            if (androidx.core.content.a.a(v0.g(), "android.permission.WRITE_CALENDAR") != 0) {
                arrayList.add("android.permission.WRITE_CALENDAR");
            }
            if (arrayList.size() != 0) {
                String[] strArr = new String[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    strArr[i2] = String.valueOf(arrayList.get(i2));
                }
                androidx.core.app.f.l(activityD, strArr, 981);
                return false;
            }
        }
        return true;
    }

    public void b(String str, String str2, long j2, long j3, String str3, int i2) {
        int iE = e(v0.g());
        if (iE < 0) {
            return;
        }
        ContentResolver contentResolver = v0.g().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str2);
        contentValues.put("calendar_id", Integer.valueOf(iE));
        contentValues.put("dtstart", Long.valueOf(j2));
        contentValues.put("dtend", Long.valueOf(j3));
        contentValues.put("hasAlarm", (Integer) 1);
        contentValues.put("eventTimezone", "Asia/Shanghai");
        contentValues.put("rrule", str3);
        Uri uriInsert = contentResolver.insert(Uri.parse(b), contentValues);
        if (uriInsert == null) {
            l1.e(new Runnable() { // from class: i.a.e
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(v0.g(), "添加日历事件失败", 0).show();
                }
            });
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(uriInsert)));
        contentValues2.put("minutes", (Integer) 0);
        contentValues2.put("method", Integer.valueOf(i2));
        if (contentResolver.insert(Uri.parse(c), contentValues2) == null) {
            l1.e(new Runnable() { // from class: i.a.d
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(v0.g(), "添加事件提醒失败", 0).show();
                }
            });
        }
    }

    public void c(String str, String str2, long j2, long j3, List<Integer> list) {
        String[] strArr = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(strArr[it.next().intValue() - 1]);
        }
        String str3 = "COUNT=100;FREQ=WEEKLY;WKST=SU;BYDAY=" + TextUtils.join(",", arrayList);
        Log.v("Remind", str3 + "---提醒时间:" + m1.b(j2, "HH:mm"));
        b(str, str2, j2, j3, str3, 1);
    }

    public void d() {
        g();
    }

    public void h(String str) {
        try {
            if (v0.g().getContentResolver().delete(Uri.parse(b), "description=?", new String[]{str}) == -1) {
                Toast.makeText(v0.g(), "删除失败", 0).show();
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    public boolean i() {
        return androidx.core.content.a.a(v0.g(), "android.permission.READ_CALENDAR") == 0 && androidx.core.content.a.a(v0.g(), "android.permission.WRITE_CALENDAR") == 0;
    }
}
