package org.apache.poi.javax.xml.stream.events;

/* loaded from: classes.dex */
public interface Namespace extends Attribute {
    String getNamespaceURI();

    String getPrefix();

    boolean isDefaultNamespaceDeclaration();
}
