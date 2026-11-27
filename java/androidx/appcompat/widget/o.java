package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* loaded from: classes.dex */
class o implements h1 {
    private final int[] a = {h.a.e.R, h.a.e.P, h.a.e.a};
    private final int[] b = {h.a.e.f1200o, h.a.e.B, h.a.e.t, h.a.e.p, h.a.e.q, h.a.e.s, h.a.e.r};
    private final int[] c = {h.a.e.O, h.a.e.Q, h.a.e.f1196k, h.a.e.K, h.a.e.L, h.a.e.M, h.a.e.N};
    private final int[] d = {h.a.e.w, h.a.e.f1194i, h.a.e.v};
    private final int[] e = {h.a.e.J, h.a.e.S};
    private final int[] f = {h.a.e.c, h.a.e.g, h.a.e.d, h.a.e.f1193h};

    o() {
    }

    private boolean f(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList g(Context context) {
        return h(context, 0);
    }

    private ColorStateList h(Context context, int i2) {
        int iC = p1.c(context, h.a.a.w);
        return new ColorStateList(new int[][]{p1.b, p1.d, p1.c, p1.f}, new int[]{p1.b(context, h.a.a.u), h.e.d.a.b(iC, i2), h.e.d.a.b(iC, i2), i2});
    }

    private ColorStateList i(Context context) {
        return h(context, p1.c(context, h.a.a.t));
    }

    private ColorStateList j(Context context) {
        return h(context, p1.c(context, h.a.a.u));
    }

    private ColorStateList k(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        int i2 = h.a.a.y;
        ColorStateList colorStateListE = p1.e(context, i2);
        if (colorStateListE == null || !colorStateListE.isStateful()) {
            iArr[0] = p1.b;
            iArr2[0] = p1.b(context, i2);
            iArr[1] = p1.e;
            iArr2[1] = p1.c(context, h.a.a.v);
            iArr[2] = p1.f;
            iArr2[2] = p1.c(context, i2);
        } else {
            iArr[0] = p1.b;
            iArr2[0] = colorStateListE.getColorForState(iArr[0], 0);
            iArr[1] = p1.e;
            iArr2[1] = p1.c(context, h.a.a.v);
            iArr[2] = p1.f;
            iArr2[2] = colorStateListE.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private LayerDrawable l(j1 j1Var, Context context, int i2) throws Resources.NotFoundException {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
        Drawable drawableJ = j1Var.j(context, h.a.e.F);
        Drawable drawableJ2 = j1Var.j(context, h.a.e.G);
        if ((drawableJ instanceof BitmapDrawable) && drawableJ.getIntrinsicWidth() == dimensionPixelSize && drawableJ.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableJ;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableJ.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableJ.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableJ2 instanceof BitmapDrawable) && drawableJ2.getIntrinsicWidth() == dimensionPixelSize && drawableJ2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableJ2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableJ2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableJ2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (m0.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = p.b;
        }
        drawable.setColorFilter(p.e(i2, mode));
    }

    @Override // androidx.appcompat.widget.h1
    public Drawable a(j1 j1Var, Context context, int i2) {
        if (i2 == h.a.e.f1195j) {
            return new LayerDrawable(new Drawable[]{j1Var.j(context, h.a.e.f1194i), j1Var.j(context, h.a.e.f1196k)});
        }
        if (i2 == h.a.e.y) {
            return l(j1Var, context, h.a.d.f1186i);
        }
        if (i2 == h.a.e.x) {
            return l(j1Var, context, h.a.d.f1187j);
        }
        if (i2 == h.a.e.z) {
            return l(j1Var, context, h.a.d.f1188k);
        }
        return null;
    }

    @Override // androidx.appcompat.widget.h1
    public ColorStateList b(Context context, int i2) {
        if (i2 == h.a.e.f1198m) {
            return h.a.k.a.b.c(context, h.a.c.e);
        }
        if (i2 == h.a.e.I) {
            return h.a.k.a.b.c(context, h.a.c.f1184h);
        }
        if (i2 == h.a.e.H) {
            return k(context);
        }
        if (i2 == h.a.e.f) {
            return j(context);
        }
        if (i2 == h.a.e.b) {
            return g(context);
        }
        if (i2 == h.a.e.e) {
            return i(context);
        }
        if (i2 == h.a.e.D || i2 == h.a.e.E) {
            return h.a.k.a.b.c(context, h.a.c.g);
        }
        if (f(this.b, i2)) {
            return p1.e(context, h.a.a.x);
        }
        if (f(this.e, i2)) {
            return h.a.k.a.b.c(context, h.a.c.d);
        }
        if (f(this.f, i2)) {
            return h.a.k.a.b.c(context, h.a.c.c);
        }
        if (i2 == h.a.e.A) {
            return h.a.k.a.b.c(context, h.a.c.f);
        }
        return null;
    }

    @Override // androidx.appcompat.widget.h1
    public PorterDuff.Mode c(int i2) {
        if (i2 == h.a.e.H) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    @Override // androidx.appcompat.widget.h1
    public boolean d(Context context, int i2, Drawable drawable) {
        if (i2 == h.a.e.C) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
            int i3 = h.a.a.x;
            m(drawableFindDrawableByLayerId, p1.c(context, i3), p.b);
            m(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), p1.c(context, i3), p.b);
            m(layerDrawable.findDrawableByLayerId(R.id.progress), p1.c(context, h.a.a.v), p.b);
            return true;
        }
        if (i2 != h.a.e.y && i2 != h.a.e.x && i2 != h.a.e.z) {
            return false;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        m(layerDrawable2.findDrawableByLayerId(R.id.background), p1.b(context, h.a.a.x), p.b);
        Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress);
        int i4 = h.a.a.v;
        m(drawableFindDrawableByLayerId2, p1.c(context, i4), p.b);
        m(layerDrawable2.findDrawableByLayerId(R.id.progress), p1.c(context, i4), p.b);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
    @Override // androidx.appcompat.widget.h1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(Context context, int i2, Drawable drawable) {
        int iRound;
        boolean z;
        PorterDuff.Mode mode = p.b;
        boolean zF = f(this.a, i2);
        int i3 = R.attr.colorBackground;
        if (zF) {
            i3 = h.a.a.x;
        } else if (f(this.c, i2)) {
            i3 = h.a.a.v;
        } else if (f(this.d, i2)) {
            mode = PorterDuff.Mode.MULTIPLY;
        } else {
            if (i2 == h.a.e.u) {
                i3 = R.attr.colorForeground;
                iRound = Math.round(40.8f);
                z = true;
                if (!z) {
                    return false;
                }
                if (m0.a(drawable)) {
                    drawable = drawable.mutate();
                }
                drawable.setColorFilter(p.e(p1.c(context, i3), mode));
                if (iRound != -1) {
                    drawable.setAlpha(iRound);
                }
                return true;
            }
            if (i2 != h.a.e.f1197l) {
                iRound = -1;
                z = false;
                i3 = 0;
                if (!z) {
                }
            }
        }
        iRound = -1;
        z = true;
        if (!z) {
        }
    }
}
