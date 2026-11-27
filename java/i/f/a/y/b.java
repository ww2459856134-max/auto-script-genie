package i.f.a.y;

import i.f.a.r;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends k {
    static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int h(i.f.a.v.a aVar, int[] iArr, int i2) throws i.f.a.k {
        k.f(aVar, i2, iArr);
        float f = 0.25f;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = a;
            if (i4 >= iArr2.length) {
                break;
            }
            float fE = k.e(iArr, iArr2[i4], 0.7f);
            if (fE < f) {
                i3 = i4;
                f = fE;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw i.f.a.k.a();
    }

    private static int[] i(i.f.a.v.a aVar) throws i.f.a.k {
        int iK = aVar.k();
        int i2 = aVar.i(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i3 = 0;
        int i4 = i2;
        while (i2 < iK) {
            if (aVar.g(i2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    float f = 0.25f;
                    int i5 = -1;
                    for (int i6 = 103; i6 <= 105; i6++) {
                        float fE = k.e(iArr, a[i6], 0.7f);
                        if (fE < f) {
                            i5 = i6;
                            f = fE;
                        }
                    }
                    if (i5 >= 0 && aVar.m(Math.max(0, i4 - ((i2 - i4) / 2)), i4, false)) {
                        return new int[]{i4, i2, i5};
                    }
                    i4 += iArr[0] + iArr[1];
                    int i7 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            i2++;
        }
        throw i.f.a.k.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012a, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012c, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0131 A[PHI: r17
      0x0131: PHI (r17v10 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:67:0x010a, B:43:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013b A[PHI: r17
      0x013b: PHI (r17v8 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:66:0x0108, B:42:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // i.f.a.y.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g {
        char c;
        char c2;
        boolean z;
        boolean z2 = false;
        boolean z3 = map != null && map.containsKey(i.f.a.e.ASSUME_GS1);
        int[] iArrI = i(aVar);
        int i3 = iArrI[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i3));
        switch (i3) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw i.f.a.g.a();
        }
        StringBuilder sb = new StringBuilder(20);
        int i4 = 6;
        int[] iArr = new int[6];
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z7 = true;
        char c3 = c;
        int i8 = iArrI[0];
        int i9 = iArrI[1];
        char c4 = c3;
        while (!z5) {
            int iH = h(aVar, iArr, i9);
            arrayList.add(Byte.valueOf((byte) iH));
            if (iH != 106) {
                z7 = true;
            }
            if (iH != 106) {
                i6++;
                i3 += i6 * iH;
            }
            int i10 = i9;
            for (int i11 = 0; i11 < i4; i11++) {
                i10 += iArr[i11];
            }
            switch (iH) {
                case 103:
                case 104:
                case 105:
                    throw i.f.a.g.a();
                default:
                    switch (c4) {
                        case 'c':
                            c2 = 'd';
                            if (iH >= 100) {
                                if (iH != 106) {
                                    z7 = false;
                                }
                                if (iH != 106) {
                                    switch (iH) {
                                        case 100:
                                            c4 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c4 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z = false;
                                    z5 = true;
                                    break;
                                }
                            } else {
                                if (iH < 10) {
                                    sb.append('0');
                                }
                                sb.append(iH);
                            }
                            z = false;
                            break;
                        case 'd':
                            if (iH < 96) {
                                if (z4 == z2) {
                                    sb.append((char) (iH + 32));
                                } else {
                                    sb.append((char) (iH + 32 + 128));
                                }
                                z = false;
                                z4 = false;
                                c2 = 'd';
                                break;
                            } else {
                                if (iH != 106) {
                                    z7 = false;
                                }
                                if (iH != 106) {
                                    switch (iH) {
                                        case 98:
                                            z = true;
                                            c2 = 'd';
                                            c4 = 'e';
                                            break;
                                        case 99:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'c';
                                            break;
                                        case 100:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                c2 = 'd';
                                                break;
                                            }
                                            z2 = true;
                                            z = false;
                                            z4 = false;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z5 = true;
                                }
                                z = false;
                                c2 = 'd';
                            }
                            break;
                        case 'e':
                            if (iH < 64) {
                                if (z4 == z2) {
                                    sb.append((char) (iH + 32));
                                } else {
                                    sb.append((char) (iH + 32 + 128));
                                }
                            } else if (iH >= 96) {
                                if (iH != 106) {
                                    z7 = false;
                                }
                                if (iH != 106) {
                                    switch (iH) {
                                        case 98:
                                            z = true;
                                            c2 = 'd';
                                            c4 = 'd';
                                            break;
                                        case 100:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'd';
                                            break;
                                        case 101:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                c2 = 'd';
                                                break;
                                            }
                                            z2 = true;
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                z = false;
                                c2 = 'd';
                            } else if (z4 == z2) {
                                sb.append((char) (iH - 64));
                            } else {
                                sb.append((char) (iH + 64));
                            }
                            z = false;
                            z4 = false;
                            c2 = 'd';
                            break;
                        default:
                            c2 = 'd';
                            z = false;
                            break;
                    }
                    if (z6) {
                        c4 = c4 == 'e' ? c2 : 'e';
                    }
                    z6 = z;
                    i4 = 6;
                    i8 = i9;
                    i9 = i10;
                    i7 = i5;
                    i5 = iH;
                    break;
            }
            while (!z5) {
            }
        }
        int i12 = i9 - i8;
        int iJ = aVar.j(i9);
        if (!aVar.m(iJ, Math.min(aVar.k(), ((iJ - i8) / 2) + iJ), false)) {
            throw i.f.a.k.a();
        }
        int i13 = i7;
        if ((i3 - (i6 * i13)) % 103 != i13) {
            throw i.f.a.d.a();
        }
        int length = sb.length();
        if (length == 0) {
            throw i.f.a.k.a();
        }
        if (length > 0 && z7) {
            if (c4 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f = (iArrI[1] + iArrI[0]) / 2.0f;
        float f2 = i8 + (i12 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i14 = 0; i14 < size; i14++) {
            bArr[i14] = ((Byte) arrayList.get(i14)).byteValue();
        }
        float f3 = i2;
        return new i.f.a.p(sb.toString(), bArr, new r[]{new r(f, f3), new r(f2, f3)}, i.f.a.a.CODE_128);
    }
}
