package org.apache.poi.xssf.usermodel.t2;

import java.util.Objects;
import org.apache.poi.xssf.usermodel.e1;
import org.apache.poi.xssf.usermodel.u0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* loaded from: classes.dex */
public final class d {
    private u0 a;
    private CTFill b;

    public d(CTFill cTFill, u0 u0Var) {
        this.b = cTFill;
        this.a = u0Var;
    }

    public CTFill a() {
        return this.b;
    }

    public e1 b() {
        CTPatternFill patternFill = this.b.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return e1.f(patternFill.getBgColor(), this.a);
    }

    public e1 c() {
        CTPatternFill patternFill = this.b.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return e1.f(patternFill.getFgColor(), this.a);
    }

    public STPatternType.Enum d() {
        CTPatternFill patternFill = this.b.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return patternFill.getPatternType();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Objects.equals(b(), dVar.b()) && Objects.equals(c(), dVar.c()) && Objects.equals(d(), dVar.d());
    }

    public int hashCode() {
        return this.b.toString().hashCode();
    }
}
