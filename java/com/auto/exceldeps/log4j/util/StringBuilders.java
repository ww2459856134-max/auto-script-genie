package com.auto.exceldeps.log4j.util;

import java.time.temporal.Temporal;
import java.util.Map;

@InternalApi
/* loaded from: classes.dex */
public final class StringBuilders {
    private static final Class<?> dateClass;
    private static final Class<?> timeClass;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("java.sql.Time");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        timeClass = cls;
        try {
            cls2 = Class.forName("java.sql.Date");
        } catch (ClassNotFoundException unused2) {
        }
        dateClass = cls2;
    }

    private StringBuilders() {
    }

    public static StringBuilder appendDqValue(StringBuilder sb, Object obj) {
        sb.append(Chars.DQUOTE);
        sb.append(obj);
        sb.append(Chars.DQUOTE);
        return sb;
    }

    public static StringBuilder appendKeyDqValue(StringBuilder sb, Map.Entry<String, String> entry) {
        return appendKeyDqValue(sb, entry.getKey(), entry.getValue());
    }

    public static boolean appendSpecificTypes(StringBuilder sb, Object obj) {
        if (obj == null || (obj instanceof String)) {
            sb.append((String) obj);
            return true;
        }
        if (obj instanceof StringBuilderFormattable) {
            ((StringBuilderFormattable) obj).formatTo(sb);
            return true;
        }
        if (obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
            return true;
        }
        if (obj instanceof Integer) {
            sb.append(((Integer) obj).intValue());
            return true;
        }
        if (obj instanceof Long) {
            sb.append(((Long) obj).longValue());
            return true;
        }
        if (obj instanceof Double) {
            sb.append(((Double) obj).doubleValue());
            return true;
        }
        if (obj instanceof Boolean) {
            sb.append(((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
            return true;
        }
        if (obj instanceof Short) {
            sb.append((int) ((Short) obj).shortValue());
            return true;
        }
        if (obj instanceof Float) {
            sb.append(((Float) obj).floatValue());
            return true;
        }
        if (obj instanceof Byte) {
            sb.append((int) ((Byte) obj).byteValue());
            return true;
        }
        if (!isTime(obj) && !isDate(obj) && !(obj instanceof Temporal)) {
            return false;
        }
        sb.append(obj);
        return true;
    }

    public static void appendValue(StringBuilder sb, Object obj) {
        if (appendSpecificTypes(sb, obj)) {
            return;
        }
        sb.append(obj);
    }

    public static boolean equals(CharSequence charSequence, int i2, int i3, CharSequence charSequence2, int i4, int i5) {
        if (i3 != i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (charSequence.charAt(i6 + i2) != charSequence2.charAt(i6 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, int i2, int i3, CharSequence charSequence2, int i4, int i5) {
        if (i3 != i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (Character.toLowerCase(charSequence.charAt(i6 + i2)) != Character.toLowerCase(charSequence2.charAt(i6 + i4))) {
                return false;
            }
        }
        return true;
    }

    private static int escapeAndDecrement(StringBuilder sb, int i2, char c) {
        int i3 = i2 - 1;
        sb.setCharAt(i2, c);
        int i4 = i3 - 1;
        sb.setCharAt(i3, '\\');
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void escapeJson(StringBuilder sb, int i2) {
        int i3 = 0;
        while (i2 < sb.length()) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt != '\f' && cCharAt != '\r' && cCharAt != '\"' && cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                    case '\t':
                    case '\n':
                        break;
                    default:
                        if (Character.isISOControl(cCharAt)) {
                            i3 += 5;
                            break;
                        } else {
                            break;
                        }
                }
            } else {
                i3++;
            }
            i2++;
        }
        sb.setLength(sb.length() + i3);
        int length = sb.length() - 1;
        for (int length2 = sb.length() - 1; length > length2; length2--) {
            char cCharAt2 = sb.charAt(length2);
            if (cCharAt2 == '\f') {
                length = escapeAndDecrement(sb, length, 'f');
            } else if (cCharAt2 == '\r') {
                length = escapeAndDecrement(sb, length, 'r');
            } else if (cCharAt2 != '\"' && cCharAt2 != '\\') {
                switch (cCharAt2) {
                    case '\b':
                        length = escapeAndDecrement(sb, length, 'b');
                        break;
                    case '\t':
                        length = escapeAndDecrement(sb, length, 't');
                        break;
                    case '\n':
                        length = escapeAndDecrement(sb, length, 'n');
                        break;
                    default:
                        if (Character.isISOControl(cCharAt2)) {
                            int i4 = length - 1;
                            sb.setCharAt(length, Chars.getUpperCaseHex(cCharAt2 & 15));
                            int i5 = i4 - 1;
                            sb.setCharAt(i4, Chars.getUpperCaseHex((cCharAt2 & 240) >> 4));
                            int i6 = i5 - 1;
                            sb.setCharAt(i5, '0');
                            int i7 = i6 - 1;
                            sb.setCharAt(i6, '0');
                            int i8 = i7 - 1;
                            sb.setCharAt(i7, 'u');
                            length = i8 - 1;
                            sb.setCharAt(i8, '\\');
                            break;
                        } else {
                            sb.setCharAt(length, cCharAt2);
                            length--;
                            break;
                        }
                }
            } else {
                length = escapeAndDecrement(sb, length, cCharAt2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void escapeXml(StringBuilder sb, int i2) {
        int i3 = 0;
        while (i2 < sb.length()) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt == '\"') {
                i3 += 5;
            } else if (cCharAt == '<' || cCharAt == '>') {
                i3 += 3;
            } else if (cCharAt == '&') {
                i3 += 4;
            } else if (cCharAt != '\'') {
            }
            i2++;
        }
        sb.setLength(sb.length() + i3);
        int length = sb.length() - 1;
        for (int length2 = sb.length() - 1; length > length2; length2--) {
            char cCharAt2 = sb.charAt(length2);
            if (cCharAt2 == '\"') {
                int i4 = length - 1;
                sb.setCharAt(length, ';');
                int i5 = i4 - 1;
                sb.setCharAt(i4, 't');
                int i6 = i5 - 1;
                sb.setCharAt(i5, 'o');
                int i7 = i6 - 1;
                sb.setCharAt(i6, 'u');
                int i8 = i7 - 1;
                sb.setCharAt(i7, 'q');
                length = i8 - 1;
                sb.setCharAt(i8, '&');
            } else if (cCharAt2 == '<') {
                int i9 = length - 1;
                sb.setCharAt(length, ';');
                int i10 = i9 - 1;
                sb.setCharAt(i9, 't');
                int i11 = i10 - 1;
                sb.setCharAt(i10, 'l');
                length = i11 - 1;
                sb.setCharAt(i11, '&');
            } else if (cCharAt2 == '>') {
                int i12 = length - 1;
                sb.setCharAt(length, ';');
                int i13 = i12 - 1;
                sb.setCharAt(i12, 't');
                int i14 = i13 - 1;
                sb.setCharAt(i13, 'g');
                length = i14 - 1;
                sb.setCharAt(i14, '&');
            } else if (cCharAt2 == '&') {
                int i15 = length - 1;
                sb.setCharAt(length, ';');
                int i16 = i15 - 1;
                sb.setCharAt(i15, 'p');
                int i17 = i16 - 1;
                sb.setCharAt(i16, 'm');
                int i18 = i17 - 1;
                sb.setCharAt(i17, 'a');
                sb.setCharAt(i18, '&');
                length = i18 - 1;
            } else if (cCharAt2 != '\'') {
                sb.setCharAt(length, cCharAt2);
                length--;
            } else {
                int i19 = length - 1;
                sb.setCharAt(length, ';');
                int i20 = i19 - 1;
                sb.setCharAt(i19, 's');
                int i21 = i20 - 1;
                sb.setCharAt(i20, 'o');
                int i22 = i21 - 1;
                sb.setCharAt(i21, 'p');
                int i23 = i22 - 1;
                sb.setCharAt(i22, 'a');
                length = i23 - 1;
                sb.setCharAt(i23, '&');
            }
        }
    }

    private static boolean isDate(Object obj) {
        Class<?> cls = dateClass;
        return cls != null && cls.isAssignableFrom(obj.getClass());
    }

    private static boolean isTime(Object obj) {
        Class<?> cls = timeClass;
        return cls != null && cls.isAssignableFrom(obj.getClass());
    }

    public static void trimToMaxSize(StringBuilder sb, int i2) {
        if (sb == null || sb.capacity() <= i2) {
            return;
        }
        sb.setLength(i2);
        sb.trimToSize();
    }

    public static StringBuilder appendKeyDqValue(StringBuilder sb, String str, Object obj) {
        sb.append(str);
        sb.append(Chars.EQ);
        sb.append(Chars.DQUOTE);
        sb.append(obj);
        sb.append(Chars.DQUOTE);
        return sb;
    }
}
