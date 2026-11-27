package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public final class r1 extends g2 {
    private final CTGraphicalObjectFrame d;

    protected r1(j1 j1Var, CTGraphicalObjectFrame cTGraphicalObjectFrame) {
        this.c = j1Var;
        this.d = cTGraphicalObjectFrame;
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic() == null ? null : cTGraphicalObjectFrame.getGraphic().getGraphicData();
        if (graphicData != null) {
            NodeList childNodes = graphicData.getDomNode().getChildNodes();
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node nodeItem = childNodes.item(i2);
                if (nodeItem.getAttributes() != null) {
                    Node namedItem = nodeItem.getAttributes().getNamedItem("r:id");
                    if (nodeItem.getNodeName().equals("c:chart") && namedItem != null) {
                        n.a.a.j.c relationById = j1Var.getRelationById(namedItem.getNodeValue());
                        if (relationById instanceof b1) {
                            ((b1) relationById).a0(this);
                        }
                    }
                }
            }
        }
    }
}
