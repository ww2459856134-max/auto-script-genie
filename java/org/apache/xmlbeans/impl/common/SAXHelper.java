package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;
import org.apache.xmlbeans.impl.util.ExceptionUtil;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* loaded from: classes.dex */
public final class SAXHelper {
    private static long lastLog;
    private static final Logger LOG = XmlBeansLogManager.getLogger(SAXHelper.class);
    public static final EntityResolver IGNORING_ENTITY_RESOLVER = new EntityResolver() { // from class: org.apache.xmlbeans.impl.common.a
        @Override // org.xml.sax.EntityResolver
        public final InputSource resolveEntity(String str, String str2) {
            return SAXHelper.a(str, str2);
        }
    };

    private SAXHelper() {
    }

    static /* synthetic */ InputSource a(String str, String str2) throws SAXException, IOException {
        return new InputSource(new StringReader(""));
    }

    public static XMLReader newXMLReader(XmlOptions xmlOptions) throws ParserConfigurationException, SAXException {
        XMLReader xMLReader = saxFactory(xmlOptions).newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
        trySetSAXFeature(xMLReader, "http://javax.xml.XMLConstants/feature/secure-processing");
        trySetXercesSecurityManager(xMLReader, xmlOptions);
        return xMLReader;
    }

    static SAXParserFactory saxFactory() {
        return saxFactory(new XmlOptions());
    }

    private static void trySetSAXFeature(SAXParserFactory sAXParserFactory, String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
        try {
            sAXParserFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because outdated XML parser in classpath", str);
        } catch (Exception e2) {
            LOG.atWarn().withThrowable(e2).log("SAX Feature unsupported: {}", str);
        }
    }

    private static void trySetXercesSecurityManager(XMLReader xMLReader, XmlOptions xmlOptions) throws SAXNotRecognizedException, SAXNotSupportedException {
        Class<?> cls;
        String[] strArr = {"org.apache.xerces.util.SecurityManager"};
        for (int i2 = 0; i2 < 1; i2++) {
            try {
                cls = Class.forName(strArr[i2]);
            } catch (Throwable th) {
                if (ExceptionUtil.isFatal(th)) {
                    ExceptionUtil.rethrow(th);
                }
            }
            try {
                Object objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                cls.getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
                xMLReader.setProperty(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
                return;
            } catch (Throwable th2) {
                if (ExceptionUtil.isFatal(th2)) {
                    ExceptionUtil.rethrow(th2);
                }
                if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                    LOG.atWarn().withThrowable(th2).log("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
                    lastLog = System.currentTimeMillis();
                }
            }
        }
        try {
            xMLReader.setProperty(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
        } catch (SAXException e) {
            if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                LOG.atWarn().withThrowable(e).log("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
                lastLog = System.currentTimeMillis();
            }
        }
    }

    static SAXParserFactory saxFactory(XmlOptions xmlOptions) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setValidating(false);
        sAXParserFactoryNewInstance.setNamespaceAware(true);
        trySetSAXFeature(sAXParserFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptions.isLoadDTDGrammar());
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptions.isLoadExternalDTD());
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, xmlOptions.disallowDocTypeDeclaration());
        return sAXParserFactoryNewInstance;
    }

    private static void trySetSAXFeature(XMLReader xMLReader, String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        try {
            xMLReader.setFeature(str, true);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because outdated XML parser in classpath", str);
        } catch (Exception e2) {
            LOG.atWarn().withThrowable(e2).log("SAX Feature unsupported: {}", str);
        }
    }
}
