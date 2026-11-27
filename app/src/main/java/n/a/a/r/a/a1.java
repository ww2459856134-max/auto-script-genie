package n.a.a.r.a;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

/* loaded from: classes.dex */
public class a1 extends g0 implements z, b0, c0 {
    private final d0 d;

    public a1(CTSdtRun cTSdtRun, y yVar) {
        super(cTSdtRun.getSdtPr(), yVar);
        this.d = new c1(cTSdtRun.getSdtContent(), yVar, this);
    }

    public d0 a() {
        return this.d;
    }

    public a1(CTSdtBlock cTSdtBlock, y yVar) {
        super(cTSdtBlock.getSdtPr(), yVar);
        this.d = new c1(cTSdtBlock.getSdtContent(), yVar, this);
    }
}
