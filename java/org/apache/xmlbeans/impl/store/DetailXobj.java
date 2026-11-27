package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;

/* loaded from: classes.dex */
class DetailXobj extends SoapFaultElementXobj implements Detail {
    DetailXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.Detail
    public DetailEntry addDetailEntry(Name name) {
        return DomImpl.detail_addDetailEntry(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.Detail
    public Iterator<DetailEntry> getDetailEntries() {
        return DomImpl.detail_getDetailEntries(this);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapFaultElementXobj, org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale locale) {
        return new DetailXobj(locale, this._name);
    }
}
