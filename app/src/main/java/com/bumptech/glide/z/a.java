package com.bumptech.glide.z;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b0.p;
import com.bumptech.glide.load.n;
import com.bumptech.glide.load.q;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.v;
import com.bumptech.glide.load.x.b0;
import com.bumptech.glide.load.z.f.d0;
import com.bumptech.glide.z.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Map;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private boolean D;
    private Drawable H;
    private int I;
    private boolean O;
    private Resources.Theme P;
    private boolean Q;
    private boolean U;
    private boolean V;
    private boolean Z;
    private int c;
    private Drawable g;

    /* renamed from: h, reason: collision with root package name */
    private int f702h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f703i;

    /* renamed from: j, reason: collision with root package name */
    private int f704j;
    private float d = 1.0f;
    private b0 e = b0.d;
    private com.bumptech.glide.h f = com.bumptech.glide.h.NORMAL;

    /* renamed from: k, reason: collision with root package name */
    private boolean f705k = true;
    private int t = -1;
    private int A = -1;
    private n C = com.bumptech.glide.a0.c.c();
    private boolean G = true;
    private r J = new r();
    private Map<Class<?>, v<?>> K = new com.bumptech.glide.b0.d();
    private Class<?> M = Object.class;
    private boolean W = true;

    private boolean E(int i2) {
        return F(this.c, i2);
    }

    private static boolean F(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private T O(com.bumptech.glide.load.z.f.v vVar, v<Bitmap> vVar2) {
        return (T) T(vVar, vVar2, false);
    }

    private T T(com.bumptech.glide.load.z.f.v vVar, v<Bitmap> vVar2, boolean z) {
        T t = z ? (T) c0(vVar, vVar2) : (T) P(vVar, vVar2);
        t.W = true;
        return t;
    }

    private T U() {
        return this;
    }

    private T V() {
        if (this.O) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        U();
        return this;
    }

    public final boolean A() {
        return this.U;
    }

    public final boolean B() {
        return this.f705k;
    }

    public final boolean C() {
        return E(8);
    }

    boolean D() {
        return this.W;
    }

    public final boolean G() {
        return this.G;
    }

    public final boolean H() {
        return this.D;
    }

    public final boolean I() {
        return E(2048);
    }

    public final boolean J() {
        return p.r(this.A, this.t);
    }

    public T K() {
        this.O = true;
        U();
        return this;
    }

    public T L() {
        return (T) P(com.bumptech.glide.load.z.f.v.c, new com.bumptech.glide.load.z.f.i());
    }

    public T M() {
        return (T) O(com.bumptech.glide.load.z.f.v.b, new com.bumptech.glide.load.z.f.j());
    }

    public T N() {
        return (T) O(com.bumptech.glide.load.z.f.v.a, new d0());
    }

    final T P(com.bumptech.glide.load.z.f.v vVar, v<Bitmap> vVar2) {
        if (this.Q) {
            return (T) clone().P(vVar, vVar2);
        }
        g(vVar);
        return (T) b0(vVar2, false);
    }

    public T Q(int i2, int i3) {
        if (this.Q) {
            return (T) clone().Q(i2, i3);
        }
        this.A = i2;
        this.t = i3;
        this.c |= 512;
        V();
        return this;
    }

    public T R(int i2) {
        if (this.Q) {
            return (T) clone().R(i2);
        }
        this.f704j = i2;
        int i3 = this.c | 128;
        this.c = i3;
        this.f703i = null;
        this.c = i3 & (-65);
        V();
        return this;
    }

    public T S(com.bumptech.glide.h hVar) {
        if (this.Q) {
            return (T) clone().S(hVar);
        }
        com.bumptech.glide.b0.n.d(hVar);
        this.f = hVar;
        this.c |= 8;
        V();
        return this;
    }

    public <Y> T W(q<Y> qVar, Y y) {
        if (this.Q) {
            return (T) clone().W(qVar, y);
        }
        com.bumptech.glide.b0.n.d(qVar);
        com.bumptech.glide.b0.n.d(y);
        this.J.e(qVar, y);
        V();
        return this;
    }

    public T X(n nVar) {
        if (this.Q) {
            return (T) clone().X(nVar);
        }
        com.bumptech.glide.b0.n.d(nVar);
        this.C = nVar;
        this.c |= 1024;
        V();
        return this;
    }

    public T Y(float f) {
        if (this.Q) {
            return (T) clone().Y(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.d = f;
        this.c |= 2;
        V();
        return this;
    }

    public T Z(boolean z) {
        if (this.Q) {
            return (T) clone().Z(true);
        }
        this.f705k = !z;
        this.c |= 256;
        V();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.Q) {
            return (T) clone().a(aVar);
        }
        if (F(aVar.c, 2)) {
            this.d = aVar.d;
        }
        if (F(aVar.c, WXMediaMessage.NATIVE_GAME__THUMB_LIMIT)) {
            this.U = aVar.U;
        }
        if (F(aVar.c, 1048576)) {
            this.Z = aVar.Z;
        }
        if (F(aVar.c, 4)) {
            this.e = aVar.e;
        }
        if (F(aVar.c, 8)) {
            this.f = aVar.f;
        }
        if (F(aVar.c, 16)) {
            this.g = aVar.g;
            this.f702h = 0;
            this.c &= -33;
        }
        if (F(aVar.c, 32)) {
            this.f702h = aVar.f702h;
            this.g = null;
            this.c &= -17;
        }
        if (F(aVar.c, 64)) {
            this.f703i = aVar.f703i;
            this.f704j = 0;
            this.c &= -129;
        }
        if (F(aVar.c, 128)) {
            this.f704j = aVar.f704j;
            this.f703i = null;
            this.c &= -65;
        }
        if (F(aVar.c, 256)) {
            this.f705k = aVar.f705k;
        }
        if (F(aVar.c, 512)) {
            this.A = aVar.A;
            this.t = aVar.t;
        }
        if (F(aVar.c, 1024)) {
            this.C = aVar.C;
        }
        if (F(aVar.c, XMLEvent.CHANGE_PREFIX_MAPPING)) {
            this.M = aVar.M;
        }
        if (F(aVar.c, XMLEvent.ENTITY_REFERENCE)) {
            this.H = aVar.H;
            this.I = 0;
            this.c &= -16385;
        }
        if (F(aVar.c, 16384)) {
            this.I = aVar.I;
            this.H = null;
            this.c &= -8193;
        }
        if (F(aVar.c, 32768)) {
            this.P = aVar.P;
        }
        if (F(aVar.c, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            this.G = aVar.G;
        }
        if (F(aVar.c, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            this.D = aVar.D;
        }
        if (F(aVar.c, 2048)) {
            this.K.putAll(aVar.K);
            this.W = aVar.W;
        }
        if (F(aVar.c, 524288)) {
            this.V = aVar.V;
        }
        if (!this.G) {
            this.K.clear();
            int i2 = this.c & (-2049);
            this.c = i2;
            this.D = false;
            this.c = i2 & (-131073);
            this.W = true;
        }
        this.c |= aVar.c;
        this.J.d(aVar.J);
        V();
        return this;
    }

    public T a0(v<Bitmap> vVar) {
        return (T) b0(vVar, true);
    }

    public T b() {
        if (this.O && !this.Q) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.Q = true;
        K();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    T b0(v<Bitmap> vVar, boolean z) {
        if (this.Q) {
            return (T) clone().b0(vVar, z);
        }
        com.bumptech.glide.load.z.f.b0 b0Var = new com.bumptech.glide.load.z.f.b0(vVar, z);
        d0(Bitmap.class, vVar, z);
        d0(Drawable.class, b0Var, z);
        b0Var.c();
        d0(BitmapDrawable.class, b0Var, z);
        d0(com.bumptech.glide.load.z.j.f.class, new com.bumptech.glide.load.z.j.i(vVar), z);
        V();
        return this;
    }

    public T c() {
        return (T) c0(com.bumptech.glide.load.z.f.v.c, new com.bumptech.glide.load.z.f.i());
    }

    final T c0(com.bumptech.glide.load.z.f.v vVar, v<Bitmap> vVar2) {
        if (this.Q) {
            return (T) clone().c0(vVar, vVar2);
        }
        g(vVar);
        return (T) a0(vVar2);
    }

    @Override // 
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t = (T) super.clone();
            r rVar = new r();
            t.J = rVar;
            rVar.d(this.J);
            com.bumptech.glide.b0.d dVar = new com.bumptech.glide.b0.d();
            t.K = dVar;
            dVar.putAll(this.K);
            t.O = false;
            t.Q = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    <Y> T d0(Class<Y> cls, v<Y> vVar, boolean z) {
        if (this.Q) {
            return (T) clone().d0(cls, vVar, z);
        }
        com.bumptech.glide.b0.n.d(cls);
        com.bumptech.glide.b0.n.d(vVar);
        this.K.put(cls, vVar);
        int i2 = this.c | 2048;
        this.c = i2;
        this.G = true;
        int i3 = i2 | WXMediaMessage.THUMB_LENGTH_LIMIT;
        this.c = i3;
        this.W = false;
        if (z) {
            this.c = i3 | WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            this.D = true;
        }
        V();
        return this;
    }

    public T e(Class<?> cls) {
        if (this.Q) {
            return (T) clone().e(cls);
        }
        com.bumptech.glide.b0.n.d(cls);
        this.M = cls;
        this.c |= XMLEvent.CHANGE_PREFIX_MAPPING;
        V();
        return this;
    }

    public T e0(boolean z) {
        if (this.Q) {
            return (T) clone().e0(z);
        }
        this.Z = z;
        this.c |= 1048576;
        V();
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.d, this.d) == 0 && this.f702h == aVar.f702h && p.c(this.g, aVar.g) && this.f704j == aVar.f704j && p.c(this.f703i, aVar.f703i) && this.I == aVar.I && p.c(this.H, aVar.H) && this.f705k == aVar.f705k && this.t == aVar.t && this.A == aVar.A && this.D == aVar.D && this.G == aVar.G && this.U == aVar.U && this.V == aVar.V && this.e.equals(aVar.e) && this.f == aVar.f && this.J.equals(aVar.J) && this.K.equals(aVar.K) && this.M.equals(aVar.M) && p.c(this.C, aVar.C) && p.c(this.P, aVar.P);
    }

    public T f(b0 b0Var) {
        if (this.Q) {
            return (T) clone().f(b0Var);
        }
        com.bumptech.glide.b0.n.d(b0Var);
        this.e = b0Var;
        this.c |= 4;
        V();
        return this;
    }

    public T g(com.bumptech.glide.load.z.f.v vVar) {
        q qVar = com.bumptech.glide.load.z.f.v.f;
        com.bumptech.glide.b0.n.d(vVar);
        return (T) W(qVar, vVar);
    }

    public T h(int i2) {
        if (this.Q) {
            return (T) clone().h(i2);
        }
        this.f702h = i2;
        int i3 = this.c | 32;
        this.c = i3;
        this.g = null;
        this.c = i3 & (-17);
        V();
        return this;
    }

    public int hashCode() {
        return p.m(this.P, p.m(this.C, p.m(this.M, p.m(this.K, p.m(this.J, p.m(this.f, p.m(this.e, p.n(this.V, p.n(this.U, p.n(this.G, p.n(this.D, p.l(this.A, p.l(this.t, p.n(this.f705k, p.m(this.H, p.l(this.I, p.m(this.f703i, p.l(this.f704j, p.m(this.g, p.l(this.f702h, p.j(this.d)))))))))))))))))))));
    }

    public final b0 i() {
        return this.e;
    }

    public final int j() {
        return this.f702h;
    }

    public final Drawable k() {
        return this.g;
    }

    public final Drawable l() {
        return this.H;
    }

    public final int m() {
        return this.I;
    }

    public final boolean n() {
        return this.V;
    }

    public final r o() {
        return this.J;
    }

    public final int p() {
        return this.t;
    }

    public final int q() {
        return this.A;
    }

    public final Drawable r() {
        return this.f703i;
    }

    public final int s() {
        return this.f704j;
    }

    public final com.bumptech.glide.h t() {
        return this.f;
    }

    public final Class<?> u() {
        return this.M;
    }

    public final n v() {
        return this.C;
    }

    public final float w() {
        return this.d;
    }

    public final Resources.Theme x() {
        return this.P;
    }

    public final Map<Class<?>, v<?>> y() {
        return this.K;
    }

    public final boolean z() {
        return this.Z;
    }
}
