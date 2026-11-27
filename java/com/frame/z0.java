package com.frame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class z0 {
    protected static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest b;

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(z0.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char[] cArr = a;
        char c = cArr[(b2 & 240) >> 4];
        char c2 = cArr[b2 & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    private static String b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    private static String c(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            a(bArr[i2], stringBuffer);
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        return e(str.getBytes());
    }

    public static synchronized String e(byte[] bArr) {
        b.update(bArr);
        return b(b.digest());
    }
}
