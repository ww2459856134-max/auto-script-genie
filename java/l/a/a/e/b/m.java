package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;
import l.a.a.f.s;

/* loaded from: classes.dex */
class m extends b<l.a.a.b.h> {
    public m(k kVar, s sVar, char[] cArr, boolean z) throws IOException {
        super(kVar, sVar, cArr, z);
    }

    private long j(s sVar) {
        return sVar.u() ? (l.a.a.i.i.h(sVar.l()) & 65535) << 16 : sVar.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.e.b.b
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l.a.a.b.h f(OutputStream outputStream, s sVar, char[] cArr, boolean z) throws IOException {
        l.a.a.b.h hVar = new l.a.a.b.h(cArr, j(sVar), z);
        i(hVar.e());
        return hVar;
    }

    @Override // l.a.a.e.b.b, java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // l.a.a.e.b.b, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // l.a.a.e.b.b, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        super.write(bArr, i2, i3);
    }
}
