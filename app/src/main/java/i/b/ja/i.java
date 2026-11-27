package i.b.ja;

/* loaded from: classes.dex */
public abstract class i {
    public static final String a = null;

    public static boolean a(String str) {
        return "paddle".equals(str);
    }

    public static boolean b(String str) {
        return "com.jsj.autojs".equals(str);
    }

    public static String c(String str, String str2) {
        return (a(str) && b(str2)) ? "paddle" : a;
    }
}
