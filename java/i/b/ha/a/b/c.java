package i.b.ha.a.b;

/* loaded from: classes.dex */
public class c extends a {
    public c(long j2, int i2, Throwable th) {
        super(a(j2, i2), th);
    }

    private static String a(long j2, int i2) {
        return String.format("%,d KiB of memory would be needed; limit was %,d KiB. If the file is not corrupt, consider increasing the memory limit.", Long.valueOf(j2), Integer.valueOf(i2));
    }
}
