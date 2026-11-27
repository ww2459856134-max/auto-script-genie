package com.bumptech.glide.v;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class f implements b {
    private static final String u = "f";
    private int[] a;
    private final int[] b;
    private final a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f691h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f692i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f693j;

    /* renamed from: k, reason: collision with root package name */
    private int f694k;

    /* renamed from: l, reason: collision with root package name */
    private d f695l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f696m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f697n;

    /* renamed from: o, reason: collision with root package name */
    private int f698o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    public f(a aVar, d dVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        q(dVar, byteBuffer, i2);
    }

    private int i(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.p + i2; i10++) {
            byte[] bArr = this.f692i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.p + i12; i13++) {
            byte[] bArr2 = this.f692i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void j(c cVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.f693j;
        int i7 = cVar.d;
        int i8 = this.p;
        int i9 = i7 / i8;
        int i10 = cVar.b / i8;
        int i11 = cVar.c / i8;
        int i12 = cVar.a / i8;
        boolean z = this.f694k == 0;
        int i13 = this.r;
        int i14 = this.q;
        byte[] bArr = this.f692i;
        int[] iArr2 = this.a;
        Boolean bool = this.s;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i16 < i9) {
            Boolean bool2 = bool;
            if (cVar.e) {
                if (i17 >= i9) {
                    i2 = i9;
                    int i19 = i18 + 1;
                    if (i19 == 2) {
                        i18 = i19;
                        i17 = 4;
                    } else if (i19 == 3) {
                        i18 = i19;
                        i15 = 4;
                        i17 = 2;
                    } else if (i19 != 4) {
                        i18 = i19;
                    } else {
                        i18 = i19;
                        i17 = 1;
                        i15 = 2;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i17 + i15;
            } else {
                i2 = i9;
                i3 = i17;
                i17 = i16;
            }
            int i20 = i17 + i10;
            boolean z2 = i8 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i12;
                int i23 = i22 + i11;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i4 = i3;
                int i25 = i16 * i8 * cVar.c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i10;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i25 += i8;
                        i26++;
                        i10 = i27;
                    }
                } else {
                    i6 = i10;
                    int i29 = ((i23 - i22) * i8) + i25;
                    int i30 = i22;
                    while (true) {
                        i5 = i11;
                        if (i30 < i23) {
                            int i31 = i(i25, i29, cVar.c);
                            if (i31 != 0) {
                                iArr[i30] = i31;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i25 += i8;
                            i30++;
                            i11 = i5;
                        }
                    }
                    bool = bool2;
                    i16++;
                    i10 = i6;
                    i11 = i5;
                    i9 = i2;
                    i17 = i4;
                }
            } else {
                i4 = i3;
            }
            i6 = i10;
            i5 = i11;
            bool = bool2;
            i16++;
            i10 = i6;
            i11 = i5;
            i9 = i2;
            i17 = i4;
        }
        Boolean bool3 = bool;
        if (this.s == null) {
            this.s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void k(c cVar) {
        c cVar2 = cVar;
        int[] iArr = this.f693j;
        int i2 = cVar2.d;
        int i3 = cVar2.b;
        int i4 = cVar2.c;
        int i5 = cVar2.a;
        boolean z = this.f694k == 0;
        int i6 = this.r;
        byte[] bArr = this.f692i;
        int[] iArr2 = this.a;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = cVar2.c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                int i15 = b2 & 255;
                if (i15 != b) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            cVar2 = cVar;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void l(c cVar) {
        int i2;
        int i3;
        short s;
        f fVar = this;
        if (cVar != null) {
            fVar.d.position(cVar.f683j);
        }
        if (cVar == null) {
            d dVar = fVar.f695l;
            i2 = dVar.f;
            i3 = dVar.g;
        } else {
            i2 = cVar.c;
            i3 = cVar.d;
        }
        int i4 = i2 * i3;
        byte[] bArr = fVar.f692i;
        if (bArr == null || bArr.length < i4) {
            fVar.f692i = fVar.c.a(i4);
        }
        byte[] bArr2 = fVar.f692i;
        if (fVar.f == null) {
            fVar.f = new short[XMLEvent.CHANGE_PREFIX_MAPPING];
        }
        short[] sArr = fVar.f;
        if (fVar.g == null) {
            fVar.g = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
        }
        byte[] bArr3 = fVar.g;
        if (fVar.f691h == null) {
            fVar.f691h = new byte[4097];
        }
        byte[] bArr4 = fVar.f691h;
        int iP = p();
        int i5 = 1 << iP;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iP + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = fVar.e;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int iO = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = -1;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (iO == 0) {
                iO = o();
                if (iO <= 0) {
                    fVar.f698o = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            i15++;
            iO--;
            int i22 = i16 + 8;
            int i23 = i13;
            int i24 = i12;
            int i25 = i21;
            int i26 = i8;
            int i27 = i19;
            while (true) {
                if (i22 < i24) {
                    i21 = i25;
                    i13 = i23;
                    i16 = i22;
                    fVar = this;
                    i19 = i27;
                    i8 = i26;
                    i12 = i24;
                    break;
                }
                int i28 = i7;
                int i29 = i17 & i14;
                i17 >>= i24;
                i22 -= i24;
                if (i29 == i5) {
                    i14 = i9;
                    i24 = i26;
                    i23 = i28;
                    i7 = i23;
                    i25 = -1;
                } else {
                    if (i29 == i6) {
                        i16 = i22;
                        i19 = i27;
                        i13 = i23;
                        i8 = i26;
                        i7 = i28;
                        i21 = i25;
                        i12 = i24;
                        fVar = this;
                        break;
                    }
                    if (i25 == -1) {
                        bArr2[i18] = bArr3[i29];
                        i18++;
                        i10++;
                        i25 = i29;
                        i27 = i25;
                        i7 = i28;
                        i22 = i22;
                    } else {
                        if (i29 >= i23) {
                            bArr4[i20] = (byte) i27;
                            i20++;
                            s = i25;
                        } else {
                            s = i29;
                        }
                        while (s >= i5) {
                            bArr4[i20] = bArr3[s];
                            i20++;
                            s = sArr[s];
                        }
                        i27 = bArr3[s] & 255;
                        byte b = (byte) i27;
                        bArr2[i18] = b;
                        while (true) {
                            i18++;
                            i10++;
                            if (i20 <= 0) {
                                break;
                            }
                            i20--;
                            bArr2[i18] = bArr4[i20];
                        }
                        byte[] bArr6 = bArr4;
                        if (i23 < 4096) {
                            sArr[i23] = (short) i25;
                            bArr3[i23] = b;
                            i23++;
                            if ((i23 & i14) == 0 && i23 < 4096) {
                                i24++;
                                i14 += i23;
                            }
                        }
                        i25 = i29;
                        i7 = i28;
                        i22 = i22;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i18, i4, (byte) 0);
    }

    private Bitmap n() {
        Boolean bool = this.s;
        Bitmap bitmapB = this.c.b(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapB.setHasAlpha(true);
        return bitmapB;
    }

    private int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    private int p() {
        return this.d.get() & 255;
    }

    private Bitmap r(c cVar, c cVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.f693j;
        int i4 = 0;
        if (cVar2 == null) {
            Bitmap bitmap2 = this.f696m;
            if (bitmap2 != null) {
                this.c.c(bitmap2);
            }
            this.f696m = null;
            Arrays.fill(iArr, 0);
        }
        if (cVar2 != null && cVar2.g == 3 && this.f696m == null) {
            Arrays.fill(iArr, 0);
        }
        if (cVar2 != null && (i3 = cVar2.g) > 0) {
            if (i3 == 2) {
                if (!cVar.f) {
                    d dVar = this.f695l;
                    int i5 = dVar.f689l;
                    if (cVar.f684k == null || dVar.f687j != cVar.f681h) {
                        i4 = i5;
                    }
                }
                int i6 = cVar2.d;
                int i7 = this.p;
                int i8 = i6 / i7;
                int i9 = cVar2.b / i7;
                int i10 = cVar2.c / i7;
                int i11 = cVar2.a / i7;
                int i12 = this.r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.r;
                }
            } else if (i3 == 3 && (bitmap = this.f696m) != null) {
                int i17 = this.r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.q);
            }
        }
        l(cVar);
        if (cVar.e || this.p != 1) {
            j(cVar);
        } else {
            k(cVar);
        }
        if (this.f697n && ((i2 = cVar.g) == 0 || i2 == 1)) {
            if (this.f696m == null) {
                this.f696m = n();
            }
            Bitmap bitmap3 = this.f696m;
            int i18 = this.r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        }
        Bitmap bitmapN = n();
        int i19 = this.r;
        bitmapN.setPixels(iArr, 0, i19, 0, 0, i19, this.q);
        return bitmapN;
    }

    @Override // com.bumptech.glide.v.b
    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // com.bumptech.glide.v.b
    public void b() {
        this.f694k = -1;
    }

    @Override // com.bumptech.glide.v.b
    public int c() {
        return this.f694k;
    }

    @Override // com.bumptech.glide.v.b
    public void clear() {
        this.f695l = null;
        byte[] bArr = this.f692i;
        if (bArr != null) {
            this.c.e(bArr);
        }
        int[] iArr = this.f693j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.f696m;
        if (bitmap != null) {
            this.c.c(bitmap);
        }
        this.f696m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.v.b
    public int d() {
        return this.d.limit() + this.f692i.length + (this.f693j.length * 4);
    }

    @Override // com.bumptech.glide.v.b
    public synchronized Bitmap e() {
        if (this.f695l.c <= 0 || this.f694k < 0) {
            String str = u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f695l.c + ", framePointer=" + this.f694k);
            }
            this.f698o = 1;
        }
        int i2 = this.f698o;
        if (i2 != 1 && i2 != 2) {
            this.f698o = 0;
            if (this.e == null) {
                this.e = this.c.a(255);
            }
            c cVar = this.f695l.e.get(this.f694k);
            int i3 = this.f694k - 1;
            c cVar2 = i3 >= 0 ? this.f695l.e.get(i3) : null;
            int[] iArr = cVar.f684k;
            if (iArr == null) {
                iArr = this.f695l.a;
            }
            this.a = iArr;
            if (iArr == null) {
                String str2 = u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f694k);
                }
                this.f698o = 1;
                return null;
            }
            if (cVar.f) {
                System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                int[] iArr2 = this.b;
                this.a = iArr2;
                iArr2[cVar.f681h] = 0;
                if (cVar.g == 2 && this.f694k == 0) {
                    this.s = Boolean.TRUE;
                }
            }
            return r(cVar, cVar2);
        }
        String str3 = u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f698o);
        }
        return null;
    }

    @Override // com.bumptech.glide.v.b
    public void f() {
        this.f694k = (this.f694k + 1) % this.f695l.c;
    }

    @Override // com.bumptech.glide.v.b
    public int g() {
        return this.f695l.c;
    }

    @Override // com.bumptech.glide.v.b
    public ByteBuffer getData() {
        return this.d;
    }

    @Override // com.bumptech.glide.v.b
    public int h() {
        int i2;
        if (this.f695l.c <= 0 || (i2 = this.f694k) < 0) {
            return 0;
        }
        return m(i2);
    }

    public int m(int i2) {
        if (i2 >= 0) {
            d dVar = this.f695l;
            if (i2 < dVar.c) {
                return dVar.e.get(i2).f682i;
            }
        }
        return -1;
    }

    public synchronized void q(d dVar, ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
        int iHighestOneBit = Integer.highestOneBit(i2);
        this.f698o = 0;
        this.f695l = dVar;
        this.f694k = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.d = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.f697n = false;
        Iterator<c> it = dVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.f697n = true;
                break;
            }
        }
        this.p = iHighestOneBit;
        int i3 = dVar.f;
        this.r = i3 / iHighestOneBit;
        int i4 = dVar.g;
        this.q = i4 / iHighestOneBit;
        this.f692i = this.c.a(i3 * i4);
        this.f693j = this.c.d(this.r * this.q);
    }

    public f(a aVar) {
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.f695l = new d();
    }
}
