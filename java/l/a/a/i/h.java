package l.a.a.i;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import l.a.a.e.a.n;
import l.a.a.f.q;

/* loaded from: classes.dex */
public abstract class h {
    public static void a(l.a.a.f.i iVar, File file) throws IOException {
        try {
            Path path = file.toPath();
            d.A(path, iVar.O());
            d.B(path, iVar.m());
        } catch (NoSuchMethodError unused) {
            d.C(file, iVar.m());
        }
    }

    public static l.a.a.e.a.i b(q qVar) throws IOException {
        return qVar.g().getName().endsWith(".zip.001") ? new l.a.a.e.a.g(qVar.g()) : new n(qVar.g(), qVar.h(), qVar.b().d());
    }
}
