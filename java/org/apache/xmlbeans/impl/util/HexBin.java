package org.apache.xmlbeans.impl.util;

import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class HexBin {
    private static final int LOOKUPLENGTH = 16;
    private static final int BASELENGTH = 255;
    private static final byte[] hexNumberTable = new byte[BASELENGTH];
    private static final byte[] lookUpHexAlphabet = new byte[16];

    static {
        for (int i2 = 0; i2 < BASELENGTH; i2++) {
            hexNumberTable[i2] = -1;
        }
        for (int i3 = 57; i3 >= 48; i3--) {
            hexNumberTable[i3] = (byte) (i3 - 48);
        }
        for (int i4 = 70; i4 >= 65; i4--) {
            hexNumberTable[i4] = (byte) ((i4 - 65) + 10);
        }
        for (int i5 = 102; i5 >= 97; i5--) {
            hexNumberTable[i5] = (byte) ((i5 - 97) + 10);
        }
        for (int i6 = 0; i6 < 10; i6++) {
            lookUpHexAlphabet[i6] = (byte) (i6 + 48);
        }
        for (int i7 = 10; i7 <= 15; i7++) {
            lookUpHexAlphabet[i7] = (byte) ((i7 + 65) - 10);
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(encode(bArr), StandardCharsets.ISO_8859_1);
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (length % 2 != 0) {
            return null;
        }
        int i2 = length / 2;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            if (isHex(bArr[i4])) {
                int i5 = i4 + 1;
                if (isHex(bArr[i5])) {
                    byte[] bArr3 = hexNumberTable;
                    bArr2[i3] = (byte) ((bArr3[bArr[i4]] << 4) | bArr3[bArr[i5]]);
                }
            }
            return null;
        }
        return bArr2;
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length * 2];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            byte[] bArr3 = lookUpHexAlphabet;
            bArr2[i3] = bArr3[(bArr[i2] >> 4) & 15];
            bArr2[i3 + 1] = bArr3[bArr[i2] & 15];
        }
        return bArr2;
    }

    static boolean isHex(byte b) {
        return hexNumberTable[b & 255] != -1;
    }

    public static byte[] stringToBytes(String str) {
        return decode(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static String encode(String str) {
        byte[] bArrEncode;
        if (str == null || (bArrEncode = encode(str.getBytes(StandardCharsets.UTF_8))) == null) {
            return null;
        }
        return new String(bArrEncode, StandardCharsets.ISO_8859_1);
    }

    public static String decode(String str) {
        byte[] bArrDecode;
        if (str == null || (bArrDecode = decode(str.getBytes(StandardCharsets.ISO_8859_1))) == null) {
            return null;
        }
        return new String(bArrDecode, StandardCharsets.UTF_8);
    }
}
