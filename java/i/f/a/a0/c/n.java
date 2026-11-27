package i.f.a.a0.c;

import java.util.Map;

/* loaded from: classes.dex */
public final class n {
    private final i.f.a.v.n.c a = new i.f.a.v.n.c(i.f.a.v.n.a.f1691l);

    private void a(byte[] bArr, int i2) throws i.f.a.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (i.f.a.v.n.e unused) {
            throw i.f.a.d.a();
        }
    }

    private i.f.a.v.e c(a aVar, Map<i.f.a.e, ?> map) throws i.f.a.d, i.f.a.g {
        u uVarE = aVar.e();
        o oVarD = aVar.d().d();
        b[] bVarArrB = b.b(aVar.c(), uVarE, oVarD);
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int i2 = 0;
        for (b bVar2 : bVarArrB) {
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            a(bArrA, iC2);
            int i3 = 0;
            while (i3 < iC2) {
                bArr[i2] = bArrA[i3];
                i3++;
                i2++;
            }
        }
        return m.a(bArr, uVarE, oVarD, map);
    }

    public i.f.a.v.e b(i.f.a.v.b bVar, Map<i.f.a.e, ?> map) throws i.f.a.d, i.f.a.g {
        i.f.a.d e;
        a aVar = new a(bVar);
        i.f.a.g gVar = null;
        try {
            return c(aVar, map);
        } catch (i.f.a.d e2) {
            e = e2;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                i.f.a.v.e eVarC = c(aVar, map);
                eVarC.m(new r(true));
                return eVarC;
            } catch (i.f.a.d | i.f.a.g unused) {
                if (gVar != null) {
                    throw gVar;
                }
                throw e;
            }
        } catch (i.f.a.g e3) {
            e = null;
            gVar = e3;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            i.f.a.v.e eVarC2 = c(aVar, map);
            eVarC2.m(new r(true));
            return eVarC2;
        }
    }
}
