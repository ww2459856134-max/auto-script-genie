package org.apache.xmlbeans.impl.store;

import org.apache.xmlbeans.impl.store.DomImpl;

/* loaded from: classes.dex */
class SoapPartDocXobj extends DocumentXobj {
    SoapPartDom _soapPartDom;

    SoapPartDocXobj(Locale locale) {
        super(locale);
        this._soapPartDom = new SoapPartDom(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.Xobj
    DomImpl.Dom getDom() {
        return this._soapPartDom;
    }

    @Override // org.apache.xmlbeans.impl.store.DocumentXobj, org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale locale) {
        return new SoapPartDocXobj(locale);
    }
}
