package org.apache.xmlbeans.impl.xpath;

import org.apache.xmlbeans.impl.store.Cur;

/* loaded from: classes2.dex */
public interface XPathEngine {
    boolean next(Cur cur);

    void release();
}
