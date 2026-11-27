package n.a.a.r.a;

import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;

/* loaded from: classes.dex */
public class w0 {
    private final CTPicture a;

    public w0(CTPicture cTPicture, z0 z0Var) {
        this.a = cTPicture;
        if (cTPicture != null && cTPicture.getNvPicPr() != null && cTPicture.getNvPicPr().getCNvPr() != null) {
            cTPicture.getNvPicPr().getCNvPr().getDescr();
            return;
        }
        throw new IllegalArgumentException("Found missing data while reading picture data from " + cTPicture);
    }
}
