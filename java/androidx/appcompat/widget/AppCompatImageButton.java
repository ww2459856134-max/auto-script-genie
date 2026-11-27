package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements h.e.j.e0, androidx.core.widget.s {
    private final m c;
    private final r d;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.c;
        if (mVar != null) {
            mVar.b();
        }
        r rVar = this.d;
        if (rVar != null) {
            rVar.b();
        }
    }

    @Override // h.e.j.e0
    public ColorStateList getSupportBackgroundTintList() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // h.e.j.e0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.s
    public ColorStateList getSupportImageTintList() {
        r rVar = this.d;
        if (rVar != null) {
            return rVar.c();
        }
        return null;
    }

    @Override // androidx.core.widget.s
    public PorterDuff.Mode getSupportImageTintMode() {
        r rVar = this.d;
        if (rVar != null) {
            return rVar.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.d.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m mVar = this.c;
        if (mVar != null) {
            mVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        m mVar = this.c;
        if (mVar != null) {
            mVar.g(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        r rVar = this.d;
        if (rVar != null) {
            rVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        r rVar = this.d;
        if (rVar != null) {
            rVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.d.g(i2);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        r rVar = this.d;
        if (rVar != null) {
            rVar.b();
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.i(colorStateList);
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.j(mode);
        }
    }

    @Override // androidx.core.widget.s
    public void setSupportImageTintList(ColorStateList colorStateList) {
        r rVar = this.d;
        if (rVar != null) {
            rVar.h(colorStateList);
        }
    }

    @Override // androidx.core.widget.s
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        r rVar = this.d;
        if (rVar != null) {
            rVar.i(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.C);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(q1.b(context), attributeSet, i2);
        p1.a(this, getContext());
        m mVar = new m(this);
        this.c = mVar;
        mVar.e(attributeSet, i2);
        r rVar = new r(this);
        this.d = rVar;
        rVar.f(attributeSet, i2);
    }
}
