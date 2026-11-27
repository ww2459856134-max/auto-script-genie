package com.bumptech.glide.load.x.g1;

/* loaded from: classes.dex */
final class m implements t {
    private final n a;
    int b;
    private Class<?> c;

    m(n nVar) {
        this.a = nVar;
    }

    @Override // com.bumptech.glide.load.x.g1.t
    public void a() {
        this.a.c(this);
    }

    void b(int i2, Class<?> cls) {
        this.b = i2;
        this.c = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.b == mVar.b && this.c == mVar.c;
    }

    public int hashCode() {
        int i2 = this.b * 31;
        Class<?> cls = this.c;
        return i2 + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
