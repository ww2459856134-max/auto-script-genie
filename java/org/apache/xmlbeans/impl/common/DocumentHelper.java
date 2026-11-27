package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;
import org.apache.xmlbeans.impl.util.ExceptionUtil;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes.dex */
public final class DocumentHelper {
    private static final Logger LOG = XmlBeansLogManager.getLogger(DocumentHelper.class);
    private static final DocumentBuilder documentBuilderSingleton = newDocumentBuilder(new XmlOptions());
    private static long lastLog;

    private static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        private String asString(SAXParseException sAXParseException) {
            StringBuilder sb = new StringBuilder();
            String systemId = sAXParseException.getSystemId();
            if (systemId != null) {
                int iLastIndexOf = systemId.lastIndexOf(47);
                if (iLastIndexOf != -1) {
                    systemId = systemId.substring(iLastIndexOf + 1);
                }
                sb.append(systemId);
            }
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getLineNumber());
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getColumnNumber());
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            return sb.toString();
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
            DocumentHelper.LOG.atError().withThrowable(sAXParseException).log(asString(sAXParseException));
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            DocumentHelper.LOG.atFatal().withThrowable(sAXParseException).log(asString(sAXParseException));
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
            DocumentHelper.LOG.atWarn().withThrowable(sAXParseException).log(asString(sAXParseException));
        }
    }

    private DocumentHelper() {
    }

    public static Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    private static DocumentBuilderFactory documentBuilderFactory(XmlOptions xmlOptions) throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySetFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptions.isLoadDTDGrammar());
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptions.isLoadExternalDTD());
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, xmlOptions.disallowDocTypeDeclaration());
        trySetXercesSecurityManager(documentBuilderFactoryNewInstance, xmlOptions);
        return documentBuilderFactoryNewInstance;
    }

    public static DocumentBuilder newDocumentBuilder(XmlOptions xmlOptions) throws ParserConfigurationException {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactory(xmlOptions).newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
            return documentBuilderNewDocumentBuilder;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
    }

    public static Document readDocument(XmlOptions xmlOptions, InputStream inputStream) throws SAXException, IOException {
        return newDocumentBuilder(xmlOptions).parse(inputStream);
    }

    private static void trySetFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z) throws ParserConfigurationException {
        try {
            documentBuilderFactory.setFeature(str, z);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because of outdated XML parser in classpath", str);
        } catch (Exception e2) {
            LOG.atWarn().withThrowable(e2).log("SAX Feature unsupported: {}", str);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory, XmlOptions xmlOptions) {
        String[] strArr = {"org.apache.xerces.util.SecurityManager"};
        for (int i2 = 0; i2 < 1; i2++) {
            try {
                Object objNewInstance = Class.forName(strArr[i2]).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
                documentBuilderFactory.setAttribute(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
                return;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                if (ExceptionUtil.isFatal(th)) {
                    ExceptionUtil.rethrow(th);
                }
                if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                    LOG.atWarn().withThrowable(th).log("DocumentBuilderFactory Security Manager could not be setup [log suppressed for 5 minutes]");
                    lastLog = System.currentTimeMillis();
                }
            }
        }
        try {
            documentBuilderFactory.setAttribute(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
        } catch (Throwable th2) {
            if (ExceptionUtil.isFatal(th2)) {
                ExceptionUtil.rethrow(th2);
            }
            if (System.currentTimeMillis() > lastLog + TimeUnit.MINUTES.toMillis(5L)) {
                LOG.atWarn().withThrowable(th2).log("DocumentBuilderFactory Entity Expansion Limit could not be setup [log suppressed for 5 minutes]");
                lastLog = System.currentTimeMillis();
            }
        }
    }

    public static Document readDocument(XmlOptions xmlOptions, InputSource inputSource) throws SAXException, IOException {
        return newDocumentBuilder(xmlOptions).parse(inputSource);
    }
}
