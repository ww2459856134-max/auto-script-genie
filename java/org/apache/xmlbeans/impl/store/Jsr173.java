package org.apache.xmlbeans.impl.store;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlLineNumber;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class Jsr173 {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static abstract class Jsr173GateWay {
        Locale _l;
        XMLStreamReaderBase _xs;

        public Jsr173GateWay(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            this._l = locale;
            this._xs = xMLStreamReaderBase;
        }
    }

    private static abstract class XMLStreamReaderBase implements XMLStreamReader, NamespaceContext, Location {
        private Locale _locale;
        String _uri;
        private long _version;
        int _line = -1;
        int _column = -1;
        int _offset = -1;

        XMLStreamReaderBase(Cur cur) {
            Locale locale = cur._locale;
            this._locale = locale;
            this._version = locale.version();
        }

        protected final void checkChanged() {
            if (this._version != this._locale.version()) {
                throw new ConcurrentModificationException("Document changed while streaming");
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            checkChanged();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getEncoding();
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getCharacterOffset() {
            return this._offset;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getColumnNumber() {
            return this._column;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getEncoding() {
            return null;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getLineNumber() {
            return this._line;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Location getLocation() {
            checkChanged();
            XmlLineNumber xmlLineNumber = (XmlLineNumber) getStreamCur().getBookmark(XmlLineNumber.class);
            this._uri = null;
            if (xmlLineNumber != null) {
                this._line = xmlLineNumber.getLine();
                this._column = xmlLineNumber.getColumn();
                this._offset = xmlLineNumber.getOffset();
            } else {
                this._line = -1;
                this._column = -1;
                this._offset = -1;
            }
            return this;
        }

        public String getLocationURI() {
            return this._uri;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            throw new RuntimeException("This version of getNamespaceContext should not be called");
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String strNamespaceForPrefix = streamCur.namespaceForPrefix(str, true);
            streamCur.pop();
            return strNamespaceForPrefix;
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            checkChanged();
            Cur streamCur = getStreamCur();
            streamCur.push();
            if (!streamCur.isContainer()) {
                streamCur.toParent();
            }
            String strPrefixForNamespace = streamCur.prefixForNamespace(str, null, false);
            streamCur.pop();
            return strPrefixForNamespace;
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            checkChanged();
            HashMap map = new HashMap();
            map.put(str, getPrefix(str));
            return map.values().iterator();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            checkChanged();
            if (str != null) {
                return null;
            }
            throw new IllegalArgumentException("Property name is null");
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getPublicId() {
            return null;
        }

        protected abstract Cur getStreamCur();

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getSystemId() {
            return null;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getVersion() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return null;
            }
            return docProps.getVersion();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            checkChanged();
            XmlDocumentProperties docProps = Locale.getDocProps(getStreamCur(), false);
            if (docProps == null) {
                return false;
            }
            return docProps.getStandalone();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            checkChanged();
            String text = getText();
            return this._locale.getCharUtil().isWhiteSpace(text, 0, text.length());
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void require(int i2, String str, String str2) throws XMLStreamException {
            checkChanged();
            if (i2 != getEventType()) {
                throw new XMLStreamException();
            }
            if (str != null && !getNamespaceURI().equals(str)) {
                throw new XMLStreamException();
            }
            if (str2 != null && !getLocalName().equals(str2)) {
                throw new XMLStreamException();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            checkChanged();
            return false;
        }
    }

    private static final class XMLStreamReaderForString extends XMLStreamReaderBase {
        private int _cch;
        private Cur _cur;
        private int _off;
        private Object _src;

        XMLStreamReaderForString(Cur cur, Object obj, int i2, int i3) {
            super(cur);
            this._src = obj;
            this._off = i2;
            this._cch = i3;
            this._cur = cur;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeType(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getElementText() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getEventType() {
            checkChanged();
            return 4;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getLocalName() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getName() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPIData() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPITarget() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPrefix() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, org.apache.poi.javax.xml.stream.Location
        public String getPublicId() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        protected Cur getStreamCur() {
            return this._cur;
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase, org.apache.poi.javax.xml.stream.Location
        public String getSystemId() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getText() {
            checkChanged();
            return CharUtil.getString(this._src, this._off, this._cch);
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            checkChanged();
            int i2 = this._cch;
            char[] cArr = new char[i2];
            CharUtil.getChars(cArr, 0, this._src, this._off, i2);
            return cArr;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextLength() {
            checkChanged();
            return this._cch;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextStart() {
            checkChanged();
            return this._off;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasName() {
            checkChanged();
            return false;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasNext() {
            checkChanged();
            return false;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasText() {
            checkChanged();
            return true;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            checkChanged();
            return true;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            checkChanged();
            return false;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            checkChanged();
            return false;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int next() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int nextTag() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i2, char[] cArr, int i3, int i4) {
            checkChanged();
            if (i4 >= 0) {
                int i5 = this._cch;
                if (i2 <= i5) {
                    if (i2 + i4 > i5) {
                        i4 = i5 - i2;
                    }
                    CharUtil.getChars(cArr, i3, this._src, this._off + i2, i4);
                    return i4;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, Object obj, int i2, int i3) {
        XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(cur, obj, i2, i3);
        return cur._locale.noSync() ? new UnsyncedJsr173(cur._locale, xMLStreamReaderForString) : new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node nodeFromStream(XMLStreamReader xMLStreamReader) {
        Node nodeNodeFromStreamImpl;
        if (!(xMLStreamReader instanceof Jsr173GateWay)) {
            return null;
        }
        Jsr173GateWay jsr173GateWay = (Jsr173GateWay) xMLStreamReader;
        Locale locale = jsr173GateWay._l;
        if (locale.noSync()) {
            locale.enter();
            try {
                return nodeFromStreamImpl(jsr173GateWay);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                nodeNodeFromStreamImpl = nodeFromStreamImpl(jsr173GateWay);
            } finally {
            }
        }
        return nodeNodeFromStreamImpl;
    }

    public static Node nodeFromStreamImpl(Jsr173GateWay jsr173GateWay) {
        Cur streamCur = jsr173GateWay._xs.getStreamCur();
        if (streamCur.isNode()) {
            return (Node) streamCur.getDom();
        }
        return null;
    }

    private static final class XMLStreamReaderForNode extends XMLStreamReaderBase {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchChars;
        private int _cchSrc;
        private char[] _chars;
        private Cur _cur;
        private boolean _done;
        private Cur _end;
        private int _offChars;
        private int _offSrc;
        private Object _src;
        private boolean _srcFetched;
        private boolean _textFetched;
        private boolean _wholeDoc;

        public XMLStreamReaderForNode(Cur cur, boolean z) {
            super(cur);
            if (z) {
                Cur curWeakCur = cur.weakCur(this);
                this._cur = curWeakCur;
                if (!curWeakCur.toFirstAttr()) {
                    this._cur.next();
                }
                Cur curWeakCur2 = cur.weakCur(this);
                this._end = curWeakCur2;
                curWeakCur2.toEnd();
            } else {
                this._cur = cur.weakCur(this);
                if (cur.isRoot()) {
                    this._wholeDoc = true;
                } else {
                    this._end = cur.weakCur(this);
                    if (!cur.isAttr()) {
                        this._end.skip();
                    } else if (!this._end.toNextAttr()) {
                        this._end.toParent();
                        this._end.next();
                    }
                }
            }
            if (this._wholeDoc) {
                return;
            }
            this._cur.push();
            try {
                next();
                this._cur.pop();
            } catch (XMLStreamException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        private void ensureCharBufLen(int i2) {
            char[] cArr = this._chars;
            if (cArr == null || cArr.length < i2) {
                int i3 = 256;
                while (i3 < i2) {
                    i3 *= 2;
                }
                this._chars = new char[i3];
            }
        }

        private void fetchChars() {
            Cur curTempCur;
            if (this._textFetched) {
                return;
            }
            int iKind = this._cur.kind();
            if (iKind == 4) {
                curTempCur = this._cur.tempCur();
                curTempCur.next();
            } else {
                if (iKind != 0) {
                    throw new IllegalStateException();
                }
                curTempCur = this._cur;
            }
            Object chars = curTempCur.getChars(-1);
            ensureCharBufLen(curTempCur._cchSrc);
            char[] cArr = this._chars;
            this._offChars = 0;
            int i2 = curTempCur._offSrc;
            int i3 = curTempCur._cchSrc;
            this._cchChars = i3;
            CharUtil.getChars(cArr, 0, chars, i2, i3);
            if (curTempCur != this._cur) {
                curTempCur.release();
            }
            this._textFetched = true;
        }

        private static boolean matchAttr(Cur cur, String str, String str2) {
            QName name = cur.getName();
            return name.getLocalPart().equals(str2) && (str == null || name.getNamespaceURI().equals(str));
        }

        private static Cur toAttr(Cur cur, String str, String str2) {
            if (str == null || str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Cur curTempCur = cur.tempCur();
            boolean zMatchAttr = false;
            if (cur.isElem()) {
                if (curTempCur.toFirstAttr()) {
                    while (true) {
                        if (curTempCur.isNormalAttr() && matchAttr(curTempCur, str, str2)) {
                            zMatchAttr = true;
                            break;
                        }
                        if (!curTempCur.toNextSibling()) {
                            break;
                        }
                    }
                }
            } else {
                if (!cur.isNormalAttr()) {
                    throw new IllegalStateException();
                }
                zMatchAttr = matchAttr(cur, str, str2);
            }
            if (zMatchAttr) {
                return curTempCur;
            }
            curTempCur.release();
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static Cur toXmlns(Cur cur, int i2) {
            if (i2 < 0) {
                throw new IndexOutOfBoundsException("Namespace index is negative");
            }
            Cur curTempCur = cur.tempCur();
            boolean z = true;
            if (cur.isElem() || cur.kind() == -2) {
                if (cur.kind() == -2) {
                    curTempCur.toParent();
                }
                if (curTempCur.toFirstAttr()) {
                    do {
                        if (curTempCur.isXmlns()) {
                            int i3 = i2 - 1;
                            if (i2 == 0) {
                                break;
                            }
                            i2 = i3;
                        }
                    } while (curTempCur.toNextSibling());
                    z = false;
                } else {
                    z = false;
                }
            } else {
                if (!cur.isXmlns()) {
                    throw new IllegalStateException();
                }
                if (i2 != 0) {
                }
            }
            if (z) {
                return curTempCur;
            }
            curTempCur.release();
            throw new IndexOutOfBoundsException("Namespace index is too large");
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            if (!this._cur.isElem()) {
                if (this._cur.isNormalAttr()) {
                    return 1;
                }
                throw new IllegalStateException();
            }
            Cur curTempCur = this._cur.tempCur();
            int i2 = 0;
            if (curTempCur.toFirstAttr()) {
                do {
                    if (curTempCur.isNormalAttr()) {
                        i2++;
                    }
                } while (curTempCur.toNextSibling());
            }
            curTempCur.release();
            return i2;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i2) {
            return getAttributeName(i2).getLocalPart();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i2) {
            Cur attr = toAttr(this._cur, i2);
            QName name = attr.getName();
            attr.release();
            return name;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i2) {
            return getAttributeName(i2).getNamespaceURI();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i2) {
            return getAttributeName(i2).getPrefix();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeType(int i2) {
            toAttr(this._cur, i2).release();
            return "CDATA";
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            Cur attr = toAttr(this._cur, str, str2);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            checkChanged();
            if (!isStartElement()) {
                throw new IllegalStateException();
            }
            StringBuilder sb = new StringBuilder();
            while (hasNext()) {
                int next = next();
                if (next == 2) {
                    return sb.toString();
                }
                if (next == 1) {
                    throw new XMLStreamException();
                }
                if (next != 5 && next != 3) {
                    sb.append(getText());
                }
            }
            throw new XMLStreamException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getEventType() {
            switch (this._cur.kind()) {
                case -2:
                    return 2;
                case -1:
                    return 8;
                case 0:
                    return 4;
                case 1:
                    return 7;
                case 2:
                    return 1;
                case 3:
                    return this._cur.isXmlns() ? 13 : 10;
                case 4:
                    return 5;
                case 5:
                    return 3;
                default:
                    throw new IllegalStateException();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getLocalName() {
            return getName().getLocalPart();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getName() {
            if (hasName()) {
                return this._cur.getName();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            if (!this._cur.isElem() && this._cur.kind() != -2) {
                if (this._cur.isXmlns()) {
                    return 1;
                }
                throw new IllegalStateException();
            }
            Cur curTempCur = this._cur.tempCur();
            if (this._cur.kind() == -2) {
                curTempCur.toParent();
            }
            int i2 = 0;
            if (curTempCur.toFirstAttr()) {
                do {
                    if (curTempCur.isXmlns()) {
                        i2++;
                    }
                } while (curTempCur.toNextSibling());
            }
            curTempCur.release();
            return i2;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i2) {
            Cur xmlns = toXmlns(this._cur, i2);
            String xmlnsPrefix = xmlns.getXmlnsPrefix();
            xmlns.release();
            return xmlnsPrefix;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i2) {
            Cur xmlns = toXmlns(this._cur, i2);
            String xmlnsUri = xmlns.getXmlnsUri();
            xmlns.release();
            return xmlnsUri;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPIData() {
            if (this._cur.kind() == 5) {
                return this._cur.getValueAsString();
            }
            return null;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPITarget() {
            if (this._cur.kind() == 5) {
                return this._cur.getName().getLocalPart();
            }
            return null;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPrefix() {
            return getName().getPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Jsr173.XMLStreamReaderBase
        protected Cur getStreamCur() {
            return this._cur;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getText() {
            checkChanged();
            int iKind = this._cur.kind();
            if (iKind == 4) {
                return this._cur.getValueAsString();
            }
            if (iKind == 0) {
                return this._cur.getCharsAsString();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            checkChanged();
            fetchChars();
            return this._chars;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextLength() {
            checkChanged();
            fetchChars();
            return this._cchChars;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextStart() {
            checkChanged();
            fetchChars();
            return this._offChars;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasName() {
            int iKind = this._cur.kind();
            return iKind == 2 || iKind == -2;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            checkChanged();
            return !this._done;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasText() {
            int iKind = this._cur.kind();
            return iKind == 4 || iKind == 0;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i2) {
            toAttr(this._cur, i2).release();
            return false;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            return getEventType() == 4;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            return getEventType() == 2;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            return getEventType() == 1;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            checkChanged();
            if (!hasNext()) {
                throw new IllegalStateException("No next event in stream");
            }
            int iKind = this._cur.kind();
            boolean zIsSamePos = true;
            if (iKind == -1) {
                this._done = true;
            } else {
                if (iKind == 3) {
                    if (!this._cur.toNextAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                } else if (iKind == 4 || iKind == 5) {
                    this._cur.skip();
                } else if (iKind != 1 || !this._cur.toFirstAttr()) {
                    this._cur.next();
                }
                if (!this._wholeDoc) {
                    zIsSamePos = this._cur.isSamePos(this._end);
                } else if (this._cur.kind() != -1) {
                    zIsSamePos = false;
                }
                this._done = zIsSamePos;
            }
            this._textFetched = false;
            this._srcFetched = false;
            return getEventType();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            checkChanged();
            while (!isStartElement() && !isEndElement()) {
                if (!isWhiteSpace()) {
                    throw new XMLStreamException();
                }
                if (!hasNext()) {
                    throw new XMLStreamException();
                }
                next();
            }
            return getEventType();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i2) {
            Cur attr = toAttr(this._cur, i2);
            if (attr == null) {
                return null;
            }
            String valueAsString = attr.getValueAsString();
            attr.release();
            return valueAsString;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            return getName().getNamespaceURI();
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException {
            Cur curTempCur;
            if (i4 >= 0) {
                if (i3 >= 0 && i3 < cArr.length) {
                    if (i3 + i4 <= cArr.length) {
                        if (!this._srcFetched) {
                            int iKind = this._cur.kind();
                            if (iKind == 4) {
                                curTempCur = this._cur.tempCur();
                                curTempCur.next();
                            } else if (iKind == 0) {
                                curTempCur = this._cur;
                            } else {
                                throw new IllegalStateException();
                            }
                            this._src = curTempCur.getChars(-1);
                            this._offSrc = curTempCur._offSrc;
                            this._cchSrc = curTempCur._cchSrc;
                            if (curTempCur != this._cur) {
                                curTempCur.release();
                            }
                            this._srcFetched = true;
                        }
                        int i5 = this._cchSrc;
                        if (i2 <= i5) {
                            if (i2 + i4 > i5) {
                                i4 = i5 - i2;
                            }
                            CharUtil.getChars(cArr, i3, this._src, this._offSrc, i4);
                            return i4;
                        }
                        throw new IndexOutOfBoundsException();
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static Cur toAttr(Cur cur, int i2) {
            if (i2 >= 0) {
                Cur curTempCur = cur.tempCur();
                boolean z = true;
                if (cur.isElem()) {
                    if (curTempCur.toFirstAttr()) {
                        do {
                            if (curTempCur.isNormalAttr()) {
                                int i3 = i2 - 1;
                                if (i2 == 0) {
                                    break;
                                }
                                i2 = i3;
                            }
                        } while (curTempCur.toNextSibling());
                        z = false;
                    } else {
                        z = false;
                    }
                } else {
                    if (!cur.isNormalAttr()) {
                        throw new IllegalStateException();
                    }
                    if (i2 != 0) {
                    }
                }
                if (z) {
                    return curTempCur;
                }
                curTempCur.release();
                throw new IndexOutOfBoundsException("Attribute index is too large");
            }
            throw new IndexOutOfBoundsException("Attribute index is negative");
        }
    }

    private static final class UnsyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        public UnsyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            try {
                this._l.enter();
                this._xs.close();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            try {
                this._l.enter();
                return this._xs.getAttributeCount();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributeLocalName(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributeName(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributeNamespace(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributePrefix(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeType(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributeType(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(str, str2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            try {
                this._l.enter();
                return this._xs.getCharacterEncodingScheme();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getCharacterOffset() {
            try {
                this._l.enter();
                return this._xs.getCharacterOffset();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getColumnNumber() {
            try {
                this._l.enter();
                return this._xs.getColumnNumber();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.getElementText();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getEncoding() {
            try {
                this._l.enter();
                return this._xs.getEncoding();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getEventType() {
            try {
                this._l.enter();
                return this._xs.getEventType();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    lineNumber = this._xs.getLineNumber();
                } finally {
                    this._l.exit();
                }
            }
            return lineNumber;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getLocalName() {
            try {
                this._l.enter();
                return this._xs.getLocalName();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Location getLocation() {
            try {
                this._l.enter();
                return this._xs.getLocation();
            } finally {
                this._l.exit();
            }
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    locationURI = this._xs.getLocationURI();
                } finally {
                    this._l.exit();
                }
            }
            return locationURI;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getName() {
            try {
                this._l.enter();
                return this._xs.getName();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            return this;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            try {
                this._l.enter();
                return this._xs.getNamespaceCount();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i2) {
            try {
                this._l.enter();
                return this._xs.getNamespacePrefix(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPIData() {
            try {
                this._l.enter();
                return this._xs.getPIData();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPITarget() {
            try {
                this._l.enter();
                return this._xs.getPITarget();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPrefix() {
            try {
                this._l.enter();
                return this._xs.getPrefix();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefixes(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            try {
                this._l.enter();
                return this._xs.getProperty(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    publicId = this._xs.getPublicId();
                } finally {
                    this._l.exit();
                }
            }
            return publicId;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    systemId = this._xs.getSystemId();
                } finally {
                    this._l.exit();
                }
            }
            return systemId;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getText() {
            try {
                this._l.enter();
                return this._xs.getText();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            try {
                this._l.enter();
                return this._xs.getTextCharacters();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextLength() {
            try {
                this._l.enter();
                return this._xs.getTextLength();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextStart() {
            try {
                this._l.enter();
                return this._xs.getTextStart();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getVersion() {
            try {
                this._l.enter();
                return this._xs.getVersion();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasName() {
            try {
                this._l.enter();
                return this._xs.hasName();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.hasNext();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasText() {
            try {
                this._l.enter();
                return this._xs.hasText();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i2) {
            try {
                this._l.enter();
                return this._xs.isAttributeSpecified(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            try {
                this._l.enter();
                return this._xs.isCharacters();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            try {
                this._l.enter();
                return this._xs.isEndElement();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            try {
                this._l.enter();
                return this._xs.isStandalone();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            try {
                this._l.enter();
                return this._xs.isStartElement();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            try {
                this._l.enter();
                return this._xs.isWhiteSpace();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.next();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.nextTag();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void require(int i2, String str, String str2) throws XMLStreamException {
            try {
                this._l.enter();
                this._xs.require(i2, str, str2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            try {
                this._l.enter();
                return this._xs.standaloneSet();
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i2) {
            try {
                this._l.enter();
                return this._xs.getAttributeValue(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i2) {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI(i2);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            try {
                this._l.enter();
                return this._xs.getPrefix(str);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException {
            try {
                this._l.enter();
                return this._xs.getTextCharacters(i2, cArr, i3, i4);
            } finally {
                this._l.exit();
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            try {
                this._l.enter();
                return this._xs.getNamespaceURI();
            } finally {
                this._l.exit();
            }
        }
    }

    public static XMLStreamReader newXmlStreamReader(Cur cur, XmlOptions xmlOptions) {
        XMLStreamReaderBase xMLStreamReaderForString;
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        boolean z = xmlOptionsMaskNull.isSaveInner() && !xmlOptionsMaskNull.isSaveOuter();
        int iKind = cur.kind();
        if (iKind == 0 || iKind < 0) {
            xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getChars(-1), cur._offSrc, cur._cchSrc);
        } else if (z) {
            if (!cur.hasAttrs() && !cur.hasChildren()) {
                xMLStreamReaderForString = new XMLStreamReaderForString(cur, cur.getFirstChars(), cur._offSrc, cur._cchSrc);
            } else {
                xMLStreamReaderForString = new XMLStreamReaderForNode(cur, true);
            }
        } else {
            xMLStreamReaderForString = new XMLStreamReaderForNode(cur, false);
        }
        if (cur._locale.noSync()) {
            return new UnsyncedJsr173(cur._locale, xMLStreamReaderForString);
        }
        return new SyncedJsr173(cur._locale, xMLStreamReaderForString);
    }

    private static final class SyncedJsr173 extends Jsr173GateWay implements XMLStreamReader, Location, NamespaceContext {
        public SyncedJsr173(Locale locale, XMLStreamReaderBase xMLStreamReaderBase) {
            super(locale, xMLStreamReaderBase);
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void close() throws XMLStreamException {
            synchronized (this._l) {
                this._l.enter();
                try {
                    this._xs.close();
                } finally {
                    this._l.exit();
                }
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getAttributeCount() {
            int attributeCount;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeCount = this._xs.getAttributeCount();
                } finally {
                    this._l.exit();
                }
            }
            return attributeCount;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeLocalName(int i2) {
            String attributeLocalName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeLocalName = this._xs.getAttributeLocalName(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeLocalName;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getAttributeName(int i2) {
            QName attributeName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeName = this._xs.getAttributeName(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeName;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeNamespace(int i2) {
            String attributeNamespace;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeNamespace = this._xs.getAttributeNamespace(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeNamespace;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributePrefix(int i2) {
            String attributePrefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributePrefix = this._xs.getAttributePrefix(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributePrefix;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeType(int i2) {
            String attributeType;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeType = this._xs.getAttributeType(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeType;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(String str, String str2) {
            String attributeValue;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeValue = this._xs.getAttributeValue(str, str2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeValue;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getCharacterEncodingScheme() {
            String characterEncodingScheme;
            synchronized (this._l) {
                this._l.enter();
                try {
                    characterEncodingScheme = this._xs.getCharacterEncodingScheme();
                } finally {
                    this._l.exit();
                }
            }
            return characterEncodingScheme;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getCharacterOffset() {
            int characterOffset;
            synchronized (this._l) {
                this._l.enter();
                try {
                    characterOffset = this._xs.getCharacterOffset();
                } finally {
                    this._l.exit();
                }
            }
            return characterOffset;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getColumnNumber() {
            int columnNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    columnNumber = this._xs.getColumnNumber();
                } finally {
                    this._l.exit();
                }
            }
            return columnNumber;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getElementText() throws XMLStreamException {
            String elementText;
            synchronized (this._l) {
                this._l.enter();
                try {
                    elementText = this._xs.getElementText();
                } finally {
                    this._l.exit();
                }
            }
            return elementText;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getEncoding() {
            String encoding;
            synchronized (this._l) {
                this._l.enter();
                try {
                    encoding = this._xs.getEncoding();
                } finally {
                    this._l.exit();
                }
            }
            return encoding;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getEventType() {
            int eventType;
            synchronized (this._l) {
                this._l.enter();
                try {
                    eventType = this._xs.getEventType();
                } finally {
                    this._l.exit();
                }
            }
            return eventType;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public int getLineNumber() {
            int lineNumber;
            synchronized (this._l) {
                this._l.enter();
                try {
                    lineNumber = this._xs.getLineNumber();
                } finally {
                    this._l.exit();
                }
            }
            return lineNumber;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getLocalName() {
            String localName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    localName = this._xs.getLocalName();
                } finally {
                    this._l.exit();
                }
            }
            return localName;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Location getLocation() {
            Location location;
            synchronized (this._l) {
                this._l.enter();
                try {
                    location = this._xs.getLocation();
                } finally {
                    this._l.exit();
                }
            }
            return location;
        }

        public String getLocationURI() {
            String locationURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    locationURI = this._xs.getLocationURI();
                } finally {
                    this._l.exit();
                }
            }
            return locationURI;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public QName getName() {
            QName name;
            synchronized (this._l) {
                this._l.enter();
                try {
                    name = this._xs.getName();
                } finally {
                    this._l.exit();
                }
            }
            return name;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public NamespaceContext getNamespaceContext() {
            return this;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getNamespaceCount() {
            int namespaceCount;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceCount = this._xs.getNamespaceCount();
                } finally {
                    this._l.exit();
                }
            }
            return namespaceCount;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespacePrefix(int i2) {
            String namespacePrefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespacePrefix = this._xs.getNamespacePrefix(i2);
                } finally {
                    this._l.exit();
                }
            }
            return namespacePrefix;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(String str) {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI(str);
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPIData() {
            String pIData;
            synchronized (this._l) {
                this._l.enter();
                try {
                    pIData = this._xs.getPIData();
                } finally {
                    this._l.exit();
                }
            }
            return pIData;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPITarget() {
            String pITarget;
            synchronized (this._l) {
                this._l.enter();
                try {
                    pITarget = this._xs.getPITarget();
                } finally {
                    this._l.exit();
                }
            }
            return pITarget;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getPrefix() {
            String prefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefix = this._xs.getPrefix();
                } finally {
                    this._l.exit();
                }
            }
            return prefix;
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String str) {
            Iterator<String> prefixes;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefixes = this._xs.getPrefixes(str);
                } finally {
                    this._l.exit();
                }
            }
            return prefixes;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public Object getProperty(String str) {
            Object property;
            synchronized (this._l) {
                this._l.enter();
                try {
                    property = this._xs.getProperty(str);
                } finally {
                    this._l.exit();
                }
            }
            return property;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getPublicId() {
            String publicId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    publicId = this._xs.getPublicId();
                } finally {
                    this._l.exit();
                }
            }
            return publicId;
        }

        @Override // org.apache.poi.javax.xml.stream.Location
        public String getSystemId() {
            String systemId;
            synchronized (this._l) {
                this._l.enter();
                try {
                    systemId = this._xs.getSystemId();
                } finally {
                    this._l.exit();
                }
            }
            return systemId;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getText() {
            String text;
            synchronized (this._l) {
                this._l.enter();
                try {
                    text = this._xs.getText();
                } finally {
                    this._l.exit();
                }
            }
            return text;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            char[] textCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textCharacters = this._xs.getTextCharacters();
                } finally {
                    this._l.exit();
                }
            }
            return textCharacters;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextLength() {
            int textLength;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textLength = this._xs.getTextLength();
                } finally {
                    this._l.exit();
                }
            }
            return textLength;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextStart() {
            int textStart;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textStart = this._xs.getTextStart();
                } finally {
                    this._l.exit();
                }
            }
            return textStart;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getVersion() {
            String version;
            synchronized (this._l) {
                this._l.enter();
                try {
                    version = this._xs.getVersion();
                } finally {
                    this._l.exit();
                }
            }
            return version;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasName() {
            boolean zHasName;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zHasName = this._xs.hasName();
                } finally {
                    this._l.exit();
                }
            }
            return zHasName;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasNext() throws XMLStreamException {
            boolean zHasNext;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zHasNext = this._xs.hasNext();
                } finally {
                    this._l.exit();
                }
            }
            return zHasNext;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean hasText() {
            boolean zHasText;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zHasText = this._xs.hasText();
                } finally {
                    this._l.exit();
                }
            }
            return zHasText;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isAttributeSpecified(int i2) {
            boolean zIsAttributeSpecified;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsAttributeSpecified = this._xs.isAttributeSpecified(i2);
                } finally {
                    this._l.exit();
                }
            }
            return zIsAttributeSpecified;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isCharacters() {
            boolean zIsCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsCharacters = this._xs.isCharacters();
                } finally {
                    this._l.exit();
                }
            }
            return zIsCharacters;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isEndElement() {
            boolean zIsEndElement;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsEndElement = this._xs.isEndElement();
                } finally {
                    this._l.exit();
                }
            }
            return zIsEndElement;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStandalone() {
            boolean zIsStandalone;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsStandalone = this._xs.isStandalone();
                } finally {
                    this._l.exit();
                }
            }
            return zIsStandalone;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isStartElement() {
            boolean zIsStartElement;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsStartElement = this._xs.isStartElement();
                } finally {
                    this._l.exit();
                }
            }
            return zIsStartElement;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            boolean zIsWhiteSpace;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zIsWhiteSpace = this._xs.isWhiteSpace();
                } finally {
                    this._l.exit();
                }
            }
            return zIsWhiteSpace;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            int next;
            synchronized (this._l) {
                this._l.enter();
                try {
                    next = this._xs.next();
                } finally {
                    this._l.exit();
                }
            }
            return next;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int nextTag() throws XMLStreamException {
            int iNextTag;
            synchronized (this._l) {
                this._l.enter();
                try {
                    iNextTag = this._xs.nextTag();
                } finally {
                    this._l.exit();
                }
            }
            return iNextTag;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public void require(int i2, String str, String str2) throws XMLStreamException {
            synchronized (this._l) {
                this._l.enter();
                try {
                    this._xs.require(i2, str, str2);
                } finally {
                    this._l.exit();
                }
            }
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public boolean standaloneSet() {
            boolean zStandaloneSet;
            synchronized (this._l) {
                this._l.enter();
                try {
                    zStandaloneSet = this._xs.standaloneSet();
                } finally {
                    this._l.exit();
                }
            }
            return zStandaloneSet;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getAttributeValue(int i2) {
            String attributeValue;
            synchronized (this._l) {
                this._l.enter();
                try {
                    attributeValue = this._xs.getAttributeValue(i2);
                } finally {
                    this._l.exit();
                }
            }
            return attributeValue;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI(int i2) {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI(i2);
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }

        @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            String prefix;
            synchronized (this._l) {
                this._l.enter();
                try {
                    prefix = this._xs.getPrefix(str);
                } finally {
                    this._l.exit();
                }
            }
            return prefix;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i2, char[] cArr, int i3, int i4) throws XMLStreamException {
            int textCharacters;
            synchronized (this._l) {
                this._l.enter();
                try {
                    textCharacters = this._xs.getTextCharacters(i2, cArr, i3, i4);
                } finally {
                    this._l.exit();
                }
            }
            return textCharacters;
        }

        @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
        public String getNamespaceURI() {
            String namespaceURI;
            synchronized (this._l) {
                this._l.enter();
                try {
                    namespaceURI = this._xs.getNamespaceURI();
                } finally {
                    this._l.exit();
                }
            }
            return namespaceURI;
        }
    }
}
