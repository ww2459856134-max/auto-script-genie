package org.apache.xmlbeans.impl.soap;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.Properties;
import org.apache.xmlbeans.SystemProperties;

/* loaded from: classes.dex */
class FactoryFinder {
    FactoryFinder() {
    }

    static Object find(String str, String str2) throws SOAPException, IOException {
        try {
            String property = SystemProperties.getProperty(str);
            if (property != null) {
                return newInstance(property);
            }
        } catch (SecurityException unused) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemProperties.getProperty("java.home"));
            String str3 = File.separator;
            sb.append(str3);
            sb.append("lib");
            sb.append(str3);
            sb.append("jaxm.properties");
            File file = new File(sb.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
                try {
                    properties.load(inputStreamNewInputStream);
                    if (inputStreamNewInputStream != null) {
                        inputStreamNewInputStream.close();
                    }
                    return newInstance(properties.getProperty(str));
                } finally {
                }
            }
        } catch (Exception unused2) {
        }
        try {
            InputStream resource = getResource("META-INF/services/" + str);
            if (resource != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8));
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    if (line != null && !"".equals(line)) {
                        return newInstance(line);
                    }
                } finally {
                }
            }
        } catch (Exception unused3) {
        }
        if (str2 != null) {
            return newInstance(str2);
        }
        throw new SOAPException("Provider for " + str + " cannot be found", null);
    }

    private static InputStream getResource(String str) {
        ClassLoader contextClassLoader;
        try {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            contextClassLoader = null;
        }
        InputStream systemResourceAsStream = contextClassLoader == null ? ClassLoader.getSystemResourceAsStream(str) : contextClassLoader.getResourceAsStream(str);
        if (systemResourceAsStream == null) {
            systemResourceAsStream = FactoryFinder.class.getResourceAsStream(str);
        }
        return (systemResourceAsStream != null || FactoryFinder.class.getClassLoader() == null) ? systemResourceAsStream : FactoryFinder.class.getClassLoader().getResourceAsStream(str);
    }

    private static Object newInstance(String str) throws SOAPException, ClassNotFoundException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Class<?> clsLoadClass = null;
            try {
                if (contextClassLoader == null) {
                    try {
                        clsLoadClass = Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        throw new SOAPException("Provider " + str + " not found", e);
                    }
                } else {
                    try {
                        clsLoadClass = contextClassLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (clsLoadClass == null) {
                    clsLoadClass = FactoryFinder.class.getClassLoader().loadClass(str);
                }
                return clsLoadClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new SOAPException("Provider " + str + " could not be instantiated: " + e2, e2);
            }
        } catch (Exception e3) {
            throw new SOAPException(e3.toString(), e3);
        }
    }
}
