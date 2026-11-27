package org.apache.poi.javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;

/* loaded from: classes.dex */
class FactoryFinder {
    static /* synthetic */ Class class$javax$xml$stream$FactoryFinder;
    private static boolean debug;

    private static abstract class ClassLoaderFinder {
        private ClassLoaderFinder() {
        }

        abstract ClassLoader getContextClassLoader();
    }

    static class ClassLoaderFinderConcrete extends ClassLoaderFinder {
        ClassLoaderFinderConcrete() {
            super();
        }

        @Override // org.apache.poi.javax.xml.stream.FactoryFinder.ClassLoaderFinder
        ClassLoader getContextClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }

    static {
        try {
            debug = System.getProperty("xml.stream.debug") != null;
        } catch (Exception unused) {
        }
    }

    FactoryFinder() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private static void debugPrintln(String str) {
        if (debug) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("STREAM: ");
            stringBuffer.append(str);
            printStream.println(stringBuffer.toString());
        }
    }

    static Object find(String str) throws FactoryConfigurationError {
        return find(str, null);
    }

    private static ClassLoader findClassLoader() throws FactoryConfigurationError {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Class clsClass$ = class$javax$xml$stream$FactoryFinder;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$;
            }
            stringBuffer.append(clsClass$.getName());
            stringBuffer.append("$ClassLoaderFinderConcrete");
            return ((ClassLoaderFinder) Class.forName(stringBuffer.toString()).newInstance()).getContextClassLoader();
        } catch (ClassNotFoundException unused) {
            Class clsClass$2 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$2 == null) {
                clsClass$2 = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$2;
            }
            return clsClass$2.getClassLoader();
        } catch (Exception e) {
            throw new FactoryConfigurationError(e.toString(), e);
        } catch (LinkageError unused2) {
            Class clsClass$3 = class$javax$xml$stream$FactoryFinder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("org.apache.poi.javax.xml.stream.FactoryFinder");
                class$javax$xml$stream$FactoryFinder = clsClass$3;
            }
            return clsClass$3.getClassLoader();
        }
    }

    private static Object newInstance(String str, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (classLoader == null ? Class.forName(str) : classLoader.loadClass(str)).newInstance();
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Provider ");
            stringBuffer.append(str);
            stringBuffer.append(" not found");
            throw new FactoryConfigurationError(stringBuffer.toString(), e);
        } catch (Exception e2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Provider ");
            stringBuffer2.append(str);
            stringBuffer2.append(" could not be instantiated: ");
            stringBuffer2.append(e2);
            throw new FactoryConfigurationError(stringBuffer2.toString(), e2);
        }
    }

    static Object find(String str, String str2) throws FactoryConfigurationError {
        return find(str, str2, findClassLoader());
    }

    static Object find(String str, String str2, ClassLoader classLoader) throws IOException, FactoryConfigurationError {
        InputStream resourceAsStream;
        try {
            String property = System.getProperty(str);
            if (property != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("found system property");
                stringBuffer.append(property);
                debugPrintln(stringBuffer.toString());
                return newInstance(property, classLoader);
            }
        } catch (SecurityException unused) {
        }
        try {
            String property2 = System.getProperty("java.home");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(property2);
            String str3 = File.separator;
            stringBuffer2.append(str3);
            stringBuffer2.append("lib");
            stringBuffer2.append(str3);
            stringBuffer2.append("jaxp.properties");
            File file = new File(stringBuffer2.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String property3 = properties.getProperty(str);
                if (property3 != null && property3.length() > 0) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("found java.home property ");
                    stringBuffer3.append(property3);
                    debugPrintln(stringBuffer3.toString());
                    return newInstance(property3, classLoader);
                }
            }
        } catch (Exception e) {
            if (debug) {
                e.printStackTrace();
            }
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("META-INF/services/");
        stringBuffer4.append(str);
        String string = stringBuffer4.toString();
        try {
            if (classLoader == null) {
                resourceAsStream = ClassLoader.getSystemResourceAsStream(string);
            } else {
                resourceAsStream = classLoader.getResourceAsStream(string);
            }
            if (resourceAsStream != null) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("found ");
                stringBuffer5.append(string);
                debugPrintln(stringBuffer5.toString());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                if (line != null && !"".equals(line)) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("loaded from services: ");
                    stringBuffer6.append(line);
                    debugPrintln(stringBuffer6.toString());
                    return newInstance(line, classLoader);
                }
            }
        } catch (Exception e2) {
            if (debug) {
                e2.printStackTrace();
            }
        }
        if (str2 != null) {
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("loaded from fallback value: ");
            stringBuffer7.append(str2);
            debugPrintln(stringBuffer7.toString());
            return newInstance(str2, classLoader);
        }
        StringBuffer stringBuffer8 = new StringBuffer();
        stringBuffer8.append("Provider for ");
        stringBuffer8.append(str);
        stringBuffer8.append(" cannot be found");
        throw new FactoryConfigurationError(stringBuffer8.toString(), (Exception) null);
    }
}
