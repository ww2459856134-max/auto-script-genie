package k.x.i1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class t implements c0 {
    private static k.y.c e = k.y.c.b(t.class);
    private z[] d;
    private int b = 0;
    private byte[] a = null;
    private boolean c = false;

    private void e(y yVar, ArrayList arrayList) {
        z[] zVarArrN = yVar.n();
        for (int i2 = 0; i2 < zVarArrN.length; i2++) {
            if (zVarArrN[i2].h() == b0.f2039h) {
                arrayList.add(zVarArrN[i2]);
            } else if (zVarArrN[i2].h() == b0.g) {
                e((y) zVarArrN[i2], arrayList);
            } else {
                e.f("Spgr Containers contains a record other than Sp/Spgr containers");
            }
        }
    }

    private void f() {
        a0 a0Var = new a0(this, 0);
        k.y.a.a(a0Var.h());
        y yVar = new y(a0Var);
        yVar.n();
        z[] zVarArrN = yVar.n();
        y yVar2 = null;
        for (int i2 = 0; i2 < zVarArrN.length && yVar2 == null; i2++) {
            z zVar = zVarArrN[i2];
            if (zVar.h() == b0.g) {
                yVar2 = (y) zVar;
            }
        }
        k.y.a.a(yVar2 != null);
        z[] zVarArrN2 = yVar2.n();
        boolean z = false;
        for (int i3 = 0; i3 < zVarArrN2.length && !z; i3++) {
            if (zVarArrN2[i3].h() == b0.g) {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            e(yVar2, arrayList);
            z[] zVarArr = new z[arrayList.size()];
            this.d = zVarArr;
            this.d = (z[]) arrayList.toArray(zVarArr);
        } else {
            this.d = zVarArrN2;
        }
        this.c = true;
    }

    public void a(byte[] bArr) {
        b(bArr);
        this.b++;
    }

    public void b(byte[] bArr) {
        byte[] bArr2 = this.a;
        if (bArr2 == null) {
            this.a = bArr;
            return;
        }
        byte[] bArr3 = new byte[bArr2.length + bArr.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, this.a.length, bArr.length);
        this.a = bArr3;
        this.c = false;
    }

    final int c() {
        return this.b;
    }

    y d(int i2) {
        if (!this.c) {
            f();
        }
        int i3 = i2 + 1;
        z[] zVarArr = this.d;
        if (i3 >= zVarArr.length) {
            throw new u();
        }
        y yVar = (y) zVarArr[i3];
        k.y.a.a(yVar != null);
        return yVar;
    }

    @Override // k.x.i1.c0
    public byte[] getData() {
        return this.a;
    }
}
