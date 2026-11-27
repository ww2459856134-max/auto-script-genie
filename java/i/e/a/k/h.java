package i.e.a.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* loaded from: classes.dex */
final class h {
    final int a;
    String[] b;
    int c;

    private h(int i2, String[] strArr) {
        this.c = i2;
        this.a = i2;
        this.b = strArr;
    }

    public static h c() {
        String[] strArr = new String[32];
        strArr[0] = "xml";
        strArr[1] = XMLConstants.XML_NS_URI;
        strArr[2] = "xmlns";
        strArr[3] = "http://www.w3.org/2000/xmlns/";
        return new h(4, strArr);
    }

    String a(String str, String str2) {
        String[] strArr = this.b;
        int iHashCode = str.hashCode();
        int i2 = this.c;
        for (int i3 = this.a; i3 < i2; i3 += 2) {
            String str3 = strArr[i3];
            if (str3 == str || (str3.hashCode() == iHashCode && str3.equals(str))) {
                int i4 = i3 + 1;
                String str4 = strArr[i4];
                strArr[i4] = str2;
                return str4;
            }
        }
        if (this.c >= strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length << 1);
            this.b = strArr;
        }
        int i5 = this.c;
        int i6 = i5 + 1;
        this.c = i6;
        strArr[i5] = str;
        this.c = i6 + 1;
        strArr[i6] = str2;
        return null;
    }

    public h b() {
        return new h(this.c, this.b);
    }

    public String d(String str) {
        String[] strArr = this.b;
        int iHashCode = str.hashCode();
        for (int i2 = this.c - 1; i2 > 0; i2 -= 2) {
            String str2 = strArr[i2];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i3 = i2 - 1;
                String str3 = strArr[i3];
                if (i2 < this.a) {
                    int iHashCode2 = str3.hashCode();
                    int i4 = this.c;
                    while (i3 < i4) {
                        String str4 = strArr[i2];
                        if (str4 == str3 || (str4.hashCode() == iHashCode2 && str4.equals(str3))) {
                            break;
                        }
                        i3 += 2;
                    }
                }
                return str3;
            }
        }
        return null;
    }

    public String e(String str) {
        String[] strArr = this.b;
        int iHashCode = str.hashCode();
        for (int i2 = this.c - 2; i2 >= 0; i2 -= 2) {
            String str2 = strArr[i2];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                return strArr[i2 + 1];
            }
        }
        return null;
    }

    String f(String str, NamespaceContext namespaceContext, int[] iArr) {
        String strIntern;
        String[] strArr = this.b;
        int i2 = iArr[0];
        while (true) {
            strIntern = (str + i2).intern();
            i2++;
            int iHashCode = strIntern.hashCode();
            int i3 = this.c + (-2);
            while (true) {
                if (i3 >= 0) {
                    String str2 = strArr[i3];
                    if (str2 == strIntern || (str2.hashCode() == iHashCode && str2.equals(strIntern))) {
                        break;
                    }
                    i3 -= 2;
                } else if (namespaceContext == null || namespaceContext.getNamespaceURI(strIntern) == null) {
                    break;
                }
            }
        }
        iArr[0] = i2;
        return strIntern;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> g(String str, List<String> list) {
        String[] strArr = this.b;
        int iHashCode = str.hashCode();
        for (int i2 = this.c - 1; i2 > 0; i2 -= 2) {
            String str2 = strArr[i2];
            if (str2 == str || (str2.hashCode() == iHashCode && str2.equals(str))) {
                int i3 = i2 - 1;
                String str3 = strArr[i3];
                if (i2 < this.a) {
                    int iHashCode2 = str3.hashCode();
                    int i4 = this.c;
                    while (i3 < i4) {
                        String str4 = strArr[i2];
                        if (str4 == str3 || (str4.hashCode() == iHashCode2 && str4.equals(str3))) {
                            break;
                        }
                        i3 += 2;
                    }
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(str3);
                } else {
                    if (list == null) {
                    }
                    list.add(str3);
                }
            }
        }
        return list;
    }

    public int h() {
        return (this.c - this.a) >> 1;
    }

    public int i() {
        return this.c >> 1;
    }

    public String toString() {
        return "[" + h.class.toString() + "; " + i() + " entries; of which " + h() + " local]";
    }
}
