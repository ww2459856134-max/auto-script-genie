package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class f1 implements g1 {
    f1() {
    }

    @Override // androidx.appcompat.widget.g1
    public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String classAttribute = attributeSet.getClassAttribute();
        if (classAttribute != null) {
            try {
                Drawable drawable = (Drawable) f1.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                } else {
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                }
                return drawable;
            } catch (Exception e) {
                Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
            }
        }
        return null;
    }
}
