package k.x;

/* loaded from: classes.dex */
final class h implements b0 {
    public static h[] b;
    private int a;

    static {
        h[] hVarArr = new h[50];
        b = hVarArr;
        hVarArr[0] = new h("", 0);
        hVarArr[1] = new h("0", 1);
        hVarArr[2] = new h("0.00", 2);
        hVarArr[3] = new h("#,##0", 3);
        hVarArr[4] = new h("#,##0.00", 4);
        hVarArr[5] = new h("($#,##0_);($#,##0)", 5);
        hVarArr[6] = new h("($#,##0_);[Red]($#,##0)", 6);
        hVarArr[7] = new h("($#,##0_);[Red]($#,##0)", 7);
        hVarArr[8] = new h("($#,##0.00_);[Red]($#,##0.00)", 8);
        hVarArr[9] = new h("0%", 9);
        hVarArr[10] = new h("0.00%", 10);
        hVarArr[11] = new h("0.00E+00", 11);
        hVarArr[12] = new h("# ?/?", 12);
        hVarArr[13] = new h("# ??/??", 13);
        hVarArr[14] = new h("dd/mm/yyyy", 14);
        hVarArr[15] = new h("d-mmm-yy", 15);
        hVarArr[16] = new h("d-mmm", 16);
        hVarArr[17] = new h("mmm-yy", 17);
        hVarArr[18] = new h("h:mm AM/PM", 18);
        hVarArr[19] = new h("h:mm:ss AM/PM", 19);
        hVarArr[20] = new h("h:mm", 20);
        hVarArr[21] = new h("h:mm:ss", 21);
        hVarArr[22] = new h("m/d/yy h:mm", 22);
        hVarArr[37] = new h("(#,##0_);(#,##0)", 37);
        hVarArr[38] = new h("(#,##0_);[Red](#,##0)", 38);
        hVarArr[39] = new h("(#,##0.00_);(#,##0.00)", 39);
        hVarArr[40] = new h("(#,##0.00_);[Red](#,##0.00)", 40);
        hVarArr[41] = new h("_(*#,##0_);_(*(#,##0);_(*\"-\"_);(@_)", 41);
        hVarArr[42] = new h("_($*#,##0_);_($*(#,##0);_($*\"-\"_);(@_)", 42);
        hVarArr[43] = new h("_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);(@_)", 43);
        hVarArr[44] = new h("_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);(@_)", 44);
        hVarArr[45] = new h("mm:ss", 45);
        hVarArr[46] = new h("[h]mm:ss", 46);
        hVarArr[47] = new h("mm:ss.0", 47);
        hVarArr[48] = new h("##0.0E+0", 48);
        hVarArr[49] = new h("@", 49);
    }

    private h(String str, int i2) {
        this.a = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof h) && this.a == ((h) obj).a;
    }

    @Override // k.x.b0
    public void f(int i2) {
    }

    @Override // k.x.b0
    public boolean isInitialized() {
        return true;
    }

    @Override // k.x.b0
    public int m() {
        return this.a;
    }

    @Override // k.x.b0
    public boolean r() {
        return true;
    }
}
