package org.apache.xmlbeans.impl.regex;

import com.auto.exceldeps.log4j.message.StructuredDataId;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.text.CharacterIterator;

/* loaded from: classes.dex */
public final class REUtil {
    static final int CACHESIZE = 20;
    static final RegularExpression[] regexCache = new RegularExpression[20];

    private REUtil() {
    }

    static final int composeFromSurrogates(int i2, int i3) {
        return ((((i2 - 55296) << 10) + WXMediaMessage.THUMB_LENGTH_LIMIT) + i3) - 56320;
    }

    static final String createOptionString(int i2) {
        StringBuilder sb = new StringBuilder(9);
        if ((i2 & 256) != 0) {
            sb.append('F');
        }
        if ((i2 & 128) != 0) {
            sb.append('H');
        }
        if ((i2 & 512) != 0) {
            sb.append('X');
        }
        if ((i2 & 2) != 0) {
            sb.append('i');
        }
        if ((i2 & 8) != 0) {
            sb.append('m');
        }
        if ((i2 & 4) != 0) {
            sb.append('s');
        }
        if ((i2 & 32) != 0) {
            sb.append('u');
        }
        if ((i2 & 64) != 0) {
            sb.append('w');
        }
        if ((i2 & 16) != 0) {
            sb.append('x');
        }
        if ((i2 & 1024) != 0) {
            sb.append(',');
        }
        return sb.toString().intern();
    }

    public static RegularExpression createRegex(String str, String str2) throws ParseException {
        RegularExpression regularExpression;
        int options = parseOptions(str2);
        synchronized (regexCache) {
            int i2 = 0;
            while (true) {
                regularExpression = null;
                if (i2 >= 20) {
                    break;
                }
                try {
                    RegularExpression regularExpression2 = regexCache[i2];
                    if (regularExpression2 == null) {
                        i2 = -1;
                        break;
                    }
                    if (regularExpression2.equals(str, options)) {
                        regularExpression = regularExpression2;
                        break;
                    }
                    i2++;
                } finally {
                }
            }
            if (regularExpression == null) {
                regularExpression = new RegularExpression(str, str2);
                RegularExpression[] regularExpressionArr = regexCache;
                System.arraycopy(regularExpressionArr, 0, regularExpressionArr, 1, 19);
                regularExpressionArr[0] = regularExpression;
            } else if (i2 != 0) {
                RegularExpression[] regularExpressionArr2 = regexCache;
                System.arraycopy(regularExpressionArr2, 0, regularExpressionArr2, 1, i2);
                regularExpressionArr2[0] = regularExpression;
            }
        }
        return regularExpression;
    }

    static final String decomposeToSurrogates(int i2) {
        int i3 = i2 - WXMediaMessage.THUMB_LENGTH_LIMIT;
        return new String(new char[]{(char) ((i3 >> 10) + 55296), (char) ((i3 & 1023) + 56320)});
    }

    static void dumpString(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            System.out.print(Integer.toHexString(str.charAt(i2)));
            System.out.print(" ");
        }
        System.out.println();
    }

    static final int getOptionValue(int i2) {
        if (i2 == 44) {
            return 1024;
        }
        if (i2 == 70) {
            return 256;
        }
        if (i2 == 72) {
            return 128;
        }
        if (i2 == 88) {
            return 512;
        }
        if (i2 == 105) {
            return 2;
        }
        if (i2 == 109) {
            return 8;
        }
        if (i2 == 115) {
            return 4;
        }
        if (i2 == 117) {
            return 32;
        }
        if (i2 != 119) {
            return i2 != 120 ? 0 : 16;
        }
        return 64;
    }

    static final boolean isHighSurrogate(int i2) {
        return (i2 & 64512) == 55296;
    }

    static final boolean isLowSurrogate(int i2) {
        return (i2 & 64512) == 56320;
    }

    public static void main(String[] strArr) {
        String str = null;
        try {
            if (strArr.length == 0) {
                System.out.println("Error:Usage: java REUtil -i|-m|-s|-u|-w|-X regularExpression String");
                System.exit(0);
            }
            String str2 = "";
            String str3 = null;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].isEmpty() || strArr[i2].charAt(0) != '-') {
                    if (str == null) {
                        str = strArr[i2];
                    } else if (str3 == null) {
                        str3 = strArr[i2];
                    } else {
                        System.err.println("Unnecessary: " + strArr[i2]);
                    }
                } else if (strArr[i2].equals("-i")) {
                    str2 = str2 + "i";
                } else if (strArr[i2].equals("-m")) {
                    str2 = str2 + "m";
                } else if (strArr[i2].equals("-s")) {
                    str2 = str2 + "s";
                } else if (strArr[i2].equals("-u")) {
                    str2 = str2 + "u";
                } else if (strArr[i2].equals("-w")) {
                    str2 = str2 + "w";
                } else if (strArr[i2].equals("-X")) {
                    str2 = str2 + "X";
                } else {
                    System.err.println("Unknown option: " + strArr[i2]);
                }
            }
            RegularExpression regularExpression = new RegularExpression(str, str2);
            System.out.println("RegularExpression: " + regularExpression);
            Match match = new Match();
            regularExpression.matches(str3, match);
            for (int i3 = 0; i3 < match.getNumberOfGroups(); i3++) {
                if (i3 == 0) {
                    System.out.print("Matched range for the whole pattern: ");
                } else {
                    System.out.print("[" + i3 + "]: ");
                }
                if (match.getBeginning(i3) < 0) {
                    System.out.println(StructuredDataId.RESERVED);
                } else {
                    System.out.print(match.getBeginning(i3) + ", " + match.getEnd(i3) + ", ");
                    System.out.println("\"" + match.getCapturedText(i3) + "\"");
                }
            }
        } catch (ParseException e) {
            if (str == null) {
                e.printStackTrace();
                return;
            }
            System.err.println("org.apache.xerces.utils.regex.ParseException: " + e.getMessage());
            System.err.println("        " + str);
            int location = e.getLocation();
            if (location >= 0) {
                System.err.print("        ");
                for (int i4 = 0; i4 < location; i4++) {
                    System.err.print(ProcessIdUtil.DEFAULT_PROCESSID);
                }
                System.err.println("^");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean matches(String str, String str2) throws ParseException {
        return createRegex(str, null).matches(str2);
    }

    static final int parseOptions(String str) throws ParseException {
        if (str == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            int optionValue = getOptionValue(str.charAt(i3));
            if (optionValue == 0) {
                throw new ParseException("Unknown Option: " + str.substring(i3), -1);
            }
            i2 |= optionValue;
        }
        return i2;
    }

    public static String quoteMeta(String str) {
        int length = str.length();
        StringBuilder sb = null;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (".*+?{[()|\\^$".indexOf(cCharAt) >= 0) {
                if (sb == null) {
                    sb = new StringBuilder(((length - i2) * 2) + i2);
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                sb.append('\\');
                sb.append(cCharAt);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : str;
    }

    static String stripExtendedComment(String str) {
        char cCharAt;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '\f' && cCharAt2 != '\r' && cCharAt2 != ' ') {
                if (cCharAt2 == '#') {
                    do {
                        i2 = i3;
                        if (i2 < length) {
                            i3 = i2 + 1;
                            cCharAt = str.charAt(i2);
                            if (cCharAt == '\r') {
                                break;
                            }
                        }
                    } while (cCharAt != '\n');
                } else if (cCharAt2 != '\\' || i3 >= length) {
                    sb.append(cCharAt2);
                } else {
                    char cCharAt3 = str.charAt(i3);
                    if (cCharAt3 == '#' || cCharAt3 == '\t' || cCharAt3 == '\n' || cCharAt3 == '\f' || cCharAt3 == '\r' || cCharAt3 == ' ') {
                        sb.append(cCharAt3);
                    } else {
                        sb.append('\\');
                        sb.append(cCharAt3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        return sb.toString();
    }

    static final String substring(CharacterIterator characterIterator, int i2, int i3) {
        int i4 = i3 - i2;
        char[] cArr = new char[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            cArr[i5] = characterIterator.setIndex(i5 + i2);
        }
        return new String(cArr);
    }

    public static boolean matches(String str, String str2, String str3) throws ParseException {
        return createRegex(str, str2).matches(str3);
    }
}
