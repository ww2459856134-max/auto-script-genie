package k.x.j1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class m extends b {

    /* renamed from: o, reason: collision with root package name */
    private t f2136o;
    private int p;

    static {
        k.y.c.b(m.class);
    }

    m(String str, t tVar) throws w {
        super(tVar);
        this.f2136o = tVar;
        int iLastIndexOf = str.lastIndexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        k.y.a.a(iLastIndexOf != -1);
        str.substring(0, iLastIndexOf);
        String strSubstring = str.substring(iLastIndexOf + 1);
        int iIndexOf = str.indexOf(33);
        int iF = k.x.m.f(str.substring(iIndexOf + 1, iLastIndexOf));
        String strSubstring2 = str.substring(0, iIndexOf);
        strSubstring2.lastIndexOf(93);
        if (strSubstring2.charAt(0) == '\'' && strSubstring2.charAt(strSubstring2.length() - 1) == '\'') {
            strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
        }
        int iC = tVar.c(strSubstring2);
        this.p = iC;
        if (iC < 0) {
            throw new w(w.f2147h, strSubstring2);
        }
        m(this.p, iF, k.x.m.f(strSubstring), 0, 65535, true, true, true, true);
    }

    @Override // k.x.j1.b, k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        stringBuffer.append(Chars.QUOTE);
        stringBuffer.append(this.f2136o.a(this.p));
        stringBuffer.append(Chars.QUOTE);
        stringBuffer.append('!');
        k.x.m.g(j(), stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        k.x.m.g(k(), stringBuffer);
    }
}
