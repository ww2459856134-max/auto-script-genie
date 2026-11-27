package n.a.a.q.b;

/* loaded from: classes.dex */
public enum k {
    LT1(0, "Lt1"),
    DK1(1, "Dk1"),
    LT2(2, "Lt2"),
    DK2(3, "Dk2"),
    ACCENT1(4, "Accent1"),
    ACCENT2(5, "Accent2"),
    ACCENT3(6, "Accent3"),
    ACCENT4(7, "Accent4"),
    ACCENT5(8, "Accent5"),
    ACCENT6(9, "Accent6"),
    HLINK(10, "Hlink"),
    FOLHLINK(11, "FolHlink"),
    UNKNOWN(-1, null);

    k(int i2, String str) {
    }

    public static k a(int i2) {
        return (i2 >= values().length || i2 < 0) ? UNKNOWN : values()[i2];
    }
}
