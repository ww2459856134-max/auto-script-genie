package h.p.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class f extends l implements Animatable {
    private d d;
    private Context e;
    private ArgbEvaluator f;
    final Drawable.Callback g;

    f() {
        this(null, null, null);
    }

    public static f a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        f fVar = new f(context);
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.d.b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        d dVar = this.d;
        if (dVar.d == null) {
            dVar.d = new ArrayList<>();
            this.d.e = new h.d.b<>();
        }
        this.d.d.add(animator);
        this.d.e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                c(childAnimations.get(i2));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f == null) {
                    this.f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f);
            }
        }
    }

    @Override // h.p.a.a.l, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.c;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.d.b.draw(canvas);
        if (this.d.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.d.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.d.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.d.b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new e(this.c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getIntrinsicHeight() : this.d.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getIntrinsicWidth() : this.d.b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.getOpacity() : this.d.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayS = androidx.core.content.c.r.s(resources, theme, attributeSet, a.e);
                    int resourceId = typedArrayS.getResourceId(0, 0);
                    if (resourceId != 0) {
                        v vVarB = v.b(resources, resourceId, theme);
                        vVarB.h(false);
                        vVarB.setCallback(this.g);
                        v vVar = this.d.b;
                        if (vVar != null) {
                            vVar.setCallback(null);
                        }
                        this.d.b = vVarB;
                    }
                    typedArrayS.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, a.f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.e;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, i.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.d.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.c;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.d.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.c;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.d.c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.c;
        return drawable != null ? drawable.isStateful() : this.d.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.d.b.setBounds(rect);
        }
    }

    @Override // h.p.a.a.l, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.c;
        return drawable != null ? drawable.setLevel(i2) : this.d.b.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.c;
        return drawable != null ? drawable.setState(iArr) : this.d.b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else {
            this.d.b.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z);
        } else {
            this.d.b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            this.d.b.setTint(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
        } else {
            this.d.b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
        } else {
            this.d.b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.c;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.d.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.d.c.isStarted()) {
                return;
            }
            this.d.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.d.c.end();
        }
    }

    private f(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.d.b.setColorFilter(colorFilter);
        }
    }

    private f(Context context, d dVar, Resources resources) {
        this.f = null;
        c cVar = new c(this);
        this.g = cVar;
        this.e = context;
        if (dVar != null) {
            this.d = dVar;
        } else {
            this.d = new d(context, dVar, cVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
