package com.auto.exceldeps.log4j.message;

import com.auto.exceldeps.log4j.util.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ObjectArrayMessage implements Message {
    private static final long serialVersionUID = -5903272448334166185L;
    private transient Object[] array;
    private transient String arrayString;

    public ObjectArrayMessage(Object... objArr) {
        this.array = objArr == null ? Constants.EMPTY_OBJECT_ARRAY : objArr;
    }

    private boolean equalObjectsOrStrings(Object[] objArr, Object[] objArr2) {
        return Arrays.equals(objArr, objArr2) || Arrays.toString(objArr).equals(Arrays.toString(objArr2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.array = (Object[]) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.array);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ObjectArrayMessage.class != obj.getClass()) {
            return false;
        }
        Object[] objArr = this.array;
        Object[] objArr2 = ((ObjectArrayMessage) obj).array;
        return objArr == null ? objArr2 == null : equalObjectsOrStrings(objArr, objArr2);
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormat() {
        return getFormattedMessage();
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public String getFormattedMessage() {
        if (this.arrayString == null) {
            this.arrayString = Arrays.toString(this.array);
        }
        return this.arrayString;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Object[] getParameters() {
        return this.array;
    }

    @Override // com.auto.exceldeps.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.array);
    }

    public String toString() {
        return getFormattedMessage();
    }
}
