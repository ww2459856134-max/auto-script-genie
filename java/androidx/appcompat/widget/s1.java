package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class s1 extends k1 {
    private final WeakReference<Context> b;

    public s1(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.k1, android.content.res.Resources
    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = this.b.get();
        if (drawable != null && context != null) {
            j1.h().x(context, i2, drawable);
        }
        return drawable;
    }
}
