package n.a.a.f;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import n.a.a.o.v0;

/* loaded from: classes.dex */
public class b implements n.a.a.e.a.a {
    private final byte[] c;

    public b(byte[] bArr, int i2) {
        this.c = new byte[16];
        a(bArr, i2);
    }

    public byte[] a(byte[] bArr, int i2) {
        byte[] bArr2 = this.c;
        bArr2[0] = bArr[i2 + 3];
        bArr2[1] = bArr[i2 + 2];
        bArr2[2] = bArr[i2 + 1];
        bArr2[3] = bArr[i2 + 0];
        bArr2[4] = bArr[i2 + 5];
        bArr2[5] = bArr[i2 + 4];
        bArr2[6] = bArr[i2 + 7];
        bArr2[7] = bArr[i2 + 6];
        System.arraycopy(bArr, i2 + 8, bArr2, 8, 8);
        return (byte[]) this.c.clone();
    }

    public UUID b() {
        return new UUID(ByteBuffer.wrap(this.c, 0, 8).getLong(), ByteBuffer.wrap(this.c, 8, 8).getLong());
    }

    public String c() {
        return b().toString().toUpperCase(Locale.ROOT);
    }

    public void d(byte[] bArr, int i2) throws ArrayStoreException {
        if (bArr.length < 16) {
            throw new ArrayStoreException("Destination byte[] must have room for at least 16 bytes, but has a length of only " + bArr.length + ".");
        }
        byte[] bArr2 = this.c;
        bArr[i2 + 0] = bArr2[3];
        bArr[i2 + 1] = bArr2[2];
        bArr[i2 + 2] = bArr2[1];
        bArr[i2 + 3] = bArr2[0];
        bArr[i2 + 4] = bArr2[5];
        bArr[i2 + 5] = bArr2[4];
        bArr[i2 + 6] = bArr2[7];
        bArr[i2 + 7] = bArr2[6];
        System.arraycopy(bArr2, 8, bArr, i2 + 8, 8);
    }

    @Override // n.a.a.e.a.a
    public Map<String, Supplier<?>> e() {
        return v0.c("uuid", new Supplier() { // from class: n.a.a.f.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.toString();
            }
        });
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && Arrays.equals(this.c, ((b) obj).c);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return "{" + c() + "}";
    }

    public b(String str) {
        this.c = new byte[16];
        String strReplaceAll = str.replaceAll("[{}-]", "");
        int i2 = 0;
        while (i2 < strReplaceAll.length()) {
            int i3 = i2 + 2;
            this.c[i2 / 2] = (byte) Integer.parseInt(strReplaceAll.substring(i2, i3), 16);
            i2 = i3;
        }
    }
}
