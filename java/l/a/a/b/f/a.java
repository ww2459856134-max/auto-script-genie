package l.a.a.b.f;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class a implements d {
    private Mac a;
    private int b;
    private String c;
    private ByteArrayOutputStream d = new ByteArrayOutputStream(XMLEvent.CHANGE_PREFIX_MAPPING);

    public a(String str) throws NoSuchAlgorithmException {
        this.c = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.a = mac;
            this.b = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private void f(int i2) throws IllegalStateException {
        byte[] byteArray = this.d.toByteArray();
        int length = byteArray.length - i2;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 16;
            this.a.update(byteArray, i3, i4 <= length ? 16 : length - i3);
            i3 = i4;
        }
        this.d.reset();
    }

    @Override // l.a.a.b.f.d
    public int a() {
        return this.b;
    }

    @Override // l.a.a.b.f.d
    public void b(byte[] bArr) throws InvalidKeyException {
        try {
            this.a.init(new SecretKeySpec(bArr, this.c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // l.a.a.b.f.d
    public byte[] c(byte[] bArr) throws IllegalStateException {
        if (this.d.size() > 0) {
            f(0);
        }
        return this.a.doFinal(bArr);
    }

    public byte[] d() {
        return e(0);
    }

    public byte[] e(int i2) throws IllegalStateException {
        if (this.d.size() > 0) {
            f(i2);
        }
        return this.a.doFinal();
    }

    public void g(byte[] bArr, int i2, int i3) {
        try {
            if (this.d.size() + i3 > 4096) {
                f(0);
            }
            this.d.write(bArr, i2, i3);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
