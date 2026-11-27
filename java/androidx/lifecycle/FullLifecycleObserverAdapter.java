package androidx.lifecycle;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements g {
    private final c a;
    private final g b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f.a.values().length];
            a = iArr;
            try {
                iArr[f.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[f.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[f.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[f.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[f.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[f.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[f.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.g
    public void a(i iVar, f.a aVar) {
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.a.f(iVar);
                break;
            case 2:
                this.a.e(iVar);
                break;
            case 3:
                this.a.b(iVar);
                break;
            case 4:
                this.a.c(iVar);
                break;
            case 5:
                this.a.g(iVar);
                break;
            case 6:
                this.a.d(iVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(iVar, aVar);
        }
    }
}
