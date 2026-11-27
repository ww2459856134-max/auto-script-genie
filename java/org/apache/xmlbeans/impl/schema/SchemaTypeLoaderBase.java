package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XPathFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";

    private static String doCompilePath(String str, XmlOptions xmlOptions) {
        return XPathFactory.compilePath(str, xmlOptions);
    }

    private static String doCompileQuery(String str, XmlOptions xmlOptions) {
        return XPathFactory.compileQuery(str, xmlOptions);
    }

    public String compilePath(String str) {
        return compilePath(str, null);
    }

    public String compileQuery(String str) {
        return compileQuery(str, null);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        SchemaGlobalAttribute.Ref refFindAttributeRef = findAttributeRef(qName);
        if (refFindAttributeRef == null) {
            return null;
        }
        return refFindAttributeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = findAttributeGroupRef(qName);
        if (refFindAttributeGroupRef == null) {
            return null;
        }
        return refFindAttributeGroupRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        SchemaType.Ref refFindAttributeTypeRef = findAttributeTypeRef(qName);
        if (refFindAttributeTypeRef == null) {
            return null;
        }
        return refFindAttributeTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        SchemaType.Ref refFindDocumentTypeRef = findDocumentTypeRef(qName);
        if (refFindDocumentTypeRef == null) {
            return null;
        }
        return refFindDocumentTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        SchemaGlobalElement.Ref refFindElementRef = findElementRef(qName);
        if (refFindElementRef == null) {
            return null;
        }
        return refFindElementRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        SchemaModelGroup.Ref refFindModelGroupRef = findModelGroupRef(qName);
        if (refFindModelGroupRef == null) {
            return null;
        }
        return refFindModelGroupRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        SchemaType.Ref refFindTypeRef = findTypeRef(qName);
        if (refFindTypeRef == null) {
            return null;
        }
        return refFindTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return Locale.newDomImplementation(this, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newInstance(this, schemaType, xmlOptions) : Locale.newInstance(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newXmlSaxHandler(this, schemaType, xmlOptions) : Locale.newSaxHandler(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.parse(this, str, schemaType, xmlOptions) : Locale.parseToXmlObject(this, str, schemaType, xmlOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013e  */
    @Override // org.apache.xmlbeans.SchemaTypeLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SchemaType typeForSignature(String str) throws NumberFormatException {
        String strSubstring;
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
            strSubstring = "";
        } else {
            strSubstring = str.substring(iIndexOf + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < iIndexOf) {
            int iIndexOf2 = str.indexOf(58, i2);
            int iIndexOf3 = str.indexOf(124, i2);
            if (iIndexOf2 < 0) {
                iIndexOf2 = iIndexOf3;
            } else if (iIndexOf3 >= 0) {
                iIndexOf2 = Math.min(iIndexOf2, iIndexOf3);
            }
            if (iIndexOf2 < 0 || iIndexOf2 > iIndexOf) {
                iIndexOf2 = iIndexOf;
            }
            arrayList.add(str.substring(i2, iIndexOf2));
            i2 = iIndexOf2 + 1;
        }
        SchemaType type = null;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str2 = (String) arrayList.get(size);
            if (str2.length() < 1) {
                throw new IllegalArgumentException();
            }
            int i3 = (str2.length() < 2 || str2.charAt(1) != '=') ? 1 : 2;
            char cCharAt = str2.charAt(0);
            if (cCharAt == 'I') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                if (type.getSimpleVariety() != 3) {
                    return null;
                }
                SchemaType[] anonymousTypes = type.getAnonymousTypes();
                if (anonymousTypes.length != 1) {
                    return null;
                }
                type = anonymousTypes[0];
            } else if (cCharAt == 'M') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                try {
                    int i4 = Integer.parseInt(str2.substring(i3));
                    if (type.getSimpleVariety() != 2) {
                        return null;
                    }
                    SchemaType[] anonymousTypes2 = type.getAnonymousTypes();
                    if (anonymousTypes2.length <= i4) {
                        return null;
                    }
                    type = anonymousTypes2[i4];
                } catch (Exception unused) {
                    throw new IllegalArgumentException();
                }
            } else if (cCharAt == 'Q') {
                if (type != null) {
                    if (type.isSimpleType()) {
                        return null;
                    }
                    SchemaType[] anonymousTypes3 = type.getAnonymousTypes();
                    String strSubstring2 = str2.substring(i3);
                    for (SchemaType schemaType : anonymousTypes3) {
                        SchemaField containerField = schemaType.getContainerField();
                        if (containerField != null && containerField.isAttribute() && containerField.getName().getLocalPart().equals(strSubstring2)) {
                            type = schemaType;
                        }
                    }
                    return null;
                }
                SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i3), strSubstring));
                if (schemaGlobalAttributeFindAttribute == null) {
                    return null;
                }
                type = schemaGlobalAttributeFindAttribute.getType();
            } else if (cCharAt == 'R') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findAttributeType(QNameHelper.forLNS(str2.substring(i3), strSubstring));
                if (type == null) {
                    return null;
                }
                continue;
            } else if (cCharAt == 'T') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findType(QNameHelper.forLNS(str2.substring(i3), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt != 'U') {
                switch (cCharAt) {
                    case 'A':
                        break;
                    case 'B':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        if (type.getSimpleVariety() != 1) {
                            return null;
                        }
                        SchemaType[] anonymousTypes4 = type.getAnonymousTypes();
                        if (anonymousTypes4.length != 1) {
                            return null;
                        }
                        type = anonymousTypes4[0];
                        continue;
                    case 'C':
                        break;
                    case 'D':
                        if (type != null) {
                            throw new IllegalArgumentException();
                        }
                        type = findDocumentType(QNameHelper.forLNS(str2.substring(i3), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        continue;
                    case 'E':
                        if (type != null) {
                            if (type.getContentType() < 3) {
                                return null;
                            }
                            SchemaType[] anonymousTypes5 = type.getAnonymousTypes();
                            String strSubstring3 = str2.substring(i3);
                            int length = anonymousTypes5.length;
                            for (int i5 = 0; i5 < length; i5++) {
                                schemaType = anonymousTypes5[i5];
                                SchemaField containerField2 = schemaType.getContainerField();
                                if (containerField2 != null && !containerField2.isAttribute() && containerField2.getName().getLocalPart().equals(strSubstring3)) {
                                    break;
                                }
                            }
                            return null;
                        }
                        SchemaGlobalElement schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i3), strSubstring));
                        if (schemaGlobalElementFindElement == null) {
                            return null;
                        }
                        type = schemaGlobalElementFindElement.getType();
                        break;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                type = schemaType;
            }
        }
        return type;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compilePath(String str, XmlOptions xmlOptions) {
        return doCompilePath(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compileQuery(String str, XmlOptions xmlOptions) {
        return doCompileQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLStreamReader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLStreamReader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        String string = file.toURI().normalize().toString();
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.setDocumentSourceName(string);
        } else if (xmlOptions.getDocumentSourceName() == null) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setDocumentSourceName(string);
            xmlOptions = xmlOptions2;
        }
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            XmlObject xmlObject = parse(inputStreamNewInputStream, schemaType, xmlOptions);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return xmlObject;
        } finally {
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        URLConnection uRLConnectionOpenConnection;
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.setDocumentSourceName(url.toString());
        } else if (xmlOptions.getDocumentSourceName() == null) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setDocumentSourceName(url.toString());
            xmlOptions = xmlOptions2;
        }
        int i2 = 0;
        boolean z = false;
        do {
            uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.addRequestProperty("User-Agent", USER_AGENT);
            uRLConnectionOpenConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                int responseCode = httpURLConnection.getResponseCode();
                boolean z2 = responseCode == 301 || responseCode == 302;
                if (z2 && i2 > 5) {
                    z2 = false;
                }
                if (z2) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        z = false;
                    } else {
                        url = new URL(headerField);
                        i2++;
                        z = z2;
                    }
                } else {
                    z = z2;
                }
            }
        } while (z);
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            XmlObject xmlObject = parse(inputStream, schemaType, xmlOptions);
            if (inputStream != null) {
                inputStream.close();
            }
            return xmlObject;
        } finally {
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        DigestInputStream digestInputStream;
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (xmlOptions == null || !xmlOptions.isLoadMessageDigest()) {
            digestInputStream = null;
        } else {
            try {
                digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
                inputStream = digestInputStream;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        if (hook != null) {
            return hook.parse(this, inputStream, schemaType, xmlOptions);
        }
        XmlObject toXmlObject = Locale.parseToXmlObject(this, inputStream, schemaType, xmlOptions);
        if (digestInputStream != null) {
            toXmlObject.documentProperties().setMessageDigest(digestInputStream.getMessageDigest().digest());
        }
        return toXmlObject;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException, IOException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, reader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, reader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, node, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, node, schemaType, xmlOptions);
    }
}
