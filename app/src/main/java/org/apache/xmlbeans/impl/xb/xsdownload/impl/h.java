package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Consumer {
    public final /* synthetic */ DownloadedSchemaEntryImpl a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.a.removeSchemaLocation(((Integer) obj).intValue());
    }
}
