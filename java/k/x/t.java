package k.x;

import java.text.MessageFormat;

/* loaded from: classes.dex */
public class t {
    private static t[] b = new t[0];
    private int a;

    t(int i2, String str) {
        this.a = i2;
        new MessageFormat(str);
        t[] tVarArr = b;
        t[] tVarArr2 = new t[tVarArr.length + 1];
        b = tVarArr2;
        System.arraycopy(tVarArr, 0, tVarArr2, 0, tVarArr.length);
        b[tVarArr.length] = this;
    }

    static t a(int i2) {
        t tVar = null;
        int i3 = 0;
        while (true) {
            t[] tVarArr = b;
            if (i3 >= tVarArr.length || tVar != null) {
                break;
            }
            if (tVarArr[i3].a == i2) {
                tVar = tVarArr[i3];
            }
            i3++;
        }
        return tVar;
    }

    public int b() {
        return this.a;
    }
}
