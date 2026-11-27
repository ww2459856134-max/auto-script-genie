package org.apache.xmlbeans.impl.common;

import java.util.Stack;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public class Sax2Dom extends DefaultHandler implements ContentHandler, LexicalHandler {
    public static final String EMPTYSTRING = "";
    public static final String XMLNS_PREFIX = "xmlns";
    public static final String XMLNS_STRING = "xmlns:";
    public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    public static final String XML_PREFIX = "xml";
    private Document _document;
    private Node _root;
    private Stack<Node> _nodeStk = new Stack<>();
    private Vector<String> _namespaceDecls = null;

    public Sax2Dom() throws ParserConfigurationException {
        this._root = null;
        this._document = null;
        Document documentCreateDocument = DocumentHelper.createDocument();
        this._document = documentCreateDocument;
        this._root = documentCreateDocument;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i2, int i3) throws DOMException {
        Node nodePeek = this._nodeStk.peek();
        if (nodePeek != this._document) {
            nodePeek.appendChild(this._document.createTextNode(new String(cArr, i2, i3)));
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i2, int i3) throws DOMException {
        Node nodePeek = this._nodeStk.peek();
        Comment commentCreateComment = this._document.createComment(new String(cArr, i2, i3));
        if (commentCreateComment != null) {
            nodePeek.appendChild(commentCreateComment);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        this._nodeStk.pop();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        this._nodeStk.pop();
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
    }

    public Node getDOM() {
        return this._root;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i2, int i3) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws DOMException {
        Node nodePeek = this._nodeStk.peek();
        ProcessingInstruction processingInstructionCreateProcessingInstruction = this._document.createProcessingInstruction(str, str2);
        if (processingInstructionCreateProcessingInstruction != null) {
            nodePeek.appendChild(processingInstructionCreateProcessingInstruction);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this._nodeStk.push(this._root);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws DOMException {
        Element elementCreateElementNS = this._document.createElementNS(str, str3);
        Vector<String> vector = this._namespaceDecls;
        if (vector != null) {
            int size = vector.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                String strElementAt = this._namespaceDecls.elementAt(i2);
                if (strElementAt == null || strElementAt.equals("")) {
                    elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", this._namespaceDecls.elementAt(i3));
                } else {
                    elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", XMLNS_STRING + strElementAt, this._namespaceDecls.elementAt(i3));
                }
                i2 = i3 + 1;
            }
            this._namespaceDecls.clear();
        }
        int length = attributes.getLength();
        for (int i4 = 0; i4 < length; i4++) {
            if (attributes.getLocalName(i4) == null) {
                elementCreateElementNS.setAttribute(attributes.getQName(i4), attributes.getValue(i4));
            } else {
                elementCreateElementNS.setAttributeNS(attributes.getURI(i4), attributes.getQName(i4), attributes.getValue(i4));
            }
        }
        this._nodeStk.peek().appendChild(elementCreateElementNS);
        this._nodeStk.push(elementCreateElementNS);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        if (this._namespaceDecls == null) {
            this._namespaceDecls = new Vector<>(2);
        }
        this._namespaceDecls.addElement(str);
        this._namespaceDecls.addElement(str2);
    }

    public Sax2Dom(Node node) throws ParserConfigurationException {
        this._root = null;
        this._document = null;
        this._root = node;
        if (node instanceof Document) {
            this._document = (Document) node;
        } else {
            if (node != null) {
                this._document = node.getOwnerDocument();
                return;
            }
            Document documentCreateDocument = DocumentHelper.createDocument();
            this._document = documentCreateDocument;
            this._root = documentCreateDocument;
        }
    }
}
