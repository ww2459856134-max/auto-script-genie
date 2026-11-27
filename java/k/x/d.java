package k.x;

/* loaded from: classes.dex */
public class d {
    private static d[] a = new d[0];

    d(t tVar) {
        d[] dVarArr = a;
        d[] dVarArr2 = new d[dVarArr.length + 1];
        a = dVarArr2;
        System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
        a[dVarArr.length] = this;
    }
}
