package i.b;

/* loaded from: classes.dex */
abstract class h8 {
    static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String strReplace = str.replace('\\', '/');
        while (strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return "backup_temp".equals(strReplace) || strReplace.startsWith("backup_temp/");
    }
}
