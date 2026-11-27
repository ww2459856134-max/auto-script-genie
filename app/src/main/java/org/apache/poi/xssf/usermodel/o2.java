package org.apache.poi.xssf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* loaded from: classes.dex */
public class o2 implements Iterable<p2> {
    private final CTTextParagraph c;
    private final CTShape d;
    private final List<p2> e = new ArrayList();

    o2(CTTextParagraph cTTextParagraph, CTShape cTShape) {
        this.c = cTTextParagraph;
        this.d = cTShape;
        for (XmlObject xmlObject : cTTextParagraph.selectPath("*")) {
            if (xmlObject instanceof CTRegularTextRun) {
                this.e.add(new p2((CTRegularTextRun) xmlObject, this));
            } else if (xmlObject instanceof CTTextLineBreak) {
                CTRegularTextRun cTRegularTextRunNewInstance = CTRegularTextRun.Factory.newInstance();
                cTRegularTextRunNewInstance.setRPr(((CTTextLineBreak) xmlObject).getRPr());
                cTRegularTextRunNewInstance.setT("\n");
                this.e.add(new p2(cTRegularTextRunNewInstance, this));
            } else if (xmlObject instanceof CTTextField) {
                CTTextField cTTextField = (CTTextField) xmlObject;
                CTRegularTextRun cTRegularTextRunNewInstance2 = CTRegularTextRun.Factory.newInstance();
                cTRegularTextRunNewInstance2.setRPr(cTTextField.getRPr());
                cTRegularTextRunNewInstance2.setT(cTTextField.getT());
                this.e.add(new p2(cTRegularTextRunNewInstance2, this));
            }
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        Iterator<p2> it = this.e.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a());
        }
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<p2> iterator() {
        return this.e.iterator();
    }

    public String toString() {
        return "[" + o2.class + "]" + a();
    }
}
