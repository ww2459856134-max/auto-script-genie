package h.a.l.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.j1;
import androidx.core.content.c.r;
import h.p.a.a.v;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class h extends p implements androidx.core.graphics.drawable.b {
    private c H;
    private g I;
    private int J;
    private int K;
    private boolean M;

    public h() {
        this(null, null);
    }

    public static h l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            h hVar = new h();
            hVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return hVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void o() {
        onStateChange(getState());
    }

    private int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = r.s(resources, theme, attributeSet, h.a.m.b.f1245h);
        int resourceId = typedArrayS.getResourceId(h.a.m.b.f1246i, 0);
        int resourceId2 = typedArrayS.getResourceId(h.a.m.b.f1247j, -1);
        Drawable drawableJ = resourceId2 > 0 ? j1.h().j(context, resourceId2) : null;
        typedArrayS.recycle();
        int[] iArrJ = j(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? v.c(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ != null) {
            return this.H.B(iArrJ, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = r.s(resources, theme, attributeSet, h.a.m.b.f1248k);
        int resourceId = typedArrayS.getResourceId(h.a.m.b.f1251n, -1);
        int resourceId2 = typedArrayS.getResourceId(h.a.m.b.f1250m, -1);
        int resourceId3 = typedArrayS.getResourceId(h.a.m.b.f1249l, -1);
        Drawable drawableJ = resourceId3 > 0 ? j1.h().j(context, resourceId3) : null;
        boolean z = typedArrayS.getBoolean(h.a.m.b.f1252o, false);
        typedArrayS.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? h.p.a.a.f.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.H.C(resourceId, resourceId2, drawableJ, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    private boolean r(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iC;
        int iG;
        g bVar;
        g gVar = this.I;
        if (gVar == null) {
            iC = c();
        } else {
            if (i2 == this.J) {
                return true;
            }
            if (i2 == this.K && gVar.a()) {
                gVar.b();
                this.J = this.K;
                this.K = i2;
                return true;
            }
            iC = this.J;
            gVar.d();
        }
        this.I = null;
        this.K = -1;
        this.J = -1;
        c cVar = this.H;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i2);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof h.p.a.a.f)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((h.p.a.a.f) current);
        }
        bVar.c();
        this.I = bVar;
        this.K = iC;
        this.J = i2;
        return true;
    }

    private void s(TypedArray typedArray) {
        c cVar = this.H;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(h.a.m.b.d, cVar.f1234i));
        cVar.t(typedArray.getBoolean(h.a.m.b.e, cVar.f1237l));
        cVar.u(typedArray.getInt(h.a.m.b.f, cVar.A));
        cVar.v(typedArray.getInt(h.a.m.b.g, cVar.B));
        setDither(typedArray.getBoolean(h.a.m.b.b, cVar.x));
    }

    @Override // h.a.l.a.p, h.a.l.a.m
    void h(l lVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.h(lVar);
        if (lVar instanceof c) {
            this.H = (c) lVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // h.a.l.a.m, android.graphics.drawable.Drawable
    public void jumpToCurrentState() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.jumpToCurrentState();
        g gVar = this.I;
        if (gVar != null) {
            gVar.d();
            this.I = null;
            g(this.J);
            this.J = -1;
            this.K = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // h.a.l.a.m
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.H, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IllegalAccessException, NoSuchMethodException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        TypedArray typedArrayS = r.s(resources, theme, attributeSet, h.a.m.b.a);
        setVisible(typedArrayS.getBoolean(h.a.m.b.c, true), true);
        s(typedArrayS);
        i(resources);
        typedArrayS.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // h.a.l.a.p, h.a.l.a.m, android.graphics.drawable.Drawable
    public Drawable mutate() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.M) {
            super.mutate();
            if (this == this) {
                this.H.r();
                this.M = true;
            }
        }
        return this;
    }

    @Override // h.a.l.a.p, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iF = this.H.F(iArr);
        boolean z = iF != c() && (r(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // h.a.l.a.m, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.I;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    h(c cVar, Resources resources) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(null);
        this.J = -1;
        this.K = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
