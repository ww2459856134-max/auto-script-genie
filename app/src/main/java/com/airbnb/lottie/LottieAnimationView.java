package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String P = LottieAnimationView.class.getSimpleName();
    private static final g0<Throwable> Q = new a();
    private boolean A;
    private boolean C;
    private boolean D;
    private boolean G;
    private boolean H;
    private q0 I;
    private Set<i0> J;
    private int K;
    private m0<com.airbnb.lottie.e> M;
    private com.airbnb.lottie.e O;
    private final g0<com.airbnb.lottie.e> e;
    private final g0<Throwable> f;
    private g0<Throwable> g;

    /* renamed from: h, reason: collision with root package name */
    private int f420h;

    /* renamed from: i, reason: collision with root package name */
    private final e0 f421i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f422j;

    /* renamed from: k, reason: collision with root package name */
    private String f423k;
    private int t;

    class a implements g0<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.g0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            if (!com.airbnb.lottie.y0.h.k(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            com.airbnb.lottie.y0.d.d("Unable to load composition.", th);
        }
    }

    class b implements g0<com.airbnb.lottie.e> {
        b() {
        }

        @Override // com.airbnb.lottie.g0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.airbnb.lottie.e eVar) {
            LottieAnimationView.this.setComposition(eVar);
        }
    }

    class c implements g0<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.g0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            if (LottieAnimationView.this.f420h != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f420h);
            }
            (LottieAnimationView.this.g == null ? LottieAnimationView.Q : LottieAnimationView.this.g).a(th);
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[q0.values().length];
            a = iArr;
            try {
                iArr[q0.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[q0.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[q0.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new com.airbnb.lottie.d();
        String c;
        int d;
        float e;
        boolean f;
        String g;

        /* renamed from: h, reason: collision with root package name */
        int f424h;

        /* renamed from: i, reason: collision with root package name */
        int f425i;

        /* synthetic */ e(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.c);
            parcel.writeFloat(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeString(this.g);
            parcel.writeInt(this.f424h);
            parcel.writeInt(this.f425i);
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        private e(Parcel parcel) {
            super(parcel);
            this.c = parcel.readString();
            this.e = parcel.readFloat();
            this.f = parcel.readInt() == 1;
            this.g = parcel.readString();
            this.f424h = parcel.readInt();
            this.f425i = parcel.readInt();
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.e = new b();
        this.f = new c();
        this.f420h = 0;
        this.f421i = new e0();
        this.A = false;
        this.C = false;
        this.D = false;
        this.G = false;
        this.H = true;
        this.I = q0.AUTOMATIC;
        this.J = new HashSet();
        this.K = 0;
        l(null);
    }

    private void h() {
        m0<com.airbnb.lottie.e> m0Var = this.M;
        if (m0Var != null) {
            m0Var.k(this.e);
            this.M.j(this.f);
        }
    }

    private void i() {
        this.O = null;
        this.f421i.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        com.airbnb.lottie.e eVar;
        int i2 = d.a[this.I.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 == 2 || i2 != 3) {
                i3 = 1;
            } else {
                com.airbnb.lottie.e eVar2 = this.O;
                boolean z = false;
                if ((eVar2 == null || !eVar2.p() || Build.VERSION.SDK_INT >= 28) && (((eVar = this.O) == null || eVar.l() <= 4) && Build.VERSION.SDK_INT >= 21)) {
                    z = true;
                }
                if (!z) {
                }
            }
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    private void l(AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p0.a);
        if (!isInEditMode()) {
            this.H = typedArrayObtainStyledAttributes.getBoolean(p0.c, true);
            int i2 = p0.f449k;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = p0.g;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i3);
            int i4 = p0.q;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i4);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(p0.f, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(p0.b, false)) {
            this.D = true;
            this.G = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(p0.f447i, false)) {
            this.f421i.c0(-1);
        }
        int i5 = p0.f452n;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = p0.f451m;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = p0.p;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(p0.f446h));
        setProgress(typedArrayObtainStyledAttributes.getFloat(p0.f448j, 0.0f));
        j(typedArrayObtainStyledAttributes.getBoolean(p0.e, false));
        int i8 = p0.d;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            f(new com.airbnb.lottie.v0.f("**"), j0.C, new com.airbnb.lottie.z0.c(new r0(typedArrayObtainStyledAttributes.getColor(i8, 0))));
        }
        int i9 = p0.f453o;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.f421i.f0(typedArrayObtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = p0.f450l;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            q0 q0Var = q0.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i10, q0Var.ordinal());
            if (iOrdinal >= q0.values().length) {
                iOrdinal = q0Var.ordinal();
            }
            setRenderMode(q0.values()[iOrdinal]);
        }
        if (getScaleType() != null) {
            this.f421i.g0(getScaleType());
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f421i.i0(Boolean.valueOf(com.airbnb.lottie.y0.h.f(getContext()) != 0.0f));
        k();
        this.f422j = true;
    }

    private void setCompositionTask(m0<com.airbnb.lottie.e> m0Var) {
        i();
        h();
        m0Var.f(this.e);
        m0Var.e(this.f);
        this.M = m0Var;
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.c.a("buildDrawingCache");
        this.K++;
        super.buildDrawingCache(z);
        if (this.K == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(q0.HARDWARE);
        }
        this.K--;
        com.airbnb.lottie.c.b("buildDrawingCache");
    }

    public <T> void f(com.airbnb.lottie.v0.f fVar, T t, com.airbnb.lottie.z0.c<T> cVar) {
        this.f421i.c(fVar, t, cVar);
    }

    public void g() {
        this.D = false;
        this.C = false;
        this.A = false;
        this.f421i.e();
        k();
    }

    public com.airbnb.lottie.e getComposition() {
        return this.O;
    }

    public long getDuration() {
        com.airbnb.lottie.e eVar = this.O;
        if (eVar != null) {
            return (long) eVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f421i.p();
    }

    public String getImageAssetsFolder() {
        return this.f421i.s();
    }

    public float getMaxFrame() {
        return this.f421i.t();
    }

    public float getMinFrame() {
        return this.f421i.v();
    }

    public o0 getPerformanceTracker() {
        return this.f421i.w();
    }

    public float getProgress() {
        return this.f421i.x();
    }

    public int getRepeatCount() {
        return this.f421i.y();
    }

    public int getRepeatMode() {
        return this.f421i.z();
    }

    public float getScale() {
        return this.f421i.A();
    }

    public float getSpeed() {
        return this.f421i.B();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        e0 e0Var = this.f421i;
        if (drawable2 == e0Var) {
            super.invalidateDrawable(e0Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j(boolean z) {
        this.f421i.j(z);
    }

    public boolean m() {
        return this.f421i.E();
    }

    public void n() {
        this.G = false;
        this.D = false;
        this.C = false;
        this.A = false;
        this.f421i.G();
        k();
    }

    public void o() {
        if (!isShown()) {
            this.A = true;
        } else {
            this.f421i.H();
            k();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G || this.D) {
            o();
            this.G = false;
            this.D = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m()) {
            g();
            this.D = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        String str = eVar.c;
        this.f423k = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f423k);
        }
        int i2 = eVar.d;
        this.t = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(eVar.e);
        if (eVar.f) {
            o();
        }
        this.f421i.P(eVar.g);
        setRepeatMode(eVar.f424h);
        setRepeatCount(eVar.f425i);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.c = this.f423k;
        eVar.d = this.t;
        eVar.e = this.f421i.x();
        eVar.f = this.f421i.E() || (!h.e.j.s0.J(this) && this.D);
        eVar.g = this.f421i.s();
        eVar.f424h = this.f421i.z();
        eVar.f425i = this.f421i.y();
        return eVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        if (this.f422j) {
            if (!isShown()) {
                if (m()) {
                    n();
                    this.C = true;
                    return;
                }
                return;
            }
            if (this.C) {
                p();
            } else if (this.A) {
                o();
            }
            this.C = false;
            this.A = false;
        }
    }

    public void p() {
        if (isShown()) {
            this.f421i.J();
            k();
        } else {
            this.A = false;
            this.C = true;
        }
    }

    public void setAnimation(int i2) {
        this.t = i2;
        this.f423k = null;
        setCompositionTask(this.H ? m.l(getContext(), i2) : m.m(getContext(), i2, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.H ? m.p(getContext(), str) : m.q(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f421i.K(z);
    }

    public void setCacheComposition(boolean z) {
        this.H = z;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        if (com.airbnb.lottie.c.a) {
            Log.v(P, "Set Composition \n" + eVar);
        }
        this.f421i.setCallback(this);
        this.O = eVar;
        boolean zL = this.f421i.L(eVar);
        k();
        if (getDrawable() != this.f421i || zL) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<i0> it = this.J.iterator();
            while (it.hasNext()) {
                it.next().a(eVar);
            }
        }
    }

    public void setFailureListener(g0<Throwable> g0Var) {
        this.g = g0Var;
    }

    public void setFallbackResource(int i2) {
        this.f420h = i2;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f421i.M(aVar);
    }

    public void setFrame(int i2) {
        this.f421i.N(i2);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f421i.O(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f421i.P(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        h();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        h();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f421i.Q(i2);
    }

    public void setMaxProgress(float f) {
        this.f421i.S(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.f421i.U(str);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.f421i.W(f, f2);
    }

    public void setMinFrame(int i2) {
        this.f421i.X(i2);
    }

    public void setMinProgress(float f) {
        this.f421i.Z(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f421i.a0(z);
    }

    public void setProgress(float f) {
        this.f421i.b0(f);
    }

    public void setRenderMode(q0 q0Var) {
        this.I = q0Var;
        k();
    }

    public void setRepeatCount(int i2) {
        this.f421i.c0(i2);
    }

    public void setRepeatMode(int i2) {
        this.f421i.d0(i2);
    }

    public void setSafeMode(boolean z) {
        this.f421i.e0(z);
    }

    public void setScale(float f) {
        this.f421i.f0(f);
        if (getDrawable() == this.f421i) {
            setImageDrawable(null);
            setImageDrawable(this.f421i);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        e0 e0Var = this.f421i;
        if (e0Var != null) {
            e0Var.g0(scaleType);
        }
    }

    public void setSpeed(float f) {
        this.f421i.h0(f);
    }

    public void setTextDelegate(s0 s0Var) {
        this.f421i.j0(s0Var);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f421i.R(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.f421i.V(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.f421i.Y(str);
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        this.f421i.T(i2, i3);
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(m.q(getContext(), str, str2));
    }

    public void setAnimation(String str) {
        this.f423k = str;
        this.t = 0;
        setCompositionTask(this.H ? m.d(getContext(), str) : m.e(getContext(), str, null));
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(m.g(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new b();
        this.f = new c();
        this.f420h = 0;
        this.f421i = new e0();
        this.A = false;
        this.C = false;
        this.D = false;
        this.G = false;
        this.H = true;
        this.I = q0.AUTOMATIC;
        this.J = new HashSet();
        this.K = 0;
        l(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = new b();
        this.f = new c();
        this.f420h = 0;
        this.f421i = new e0();
        this.A = false;
        this.C = false;
        this.D = false;
        this.G = false;
        this.H = true;
        this.I = q0.AUTOMATIC;
        this.J = new HashSet();
        this.K = 0;
        l(attributeSet);
    }
}
