package com.auto.exceldeps.log4j.util;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.LoggingException;
import com.auto.exceldeps.log4j.status.StatusLogger;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class Base64Util {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static Method encodeMethod;
    private static Object encoder;

    static {
        encodeMethod = null;
        encoder = null;
        try {
            try {
                Class<?> clsLoadClass = LoaderUtil.loadClass("java.util.Base64");
                Class<?> clsLoadClass2 = LoaderUtil.loadClass("java.util.Base64$Encoder");
                encoder = clsLoadClass.getMethod("getEncoder", new Class[0]).invoke(null, new Object[0]);
                encodeMethod = clsLoadClass2.getMethod("encodeToString", byte[].class);
            } catch (Exception e) {
                LOGGER.error("Unable to create a Base64 Encoder", (Throwable) e);
            }
        } catch (Exception unused) {
            encodeMethod = LoaderUtil.loadClass("javax.xml.bind.DataTypeConverter").getMethod("printBase64Binary", new Class[0]);
        }
    }

    private Base64Util() {
    }

    @Deprecated
    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        Method method = encodeMethod;
        if (method == null) {
            throw new LoggingException("No Encoder, unable to encode string");
        }
        try {
            return (String) method.invoke(encoder, bytes);
        } catch (Exception e) {
            throw new LoggingException("Unable to encode String", e);
        }
    }
}
