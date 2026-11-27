package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.xpath.XPathFactory;

/* loaded from: classes.dex */
abstract class Xobj implements TypeStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int INHIBIT_DISCONNECT = 1024;
    static final int STABLE_USER = 512;
    static final int VACANT = 256;
    int _bits;
    Bookmark _bookmarks;
    int _cchAfter;
    int _cchValue;
    CharNode _charNodesAfter;
    CharNode _charNodesValue;
    Cur _embedded;
    Xobj _firstChild;
    Xobj _lastChild;
    Locale _locale;
    QName _name;
    Xobj _nextSibling;
    int _offAfter;
    int _offValue;
    Xobj _parent;
    Xobj _prevSibling;
    Object _srcAfter;
    Object _srcValue;
    TypeStoreUser _user;

    Xobj(Locale locale, int i2, int i3) {
        this._locale = locale;
        this._bits = (i3 << 4) + i2;
    }

    static /* synthetic */ TypeStoreUser a(XmlObject xmlObject) {
        return (TypeStoreUser) xmlObject;
    }

    static /* synthetic */ Xobj b(TypeStore typeStore) {
        return (Xobj) typeStore;
    }

    private static TypeStoreUser insertElement(QName qName, Xobj xobj, int i2) {
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj._locale.tempCur();
            curTempCur.moveTo(xobj, i2);
            curTempCur.createElement(qName);
            TypeStoreUser user = curTempCur.getUser();
            curTempCur.release();
            return user;
        } finally {
            xobj._locale.exit();
        }
    }

    private static void removeElement(Xobj xobj) {
        if (xobj == null) {
            throw new IndexOutOfBoundsException();
        }
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj.tempCur();
            curTempCur.moveNode(null);
            curTempCur.release();
        } finally {
            xobj._locale.exit();
        }
    }

    private void setValue(String str) {
        Xobj xobj;
        if (str.length() <= 0) {
            return;
        }
        this._locale.notifyChange();
        Xobj xobjLastAttr = lastAttr();
        int iPosAfter = 1;
        if (xobjLastAttr != null) {
            iPosAfter = xobjLastAttr.posAfter();
            xobj = xobjLastAttr;
        } else {
            xobj = this;
        }
        xobj.insertCharsHelper(iPosAfter, str, 0, str.length(), true);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_attribute_user(QName qName) {
        if (getAttr(qName) != null) {
            throw new IndexOutOfBoundsException();
        }
        this._locale.enter();
        try {
            return setAttr(qName, "").getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_element_user(QName qName) {
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = null;
        boolean z = false;
        QNameSet qNameSet = null;
        for (Xobj xobj2 = this._lastChild; xobj2 != null; xobj2 = xobj2._prevSibling) {
            if (xobj2.isContainer()) {
                if (xobj2._name.equals(qName)) {
                    break;
                }
                if (!z) {
                    qNameSet = this._user.get_element_ending_delimiters(qName);
                    z = true;
                }
                if (qNameSet == null || qNameSet.contains(xobj2._name)) {
                    xobj = xobj2;
                }
            }
        }
        return xobj == null ? insertElement(qName, this, -1) : insertElement(qName, xobj, 0);
    }

    final Xobj appendXobj(Xobj xobj) {
        xobj._parent = this;
        Xobj xobj2 = this._lastChild;
        xobj._prevSibling = xobj2;
        if (xobj2 == null) {
            this._firstChild = xobj;
        } else {
            xobj2._nextSibling = xobj;
        }
        this._lastChild = xobj;
        return this;
    }

    final void appendXobjs(Xobj xobj, Xobj xobj2) {
        Xobj xobj3 = this._lastChild;
        xobj._prevSibling = xobj3;
        if (xobj3 == null) {
            this._firstChild = xobj;
        } else {
            xobj3._nextSibling = xobj;
        }
        this._lastChild = xobj2;
        while (xobj != null) {
            xobj._parent = this;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void array_setter(XmlObject[] xmlObjectArr, QName qName) {
        this._locale.enter();
        try {
            int length = xmlObjectArr.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (XmlObject xmlObject : xmlObjectArr) {
                if (xmlObject == null) {
                    throw new IllegalArgumentException("Array element null");
                }
                if (xmlObject.isImmutable()) {
                    arrayList.add(null);
                    arrayList2.add(null);
                } else {
                    Xobj xobj = (Xobj) ((TypeStoreUser) xmlObject).get_store();
                    Locale locale = xobj._locale;
                    Locale locale2 = this._locale;
                    if (locale == locale2) {
                        arrayList.add(xobj.copyNode(locale2));
                    } else {
                        locale.enter();
                        try {
                            arrayList.add(xobj.copyNode(this._locale));
                        } finally {
                            xobj._locale.exit();
                        }
                    }
                    arrayList2.add(xmlObject.schemaType());
                }
            }
            int iCount_elements = count_elements(qName);
            while (iCount_elements > length) {
                remove_element(qName, length);
                iCount_elements--;
            }
            while (length > iCount_elements) {
                add_element_user(qName);
                iCount_elements++;
            }
            ArrayList arrayList3 = new ArrayList();
            find_all_element_users(qName, arrayList3);
            List list = (List) arrayList3.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.store.y7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Xobj.a((XmlObject) obj);
                }
            }).map(new Function() { // from class: org.apache.xmlbeans.impl.store.j9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((TypeStoreUser) obj).get_store();
                }
            }).map(new Function() { // from class: org.apache.xmlbeans.impl.store.z7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Xobj.b((TypeStore) obj);
                }
            }).collect(Collectors.toList());
            Cur curTempCur = tempCur();
            for (int i2 = 0; i2 < iCount_elements; i2++) {
                Xobj xobj2 = (Xobj) list.get(i2);
                if (xmlObjectArr[i2].isImmutable()) {
                    xobj2.getObject().set(xmlObjectArr[i2]);
                } else {
                    Cur.moveNodeContents(xobj2, null, true);
                    curTempCur.moveTo(xobj2);
                    curTempCur.next();
                    Cur.moveNodeContents((Xobj) arrayList.get(i2), curTempCur, true);
                    xobj2.change_type((SchemaType) arrayList2.get(i2));
                }
            }
            curTempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    final boolean bitIsClear(int i2) {
        return (i2 & this._bits) == 0;
    }

    final boolean bitIsSet(int i2) {
        return (i2 & this._bits) != 0;
    }

    final int cchAfter() {
        return this._cchAfter;
    }

    final int cchLeft(int i2) {
        if (isRoot() && i2 == 0) {
            return 0;
        }
        Xobj denormal = getDenormal(i2);
        int iPosTemp = posTemp();
        int iPosAfter = denormal.posAfter();
        if (iPosTemp < iPosAfter) {
            iPosAfter = 1;
        }
        return iPosTemp - iPosAfter;
    }

    final int cchRight(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return i2 < posAfter() ? (r0 - i2) - 1 : posMax() - i2;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser change_type(SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setType(schemaType, false);
            curTempCur.release();
            this._locale.exit();
            return getUser();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    final void clearBit(int i2) {
        this._bits = (~i2) & this._bits;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String compute_default_text() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_default_attribute_text(this._name);
        }
        String str = user.get_default_element_text(this._name);
        if (str != null) {
            return str;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_default_text();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int compute_flags() {
        if (isRoot()) {
            return 0;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attributeflags(this._name);
        }
        int i2 = user.get_elementflags(this._name);
        if (i2 != -1) {
            return i2;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return 0;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_elementflags();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    final boolean contains(Cur cur) {
        return contains(cur._xobj, cur._pos);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType documentType = xmlOptionsMaskNull.getDocumentType();
        if (documentType == null) {
            documentType = schemaType == null ? XmlObject.type : schemaType;
        }
        Locale locale = locale();
        if (xmlOptionsMaskNull.isCopyUseNewSynchronizationDomain()) {
            locale = Locale.getLocale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, (documentType.isDocumentType() || (documentType.isNoType() && (this instanceof DocumentXobj))) ? false : true);
        locale.enter();
        try {
            Cur curTempCur = xobjCreateDomDocumentRootXobj.tempCur();
            curTempCur.setType(schemaType);
            curTempCur.release();
            locale.exit();
            return xobjCreateDomDocumentRootXobj.copy_contents_from(this);
        } catch (Throwable th) {
            locale.exit();
            throw th;
        }
    }

    Xobj copyNode(Locale locale) {
        Xobj xobj = this;
        Xobj xobj2 = null;
        Xobj xobj3 = null;
        while (true) {
            xobj.ensureOccupancy();
            Xobj xobjNewNode = xobj.newNode(locale);
            xobjNewNode._srcValue = xobj._srcValue;
            xobjNewNode._offValue = xobj._offValue;
            xobjNewNode._cchValue = xobj._cchValue;
            xobjNewNode._srcAfter = xobj._srcAfter;
            xobjNewNode._offAfter = xobj._offAfter;
            xobjNewNode._cchAfter = xobj._cchAfter;
            for (Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                CDataBookmark cDataBookmark = CDataBookmark.CDATA_BOOKMARK;
                if (xobj.hasBookmark(cDataBookmark.getKey(), bookmark._pos)) {
                    xobjNewNode.setBookmark(bookmark._pos, cDataBookmark.getKey(), cDataBookmark);
                }
            }
            if (xobj2 == null) {
                xobj3 = xobjNewNode;
            } else {
                xobj2.appendXobj(xobjNewNode);
            }
            Xobj xobjWalk = xobj.walk(this, true);
            if (xobjWalk == null) {
                xobj3._srcAfter = null;
                xobj3._offAfter = 0;
                xobj3._cchAfter = 0;
                return xobj3;
            }
            if (xobj == xobjWalk._parent) {
                xobj2 = xobjNewNode;
            } else {
                while (true) {
                    xobj = xobj._parent;
                    if (xobj != xobjWalk._parent) {
                        xobj2 = xobj2._parent;
                    }
                }
            }
            xobj = xobjWalk;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy_contents_from(TypeStore typeStore) {
        Xobj xobj = (Xobj) typeStore;
        if (xobj == this) {
            return getUser();
        }
        this._locale.enter();
        try {
            xobj._locale.enter();
            Cur curTempCur = tempCur();
            try {
                Cur curTempCur2 = xobj.tempCur();
                Map<String, String> allNamespaces = Locale.getAllNamespaces(curTempCur2, null);
                curTempCur2.release();
                if (isAttr()) {
                    Cur curTempCur3 = xobj.tempCur();
                    String textValue = Locale.getTextValue(curTempCur3);
                    curTempCur3.release();
                    curTempCur.setValue(textValue);
                } else {
                    disconnectChildrenUsers();
                    setBit(1024);
                    QName xsiTypeName = isContainer() ? getXsiTypeName() : null;
                    Xobj xobjCopyNode = xobj.copyNode(this._locale);
                    Cur.moveNodeContents(this, null, true);
                    curTempCur.next();
                    Cur.moveNodeContents(xobjCopyNode, curTempCur, true);
                    curTempCur.moveTo(this);
                    if (xsiTypeName != null) {
                        curTempCur.setXsiType(xsiTypeName);
                    }
                    clearBit(1024);
                }
                if (allNamespaces != null) {
                    if (!curTempCur.isContainer()) {
                        curTempCur.toParent();
                    }
                    Locale.applyNamespaces(curTempCur, allNamespaces);
                }
                this._locale.exit();
                return getUser();
            } finally {
                curTempCur.release();
                xobj._locale.exit();
            }
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QName qName) {
        return this._locale.count(this, qName, null);
    }

    void disconnectChildrenUsers() {
        Xobj xobjWalk = walk(this, this._user == null);
        while (xobjWalk != null) {
            Xobj xobjWalk2 = xobjWalk.walk(this, xobjWalk._user != null);
            xobjWalk.disconnectUser();
            xobjWalk = xobjWalk2;
        }
    }

    void disconnectNonRootUsers() {
        Xobj xobj = this;
        while (xobj != null) {
            Xobj xobjWalk = xobj.walk(this, xobj._user != null);
            if (!xobj.isRoot()) {
                xobj.disconnectUser();
            }
            xobj = xobjWalk;
        }
    }

    void disconnectUser() {
        if (this._user == null || inhibitDisconnect()) {
            return;
        }
        ensureOccupancy();
        this._user.disconnect_store();
        this._user = null;
    }

    final int domType() {
        return (this._bits & 240) >> 4;
    }

    public void dump(PrintStream printStream, Object obj) {
        Cur.dump(printStream, this, obj);
    }

    final void ensureOccupancy() {
        if (isVacant()) {
            clearBit(256);
            TypeStoreUser typeStoreUser = this._user;
            this._user = null;
            String strBuild_text = typeStoreUser.build_text(this);
            Locale locale = this._locale;
            long j2 = locale._versionAll;
            long j3 = locale._versionSansText;
            setValue(strBuild_text);
            this._locale._versionAll = j2;
            this._user = typeStoreUser;
        }
    }

    final Xobj ensureParent() {
        Xobj xobj = this._parent;
        return xobj == null ? new DocumentFragXobj(this._locale).appendXobj(this) : xobj;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlObject[] exec_query(String str, XmlOptions xmlOptions) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            XmlObject[] xmlObjectArrObjectExecQuery = XPathFactory.objectExecQuery(curTempCur, str, xmlOptions);
            curTempCur.release();
            return xmlObjectArrObjectExecQuery;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String fetch_text(int i2) {
        this._locale.enter();
        try {
            return getValueAsString(i2);
        } finally {
            this._locale.exit();
        }
    }

    final Xobj findXmlnsForPrefix(String str) {
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsPrefix().equals(str)) {
                    return xobjFirstAttr;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QName qName, List<T> list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName)) {
                list.add((XmlObject) xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_attribute_user(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return null;
        }
        return attr.getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QName qName, int i2) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName) && i2 - 1 < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean find_nil() {
        boolean z = false;
        if (isAttr()) {
            return false;
        }
        this._locale.enter();
        try {
            Xobj attr = getAttr(Locale._xsiNil);
            if (attr != null) {
                String valueAsString = attr.getValueAsString(3);
                if (!valueAsString.equals("true")) {
                    if (valueAsString.equals("1")) {
                        z = true;
                    }
                }
            }
            return z;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.NamespaceManager
    public String find_prefix_for_nsuri(String str, String str2) {
        this._locale.enter();
        try {
            return prefixForNamespace(str, str2, true);
        } finally {
            this._locale.exit();
        }
    }

    final Xobj firstAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        return this._firstChild;
    }

    final Xobj getAttr(QName qName) {
        for (Xobj xobj = this._firstChild; xobj != null && xobj.isAttr(); xobj = xobj._nextSibling) {
            if (xobj._name.equals(qName)) {
                return xobj;
            }
        }
        return null;
    }

    Object getChars(int i2, int i3, Cur cur) {
        Object chars = getChars(i2, i3);
        Locale locale = this._locale;
        cur._offSrc = locale._offSrc;
        cur._cchSrc = locale._cchSrc;
        return chars;
    }

    String getCharsAfterAsString(int i2, int i3) {
        int i4 = i2 + this._cchValue + 2;
        if (i4 == posMax()) {
            i4 = -1;
        }
        return getCharsAsString(i4, i3, 1);
    }

    String getCharsAsString(int i2, int i3, int i4) {
        if (cchRight(i2) == 0) {
            return "";
        }
        Object chars = getChars(i2, i3);
        if (i4 == 1) {
            Locale locale = this._locale;
            return CharUtil.getString(chars, locale._offSrc, locale._cchSrc);
        }
        Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i4);
        Locale locale2 = this._locale;
        scrubBuffer.scrub(chars, locale2._offSrc, locale2._cchSrc);
        return scrubBuffer.getResultAsString();
    }

    Object getCharsHelper(int i2, int i3) {
        Object obj;
        int iPosAfter = posAfter();
        if (i2 >= iPosAfter) {
            obj = this._srcAfter;
            this._locale._offSrc = (this._offAfter + i2) - iPosAfter;
        } else {
            obj = this._srcValue;
            this._locale._offSrc = (this._offValue + i2) - 1;
        }
        this._locale._cchSrc = i3;
        return obj;
    }

    String getCharsValueAsString(int i2, int i3) {
        return getCharsAsString(i2 + 1, i3, 1);
    }

    final Xobj getDenormal(int i2) {
        Xobj xobj;
        Xobj xobjEnsureParent;
        int iPosMax;
        if (i2 != 0) {
            if (i2 == -1) {
                xobjEnsureParent = this._lastChild;
                if (xobjEnsureParent == null) {
                    i2 = posAfter() - 1;
                } else {
                    iPosMax = xobjEnsureParent.posMax();
                }
            }
            xobj = this;
            this._locale._posTemp = i2;
            return xobj;
        }
        xobjEnsureParent = this._prevSibling;
        if (xobjEnsureParent == null) {
            xobjEnsureParent = ensureParent();
            iPosMax = xobjEnsureParent.posAfter() - 1;
        } else {
            iPosMax = xobjEnsureParent.posMax();
        }
        int i3 = iPosMax;
        xobj = xobjEnsureParent;
        i2 = i3;
        this._locale._posTemp = i2;
        return xobj;
    }

    abstract DomImpl.Dom getDom();

    protected final int getDomZeroOneChildren() {
        CharNode charNode;
        if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null) {
            return 0;
        }
        Xobj xobj = this._lastChild;
        if (xobj != null && xobj.isAttr()) {
            Xobj xobj2 = this._lastChild;
            if (xobj2._charNodesAfter == null && xobj2._srcAfter == null && this._srcValue == null && this._charNodesValue == null) {
                return 0;
            }
        }
        Xobj xobj3 = this._firstChild;
        if (xobj3 == this._lastChild && xobj3 != null && !xobj3.isAttr() && this._srcValue == null && this._charNodesValue == null && this._firstChild._srcAfter == null) {
            return 1;
        }
        if (this._firstChild == null && this._srcValue != null && ((charNode = this._charNodesValue) == null || (charNode._next == null && charNode._cch == this._cchValue))) {
            return 1;
        }
        Xobj xobjLastAttr = lastAttr();
        Xobj xobj4 = xobjLastAttr == null ? null : xobjLastAttr._nextSibling;
        return (xobjLastAttr != null && xobjLastAttr._srcAfter == null && xobj4 != null && xobj4._srcAfter == null && xobj4._nextSibling == null) ? 1 : 2;
    }

    final Cur getEmbedded() {
        this._locale.embedCurs();
        return this._embedded;
    }

    Object getFirstChars() {
        ensureOccupancy();
        if (this._cchValue > 0) {
            return getChars(1, -1);
        }
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr != null && xobjLastAttr._cchAfter > 0) {
            return xobjLastAttr.getChars(xobjLastAttr.posAfter(), -1);
        }
        Locale locale = this._locale;
        locale._offSrc = 0;
        locale._cchSrc = 0;
        return null;
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        return namespaceForPrefix(str, true);
    }

    final Xobj getNormal(int i2) {
        Xobj xobjEnsureParent;
        if (i2 == posMax()) {
            Xobj xobj = this._nextSibling;
            if (xobj != null) {
                xobjEnsureParent = xobj;
                i2 = 0;
            } else {
                xobjEnsureParent = ensureParent();
                i2 = -1;
            }
        } else if (i2 == posAfter() - 1) {
            xobjEnsureParent = this;
            i2 = -1;
        } else {
            xobjEnsureParent = this;
        }
        this._locale._posTemp = i2;
        return xobjEnsureParent;
    }

    final XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    public final QName getQName() {
        return this._name;
    }

    final TypeStoreUser getUser() {
        if (this._user == null) {
            Xobj xobj = this._parent;
            TypeStoreUser typeStoreUserCreateTypeStoreUser = xobj == null ? ((TypeStoreUserFactory) XmlBeans.NO_TYPE).createTypeStoreUser() : xobj.getUser();
            TypeStoreUser typeStoreUserCreate_element_user = isElem() ? typeStoreUserCreateTypeStoreUser.create_element_user(this._name, getXsiTypeName()) : typeStoreUserCreateTypeStoreUser.create_attribute_user(this._name);
            this._user = typeStoreUserCreate_element_user;
            typeStoreUserCreate_element_user.attach_store(this);
        }
        return this._user;
    }

    final QName getValueAsQName() {
        String strSubstring;
        String valueAsString = getValueAsString(3);
        int iIndexOf = valueAsString.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = valueAsString.substring(0, iIndexOf);
            valueAsString = valueAsString.substring(iIndexOf + 1);
        } else {
            strSubstring = "";
        }
        String strNamespaceForPrefix = namespaceForPrefix(strSubstring, true);
        if (strNamespaceForPrefix == null) {
            return null;
        }
        return new QName(strNamespaceForPrefix, valueAsString);
    }

    String getValueAsString(int i2) {
        if (hasChildren()) {
            Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i2);
            Cur curTempCur = tempCur();
            curTempCur.push();
            curTempCur.next();
            while (!curTempCur.isAtEndOfLastPush()) {
                if (curTempCur.isText()) {
                    scrubBuffer.scrub(curTempCur.getChars(-1), curTempCur._offSrc, curTempCur._cchSrc);
                }
                if (curTempCur.isComment() || curTempCur.isProcinst()) {
                    curTempCur.skip();
                } else {
                    curTempCur.next();
                }
            }
            String resultAsString = scrubBuffer.getResultAsString();
            curTempCur.release();
            return resultAsString;
        }
        Object firstChars = getFirstChars();
        if (i2 != 1) {
            Locale.ScrubBuffer scrubBuffer2 = Locale.getScrubBuffer(i2);
            Locale locale = this._locale;
            scrubBuffer2.scrub(firstChars, locale._offSrc, locale._cchSrc);
            return scrubBuffer2.getResultAsString();
        }
        Locale locale2 = this._locale;
        String string = CharUtil.getString(firstChars, locale2._offSrc, locale2._cchSrc);
        if (string.length() > 0) {
            Xobj xobjLastAttr = lastAttr();
            if (xobjLastAttr != null) {
                xobjLastAttr._srcAfter = string;
                xobjLastAttr._offAfter = 0;
            } else {
                this._srcValue = string;
                this._offValue = 0;
            }
        }
        return string;
    }

    final String getXmlnsPrefix() {
        return Locale.xmlnsPrefix(this._name);
    }

    final String getXmlnsUri() {
        return getValueAsString();
    }

    final QName getXsiTypeName() {
        Xobj attr = getAttr(Locale._xsiType);
        if (attr == null) {
            return null;
        }
        return attr.getValueAsQName();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlLocale get_locale() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public Object get_root_object() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaField get_schema_field() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attribute_field(this._name);
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_schema_field();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaTypeLoader get_schematypeloader() {
        return this._locale._schemaTypeLoader;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public QName get_xsi_type() {
        return getXsiTypeName();
    }

    final boolean hasAttrs() {
        Xobj xobj = this._firstChild;
        return xobj != null && xobj.isAttr();
    }

    final boolean hasBookmark(Object obj, int i2) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == i2 && obj == bookmark._key) {
                return true;
            }
        }
        return false;
    }

    final boolean hasChildren() {
        Xobj xobj = this._lastChild;
        return (xobj == null || xobj.isAttr()) ? false : true;
    }

    final boolean hasTextEnsureOccupancy() {
        ensureOccupancy();
        return hasTextNoEnsureOccupancy();
    }

    final boolean hasTextNoEnsureOccupancy() {
        if (this._cchValue > 0) {
            return true;
        }
        Xobj xobjLastAttr = lastAttr();
        return xobjLastAttr != null && xobjLastAttr._cchAfter > 0;
    }

    final boolean inChars(int i2, Xobj xobj, int i3, int i4, boolean z) {
        int i5;
        if (!z) {
            i5 = 0;
        } else {
            if (xobj.isRoot() && i3 == 0) {
                return false;
            }
            xobj = xobj.getDenormal(i3);
            i3 = xobj.posTemp();
            i5 = 1;
        }
        return xobj == this && i3 >= i2 && i3 < (i2 + i4) + i5;
    }

    final boolean inhibitDisconnect() {
        return bitIsSet(1024);
    }

    final void insertCharsHelper(int i2, Object obj, int i3, int i4, boolean z) {
        Xobj xobj;
        int iPosAfter = posAfter();
        if (i2 - (i2 < iPosAfter ? 1 : 2) < this._cchValue + this._cchAfter) {
            for (Cur embedded = getEmbedded(); embedded != null; embedded = embedded._next) {
                int i5 = embedded._pos;
                if (i5 >= i2) {
                    embedded._pos = i5 + i4;
                }
            }
            for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
                int i6 = bookmark._pos;
                if (i6 >= i2) {
                    bookmark._pos = i6 + i4;
                }
            }
        }
        CharUtil charUtil = this._locale.getCharUtil();
        if (i2 < iPosAfter) {
            this._srcValue = charUtil.insertChars(i2 - 1, this._srcValue, this._offValue, this._cchValue, obj, i3, i4);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.insertChars(i2 - iPosAfter, this._srcAfter, this._offAfter, this._cchAfter, obj, i3, i4);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z || (xobj = this._parent) == null) {
            return;
        }
        xobj.invalidateUser();
    }

    final void insertXobj(Xobj xobj) {
        ensureParent();
        xobj._parent = this._parent;
        xobj._prevSibling = this._prevSibling;
        xobj._nextSibling = this;
        Xobj xobj2 = this._prevSibling;
        if (xobj2 != null) {
            xobj2._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj;
    }

    final void insertXobjs(Xobj xobj, Xobj xobj2) {
        xobj._prevSibling = this._prevSibling;
        xobj2._nextSibling = this;
        Xobj xobj3 = this._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj2;
        while (xobj != this) {
            xobj._parent = this._parent;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QName qName, int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, qName, null, i2);
        if (xobjFindNthChildElem != null) {
            return insertElement(qName, xobjFindNthChildElem, 0);
        }
        if (i2 <= this._locale.count(this, qName, null) + 1) {
            return add_element_user(qName);
        }
        throw new IndexOutOfBoundsException();
    }

    void invalidateNil() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_nilvalue();
        }
    }

    final void invalidateSpecialAttr(Xobj xobj) {
        if (isAttr()) {
            if (this._name.equals(Locale._xsiType)) {
                Xobj xobj2 = this._parent;
                if (xobj2 != null) {
                    xobj2.disconnectNonRootUsers();
                }
                if (xobj != null) {
                    xobj.disconnectNonRootUsers();
                }
            }
            if (this._name.equals(Locale._xsiNil)) {
                Xobj xobj3 = this._parent;
                if (xobj3 != null) {
                    xobj3.invalidateNil();
                }
                if (xobj != null) {
                    xobj.invalidateNil();
                }
            }
        }
    }

    final void invalidateUser() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_value();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_nil() {
        if (isAttr()) {
            return;
        }
        this._locale.enter();
        try {
            if (this._user.build_nil()) {
                setAttr(Locale._xsiNil, "true");
            } else {
                removeAttr(Locale._xsiNil);
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_text() {
        this._locale.enter();
        try {
            if (isOccupied()) {
                if (hasTextNoEnsureOccupancy() || hasChildren()) {
                    TypeStoreUser typeStoreUser = this._user;
                    this._user = null;
                    Cur curTempCur = tempCur();
                    curTempCur.moveNodeContents(null, false);
                    curTempCur.release();
                    this._user = typeStoreUser;
                }
                setBit(256);
            }
        } finally {
            this._locale.exit();
        }
    }

    final boolean isAttr() {
        return kind() == 3;
    }

    protected final boolean isCharNodesAfterUsable() {
        if (this._srcAfter == null) {
            return false;
        }
        CharNode charNode = this._charNodesAfter;
        if (charNode != null && charNode._next == null && charNode._cch == this._cchAfter) {
            return true;
        }
        CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, charNode, this._cchAfter);
        this._charNodesAfter = charNodeUpdateCharNodes;
        return charNodeUpdateCharNodes != null;
    }

    protected final boolean isCharNodesValueUsable() {
        if (!isExistingCharNodesValueUsable()) {
            CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue);
            this._charNodesValue = charNodeUpdateCharNodes;
            if (charNodeUpdateCharNodes == null) {
                return false;
            }
        }
        return true;
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

    protected final boolean isExistingCharNodesValueUsable() {
        CharNode charNode;
        return this._srcValue != null && (charNode = this._charNodesValue) != null && charNode._next == null && charNode._cch == this._cchValue;
    }

    protected final boolean isFirstChildPtrDomUsable() {
        Xobj xobj = this._firstChild;
        if (xobj == null && this._srcValue == null && this._charNodesValue == null) {
            return true;
        }
        return xobj != null && !xobj.isAttr() && this._srcValue == null && this._charNodesValue == null;
    }

    final boolean isInSameTree(Xobj xobj) {
        if (this._locale != xobj._locale) {
            return false;
        }
        Xobj xobj2 = this;
        while (xobj2 != xobj) {
            Xobj xobj3 = xobj2._parent;
            if (xobj3 == null) {
                while (xobj != this) {
                    Xobj xobj4 = xobj._parent;
                    if (xobj4 == null) {
                        return xobj == xobj2;
                    }
                    xobj = xobj4;
                }
                return true;
            }
            xobj2 = xobj3;
        }
        return true;
    }

    final boolean isJustAfterEnd(Xobj xobj, int i2) {
        if (xobj.isRoot() && i2 == 0) {
            return false;
        }
        if (xobj == this) {
            if (i2 != posAfter()) {
                return false;
            }
        } else if (xobj.getDenormal(i2) != this || xobj.posTemp() != posAfter()) {
            return false;
        }
        return true;
    }

    protected final boolean isNextSiblingPtrDomUsable() {
        return this._charNodesAfter == null && this._srcAfter == null;
    }

    final boolean isNormal(int i2) {
        Xobj xobj;
        if (!isValid()) {
            return false;
        }
        if (i2 == -1 || i2 == 0) {
            return true;
        }
        if (i2 < 0 || i2 >= posMax()) {
            return false;
        }
        if (i2 >= posAfter()) {
            if (isRoot()) {
                return false;
            }
            Xobj xobj2 = this._nextSibling;
            if ((xobj2 != null && xobj2.isAttr()) || (xobj = this._parent) == null || !xobj.isContainer()) {
                return false;
            }
        }
        return i2 != posAfter() - 1;
    }

    final boolean isNormalAttr() {
        return isAttr() && !Locale.isXmlns(this._name);
    }

    final boolean isOccupied() {
        return bitIsClear(256);
    }

    final boolean isProcinst() {
        return kind() == 5;
    }

    final boolean isRoot() {
        return kind() == 1;
    }

    final boolean isStableUser() {
        return bitIsSet(512);
    }

    final boolean isUserNode() {
        int iKind = kind();
        if (iKind == 2 || iKind == 1) {
            return true;
        }
        return iKind == 3 && !isXmlns();
    }

    final boolean isVacant() {
        return bitIsSet(256);
    }

    final boolean isValid() {
        return !isVacant() || (this._cchValue == 0 && this._user != null);
    }

    final boolean isXmlns() {
        return isAttr() && Locale.isXmlns(this._name);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean is_attribute() {
        return isAttr();
    }

    final int kind() {
        return this._bits & 15;
    }

    final Xobj lastAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        Xobj xobj2 = this._firstChild;
        while (true) {
            Xobj xobj3 = xobj2._nextSibling;
            if (xobj3 == null || !xobj3.isAttr()) {
                break;
            }
            xobj2 = xobj2._nextSibling;
        }
        return xobj2;
    }

    public final Locale locale() {
        return this._locale;
    }

    final String namespaceForPrefix(String str, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals("xml")) {
            return XMLConstants.XML_NS_URI;
        }
        if (str.equals("xmlns")) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobj2 = xobj._firstChild; xobj2 != null && xobj2.isAttr(); xobj2 = xobj2._nextSibling) {
                if (xobj2.isXmlns() && xobj2.getXmlnsPrefix().equals(str)) {
                    return xobj2.getXmlnsUri();
                }
            }
        }
        if (z && str.isEmpty()) {
            return "";
        }
        return null;
    }

    abstract Xobj newNode(Locale locale);

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlCursor new_cursor() {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            Cursor cursor = new Cursor(curTempCur);
            curTempCur.release();
            return cursor;
        } finally {
            this._locale.exit();
        }
    }

    final Xobj nextAttr() {
        Xobj xobj = this._firstChild;
        if (xobj != null && xobj.isAttr()) {
            return this._firstChild;
        }
        Xobj xobj2 = this._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return null;
        }
        return this._nextSibling;
    }

    public final int nodeType() {
        return domType();
    }

    final int posAfter() {
        return this._cchValue + 2;
    }

    final int posMax() {
        return this._cchValue + 2 + this._cchAfter;
    }

    final int posTemp() {
        return this._locale._posTemp;
    }

    final String prefixForNamespace(String str, String str2, boolean z) {
        if (str == null) {
            str = "";
        }
        if (str.equals(XMLConstants.XML_NS_URI)) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return "xmlns";
        }
        Xobj xobjEnsureParent = this;
        while (!xobjEnsureParent.isContainer()) {
            xobjEnsureParent = xobjEnsureParent.ensureParent();
        }
        if (str.isEmpty()) {
            Xobj xobjFindXmlnsForPrefix = xobjEnsureParent.findXmlnsForPrefix("");
            if (xobjFindXmlnsForPrefix != null && !xobjFindXmlnsForPrefix.getXmlnsUri().isEmpty()) {
                if (!z) {
                    return null;
                }
                xobjEnsureParent.setAttr(this._locale.createXmlns(null), "");
            }
            return "";
        }
        for (Xobj xobj = xobjEnsureParent; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsUri().equals(str) && xobjEnsureParent.findXmlnsForPrefix(xobjFirstAttr.getXmlnsPrefix()) == xobjFirstAttr) {
                    return xobjFirstAttr.getXmlnsPrefix();
                }
            }
        }
        if (!z) {
            return null;
        }
        if (str2 != null && (str2.isEmpty() || str2.toLowerCase(java.util.Locale.ROOT).startsWith("xml") || xobjEnsureParent.findXmlnsForPrefix(str2) != null)) {
            str2 = null;
        }
        if (str2 == null) {
            String strSuggestPrefix = QNameHelper.suggestPrefix(str);
            int i2 = 1;
            str2 = strSuggestPrefix;
            while (xobjEnsureParent.findXmlnsForPrefix(str2) != null) {
                str2 = strSuggestPrefix + i2;
                i2++;
            }
        }
        for (Xobj xobj2 = xobjEnsureParent; !xobj2.isRoot() && !xobj2.ensureParent().isRoot(); xobj2 = xobj2._parent) {
        }
        xobjEnsureParent.setAttr(this._locale.createXmlns(str2), str);
        return str2;
    }

    final boolean removeAttr(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return false;
        }
        Cur curTempCur = attr.tempCur();
        while (true) {
            curTempCur.moveNode(null);
            Xobj attr2 = getAttr(qName);
            if (attr2 == null) {
                curTempCur.release();
                return true;
            }
            curTempCur.moveTo(attr2);
        }
    }

    final void removeCharsHelper(int i2, int i3, Xobj xobj, int i4, boolean z, boolean z2) {
        Xobj xobj2;
        int i5;
        int i6;
        Cur embedded = getEmbedded();
        while (embedded != null) {
            Cur cur = embedded._next;
            int i7 = embedded._pos;
            if (i7 >= i2 && i7 < i2 + i3) {
                if (z) {
                    embedded.moveToNoCheck(xobj, (i7 + i4) - i2);
                } else {
                    embedded.nextChars((i3 - i7) + i2);
                }
            }
            if (embedded._xobj == this && (i6 = embedded._pos) >= i2 + i3) {
                embedded._pos = i6 - i3;
            }
            embedded = cur;
        }
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            int i8 = bookmark._pos;
            if (i8 >= i2 && i8 < i2 + i3) {
                bookmark.moveTo(xobj, (i8 + i4) - i2);
            }
            if (bookmark._xobj == this && (i5 = bookmark._pos) >= i2 + i3) {
                bookmark._pos = i5 - i3;
            }
        }
        int iPosAfter = posAfter();
        CharUtil charUtil = this._locale.getCharUtil();
        if (i2 < iPosAfter) {
            this._srcValue = charUtil.removeChars(i2 - 1, i3, this._srcValue, this._offValue, this._cchValue);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z2) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.removeChars(i2 - iPosAfter, i3, this._srcAfter, this._offAfter, this._cchAfter);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z2 || (xobj2 = this._parent) == null) {
            return;
        }
        xobj2.invalidateUser();
    }

    final void removeXobj() {
        Xobj xobj = this._parent;
        if (xobj != null) {
            if (xobj._firstChild == this) {
                xobj._firstChild = this._nextSibling;
            }
            if (xobj._lastChild == this) {
                xobj._lastChild = this._prevSibling;
            }
            Xobj xobj2 = this._prevSibling;
            if (xobj2 != null) {
                xobj2._nextSibling = this._nextSibling;
            }
            Xobj xobj3 = this._nextSibling;
            if (xobj3 != null) {
                xobj3._prevSibling = xobj2;
            }
            this._parent = null;
            this._prevSibling = null;
            this._nextSibling = null;
        }
    }

    final void removeXobjs(Xobj xobj, Xobj xobj2) {
        if (this._firstChild == xobj) {
            this._firstChild = xobj2._nextSibling;
        }
        if (this._lastChild == xobj2) {
            this._lastChild = xobj._prevSibling;
        }
        Xobj xobj3 = xobj._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj2._nextSibling;
        }
        Xobj xobj4 = xobj2._nextSibling;
        if (xobj4 != null) {
            xobj4._prevSibling = xobj3;
        }
        xobj._prevSibling = null;
        xobj2._nextSibling = null;
        while (xobj != null) {
            xobj._parent = null;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_attribute(QName qName) {
        this._locale.enter();
        try {
            if (removeAttr(qName)) {
            } else {
                throw new IndexOutOfBoundsException();
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QName qName, int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !xobj._name.equals(qName) || i2 - 1 >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    final Xobj setAttr(QName qName, String str) {
        Cur curTempCur = tempCur();
        if (curTempCur.toAttr(qName)) {
            curTempCur.removeFollowingAttrs();
        } else {
            curTempCur.next();
            curTempCur.createAttr(qName);
        }
        curTempCur.setValue(str);
        Xobj xobj = curTempCur._xobj;
        curTempCur.release();
        return xobj;
    }

    final void setBit(int i2) {
        this._bits = i2 | this._bits;
    }

    final Bookmark setBookmark(int i2, Object obj, Object obj2) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (i2 == bookmark._pos && obj == bookmark._key) {
                if (obj2 == null) {
                    this._bookmarks = bookmark.listRemove(this._bookmarks);
                    return null;
                }
                bookmark._value = obj2;
                return bookmark;
            }
        }
        if (obj2 == null) {
            return null;
        }
        Bookmark bookmark2 = new Bookmark();
        bookmark2._xobj = this;
        bookmark2._pos = i2;
        bookmark2._key = obj;
        bookmark2._value = obj2;
        this._bookmarks = bookmark2.listInsert(this._bookmarks);
        return bookmark2;
    }

    final void setName(QName qName) {
        Xobj xobj;
        if (this._name.equals(qName) && this._name.getPrefix().equals(qName.getPrefix())) {
            return;
        }
        this._locale.notifyChange();
        QName qName2 = this._name;
        this._name = qName;
        if (this instanceof NamedNodeXobj) {
            ((NamedNodeXobj) this)._canHavePrefixUri = true;
        }
        if (!isProcinst()) {
            if (!isAttr() || this._parent == null) {
                xobj = this;
            } else {
                QName qName3 = Locale._xsiType;
                xobj = (qName2.equals(qName3) || qName.equals(qName3)) ? this._parent : this;
                QName qName4 = Locale._xsiNil;
                if (qName2.equals(qName4) || qName.equals(qName4)) {
                    this._parent.invalidateNil();
                }
            }
            xobj.disconnectNonRootUsers();
        }
        Locale locale = this._locale;
        locale._versionAll++;
        locale._versionSansText++;
    }

    void setStableType(SchemaType schemaType) {
        setStableUser(((TypeStoreUserFactory) schemaType).createTypeStoreUser());
    }

    void setStableUser(TypeStoreUser typeStoreUser) {
        disconnectNonRootUsers();
        disconnectUser();
        this._user = typeStoreUser;
        typeStoreUser.attach_store(this);
        setBit(512);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void store_text(String str) {
        this._locale.enter();
        TypeStoreUser typeStoreUser = this._user;
        this._user = null;
        try {
            Cur curTempCur = tempCur();
            curTempCur.moveNodeContents(null, false);
            if (str != null && !str.isEmpty()) {
                curTempCur.next();
                curTempCur.insertString(str);
            }
            curTempCur.release();
        } finally {
            this._user = typeStoreUser;
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser substitute(QName qName, SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setSubstitution(qName, schemaType);
            curTempCur.release();
            this._locale.exit();
            return getUser();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    public final Cur tempCur() {
        Cur curTempCur = this._locale.tempCur();
        curTempCur.moveTo(this);
        return curTempCur;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void validate(ValidatorListener validatorListener) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            new Validate(curTempCur, validatorListener);
            curTempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean validate_on_set() {
        return this._locale._validateOnSet;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void visit_elements(TypeStoreVisitor typeStoreVisitor) {
        throw new RuntimeException("Not implemeneted");
    }

    final Xobj walk(Xobj xobj, boolean z) {
        Xobj xobj2 = this._firstChild;
        if (xobj2 != null && z) {
            return xobj2;
        }
        for (Xobj xobj3 = this; xobj3 != xobj; xobj3 = xobj3._parent) {
            Xobj xobj4 = xobj3._nextSibling;
            if (xobj4 != null) {
                return xobj4;
            }
        }
        return null;
    }

    final boolean contains(Xobj xobj, int i2) {
        if (this == xobj) {
            if (i2 != -1) {
                return i2 > 0 && i2 < posAfter();
            }
            return true;
        }
        if (this._firstChild == null) {
            return false;
        }
        while (xobj != null) {
            if (xobj == this) {
                return true;
            }
            xobj = xobj._parent;
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QNameSet qNameSet) {
        return this._locale.count(this, null, qNameSet);
    }

    public void dump(PrintStream printStream) {
        Cur.dump(printStream, this, this);
    }

    public void dump() {
        dump(System.out);
    }

    Object getChars(int i2, int i3) {
        int iCchRight = cchRight(i2);
        if (i3 < 0 || i3 > iCchRight) {
            i3 = iCchRight;
        }
        if (i3 == 0) {
            Locale locale = this._locale;
            locale._offSrc = 0;
            locale._cchSrc = 0;
            return null;
        }
        return getCharsHelper(i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QNameSet qNameSet, List<T> list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name)) {
                list.add((XmlObject) xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QNameSet qNameSet, int i2) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name) && i2 - 1 < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QNameSet qNameSet, int i2) {
        if (i2 >= 0) {
            if (isContainer()) {
                Xobj xobj = this._firstChild;
                while (xobj != null && (!xobj.isElem() || !qNameSet.contains(xobj._name) || i2 - 1 >= 0)) {
                    xobj = xobj._nextSibling;
                }
                removeElement(xobj);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QNameSet qNameSet, QName qName, int i2) {
        if (i2 >= 0) {
            if (isContainer()) {
                Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, null, qNameSet, i2);
                if (xobjFindNthChildElem == null) {
                    if (i2 <= this._locale.count(this, null, qNameSet) + 1) {
                        return add_element_user(qName);
                    }
                    throw new IndexOutOfBoundsException();
                }
                return insertElement(qName, xobjFindNthChildElem, 0);
            }
            throw new IllegalStateException();
        }
        throw new IndexOutOfBoundsException();
    }

    String getValueAsString() {
        return getValueAsString(1);
    }
}
