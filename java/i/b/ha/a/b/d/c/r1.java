package i.b.ha.a.b.d.c;

import java.io.InputStream;
import java.util.Objects;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
final class r1 {
    private final o1 a;
    private boolean b;
    private boolean c;
    private long d;
    private long e;
    private final CRC32 f;
    private InputStream g;

    private r1() {
        this.a = new o1();
        this.f = new CRC32();
    }

    static /* synthetic */ long c(r1 r1Var, long j2) {
        long j3 = r1Var.e + j2;
        r1Var.e = j3;
        return j3;
    }

    static /* synthetic */ long d(r1 r1Var, long j2) {
        long j3 = r1Var.e - j2;
        r1Var.e = j3;
        return j3;
    }

    static /* synthetic */ long g(r1 r1Var, long j2) {
        long j3 = r1Var.d + j2;
        r1Var.d = j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends InputStream> T o() {
        InputStream inputStream = this.g;
        Objects.requireNonNull(inputStream, "inputStream");
        return (T) inputStream;
    }

    /* synthetic */ r1(p1 p1Var) {
        this();
    }
}
