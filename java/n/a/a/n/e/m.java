package n.a.a.n.e;

import n.a.a.n.c.c1;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class m extends o {
    public m(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        if (i3 < i2 || i5 < i4) {
            throw new IllegalArgumentException("Invalid cell range, having lastRow < firstRow || lastCol < firstCol, had rows " + i3 + " >= " + i2 + " or cells " + i5 + " >= " + i4);
        }
    }

    public static m F(String str) {
        s sVar;
        s sVar2;
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            sVar2 = new s(str);
            sVar = sVar2;
        } else {
            s sVar3 = new s(str.substring(0, iIndexOf));
            sVar = new s(str.substring(iIndexOf + 1));
            sVar2 = sVar3;
        }
        return new m(sVar2.m(), sVar.m(), sVar2.l(), sVar.l());
    }

    public m C() {
        return new m(b(), k(), a(), g());
    }

    public String D() {
        return E(null, false);
    }

    public String E(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(c1.d(str));
            sb.append('!');
        }
        s sVar = new s(b(), a(), z, z);
        s sVar2 = new s(k(), g(), z, z);
        sb.append(sVar.g());
        if (!sVar.equals(sVar2) || v() || w()) {
            sb.append(NameUtil.COLON);
            sb.append(sVar2.g());
        }
        return sb.toString();
    }
}
