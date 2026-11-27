package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: classes.dex */
class h extends AppCompatImageView implements ActionMenuView.a {
    final /* synthetic */ k e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, Context context) {
        super(context, null, h.a.a.f1180l);
        this.e = kVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        y1.a(this, getContentDescription());
        setOnTouchListener(new g(this, this, kVar));
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return false;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.e.L();
        return true;
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            androidx.core.graphics.drawable.a.k(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
