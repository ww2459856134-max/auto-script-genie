package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class c0 implements r0 {
    public static final c0 d = new c0(0);
    public static final c0 e = new c0(1);
    public static final c0 f = new c0(2);
    private final int c;

    private c0(int i2) {
        this.c = i2;
    }

    @Override // i.b.ha.a.b.d.c.r0
    public a2 a(byte[] bArr, int i2, int i3, boolean z, int i4) throws ZipException {
        int i5 = this.c;
        if (i5 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Bad extra field starting at ");
            sb.append(i2);
            sb.append(".  Block length of ");
            sb.append(i4);
            sb.append(" bytes exceeds remaining data of ");
            sb.append(i3 - 4);
            sb.append(" bytes.");
            throw new ZipException(sb.toString());
        }
        if (i5 == 1) {
            return null;
        }
        if (i5 != 2) {
            throw new ZipException("Unknown UnparseableExtraField key: " + this.c);
        }
        s0 s0Var = new s0();
        if (z) {
            s0Var.g(bArr, i2, i3);
        } else {
            s0Var.b(bArr, i2, i3);
        }
        return s0Var;
    }
}
