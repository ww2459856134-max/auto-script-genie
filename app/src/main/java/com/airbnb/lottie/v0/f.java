package com.airbnb.lottie.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class f {
    private final List<String> a;
    private g b;

    public f(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        return this.a.get(r0.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public f a(String str) {
        f fVar = new f(this);
        fVar.a.add(str);
        return fVar;
    }

    public boolean c(String str, int i2) {
        if (i2 >= this.a.size()) {
            return false;
        }
        boolean z = i2 == this.a.size() - 1;
        String str2 = this.a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.a.get(i2 + 1).equals(str)) {
            return i2 == this.a.size() + (-2) || (i2 == this.a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.a.size() - 1) {
            return false;
        }
        return this.a.get(i3).equals(str);
    }

    public g d() {
        return this.b;
    }

    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (this.a.get(i2).equals("**")) {
            return (i2 != this.a.size() - 1 && this.a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean g(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.a.size()) {
            return false;
        }
        return this.a.get(i2).equals(str) || this.a.get(i2).equals("**") || this.a.get(i2).equals("*");
    }

    public boolean h(String str, int i2) {
        return "__container".equals(str) || i2 < this.a.size() - 1 || this.a.get(i2).equals("**");
    }

    public f i(g gVar) {
        f fVar = new f(this);
        fVar.b = gVar;
        return fVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    private f(f fVar) {
        this.a = new ArrayList(fVar.a);
        this.b = fVar.b;
    }
}
