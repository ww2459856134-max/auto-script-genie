package org.apache.xmlbeans.impl.xpathgen;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes2.dex */
public class XPathGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static int countTextTokens(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursor.push();
            xmlCursor.toParent();
            XmlCursor.TokenType firstContentToken = xmlCursor.toFirstContentToken();
            int i2 = 0;
            int i3 = 0;
            while (!firstContentToken.isEnd()) {
                if (firstContentToken.isText()) {
                    if (xmlCursor.comparePosition(xmlCursorNewCursor) > 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                } else if (firstContentToken.isStart()) {
                    xmlCursor.toEndToken();
                }
                firstContentToken = xmlCursor.toNextToken();
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            xmlCursor.pop();
            if (i3 == 0) {
                return 0;
            }
            return i2;
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
    }

    private static String generateInternal(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XPathGenerationException {
        if (xmlCursor.isStartdoc()) {
            return "";
        }
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        QName name = xmlCursor.getName();
        int i2 = 0;
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            if (!xmlCursor.toParent()) {
                String str = "/" + name;
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return str;
            }
            xmlCursor.push();
            if (!xmlCursor.toChild(name)) {
                throw new IllegalStateException("Must have at least one child with name: " + name);
            }
            int i3 = 1;
            do {
                if (xmlCursor.isAtSamePositionAs(xmlCursorNewCursor)) {
                    i2 = i3;
                } else {
                    i3++;
                }
            } while (xmlCursor.toNextSibling(name));
            xmlCursor.pop();
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (i3 == 1) {
                return strGenerateInternal + '/' + qnameToString(name, namespaceContext);
            }
            return strGenerateInternal + '/' + qnameToString(name, namespaceContext) + '[' + i2 + ']';
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
    }

    public static String generateXPath(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XPathGenerationException {
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Null node");
        }
        if (namespaceContext == null) {
            throw new IllegalArgumentException("Null namespace context");
        }
        XmlCursor.TokenType tokenTypeCurrentTokenType = xmlCursor.currentTokenType();
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return ".";
        }
        int iIntValue = tokenTypeCurrentTokenType.intValue();
        if (iIntValue == 1 || iIntValue == 3) {
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        }
        if (iIntValue == 5) {
            int iCountTextTokens = countTextTokens(xmlCursor);
            xmlCursor.toParent();
            String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (iCountTextTokens == 0) {
                return strGenerateInternal + "/text()";
            }
            return strGenerateInternal + "/text()[position()=" + iCountTextTokens + ']';
        }
        if (iIntValue == 6) {
            QName name = xmlCursor.getName();
            xmlCursor.toParent();
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext) + "/@" + qnameToString(name, namespaceContext);
        }
        if (iIntValue != 7) {
            throw new XPathGenerationException("Cannot generate XPath for cursor position: " + tokenTypeCurrentTokenType.toString());
        }
        QName name2 = xmlCursor.getName();
        xmlCursor.toParent();
        String strGenerateInternal2 = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        String localPart = name2.getLocalPart();
        if (localPart.isEmpty()) {
            return strGenerateInternal2 + "/@xmlns";
        }
        return strGenerateInternal2 + "/@xmlns:" + localPart;
    }

    public static void main(String[] strArr) throws XmlException {
        NamespaceContext namespaceContext = new NamespaceContext() { // from class: org.apache.xmlbeans.impl.xpathgen.XPathGenerator.1
            @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String str) {
                if ("ns".equals(str)) {
                    return "http://a.com";
                }
                return null;
            }

            @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
            public String getPrefix(String str) {
                return null;
            }

            @Override // org.apache.poi.javax.xml.namespace.NamespaceContext
            public Iterator getPrefixes(String str) {
                return null;
            }
        };
        XmlCursor xmlCursorNewCursor = XmlObject.Factory.parse("<root>\n<ns:a xmlns:ns=\"http://a.com\"><b foo=\"value\">text1<c/>text2<c/>text3<c>text</c>text4</b></ns:a>\n</root>").newCursor();
        try {
            xmlCursorNewCursor.toFirstContentToken();
            xmlCursorNewCursor.toFirstContentToken();
            xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.push();
            System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
            xmlCursorNewCursor.pop();
            xmlCursorNewCursor.toNextSibling();
            xmlCursorNewCursor.toNextSibling();
            xmlCursorNewCursor.push();
            System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
            xmlCursorNewCursor.pop();
            XmlCursor xmlCursorNewCursor2 = xmlCursorNewCursor.newCursor();
            try {
                xmlCursorNewCursor2.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor2.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toFirstContentToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toPrevToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toFirstAttribute();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                if (xmlCursorNewCursor2 != null) {
                    xmlCursorNewCursor2.close();
                }
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
                xmlCursorNewCursor.pop();
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
            } finally {
            }
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
    }

    private static String qnameToString(QName qName, NamespaceContext namespaceContext) throws XPathGenerationException {
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.isEmpty()) {
            return localPart;
        }
        String prefix = qName.getPrefix();
        if (prefix != null && prefix.length() > 0 && namespaceURI.equals(namespaceContext.getNamespaceURI(prefix))) {
            return prefix + NameUtil.COLON + localPart;
        }
        String prefix2 = namespaceContext.getPrefix(namespaceURI);
        if (prefix2 == null) {
            throw new XPathGenerationException("Could not obtain a prefix for URI: " + namespaceURI);
        }
        if (prefix2.isEmpty()) {
            throw new XPathGenerationException("Can not use default prefix in XPath for URI: " + namespaceURI);
        }
        return prefix2 + NameUtil.COLON + localPart;
    }
}
