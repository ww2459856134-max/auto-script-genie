package i.b.ha.a.c.j;

import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public class k extends i.b.ha.a.c.g.f<l, k> {

    /* renamed from: i, reason: collision with root package name */
    private int f1481i;

    /* renamed from: j, reason: collision with root package name */
    private int f1482j;

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] u() throws IOException {
        return d().d();
    }

    @Override // i.b.ha.a.c.i.p
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public l get() throws IOException {
        return new l(this);
    }

    public k w(byte[] bArr) {
        Objects.requireNonNull(bArr, "origin");
        this.f1482j = bArr.length;
        return (k) super.g(bArr);
    }

    public k x(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("length cannot be negative");
        }
        this.f1482j = i2;
        return this;
    }

    public k y(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        }
        this.f1481i = i2;
        return this;
    }
}
