package l.a.a.e.a;

import java.io.IOException;

/* loaded from: classes.dex */
class m extends b<l.a.a.b.g> {
    public m(k kVar, l.a.a.f.j jVar, char[] cArr, int i2, boolean z) throws IOException {
        super(kVar, jVar, cArr, i2, z);
    }

    private byte[] m() throws IOException {
        byte[] bArr = new byte[12];
        j(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l.a.a.e.a.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public l.a.a.b.g i(l.a.a.f.j jVar, char[] cArr, boolean z) throws IOException {
        return new l.a.a.b.g(cArr, jVar.f(), jVar.m(), m(), z);
    }
}
