package n.a.a.n.e;

/* loaded from: classes.dex */
public abstract class e0 {
    public static void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sheetName must not be null");
        }
        int length = str.length();
        if (length < 1 || length > 31) {
            throw new IllegalArgumentException("sheetName '" + str + "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31");
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '*' && cCharAt != '/' && cCharAt != ':' && cCharAt != '?') {
                switch (cCharAt) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                }
            }
            throw new IllegalArgumentException("Invalid char (" + cCharAt + ") found at index (" + i2 + ") in sheet name '" + str + "'");
        }
        if (str.charAt(0) == '\'' || str.charAt(length - 1) == '\'') {
            throw new IllegalArgumentException("Invalid sheet name '" + str + "'. Sheet names must not begin or end with (').");
        }
    }
}
