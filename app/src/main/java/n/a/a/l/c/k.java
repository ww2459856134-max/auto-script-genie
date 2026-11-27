package n.a.a.l.c;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import n.a.a.o.a1;
import n.a.a.o.w0;
import n.a.a.o.y0;

/* loaded from: classes.dex */
public enum k {
    OLE2(-2226271756974174256L),
    OOXML(80, 75, 3, 4),
    XML(60, 63, 120, 109, 108),
    BIFF2(9, 0, 4, 0, 0, 0, 63, 0),
    BIFF3(9, 2, 6, 0, 0, 0, 63, 0),
    BIFF4(new byte[]{9, 4, 6, 0, 0, 0, 63, 0}, new byte[]{9, 4, 6, 0, 0, 0, 0, 1}),
    MSWRITE(new byte[]{49, -66, 0, 0}, new byte[]{50, -66, 0, 0}),
    RTF("{\\rtf"),
    PDF("%PDF"),
    HTML("<!DOCTYP", "<html", "\n\r<html", "\r\n<html", "\r<html", "\n<html", "<HTML", "\r\n<HTML", "\n\r<HTML", "\r<HTML", "\n<HTML"),
    WORD2(219, 165, 45, 0),
    JPEG(new byte[]{-1, -40, -1, -37}, new byte[]{-1, -40, -1, -32, 63, 63, 74, 70, 73, 70, 0, 1}, new byte[]{-1, -40, -1, -18}, new byte[]{-1, -40, -1, -31, 63, 63, 69, 120, 105, 102, 0, 0}),
    GIF("GIF87a", "GIF89a"),
    PNG(137, 80, 78, 71, 13, 10, 26, 10),
    TIFF("II*\u0000", "MM\u0000*"),
    WMF(215, 205, 198, 154),
    EMF(1, 0, 0, 0, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 32, 69, 77, 70),
    BMP(66, 77),
    UNKNOWN(new byte[0]);

    final byte[][] c;

    k(long j2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, 1, 8);
        this.c = bArr;
        y0.c(bArr[0], 0, j2);
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b = bArr[i2];
            int i4 = i3 + 1;
            if (bArr2[i3] != b && b != 63) {
                return false;
            }
            i2++;
            i3 = i4;
        }
        return true;
    }

    public static InputStream b(InputStream inputStream) {
        return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }

    public static k c(InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            return d(w0.k(inputStream, 44));
        }
        throw new IOException("getFileMagic() only operates on streams which support mark(int)");
    }

    public static k d(byte[] bArr) {
        for (k kVar : values()) {
            for (byte[] bArr2 : kVar.c) {
                if (bArr.length >= bArr2.length && a(bArr2, bArr)) {
                    return kVar;
                }
            }
        }
        return UNKNOWN;
    }

    k(int... iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            bArr[i2] = (byte) (iArr[i2] & 255);
        }
        this.c = new byte[][]{bArr};
    }

    k(byte[]... bArr) {
        this.c = bArr;
    }

    k(String... strArr) {
        this.c = new byte[strArr.length][];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            this.c[i3] = strArr[i2].getBytes(a1.b);
            i2++;
            i3++;
        }
    }
}
