package com.auto.exceldeps.log4j.util;

/* loaded from: classes.dex */
public final class Constants {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    public static final boolean ENABLE_THREADLOCALS;
    public static final boolean IS_WEB_APP;
    public static final int JAVA_MAJOR_VERSION;
    public static final String LOG4J2_DEBUG = "log4j2.debug";
    public static final int MAX_REUSABLE_MESSAGE_SIZE;

    static {
        boolean booleanProperty = PropertiesUtil.getProperties().getBooleanProperty("log4j2.is.webapp", isClassAvailable("javax.servlet.Servlet") || isClassAvailable("jakarta.servlet.Servlet"));
        IS_WEB_APP = booleanProperty;
        ENABLE_THREADLOCALS = PropertiesUtil.getProperties().getBooleanProperty("log4j2.enable.threadlocals", !booleanProperty);
        JAVA_MAJOR_VERSION = getMajorVersion();
        MAX_REUSABLE_MESSAGE_SIZE = size("log4j.maxReusableMsgSize", 518);
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    private Constants() {
    }

    private static int getMajorVersion() {
        return getMajorVersion(System.getProperty("java.version"));
    }

    private static boolean isClassAvailable(String str) {
        try {
            return LoaderUtil.loadClass(str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int size(String str, int i2) {
        return PropertiesUtil.getProperties().getIntegerProperty(str, i2);
    }

    static int getMajorVersion(String str) throws NumberFormatException {
        String[] strArrSplit = str.split("-|\\.", 3);
        try {
            int i2 = Integer.parseInt(strArrSplit[0]);
            return i2 != 1 ? i2 : Integer.parseInt(strArrSplit[1]);
        } catch (Exception unused) {
            return 0;
        }
    }
}
