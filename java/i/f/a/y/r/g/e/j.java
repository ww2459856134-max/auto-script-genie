package i.f.a.y.r.g.e;

import com.tencent.connect.common.Constants;

/* loaded from: classes.dex */
public abstract class j {
    private final i.f.a.v.a a;
    private final t b;

    j(i.f.a.v.a aVar) {
        this.a = aVar;
        this.b = new t(aVar);
    }

    public static j a(i.f.a.v.a aVar) {
        if (aVar.g(1)) {
            return new g(aVar);
        }
        if (!aVar.g(2)) {
            return new k(aVar);
        }
        int iG = t.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = t.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (t.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 57:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 58:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            case 59:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
            case 60:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 61:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 62:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
        }
    }

    protected final t b() {
        return this.b;
    }

    protected final i.f.a.v.a c() {
        return this.a;
    }

    public abstract String d() throws i.f.a.k, i.f.a.g;
}
