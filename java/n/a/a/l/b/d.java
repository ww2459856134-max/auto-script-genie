package n.a.a.l.b;

import java.security.DigestException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import n.a.a.o.j1;
import n.a.a.o.y0;

/* loaded from: classes.dex */
public abstract class d {
    public static int a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        byte[] bArrG = g(str);
        short sF = 0;
        if (!str.isEmpty()) {
            for (int length = bArrG.length - 1; length >= 0; length--) {
                sF = (short) (f(sF) ^ bArrG[length]);
            }
            sF = (short) (((short) (f(sF) ^ bArrG.length)) ^ 52811);
        }
        return 65535 & sF;
    }

    public static Cipher b(Key key, b bVar, a aVar, byte[] bArr, int i2, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Cipher cipher;
        int length = key.getEncoded().length;
        if (str == null) {
            str = "NoPadding";
        }
        try {
            if (Cipher.getMaxAllowedKeyLength(bVar.c) < length * 8) {
                throw new n.a.a.b("Export Restrictions in place - please install JCE Unlimited Strength Jurisdiction Policy files");
            }
            if (bVar == b.e) {
                cipher = Cipher.getInstance(bVar.c);
            } else if (bVar.d) {
                if (aVar == null) {
                    throw new IllegalArgumentException("Did not have a chain for cipher " + bVar);
                }
                e();
                cipher = Cipher.getInstance(bVar.c + "/" + aVar.c + "/" + str, "BC");
            } else {
                if (aVar == null) {
                    throw new IllegalArgumentException("Did not have a chain for cipher " + bVar);
                }
                cipher = Cipher.getInstance(bVar.c + "/" + aVar.c + "/" + str);
            }
            if (bArr == null) {
                cipher.init(i2, key);
            } else {
                cipher.init(i2, key, bVar == b.f2299i ? new RC2ParameterSpec(key.getEncoded().length * 8, bArr) : new IvParameterSpec(bArr));
            }
            return cipher;
        } catch (GeneralSecurityException e) {
            throw new n.a.a.b(e);
        }
    }

    public static MessageDigest c(e eVar) {
        try {
            if (!eVar.e) {
                return MessageDigest.getInstance(eVar.c);
            }
            e();
            return MessageDigest.getInstance(eVar.c, "BC");
        } catch (GeneralSecurityException e) {
            throw new n.a.a.b("hash algo not supported", e);
        }
    }

    public static byte[] d(String str, e eVar, byte[] bArr, int i2, boolean z) throws DigestException {
        if (str == null) {
            str = "VelvetSweatshop";
        }
        MessageDigest messageDigestC = c(eVar);
        messageDigestC.update(bArr);
        byte[] bArrDigest = messageDigestC.digest(j1.d(str));
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = z ? bArr2 : bArrDigest;
        byte[] bArr4 = z ? bArrDigest : bArr2;
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                y0.b(bArr2, 0, i3);
                messageDigestC.reset();
                messageDigestC.update(bArr3);
                messageDigestC.update(bArr4);
                messageDigestC.digest(bArrDigest, 0, bArrDigest.length);
            } catch (DigestException unused) {
                throw new n.a.a.b("error in password hashing");
            }
        }
        return bArrDigest;
    }

    public static void e() {
        if (Security.getProvider("BC") != null) {
            return;
        }
        try {
            Security.addProvider((Provider) d.class.getClassLoader().loadClass("org.bouncycastle.jce.provider.BouncyCastleProvider").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception e) {
            throw new n.a.a.b("Only the BouncyCastle provider supports your encryption settings - please add it to the classpath.", e);
        }
    }

    private static short f(short s) {
        return (short) (((short) ((s << 1) & 32767)) | ((short) ((s & 16384) == 0 ? 0 : 1)));
    }

    private static byte[] g(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            byte b = (byte) (cCharAt & 255);
            byte b2 = (byte) ((cCharAt >>> '\b') & 255);
            if (b == 0) {
                b = b2;
            }
            bArr[i2] = b;
        }
        return bArr;
    }
}
