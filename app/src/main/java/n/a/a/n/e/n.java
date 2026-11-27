package n.a.a.n.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
class n implements Iterator<l> {
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private int f2489h;

    public n(o oVar) {
        int iB = oVar.b();
        this.c = iB;
        this.g = iB;
        int iA = oVar.a();
        this.d = iA;
        this.f2489h = iA;
        int iK = oVar.k();
        this.e = iK;
        int iG = oVar.g();
        this.f = iG;
        if (iB < 0) {
            throw new IllegalStateException("First row cannot be negative.");
        }
        if (iA < 0) {
            throw new IllegalStateException("First column cannot be negative.");
        }
        if (iB > iK) {
            throw new IllegalStateException("First row cannot be greater than last row.");
        }
        if (iA > iG) {
            throw new IllegalStateException("First column cannot be greater than last column.");
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.g;
        int i3 = this.f2489h;
        l lVar = new l(i2, i3);
        if (i3 < this.f) {
            this.f2489h = i3 + 1;
        } else {
            this.f2489h = this.d;
            this.g = i2 + 1;
        }
        return lVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.g <= this.e && this.f2489h <= this.f;
    }
}
