package org.apache.xmlbeans.impl.regex;

/* loaded from: classes.dex */
public class ParseException extends RuntimeException {
    int location;

    public ParseException(String str, int i2) {
        super(str);
        this.location = i2;
    }

    public int getLocation() {
        return this.location;
    }
}
