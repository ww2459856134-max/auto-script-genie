package i.f.a.y;

import i.f.a.r;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k implements i.f.a.n {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i.f.a.p d(i.f.a.c cVar, Map<i.f.a.e, ?> map) throws i.f.a.k {
        k kVar;
        Map<i.f.a.e, ?> map2;
        int i2;
        int i3;
        Map<i.f.a.e, ?> map3 = map;
        int iD = cVar.d();
        int iC = cVar.c();
        i.f.a.v.a aVar = new i.f.a.v.a(iD);
        int i4 = 0;
        int i5 = 1;
        boolean z = map3 != null && map3.containsKey(i.f.a.e.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z ? 8 : 5));
        int i6 = z ? iC : 15;
        int i7 = iC / 2;
        int i8 = 0;
        while (i8 < i6) {
            int i9 = i8 + 1;
            int i10 = i9 / 2;
            if (((i8 & 1) == 0 ? i5 : i4) == 0) {
                i10 = -i10;
            }
            int i11 = (i10 * iMax) + i7;
            if (i11 < 0 || i11 >= iC) {
                break;
            }
            try {
                aVar = cVar.b(i11, aVar);
                int i12 = i4;
                while (i12 < 2) {
                    if (i12 == i5) {
                        aVar.o();
                        if (map3 != null) {
                            i.f.a.e eVar = i.f.a.e.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(eVar)) {
                                EnumMap enumMap = new EnumMap(i.f.a.e.class);
                                enumMap.putAll(map3);
                                enumMap.remove(eVar);
                                kVar = this;
                                map3 = enumMap;
                            } else {
                                kVar = this;
                            }
                        }
                    }
                    try {
                        i.f.a.p pVarC = kVar.c(i11, aVar, map3);
                        if (i12 == i5) {
                            try {
                                pVarC.h(i.f.a.q.ORIENTATION, 180);
                                r[] rVarArrE = pVarC.e();
                                if (rVarArrE != null) {
                                    map2 = map3;
                                    float f = iD;
                                    try {
                                        i2 = iD;
                                    } catch (i.f.a.o unused) {
                                        i2 = iD;
                                        i3 = 1;
                                        i12++;
                                        i5 = i3;
                                        map3 = map2;
                                        iD = i2;
                                        i4 = 0;
                                    }
                                    try {
                                        rVarArrE[0] = new r((f - rVarArrE[i4].c()) - 1.0f, rVarArrE[i4].d());
                                        i3 = 1;
                                        try {
                                            rVarArrE[1] = new r((f - rVarArrE[1].c()) - 1.0f, rVarArrE[1].d());
                                        } catch (i.f.a.o unused2) {
                                            continue;
                                            i12++;
                                            i5 = i3;
                                            map3 = map2;
                                            iD = i2;
                                            i4 = 0;
                                        }
                                    } catch (i.f.a.o unused3) {
                                        i3 = 1;
                                        i12++;
                                        i5 = i3;
                                        map3 = map2;
                                        iD = i2;
                                        i4 = 0;
                                    }
                                }
                            } catch (i.f.a.o unused4) {
                                map2 = map3;
                            }
                        }
                        return pVarC;
                    } catch (i.f.a.o unused5) {
                        map2 = map3;
                        i2 = iD;
                        i3 = i5;
                    }
                }
            } catch (i.f.a.k unused6) {
            }
            i8 = i9;
            i5 = i5;
            iD = iD;
            i4 = 0;
        }
        throw i.f.a.k.a();
    }

    protected static float e(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i2;
        float f3 = f2 / i3;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f6 = iArr2[i5] * f3;
            float f7 = iArr[i5];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void f(i.f.a.v.a aVar, int i2, int[] iArr) throws i.f.a.k {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iK = aVar.k();
        if (i2 >= iK) {
            throw i.f.a.k.a();
        }
        boolean z = !aVar.g(i2);
        while (i2 < iK) {
            if (aVar.g(i2) == z) {
                i3++;
                if (i3 == length) {
                    break;
                }
                iArr[i3] = 1;
                z = !z;
            } else {
                iArr[i3] = iArr[i3] + 1;
            }
            i2++;
        }
        if (i3 != length) {
            if (i3 != length - 1 || i2 != iK) {
                throw i.f.a.k.a();
            }
        }
    }

    protected static void g(i.f.a.v.a aVar, int i2, int[] iArr) throws i.f.a.k {
        int length = iArr.length;
        boolean zG = aVar.g(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.g(i2) != zG) {
                length--;
                zG = !zG;
            }
        }
        if (length >= 0) {
            throw i.f.a.k.a();
        }
        f(aVar, i2 + 1, iArr);
    }

    @Override // i.f.a.n
    public i.f.a.p a(i.f.a.c cVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.g {
        try {
            return d(cVar, map);
        } catch (i.f.a.k e) {
            if (!(map != null && map.containsKey(i.f.a.e.TRY_HARDER)) || !cVar.e()) {
                throw e;
            }
            i.f.a.c cVarF = cVar.f();
            i.f.a.p pVarD = d(cVarF, map);
            Map<i.f.a.q, Object> mapD = pVarD.d();
            int iIntValue = 270;
            if (mapD != null) {
                i.f.a.q qVar = i.f.a.q.ORIENTATION;
                if (mapD.containsKey(qVar)) {
                    iIntValue = (((Integer) mapD.get(qVar)).intValue() + 270) % 360;
                }
            }
            pVarD.h(i.f.a.q.ORIENTATION, Integer.valueOf(iIntValue));
            r[] rVarArrE = pVarD.e();
            if (rVarArrE != null) {
                int iC = cVarF.c();
                for (int i2 = 0; i2 < rVarArrE.length; i2++) {
                    rVarArrE[i2] = new r((iC - rVarArrE[i2].d()) - 1.0f, rVarArrE[i2].c());
                }
            }
            return pVarD;
        }
    }

    @Override // i.f.a.n
    public void b() {
    }

    public abstract i.f.a.p c(int i2, i.f.a.v.a aVar, Map<i.f.a.e, ?> map) throws i.f.a.k, i.f.a.d, i.f.a.g;
}
