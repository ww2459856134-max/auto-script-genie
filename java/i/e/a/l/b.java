package i.e.a.l;

import java.io.OutputStreamWriter;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class b {
    public static boolean a(String str, String str2) {
        int i2;
        char cCharAt;
        int i3;
        char cCharAt2;
        int length = str.length();
        int length2 = str2.length();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length && i5 >= length2) {
                return true;
            }
            if (i4 >= length) {
                i2 = i4;
                cCharAt = 0;
            } else {
                i2 = i4 + 1;
                cCharAt = str.charAt(i4);
            }
            if (i5 >= length2) {
                i3 = i5;
                cCharAt2 = 0;
            } else {
                i3 = i5 + 1;
                cCharAt2 = str2.charAt(i5);
            }
            if (cCharAt != cCharAt2) {
                while (true) {
                    if (cCharAt > ' ' && cCharAt != '_' && cCharAt != '-') {
                        break;
                    }
                    if (i2 >= length) {
                        cCharAt = 0;
                    } else {
                        int i6 = i2 + 1;
                        char cCharAt3 = str.charAt(i2);
                        i2 = i6;
                        cCharAt = cCharAt3;
                    }
                }
                while (true) {
                    if (cCharAt2 > ' ' && cCharAt2 != '_' && cCharAt2 != '-') {
                        break;
                    }
                    if (i3 >= length2) {
                        cCharAt2 = 0;
                    } else {
                        int i7 = i3 + 1;
                        char cCharAt4 = str2.charAt(i3);
                        i3 = i7;
                        cCharAt2 = cCharAt4;
                    }
                }
                if (cCharAt == cCharAt2) {
                    continue;
                } else {
                    if (cCharAt2 == 0) {
                        return true;
                    }
                    if (cCharAt == 0 || Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                        return false;
                    }
                }
            }
            i4 = i2;
            i5 = i3;
        }
    }

    public static boolean b(String str, String str2) {
        int i2;
        char cCharAt;
        int i3;
        char cCharAt2;
        int length = str.length();
        int length2 = str2.length();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= length && i5 >= length2) {
                return true;
            }
            if (i4 >= length) {
                i2 = i4;
                cCharAt = 0;
            } else {
                i2 = i4 + 1;
                cCharAt = str.charAt(i4);
            }
            if (i5 >= length2) {
                i3 = i5;
                cCharAt2 = 0;
            } else {
                i3 = i5 + 1;
                cCharAt2 = str2.charAt(i5);
            }
            if (cCharAt != cCharAt2) {
                while (true) {
                    if (cCharAt > ' ' && cCharAt != '_' && cCharAt != '-') {
                        break;
                    }
                    if (i2 >= length) {
                        cCharAt = 0;
                    } else {
                        int i6 = i2 + 1;
                        char cCharAt3 = str.charAt(i2);
                        i2 = i6;
                        cCharAt = cCharAt3;
                    }
                }
                while (true) {
                    if (cCharAt2 > ' ' && cCharAt2 != '_' && cCharAt2 != '-') {
                        break;
                    }
                    if (i3 >= length2) {
                        cCharAt2 = 0;
                    } else {
                        int i7 = i3 + 1;
                        char cCharAt4 = str2.charAt(i3);
                        i3 = i7;
                        cCharAt2 = cCharAt4;
                    }
                }
                if (cCharAt != cCharAt2 && (cCharAt == 0 || cCharAt2 == 0 || Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2))) {
                    break;
                }
            }
            i4 = i2;
            i5 = i3;
        }
        return false;
    }

    public static String c(Writer writer) {
        if (writer instanceof OutputStreamWriter) {
            return d(((OutputStreamWriter) writer).getEncoding());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(String str) {
        char cCharAt;
        String strSubstring = str;
        if (strSubstring == null || str.length() < 3) {
            return strSubstring;
        }
        boolean z = false;
        char cCharAt2 = strSubstring.charAt(0);
        if ((cCharAt2 == 'c' || cCharAt2 == 'C') && ((cCharAt = strSubstring.charAt(1)) == 's' || cCharAt == 'S')) {
            strSubstring = strSubstring.substring(2);
            cCharAt2 = strSubstring.charAt(0);
            z = true;
        }
        if (cCharAt2 == 'A') {
            if (strSubstring == "ASCII" || b(strSubstring, "ASCII")) {
                return "US-ASCII";
            }
        } else if (cCharAt2 == 'C') {
            a(strSubstring, "cs");
        } else if (cCharAt2 == 'E') {
            if (strSubstring.startsWith("EBCDIC") || strSubstring.startsWith("ebcdic")) {
                return "EBCDIC";
            }
        } else if (cCharAt2 == 'S') {
            if (b(strSubstring, "Shift_JIS")) {
                return "Shift_JIS";
            }
        } else if (cCharAt2 == 'U') {
            if (strSubstring.length() >= 2) {
                char cCharAt3 = strSubstring.charAt(1);
                if (cCharAt3 == 'C') {
                    if (b(strSubstring, "UCS-2")) {
                        return "UTF-16";
                    }
                    if (b(strSubstring, "UCS-4")) {
                        return "UTF-32";
                    }
                } else if (cCharAt3 == 'N') {
                    if (z) {
                        if (b(strSubstring, "Unicode")) {
                            return "UTF-16";
                        }
                        if (b(strSubstring, "UnicodeAscii")) {
                            return "ISO-8859-1";
                        }
                        if (b(strSubstring, "UnicodeAscii")) {
                            return "US-ASCII";
                        }
                    }
                } else if (cCharAt3 != 'c') {
                    if (cCharAt3 != 'n') {
                        if (cCharAt3 == 'S') {
                            if (b(strSubstring, "US-ASCII")) {
                                return "US-ASCII";
                            }
                        } else if (cCharAt3 == 'T') {
                            if (strSubstring == "UTF-8" || b(strSubstring, "UTF-8")) {
                                return "UTF-8";
                            }
                            if (b(strSubstring, "UTF-16BE")) {
                                return "UTF-16BE";
                            }
                            if (b(strSubstring, "UTF-16LE")) {
                                return "UTF-16LE";
                            }
                            if (b(strSubstring, "UTF-16")) {
                                return "UTF-16";
                            }
                            if (b(strSubstring, "UTF-32BE")) {
                                return "UTF-32BE";
                            }
                            if (b(strSubstring, "UTF-32LE")) {
                                return "UTF-32LE";
                            }
                            if (b(strSubstring, "UTF-32")) {
                                return "UTF-32";
                            }
                            if (b(strSubstring, "UTF")) {
                                return "UTF-16";
                            }
                        } else if (cCharAt3 != 's') {
                            if (cCharAt3 == 't') {
                            }
                        }
                    }
                }
            }
        } else if (cCharAt2 != 'a') {
            if (cCharAt2 != 'c') {
                if (cCharAt2 != 'e') {
                    if (cCharAt2 != 's') {
                        if (cCharAt2 != 'u') {
                            if (cCharAt2 == 'I') {
                                if (strSubstring == "ISO-8859-1" || b(strSubstring, "ISO-8859-1") || b(strSubstring, "ISO-Latin1")) {
                                    return "ISO-8859-1";
                                }
                                if (a(strSubstring, "ISO-10646")) {
                                    String strSubstring2 = strSubstring.substring(strSubstring.indexOf("10646") + 5);
                                    if (b(strSubstring2, "UCS-Basic")) {
                                        return "US-ASCII";
                                    }
                                    if (b(strSubstring2, "Unicode-Latin1")) {
                                        return "ISO-8859-1";
                                    }
                                    if (b(strSubstring2, "UCS-2")) {
                                        return "UTF-16";
                                    }
                                    if (b(strSubstring2, "UCS-4")) {
                                        return "UTF-32";
                                    }
                                    if (b(strSubstring2, "UTF-1") || b(strSubstring2, "J-1") || b(strSubstring2, "US-ASCII")) {
                                        return "US-ASCII";
                                    }
                                }
                            } else if (cCharAt2 == 'J') {
                                if (b(strSubstring, "JIS_Encoding")) {
                                    return "Shift_JIS";
                                }
                            } else if (cCharAt2 != 'i') {
                                if (cCharAt2 == 'j') {
                                }
                            }
                        }
                    }
                }
            }
        }
        return strSubstring;
    }
}
