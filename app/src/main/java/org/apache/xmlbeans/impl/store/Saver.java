package org.apache.xmlbeans.impl.store;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptionCharEscapeMap;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.EncodingMap;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes.dex */
abstract class Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 3;
    static final int COMMENT = 4;
    static final int ELEM = 2;
    static final int MAX_ARRAY_SIZE = 2147483639;
    static final int PROCINST = 5;
    static final int ROOT = 1;
    static final int TEXT = 0;
    static final String _newLine = SystemProperties.getProperty("line.separator", "\n");
    private List<String> _ancestorNamespaces;
    private SaveCur _cur;
    private int _currentMapping;
    private String _initialDefaultUri;
    private final Locale _locale;
    private Map<String, String> _preComputedNamespaces;
    protected XmlOptionCharEscapeMap _replaceChar;
    private final boolean _saveNamespacesFirst;
    private final Map<String, String> _suggestedPrefixes;
    private final boolean _useDefaultNamespace;
    private final long _version;
    private final ArrayList<QName> _attrNames = new ArrayList<>();
    private final ArrayList<String> _attrValues = new ArrayList<>();
    private final ArrayList<String> _namespaceStack = new ArrayList<>();
    private final HashMap<String, String> _uriMap = new HashMap<>();
    private final HashMap<String, String> _prefixMap = new HashMap<>();

    private static final class DocSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Cur _cur;

        DocSaveCur(Cur cur) {
            this._cur = cur.weakCur(this);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            return this._cur.next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    private static final class FilterPiSaveCur extends FilterSaveCur {
        private final String _piTarget;

        FilterPiSaveCur(SaveCur saveCur, String str) {
            super(saveCur);
            this._piTarget = str;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.FilterSaveCur
        protected boolean filter() {
            return kind() == 5 && getName().getLocalPart().equals(this._piTarget);
        }
    }

    private static abstract class FilterSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SaveCur _cur;

        FilterSaveCur(SaveCur saveCur) {
            this._cur = saveCur;
        }

        protected abstract boolean filter();

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            return this._cur.kind();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            if (!this._cur.next()) {
                return false;
            }
            if (!filter()) {
                return true;
            }
            toEnd();
            return next();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    private static final class FragSaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CUR = 5;
        private static final int ELEM_END = 4;
        private static final int ELEM_START = 2;
        private static final int ROOT_END = 3;
        private static final int ROOT_START = 1;
        private ArrayList<String> _ancestorNamespaces;
        private Cur _cur;
        private final QName _elem;
        private Cur _end;
        private final boolean _saveAttr;
        private int _state;
        private int[] _stateStack;
        private int _stateStackSize;

        FragSaveCur(Cur cur, Cur cur2, QName qName) {
            this._saveAttr = cur.isAttr() && cur.isSamePos(cur2);
            this._cur = cur.weakCur(this);
            this._end = cur2.weakCur(this);
            this._elem = qName;
            this._state = 1;
            this._stateStack = new int[8];
            cur.push();
            computeAncestorNamespaces(cur);
            cur.pop();
        }

        private void computeAncestorNamespaces(Cur cur) {
            this._ancestorNamespaces = new ArrayList<>();
            while (cur.toParentRaw()) {
                if (cur.toFirstAttr()) {
                    do {
                        if (cur.isXmlns()) {
                            String xmlnsPrefix = cur.getXmlnsPrefix();
                            if (!cur.getXmlnsUri().isEmpty() || xmlnsPrefix.isEmpty()) {
                                this._ancestorNamespaces.add(cur.getXmlnsPrefix());
                                this._ancestorNamespaces.add(cur.getXmlnsUri());
                            }
                        }
                    } while (cur.toNextAttr());
                    cur.toParent();
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._ancestorNamespaces;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getValueAsString();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            Object chars = this._cur.getChars(-1);
            Cur cur = this._cur;
            this._offSrc = cur._offSrc;
            this._cchSrc = cur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return Locale.getDocProps(this._cur, false);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            int i2 = this._state;
            if (i2 == 1) {
                return null;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                if (i2 != 4) {
                    return this._cur.getName();
                }
            }
            return this._elem;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            boolean z = false;
            if (isContainer()) {
                push();
                next();
                if (!isText() && !isFinish()) {
                    z = true;
                }
                pop();
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            if (!isContainer()) {
                return false;
            }
            push();
            next();
            boolean zIsText = isText();
            pop();
            return zIsText;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._cur.isTextCData();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            int i2 = this._state;
            int i3 = 1;
            if (i2 != 1) {
                i3 = 2;
                if (i2 != 2) {
                    if (i2 == 3) {
                        return -1;
                    }
                    if (i2 != 4) {
                        return this._cur.kind();
                    }
                    return -2;
                }
            }
            return i3;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            int i2 = this._state;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return false;
                    }
                    if (i2 == 4) {
                        this._state = 3;
                    } else if (i2 == 5) {
                        this._cur.next();
                        if (this._cur.isSamePos(this._end)) {
                            this._state = this._elem == null ? 3 : 4;
                        }
                    }
                } else if (this._saveAttr) {
                    this._state = 4;
                } else {
                    if (this._cur.isAttr()) {
                        this._cur.toParent();
                        this._cur.next();
                    }
                    if (this._cur.isSamePos(this._end)) {
                        this._state = 4;
                    } else {
                        this._state = 5;
                    }
                }
            } else {
                this._state = this._elem == null ? 5 : 2;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            int[] iArr = this._stateStack;
            int i2 = this._stateStackSize - 1;
            this._stateStackSize = i2;
            this._state = iArr[i2];
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            int i2 = this._stateStackSize;
            int[] iArr = this._stateStack;
            if (i2 == iArr.length) {
                int[] iArr2 = new int[i2 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this._stateStack = iArr2;
            }
            int[] iArr3 = this._stateStack;
            int i3 = this._stateStackSize;
            this._stateStackSize = i3 + 1;
            iArr3[i3] = this._state;
            this._cur.push();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
            this._cur = null;
            this._end.release();
            this._end = null;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            int i2 = this._state;
            if (i2 == 1) {
                this._state = 3;
                return;
            }
            if (i2 == 2) {
                this._state = 4;
            } else {
                if (i2 == 3 || i2 == 4) {
                    return;
                }
                this._cur.toEnd();
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            int i2 = this._state;
            if (i2 == 1 || i2 == 3 || i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                return this._cur.toFirstAttr();
            }
            if (!this._cur.isAttr()) {
                return false;
            }
            this._state = 5;
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return !this._saveAttr && this._cur.toNextAttr();
        }
    }

    private static final class PrettySaveCur extends SaveCur {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final SaveCur _cur;
        private int _depth;
        private int _prettyIndent;
        private int _prettyOffset;
        private String _txt;
        private final boolean _useCDataBookmarks;
        private boolean _isTextCData = false;
        private final StringBuffer _sb = new StringBuffer();
        private final ArrayList<Object> _stack = new ArrayList<>();

        PrettySaveCur(SaveCur saveCur, XmlOptions xmlOptions) {
            this._cur = saveCur;
            this._prettyIndent = 2;
            if (xmlOptions.getSavePrettyPrintIndent() != null) {
                this._prettyIndent = xmlOptions.getSavePrettyPrintIndent().intValue();
            }
            if (xmlOptions.getSavePrettyPrintOffset() != null) {
                this._prettyOffset = xmlOptions.getSavePrettyPrintOffset().intValue();
            }
            this._useCDataBookmarks = xmlOptions.isUseCDataBookmarks();
        }

        static void spaces(StringBuffer stringBuffer, int i2, int i3) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return;
                }
                stringBuffer.insert(i2, Chars.SPACE);
                i3 = i4;
            }
        }

        static void trim(StringBuffer stringBuffer) {
            int i2 = 0;
            while (i2 < stringBuffer.length() && CharUtil.isWhiteSpace(stringBuffer.charAt(i2))) {
                i2++;
            }
            stringBuffer.delete(0, i2);
            int length = stringBuffer.length();
            while (length > 0 && CharUtil.isWhiteSpace(stringBuffer.charAt(length - 1))) {
                length--;
            }
            stringBuffer.delete(length, stringBuffer.length());
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        List<String> getAncestorNamespaces() {
            return this._cur.getAncestorNamespaces();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getAttrValue() {
            return this._cur.getAttrValue();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        Object getChars() {
            String str = this._txt;
            if (str != null) {
                this._offSrc = 0;
                this._cchSrc = str.length();
                return this._txt;
            }
            Object chars = this._cur.getChars();
            SaveCur saveCur = this._cur;
            this._offSrc = saveCur._offSrc;
            this._cchSrc = saveCur._cchSrc;
            return chars;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        XmlDocumentProperties getDocProps() {
            return this._cur.getDocProps();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        QName getName() {
            return this._cur.getName();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsPrefix() {
            return this._cur.getXmlnsPrefix();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        String getXmlnsUri() {
            return this._cur.getXmlnsUri();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasChildren() {
            return this._txt == null && this._cur.hasChildren();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean hasText() {
            return this._txt == null && this._cur.hasText();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isTextCData() {
            return this._txt == null ? this._useCDataBookmarks && this._cur.isTextCData() : this._isTextCData;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean isXmlns() {
            return this._txt == null && this._cur.isXmlns();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        int kind() {
            if (this._txt == null) {
                return this._cur.kind();
            }
            return 0;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean next() {
            int iKind = 0;
            if (this._txt != null) {
                this._txt = null;
                this._isTextCData = false;
                iKind = this._cur.kind();
            } else {
                int iKind2 = this._cur.kind();
                if (!this._cur.next()) {
                    return false;
                }
                StringBuffer stringBuffer = this._sb;
                stringBuffer.delete(0, stringBuffer.length());
                if (this._cur.isText()) {
                    this._isTextCData = this._useCDataBookmarks && this._cur.isTextCData();
                    StringBuffer stringBuffer2 = this._sb;
                    Object chars = this._cur.getChars();
                    SaveCur saveCur = this._cur;
                    CharUtil.getString(stringBuffer2, chars, saveCur._offSrc, saveCur._cchSrc);
                    this._cur.next();
                    int iKind3 = this._cur.kind();
                    if (iKind2 != 2 || iKind3 != -2) {
                        trim(this._sb);
                    }
                }
                int iKind4 = this._cur.kind();
                if (this._prettyIndent >= 0 && iKind2 != 4 && iKind2 != 5 && (iKind2 != 2 || iKind4 != -2)) {
                    if (this._sb.length() > 0) {
                        StringBuffer stringBuffer3 = this._sb;
                        String str = Saver._newLine;
                        stringBuffer3.insert(0, str);
                        spaces(this._sb, str.length(), this._prettyOffset + (this._prettyIndent * this._depth));
                    }
                    if (iKind4 != -1) {
                        if (iKind2 != 1) {
                            this._sb.append(Saver._newLine);
                        }
                        int i2 = this._depth;
                        if (iKind4 < 0) {
                            i2--;
                        }
                        StringBuffer stringBuffer4 = this._sb;
                        spaces(stringBuffer4, stringBuffer4.length(), this._prettyOffset + (this._prettyIndent * i2));
                    }
                }
                if (this._sb.length() > 0) {
                    this._txt = this._sb.toString();
                } else {
                    iKind = iKind4;
                }
            }
            if (iKind == 2) {
                this._depth++;
            } else if (iKind == -2) {
                this._depth--;
            }
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void pop() {
            this._cur.pop();
            this._depth = ((Integer) this._stack.remove(r0.size() - 1)).intValue();
            this._txt = (String) this._stack.remove(r0.size() - 1);
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void push() {
            this._cur.push();
            this._stack.add(this._txt);
            this._stack.add(Integer.valueOf(this._depth));
            this._isTextCData = false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void release() {
            this._cur.release();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        void toEnd() {
            this._cur.toEnd();
            if (this._cur.kind() == -2) {
                this._depth--;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toFirstAttr() {
            return this._cur.toFirstAttr();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver.SaveCur
        boolean toNextAttr() {
            return this._cur.toNextAttr();
        }
    }

    static abstract class SaveCur {
        int _cchSrc;
        int _offSrc;

        SaveCur() {
        }

        abstract List<String> getAncestorNamespaces();

        abstract String getAttrValue();

        abstract Object getChars();

        abstract XmlDocumentProperties getDocProps();

        abstract QName getName();

        abstract String getXmlnsPrefix();

        abstract String getXmlnsUri();

        abstract boolean hasChildren();

        abstract boolean hasText();

        final boolean isAttr() {
            return kind() == 3;
        }

        final boolean isComment() {
            return kind() == 4;
        }

        final boolean isContainer() {
            return Cur.kindIsContainer(kind());
        }

        final boolean isElem() {
            return kind() == 2;
        }

        final boolean isFinish() {
            return Cur.kindIsFinish(kind());
        }

        final boolean isNormalAttr() {
            return kind() == 3 && !isXmlns();
        }

        final boolean isProcinst() {
            return kind() == 5;
        }

        final boolean isRoot() {
            return kind() == 1;
        }

        final boolean isText() {
            return kind() == 0;
        }

        abstract boolean isTextCData();

        abstract boolean isXmlns();

        abstract int kind();

        abstract boolean next();

        abstract void pop();

        abstract void push();

        abstract void release();

        final boolean skip() {
            toEnd();
            return next();
        }

        abstract void toEnd();

        abstract boolean toFirstAttr();

        abstract boolean toNextAttr();
    }

    static final class SaxSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AttributesImpl _attributes;
        private char[] _buf;
        private final ContentHandler _contentHandler;
        private final LexicalHandler _lexicalHandler;
        private final boolean _nsAsAttrs;

        private static class SaverSAXException extends RuntimeException {
            SAXException _saxException;

            SaverSAXException(SAXException sAXException) {
                this._saxException = sAXException;
            }
        }

        SaxSaver(Cur cur, XmlOptions xmlOptions, ContentHandler contentHandler, LexicalHandler lexicalHandler) throws SAXException {
            super(cur, xmlOptions);
            this._contentHandler = contentHandler;
            this._lexicalHandler = lexicalHandler;
            this._attributes = new AttributesImpl();
            this._nsAsAttrs = !xmlOptions.isSaveSaxNoNSDeclsInAttributes();
            contentHandler.startDocument();
            do {
                try {
                } catch (SaverSAXException e) {
                    throw e._saxException;
                }
            } while (process());
            this._contentHandler.endDocument();
        }

        private void emitNamespacesHelper() throws SAXException {
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                String strMappingUri = mappingUri();
                try {
                    this._contentHandler.startPrefixMapping(strMappingPrefix, strMappingUri);
                    if (this._nsAsAttrs) {
                        if (strMappingPrefix == null || strMappingPrefix.isEmpty()) {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", "xmlns", "xmlns", "CDATA", strMappingUri);
                        } else {
                            this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", strMappingPrefix, Sax2Dom.XMLNS_STRING + strMappingPrefix, "CDATA", strMappingUri);
                        }
                    }
                    nextMapping();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        private String getPrefixedName(QName qName) {
            String namespaceURI = qName.getNamespaceURI();
            String localPart = qName.getLocalPart();
            if (namespaceURI.isEmpty()) {
                return localPart;
            }
            String uriMapping = getUriMapping(namespaceURI);
            if (uriMapping.isEmpty()) {
                return localPart;
            }
            return uriMapping + ParameterizedMessage.ERROR_MSG_SEPARATOR + localPart;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) throws SAXException {
            if (this._lexicalHandler != null) {
                saveCur.push();
                saveCur.next();
                try {
                    if (saveCur.isText()) {
                        Object chars = saveCur.getChars();
                        if (chars instanceof char[]) {
                            this._lexicalHandler.comment((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                        } else {
                            char[] cArr = this._buf;
                            if (cArr == null || cArr.length < saveCur._cchSrc) {
                                this._buf = new char[Math.max(1024, saveCur._cchSrc)];
                            }
                            CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, saveCur._cchSrc);
                            this._lexicalHandler.comment(this._buf, 0, saveCur._cchSrc);
                        }
                    } else {
                        this._lexicalHandler.comment(null, 0, 0);
                    }
                    saveCur.pop();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) throws SAXException {
            LexicalHandler lexicalHandler = this._lexicalHandler;
            if (lexicalHandler != null) {
                try {
                    lexicalHandler.startDTD(str, str2, str3);
                    this._lexicalHandler.endDTD();
                } catch (SAXException e) {
                    throw new SaverSAXException(e);
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) throws SAXException {
            this._attributes.clear();
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                QName qName = list.get(i2);
                this._attributes.addAttribute(qName.getNamespaceURI(), qName.getLocalPart(), getPrefixedName(qName), "CDATA", list2.get(i2));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            QName name = saveCur.getName();
            try {
                this._contentHandler.startElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name), this._attributes);
                return false;
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) throws SAXException {
            QName name = saveCur.getName();
            try {
                this._contentHandler.endElement(name.getNamespaceURI(), name.getLocalPart(), getPrefixedName(name));
                iterateMappings();
                while (hasMapping()) {
                    this._contentHandler.endPrefixMapping(mappingPrefix());
                    nextMapping();
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) throws SAXException {
            saveCur.push();
            saveCur.next();
            String string = CharUtil.getString(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
            saveCur.pop();
            try {
                this._contentHandler.processingInstruction(saveCur.getName().getLocalPart(), string);
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) throws SAXException {
            Object chars = saveCur.getChars();
            try {
                if (chars instanceof char[]) {
                    this._contentHandler.characters((char[]) chars, saveCur._offSrc, saveCur._cchSrc);
                    return;
                }
                if (this._buf == null) {
                    this._buf = new char[1024];
                }
                while (true) {
                    int i2 = saveCur._cchSrc;
                    if (i2 <= 0) {
                        return;
                    }
                    int iMin = Math.min(this._buf.length, i2);
                    CharUtil.getChars(this._buf, 0, chars, saveCur._offSrc, iMin);
                    this._contentHandler.characters(this._buf, 0, iMin);
                    saveCur._offSrc += iMin;
                    saveCur._cchSrc -= iMin;
                }
            } catch (SAXException e) {
                throw new SaverSAXException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface SyncWrapFun {
        int process() throws IOException;
    }

    static final class SynthNamespaceSaver extends Saver {
        LinkedHashMap<String, String> _synthNamespaces;

        SynthNamespaceSaver(Cur cur, XmlOptions xmlOptions) {
            super(cur, xmlOptions);
            this._synthNamespaces = new LinkedHashMap<>();
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void syntheticNamespace(String str, String str2, boolean z) {
            LinkedHashMap<String, String> linkedHashMap = this._synthNamespaces;
            if (z) {
                str = "";
            }
            linkedHashMap.put(str2, str);
        }
    }

    Saver(Cur cur, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._cur = createSaveCur(cur, xmlOptionsMaskNull);
        Locale locale = cur._locale;
        this._locale = locale;
        this._version = locale.version();
        addMapping("xml", XMLConstants.XML_NS_URI);
        Map<String, String> saveImplicitNamespaces = xmlOptionsMaskNull.getSaveImplicitNamespaces();
        if (saveImplicitNamespaces != null) {
            for (String str : saveImplicitNamespaces.keySet()) {
                addMapping(str, saveImplicitNamespaces.get(str));
            }
        }
        this._replaceChar = xmlOptionsMaskNull.getSaveSubstituteCharacters();
        if (getNamespaceForPrefix("") == null) {
            this._initialDefaultUri = "";
            addMapping("", "");
        }
        if (xmlOptionsMaskNull.isSaveAggressiveNamespaces() && !(this instanceof SynthNamespaceSaver)) {
            SynthNamespaceSaver synthNamespaceSaver = new SynthNamespaceSaver(cur, xmlOptionsMaskNull);
            while (synthNamespaceSaver.process()) {
            }
            if (!synthNamespaceSaver._synthNamespaces.isEmpty()) {
                this._preComputedNamespaces = synthNamespaceSaver._synthNamespaces;
            }
        }
        this._useDefaultNamespace = xmlOptionsMaskNull.isUseDefaultNamespace();
        this._saveNamespacesFirst = xmlOptionsMaskNull.isSaveNamespacesFirst();
        this._suggestedPrefixes = xmlOptionsMaskNull.getSaveSuggestedPrefixes();
        this._ancestorNamespaces = this._cur.getAncestorNamespaces();
    }

    private void addMapping(String str, String str2) {
        String str3;
        String str4 = this._prefixMap.get(str);
        if (str4 == null) {
            str3 = null;
        } else if (!str4.equals(str2)) {
            int size = this._namespaceStack.size();
            str3 = null;
            while (size > 0) {
                if (this._namespaceStack.get(size - 1) != null) {
                    if (this._namespaceStack.get(size - 7).equals(str4) && ((str3 = this._namespaceStack.get(size - 8)) == null || !str3.equals(str))) {
                        break;
                    } else {
                        size -= 8;
                    }
                } else {
                    size--;
                }
            }
        } else {
            str4 = null;
            str3 = null;
        }
        this._namespaceStack.add(this._uriMap.get(str2));
        this._namespaceStack.add(str2);
        if (str4 != null) {
            this._namespaceStack.add(this._uriMap.get(str4));
            this._namespaceStack.add(str4);
        } else {
            this._namespaceStack.add(null);
            this._namespaceStack.add(null);
        }
        this._namespaceStack.add(str);
        this._namespaceStack.add(this._prefixMap.get(str));
        this._namespaceStack.add(str);
        this._namespaceStack.add(str2);
        this._uriMap.put(str2, str);
        this._prefixMap.put(str, str2);
        if (str4 != null) {
            this._uriMap.put(str4, str3);
        }
    }

    private void addNewFrameMapping(String str, String str2, boolean z) {
        if (str.isEmpty() || !str2.isEmpty()) {
            if (z && str.isEmpty() && !str2.isEmpty()) {
                return;
            }
            iterateMappings();
            while (hasMapping()) {
                if (mappingPrefix().equals(str)) {
                    return;
                } else {
                    nextMapping();
                }
            }
            if (str2.equals(getNamespaceForPrefix(str))) {
                return;
            }
            addMapping(str, str2);
        }
    }

    private static SaveCur createSaveCur(Cur cur, XmlOptions xmlOptions) {
        QName saveSyntheticDocumentElement = xmlOptions.getSaveSyntheticDocumentElement();
        QName qName = saveSyntheticDocumentElement == null ? xmlOptions.isSaveUseOpenFrag() ? Locale._openuriFragment : Locale._xmlFragment : saveSyntheticDocumentElement;
        boolean z = xmlOptions.isSaveInner() && !xmlOptions.isSaveOuter();
        Cur curTempCur = cur.tempCur();
        Cur curTempCur2 = cur.tempCur();
        int iKind = cur.kind();
        SaveCur fragSaveCur = null;
        if (iKind == 1) {
            positionToInner(cur, curTempCur, curTempCur2);
            fragSaveCur = Locale.isFragment(curTempCur, curTempCur2) ? new FragSaveCur(curTempCur, curTempCur2, qName) : saveSyntheticDocumentElement != null ? new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement) : new DocSaveCur(cur);
        } else if (iKind == 2) {
            if (z) {
                positionToInner(cur, curTempCur, curTempCur2);
                if (Locale.isFragment(curTempCur, curTempCur2)) {
                    saveSyntheticDocumentElement = qName;
                }
                fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement);
            } else if (saveSyntheticDocumentElement != null) {
                positionToInner(cur, curTempCur, curTempCur2);
                fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, saveSyntheticDocumentElement);
            } else {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.skip();
                fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, null);
            }
        }
        if (fragSaveCur == null) {
            if (iKind < 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else if (iKind == 0) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.next();
            } else if (z) {
                curTempCur.moveToCur(cur);
                curTempCur.next();
                curTempCur2.moveToCur(cur);
                curTempCur2.toEnd();
            } else if (iKind == 3) {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
            } else {
                curTempCur.moveToCur(cur);
                curTempCur2.moveToCur(cur);
                curTempCur2.skip();
            }
            fragSaveCur = new FragSaveCur(curTempCur, curTempCur2, qName);
        }
        String saveFilterProcinst = xmlOptions.getSaveFilterProcinst();
        if (saveFilterProcinst != null) {
            fragSaveCur = new FilterPiSaveCur(fragSaveCur, saveFilterProcinst);
        }
        if (xmlOptions.isSavePrettyPrint()) {
            fragSaveCur = new PrettySaveCur(fragSaveCur, xmlOptions);
        }
        curTempCur.release();
        curTempCur2.release();
        return fragSaveCur;
    }

    private void ensureMapping(String str, String str2, boolean z, boolean z2) {
        if (str.isEmpty()) {
            return;
        }
        String str3 = this._uriMap.get(str);
        if (str3 == null || (str3.isEmpty() && z2)) {
            if (str2 != null && str2.isEmpty()) {
                str2 = null;
            }
            if (!tryPrefix(str2)) {
                Map<String, String> map = this._suggestedPrefixes;
                if (map != null && map.containsKey(str) && tryPrefix(this._suggestedPrefixes.get(str))) {
                    str2 = this._suggestedPrefixes.get(str);
                } else if (z && this._useDefaultNamespace && tryPrefix("")) {
                    str2 = "";
                } else {
                    String strSuggestPrefix = QNameHelper.suggestPrefix(str);
                    str2 = strSuggestPrefix;
                    int i2 = 1;
                    while (!tryPrefix(str2)) {
                        str2 = strSuggestPrefix + i2;
                        i2++;
                    }
                }
            }
            syntheticNamespace(str2, str, z);
            addMapping(str2, str);
        }
    }

    static boolean isBadChar(char c) {
        return (Character.isHighSurrogate(c) || Character.isLowSurrogate(c) || (c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || c == '\t' || c == '\n' || c == '\r')) ? false : true;
    }

    private void popMappings() {
        while (true) {
            int size = this._namespaceStack.size();
            if (size == 0) {
                return;
            }
            int i2 = size - 1;
            if (this._namespaceStack.get(i2) == null) {
                this._namespaceStack.remove(i2);
                return;
            }
            int i3 = size - 7;
            String str = this._namespaceStack.get(i3);
            int i4 = size - 8;
            String str2 = this._namespaceStack.get(i4);
            if (str2 == null) {
                this._uriMap.remove(str);
            } else {
                this._uriMap.put(str, str2);
            }
            int i5 = size - 4;
            String str3 = this._namespaceStack.get(i5);
            int i6 = size - 3;
            String str4 = this._namespaceStack.get(i6);
            if (str4 == null) {
                this._prefixMap.remove(str3);
            } else {
                this._prefixMap.put(str3, str4);
            }
            int i7 = size - 5;
            String str5 = this._namespaceStack.get(i7);
            if (str5 != null) {
                this._uriMap.put(str5, this._namespaceStack.get(size - 6));
            }
            this._namespaceStack.remove(i2);
            this._namespaceStack.remove(size - 2);
            this._namespaceStack.remove(i6);
            this._namespaceStack.remove(i5);
            this._namespaceStack.remove(i7);
            this._namespaceStack.remove(size - 6);
            this._namespaceStack.remove(i3);
            this._namespaceStack.remove(i4);
        }
    }

    private static void positionToInner(Cur cur, Cur cur2, Cur cur3) {
        cur2.moveToCur(cur);
        if (!cur2.toFirstAttr()) {
            cur2.next();
        }
        cur3.moveToCur(cur);
        cur3.toEnd();
    }

    private void processElement() {
        QName name = this._cur.getName();
        boolean zIsEmpty = name.getNamespaceURI().isEmpty();
        pushMappings(this._cur, zIsEmpty);
        ensureMapping(name.getNamespaceURI(), name.getPrefix(), !zIsEmpty, false);
        this._attrNames.clear();
        this._attrValues.clear();
        this._cur.push();
        boolean firstAttr = this._cur.toFirstAttr();
        while (firstAttr) {
            if (this._cur.isNormalAttr()) {
                QName name2 = this._cur.getName();
                this._attrNames.add(name2);
                int size = this._attrNames.size() - 2;
                while (true) {
                    if (size < 0) {
                        this._attrValues.add(this._cur.getAttrValue());
                        ensureMapping(name2.getNamespaceURI(), name2.getPrefix(), false, true);
                        break;
                    } else {
                        if (this._attrNames.get(size).equals(name2)) {
                            ArrayList<QName> arrayList = this._attrNames;
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        }
                        size--;
                    }
                }
            }
            firstAttr = this._cur.toNextAttr();
        }
        this._cur.pop();
        Map<String, String> map = this._preComputedNamespaces;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                ensureMapping(key, value, value.isEmpty() && !zIsEmpty, false);
            }
            this._preComputedNamespaces = null;
        }
        if (emitElement(this._cur, this._attrNames, this._attrValues)) {
            popMappings();
            this._cur.toEnd();
        }
    }

    private void processFinish() {
        emitFinish(this._cur);
        popMappings();
    }

    private void processRoot() {
        String localPart;
        XmlDocumentProperties docProps = this._cur.getDocProps();
        String doctypeSystemId = null;
        if (docProps != null) {
            doctypeSystemId = docProps.getDoctypeSystemId();
            localPart = docProps.getDoctypeName();
        } else {
            localPart = null;
        }
        if (doctypeSystemId != null || localPart != null) {
            if (localPart == null) {
                this._cur.push();
                while (!this._cur.isElem() && this._cur.next()) {
                }
                if (this._cur.isElem()) {
                    localPart = this._cur.getName().getLocalPart();
                }
                this._cur.pop();
            }
            String doctypePublicId = docProps.getDoctypePublicId();
            if (localPart != null) {
                QName name = this._cur.getName();
                if (name == null) {
                    this._cur.push();
                    while (true) {
                        if (this._cur.isFinish()) {
                            break;
                        }
                        if (this._cur.isElem()) {
                            name = this._cur.getName();
                            break;
                        }
                        this._cur.next();
                    }
                    this._cur.pop();
                }
                if (name != null && localPart.equals(name.getLocalPart())) {
                    emitDocType(localPart, doctypePublicId, doctypeSystemId);
                    return;
                }
            }
        }
        emitStartDoc(this._cur);
    }

    private void pushMappings(SaveCur saveCur, boolean z) {
        this._namespaceStack.add(null);
        saveCur.push();
        boolean firstAttr = saveCur.toFirstAttr();
        while (firstAttr) {
            if (saveCur.isXmlns()) {
                addNewFrameMapping(saveCur.getXmlnsPrefix(), saveCur.getXmlnsUri(), z);
            }
            firstAttr = saveCur.toNextAttr();
        }
        saveCur.pop();
        if (this._ancestorNamespaces != null) {
            for (int i2 = 0; i2 < this._ancestorNamespaces.size(); i2 += 2) {
                addNewFrameMapping(this._ancestorNamespaces.get(i2), this._ancestorNamespaces.get(i2 + 1), z);
            }
            this._ancestorNamespaces = null;
        }
        if (!z || this._prefixMap.get("").isEmpty()) {
            return;
        }
        addMapping("", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int syncWrap(Locale locale, SyncWrapFun syncWrapFun) throws IOException {
        int iProcess;
        if (locale.noSync()) {
            locale.enter();
            try {
                return syncWrapFun.process();
            } finally {
            }
        }
        synchronized (locale) {
            locale.enter();
            try {
                iProcess = syncWrapFun.process();
            } finally {
            }
        }
        return iProcess;
    }

    private boolean tryPrefix(String str) {
        if (str == null || Locale.beginsWithXml(str)) {
            return false;
        }
        String str2 = this._prefixMap.get(str);
        return str2 == null || (str.length() <= 0 && Objects.equals(str2, this._initialDefaultUri));
    }

    protected abstract void emitComment(SaveCur saveCur);

    protected abstract void emitDocType(String str, String str2, String str3);

    protected abstract boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2);

    protected abstract void emitEndDoc(SaveCur saveCur);

    protected abstract void emitFinish(SaveCur saveCur);

    protected abstract void emitProcinst(SaveCur saveCur);

    protected abstract void emitStartDoc(SaveCur saveCur);

    protected abstract void emitText(SaveCur saveCur);

    public final String getNamespaceForPrefix(String str) {
        return this._prefixMap.get(str);
    }

    String getNonDefaultUriMapping(String str) {
        String str2 = this._uriMap.get(str);
        if (str2 != null && !str2.isEmpty()) {
            return str2;
        }
        for (String str3 : this._prefixMap.keySet()) {
            if (!str3.isEmpty() && this._prefixMap.get(str3).equals(str)) {
                return str3;
            }
        }
        return null;
    }

    protected final String getUriMapping(String str) {
        return this._uriMap.get(str);
    }

    boolean hasMapping() {
        return this._currentMapping < this._namespaceStack.size();
    }

    void iterateMappings() {
        this._currentMapping = this._namespaceStack.size();
        while (true) {
            int i2 = this._currentMapping;
            if (i2 <= 0 || this._namespaceStack.get(i2 - 1) == null) {
                return;
            } else {
                this._currentMapping -= 8;
            }
        }
    }

    String mappingPrefix() {
        return this._namespaceStack.get(this._currentMapping + 6);
    }

    String mappingUri() {
        return this._namespaceStack.get(this._currentMapping + 7);
    }

    void nextMapping() {
        this._currentMapping += 8;
    }

    protected final boolean process() {
        if (this._cur == null) {
            return false;
        }
        if (this._version != this._locale.version()) {
            throw new ConcurrentModificationException("Document changed during save");
        }
        int iKind = this._cur.kind();
        if (iKind == -2) {
            processFinish();
        } else {
            if (iKind == -1) {
                emitEndDoc(this._cur);
                this._cur.release();
                this._cur = null;
                return true;
            }
            if (iKind == 0) {
                emitText(this._cur);
            } else if (iKind == 1) {
                processRoot();
            } else if (iKind == 2) {
                processElement();
            } else if (iKind == 4) {
                emitComment(this._cur);
                this._cur.toEnd();
            } else {
                if (iKind != 5) {
                    throw new RuntimeException("Unexpected kind");
                }
                emitProcinst(this._cur);
                this._cur.toEnd();
            }
        }
        this._cur.next();
        return true;
    }

    protected boolean saveNamespacesFirst() {
        return this._saveNamespacesFirst;
    }

    protected void syntheticNamespace(String str, String str2, boolean z) {
    }

    static final class OptimizedForSpeedSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] _buf;
        Writer _w;

        private static class SaverIOException extends RuntimeException {
            SaverIOException(IOException iOException) {
                super(iOException);
            }
        }

        OptimizedForSpeedSaver(Cur cur, Writer writer) {
            super(cur, XmlOptions.maskNull(null));
            this._buf = new char[1024];
            this._w = writer;
        }

        private void emit(String str) throws IOException {
            try {
                this._w.write(str);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emitAttrHelper(QName qName, String str) throws IOException {
            emit(Chars.SPACE);
            emitName(qName, true);
            emit(Chars.EQ, Chars.DQUOTE);
            emitAttrValue(str);
            emit(Chars.DQUOTE);
        }

        private void emitAttrValue(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt == '<') {
                    emit("&lt;");
                } else if (cCharAt == '&') {
                    emit("&amp;");
                } else if (cCharAt == '\"') {
                    emit("&quot;");
                } else {
                    emit(cCharAt);
                }
            }
        }

        private void emitLiteral(String str) throws IOException {
            if (str.contains("\"")) {
                emit(Chars.QUOTE);
                emit(str);
                emit(Chars.QUOTE);
            } else {
                emit(Chars.DQUOTE);
                emit(str);
                emit(Chars.DQUOTE);
            }
        }

        private void emitName(QName qName, boolean z) throws IOException {
            String namespaceURI = qName.getNamespaceURI();
            if (!namespaceURI.isEmpty()) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.isEmpty()) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (!prefix.isEmpty()) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() throws IOException {
            iterateMappings();
            while (hasMapping()) {
                emit(Chars.SPACE);
                emitXmlns(mappingPrefix(), mappingUri());
                nextMapping();
            }
        }

        private void entitizeAndWriteCommentText(int i2) throws IOException {
            int i3 = 0;
            boolean z = false;
            while (i3 < i2) {
                char c = this._buf[i3];
                if (Saver.isBadChar(c)) {
                    this._buf[i3] = '?';
                } else if (c != '-') {
                    z = false;
                } else if (z) {
                    this._buf[i3] = Chars.SPACE;
                    z = false;
                } else {
                    z = true;
                }
                if (i3 == this._buf.length) {
                    i3 = 0;
                }
                i3++;
            }
            char[] cArr = this._buf;
            int i4 = i2 - 1;
            if (cArr[i4] == '-') {
                cArr[i4] = Chars.SPACE;
            }
            emit(cArr, 0, i2);
        }

        private void entitizeAndWritePIText(int i2) throws IOException {
            boolean z = false;
            for (int i3 = 0; i3 < i2; i3++) {
                char c = this._buf[i3];
                if (Saver.isBadChar(c)) {
                    this._buf[i3] = '?';
                    c = '?';
                }
                if (c != '>') {
                    z = c == '?';
                } else if (z) {
                    this._buf[i3] = Chars.SPACE;
                }
            }
            emit(this._buf, 0, i2);
        }

        private void entitizeAndWriteText(int i2) throws IOException {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                char[] cArr = this._buf;
                char c = cArr[i4];
                if (c == '&') {
                    emit(cArr, i3, i4 - i3);
                    emit("&amp;");
                } else if (c == '<') {
                    emit(cArr, i3, i4 - i3);
                    emit("&lt;");
                }
                i3 = i4 + 1;
            }
            emit(this._buf, i3, i2 - i3);
        }

        static void save(Cur cur, Writer writer) throws IOException {
            try {
                do {
                } while (new OptimizedForSpeedSaver(cur, writer).process());
            } catch (SaverIOException e) {
                throw ((IOException) e.getCause());
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) throws IOException {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emitCommentText(saveCur);
            saveCur.pop();
            emit("-->");
        }

        protected void emitCommentText(SaveCur saveCur) throws IOException {
            Object chars = saveCur.getChars();
            int i2 = saveCur._cchSrc;
            int i3 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 512 > i2 ? i2 : 512;
                CharUtil.getChars(this._buf, 0, chars, i3 + i4, i5);
                entitizeAndWriteCommentText(i5 - i4);
                i4 = i5;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) throws IOException {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(Chars.SPACE);
                emitLiteral(str3);
            }
            emit('>');
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) throws IOException {
            emit('<');
            emitName(saveCur.getName(), false);
            for (int i2 = 0; i2 < list.size(); i2++) {
                emitAttrHelper(list.get(i2), list2.get(i2));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) throws IOException {
            emit('<', '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        protected void emitPiText(SaveCur saveCur) throws IOException {
            Object chars = saveCur.getChars();
            int i2 = saveCur._cchSrc;
            int i3 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 512 > i2 ? i2 : 512;
                CharUtil.getChars(this._buf, 0, chars, i3 + i4, i5);
                entitizeAndWritePIText(i5 - i4);
                i4 = i5;
            }
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) throws IOException {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(Chars.SPACE);
                emitPiText(saveCur);
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) throws IOException {
            Object chars = saveCur.getChars();
            int i2 = saveCur._cchSrc;
            int i3 = saveCur._offSrc;
            int i4 = 0;
            while (i4 < i2) {
                int iMin = Math.min(i4 + 512, i2);
                int i5 = i3 + i4;
                int i6 = iMin - i4;
                CharUtil.getChars(this._buf, 0, chars, i5, i6);
                entitizeAndWriteText(i6);
                i4 = iMin;
            }
        }

        protected void emitXmlns(String str, String str2) throws IOException {
            emit("xmlns");
            if (!str.isEmpty()) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit(Chars.EQ, Chars.DQUOTE);
            emitAttrValue(str2);
            emit(Chars.DQUOTE);
        }

        private void emit(char c) throws IOException {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                this._w.write(cArr, 0, 1);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char c, char c2) throws IOException {
            try {
                char[] cArr = this._buf;
                cArr[0] = c;
                cArr[1] = c2;
                this._w.write(cArr, 0, 2);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }

        private void emit(char[] cArr, int i2, int i3) throws IOException {
            try {
                this._w.write(cArr, i2, i3);
            } catch (IOException e) {
                throw new SaverIOException(e);
            }
        }
    }

    static final class TextReader extends Reader {
        private boolean _closed = false;
        private final Locale _locale;
        private final TextSaver _textSaver;

        TextReader(Cur cur, XmlOptions xmlOptions) {
            this._textSaver = new TextSaver(cur, xmlOptions, null);
            this._locale = cur._locale;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int c(char[] cArr) throws IOException {
            return this._textSaver.read(cArr, 0, cArr == null ? 0 : cArr.length);
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Reader has been closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int f(char[] cArr, int i2, int i3) throws IOException {
            return this._textSaver.read(cArr, i2, i3);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.Reader
        public int read() throws IOException {
            checkClosed();
            Locale locale = this._locale;
            final TextSaver textSaver = this._textSaver;
            textSaver.getClass();
            return Saver.syncWrap(locale, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.g
                @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
                public final int process() {
                    return textSaver.read();
                }
            });
        }

        @Override // java.io.Reader
        public boolean ready() {
            return !this._closed;
        }

        @Override // java.io.Reader
        public int read(final char[] cArr) throws IOException {
            checkClosed();
            return Saver.syncWrap(this._locale, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.p7
                @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
                public final int process() {
                    return this.a.c(cArr);
                }
            });
        }

        @Override // java.io.Reader
        public int read(final char[] cArr, final int i2, final int i3) throws IOException {
            checkClosed();
            return Saver.syncWrap(this._locale, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.o7
                @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
                public final int process() {
                    return this.a.f(cArr, i2, i3);
                }
            });
        }
    }

    static final class InputStreamSaver extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean _closed = false;
        private final OutputStreamWriter _converter;
        private final Locale _locale;
        private final OutputStreamImpl _outStreamImpl;
        private final TextSaver _textSaver;

        /* JADX WARN: Multi-variable type inference failed */
        InputStreamSaver(Cur cur, XmlOptions xmlOptions) {
            String java2IANAMapping;
            this._locale = cur._locale;
            XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            OutputStreamImpl outputStreamImpl = new OutputStreamImpl();
            this._outStreamImpl = outputStreamImpl;
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            String iANA2JavaMapping = (docProps == null || docProps.getEncoding() == null) ? null : EncodingMap.getIANA2JavaMapping(docProps.getEncoding());
            String characterEncoding = xmlOptionsMaskNull.getCharacterEncoding();
            iANA2JavaMapping = characterEncoding != null ? characterEncoding : iANA2JavaMapping;
            if (iANA2JavaMapping != null && (java2IANAMapping = EncodingMap.getJava2IANAMapping(iANA2JavaMapping)) != null) {
                iANA2JavaMapping = java2IANAMapping;
            }
            iANA2JavaMapping = iANA2JavaMapping == null ? EncodingMap.getJava2IANAMapping("UTF8") : iANA2JavaMapping;
            String iANA2JavaMapping2 = iANA2JavaMapping != null ? EncodingMap.getIANA2JavaMapping(iANA2JavaMapping) : null;
            if (iANA2JavaMapping2 == null) {
                throw new IllegalStateException("Unknown encoding: " + iANA2JavaMapping);
            }
            try {
                this._converter = new OutputStreamWriter(outputStreamImpl, iANA2JavaMapping2);
                this._textSaver = new TextSaver(cur, xmlOptionsMaskNull, iANA2JavaMapping);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int c() throws IOException {
            return ensure(1024);
        }

        private void checkClosed() throws IOException {
            if (this._closed) {
                throw new IOException("Stream closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int f(byte[] bArr, int i2, int i3) throws IOException {
            return this._outStreamImpl.read(bArr, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int ensure(int i2) {
            if (i2 <= 0) {
                i2 = 1;
            }
            int available = this._outStreamImpl.getAvailable();
            while (available < i2 && this._textSaver.write(this._converter, 2048) >= 2048) {
                available = this._outStreamImpl.getAvailable();
            }
            return this._outStreamImpl.getAvailable();
        }

        @Override // java.io.InputStream
        public int available() {
            try {
                return Saver.syncWrap(this._locale, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.n7
                    @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
                    public final int process() {
                        return this.a.c();
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._closed = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i2;
            checkClosed();
            if (this._locale.noSync()) {
                this._locale.enter();
                try {
                    return this._outStreamImpl.read();
                } finally {
                }
            }
            synchronized (this._locale) {
                this._locale.enter();
                try {
                    i2 = this._outStreamImpl.read();
                } finally {
                }
            }
            return i2;
        }

        private final class OutputStreamImpl extends OutputStream {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private static final int _initialBufSize = 4096;
            private byte[] _buf;
            private int _free;
            private int _in;
            private int _out;

            private OutputStreamImpl() {
            }

            int getAvailable() {
                byte[] bArr = this._buf;
                if (bArr == null) {
                    return 0;
                }
                return bArr.length - this._free;
            }

            int read() {
                if (InputStreamSaver.this.ensure(1) == 0) {
                    return -1;
                }
                byte[] bArr = this._buf;
                int i2 = this._out;
                byte b = bArr[i2];
                this._out = (i2 + 1) % bArr.length;
                this._free++;
                return b;
            }

            void resize(int i2) {
                long length = this._buf == null ? ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF : r0.length * 2;
                int available = getAvailable();
                while (length - available < i2) {
                    length *= 2;
                }
                int iMin = (int) Math.min(length, 2147483639L);
                byte[] bArr = new byte[iMin];
                if (available > 0) {
                    int i3 = this._in;
                    int i4 = this._out;
                    if (i3 > i4) {
                        System.arraycopy(this._buf, i4, bArr, 0, available);
                    } else {
                        System.arraycopy(this._buf, i4, bArr, 0, available - i3);
                        byte[] bArr2 = this._buf;
                        int i5 = this._in;
                        System.arraycopy(bArr2, 0, bArr, available - i5, i5);
                    }
                    this._out = 0;
                    this._in = available;
                    this._free += iMin - this._buf.length;
                } else {
                    this._free = iMin;
                }
                this._buf = bArr;
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                if (this._free == 0) {
                    resize(1);
                }
                byte[] bArr = this._buf;
                int i3 = this._in;
                bArr[i3] = (byte) i2;
                this._in = (i3 + 1) % bArr.length;
                this._free--;
            }

            int read(byte[] bArr, int i2, int i3) {
                int iEnsure = InputStreamSaver.this.ensure(i3);
                if (iEnsure == 0) {
                    return -1;
                }
                if (bArr == null || i3 <= 0) {
                    return 0;
                }
                if (iEnsure < i3) {
                    i3 = iEnsure;
                }
                int i4 = this._out;
                if (i4 < this._in) {
                    System.arraycopy(this._buf, i4, bArr, i2, i3);
                } else {
                    byte[] bArr2 = this._buf;
                    int length = bArr2.length - i4;
                    if (length >= i3) {
                        System.arraycopy(bArr2, i4, bArr, i2, i3);
                    } else {
                        System.arraycopy(bArr2, i4, bArr, i2, length);
                        System.arraycopy(this._buf, 0, bArr, i2 + length, i3 - length);
                    }
                }
                this._out = (this._out + i3) % this._buf.length;
                this._free += i3;
                return i3;
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                if (i3 == 0) {
                    return;
                }
                if (this._free < i3) {
                    resize(i3);
                }
                if (this._in == this._out) {
                    this._out = 0;
                    this._in = 0;
                }
                byte[] bArr2 = this._buf;
                int length = bArr2.length;
                int i4 = this._in;
                int i5 = length - i4;
                if (i4 > this._out && i3 >= i5) {
                    System.arraycopy(bArr, i2, bArr2, i4, i5);
                    System.arraycopy(bArr, i2 + i5, this._buf, 0, i3 - i5);
                    this._in = (this._in + i3) % this._buf.length;
                } else {
                    System.arraycopy(bArr, i2, bArr2, i4, i3);
                    this._in += i3;
                }
                this._free -= i3;
            }
        }

        @Override // java.io.InputStream
        public int read(final byte[] bArr, final int i2, final int i3) throws IOException {
            checkClosed();
            Objects.requireNonNull(bArr, "buf to read into is null");
            if (i2 >= 0 && i2 <= bArr.length) {
                return Saver.syncWrap(this._locale, new SyncWrapFun() { // from class: org.apache.xmlbeans.impl.store.m7
                    @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
                    public final int process() {
                        return this.a.f(bArr, i2, i3);
                    }
                });
            }
            throw new IndexOutOfBoundsException("Offset is not within buf");
        }
    }

    static final class TextSaver extends Saver {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int _initialBufSize = 4096;
        private char[] _cbuf;
        private int _cdataEntityCountThreshold;
        private int _cdataLengthThreshold;
        private int _free;
        private int _in;
        private boolean _isPrettyPrint;
        private int _lastEmitCch;
        private int _lastEmitIn;
        private int _out;
        private boolean _useCDataBookmarks;

        TextSaver(Cur cur, XmlOptions xmlOptions, String str) {
            super(cur, xmlOptions);
            this._cdataLengthThreshold = 32;
            this._cdataEntityCountThreshold = 5;
            this._useCDataBookmarks = false;
            this._isPrettyPrint = false;
            boolean z = xmlOptions != null && xmlOptions.isSaveNoXmlDecl();
            if (xmlOptions != null && xmlOptions.getSaveCDataLengthThreshold() != null) {
                this._cdataLengthThreshold = xmlOptions.getSaveCDataLengthThreshold().intValue();
            }
            if (xmlOptions != null && xmlOptions.getSaveCDataEntityCountThreshold() != null) {
                this._cdataEntityCountThreshold = xmlOptions.getSaveCDataEntityCountThreshold().intValue();
            }
            if (xmlOptions != null && xmlOptions.isUseCDataBookmarks()) {
                this._useCDataBookmarks = true;
            }
            if (xmlOptions != null && xmlOptions.isSavePrettyPrint()) {
                this._isPrettyPrint = true;
            }
            this._out = 0;
            this._in = 0;
            this._free = 0;
            if (str == null || z) {
                return;
            }
            XmlDocumentProperties docProps = Locale.getDocProps(cur, false);
            Boolean boolValueOf = null;
            String version = docProps == null ? null : docProps.getVersion();
            version = version == null ? "1.0" : version;
            if (docProps != null && docProps.get(XmlDocumentProperties.STANDALONE) != null) {
                boolValueOf = Boolean.valueOf(docProps.getStandalone());
            }
            emit("<?xml version=\"");
            emit(version);
            emit("\" encoding=\"" + str + "\"");
            if (boolValueOf != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" standalone=\"");
                sb.append(boolValueOf.booleanValue() ? "yes" : "no");
                sb.append("\"");
                emit(sb.toString());
            }
            emit("?>" + Saver._newLine);
        }

        private void emit(char c) {
            preEmit(1);
            char[] cArr = this._cbuf;
            int i2 = this._in;
            cArr[i2] = c;
            this._in = (i2 + 1) % cArr.length;
        }

        private void emitAttrHelper(QName qName, String str) {
            emit(Chars.SPACE);
            emitName(qName, true);
            emit(Chars.EQ, Chars.DQUOTE);
            emit(str);
            entitizeAttrValue(true);
            emit(Chars.DQUOTE);
        }

        private void emitLiteral(String str) {
            if (str.contains("\"")) {
                emit(Chars.QUOTE);
                emit(str);
                emit(Chars.QUOTE);
            } else {
                emit(Chars.DQUOTE);
                emit(str);
                emit(Chars.DQUOTE);
            }
        }

        private void emitName(QName qName, boolean z) {
            if (qName != null && (qName.getLocalPart() == null || qName.getLocalPart().isEmpty())) {
                throw new IllegalArgumentException("emitName does not support names with empty local part");
            }
            String namespaceURI = qName.getNamespaceURI();
            if (!namespaceURI.isEmpty()) {
                String prefix = qName.getPrefix();
                String namespaceForPrefix = getNamespaceForPrefix(prefix);
                if (namespaceForPrefix == null || !namespaceForPrefix.equals(namespaceURI)) {
                    prefix = getUriMapping(namespaceURI);
                }
                if (z && prefix.isEmpty()) {
                    prefix = getNonDefaultUriMapping(namespaceURI);
                }
                if (!prefix.isEmpty()) {
                    emit(prefix);
                    emit(NameUtil.COLON);
                }
            }
            emit(qName.getLocalPart());
        }

        private void emitNamespacesHelper() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            iterateMappings();
            while (hasMapping()) {
                String strMappingPrefix = mappingPrefix();
                String strMappingUri = mappingUri();
                if (!linkedHashMap.containsKey(strMappingPrefix)) {
                    linkedHashMap.put(strMappingPrefix, strMappingUri);
                } else if (strMappingPrefix.isEmpty() && ((String) linkedHashMap.get(strMappingPrefix)).isEmpty()) {
                    linkedHashMap.put(strMappingPrefix, strMappingUri);
                }
                nextMapping();
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                emit(Chars.SPACE);
                emitXmlns((String) entry.getKey(), (String) entry.getValue());
            }
        }

        private int ensure(int i2) {
            if (i2 <= 0) {
                i2 = 1;
            }
            int available = getAvailable();
            while (available < i2 && process()) {
                available = getAvailable();
            }
            return available;
        }

        private void entitizeAttrValue(boolean z) {
            int i2 = this._lastEmitCch;
            if (i2 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            while (i2 > 0) {
                char c = this._cbuf[iReplace];
                if (c == '<') {
                    iReplace = replace(iReplace, "&lt;");
                } else if (c == '&') {
                    iReplace = replace(iReplace, "&amp;");
                } else if (c == '\"') {
                    iReplace = replace(iReplace, "&quot;");
                } else if (!isEscapedChar(c)) {
                    iReplace++;
                } else if (z) {
                    iReplace = replace(iReplace, this._replaceChar.getEscapedString(c));
                }
                if (iReplace == this._cbuf.length) {
                    iReplace = 0;
                }
                i2--;
            }
        }

        private void entitizeComment() {
            int i2 = this._lastEmitCch;
            if (i2 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            boolean z = false;
            while (i2 > 0) {
                char c = this._cbuf[iReplace];
                if (Saver.isBadChar(c)) {
                    iReplace = replace(iReplace, "?");
                } else {
                    if (c != '-') {
                        iReplace++;
                    } else if (z) {
                        iReplace = replace(iReplace, " ");
                    } else {
                        iReplace++;
                        z = true;
                    }
                    z = false;
                }
                if (iReplace == this._cbuf.length) {
                    iReplace = 0;
                }
                i2--;
            }
            int i3 = (this._lastEmitIn + this._lastEmitCch) - 1;
            char[] cArr = this._cbuf;
            int length = i3 % cArr.length;
            if (cArr[length] == '-') {
                replace(length, " ");
            }
        }

        private void entitizeContent(boolean z) {
            int i2;
            int i3 = this._lastEmitCch;
            if (i3 == 0) {
                return;
            }
            int i4 = this._lastEmitIn;
            int length = this._cbuf.length;
            int i5 = 0;
            boolean z2 = false;
            char c = 0;
            char c2 = 0;
            while (i3 > 0) {
                char c3 = this._cbuf[i4];
                if (c3 == '<' || c3 == '&') {
                    i5++;
                } else if ((c == ']' && c2 == ']' && c3 == '>') || Saver.isBadChar(c3) || isEscapedChar(c3) || (!this._isPrettyPrint && c3 == '\r')) {
                    z2 = true;
                }
                i4++;
                if (i4 == length) {
                    i4 = 0;
                }
                i3--;
                c = c2;
                c2 = c3;
            }
            if (z || i5 != 0 || z2 || i5 >= this._cdataEntityCountThreshold) {
                int iReplace = this._lastEmitIn;
                if (!z && ((i2 = this._lastEmitCch) <= this._cdataLengthThreshold || i5 <= this._cdataEntityCountThreshold)) {
                    char c4 = 0;
                    char c5 = 0;
                    while (i2 > 0) {
                        char c6 = this._cbuf[iReplace];
                        iReplace = c6 == '<' ? replace(iReplace, "&lt;") : c6 == '&' ? replace(iReplace, "&amp;") : (c6 == '>' && c5 == ']' && c4 == ']') ? replace(iReplace, "&gt;") : Saver.isBadChar(c6) ? replace(iReplace, "?") : (this._isPrettyPrint || c6 != '\r') ? isEscapedChar(c6) ? replace(iReplace, this._replaceChar.getEscapedString(c6)) : iReplace + 1 : replace(iReplace, "&#13;");
                        if (iReplace == this._cbuf.length) {
                            iReplace = 0;
                        }
                        i2--;
                        c4 = c5;
                        c5 = c6;
                    }
                    return;
                }
                boolean z3 = this._cbuf[iReplace] == ']';
                int iReplace2 = replace(iReplace, "<![CDATA[" + this._cbuf[iReplace]);
                char[] cArr = this._cbuf;
                boolean z4 = cArr[iReplace2] == ']';
                int iReplace3 = iReplace2 + 1;
                if (iReplace3 == cArr.length) {
                    iReplace3 = 0;
                }
                int i6 = this._lastEmitCch - 2;
                while (i6 > 0) {
                    char c7 = this._cbuf[iReplace3];
                    iReplace3 = (c7 == '>' && z3 && z4) ? replace(iReplace3, "]]>><![CDATA[") : Saver.isBadChar(c7) ? replace(iReplace3, "?") : iReplace3 + 1;
                    boolean z5 = c7 == ']';
                    if (iReplace3 == this._cbuf.length) {
                        iReplace3 = 0;
                    }
                    i6--;
                    boolean z6 = z4;
                    z4 = z5;
                    z3 = z6;
                }
                emit("]]>");
            }
        }

        private void entitizeProcinst() {
            int i2 = this._lastEmitCch;
            if (i2 == 0) {
                return;
            }
            int iReplace = this._lastEmitIn;
            boolean z = false;
            while (i2 > 0) {
                char c = this._cbuf[iReplace];
                if (Saver.isBadChar(c)) {
                    iReplace = replace(iReplace, "?");
                }
                if (c == '>') {
                    iReplace = z ? replace(iReplace, " ") : iReplace + 1;
                    z = false;
                } else {
                    z = c == '?';
                    iReplace++;
                }
                if (iReplace == this._cbuf.length) {
                    iReplace = 0;
                }
                i2--;
            }
        }

        private boolean isEscapedChar(char c) {
            XmlOptionCharEscapeMap xmlOptionCharEscapeMap = this._replaceChar;
            return xmlOptionCharEscapeMap != null && xmlOptionCharEscapeMap.containsChar(c);
        }

        private boolean preEmit(int i2) {
            this._lastEmitCch = i2;
            if (i2 == 0) {
                return true;
            }
            if (this._free <= i2) {
                resize(i2, -1);
            }
            if (getAvailable() == 0) {
                this._out = 0;
                this._in = 0;
            }
            this._lastEmitIn = this._in;
            this._free -= i2;
            return false;
        }

        private int replace(int i2, String str) {
            int length = str.length() - 1;
            if (length == 0) {
                this._cbuf[i2] = str.charAt(0);
                return i2 + 1;
            }
            if (length > this._free) {
                i2 = resize(length, i2);
            }
            int i3 = length + 1;
            int i4 = this._out;
            int i5 = this._in;
            if (i4 <= i5 || i2 < i4) {
                char[] cArr = this._cbuf;
                int length2 = cArr.length - i5;
                if (length <= length2) {
                    System.arraycopy(cArr, i2, cArr, i2 + length, i5 - i2);
                    this._in = (this._in + length) % this._cbuf.length;
                } else if (length <= ((length2 + i5) - i2) - 1) {
                    int i6 = length - length2;
                    System.arraycopy(cArr, i5 - i6, cArr, 0, i6);
                    char[] cArr2 = this._cbuf;
                    int i7 = i2 + 1;
                    System.arraycopy(cArr2, i7, cArr2, i7 + length, ((this._in - i2) - 1) - i6);
                    this._in = i6;
                } else {
                    int i8 = (i5 - i2) - 1;
                    int i9 = (length2 + i5) - i2;
                    System.arraycopy(cArr, i5 - i8, cArr, (length - i9) + 1, i8);
                    str.getChars(i9, i3, this._cbuf, 0);
                    this._in = ((i8 + length) - i9) + 1;
                    i3 = i9;
                }
            } else {
                char[] cArr3 = this._cbuf;
                System.arraycopy(cArr3, i4, cArr3, i4 - length, i2 - i4);
                this._out -= length;
                i2 -= length;
            }
            str.getChars(0, i3, this._cbuf, i2);
            this._free -= length;
            return ((i2 + length) + 1) % this._cbuf.length;
        }

        private int resize(int i2, int i3) {
            long length = this._cbuf == null ? ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF : r0.length * 2;
            int available = getAvailable();
            while (length - available < i2) {
                length *= 2;
            }
            int iMin = (int) Math.min(length, 2147483639L);
            char[] cArr = new char[iMin];
            if (available > 0) {
                int i4 = this._in;
                int i5 = this._out;
                if (i4 > i5) {
                    System.arraycopy(this._cbuf, i5, cArr, 0, available);
                    i3 -= this._out;
                } else {
                    int i6 = available - i4;
                    System.arraycopy(this._cbuf, i5, cArr, 0, i6);
                    System.arraycopy(this._cbuf, 0, cArr, i6, this._in);
                    int i7 = this._out;
                    i3 = i3 >= i7 ? i3 - i7 : i3 + i6;
                }
                this._out = 0;
                this._in = available;
                this._free += iMin - this._cbuf.length;
            } else {
                this._free = iMin;
            }
            this._cbuf = cArr;
            return i3;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitComment(SaveCur saveCur) {
            emit("<!--");
            saveCur.push();
            saveCur.next();
            emit(saveCur);
            saveCur.pop();
            entitizeComment();
            emit("-->");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitDocType(String str, String str2, String str3) {
            emit("<!DOCTYPE ");
            emit(str);
            if (str2 == null && str3 != null) {
                emit(" SYSTEM ");
                emitLiteral(str3);
            } else if (str2 != null) {
                emit(" PUBLIC ");
                emitLiteral(str2);
                emit(" ");
                emitLiteral(str3);
            }
            emit(">");
            emit(Saver._newLine);
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected boolean emitElement(SaveCur saveCur, List<QName> list, List<String> list2) {
            emit('<');
            emitName(saveCur.getName(), false);
            if (saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                emitAttrHelper(list.get(i2), list2.get(i2));
            }
            if (!saveNamespacesFirst()) {
                emitNamespacesHelper();
            }
            if (saveCur.hasChildren() || saveCur.hasText()) {
                emit('>');
                return false;
            }
            emit('/', '>');
            return true;
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitEndDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitFinish(SaveCur saveCur) {
            emit('<', '/');
            emitName(saveCur.getName(), false);
            emit('>');
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitProcinst(SaveCur saveCur) {
            emit("<?");
            emit(saveCur.getName().getLocalPart());
            saveCur.push();
            saveCur.next();
            if (saveCur.isText()) {
                emit(" ");
                emit(saveCur);
                entitizeProcinst();
            }
            saveCur.pop();
            emit("?>");
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitStartDoc(SaveCur saveCur) {
        }

        @Override // org.apache.xmlbeans.impl.store.Saver
        protected void emitText(SaveCur saveCur) {
            boolean z = this._useCDataBookmarks && saveCur.isTextCData();
            emit(saveCur);
            entitizeContent(z);
        }

        protected void emitXmlns(String str, String str2) {
            emit("xmlns");
            if (!str.isEmpty()) {
                emit(NameUtil.COLON);
                emit(str);
            }
            emit(Chars.EQ, Chars.DQUOTE);
            emit(str2);
            entitizeAttrValue(false);
            emit(Chars.DQUOTE);
        }

        int getAvailable() {
            char[] cArr = this._cbuf;
            if (cArr == null) {
                return 0;
            }
            return cArr.length - this._free;
        }

        public int read() {
            if (ensure(1) == 0) {
                return -1;
            }
            char[] cArr = this._cbuf;
            int i2 = this._out;
            char c = cArr[i2];
            this._out = (i2 + 1) % cArr.length;
            this._free++;
            return c;
        }

        public String saveToString() {
            while (process()) {
            }
            int available = getAvailable();
            return available == 0 ? "" : new String(this._cbuf, this._out, available);
        }

        public int write(Writer writer, int i2) throws IOException {
            while (getAvailable() < i2 && process()) {
            }
            int available = getAvailable();
            if (available > 0) {
                char[] cArr = this._cbuf;
                if (cArr.length - this._in != this._free) {
                    this._in = cArr.length;
                }
                try {
                    writer.write(cArr, 0, available);
                    writer.flush();
                    this._free += available;
                    this._in = 0;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return available;
        }

        private void emit(char c, char c2) {
            if (preEmit(2)) {
                return;
            }
            char[] cArr = this._cbuf;
            int i2 = this._in;
            cArr[i2] = c;
            int length = (i2 + 1) % cArr.length;
            this._in = length;
            cArr[length] = c2;
            this._in = (length + 1) % cArr.length;
        }

        public int read(char[] cArr, int i2, int i3) {
            int iEnsure = ensure(i3);
            if (iEnsure == 0) {
                return -1;
            }
            if (cArr == null || i3 <= 0) {
                return 0;
            }
            if (iEnsure < i3) {
                i3 = iEnsure;
            }
            int i4 = this._out;
            if (i4 < this._in) {
                System.arraycopy(this._cbuf, i4, cArr, i2, i3);
            } else {
                char[] cArr2 = this._cbuf;
                int length = cArr2.length - i4;
                if (length >= i3) {
                    System.arraycopy(cArr2, i4, cArr, i2, i3);
                } else {
                    System.arraycopy(cArr2, i4, cArr, i2, length);
                    System.arraycopy(this._cbuf, 0, cArr, i2 + length, i3 - length);
                }
            }
            this._out = (this._out + i3) % this._cbuf.length;
            this._free += i3;
            return i3;
        }

        private void emit(String str) {
            int length = str == null ? 0 : str.length();
            if (preEmit(length) || str == null) {
                return;
            }
            int i2 = this._in;
            if (i2 > this._out) {
                char[] cArr = this._cbuf;
                int length2 = cArr.length - i2;
                if (length >= length2) {
                    str.getChars(0, length2, cArr, i2);
                    str.getChars(length2, length, this._cbuf, 0);
                    this._in = (this._in + length) % this._cbuf.length;
                    return;
                }
            }
            str.getChars(0, length, this._cbuf, i2);
            this._in += length;
        }

        private void emit(SaveCur saveCur) {
            if (saveCur.isText()) {
                Object chars = saveCur.getChars();
                int i2 = saveCur._cchSrc;
                if (preEmit(i2)) {
                    return;
                }
                int i3 = this._in;
                if (i3 > this._out) {
                    char[] cArr = this._cbuf;
                    int length = cArr.length - i3;
                    if (i2 >= length) {
                        CharUtil.getChars(cArr, i3, chars, saveCur._offSrc, length);
                        CharUtil.getChars(this._cbuf, 0, chars, saveCur._offSrc + length, i2 - length);
                        this._in = (this._in + i2) % this._cbuf.length;
                        return;
                    }
                }
                CharUtil.getChars(this._cbuf, i3, chars, saveCur._offSrc, i2);
                this._in += i2;
                return;
            }
            preEmit(0);
        }
    }
}
