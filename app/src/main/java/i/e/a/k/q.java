package i.e.a.k;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class q extends c {
    public q(w wVar, OutputStream outputStream) {
        super(wVar, outputStream, i.i());
    }

    @Override // i.e.a.k.c
    protected r L(String str) throws XMLStreamException {
        try {
            return new b(str, str.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // i.e.a.k.c
    protected r M(String str, String str2) throws XMLStreamException {
        try {
            return new b(str, str2, (str + ParameterizedMessage.ERROR_MSG_SEPARATOR + str2).getBytes("UTF-8"));
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    @Override // i.e.a.k.c
    protected final void S(int i2) throws IOException, XMLStreamException {
        if (this.f1616j + 2 > this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i3 = this.f1616j;
        int i4 = i3 + 1;
        this.f1616j = i4;
        bArr[i3] = (byte) ((i2 >> 6) | 192);
        this.f1616j = i4 + 1;
        bArr[i4] = (byte) ((i2 & 63) | 128);
    }

    @Override // i.e.a.k.c
    protected final int T(int i2, char[] cArr, int i3, int i4) throws IOException, XMLStreamException {
        if (i2 >= 55296) {
            if (i2 <= 57343) {
                if (i3 >= i4) {
                    this.f1618l = i2;
                    return i3;
                }
                U(i2, cArr[i3]);
                return i3 + 1;
            }
            if (i2 >= 65534) {
                o(i2);
                throw null;
            }
        }
        if (this.f1616j + 3 > this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i5 = this.f1616j;
        int i6 = i5 + 1;
        this.f1616j = i6;
        bArr[i5] = (byte) ((i2 >> 12) | 224);
        int i7 = i6 + 1;
        this.f1616j = i7;
        bArr[i6] = (byte) (((i2 >> 6) & 63) | 128);
        this.f1616j = i7 + 1;
        bArr[i7] = (byte) ((i2 & 63) | 128);
        return i3;
    }

    @Override // i.e.a.k.c
    protected final void U(int i2, int i3) throws IOException, XMLStreamException {
        int iK = K(i2, i3, " in content");
        if (this.f1616j + 4 > this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i4 = this.f1616j;
        int i5 = i4 + 1;
        this.f1616j = i5;
        bArr[i4] = (byte) ((iK >> 18) | 240);
        int i6 = i5 + 1;
        this.f1616j = i6;
        bArr[i5] = (byte) (((iK >> 12) & 63) | 128);
        int i7 = i6 + 1;
        this.f1616j = i7;
        bArr[i6] = (byte) (((iK >> 6) & 63) | 128);
        this.f1616j = i7 + 1;
        bArr[i7] = (byte) ((iK & 63) | 128);
    }

    @Override // i.e.a.k.x
    public int j() {
        return 1114111;
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
            do {
                char c = cArr[i2];
                if (c >= 128) {
                    int i6 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < 2048) {
                        S(c2);
                        i2 = i6;
                    } else {
                        i2 = T(c2, cArr, i6, i5);
                    }
                } else {
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i7 = this.f1616j;
                    this.f1616j = i7 + 1;
                    bArr[i7] = (byte) c;
                    i2++;
                }
            } while (i2 < i5);
            return;
        }
    }
}
