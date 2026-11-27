package com.frame;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class n1 {
    private static final Charset a = Charset.forName("UTF-8");
    private static final Charset b;
    private static final byte[] c;
    public static final byte[][] d;

    static {
        Charset charset = StandardCharsets.UTF_8;
        b = charset;
        c = "01234567".getBytes(charset);
        d = new byte[][]{new byte[]{97, 50, 101, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{52, 50, 55, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{101, 102, 49, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{52, 106, 115, 111, 36, 100, 107, 109, 35, 107, 107, 100, 42, 108, 115, 100, 107, 64, 0, 0, 0, 0, 0, 0}, new byte[]{50, 49, 53, 97, 53, 57, 56, 54, 49, 57, 98, 56, 102, 53, 49, 48, 101, 54, 55, 55, 57, 49, 97, 50}};
    }

    private static Cipher a() throws Exception {
        String[] strArr = {"AndroidOpenSSL", "Conscrypt", "BC", "SunJCE"};
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                return Cipher.getInstance("DESede/CBC/PKCS5Padding", strArr[i2]);
            } catch (Exception unused) {
            }
        }
        return Cipher.getInstance("DESede/CBC/PKCS5Padding");
    }

    public static String b(String str) throws Exception {
        return f(str.trim(), d);
    }

    public static String c(String str, String str2) throws Exception {
        return d(str, j(str2));
    }

    public static String d(String str, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "DESede");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(c);
        Cipher cipherA = a();
        cipherA.init(2, secretKeySpec, ivParameterSpec);
        String strReplaceAll = str.replaceAll("[^A-Za-z0-9+/=]", "");
        if (TextUtils.isEmpty(strReplaceAll)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(strReplaceAll.trim(), 0);
            if (bArrDecode != null && bArrDecode.length != 0) {
                return new String(cipherA.doFinal(bArrDecode), a);
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    public static String e(String str, String... strArr) throws Exception {
        if (str == null) {
            return null;
        }
        for (String str2 : strArr) {
            try {
                return c(str, str2);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String f(String str, byte[]... bArr) throws Exception {
        String strD;
        if (str == null) {
            return null;
        }
        for (byte[] bArr2 : bArr) {
            try {
                strD = d(str, bArr2);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(strD)) {
                return strD;
            }
        }
        return null;
    }

    public static String g(String str) throws Exception {
        return i(str, d[0]);
    }

    public static String h(String str, String str2) throws Exception {
        return i(str, j(str2));
    }

    public static String i(String str, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "DESede");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(c);
        Cipher cipherA = a();
        cipherA.init(1, secretKeySpec, ivParameterSpec);
        byte[] bytes = str.getBytes(a);
        return bytes.length == 0 ? "" : Base64.encodeToString(cipherA.doFinal(bytes), 0).trim();
    }

    private static byte[] j(String str) throws Exception {
        return Arrays.copyOf(str.getBytes(a), 24);
    }

    public static String k() {
        return z0.d("xxx$222$5F@").substring(6);
    }

    public static String l() {
        return z0.d("xxx$222$5F@").substring(28);
    }
}
