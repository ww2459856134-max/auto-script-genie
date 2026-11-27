package n.a.a.e.a;

import java.util.HashMap;

/* loaded from: classes.dex */
public enum c {
    EMF("image/x-emf", ".emf", 2),
    WMF("image/x-wmf", ".wmf", 3),
    PICT("image/x-pict", ".pict", 4),
    JPEG("image/jpeg", ".jpg", 5),
    PNG("image/png", ".png", 6),
    DIB("image/dib", ".dib", 7),
    GIF("image/gif", ".gif", 8),
    TIFF("image/tiff", ".tif", 9),
    EPS("image/x-eps", ".eps", 10),
    BMP("image/x-ms-bmp", ".bmp", 11),
    WPG("image/x-wpg", ".wpg", 12),
    WDP("image/vnd.ms-photo", ".wdp", 13),
    SVG("image/svg+xml", ".svg", 14),
    UNKNOWN("", ".dat", -1),
    ERROR("", ".dat", -1),
    CMYKJPEG("image/jpeg", ".jpg", -1),
    CLIENT("", ".dat", -1);

    private static final HashMap<Integer, c> O = new HashMap<>();
    public final String c;
    public final int d;

    static {
        for (c cVar : values()) {
            int i2 = cVar.d;
            if (i2 >= -1) {
                O.put(Integer.valueOf(i2), cVar);
            }
        }
    }

    c(String str, String str2, int i2) {
        this.c = str;
        this.d = i2;
    }
}
