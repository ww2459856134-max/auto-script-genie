package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class n0 extends h.a.l.a.n {
    private boolean d;

    n0(Drawable drawable) {
        super(drawable);
        this.d = true;
    }

    void c(boolean z) {
        this.d = z;
    }

    @Override // h.a.l.a.n, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.d) {
            super.draw(canvas);
        }
    }

    @Override // h.a.l.a.n, android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.d) {
            super.setHotspot(f, f2);
        }
    }

    @Override // h.a.l.a.n, android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        if (this.d) {
            super.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    @Override // h.a.l.a.n, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (this.d) {
            return super.setState(iArr);
        }
        return false;
    }

    @Override // h.a.l.a.n, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.d) {
            return super.setVisible(z, z2);
        }
        return false;
    }
}
