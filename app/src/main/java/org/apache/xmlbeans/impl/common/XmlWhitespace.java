package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public class XmlWhitespace {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    public static String collapse(String str) {
        return collapse(str, 3);
    }

    public static boolean isAllSpace(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!isSpace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public static String collapse(String str, int i2) {
        int length;
        int i3;
        int i4;
        if (i2 == 1 || i2 == 0) {
            return str;
        }
        if (str.indexOf(10) >= 0) {
            str = str.replace('\n', Chars.SPACE);
        }
        if (str.indexOf(9) >= 0) {
            str = str.replace('\t', Chars.SPACE);
        }
        if (str.indexOf(13) >= 0) {
            str = str.replace(Chars.CR, Chars.SPACE);
        }
        String str2 = str;
        if (i2 == 2 || (length = str2.length()) == 0) {
            return str2;
        }
        if (str2.charAt(0) != ' ') {
            i3 = 2;
            while (true) {
                if (i3 < length) {
                    if (str2.charAt(i3) == ' ') {
                        if (str2.charAt(i3 - 1) == ' ' || i3 == length - 1) {
                            break;
                        }
                        i3++;
                        if (str2.charAt(i3) == ' ') {
                            break;
                        }
                    }
                    i3 += 2;
                } else if (i3 != length || str2.charAt(i3 - 1) != ' ') {
                    return str2;
                }
            }
            i4 = i3;
        } else {
            i3 = 0;
            while (true) {
                int i5 = i3 + 1;
                if (i5 >= str2.length() || str2.charAt(i5) != ' ') {
                    break;
                }
                i3 = i5;
            }
            i4 = 0;
        }
        char[] charArray = str2.toCharArray();
        loop1: while (true) {
            i3++;
            if (i3 >= length) {
                break;
            }
            if (str2.charAt(i3) != ' ') {
                while (true) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    charArray[i4] = charArray[i3];
                    if (i7 >= length) {
                        i4 = i6;
                        break loop1;
                    }
                    if (charArray[i7] == ' ') {
                        i4 = i6 + 1;
                        i3 = i7 + 1;
                        charArray[i6] = charArray[i7];
                        if (i3 >= length) {
                            break loop1;
                        }
                        if (charArray[i3] == ' ') {
                            break;
                        }
                    } else {
                        i4 = i6;
                        i3 = i7;
                    }
                }
            }
        }
        if (i4 != 0) {
            int i8 = i4 - 1;
            if (charArray[i8] == ' ') {
                i4 = i8;
            }
        }
        return new String(charArray, 0, i4);
    }

    public static boolean isAllSpace(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!isSpace(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }
}
