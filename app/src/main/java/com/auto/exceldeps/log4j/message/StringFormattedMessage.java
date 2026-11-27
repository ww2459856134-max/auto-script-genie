package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes.dex */
public class StringFormattedMessage implements Message {
    private static final int HASHVAL = 31;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final long serialVersionUID = -665975803997290697L;
    private transient Object[] argArray;
    private transient String formattedMessage;
    private final Locale locale;
    private String messagePattern;
    private String[] stringArgs;
    private transient Throwable throwable;

    public StringFormattedMessage(Locale locale, String str, Object... objArr) {
        this.locale = locale;
        this.messagePattern = str;
        this.argArray = objArr;
        if (objArr == null || objArr.length <= 0 || !(objArr[objArr.length - 1] instanceof Throwable)) {
            return;
        }
        this.throwable = (Throwable) objArr[objArr.length - 1];
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
        if (!(obj instanceof StringFormattedMessage)) {
            return false;
        }
        StringFormattedMessage stringFormattedMessage = (StringFormattedMessage) obj;
        String str = this.messagePattern;
        if (str == null ? stringFormattedMessage.messagePattern == null : str.equals(stringFormattedMessage.messagePattern)) {
            return Arrays.equals(this.stringArgs, stringFormattedMessage.stringArgs);
        }
        return false;
    }

    protected String formatMessage(String str, Object... objArr) {
        if (objArr != null && objArr.length == 0) {
            return str;
        }
        try {
            return String.format(this.locale, str, objArr);
        } catch (IllegalFormatException e) {
            LOGGER.error("Unable to format msg: {}", str, e);
            return str;
        }
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            this.formattedMessage = formatMessage(this.messagePattern, this.argArray);
        }
        return this.formattedMessage;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = this.argArray;
        return objArr != null ? objArr : this.stringArgs;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
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

    public StringFormattedMessage(String str, Object... objArr) {
        this(Locale.getDefault(Locale.Category.FORMAT), str, objArr);
    }
}
