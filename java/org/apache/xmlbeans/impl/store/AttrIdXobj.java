package org.apache.xmlbeans.impl.store;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
class AttrIdXobj extends AttrXobj {
    AttrIdXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.store.AttrXobj, org.w3c.dom.Attr
    public boolean isId() {
        return true;
    }
}
