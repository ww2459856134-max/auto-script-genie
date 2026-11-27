package l.a.a.e.b;

import java.io.IOException;
import java.io.OutputStream;
import l.a.a.f.s;

/* loaded from: classes.dex */
class a extends b<l.a.a.b.b> {
    private byte[] e;
    private int f;

    public a(k kVar, s sVar, char[] cArr, boolean z) throws IOException {
        super(kVar, sVar, cArr, z);
        this.e = new byte[16];
        this.f = 0;
    }

    private void m(l.a.a.b.b bVar) throws IOException {
        i(bVar.e());
        i(bVar.c());
    }

    @Override // l.a.a.e.b.b
    public void a() throws IOException {
        int i2 = this.f;
        if (i2 != 0) {
            super.write(this.e, 0, i2);
            this.f = 0;
        }
        i(c().d());
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.e.b.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public l.a.a.b.b f(OutputStream outputStream, s sVar, char[] cArr, boolean z) throws IOException {
        l.a.a.b.b bVar = new l.a.a.b.b(cArr, sVar.a(), z);
        m(bVar);
        return bVar;
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
        int i4;
        int i5 = this.f;
        if (i3 >= 16 - i5) {
            System.arraycopy(bArr, i2, this.e, i5, 16 - i5);
            byte[] bArr2 = this.e;
            super.write(bArr2, 0, bArr2.length);
            int i6 = 16 - this.f;
            int i7 = i3 - i6;
            this.f = 0;
            if (i7 != 0 && (i4 = i7 % 16) != 0) {
                System.arraycopy(bArr, (i7 + i6) - i4, this.e, 0, i4);
                this.f = i4;
                i7 -= i4;
            }
            super.write(bArr, i6, i7);
            return;
        }
        System.arraycopy(bArr, i2, this.e, i5, i3);
        this.f += i3;
    }
}
