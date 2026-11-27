package i.f.a.v;

/* loaded from: classes.dex */
public abstract class i {
    private static i a = new f();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void a(b bVar, float[] fArr) throws i.f.a.k {
        int iJ = bVar.j();
        int iG = bVar.g();
        int length = fArr.length - 1;
        boolean z = true;
        for (int i2 = 0; i2 < length && z; i2 += 2) {
            int i3 = (int) fArr[i2];
            int i4 = i2 + 1;
            int i5 = (int) fArr[i4];
            if (i3 < -1 || i3 > iJ || i5 < -1 || i5 > iG) {
                throw i.f.a.k.a();
            }
            if (i3 == -1) {
                fArr[i2] = 0.0f;
            } else if (i3 == iJ) {
                fArr[i2] = iJ - 1;
            } else {
                z = false;
                if (i5 != -1) {
                    fArr[i4] = 0.0f;
                } else if (i5 == iG) {
                    fArr[i4] = iG - 1;
                }
                z = true;
            }
            z = true;
            if (i5 != -1) {
            }
            z = true;
        }
        boolean z2 = true;
        for (int length2 = fArr.length - 2; length2 >= 0 && z2; length2 -= 2) {
            int i6 = (int) fArr[length2];
            int i7 = length2 + 1;
            int i8 = (int) fArr[i7];
            if (i6 < -1 || i6 > iJ || i8 < -1 || i8 > iG) {
                throw i.f.a.k.a();
            }
            if (i6 == -1) {
                fArr[length2] = 0.0f;
            } else if (i6 == iJ) {
                fArr[length2] = iJ - 1;
            } else {
                z2 = false;
                if (i8 != -1) {
                    fArr[i7] = 0.0f;
                } else if (i8 == iG) {
                    fArr[i7] = iG - 1;
                }
                z2 = true;
            }
            z2 = true;
            if (i8 != -1) {
            }
            z2 = true;
        }
    }

    public static i b() {
        return a;
    }

    public abstract b c(b bVar, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws i.f.a.k;

    public abstract b d(b bVar, int i2, int i3, k kVar) throws i.f.a.k;
}
