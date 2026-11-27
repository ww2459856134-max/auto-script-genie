package n.a.a.r.a;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;

/* loaded from: classes.dex */
public abstract class g0 {
    private final j0 c;

    public g0(CTSdtPr cTSdtPr, y yVar) {
        if (cTSdtPr != null && cTSdtPr.isSetAlias()) {
            cTSdtPr.getAlias().getVal();
        }
        if (cTSdtPr != null && cTSdtPr.isSetTag()) {
            cTSdtPr.getTag().getVal();
        }
        yVar.u();
    }

    public j0 getDocument() {
        return this.c;
    }
}
