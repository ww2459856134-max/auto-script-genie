package com.fasterxml.aalto.stax;

import n.b.a.m.d;
import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public final class EventFactoryImpl extends d {
    protected QName createQName(String str, String str2) {
        return new QName(str, str2);
    }

    @Override // n.b.a.m.d
    protected QName createQName(String str, String str2, String str3) {
        return new QName(str, str2, str3);
    }
}
