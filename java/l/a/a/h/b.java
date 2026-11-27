package l.a.a.h;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.regex.Matcher;
import l.a.a.f.q;

/* loaded from: classes.dex */
public abstract class b<T> extends l<T> {
    private final q d;
    private final l.a.a.f.k e;

    public b(q qVar, l.a.a.f.k kVar, k kVar2) {
        super(kVar2);
        this.d = qVar;
        this.e = kVar;
    }

    private void k(File file, String str, l.a.a.f.i iVar) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (file.isDirectory()) {
            String str2 = l.a.a.i.e.a;
            if (!canonicalPath.endsWith(str2)) {
                canonicalPath = canonicalPath + str2;
            }
        }
        String canonicalPath2 = new File(str).getCanonicalPath();
        String str3 = l.a.a.i.e.a;
        if (!canonicalPath2.endsWith(str3)) {
            canonicalPath2 = canonicalPath2 + str3;
        }
        if (canonicalPath.startsWith(canonicalPath2)) {
            return;
        }
        throw new l.a.a.c.b("illegal file name that breaks out of the target directory: " + iVar.j());
    }

    private void l(File file) throws l.a.a.c.b {
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return;
        }
        throw new l.a.a.c.b("Unable to create parent directories: " + file.getParentFile());
    }

    private void m(l.a.a.e.a.l lVar, l.a.a.f.i iVar, File file, l.a.a.g.d dVar) throws IOException {
        String str = new String(s(lVar, iVar, dVar));
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new l.a.a.c.b("Could not create parent directories");
        }
        try {
            Path path = Paths.get(str, new String[0]);
            if (file.exists() && !file.delete()) {
                throw new l.a.a.c.b("Could not delete existing symlink " + file);
            }
            Files.createSymbolicLink(file.toPath(), path, new FileAttribute[0]);
        } catch (NoSuchMethodError unused) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private File n(l.a.a.f.i iVar, String str, String str2) {
        String strJ = iVar.j();
        if (!l.a.a.i.i.j(str2)) {
            str2 = strJ;
        }
        return new File(str, p(str2));
    }

    private String p(String str) {
        return str.replaceAll(":\\\\", "_").replaceAll("[/\\\\]", Matcher.quoteReplacement(l.a.a.i.e.a));
    }

    private boolean r(l.a.a.f.i iVar) {
        byte[] bArrO = iVar.O();
        if (bArrO == null || bArrO.length < 4) {
            return false;
        }
        return l.a.a.i.a.a(bArrO[3], 5);
    }

    private byte[] s(l.a.a.e.a.l lVar, l.a.a.f.i iVar, l.a.a.g.d dVar) throws InterruptedException, IOException {
        int iN = (int) iVar.n();
        byte[] bArr = new byte[iN];
        if (lVar.read(bArr) != iN) {
            throw new l.a.a.c.b("Could not read complete entry");
        }
        dVar.l(iN);
        return bArr;
    }

    private void t(l.a.a.e.a.l lVar, File file, l.a.a.g.d dVar, byte[] bArr) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i2 = lVar.read(bArr);
                    if (i2 == -1) {
                        fileOutputStream.close();
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, i2);
                        dVar.l(i2);
                        j();
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    private void u(l.a.a.e.a.l lVar, l.a.a.f.i iVar) throws IOException {
        if (l.a.a.i.a.a(iVar.l()[0], 6)) {
            throw new l.a.a.c.b("Entry with name " + iVar.j() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
        l.a.a.f.j jVarM = lVar.m(iVar, false);
        if (jVarM != null) {
            if (!iVar.j().equals(jVarM.j())) {
                throw new l.a.a.c.b("File header and local file header mismatch");
            }
        } else {
            throw new l.a.a.c.b("Could not read corresponding local file header for file header: " + iVar.j());
        }
    }

    @Override // l.a.a.h.l
    protected l.a.a.g.c g() {
        return l.a.a.g.c.EXTRACT_ENTRY;
    }

    protected void o(l.a.a.e.a.l lVar, l.a.a.f.i iVar, String str, String str2, l.a.a.g.d dVar, byte[] bArr) throws Exception {
        boolean zR = r(iVar);
        if (!zR || this.e.a()) {
            String str3 = l.a.a.i.e.a;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
            File fileN = n(iVar, str, str2);
            dVar.h(fileN.getAbsolutePath());
            k(fileN, str, iVar);
            u(lVar, iVar);
            if (iVar.r()) {
                if (!fileN.exists() && !fileN.mkdirs()) {
                    throw new l.a.a.c.b("Could not create directory: " + fileN);
                }
            } else if (zR) {
                m(lVar, iVar, fileN, dVar);
            } else {
                l(fileN);
                t(lVar, fileN, dVar, bArr);
            }
            if (zR) {
                return;
            }
            l.a.a.i.h.a(iVar, fileN);
        }
    }

    public q q() {
        return this.d;
    }
}
