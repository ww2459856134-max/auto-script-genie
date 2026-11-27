package i.b.ja;

/* loaded from: classes.dex */
public final class n extends RuntimeException {
    private final l c;

    n(l lVar, String str) {
        super(str);
        this.c = lVar;
    }

    public l a() {
        return this.c;
    }

    n(l lVar, String str, Throwable th) {
        super(str, th);
        this.c = lVar;
    }
}
