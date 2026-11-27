package com.tencent.open.a;

import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.l;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class d {
    protected static d a;

    protected d() {
    }

    public static synchronized d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        g.a().a(l.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g.a().a(l.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        g.a().a(l.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void a(int i2, String str, String str2, String str3, String str4, Long l2, int i3, int i4, String str5) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l2.longValue();
        if (l2.longValue() == 0 || jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i2);
        stringBuffer.append("&code=");
        stringBuffer.append(i3);
        stringBuffer.append("&time=");
        stringBuffer.append(jElapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i4);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        g.a().a(stringBuffer.toString(), Constants.HTTP_GET, l.a(String.valueOf(i2), String.valueOf(i3), String.valueOf(jElapsedRealtime), String.valueOf(i4), str, str2, str3, str4, str5), true);
    }
}
