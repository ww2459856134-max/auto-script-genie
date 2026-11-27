package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

/* loaded from: classes.dex */
final class n0 extends o0 {

    /* renamed from: i, reason: collision with root package name */
    private final OutputStream f1431i;

    n0(Deflater deflater, OutputStream outputStream) {
        super(deflater);
        this.f1431i = outputStream;
    }

    @Override // i.b.ha.a.b.d.c.o0
    protected void u(byte[] bArr, int i2, int i3) throws IOException {
        this.f1431i.write(bArr, i2, i3);
    }
}
