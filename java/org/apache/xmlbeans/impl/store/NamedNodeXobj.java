package org.apache.xmlbeans.impl.store;

/* loaded from: classes.dex */
abstract class NamedNodeXobj extends NodeXobj {
    boolean _canHavePrefixUri;

    NamedNodeXobj(Locale locale, int i2, int i3) {
        super(locale, i2, i3);
        this._canHavePrefixUri = true;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.DomImpl.Dom
    public boolean nodeCanHavePrefixUri() {
        return this._canHavePrefixUri;
    }
}
