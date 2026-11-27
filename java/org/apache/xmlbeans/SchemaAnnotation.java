package org.apache.xmlbeans;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface SchemaAnnotation extends SchemaComponent {

    public interface Attribute {
        QName getName();

        String getValue();

        String getValueUri();
    }

    XmlObject[] getApplicationInformation();

    Attribute[] getAttributes();

    XmlObject[] getUserInformation();
}
