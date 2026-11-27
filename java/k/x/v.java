package k.x;

/* loaded from: classes.dex */
public class v {
    private static v[] b = new v[0];
    private int a;

    v(int i2) {
        this.a = i2;
        v[] vVarArr = b;
        v[] vVarArr2 = new v[vVarArr.length + 1];
        b = vVarArr2;
        System.arraycopy(vVarArr, 0, vVarArr2, 0, vVarArr.length);
        b[vVarArr.length] = this;
    }

    static v a(int i2) {
        v vVar = null;
        int i3 = 0;
        while (true) {
            v[] vVarArr = b;
            if (i3 >= vVarArr.length || vVar != null) {
                break;
            }
            if (vVarArr[i3].a == i2) {
                vVar = vVarArr[i3];
            }
            i3++;
        }
        return vVar;
    }

    public int b() {
        return this.a;
    }
}
