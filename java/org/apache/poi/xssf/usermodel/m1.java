package org.apache.poi.xssf.usermodel;

/* loaded from: classes.dex */
class m1 {
    private final int a;
    private final int b;
    private int c = -1;

    protected m1(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.a == m1Var.a && this.b == m1Var.b;
    }

    public int hashCode() {
        if (this.c == -1) {
            this.c = ((this.a + 629) * 37) + this.b;
        }
        return this.c;
    }
}
