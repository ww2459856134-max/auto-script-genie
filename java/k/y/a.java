package k.y;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(boolean z) {
        if (!z) {
            throw new b();
        }
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new b(str);
        }
    }
}
