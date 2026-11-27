package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.message.MapMessage;
import com.auto.exceldeps.log4j.util.BiConsumer;
import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.EnglishEnums;
import com.auto.exceldeps.log4j.util.IndexedReadOnlyStringMap;
import com.auto.exceldeps.log4j.util.IndexedStringMap;
import com.auto.exceldeps.log4j.util.MultiFormatStringBuilderFormattable;
import com.auto.exceldeps.log4j.util.PerformanceSensitive;
import com.auto.exceldeps.log4j.util.SortedArrayStringMap;
import com.auto.exceldeps.log4j.util.StringBuilders;
import com.auto.exceldeps.log4j.util.TriConsumer;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@PerformanceSensitive({"allocation"})
@AsynchronouslyFormattable
/* loaded from: classes.dex */
public class MapMessage<M extends MapMessage<M, V>, V> implements MultiFormatStringBuilderFormattable {
    private static final long serialVersionUID = -5031471831131487120L;
    private final IndexedStringMap data;

    /* renamed from: com.auto.exceldeps.log4j.message.MapMessage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat;

        static {
            int[] iArr = new int[MapFormat.values().length];
            $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat = iArr;
            try {
                iArr[MapFormat.XML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JAVA_UNQUOTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum MapFormat {
        XML,
        JSON,
        JAVA,
        JAVA_UNQUOTED;

        public static MapFormat lookupIgnoreCase(String str) {
            MapFormat mapFormat = XML;
            if (mapFormat.name().equalsIgnoreCase(str)) {
                return mapFormat;
            }
            MapFormat mapFormat2 = JSON;
            if (mapFormat2.name().equalsIgnoreCase(str)) {
                return mapFormat2;
            }
            MapFormat mapFormat3 = JAVA;
            if (mapFormat3.name().equalsIgnoreCase(str)) {
                return mapFormat3;
            }
            MapFormat mapFormat4 = JAVA_UNQUOTED;
            if (mapFormat4.name().equalsIgnoreCase(str)) {
                return mapFormat4;
            }
            return null;
        }

        public static String[] names() {
            return new String[]{XML.name(), JSON.name(), JAVA.name(), JAVA_UNQUOTED.name()};
        }
    }

    public MapMessage() {
        this.data = new SortedArrayStringMap();
    }

    private StringBuilder format(MapFormat mapFormat, StringBuilder sb) {
        if (mapFormat == null) {
            appendMap(sb);
        } else {
            int i2 = AnonymousClass1.$SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[mapFormat.ordinal()];
            if (i2 == 1) {
                asXml(sb);
            } else if (i2 == 2) {
                asJson(sb);
            } else if (i2 == 3) {
                asJava(sb);
            } else if (i2 != 4) {
                appendMap(sb);
            } else {
                asJavaUnquoted(sb);
            }
        }
        return sb;
    }

    private MapFormat getFormat(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                MapFormat mapFormatLookupIgnoreCase = MapFormat.lookupIgnoreCase(str);
                if (mapFormatLookupIgnoreCase != null) {
                    return mapFormatLookupIgnoreCase;
                }
            }
        }
        return null;
    }

    protected void appendMap(StringBuilder sb) {
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            if (i2 > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(this.data.getKeyAt(i2));
            sb.append(Chars.EQ);
            sb.append(Chars.DQUOTE);
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i2), sb);
            sb.append(Chars.DQUOTE);
        }
    }

    protected void asJava(StringBuilder sb) {
        asJava(sb, true);
    }

    protected void asJavaUnquoted(StringBuilder sb) {
        asJava(sb, false);
    }

    protected void asJson(StringBuilder sb) {
        MapMessageJsonFormatter.format(sb, this.data);
    }

    public String asString() {
        return format(null, new StringBuilder()).toString();
    }

    public void asXml(StringBuilder sb) {
        sb.append("<Map>\n");
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            sb.append("  <Entry key=\"");
            sb.append(this.data.getKeyAt(i2));
            sb.append("\">");
            int length = sb.length();
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i2), sb);
            StringBuilders.escapeXml(sb, length);
            sb.append("</Entry>\n");
        }
        sb.append("</Map>");
    }

    public void clear() {
        this.data.clear();
    }

    public boolean containsKey(String str) {
        return this.data.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MapMessage) {
            return this.data.equals(((MapMessage) obj).data);
        }
        return false;
    }

    public <CV> void forEach(BiConsumer<String, ? super CV> biConsumer) {
        this.data.forEach(biConsumer);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        format(null, sb);
    }

    public String get(String str) {
        return ParameterFormatter.deepToString(this.data.getValue(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, V> getData() {
        TreeMap treeMap = new TreeMap();
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            treeMap.put(this.data.getKeyAt(i2), this.data.getValueAt(i2));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return "";
    }

    @Override // com.auto.exceldeps.log4j.message.MultiformatMessage
    public String[] getFormats() {
        return MapFormat.names();
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        return asString();
    }

    public IndexedReadOnlyStringMap getIndexedReadOnlyStringMap() {
        return this.data;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = new Object[this.data.size()];
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            objArr[i2] = this.data.getValueAt(i2);
        }
        return objArr;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public M newInstance(Map<String, V> map) {
        return (M) new MapMessage(map);
    }

    public void put(String str, String str2) {
        if (str2 != null) {
            String key = toKey(str);
            validate(key, str2);
            this.data.putValue(key, str2);
        } else {
            throw new IllegalArgumentException("No value provided for key " + str);
        }
    }

    public void putAll(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.data.putValue(entry.getKey(), entry.getValue());
        }
    }

    public String remove(String str) {
        String str2 = get(str);
        this.data.remove(str);
        return str2;
    }

    protected String toKey(String str) {
        return str;
    }

    public String toString() {
        return asString();
    }

    protected void validate(String str, byte b) {
    }

    protected void validate(String str, char c) {
    }

    protected void validate(String str, double d) {
    }

    protected void validate(String str, float f) {
    }

    protected void validate(String str, int i2) {
    }

    protected void validate(String str, long j2) {
    }

    protected void validate(String str, Object obj) {
    }

    protected void validate(String str, String str2) {
    }

    protected void validate(String str, short s) {
    }

    protected void validate(String str, boolean z) {
    }

    public M with(String str, boolean z) {
        String key = toKey(str);
        validate(key, z);
        this.data.putValue(key, Boolean.valueOf(z));
        return this;
    }

    private void asJava(StringBuilder sb, boolean z) {
        sb.append('{');
        for (int i2 = 0; i2 < this.data.size(); i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.data.getKeyAt(i2));
            sb.append(Chars.EQ);
            if (z) {
                sb.append(Chars.DQUOTE);
            }
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i2), sb);
            if (z) {
                sb.append(Chars.DQUOTE);
            }
        }
        sb.append('}');
    }

    public String asString(String str) {
        try {
            return format((MapFormat) EnglishEnums.valueOf(MapFormat.class, str), new StringBuilder()).toString();
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    public <CV, S> void forEach(TriConsumer<String, ? super CV, S> triConsumer, S s) {
        this.data.forEach(triConsumer, s);
    }

    @Override // com.auto.exceldeps.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] strArr, StringBuilder sb) {
        format(getFormat(strArr), sb);
    }

    @Override // com.auto.exceldeps.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] strArr) {
        return format(getFormat(strArr), new StringBuilder()).toString();
    }

    public MapMessage(int i2) {
        this.data = new SortedArrayStringMap(i2);
    }

    public M with(String str, byte b) {
        String key = toKey(str);
        validate(key, b);
        this.data.putValue(key, Byte.valueOf(b));
        return this;
    }

    public MapMessage(Map<String, V> map) {
        this.data = new SortedArrayStringMap((Map<String, ?>) map);
    }

    public M with(String str, char c) {
        String key = toKey(str);
        validate(key, c);
        this.data.putValue(key, Character.valueOf(c));
        return this;
    }

    public M with(String str, double d) {
        String key = toKey(str);
        validate(key, d);
        this.data.putValue(key, Double.valueOf(d));
        return this;
    }

    public M with(String str, float f) {
        String key = toKey(str);
        validate(key, f);
        this.data.putValue(key, Float.valueOf(f));
        return this;
    }

    public M with(String str, int i2) {
        String key = toKey(str);
        validate(key, i2);
        this.data.putValue(key, Integer.valueOf(i2));
        return this;
    }

    public M with(String str, long j2) {
        String key = toKey(str);
        validate(key, j2);
        this.data.putValue(key, Long.valueOf(j2));
        return this;
    }

    public M with(String str, Object obj) {
        String key = toKey(str);
        validate(key, obj);
        this.data.putValue(key, obj);
        return this;
    }

    public M with(String str, short s) {
        String key = toKey(str);
        validate(key, s);
        this.data.putValue(key, Short.valueOf(s));
        return this;
    }

    public M with(String str, String str2) {
        put(toKey(str), str2);
        return this;
    }
}
