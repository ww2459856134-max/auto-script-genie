package com.bumptech.glide.v;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class e {
    private ByteBuffer b;
    private d c;
    private final byte[] a = new byte[256];
    private int d = 0;

    private boolean b() {
        return this.c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.c.d.a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int iD = d();
        boolean z = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        c cVar = this.c.d;
        cVar.e = (iD & 64) != 0;
        if (z) {
            cVar.f684k = g(iPow);
        } else {
            cVar.f684k = null;
        }
        this.c.d.f683j = this.b.position();
        r();
        if (b()) {
            return;
        }
        d dVar = this.c;
        dVar.c++;
        dVar.e.add(dVar.d);
    }

    private void f() {
        int iD = d();
        this.d = iD;
        if (iD <= 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = this.d;
                if (i2 >= i3) {
                    return;
                }
                i3 -= i2;
                this.b.get(this.a, i2, i3);
                i2 += i3;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.d, e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    private int[] g(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i2) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i2) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.c.d = new c();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                d dVar = this.c;
                if (dVar.d == null) {
                    dVar.d = new c();
                }
                e();
            } else if (iD != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int iD = d();
        c cVar = this.c.d;
        int i2 = (iD & 28) >> 2;
        cVar.g = i2;
        if (i2 == 0) {
            cVar.g = 1;
        }
        cVar.f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        c cVar2 = this.c.d;
        cVar2.f682i = iN * 10;
        cVar2.f681h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        l();
        if (!this.c.f685h || b()) {
            return;
        }
        d dVar = this.c;
        dVar.a = g(dVar.f686i);
        d dVar2 = this.c;
        dVar2.f689l = dVar2.a[dVar2.f687j];
    }

    private void l() {
        this.c.f = n();
        this.c.g = n();
        int iD = d();
        d dVar = this.c;
        dVar.f685h = (iD & 128) != 0;
        dVar.f686i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.c.f687j = d();
        this.c.f688k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.f690m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.b.getShort();
    }

    private void o() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new d();
        this.d = 0;
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.b.position(Math.min(this.b.position() + iD, this.b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public d c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        k();
        if (!b()) {
            h();
            d dVar = this.c;
            if (dVar.c < 0) {
                dVar.b = 1;
            }
        }
        return this.c;
    }

    public e p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
