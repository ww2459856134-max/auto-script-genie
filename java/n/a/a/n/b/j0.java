package n.a.a.n.b;

import java.util.Locale;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public class j0 extends b0 {
    static final b0 e = new j0("@");
    private final int[] c;
    private final String d;

    public j0(String str) {
        super(str);
        final int[] iArr = new int[1];
        String string = t.m(str, a0.g, new s() { // from class: n.a.a.n.b.b
            @Override // n.a.a.n.b.s
            public final String a(Matcher matcher, String str2, a0 a0Var, StringBuffer stringBuffer) {
                return j0.f(iArr, matcher, str2, a0Var, stringBuffer);
            }
        }).toString();
        this.d = string;
        this.c = new int[iArr[0]];
        int length = string.length() - 1;
        int i2 = 0;
        while (true) {
            int[] iArr2 = this.c;
            if (i2 >= iArr2.length) {
                return;
            }
            iArr2[i2] = this.d.lastIndexOf(0, length);
            length = this.c[i2] - 1;
            i2++;
        }
    }

    static /* synthetic */ String f(int[] iArr, Matcher matcher, String str, a0 a0Var, StringBuffer stringBuffer) {
        if (!str.equals("@")) {
            return null;
        }
        iArr[0] = iArr[0] + 1;
        return "\u0000";
    }

    @Override // n.a.a.n.b.b0
    public void b(StringBuffer stringBuffer, Object obj) {
        int length = stringBuffer.length();
        String string = obj.toString();
        if (obj instanceof Boolean) {
            string = string.toUpperCase(Locale.ROOT);
        }
        stringBuffer.append(this.d);
        for (int i2 : this.c) {
            int i3 = i2 + length;
            stringBuffer.replace(i3, i3 + 1, string);
        }
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        e.b(stringBuffer, obj);
    }
}
