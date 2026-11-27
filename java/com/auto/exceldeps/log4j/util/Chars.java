package com.auto.exceldeps.log4j.util;

@InternalApi
/* loaded from: classes.dex */
public final class Chars {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char EQ = '=';
    public static final char LF = '\n';
    public static final char NUL = 0;
    public static final char QUOTE = '\'';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';

    private Chars() {
    }

    private static char getLowerCaseAlphaDigit(int i2) {
        return (char) ((i2 + 97) - 10);
    }

    public static char getLowerCaseHex(int i2) {
        if (i2 < 0 || i2 >= 16) {
            return (char) 0;
        }
        return i2 < 10 ? getNumericalDigit(i2) : getLowerCaseAlphaDigit(i2);
    }

    private static char getNumericalDigit(int i2) {
        return (char) (i2 + 48);
    }

    private static char getUpperCaseAlphaDigit(int i2) {
        return (char) ((i2 + 65) - 10);
    }

    public static char getUpperCaseHex(int i2) {
        if (i2 < 0 || i2 >= 16) {
            return (char) 0;
        }
        return i2 < 10 ? getNumericalDigit(i2) : getUpperCaseAlphaDigit(i2);
    }
}
