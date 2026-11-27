package com.auto.exceldeps.log4j.message;

import aQute.bnd.annotation.baseline.BaselineIgnore;
import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import com.auto.exceldeps.log4j.util.Strings;
import com.google.errorprone.annotations.InlineMe;
import java.io.Serializable;

/* loaded from: classes.dex */
public class StructuredDataId implements Serializable, StringBuilderFormattable {
    private static final String AT_SIGN = "@";
    private static final int MAX_LENGTH = 32;
    public static final String RESERVED = "-1";
    private static final long serialVersionUID = -8252896346202183738L;
    private final String enterpriseNumber;
    private final String name;
    private final String[] optional;
    private final String[] required;
    public static final StructuredDataId TIME_QUALITY = new StructuredDataId("timeQuality", null, new String[]{"tzKnown", "isSynced", "syncAccuracy"});
    public static final StructuredDataId ORIGIN = new StructuredDataId("origin", null, new String[]{"ip", "enterpriseId", "software", "swVersion"});
    public static final StructuredDataId META = new StructuredDataId("meta", null, new String[]{"sequenceId", "sysUpTime", "language"});

    public StructuredDataId(String str) {
        this(str, (String[]) null, (String[]) null, 32);
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        if (isReserved()) {
            sb.append(this.name);
            return;
        }
        sb.append(this.name);
        sb.append(AT_SIGN);
        sb.append(this.enterpriseNumber);
    }

    public String getEnterpriseNumber() {
        return this.enterpriseNumber;
    }

    public String getName() {
        return this.name;
    }

    public String[] getOptional() {
        return this.optional;
    }

    public String[] getRequired() {
        return this.required;
    }

    public boolean isReserved() {
        return RESERVED.equals(this.enterpriseNumber);
    }

    public StructuredDataId makeId(StructuredDataId structuredDataId) {
        return structuredDataId == null ? this : makeId(structuredDataId.getName(), structuredDataId.getEnterpriseNumber());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.name.length() + 10);
        formatTo(sb);
        return sb.toString();
    }

    public StructuredDataId(String str, int i2) {
        this(str, (String[]) null, (String[]) null, i2);
    }

    public StructuredDataId makeId(String str, String str2) {
        String[] strArr;
        if (RESERVED.equals(str2)) {
            return this;
        }
        String str3 = this.name;
        String[] strArr2 = null;
        if (str3 != null) {
            strArr2 = this.required;
            strArr = this.optional;
            str = str3;
        } else {
            strArr = null;
        }
        return new StructuredDataId(str, str2, strArr2, strArr);
    }

    public StructuredDataId(String str, String[] strArr, String[] strArr2) {
        this(str, strArr, strArr2, 32);
    }

    public StructuredDataId(String str, String[] strArr, String[] strArr2, int i2) {
        int iIndexOf;
        if (str != null) {
            i2 = i2 <= 0 ? 32 : i2;
            if (str.length() <= i2) {
                iIndexOf = str.indexOf(AT_SIGN);
            } else {
                throw new IllegalArgumentException(String.format("Length of id %s exceeds maximum of %d characters", str, Integer.valueOf(i2)));
            }
        } else {
            iIndexOf = -1;
        }
        if (iIndexOf > 0) {
            this.name = str.substring(0, iIndexOf);
            this.enterpriseNumber = str.substring(iIndexOf + 1).trim();
        } else {
            this.name = str;
            this.enterpriseNumber = RESERVED;
        }
        this.required = strArr;
        this.optional = strArr2;
    }

    @InlineMe(replacement = "this.makeId(defaultId, String.valueOf(anEnterpriseNumber))")
    @BaselineIgnore("2.22.0")
    @Deprecated
    public final StructuredDataId makeId(String str, int i2) {
        return makeId(str, String.valueOf(i2));
    }

    public StructuredDataId(String str, String str2, String[] strArr, String[] strArr2) {
        this(str, str2, strArr, strArr2, 32);
    }

    @InlineMe(replacement = "this(name, String.valueOf(enterpriseNumber), required, optional)")
    @Deprecated
    public StructuredDataId(String str, int i2, String[] strArr, String[] strArr2) {
        this(str, String.valueOf(i2), strArr, strArr2);
    }

    public StructuredDataId(String str, String str2, String[] strArr, String[] strArr2, int i2) {
        if (str != null) {
            if (!str.contains(AT_SIGN)) {
                if (!RESERVED.equals(str2)) {
                    this.name = str;
                    this.enterpriseNumber = str2;
                    String str3 = str + AT_SIGN + str2;
                    if (i2 > 0 && str3.length() > i2) {
                        throw new IllegalArgumentException("Length of id exceeds maximum of " + i2 + " characters: " + str3);
                    }
                    this.required = strArr;
                    this.optional = strArr2;
                    return;
                }
                throw new IllegalArgumentException("No enterprise number was supplied");
            }
            throw new IllegalArgumentException("Structured id name cannot contain an " + Strings.quote(AT_SIGN));
        }
        throw new IllegalArgumentException("No structured id name was supplied");
    }

    @InlineMe(replacement = "this(name, String.valueOf(enterpriseNumber), required, optional, maxLength)")
    @Deprecated
    public StructuredDataId(String str, int i2, String[] strArr, String[] strArr2, int i3) {
        this(str, String.valueOf(i2), strArr, strArr2, i3);
    }
}
