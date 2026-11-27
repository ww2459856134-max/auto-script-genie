package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.StringBuilderFormattable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public class SimpleMessage implements Message, StringBuilderFormattable, CharSequence {
    private static final long serialVersionUID = -8398002534962715992L;
    private transient CharSequence charSequence;
    private String message;

    public SimpleMessage() {
        this((String) null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.charSequence = this.message;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getFormattedMessage();
        objectOutputStream.defaultWriteObject();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.charSequence.charAt(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleMessage)) {
            return false;
        }
        SimpleMessage simpleMessage = (SimpleMessage) obj;
        return Objects.equals(this.charSequence, simpleMessage.charSequence) || Objects.equals(getFormattedMessage(), simpleMessage.getFormattedMessage());
    }

    @Override // com.auto.exceldeps.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        CharSequence charSequence = this.message;
        if (charSequence == null) {
            charSequence = this.charSequence;
        }
        sb.append(charSequence);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        String strValueOf = this.message;
        if (strValueOf == null) {
            strValueOf = String.valueOf(this.charSequence);
        }
        this.message = strValueOf;
        return strValueOf;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return null;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        CharSequence charSequence = this.charSequence;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    @Override // java.lang.CharSequence
    public int length() {
        CharSequence charSequence = this.charSequence;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.charSequence.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return getFormattedMessage();
    }

    public SimpleMessage(String str) {
        this.message = str;
        this.charSequence = str;
    }

    public SimpleMessage(CharSequence charSequence) {
        this.charSequence = charSequence;
    }
}
