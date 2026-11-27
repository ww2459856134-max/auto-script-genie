package i.f.a.y.r.g.e;

import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
final class b extends f {
    b(i.f.a.v.a aVar) {
        super(aVar);
    }

    @Override // i.f.a.y.r.g.e.i
    protected void h(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // i.f.a.y.r.g.e.i
    protected int i(int i2) {
        return i2 < 10000 ? i2 : i2 - XmlValidationError.UNDEFINED;
    }
}
