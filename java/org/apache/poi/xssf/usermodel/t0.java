package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
public class t0 implements u0 {
    public static byte[] b(int i2) {
        n.a.a.g.a.b bVar = n.a.a.g.a.b.h().get(Integer.valueOf(i2));
        if (bVar == null) {
            return null;
        }
        short[] sArrJ = bVar.j();
        return new byte[]{(byte) sArrJ[0], (byte) sArrJ[1], (byte) sArrJ[2]};
    }

    @Override // org.apache.poi.xssf.usermodel.u0
    public byte[] a(int i2) {
        return b(i2);
    }
}
