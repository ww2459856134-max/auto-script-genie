package k.z;

/* loaded from: classes.dex */
public final class j {
    private static j[] b = new j[90];
    public static final j c;
    private int a;

    static {
        new j(0);
        new j(1);
        new j(2);
        new j(3);
        new j(4);
        new j(5);
        new j(6);
        new j(7);
        new j(8);
        c = new j(9);
        new j(10);
        new j(11);
        new j(12);
        new j(13);
        new j(14);
        new j(15);
        new j(16);
        new j(17);
        new j(18);
        new j(19);
        new j(20);
        new j(21);
        new j(22);
        new j(23);
        new j(24);
        new j(25);
        new j(26);
        new j(27);
        new j(28);
        new j(29);
        new j(30);
        new j(31);
        new j(32);
        new j(33);
        new j(34);
        new j(35);
        new j(36);
        new j(37);
        new j(38);
        new j(39);
        new j(40);
        new j(41);
        new j(42);
        new j(43);
        new j(44);
        new j(45);
        new j(46);
        new j(47);
        new j(50);
        new j(51);
        new j(52);
        new j(53);
        new j(54);
        new j(55);
        new j(56);
        new j(57);
        new j(58);
        new j(59);
        new j(60);
        new j(61);
        new j(62);
        new j(63);
        new j(64);
        new j(65);
        new j(66);
        new j(67);
        new j(68);
        new j(69);
        new j(70);
        new j(75);
        new j(76);
        new j(77);
        new j(78);
        new j(79);
        new j(80);
        new j(81);
        new j(82);
        new j(83);
        new j(88);
        new j(89);
    }

    private j(int i2, boolean z) {
        this.a = i2;
        j[] jVarArr = b;
        if (i2 >= jVarArr.length && z) {
            j[] jVarArr2 = new j[i2 + 1];
            System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            b = jVarArr2;
        }
        j[] jVarArr3 = b;
        if (i2 < jVarArr3.length) {
            jVarArr3[i2] = this;
        }
    }

    public static j a(int i2) {
        j[] jVarArr = b;
        j jVar = i2 > jVarArr.length + (-1) ? null : jVarArr[i2];
        return jVar == null ? new j(i2, false) : jVar;
    }

    public int b() {
        return this.a;
    }

    private j(int i2) {
        this(i2, true);
    }
}
