package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.x.b0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.bumptech.glide.q<TranscodeType>>] */
/* loaded from: classes.dex */
public class q<TranscodeType> extends com.bumptech.glide.z.a<q<TranscodeType>> implements Cloneable {
    private final Context a0;
    private final s b0;
    private final Class<TranscodeType> c0;
    private final f d0;
    private t<?, ? super TranscodeType> e0;
    private Object f0;
    private List<com.bumptech.glide.z.f<TranscodeType>> g0;
    private q<TranscodeType> h0;
    private q<TranscodeType> i0;
    private Float j0;
    private boolean k0 = true;
    private boolean l0;
    private boolean m0;

    static {
        new com.bumptech.glide.z.g().f(b0.c).S(h.LOW).Z(true);
    }

    @SuppressLint({"CheckResult"})
    protected q(c cVar, s sVar, Class<TranscodeType> cls, Context context) {
        this.b0 = sVar;
        this.c0 = cls;
        this.a0 = context;
        this.e0 = sVar.r(cls);
        this.d0 = cVar.i();
        m0(sVar.p());
        a(sVar.q());
    }

    private com.bumptech.glide.z.c h0(com.bumptech.glide.z.l.h<TranscodeType> hVar, com.bumptech.glide.z.f<TranscodeType> fVar, com.bumptech.glide.z.a<?> aVar, Executor executor) {
        return i0(new Object(), hVar, fVar, null, this.e0, aVar.t(), aVar.q(), aVar.p(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.z.c i0(Object obj, com.bumptech.glide.z.l.h<TranscodeType> hVar, com.bumptech.glide.z.f<TranscodeType> fVar, com.bumptech.glide.z.e eVar, t<?, ? super TranscodeType> tVar, h hVar2, int i2, int i3, com.bumptech.glide.z.a<?> aVar, Executor executor) {
        com.bumptech.glide.z.e eVar2;
        com.bumptech.glide.z.e bVar;
        if (this.i0 != null) {
            bVar = new com.bumptech.glide.z.b(obj, eVar);
            eVar2 = bVar;
        } else {
            eVar2 = null;
            bVar = eVar;
        }
        com.bumptech.glide.z.c cVarJ0 = j0(obj, hVar, fVar, bVar, tVar, hVar2, i2, i3, aVar, executor);
        if (eVar2 == null) {
            return cVarJ0;
        }
        int iQ = this.i0.q();
        int iP = this.i0.p();
        if (com.bumptech.glide.b0.p.r(i2, i3) && !this.i0.J()) {
            iQ = aVar.q();
            iP = aVar.p();
        }
        q<TranscodeType> qVar = this.i0;
        com.bumptech.glide.z.b bVar2 = eVar2;
        bVar2.q(cVarJ0, qVar.i0(obj, hVar, fVar, bVar2, qVar.e0, qVar.t(), iQ, iP, this.i0, executor));
        return bVar2;
    }

    private com.bumptech.glide.z.c j0(Object obj, com.bumptech.glide.z.l.h<TranscodeType> hVar, com.bumptech.glide.z.f<TranscodeType> fVar, com.bumptech.glide.z.e eVar, t<?, ? super TranscodeType> tVar, h hVar2, int i2, int i3, com.bumptech.glide.z.a<?> aVar, Executor executor) {
        q<TranscodeType> qVar = this.h0;
        if (qVar == null) {
            if (this.j0 == null) {
                return z0(obj, hVar, fVar, aVar, eVar, tVar, hVar2, i2, i3, executor);
            }
            com.bumptech.glide.z.k kVar = new com.bumptech.glide.z.k(obj, eVar);
            kVar.p(z0(obj, hVar, fVar, aVar, kVar, tVar, hVar2, i2, i3, executor), z0(obj, hVar, fVar, aVar.clone().Y(this.j0.floatValue()), kVar, tVar, l0(hVar2), i2, i3, executor));
            return kVar;
        }
        if (this.m0) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        t<?, ? super TranscodeType> tVar2 = qVar.k0 ? tVar : qVar.e0;
        h hVarT = qVar.C() ? this.h0.t() : l0(hVar2);
        int iQ = this.h0.q();
        int iP = this.h0.p();
        if (com.bumptech.glide.b0.p.r(i2, i3) && !this.h0.J()) {
            iQ = aVar.q();
            iP = aVar.p();
        }
        com.bumptech.glide.z.k kVar2 = new com.bumptech.glide.z.k(obj, eVar);
        com.bumptech.glide.z.c cVarZ0 = z0(obj, hVar, fVar, aVar, kVar2, tVar, hVar2, i2, i3, executor);
        this.m0 = true;
        q<TranscodeType> qVar2 = this.h0;
        com.bumptech.glide.z.c cVarI0 = qVar2.i0(obj, hVar, fVar, kVar2, tVar2, hVarT, iQ, iP, qVar2, executor);
        this.m0 = false;
        kVar2.p(cVarZ0, cVarI0);
        return kVar2;
    }

    private h l0(h hVar) {
        int i2 = p.b[hVar.ordinal()];
        if (i2 == 1) {
            return h.NORMAL;
        }
        if (i2 == 2) {
            return h.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return h.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + t());
    }

    @SuppressLint({"CheckResult"})
    private void m0(List<com.bumptech.glide.z.f<Object>> list) {
        Iterator<com.bumptech.glide.z.f<Object>> it = list.iterator();
        while (it.hasNext()) {
            f0((com.bumptech.glide.z.f) it.next());
        }
    }

    private <Y extends com.bumptech.glide.z.l.h<TranscodeType>> Y o0(Y y, com.bumptech.glide.z.f<TranscodeType> fVar, com.bumptech.glide.z.a<?> aVar, Executor executor) {
        com.bumptech.glide.b0.n.d(y);
        if (!this.l0) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.z.c cVarH0 = h0(y, fVar, aVar, executor);
        com.bumptech.glide.z.c cVarE = y.e();
        if (!cVarH0.h(cVarE) || r0(aVar, cVarE)) {
            this.b0.o(y);
            y.i(cVarH0);
            this.b0.C(y, cVarH0);
            return y;
        }
        com.bumptech.glide.b0.n.d(cVarE);
        if (!cVarE.isRunning()) {
            cVarE.k();
        }
        return y;
    }

    private boolean r0(com.bumptech.glide.z.a<?> aVar, com.bumptech.glide.z.c cVar) {
        return !aVar.B() && cVar.g();
    }

    private q<TranscodeType> y0(Object obj) {
        this.f0 = obj;
        this.l0 = true;
        return this;
    }

    private com.bumptech.glide.z.c z0(Object obj, com.bumptech.glide.z.l.h<TranscodeType> hVar, com.bumptech.glide.z.f<TranscodeType> fVar, com.bumptech.glide.z.a<?> aVar, com.bumptech.glide.z.e eVar, t<?, ? super TranscodeType> tVar, h hVar2, int i2, int i3, Executor executor) {
        Context context = this.a0;
        f fVar2 = this.d0;
        return com.bumptech.glide.z.j.x(context, fVar2, obj, this.f0, this.c0, aVar, i2, i3, hVar2, hVar, fVar, this.g0, eVar, fVar2.f(), tVar.b(), executor);
    }

    public q<TranscodeType> f0(com.bumptech.glide.z.f<TranscodeType> fVar) {
        if (fVar != null) {
            if (this.g0 == null) {
                this.g0 = new ArrayList();
            }
            this.g0.add(fVar);
        }
        return this;
    }

    @Override // com.bumptech.glide.z.a
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public q<TranscodeType> a(com.bumptech.glide.z.a<?> aVar) {
        com.bumptech.glide.b0.n.d(aVar);
        return (q) super.a(aVar);
    }

    @Override // com.bumptech.glide.z.a
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public q<TranscodeType> clone() {
        q<TranscodeType> qVar = (q) super.clone();
        qVar.e0 = qVar.e0.clone();
        return qVar;
    }

    public <Y extends com.bumptech.glide.z.l.h<TranscodeType>> Y n0(Y y) {
        p0(y, null, com.bumptech.glide.b0.i.b());
        return y;
    }

    <Y extends com.bumptech.glide.z.l.h<TranscodeType>> Y p0(Y y, com.bumptech.glide.z.f<TranscodeType> fVar, Executor executor) {
        o0(y, fVar, this, executor);
        return y;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bumptech.glide.z.l.k<ImageView, TranscodeType> q0(ImageView imageView) {
        q<TranscodeType> qVarL;
        com.bumptech.glide.b0.p.a();
        com.bumptech.glide.b0.n.d(imageView);
        if (!I() && G() && imageView.getScaleType() != null) {
            switch (p.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    qVarL = clone().L();
                    break;
                case 2:
                    qVarL = clone().M();
                    break;
                case 3:
                case 4:
                case 5:
                    qVarL = clone().N();
                    break;
                case 6:
                    qVarL = clone().M();
                    break;
            }
        } else {
            qVarL = this;
        }
        com.bumptech.glide.z.l.k<ImageView, TranscodeType> kVarA = this.d0.a(imageView, this.c0);
        o0(kVarA, null, qVarL, com.bumptech.glide.b0.i.b());
        return kVarA;
    }

    public q<TranscodeType> s0(Drawable drawable) {
        y0(drawable);
        return a(com.bumptech.glide.z.g.g0(b0.b));
    }

    public q<TranscodeType> t0(Uri uri) {
        y0(uri);
        return this;
    }

    public q<TranscodeType> u0(File file) {
        y0(file);
        return this;
    }

    public q<TranscodeType> v0(Integer num) {
        y0(num);
        return a(com.bumptech.glide.z.g.h0(com.bumptech.glide.a0.a.c(this.a0)));
    }

    public q<TranscodeType> w0(Object obj) {
        y0(obj);
        return this;
    }

    public q<TranscodeType> x0(String str) {
        y0(str);
        return this;
    }
}
