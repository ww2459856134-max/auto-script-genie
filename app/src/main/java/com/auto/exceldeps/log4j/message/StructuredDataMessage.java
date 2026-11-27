package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.EnglishEnums;
import com.auto.exceldeps.log4j.util.StringBuilders;
import java.util.Map;

@AsynchronouslyFormattable
/* loaded from: classes.dex */
public class StructuredDataMessage extends MapMessage<StructuredDataMessage, String> {
    private static final int HASHVAL = 31;
    private static final int MAX_LENGTH = 32;
    private static final long serialVersionUID = 1703221292892071920L;
    private StructuredDataId id;
    private final int maxLength;
    private String message;
    private String type;

    public enum Format {
        XML,
        FULL
    }

    public StructuredDataMessage(String str, String str2, String str3) {
        this(str, str2, str3, 32);
    }

    private void asXml(StructuredDataId structuredDataId, StringBuilder sb) {
        sb.append("<StructuredData>\n");
        sb.append("<type>");
        sb.append(this.type);
        sb.append("</type>\n");
        sb.append("<id>");
        sb.append(structuredDataId);
        sb.append("</id>\n");
        super.asXml(sb);
        sb.append("\n</StructuredData>\n");
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public String asString() {
        return asString(Format.FULL, null);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StructuredDataMessage)) {
            return false;
        }
        StructuredDataMessage structuredDataMessage = (StructuredDataMessage) obj;
        if (!super.equals(obj)) {
            return false;
        }
        String str = this.type;
        if (str == null ? structuredDataMessage.type != null : !str.equals(structuredDataMessage.type)) {
            return false;
        }
        StructuredDataId structuredDataId = this.id;
        if (structuredDataId == null ? structuredDataMessage.id != null : !structuredDataId.equals(structuredDataMessage.id)) {
            return false;
        }
        String str2 = this.message;
        return str2 == null ? structuredDataMessage.message == null : str2.equals(structuredDataMessage.message);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        asString(Format.FULL, null, sb);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.message.MultiformatMessage
    public String[] getFormats() {
        String[] strArr = new String[Format.values().length];
        Format[] formatArrValues = Format.values();
        int length = formatArrValues.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            strArr[i3] = formatArrValues[i2].name();
            i2++;
            i3++;
        }
        return strArr;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        return asString(Format.FULL, null);
    }

    public StructuredDataId getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        StructuredDataId structuredDataId = this.id;
        int iHashCode3 = (iHashCode2 + (structuredDataId != null ? structuredDataId.hashCode() : 0)) * 31;
        String str2 = this.message;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    protected void setId(String str) {
        this.id = new StructuredDataId(str, null, null);
    }

    protected void setMessageFormat(String str) {
        this.message = str;
    }

    protected void setType(String str) {
        if (str.length() <= 32) {
            this.type = str;
            return;
        }
        throw new IllegalArgumentException("structured data type exceeds maximum length of 32 characters: " + str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public String toString() {
        return asString(null, null);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, boolean z) {
        validateKey(str);
    }

    protected void validateKey(String str) {
        if (this.maxLength > 0 && str.length() > this.maxLength) {
            throw new IllegalArgumentException("Structured data keys are limited to " + this.maxLength + " characters. key: " + str);
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '!' || cCharAt > '~' || cCharAt == '=' || cCharAt == ']' || cCharAt == '\"') {
                throw new IllegalArgumentException("Structured data keys must contain printable US ASCII charactersand may not contain a space, =, ], or \"");
            }
        }
    }

    public StructuredDataMessage(String str, String str2, String str3, int i2) {
        this.id = new StructuredDataId(str, (String[]) null, (String[]) null, i2);
        this.message = str2;
        this.type = str3;
        this.maxLength = i2;
    }

    private Format getFormat(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return Format.FULL;
        }
        for (String str : strArr) {
            Format format = Format.XML;
            if (format.name().equalsIgnoreCase(str)) {
                return format;
            }
            Format format2 = Format.FULL;
            if (format2.name().equalsIgnoreCase(str)) {
                return format2;
            }
        }
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public String asString(String str) {
        try {
            return asString((Format) EnglishEnums.valueOf(Format.class, str), null);
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] strArr, StringBuilder sb) {
        asString(getFormat(strArr), null, sb);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage, com.auto.exceldeps.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] strArr) {
        return asString(getFormat(strArr), null);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    public StructuredDataMessage newInstance(Map<String, String> map) {
        return new StructuredDataMessage(this, map);
    }

    protected void setId(StructuredDataId structuredDataId) {
        this.id = structuredDataId;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, byte b) {
        validateKey(str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, char c) {
        validateKey(str);
    }

    public final String asString(Format format, StructuredDataId structuredDataId) {
        StringBuilder sb = new StringBuilder();
        asString(format, structuredDataId, sb);
        return sb.toString();
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, double d) {
        validateKey(str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, float f) {
        validateKey(str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, int i2) {
        validateKey(str);
    }

    public StructuredDataMessage(String str, String str2, String str3, Map<String, String> map) {
        this(str, str2, str3, map, 32);
    }

    public final void asString(Format format, StructuredDataId structuredDataId, StringBuilder sb) {
        String format2;
        boolean zEquals = Format.FULL.equals(format);
        if (zEquals) {
            if (getType() == null) {
                return;
            }
            sb.append(getType());
            sb.append(Chars.SPACE);
        }
        StructuredDataId id = getId();
        if (id != null) {
            structuredDataId = id.makeId(structuredDataId);
        }
        if (structuredDataId == null || structuredDataId.getName() == null) {
            return;
        }
        if (Format.XML.equals(format)) {
            asXml(structuredDataId, sb);
            return;
        }
        sb.append('[');
        StringBuilders.appendValue(sb, structuredDataId);
        sb.append(Chars.SPACE);
        appendMap(sb);
        sb.append(']');
        if (!zEquals || (format2 = getFormat()) == null) {
            return;
        }
        sb.append(Chars.SPACE);
        sb.append(format2);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, long j2) {
        validateKey(str);
    }

    public StructuredDataMessage(String str, String str2, String str3, Map<String, String> map, int i2) {
        super(map);
        this.id = new StructuredDataId(str, (String[]) null, (String[]) null, i2);
        this.message = str2;
        this.type = str3;
        this.maxLength = i2;
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, Object obj) {
        validateKey(str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, short s) {
        validateKey(str);
    }

    @Override // com.auto.exceldeps.log4j.message.MapMessage
    protected void validate(String str, String str2) {
        validateKey(str);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2) {
        this(structuredDataId, str, str2, 32);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, int i2) {
        this.id = structuredDataId;
        this.message = str;
        this.type = str2;
        this.maxLength = i2;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, Map<String, String> map) {
        this(structuredDataId, str, str2, map, 32);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, Map<String, String> map, int i2) {
        super(map);
        this.id = structuredDataId;
        this.message = str;
        this.type = str2;
        this.maxLength = i2;
    }

    private StructuredDataMessage(StructuredDataMessage structuredDataMessage, Map<String, String> map) {
        super(map);
        this.id = structuredDataMessage.id;
        this.message = structuredDataMessage.message;
        this.type = structuredDataMessage.type;
        this.maxLength = 32;
    }

    protected StructuredDataMessage() {
        this.maxLength = 32;
    }
}
