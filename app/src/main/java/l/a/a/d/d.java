package l.a.a.d;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import l.a.a.f.i;
import l.a.a.f.q;

/* loaded from: classes.dex */
public abstract class d {
    public static String a(byte[] bArr, boolean z, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z) {
            return new String(bArr, l.a.a.i.e.b);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] b(String str, Charset charset) {
        return charset == null ? str.getBytes(l.a.a.i.e.c) : str.getBytes(charset);
    }

    public static i c(q qVar, String str) throws l.a.a.c.b {
        i iVarD = d(qVar, str);
        if (iVarD != null) {
            return iVarD;
        }
        String strReplaceAll = str.replaceAll("\\\\", "/");
        i iVarD2 = d(qVar, strReplaceAll);
        return iVarD2 == null ? d(qVar, strReplaceAll.replaceAll("/", "\\\\")) : iVarD2;
    }

    private static i d(q qVar, String str) throws l.a.a.c.b {
        if (qVar == null) {
            throw new l.a.a.c.b("zip model is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (!l.a.a.i.i.j(str)) {
            throw new l.a.a.c.b("file name is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (qVar.a() == null) {
            throw new l.a.a.c.b("central directory is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (qVar.a().a() == null) {
            throw new l.a.a.c.b("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        }
        if (qVar.a().a().size() == 0) {
            return null;
        }
        for (i iVar : qVar.a().a()) {
            String strJ = iVar.j();
            if (l.a.a.i.i.j(strJ) && str.equals(strJ)) {
                return iVar;
            }
        }
        return null;
    }

    public static long e(q qVar) {
        return qVar.i() ? qVar.f().e() : qVar.b().g();
    }

    public static long f(List<i> list) {
        long jN = 0;
        for (i iVar : list) {
            jN += (iVar.p() == null || iVar.p().f() <= 0) ? iVar.n() : iVar.p().f();
        }
        return jN;
    }
}
