package org.apache.xmlbeans.impl.store;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.xml.transform.Source;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.MimeHeader;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.values.NamespaceManager;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* loaded from: classes.dex */
public final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ATTR = 2;
    static final int CDATA = 4;
    static final int COMMENT = 8;
    static final int DOCFRAG = 11;
    static final int DOCTYPE = 10;
    static final int DOCUMENT = 9;
    static final int ELEMENT = 1;
    static final int ENTITY = 6;
    static final int ENTITYREF = 5;
    static final int NOTATION = 12;
    static final int PROCINST = 7;
    static final int TEXT = 3;
    public static final NodeList _emptyNodeList = new EmptyNodeList();

    public interface Dom {
        void dump();

        void dump(PrintStream printStream);

        void dump(PrintStream printStream, Object obj);

        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    public static class DomLevel3NotImplemented extends RuntimeException {
        DomLevel3NotImplemented() {
            super("DOM Level 3 Not implemented");
        }
    }

    private static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _local;
        private final String _uri;

        ElementsByTagNameNSNodeList(Dom dom, String str, String str2) {
            super(dom);
            this._uri = str == null ? "" : str;
            this._local = str2;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            if (this._uri.equals("*") || this._uri.equals(DomImpl._node_getNamespaceURI(dom))) {
                return this._local.equals("*") || this._local.equals(DomImpl._node_getLocalName(dom));
            }
            return false;
        }
    }

    private static class ElementsByTagNameNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _name;

        ElementsByTagNameNodeList(Dom dom, String str) {
            super(dom);
            this._name = str;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        protected boolean match(Dom dom) {
            return this._name.equals("*") || this._name.equals(DomImpl._node_getNodeName(dom));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<Dom> _elements;
        private final Locale _locale;
        private final Dom _root;
        private long _version = 0;

        ElementsNodeList(Dom dom) {
            this._root = dom;
            this._locale = dom.locale();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ Object b() {
            addElements(this._root);
            return null;
        }

        private void addElements(Dom dom) {
            Node nodeFirstChild = DomImpl.firstChild(dom);
            while (nodeFirstChild != null) {
                Dom dom2 = (Dom) nodeFirstChild;
                if (dom2.nodeType() == 1) {
                    if (match(dom2)) {
                        this._elements.add(dom2);
                    }
                    addElements(dom2);
                }
                nodeFirstChild = DomImpl.nextSibling(dom2);
            }
        }

        private void ensureElements() {
            if (this._version == this._locale.version()) {
                return;
            }
            this._version = this._locale.version();
            this._elements = new ArrayList<>();
            DomImpl.syncWrapHelper(this._locale, true, new Supplier() { // from class: org.apache.xmlbeans.impl.store.o3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.a.b();
                }
            });
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i2) {
            ensureElements();
            if (i2 < 0 || i2 >= this._elements.size()) {
                return null;
            }
            return (Node) this._elements.get(i2);
        }

        protected abstract boolean match(Dom dom);
    }

    private static final class EmptyNodeList implements NodeList {
        private EmptyNodeList() {
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int i2) {
            return null;
        }
    }

    static class HierarchyRequestErr extends DOMException {
        HierarchyRequestErr(String str) {
            super((short) 3, str);
        }
    }

    static class IndexSizeError extends DOMException {
        IndexSizeError() {
            this("Index Size Error");
        }

        IndexSizeError(String str) {
            super((short) 1, str);
        }
    }

    static class InuseAttributeError extends DOMException {
        InuseAttributeError() {
            this("Attribute currently in use error");
        }

        InuseAttributeError(String str) {
            super((short) 10, str);
        }
    }

    static class InvalidCharacterError extends DOMException {
        InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        InvalidCharacterError(String str) {
            super((short) 5, str);
        }
    }

    static class NamespaceErr extends DOMException {
        NamespaceErr(String str) {
            super((short) 14, str);
        }
    }

    static class NoModificationAllowedErr extends DOMException {
        NoModificationAllowedErr(String str) {
            super((short) 7, str);
        }
    }

    static class NotFoundErr extends DOMException {
        NotFoundErr(String str) {
            super((short) 8, str);
        }
    }

    static class NotSupportedError extends DOMException {
        NotSupportedError(String str) {
            super((short) 9, str);
        }
    }

    private static class SaajData {
        Object _obj;

        private SaajData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface WrapSoapEx<T> {
        T get() throws SOAPException;
    }

    static class WrongDocumentErr extends DOMException {
        WrongDocumentErr(String str) {
            super((short) 4, str);
        }
    }

    static /* synthetic */ Object P0(Dom dom, SOAPFault sOAPFault, Name name) throws SOAPException {
        dom.locale()._saaj.soapFault_setFaultCode(sOAPFault, name);
        return null;
    }

    static /* synthetic */ Object Q0(Dom dom, SOAPFault sOAPFault, String str) throws SOAPException {
        dom.locale()._saaj.soapFault_setFaultCode(sOAPFault, str);
        return null;
    }

    public static Element _attr_getOwnerElement(Dom dom) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.t8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attr_getOwnerElement((DomImpl.Dom) obj);
            }
        });
    }

    public static boolean _attr_getSpecified(Dom dom) {
        return true;
    }

    public static int _attributes_getLength(Dom dom) {
        return ((Integer) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(DomImpl.attributes_getLength((DomImpl.Dom) obj));
            }
        })).intValue();
    }

    public static Node _attributes_getNamedItem(final Dom dom, final String str) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.m5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attributes_getNamedItem(dom, str);
            }
        });
    }

    public static Node _attributes_getNamedItemNS(Dom dom, final String str, final String str2) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.s5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attributes_getNamedItemNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static Node _attributes_item(Dom dom, final int i2) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.t3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attributes_item((DomImpl.Dom) obj, i2);
            }
        });
    }

    public static Node _attributes_removeNamedItem(Dom dom, final String str) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.n5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attributes_removeNamedItem((DomImpl.Dom) obj, str);
            }
        });
    }

    public static Node _attributes_removeNamedItemNS(Dom dom, final String str, final String str2) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.u4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.attributes_removeNamedItemNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static Node _attributes_setNamedItem(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            final Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.z5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DomImpl.attributes_setNamedItem((DomImpl.Dom) obj, dom2);
                    }
                });
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static Node _attributes_setNamedItemNS(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Attr to set is null");
        }
        if (node instanceof Dom) {
            final Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.p4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DomImpl.attributes_setNamedItemNS((DomImpl.Dom) obj, dom2);
                    }
                });
            }
        }
        throw new WrongDocumentErr("Attr to set is from another document");
    }

    public static void _characterData_appendData(Dom dom, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        _node_setNodeValue(dom, _node_getNodeValue(dom) + str);
    }

    public static void _characterData_deleteData(Dom dom, int i2, int i3) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i2 < 0 || i2 > str_characterData_getData.length() || i3 < 0) {
            throw new IndexSizeError();
        }
        if (i2 + i3 > str_characterData_getData.length()) {
            i3 = str_characterData_getData.length() - i2;
        }
        if (i3 > 0) {
            _characterData_setData(dom, str_characterData_getData.substring(0, i2) + str_characterData_getData.substring(i2 + i3));
        }
    }

    public static String _characterData_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static int _characterData_getLength(Dom dom) {
        return _characterData_getData(dom).length();
    }

    public static void _characterData_insertData(Dom dom, int i2, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i2 < 0 || i2 > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        _characterData_setData(dom, str_characterData_getData.substring(0, i2) + str + str_characterData_getData.substring(i2));
    }

    public static void _characterData_replaceData(Dom dom, int i2, int i3, String str) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i2 < 0 || i2 > str_characterData_getData.length() || i3 < 0) {
            throw new IndexSizeError();
        }
        if (i2 + i3 > str_characterData_getData.length()) {
            i3 = str_characterData_getData.length() - i2;
        }
        if (i3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str_characterData_getData.substring(0, i2));
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(str_characterData_getData.substring(i2 + i3));
            _characterData_setData(dom, sb.toString());
        }
    }

    public static void _characterData_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static String _characterData_substringData(Dom dom, int i2, int i3) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i2 < 0 || i2 > str_characterData_getData.length() || i3 < 0) {
            throw new IndexSizeError();
        }
        if (i2 + i3 > str_characterData_getData.length()) {
            i3 = str_characterData_getData.length() - i2;
        }
        return str_characterData_getData.substring(i2, i3 + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int _childNodes_getLength(Dom dom) {
        int domZeroOneChildren;
        Xobj xobj = (Xobj) dom;
        return (xobj.isVacant() || (domZeroOneChildren = xobj.getDomZeroOneChildren()) >= 2) ? ((Integer) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.g7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(DomImpl.childNodes_getLength((DomImpl.Dom) obj));
            }
        })).intValue() : domZeroOneChildren;
    }

    public static Node _childNodes_item(Dom dom, final int i2) {
        return i2 == 0 ? _node_getFirstChild(dom) : (Node) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.u3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.childNodes_item((DomImpl.Dom) obj, i2);
            }
        });
    }

    public static Attr _document_createAttribute(Dom dom, final String str) {
        return (Attr) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.y2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createAttribute((DomImpl.Dom) obj, str);
            }
        });
    }

    public static Attr _document_createAttributeNS(Dom dom, final String str, final String str2) {
        return (Attr) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.f4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createAttributeNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static CDATASection _document_createCDATASection(Dom dom, String str) {
        return document_createCDATASection(dom, str);
    }

    public static Comment _document_createComment(Dom dom, final String str) {
        return (Comment) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.c6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createComment((DomImpl.Dom) obj, str);
            }
        });
    }

    public static DocumentFragment _document_createDocumentFragment(Dom dom) {
        return (DocumentFragment) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.y8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createDocumentFragment((DomImpl.Dom) obj);
            }
        });
    }

    public static Element _document_createElement(Dom dom, final String str) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.p5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createElement((DomImpl.Dom) obj, str);
            }
        });
    }

    public static Element _document_createElementNS(Dom dom, final String str, final String str2) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.m4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createElementNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static EntityReference _document_createEntityReference(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom dom, final String str, final String str2) {
        return (ProcessingInstruction) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.f5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_createProcessingInstruction((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static Text _document_createTextNode(Dom dom, String str) {
        return document_createTextNode(dom, str);
    }

    public static DocumentType _document_getDoctype(Dom dom) {
        return (DocumentType) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.u8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_getDoctype((DomImpl.Dom) obj);
            }
        });
    }

    public static Element _document_getDocumentElement(Dom dom) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.t7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_getDocumentElement((DomImpl.Dom) obj);
            }
        });
    }

    public static Element _document_getElementById(Dom dom, String str) {
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom dom, final String str) {
        return (NodeList) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.k3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_getElementsByTagName((DomImpl.Dom) obj, str);
            }
        });
    }

    public static NodeList _document_getElementsByTagNameNS(Dom dom, final String str, final String str2) {
        return (NodeList) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.q6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_getElementsByTagNameNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static DOMImplementation _document_getImplementation(Dom dom) {
        return dom.locale();
    }

    public static Node _document_importNode(Dom dom, final Node node, final boolean z) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.d5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.document_importNode((DomImpl.Dom) obj, node, z);
            }
        });
    }

    public static Document _domImplementation_createDocument(final Locale locale, final String str, final String str2, final DocumentType documentType) {
        return (Document) syncWrapHelper(locale, true, new Supplier() { // from class: org.apache.xmlbeans.impl.store.b3
            @Override // java.util.function.Supplier
            public final Object get() {
                return DomImpl.domImplementation_createDocument(locale, str, str2, documentType);
            }
        });
    }

    public static boolean _domImplementation_hasFeature(Locale locale, String str, String str2) {
        if (str == null) {
            return false;
        }
        if (str2 != null && str2.length() > 0 && !str2.equals("1.0") && !str2.equals("2.0")) {
            return false;
        }
        if (str.equalsIgnoreCase("core")) {
            return true;
        }
        return str.equalsIgnoreCase("xml");
    }

    public static String _element_getAttribute(Dom dom, String str) {
        Node node_attributes_getNamedItem = _attributes_getNamedItem(dom, str);
        return node_attributes_getNamedItem == null ? "" : node_attributes_getNamedItem.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom dom, String str, String str2) {
        Node node_attributes_getNamedItemNS = _attributes_getNamedItemNS(dom, str, str2);
        return node_attributes_getNamedItemNS == null ? "" : node_attributes_getNamedItemNS.getNodeValue();
    }

    public static Attr _element_getAttributeNode(Dom dom, String str) {
        return (Attr) _attributes_getNamedItem(dom, str);
    }

    public static Attr _element_getAttributeNodeNS(Dom dom, String str, String str2) {
        return (Attr) _attributes_getNamedItemNS(dom, str, str2);
    }

    public static NodeList _element_getElementsByTagName(Dom dom, final String str) {
        return (NodeList) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.d6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.element_getElementsByTagName((DomImpl.Dom) obj, str);
            }
        });
    }

    public static NodeList _element_getElementsByTagNameNS(Dom dom, final String str, final String str2) {
        return (NodeList) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.e3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.element_getElementsByTagNameNS((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static String _element_getTagName(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static boolean _element_hasAttribute(Dom dom, String str) {
        return _attributes_getNamedItem(dom, str) != null;
    }

    public static boolean _element_hasAttributeNS(Dom dom, String str, String str2) {
        return _attributes_getNamedItemNS(dom, str, str2) != null;
    }

    public static void _element_removeAttribute(Dom dom, String str) {
        try {
            _attributes_removeNamedItem(dom, str);
        } catch (NotFoundErr unused) {
        }
    }

    public static void _element_removeAttributeNS(Dom dom, String str, String str2) {
        try {
            _attributes_removeNamedItemNS(dom, str, str2);
        } catch (NotFoundErr unused) {
        }
    }

    public static Attr _element_removeAttributeNode(Dom dom, Attr attr) {
        if (attr == null) {
            throw new NotFoundErr("Attribute to remove is null");
        }
        if (attr.getOwnerElement() == dom) {
            return (Attr) _attributes_removeNamedItem(dom, attr.getNodeName());
        }
        throw new NotFoundErr("Attribute to remove does not belong to this element");
    }

    public static void _element_setAttribute(Dom dom, final String str, final String str2) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.g3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws DOMException {
                DomImpl.element_setAttribute((DomImpl.Dom) obj, str, str2);
            }
        });
    }

    public static void _element_setAttributeNS(Dom dom, final String str, final String str2, final String str3) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.s4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws DOMException {
                DomImpl.element_setAttributeNS((DomImpl.Dom) obj, str, str2, str3);
            }
        });
    }

    public static Attr _element_setAttributeNode(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItem(dom, attr);
    }

    public static Attr _element_setAttributeNodeNS(Dom dom, Attr attr) {
        return (Attr) _attributes_setNamedItemNS(dom, attr);
    }

    public static XmlCursor _getXmlCursor(Dom dom) {
        return (XmlCursor) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.o9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.getXmlCursor((DomImpl.Dom) obj);
            }
        });
    }

    public static XmlObject _getXmlObject(Dom dom) {
        return (XmlObject) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.n8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.getXmlObject((DomImpl.Dom) obj);
            }
        });
    }

    public static XMLStreamReader _getXmlStreamReader(Dom dom) {
        return (XMLStreamReader) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.getXmlStreamReader((DomImpl.Dom) obj);
            }
        });
    }

    public static Node _node_appendChild(Dom dom, Node node) {
        return _node_insertBefore(dom, node, null);
    }

    public static Node _node_cloneNode(Dom dom, final boolean z) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.z4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_cloneNode((DomImpl.Dom) obj, z);
            }
        });
    }

    public static short _node_compareDocumentPosition(Dom dom, Node node) {
        Node next;
        Node next2;
        boolean zEquals;
        if (!(dom instanceof Node)) {
            return (short) 32;
        }
        Iterator<Node> it = ancestorAndSelf((Node) dom).iterator();
        Iterator<Node> it2 = ancestorAndSelf(node).iterator();
        boolean z = true;
        do {
            next = it.next();
            next2 = it2.next();
            zEquals = Objects.equals(next, next2);
            if (z && !zEquals) {
                return (short) 1;
            }
            z = false;
            if (!zEquals || !it.hasNext()) {
                break;
            }
        } while (it2.hasNext());
        if (zEquals) {
            if (it.hasNext()) {
                return (short) 10;
            }
            return it2.hasNext() ? (short) 20 : (short) 32;
        }
        do {
            next = next.getPreviousSibling();
            if (next == null) {
                return (short) 4;
            }
        } while (!Objects.equals(next, next2));
        return (short) 2;
    }

    public static String _node_getBaseURI(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getFeature(Dom dom, String str, String str2) {
        throw new DomLevel3NotImplemented();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node _node_getFirstChild(Dom dom) {
        Xobj xobj = (Xobj) dom;
        if (!xobj.isVacant()) {
            if (xobj.isFirstChildPtrDomUsable()) {
                return (Node) xobj._firstChild;
            }
            Xobj xobjLastAttr = xobj.lastAttr();
            if (xobjLastAttr != null && xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobj.isExistingCharNodesValueUsable()) {
                return xobj._charNodesValue;
            }
        }
        return (Node) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.w8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getFirstChild((DomImpl.Dom) obj);
            }
        });
    }

    public static Node _node_getLastChild(Dom dom) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.l9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getLastChild((DomImpl.Dom) obj);
            }
        });
    }

    public static String _node_getLocalName(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getNamespaceURI();
    }

    public static Node _node_getNextSibling(Dom dom) {
        return (Node) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.b8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getNextSibling((DomImpl.Dom) obj);
            }
        });
    }

    public static String _node_getNodeName(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 2:
                QName qName = dom.getQName();
                String prefix = qName.getPrefix();
                if (prefix.isEmpty()) {
                    return qName.getLocalPart();
                }
                return prefix + ParameterizedMessage.ERROR_MSG_SEPARATOR + qName.getLocalPart();
            case 3:
                return "#text";
            case 4:
                return "#cdata-section";
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                return dom.getQName().getLocalPart();
            case 8:
                return "#comment";
            case 9:
                return "#document";
            case 11:
                return "#document-fragment";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    public static short _node_getNodeType(Dom dom) {
        return (short) dom.nodeType();
    }

    public static String _node_getNodeValue(Dom dom) {
        return (String) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.h7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getNodeValue((DomImpl.Dom) obj);
            }
        });
    }

    public static Document _node_getOwnerDocument(Dom dom) {
        return (Document) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.w6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getOwnerDocument((DomImpl.Dom) obj);
            }
        });
    }

    public static Node _node_getParentNode(Dom dom) {
        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getParentNode((DomImpl.Dom) obj);
            }
        });
    }

    public static String _node_getPrefix(Dom dom) {
        if (!dom.nodeCanHavePrefixUri()) {
            return null;
        }
        QName qName = dom.getQName();
        return qName == null ? "" : qName.getPrefix();
    }

    public static Node _node_getPreviousSibling(Dom dom) {
        return (Node) syncWrapNoEnter(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.k7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.node_getPreviousSibling((DomImpl.Dom) obj);
            }
        });
    }

    public static String _node_getTextContent(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getUserData(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_hasAttributes(Dom dom) {
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.a8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(DomImpl.node_hasAttributes((DomImpl.Dom) obj));
            }
        })).booleanValue();
    }

    public static boolean _node_hasChildNodes(Dom dom) {
        return (dom instanceof Xobj) && _node_getFirstChild(dom) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r1.locale() == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Node _node_insertBefore(Dom dom, Node node, Node node2) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node instanceof Dom) {
            final Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                final Dom dom3 = null;
                if (node2 != null) {
                    if (node2 instanceof Dom) {
                        dom3 = (Dom) node2;
                    }
                    throw new WrongDocumentErr("Reference child is from another document");
                }
                return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.b4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DomImpl.node_insertBefore((DomImpl.Dom) obj, dom2, dom3);
                    }
                });
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static boolean _node_isDefaultNamespace(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isEqualNode(Dom dom, Node node) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSameNode(Dom dom, Node node) {
        if (dom instanceof CharNode) {
            return dom.equals(node);
        }
        if (dom instanceof NodeXobj) {
            return ((NodeXobj) dom).getDom().equals(node);
        }
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSupported(Dom dom, String str, String str2) {
        return _domImplementation_hasFeature(dom.locale(), str, str2);
    }

    public static String _node_lookupNamespaceURI(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static String _node_lookupPrefix(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static void _node_normalize(Dom dom) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.v8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DomImpl.node_normalize((DomImpl.Dom) obj);
            }
        });
    }

    public static Node _node_removeChild(Dom dom, Node node) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new NotFoundErr("Child to remove is null");
        }
        if (node instanceof Dom) {
            final Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.l4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return DomImpl.node_removeChild((DomImpl.Dom) obj, dom2);
                    }
                });
            }
        }
        throw new WrongDocumentErr("Child to remove is from another document");
    }

    public static Node _node_replaceChild(Dom dom, Node node, Node node2) {
        Locale locale = dom.locale();
        if (node == null) {
            throw new IllegalArgumentException("Child to add is null");
        }
        if (node2 == null) {
            throw new NotFoundErr("Child to replace is null");
        }
        if (node instanceof Dom) {
            final Dom dom2 = (Dom) node;
            if (dom2.locale() == locale) {
                if (node2 instanceof Dom) {
                    final Dom dom3 = (Dom) node2;
                    if (dom3.locale() == locale) {
                        return (Node) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.w3
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return DomImpl.node_replaceChild((DomImpl.Dom) obj, dom2, dom3);
                            }
                        });
                    }
                }
                throw new WrongDocumentErr("Child to replace is from another document");
            }
        }
        throw new WrongDocumentErr("Child to add is from another document");
    }

    public static void _node_setNodeValue(Dom dom, final String str) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.n6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws DOMException {
                DomImpl.node_setNodeValue((DomImpl.Dom) obj, str);
            }
        });
    }

    public static void _node_setPrefix(Dom dom, final String str) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.e6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DomImpl.node_setPrefix((DomImpl.Dom) obj, str);
            }
        });
    }

    public static void _node_setTextContent(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_setUserData(Dom dom, String str, Object obj, UserDataHandler userDataHandler) {
        throw new DomLevel3NotImplemented();
    }

    public static String _processingInstruction_getData(Dom dom) {
        return _node_getNodeValue(dom);
    }

    public static String _processingInstruction_getTarget(Dom dom) {
        return _node_getNodeName(dom);
    }

    public static void _processingInstruction_setData(Dom dom, String str) {
        _node_setNodeValue(dom, str);
    }

    public static SOAPElement _soapElement_addAttribute(final Dom dom, final Name name, final String str) throws SOAPException {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.a4
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addAttribute(sOAPElement, name, str);
            }
        });
    }

    public static SOAPElement _soapElement_addChildElement(final Dom dom, final SOAPElement sOAPElement) throws SOAPException {
        final SOAPElement sOAPElement2 = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.w4
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addChildElement(sOAPElement2, sOAPElement);
            }
        });
    }

    public static SOAPElement _soapElement_addNamespaceDeclaration(Dom dom, final String str, final String str2) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.c4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_addNamespaceDeclaration(sOAPElement, str, str2);
            }
        });
    }

    public static SOAPElement _soapElement_addTextNode(Dom dom, final String str) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.h3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_addTextNode(sOAPElement, str);
            }
        });
    }

    public static Iterator<Name> _soapElement_getAllAttributes(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.p3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getAllAttributes(sOAPElement);
            }
        });
    }

    public static String _soapElement_getAttributeValue(Dom dom, final Name name) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.o4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getAttributeValue(sOAPElement, name);
            }
        });
    }

    public static Iterator<SOAPElement> _soapElement_getChildElements(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.c3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getChildElements(sOAPElement);
            }
        });
    }

    public static Name _soapElement_getElementName(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Name) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.g4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getElementName(sOAPElement);
            }
        });
    }

    public static String _soapElement_getEncodingStyle(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.d4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getEncodingStyle(sOAPElement);
            }
        });
    }

    public static Iterator<String> _soapElement_getNamespacePrefixes(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.v4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getNamespacePrefixes(sOAPElement);
            }
        });
    }

    public static String _soapElement_getNamespaceURI(Dom dom, final String str) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.f3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getNamespaceURI(sOAPElement, str);
            }
        });
    }

    public static Iterator<String> _soapElement_getVisibleNamespacePrefixes(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.j3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement);
            }
        });
    }

    public static boolean _soapElement_removeAttribute(Dom dom, final Name name) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.t6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((DomImpl.Dom) obj).locale()._saaj.soapElement_removeAttribute(sOAPElement, name));
            }
        })).booleanValue();
    }

    public static void _soapElement_removeContents(Dom dom) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.s3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapElement_removeContents(sOAPElement);
            }
        });
    }

    public static boolean _soapElement_removeNamespaceDeclaration(Dom dom, final String str) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.k6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((DomImpl.Dom) obj).locale()._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, str));
            }
        })).booleanValue();
    }

    public static void _soapElement_setEncodingStyle(Dom dom, final String str) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.n2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapElement_setEncodingStyle(sOAPElement, str);
            }
        });
    }

    public static SOAPBody _soapEnvelope_addBody(final Dom dom) throws SOAPException {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (SOAPBody) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.p2
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapEnvelope_addBody(sOAPEnvelope);
            }
        });
    }

    public static SOAPHeader _soapEnvelope_addHeader(final Dom dom) throws SOAPException {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (SOAPHeader) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.q3
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapEnvelope_addHeader(sOAPEnvelope);
            }
        });
    }

    public static Name _soapEnvelope_createName(Dom dom, final String str) {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (Name) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.i5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapEnvelope_createName(sOAPEnvelope, str);
            }
        });
    }

    public static SOAPBody _soapEnvelope_getBody(final Dom dom) throws SOAPException {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (SOAPBody) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.r4
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapEnvelope_getBody(sOAPEnvelope);
            }
        });
    }

    public static SOAPHeader _soapEnvelope_getHeader(final Dom dom) throws SOAPException {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (SOAPHeader) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.q4
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapEnvelope_getHeader(sOAPEnvelope);
            }
        });
    }

    public static void _soapNode_detachNode(Dom dom) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.h6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapNode_detachNode(node);
            }
        });
    }

    public static SOAPElement _soapNode_getParentElement(Dom dom) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        return (SOAPElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.w2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapNode_getParentElement(node);
            }
        });
    }

    public static String _soapNode_getValue(Dom dom) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.u5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapNode_getValue(node);
            }
        });
    }

    public static void _soapNode_recycleNode(Dom dom) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.v5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapNode_recycleNode(node);
            }
        });
    }

    public static void _soapNode_setParentElement(Dom dom, final SOAPElement sOAPElement) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.j4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapNode_setParentElement(node, sOAPElement);
            }
        });
    }

    public static void _soapNode_setValue(Dom dom, final String str) {
        final org.apache.xmlbeans.impl.soap.Node node = (org.apache.xmlbeans.impl.soap.Node) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.x5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapNode_setValue(node, str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_addMimeHeader(Dom dom, final String str, final String str2) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.y5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapPart_addMimeHeader(sOAPPart, str, str2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getAllMimeHeaders(Dom dom) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.z2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getAllMimeHeaders(sOAPPart);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Source _soapPart_getContent(Dom dom) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (Source) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.o2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getContent(sOAPPart);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SOAPEnvelope _soapPart_getEnvelope(Dom dom) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (SOAPEnvelope) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.d3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getEnvelope(sOAPPart);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getMatchingMimeHeaders(Dom dom, final String[] strArr) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.r3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String[] _soapPart_getMimeHeader(Dom dom, final String str) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (String[]) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.l5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getMimeHeader(sOAPPart, str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Iterator<MimeHeader> _soapPart_getNonMatchingMimeHeaders(Dom dom, final String[] strArr) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.k5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeAllMimeHeaders(Dom dom) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.r5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapPart_removeAllMimeHeaders(sOAPPart);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_removeMimeHeader(Dom dom, final String str) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.n3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapPart_removeMimeHeader(sOAPPart, str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setContent(Dom dom, final Source source) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.a6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapPart_setContent(sOAPPart, source);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _soapPart_setMimeHeader(Dom dom, final String str, final String str2) {
        final SOAPPart sOAPPart = (SOAPPart) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.a3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapPart_setMimeHeader(sOAPPart, str, str2);
            }
        });
    }

    public static boolean _soapText_isComment(Dom dom) {
        final org.apache.xmlbeans.impl.soap.Text text = (org.apache.xmlbeans.impl.soap.Text) dom;
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.r2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((DomImpl.Dom) obj).locale()._saaj.soapText_isComment(text));
            }
        })).booleanValue();
    }

    public static String _text_getWholeText(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static boolean _text_isElementContentWhitespace(Dom dom) {
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_replaceWholeText(Dom dom, String str) {
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_splitText(Dom dom, int i2) {
        String str_characterData_getData = _characterData_getData(dom);
        if (i2 < 0 || i2 > str_characterData_getData.length()) {
            throw new IndexSizeError();
        }
        _characterData_deleteData(dom, i2, str_characterData_getData.length() - i2);
        Dom dom2 = (Dom) _document_createTextNode(dom, str_characterData_getData.substring(i2));
        Dom dom3 = (Dom) _node_getParentNode(dom);
        if (dom3 != null) {
            _node_insertBefore(dom3, (Text) dom2, _node_getNextSibling(dom));
            dom.locale().invalidateDomCaches(dom3);
        }
        return (Text) dom2;
    }

    private static List<Node> ancestorAndSelf(Node node) {
        LinkedList linkedList = new LinkedList();
        do {
            linkedList.addFirst(node);
            node = node.getParentNode();
        } while (node != null);
        return linkedList;
    }

    public static Node append(Dom dom, Dom dom2) {
        return node_insertBefore(dom2, dom, null);
    }

    public static Element attr_getOwnerElement(Dom dom) {
        Cur curTempCur = dom.tempCur();
        if (!curTempCur.toParentRaw()) {
            curTempCur.release();
            return null;
        }
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static int attributes_getLength(Dom dom) {
        Cur curTempCur = dom.tempCur();
        int i2 = 0;
        while (curTempCur.toNextAttr()) {
            i2++;
        }
        curTempCur.release();
        return i2;
    }

    public static Node attributes_getNamedItem(Dom dom, String str) {
        Dom dom2;
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                dom2 = null;
                break;
            }
            dom2 = curTempCur.getDom();
            if (_node_getNodeName(dom2).equals(str)) {
                break;
            }
        }
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_getNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Dom dom2 = null;
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                break;
            }
            Dom dom3 = curTempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                dom2 = dom3;
                break;
            }
        }
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_item(Dom dom, int i2) {
        Dom dom2 = null;
        if (i2 < 0) {
            return null;
        }
        Cur curTempCur = dom.tempCur();
        while (true) {
            if (!curTempCur.toNextAttr()) {
                break;
            }
            int i3 = i2 - 1;
            if (i2 == 0) {
                dom2 = curTempCur.getDom();
                break;
            }
            i2 = i3;
        }
        curTempCur.release();
        return (Node) dom2;
    }

    public static Node attributes_removeNamedItem(Dom dom, String str) {
        Cur curTempCur = dom.tempCur();
        Dom dom2 = null;
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            if (_node_getNodeName(dom3).equals(str)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((AttrXobj) dom3).isId()) {
                    Document documentNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                        ((DocumentXobj) documentNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return (Node) dom2;
        }
        throw new NotFoundErr("Named item not found: " + str);
    }

    public static Node attributes_removeNamedItemNS(Dom dom, String str, String str2) {
        if (str == null) {
            str = "";
        }
        Dom dom2 = null;
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            Dom dom3 = curTempCur.getDom();
            QName qName = dom3.getQName();
            if (qName.getNamespaceURI().equals(str) && qName.getLocalPart().equals(str2)) {
                if (dom2 == null) {
                    dom2 = dom3;
                }
                if (((AttrXobj) dom3).isId()) {
                    Document documentNode_getOwnerDocument = node_getOwnerDocument(dom3);
                    String strNode_getNodeValue = node_getNodeValue(dom3);
                    if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                        ((DocumentXobj) documentNode_getOwnerDocument).removeIdElement(strNode_getNodeValue);
                    }
                }
                removeNode(dom3);
                curTempCur.toPrevAttr();
            }
        }
        curTempCur.release();
        if (dom2 != null) {
            return (Node) dom2;
        }
        throw new NotFoundErr("Named item not found: uri=" + str + ", local=" + str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node attributes_setNamedItem(Dom dom, Dom dom2) {
        if (attr_getOwnerElement(dom2) != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        String str_node_getNodeName = _node_getNodeName(dom2);
        Dom dom3 = null;
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (_node_getNodeName(dom4).equals(str_node_getNodeName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return (Node) dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node attributes_setNamedItemNS(Dom dom, Dom dom2) {
        Element elementAttr_getOwnerElement = attr_getOwnerElement(dom2);
        if (elementAttr_getOwnerElement == dom) {
            return (Node) dom2;
        }
        if (elementAttr_getOwnerElement != null) {
            throw new InuseAttributeError();
        }
        if (dom2.nodeType() != 2) {
            throw new HierarchyRequestErr("Node is not an attribute");
        }
        QName qName = dom2.getQName();
        Dom dom3 = null;
        Cur curTempCur = dom.tempCur();
        while (curTempCur.toNextAttr()) {
            Dom dom4 = curTempCur.getDom();
            if (dom4.getQName().equals(qName)) {
                if (dom3 == null) {
                    dom3 = dom4;
                } else {
                    removeNode(dom4);
                    curTempCur.toPrevAttr();
                }
            }
        }
        if (dom3 == null) {
            curTempCur.moveToDom(dom);
            curTempCur.next();
            Cur.moveNode((Xobj) dom2, curTempCur);
        } else {
            curTempCur.moveToDom(dom3);
            Cur.moveNode((Xobj) dom2, curTempCur);
            removeNode(dom3);
        }
        curTempCur.release();
        return (Node) dom3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int childNodes_getLength(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return 0;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                int domZeroOneChildren = xobj.getDomZeroOneChildren();
                return domZeroOneChildren < 2 ? domZeroOneChildren : dom.locale().domLength(dom);
        }
    }

    public static Node childNodes_item(Dom dom, int i2) {
        if (i2 < 0) {
            return null;
        }
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                return i2 == 0 ? node_getFirstChild(dom) : (Node) dom.locale().findDomNthChild(dom, i2);
        }
    }

    public static DetailEntry detail_addDetailEntry(Dom dom, final Name name) {
        final Detail detail = (Detail) dom;
        return (DetailEntry) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.v3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.detail_addDetailEntry(detail, name);
            }
        });
    }

    public static Iterator<DetailEntry> detail_getDetailEntries(Dom dom) {
        final Detail detail = (Detail) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.x4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.detail_getDetailEntries(detail);
            }
        });
    }

    public static Attr document_createAttribute(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName("", str));
        AttrXobj attrXobj = (AttrXobj) curTempCur.getDom();
        curTempCur.release();
        attrXobj._canHavePrefixUri = false;
        return attrXobj;
    }

    public static Attr document_createAttributeNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, true);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createAttr(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Attr) dom2;
    }

    public static CDATASection document_createCDATASection(Dom dom, String str) {
        CdataNode cdataNodeCreateCdataNode = dom.locale().createCdataNode();
        if (str == null) {
            str = "";
        }
        cdataNodeCreateCdataNode.setChars(str, 0, str.length());
        return cdataNodeCreateCdataNode;
    }

    public static Comment document_createComment(Dom dom, String str) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createComment();
        Dom dom2 = curTempCur.getDom();
        if (str != null) {
            curTempCur.next();
            curTempCur.insertString(str);
        }
        curTempCur.release();
        return (Comment) dom2;
    }

    public static DocumentFragment document_createDocumentFragment(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createDomDocFragRoot();
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (DocumentFragment) dom2;
    }

    public static Element document_createElement(Dom dom, String str) {
        validateName(str);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName("", str));
        ElementXobj elementXobj = (ElementXobj) curTempCur.getDom();
        curTempCur.release();
        elementXobj._canHavePrefixUri = false;
        return elementXobj;
    }

    public static Element document_createElementNS(Dom dom, String str, String str2) {
        validateQualifiedName(str2, str, false);
        Locale locale = dom.locale();
        Cur curTempCur = locale.tempCur();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static ProcessingInstruction document_createProcessingInstruction(Dom dom, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Target is null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Target is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Target has an invalid character");
        }
        if (Locale.beginsWithXml(str) && str.length() == 3) {
            throw new InvalidCharacterError("Invalid target - is 'xml'");
        }
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createProcinst(str);
        Dom dom2 = curTempCur.getDom();
        if (str2 != null) {
            curTempCur.next();
            curTempCur.insertString(str2);
        }
        curTempCur.release();
        return (ProcessingInstruction) dom2;
    }

    public static Text document_createTextNode(Dom dom, String str) {
        TextNode textNodeCreateTextNode = dom.locale().createTextNode();
        if (str == null) {
            str = "";
        }
        textNodeCreateTextNode.setChars(str, 0, str.length());
        return textNodeCreateTextNode;
    }

    public static DocumentType document_getDoctype(Dom dom) {
        return null;
    }

    public static Element document_getDocumentElement(Dom dom) {
        Node nodeFirstChild = firstChild(dom);
        while (nodeFirstChild != null) {
            Dom dom2 = (Dom) nodeFirstChild;
            if (dom2.nodeType() == 1) {
                return (Element) nodeFirstChild;
            }
            nodeFirstChild = nextSibling(dom2);
        }
        return null;
    }

    public static NodeList document_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList document_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19, types: [org.w3c.dom.Node] */
    /* JADX WARN: Type inference failed for: r1v20, types: [org.w3c.dom.DocumentFragment] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Node document_importNode(Dom dom, Node node, boolean z) {
        Dom domDocument_createDocumentFragment;
        Attr attrDocument_createAttribute;
        if (node == null) {
            return null;
        }
        switch (node.getNodeType()) {
            case 1:
                String localName = node.getLocalName();
                if (localName == null || localName.isEmpty()) {
                    domDocument_createDocumentFragment = document_createElement(dom, node.getNodeName());
                } else {
                    String prefix = node.getPrefix();
                    if (prefix != null && !prefix.isEmpty()) {
                        localName = prefix + ParameterizedMessage.ERROR_MSG_SEPARATOR + localName;
                    }
                    String namespaceURI = node.getNamespaceURI();
                    domDocument_createDocumentFragment = (namespaceURI == null || namespaceURI.isEmpty()) ? document_createElement(dom, localName) : document_createElementNS(dom, namespaceURI, localName);
                }
                NamedNodeMap attributes = node.getAttributes();
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    attributes_setNamedItem(domDocument_createDocumentFragment, (Dom) document_importNode(dom, attributes.item(i2), true));
                }
                if (z) {
                    NodeList childNodes = node.getChildNodes();
                    for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                        node_insertBefore(domDocument_createDocumentFragment, (Dom) document_importNode(dom, childNodes.item(i3), true), null);
                    }
                }
                return domDocument_createDocumentFragment;
            case 2:
                String localName2 = node.getLocalName();
                if (localName2 == null || localName2.isEmpty()) {
                    attrDocument_createAttribute = document_createAttribute(dom, node.getNodeName());
                } else {
                    String prefix2 = node.getPrefix();
                    if (prefix2 != null && !prefix2.isEmpty()) {
                        localName2 = prefix2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + localName2;
                    }
                    String namespaceURI2 = node.getNamespaceURI();
                    attrDocument_createAttribute = (namespaceURI2 == null || namespaceURI2.isEmpty()) ? document_createAttribute(dom, localName2) : document_createAttributeNS(dom, namespaceURI2, localName2);
                }
                domDocument_createDocumentFragment = attrDocument_createAttribute;
                z = true;
                if (z) {
                }
                return domDocument_createDocumentFragment;
            case 3:
                domDocument_createDocumentFragment = document_createTextNode(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createDocumentFragment;
            case 4:
                domDocument_createDocumentFragment = document_createCDATASection(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createDocumentFragment;
            case 5:
            case 6:
            case 12:
                throw new RuntimeException("Not impl");
            case 7:
                domDocument_createDocumentFragment = document_createProcessingInstruction(dom, node.getNodeName(), node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createDocumentFragment;
            case 8:
                domDocument_createDocumentFragment = document_createComment(dom, node.getNodeValue());
                z = false;
                if (z) {
                }
                return domDocument_createDocumentFragment;
            case 9:
                throw new NotSupportedError("Document nodes may not be imported");
            case 10:
                throw new NotSupportedError("Document type nodes may not be imported");
            case 11:
                domDocument_createDocumentFragment = document_createDocumentFragment(dom);
                if (z) {
                }
                return domDocument_createDocumentFragment;
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Document domImplementation_createDocument(Locale locale, String str, String str2, DocumentType documentType) {
        validateQualifiedName(str2, str, false);
        Cur curTempCur = locale.tempCur();
        curTempCur.createDomDocumentRoot();
        Document document = (Document) curTempCur.getDom();
        curTempCur.next();
        curTempCur.createElement(locale.makeQualifiedQName(str, str2));
        if (documentType != null) {
            throw new RuntimeException("Not impl");
        }
        curTempCur.toParent();
        try {
            Locale.autoTypeDocument(curTempCur, null, null);
            curTempCur.release();
            return document;
        } catch (XmlException e) {
            throw new XmlRuntimeException(e);
        }
    }

    public static NodeList element_getElementsByTagName(Dom dom, String str) {
        return new ElementsByTagNameNodeList(dom, str);
    }

    public static NodeList element_getElementsByTagNameNS(Dom dom, String str, String str2) {
        return new ElementsByTagNameNSNodeList(dom, str, str2);
    }

    public static void element_setAttribute(Dom dom, String str, String str2) throws DOMException {
        Object objAttributes_getNamedItem = attributes_getNamedItem(dom, str);
        if (objAttributes_getNamedItem == null) {
            Dom dom2 = (Dom) node_getOwnerDocument(dom);
            if (dom2 == null) {
                throw new NotFoundErr("Document element can't be determined.");
            }
            objAttributes_getNamedItem = document_createAttribute(dom2, str);
            attributes_setNamedItem(dom, (Dom) objAttributes_getNamedItem);
        }
        node_setNodeValue((Dom) objAttributes_getNamedItem, str2);
    }

    public static void element_setAttributeNS(Dom dom, String str, String str2, String str3) throws DOMException {
        validateQualifiedName(str2, str, true);
        QName qNameMakeQualifiedQName = dom.locale().makeQualifiedQName(str, str2);
        String localPart = qNameMakeQualifiedQName.getLocalPart();
        String strValidatePrefix = validatePrefix(qNameMakeQualifiedQName.getPrefix(), str, localPart, true);
        Object objAttributes_getNamedItemNS = attributes_getNamedItemNS(dom, str, localPart);
        if (objAttributes_getNamedItemNS == null) {
            objAttributes_getNamedItemNS = document_createAttributeNS((Dom) node_getOwnerDocument(dom), str, localPart);
            attributes_setNamedItemNS(dom, (Dom) objAttributes_getNamedItemNS);
        }
        Dom dom2 = (Dom) objAttributes_getNamedItemNS;
        node_setPrefix(dom2, strValidatePrefix);
        node_setNodeValue(dom2, str3);
    }

    static /* synthetic */ Object f1(Consumer consumer, Dom dom) {
        consumer.accept(dom);
        return null;
    }

    static Node firstChild(Dom dom) {
        return node_getFirstChild(dom);
    }

    public static XmlCursor getXmlCursor(Dom dom) {
        Cur curTempCur = dom.tempCur();
        Cursor cursor = new Cursor(curTempCur);
        curTempCur.release();
        return cursor;
    }

    public static XmlObject getXmlObject(Dom dom) {
        Cur curTempCur = dom.tempCur();
        XmlObject object = curTempCur.getObject();
        curTempCur.release();
        return object;
    }

    public static XMLStreamReader getXmlStreamReader(Dom dom) {
        XMLStreamReader xMLStreamReaderNewXmlStreamReader;
        switch (dom.nodeType()) {
            case 1:
            case 2:
            case 7:
            case 8:
            case 9:
            case 11:
                Cur curTempCur = dom.tempCur();
                XMLStreamReader xMLStreamReaderNewXmlStreamReader2 = Jsr173.newXmlStreamReader(curTempCur, null);
                curTempCur.release();
                return xMLStreamReaderNewXmlStreamReader2;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                Cur curTempCur2 = charNode.tempCur();
                if (curTempCur2 == null) {
                    curTempCur2 = dom.locale().tempCur();
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, charNode.getObject(), charNode._off, charNode._cch);
                } else {
                    xMLStreamReaderNewXmlStreamReader = Jsr173.newXmlStreamReader(curTempCur2, curTempCur2.getChars(charNode._cch), curTempCur2._offSrc, curTempCur2._cchSrc);
                }
                curTempCur2.release();
                return xMLStreamReaderNewXmlStreamReader;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    public static Element impl_saajCallback_createSoapElement(Dom dom, QName qName, QName qName2) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.createElement(qName, qName2);
        Dom dom2 = curTempCur.getDom();
        curTempCur.release();
        return (Element) dom2;
    }

    public static Text impl_saajCallback_ensureSoapTextNode(Dom dom) {
        return null;
    }

    public static Object impl_saajCallback_getSaajData(Dom dom) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = (SaajData) curTempCur.getBookmark(SaajData.class);
        Object obj = saajData == null ? null : saajData._obj;
        curTempCur.release();
        return obj;
    }

    public static Element impl_saajCallback_importSoapElement(Dom dom, Element element, boolean z, QName qName) {
        throw new RuntimeException("Not impl");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void impl_saajCallback_setSaajData(Dom dom, Object obj) {
        Cur curTempCur = dom.locale().tempCur();
        curTempCur.moveToDom(dom);
        SaajData saajData = null;
        Object[] objArr = 0;
        if (obj != null) {
            SaajData saajData2 = (SaajData) curTempCur.getBookmark(SaajData.class);
            if (saajData2 == null) {
                saajData2 = new SaajData();
            }
            saajData = saajData2;
            saajData._obj = obj;
        }
        curTempCur.setBookmark(SaajData.class, saajData);
        curTempCur.release();
    }

    public static Node insert(Dom dom, Dom dom2) {
        return node_insertBefore((Dom) parent(dom2), dom, dom2);
    }

    private static String isValidChild(Dom dom, Dom dom2) {
        int iNodeType = dom.nodeType();
        int iNodeType2 = dom2.nodeType();
        switch (iNodeType) {
            case 1:
            case 5:
            case 6:
            case 11:
                if (iNodeType2 == 1 || iNodeType2 == 3 || iNodeType2 == 4 || iNodeType2 == 5 || iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
            case 2:
                if (iNodeType2 == 3 || iNodeType2 == 5) {
                    return null;
                }
            case 3:
            case 4:
            case 7:
            case 8:
            case 10:
            case 12:
                return nodeKindName(iNodeType) + " nodes may not have any children";
            case 9:
                if (iNodeType2 == 1) {
                    if (document_getDocumentElement(dom) != null) {
                        return "Documents may only have a maximum of one document element";
                    }
                    return null;
                }
                if (iNodeType2 == 10) {
                    if (document_getDoctype(dom) != null) {
                        return "Documents may only have a maximum of one document type node";
                    }
                    return null;
                }
                if (iNodeType2 == 7 || iNodeType2 == 8) {
                    return null;
                }
        }
        return nodeKindName(iNodeType) + " nodes may not have " + nodeKindName(iNodeType2) + " nodes as children";
    }

    static Node nextSibling(Dom dom) {
        return node_getNextSibling(dom);
    }

    static String nodeKindName(int i2) {
        switch (i2) {
            case 1:
                return "element";
            case 2:
                return "attribute";
            case 3:
                return "text";
            case 4:
                return "cdata section";
            case 5:
                return "entity reference";
            case 6:
                return "entity";
            case 7:
                return "processing instruction";
            case 8:
                return "comment";
            case 9:
                return "document";
            case 10:
                return "document type";
            case 11:
                return "document fragment";
            case 12:
                return "notation";
            default:
                throw new RuntimeException("Unknown node type");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.apache.xmlbeans.impl.store.CharNode] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static Node node_cloneNode(Dom dom, boolean z) throws DOMException {
        Cur curTempCur;
        Locale locale = dom.locale();
        ?? dom2 = 0;
        dom2 = 0;
        if (!z) {
            int iNodeType = dom.nodeType();
            if (iNodeType == 1) {
                curTempCur = locale.tempCur();
                curTempCur.createElement(dom.getQName());
                Element element = (Element) curTempCur.getDom();
                NamedNodeMap attributes = ((Element) dom).getAttributes();
                for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                    element.setAttributeNodeNS((Attr) attributes.item(i2).cloneNode(true));
                }
            } else if (iNodeType == 2) {
                curTempCur = locale.tempCur();
                curTempCur.createAttr(dom.getQName());
            } else if (iNodeType == 9) {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocumentRoot();
            } else if (iNodeType != 11) {
                curTempCur = null;
            } else {
                curTempCur = locale.tempCur();
                curTempCur.createDomDocFragRoot();
            }
            if (curTempCur != null) {
                dom2 = curTempCur.getDom();
                curTempCur.release();
            }
        }
        if (dom2 == 0) {
            switch (dom.nodeType()) {
                case 1:
                case 2:
                case 7:
                case 8:
                case 9:
                case 11:
                    Cur curTempCur2 = locale.tempCur();
                    Cur curTempCur3 = dom.tempCur();
                    curTempCur3.copyNode(curTempCur2);
                    dom2 = curTempCur2.getDom();
                    curTempCur2.release();
                    curTempCur3.release();
                    break;
                case 3:
                case 4:
                    Cur curTempCur4 = dom.tempCur();
                    dom2 = dom.nodeType() == 3 ? locale.createTextNode() : locale.createCdataNode();
                    dom2.setChars(curTempCur4.getChars(((CharNode) dom)._cch), curTempCur4._offSrc, curTempCur4._cchSrc);
                    curTempCur4.release();
                    break;
                case 5:
                case 6:
                case 10:
                case 12:
                    throw new RuntimeException("Not impl");
                default:
                    throw new RuntimeException("Unknown kind");
            }
        }
        return (Node) dom2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node node_getFirstChild(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 1 && iNodeType != 2) {
            if (iNodeType == 5) {
                throw new RuntimeException("Not impl");
            }
            if (iNodeType != 6) {
                switch (iNodeType) {
                    case 9:
                    case 11:
                        break;
                    case 10:
                    case 12:
                        break;
                    default:
                        return null;
                }
            }
            throw new RuntimeException("Not impl");
        }
        Xobj xobj = (Xobj) dom;
        xobj.ensureOccupancy();
        if (xobj.isFirstChildPtrDomUsable()) {
            return (NodeXobj) xobj._firstChild;
        }
        Xobj xobjLastAttr = xobj.lastAttr();
        if (xobjLastAttr != null) {
            if (xobjLastAttr.isNextSiblingPtrDomUsable()) {
                return (NodeXobj) xobjLastAttr._nextSibling;
            }
            if (xobjLastAttr.isCharNodesAfterUsable()) {
                return xobjLastAttr._charNodesAfter;
            }
        }
        if (xobj.isCharNodesValueUsable()) {
            return xobj._charNodesValue;
        }
        return null;
    }

    public static Node node_getLastChild(Dom dom) {
        CharNode charNodes;
        CharNode charNode = null;
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return null;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                if (curTempCur.toLastChild()) {
                    Dom dom2 = curTempCur.getDom();
                    curTempCur.skip();
                    charNodes = curTempCur.getCharNodes();
                    if (charNodes == null) {
                        charNode = dom2;
                    }
                } else {
                    curTempCur.next();
                    charNodes = curTempCur.getCharNodes();
                }
                if (charNode == null && charNodes != null) {
                    while (true) {
                        CharNode charNode2 = charNodes._next;
                        if (charNode2 != null) {
                            charNodes = charNode2;
                        } else {
                            charNode = charNodes;
                        }
                    }
                }
                curTempCur.release();
                return charNode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Node node_getNextSibling(Dom dom) {
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                Xobj xobj = (Xobj) dom;
                xobj.ensureOccupancy();
                if (xobj.isNextSiblingPtrDomUsable()) {
                    return (NodeXobj) xobj._nextSibling;
                }
                if (xobj.isCharNodesAfterUsable()) {
                    return xobj._charNodesAfter;
                }
                return null;
            case 2:
            case 9:
            case 11:
            default:
                return null;
            case 3:
            case 4:
                CharNode charNode = (CharNode) dom;
                if (!(charNode.getObject() instanceof Xobj)) {
                    return null;
                }
                Xobj xobj2 = (Xobj) charNode.getObject();
                xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
                xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
                CharNode charNode2 = charNode._next;
                return charNode2 != null ? charNode2 : charNode.isNodeAftertext() ? (NodeXobj) xobj2._nextSibling : (NodeXobj) xobj2._firstChild;
            case 5:
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not implemented");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String node_getNodeValue(Dom dom) {
        int iNodeType = dom.nodeType();
        if (iNodeType != 2) {
            if (iNodeType == 3 || iNodeType == 4) {
                CharNode charNode = (CharNode) dom;
                if (!(charNode.getObject() instanceof Xobj)) {
                    return CharUtil.getString(charNode.getObject(), charNode._off, charNode._cch);
                }
                Xobj xobj = (Xobj) charNode.getObject();
                xobj.ensureOccupancy();
                if (charNode.isNodeAftertext()) {
                    xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
                    return xobj.getCharsAfterAsString(charNode._off, charNode._cch);
                }
                xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
                return xobj.getCharsValueAsString(charNode._off, charNode._cch);
            }
            if (iNodeType != 7 && iNodeType != 8) {
                return null;
            }
        }
        return ((Xobj) dom).getValueAsString();
    }

    public static Document node_getOwnerDocument(Dom dom) {
        if (dom.nodeType() == 9) {
            return null;
        }
        Locale locale = dom.locale();
        if (locale._ownerDoc == null) {
            Cur curTempCur = locale.tempCur();
            curTempCur.createDomDocumentRoot();
            locale._ownerDoc = curTempCur.getDom();
            curTempCur.release();
        }
        return (Document) locale._ownerDoc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Node node_getParentNode(Dom dom) {
        Cur curTempCur;
        switch (dom.nodeType()) {
            case 1:
            case 7:
            case 8:
                curTempCur = dom.tempCur();
                if (!curTempCur.toParentRaw()) {
                    curTempCur.release();
                }
                if (curTempCur == null) {
                    return null;
                }
                Dom dom2 = curTempCur.getDom();
                curTempCur.release();
                return (Node) dom2;
            case 2:
            case 9:
            case 11:
                curTempCur = null;
                if (curTempCur == null) {
                }
                break;
            case 3:
            case 4:
                curTempCur = dom.tempCur();
                if (curTempCur != null) {
                    curTempCur.toParent();
                }
                if (curTempCur == null) {
                }
                break;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
    }

    /* JADX WARN: Path cross not found for [B:27:0x0055, B:21:0x0044], limit reached: 27 */
    /* JADX WARN: Path cross not found for [B:8:0x0013, B:12:0x001b], limit reached: 27 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0055 -> B:24:0x004a). Please report as a decompilation issue!!! */
    public static Node node_getPreviousSibling(Dom dom) {
        Node nodeNode_getFirstChild;
        int iNodeType = dom.nodeType();
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            if (!(charNode.getObject() instanceof Xobj)) {
                return null;
            }
            NodeXobj nodeXobj = (NodeXobj) charNode.getObject();
            nodeXobj.ensureOccupancy();
            boolean zIsNodeAftertext = charNode.isNodeAftertext();
            Node nodeNode_getNextSibling = charNode._prev;
            nodeNode_getFirstChild = nodeXobj;
            if (nodeNode_getNextSibling == null) {
                if (!zIsNodeAftertext) {
                    nodeNode_getNextSibling = nodeXobj._charNodesValue;
                }
            }
            nodeNode_getFirstChild = nodeNode_getNextSibling;
        } else {
            NodeXobj nodeXobj2 = (NodeXobj) dom;
            Node node = (NodeXobj) nodeXobj2._prevSibling;
            if (node != null) {
                nodeNode_getFirstChild = node;
                if (!(nodeXobj2 instanceof AttrXobj)) {
                    boolean z = node instanceof AttrXobj;
                    nodeNode_getFirstChild = node;
                    if (z) {
                    }
                }
            }
            NamespaceManager namespaceManager = nodeXobj2._parent;
            nodeNode_getFirstChild = node;
            if (namespaceManager != null) {
                nodeNode_getFirstChild = node_getFirstChild((Dom) namespaceManager);
            }
        }
        if (nodeNode_getFirstChild != null || (nodeNode_getNextSibling = node_getNextSibling((Dom) nodeNode_getFirstChild)) == dom) {
            return nodeNode_getFirstChild;
        }
        nodeNode_getFirstChild = nodeNode_getNextSibling;
        if (nodeNode_getFirstChild != null) {
        }
        return nodeNode_getFirstChild;
    }

    public static boolean node_hasAttributes(Dom dom) {
        if (dom.nodeType() != 1) {
            return false;
        }
        Cur curTempCur = dom.tempCur();
        boolean zHasAttrs = curTempCur.hasAttrs();
        curTempCur.release();
        return zHasAttrs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Node node_insertBefore(Dom dom, Dom dom2, Dom dom3) {
        if (dom2 == dom3) {
            return (Node) dom2;
        }
        if (dom3 != null && parent(dom3) != dom) {
            throw new NotFoundErr("RefChild is not a child of this node");
        }
        int iNodeType = dom2.nodeType();
        if (iNodeType == 11) {
            Node nodeFirstChild = firstChild(dom2);
            while (nodeFirstChild != null) {
                Dom dom4 = (Dom) nodeFirstChild;
                validateNewChild(dom, dom4);
                nodeFirstChild = nextSibling(dom4);
            }
            Node nodeFirstChild2 = firstChild(dom2);
            while (nodeFirstChild2 != null) {
                Dom dom5 = (Dom) nodeFirstChild2;
                Node nodeNextSibling = nextSibling(dom5);
                if (dom3 == null) {
                    append(dom5, dom);
                } else {
                    insert(dom5, dom3);
                }
                nodeFirstChild2 = nodeNextSibling;
            }
            return (Node) dom2;
        }
        validateNewChild(dom, dom2);
        remove(dom2);
        dom.nodeType();
        if (iNodeType != 1) {
            if (iNodeType == 10) {
                throw new RuntimeException("Not implemented");
            }
            if (iNodeType == 3 || iNodeType == 4) {
                CharNode charNode = (CharNode) dom2;
                CharNode charNode2 = null;
                Cur curTempCur = dom.tempCur();
                if (dom3 == null) {
                    curTempCur.toEnd();
                } else {
                    int iNodeType2 = dom3.nodeType();
                    if (iNodeType2 == 3 || iNodeType2 == 4) {
                        charNode2 = (CharNode) dom3;
                        curTempCur.moveToCharNode(charNode2);
                    } else {
                        if (iNodeType2 == 5) {
                            throw new RuntimeException("Not implemented");
                        }
                        curTempCur.moveToDom(dom3);
                    }
                }
                CharNode charNodeInsertNode = CharNode.insertNode(curTempCur.getCharNodes(), charNode, charNode2);
                curTempCur.insertChars(charNode.getObject(), charNode._off, charNode._cch);
                curTempCur.setCharNodes(charNodeInsertNode);
                curTempCur.release();
            } else {
                if (iNodeType == 5) {
                    throw new RuntimeException("Not implemented");
                }
                if (iNodeType != 7 && iNodeType != 8) {
                    throw new RuntimeException("Unexpected child node type");
                }
                if (dom3 != null) {
                }
            }
        } else if (dom3 != null) {
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.toEnd();
            Cur.moveNode((Xobj) dom2, curTempCur2);
            curTempCur2.release();
        } else {
            int iNodeType3 = dom3.nodeType();
            if (iNodeType3 == 3 || iNodeType3 == 4) {
                ArrayList<Dom> arrayList = new ArrayList();
                while (dom3 != null && (dom3.nodeType() == 3 || dom3.nodeType() == 4)) {
                    Node nodeNextSibling2 = nextSibling(dom3);
                    arrayList.add((Dom) remove(dom3));
                    dom3 = (Dom) nodeNextSibling2;
                }
                if (dom3 == null) {
                    append(dom2, dom);
                } else {
                    insert(dom2, dom3);
                }
                Dom dom6 = (Dom) nextSibling(dom2);
                for (Dom dom7 : arrayList) {
                    if (dom6 == null) {
                        append(dom7, dom);
                    } else {
                        insert(dom7, dom6);
                    }
                }
            } else {
                if (iNodeType3 == 5) {
                    throw new RuntimeException("Not implemented");
                }
                Cur curTempCur3 = dom3.tempCur();
                Cur.moveNode((Xobj) dom2, curTempCur3);
                curTempCur3.release();
            }
        }
        return (Node) dom2;
    }

    public static void node_normalize(Dom dom) {
        switch (dom.nodeType()) {
            case 3:
            case 4:
            case 7:
            case 8:
                return;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            case 9:
            case 11:
            default:
                Cur curTempCur = dom.tempCur();
                curTempCur.push();
                do {
                    curTempCur.nextWithAttrs();
                    CharNode charNodes = curTempCur.getCharNodes();
                    if (charNodes != null) {
                        if (!curTempCur.isText()) {
                            while (charNodes != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes);
                            }
                        } else if (charNodes._next != null) {
                            while (charNodes._next != null) {
                                charNodes.setChars(null, 0, 0);
                                charNodes = CharNode.remove(charNodes, charNodes._next);
                            }
                            charNodes._cch = Integer.MAX_VALUE;
                        }
                        curTempCur.setCharNodes(charNodes);
                    }
                } while (!curTempCur.isAtEndOfLastPush());
                curTempCur.release();
                dom.locale().invalidateDomCaches(dom);
                return;
        }
    }

    public static Node node_removeChild(Dom dom, Dom dom2) {
        if (parent(dom2) != dom) {
            throw new NotFoundErr("Child to remove is not a child of given parent");
        }
        switch (dom2.nodeType()) {
            case 1:
            case 7:
            case 8:
                removeNode(dom2);
                break;
            case 2:
            case 9:
            case 11:
                throw new IllegalStateException();
            case 3:
            case 4:
                Cur curTempCur = dom2.tempCur();
                CharNode charNodes = curTempCur.getCharNodes();
                CharNode charNode = (CharNode) dom2;
                charNode.setChars(curTempCur.moveChars(null, charNode._cch), curTempCur._offSrc, curTempCur._cchSrc);
                curTempCur.setCharNodes(CharNode.remove(charNodes, charNode));
                curTempCur.release();
                break;
            case 5:
                throw new RuntimeException("Not impl");
            case 6:
            case 10:
            case 12:
                throw new RuntimeException("Not impl");
            default:
                throw new RuntimeException("Unknown kind");
        }
        return (Node) dom2;
    }

    public static Node node_replaceChild(Dom dom, Dom dom2, Dom dom3) {
        Node nodeNode_getNextSibling = node_getNextSibling(dom3);
        node_removeChild(dom, dom3);
        try {
            node_insertBefore(dom, dom2, (Dom) nodeNode_getNextSibling);
            return (Node) dom3;
        } catch (DOMException e) {
            node_insertBefore(dom, dom3, (Dom) nodeNode_getNextSibling);
            throw e;
        }
    }

    public static void node_setNodeValue(Dom dom, String str) throws DOMException {
        if (str == null) {
            str = "";
        }
        int iNodeType = dom.nodeType();
        if (iNodeType == 2) {
            NodeList childNodes = ((Node) dom).getChildNodes();
            while (childNodes.getLength() > 1) {
                node_removeChild(dom, (Dom) childNodes.item(1));
            }
            if (childNodes.getLength() == 0) {
                TextNode textNodeCreateTextNode = dom.locale().createTextNode();
                textNodeCreateTextNode.setChars(str, 0, str.length());
                node_insertBefore(dom, textNodeCreateTextNode, null);
            } else {
                childNodes.item(0).setNodeValue(str);
            }
            if (((AttrXobj) dom).isId()) {
                Document documentNode_getOwnerDocument = node_getOwnerDocument(dom);
                String strNode_getNodeValue = node_getNodeValue(dom);
                if (documentNode_getOwnerDocument instanceof DocumentXobj) {
                    DocumentXobj documentXobj = (DocumentXobj) documentNode_getOwnerDocument;
                    documentXobj.removeIdElement(strNode_getNodeValue);
                    documentXobj.addIdElement(str, (Dom) attr_getOwnerElement(dom));
                    return;
                }
                return;
            }
            return;
        }
        if (iNodeType == 3 || iNodeType == 4) {
            CharNode charNode = (CharNode) dom;
            Cur curTempCur = charNode.tempCur();
            if (curTempCur == null) {
                charNode.setChars(str, 0, str.length());
                return;
            }
            curTempCur.moveChars(null, charNode._cch);
            charNode._cch = str.length();
            curTempCur.insertString(str);
            curTempCur.release();
            return;
        }
        if (iNodeType == 7 || iNodeType == 8) {
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.next();
            curTempCur2.getChars(-1);
            curTempCur2.moveChars(null, curTempCur2._cchSrc);
            curTempCur2.insertString(str);
            curTempCur2.release();
        }
    }

    public static void node_setPrefix(Dom dom, String str) {
        if (dom.nodeType() != 1 && dom.nodeType() != 2) {
            validatePrefix(str, "", "", false);
            return;
        }
        Cur curTempCur = dom.tempCur();
        QName name = curTempCur.getName();
        String namespaceURI = name.getNamespaceURI();
        String localPart = name.getLocalPart();
        curTempCur.setName(dom.locale().makeQName(namespaceURI, localPart, validatePrefix(str, namespaceURI, localPart, dom.nodeType() == 2)));
        curTempCur.release();
    }

    static Node parent(Dom dom) {
        return node_getParentNode(dom);
    }

    static Node prevSibling(Dom dom) {
        return node_getPreviousSibling(dom);
    }

    public static Node remove(Dom dom) {
        Node nodeParent = parent(dom);
        if (nodeParent != null) {
            node_removeChild((Dom) nodeParent, dom);
        }
        return (Node) dom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void removeNode(Dom dom) {
        CharNode charNodes;
        Cur curTempCur = dom.tempCur();
        curTempCur.toEnd();
        if (curTempCur.next() && (charNodes = curTempCur.getCharNodes()) != null) {
            curTempCur.setCharNodes(null);
            Cur curTempCur2 = dom.tempCur();
            curTempCur2.setCharNodes(CharNode.appendNodes(curTempCur2.getCharNodes(), charNodes));
            curTempCur2.release();
        }
        curTempCur.release();
        Cur.moveNode((Xobj) dom, null);
    }

    public static Element saajCallback_createSoapElement(Dom dom, final QName qName, final QName qName2) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.s2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.impl_saajCallback_createSoapElement((DomImpl.Dom) obj, qName, qName2);
            }
        });
    }

    public static Text saajCallback_ensureSoapTextNode(Dom dom) {
        return (Text) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.x7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.impl_saajCallback_ensureSoapTextNode((DomImpl.Dom) obj);
            }
        });
    }

    public static Object saajCallback_getSaajData(Dom dom) {
        return syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.p8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.impl_saajCallback_getSaajData((DomImpl.Dom) obj);
            }
        });
    }

    public static Element saajCallback_importSoapElement(Dom dom, final Element element, final boolean z, final QName qName) {
        return (Element) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.x3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DomImpl.impl_saajCallback_importSoapElement((DomImpl.Dom) obj, element, z, qName);
            }
        });
    }

    public static void saajCallback_setSaajData(Dom dom, final Object obj) {
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.u2
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                DomImpl.impl_saajCallback_setSaajData((DomImpl.Dom) obj2, obj);
            }
        });
    }

    public static SOAPBodyElement soapBody_addBodyElement(Dom dom, final Name name) {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPBodyElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.m6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapBody_addBodyElement(sOAPBody, name);
            }
        });
    }

    public static SOAPBodyElement soapBody_addDocument(Dom dom, final Document document) {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPBodyElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.c5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapBody_addDocument(sOAPBody, document);
            }
        });
    }

    public static SOAPFault soapBody_addFault(final Dom dom) throws SOAPException {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPFault) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.j6
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapBody_addFault(sOAPBody);
            }
        });
    }

    public static SOAPFault soapBody_getFault(Dom dom) {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPFault) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.h5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapBody_getFault(sOAPBody);
            }
        });
    }

    public static boolean soapBody_hasFault(Dom dom) {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.n4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((DomImpl.Dom) obj).locale()._saaj.soapBody_hasFault(sOAPBody));
            }
        })).booleanValue();
    }

    public static Detail soapFault_addDetail(final Dom dom) throws SOAPException {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (Detail) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.z3
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapFault_addDetail(sOAPFault);
            }
        });
    }

    public static Detail soapFault_getDetail(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (Detail) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.y3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getDetail(sOAPFault);
            }
        });
    }

    public static String soapFault_getFaultActor(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.o5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getFaultActor(sOAPFault);
            }
        });
    }

    public static String soapFault_getFaultCode(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.x2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getFaultCode(sOAPFault);
            }
        });
    }

    public static Name soapFault_getFaultCodeAsName(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (Name) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.l3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getFaultCodeAsName(sOAPFault);
            }
        });
    }

    public static String soapFault_getFaultString(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.e4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getFaultString(sOAPFault);
            }
        });
    }

    public static java.util.Locale soapFault_getFaultStringLocale(Dom dom) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        return (java.util.Locale) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.i3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapFault_getFaultStringLocale(sOAPFault);
            }
        });
    }

    public static void soapFault_setFaultActor(Dom dom, final String str) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.h4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapFault_setFaultActor(sOAPFault, str);
            }
        });
    }

    public static void soapFault_setFaultCode(final Dom dom, final Name name) throws SOAPException {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.e5
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return DomImpl.P0(dom, sOAPFault, name);
            }
        });
    }

    public static void soapFault_setFaultString(Dom dom, final String str) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.m3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapFault_setFaultString(sOAPFault, str);
            }
        });
    }

    public static String soapHeaderElement_getActor(Dom dom) {
        final SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        return (String) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.k4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeaderElement_getActor(sOAPHeaderElement);
            }
        });
    }

    public static boolean soapHeaderElement_getMustUnderstand(Dom dom) {
        final SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        return ((Boolean) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.j5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((DomImpl.Dom) obj).locale()._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement));
            }
        })).booleanValue();
    }

    public static void soapHeaderElement_setActor(Dom dom, final String str) {
        final SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.p6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapHeaderElement_setActor(sOAPHeaderElement, str);
            }
        });
    }

    public static void soapHeaderElement_setMustUnderstand(Dom dom, final boolean z) {
        final SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.q2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, z);
            }
        });
    }

    public static SOAPHeaderElement soapHeader_addHeaderElement(Dom dom, final Name name) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (SOAPHeaderElement) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.b6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_addHeaderElement(sOAPHeader, name);
            }
        });
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineAllHeaderElements(Dom dom) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.g5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_examineAllHeaderElements(sOAPHeader);
            }
        });
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineHeaderElements(Dom dom, final String str) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.b5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_examineHeaderElements(sOAPHeader, str);
            }
        });
    }

    public static Iterator<SOAPHeaderElement> soapHeader_examineMustUnderstandHeaderElements(Dom dom, final String str) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.t5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, str);
            }
        });
    }

    public static Iterator<SOAPHeaderElement> soapHeader_extractAllHeaderElements(Dom dom) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.i4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_extractAllHeaderElements(sOAPHeader);
            }
        });
    }

    public static Iterator<SOAPHeaderElement> soapHeader_extractHeaderElements(Dom dom, final String str) {
        final SOAPHeader sOAPHeader = (SOAPHeader) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.o6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapHeader_extractHeaderElements(sOAPHeader, str);
            }
        });
    }

    private static <T> T syncWrap(final Dom dom, final Function<Dom, T> function) {
        return (T) syncWrapHelper(dom.locale(), true, new Supplier() { // from class: org.apache.xmlbeans.impl.store.t4
            @Override // java.util.function.Supplier
            public final Object get() {
                return function.apply(dom);
            }
        });
    }

    private static <T> T syncWrapEx(Dom dom, WrapSoapEx<T> wrapSoapEx) throws SOAPException {
        return (T) syncWrapHelperEx(dom.locale(), true, wrapSoapEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T syncWrapHelper(Locale locale, boolean z, Supplier<T> supplier) {
        T t;
        if (locale.noSync()) {
            return (T) syncWrapHelper2(locale, z, supplier);
        }
        synchronized (locale) {
            t = (T) syncWrapHelper2(locale, z, supplier);
        }
        return t;
    }

    private static <T> T syncWrapHelper2(Locale locale, boolean z, Supplier<T> supplier) {
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

    private static <T> T syncWrapHelperEx(Locale locale, boolean z, WrapSoapEx<T> wrapSoapEx) throws SOAPException {
        T t;
        if (locale.noSync()) {
            return (T) syncWrapHelperEx2(locale, z, wrapSoapEx);
        }
        synchronized (locale) {
            t = (T) syncWrapHelperEx2(locale, z, wrapSoapEx);
        }
        return t;
    }

    private static <T> T syncWrapHelperEx2(Locale locale, boolean z, WrapSoapEx<T> wrapSoapEx) throws SOAPException {
        if (z) {
            locale.enter();
        }
        try {
            return wrapSoapEx.get();
        } finally {
            if (z) {
                locale.exit();
            }
        }
    }

    private static <T> T syncWrapNoEnter(final Dom dom, final Function<Dom, T> function) {
        return (T) syncWrapHelper(dom.locale(), false, new Supplier() { // from class: org.apache.xmlbeans.impl.store.a5
            @Override // java.util.function.Supplier
            public final Object get() {
                return function.apply(dom);
            }
        });
    }

    private static void syncWrapVoid(final Dom dom, final Consumer<Dom> consumer) {
        syncWrapHelper(dom.locale(), true, new Supplier() { // from class: org.apache.xmlbeans.impl.store.q5
            @Override // java.util.function.Supplier
            public final Object get() {
                return DomImpl.f1(consumer, dom);
            }
        });
    }

    private static void validateName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        if (!XMLChar.isValidName(str)) {
            throw new InvalidCharacterError("Name has an invalid character");
        }
    }

    private static void validateNcName(String str) {
        if (str != null && str.length() > 0 && !XMLChar.isValidNCName(str)) {
            throw new InvalidCharacterError();
        }
    }

    private static void validateNewChild(Dom dom, Dom dom2) {
        String strIsValidChild = isValidChild(dom, dom2);
        if (strIsValidChild != null) {
            throw new HierarchyRequestErr(strIsValidChild);
        }
        if (dom == dom2) {
            throw new HierarchyRequestErr("New child and parent are the same node");
        }
        Node nodeParent = (Node) dom;
        do {
            nodeParent = parent((Dom) nodeParent);
            if (nodeParent == null) {
                return;
            }
            if (dom2.nodeType() == 5) {
                throw new NoModificationAllowedErr("Entity reference trees may not be modified");
            }
        } while (dom2 != nodeParent);
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    }

    private static String validatePrefix(String str, String str2, String str3, boolean z) {
        if (str != null && str.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            throw new NamespaceErr("Invalid prefix - contains ':' character");
        }
        validateNcName(str);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!str.isEmpty() && str2.isEmpty()) {
            throw new NamespaceErr("Attempt to give a prefix for no namespace");
        }
        if (str.equals("xml") && !str2.equals(XMLConstants.XML_NS_URI)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        if (z) {
            if (str.length() > 0) {
                if (str3.equals("xmlns")) {
                    throw new NamespaceErr("Invalid namespace - attr is default namespace already");
                }
                if (Locale.beginsWithXml(str3)) {
                    throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
                }
                if (str.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                    throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
                }
            } else if (str3.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
            }
        } else if (Locale.beginsWithXml(str)) {
            throw new NamespaceErr("Invalid prefix - begins with 'xml'");
        }
        return str;
    }

    private static void validateQualifiedName(String str, String str2, boolean z) {
        if (str2 == null) {
            str2 = "";
        }
        int iIndexOf = str.indexOf(58);
        if (iIndexOf < 0) {
            validateNcName(str);
            if (z && str.equals("xmlns") && !str2.equals("http://www.w3.org/2000/xmlns/")) {
                throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
            }
        } else {
            if (iIndexOf == 0) {
                throw new NamespaceErr("Invalid qualified name, no prefix specified");
            }
            String strSubstring = str.substring(0, iIndexOf);
            validateNcName(strSubstring);
            if (str2.isEmpty()) {
                throw new NamespaceErr("Attempt to give a prefix for no namespace");
            }
            str = str.substring(iIndexOf + 1);
            if (str.indexOf(58) >= 0) {
                throw new NamespaceErr("Invalid qualified name, more than one colon");
            }
            validateNcName(str);
            if (strSubstring.equals("xml") && !str2.equals(XMLConstants.XML_NS_URI)) {
                throw new NamespaceErr("Invalid prefix - begins with 'xml'");
            }
        }
        if (str.isEmpty()) {
            throw new NamespaceErr("Invalid qualified name, no local part specified");
        }
    }

    public static SOAPElement _soapElement_addChildElement(final Dom dom, final Name name) throws SOAPException {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.f6
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, name);
            }
        });
    }

    public static Iterator<SOAPElement> _soapElement_getChildElements(Dom dom, final Name name) {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (Iterator) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.l6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapElement_getChildElements(sOAPElement, name);
            }
        });
    }

    public static Name _soapEnvelope_createName(Dom dom, final String str, final String str2, final String str3) {
        final SOAPEnvelope sOAPEnvelope = (SOAPEnvelope) dom;
        return (Name) syncWrap(dom, new Function() { // from class: org.apache.xmlbeans.impl.store.v2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((DomImpl.Dom) obj).locale()._saaj.soapEnvelope_createName(sOAPEnvelope, str, str2, str3);
            }
        });
    }

    public static SOAPFault soapBody_addFault(final Dom dom, final Name name, final String str) throws SOAPException {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPFault) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.t2
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapBody_addFault(sOAPBody, name, str);
            }
        });
    }

    public static void soapFault_setFaultCode(final Dom dom, final String str) throws SOAPException {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.r6
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return DomImpl.Q0(dom, sOAPFault, str);
            }
        });
    }

    public static void soapFault_setFaultString(Dom dom, final String str, final java.util.Locale locale) {
        final SOAPFault sOAPFault = (SOAPFault) dom;
        syncWrapVoid(dom, new Consumer() { // from class: org.apache.xmlbeans.impl.store.i6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((DomImpl.Dom) obj).locale()._saaj.soapFault_setFaultString(sOAPFault, str, locale);
            }
        });
    }

    public static SOAPElement _soapElement_addChildElement(final Dom dom, final String str) throws SOAPException {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.y4
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str);
            }
        });
    }

    public static SOAPFault soapBody_addFault(final Dom dom, final Name name, final String str, final java.util.Locale locale) throws SOAPException {
        final SOAPBody sOAPBody = (SOAPBody) dom;
        return (SOAPFault) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.s6
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapBody_addFault(sOAPBody, name, str, locale);
            }
        });
    }

    public static SOAPElement _soapElement_addChildElement(final Dom dom, final String str, final String str2) throws SOAPException {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.w5
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str, str2);
            }
        });
    }

    public static SOAPElement _soapElement_addChildElement(final Dom dom, final String str, final String str2, final String str3) throws SOAPException {
        final SOAPElement sOAPElement = (SOAPElement) dom;
        return (SOAPElement) syncWrapEx(dom, new WrapSoapEx() { // from class: org.apache.xmlbeans.impl.store.g6
            @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
            public final Object get() {
                return dom.locale()._saaj.soapElement_addChildElement(sOAPElement, str, str2, str3);
            }
        });
    }
}
