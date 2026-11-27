package n.a.a.m.a;

/* loaded from: classes.dex */
public enum a {
    EMF(2, 2, "image/x-emf", ".emf"),
    WMF(3, 3, "image/x-wmf", ".wmf"),
    PICT(4, 4, "image/x-pict", ".pict"),
    JPEG(5, 5, "image/jpeg", ".jpg"),
    PNG(6, 6, "image/png", ".png"),
    DIB(7, 7, "image/dib", ".dib"),
    GIF(-1, 8, "image/gif", ".gif"),
    TIFF(17, 9, "image/tiff", ".tif"),
    EPS(-1, 10, "image/x-eps", ".eps"),
    BMP(-1, 11, "image/x-ms-bmp", ".bmp"),
    WPG(-1, 12, "image/x-wpg", ".wpg"),
    WDP(-1, 13, "image/vnd.ms-photo", ".wdp"),
    SVG(-1, -1, "image/svg+xml", ".svg"),
    UNKNOWN(1, -1, "", ".dat"),
    ERROR(0, -1, "", ".dat"),
    CMYKJPEG(18, -1, "image/jpeg", ".jpg"),
    CLIENT(32, -1, "", ".dat");

    public final String c;

    a(int i2, int i3, String str, String str2) {
        this.c = str;
    }
}
