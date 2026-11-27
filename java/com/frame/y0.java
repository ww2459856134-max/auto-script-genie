package com.frame;

import android.util.Log;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class y0 {
    private static y0 f = null;
    private static long g = 50;
    private boolean a;
    private a c;
    private File d;
    private long e = 307200;
    private final SimpleDateFormat b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");

    public interface a {
        void a(String str);
    }

    private y0() {
        q();
    }

    public static y0 b() {
        y0 y0Var = f;
        if (y0Var != null) {
            return y0Var;
        }
        y0 y0Var2 = new y0();
        f = y0Var2;
        return y0Var2;
    }

    public static void g(String str) {
        Log.v("log", str);
        h(str, null);
    }

    public static void h(String str, String str2) {
        String str3;
        y0 y0Var = f;
        if (y0Var == null || !y0Var.a) {
            return;
        }
        synchronized ("LogUtil") {
            if (str2 == null) {
                str3 = "<br/>" + f.b.format(new Date()) + "    " + str;
            } else {
                str3 = String.format("<br/>%s    <font color='%s'>%s</font>", f.b.format(new Date()), str2, str);
            }
            r0.z(f.a().getAbsolutePath(), str3, true);
            a aVar = f.c;
            if (aVar != null) {
                aVar.a(str3);
            }
            if (f.a().length() > f.e) {
                p();
            }
        }
    }

    public static void i(String str) {
        Log.d("debug", str);
        h(str, "#EE41F2");
    }

    public static void j(String str) {
        k(str, false);
    }

    public static void k(String str, boolean z) {
        y0 y0Var;
        a aVar;
        h(str, "#F45075");
        if (!z || (y0Var = f) == null || (aVar = y0Var.c) == null || !y0Var.a) {
            return;
        }
        aVar.a("<br/><font color='#EB5E00'>" + f.d() + "</font>");
    }

    public static void l(Throwable th) {
        PrintWriter printWriter;
        th.printStackTrace();
        y0 y0Var = f;
        if (y0Var == null || !y0Var.a) {
            return;
        }
        synchronized ("LogUtil") {
            PrintWriter printWriter2 = null;
            try {
                try {
                    try {
                        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(f.a(), true)));
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    th.printStackTrace(printWriter);
                    x0.g(printWriter);
                } catch (Exception e2) {
                    e = e2;
                    printWriter2 = printWriter;
                    k0.r(e);
                    x0.g(printWriter2);
                } catch (Throwable th3) {
                    th = th3;
                    printWriter2 = printWriter;
                    x0.g(printWriter2);
                    throw th;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public static void m(String str) {
        h(str, "#417DF2");
    }

    public static void n(String str) {
        h(str, "#55CA9B");
    }

    public static void o(String str) {
        h(str, "#EB5E00");
    }

    public static void p() {
        if (f != null) {
            File file = new File(v0.g().getFilesDir(), "/clickHistory/");
            File[] fileArrS = r0.s(file);
            if (fileArrS != null) {
                long length = fileArrS.length;
                long j2 = g;
                if (length > j2) {
                    long length2 = fileArrS.length - j2;
                    for (int i2 = 0; i2 < length2; i2++) {
                        try {
                            fileArrS[i2].delete();
                        } catch (Exception e) {
                            k0.r(e);
                        }
                    }
                }
            }
            f.d = new File(file.getAbsolutePath() + "/脚本日志" + m1.a("yyyy年MM月dd日HH:mm") + ".txt");
        }
    }

    public File a() {
        if (this.d == null) {
            this.d = c();
        }
        return this.d;
    }

    public synchronized File c() {
        File file = new File(v0.g().getFilesDir(), "/clickHistory/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] fileArrS = r0.s(file);
        if (fileArrS != null) {
            long length = fileArrS.length;
            long j2 = g;
            if (length > j2) {
                long length2 = fileArrS.length - j2;
                for (int i2 = 0; i2 < length2; i2++) {
                    try {
                        fileArrS[i2].delete();
                    } catch (Exception e) {
                        k0.r(e);
                    }
                }
            }
        }
        if (fileArrS != null && fileArrS.length > 0) {
            return fileArrS[fileArrS.length - 1];
        }
        return new File(file.getAbsolutePath() + "/脚本日志" + m1.a("yyyy年MM月dd日HH:mm") + ".txt");
    }

    public String d() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 2) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int length = stackTrace.length - 1; length > 1; length--) {
            stringBuffer.append(stackTrace[length].getFileName() + "." + stackTrace[length].getMethodName() + "(" + stackTrace[length].getLineNumber() + ")");
            if (length > 2) {
                stringBuffer.append("->");
            }
        }
        return stringBuffer.toString();
    }

    public boolean e() {
        return f() && !n0.a("logUserClose", false);
    }

    public boolean f() {
        boolean zA = n0.a("isDebug", false);
        this.a = zA;
        return zA;
    }

    public void q() {
        this.e = n0.c("lgoSize", 300) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        g = n0.c("lgoCount", 50);
    }

    public void r(boolean z) {
        n0.g("isDebug", z);
        this.a = z;
        if (z) {
            t(false);
        }
    }

    public void s(a aVar) {
        this.c = aVar;
    }

    public void t(boolean z) {
        n0.g("logUserClose", z);
    }
}
