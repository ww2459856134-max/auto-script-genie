package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Supplier {
    public final /* synthetic */ DownloadedSchemaEntryImpl a;

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.a.sizeOfSchemaLocationArray());
    }
}
