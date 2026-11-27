package org.apache.xmlbeans.impl.store;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public interface QNameFactory {
    QName getQName(String str, String str2);

    QName getQName(String str, String str2, String str3);

    QName getQName(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5);

    QName getQName(char[] cArr, int i2, int i3, char[] cArr2, int i4, int i5, char[] cArr3, int i6, int i7);
}
