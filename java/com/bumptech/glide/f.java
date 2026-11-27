package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.x.i0;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class f extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    static final t<?, ?> f589k = new a();
    private final com.bumptech.glide.load.x.g1.b a;
    private final o b;
    private final com.bumptech.glide.z.l.f c;
    private final b d;
    private final List<com.bumptech.glide.z.f<Object>> e;
    private final Map<Class<?>, t<?, ?>> f;
    private final i0 g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f590h;

    /* renamed from: i, reason: collision with root package name */
    private final int f591i;

    /* renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.z.g f592j;

    public f(Context context, com.bumptech.glide.load.x.g1.b bVar, o oVar, com.bumptech.glide.z.l.f fVar, b bVar2, Map<Class<?>, t<?, ?>> map, List<com.bumptech.glide.z.f<Object>> list, i0 i0Var, boolean z, int i2) {
        super(context.getApplicationContext());
        this.a = bVar;
        this.b = oVar;
        this.c = fVar;
        this.d = bVar2;
        this.e = list;
        this.f = map;
        this.g = i0Var;
        this.f590h = z;
        this.f591i = i2;
    }

    public <X> com.bumptech.glide.z.l.k<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    public com.bumptech.glide.load.x.g1.b b() {
        return this.a;
    }

    public List<com.bumptech.glide.z.f<Object>> c() {
        return this.e;
    }

    public synchronized com.bumptech.glide.z.g d() {
        if (this.f592j == null) {
            com.bumptech.glide.z.g gVarA = this.d.a();
            gVarA.K();
            this.f592j = gVarA;
        }
        return this.f592j;
    }

    public <T> t<?, T> e(Class<T> cls) {
        t<?, T> tVar = (t) this.f.get(cls);
        if (tVar == null) {
            for (Map.Entry<Class<?>, t<?, ?>> entry : this.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    tVar = (t) entry.getValue();
                }
            }
        }
        return tVar == null ? (t<?, T>) f589k : tVar;
    }

    public i0 f() {
        return this.g;
    }

    public int g() {
        return this.f591i;
    }

    public o h() {
        return this.b;
    }

    public boolean i() {
        return this.f590h;
    }
}
