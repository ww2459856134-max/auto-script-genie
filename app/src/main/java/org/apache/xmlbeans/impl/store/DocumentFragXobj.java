package org.apache.xmlbeans.impl.store;

import org.w3c.dom.DocumentFragment;

/* loaded from: classes.dex */
class DocumentFragXobj extends NodeXobj implements DocumentFragment {
    DocumentFragXobj(Locale locale) {
        super(locale, 1, 11);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale locale) {
        return new DocumentFragXobj(locale);
    }
}
