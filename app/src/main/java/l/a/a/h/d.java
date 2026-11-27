package l.a.a.h;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l.a.a.f.q;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
abstract class d<T> extends l<T> {
    d(k kVar) {
        super(kVar);
    }

    private int n(List<l.a.a.f.i> list, l.a.a.f.i iVar) throws l.a.a.c.b {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).equals(iVar)) {
                return i2;
            }
        }
        throw new l.a.a.c.b("Could not find file header in list of central directory file headers");
    }

    private void q(File file, File file2) throws l.a.a.c.b {
        if (!file.delete()) {
            throw new l.a.a.c.b("cannot delete old zip file");
        }
        if (!file2.renameTo(file)) {
            throw new l.a.a.c.b("cannot rename modified zip file");
        }
    }

    void k(boolean z, File file, File file2) throws l.a.a.c.b {
        if (z) {
            q(file, file2);
        } else if (!file2.delete()) {
            throw new l.a.a.c.b("Could not delete temporary file");
        }
    }

    List<l.a.a.f.i> l(List<l.a.a.f.i> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new c(this));
        return arrayList;
    }

    long m(RandomAccessFile randomAccessFile, OutputStream outputStream, long j2, long j3, l.a.a.g.d dVar, int i2) throws InterruptedException, IOException {
        l.a.a.i.d.g(randomAccessFile, outputStream, j2, j2 + j3, dVar, i2);
        return j3;
    }

    long o(List<l.a.a.f.i> list, l.a.a.f.i iVar, q qVar) throws l.a.a.c.b {
        int iN = n(list, iVar);
        return iN == list.size() + (-1) ? l.a.a.d.d.e(qVar) : list.get(iN + 1).Q();
    }

    File p(String str) {
        SecureRandom secureRandom = new SecureRandom();
        File file = new File(str + secureRandom.nextInt(XmlValidationError.UNDEFINED));
        while (file.exists()) {
            file = new File(str + secureRandom.nextInt(XmlValidationError.UNDEFINED));
        }
        return file;
    }

    void r(List<l.a.a.f.i> list, q qVar, l.a.a.f.i iVar, long j2) throws l.a.a.c.b {
        int iN = n(list, iVar);
        if (iN == -1) {
            throw new l.a.a.c.b("Could not locate modified file header in zipModel");
        }
        while (true) {
            iN++;
            if (iN >= list.size()) {
                return;
            }
            l.a.a.f.i iVar2 = list.get(iN);
            iVar2.X(iVar2.Q() + j2);
            if (qVar.i() && iVar2.p() != null && iVar2.p().e() != -1) {
                iVar2.p().i(iVar2.p().e() + j2);
            }
        }
    }
}
