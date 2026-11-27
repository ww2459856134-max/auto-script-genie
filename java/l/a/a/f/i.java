package l.a.a.f;

import java.util.Objects;

/* loaded from: classes.dex */
public class i extends b {
    private int t;
    private int u;
    private byte[] v;
    private long w;
    private String x;

    public i() {
        b(l.a.a.d.c.CENTRAL_DIRECTORY);
    }

    private long M(i iVar) {
        return iVar.p() != null ? iVar.p().e() : iVar.Q();
    }

    public int N() {
        return this.u;
    }

    public byte[] O() {
        return this.v;
    }

    public String P() {
        return this.x;
    }

    public long Q() {
        return this.w;
    }

    public int R() {
        return this.t;
    }

    public void S(int i2) {
        this.u = i2;
    }

    public void T(byte[] bArr) {
        this.v = bArr;
    }

    public void U(String str) {
        this.x = str;
    }

    public void V(int i2) {
    }

    public void W(byte[] bArr) {
    }

    public void X(long j2) {
        this.w = j2;
    }

    public void Y(int i2) {
        this.t = i2;
    }

    @Override // l.a.a.f.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && i.class == obj.getClass() && super.equals(obj) && M(this) == M((i) obj);
    }

    public int hashCode() {
        return Objects.hash(j(), Long.valueOf(M(this)));
    }

    public String toString() {
        return j();
    }
}
