package k.x.j1;

/* loaded from: classes.dex */
public class u {
    private static u[] c = new u[0];
    public static final u d = new u(255, "?");
    public static final u e;
    public static final u f;
    public static final u g;
    private int a;
    private String b;

    static {
        new u(0, "#NULL!");
        e = new u(7, "#DIV/0!");
        f = new u(15, "#VALUE!");
        g = new u(23, "#REF!");
        new u(29, "#NAME?");
        new u(36, "#NUM!");
        new u(42, "#N/A!");
    }

    u(int i2, String str) {
        this.a = i2;
        this.b = str;
        u[] uVarArr = c;
        u[] uVarArr2 = new u[uVarArr.length + 1];
        System.arraycopy(uVarArr, 0, uVarArr2, 0, uVarArr.length);
        uVarArr2[c.length] = this;
        c = uVarArr2;
    }

    public static u c(int i2) {
        u uVar = d;
        int i3 = 0;
        boolean z = false;
        while (true) {
            u[] uVarArr = c;
            if (i3 >= uVarArr.length || z) {
                break;
            }
            if (uVarArr[i3].a == i2) {
                uVar = uVarArr[i3];
                z = true;
            }
            i3++;
        }
        return uVar;
    }

    public static u d(String str) {
        u uVar = d;
        if (str != null && str.length() != 0) {
            int i2 = 0;
            boolean z = false;
            while (true) {
                u[] uVarArr = c;
                if (i2 >= uVarArr.length || z) {
                    break;
                }
                if (uVarArr[i2].b.equals(str)) {
                    uVar = c[i2];
                    z = true;
                }
                i2++;
            }
        }
        return uVar;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
