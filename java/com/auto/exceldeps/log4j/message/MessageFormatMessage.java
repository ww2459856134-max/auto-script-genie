package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: classes.dex */
public class MessageFormatMessage implements Message {
    private static final int HASHVAL = 31;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final long serialVersionUID = 1;
    private transient String formattedMessage;
    private final Locale locale;
    private String messagePattern;
    private transient Object[] parameters;
    private String[] serializedParameters;
    private transient Throwable throwable;

    public MessageFormatMessage(Locale locale, String str, Object... objArr) {
        this.locale = locale;
        this.messagePattern = str;
        this.parameters = objArr;
        int length = objArr == null ? 0 : objArr.length;
        if (length > 0) {
            int i2 = length - 1;
            if (objArr[i2] instanceof Throwable) {
                this.throwable = (Throwable) objArr[i2];
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.parameters = null;
        this.throwable = null;
        this.formattedMessage = objectInputStream.readUTF();
        this.messagePattern = objectInputStream.readUTF();
        int i2 = objectInputStream.readInt();
        this.serializedParameters = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.serializedParameters[i3] = objectInputStream.readUTF();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getFormattedMessage();
        objectOutputStream.writeUTF(this.formattedMessage);
        objectOutputStream.writeUTF(this.messagePattern);
        Object[] objArr = this.parameters;
        int length = objArr == null ? 0 : objArr.length;
        objectOutputStream.writeInt(length);
        this.serializedParameters = new String[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                this.serializedParameters[i2] = String.valueOf(this.parameters[i2]);
                objectOutputStream.writeUTF(this.serializedParameters[i2]);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFormatMessage)) {
            return false;
        }
        MessageFormatMessage messageFormatMessage = (MessageFormatMessage) obj;
        String str = this.messagePattern;
        if (str == null ? messageFormatMessage.messagePattern == null : str.equals(messageFormatMessage.messagePattern)) {
            return Arrays.equals(this.serializedParameters, messageFormatMessage.serializedParameters);
        }
        return false;
    }

    protected String formatMessage(String str, Object... objArr) {
        try {
            return new MessageFormat(str, this.locale).format(objArr);
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
            this.formattedMessage = formatMessage(this.messagePattern, this.parameters);
        }
        return this.formattedMessage;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = this.parameters;
        return objArr != null ? objArr : this.serializedParameters;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        String str = this.messagePattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.serializedParameters;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        return getFormattedMessage();
    }

    public MessageFormatMessage(String str, Object... objArr) {
        this(Locale.getDefault(Locale.Category.FORMAT), str, objArr);
    }
}
