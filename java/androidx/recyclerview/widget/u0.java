package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* loaded from: classes.dex */
class u0 {
    final t0 a;

    u0(t0 t0Var) {
        this.a = t0Var;
    }

    private int a(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        int i4 = bVar.d;
        int i5 = bVar2.b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = bVar.b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            bVar.b = i7 + bVar2.d;
        }
        int i8 = bVar2.b;
        if (i8 <= i4) {
            bVar.d = i4 + bVar2.d;
        }
        bVar2.b = i8 + i6;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    private void d(List<a.b> list, int i2, int i3) {
        a.b bVar = list.get(i2);
        a.b bVar2 = list.get(i3);
        int i4 = bVar2.a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            e(list, i2, bVar, i3, bVar2);
        } else {
            if (i4 != 4) {
                return;
            }
            f(list, i2, bVar, i3, bVar2);
        }
    }

    void b(List<a.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        boolean z;
        int i4 = bVar.b;
        int i5 = bVar.d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.b == i4 && bVar2.d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.b == i5 + 1 && bVar2.d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar2.b;
        if (i5 < i6) {
            bVar2.b = i6 - 1;
        } else {
            int i7 = bVar2.d;
            if (i5 < i6 + i7) {
                bVar2.d = i7 - 1;
                bVar.a = 2;
                bVar.d = 1;
                if (bVar2.d == 0) {
                    list.remove(i3);
                    this.a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i8 = bVar.b;
        int i9 = bVar2.b;
        a.b bVarA = null;
        if (i8 <= i9) {
            bVar2.b = i9 + 1;
        } else {
            int i10 = bVar2.d;
            if (i8 < i9 + i10) {
                bVarA = this.a.a(2, i8 + 1, (i9 + i10) - i8, null);
                bVar2.d = bVar.b - bVar2.b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.a.b(bVar);
            return;
        }
        if (z) {
            if (bVarA != null) {
                int i11 = bVar.b;
                if (i11 > bVarA.b) {
                    bVar.b = i11 - bVarA.d;
                }
                int i12 = bVar.d;
                if (i12 > bVarA.b) {
                    bVar.d = i12 - bVarA.d;
                }
            }
            int i13 = bVar.b;
            if (i13 > bVar2.b) {
                bVar.b = i13 - bVar2.d;
            }
            int i14 = bVar.d;
            if (i14 > bVar2.b) {
                bVar.d = i14 - bVar2.d;
            }
        } else {
            if (bVarA != null) {
                int i15 = bVar.b;
                if (i15 >= bVarA.b) {
                    bVar.b = i15 - bVarA.d;
                }
                int i16 = bVar.d;
                if (i16 >= bVarA.b) {
                    bVar.d = i16 - bVarA.d;
                }
            }
            int i17 = bVar.b;
            if (i17 >= bVar2.b) {
                bVar.b = i17 - bVar2.d;
            }
            int i18 = bVar.d;
            if (i18 >= bVar2.b) {
                bVar.d = i18 - bVar2.d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.b != bVar.d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVarA != null) {
            list.add(i2, bVarA);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void f(List<a.b> list, int i2, a.b bVar, int i3, a.b bVar2) {
        a.b bVarA;
        int i4;
        int i5;
        int i6 = bVar.d;
        int i7 = bVar2.b;
        a.b bVarA2 = null;
        if (i6 >= i7) {
            int i8 = bVar2.d;
            if (i6 < i7 + i8) {
                bVar2.d = i8 - 1;
                bVarA = this.a.a(4, bVar.b, 1, bVar2.c);
            }
            i4 = bVar.b;
            i5 = bVar2.b;
            if (i4 > i5) {
                bVar2.b = i5 + 1;
            } else {
                int i9 = bVar2.d;
                if (i4 < i5 + i9) {
                    int i10 = (i5 + i9) - i4;
                    bVarA2 = this.a.a(4, i4 + 1, i10, bVar2.c);
                    bVar2.d -= i10;
                }
            }
            list.set(i3, bVar);
            if (bVar2.d <= 0) {
                list.set(i2, bVar2);
            } else {
                list.remove(i2);
                this.a.b(bVar2);
            }
            if (bVarA != null) {
                list.add(i2, bVarA);
            }
            if (bVarA2 == null) {
                list.add(i2, bVarA2);
                return;
            }
            return;
        }
        bVar2.b = i7 - 1;
        bVarA = null;
        i4 = bVar.b;
        i5 = bVar2.b;
        if (i4 > i5) {
        }
        list.set(i3, bVar);
        if (bVar2.d <= 0) {
        }
        if (bVarA != null) {
        }
        if (bVarA2 == null) {
        }
    }
}
