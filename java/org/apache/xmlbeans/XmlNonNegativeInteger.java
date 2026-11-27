package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* loaded from: classes.dex */
public interface XmlNonNegativeInteger extends XmlInteger {
    public static final XmlObjectFactory<XmlNonNegativeInteger> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlNonNegativeInteger> xmlObjectFactory = new XmlObjectFactory<>("_BI_nonNegativeInteger");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }
}
