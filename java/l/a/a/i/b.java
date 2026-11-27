package l.a.a.i;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public abstract class b {
    public static long a(File file, l.a.a.g.d dVar) throws IOException {
        if (file == null || !file.exists() || !file.canRead()) {
            throw new l.a.a.c.b("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
        }
        byte[] bArr = new byte[16384];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    long value = crc32.getValue();
                    fileInputStream.close();
                    return value;
                }
                crc32.update(bArr, 0, i2);
                if (dVar != null) {
                    dVar.l(i2);
                    if (dVar.e()) {
                        dVar.i(l.a.a.g.a.CANCELLED);
                        dVar.j(l.a.a.g.b.READY);
                        fileInputStream.close();
                        return 0L;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
