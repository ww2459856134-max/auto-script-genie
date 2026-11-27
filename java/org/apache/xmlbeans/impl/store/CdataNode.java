package org.apache.xmlbeans.impl.store;

import org.w3c.dom.CDATASection;

/* loaded from: classes.dex */
class CdataNode extends TextNode implements CDATASection {
    CdataNode(Locale locale) {
        super(locale);
    }

    @Override // org.apache.xmlbeans.impl.store.TextNode
    public String name() {
        return "#cdata-section";
    }

    @Override // org.apache.xmlbeans.impl.store.TextNode, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 4;
    }
}
