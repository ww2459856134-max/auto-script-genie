package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;

/* loaded from: classes2.dex */
public class CTGroupShapeNonVisualImpl extends XmlComplexContentImpl implements CTGroupShapeNonVisual {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvGrpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr")};
    private static final long serialVersionUID = 1;

    public CTGroupShapeNonVisualImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr() {
        CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTNonVisualGroupDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualDrawingProps addNewCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTApplicationNonVisualDrawingProps addNewNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr() {
        CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualGroupDrawingShapeProps = (CTNonVisualGroupDrawingShapeProps) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTNonVisualGroupDrawingShapeProps == null) {
                cTNonVisualGroupDrawingShapeProps = null;
            }
        }
        return cTNonVisualGroupDrawingShapeProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTNonVisualDrawingProps getCNvPr() {
        CTNonVisualDrawingProps cTNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTNonVisualDrawingProps = (CTNonVisualDrawingProps) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTNonVisualDrawingProps == null) {
                cTNonVisualDrawingProps = null;
            }
        }
        return cTNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public CTApplicationNonVisualDrawingProps getNvPr() {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps;
        synchronized (monitor()) {
            check_orphaned();
            cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTApplicationNonVisualDrawingProps == null) {
                cTApplicationNonVisualDrawingProps = null;
            }
        }
        return cTApplicationNonVisualDrawingProps;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps) throws Throwable {
        generatedSetterHelperImpl(cTNonVisualGroupDrawingShapeProps, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps) throws Throwable {
        generatedSetterHelperImpl(cTNonVisualDrawingProps, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual
    public void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps) throws Throwable {
        generatedSetterHelperImpl(cTApplicationNonVisualDrawingProps, PROPERTY_QNAME[2], 0, (short) 1);
    }
}
