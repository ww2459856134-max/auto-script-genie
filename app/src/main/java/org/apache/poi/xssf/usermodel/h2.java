package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import java.util.Spliterator;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;

/* loaded from: classes.dex */
public final class h2 extends g2 implements Object<g2> {
    private CTGroupShape d;

    protected h2(j1 j1Var, CTGroupShape cTGroupShape) {
        this.c = j1Var;
        this.d = cTGroupShape;
    }

    public CTGroupShape b() {
        return this.d;
    }

    public Iterator<g2> iterator() {
        return a().O(this).iterator();
    }

    public Spliterator<g2> spliterator() {
        return a().O(this).spliterator();
    }
}
