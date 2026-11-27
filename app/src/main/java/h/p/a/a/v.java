package h.p.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class v extends l {
    static final PorterDuff.Mode t = PorterDuff.Mode.SRC_IN;
    private t d;
    private PorterDuffColorFilter e;
    private ColorFilter f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1380h;

    /* renamed from: i, reason: collision with root package name */
    private final float[] f1381i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f1382j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f1383k;

    v() {
        this.f1380h = true;
        this.f1381i = new float[9];
        this.f1382j = new Matrix();
        this.f1383k = new Rect();
        this.d = new t();
    }

    static int a(int i2, float f) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f)) << 24);
    }

    public static v b(Resources resources, int i2, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            v vVar = new v();
            vVar.c = androidx.core.content.c.q.a(resources, i2, theme);
            new u(vVar.c.getConstantState());
            return vVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static v c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        v vVar = new v();
        vVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return vVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        t tVar = this.d;
        s sVar = tVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(sVar.f1367h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                p pVar = (p) arrayDeque.peek();
                if ("path".equals(name)) {
                    o oVar = new o();
                    oVar.g(resources, attributeSet, theme, xmlPullParser);
                    pVar.b.add(oVar);
                    if (oVar.getPathName() != null) {
                        sVar.p.put(oVar.getPathName(), oVar);
                    }
                    z = false;
                    tVar.a = oVar.d | tVar.a;
                } else if ("clip-path".equals(name)) {
                    n nVar = new n();
                    nVar.e(resources, attributeSet, theme, xmlPullParser);
                    pVar.b.add(nVar);
                    if (nVar.getPathName() != null) {
                        sVar.p.put(nVar.getPathName(), nVar);
                    }
                    tVar.a = nVar.d | tVar.a;
                } else if ("group".equals(name)) {
                    p pVar2 = new p();
                    pVar2.c(resources, attributeSet, theme, xmlPullParser);
                    pVar.b.add(pVar2);
                    arrayDeque.push(pVar2);
                    if (pVar2.getGroupName() != null) {
                        sVar.p.put(pVar2.getGroupName(), pVar2);
                    }
                    tVar.a = pVar2.f1364k | tVar.a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        t tVar = this.d;
        s sVar = tVar.b;
        tVar.d = g(androidx.core.content.c.r.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = androidx.core.content.c.r.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            tVar.c = colorStateListG;
        }
        tVar.e = androidx.core.content.c.r.e(typedArray, xmlPullParser, "autoMirrored", 5, tVar.e);
        sVar.f1370k = androidx.core.content.c.r.j(typedArray, xmlPullParser, "viewportWidth", 7, sVar.f1370k);
        float fJ = androidx.core.content.c.r.j(typedArray, xmlPullParser, "viewportHeight", 8, sVar.f1371l);
        sVar.f1371l = fJ;
        if (sVar.f1370k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        sVar.f1368i = typedArray.getDimension(3, sVar.f1368i);
        float dimension = typedArray.getDimension(2, sVar.f1369j);
        sVar.f1369j = dimension;
        if (sVar.f1368i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        sVar.setAlpha(androidx.core.content.c.r.j(typedArray, xmlPullParser, "alpha", 4, sVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            sVar.f1373n = string;
            sVar.p.put(string, sVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.c;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    Object d(String str) {
        return this.d.b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1383k);
        if (this.f1383k.width() <= 0 || this.f1383k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f;
        if (colorFilter == null) {
            colorFilter = this.e;
        }
        canvas.getMatrix(this.f1382j);
        this.f1382j.getValues(this.f1381i);
        float fAbs = Math.abs(this.f1381i[0]);
        float fAbs2 = Math.abs(this.f1381i[4]);
        float fAbs3 = Math.abs(this.f1381i[1]);
        float fAbs4 = Math.abs(this.f1381i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f1383k.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f1383k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f1383k;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f1383k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f1383k.offsetTo(0, 0);
        this.d.c(iMin, iMin2);
        if (!this.f1380h) {
            this.d.j(iMin, iMin2);
        } else if (!this.d.b()) {
            this.d.j(iMin, iMin2);
            this.d.i();
        }
        this.d.d(canvas, colorFilter, this.f1383k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.d.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.c != null && Build.VERSION.SDK_INT >= 24) {
            return new u(this.c.getConstantState());
        }
        this.d.a = getChangingConfigurations();
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.d.b.f1369j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.d.b.f1368i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    void h(boolean z) {
        this.f1380h = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.d.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        t tVar;
        ColorStateList colorStateList;
        Drawable drawable = this.c;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((tVar = this.d) != null && (tVar.g() || ((colorStateList = this.d.c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.g && super.mutate() == this) {
            this.d = new t(this.d);
            this.g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        t tVar = this.d;
        ColorStateList colorStateList = tVar.c;
        if (colorStateList != null && (mode = tVar.d) != null) {
            this.e = j(this.e, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!tVar.g() || !tVar.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.d.b.getRootAlpha() != i2) {
            this.d.b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z);
        } else {
            this.d.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        t tVar = this.d;
        if (tVar.c != colorStateList) {
            tVar.c = colorStateList;
            this.e = j(this.e, colorStateList, tVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        t tVar = this.d;
        if (tVar.d != mode) {
            tVar.d = mode;
            this.e = j(this.e, tVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.c;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        t tVar = this.d;
        tVar.b = new s();
        TypedArray typedArrayS = androidx.core.content.c.r.s(resources, theme, attributeSet, a.a);
        i(typedArrayS, xmlPullParser, theme);
        typedArrayS.recycle();
        tVar.a = getChangingConfigurations();
        tVar.f1378k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.e = j(this.e, tVar.c, tVar.d);
    }

    v(t tVar) {
        this.f1380h = true;
        this.f1381i = new float[9];
        this.f1382j = new Matrix();
        this.f1383k = new Rect();
        this.d = tVar;
        this.e = j(this.e, tVar.c, tVar.d);
    }
}
