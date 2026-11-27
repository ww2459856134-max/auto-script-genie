package k.x;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class y0 {
    private static k.y.c a = k.y.c.b(y0.class);
    public static String b = "UnicodeLittle";

    public static void a(String str, byte[] bArr, int i2) {
        byte[] bArrB = b(str);
        System.arraycopy(bArrB, 0, bArr, i2, bArrB.length);
    }

    public static byte[] b(String str) {
        return str.getBytes();
    }

    public static byte[] c(String str, k.w wVar) {
        try {
            return str.getBytes(wVar.e());
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String d(byte[] bArr, int i2, int i3, k.w wVar) {
        if (i2 == 0) {
            return "";
        }
        try {
            return new String(bArr, i3, i2, wVar.e());
        } catch (UnsupportedEncodingException e) {
            a.f(e.toString());
            return "";
        }
    }

    public static void e(String str, byte[] bArr, int i2) {
        byte[] bArrF = f(str);
        System.arraycopy(bArrF, 0, bArr, i2, bArrF.length);
    }

    public static byte[] f(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes(b);
            if (bytes.length != (str.length() * 2) + 2) {
                return bytes;
            }
            int length = bytes.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 2, bArr, 0, length);
            return bArr;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String g(byte[] bArr, int i2, int i3) {
        int i4 = i2 * 2;
        try {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            return new String(bArr2, b);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static final String h(String str, String str2, String str3) {
        int iIndexOf = str.indexOf(str2);
        while (iIndexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, iIndexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(str2.length() + iIndexOf));
            str = stringBuffer.toString();
            iIndexOf = str.indexOf(str2, iIndexOf + str3.length());
        }
        return str;
    }
}
