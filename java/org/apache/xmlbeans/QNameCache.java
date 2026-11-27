package org.apache.xmlbeans;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public final class QNameCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final float DEFAULT_LOAD = 0.7f;
    private int hashmask;
    private final float loadFactor;
    private int numEntries;
    private QName[] table;
    private int threshold;

    public QNameCache(int i2, float f) {
        this.numEntries = 0;
        int i3 = 16;
        while (i3 < i2) {
            i3 <<= 1;
        }
        this.loadFactor = f;
        this.hashmask = i3 - 1;
        this.threshold = (int) (i3 * f);
        this.table = new QName[i3];
    }

    private static boolean equals(QName qName, String str, String str2, String str3) {
        return qName.getLocalPart().equals(str2) && qName.getNamespaceURI().equals(str) && qName.getPrefix().equals(str3);
    }

    private static int hash(String str, String str2, String str3) {
        return (str3.hashCode() << 10) + 0 + (str.hashCode() << 5) + str2.hashCode();
    }

    private void rehash() {
        int i2;
        int length = this.table.length * 2;
        QName[] qNameArr = new QName[length];
        int i3 = length - 1;
        int i4 = 0;
        while (true) {
            QName[] qNameArr2 = this.table;
            if (i4 >= qNameArr2.length) {
                this.table = qNameArr;
                this.hashmask = i3;
                this.threshold = (int) (length * this.loadFactor);
                return;
            }
            QName qName = qNameArr2[i4];
            if (qName != null) {
                int iHash = hash(qName.getNamespaceURI(), qName.getLocalPart(), qName.getPrefix());
                while (true) {
                    i2 = iHash & i3;
                    if (qNameArr[i2] == null) {
                        break;
                    } else {
                        iHash = i2 - 1;
                    }
                }
                qNameArr[i2] = qName;
            }
            i4++;
        }
    }

    public QName getName(String str, String str2) {
        return getName(str, str2, "");
    }

    public QName getName(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        int iHash = hash(str, str2, str3);
        int i2 = this.hashmask;
        while (true) {
            int i3 = iHash & i2;
            QName qName = this.table[i3];
            if (qName == null) {
                int i4 = this.numEntries + 1;
                this.numEntries = i4;
                if (i4 >= this.threshold) {
                    rehash();
                }
                QName[] qNameArr = this.table;
                QName qName2 = new QName(str, str2, str3);
                qNameArr[i3] = qName2;
                return qName2;
            }
            if (equals(qName, str, str2, str3)) {
                return qName;
            }
            iHash = i3 - 1;
            i2 = this.hashmask;
        }
    }

    public QNameCache(int i2) {
        this(i2, DEFAULT_LOAD);
    }
}
