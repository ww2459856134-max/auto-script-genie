package org.apache.xmlbeans.impl.store;

import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.Text;

/* loaded from: classes.dex */
class SaajTextNode extends TextNode implements Text {
    SaajTextNode(Locale locale) {
        super(locale);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void detachNode() {
        DomImpl._soapNode_detachNode(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public SOAPElement getParentElement() {
        return DomImpl._soapNode_getParentElement(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public String getValue() {
        return DomImpl._soapNode_getValue(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Text
    public boolean isComment() {
        return DomImpl._soapText_isComment(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void recycleNode() {
        DomImpl._soapNode_recycleNode(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void setParentElement(SOAPElement sOAPElement) {
        DomImpl._soapNode_setParentElement(this, sOAPElement);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void setValue(String str) {
        DomImpl._soapNode_setValue(this, str);
    }
}
