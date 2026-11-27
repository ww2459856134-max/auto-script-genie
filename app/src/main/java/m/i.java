package m;

import javax.annotation.Nullable;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
final class i {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    i f;
    i g;

    i() {
        this.a = new byte[XMLEvent.ENTITY_REFERENCE];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        i iVar = this.g;
        if (iVar == this) {
            throw new IllegalStateException();
        }
        if (iVar.e) {
            int i2 = this.c - this.b;
            if (i2 > (8192 - iVar.c) + (iVar.d ? 0 : iVar.b)) {
                return;
            }
            f(iVar, i2);
            b();
            j.a(this);
        }
    }

    @Nullable
    public final i b() {
        i iVar = this.f;
        i iVar2 = iVar != this ? iVar : null;
        i iVar3 = this.g;
        iVar3.f = iVar;
        this.f.g = iVar3;
        this.f = null;
        this.g = null;
        return iVar2;
    }

    public final i c(i iVar) {
        iVar.g = this;
        iVar.f = this.f;
        this.f.g = iVar;
        this.f = iVar;
        return iVar;
    }

    final i d() {
        this.d = true;
        return new i(this.a, this.b, this.c, true, false);
    }

    public final i e(int i2) {
        i iVarB;
        if (i2 <= 0 || i2 > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            iVarB = d();
        } else {
            iVarB = j.b();
            System.arraycopy(this.a, this.b, iVarB.a, 0, i2);
        }
        iVarB.c = iVarB.b + i2;
        this.b += i2;
        this.g.c(iVarB);
        return iVarB;
    }

    public final void f(i iVar, int i2) {
        if (!iVar.e) {
            throw new IllegalArgumentException();
        }
        int i3 = iVar.c;
        if (i3 + i2 > 8192) {
            if (iVar.d) {
                throw new IllegalArgumentException();
            }
            int i4 = iVar.b;
            if ((i3 + i2) - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = iVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            iVar.c -= iVar.b;
            iVar.b = 0;
        }
        System.arraycopy(this.a, this.b, iVar.a, iVar.c, i2);
        iVar.c += i2;
        this.b += i2;
    }

    i(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = z2;
    }
}
