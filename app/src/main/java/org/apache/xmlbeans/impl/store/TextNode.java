package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Text;

/* loaded from: classes.dex */
class TextNode extends CharNode implements Text {
    TextNode(Locale locale) {
        super(locale);
    }

    @Override // org.w3c.dom.Text
    public String getWholeText() {
        return DomImpl._text_getWholeText(this);
    }

    @Override // org.w3c.dom.Text
    public boolean isElementContentWhitespace() {
        return DomImpl._text_isElementContentWhitespace(this);
    }

    public String name() {
        return "#text";
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.Dom
    public int nodeType() {
        return 3;
    }

    @Override // org.w3c.dom.Text
    public Text replaceWholeText(String str) {
        return DomImpl._text_replaceWholeText(this, str);
    }

    @Override // org.w3c.dom.Text
    public Text splitText(int i2) {
        return DomImpl._text_splitText(this, i2);
    }
}
