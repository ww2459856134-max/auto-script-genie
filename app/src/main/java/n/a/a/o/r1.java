package n.a.a.o;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.io.StringReader;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import org.apache.xmlbeans.impl.common.XMLBeansConstants;
import org.w3c.dom.Node;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* loaded from: classes.dex */
public abstract class r1 {
    private static long c;
    private static Object e;
    private static volatile boolean f;
    static final String[] a = {"org.apache.xerces.util.SecurityManager"};
    private static final Logger b = n.a.a.i.b.a(r1.class);
    private static final DocumentBuilderFactory d = d();

    static {
        e();
        f = false;
    }

    public static int b(Node node, int i2) throws n.a.a.c {
        return c(node, i2, 0);
    }

    private static int c(Node node, int i2, int i3) throws n.a.a.c {
        int i4 = i3 + 1;
        int i5 = i4;
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            int iC = c(firstChild, i2, i4);
            if (iC > i5) {
                if (iC > i2) {
                    throw new n.a.a.c(String.format(Locale.ROOT, "Node depth exceeds maximum supported depth of %s", Integer.valueOf(i2)));
                }
                i5 = iC;
            }
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DocumentBuilderFactory d() throws Error, RuntimeException {
        final DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        documentBuilderFactoryNewInstance.setValidating(false);
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        documentBuilderFactoryNewInstance.getClass();
        n(new q1() { // from class: n.a.a.o.b
            @Override // n.a.a.o.q1
            public final void a(String str, Object obj) throws IllegalArgumentException {
                documentBuilderFactoryNewInstance.setAttribute(str, obj);
            }
        }, "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        documentBuilderFactoryNewInstance.getClass();
        n(new q1() { // from class: n.a.a.o.b
            @Override // n.a.a.o.q1
            public final void a(String str, Object obj) throws IllegalArgumentException {
                documentBuilderFactoryNewInstance.setAttribute(str, obj);
            }
        }, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, "http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, "http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, false);
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, false);
        documentBuilderFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.e0
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws ParserConfigurationException {
                documentBuilderFactoryNewInstance.setFeature(str, z);
            }
        }, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, true);
        p(new p1() { // from class: n.a.a.o.w
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) {
                documentBuilderFactoryNewInstance.setXIncludeAware(z);
            }
        }, "XIncludeAware", false);
        Object objG = g();
        if (objG != null) {
            documentBuilderFactoryNewInstance.getClass();
            if (!q(new q1() { // from class: n.a.a.o.b
                @Override // n.a.a.o.q1
                public final void a(String str, Object obj) throws IllegalArgumentException {
                    documentBuilderFactoryNewInstance.setAttribute(str, obj);
                }
            }, XMLBeansConstants.SECURITY_MANAGER, objG)) {
                documentBuilderFactoryNewInstance.getClass();
                q(new q1() { // from class: n.a.a.o.b
                    @Override // n.a.a.o.q1
                    public final void a(String str, Object obj) throws IllegalArgumentException {
                        documentBuilderFactoryNewInstance.setAttribute(str, obj);
                    }
                }, XMLBeansConstants.ENTITY_EXPANSION_LIMIT, 1);
            }
        }
        return documentBuilderFactoryNewInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SAXParserFactory e() throws Throwable {
        try {
            final SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setValidating(false);
            sAXParserFactoryNewInstance.setNamespaceAware(true);
            sAXParserFactoryNewInstance.getClass();
            p(new p1() { // from class: n.a.a.o.c
                @Override // n.a.a.o.p1
                public final void a(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
                    sAXParserFactoryNewInstance.setFeature(str, z);
                }
            }, "http://javax.xml.XMLConstants/feature/secure-processing", true);
            sAXParserFactoryNewInstance.getClass();
            p(new p1() { // from class: n.a.a.o.c
                @Override // n.a.a.o.p1
                public final void a(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
                    sAXParserFactoryNewInstance.setFeature(str, z);
                }
            }, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, false);
            sAXParserFactoryNewInstance.getClass();
            p(new p1() { // from class: n.a.a.o.c
                @Override // n.a.a.o.p1
                public final void a(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
                    sAXParserFactoryNewInstance.setFeature(str, z);
                }
            }, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, false);
            sAXParserFactoryNewInstance.getClass();
            p(new p1() { // from class: n.a.a.o.c
                @Override // n.a.a.o.p1
                public final void a(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
                    sAXParserFactoryNewInstance.setFeature(str, z);
                }
            }, "http://xml.org/sax/features/external-general-entities", false);
            sAXParserFactoryNewInstance.getClass();
            p(new p1() { // from class: n.a.a.o.c
                @Override // n.a.a.o.p1
                public final void a(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException {
                    sAXParserFactoryNewInstance.setFeature(str, z);
                }
            }, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, true);
            return sAXParserFactoryNewInstance;
        } catch (Error e2) {
            e = e2;
            if (q0.a(e)) {
                k(e, "Failed to create SAXParserFactory", ProcessIdUtil.DEFAULT_PROCESSID);
                throw e;
            }
            q0.b(e);
            throw null;
        } catch (RuntimeException e3) {
            e = e3;
            if (q0.a(e)) {
            }
        } catch (Exception e4) {
            if (q0.a(e4)) {
                q0.b(e4);
                throw null;
            }
            k(e4, "Failed to create SAXParserFactory", ProcessIdUtil.DEFAULT_PROCESSID);
            throw new IllegalStateException("Failed to create SAXParserFactory", e4);
        }
    }

    public static TransformerFactory f() throws Error, RuntimeException {
        final TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
        transformerFactoryNewInstance.getClass();
        p(new p1() { // from class: n.a.a.o.g
            @Override // n.a.a.o.p1
            public final void a(String str, boolean z) throws TransformerConfigurationException {
                transformerFactoryNewInstance.setFeature(str, z);
            }
        }, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        transformerFactoryNewInstance.getClass();
        n(new q1() { // from class: n.a.a.o.e
            @Override // n.a.a.o.q1
            public final void a(String str, Object obj) {
                transformerFactoryNewInstance.setAttribute(str, obj);
            }
        }, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        transformerFactoryNewInstance.getClass();
        n(new q1() { // from class: n.a.a.o.e
            @Override // n.a.a.o.q1
            public final void a(String str, Object obj) {
                transformerFactoryNewInstance.setAttribute(str, obj);
            }
        }, "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        transformerFactoryNewInstance.getClass();
        n(new q1() { // from class: n.a.a.o.e
            @Override // n.a.a.o.q1
            public final void a(String str, Object obj) {
                transformerFactoryNewInstance.setAttribute(str, obj);
            }
        }, "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        return transformerFactoryNewInstance;
    }

    private static Object g() {
        if (f) {
            return e;
        }
        synchronized (r1.class) {
            if (!f) {
                e = o();
                f = true;
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputSource h(String str, String str2) {
        return new InputSource(new StringReader(""));
    }

    private static void k(Throwable th, String str, String str2) {
        if (System.currentTimeMillis() > c + TimeUnit.MINUTES.toMillis(5L)) {
            b.atWarn().withThrowable(th).log("{} [log suppressed for 5 minutes] {}", str, str2);
            c = System.currentTimeMillis();
        }
    }

    public static DocumentBuilder l() throws ParserConfigurationException {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = d.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(new EntityResolver() { // from class: n.a.a.o.x
                @Override // org.xml.sax.EntityResolver
                public final InputSource resolveEntity(String str, String str2) {
                    return r1.h(str, str2);
                }
            });
            documentBuilderNewDocumentBuilder.setErrorHandler(new o1(true));
            return documentBuilderNewDocumentBuilder;
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e2);
        }
    }

    public static Transformer m() throws TransformerConfigurationException, IllegalArgumentException {
        Transformer transformerNewTransformer = f().newTransformer();
        transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
        transformerNewTransformer.setOutputProperty("indent", "no");
        transformerNewTransformer.setOutputProperty("method", "xml");
        return transformerNewTransformer;
    }

    private static boolean n(q1 q1Var, String str, Object obj) throws Error, RuntimeException {
        try {
            q1Var.a(str, obj);
            return true;
        } catch (Throwable th) {
            if (!q0.a(th)) {
                return false;
            }
            q0.b(th);
            throw null;
        }
    }

    private static Object o() throws Error, RuntimeException {
        for (String str : a) {
            try {
                Object objNewInstance = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, 1);
                return objNewInstance;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                if (q0.a(th)) {
                    q0.b(th);
                    throw null;
                }
                k(th, "SAX Feature unsupported", str);
            }
        }
        return null;
    }

    private static boolean p(p1 p1Var, String str, boolean z) throws Error, RuntimeException {
        try {
            p1Var.a(str, z);
            return true;
        } catch (Error e2) {
            if (q0.a(e2)) {
                q0.b(e2);
                throw null;
            }
            k(e2, "Cannot set SAX feature because outdated XML parser in classpath", str);
            return false;
        } catch (Exception e3) {
            if (q0.a(e3)) {
                q0.b(e3);
                throw null;
            }
            k(e3, "SAX Feature unsupported", str);
            return false;
        }
    }

    private static boolean q(q1 q1Var, String str, Object obj) throws Error, RuntimeException {
        try {
            q1Var.a(str, obj);
            return true;
        } catch (Error e2) {
            if (q0.a(e2)) {
                q0.b(e2);
                throw null;
            }
            k(e2, "Cannot set SAX feature because outdated XML parser in classpath", str);
            return false;
        } catch (Exception e3) {
            if (q0.a(e3)) {
                q0.b(e3);
                throw null;
            }
            k(e3, "SAX Feature unsupported", str);
            return false;
        }
    }
}
