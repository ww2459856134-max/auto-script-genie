package org.apache.poi.javax.xml.stream;

/* loaded from: classes.dex */
public class XMLStreamException extends Exception {
    protected Location location;
    protected Throwable nested;

    public XMLStreamException() {
    }

    public Location getLocation() {
        return this.location;
    }

    public Throwable getNestedException() {
        return this.nested;
    }

    public XMLStreamException(String str) {
        super(str);
    }

    public XMLStreamException(Throwable th) {
        this.nested = th;
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public XMLStreamException(String str, Location location, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\n");
        stringBuffer.append("Message: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.nested = th;
        this.location = location;
    }

    public XMLStreamException(String str, Location location) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ParseError at [row,col]:[");
        stringBuffer.append(location.getLineNumber());
        stringBuffer.append(",");
        stringBuffer.append(location.getColumnNumber());
        stringBuffer.append("]\n");
        stringBuffer.append("Message: ");
        stringBuffer.append(str);
        super(stringBuffer.toString());
        this.location = location;
    }
}
