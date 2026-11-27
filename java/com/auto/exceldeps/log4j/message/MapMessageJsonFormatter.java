package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.IndexedStringMap;
import com.auto.exceldeps.log4j.util.PropertiesUtil;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.auto.exceldeps.log4j.util.StringBuilders;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* loaded from: classes.dex */
enum MapMessageJsonFormatter {
    ;

    private static final char COLON = ':';
    private static final char COMMA = ',';
    private static final char DQUOTE = '\"';
    private static final char LBRACE = '[';
    private static final char LCURLY = '{';
    public static final int MAX_DEPTH = readMaxDepth();
    private static final char RBRACE = ']';
    private static final char RCURLY = '}';

    static /* synthetic */ void a(boolean[] zArr, StringBuilder sb, int i2, Object obj) {
        if (zArr[0]) {
            zArr[0] = false;
        } else {
            sb.append(COMMA);
        }
        format(sb, obj, i2);
    }

    static /* synthetic */ void b(boolean[] zArr, StringBuilder sb, int i2, Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException("null keys are not allowed");
        }
        if (zArr[0]) {
            zArr[0] = false;
        } else {
            sb.append(COMMA);
        }
        sb.append('\"');
        String strValueOf = String.valueOf(obj);
        int length = sb.length();
        sb.append(strValueOf);
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
        sb.append(':');
        format(sb, obj2, i2);
    }

    static void format(StringBuilder sb, Object obj) {
        format(sb, obj, 0);
    }

    private static void formatBoolean(StringBuilder sb, boolean z) {
        sb.append(z);
    }

    private static void formatBooleanArray(StringBuilder sb, boolean[] zArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < zArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append(zArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatByteArray(StringBuilder sb, byte[] bArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append((int) bArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatCharArray(StringBuilder sb, char[] cArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            char c = cArr[i2];
            sb.append('\"');
            int length = sb.length();
            sb.append(c);
            StringBuilders.escapeJson(sb, length);
            sb.append('\"');
        }
        sb.append(RBRACE);
    }

    private static void formatCollection(final StringBuilder sb, Collection<Object> collection, int i2) {
        sb.append(LBRACE);
        final int i3 = i2 + 1;
        final boolean[] zArr = {true};
        collection.forEach(new Consumer() { // from class: com.auto.exceldeps.log4j.message.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MapMessageJsonFormatter.a(zArr, sb, i3, obj);
            }
        });
        sb.append(RBRACE);
    }

    private static void formatDoubleArray(StringBuilder sb, double[] dArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append(dArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatFloatArray(StringBuilder sb, float[] fArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append(fArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatFormattable(StringBuilder sb, StringBuilderFormattable stringBuilderFormattable) {
        sb.append('\"');
        int length = sb.length();
        stringBuilderFormattable.formatTo(sb);
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
    }

    private static void formatIndexedStringMap(StringBuilder sb, IndexedStringMap indexedStringMap, int i2) {
        sb.append(LCURLY);
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < indexedStringMap.size(); i4++) {
            String keyAt = indexedStringMap.getKeyAt(i4);
            Object valueAt = indexedStringMap.getValueAt(i4);
            if (i4 > 0) {
                sb.append(COMMA);
            }
            sb.append('\"');
            int length = sb.length();
            sb.append(keyAt);
            StringBuilders.escapeJson(sb, length);
            sb.append('\"');
            sb.append(':');
            format(sb, valueAt, i3);
        }
        sb.append(RCURLY);
    }

    private static void formatIntArray(StringBuilder sb, int[] iArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append(iArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatList(StringBuilder sb, List<Object> list, int i2) {
        sb.append(LBRACE);
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (i4 > 0) {
                sb.append(COMMA);
            }
            format(sb, list.get(i4), i3);
        }
        sb.append(RBRACE);
    }

    private static void formatLongArray(StringBuilder sb, long[] jArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append(jArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatMap(final StringBuilder sb, Map<Object, Object> map, int i2) {
        sb.append(LCURLY);
        final int i3 = i2 + 1;
        final boolean[] zArr = {true};
        map.forEach(new BiConsumer() { // from class: com.auto.exceldeps.log4j.message.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MapMessageJsonFormatter.b(zArr, sb, i3, obj, obj2);
            }
        });
        sb.append(RCURLY);
    }

    private static void formatNumber(StringBuilder sb, Number number) {
        if (number instanceof BigDecimal) {
            sb.append(((BigDecimal) number).toString());
            return;
        }
        if (number instanceof Double) {
            sb.append(((Double) number).doubleValue());
            return;
        }
        if (number instanceof Float) {
            sb.append(((Float) number).floatValue());
            return;
        }
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            sb.append(number.longValue());
            return;
        }
        long jLongValue = number.longValue();
        double dDoubleValue = number.doubleValue();
        if (Double.compare(jLongValue, dDoubleValue) == 0) {
            sb.append(jLongValue);
        } else {
            sb.append(dDoubleValue);
        }
    }

    private static void formatObjectArray(StringBuilder sb, Object[] objArr, int i2) {
        sb.append(LBRACE);
        int i3 = i2 + 1;
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (i4 > 0) {
                sb.append(COMMA);
            }
            format(sb, objArr[i4], i3);
        }
        sb.append(RBRACE);
    }

    private static void formatShortArray(StringBuilder sb, short[] sArr) {
        sb.append(LBRACE);
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 > 0) {
                sb.append(COMMA);
            }
            sb.append((int) sArr[i2]);
        }
        sb.append(RBRACE);
    }

    private static void formatString(StringBuilder sb, Object obj) {
        sb.append('\"');
        int length = sb.length();
        sb.append(String.valueOf(obj));
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
    }

    private static int readMaxDepth() {
        int integerProperty = PropertiesUtil.getProperties().getIntegerProperty("log4j2.mapMessage.jsonFormatter.maxDepth", 8);
        if (integerProperty >= 0) {
            return integerProperty;
        }
        throw new IllegalArgumentException("was expecting a positive maxDepth, found: " + integerProperty);
    }

    private static void format(StringBuilder sb, Object obj, int i2) {
        if (i2 >= MAX_DEPTH) {
            throw new IllegalArgumentException("maxDepth has been exceeded");
        }
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (obj instanceof IndexedStringMap) {
            formatIndexedStringMap(sb, (IndexedStringMap) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            formatMap(sb, (Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            formatList(sb, (List) obj, i2);
            return;
        }
        if (obj instanceof Collection) {
            formatCollection(sb, (Collection) obj, i2);
            return;
        }
        if (obj instanceof Number) {
            formatNumber(sb, (Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            formatBoolean(sb, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof StringBuilderFormattable) {
            formatFormattable(sb, (StringBuilderFormattable) obj);
            return;
        }
        if (obj instanceof char[]) {
            formatCharArray(sb, (char[]) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            formatBooleanArray(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            formatByteArray(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            formatShortArray(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            formatIntArray(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            formatLongArray(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            formatFloatArray(sb, (float[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            formatDoubleArray(sb, (double[]) obj);
        } else if (obj instanceof Object[]) {
            formatObjectArray(sb, (Object[]) obj, i2);
        } else {
            formatString(sb, obj);
        }
    }
}
