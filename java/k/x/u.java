package k.x;

/* loaded from: classes.dex */
public class u {
    private static u[] b = new u[0];
    private int a;

    u(int i2, String str) {
        this.a = i2;
        u[] uVarArr = b;
        u[] uVarArr2 = new u[uVarArr.length + 1];
        b = uVarArr2;
        System.arraycopy(uVarArr, 0, uVarArr2, 0, uVarArr.length);
        b[uVarArr.length] = this;
    }

    static u a(int i2) {
        u uVar = null;
        int i3 = 0;
        while (true) {
            u[] uVarArr = b;
            if (i3 >= uVarArr.length || uVar != null) {
                break;
            }
            if (uVarArr[i3].a == i2) {
                uVar = uVarArr[i3];
            }
            i3++;
        }
        return uVar;
    }

    public int b() {
        return this.a;
    }
}
