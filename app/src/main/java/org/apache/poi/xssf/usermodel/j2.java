package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object, java.lang.Object] */
/* loaded from: classes.dex */
public class j2 extends g2 implements Iterable<o2> {
    private final List<o2> d;
    private CTShape e;

    protected j2(j1 j1Var, CTShape cTShape) {
        this.c = j1Var;
        this.e = cTShape;
        this.d = new ArrayList();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody == null) {
            return;
        }
        for (int i2 = 0; i2 < txBody.sizeOfPArray(); i2++) {
            this.d.add(new o2(txBody.getPArray(i2), cTShape));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<o2> iterator() {
        return this.d.iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<o2> spliterator() {
        return this.d.spliterator();
    }
}
