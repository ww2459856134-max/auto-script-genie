package n.a.a.g.a;

/* loaded from: classes.dex */
public enum a {
    BLACK(8, -1, 0),
    BROWN(60, -1, 10040064),
    OLIVE_GREEN(59, -1, 3355392),
    DARK_GREEN(58, -1, 13056),
    DARK_TEAL(56, -1, 13158),
    DARK_BLUE(18, 32, 128),
    INDIGO(62, -1, 3355545),
    GREY_80_PERCENT(63, -1, 3355443),
    ORANGE(53, -1, 16737792),
    DARK_YELLOW(19, -1, 8421376),
    GREEN(17, -1, 32768),
    TEAL(21, 38, 32896),
    BLUE(12, 39, 255),
    BLUE_GREY(54, -1, 6710937),
    GREY_50_PERCENT(23, -1, 8421504),
    RED(10, -1, 16711680),
    LIGHT_ORANGE(52, -1, 16750848),
    LIME(50, -1, 10079232),
    SEA_GREEN(57, -1, 3381606),
    AQUA(49, -1, 3394764),
    LIGHT_BLUE(48, -1, 3368703),
    VIOLET(20, 36, 8388736),
    GREY_40_PERCENT(55, -1, 9868950),
    PINK(14, 33, 16711935),
    GOLD(51, -1, 16763904),
    YELLOW(13, 34, 16776960),
    BRIGHT_GREEN(11, -1, 65280),
    TURQUOISE(15, 35, 65535),
    DARK_RED(16, 37, 8388608),
    SKY_BLUE(40, -1, 52479),
    PLUM(61, 25, 10040166),
    GREY_25_PERCENT(22, -1, 12632256),
    ROSE(45, -1, 16751052),
    LIGHT_YELLOW(43, -1, 16777113),
    LIGHT_GREEN(42, -1, 13434828),
    LIGHT_TURQUOISE(41, 27, 13434879),
    PALE_BLUE(44, -1, 10079487),
    LAVENDER(46, -1, 13408767),
    WHITE(9, -1, 16777215),
    CORNFLOWER_BLUE(24, -1, 10066431),
    LEMON_CHIFFON(26, -1, 16777164),
    MAROON(25, -1, 8323072),
    ORCHID(28, -1, 6684774),
    CORAL(29, -1, 16744576),
    ROYAL_BLUE(30, -1, 26316),
    LIGHT_CORNFLOWER_BLUE(31, -1, 13421823),
    TAN(47, -1, 16764057),
    AUTOMATIC(64, -1, 0);

    private final b c;

    a(int i2, int i3, int i4) {
        this.c = new b(i2, i3, i4);
    }

    public b a() {
        return new b(b(), c(), this.c.a);
    }

    public short b() {
        return this.c.f();
    }

    public short c() {
        return this.c.g();
    }

    public short[] d() {
        return this.c.j();
    }
}
