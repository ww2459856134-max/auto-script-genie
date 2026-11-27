package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import org.apache.xmlbeans.XmlValidationError;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class c {
    public static int a = 60;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";
    public static String d;
    public static String e;
    public static long f;
    public static int g;

    /* renamed from: h, reason: collision with root package name */
    public static int f887h;

    /* renamed from: i, reason: collision with root package name */
    public static int f888i;

    /* renamed from: j, reason: collision with root package name */
    public static String f889j;

    /* renamed from: k, reason: collision with root package name */
    public static String f890k;

    /* renamed from: l, reason: collision with root package name */
    public static String f891l;

    /* renamed from: m, reason: collision with root package name */
    public static int f892m;

    /* renamed from: n, reason: collision with root package name */
    public static long f893n;

    /* renamed from: o, reason: collision with root package name */
    public static String f894o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        d = sb.toString();
        e = ".log";
        f = 8388608L;
        g = WXMediaMessage.NATIVE_GAME__THUMB_LIMIT;
        f887h = 1024;
        f888i = XmlValidationError.UNDEFINED;
        f889j = "debug.file.blockcount";
        f890k = "debug.file.keepperiod";
        f891l = "debug.file.tracelevel";
        f892m = 24;
        f893n = 604800000L;
        f894o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
