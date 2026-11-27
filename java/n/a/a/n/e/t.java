package n.a.a.n.e;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
enum t {
    YMD_DASHES("^(\\d{4})-(\\w+)-(\\d{1,2})( .*)?$", "ymd"),
    DMY_DASHES("^(\\d{1,2})-(\\w+)-(\\d{4})( .*)?$", "dmy"),
    MD_DASHES("^(\\w+)-(\\d{1,2})( .*)?$", "md"),
    MDY_SLASHES("^(\\w+)/(\\d{1,2})/(\\d{4})( .*)?$", "mdy"),
    YMD_SLASHES("^(\\d{4})/(\\w+)/(\\d{1,2})( .*)?$", "ymd"),
    MD_SLASHES("^(\\w+)/(\\d{1,2})( .*)?$", "md");

    private Pattern c;
    private boolean d;
    private int e;
    private int f;
    private int g;

    t(String str, String str2) {
        this.c = Pattern.compile(str);
        boolean zContains = str2.contains("y");
        this.d = zContains;
        if (zContains) {
            this.e = str2.indexOf("y");
        }
        this.f = str2.indexOf("m");
        this.g = str2.indexOf("d");
    }
}
