package org.apache.xmlbeans.impl.values;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.xml.stream.StartElement;

/* loaded from: classes2.dex */
public class NamespaceContext implements PrefixResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAP = 3;
    private static final int RESOLVER = 5;
    private static final int START_ELEMENT = 4;
    private static final int TYPE_STORE = 1;
    private static final int XML_OBJECT = 2;
    private static ThreadLocal tl_namespaceContextStack = new ThreadLocal();
    private int _code = 3;
    private Object _obj;

    private static final class NamespaceContextStack {
        NamespaceContext current;
        ArrayList<NamespaceContext> stack;

        private NamespaceContextStack() {
            this.stack = new ArrayList<>();
        }

        final void pop() {
            this.current = this.stack.get(r0.size() - 1);
            this.stack.remove(r0.size() - 1);
        }

        final void push(NamespaceContext namespaceContext) {
            this.stack.add(this.current);
            this.current = namespaceContext;
        }
    }

    public NamespaceContext(Map map) {
        this._obj = map;
    }

    public static void clearThreadLocals() {
        tl_namespaceContextStack.remove();
    }

    public static PrefixResolver getCurrent() {
        return getNamespaceContextStack().current;
    }

    private static NamespaceContextStack getNamespaceContextStack() {
        NamespaceContextStack namespaceContextStack = (NamespaceContextStack) tl_namespaceContextStack.get();
        if (namespaceContextStack != null) {
            return namespaceContextStack;
        }
        NamespaceContextStack namespaceContextStack2 = new NamespaceContextStack();
        tl_namespaceContextStack.set(namespaceContextStack2);
        return namespaceContextStack2;
    }

    public static void pop() {
        NamespaceContextStack namespaceContextStack = getNamespaceContextStack();
        namespaceContextStack.pop();
        if (namespaceContextStack.stack.size() == 0) {
            tl_namespaceContextStack.set(null);
        }
    }

    public static void push(NamespaceContext namespaceContext) {
        getNamespaceContextStack().push(namespaceContext);
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) throws IllegalArgumentException {
        if (str != null && str.equals("xml")) {
            return XMLConstants.XML_NS_URI;
        }
        int i2 = this._code;
        if (i2 == 1) {
            return ((TypeStore) this._obj).getNamespaceForPrefix(str);
        }
        if (i2 == 2) {
            Object invocationHandler = this._obj;
            if (Proxy.isProxyClass(invocationHandler.getClass())) {
                invocationHandler = Proxy.getInvocationHandler(invocationHandler);
            }
            if (invocationHandler instanceof TypeStoreUser) {
                return ((TypeStoreUser) invocationHandler).get_store().getNamespaceForPrefix(str);
            }
            XmlCursor xmlCursorNewCursor = ((XmlObject) this._obj).newCursor();
            if (xmlCursorNewCursor != null) {
                try {
                    if (xmlCursorNewCursor.currentTokenType() == XmlCursor.TokenType.ATTR) {
                        xmlCursorNewCursor.toParent();
                    }
                    String strNamespaceForPrefix = xmlCursorNewCursor.namespaceForPrefix(str);
                    if (xmlCursorNewCursor != null) {
                        xmlCursorNewCursor.close();
                    }
                    return strNamespaceForPrefix;
                } finally {
                }
            } else if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
        } else if (i2 != 3) {
            if (i2 == 4) {
                return ((StartElement) this._obj).getNamespaceUri(str);
            }
            if (i2 != 5) {
                return null;
            }
            return ((PrefixResolver) this._obj).getNamespaceForPrefix(str);
        }
        return (String) ((Map) this._obj).get(str);
    }

    public NamespaceContext(TypeStore typeStore) {
        this._obj = typeStore;
    }

    public NamespaceContext(XmlObject xmlObject) {
        this._obj = xmlObject;
    }

    public NamespaceContext(StartElement startElement) {
        this._obj = startElement;
    }

    public NamespaceContext(PrefixResolver prefixResolver) {
        this._obj = prefixResolver;
    }
}
