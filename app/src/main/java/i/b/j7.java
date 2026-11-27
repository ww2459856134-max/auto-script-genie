package i.b;

/* loaded from: classes.dex */
public class j7 {
    private static j7 a;

    public static synchronized j7 a() {
        j7 j7Var;
        j7Var = a;
        if (j7Var == null) {
            j7Var = new j7();
            a = j7Var;
        }
        return j7Var;
    }

    public int b() {
        return com.frame.n0.c("tbminibt", 0);
    }

    public String c() {
        return com.frame.n0.f("tbSize1", "custom");
    }

    public boolean d() {
        return com.frame.n0.a("tbHideBtn", false);
    }

    public boolean e() {
        return com.frame.n0.a("tbHideBorder", true);
    }

    public boolean f() {
        return b() != 2;
    }

    public boolean g() {
        return com.frame.n0.a("tbmini", false);
    }

    public void h(boolean z) {
        com.frame.n0.g("tbHideBorder", z);
    }

    public void i(int i2) {
        com.frame.n0.i("tbminibt", i2);
    }

    public void j(boolean z) {
        com.frame.n0.g("tbHideBtn", z);
    }

    public void k(String str) {
        com.frame.n0.k("tbSize1", str);
    }

    public void l(boolean z) {
        com.frame.n0.g("tbmini", z);
    }
}
