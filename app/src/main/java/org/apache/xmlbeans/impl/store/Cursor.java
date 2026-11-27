package org.apache.xmlbeans.impl.store;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.store.Saver;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathFactory;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

/* loaded from: classes.dex */
public final class Cursor implements XmlCursor, Locale.ChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    private static final int COPY_CHARS = 5;
    private static final int COPY_XML = 1;
    private static final int COPY_XML_CONTENTS = 3;
    static final int ELEM = 2;
    private static final int MOVE_CHARS = 4;
    private static final int MOVE_XML = 0;
    private static final int MOVE_XML_CONTENTS = 2;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    private Cur _cur;
    private int _currentSelection;
    private Locale.ChangeListener _nextChangeListener;
    private XPathEngine _pathEngine;

    private static final class ChangeStampImpl implements XmlCursor.ChangeStamp {
        private final Locale _locale;
        private final long _versionStamp;

        ChangeStampImpl(Locale locale) {
            this._locale = locale;
            this._versionStamp = locale.version();
        }

        @Override // org.apache.xmlbeans.XmlCursor.ChangeStamp
        public boolean hasChanged() {
            return this._versionStamp != this._locale.version();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface WrapIOEx {
        void run() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface WrapSAXEx {
        void run() throws SAXException;
    }

    Cursor(Xobj xobj, int i2) {
        Cur curWeakCur = xobj._locale.weakCur(this);
        this._cur = curWeakCur;
        curWeakCur.moveTo(xobj, i2);
        this._currentSelection = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean E0(Cursor cursor) {
        return Boolean.valueOf(_isAtSamePositionAs(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean E1(XmlCursor.XmlBookmark xmlBookmark) {
        return Boolean.valueOf(_toBookmark(xmlBookmark));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer G(Cursor cursor) {
        return Integer.valueOf(_comparePosition(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean G0(Cursor cursor) {
        return Boolean.valueOf(_isLeftOf(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean G1(String str) {
        return Boolean.valueOf(_toChild(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean I0(Cursor cursor) {
        return Boolean.valueOf(_isRightOf(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean I1(String str, String str2) {
        return Boolean.valueOf(_toChild(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean K1(QName qName) {
        return Boolean.valueOf(_toChild(qName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean M1(int i2) {
        return Boolean.valueOf(_toChild(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean O1(QName qName, int i2) {
        return Boolean.valueOf(_toChild(qName, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean Q1(Cursor cursor) {
        return Boolean.valueOf(_toCursor(cursor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer U(char[] cArr, int i2, int i3) {
        return Integer.valueOf(_getChars(cArr, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer U1(int i2) {
        return Integer.valueOf(_toNextChar(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer W(char[] cArr, int i2, int i3) {
        return Integer.valueOf(_getTextValue(cArr, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean W0(QName qName) {
        return Boolean.valueOf(_removeAttribute(qName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean W1(String str) {
        return Boolean.valueOf(_toNextSibling(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer Y0(int i2) {
        return Integer.valueOf(_removeChars(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean Y1(String str, String str2) {
        return Boolean.valueOf(_toNextSibling(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a2(QName qName) {
        return Boolean.valueOf(_toNextSibling(qName));
    }

    private boolean checkContentInsertionValidity(Cursor cursor) {
        this._cur.push();
        this._cur.next();
        if (this._cur.isFinish()) {
            this._cur.pop();
            return false;
        }
        try {
            cursor.checkInsertionValidity(this._cur);
            this._cur.pop();
            return true;
        } catch (IllegalArgumentException e) {
            this._cur.pop();
            throw e;
        }
    }

    private Cursor checkCursors(XmlCursor xmlCursor) {
        checkThisCursor();
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Other cursor is <null>");
        }
        if (xmlCursor instanceof Cursor) {
            Cursor cursor = (Cursor) xmlCursor;
            if (cursor._cur != null) {
                return cursor;
            }
            throw new IllegalStateException("Other cursor has been disposed");
        }
        throw new IllegalArgumentException("Incompatible cursors: " + xmlCursor);
    }

    private void checkInsertionValidity(Cur cur) {
        int iKind = cur.kind();
        if (iKind < 0) {
            complain("Can't move/copy/insert an end token.");
        }
        if (iKind == 1) {
            complain("Can't move/copy/insert a whole document.");
        }
        int iKind2 = this._cur.kind();
        if (iKind2 == 1) {
            complain("Can't insert before the start of the document.");
        }
        if (iKind == 3) {
            this._cur.push();
            this._cur.prevWithAttrs();
            int iKind3 = this._cur.kind();
            this._cur.pop();
            if (iKind3 != 2 && iKind3 != 1 && iKind3 != -3) {
                complain("Can only insert attributes before other attributes or after containers.");
            }
        }
        if (iKind2 != 3 || iKind == 3) {
            return;
        }
        complain("Can only insert attributes before other attributes or after containers.");
    }

    private void checkThisCursor() {
        if (this._cur == null) {
            throw new IllegalStateException("This cursor has been disposed");
        }
    }

    private static void complain(String str) {
        throw new IllegalArgumentException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer e2(int i2) {
        return Integer.valueOf(_toPrevChar(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean g2(int i2) {
        return Boolean.valueOf(_toSelection(i2));
    }

    static XmlCursor.XmlBookmark getBookmark(Object obj, Cur cur) {
        if (obj == null) {
            return null;
        }
        Object bookmark = cur.getBookmark(obj);
        if (bookmark instanceof XmlCursor.XmlBookmark) {
            return (XmlCursor.XmlBookmark) bookmark;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer i2(Cursor cursor, int i2, int i3) {
        return Integer.valueOf(twoLocaleOp(cursor, i2, i3));
    }

    private void insertNode(Cur cur, String str) {
        if (str != null && str.length() > 0) {
            cur.next();
            cur.insertString(str);
            cur.toParent();
        }
        checkInsertionValidity(cur);
        cur.moveNode(this._cur);
        this._cur.toEnd();
        this._cur.nextWithAttrs();
    }

    private boolean isDomFragment() {
        int iIntValue;
        if (!isStartdoc()) {
            return true;
        }
        boolean z = false;
        XmlCursor xmlCursorNewCursor = newCursor();
        try {
            iIntValue = xmlCursorNewCursor.toNextToken().intValue();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
        while (true) {
            switch (iIntValue) {
                case 0:
                case 1:
                case 2:
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return !z;
                case 3:
                    if (z) {
                        if (xmlCursorNewCursor != null) {
                            xmlCursorNewCursor.close();
                        }
                        return true;
                    }
                    iIntValue = xmlCursorNewCursor.toEndToken().intValue();
                    z = true;
                    continue;
                case 4:
                case 8:
                case 9:
                    iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                    continue;
                case 5:
                    if (!Locale.isWhiteSpace(xmlCursorNewCursor.getChars())) {
                        if (xmlCursorNewCursor != null) {
                            xmlCursorNewCursor.close();
                        }
                        return true;
                    }
                    iIntValue = xmlCursorNewCursor.toNextToken().intValue();
                    continue;
                case 6:
                case 7:
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return true;
            }
            throw th;
        }
    }

    private static boolean isValid(Cur cur) {
        int iKind;
        if (cur.kind() > 0) {
            return true;
        }
        cur.push();
        if (cur.toParentRaw() && ((iKind = cur.kind()) == 4 || iKind == 5 || iKind == 3)) {
            return false;
        }
        cur.pop();
        return true;
    }

    public static XmlCursor newCursor(Xobj xobj, int i2) {
        Cursor cursor;
        Locale locale = xobj._locale;
        if (locale.noSync()) {
            locale.enter();
            try {
                return new Cursor(xobj, i2);
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                cursor = new Cursor(xobj, i2);
            } finally {
            }
        }
        return cursor;
    }

    private Cursor preCheck(XmlCursor xmlCursor) {
        Cursor cursorCheckCursors = checkCursors(xmlCursor);
        if (this._cur._locale == cursorCheckCursors._cur._locale) {
            return cursorCheckCursors;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    private void setTextValue(Object obj, int i2, int i3) {
        if (!this._cur.isNode()) {
            throw new IllegalStateException("Can't set text value, current token can have no text value");
        }
        this._cur.moveNodeContents(null, false);
        this._cur.next();
        this._cur.insertChars(obj, i2, i3);
        this._cur.toParent();
    }

    private void syncWrap(Runnable runnable) {
        if (preCheck()) {
            syncWrapHelper(runnable, true);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(runnable, true);
        }
    }

    private void syncWrapHelper(Runnable runnable, boolean z) {
        Locale locale = this._cur._locale;
        if (z) {
            locale.enter();
        }
        try {
            runnable.run();
        } finally {
            if (z) {
                locale.exit();
            }
        }
    }

    private void syncWrapIOEx(WrapIOEx wrapIOEx) throws IOException {
        if (preCheck()) {
            syncWrapHelper(wrapIOEx);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(wrapIOEx);
        }
    }

    private <T> T syncWrapNoEnter(Supplier<T> supplier) {
        T t;
        if (preCheck()) {
            return (T) syncWrapHelper((Supplier) supplier, false);
        }
        synchronized (this._cur._locale) {
            t = (T) syncWrapHelper((Supplier) supplier, false);
        }
        return t;
    }

    private void syncWrapSAXEx(WrapSAXEx wrapSAXEx) throws SAXException {
        if (preCheck()) {
            syncWrapHelper(wrapSAXEx);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(wrapSAXEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean u1(QName qName, String str) {
        return Boolean.valueOf(_setAttributeText(qName, str));
    }

    private int twoLocaleOp(XmlCursor xmlCursor, final int i2, final int i3) throws Throwable {
        int iTwoLocaleOp;
        int iTwoLocaleOp2;
        final Cursor cursorCheckCursors = checkCursors(xmlCursor);
        Locale locale = this._cur._locale;
        Locale locale2 = cursorCheckCursors._cur._locale;
        if (locale == locale2) {
            return ((Integer) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.z
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.a.i2(cursorCheckCursors, i2, i3);
                }
            })).intValue();
        }
        if (locale.noSync()) {
            if (locale2.noSync()) {
                return twoLocaleOp(cursorCheckCursors, i2, i3);
            }
            synchronized (locale2) {
                iTwoLocaleOp2 = twoLocaleOp(cursorCheckCursors, i2, i3);
            }
            return iTwoLocaleOp2;
        }
        if (locale2.noSync()) {
            synchronized (locale) {
                iTwoLocaleOp = twoLocaleOp(cursorCheckCursors, i2, i3);
            }
            return iTwoLocaleOp;
        }
        boolean z = false;
        try {
            try {
                GlobalLock.acquire();
            } catch (InterruptedException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                synchronized (locale) {
                    try {
                        try {
                            synchronized (locale2) {
                                try {
                                    GlobalLock.release();
                                    return twoLocaleOp(cursorCheckCursors, i2, i3);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z = true;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (InterruptedException e2) {
            e = e2;
            z = true;
            throw new RuntimeException(e.getMessage(), e);
        } catch (Throwable th6) {
            th = th6;
            z = true;
            if (z) {
                GlobalLock.release();
            }
            throw th;
        }
    }

    static void validateLocalName(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("QName is null");
        }
        validateLocalName(qName.getLocalPart());
    }

    static void validatePrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Prefix is null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Prefix is empty");
        }
        if (Locale.beginsWithXml(str)) {
            throw new IllegalArgumentException("Prefix begins with 'xml'");
        }
        if (!XMLChar.isValidNCName(str)) {
            throw new IllegalArgumentException("Prefix is not valid");
        }
    }

    public boolean ___toNextSibling() {
        if (!this._cur.hasParent()) {
            return false;
        }
        Xobj parentNoRoot = this._cur.getParentNoRoot();
        if (parentNoRoot == null) {
            this._cur._locale.enter();
            try {
                parentNoRoot = this._cur.getParent();
            } finally {
                this._cur._locale.exit();
            }
        }
        return Locale.toNextSiblingElement(this._cur, parentNoRoot);
    }

    public void _addToSelection() {
        _toSelection(Integer.MAX_VALUE);
        this._cur.addToSelection();
    }

    /* renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void x(String str) {
        x0(str, null, null);
        _toPrevToken();
    }

    /* renamed from: _clearBookmark, reason: merged with bridge method [inline-methods] */
    public void D(Object obj) {
        if (obj != null) {
            this._cur.setBookmark(obj, null);
        }
    }

    public void _clearSelections() {
        XPathEngine xPathEngine = this._pathEngine;
        if (xPathEngine != null) {
            xPathEngine.release();
            this._pathEngine = null;
        }
        this._cur.clearSelection();
        this._currentSelection = -1;
    }

    public int _comparePosition(Cursor cursor) {
        int iComparePosition = this._cur.comparePosition(cursor._cur);
        if (iComparePosition != 2) {
            return iComparePosition;
        }
        throw new IllegalArgumentException("Cursors not in same document");
    }

    public int _copyChars(int i2, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i2 == 0) {
            return 0;
        }
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        Cur cur = cursor._cur;
        Object chars = this._cur.getChars(i2);
        Cur cur2 = this._cur;
        cur.insertChars(chars, cur2._offSrc, cur2._cchSrc);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public boolean _copyXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        Cur curTempCur = cursor.tempCur();
        if (this._cur.isText()) {
            Cur cur = cursor._cur;
            Object chars = this._cur.getChars(-1);
            Cur cur2 = this._cur;
            cur.insertChars(chars, cur2._offSrc, cur2._cchSrc);
        } else {
            this._cur.copyNode(cursor._cur);
        }
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _copyXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur curTempCur = this._cur._locale.tempCur();
        this._cur.copyNode(curTempCur);
        Cur curTempCur2 = cursor._cur.tempCur();
        curTempCur.moveNodeContents(cursor._cur, false);
        curTempCur.release();
        cursor._cur.moveToCur(curTempCur2);
        curTempCur2.release();
        return true;
    }

    public XmlCursor.TokenType _currentTokenType() {
        switch (this._cur.kind()) {
            case -2:
                return XmlCursor.TokenType.END;
            case -1:
                return XmlCursor.TokenType.ENDDOC;
            case 0:
                return XmlCursor.TokenType.TEXT;
            case 1:
                return XmlCursor.TokenType.STARTDOC;
            case 2:
                return XmlCursor.TokenType.START;
            case 3:
                return this._cur.isXmlns() ? XmlCursor.TokenType.NAMESPACE : XmlCursor.TokenType.ATTR;
            case 4:
                return XmlCursor.TokenType.COMMENT;
            case 5:
                return XmlCursor.TokenType.PROCINST;
            default:
                throw new IllegalStateException();
        }
    }

    public void _dispose() {
        this._cur.release();
        this._cur = null;
    }

    public XmlDocumentProperties _documentProperties() {
        return Locale.getDocProps(this._cur, true);
    }

    public void _dump() {
        this._cur.dump();
    }

    /* renamed from: _execQuery, reason: merged with bridge method [inline-methods] */
    public XmlCursor I(String str) {
        return J(str, null);
    }

    /* renamed from: _getAllBookmarkRefs, reason: merged with bridge method [inline-methods] */
    public void M(Collection<Object> collection) {
        if (collection != null) {
            for (Bookmark bookmark = this._cur._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                Object obj = bookmark._value;
                if (obj instanceof XmlCursor.XmlBookmark) {
                    collection.add(obj);
                }
            }
        }
    }

    /* renamed from: _getAllNamespaces, reason: merged with bridge method [inline-methods] */
    public void O(Map<String, String> map) {
        if (!this._cur.isContainer()) {
            throw new IllegalStateException("Not on a container");
        }
        if (map != null) {
            Locale.getAllNamespaces(this._cur, map);
        }
    }

    /* renamed from: _getAttributeText, reason: merged with bridge method [inline-methods] */
    public String Q(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.getAttrValue(qName);
        }
        return null;
    }

    /* renamed from: _getBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark S(Object obj) {
        if (obj == null) {
            return null;
        }
        return getBookmark(obj, this._cur);
    }

    public String _getChars() {
        return this._cur.getCharsAsString();
    }

    public XmlCursor.ChangeStamp _getDocChangeStamp() {
        return new ChangeStampImpl(this._cur._locale);
    }

    public Node _getDomNode() {
        return (Node) this._cur.getDom();
    }

    public QName _getName() {
        int iKind = this._cur.kind();
        if (iKind != 2) {
            if (iKind != 3) {
                if (iKind != 5) {
                    return null;
                }
            } else if (this._cur.isXmlns()) {
                Cur cur = this._cur;
                return cur._locale.makeQNameNoCheck(cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
            }
        }
        return this._cur.getName();
    }

    public XmlObject _getObject() {
        return this._cur.getObject();
    }

    public int _getSelectionCount() {
        _toSelection(Integer.MAX_VALUE);
        return this._cur.selectionCount();
    }

    public String _getTextValue() {
        if (this._cur.isText()) {
            return _getChars();
        }
        if (this._cur.isNode()) {
            return this._cur.hasChildren() ? Locale.getTextValue(this._cur) : this._cur.getValueAsString();
        }
        throw new IllegalStateException("Can't get text value, current token can have no text value");
    }

    public boolean _hasNextSelection() {
        int i2 = this._currentSelection;
        push();
        try {
            return _toNextSelection();
        } finally {
            this._currentSelection = i2;
            pop();
        }
    }

    public boolean _hasNextToken() {
        Cur cur = this._cur;
        return (cur._pos == -1 && cur._xobj.kind() == 1) ? false : true;
    }

    public boolean _hasPrevToken() {
        return this._cur.kind() != 1;
    }

    /* renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void Y(String str) {
        d0(str, (String) null);
    }

    /* renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void e0(String str, String str2) {
        f0(str, null, str2);
    }

    /* renamed from: _insertChars, reason: merged with bridge method [inline-methods] */
    public void k0(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            if (this._cur.isRoot() || this._cur.isAttr()) {
                throw new IllegalStateException("Can't insert before the document or an attribute.");
            }
            this._cur.insertChars(str, 0, length);
            this._cur.nextChars(length);
        }
    }

    /* renamed from: _insertComment, reason: merged with bridge method [inline-methods] */
    public void m0(String str) {
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createComment();
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    /* renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void q0(String str) {
        x0(str, null, null);
    }

    /* renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void w0(String str, String str2) {
        x0(str, null, str2);
    }

    /* renamed from: _insertNamespace, reason: merged with bridge method [inline-methods] */
    public void A0(String str, String str2) {
        h0(this._cur._locale.createXmlns(str), str2);
    }

    /* renamed from: _insertProcInst, reason: merged with bridge method [inline-methods] */
    public void C0(String str, String str2) {
        validateLocalName(str);
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new IllegalArgumentException("Target is 'xml'");
        }
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createProcinst(str);
        insertNode(curTempCur, str2);
        curTempCur.release();
    }

    public boolean _isAnyAttr() {
        return this._cur.isAttr();
    }

    public boolean _isAtSamePositionAs(Cursor cursor) {
        return this._cur.isSamePos(cursor._cur);
    }

    public boolean _isAttr() {
        return this._cur.isNormalAttr();
    }

    public boolean _isComment() {
        return this._cur.isComment();
    }

    public boolean _isContainer() {
        return this._cur.isContainer();
    }

    public boolean _isEnd() {
        return this._cur.isEnd();
    }

    public boolean _isEnddoc() {
        return this._cur.isEndRoot();
    }

    public boolean _isFinish() {
        return this._cur.isFinish();
    }

    public boolean _isLeftOf(Cursor cursor) {
        return _comparePosition(cursor) < 0;
    }

    public boolean _isNamespace() {
        return this._cur.isXmlns();
    }

    public boolean _isProcinst() {
        return this._cur.isProcinst();
    }

    public boolean _isRightOf(Cursor cursor) {
        return _comparePosition(cursor) > 0;
    }

    public boolean _isStart() {
        return this._cur.isElem();
    }

    public boolean _isStartdoc() {
        return this._cur.isRoot();
    }

    public boolean _isText() {
        return this._cur.isText();
    }

    public Object _monitor() {
        return this._cur._locale;
    }

    public int _moveChars(int i2, Cursor cursor) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight <= 0 || i2 == 0) {
            return 0;
        }
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        cursor.checkInsertionValidity(this._cur);
        this._cur.moveChars(cursor._cur, i2);
        cursor._cur.nextChars(this._cur._cchSrc);
        return this._cur._cchSrc;
    }

    public boolean _moveXml(Cursor cursor) {
        cursor.checkInsertionValidity(this._cur);
        if (this._cur.isText()) {
            int iCchRight = this._cur.cchRight();
            if (this._cur.inChars(cursor._cur, iCchRight, true)) {
                return false;
            }
            this._cur.moveChars(cursor._cur, iCchRight);
            cursor._cur.nextChars(iCchRight);
            return true;
        }
        if (this._cur.contains(cursor._cur)) {
            return false;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNode(cursor._cur);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _moveXmlContents(Cursor cursor) {
        if (!this._cur.isContainer() || this._cur.contains(cursor._cur) || !checkContentInsertionValidity(cursor)) {
            return false;
        }
        Cur curTempCur = cursor.tempCur();
        this._cur.moveNodeContents(cursor._cur, false);
        cursor._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    /* renamed from: _namespaceForPrefix, reason: merged with bridge method [inline-methods] */
    public String K0(String str) {
        if (this._cur.isContainer()) {
            return this._cur.namespaceForPrefix(str, true);
        }
        throw new IllegalStateException("Not on a container");
    }

    public XmlCursor _newCursor() {
        return new Cursor(this._cur);
    }

    public Node _newDomNode() {
        return L0(null);
    }

    public InputStream _newInputStream() {
        return N0(null);
    }

    public Reader _newReader() {
        return P0(null);
    }

    public XMLStreamReader _newXMLStreamReader() {
        return R0(null);
    }

    public boolean _pop() {
        return this._cur.pop();
    }

    /* renamed from: _prefixForNamespace, reason: merged with bridge method [inline-methods] */
    public String U0(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Must specify a namespace");
        }
        return this._cur.prefixForNamespace(str, null, true);
    }

    public XmlCursor.TokenType _prevTokenType() {
        this._cur.push();
        XmlCursor.TokenType tokenType_toPrevToken = _toPrevToken();
        this._cur.pop();
        return tokenType_toPrevToken;
    }

    public void _push() {
        this._cur.push();
    }

    public boolean _removeAttribute(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        if (this._cur.isContainer()) {
            return this._cur.removeAttr(qName);
        }
        return false;
    }

    public int _removeChars(int i2) {
        int iCchRight = this._cur.cchRight();
        if (iCchRight == 0 || i2 == 0) {
            return 0;
        }
        if (i2 < 0 || i2 > iCchRight) {
            i2 = iCchRight;
        }
        this._cur.moveChars(null, i2);
        return this._cur._cchSrc;
    }

    public boolean _removeXml() {
        if (this._cur.isRoot()) {
            throw new IllegalStateException("Can't remove a whole document.");
        }
        if (this._cur.isFinish()) {
            return false;
        }
        if (this._cur.isText()) {
            this._cur.moveChars(null, -1);
            return true;
        }
        this._cur.moveNode(null);
        return true;
    }

    public boolean _removeXmlContents() {
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.moveNodeContents(null, false);
        return true;
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void m1(File file) throws IOException {
        d1(file, (XmlOptions) null);
    }

    /* renamed from: _selectPath, reason: merged with bridge method [inline-methods] */
    public void q1(String str) {
        r1(str, null);
    }

    public boolean _setAttributeText(QName qName, String str) {
        if (qName == null) {
            throw new IllegalArgumentException("Attr name is null");
        }
        validateLocalName(qName.getLocalPart());
        if (!this._cur.isContainer()) {
            return false;
        }
        this._cur.setAttrValue(qName, str);
        return true;
    }

    /* renamed from: _setBookmark, reason: merged with bridge method [inline-methods] */
    public void w1(XmlCursor.XmlBookmark xmlBookmark) {
        if (xmlBookmark != null) {
            if (xmlBookmark.getKey() == null) {
                throw new IllegalArgumentException("Annotation key is null");
            }
            xmlBookmark._currentMark = this._cur.setBookmark(xmlBookmark.getKey(), xmlBookmark);
        }
    }

    /* renamed from: _setName, reason: merged with bridge method [inline-methods] */
    public void y1(QName qName) {
        if (qName == null) {
            throw new IllegalArgumentException("Name is null");
        }
        int iKind = this._cur.kind();
        if (iKind == 2 || iKind == 3) {
            validateLocalName(qName.getLocalPart());
        } else {
            if (iKind != 5) {
                throw new IllegalStateException("Can set name on element, atrtribute and procinst only");
            }
            validatePrefix(qName.getLocalPart());
            if (qName.getNamespaceURI().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no URI");
            }
            if (qName.getPrefix().length() > 0) {
                throw new IllegalArgumentException("Procinst name must have no prefix");
            }
        }
        this._cur.setName(qName);
    }

    /* renamed from: _setTextValue, reason: merged with bridge method [inline-methods] */
    public void A1(String str) {
        if (str == null) {
            str = "";
        }
        setTextValue(str, 0, str.length());
    }

    public boolean _toBookmark(XmlCursor.XmlBookmark xmlBookmark) {
        Bookmark bookmark;
        Xobj xobj;
        if (xmlBookmark != null) {
            XmlCursor.XmlMark xmlMark = xmlBookmark._currentMark;
            if ((xmlMark instanceof Bookmark) && (xobj = (bookmark = (Bookmark) xmlMark)._xobj) != null) {
                Locale locale = xobj._locale;
                Cur cur = this._cur;
                if (locale == cur._locale) {
                    cur.moveTo(xobj, bookmark._pos);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean _toChild(String str) {
        return _toChild((String) null, str);
    }

    public boolean _toCursor(Cursor cursor) {
        this._cur.moveToCur(cursor._cur);
        return true;
    }

    public void _toEndDoc() {
        _toStartDoc();
        this._cur.toEnd();
    }

    public XmlCursor.TokenType _toEndToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.toEnd();
        return currentTokenType();
    }

    public boolean _toFirstAttribute() {
        return this._cur.isContainer() && Locale.toFirstNormalAttr(this._cur);
    }

    public boolean _toFirstChild() {
        return Locale.toFirstChildElement(this._cur);
    }

    public XmlCursor.TokenType _toFirstContentToken() {
        if (!this._cur.isContainer()) {
            return XmlCursor.TokenType.NONE;
        }
        this._cur.next();
        return currentTokenType();
    }

    public boolean _toLastAttribute() {
        if (this._cur.isContainer()) {
            this._cur.push();
            this._cur.push();
            boolean z = false;
            while (this._cur.toNextAttr()) {
                if (this._cur.isNormalAttr()) {
                    this._cur.popButStay();
                    this._cur.push();
                    z = true;
                }
            }
            this._cur.pop();
            if (z) {
                this._cur.popButStay();
                return true;
            }
            this._cur.pop();
        }
        return false;
    }

    public boolean _toLastChild() {
        return Locale.toLastChildElement(this._cur);
    }

    public boolean _toNextAttribute() {
        return this._cur.isAttr() && Locale.toNextNormalAttr(this._cur);
    }

    /* renamed from: _toNextBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark S1(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchRight = this._cur.cchRight();
            if (iCchRight > 1) {
                this._cur.nextChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInChars = cur.firstBookmarkInChars(obj, iCchRight - 1);
                if (iFirstBookmarkInChars < 0) {
                    iFirstBookmarkInChars = -1;
                }
                cur.nextChars(iFirstBookmarkInChars);
            } else if (_toNextToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != -1);
        this._cur.pop();
        return null;
    }

    public int _toNextChar(int i2) {
        return this._cur.nextChars(i2);
    }

    public boolean _toNextSelection() {
        return _toSelection(this._currentSelection + 1);
    }

    public boolean _toNextSibling(String str) {
        return _toNextSibling(new QName(str));
    }

    public XmlCursor.TokenType _toNextToken() {
        int iKind = this._cur.kind();
        if (iKind == 1 || iKind == 2) {
            if (!this._cur.toFirstAttr()) {
                this._cur.next();
            }
        } else if (iKind != 3) {
            if (iKind == 4 || iKind == 5) {
                this._cur.skip();
            } else if (!this._cur.next()) {
                return XmlCursor.TokenType.NONE;
            }
        } else if (!this._cur.toNextSibling()) {
            this._cur.toParent();
            this._cur.next();
        }
        return _currentTokenType();
    }

    public boolean _toParent() {
        Cur curTempCur = this._cur.tempCur();
        if (!curTempCur.toParent()) {
            return false;
        }
        this._cur.moveToCur(curTempCur);
        curTempCur.release();
        return true;
    }

    public boolean _toPrevAttribute() {
        return this._cur.isAttr() && Locale.toPrevNormalAttr(this._cur);
    }

    /* renamed from: _toPrevBookmark, reason: merged with bridge method [inline-methods] */
    public XmlCursor.XmlBookmark c2(Object obj) {
        if (obj == null) {
            return null;
        }
        this._cur.push();
        do {
            int iCchLeft = this._cur.cchLeft();
            if (iCchLeft > 1) {
                this._cur.prevChars(1);
                Cur cur = this._cur;
                int iFirstBookmarkInCharsLeft = cur.firstBookmarkInCharsLeft(obj, iCchLeft - 1);
                if (iFirstBookmarkInCharsLeft < 0) {
                    iFirstBookmarkInCharsLeft = -1;
                }
                cur.prevChars(iFirstBookmarkInCharsLeft);
            } else if (iCchLeft == 1) {
                this._cur.prevChars(1);
            } else if (_toPrevToken().isNone()) {
                this._cur.pop();
                return null;
            }
            XmlCursor.XmlBookmark bookmark = getBookmark(obj, this._cur);
            if (bookmark != null) {
                this._cur.popButStay();
                return bookmark;
            }
        } while (this._cur.kind() != 1);
        this._cur.pop();
        return null;
    }

    public int _toPrevChar(int i2) {
        return this._cur.prevChars(i2);
    }

    public boolean _toPrevSibling() {
        return Locale.toPrevSiblingElement(this._cur);
    }

    public XmlCursor.TokenType _toPrevToken() {
        boolean zIsText = this._cur.isText();
        if (this._cur.prev()) {
            int iKind = this._cur.kind();
            if (iKind == -4 || iKind == -5 || iKind == -3) {
                this._cur.toParent();
            } else if (this._cur.isContainer()) {
                this._cur.toLastAttr();
            } else if (zIsText && this._cur.isText()) {
                return _toPrevToken();
            }
        } else {
            if (this._cur.isRoot()) {
                return XmlCursor.TokenType.NONE;
            }
            this._cur.toParent();
        }
        return _currentTokenType();
    }

    public boolean _toSelection(int i2) {
        if (i2 < 0) {
            return false;
        }
        while (i2 >= this._cur.selectionCount()) {
            XPathEngine xPathEngine = this._pathEngine;
            if (xPathEngine == null) {
                return false;
            }
            if (!xPathEngine.next(this._cur)) {
                this._pathEngine.release();
                this._pathEngine = null;
                return false;
            }
        }
        Cur cur = this._cur;
        this._currentSelection = i2;
        cur.moveToSelection(i2);
        return true;
    }

    public void _toStartDoc() {
        this._cur.toRoot();
    }

    public String _xmlText() {
        return j2(null);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void addToSelection() {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.e9
            @Override // java.lang.Runnable
            public final void run() {
                this.c._addToSelection();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(final QName qName) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.g2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u(qName);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearBookmark(final Object obj) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.D(obj);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void clearSelections() {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.m8
            @Override // java.lang.Runnable
            public final void run() {
                this.c._clearSelections();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor, java.lang.AutoCloseable
    public void close() {
        if (this._cur != null) {
            syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.a9
                @Override // java.lang.Runnable
                public final void run() {
                    this.c._dispose();
                }
            });
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int comparePosition(XmlCursor xmlCursor) {
        final Cursor cursorPreCheck = preCheck(xmlCursor);
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.y0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.G(cursorPreCheck);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int copyChars(int i2, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 5, i2);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 1, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean copyXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 3, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType currentTokenType() {
        return (XmlCursor.TokenType) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.d8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._currentTokenType();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    @Deprecated
    public void dispose() {
        close();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        return (XmlDocumentProperties) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._documentProperties();
            }
        });
    }

    public void dump(PrintStream printStream) {
        this._cur.dump(printStream);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(final String str) {
        return (XmlCursor) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.u0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.I(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllBookmarkRefs(final Collection<Object> collection) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.M(collection);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void getAllNamespaces(final Map<String, String> map) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.z1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.O(map);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getAttributeText(final QName qName) {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.f1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.Q(qName);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getChars() {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.f7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getChars();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.ChangeStamp getDocChangeStamp() {
        return (XmlCursor.ChangeStamp) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.u7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getDocChangeStamp();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        return (Node) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.i7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getDomNode();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public QName getName() {
        return (QName) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.o8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getName();
            }
        });
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public Locale.ChangeListener getNextChangeListener() {
        return this._nextChangeListener;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlObject getObject() {
        return (XmlObject) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.f
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getObject();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getSelectionCount() {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.j8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Integer.valueOf(this.a._getSelectionCount());
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String getTextValue() {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.f8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._getTextValue();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextSelection() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.r8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._hasNextSelection());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasNextToken() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.m9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._hasNextToken());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean hasPrevToken() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.s7
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._hasPrevToken());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Y(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.x0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertChars(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.d1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.k0(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertComment(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.o1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.m0(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(final QName qName) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o0(qName);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(final QName qName, final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u0(qName, str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertNamespace(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.y1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.A0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertProcInst(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.b1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.C0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAnyAttr() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.p9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isAnyAttr());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAtSamePositionAs(XmlCursor xmlCursor) {
        final Cursor cursorPreCheck = preCheck(xmlCursor);
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.k1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.E0(cursorPreCheck);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isAttr() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.v7
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isAttr());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isComment() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.n9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isComment());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isContainer() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isContainer());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnd() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.b9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isEnd());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isEnddoc() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.j
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isEnddoc());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isFinish() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.q8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isFinish());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isInSameDocument(XmlCursor xmlCursor) {
        return xmlCursor != null && this._cur.isInSameTree(checkCursors(xmlCursor)._cur);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isLeftOf(XmlCursor xmlCursor) {
        final Cursor cursorPreCheck = preCheck(xmlCursor);
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.w
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.G0(cursorPreCheck);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isNamespace() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.h
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isNamespace());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isProcinst() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.k8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isProcinst());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isRightOf(XmlCursor xmlCursor) {
        final Cursor cursorPreCheck = preCheck(xmlCursor);
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.I0(cursorPreCheck);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStart() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.l7
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isStart());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isStartdoc() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.o
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isStartdoc());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean isText() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.k
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._isText());
            }
        })).booleanValue();
    }

    Locale locale() {
        return this._cur._locale;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        return syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.g8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._monitor();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int moveChars(int i2, XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 4, i2);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXml(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 0, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean moveXmlContents(XmlCursor xmlCursor) {
        return twoLocaleOp(xmlCursor, 2, 0) == 1;
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String namespaceForPrefix(final String str) {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.e2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.K0(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return (Node) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.z8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._newDomNode();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return (InputStream) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.x8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._newInputStream();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return (Reader) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.i8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._newReader();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return (XMLStreamReader) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._newXMLStreamReader();
            }
        });
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void notifyChange() {
        if (this._cur != null) {
            _getSelectionCount();
        }
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean pop() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._pop());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public String prefixForNamespace(final String str) {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.u
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.U0(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType prevTokenType() {
        return (XmlCursor.TokenType) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.l
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._prevTokenType();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void push() {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.f9
            @Override // java.lang.Runnable
            public final void run() {
                this.c._push();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeAttribute(final QName qName) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.h1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.W0(qName);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int removeChars(final int i2) {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.s
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.Y0(i2);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXml() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.h9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._removeXml());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean removeXmlContents() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.u6
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._removeXmlContents());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final ContentHandler contentHandler, final LexicalHandler lexicalHandler) throws SAXException {
        syncWrapSAXEx(new WrapSAXEx() { // from class: org.apache.xmlbeans.impl.store.t1
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapSAXEx
            public final void run() throws SAXException {
                this.a.k1(contentHandler, lexicalHandler);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.x
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q1(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean setAttributeText(final QName qName, final String str) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.r
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.u1(qName, str);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setBookmark(final XmlCursor.XmlBookmark xmlBookmark) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.b2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w1(xmlBookmark);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setName(final QName qName) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.w1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.y1(qName);
            }
        });
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.ChangeListener
    public void setNextChangeListener(Locale.ChangeListener changeListener) {
        this._nextChangeListener = changeListener;
    }

    Cur tempCur() {
        return this._cur.tempCur();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toBookmark(final XmlCursor.XmlBookmark xmlBookmark) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.l0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.E1(xmlBookmark);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final String str) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.i2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.G1(str);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toCursor(XmlCursor xmlCursor) {
        final Cursor cursorCheckCursors = checkCursors(xmlCursor);
        return this._cur._locale == cursorCheckCursors._cur._locale && ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.v1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.Q1(cursorCheckCursors);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toEndDoc() {
        syncWrapNoEnter(new Runnable() { // from class: org.apache.xmlbeans.impl.store.q7
            @Override // java.lang.Runnable
            public final void run() {
                this.c._toEndDoc();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toEndToken() {
        return (XmlCursor.TokenType) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.h8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._toEndToken();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstAttribute() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.p
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toFirstAttribute());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toFirstChild() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.i9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toFirstChild());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toFirstContentToken() {
        return (XmlCursor.TokenType) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.r7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._toFirstContentToken();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastAttribute() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.k9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toLastAttribute());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toLastChild() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.s8
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toLastChild());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextAttribute() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.j7
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toNextAttribute());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toNextBookmark(final Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.q1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.S1(obj);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toNextChar(final int i2) {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.r0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.U1(i2);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSelection() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.v6
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toNextSelection());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling() {
        return ((Boolean) syncWrapNoEnter(new Supplier() { // from class: org.apache.xmlbeans.impl.store.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a.___toNextSibling());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toNextToken() {
        return (XmlCursor.TokenType) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.d9
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._toNextToken();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toParent() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.g9
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toParent());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevAttribute() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.w7
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toPrevAttribute());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark toPrevBookmark(final Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.v
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.c2(obj);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int toPrevChar(final int i2) {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.j2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.e2(i2);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toPrevSibling() {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.m2
            @Override // java.util.function.Supplier
            public final Object get() {
                return Boolean.valueOf(this.a._toPrevSibling());
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.TokenType toPrevToken() {
        return (XmlCursor.TokenType) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.i
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._toPrevToken();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toSelection(final int i2) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.e0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.g2(i2);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void toStartDoc() {
        syncWrapNoEnter(new Runnable() { // from class: org.apache.xmlbeans.impl.store.l8
            @Override // java.lang.Runnable
            public final void run() {
                this.c._toStartDoc();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._xmlText();
            }
        });
    }

    /* renamed from: _execQuery, reason: merged with bridge method [inline-methods] */
    public XmlCursor K(String str, XmlOptions xmlOptions) {
        checkThisCursor();
        return XPathFactory.cursorExecQuery(this._cur, str, xmlOptions);
    }

    public int _getChars(char[] cArr, int i2, int i3) {
        int iCchRight = this._cur.cchRight();
        if (i3 < 0 || i3 > iCchRight) {
            i3 = iCchRight;
        }
        if (cArr == null || i2 >= cArr.length) {
            return 0;
        }
        if (cArr.length - i2 < i3) {
            i3 = cArr.length - i2;
        }
        Object chars = this._cur.getChars(i3);
        Cur cur = this._cur;
        CharUtil.getChars(cArr, i2, chars, cur._offSrc, cur._cchSrc);
        return this._cur._cchSrc;
    }

    /* renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void a0(String str, String str2) {
        f0(str, str2, null);
    }

    /* renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void g0(String str, String str2, String str3) {
        validateLocalName(str);
        h0(this._cur._locale.makeQName(str2, str), str3);
    }

    /* renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void s0(String str, String str2) {
        x0(str, str2, null);
    }

    /* renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void y0(String str, String str2, String str3) {
        validateLocalName(str);
        t0(this._cur._locale.makeQName(str2, str), str3);
    }

    /* renamed from: _newDomNode, reason: merged with bridge method [inline-methods] */
    public Node M0(XmlOptions xmlOptions) {
        if (xmlOptions != null && xmlOptions.isSaveInner()) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setSaveInner(false);
            xmlOptions = xmlOptions2;
        }
        return new DomSaver(this._cur, isDomFragment(), xmlOptions).saveDom();
    }

    /* renamed from: _newInputStream, reason: merged with bridge method [inline-methods] */
    public InputStream O0(XmlOptions xmlOptions) {
        return new Saver.InputStreamSaver(this._cur, xmlOptions);
    }

    /* renamed from: _newReader, reason: merged with bridge method [inline-methods] */
    public Reader Q0(XmlOptions xmlOptions) {
        return new Saver.TextReader(this._cur, xmlOptions);
    }

    /* renamed from: _newXMLStreamReader, reason: merged with bridge method [inline-methods] */
    public XMLStreamReader S0(XmlOptions xmlOptions) {
        return Jsr173.newXmlStreamReader(this._cur, xmlOptions);
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void o1(OutputStream outputStream) throws IOException {
        f1(outputStream, (XmlOptions) null);
    }

    /* renamed from: _selectPath, reason: merged with bridge method [inline-methods] */
    public void s1(String str, XmlOptions xmlOptions) {
        _clearSelections();
        this._pathEngine = XPathFactory.getCompiledPath(str, xmlOptions).execute(this._cur, xmlOptions);
        this._cur._locale.registerForChange(this);
    }

    /* renamed from: _setTextValue, reason: merged with bridge method [inline-methods] */
    public void C1(char[] cArr, int i2, int i3) {
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("setTextValue: length < 0");
        }
        if (cArr == null) {
            if (i3 > 0) {
                throw new IllegalArgumentException("setTextValue: sourceChars == null");
            }
            setTextValue((char[]) null, 0, 0);
        } else {
            if (i2 < 0 || i2 >= cArr.length) {
                throw new IndexOutOfBoundsException("setTextValue: offset out of bounds");
            }
            if (i2 + i3 > cArr.length) {
                i3 = cArr.length - i2;
            }
            CharUtil charUtil = this._cur._locale.getCharUtil();
            setTextValue(charUtil.saveChars(cArr, i2, i3), charUtil._offSrc, charUtil._cchSrc);
        }
    }

    public boolean _toChild(QName qName) {
        return _toChild(qName, 0);
    }

    public boolean _toNextSibling(String str, String str2) {
        validateLocalName(str2);
        return _toNextSibling(this._cur._locale._qnameFactory.getQName(str, str2));
    }

    /* renamed from: _xmlText, reason: merged with bridge method [inline-methods] */
    public String k2(XmlOptions xmlOptions) {
        return new Saver.TextSaver(this._cur, xmlOptions, null).saveToString();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.l2
            @Override // java.lang.Runnable
            public final void run() {
                this.c._dump();
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor execQuery(final String str, final XmlOptions xmlOptions) {
        return (XmlCursor) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.K(str, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getChars(final char[] cArr, final int i2, final int i3) {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.U(cArr, i2, i3);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public int getTextValue(final char[] cArr, final int i2, final int i3) {
        return ((Integer) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.W(cArr, i2, i3);
            }
        })).intValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.f2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(final String str, final String str2, final String str3) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.q0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.g0(str, str2, str3);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q0(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(final XmlOptions xmlOptions) {
        return (Node) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.u1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.M0(xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(final XmlOptions xmlOptions) {
        return (InputStream) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.b0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.O0(xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(final XmlOptions xmlOptions) {
        return (Reader) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.a1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.Q0(xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(final XmlOptions xmlOptions) {
        return (XMLStreamReader) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.k2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.S0(xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final File file) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.s1
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.m1(file);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void selectPath(final String str, final XmlOptions xmlOptions) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.r1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s1(str, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final String str, final String str2) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.I1(str, str2);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(final String str) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.y
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.W1(str);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(final XmlOptions xmlOptions) {
        return (String) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.x1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.k2(xmlOptions);
            }
        });
    }

    static void validateLocalName(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                if (!XMLChar.isValidNCName(str)) {
                    throw new IllegalArgumentException("Name is not valid");
                }
                return;
            }
            throw new IllegalArgumentException("Name is empty");
        }
        throw new IllegalArgumentException("Name is null");
    }

    /* renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void z(String str, String str2) {
        x0(str, str2, null);
        _toPrevToken();
    }

    /* renamed from: _insertAttribute, reason: merged with bridge method [inline-methods] */
    public void c0(QName qName) {
        h0(qName, (String) null);
    }

    /* renamed from: _insertElement, reason: merged with bridge method [inline-methods] */
    public void o0(QName qName) {
        t0(qName, (String) null);
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void a1(Writer writer) throws IOException {
        h1(writer, (XmlOptions) null);
    }

    public boolean _toChild(int i2) {
        return _toChild((QName) null, i2);
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void beginElement(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public XmlCursor.XmlBookmark getBookmark(final Object obj) {
        return (XmlCursor.XmlBookmark) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.p1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.S(obj);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttribute(final QName qName) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c0(qName);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertAttributeWithValue(final QName qName, final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i0(qName, str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElement(final String str, final String str2) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s0(str, str2);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void insertElementWithText(final String str, final String str2, final String str3) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.y0(str, str2, str3);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final OutputStream outputStream) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.l1
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.o1(outputStream);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final QName qName) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.e1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.K1(qName);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(final String str, final String str2) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.h2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.Y1(str, str2);
            }
        })).booleanValue();
    }

    private boolean preCheck() {
        checkThisCursor();
        return this._cur._locale.noSync();
    }

    /* renamed from: _insertAttributeWithValue, reason: merged with bridge method [inline-methods] */
    public void i0(QName qName, String str) {
        if (qName != null) {
            validateLocalName(qName.getLocalPart());
            Cur curTempCur = this._cur._locale.tempCur();
            curTempCur.createAttr(qName);
            insertNode(curTempCur, str);
            curTempCur.release();
            return;
        }
        throw new IllegalArgumentException("QName must not be null");
    }

    /* renamed from: _insertElementWithText, reason: merged with bridge method [inline-methods] */
    public void u0(QName qName, String str) {
        validateLocalName(qName.getLocalPart());
        Cur curTempCur = this._cur._locale.tempCur();
        curTempCur.createElement(qName);
        insertNode(curTempCur, str);
        curTempCur.release();
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void k1(ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
        b1(contentHandler, lexicalHandler, null);
    }

    public boolean _toChild(String str, String str2) {
        validateLocalName(str2);
        return _toChild(this._cur._locale.makeQName(str, str2), 0);
    }

    public boolean _toNextSibling(QName qName) {
        this._cur.push();
        while (___toNextSibling()) {
            if (this._cur.getName().equals(qName)) {
                this._cur.popButStay();
                return true;
            }
        }
        this._cur.pop();
        return false;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final Writer writer) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.v0
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.a1(writer);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final int i2) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.w0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.M1(i2);
            }
        })).booleanValue();
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toNextSibling(final QName qName) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.s0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.a2(qName);
            }
        })).booleanValue();
    }

    public Cursor(Cur cur) {
        this(cur._xobj, cur._pos);
    }

    /* renamed from: _beginElement, reason: merged with bridge method [inline-methods] */
    public void u(QName qName) {
        t0(qName, (String) null);
        _toPrevToken();
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void c1(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) throws SAXException {
        new Saver.SaxSaver(this._cur, xmlOptions, contentHandler, lexicalHandler);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final ContentHandler contentHandler, final LexicalHandler lexicalHandler, final XmlOptions xmlOptions) throws SAXException {
        syncWrapSAXEx(new WrapSAXEx() { // from class: org.apache.xmlbeans.impl.store.z0
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapSAXEx
            public final void run() throws SAXException {
                this.a.c1(contentHandler, lexicalHandler, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public boolean toChild(final QName qName, final int i2) {
        return ((Boolean) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.m1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.O1(qName, i2);
            }
        })).booleanValue();
    }

    private boolean isValid() {
        return isValid(this._cur);
    }

    private <T> T syncWrap(Supplier<T> supplier) {
        T t;
        if (preCheck()) {
            return (T) syncWrapHelper((Supplier) supplier, true);
        }
        synchronized (this._cur._locale) {
            t = (T) syncWrapHelper((Supplier) supplier, true);
        }
        return t;
    }

    private <T> T syncWrapHelper(Supplier<T> supplier, boolean z) {
        Locale locale = this._cur._locale;
        if (z) {
            locale.enter();
        }
        try {
            return supplier.get();
        } finally {
            if (z) {
                locale.exit();
            }
        }
    }

    private void syncWrapNoEnter(Runnable runnable) {
        if (preCheck()) {
            syncWrapHelper(runnable, false);
            return;
        }
        synchronized (this._cur._locale) {
            syncWrapHelper(runnable, false);
        }
    }

    public int _getTextValue(char[] cArr, int i2, int i3) {
        if (this._cur.isText()) {
            return _getChars(cArr, i2, i3);
        }
        if (cArr == null) {
            throw new IllegalArgumentException("char buffer is null");
        }
        if (i2 >= 0) {
            if (i2 < cArr.length) {
                if (i3 < 0) {
                    i3 = Integer.MAX_VALUE;
                }
                if (i2 + i3 > cArr.length) {
                    i3 = cArr.length - i2;
                }
                if (this._cur.isNode()) {
                    if (this._cur.hasChildren()) {
                        return Locale.getTextValue(this._cur, cArr, i2, i3);
                    }
                    Object firstChars = this._cur.getFirstChars();
                    Cur cur = this._cur;
                    if (cur._cchSrc > i3) {
                        cur._cchSrc = i3;
                    }
                    int i4 = cur._cchSrc;
                    if (i4 <= 0) {
                        return 0;
                    }
                    CharUtil.getChars(cArr, i2, firstChars, cur._offSrc, i4);
                    return this._cur._cchSrc;
                }
                throw new IllegalStateException("Can't get text value, current token can have no text value");
            }
            throw new IllegalArgumentException("offset off end");
        }
        throw new IllegalArgumentException("offset < 0");
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void e1(File file, XmlOptions xmlOptions) throws IOException {
        if (file != null) {
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(file.toPath(), new OpenOption[0]);
            try {
                f1(outputStreamNewOutputStream, xmlOptions);
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStreamNewOutputStream != null) {
                        try {
                            outputStreamNewOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("Null file specified");
    }

    public boolean _toChild(QName qName, int i2) {
        return Locale.toChild(this._cur, qName, i2);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final File file, final XmlOptions xmlOptions) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.h0
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.e1(file, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final OutputStream outputStream, final XmlOptions xmlOptions) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.d2
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.g1(outputStream, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(final String str) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.j1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.A1(str);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(final Writer writer, final XmlOptions xmlOptions) throws IOException {
        syncWrapIOEx(new WrapIOEx() { // from class: org.apache.xmlbeans.impl.store.t
            @Override // org.apache.xmlbeans.impl.store.Cursor.WrapIOEx
            public final void run() throws IOException {
                this.a.i1(writer, xmlOptions);
            }
        });
    }

    @Override // org.apache.xmlbeans.XmlCursor
    public void setTextValue(final char[] cArr, final int i2, final int i3) {
        syncWrap(new Runnable() { // from class: org.apache.xmlbeans.impl.store.a2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.C1(cArr, i2, i3);
            }
        });
    }

    private void syncWrapHelper(WrapSAXEx wrapSAXEx) throws SAXException {
        Locale locale = this._cur._locale;
        locale.enter();
        try {
            wrapSAXEx.run();
        } finally {
            locale.exit();
        }
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void g1(OutputStream outputStream, XmlOptions xmlOptions) throws IOException {
        if (outputStream != null) {
            InputStream inputStreamN0 = N0(xmlOptions);
            try {
                byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
                while (true) {
                    int i2 = inputStreamN0.read(bArr);
                    if (i2 < 0) {
                        break;
                    } else {
                        outputStream.write(bArr, 0, i2);
                    }
                }
                if (inputStreamN0 != null) {
                    inputStreamN0.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamN0 != null) {
                        try {
                            inputStreamN0.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("Null OutputStream specified");
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        return (XmlCursor) syncWrap(new Supplier() { // from class: org.apache.xmlbeans.impl.store.e8
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a._newCursor();
            }
        });
    }

    private void syncWrapHelper(WrapIOEx wrapIOEx) throws IOException {
        Locale locale = this._cur._locale;
        locale.enter();
        try {
            wrapIOEx.run();
        } finally {
            locale.exit();
        }
    }

    /* renamed from: _save, reason: merged with bridge method [inline-methods] */
    public void i1(Writer writer, XmlOptions xmlOptions) throws IOException {
        if (writer != null) {
            if (xmlOptions != null && xmlOptions.isSaveOptimizeForSpeed()) {
                Saver.OptimizedForSpeedSaver.save(this._cur, writer);
                return;
            }
            Reader readerP0 = P0(xmlOptions);
            try {
                char[] cArr = new char[XMLEvent.ENTITY_REFERENCE];
                while (true) {
                    int i2 = readerP0.read(cArr);
                    if (i2 < 0) {
                        break;
                    } else {
                        writer.write(cArr, 0, i2);
                    }
                }
                if (readerP0 != null) {
                    readerP0.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (readerP0 != null) {
                        try {
                            readerP0.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("Null Writer specified");
    }

    private int twoLocaleOp(Cursor cursor, int i2, int i3) {
        Locale locale = this._cur._locale;
        Locale locale2 = cursor._cur._locale;
        locale.enter(locale2);
        try {
            if (i2 == 0) {
                return _moveXml(cursor) ? 1 : 0;
            }
            if (i2 == 1) {
                return _copyXml(cursor) ? 1 : 0;
            }
            if (i2 == 2) {
                return _moveXmlContents(cursor) ? 1 : 0;
            }
            if (i2 == 3) {
                return _copyXmlContents(cursor) ? 1 : 0;
            }
            if (i2 == 4) {
                return _moveChars(i3, cursor);
            }
            if (i2 == 5) {
                return _copyChars(i3, cursor);
            }
            throw new RuntimeException("Unknown operation: " + i2);
        } finally {
            locale.exit(locale2);
        }
    }
}
