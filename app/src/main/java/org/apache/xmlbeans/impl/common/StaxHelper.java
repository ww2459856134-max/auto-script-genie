package org.apache.xmlbeans.impl.common;

import com.auto.exceldeps.log4j.Logger;
import org.apache.poi.javax.xml.stream.XMLEventFactory;
import org.apache.poi.javax.xml.stream.XMLInputFactory;
import org.apache.poi.javax.xml.stream.XMLOutputFactory;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;

/* loaded from: classes.dex */
public final class StaxHelper {
    private static final Logger LOG = XmlBeansLogManager.getLogger(StaxHelper.class);

    private StaxHelper() {
    }

    public static XMLEventFactory newXMLEventFactory(XmlOptions xmlOptions) {
        return XMLEventFactory.newFactory();
    }

    public static XMLInputFactory newXMLInputFactory(XmlOptions xmlOptions) {
        XMLInputFactory xMLInputFactoryNewFactory = XMLInputFactory.newFactory();
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_NAMESPACE_AWARE, true);
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_VALIDATING, false);
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.SUPPORT_DTD, xmlOptions.isLoadDTDGrammar());
        trySetProperty(xMLInputFactoryNewFactory, XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, xmlOptions.isLoadExternalDTD());
        return xMLInputFactoryNewFactory;
    }

    public static XMLOutputFactory newXMLOutputFactory(XmlOptions xmlOptions) {
        XMLOutputFactory xMLOutputFactoryNewFactory = XMLOutputFactory.newFactory();
        trySetProperty(xMLOutputFactoryNewFactory, XMLOutputFactory.IS_REPAIRING_NAMESPACES, true);
        return xMLOutputFactoryNewFactory;
    }

    private static void trySetProperty(XMLInputFactory xMLInputFactory, String str, boolean z) {
        try {
            xMLInputFactory.setProperty(str, Boolean.valueOf(z));
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set StAX property {} because outdated StAX parser in classpath", str);
        } catch (Exception e2) {
            LOG.atWarn().withThrowable(e2).log("StAX Property unsupported: {}", str);
        }
    }

    private static void trySetProperty(XMLOutputFactory xMLOutputFactory, String str, boolean z) {
        try {
            xMLOutputFactory.setProperty(str, Boolean.valueOf(z));
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set StAX property {} because outdated StAX parser in classpath", str);
        } catch (Exception e2) {
            LOG.atWarn().withThrowable(e2).log("StAX Property unsupported: {}", str);
        }
    }
}
