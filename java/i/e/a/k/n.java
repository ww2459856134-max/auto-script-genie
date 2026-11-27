package i.e.a.k;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class n extends c {
    public n(w wVar, OutputStream outputStream, i.e.a.l.o oVar) {
        super(wVar, outputStream, oVar);
    }

    @Override // i.e.a.k.c
    protected final void S(int i2) throws IOException, XMLStreamException {
        n("content", i2);
        throw null;
    }

    @Override // i.e.a.k.c
    protected final int T(int i2, char[] cArr, int i3, int i4) throws IOException, XMLStreamException {
        if (i2 >= 55296) {
            if (i2 <= 57343) {
                if (i3 >= i4) {
                    this.f1618l = i2;
                    return i3;
                }
                int i5 = i3 + 1;
                U(i2, cArr[i3]);
                return i5;
            }
            if (i2 >= 65534) {
                o(i2);
                throw null;
            }
        }
        Y(i2);
        return i3;
    }

    @Override // i.e.a.k.c
    protected final void U(int i2, int i3) throws IOException, XMLStreamException {
        Y(K(i2, i3, " in content"));
    }
}
