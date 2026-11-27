package n.a.a.p.a.a;

import org.apache.poi.xssf.usermodel.i2;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;

/* loaded from: classes.dex */
public abstract class z {
    public static k a(CTAxDataSource cTAxDataSource) {
        if (cTAxDataSource == null) {
            return null;
        }
        if (cTAxDataSource.getNumRef() != null && cTAxDataSource.getNumRef().getNumCache() != null) {
            return new q(cTAxDataSource);
        }
        if (cTAxDataSource.getStrRef() != null && cTAxDataSource.getStrRef().getStrCache() != null) {
            return new r(cTAxDataSource);
        }
        if (cTAxDataSource.getNumLit() != null) {
            return new s(cTAxDataSource);
        }
        if (cTAxDataSource.getStrLit() != null) {
            return new t(cTAxDataSource);
        }
        return null;
    }

    public static g0<Double> b(CTNumDataSource cTNumDataSource) {
        if (cTNumDataSource == null) {
            return null;
        }
        if (cTNumDataSource.getNumRef() != null && cTNumDataSource.getNumRef().getNumCache() != null) {
            return new u(cTNumDataSource);
        }
        if (cTNumDataSource.getNumLit() != null) {
            return new v(cTNumDataSource);
        }
        return null;
    }

    public static g0<Double> c(i2 i2Var, n.a.a.n.e.m mVar) {
        return new x(i2Var, mVar);
    }

    public static k d(i2 i2Var, n.a.a.n.e.m mVar) {
        return new y(i2Var, mVar);
    }
}
