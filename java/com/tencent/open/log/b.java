package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class b {
    private static SimpleDateFormat a = d.C0012d.a("yy.MM.dd.HH");
    private File g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = XMLEvent.CHANGE_PREFIX_MAPPING;
    private long f = 10000;

    /* renamed from: h, reason: collision with root package name */
    private int f884h = 10;

    /* renamed from: i, reason: collision with root package name */
    private String f885i = ".log";

    /* renamed from: j, reason: collision with root package name */
    private long f886j = Long.MAX_VALUE;

    public b(File file, int i2, int i3, int i4, String str, long j2, int i5, String str2, long j3) {
        a(file);
        b(i2);
        a(i3);
        c(i4);
        a(str);
        a(j2);
        d(i5);
        b(str2);
        b(j3);
    }

    private File[] c(long j2) {
        File fileB = b();
        String strC = c(d(j2));
        try {
            fileB = new File(fileB, strC);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String strB = l.b();
        File file = null;
        if (!TextUtils.isEmpty(strB) || strB != null) {
            try {
                File file2 = new File(strB, c.f894o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, strC);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
        }
        return new File[]{fileB, file};
    }

    private String d(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File fileE = e();
        if (fileE != null) {
            fileE.mkdirs();
        }
        return fileE;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.f884h;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i2) {
        this.c = i2;
    }

    public void b(int i2) {
        this.d = i2;
    }

    public void a(long j2) {
        this.f = j2;
    }

    public void b(String str) {
        this.f885i = str;
    }

    public void a(File file) {
        this.g = file;
    }

    public void b(long j2) {
        this.f886j = j2;
    }

    public int d() {
        return this.e;
    }

    public void d(int i2) {
        this.f884h = i2;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public String c() {
        return this.b;
    }

    public void c(int i2) {
        this.e = i2;
    }
}
