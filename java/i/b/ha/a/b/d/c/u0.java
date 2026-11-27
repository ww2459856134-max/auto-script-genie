package i.b.ha.a.b.d.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
final class u0 extends i.b.ha.a.b.e.d.a {
    private final boolean[] D;

    u0(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        F(9);
        z(13);
        this.D = new boolean[w()];
        for (int i2 = 0; i2 < 256; i2++) {
            this.D[i2] = true;
        }
        H(q() + 1);
    }

    private void I() {
        boolean[] zArr = new boolean[XMLEvent.ENTITY_REFERENCE];
        int i2 = 0;
        while (true) {
            boolean[] zArr2 = this.D;
            if (i2 >= zArr2.length) {
                break;
            }
            if (zArr2[i2] && u(i2) != -1) {
                zArr[u(i2)] = true;
            }
            i2++;
        }
        for (int iQ = q() + 1; iQ < 8192; iQ++) {
            if (!zArr[iQ]) {
                this.D[iQ] = false;
                G(iQ, -1);
            }
        }
    }

    @Override // i.b.ha.a.b.e.d.a
    protected int j(int i2, byte b) throws IOException {
        int iX = x();
        while (iX < 8192 && this.D[iX]) {
            iX++;
        }
        H(iX);
        int iM = m(i2, b, XMLEvent.ENTITY_REFERENCE);
        if (iM >= 0) {
            this.D[iM] = true;
        }
        return iM;
    }

    @Override // i.b.ha.a.b.e.d.a
    protected int o() throws IOException {
        int iD = D();
        if (iD < 0) {
            return -1;
        }
        boolean z = false;
        if (iD != q()) {
            if (!this.D[iD]) {
                iD = n();
                z = true;
            }
            return p(iD, z);
        }
        int iD2 = D();
        if (iD2 < 0) {
            throw new IOException("Unexpected EOF;");
        }
        if (iD2 == 1) {
            if (s() >= 13) {
                throw new IOException("Attempt to increase code size beyond maximum");
            }
            y();
        } else {
            if (iD2 != 2) {
                throw new IOException("Invalid clear code subcode " + iD2);
            }
            I();
            H(q() + 1);
        }
        return 0;
    }
}
