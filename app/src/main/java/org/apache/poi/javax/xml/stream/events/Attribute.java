package org.apache.poi.javax.xml.stream.events;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface Attribute extends XMLEvent {
    String getDTDType();

    QName getName();

    String getValue();

    boolean isSpecified();
}
