package org.apache.poi.javax.xml.stream.events;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface EndElement extends XMLEvent {
    QName getName();

    Iterator getNamespaces();
}
