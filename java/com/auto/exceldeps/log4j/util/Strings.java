package com.auto.exceldeps.log4j.util;

import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

@InternalApi
/* loaded from: classes.dex */
public final class Strings {
    private static final String COMMA_DELIMITED_RE = "\\s*,\\s*";
    public static final String EMPTY = "";
    private static final int MAX_FORMAT_BUFFER_LENGTH = 518;
    private static final ThreadLocal<StringBuilder> FORMAT_BUFFER_REF = ThreadLocal.withInitial(new java.util.function.Supplier() { // from class: com.auto.exceldeps.log4j.util.w
        @Override // java.util.function.Supplier
        public final Object get() {
            return new StringBuilder();
        }
    });
    public static final String[] EMPTY_ARRAY = new String[0];
    public static final String LINE_SEPARATOR = System.lineSeparator();

    private Strings() {
    }

    public static String concat(String str, String str2) {
        if (isEmpty(str)) {
            return str2;
        }
        if (isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = FORMAT_BUFFER_REF.get();
        try {
            sb.append(str);
            sb.append(str2);
            return sb.toString();
        } finally {
            StringBuilders.trimToMaxSize(sb, MAX_FORMAT_BUFFER_LENGTH);
            sb.setLength(0);
        }
    }

    public static String dquote(String str) {
        return Chars.DQUOTE + str + Chars.DQUOTE;
    }

    public static boolean isBlank(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String left(String str, int i2) {
        if (str == null) {
            return null;
        }
        return i2 < 0 ? "" : str.length() <= i2 ? str : str.substring(0, i2);
    }

    public static String quote(String str) {
        return Chars.QUOTE + str + Chars.QUOTE;
    }

    public static String repeat(String str, int i2) {
        Objects.requireNonNull(str, "str");
        if (i2 < 0) {
            throw new IllegalArgumentException("count");
        }
        StringBuilder sb = FORMAT_BUFFER_REF.get();
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                return sb.toString();
            }
            try {
                sb.append(str);
                i3++;
            } finally {
            }
            StringBuilders.trimToMaxSize(sb, MAX_FORMAT_BUFFER_LENGTH);
            sb.setLength(0);
        }
    }

    public static String[] splitList(String str) {
        return str != null ? str.split(COMMA_DELIMITED_RE) : new String[0];
    }

    public static String toRootLowerCase(String str) {
        return str.toLowerCase(Locale.ROOT);
    }

    public static String toRootUpperCase(String str) {
        return str.toUpperCase(Locale.ROOT);
    }

    public static String trimToNull(String str) {
        String strTrim = str == null ? null : str.trim();
        if (isEmpty(strTrim)) {
            return null;
        }
        return strTrim;
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }
}
