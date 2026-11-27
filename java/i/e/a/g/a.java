package i.e.a.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* loaded from: classes.dex */
public final class a {
    final int a;
    String[] b;
    int c;

    private a(int i2, String[] strArr) {
        this.c = i2;
        this.a = i2;
        this.b = strArr;
    }

    public static a d() {
        String[] strArr = new String[32];
        strArr[0] = "xml";
        strArr[1] = XMLConstants.XML_NS_URI;
        strArr[2] = "xmlns";
        strArr[3] = "http://www.w3.org/2000/xmlns/";
        return new a(4, strArr);
    }

    public String a(String str, NamespaceContext namespaceContext, String str2, int[] iArr) {
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
                    String str3 = strArr[i3];
                    if (str3 == strIntern || (str3.hashCode() == iHashCode && str3.equals(strIntern))) {
                        break;
                    }
                    i3 -= 2;
                } else if (namespaceContext == null || namespaceContext.getNamespaceURI(strIntern) == null) {
                    break;
                }
            }
        }
        iArr[0] = i2;
        if (this.c >= strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, strArr.length << 1);
            this.b = strArr;
        }
        int i4 = this.c;
        int i5 = i4 + 1;
        this.c = i5;
        strArr[i4] = strIntern;
        this.c = i5 + 1;
        strArr[i5] = str2;
        return strIntern;
    }

    public String b(String str, String str2) {
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

    public a c() {
        return new a(this.c, this.b);
    }

    public String e(String str) {
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

    public String f(String str) {
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
}
