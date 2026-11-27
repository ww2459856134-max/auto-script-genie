package n.a.a.n.c.u1;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;

/* loaded from: classes.dex */
public final class u2 extends y2 {
    public static final u2 d = new u2();

    private u2() {
    }

    @Override // n.a.a.n.c.u1.k2
    public byte k() {
        return (byte) 4;
    }

    @Override // n.a.a.n.c.u1.g2
    public int p() {
        return 2;
    }

    @Override // n.a.a.n.c.u1.g2
    public String q(String[] strArr) {
        return strArr[0] + ProcessIdUtil.DEFAULT_PROCESSID + strArr[1];
    }
}
