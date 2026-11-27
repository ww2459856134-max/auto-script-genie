package org.apache.xmlbeans.impl.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.config.InterfaceExtensionImpl;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;

/* loaded from: classes.dex */
public class BindingConfigImpl extends BindingConfig {
    private final File[] _classpath;
    private final File[] _javaFiles;
    private Parser _parser;
    private final Map<Object, String> _packageMap = new LinkedHashMap();
    private final Map<Object, String> _prefixMap = new LinkedHashMap();
    private final Map<Object, String> _suffixMap = new LinkedHashMap();
    private final Map<Object, String> _packageMapByUriPrefix = new LinkedHashMap();
    private final Map<Object, String> _prefixMapByUriPrefix = new LinkedHashMap();
    private final Map<Object, String> _suffixMapByUriPrefix = new LinkedHashMap();
    private final Map<QName, String> _qnameTypeMap = new LinkedHashMap();
    private final Map<QName, String> _qnameDocTypeMap = new LinkedHashMap();
    private final Map<QName, String> _qnameElemMap = new LinkedHashMap();
    private final Map<QName, String> _qnameAttMap = new LinkedHashMap();
    private final List<InterfaceExtensionImpl> _interfaceExtensions = new ArrayList();
    private final List<PrePostExtensionImpl> _prePostExtensions = new ArrayList();
    private final Map<QName, UserTypeImpl> _userTypes = new LinkedHashMap();

    private BindingConfigImpl(ConfigDocument.Config[] configArr, File[] fileArr, File[] fileArr2) {
        this._javaFiles = fileArr != null ? (File[]) fileArr.clone() : new File[0];
        this._classpath = fileArr2 != null ? (File[]) fileArr2.clone() : new File[0];
        for (ConfigDocument.Config config : configArr) {
            for (Nsconfig nsconfig : config.getNamespaceArray()) {
                recordNamespaceSetting(nsconfig.getUri(), nsconfig.getPackage(), this._packageMap);
                recordNamespaceSetting(nsconfig.getUri(), nsconfig.getPrefix(), this._prefixMap);
                recordNamespaceSetting(nsconfig.getUri(), nsconfig.getSuffix(), this._suffixMap);
                recordNamespacePrefixSetting(nsconfig.getUriprefix(), nsconfig.getPackage(), this._packageMapByUriPrefix);
                recordNamespacePrefixSetting(nsconfig.getUriprefix(), nsconfig.getPrefix(), this._prefixMapByUriPrefix);
                recordNamespacePrefixSetting(nsconfig.getUriprefix(), nsconfig.getSuffix(), this._suffixMapByUriPrefix);
            }
            for (Qnameconfig qnameconfig : config.getQnameArray()) {
                List<XmlAnySimpleType> listXgetListValue = qnameconfig.xgetTarget().xgetListValue();
                QName name = qnameconfig.getName();
                String javaname = qnameconfig.getJavaname();
                for (XmlAnySimpleType xmlAnySimpleType : listXgetListValue) {
                    if (xmlAnySimpleType instanceof Qnametargetenum) {
                        int iIntValue = ((Qnametargetenum) xmlAnySimpleType).getEnumValue().intValue();
                        if (iIntValue == 1) {
                            this._qnameTypeMap.put(name, javaname);
                        } else if (iIntValue == 2) {
                            this._qnameDocTypeMap.put(name, javaname);
                        } else if (iIntValue == 3) {
                            this._qnameElemMap.put(name, javaname);
                        } else if (iIntValue == 4) {
                            this._qnameAttMap.put(name, javaname);
                        }
                    }
                }
            }
            for (Extensionconfig extensionconfig : config.getExtensionArray()) {
                recordExtensionSetting(extensionconfig);
            }
            for (Usertypeconfig usertypeconfig : config.getUsertypeArray()) {
                recordUserTypeSetting(usertypeconfig);
            }
        }
        secondPhaseValidation();
    }

    static /* synthetic */ InterfaceExtension[] b(int i2) {
        return new InterfaceExtension[i2];
    }

    static /* synthetic */ void d(Map map, String str, Object obj) {
    }

    static /* synthetic */ void e(Map map, String str, Object obj) {
        if ("##local".equals(obj)) {
            obj = "";
        }
    }

    static void error(String str, XmlObject xmlObject) {
        StscState.get().error(str, 0, xmlObject);
    }

    public static BindingConfig forConfigDocuments(ConfigDocument.Config[] configArr, File[] fileArr, File[] fileArr2) {
        return new BindingConfigImpl(configArr, fileArr, fileArr2);
    }

    private String lookup(Map<Object, String> map, Map<Object, String> map2, String str) {
        String strLookupByUriPrefix;
        if (str == null) {
            str = "";
        }
        String str2 = map.get(str);
        return str2 != null ? str2 : (map2 == null || (strLookupByUriPrefix = lookupByUriPrefix(map2, str)) == null) ? map.get("##any") : strLookupByUriPrefix;
    }

    private String lookupByUriPrefix(Map<Object, String> map, String str) {
        if (str != null && !map.isEmpty()) {
            String str2 = null;
            for (Object obj : map.keySet()) {
                if (obj instanceof String) {
                    String str3 = (String) obj;
                    if (str2 == null || str3.length() >= str2.length()) {
                        if (str.startsWith(str3)) {
                            str2 = str3;
                        }
                    }
                }
            }
            if (str2 != null) {
                return map.get(str2);
            }
        }
        return null;
    }

    private Parser parserInstance() {
        if (this._parser == null) {
            this._parser = new Parser(this._javaFiles, this._classpath);
        }
        return this._parser;
    }

    private void recordExtensionSetting(Extensionconfig extensionconfig) {
        NameSet nameSet;
        Object obj = extensionconfig.getFor();
        if ((obj instanceof String) && "*".equals(obj)) {
            nameSet = NameSet.EVERYTHING;
        } else if (obj instanceof List) {
            NameSetBuilder nameSetBuilder = new NameSetBuilder();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                nameSetBuilder.add((String) it.next());
            }
            nameSet = nameSetBuilder.toNameSet();
        } else {
            nameSet = null;
        }
        if (nameSet == null) {
            error("Invalid value of attribute 'for' : '" + obj + "'.", extensionconfig);
        }
        Extensionconfig.Interface[] interfaceArray = extensionconfig.getInterfaceArray();
        Extensionconfig.PrePostSet prePostSet = extensionconfig.getPrePostSet();
        Parser parser = parserInstance();
        if (interfaceArray.length > 0 || prePostSet != null) {
            for (Extensionconfig.Interface r0 : interfaceArray) {
                addInterfaceExtension(InterfaceExtensionImpl.newInstance(parser, nameSet, r0));
            }
            addPrePostExtension(PrePostExtensionImpl.newInstance(parser, nameSet, prePostSet));
        }
    }

    private static void recordNamespacePrefixSetting(List list, final String str, final Map<Object, String> map) {
        if (str == null || list == null) {
            return;
        }
        list.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.config.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                BindingConfigImpl.d(map, str, obj);
            }
        });
    }

    private static void recordNamespaceSetting(Object obj, final String str, final Map<Object, String> map) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            map.put("", str);
            return;
        }
        if ((obj instanceof String) && "##any".equals(obj)) {
            map.put(obj, str);
        } else if (obj instanceof List) {
            ((List) obj).forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.config.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    BindingConfigImpl.e(map, str, obj2);
                }
            });
        }
    }

    private void recordUserTypeSetting(Usertypeconfig usertypeconfig) {
        UserTypeImpl userTypeImplNewInstance = UserTypeImpl.newInstance(parserInstance(), usertypeconfig);
        this._userTypes.put(userTypeImplNewInstance.getName(), userTypeImplNewInstance);
    }

    static void warning(String str, XmlObject xmlObject) {
        StscState.get().error(str, 1, xmlObject);
    }

    void addInterfaceExtension(InterfaceExtensionImpl interfaceExtensionImpl) {
        if (interfaceExtensionImpl == null) {
            return;
        }
        this._interfaceExtensions.add(interfaceExtensionImpl);
    }

    void addPrePostExtension(PrePostExtensionImpl prePostExtensionImpl) {
        if (prePostExtensionImpl == null) {
            return;
        }
        this._prePostExtensions.add(prePostExtensionImpl);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public InterfaceExtension[] getInterfaceExtensions() {
        return (InterfaceExtension[]) this._interfaceExtensions.toArray(new InterfaceExtension[0]);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public PrePostExtension getPrePostExtension(final String str) {
        return this._prePostExtensions.stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((PrePostExtensionImpl) obj).contains(str);
            }
        }).findFirst().orElse(null);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public PrePostExtension[] getPrePostExtensions() {
        return (PrePostExtension[]) this._prePostExtensions.toArray(new PrePostExtension[0]);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public UserType[] getUserTypes() {
        return (UserType[]) this._userTypes.values().toArray(new UserType[0]);
    }

    public String lookupJavanameForQName(QName qName) {
        String str = this._qnameTypeMap.get(qName);
        return str != null ? str : this._qnameDocTypeMap.get(qName);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public String lookupPackageForNamespace(String str) {
        return lookup(this._packageMap, this._packageMapByUriPrefix, str);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public String lookupPrefixForNamespace(String str) {
        return lookup(this._prefixMap, this._prefixMapByUriPrefix, str);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public String lookupSuffixForNamespace(String str) {
        return lookup(this._suffixMap, this._suffixMapByUriPrefix, str);
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public UserType lookupUserTypeForQName(QName qName) {
        if (qName == null) {
            return null;
        }
        return this._userTypes.get(qName);
    }

    void secondPhaseValidation() {
        HashMap map = new HashMap();
        Iterator<InterfaceExtensionImpl> it = this._interfaceExtensions.iterator();
        while (true) {
            int i2 = 0;
            if (it.hasNext()) {
                InterfaceExtensionImpl.MethodSignatureImpl[] methodSignatureImplArr = (InterfaceExtensionImpl.MethodSignatureImpl[]) it.next().getMethods();
                int length = methodSignatureImplArr.length;
                while (i2 < length) {
                    InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl = methodSignatureImplArr[i2];
                    if (map.containsKey(methodSignatureImpl)) {
                        InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl2 = (InterfaceExtensionImpl.MethodSignatureImpl) map.get(methodSignatureImpl);
                        if (methodSignatureImpl.getReturnType().equals(methodSignatureImpl2.getReturnType())) {
                            return;
                        }
                        error("Colliding methods '" + methodSignatureImpl.getSignature() + "' in interfaces " + methodSignatureImpl.getInterfaceName() + " and " + methodSignatureImpl2.getInterfaceName() + ".", null);
                        return;
                    }
                    map.put(methodSignatureImpl, methodSignatureImpl);
                    i2++;
                }
            } else {
                while (true) {
                    if (i2 >= this._prePostExtensions.size() - 1) {
                        return;
                    }
                    PrePostExtensionImpl prePostExtensionImpl = this._prePostExtensions.get(i2);
                    for (int i3 = 1; i3 < this._prePostExtensions.size(); i3++) {
                        PrePostExtensionImpl prePostExtensionImpl2 = this._prePostExtensions.get(i3);
                        if (prePostExtensionImpl.hasNameSetIntersection(prePostExtensionImpl2)) {
                            error("The applicable domain for handler '" + prePostExtensionImpl.getHandlerNameForJavaSource() + "' intersects with the one for '" + prePostExtensionImpl2.getHandlerNameForJavaSource() + "'.", null);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public InterfaceExtension[] getInterfaceExtensions(final String str) {
        return (InterfaceExtension[]) this._interfaceExtensions.stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InterfaceExtensionImpl) obj).contains(str);
            }
        }).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.f
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return BindingConfigImpl.b(i2);
            }
        });
    }

    @Override // org.apache.xmlbeans.BindingConfig
    public String lookupJavanameForQName(QName qName, int i2) {
        if (i2 == 1) {
            return this._qnameTypeMap.get(qName);
        }
        if (i2 == 2) {
            return this._qnameDocTypeMap.get(qName);
        }
        if (i2 == 3) {
            return this._qnameElemMap.get(qName);
        }
        if (i2 != 4) {
            return null;
        }
        return this._qnameAttMap.get(qName);
    }
}
