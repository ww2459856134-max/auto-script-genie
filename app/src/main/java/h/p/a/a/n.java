package h.p.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class n extends r {
    n() {
    }

    private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.b = string;
        }
        String string2 = typedArray.getString(1);
        if (string2 != null) {
            this.a = h.e.d.e.d(string2);
        }
        this.c = androidx.core.content.c.r.k(typedArray, xmlPullParser, "fillType", 2, 0);
    }

    @Override // h.p.a.a.r
    public boolean c() {
        return true;
    }

    public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        if (androidx.core.content.c.r.r(xmlPullParser, "pathData")) {
            TypedArray typedArrayS = androidx.core.content.c.r.s(resources, theme, attributeSet, a.d);
            f(typedArrayS, xmlPullParser);
            typedArrayS.recycle();
        }
    }

    n(n nVar) {
        super(nVar);
    }
}
