package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.StringBuilders;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class ParameterFormatter {
    private static final char DELIM_START = '{';
    private static final char DELIM_STOP = '}';
    static final String ERROR_MSG_SEPARATOR = ":";
    static final String ERROR_PREFIX = "[!!!";
    static final String ERROR_SEPARATOR = "=>";
    static final String ERROR_SUFFIX = "!!!]";
    private static final char ESCAPE_CHAR = '\\';
    static final String RECURSION_PREFIX = "[...";
    static final String RECURSION_SUFFIX = "...]";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withZone(ZoneId.systemDefault());
    private static final Logger STATUS_LOGGER = StatusLogger.getLogger();

    static final class MessagePatternAnalysis implements Serializable {
        private static final int PLACEHOLDER_CHAR_INDEX_BUFFER_INITIAL_SIZE = 8;
        private static final int PLACEHOLDER_CHAR_INDEX_BUFFER_SIZE_INCREMENT = 8;
        private static final long serialVersionUID = -5974082575968329887L;
        boolean escapedCharFound;
        int[] placeholderCharIndices;
        int placeholderCount;

        MessagePatternAnalysis() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ensurePlaceholderCharIndicesCapacity(int i2) {
            int[] iArr = this.placeholderCharIndices;
            if (iArr == null) {
                this.placeholderCharIndices = new int[Math.max(i2, 8)];
                return;
            }
            if (this.placeholderCount >= iArr.length) {
                if (i2 <= 0) {
                    i2 = Math.addExact(iArr.length, 8);
                }
                int[] iArr2 = new int[i2];
                System.arraycopy(this.placeholderCharIndices, 0, iArr2, 0, this.placeholderCount);
                this.placeholderCharIndices = iArr2;
            }
        }
    }

    private ParameterFormatter() {
    }

    static MessagePatternAnalysis analyzePattern(String str, int i2) {
        MessagePatternAnalysis messagePatternAnalysis = new MessagePatternAnalysis();
        analyzePattern(str, i2, messagePatternAnalysis);
        return messagePatternAnalysis;
    }

    private static void appendArray(Object obj, StringBuilder sb, Set<Object> set, Class<?> cls) {
        if (cls == byte[].class) {
            sb.append(Arrays.toString((byte[]) obj));
            return;
        }
        if (cls == short[].class) {
            sb.append(Arrays.toString((short[]) obj));
            return;
        }
        if (cls == int[].class) {
            sb.append(Arrays.toString((int[]) obj));
            return;
        }
        if (cls == long[].class) {
            sb.append(Arrays.toString((long[]) obj));
            return;
        }
        if (cls == float[].class) {
            sb.append(Arrays.toString((float[]) obj));
            return;
        }
        if (cls == double[].class) {
            sb.append(Arrays.toString((double[]) obj));
            return;
        }
        if (cls == boolean[].class) {
            sb.append(Arrays.toString((boolean[]) obj));
            return;
        }
        if (cls == char[].class) {
            sb.append(Arrays.toString((char[]) obj));
            return;
        }
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        boolean z = true;
        if (!orCreateDejaVu.add(obj)) {
            String strIdentityToString = identityToString(obj);
            sb.append("[...");
            sb.append(strIdentityToString);
            sb.append("...]");
            return;
        }
        sb.append('[');
        for (Object obj2 : (Object[]) obj) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            recursiveDeepToString(obj2, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(']');
    }

    private static void appendCollection(Object obj, StringBuilder sb, Set<Object> set) {
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        boolean z = true;
        if (!orCreateDejaVu.add(obj)) {
            String strIdentityToString = identityToString(obj);
            sb.append("[...");
            sb.append(strIdentityToString);
            sb.append("...]");
            return;
        }
        sb.append('[');
        for (Object obj2 : (Collection) obj) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            recursiveDeepToString(obj2, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(']');
    }

    private static boolean appendDate(Object obj, StringBuilder sb) {
        if (!(obj instanceof Date)) {
            return false;
        }
        DATE_FORMATTER.formatTo(((Date) obj).toInstant(), sb);
        return true;
    }

    private static void appendMap(Object obj, StringBuilder sb, Set<Object> set) {
        Set<Object> orCreateDejaVu = getOrCreateDejaVu(set);
        boolean z = true;
        if (!orCreateDejaVu.add(obj)) {
            String strIdentityToString = identityToString(obj);
            sb.append("[...");
            sb.append(strIdentityToString);
            sb.append("...]");
            return;
        }
        sb.append(DELIM_START);
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            Object key = entry.getKey();
            Object value = entry.getValue();
            recursiveDeepToString(key, sb, cloneDejaVu(orCreateDejaVu));
            sb.append(Chars.EQ);
            recursiveDeepToString(value, sb, cloneDejaVu(orCreateDejaVu));
        }
        sb.append(DELIM_STOP);
    }

    private static void appendPotentiallyRecursiveValue(Object obj, StringBuilder sb, Set<Object> set) {
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            appendArray(obj, sb, set, cls);
            return;
        }
        if (obj instanceof Map) {
            appendMap(obj, sb, set);
        } else {
            if (obj instanceof Collection) {
                appendCollection(obj, sb, set);
                return;
            }
            throw new IllegalArgumentException("was expecting a container, found " + cls);
        }
    }

    private static boolean appendSpecialTypes(Object obj, StringBuilder sb) {
        return StringBuilders.appendSpecificTypes(sb, obj) || appendDate(obj, sb);
    }

    private static Set<Object> cloneDejaVu(Set<Object> set) {
        Set<Object> setCreateDejaVu = createDejaVu();
        setCreateDejaVu.addAll(set);
        return setCreateDejaVu;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void copyMessagePatternContainingEscapes(StringBuilder sb, String str, int i2, int i3) {
        boolean z = false;
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\\') {
                if (z) {
                    z = false;
                } else {
                    sb.append(cCharAt);
                    z = true;
                }
            } else if (!z) {
                sb.append(cCharAt);
            } else if (cCharAt == '{') {
                int i4 = i2 + 1;
                if (str.charAt(i4) == '}') {
                    sb.setLength(sb.length() - 1);
                    sb.append("{}");
                    i2 = i4;
                } else {
                    sb.append(cCharAt);
                }
                z = false;
            }
            i2++;
        }
    }

    private static Set<Object> createDejaVu() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    static String deepToString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return Integer.toString(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return Long.toString(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return Double.toString(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return Boolean.toString(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Character) {
            return Character.toString(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return Short.toString(((Short) obj).shortValue());
        }
        if (obj instanceof Float) {
            return Float.toString(((Float) obj).floatValue());
        }
        if (obj instanceof Byte) {
            return Byte.toString(((Byte) obj).byteValue());
        }
        StringBuilder sb = new StringBuilder();
        recursiveDeepToString(obj, sb);
        return sb.toString();
    }

    static String format(String str, Object[] objArr, int i2) {
        StringBuilder sb = new StringBuilder();
        formatMessage(sb, str, objArr, i2, analyzePattern(str, i2));
        return sb.toString();
    }

    static void formatMessage(StringBuilder sb, String str, Object[] objArr, int i2, MessagePatternAnalysis messagePatternAnalysis) {
        int i3;
        if (str == null || objArr == null || (i3 = messagePatternAnalysis.placeholderCount) == 0) {
            sb.append(str);
            return;
        }
        if (i3 != i2) {
            if (i3 != (i2 < 1 ? 0 : i2 - (objArr[i2 + (-1)] instanceof Throwable ? 1 : 0))) {
                STATUS_LOGGER.warn("found {} argument placeholders, but provided {} for pattern `{}`", Integer.valueOf(i3), Integer.valueOf(i2), str);
            }
        }
        if (messagePatternAnalysis.escapedCharFound) {
            formatMessageContainingEscapes(sb, str, objArr, i2, messagePatternAnalysis);
        } else {
            formatMessageContainingNoEscapes(sb, str, objArr, i2, messagePatternAnalysis);
        }
    }

    private static void formatMessageContainingEscapes(StringBuilder sb, String str, Object[] objArr, int i2, MessagePatternAnalysis messagePatternAnalysis) {
        int iMin = Math.min(messagePatternAnalysis.placeholderCount, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < iMin; i4++) {
            int i5 = messagePatternAnalysis.placeholderCharIndices[i4];
            copyMessagePatternContainingEscapes(sb, str, i3, i5);
            recursiveDeepToString(objArr[i4], sb);
            i3 = i5 + 2;
        }
        copyMessagePatternContainingEscapes(sb, str, i3, str.length());
    }

    private static void formatMessageContainingNoEscapes(StringBuilder sb, String str, Object[] objArr, int i2, MessagePatternAnalysis messagePatternAnalysis) {
        int iMin = Math.min(messagePatternAnalysis.placeholderCount, i2);
        int i3 = 0;
        for (int i4 = 0; i4 < iMin; i4++) {
            int i5 = messagePatternAnalysis.placeholderCharIndices[i4];
            sb.append((CharSequence) str, i3, i5);
            recursiveDeepToString(objArr[i4], sb);
            i3 = i5 + 2;
        }
        sb.append((CharSequence) str, i3, str.length());
    }

    private static Set<Object> getOrCreateDejaVu(Set<Object> set) {
        return set == null ? createDejaVu() : set;
    }

    private static void handleErrorInObjectToString(Object obj, StringBuilder sb, Throwable th) {
        sb.append("[!!!");
        sb.append(identityToString(obj));
        sb.append("=>");
        String message = th.getMessage();
        String name = th.getClass().getName();
        sb.append(name);
        if (!name.equals(message)) {
            sb.append(":");
            sb.append(message);
        }
        sb.append("!!!]");
    }

    static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
    }

    private static boolean isMaybeRecursive(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Map) || (obj instanceof Collection);
    }

    static void recursiveDeepToString(Object obj, StringBuilder sb) {
        recursiveDeepToString(obj, sb, null);
    }

    private static void tryObjectToString(Object obj, StringBuilder sb) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            handleErrorInObjectToString(obj, sb, th);
        }
    }

    private static void recursiveDeepToString(Object obj, StringBuilder sb, Set<Object> set) {
        if (appendSpecialTypes(obj, sb)) {
            return;
        }
        if (isMaybeRecursive(obj)) {
            appendPotentiallyRecursiveValue(obj, sb, set);
        } else {
            tryObjectToString(obj, sb);
        }
    }

    static void analyzePattern(String str, int i2, MessagePatternAnalysis messagePatternAnalysis) {
        int length;
        int i3;
        if (str != null && (length = str.length()) >= 2) {
            messagePatternAnalysis.placeholderCount = 0;
            messagePatternAnalysis.escapedCharFound = false;
            int i4 = 0;
            boolean z = false;
            while (i4 < length - 1) {
                char cCharAt = str.charAt(i4);
                if (cCharAt == '\\') {
                    messagePatternAnalysis.escapedCharFound = true;
                    z = !z;
                } else if (z) {
                    z = false;
                } else if (cCharAt == '{') {
                    int i5 = i4 + 1;
                    if (str.charAt(i5) == '}') {
                        if (i2 < 0 || (i3 = messagePatternAnalysis.placeholderCount) < i2) {
                            messagePatternAnalysis.ensurePlaceholderCharIndicesCapacity(i2);
                            int[] iArr = messagePatternAnalysis.placeholderCharIndices;
                            int i6 = messagePatternAnalysis.placeholderCount;
                            messagePatternAnalysis.placeholderCount = i6 + 1;
                            iArr[i6] = i4;
                        } else {
                            messagePatternAnalysis.placeholderCount = i3 + 1;
                        }
                        i4 = i5;
                    }
                }
                i4++;
            }
            return;
        }
        messagePatternAnalysis.placeholderCount = 0;
    }
}
