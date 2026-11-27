package n.a.a.q.b;

import n.a.a.n.d.m0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;

/* loaded from: classes.dex */
public class d implements m0 {
    private final CTExternalDefinedName a;

    protected d(e eVar, CTExternalDefinedName cTExternalDefinedName) {
        this.a = cTExternalDefinedName;
    }

    @Override // n.a.a.n.d.m0
    public int a() {
        if (this.a.isSetSheetId()) {
            return (int) this.a.getSheetId();
        }
        return -1;
    }

    @Override // n.a.a.n.d.m0
    public void b(String str) {
        this.a.setName(str);
    }

    @Override // n.a.a.n.d.m0
    public void c(int i2) {
        this.a.setSheetId(i2);
    }

    @Override // n.a.a.n.d.m0
    public String d() {
        return this.a.getName();
    }

    @Override // n.a.a.n.d.m0
    public void setFunction(boolean z) {
        throw new IllegalStateException("Not Supported");
    }
}
