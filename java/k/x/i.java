package k.x;

/* loaded from: classes.dex */
public class i {
    private static i[] c = new i[0];
    public static final i d;
    public static final i e;
    public static final i f;
    private String a;
    private int b;

    static {
        new i("Consolidate_Area", 0);
        new i("Auto_Open", 1);
        new i("Auto_Open", 2);
        new i("Extract", 3);
        new i("Database", 4);
        new i("Criteria", 5);
        d = new i("Print_Area", 6);
        e = new i("Print_Titles", 7);
        new i("Recorder", 8);
        new i("Data_Form", 9);
        new i("Auto_Activate", 10);
        new i("Auto_Deactivate", 11);
        new i("Sheet_Title", 11);
        f = new i("_FilterDatabase", 13);
    }

    private i(String str, int i2) {
        this.a = str;
        this.b = i2;
        i[] iVarArr = c;
        i[] iVarArr2 = new i[iVarArr.length + 1];
        c = iVarArr2;
        System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
        c[iVarArr.length] = this;
    }

    public static i a(int i2) {
        i iVar = f;
        int i3 = 0;
        while (true) {
            i[] iVarArr = c;
            if (i3 >= iVarArr.length) {
                return iVar;
            }
            if (iVarArr[i3].c() == i2) {
                iVar = c[i3];
            }
            i3++;
        }
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }
}
