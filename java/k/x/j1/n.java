package k.x.j1;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class n extends c {
    static {
        k.y.c.b(n.class);
    }

    n(String str) {
        int iIndexOf = str.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        k.y.a.a(iIndexOf != -1);
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        m(k.x.m.f(strSubstring), k.x.m.f(strSubstring2), 0, 65535, k.x.m.j(strSubstring), k.x.m.j(strSubstring2), false, false);
    }

    @Override // k.x.j1.c, k.x.j1.t0
    public void c(StringBuffer stringBuffer) {
        k.x.m.g(j(), stringBuffer);
        stringBuffer.append(NameUtil.COLON);
        k.x.m.g(k(), stringBuffer);
    }
}
