package k.x.i1;

import k.a0.a.f2;
import k.x.c1;
import k.x.z0;

/* loaded from: classes.dex */
public class e0 extends c1 {
    private boolean c;
    private byte[] d;

    static {
        k.y.c.b(e0.class);
    }

    public e0(f2 f2Var) {
        super(f2Var);
        this.d = x().c();
        this.c = false;
    }

    public boolean A() {
        return this.c;
    }

    public void B() {
        this.c = true;
    }

    @Override // k.x.w0
    public f2 x() {
        return super.x();
    }

    @Override // k.x.c1
    public byte[] y() {
        return this.d;
    }

    public e0(byte[] bArr) {
        super(z0.P0);
        this.d = bArr;
        this.c = false;
    }
}
