package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;

/* loaded from: classes.dex */
public abstract class n {
    protected p<?> a;
    protected g0<? extends Number> b;

    protected n(p<?> pVar, g0<? extends Number> g0Var) {
        d(pVar, g0Var);
    }

    private CTNumData e(CTAxDataSource cTAxDataSource, p<?> pVar) {
        CTNumData numLit;
        if (pVar.a()) {
            CTNumRef numRef = cTAxDataSource.isSetNumRef() ? cTAxDataSource.getNumRef() : cTAxDataSource.addNewNumRef();
            numLit = numRef.isSetNumCache() ? numRef.getNumCache() : numRef.addNewNumCache();
            numRef.setF(pVar.d());
            if (cTAxDataSource.isSetNumLit()) {
                cTAxDataSource.unsetNumLit();
            }
        } else {
            numLit = cTAxDataSource.isSetNumLit() ? cTAxDataSource.getNumLit() : cTAxDataSource.addNewNumLit();
            if (cTAxDataSource.isSetNumRef()) {
                cTAxDataSource.unsetNumRef();
            }
        }
        return numLit;
    }

    private CTStrData g(CTAxDataSource cTAxDataSource, p<?> pVar) {
        CTStrData strLit;
        if (pVar.a()) {
            CTStrRef strRef = cTAxDataSource.isSetStrRef() ? cTAxDataSource.getStrRef() : cTAxDataSource.addNewStrRef();
            strLit = strRef.isSetStrCache() ? strRef.getStrCache() : strRef.addNewStrCache();
            strRef.setF(pVar.d());
            if (cTAxDataSource.isSetStrLit()) {
                cTAxDataSource.unsetStrLit();
            }
        } else {
            strLit = cTAxDataSource.isSetStrLit() ? cTAxDataSource.getStrLit() : cTAxDataSource.addNewStrLit();
            if (cTAxDataSource.isSetStrRef()) {
                cTAxDataSource.unsetStrRef();
            }
        }
        return strLit;
    }

    protected abstract CTAxDataSource a();

    protected abstract CTNumDataSource b();

    public void c() {
        p<?> pVar = this.a;
        if (pVar != null) {
            if (pVar.isNumeric()) {
                this.a.c(e(a(), this.a));
            } else {
                this.a.f(g(a(), this.a));
            }
        }
        if (this.b != null) {
            this.b.c(f(b(), this.b));
        }
    }

    public void d(p<?> pVar, g0<? extends Number> g0Var) {
        int iE;
        if (this.a != null && g0Var != null && (iE = pVar.e()) != g0Var.e()) {
            o.b.warn("Category and values must have the same point count, but had {} categories and {} values.", Integer.valueOf(iE), Integer.valueOf(g0Var.e()));
        }
        this.a = pVar;
        this.b = g0Var;
    }

    protected CTNumData f(CTNumDataSource cTNumDataSource, p<?> pVar) {
        CTNumData numLit;
        if (pVar.a()) {
            CTNumRef numRef = cTNumDataSource.isSetNumRef() ? cTNumDataSource.getNumRef() : cTNumDataSource.addNewNumRef();
            numLit = numRef.isSetNumCache() ? numRef.getNumCache() : numRef.addNewNumCache();
            numRef.setF(pVar.d());
            if (cTNumDataSource.isSetNumLit()) {
                cTNumDataSource.unsetNumLit();
            }
        } else {
            numLit = cTNumDataSource.isSetNumLit() ? cTNumDataSource.getNumLit() : cTNumDataSource.addNewNumLit();
            if (cTNumDataSource.isSetNumRef()) {
                cTNumDataSource.unsetNumRef();
            }
        }
        return numLit;
    }
}
