package com.google.gson.internal.bind.c;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.auto.exceldeps.log4j.util.Chars;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class a {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i2, char c) {
        return i2 < str.length() && str.charAt(i2) == c;
    }

    private static int b(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00cd, B:49:0x00d3, B:51:0x00da, B:75:0x0187, B:55:0x00e4, B:56:0x00ff, B:57:0x0100, B:61:0x011c, B:63:0x0129, B:66:0x0132, B:68:0x0151, B:71:0x0160, B:72:0x0182, B:74:0x0185, B:60:0x010b, B:77:0x01b8, B:78:0x01bf, B:40:0x00b4, B:41:0x00b7), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b8 A[Catch: IllegalArgumentException -> 0x01c0, NumberFormatException -> 0x01c2, IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, TryCatch #2 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x01c4, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0036, B:13:0x003c, B:17:0x0054, B:19:0x0064, B:20:0x0066, B:22:0x0072, B:23:0x0074, B:25:0x007a, B:29:0x0084, B:34:0x0094, B:36:0x009c, B:47:0x00cd, B:49:0x00d3, B:51:0x00da, B:75:0x0187, B:55:0x00e4, B:56:0x00ff, B:57:0x0100, B:61:0x011c, B:63:0x0129, B:66:0x0132, B:68:0x0151, B:71:0x0160, B:72:0x0182, B:74:0x0185, B:60:0x010b, B:77:0x01b8, B:78:0x01bf, B:40:0x00b4, B:41:0x00b7), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i2;
        int i3;
        int i4;
        int iD;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int iD2 = d(str, index, i5);
            if (a(str, i5, NameUtil.HYPHEN)) {
                i5++;
            }
            int i6 = i5 + 2;
            int iD3 = d(str, i5, i6);
            if (a(str, i6, NameUtil.HYPHEN)) {
                i6++;
            }
            int i7 = i6 + 2;
            int iD4 = d(str, i6, i7);
            boolean zA = a(str, i7, 'T');
            if (!zA && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                int iD5 = d(str, i8, i9);
                if (a(str, i9, NameUtil.COLON)) {
                    i9++;
                }
                int i10 = i9 + 2;
                int iD6 = d(str, i9, i10);
                if (a(str, i10, NameUtil.COLON)) {
                    i10++;
                }
                if (str.length() > i10 && (cCharAt = str.charAt(i10)) != 'Z' && cCharAt != '+' && cCharAt != '-') {
                    int i11 = i10 + 2;
                    iD = d(str, i10, i11);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i11, NameUtil.PERIOD)) {
                        int i12 = i11 + 1;
                        int iB = b(str, i12 + 1);
                        int iMin = Math.min(iB, i12 + 3);
                        int iD7 = d(str, i12, iMin);
                        int i13 = iMin - i12;
                        if (i13 == 1) {
                            iD7 *= 100;
                        } else if (i13 == 2) {
                            iD7 *= 10;
                        }
                        i3 = iD6;
                        i4 = iD7;
                        i2 = iD5;
                        i7 = iB;
                    } else {
                        i3 = iD6;
                        i2 = iD5;
                        i7 = i11;
                        i4 = 0;
                    }
                    if (str.length() > i7) {
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                    char cCharAt2 = str.charAt(i7);
                    if (cCharAt2 == 'Z') {
                        timeZone = a;
                        length = i7 + 1;
                    } else {
                        if (cCharAt2 != '+' && cCharAt2 != '-') {
                            throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                        }
                        String strSubstring = str.substring(i7);
                        if (strSubstring.length() < 5) {
                            strSubstring = strSubstring + "00";
                        }
                        length = i7 + strSubstring.length();
                        if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                            timeZone = a;
                        } else {
                            String str3 = "GMT" + strSubstring;
                            TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                            String id = timeZone2.getID();
                            if (!id.equals(str3) && !id.replace(ParameterizedMessage.ERROR_MSG_SEPARATOR, "").equals(str3)) {
                                throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                            }
                            timeZone = timeZone2;
                        }
                    }
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(1, iD2);
                    gregorianCalendar2.set(2, iD3 - 1);
                    gregorianCalendar2.set(5, iD4);
                    gregorianCalendar2.set(11, i2);
                    gregorianCalendar2.set(12, i3);
                    gregorianCalendar2.set(13, iD);
                    gregorianCalendar2.set(14, i4);
                    parsePosition.setIndex(length);
                    return gregorianCalendar2.getTime();
                }
                i3 = iD6;
                i4 = 0;
                i2 = iD5;
                i7 = i10;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            iD = 0;
            if (str.length() > i7) {
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = Chars.DQUOTE + str + Chars.DQUOTE;
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static int d(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = -iDigit;
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = (i4 * 10) - iDigit2;
            i5 = i6;
        }
        return -i4;
    }
}
