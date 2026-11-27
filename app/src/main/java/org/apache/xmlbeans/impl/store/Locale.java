package org.apache.xmlbeans.impl.store;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameCache;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.SAXHelper;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Saaj;
import org.apache.xmlbeans.impl.util.ExceptionUtil;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes.dex */
public final class Locale implements DOMImplementation, Saaj.SaajCallback, XmlLocale {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _xml1998Uri = "http://www.w3.org/XML/1998/namespace";
    static final String _xmlnsUri = "http://www.w3.org/2000/xmlns/";
    int _cchSrc;
    ChangeListener _changeListeners;
    private CharUtil _charUtil;
    Cur _curPool;
    int _curPoolCount;
    private int _entryCount;
    Cur.Locations _locations;
    boolean _noSync;
    int _numTempFramesLeft;
    int _offSrc;
    DomImpl.Dom _ownerDoc;
    int _posTemp;
    QNameFactory _qnameFactory;
    private ReferenceQueue<Ref> _refQueue;
    Cur _registered;
    Saaj _saaj;
    SchemaTypeLoader _schemaTypeLoader;
    Cur[] _tempFrames;
    boolean _validateOnSet;
    long _versionAll;
    long _versionSansText;
    private static final Logger LOG = XmlBeansLogManager.getLogger(Locale.class);
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiNil = new QName(_xsi, "nil", "xsi");
    static final QName _xsiType = new QName(_xsi, SocialConstants.PARAM_TYPE, "xsi");
    static final QName _xsiLoc = new QName(_xsi, "schemaLocation", "xsi");
    static final QName _xsiNoLoc = new QName(_xsi, "noNamespaceSchemaLocation", "xsi");
    static final String _openFragUri = "http://www.openuri.org/fragment";
    static final QName _openuriFragment = new QName(_openFragUri, "fragment", "frag");
    static final QName _xmlFragment = new QName("xml-fragment");
    private static final ThreadLocal<SoftReference<ScrubBuffer>> tl_scrubBuffer = ThreadLocal.withInitial(new Supplier() { // from class: org.apache.xmlbeans.impl.store.z6
        @Override // java.util.function.Supplier
        public final Object get() {
            return Locale.h();
        }
    });
    nthCache _nthCache_A = new nthCache();
    nthCache _nthCache_B = new nthCache();
    domNthCache _domNthCache_A = new domNthCache();
    domNthCache _domNthCache_B = new domNthCache();

    interface ChangeListener {
        ChangeListener getNextChangeListener();

        void notifyChange();

        void setNextChangeListener(ChangeListener changeListener);
    }

    private static class DefaultEntityResolver implements EntityResolver {
        private DefaultEntityResolver() {
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            return new InputSource(new StringReader(""));
        }
    }

    private static final class DefaultQNameFactory implements QNameFactory {
        private final QNameCache _cache;

        private DefaultQNameFactory() {
            this._cache = XmlBeans.getQNameCache();
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2) {
            return this._cache.getName(str, str2, "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(String str, String str2, String str3) {
            return this._cache.getName(str, str2, str3);
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5) {
            return this._cache.getName(new String(cArr, i2, i3), new String(cArr2, i4, i5), "");
        }

        @Override // org.apache.xmlbeans.impl.store.QNameFactory
        public QName getQName(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, char[] cArr3, int i6, int i7) {
            return this._cache.getName(new String(cArr, i2, i3), new String(cArr2, i4, i5), new String(cArr3, i6, i7));
        }
    }

    private static class DocProps extends XmlDocumentProperties {
        private final HashMap<Object, Object> _map;

        private DocProps() {
            this._map = new HashMap<>();
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object get(Object obj) {
            return this._map.get(obj);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object put(Object obj, Object obj2) {
            return this._map.put(obj, obj2);
        }

        @Override // org.apache.xmlbeans.XmlDocumentProperties
        public Object remove(Object obj) {
            return this._map.remove(obj);
        }
    }

    public static abstract class LoadContext {
        private Hashtable<String, String> _idAttrs;

        protected abstract void abort();

        protected void addIdAttr(String str, String str2) {
            if (this._idAttrs == null) {
                this._idAttrs = new Hashtable<>();
            }
            this._idAttrs.put(str2, str);
        }

        protected abstract void attr(String str, String str2, String str3, String str4);

        public abstract void attr(QName qName, String str);

        protected abstract void bookmark(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void bookmarkLastNonAttr(XmlCursor.XmlBookmark xmlBookmark);

        protected abstract void comment(String str);

        protected abstract void comment(char[] cArr, int i2, int i3);

        protected abstract void endDTD();

        protected abstract void endElement();

        public abstract Cur finish();

        protected boolean isAttrOfTypeId(QName qName, QName qName2) {
            if (this._idAttrs == null) {
                return "id".equalsIgnoreCase(qName.getLocalPart());
            }
            String prefix = qName.getPrefix();
            String localPart = qName.getLocalPart();
            if (!"".equals(prefix)) {
                localPart = prefix + ParameterizedMessage.ERROR_MSG_SEPARATOR + localPart;
            }
            String str = this._idAttrs.get(localPart);
            if (str == null) {
                return false;
            }
            String prefix2 = qName2.getPrefix();
            String localPart2 = qName2.getLocalPart();
            if (!"".equals(prefix2)) {
                localPart2 = prefix2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + localPart2;
            }
            return str.equals(localPart2);
        }

        protected abstract void lineNumber(int i2, int i3, int i4);

        protected abstract void procInst(String str, String str2);

        protected abstract void startDTD(String str, String str2, String str3);

        protected abstract void startElement(QName qName);

        protected abstract void text(String str);

        protected abstract void text(char[] cArr, int i2, int i3);

        protected abstract void xmlns(String str, String str2);
    }

    static final class Ref extends PhantomReference {
        Cur _cur;

        Ref(Cur cur, Object obj) {
            super(obj, cur._locale.refQueue());
            this._cur = cur;
        }
    }

    private static abstract class SaxHandler implements ContentHandler, LexicalHandler, DeclHandler, DTDHandler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected LoadContext _context;
        protected Locale _locale;
        private Locator _startLocator;
        private boolean _wantCdataBookmarks;
        private boolean _wantLineNumbers;
        private boolean _wantLineNumbersAtEndElt;
        private boolean _insideCDATA = false;
        private int _entityBytesLimit = 10240;
        private int _entityBytes = 0;
        private int _insideEntity = 0;
        private Map<String, String> delayedPrefixMappings = new LinkedHashMap();

        SaxHandler(Locator locator) {
            this._startLocator = locator;
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void attributeDecl(String str, String str2, String str3, String str4, String str5) {
            if (str3.equals("ID")) {
                this._context.addIdAttr(str, str2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i2, int i3) throws SAXException {
            this._context.text(cArr, i2, i3);
            if (this._wantCdataBookmarks && this._insideCDATA && this._startLocator != null) {
                this._context.bookmarkLastNonAttr(CDataBookmark.CDATA_BOOKMARK);
            }
            if (this._insideEntity != 0) {
                int i4 = this._entityBytes + i3;
                this._entityBytes = i4;
                int i5 = this._entityBytesLimit;
                if (i4 > i5) {
                    throw new SAXException(XmlError.forMessage(XmlErrorCodes.EXCEPTION_EXCEEDED_ENTITY_BYTES, new Integer[]{Integer.valueOf(i5)}).getMessage());
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i2, int i3) throws SAXException {
            this._context.comment(cArr, i2, i3);
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void elementDecl(String str, String str2) {
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() {
            this._insideCDATA = false;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() {
            this._context.endDTD();
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            Locator locator;
            this._context.endElement();
            if (!this._wantLineNumbersAtEndElt || (locator = this._startLocator) == null) {
                return;
            }
            this._context.bookmark(new XmlLineNumber(locator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) throws SAXException {
            int i2 = this._insideEntity - 1;
            this._insideEntity = i2;
            if (i2 == 0) {
                this._entityBytes = 0;
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void externalEntityDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i2, int i3) {
        }

        void initSaxHandler(Locale locale, XmlOptions xmlOptions) {
            this._locale = locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            this._context = new Cur.CurLoadContext(this._locale, xmlOptionsMaskNull);
            this._wantLineNumbers = xmlOptionsMaskNull.isLoadLineNumbers();
            this._wantLineNumbersAtEndElt = xmlOptionsMaskNull.isLoadLineNumbersEndElement();
            this._wantCdataBookmarks = xmlOptionsMaskNull.isUseCDataBookmarks();
            Integer loadEntityBytesLimit = xmlOptionsMaskNull.getLoadEntityBytesLimit();
            if (loadEntityBytesLimit != null) {
                this._entityBytesLimit = loadEntityBytesLimit.intValue();
            }
        }

        @Override // org.xml.sax.ext.DeclHandler
        public void internalEntityDecl(String str, String str2) {
        }

        @Override // org.xml.sax.DTDHandler
        public void notationDecl(String str, String str2, String str3) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            this._context.procInst(str, str2);
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            if (this._startLocator == null) {
                this._startLocator = locator;
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() {
            this._insideCDATA = true;
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) throws SAXException {
            this._context.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            Locator locator;
            if (str3.indexOf(58) >= 0 && str.isEmpty()) {
                XmlError xmlErrorForMessage = XmlError.forMessage("Use of undefined namespace prefix: " + str3.substring(0, str3.indexOf(58)));
                throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
            }
            this._context.startElement(this._locale.makeQualifiedQName(str, str3));
            if (this._wantLineNumbers && (locator = this._startLocator) != null) {
                this._context.bookmark(new XmlLineNumber(locator.getLineNumber(), this._startLocator.getColumnNumber() - 1, -1));
            }
            for (Map.Entry<String, String> entry : this.delayedPrefixMappings.entrySet()) {
                this._context.xmlns(entry.getKey(), entry.getValue());
            }
            this.delayedPrefixMappings.clear();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                String qName = attributes.getQName(i2);
                int iIndexOf = qName.indexOf(58);
                if (iIndexOf < 0) {
                    this._context.attr(qName, attributes.getURI(i2), null, attributes.getValue(i2));
                } else {
                    this._context.attr(qName.substring(iIndexOf + 1), attributes.getURI(i2), qName.substring(0, iIndexOf), attributes.getValue(i2));
                }
            }
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) throws SAXException {
            this._insideEntity++;
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
            if (!Locale.beginsWithXml(str) || ("xml".equals(str) && "http://www.w3.org/XML/1998/namespace".equals(str2))) {
                this.delayedPrefixMappings.put(str, str2);
                return;
            }
            XmlError xmlErrorForMessage = XmlError.forMessage("Prefix can't begin with XML: " + str, 0);
            throw new XmlRuntimeException(xmlErrorForMessage.toString(), (Throwable) null, xmlErrorForMessage);
        }

        @Override // org.xml.sax.DTDHandler
        public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class SaxLoader extends SaxHandler implements ErrorHandler {
        private final XMLReader _xr;

        SaxLoader(XMLReader xMLReader, Locator locator) {
            super(locator);
            this._xr = xMLReader;
            try {
                xMLReader.setFeature("http://xml.org/sax/features/namespaces", true);
                xMLReader.setFeature("http://xml.org/sax/features/validation", false);
                xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
                xMLReader.setContentHandler(this);
                xMLReader.setDTDHandler(this);
                xMLReader.setErrorHandler(this);
                try {
                    xMLReader.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
                } catch (Throwable th) {
                    if (ExceptionUtil.isFatal(th)) {
                        ExceptionUtil.rethrow(th);
                    }
                    Locale.LOG.atWarn().withThrowable(th).log("Secure Processing Feature is not supported");
                }
                try {
                    this._xr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
                } catch (Throwable th2) {
                    if (ExceptionUtil.isFatal(th2)) {
                        ExceptionUtil.rethrow(th2);
                    }
                    Locale.LOG.atWarn().withThrowable(th2).log("SAX Declaration Handler is not supported");
                }
            } catch (Throwable th3) {
                if (ExceptionUtil.isFatal(th3)) {
                    ExceptionUtil.rethrow(th3);
                }
                throw new RuntimeException(th3.getMessage(), th3);
            }
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }

        public Cur load(Locale locale, InputSource inputSource, XmlOptions xmlOptions) throws XmlException, SAXException, IOException {
            inputSource.setSystemId("file://");
            initSaxHandler(locale, xmlOptions);
            try {
                this._xr.parse(inputSource);
                Cur curFinish = this._context.finish();
                Locale.associateSourceName(curFinish, xmlOptions);
                postLoad(curFinish);
                return curFinish;
            } catch (XmlRuntimeException e) {
                this._context.abort();
                throw new XmlException(e);
            } catch (RuntimeException e2) {
                this._context.abort();
                throw e2;
            } catch (SAXParseException e3) {
                this._context.abort();
                XmlError xmlErrorForLocation = XmlError.forLocation(e3.getMessage(), xmlOptions == null ? null : xmlOptions.getDocumentSourceName(), e3.getLineNumber(), e3.getColumnNumber(), -1);
                throw new XmlException(xmlErrorForLocation.toString(), e3, xmlErrorForLocation);
            } catch (SAXException e4) {
                this._context.abort();
                XmlError xmlErrorForMessage = XmlError.forMessage(e4.getMessage());
                throw new XmlException(xmlErrorForMessage.toString(), e4, xmlErrorForMessage);
            }
        }

        void postLoad(Cur cur) {
            this._locale = null;
            this._context = null;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            throw sAXParseException;
        }
    }

    static final class ScrubBuffer {
        private static final int NOSPACE_STATE = 2;
        private static final int SPACE_SEEN_STATE = 1;
        private static final int START_STATE = 0;
        private int _state;
        private int _wsr;
        private char[] _srcBuf = new char[1024];
        private final StringBuffer _sb = new StringBuffer();

        ScrubBuffer() {
        }

        String getResultAsString() {
            return this._sb.toString();
        }

        void init(int i2) {
            StringBuffer stringBuffer = this._sb;
            stringBuffer.delete(0, stringBuffer.length());
            this._wsr = i2;
            this._state = 0;
        }

        void scrub(Object obj, int i2, int i3) {
            char[] cArr;
            if (i3 == 0) {
                return;
            }
            if (this._wsr == 1) {
                CharUtil.getString(this._sb, obj, i2, i3);
                return;
            }
            if (obj instanceof char[]) {
                cArr = (char[]) obj;
            } else {
                char[] cArr2 = this._srcBuf;
                if (i3 > cArr2.length) {
                    if (i3 <= 16384) {
                        cArr2 = new char[16384];
                        this._srcBuf = cArr2;
                    } else {
                        cArr2 = new char[i3];
                    }
                }
                CharUtil.getChars(cArr2, 0, obj, i2, i3);
                cArr = cArr2;
                i2 = 0;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                char c = cArr[i2 + i5];
                if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                    this._sb.append(cArr, i2 + i4, i5 - i4);
                    i4 = i5 + 1;
                    if (this._wsr == 2) {
                        this._sb.append(Chars.SPACE);
                    } else if (this._state == 2) {
                        this._state = 1;
                    }
                } else {
                    if (this._state == 1) {
                        this._sb.append(Chars.SPACE);
                    }
                    this._state = 2;
                }
            }
            this._sb.append(cArr, i2 + i4, i3 - i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface SyncWrapFun<T> {
        T parse(Locale locale) throws XmlException, IOException;
    }

    private static class XmlReaderSaxLoader extends SaxLoader {
        XmlReaderSaxLoader(XMLReader xMLReader) {
            super(xMLReader, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class XmlSaxHandlerImpl extends SaxHandler implements XmlSaxHandler {
        private final XmlOptions _options;
        private final SchemaType _type;

        XmlSaxHandlerImpl(Locale locale, SchemaType schemaType, XmlOptions xmlOptions) {
            super(null);
            this._options = xmlOptions;
            this._type = schemaType;
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setLoadUseLocaleCharUtil(true);
            initSaxHandler(locale, xmlOptions2);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastAttr(qName, xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark) {
            this._context.bookmarkLastNonAttr(xmlBookmark);
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public ContentHandler getContentHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public LexicalHandler getLexicalHandler() {
            if (this._context == null) {
                return null;
            }
            return this;
        }

        @Override // org.apache.xmlbeans.XmlSaxHandler
        public XmlObject getObject() throws XmlException {
            if (this._context == null) {
                return null;
            }
            this._locale.enter();
            try {
                Cur curFinish = this._context.finish();
                Locale.autoTypeDocument(curFinish, this._type, this._options);
                XmlObject xmlObject = (XmlObject) curFinish.getUser();
                curFinish.release();
                this._context = null;
                return xmlObject;
            } finally {
                this._locale.exit();
            }
        }
    }

    class domNthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int BLITZ_BOUNDARY = 40;
        private DomImpl.Dom _child;
        private int _len;
        private int _n;
        private DomImpl.Dom _parent;
        private long _version;

        domNthCache() {
        }

        int distance(DomImpl.Dom dom, int i2) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (dom != this._parent) {
                return Integer.MAX_VALUE;
            }
            int i3 = this._n;
            return i2 > i3 ? i2 - i3 : i3 - i2;
        }

        DomImpl.Dom fetch(DomImpl.Dom dom, int i2) {
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
                Node nodeFirstChild = DomImpl.firstChild(this._parent);
                while (true) {
                    DomImpl.Dom dom2 = (DomImpl.Dom) nodeFirstChild;
                    if (dom2 == null) {
                        break;
                    }
                    int i3 = this._n + 1;
                    this._n = i3;
                    if (this._child == null && i2 == i3) {
                        this._child = dom2;
                        break;
                    }
                    nodeFirstChild = DomImpl.nextSibling(dom2);
                }
                return this._child;
            }
            int i4 = this._n;
            if (i4 < 0) {
                return null;
            }
            if (i2 > i4) {
                while (i2 > this._n) {
                    DomImpl.Dom dom3 = (DomImpl.Dom) DomImpl.nextSibling(this._child);
                    if (dom3 == null) {
                        return null;
                    }
                    this._child = dom3;
                    this._n++;
                }
            } else if (i2 < i4) {
                while (i2 < this._n) {
                    DomImpl.Dom dom4 = (DomImpl.Dom) DomImpl.prevSibling(this._child);
                    if (dom4 == null) {
                        return null;
                    }
                    this._child = dom4;
                    this._n--;
                }
            }
            return this._child;
        }

        int length(DomImpl.Dom dom) {
            int i2;
            if (this._version != Locale.this.version() || this._parent != dom) {
                this._parent = dom;
                this._version = Locale.this.version();
                this._child = null;
                this._n = -1;
                this._len = -1;
            }
            if (this._len == -1) {
                DomImpl.Dom dom2 = this._child;
                if (dom2 == null || (i2 = this._n) == -1) {
                    dom2 = (DomImpl.Dom) DomImpl.firstChild(this._parent);
                    this._len = 0;
                    this._child = dom2;
                    this._n = 0;
                } else {
                    this._len = i2;
                }
                while (dom2 != null) {
                    this._len++;
                    dom2 = (DomImpl.Dom) DomImpl.nextSibling(dom2);
                }
            }
            return this._len;
        }
    }

    class nthCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Xobj _child;
        private int _n;
        private QName _name;
        private Xobj _parent;
        private QNameSet _set;
        private long _version;

        nthCache() {
        }

        private boolean cacheSame(QName qName, QNameSet qNameSet) {
            return qNameSet == null ? namesSame(qName, this._name) : setsSame(qNameSet, this._set);
        }

        private boolean nameHit(QName qName, QNameSet qNameSet, QName qName2) {
            return qNameSet == null ? namesSame(qName, qName2) : qNameSet.contains(qName2);
        }

        private boolean namesSame(QName qName, QName qName2) {
            return qName == null || qName.equals(qName2);
        }

        private boolean setsSame(QNameSet qNameSet, QNameSet qNameSet2) {
            return qNameSet != null && qNameSet == qNameSet2;
        }

        int distance(Xobj xobj, QName qName, QNameSet qNameSet, int i2) {
            if (this._version != Locale.this.version()) {
                return 2147483646;
            }
            if (xobj != this._parent || !cacheSame(qName, qNameSet)) {
                return Integer.MAX_VALUE;
            }
            int i3 = this._n;
            return i2 > i3 ? i2 - i3 : i3 - i2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        
            r4._child = r5;
            r4._n++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
        
            r4._child = r5;
            r4._n--;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Xobj fetch(Xobj xobj, QName qName, QNameSet qNameSet, int i2) {
            if (this._version != Locale.this.version() || this._parent != xobj || !cacheSame(qName, qNameSet) || i2 == 0) {
                this._version = Locale.this.version();
                this._parent = xobj;
                this._name = qName;
                this._child = null;
                this._n = -1;
                Xobj xobj2 = xobj._firstChild;
                while (true) {
                    if (xobj2 != null) {
                        if (xobj2.isElem() && nameHit(qName, qNameSet, xobj2._name)) {
                            this._child = xobj2;
                            this._n = 0;
                            break;
                        }
                        xobj2 = xobj2._nextSibling;
                    } else {
                        break;
                    }
                }
            }
            int i3 = this._n;
            if (i3 < 0) {
                return null;
            }
            if (i2 > i3) {
                while (i2 > this._n) {
                    Xobj xobj3 = this._child;
                    while (true) {
                        xobj3 = xobj3._nextSibling;
                        if (xobj3 == null) {
                            return null;
                        }
                        if (!xobj3.isElem() || !nameHit(qName, qNameSet, xobj3._name)) {
                        }
                    }
                }
            } else if (i2 < i3) {
                while (i2 < this._n) {
                    Xobj xobj4 = this._child;
                    while (true) {
                        xobj4 = xobj4._prevSibling;
                        if (xobj4 == null) {
                            return null;
                        }
                        if (!xobj4.isElem() || !nameHit(qName, qNameSet, xobj4._name)) {
                        }
                    }
                }
            }
            return this._child;
        }
    }

    private Locale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._noSync = xmlOptionsMaskNull.isUnsynchronized();
        this._numTempFramesLeft = 8;
        this._tempFrames = new Cur[8];
        this._qnameFactory = new DefaultQNameFactory();
        this._locations = new Cur.Locations(this);
        this._schemaTypeLoader = schemaTypeLoader;
        this._validateOnSet = xmlOptionsMaskNull.isValidateOnSet();
        Saaj saaj = xmlOptionsMaskNull.getSaaj();
        this._saaj = saaj;
        if (saaj != null) {
            saaj.setCallback(this);
        }
    }

    static /* synthetic */ XmlObject a(XmlOptions xmlOptions, SchemaType schemaType, Locale locale) throws XmlException, IOException {
        Cur curTempCur = locale.tempCur();
        SchemaType documentType = XmlOptions.maskNull(xmlOptions).getDocumentType();
        if (documentType == null) {
            if (schemaType == null) {
                schemaType = XmlObject.type;
            }
            documentType = schemaType;
        }
        if (documentType.isDocumentType()) {
            curTempCur.createDomDocumentRoot();
        } else {
            curTempCur.createRoot();
        }
        curTempCur.setType(documentType);
        XmlObject xmlObject = (XmlObject) curTempCur.getUser();
        curTempCur.release();
        return xmlObject;
    }

    private static void addNamespace(StringBuilder sb, QName qName) {
        if (qName.getNamespaceURI() == null) {
            sb.append("<no namespace>");
            return;
        }
        sb.append("\"");
        sb.append(qName.getNamespaceURI());
        sb.append("\"");
    }

    static void applyNamespaces(Cur cur, Map<String, String> map) {
        for (String str : map.keySet()) {
            if (!str.toLowerCase(java.util.Locale.ROOT).startsWith("xml") && cur.namespaceForPrefix(str, false) == null) {
                cur.push();
                cur.next();
                cur.createAttr(cur._locale.createXmlns(str));
                cur.next();
                cur.insertString(map.get(str));
                cur.pop();
            }
        }
    }

    static String applyWhiteSpaceRule(String str, int i2) {
        int i3 = 0;
        int length = str == null ? 0 : str.length();
        if (length == 0) {
            return str;
        }
        int i4 = 1;
        if (i2 == 1) {
            return str;
        }
        if (i2 == 2) {
            while (i3 < length) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t') {
                    return processWhiteSpaceRule(str, i2);
                }
                i3++;
            }
            return str;
        }
        if (i2 != 3) {
            return str;
        }
        if (CharUtil.isWhiteSpace(str.charAt(0)) || CharUtil.isWhiteSpace(str.charAt(length - 1))) {
            return processWhiteSpaceRule(str, i2);
        }
        while (i4 < length) {
            boolean zIsWhiteSpace = CharUtil.isWhiteSpace(str.charAt(i4));
            if (zIsWhiteSpace && i3 != 0) {
                return processWhiteSpaceRule(str, i2);
            }
            i4++;
            i3 = zIsWhiteSpace ? 1 : 0;
        }
        return str;
    }

    public static void associateSourceName(Cur cur, XmlOptions xmlOptions) {
        String documentSourceName = xmlOptions == null ? null : xmlOptions.getDocumentSourceName();
        if (documentSourceName != null) {
            getDocProps(cur, true).setSourceName(documentSourceName);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void autoTypeDocument(Cur cur, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        SchemaType schemaTypeFindType;
        SchemaType documentType = XmlOptions.maskNull(xmlOptions).getDocumentType();
        if (documentType != null) {
            cur.setType(documentType);
            return;
        }
        SchemaType schemaTypeFindAttributeType = null;
        if (schemaType == null || schemaType.getName() != null) {
            QName xsiTypeName = cur.getXsiTypeName();
            schemaTypeFindType = xsiTypeName == null ? null : cur._locale._schemaTypeLoader.findType(xsiTypeName);
            if (schemaType != null && !schemaType.isAssignableFrom(schemaTypeFindType)) {
                schemaTypeFindType = null;
            }
        }
        if (schemaTypeFindType == null && (schemaType == null || schemaType.isDocumentType())) {
            cur.push();
            QName name = (cur.hasAttrs() || !toFirstChildElement(cur) || toNextSiblingElement(cur)) ? null : cur.getName();
            cur.pop();
            if (name != null && (schemaTypeFindType = cur._locale._schemaTypeLoader.findDocumentType(name)) != null && schemaType != null) {
                QName documentElementName = schemaType.getDocumentElementName();
                if (!documentElementName.equals(name) && !schemaType.isValidSubstitution(name)) {
                    throw new XmlException("Element " + QNameHelper.pretty(name) + " is not a valid " + QNameHelper.pretty(documentElementName) + " document or a valid substitution.");
                }
            }
        }
        if (schemaTypeFindType == null && schemaType == null) {
            cur.push();
            if (toFirstNormalAttr(cur) && !toNextNormalAttr(cur)) {
                schemaTypeFindAttributeType = cur._locale._schemaTypeLoader.findAttributeType(cur.getName());
            }
            cur.pop();
            schemaTypeFindType = schemaTypeFindAttributeType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = schemaType;
        }
        if (schemaTypeFindType == null) {
            schemaTypeFindType = XmlBeans.NO_TYPE;
        }
        cur.setType(schemaTypeFindType);
        if (schemaType != null) {
            if (schemaTypeFindType.isDocumentType()) {
                verifyDocumentType(cur, schemaTypeFindType.getDocumentElementName());
            } else if (schemaTypeFindType.isAttributeType()) {
                verifyAttributeType(cur, schemaTypeFindType.getAttributeTypeAttributeName());
            }
        }
    }

    static /* synthetic */ XmlSaxHandlerImpl b(SchemaType schemaType, XmlOptions xmlOptions, Locale locale) throws XmlException, IOException {
        return new XmlSaxHandlerImpl(locale, schemaType, xmlOptions);
    }

    static boolean beginsWithXml(String str) {
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        return str.length() >= 3 && ((cCharAt = str.charAt(0)) == 'x' || cCharAt == 'X') && (((cCharAt2 = str.charAt(1)) == 'm' || cCharAt2 == 'M') && ((cCharAt3 = str.charAt(2)) == 'l' || cCharAt3 == 'L'));
    }

    static /* synthetic */ XmlObject c(String str, XmlOptions xmlOptions, SchemaType schemaType, Locale locale) throws XmlException, IOException {
        StringReader stringReader = new StringReader(str);
        try {
            Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(stringReader), xmlOptions);
            autoTypeDocument(curLoad, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoad.getUser();
            curLoad.release();
            stringReader.close();
            return xmlObject;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private static DomImpl.Dom checkNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        if (node instanceof DomImpl.Dom) {
            return (DomImpl.Dom) node;
        }
        throw new IllegalArgumentException("Node is not an XmlBeans node");
    }

    public static void clearThreadLocals() {
        tl_scrubBuffer.remove();
    }

    static /* synthetic */ XmlObject d(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions, SchemaType schemaType, Locale locale) throws XmlException, IOException {
        try {
            Cur curLoadXMLStreamReader = locale.loadXMLStreamReader(xMLStreamReader, xmlOptions);
            autoTypeDocument(curLoadXMLStreamReader, schemaType, xmlOptions);
            XmlObject xmlObject = (XmlObject) curLoadXMLStreamReader.getUser();
            curLoadXMLStreamReader.release();
            return xmlObject;
        } catch (XMLStreamException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private void doAttributes(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int attributeCount = xMLStreamReader.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            loadContext.attr(xMLStreamReader.getAttributeLocalName(i2), xMLStreamReader.getAttributeNamespace(i2), xMLStreamReader.getAttributePrefix(i2), xMLStreamReader.getAttributeValue(i2));
        }
    }

    private void doNamespaces(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        int namespaceCount = xMLStreamReader.getNamespaceCount();
        for (int i2 = 0; i2 < namespaceCount; i2++) {
            String namespacePrefix = xMLStreamReader.getNamespacePrefix(i2);
            if (namespacePrefix == null || namespacePrefix.isEmpty()) {
                loadContext.attr("xmlns", "http://www.w3.org/2000/xmlns/", null, xMLStreamReader.getNamespaceURI(i2));
            } else {
                loadContext.attr(namespacePrefix, "http://www.w3.org/2000/xmlns/", "xmlns", xMLStreamReader.getNamespaceURI(i2));
            }
        }
    }

    static /* synthetic */ XmlObject e(XmlOptions xmlOptions, InputStream inputStream, SchemaType schemaType, Locale locale) throws XmlException, SAXException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(inputStream), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    static /* synthetic */ XmlObject f(XmlOptions xmlOptions, Reader reader, SchemaType schemaType, Locale locale) throws XmlException, SAXException, IOException {
        Cur curLoad = getSaxLoader(xmlOptions).load(locale, new InputSource(reader), xmlOptions);
        autoTypeDocument(curLoad, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curLoad.getUser();
        curLoad.release();
        return xmlObject;
    }

    static /* synthetic */ XmlObject g(XmlOptions xmlOptions, Node node, SchemaType schemaType, Locale locale) throws XmlException, DOMException, IOException {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, xmlOptions);
        locale.loadNode(node, curLoadContext);
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptions);
        autoTypeDocument(curFinish, schemaType, xmlOptions);
        XmlObject xmlObject = (XmlObject) curFinish.getUser();
        curFinish.release();
        return xmlObject;
    }

    static Map<String, String> getAllNamespaces(Cur cur, Map<String, String> map) {
        cur.push();
        if (!cur.isContainer()) {
            cur.toParent();
        }
        while (true) {
            if (!cur.toNextAttr()) {
                if (!cur.isContainer()) {
                    cur.toParentRaw();
                }
                if (!cur.toParentRaw()) {
                    cur.pop();
                    return map;
                }
            } else if (cur.isXmlns()) {
                String xmlnsPrefix = cur.getXmlnsPrefix();
                String xmlnsUri = cur.getXmlnsUri();
                if (map == null) {
                    map = new HashMap<>();
                }
                if (!map.containsKey(xmlnsPrefix)) {
                    map.put(xmlnsPrefix, xmlnsUri);
                }
            }
        }
    }

    static XmlDocumentProperties getDocProps(Cur cur, boolean z) {
        cur.push();
        while (cur.toParent()) {
        }
        DocProps docProps = (DocProps) cur.getBookmark(DocProps.class);
        if (docProps == null && z) {
            docProps = new DocProps();
            cur.setBookmark(DocProps.class, docProps);
        }
        cur.pop();
        return docProps;
    }

    public static Locale getLocale(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        Locale locale;
        if (schemaTypeLoader == null) {
            schemaTypeLoader = XmlBeans.getContextTypeLoader();
        }
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        Object useSameLocale = xmlOptionsMaskNull.getUseSameLocale();
        if (useSameLocale == null) {
            return new Locale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        if (useSameLocale instanceof Locale) {
            locale = (Locale) useSameLocale;
        } else {
            if (!(useSameLocale instanceof XmlTokenSource)) {
                throw new IllegalArgumentException("Source locale not understood: " + useSameLocale);
            }
            locale = (Locale) ((XmlTokenSource) useSameLocale).monitor();
        }
        if (locale._schemaTypeLoader != schemaTypeLoader) {
            throw new IllegalArgumentException("Source locale does not support same schema type loader");
        }
        Saaj saaj = locale._saaj;
        if (saaj != null && saaj != xmlOptionsMaskNull.getSaaj()) {
            throw new IllegalArgumentException("Source locale does not support same saaj");
        }
        if (!locale._validateOnSet || xmlOptionsMaskNull.isValidateOnSet()) {
            return locale;
        }
        throw new IllegalArgumentException("Source locale does not support same validate on set");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SaxLoader getSaxLoader(XmlOptions xmlOptions) throws XmlException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        EntityResolver entityResolver = null;
        Object[] objArr = 0;
        if (!xmlOptionsMaskNull.isLoadUseDefaultResolver()) {
            EntityResolver entityResolver2 = xmlOptionsMaskNull.getEntityResolver();
            if (entityResolver2 == null) {
                entityResolver2 = ResolverUtil.getGlobalEntityResolver();
            }
            if (entityResolver2 == null) {
                entityResolver2 = new DefaultEntityResolver();
            }
            entityResolver = entityResolver2;
        }
        XMLReader loadUseXMLReader = xmlOptionsMaskNull.getLoadUseXMLReader();
        if (loadUseXMLReader == null) {
            try {
                loadUseXMLReader = SAXHelper.newXMLReader(new XmlOptions(xmlOptionsMaskNull));
            } catch (Exception e) {
                throw new XmlException("Problem creating XMLReader", e);
            }
        }
        XmlReaderSaxLoader xmlReaderSaxLoader = new XmlReaderSaxLoader(loadUseXMLReader);
        if (entityResolver != null) {
            loadUseXMLReader.setEntityResolver(entityResolver);
        }
        return xmlReaderSaxLoader;
    }

    static ScrubBuffer getScrubBuffer(int i2) {
        ThreadLocal<SoftReference<ScrubBuffer>> threadLocal = tl_scrubBuffer;
        ScrubBuffer scrubBuffer = threadLocal.get().get();
        if (scrubBuffer == null) {
            scrubBuffer = new ScrubBuffer();
            threadLocal.set(new SoftReference<>(scrubBuffer));
        }
        scrubBuffer.init(i2);
        return scrubBuffer;
    }

    static String getTextValue(Cur cur) {
        if (!cur.hasChildren()) {
            return cur.getValueAsString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        cur.push();
        while (true) {
            cur.next();
            if (cur.isAtEndOfLastPush()) {
                cur.pop();
                return stringBuffer.toString();
            }
            if (cur.isText() && ((!cur._xobj.isComment() && !cur._xobj.isProcinst()) || cur._pos >= cur._xobj._cchValue)) {
                CharUtil.getString(stringBuffer, cur.getChars(-1), cur._offSrc, cur._cchSrc);
            }
        }
    }

    static /* synthetic */ SoftReference h() {
        return new SoftReference(new ScrubBuffer());
    }

    static boolean isFragment(Cur cur, Cur cur2) {
        boolean z;
        int iKind;
        cur.push();
        cur2.push();
        int i2 = 0;
        while (!cur.isSamePos(cur2) && (iKind = cur.kind()) != 3) {
            if ((iKind == 0 && !isWhiteSpace(cur.getCharsAsString())) || (iKind == 2 && (i2 = i2 + 1) > 1)) {
                z = true;
                break;
            }
            if (iKind != 0) {
                cur.toEnd();
            }
            cur.next();
        }
        z = false;
        cur.pop();
        cur2.pop();
        return z || i2 != 1;
    }

    static boolean isFragmentQName(QName qName) {
        return qName.equals(_openuriFragment) || qName.equals(_xmlFragment);
    }

    static boolean isWhiteSpace(String str) {
        int length = str.length();
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (!CharUtil.isWhiteSpace(str.charAt(i2))) {
                return false;
            }
            length = i2;
        }
    }

    static boolean isXmlns(QName qName) {
        String prefix = qName.getPrefix();
        if (prefix.equals("xmlns")) {
            return true;
        }
        return prefix.isEmpty() && qName.getLocalPart().equals("xmlns");
    }

    private static void lineNumber(XMLStreamReader xMLStreamReader, LoadContext loadContext) {
        Location location = xMLStreamReader.getLocation();
        if (location != null) {
            loadContext.lineNumber(location.getLineNumber(), location.getColumnNumber(), location.getCharacterOffset());
        }
    }

    private DomImpl.Dom load(InputSource inputSource, XmlOptions xmlOptions) throws XmlException, IOException {
        return getSaxLoader(xmlOptions).load(this, inputSource, xmlOptions).getDom();
    }

    private void loadNodeChildren(Node node, LoadContext loadContext) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            loadNode(firstChild, loadContext);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Cur loadXMLStreamReader(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XMLStreamException {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean zIsLoadLineNumbers = xmlOptionsMaskNull.isLoadLineNumbers();
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(this, xmlOptionsMaskNull);
        int eventType = xMLStreamReader.getEventType();
        int i2 = 0;
        String str = null;
        String str2 = null;
        boolean z = false;
        while (true) {
            switch (eventType) {
                case 1:
                    i2++;
                    curLoadContext.startElement(xMLStreamReader.getName());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    doAttributes(xMLStreamReader, curLoadContext);
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext() || i2 <= 0) {
                        break;
                    } else {
                        eventType = xMLStreamReader.next();
                    }
                    break;
                case 2:
                    i2--;
                    curLoadContext.endElement();
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                        break;
                    }
                    break;
                case 3:
                    curLoadContext.procInst(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 4:
                case 12:
                    curLoadContext.text(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 5:
                    curLoadContext.comment(xMLStreamReader.getText());
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 6:
                case 11:
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 7:
                    i2++;
                    String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                    String version = xMLStreamReader.getVersion();
                    boolean zIsStandalone = xMLStreamReader.isStandalone();
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                    }
                    str2 = version;
                    z = zIsStandalone;
                    str = characterEncodingScheme;
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 8:
                    if (zIsLoadLineNumbers) {
                        lineNumber(xMLStreamReader, curLoadContext);
                        break;
                    }
                    break;
                case 9:
                    curLoadContext.text(xMLStreamReader.getText());
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 10:
                    doAttributes(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                case 13:
                    doNamespaces(xMLStreamReader, curLoadContext);
                    if (xMLStreamReader.hasNext()) {
                    }
                    break;
                default:
                    throw new RuntimeException("Unhandled xml event type: " + eventType);
            }
        }
        Cur curFinish = curLoadContext.finish();
        associateSourceName(curFinish, xmlOptionsMaskNull);
        XmlDocumentProperties docProps = getDocProps(curFinish, true);
        docProps.setEncoding(str);
        docProps.setVersion(str2);
        docProps.setStandalone(z);
        return curFinish;
    }

    private static boolean namespacesSame(QName qName, QName qName2) {
        if (qName == qName2) {
            return true;
        }
        if (qName == null || qName2 == null) {
            return false;
        }
        return Objects.equals(qName.getNamespaceURI(), qName2.getNamespaceURI());
    }

    public static DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions) {
        return getLocale(schemaTypeLoader, xmlOptions);
    }

    public static XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, final SchemaType schemaType, final XmlOptions xmlOptions) {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.b7
                @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
                public final Object parse(Locale locale) {
                    return Locale.a(xmlOptions, schemaType, locale);
                }
            });
        } catch (IOException | XmlException e) {
            throw new RuntimeException(e);
        }
    }

    public static XmlSaxHandler newSaxHandler(SchemaTypeLoader schemaTypeLoader, final SchemaType schemaType, final XmlOptions xmlOptions) {
        try {
            return (XmlSaxHandler) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.x6
                @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
                public final Object parse(Locale locale) {
                    return Locale.b(schemaType, xmlOptions, locale);
                }
            });
        } catch (IOException | XmlException e) {
            throw new RuntimeException(e);
        }
    }

    public static XmlCursor nodeToCursor(Node node) {
        return DomImpl._getXmlCursor(checkNode(node));
    }

    public static XmlObject nodeToXmlObject(Node node) {
        return DomImpl._getXmlObject(checkNode(node));
    }

    public static XMLStreamReader nodeToXmlStream(Node node) {
        return DomImpl._getXmlStreamReader(checkNode(node));
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, final String str, final SchemaType schemaType, final XmlOptions xmlOptions) throws XmlException {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.c7
                @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
                public final Object parse(Locale locale) {
                    return Locale.c(str, xmlOptions, schemaType, locale);
                }
            });
        } catch (IOException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private void pollQueue() {
        if (this._refQueue == null) {
            return;
        }
        while (true) {
            Ref ref = (Ref) this._refQueue.poll();
            if (ref == null) {
                return;
            }
            Cur cur = ref._cur;
            if (cur != null) {
                cur.release();
            }
        }
    }

    static String processWhiteSpaceRule(String str, int i2) {
        ScrubBuffer scrubBuffer = getScrubBuffer(i2);
        scrubBuffer.scrub(str, 0, str.length());
        return scrubBuffer.getResultAsString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r3.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean pushToContainer(Cur cur) {
        cur.push();
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                break;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        return true;
    }

    public static Node streamToNode(XMLStreamReader xMLStreamReader) {
        return Jsr173.nodeFromStream(xMLStreamReader);
    }

    private static <T> T syncWrap(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, SyncWrapFun<T> syncWrapFun) throws XmlException, IOException {
        T t;
        Locale locale = getLocale(schemaTypeLoader, xmlOptions);
        if (locale.noSync()) {
            locale.enter();
            try {
                return syncWrapFun.parse(locale);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                t = syncWrapFun.parse(locale);
            } finally {
            }
        }
        return t;
    }

    static boolean toChild(Cur cur, QName qName, int i2) {
        if (i2 < 0 || !pushToContainer(cur)) {
            return false;
        }
        Xobj xobjFindNthChildElem = cur._locale.findNthChildElem(cur._xobj, qName, null, i2);
        cur.pop();
        if (xobjFindNthChildElem == null) {
            return false;
        }
        cur.moveTo(xobjFindNthChildElem);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r6.moveTo(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean toFirstChildElement(Cur cur) {
        Xobj xobj = cur._xobj;
        int i2 = cur._pos;
        while (true) {
            int iKind = cur.kind();
            if (iKind == -2 || iKind == -1) {
                break;
            }
            if (iKind == 1 || iKind == 2) {
                break;
            }
            if (iKind == 4 || iKind == 5) {
                cur.skip();
            } else {
                cur.nextWithAttrs();
            }
        }
        if (cur.toFirstChild() && (cur.isElem() || toNextSiblingElement(cur))) {
            return true;
        }
        cur.moveTo(xobj, i2);
        return false;
    }

    static boolean toFirstNormalAttr(Cur cur) {
        cur.push();
        if (cur.toFirstAttr()) {
            while (cur.isXmlns()) {
                if (!cur.toNextAttr()) {
                }
            }
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    static boolean toLastChildElement(Cur cur) {
        if (!pushToContainer(cur)) {
            return false;
        }
        if (cur.toLastChild() && (cur.isElem() || toPrevSiblingElement(cur))) {
            cur.popButStay();
            return true;
        }
        cur.pop();
        return false;
    }

    static boolean toNextNormalAttr(Cur cur) {
        cur.push();
        while (cur.toNextAttr()) {
            if (!cur.isXmlns()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    static boolean toNextSiblingElement(Cur cur) {
        if (!cur.hasParent()) {
            return false;
        }
        cur.push();
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.toParent();
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.pop();
                return false;
            }
            if (iKind2 == 2) {
                cur.popButStay();
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }

    static boolean toPrevNormalAttr(Cur cur) {
        if (!cur.isAttr()) {
            return false;
        }
        cur.push();
        while (cur.prev()) {
            cur.prev();
            if (!cur.isAttr()) {
                cur.prev();
            }
            if (cur.isNormalAttr()) {
                cur.popButStay();
                return true;
            }
        }
        cur.pop();
        return false;
    }

    static boolean toPrevSiblingElement(Cur cur) {
        int iKind;
        boolean z = false;
        if (!cur.hasParent()) {
            return false;
        }
        Cur curTempCur = cur.tempCur();
        if (curTempCur.kind() != 3) {
            while (true) {
                if (!curTempCur.prev() || (iKind = curTempCur.kind()) == 1 || iKind == 2) {
                    break;
                }
                if (curTempCur.kind() == -2) {
                    curTempCur.toParent();
                    cur.moveToCur(curTempCur);
                    z = true;
                    break;
                }
            }
        }
        curTempCur.release();
        return z;
    }

    private static void verifyAttributeType(Cur cur, QName qName) throws XmlException {
        StringBuilder sb;
        cur.push();
        try {
            if (!toFirstNormalAttr(cur) || toNextNormalAttr(cur)) {
                sb = new StringBuilder();
                sb.append("The document is not a ");
                sb.append(QNameHelper.pretty(qName));
                sb.append(cur.isRoot() ? ": no attributes" : ": multiple attributes");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    sb.append("The document is not a ");
                    sb.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        sb.append(": attribute namespace mismatch ");
                        sb.append("expected ");
                        addNamespace(sb, qName);
                        sb.append(" got ");
                        addNamespace(sb, name);
                    } else if (namespacesSame(qName, name)) {
                        sb.append(": attribute local name mismatch ");
                        sb.append("expected ");
                        sb.append(qName.getLocalPart());
                        sb.append(" got ");
                        sb.append(name.getLocalPart());
                    } else {
                        sb.append(": attribute element mismatch ");
                        sb.append("got ");
                        sb.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (sb == null) {
                return;
            }
            XmlError xmlErrorForCursor = XmlError.forCursor(sb.toString(), new Cursor(cur));
            throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
        } finally {
            cur.pop();
        }
    }

    private static void verifyDocumentType(Cur cur, QName qName) throws XmlException {
        StringBuilder sb;
        cur.push();
        try {
            if (!toFirstChildElement(cur) || toNextSiblingElement(cur)) {
                sb = new StringBuilder();
                sb.append("The document is not a ");
                sb.append(QNameHelper.pretty(qName));
                sb.append(cur.isRoot() ? ": no document element" : ": multiple document elements");
            } else {
                QName name = cur.getName();
                if (name.equals(qName)) {
                    sb = null;
                } else {
                    sb = new StringBuilder();
                    sb.append("The document is not a ");
                    sb.append(QNameHelper.pretty(qName));
                    if (qName.getLocalPart().equals(name.getLocalPart())) {
                        sb.append(": document element namespace mismatch ");
                        sb.append("expected ");
                        addNamespace(sb, qName);
                        sb.append(" got ");
                        addNamespace(sb, name);
                    } else if (namespacesSame(qName, name)) {
                        sb.append(": document element local name mismatch expected ");
                        sb.append(qName.getLocalPart());
                        sb.append(" got ");
                        sb.append(name.getLocalPart());
                    } else {
                        sb.append(": document element mismatch got ");
                        sb.append(QNameHelper.pretty(name));
                    }
                }
            }
            if (sb == null) {
                return;
            }
            XmlError xmlErrorForCursor = XmlError.forCursor(sb.toString(), new Cursor(cur));
            throw new XmlException(xmlErrorForCursor.toString(), (Throwable) null, xmlErrorForCursor);
        } finally {
            cur.pop();
        }
    }

    static String xmlnsPrefix(QName qName) {
        return qName.getPrefix().equals("xmlns") ? qName.getLocalPart() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int count(Xobj xobj, QName qName, QNameSet qNameSet) {
        int i2 = 0;
        for (Xobj xobjFindNthChildElem = findNthChildElem(xobj, qName, qNameSet, 0); xobjFindNthChildElem != null; xobjFindNthChildElem = xobjFindNthChildElem._nextSibling) {
            if (xobjFindNthChildElem.isElem()) {
                if (qNameSet == null) {
                    if (xobjFindNthChildElem._name.equals(qName)) {
                        i2++;
                    }
                } else if (qNameSet.contains(xobjFindNthChildElem._name)) {
                }
            }
        }
        return i2;
    }

    CdataNode createCdataNode() {
        return this._saaj == null ? new CdataNode(this) : new SaajCdataNode(this);
    }

    @Override // org.w3c.dom.DOMImplementation
    public Document createDocument(String str, String str2, DocumentType documentType) {
        return DomImpl._domImplementation_createDocument(this, str, str2, documentType);
    }

    @Override // org.w3c.dom.DOMImplementation
    public DocumentType createDocumentType(String str, String str2, String str3) {
        throw new RuntimeException("Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element createSoapElement(QName qName, QName qName2) {
        return DomImpl.saajCallback_createSoapElement(this._ownerDoc, qName, qName2);
    }

    TextNode createTextNode() {
        return this._saaj == null ? new TextNode(this) : new SaajTextNode(this);
    }

    QName createXmlns(String str) {
        if (str == null) {
            str = "";
        }
        return str.isEmpty() ? makeQName("http://www.w3.org/2000/xmlns/", "xmlns", "") : makeQName("http://www.w3.org/2000/xmlns/", str, "xmlns");
    }

    int domLength(DomImpl.Dom dom) {
        if (dom == null) {
            return 0;
        }
        int iDistance = this._domNthCache_A.distance(dom, 0);
        int iDistance2 = this._domNthCache_B.distance(dom, 0);
        int length = iDistance <= iDistance2 ? this._domNthCache_A.length(dom) : this._domNthCache_B.length(dom);
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return length;
    }

    void embedCurs() {
        while (true) {
            Cur cur = this._registered;
            if (cur == null) {
                return;
            }
            this._registered = cur.listRemove(cur);
            Xobj xobj = cur._xobj;
            xobj._embedded = cur.listInsert(xobj._embedded);
            cur._state = 2;
        }
    }

    public void enter(Locale locale) {
        enter();
        if (locale != this) {
            locale.enter();
        }
    }

    boolean entered() {
        return this._tempFrames.length - this._numTempFramesLeft > 0;
    }

    public void exit(Locale locale) {
        exit();
        if (locale != this) {
            locale.exit();
        }
    }

    DomImpl.Dom findDomNthChild(DomImpl.Dom dom, int i2) {
        DomImpl.Dom domFetch;
        if (dom == null) {
            return null;
        }
        int iDistance = this._domNthCache_A.distance(dom, i2);
        int iDistance2 = this._domNthCache_B.distance(dom, i2);
        boolean z = iDistance2 - (this._domNthCache_B._len / 2) > 0 && (iDistance2 - (this._domNthCache_B._len / 2)) + (-40) > 0;
        boolean z2 = iDistance - (this._domNthCache_A._len / 2) > 0 && (iDistance - (this._domNthCache_A._len / 2)) + (-40) > 0;
        if (iDistance <= iDistance2) {
            if (z2) {
                this._domNthCache_B._version = -1L;
                domFetch = this._domNthCache_B.fetch(dom, i2);
            } else {
                domFetch = this._domNthCache_A.fetch(dom, i2);
            }
        } else if (z) {
            this._domNthCache_A._version = -1L;
            domFetch = this._domNthCache_A.fetch(dom, i2);
        } else {
            domFetch = this._domNthCache_B.fetch(dom, i2);
        }
        if (iDistance == iDistance2) {
            domNthCache domnthcache = this._domNthCache_A;
            this._domNthCache_A = this._domNthCache_B;
            this._domNthCache_B = domnthcache;
        }
        return domFetch;
    }

    Xobj findNthChildElem(Xobj xobj, QName qName, QNameSet qNameSet, int i2) {
        if (xobj == null) {
            return null;
        }
        int iDistance = this._nthCache_A.distance(xobj, qName, qNameSet, i2);
        int iDistance2 = this._nthCache_B.distance(xobj, qName, qNameSet, i2);
        Xobj xobjFetch = iDistance <= iDistance2 ? this._nthCache_A.fetch(xobj, qName, qNameSet, i2) : this._nthCache_B.fetch(xobj, qName, qNameSet, i2);
        if (iDistance == iDistance2) {
            nthCache nthcache = this._nthCache_A;
            this._nthCache_A = this._nthCache_B;
            this._nthCache_B = nthcache;
        }
        return xobjFetch;
    }

    CharUtil getCharUtil() {
        if (this._charUtil == null) {
            this._charUtil = new CharUtil(1024);
        }
        return this._charUtil;
    }

    Cur getCur() {
        Cur cur = this._curPool;
        if (cur == null) {
            cur = new Cur(this);
        } else {
            this._curPool = cur.listRemove(cur);
            this._curPoolCount--;
        }
        this._registered = cur.listInsert(this._registered);
        cur._state = 1;
        return cur;
    }

    @Override // org.w3c.dom.DOMImplementation
    public Object getFeature(String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Object getSaajData(Node node) {
        return DomImpl.saajCallback_getSaajData((DomImpl.Dom) node);
    }

    public SchemaTypeLoader getSchemaTypeLoader() {
        return this._schemaTypeLoader;
    }

    @Override // org.w3c.dom.DOMImplementation
    public boolean hasFeature(String str, String str2) {
        return DomImpl._domImplementation_hasFeature(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public Element importSoapElement(Document document, Element element, boolean z, QName qName) {
        return DomImpl.saajCallback_importSoapElement((DomImpl.Dom) document, element, z, qName);
    }

    void invalidateDomCaches(DomImpl.Dom dom) {
        if (this._domNthCache_A._parent == dom) {
            this._domNthCache_A._version = -1L;
        }
        if (this._domNthCache_B._parent == dom) {
            this._domNthCache_B._version = -1L;
        }
    }

    public void loadNode(Node node, LoadContext loadContext) throws DOMException {
        switch (node.getNodeType()) {
            case 1:
                loadContext.startElement(makeQualifiedQName(node.getNamespaceURI(), node.getNodeName()));
                NamedNodeMap attributes = node.getAttributes();
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    Node nodeItem = attributes.item(i2);
                    String nodeName = nodeItem.getNodeName();
                    String nodeValue = nodeItem.getNodeValue();
                    if (!nodeName.toLowerCase(java.util.Locale.ROOT).startsWith("xmlns")) {
                        loadContext.attr(makeQualifiedQName(nodeItem.getNamespaceURI(), nodeName), nodeValue);
                    } else if (nodeName.length() == 5) {
                        loadContext.xmlns(null, nodeValue);
                    } else {
                        loadContext.xmlns(nodeName.substring(6), nodeValue);
                    }
                }
                loadNodeChildren(node, loadContext);
                loadContext.endElement();
                return;
            case 2:
                throw new RuntimeException("Unexpected node");
            case 3:
            case 4:
                loadContext.text(node.getNodeValue());
                return;
            case 5:
            case 9:
            case 11:
                loadNodeChildren(node, loadContext);
                return;
            case 6:
            case 10:
            case 12:
                Node nextSibling = node.getNextSibling();
                if (nextSibling != null) {
                    loadNode(nextSibling, loadContext);
                    return;
                }
                return;
            case 7:
                loadContext.procInst(node.getNodeName(), node.getNodeValue());
                return;
            case 8:
                loadContext.comment(node.getNodeValue());
                return;
            default:
                return;
        }
    }

    QName makeQName(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    QName makeQNameNoCheck(String str, String str2) {
        return this._qnameFactory.getQName(str, str2);
    }

    QName makeQualifiedQName(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str2.indexOf(58);
        return iIndexOf < 0 ? this._qnameFactory.getQName(str, str2) : this._qnameFactory.getQName(str, str2.substring(iIndexOf + 1), str2.substring(0, iIndexOf));
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean noSync() {
        return this._noSync;
    }

    void notifyChange() {
        while (true) {
            ChangeListener changeListener = this._changeListeners;
            if (changeListener == null) {
                this._locations.notifyChange();
                return;
            }
            changeListener.notifyChange();
            ChangeListener nextChangeListener = this._changeListeners.getNextChangeListener();
            ChangeListener changeListener2 = this._changeListeners;
            if (nextChangeListener == changeListener2) {
                changeListener2.setNextChangeListener(null);
            }
            ChangeListener nextChangeListener2 = this._changeListeners.getNextChangeListener();
            this._changeListeners.setNextChangeListener(null);
            this._changeListeners = nextChangeListener2;
        }
    }

    final ReferenceQueue<Ref> refQueue() {
        if (this._refQueue == null) {
            this._refQueue = new ReferenceQueue<>();
        }
        return this._refQueue;
    }

    void registerForChange(ChangeListener changeListener) {
        if (changeListener.getNextChangeListener() == null) {
            ChangeListener changeListener2 = this._changeListeners;
            if (changeListener2 == null) {
                changeListener.setNextChangeListener(changeListener);
            } else {
                changeListener.setNextChangeListener(changeListener2);
            }
            this._changeListeners = changeListener;
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Saaj.SaajCallback
    public void setSaajData(Node node, Object obj) {
        DomImpl.saajCallback_setSaajData((DomImpl.Dom) node, obj);
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public boolean sync() {
        return !this._noSync;
    }

    Cur tempCur() {
        return tempCur(null);
    }

    public long version() {
        return this._versionAll;
    }

    Cur weakCur(Object obj) {
        Cur cur = getCur();
        cur._ref = new Ref(cur, obj);
        return cur;
    }

    public DomImpl.Dom load(Reader reader) throws XmlException, IOException {
        return load(reader, (XmlOptions) null);
    }

    QName makeQName(String str, String str2, String str3) {
        QNameFactory qNameFactory = this._qnameFactory;
        if (str3 == null) {
            str3 = "";
        }
        return qNameFactory.getQName(str, str2, str3);
    }

    Cur tempCur(String str) {
        Cur cur = getCur();
        Cur[] curArr = this._tempFrames;
        int length = (curArr.length - this._numTempFramesLeft) - 1;
        Cur cur2 = curArr[length];
        cur._nextTemp = cur2;
        if (cur2 != null) {
            cur2._prevTemp = cur;
        }
        curArr[length] = cur;
        cur._tempFrame = length;
        cur._id = str;
        return cur;
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, final XMLStreamReader xMLStreamReader, final SchemaType schemaType, final XmlOptions xmlOptions) throws XmlException {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.d7
                @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
                public final Object parse(Locale locale) {
                    return Locale.d(xMLStreamReader, xmlOptions, schemaType, locale);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void enter() {
        int i2 = this._numTempFramesLeft - 1;
        this._numTempFramesLeft = i2;
        if (i2 <= 0) {
            Cur[] curArr = this._tempFrames;
            Cur[] curArr2 = new Cur[curArr.length * 2];
            this._numTempFramesLeft = curArr.length;
            System.arraycopy(curArr, 0, curArr2, 0, curArr.length);
            this._tempFrames = curArr2;
        }
        int i3 = this._entryCount + 1;
        this._entryCount = i3;
        if (i3 > 1000) {
            pollQueue();
            this._entryCount = 0;
        }
    }

    @Override // org.apache.xmlbeans.impl.common.XmlLocale
    public void exit() {
        int length = this._tempFrames.length;
        int i2 = this._numTempFramesLeft + 1;
        this._numTempFramesLeft = i2;
        int i3 = length - i2;
        while (true) {
            Cur[] curArr = this._tempFrames;
            if (curArr[i3] == null) {
                return;
            } else {
                curArr[i3].release();
            }
        }
    }

    public DomImpl.Dom load(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(reader), xmlOptions);
    }

    public DomImpl.Dom load(InputStream inputStream) throws XmlException, IOException {
        return load(inputStream, (XmlOptions) null);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, final InputStream inputStream, final SchemaType schemaType, final XmlOptions xmlOptions) throws XmlException, IOException {
        return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.a7
            @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
            public final Object parse(Locale locale) {
                return Locale.e(xmlOptions, inputStream, schemaType, locale);
            }
        });
    }

    public DomImpl.Dom load(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
        return load(new InputSource(inputStream), xmlOptions);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, final Reader reader, final SchemaType schemaType, final XmlOptions xmlOptions) throws XmlException, IOException {
        return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.y6
            @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
            public final Object parse(Locale locale) {
                return Locale.f(xmlOptions, reader, schemaType, locale);
            }
        });
    }

    public DomImpl.Dom load(String str) throws XmlException {
        return load(str, (XmlOptions) null);
    }

    public static XmlObject parseToXmlObject(SchemaTypeLoader schemaTypeLoader, final Node node, final SchemaType schemaType, final XmlOptions xmlOptions) throws XmlException {
        try {
            return (XmlObject) syncWrap(schemaTypeLoader, xmlOptions, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.e7
                @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
                public final Object parse(Locale locale) {
                    return Locale.g(xmlOptions, node, schemaType, locale);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DomImpl.Dom load(String str, XmlOptions xmlOptions) throws XmlException, IOException {
        try {
            StringReader stringReader = new StringReader(str);
            try {
                DomImpl.Dom domLoad = load(stringReader, xmlOptions);
                stringReader.close();
                return domLoad;
            } finally {
            }
        } catch (IOException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    static int getTextValue(Cur cur, char[] cArr, int i2, int i3) {
        String valueAsString = cur._xobj.getValueAsString(1);
        int length = valueAsString.length();
        if (length <= i3) {
            i3 = length;
        }
        if (i3 <= 0) {
            return 0;
        }
        valueAsString.getChars(0, i3, cArr, i2);
        return i3;
    }

    static boolean toNextSiblingElement(Cur cur, Xobj xobj) {
        Xobj xobj2 = cur._xobj;
        int i2 = cur._pos;
        int iKind = cur.kind();
        if (iKind == 3) {
            cur.moveTo(xobj);
            cur.next();
        } else if (iKind == 2) {
            cur.skip();
        }
        while (true) {
            int iKind2 = cur.kind();
            if (iKind2 < 0) {
                cur.moveTo(xobj2, i2);
                return false;
            }
            if (iKind2 == 2) {
                return true;
            }
            if (iKind2 > 0) {
                cur.toEnd();
            }
            cur.next();
        }
    }
}
