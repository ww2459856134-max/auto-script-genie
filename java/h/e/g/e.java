package h.e.g;

import java.util.Comparator;

/* loaded from: classes.dex */
class e implements Comparator<byte[]> {
    e() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    length = bArr[i2];
                    length2 = bArr2[i2];
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }
}
