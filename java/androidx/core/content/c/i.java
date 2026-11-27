package androidx.core.content.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
abstract class i {
    private static h a(h hVar, int i2, int i3, boolean z, int i4) {
        return hVar != null ? hVar : z ? new h(i2, i4, i3) : new h(i2, i3);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = r.s(resources, theme, attributeSet, h.e.c.x);
        float fJ = r.j(typedArrayS, xmlPullParser, "startX", h.e.c.G, 0.0f);
        float fJ2 = r.j(typedArrayS, xmlPullParser, "startY", h.e.c.H, 0.0f);
        float fJ3 = r.j(typedArrayS, xmlPullParser, "endX", h.e.c.I, 0.0f);
        float fJ4 = r.j(typedArrayS, xmlPullParser, "endY", h.e.c.J, 0.0f);
        float fJ5 = r.j(typedArrayS, xmlPullParser, "centerX", h.e.c.B, 0.0f);
        float fJ6 = r.j(typedArrayS, xmlPullParser, "centerY", h.e.c.C, 0.0f);
        int iK = r.k(typedArrayS, xmlPullParser, SocialConstants.PARAM_TYPE, h.e.c.A, 0);
        int iF = r.f(typedArrayS, xmlPullParser, "startColor", h.e.c.y, 0);
        boolean zR = r.r(xmlPullParser, "centerColor");
        int iF2 = r.f(typedArrayS, xmlPullParser, "centerColor", h.e.c.F, 0);
        int iF3 = r.f(typedArrayS, xmlPullParser, "endColor", h.e.c.z, 0);
        int iK2 = r.k(typedArrayS, xmlPullParser, "tileMode", h.e.c.E, 0);
        float fJ7 = r.j(typedArrayS, xmlPullParser, "gradientRadius", h.e.c.D, 0.0f);
        typedArrayS.recycle();
        h hVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, hVarA.a, hVarA.b, d(iK2)) : new SweepGradient(fJ5, fJ6, hVarA.a, hVarA.b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, hVarA.a, hVarA.b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        return new androidx.core.content.c.h(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = r.s(resources, theme, attributeSet, h.e.c.K);
                int i2 = h.e.c.L;
                boolean zHasValue = typedArrayS.hasValue(i2);
                int i3 = h.e.c.M;
                boolean zHasValue2 = typedArrayS.hasValue(i3);
                if (!zHasValue || !zHasValue2) {
                    break;
                }
                int color = typedArrayS.getColor(i2, 0);
                float f = typedArrayS.getFloat(i3, 0.0f);
                typedArrayS.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    }

    private static Shader.TileMode d(int i2) {
        return i2 != 1 ? i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
