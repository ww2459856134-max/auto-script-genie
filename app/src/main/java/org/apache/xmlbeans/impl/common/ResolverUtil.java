package org.apache.xmlbeans.impl.common;

import java.lang.reflect.InvocationTargetException;
import org.apache.xmlbeans.SystemProperties;
import org.xml.sax.EntityResolver;

/* loaded from: classes.dex */
public class ResolverUtil {
    private static EntityResolver _entityResolver;

    static {
        try {
            String property = SystemProperties.getProperty("xmlbean.entityResolver");
            if (property != null) {
                _entityResolver = (EntityResolver) Class.forName(property).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Exception unused) {
            _entityResolver = null;
        }
    }

    public static EntityResolver getGlobalEntityResolver() {
        return _entityResolver;
    }

    public static EntityResolver resolverForCatalog(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("org.apache.xml.resolver.CatalogManager");
            Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            cls.getMethod("setCatalogFiles", String.class).invoke(objNewInstance, str);
            return (EntityResolver) Class.forName("org.apache.xml.resolver.tools.CatalogResolver").getDeclaredConstructor(cls).newInstance(objNewInstance);
        } catch (Exception unused) {
            return null;
        }
    }
}
