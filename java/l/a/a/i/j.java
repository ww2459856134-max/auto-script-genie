package l.a.a.i;

import l.a.a.f.s;

/* loaded from: classes.dex */
public abstract class j {
    public static int a(s sVar, g gVar) {
        byte[] bArr = {l.a.a.d.f.SPECIFICATION_VERSION.a(), l.a.a.d.f.UNIX.a()};
        if (d.w() && !sVar.t()) {
            bArr[1] = l.a.a.d.f.WINDOWS.a();
        }
        return gVar.m(bArr, 0);
    }

    public static l.a.a.d.g b(s sVar) {
        l.a.a.d.g gVar = l.a.a.d.g.DEFAULT;
        if (sVar.d() == l.a.a.f.t.d.DEFLATE) {
            gVar = l.a.a.d.g.DEFLATE_COMPRESSED;
        }
        if (sVar.h() > 4294967295L) {
            gVar = l.a.a.d.g.ZIP_64_FORMAT;
        }
        return (sVar.o() && sVar.f().equals(l.a.a.f.t.e.AES)) ? l.a.a.d.g.AES_ENCRYPTED : gVar;
    }
}
