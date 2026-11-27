package n.b.a.m;

import org.apache.poi.javax.xml.stream.XMLStreamConstants;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes2.dex */
public abstract class i implements XMLStreamConstants {

    public static final class a {
        private static final byte[] e = new byte[0];
        private byte[][] a;
        private int b;
        private int c;
        private byte[] d;

        public byte[] a(byte[] bArr) {
            int length = bArr.length;
            byte[][] bArr2 = this.a;
            if (bArr2 == null) {
                this.a = new byte[100][];
            } else {
                int length2 = bArr2.length;
                if (this.b >= length2) {
                    byte[][] bArr3 = new byte[length2 + length2][];
                    this.a = bArr3;
                    System.arraycopy(bArr2, 0, bArr3, 0, length2);
                }
            }
            byte[][] bArr4 = this.a;
            int i2 = this.b;
            bArr4[i2] = bArr;
            this.b = i2 + 1;
            int i3 = this.c + length;
            this.c = i3;
            return new byte[Math.max(i3 >> 1, XmlValidationError.INCORRECT_ATTRIBUTE)];
        }

        public byte[] b(byte[] bArr, int i2) {
            int i3;
            int i4 = this.c + i2;
            if (i4 == 0) {
                return e;
            }
            byte[] bArr2 = new byte[i4];
            if (this.a != null) {
                i3 = 0;
                for (int i5 = 0; i5 < this.b; i5++) {
                    byte[] bArr3 = this.a[i5];
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i3, length);
                    i3 += length;
                }
            } else {
                i3 = 0;
            }
            System.arraycopy(bArr, 0, bArr2, i3, i2);
            this.d = bArr;
            int i6 = i3 + i2;
            if (i6 == i4) {
                return bArr2;
            }
            throw new RuntimeException("Internal error: total len assumed to be " + i4 + ", copied " + i6 + " bytes");
        }

        public byte[] c() {
            this.c = 0;
            this.b = 0;
            byte[] bArr = this.d;
            if (bArr == null) {
                return new byte[500];
            }
            this.d = null;
            return bArr;
        }
    }

    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
            default:
                return "[" + i2 + "]";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
        }
    }
}
