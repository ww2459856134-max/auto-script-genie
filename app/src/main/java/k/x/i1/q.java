package k.x.i1;

/* loaded from: classes.dex */
public class q {
    private static q[] b = new q[0];
    private int a;

    q(int i2) {
        this.a = i2;
        q[] qVarArr = b;
        q[] qVarArr2 = new q[qVarArr.length + 1];
        b = qVarArr2;
        System.arraycopy(qVarArr, 0, qVarArr2, 0, qVarArr.length);
        b[qVarArr.length] = this;
    }

    static q a(int i2) {
        q qVar = s.v;
        int i3 = 0;
        while (true) {
            q[] qVarArr = b;
            if (i3 >= qVarArr.length) {
                return qVar;
            }
            if (qVarArr[i3].b() == i2) {
                return b[i3];
            }
            i3++;
        }
    }

    int b() {
        return this.a;
    }
}
