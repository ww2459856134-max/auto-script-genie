package com.auto.exceldeps.log4j.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public class FormattedMessage implements Message {
    private static final int HASHVAL = 31;
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private final Locale locale;
    private Message message;
    private String messagePattern;
    private String[] stringArgs;
    private final Throwable throwable;

    public FormattedMessage(Locale locale, String str, Object obj) {
        this(locale, str, new Object[]{obj}, (Throwable) null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.formattedMessage = objectInputStream.readUTF();
        this.messagePattern = objectInputStream.readUTF();
        int i2 = objectInputStream.readInt();
        this.stringArgs = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.stringArgs[i3] = objectInputStream.readUTF();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.messagePattern);
        objectOutputStream.writeInt(this.argArray.length);
        Object[] objArr = this.argArray;
        this.stringArgs = new String[objArr.length];
        int i2 = 0;
        for (Object obj : objArr) {
            String strValueOf = String.valueOf(obj);
            this.stringArgs[i2] = strValueOf;
            objectOutputStream.writeUTF(strValueOf);
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormattedMessage)) {
            return false;
        }
        FormattedMessage formattedMessage = (FormattedMessage) obj;
        String str = this.messagePattern;
        if (str == null ? formattedMessage.messagePattern == null : str.equals(formattedMessage.messagePattern)) {
            return Arrays.equals(this.stringArgs, formattedMessage.stringArgs);
        }
        return false;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            if (this.message == null) {
                this.message = getMessage(this.messagePattern, this.argArray, this.throwable);
            }
            this.formattedMessage = this.message.getFormattedMessage();
        }
        return this.formattedMessage;
    }

    protected Message getMessage(String str, Object[] objArr, Throwable th) {
        try {
            if (new MessageFormat(str).getFormats().length > 0) {
                return new MessageFormatMessage(this.locale, str, objArr);
            }
        } catch (Exception unused) {
        }
        return (ParameterFormatter.analyzePattern(str, 1).placeholderCount > 0 || str.indexOf(37) == -1) ? new ParameterizedMessage(str, objArr, th) : new StringFormattedMessage(this.locale, str, objArr);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = this.argArray;
        return objArr != null ? objArr : this.stringArgs;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        Throwable th = this.throwable;
        if (th != null) {
            return th;
        }
        if (this.message == null) {
            this.message = getMessage(this.messagePattern, this.argArray, null);
        }
        return this.message.getThrowable();
    }

    public int hashCode() {
        String str = this.messagePattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.stringArgs;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        return getFormattedMessage();
    }

    public FormattedMessage(Locale locale, String str, Object obj, Object obj2) {
        this(locale, str, obj, obj2);
    }

    public FormattedMessage(Locale locale, String str, Object... objArr) {
        this(locale, str, objArr, (Throwable) null);
    }

    public FormattedMessage(Locale locale, String str, Object[] objArr, Throwable th) {
        this.locale = locale;
        this.messagePattern = str;
        this.argArray = objArr;
        this.throwable = th;
    }

    public FormattedMessage(String str, Object obj) {
        this(str, new Object[]{obj}, (Throwable) null);
    }

    public FormattedMessage(String str, Object obj, Object obj2) {
        this(str, obj, obj2);
    }

    public FormattedMessage(String str, Object... objArr) {
        this(str, objArr, (Throwable) null);
    }

    public FormattedMessage(String str, Object[] objArr, Throwable th) {
        this.locale = Locale.getDefault(Locale.Category.FORMAT);
        this.messagePattern = str;
        this.argArray = objArr;
        this.throwable = th;
    }
}
