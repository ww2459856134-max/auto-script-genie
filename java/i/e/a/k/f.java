package i.e.a.k;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class f extends n {
    public f(w wVar, OutputStream outputStream) {
        super(wVar, outputStream, i.h());
    }

    @Override // i.e.a.k.c
    protected r L(String str) throws XMLStreamException {
        return new b(str, c.Q(str));
    }

    @Override // i.e.a.k.c
    protected r M(String str, String str2) throws XMLStreamException {
        int length = str.length();
        int i2 = length + 1;
        byte[] bArr = new byte[str2.length() + i2];
        c.P(str, bArr, 0);
        bArr[length] = 58;
        c.P(str2, bArr, i2);
        return new b(str, str2, bArr);
    }

    @Override // i.e.a.k.x
    public int j() {
        return 255;
    }

    @Override // i.e.a.k.c
    public void p0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        if (this.f1614h == null || i3 == 0) {
            return;
        }
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            i2++;
            i3--;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int i6 = i2 + 1;
            char c = cArr[i2];
            if (c > 255) {
                n("raw content", c);
                throw null;
            }
            if (this.f1616j >= this.f1617k) {
                O();
            }
            byte[] bArr = this.f1615i;
            int i7 = this.f1616j;
            this.f1616j = i7 + 1;
            bArr[i7] = (byte) c;
            i2 = i6;
        }
    }
}
