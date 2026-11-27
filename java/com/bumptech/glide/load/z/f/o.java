package com.bumptech.glide.load.z.f;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
final class o implements n {
    private final InputStream a;

    o(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // com.bumptech.glide.load.z.f.n
    public int a() throws IOException {
        return (c() << 8) | c();
    }

    @Override // com.bumptech.glide.load.z.f.n
    public int b(byte[] bArr, int i2) throws IOException {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2 && (i4 = this.a.read(bArr, i3, i2 - i3)) != -1) {
            i3 += i4;
        }
        if (i3 == 0 && i4 == -1) {
            throw new m();
        }
        return i3;
    }

    @Override // com.bumptech.glide.load.z.f.n
    public short c() throws IOException {
        int i2 = this.a.read();
        if (i2 != -1) {
            return (short) i2;
        }
        throw new m();
    }

    @Override // com.bumptech.glide.load.z.f.n
    public long skip(long j2) throws IOException {
        if (j2 < 0) {
            return 0L;
        }
        long j3 = j2;
        while (j3 > 0) {
            long jSkip = this.a.skip(j3);
            if (jSkip <= 0) {
                if (this.a.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j3 -= jSkip;
        }
        return j2 - j3;
    }
}
