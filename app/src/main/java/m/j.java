package m;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
abstract class j {

    @Nullable
    static i a;
    static long b;

    static void a(i iVar) {
        if (iVar.f != null || iVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (iVar.d) {
            return;
        }
        synchronized (j.class) {
            long j2 = b;
            if (j2 + 8192 > 65536) {
                return;
            }
            b = j2 + 8192;
            iVar.f = a;
            iVar.c = 0;
            iVar.b = 0;
            a = iVar;
        }
    }

    static i b() {
        synchronized (j.class) {
            i iVar = a;
            if (iVar == null) {
                return new i();
            }
            a = iVar.f;
            iVar.f = null;
            b -= 8192;
            return iVar;
        }
    }
}
