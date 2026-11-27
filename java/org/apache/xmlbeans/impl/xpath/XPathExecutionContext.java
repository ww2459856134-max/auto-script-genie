package org.apache.xmlbeans.impl.xpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes2.dex */
public class XPathExecutionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ATTRS = 4;
    public static final int DESCEND = 2;
    public static final int HIT = 1;
    private PathContext[] _paths;
    private final ArrayList<QName> _stack = new ArrayList<>();
    private XPath _xpath;

    /* JADX INFO: Access modifiers changed from: private */
    final class PathContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private XPathStep _curr;
        private final List<XPathStep> _prev;

        private PathContext() {
            this._prev = new ArrayList();
        }

        private void backtrack() {
            XPathStep xPathStep = this._curr;
            if (xPathStep._hasBacktrack) {
                this._curr = xPathStep._backtrack;
                return;
            }
            this._curr = xPathStep._prev;
            while (true) {
                XPathStep xPathStep2 = this._curr;
                if (xPathStep2._deep) {
                    return;
                }
                int i2 = 0;
                while (!xPathStep2._deep) {
                    int i3 = i2 + 1;
                    if (!xPathStep2.match(top(i2))) {
                        break;
                    }
                    xPathStep2 = xPathStep2._prev;
                    i2 = i3;
                }
                return;
                this._curr = this._curr._prev;
            }
        }

        private QName top(int i2) {
            return (QName) XPathExecutionContext.this._stack.get((XPathExecutionContext.this._stack.size() - 1) - i2);
        }

        boolean attr(QName qName) {
            XPathStep xPathStep = this._curr;
            return xPathStep != null && xPathStep._attr && xPathStep.match(qName);
        }

        int element(QName qName) {
            this._prev.add(this._curr);
            XPathStep xPathStep = this._curr;
            if (xPathStep == null) {
                return 0;
            }
            if (!xPathStep._attr && xPathStep.match(qName)) {
                XPathStep xPathStep2 = this._curr._next;
                this._curr = xPathStep2;
                if (xPathStep2._name != null) {
                    return xPathStep2._flags;
                }
                backtrack();
                XPathStep xPathStep3 = this._curr;
                if (xPathStep3 == null) {
                    return 1;
                }
                return 1 | xPathStep3._flags;
            }
            while (true) {
                backtrack();
                XPathStep xPathStep4 = this._curr;
                if (xPathStep4 == null) {
                    return 0;
                }
                if (xPathStep4.match(qName)) {
                    this._curr = this._curr._next;
                    break;
                }
                if (this._curr._deep) {
                    break;
                }
            }
            return this._curr._flags;
        }

        void end() {
            this._curr = this._prev.remove(r0.size() - 1);
        }

        void init(XPathStep xPathStep) {
            this._curr = xPathStep;
            this._prev.clear();
        }

        int start() {
            XPathStep xPathStep = this._curr;
            if (xPathStep._name != null) {
                return xPathStep._flags;
            }
            this._curr = null;
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ PathContext b(int i2) {
        return new PathContext();
    }

    public final boolean attr(QName qName) {
        boolean zAttr = false;
        for (PathContext pathContext : this._paths) {
            zAttr |= pathContext.attr(qName);
        }
        return zAttr;
    }

    public final int element(QName qName) {
        this._stack.add(qName);
        int iElement = 0;
        for (PathContext pathContext : this._paths) {
            iElement |= pathContext.element(qName);
        }
        return iElement;
    }

    public final void end() {
        this._stack.remove(r0.size() - 1);
        for (PathContext pathContext : this._paths) {
            pathContext.end();
        }
    }

    public final void init(XPath xPath) {
        if (this._xpath != xPath) {
            this._xpath = xPath;
            PathContext[] pathContextArr = new PathContext[xPath._selector._paths.length];
            this._paths = pathContextArr;
            Arrays.setAll(pathContextArr, new IntFunction() { // from class: org.apache.xmlbeans.impl.xpath.a
                @Override // java.util.function.IntFunction
                public final Object apply(int i2) {
                    return this.a.b(i2);
                }
            });
        }
        this._stack.clear();
        int i2 = 0;
        while (true) {
            PathContext[] pathContextArr2 = this._paths;
            if (i2 >= pathContextArr2.length) {
                return;
            }
            pathContextArr2[i2].init(xPath._selector._paths[i2]);
            i2++;
        }
    }

    public final int start() {
        int iStart = 0;
        for (PathContext pathContext : this._paths) {
            iStart |= pathContext.start();
        }
        return iStart;
    }
}
