package i.b.ha.a.b.d.c;

import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public final class e0 implements Cloneable {
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f1407h;

    public static e0 d(byte[] bArr, int i2) {
        int iE = l2.e(bArr, i2);
        e0 e0Var = new e0();
        e0Var.e((iE & 8) != 0);
        e0Var.h((iE & 2048) != 0);
        e0Var.g((iE & 64) != 0);
        e0Var.f((iE & 1) != 0);
        e0Var.g = (iE & 2) != 0 ? XMLEvent.ENTITY_REFERENCE : XMLEvent.CHANGE_PREFIX_MAPPING;
        e0Var.f1407h = (iE & 4) != 0 ? 3 : 2;
        return e0Var;
    }

    public void a(byte[] bArr, int i2) {
        l2.g((this.d ? 8 : 0) | (this.c ? 2048 : 0) | (this.e ? 1 : 0) | (this.f ? 64 : 0), bArr, i2);
    }

    int b() {
        return this.f1407h;
    }

    int c() {
        return this.g;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException("GeneralPurposeBit is not Cloneable?", e);
        }
    }

    public void e(boolean z) {
        this.d = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return e0Var.e == this.e && e0Var.f == this.f && e0Var.c == this.c && e0Var.d == this.d;
    }

    public void f(boolean z) {
        this.e = z;
    }

    public void g(boolean z) {
        this.f = z;
        if (z) {
            f(true);
        }
    }

    public void h(boolean z) {
        this.c = z;
    }

    public int hashCode() {
        return (((((((this.e ? 1 : 0) * 17) + (this.f ? 1 : 0)) * 13) + (this.c ? 1 : 0)) * 7) + (this.d ? 1 : 0)) * 3;
    }

    public boolean i() {
        return this.d;
    }

    public boolean j() {
        return this.e;
    }

    public boolean k() {
        return this.c;
    }
}
