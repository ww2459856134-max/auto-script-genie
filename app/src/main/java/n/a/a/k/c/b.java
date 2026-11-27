package n.a.a.k.c;

import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.q1;
import i.b.ha.a.b.f.h;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.ZipException;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public class b extends FilterInputStream {
    private o1 c;
    private boolean d;
    private long e;

    public b(InputStream inputStream) {
        super(inputStream);
        this.d = true;
        if (inputStream instanceof h) {
            return;
        }
        throw new IllegalArgumentException("InputStream of class " + inputStream.getClass() + " is not implementing InputStreamStatistics.");
    }

    private void a() throws IOException {
        long jA;
        if (this.d) {
            h hVar = (h) ((FilterInputStream) this).in;
            long jC = hVar.c();
            try {
                jA = hVar.a();
            } catch (NullPointerException unused) {
                jA = 0;
            }
            o1 o1Var = this.c;
            String name = o1Var == null ? "not set" : o1Var.getName();
            if (jC > f.K()) {
                throw new IOException(String.format(Locale.ROOT, "Zip bomb detected! The file would exceed the max size of the expanded data in the zip-file.\nThis may indicates that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxEntrySize() if you need to work with files which are very large.\nUncompressed size: %d, Raw/compressed size: %d\nLimits: MAX_ENTRY_SIZE: %d, Entry: %s", Long.valueOf(jC), Long.valueOf(jA), Long.valueOf(f.K()), name));
            }
            if (jC <= f.c0) {
                return;
            }
            double d = jA / jC;
            if (d < f.Z) {
                throw new IOException(String.format(Locale.ROOT, "Zip bomb detected! The file would exceed the max. ratio of compressed file size to the size of the expanded data.\nThis may indicate that the file is used to inflate memory usage and thus could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMinInflateRatio() if you need to work with files which exceed this limit.\nUncompressed size: %d, Raw/compressed size: %d, ratio: %f\nLimits: MIN_INFLATE_RATIO: %f, Entry: %s", Long.valueOf(jC), Long.valueOf(jA), Double.valueOf(d), Double.valueOf(f.Z), name));
            }
        }
    }

    o1 c() throws IOException {
        if (!(((FilterInputStream) this).in instanceof q1)) {
            throw new IllegalStateException("getNextEntry() is only allowed for stream based zip processing.");
        }
        try {
            o1 o1VarB = ((q1) ((FilterInputStream) this).in).B();
            this.c = o1VarB;
            if (this.d && o1VarB != null) {
                long j2 = this.e + 1;
                this.e = j2;
                if (j2 > f.b0) {
                    throw new IOException(String.format(Locale.ROOT, "The file appears to be potentially malicious. This file embeds more internal file entries than expected.\nThis may indicates that the file could pose a security risk.\nYou can adjust this limit via ZipSecureFile.setMaxFileCount() if you need to work with files which are very large.\nLimits: MAX_FILE_COUNT: %d", Long.valueOf(f.b0)));
                }
            }
            return o1VarB;
        } catch (EOFException unused) {
            return null;
        } catch (ZipException e) {
            String message = e.getMessage();
            if (message.startsWith("Unexpected record signature") || message.startsWith("Cannot find zip signature within the file")) {
                throw new n.a.a.k.a.c("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file", e);
            }
            throw e;
        }
    }

    void d(o1 o1Var) {
        this.c = o1Var;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = super.read();
        if (i2 > -1) {
            a();
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jN = w0.n(((FilterInputStream) this).in, j2);
        if (jN > 0) {
            a();
        }
        return jN;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = super.read(bArr, i2, i3);
        if (i4 > -1) {
            a();
        }
        return i4;
    }
}
