package org.apache.xmlbeans.impl.xpath;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.xpath.XPath;

/* loaded from: classes2.dex */
class XPathCompilationContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int _column;
    private final String _currentNodeVar;
    private String _expr;
    private final Map<String, String> _externalNamespaces;
    private boolean _lastDeepDot;
    private int _line;
    protected final Map<String, String> _namespaces = new HashMap();
    private int _offset;
    private boolean _sawDeepDot;

    XPathCompilationContext(Map<String, String> map, String str) {
        this._currentNodeVar = str == null ? "$this" : str;
        this._externalNamespaces = map == null ? new HashMap<>() : map;
    }

    private XPathStep addStep(boolean z, boolean z2, QName qName, XPathStep xPathStep) {
        XPathStep xPathStep2 = new XPathStep(z, z2, qName);
        if (xPathStep == null) {
            return xPathStep2;
        }
        XPathStep xPathStep3 = xPathStep;
        while (true) {
            XPathStep xPathStep4 = xPathStep3._next;
            if (xPathStep4 == null) {
                xPathStep3._next = xPathStep2;
                xPathStep2._prev = xPathStep3;
                return xPathStep;
            }
            xPathStep3 = xPathStep4;
        }
    }

    private void computeBacktrack(XPathStep xPathStep) {
        XPathStep xPathStep2;
        while (xPathStep != null) {
            XPathStep xPathStep3 = xPathStep._next;
            while (xPathStep3 != null && !xPathStep3._deep) {
                xPathStep3 = xPathStep3._next;
            }
            if (xPathStep._deep) {
                int i2 = 0;
                XPathStep xPathStep4 = xPathStep;
                int i3 = 0;
                while (xPathStep4 != xPathStep3 && xPathStep4._name != null && !xPathStep4.isWild() && !xPathStep4._attr) {
                    i3++;
                    xPathStep4 = xPathStep4._next;
                }
                int i4 = i3 + 1;
                Object[] objArr = new QName[i4];
                int[] iArr = new int[i4];
                XPathStep xPathStep5 = xPathStep;
                for (int i5 = 0; i5 < i3; i5++) {
                    objArr[i5] = xPathStep5._name;
                    xPathStep5 = xPathStep5._next;
                }
                objArr[i3] = getAnyQName();
                iArr[0] = -1;
                int i6 = 0;
                int i7 = -1;
                while (i6 < i3) {
                    while (i7 > -1 && !objArr[i6].equals(objArr[i7])) {
                        i7 = iArr[i7];
                    }
                    i6++;
                    i7++;
                    iArr[i6] = objArr[i6].equals(objArr[i7]) ? iArr[i7] : i7;
                }
                for (XPathStep xPathStep6 = xPathStep; xPathStep6 != xPathStep4; xPathStep6 = xPathStep6._next) {
                    xPathStep6._hasBacktrack = true;
                    xPathStep6._backtrack = xPathStep;
                    for (int i8 = iArr[i2]; i8 > 0; i8--) {
                        xPathStep6._backtrack = xPathStep6._backtrack._next;
                    }
                    i2++;
                }
                if (i3 > 1) {
                    xPathStep2 = xPathStep;
                    for (int i9 = iArr[i3 - 1]; i9 > 0; i9--) {
                        xPathStep2 = xPathStep2._next;
                    }
                } else {
                    xPathStep2 = xPathStep;
                }
                if (xPathStep4 != xPathStep3 && xPathStep4._attr) {
                    xPathStep4._hasBacktrack = true;
                    xPathStep4._backtrack = xPathStep2;
                    xPathStep4 = xPathStep4._next;
                }
                if (xPathStep4 != xPathStep3 && xPathStep4._name == null) {
                    xPathStep4._hasBacktrack = true;
                    xPathStep4._backtrack = xPathStep2;
                }
                xPathStep._hasBacktrack = true;
                xPathStep._backtrack = xPathStep;
            } else {
                while (xPathStep != xPathStep3) {
                    xPathStep._hasBacktrack = true;
                    xPathStep = xPathStep._next;
                }
            }
            xPathStep = xPathStep3;
        }
    }

    private QName getAnyQName() {
        return new QName("", "");
    }

    private XPath.XPathCompileException newError(String str) {
        return new XPath.XPathCompileException(XmlError.forLocation(str, 0, null, this._line, this._column, this._offset));
    }

    private boolean parseWhitespace() {
        boolean z = false;
        while (isWhitespace()) {
            advance();
            z = true;
        }
        return z;
    }

    private void processNonXpathDecls() {
    }

    private boolean tokenize(String... strArr) {
        int length = 0;
        for (String str : strArr) {
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str, length)) {
                return false;
            }
            length += str.length();
        }
        advance(length);
        return true;
    }

    private String tokenizeNCName() throws XPath.XPathCompileException {
        parseWhitespace();
        if (!isNCNameStart()) {
            throw newError("Expected non-colonized name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) currChar());
        while (true) {
            advance();
            if (!isNCName()) {
                return sb.toString();
            }
            sb.append((char) currChar());
        }
    }

    private void tokenizePath(ArrayList<XPathStep> arrayList) throws XPath.XPathCompileException {
        this._lastDeepDot = false;
        XPathStep xPathStep = tokenizeSteps();
        computeBacktrack(xPathStep);
        arrayList.add(xPathStep);
        if (this._lastDeepDot) {
            this._sawDeepDot = true;
            XPathStep xPathStepAddStep = null;
            while (xPathStep != null) {
                XPathStep xPathStep2 = xPathStep._next;
                xPathStepAddStep = addStep(xPathStep._deep, (xPathStep2 != null && xPathStep2._next == null) || xPathStep._attr, xPathStep._name, xPathStepAddStep);
                xPathStep = xPathStep._next;
            }
            computeBacktrack(xPathStepAddStep);
            arrayList.add(xPathStepAddStep);
        }
    }

    private QName tokenizeQName() throws XPath.XPathCompileException {
        if (tokenize("*")) {
            return getAnyQName();
        }
        String str = tokenizeNCName();
        if (tokenize(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            return new QName(lookupPrefix(str), tokenize("*") ? "" : tokenizeNCName());
        }
        return new QName(lookupPrefix(""), str);
    }

    private String tokenizeQuotedUri() throws XPath.XPathCompileException {
        int i2;
        if (tokenize("\"")) {
            i2 = 34;
        } else {
            if (!tokenize("'")) {
                throw newError("Expected quote (\" or ')");
            }
            i2 = 39;
        }
        StringBuilder sb = new StringBuilder();
        while (currChar() != -1) {
            if (currChar() == i2) {
                advance();
                if (currChar() != i2) {
                    return sb.toString();
                }
            }
            sb.append((char) currChar());
            advance();
        }
        throw newError("Path terminated in URI literal");
    }

    private XPath.Selector tokenizeSelector() throws XPath.XPathCompileException {
        ArrayList<XPathStep> arrayList = new ArrayList<>();
        tokenizePath(arrayList);
        while (tokenize("|")) {
            tokenizePath(arrayList);
        }
        return new XPath.Selector((XPathStep[]) arrayList.toArray(new XPathStep[0]));
    }

    private XPathStep tokenizeSteps() throws XPath.XPathCompileException {
        boolean z;
        if (tokenize("/")) {
            throw newError("Absolute paths unsupported");
        }
        if (tokenize("$", this._currentNodeVar, "//") || tokenize(".", "//")) {
            z = true;
        } else {
            if (!tokenize("$", this._currentNodeVar, "/") && !tokenize(".", "/") && (tokenize("$", this._currentNodeVar) || tokenize("."))) {
                return addStep(false, false, null, null);
            }
            z = false;
        }
        boolean z2 = false;
        XPathStep xPathStepAddStep = null;
        while (!tokenize("attribute", "::") && !tokenize("@")) {
            if (tokenize(".")) {
                z2 = z2 || z;
            } else {
                tokenize("child", "::");
                xPathStepAddStep = addStep(z, false, tokenizeQName(), xPathStepAddStep);
                z = false;
            }
            if (!tokenize("//")) {
                if (!tokenize("/")) {
                    break;
                }
                if (z2) {
                }
            } else {
                z2 = false;
            }
            z = true;
        }
        xPathStepAddStep = addStep(z, true, tokenizeQName(), xPathStepAddStep);
        this._lastDeepDot = z2;
        if (z2) {
            this._lastDeepDot = true;
            xPathStepAddStep = addStep(true, false, getAnyQName(), xPathStepAddStep);
        }
        return addStep(false, false, null, xPathStepAddStep);
    }

    private XPath tokenizeXPath() throws XPath.XPathCompileException {
        while (true) {
            if (tokenize("declare", "namespace")) {
                if (!parseWhitespace()) {
                    throw newError("Expected prefix after 'declare namespace'");
                }
                String str = tokenizeNCName();
                if (!tokenize("=")) {
                    throw newError("Expected '='");
                }
                String str2 = tokenizeQuotedUri();
                if (this._namespaces.containsKey(str)) {
                    throw newError("Redefinition of namespace prefix: " + str);
                }
                this._namespaces.put(str, str2);
                if (this._externalNamespaces.containsKey(str)) {
                    throw newError("Redefinition of namespace prefix: " + str);
                }
                this._externalNamespaces.put(str, str2);
                tokenize(";");
                this._externalNamespaces.put(XPath._NS_BOUNDARY, Integer.toString(this._offset));
            } else {
                if (!tokenize("declare", "default", "element", "namespace")) {
                    if (!this._namespaces.containsKey("")) {
                        this._namespaces.put("", "");
                    }
                    XPath.Selector selector = tokenizeSelector();
                    parseWhitespace();
                    if (currChar() == -1) {
                        return new XPath(selector, this._sawDeepDot);
                    }
                    throw newError("Unexpected char '" + ((char) currChar()) + "'");
                }
                String str3 = tokenizeQuotedUri();
                if (this._namespaces.containsKey("")) {
                    throw newError("Redefinition of default element namespace");
                }
                this._namespaces.put("", str3);
                if (this._externalNamespaces.containsKey(XPath._DEFAULT_ELT_NS)) {
                    throw newError("Redefinition of default element namespace : ");
                }
                this._externalNamespaces.put(XPath._DEFAULT_ELT_NS, str3);
                if (!tokenize(";")) {
                    throw newError("Default Namespace declaration must end with ;");
                }
                this._externalNamespaces.put(XPath._NS_BOUNDARY, Integer.toString(this._offset));
            }
        }
    }

    void advance() {
        if (this._offset < this._expr.length()) {
            char cCharAt = this._expr.charAt(this._offset);
            int i2 = this._offset + 1;
            this._offset = i2;
            this._column++;
            if (cCharAt == '\r' || cCharAt == '\n') {
                this._line++;
                this._column = 1;
                if (i2 + 1 < this._expr.length()) {
                    char cCharAt2 = this._expr.charAt(this._offset + 1);
                    if ((cCharAt2 == '\r' || cCharAt2 == '\n') && cCharAt != cCharAt2) {
                        this._offset++;
                    }
                }
            }
        }
    }

    XPath compile(String str) throws XPath.XPathCompileException {
        this._offset = 0;
        this._line = 1;
        this._column = 1;
        this._expr = str;
        return tokenizeXPath();
    }

    int currChar() {
        return currChar(0);
    }

    boolean isNCName() {
        return currChar() != -1 && XMLChar.isNCName(currChar());
    }

    boolean isNCNameStart() {
        return currChar() != -1 && XMLChar.isNCNameStart(currChar());
    }

    boolean isWhitespace() {
        return isWhitespace(0);
    }

    String lookupPrefix(String str) throws XPath.XPathCompileException {
        if (this._namespaces.containsKey(str)) {
            return this._namespaces.get(str);
        }
        if (this._externalNamespaces.containsKey(str)) {
            return this._externalNamespaces.get(str);
        }
        String str2 = str != null ? str : "";
        str2.hashCode();
        switch (str2) {
            case "fn":
                return "http://www.w3.org/2002/11/xquery-functions";
            case "xs":
                return "http://www.w3.org/2001/XMLSchema";
            case "xdt":
                return "http://www.w3.org/2003/11/xpath-datatypes";
            case "xml":
                return XMLConstants.XML_NS_URI;
            case "xsi":
                return "http://www.w3.org/2001/XMLSchema-instance";
            case "local":
                return "http://www.w3.org/2003/11/xquery-local-functions";
            default:
                throw newError("Undefined prefix: " + str);
        }
    }

    boolean startsWith(String str, int i2) {
        if (this._offset + i2 >= this._expr.length()) {
            return false;
        }
        return this._expr.startsWith(str, this._offset + i2);
    }

    int currChar(int i2) {
        if (this._offset + i2 >= this._expr.length()) {
            return -1;
        }
        return this._expr.charAt(this._offset + i2);
    }

    boolean isWhitespace(int i2) {
        int iCurrChar = currChar(i2);
        return iCurrChar == 32 || iCurrChar == 9 || iCurrChar == 10 || iCurrChar == 13;
    }

    void advance(int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            advance();
            i2 = i3;
        }
    }
}
