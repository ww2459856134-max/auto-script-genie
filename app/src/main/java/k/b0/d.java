package k.b0;

import k.x.b0;

/* loaded from: classes.dex */
class d implements b0 {
    private int a;

    public d(int i2, String str) {
        this.a = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof d) && this.a == ((d) obj).a;
    }

    @Override // k.x.b0
    public void f(int i2) {
    }

    public int hashCode() {
        return this.a;
    }

    @Override // k.x.b0
    public boolean isInitialized() {
        return true;
    }

    @Override // k.x.b0
    public int m() {
        return this.a;
    }

    @Override // k.x.b0
    public boolean r() {
        return true;
    }
}
