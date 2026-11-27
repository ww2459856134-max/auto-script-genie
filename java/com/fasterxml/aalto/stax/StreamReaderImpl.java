package com.fasterxml.aalto.stax;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import i.e.a.j.e0;
import i.e.a.j.n;
import i.e.a.j.v;
import i.e.a.j.z;
import i.e.a.l.q;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.NoSuchElementException;
import n.b.a.a;
import n.b.a.b;
import n.b.a.c;
import n.b.a.h;
import n.b.a.i;
import n.b.a.m.i;
import n.b.a.m.o.d;
import n.b.a.n.e;
import n.b.a.p.f;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class StreamReaderImpl implements i, a, b, c {
    private static final int MASK_GET_ELEMENT_TEXT = 4688;
    private static final int MASK_GET_TEXT = 6768;
    private static final int MASK_GET_TEXT_WITH_WRITER = 6776;
    private static final int MASK_GET_TEXT_XXX = 4208;
    private static final int MASK_TYPED_ACCESS_ARRAY = 4182;
    private static final int MASK_TYPED_ACCESS_BINARY = 4178;
    static final int STATE_CLOSED = 3;
    static final int STATE_EPILOG = 2;
    static final int STATE_PROLOG = 0;
    static final int STATE_TREE = 1;
    protected int _attrCount;
    protected final boolean _cfgCoalesceText;
    protected final boolean _cfgReportTextAsChars;
    protected v _currName;
    protected d _decoderFactory;
    protected v _dtdRootName;
    protected int _parseState;
    protected final e0 _scanner;
    protected n.b.a.m.o.b _base64Decoder = null;
    protected int _currToken = 7;

    public StreamReaderImpl(e0 e0Var) {
        this._scanner = e0Var;
        this._cfgCoalesceText = e0Var.C().b0();
        this._cfgReportTextAsChars = !r2.h0();
    }

    private e _constructTypeException(IllegalArgumentException illegalArgumentException, String str) {
        return new e(str, illegalArgumentException.getMessage(), getStartLocation(), illegalArgumentException);
    }

    private void _handleEmptyValue(n.b.a.n.d dVar) throws XMLStreamException {
        try {
            dVar.c();
            throw null;
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, "");
        }
    }

    public static StreamReaderImpl construct(n nVar) throws XMLStreamException {
        return new StreamReaderImpl(nVar.a());
    }

    private void throwNotTextXxx(int i2) {
        throw new IllegalStateException("getTextXxx() methods can not be called on " + i.e.a.i.b.c(this._currToken));
    }

    private void throwNotTextual(int i2) {
        throw new IllegalStateException("Not a textual event (" + i.e.a.i.b.c(this._currToken) + ")");
    }

    protected n.b.a.m.o.b _base64Decoder() {
        if (this._base64Decoder == null) {
            this._base64Decoder = new n.b.a.m.o.b();
        }
        return this._base64Decoder;
    }

    protected void _closeScanner(boolean z) throws XMLStreamException {
        if (this._parseState != 3) {
            this._parseState = 3;
            if (this._currToken != 8) {
                this._currToken = 8;
            }
        }
        this._scanner.g(z);
    }

    protected XMLStreamException _constructUnexpectedInTyped(int i2) {
        if (i2 == 1) {
            return _constructTypeException("Element content can not contain child START_ELEMENT when using Typed Access methods", (String) null);
        }
        return _constructTypeException("Expected a text token, got " + i.e.a.i.b.c(i2), (String) null);
    }

    protected final d _decoderFactory() {
        if (this._decoderFactory == null) {
            this._decoderFactory = new d();
        }
        return this._decoderFactory;
    }

    protected void _reportNonTextEvent(int i2) throws XMLStreamException {
        throwWfe("Expected a text token, got " + i.e.a.i.b.c(i2) + ".");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final void close() throws XMLStreamException {
        _closeScanner(false);
    }

    public final void closeCompletely() throws XMLStreamException {
        _closeScanner(true);
    }

    public final int findAttributeIndex(String str, String str2) {
        return this._scanner.l(str, str2);
    }

    public final void getAttributeAs(int i2, n.b.a.n.d dVar) throws XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        try {
            this._scanner.i(i2, dVar);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, getAttributeValue(i2));
        }
    }

    public final int getAttributeAsArray(int i2, n.b.a.n.c cVar) throws XMLStreamException {
        if (this._currToken == 1) {
            return this._scanner.j(i2, cVar);
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    public final byte[] getAttributeAsBinary(int i2) throws XMLStreamException {
        return getAttributeAsBinary(i2, n.b.a.n.b.a());
    }

    public final boolean getAttributeAsBoolean(int i2) throws XMLStreamException {
        d.a aVarA = _decoderFactory().a();
        getAttributeAs(i2, aVarA);
        return aVarA.t();
    }

    public final BigDecimal getAttributeAsDecimal(int i2) throws XMLStreamException {
        d.b bVarB = _decoderFactory().b();
        getAttributeAs(i2, bVarB);
        return bVarB.t();
    }

    public final double getAttributeAsDouble(int i2) throws XMLStreamException {
        d.C0018d c0018dE = _decoderFactory().e();
        getAttributeAs(i2, c0018dE);
        return c0018dE.t();
    }

    public final double[] getAttributeAsDoubleArray(int i2) throws XMLStreamException {
        d.c cVarC = _decoderFactory().c();
        getAttributeAsArray(i2, cVarC);
        return cVarC.e();
    }

    public final float getAttributeAsFloat(int i2) throws XMLStreamException {
        d.f fVarH = _decoderFactory().h();
        getAttributeAs(i2, fVarH);
        return fVarH.t();
    }

    public final float[] getAttributeAsFloatArray(int i2) throws XMLStreamException {
        d.e eVarF = _decoderFactory().f();
        getAttributeAsArray(i2, eVarF);
        return eVarF.e();
    }

    public final int getAttributeAsInt(int i2) throws XMLStreamException {
        d.h hVarK = _decoderFactory().k();
        getAttributeAs(i2, hVarK);
        return hVarK.t();
    }

    public final int[] getAttributeAsIntArray(int i2) throws XMLStreamException {
        d.g gVarI = _decoderFactory().i();
        getAttributeAsArray(i2, gVarI);
        return gVarI.e();
    }

    public final BigInteger getAttributeAsInteger(int i2) throws XMLStreamException {
        d.i iVarL = _decoderFactory().l();
        getAttributeAs(i2, iVarL);
        return iVarL.t();
    }

    public final long getAttributeAsLong(int i2) throws XMLStreamException {
        d.k kVarO = _decoderFactory().o();
        getAttributeAs(i2, kVarO);
        return kVarO.t();
    }

    public final long[] getAttributeAsLongArray(int i2) throws XMLStreamException {
        d.j jVarM = _decoderFactory().m();
        getAttributeAsArray(i2, jVarM);
        return jVarM.e();
    }

    public final QName getAttributeAsQName(int i2) throws XMLStreamException {
        d.l lVarP = _decoderFactory().p(getNamespaceContext());
        getAttributeAs(i2, lVarP);
        return verifyQName(lVarP.t());
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getAttributeCount() {
        if (this._currToken == 1) {
            return this._attrCount;
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    public final int getAttributeIndex(String str, String str2) {
        if (this._currToken == 1) {
            return findAttributeIndex(str, str2);
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    public final a getAttributeInfo() throws XMLStreamException {
        if (this._currToken == 1) {
            return this;
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributeLocalName(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        return this._scanner.v(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final QName getAttributeName(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        return this._scanner.y(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributeNamespace(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        String strW = this._scanner.w(i2);
        return strW == null ? "" : strW;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributePrefix(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        String strX = this._scanner.x(i2);
        return strX == null ? "" : strX;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributeType(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        return this._scanner.z(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributeValue(int i2) {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        if (i2 >= this._attrCount || i2 < 0) {
            reportInvalidAttrIndex(i2);
        }
        return this._scanner.A(i2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getCharacterEncodingScheme() {
        return this._scanner.C().L();
    }

    public z getConfig() {
        return this._scanner.C();
    }

    public final h getCurrentLocation() {
        return this._scanner.D();
    }

    @Override // n.b.a.i
    public final b getDTDInfo() throws XMLStreamException {
        if (this._currToken != 11) {
            return null;
        }
        return this;
    }

    @Override // n.b.a.b
    public final String getDTDInternalSubset() {
        if (this._currToken != 11) {
            return null;
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // n.b.a.b
    public final String getDTDPublicId() {
        return this._scanner.E();
    }

    @Override // n.b.a.b
    public final String getDTDRootName() {
        v vVar;
        if (this._currToken == 11 && (vVar = this._currName) != null) {
            return vVar.l();
        }
        return null;
    }

    @Override // n.b.a.b
    public final String getDTDSystemId() {
        return this._scanner.F();
    }

    public final int getDepth() {
        int iG = this._scanner.G();
        return this._currToken == 2 ? iG + 1 : iG;
    }

    public final void getElementAs(n.b.a.n.d dVar) throws XMLStreamException {
        String strTrim = getElementText().trim();
        if (strTrim.length() == 0) {
            _handleEmptyValue(dVar);
            return;
        }
        try {
            dVar.a(strTrim);
        } catch (IllegalArgumentException e) {
            throw _constructTypeException(e, strTrim);
        }
    }

    public final byte[] getElementAsBinary() throws XMLStreamException {
        return getElementAsBinary(n.b.a.n.b.a());
    }

    public final boolean getElementAsBoolean() throws XMLStreamException {
        d.a aVarA = _decoderFactory().a();
        getElementAs(aVarA);
        return aVarA.t();
    }

    public final BigDecimal getElementAsDecimal() throws XMLStreamException {
        d.b bVarB = _decoderFactory().b();
        getElementAs(bVarB);
        return bVarB.t();
    }

    public final double getElementAsDouble() throws XMLStreamException {
        d.C0018d c0018dE = _decoderFactory().e();
        getElementAs(c0018dE);
        return c0018dE.t();
    }

    public final float getElementAsFloat() throws XMLStreamException {
        d.f fVarH = _decoderFactory().h();
        getElementAs(fVarH);
        return fVarH.t();
    }

    public final int getElementAsInt() throws XMLStreamException {
        d.h hVarK = _decoderFactory().k();
        getElementAs(hVarK);
        return hVarK.t();
    }

    public final BigInteger getElementAsInteger() throws XMLStreamException {
        d.i iVarL = _decoderFactory().l();
        getElementAs(iVarL);
        return iVarL.t();
    }

    public final long getElementAsLong() throws XMLStreamException {
        d.k kVarO = _decoderFactory().o();
        getElementAs(kVarO);
        return kVarO.t();
    }

    public final QName getElementAsQName() throws XMLStreamException {
        d.l lVarP = _decoderFactory().p(getNamespaceContext());
        getElementAs(lVarP);
        return verifyQName(lVarP.t());
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getElementText() throws XMLStreamException {
        if (this._currToken != 1) {
            throwWfe(i.e.a.i.b.e);
        }
        while (true) {
            int next = next();
            if (next == 2) {
                return "";
            }
            if (next != 5 && next != 3) {
                if (((1 << next) & MASK_GET_ELEMENT_TEXT) == 0) {
                    _reportNonTextEvent(next);
                }
                String text = this._scanner.getText();
                i.e.a.l.h hVar = null;
                while (true) {
                    int next2 = next();
                    if (next2 == 2) {
                        break;
                    }
                    if (((1 << next2) & MASK_GET_ELEMENT_TEXT) != 0) {
                        if (hVar == null) {
                            hVar = new i.e.a.l.h();
                            hVar.a(text);
                        }
                        hVar.a(getText());
                    } else if (next2 != 5 && next2 != 3) {
                        _reportNonTextEvent(next2);
                    }
                }
                return hVar == null ? text : hVar.b();
            }
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getEncoding() {
        return this._scanner.C().B();
    }

    public final h getEndLocation() throws XMLStreamException {
        return this._scanner.H();
    }

    public final long getEndingByteOffset() throws XMLStreamException {
        return this._scanner.I();
    }

    public final long getEndingCharOffset() throws XMLStreamException {
        return this._scanner.J();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getEventType() {
        int i2 = this._currToken;
        if (i2 != 12) {
            return i2;
        }
        if (this._cfgCoalesceText || this._cfgReportTextAsChars) {
            return 4;
        }
        return i2;
    }

    @Deprecated
    public final Object getFeature(String str) {
        return null;
    }

    public final int getIdAttributeIndex() {
        return -1;
    }

    protected Location getLastCharLocation() {
        return this._scanner.D();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getLocalName() {
        int i2 = this._currToken;
        if (i2 == 1 || i2 == 2 || i2 == 9) {
            return this._currName.i();
        }
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final Location getLocation() {
        return getStartLocation();
    }

    public final c getLocationInfo() {
        return this;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final QName getName() {
        int i2 = this._currToken;
        if (i2 == 1 || i2 == 2) {
            return this._scanner.M();
        }
        throw new IllegalStateException(i.e.a.i.b.f);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final NamespaceContext getNamespaceContext() {
        return this._scanner;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getNamespaceCount() {
        int i2 = this._currToken;
        if (i2 == 1 || i2 == 2) {
            return this._scanner.L();
        }
        throw new IllegalStateException(i.e.a.i.b.f);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getNamespacePrefix(int i2) {
        int i3 = this._currToken;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalStateException(i.e.a.i.b.f);
        }
        String namespacePrefix = this._scanner.getNamespacePrefix(i2);
        return namespacePrefix == null ? "" : namespacePrefix;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getNamespaceURI() {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(i.e.a.i.b.f);
        }
        String namespaceURI = this._scanner.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    @Override // n.b.a.i
    public final NamespaceContext getNonTransientNamespaceContext() {
        return this._scanner.getNonTransientNamespaceContext();
    }

    public final int getNotationAttributeIndex() {
        return -1;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getPIData() {
        if (this._currToken != 3) {
            throw new IllegalStateException(i.e.a.i.b.g);
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getPITarget() {
        if (this._currToken == 3) {
            return this._currName.i();
        }
        throw new IllegalStateException(i.e.a.i.b.g);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getPrefix() {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(i.e.a.i.b.f);
        }
        String strK = this._currName.k();
        return strK == null ? "" : strK;
    }

    public final String getPrefixedName() {
        int i2 = this._currToken;
        if (i2 == 1 || i2 == 2) {
            return this._currName.l();
        }
        if (i2 == 3) {
            return getPITarget();
        }
        if (i2 == 9) {
            return getLocalName();
        }
        if (i2 == 11) {
            return getDTDRootName();
        }
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT, ENTITY_REFERENCE, PROCESSING_INSTRUCTION or DTD");
    }

    @Override // n.b.a.b
    public final Object getProcessedDTD() {
        return null;
    }

    public final n.b.a.p.a getProcessedDTDSchema() {
        return null;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        return str.equals("org.apache.poi.javax.xml.stream.entities") ? Collections.EMPTY_LIST : str.equals("org.apache.poi.javax.xml.stream.notations") ? Collections.EMPTY_LIST : this._scanner.C().a(str, false);
    }

    public e0 getScanner() {
        return this._scanner;
    }

    public final h getStartLocation() {
        return this._scanner.N();
    }

    public final long getStartingByteOffset() {
        return this._scanner.O();
    }

    public final long getStartingCharOffset() {
        return this._scanner.P();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getText() {
        int i2 = this._currToken;
        if (((1 << i2) & MASK_GET_TEXT) == 0) {
            throwNotTextual(i2);
        }
        try {
            return this._scanner.getText();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final char[] getTextCharacters() {
        int i2 = this._currToken;
        if (((1 << i2) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i2);
        }
        try {
            return this._scanner.getTextCharacters();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getTextLength() {
        int i2 = this._currToken;
        if (((1 << i2) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i2);
        }
        try {
            return this._scanner.getTextLength();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getTextStart() {
        int i2 = this._currToken;
        if (((1 << i2) & MASK_GET_TEXT_XXX) != 0) {
            return 0;
        }
        throwNotTextXxx(i2);
        return 0;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this._scanner.C().N();
    }

    protected int handlePrologEoi(boolean z) throws XMLStreamException {
        close();
        if (!z) {
            return 8;
        }
        throwUnexpectedEOI(i.e.a.i.b.f1562i);
        return 8;
    }

    protected void handleTreeEoi() throws XMLStreamException {
        this._currToken = 8;
        throwUnexpectedEOI(i.e.a.i.b.f1564k);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean hasName() {
        int i2 = this._currToken;
        return i2 == 1 || i2 == 2;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean hasNext() {
        return this._currToken != 8;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean hasText() {
        return ((1 << this._currToken) & MASK_GET_TEXT) != 0;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isAttributeSpecified(int i2) {
        if (this._currToken == 1) {
            return this._scanner.T(i2);
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isCharacters() {
        return getEventType() == 4;
    }

    public final boolean isEmptyElement() throws XMLStreamException {
        if (this._currToken == 1) {
            return this._scanner.U();
        }
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isEndElement() {
        return this._currToken == 2;
    }

    public final boolean isPropertySupported(String str) {
        return this._scanner.C().e(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isStandalone() {
        return this._scanner.C().M() == 1;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isStartElement() {
        return this._currToken == 1;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean isWhiteSpace() {
        int i2 = this._currToken;
        if (i2 != 4 && i2 != 12) {
            return i2 == 6;
        }
        try {
            return this._scanner.V();
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int next() throws XMLStreamException {
        int iZ;
        int i2 = this._parseState;
        if (i2 == 1) {
            int iA0 = this._scanner.a0();
            if (iA0 == -1) {
                handleTreeEoi();
            }
            this._currToken = iA0;
            if (iA0 != 12) {
                this._currName = this._scanner.K();
                if (iA0 == 2) {
                    if (this._scanner.S()) {
                        this._parseState = 2;
                    }
                } else if (iA0 == 1) {
                    this._attrCount = this._scanner.u();
                }
            } else if (this._cfgCoalesceText || this._cfgReportTextAsChars) {
                return 4;
            }
            return iA0;
        }
        if (i2 == 0) {
            iZ = this._scanner.Z(true);
            if (iZ == 1) {
                this._parseState = 1;
                this._attrCount = this._scanner.u();
            } else if (iZ == 11) {
                if (this._dtdRootName != null) {
                    throwWfe("Duplicate DOCTYPE declaration");
                }
                this._dtdRootName = this._scanner.K();
            }
        } else {
            if (i2 != 2) {
                throw new NoSuchElementException();
            }
            iZ = this._scanner.Z(false);
        }
        if (iZ < 0) {
            return handlePrologEoi(this._parseState == 0);
        }
        this._currName = this._scanner.K();
        this._currToken = iZ;
        return iZ;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int nextTag() throws XMLStreamException {
        while (true) {
            int next = next();
            if (next != 12) {
                switch (next) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 4:
                        break;
                    default:
                        throwWfe("Received event " + i.e.a.i.b.c(next) + ", instead of START_ELEMENT or END_ELEMENT.");
                }
                return next;
            }
            if (!isWhiteSpace()) {
                throwWfe("Received non-all-whitespace CHARACTERS or CDATA event in nextTag().");
                throwWfe("Received event " + i.e.a.i.b.c(next) + ", instead of START_ELEMENT or END_ELEMENT.");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        if (r12.b() == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0058 -> B:37:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int readElementAsArray(n.b.a.n.c cVar) throws XMLStreamException {
        boolean z;
        int next = this._currToken;
        if (((1 << next) & MASK_TYPED_ACCESS_ARRAY) == 0) {
            throw new IllegalStateException(i.e.a.i.b.f1561h);
        }
        int iK = 0;
        if (next == 1) {
            if (this._scanner.U()) {
                next();
                return -1;
            }
            while (true) {
                next = next();
                if (next == 2) {
                    return -1;
                }
                if (next != 5 && next != 3) {
                    if (next != 4 && next != 12) {
                        throw _constructUnexpectedInTyped(next);
                    }
                }
            }
            z = true;
            if (next != 2) {
                if (next == 4 || next == 12 || next == 6) {
                    iK += this._scanner.k(cVar, z);
                } else if (next != 5 && next != 3) {
                    throw _constructUnexpectedInTyped(next);
                }
                next = next();
                z = true;
                if (next != 2) {
                }
            }
            if (iK <= 0) {
                return iK;
            }
            return -1;
        }
        z = false;
        if (next != 2) {
        }
        if (iK <= 0) {
        }
    }

    public final int readElementAsBinary(byte[] bArr, int i2, int i3) throws XMLStreamException {
        return readElementAsBinary(bArr, i2, i3, n.b.a.n.b.a());
    }

    public final int readElementAsDoubleArray(double[] dArr, int i2, int i3) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().d(dArr, i2, i3));
    }

    public final int readElementAsFloatArray(float[] fArr, int i2, int i3) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().g(fArr, i2, i3));
    }

    public final int readElementAsIntArray(int[] iArr, int i2, int i3) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().j(iArr, i2, i3));
    }

    public final int readElementAsLongArray(long[] jArr, int i2, int i3) throws XMLStreamException {
        return readElementAsArray(_decoderFactory().n(jArr, i2, i3));
    }

    protected void reportInvalidAttrIndex(int i2) {
        throw new IllegalArgumentException("Illegal attribute index, " + i2 + ", current START_ELEMENT has " + this._attrCount + " attributes");
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final void require(int i2, String str, String str2) throws XMLStreamException {
        int i3 = this._currToken;
        if (i3 != i2 && i3 == 12 && (this._cfgCoalesceText || this._cfgReportTextAsChars)) {
            i3 = 4;
        }
        if (i2 != i3) {
            throwWfe("Expected type " + i.e.a.i.b.c(i2) + ", current type " + i.e.a.i.b.c(i3));
        }
        if (str2 != null) {
            if (i3 != 1 && i3 != 2 && i3 != 9) {
                throwWfe("Expected non-null local name, but current token not a START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE (was " + i.e.a.i.b.c(this._currToken) + ")");
            }
            String localName = getLocalName();
            if (localName != str2 && !localName.equals(str2)) {
                throwWfe("Expected local name '" + str2 + "'; current local name '" + localName + "'.");
            }
        }
        if (str != null) {
            if (i3 != 1 && i3 != 2) {
                throwWfe("Expected non-null NS URI, but current token not a START_ELEMENT or END_ELEMENT (was " + i.e.a.i.b.c(i3) + ")");
            }
            String namespaceURI = getNamespaceURI();
            if (str.length() == 0) {
                if (namespaceURI == null || namespaceURI.length() <= 0) {
                    return;
                }
                throwWfe("Expected empty namespace, instead have '" + namespaceURI + "'.");
                return;
            }
            if (str == namespaceURI || str.equals(namespaceURI)) {
                return;
            }
            throwWfe("Expected namespace '" + str + "'; have '" + namespaceURI + "'.");
        }
    }

    @Deprecated
    public final void setFeature(String str, Object obj) {
    }

    public final boolean setProperty(String str, Object obj) {
        return this._scanner.C().g(str, obj);
    }

    public final n.b.a.p.b setValidationProblemHandler(n.b.a.p.b bVar) {
        return null;
    }

    public final void skipElement() throws XMLStreamException {
        if (this._currToken != 1) {
            throw new IllegalStateException(i.e.a.i.b.e);
        }
        int i2 = 1;
        while (true) {
            int next = next();
            if (next == 1) {
                i2++;
            } else if (next == 2 && i2 - 1 == 0) {
                return;
            }
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final boolean standaloneSet() {
        return this._scanner.C().M() != 0;
    }

    public final f stopValidatingAgainst(n.b.a.p.e eVar) throws XMLStreamException {
        return null;
    }

    public final f stopValidatingAgainst(f fVar) throws XMLStreamException {
        return null;
    }

    protected void throwFromIOE(IOException iOException) throws XMLStreamException {
        throw new i.e.a.i.c(iOException);
    }

    protected void throwUnexpectedEOI(String str) throws XMLStreamException {
        throwWfe("Unexpected End-of-input" + str);
    }

    protected void throwWfe(String str) throws XMLStreamException {
        throw new i.e.a.e(str, getLastCharLocation());
    }

    public final String toString() {
        return "[Aalto stream reader, scanner: " + this._scanner + "]";
    }

    public final f validateAgainst(n.b.a.p.e eVar) throws XMLStreamException {
        return null;
    }

    protected QName verifyQName(QName qName) throws e {
        String str;
        String localPart = qName.getLocalPart();
        int iA = q.a(localPart, false);
        if (iA < 0) {
            return qName;
        }
        String prefix = qName.getPrefix();
        if (prefix == null || prefix.length() <= 0) {
            str = localPart;
        } else {
            str = prefix + ParameterizedMessage.ERROR_MSG_SEPARATOR + localPart;
        }
        throw _constructTypeException("Invalid local name \"" + localPart + "\" (character at #" + iA + " is invalid)", str);
    }

    private e _constructTypeException(String str, String str2) {
        return new e(str2, str, getStartLocation());
    }

    public final byte[] getAttributeAsBinary(int i2, n.b.a.n.a aVar) throws XMLStreamException {
        if (this._currToken == 1) {
            return this._scanner.h(i2, aVar, _base64Decoder());
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    public final byte[] getElementAsBinary(n.b.a.n.a aVar) throws XMLStreamException {
        i.a aVarD = _base64Decoder().d();
        byte[] bArrC = aVarD.c();
        while (true) {
            int i2 = 0;
            int length = bArrC.length;
            do {
                int elementAsBinary = readElementAsBinary(bArrC, i2, length, aVar);
                if (elementAsBinary < 1) {
                    return aVarD.b(bArrC, i2);
                }
                i2 += elementAsBinary;
                length -= elementAsBinary;
            } while (length > 0);
            bArrC = aVarD.a(bArrC);
        }
    }

    public final int readElementAsBinary(byte[] bArr, int i2, int i3, n.b.a.n.a aVar) throws XMLStreamException {
        int next;
        if (bArr == null) {
            throw new IllegalArgumentException("resultBuffer is null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal offset (" + i2 + "), must be [0, " + bArr.length + "[");
        }
        if (i3 < 1 || i2 + i3 > bArr.length) {
            if (i3 == 0) {
                return 0;
            }
            throw new IllegalArgumentException("Illegal maxLength (" + i3 + "), has to be positive number, and offset+maxLength can not exceed" + bArr.length);
        }
        n.b.a.m.o.b bVar_base64Decoder = _base64Decoder();
        int i4 = this._currToken;
        if (((1 << i4) & MASK_TYPED_ACCESS_BINARY) == 0) {
            if (i4 != 2) {
                throw new IllegalStateException(i.e.a.i.b.f1561h);
            }
            if (!bVar_base64Decoder.e()) {
                return -1;
            }
        } else if (i4 == 1) {
            if (this._scanner.U()) {
                next();
                return -1;
            }
            while (true) {
                int next2 = next();
                if (next2 == 2) {
                    return -1;
                }
                if (next2 != 5 && next2 != 3) {
                    if (next2 != 4 && next2 != 12) {
                        throw _constructUnexpectedInTyped(next2);
                    }
                    this._scanner.v0(aVar, bVar_base64Decoder, true);
                }
            }
        }
        int i5 = 0;
        while (true) {
            try {
                int iA = bVar_base64Decoder.a(bArr, i2, i3);
                i2 += iA;
                i5 += iA;
                i3 -= iA;
                if (i3 < 1 || this._currToken == 2) {
                    break;
                }
                while (true) {
                    next = next();
                    if (next != 5 && next != 3 && next != 6) {
                        break;
                    }
                }
                if (next == 2) {
                    int iC = bVar_base64Decoder.c();
                    if (iC < 0) {
                        throw _constructTypeException("Incomplete base64 triplet at the end of decoded content", "");
                    }
                    if (iC <= 0) {
                        break;
                    }
                } else {
                    this._scanner.v0(aVar, bVar_base64Decoder, false);
                }
            } catch (IllegalArgumentException e) {
                throw _constructTypeException(e.getMessage(), "");
            }
        }
        if (i5 > 0) {
            return i5;
        }
        return -1;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getNamespaceURI(int i2) {
        int i3 = this._currToken;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalStateException(i.e.a.i.b.f);
        }
        String namespaceURI = this._scanner.getNamespaceURI(i2);
        return namespaceURI == null ? "" : namespaceURI;
    }

    public final int getText(Writer writer, boolean z) throws XMLStreamException {
        int i2 = this._currToken;
        if (((1 << i2) & MASK_GET_TEXT_WITH_WRITER) == 0) {
            throwNotTextual(i2);
        }
        return this._scanner.Q(writer, z);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final int getTextCharacters(int i2, char[] cArr, int i3, int i4) {
        int i5 = this._currToken;
        if (((1 << i5) & MASK_GET_TEXT_XXX) == 0) {
            throwNotTextXxx(i5);
        }
        try {
            return this._scanner.getTextCharacters(i2, cArr, i3, i4);
        } catch (XMLStreamException e) {
            throw i.e.a.c.a(e);
        }
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getAttributeValue(String str, String str2) {
        if (this._currToken == 1) {
            return this._scanner.B(str, str2);
        }
        throw new IllegalStateException(i.e.a.i.b.e);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public final String getNamespaceURI(String str) {
        int i2 = this._currToken;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException(i.e.a.i.b.f);
        }
        return this._scanner.getNamespaceURI(str);
    }
}
