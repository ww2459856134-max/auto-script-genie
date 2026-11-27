package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.MessageFactory;

/* loaded from: classes.dex */
public final class LambdaUtil {
    private LambdaUtil() {
    }

    public static Object get(Supplier<?> supplier) {
        if (supplier == null) {
            return null;
        }
        Object obj = supplier.get();
        return obj instanceof Message ? ((Message) obj).getFormattedMessage() : obj;
    }

    public static Object[] getAll(Supplier<?>... supplierArr) {
        if (supplierArr == null) {
            return null;
        }
        int length = supplierArr.length;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            objArr[i2] = get(supplierArr[i2]);
        }
        return objArr;
    }

    public static Message getMessage(Supplier<?> supplier, MessageFactory messageFactory) {
        if (supplier == null) {
            return null;
        }
        Object obj = supplier.get();
        return obj instanceof Message ? (Message) obj : messageFactory.newMessage(obj);
    }

    public static Message get(MessageSupplier messageSupplier) {
        if (messageSupplier == null) {
            return null;
        }
        return messageSupplier.get();
    }
}
