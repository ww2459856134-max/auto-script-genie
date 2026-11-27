package n.a.a.r.a;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;

/* loaded from: classes.dex */
public class b1 extends g0 implements a0 {
    private final d1 d;
    private final CTSdtCell e;

    public b1(CTSdtCell cTSdtCell, k1 k1Var, y yVar) {
        super(cTSdtCell.getSdtPr(), yVar);
        this.e = cTSdtCell;
        this.d = new d1(cTSdtCell.getSdtContent(), k1Var, yVar);
    }

    public d0 a() {
        return this.d;
    }
}
