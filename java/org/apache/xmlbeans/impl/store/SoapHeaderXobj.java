package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;

/* loaded from: classes.dex */
class SoapHeaderXobj extends SoapElementXobj implements SOAPHeader {
    SoapHeaderXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public SOAPHeaderElement addHeaderElement(Name name) {
        return DomImpl.soapHeader_addHeaderElement(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineAllHeaderElements() {
        return DomImpl.soapHeader_examineAllHeaderElements(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineHeaderElements(String str) {
        return DomImpl.soapHeader_examineHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineMustUnderstandHeaderElements(String str) {
        return DomImpl.soapHeader_examineMustUnderstandHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> extractAllHeaderElements() {
        return DomImpl.soapHeader_extractAllHeaderElements(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> extractHeaderElements(String str) {
        return DomImpl.soapHeader_extractHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale locale) {
        return new SoapHeaderXobj(locale, this._name);
    }
}
