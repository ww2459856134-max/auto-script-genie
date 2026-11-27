package org.apache.xmlbeans.impl.schema;

import com.auto.exceldeps.log4j.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.util.ExceptionUtil;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.util.LongUTFDataOutputStream;

/* loaded from: classes.dex */
public class SchemaTypeSystemImpl extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DATA_BABE = -629491010;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAIDENTITYCONSTRAINT = 8;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    public static final int MAJOR_VERSION = 2;
    public static final int MINOR_VERSION = 24;
    public static final int RELEASE_NUMBER = 0;
    private static Random _random;
    private List<SchemaAnnotation> _annotations;
    private Map<QName, SchemaComponent.Ref> _attributeGroups;
    private Map<QName, SchemaComponent.Ref> _attributeTypes;
    private ClassLoader _classloader;
    private SchemaDependencies _deps;
    private Map<QName, SchemaComponent.Ref> _documentTypes;
    private Filer _filer;
    private Map<QName, SchemaComponent.Ref> _globalAttributes;
    private Map<QName, SchemaComponent.Ref> _globalElements;
    private Map<QName, SchemaComponent.Ref> _globalTypes;
    SchemaTypeLoader _linker;
    private SchemaTypePool _localHandles;
    private Map<QName, SchemaComponent.Ref> _modelGroups;
    private final String _name;
    private Set<String> _namespaces;
    private List<SchemaComponent.Ref> _redefinedAttributeGroups;
    private List<SchemaComponent.Ref> _redefinedGlobalTypes;
    private List<SchemaComponent.Ref> _redefinedModelGroups;
    private ResourceLoader _resourceLoader;
    private String _sourceCodeEncoding;
    private static final Pattern packPat = Pattern.compile("^(.+)(\\.[^.]+){2}$");
    public static String METADATA_PACKAGE_GEN = "org/apache/xmlbeans/metadata";
    private static final SchemaType[] EMPTY_ST_ARRAY = new SchemaType[0];
    private static final SchemaGlobalElement[] EMPTY_GE_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaGlobalAttribute[] EMPTY_GA_ARRAY = new SchemaGlobalAttribute[0];
    private static final SchemaModelGroup[] EMPTY_MG_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_AG_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaIdentityConstraint[] EMPTY_IC_ARRAY = new SchemaIdentityConstraint[0];
    private static final SchemaAnnotation[] EMPTY_ANN_ARRAY = new SchemaAnnotation[0];
    private static final byte[] _mask = new byte[16];
    static final byte[] SINGLE_ZERO_BYTE = {0};
    private boolean _incomplete = false;
    private Map<String, SchemaContainer> _containers = new HashMap();
    private Map<QName, SchemaComponent.Ref> _identityConstraints = Collections.emptyMap();
    private Map<String, SchemaComponent.Ref> _typeRefsByClassname = new HashMap();
    private final Map<String, SchemaComponent> _resolvedHandles = new HashMap();
    private boolean _allNonGroupHandlesResolved = false;

    static class StringPool {
        private final String _handle;
        private final String _name;
        private final List<String> intsToStrings;
        private final Map<String, Integer> stringsToInts;

        StringPool(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            this.intsToStrings = arrayList;
            this.stringsToInts = new HashMap();
            this._handle = str;
            this._name = str2;
            arrayList.add(null);
        }

        int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer numValueOf = this.stringsToInts.get(str);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, numValueOf);
            }
            return numValueOf.intValue();
        }

        void readFrom(LongUTFDataInputStream longUTFDataInputStream) {
            if (this.intsToStrings.size() != 1 || !this.stringsToInts.isEmpty()) {
                throw new IllegalStateException();
            }
            try {
                int unsignedShortOrInt = longUTFDataInputStream.readUnsignedShortOrInt();
                for (int i2 = 1; i2 < unsignedShortOrInt; i2++) {
                    if (codeForString(longUTFDataInputStream.readLongUTF().intern()) != i2) {
                        throw new IllegalStateException();
                    }
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage() == null ? e.getMessage() : "IO Exception", this._name, this._handle, 9, e);
            }
        }

        String stringForCode(int i2) {
            if (i2 == 0) {
                return null;
            }
            return this.intsToStrings.get(i2);
        }

        void writeTo(LongUTFDataOutputStream longUTFDataOutputStream) {
            try {
                longUTFDataOutputStream.writeShortOrInt(this.intsToStrings.size());
                boolean z = false;
                for (String str : this.intsToStrings) {
                    if (z) {
                        longUTFDataOutputStream.writeLongUTF(str);
                    }
                    z = true;
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this._name, this._handle, 9, e);
            }
        }
    }

    protected SchemaTypeSystemImpl() {
        String name = getClass().getName();
        String strSubstring = name.substring(0, name.lastIndexOf(46));
        this._name = strSubstring;
        Logger logger = XBeanDebug.LOG;
        logger.atTrace().log("Loading type system {}", strSubstring);
        ClassLoader classLoader = getClass().getClassLoader();
        this._classloader = classLoader;
        this._linker = this;
        this._resourceLoader = new ClassLoaderResourceLoader(classLoader);
        try {
            initFromHeader();
            logger.atTrace().log("Finished loading type system {}", strSubstring);
        } catch (Error | RuntimeException e) {
            XBeanDebug.LOG.atDebug().withThrowable(e).log(e.getMessage());
            throw e;
        }
    }

    private void addContainer(String str) {
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(this);
        this._containers.put(str, schemaContainer);
    }

    private void assertContainersHelper(Map<QName, SchemaComponent.Ref> map, Function<SchemaContainer, List<? extends SchemaComponent>> function, Function<List<? extends SchemaComponent>, ? extends Map<QName, SchemaComponent.Ref>> function2) {
        Stream<R> map2 = this._containers.values().stream().map(function);
        if (function2 == null) {
            function2 = new Function() { // from class: org.apache.xmlbeans.impl.schema.r0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return SchemaTypeSystemImpl.buildComponentRefMap((List<? extends SchemaComponent>) obj);
                }
            };
        }
    }

    private void assertContainersSynchronized() {
    }

    static /* synthetic */ SchemaAttributeGroup[] b(int i2) {
        return new SchemaAttributeGroup[i2];
    }

    private static Map<QName, SchemaComponent.Ref> buildAttributeTypeMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SchemaType schemaType : schemaTypeArr) {
            linkedHashMap.put(schemaType.getAttributeTypeAttributeName(), schemaType.getRef());
        }
        return linkedHashMap;
    }

    private static List<SchemaComponent.Ref> buildComponentRefList(SchemaComponent[] schemaComponentArr) {
        return buildComponentRefList((List<? extends SchemaComponent>) Arrays.asList(schemaComponentArr));
    }

    private static Map<QName, SchemaComponent.Ref> buildComponentRefMap(SchemaComponent[] schemaComponentArr) {
        return buildComponentRefMap((List<? extends SchemaComponent>) Arrays.asList(schemaComponentArr));
    }

    private void buildContainers(List<QName> list, List<QName> list2, List<QName> list3) {
        buildContainersHelper(this._globalElements, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.w
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addGlobalElement((SchemaGlobalElement.Ref) obj2);
            }
        });
        buildContainersHelper(this._globalAttributes, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addGlobalAttribute((SchemaGlobalAttribute.Ref) obj2);
            }
        });
        buildContainersHelper(this._modelGroups, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.p2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addModelGroup((SchemaModelGroup.Ref) obj2);
            }
        });
        buildContainersHelper(this._attributeGroups, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.k2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addAttributeGroup((SchemaAttributeGroup.Ref) obj2);
            }
        });
        buildContainersHelper(this._identityConstraints, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.s
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addIdentityConstraint((SchemaIdentityConstraint.Ref) obj2);
            }
        });
        buildContainersHelper(this._globalTypes, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.q
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addGlobalType((SchemaType.Ref) obj2);
            }
        });
        buildContainersHelper(this._attributeTypes, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.h2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((SchemaContainer) obj).addAttributeType((SchemaType.Ref) obj2);
            }
        });
        List<SchemaComponent.Ref> list4 = this._redefinedGlobalTypes;
        if (list4 != null && this._redefinedModelGroups != null && this._redefinedAttributeGroups != null) {
            buildContainersHelper(list4, list, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.l
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((SchemaContainer) obj).addRedefinedType((SchemaType.Ref) obj2);
                }
            });
            buildContainersHelper(this._redefinedModelGroups, list2, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((SchemaContainer) obj).addRedefinedModelGroup((SchemaModelGroup.Ref) obj2);
                }
            });
            buildContainersHelper(this._redefinedAttributeGroups, list3, new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.c2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((SchemaContainer) obj).addRedefinedAttributeGroup((SchemaAttributeGroup.Ref) obj2);
                }
            });
        }
        List<SchemaAnnotation> list5 = this._annotations;
        if (list5 != null && !list5.isEmpty()) {
            List<SchemaAnnotation> list6 = this._annotations;
            final SchemaContainer containerNonNull = getContainerNonNull("");
            containerNonNull.getClass();
            list6.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.schema.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    containerNonNull.addAnnotation((SchemaAnnotation) obj);
                }
            });
        }
        this._containers.values().forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.schema.x1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((SchemaContainer) obj).setImmutable();
            }
        });
    }

    private <T extends SchemaComponent.Ref> void buildContainersHelper(Map<QName, SchemaComponent.Ref> map, final BiConsumer<SchemaContainer, T> biConsumer) {
        map.forEach(new BiConsumer() { // from class: org.apache.xmlbeans.impl.schema.i0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.a.f(biConsumer, (QName) obj, (SchemaComponent.Ref) obj2);
            }
        });
    }

    private static Map<QName, SchemaComponent.Ref> buildDocumentMap(SchemaType[] schemaTypeArr) {
        return buildDocumentMap((List<? extends SchemaComponent>) Arrays.asList(schemaTypeArr));
    }

    private Map<String, SchemaComponent.Ref> buildTypeRefsByClassname(Map<String, SchemaType> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            linkedHashMap.put(str, map.get(str).getRef());
        }
        return linkedHashMap;
    }

    static /* synthetic */ SchemaType[] c(int i2) {
        return new SchemaType[i2];
    }

    public static String crackPointer(InputStream inputStream) {
        try {
            LongUTFDataInputStream longUTFDataInputStream = new LongUTFDataInputStream(inputStream);
            try {
                if (longUTFDataInputStream.readInt() != -629491010) {
                    longUTFDataInputStream.close();
                    return null;
                }
                short s = longUTFDataInputStream.readShort();
                short s2 = longUTFDataInputStream.readShort();
                if (s != 2) {
                    longUTFDataInputStream.close();
                    return null;
                }
                if (s2 > 24) {
                    longUTFDataInputStream.close();
                    return null;
                }
                if (s2 >= 18) {
                    longUTFDataInputStream.readShort();
                }
                if (longUTFDataInputStream.readShort() != 5) {
                    longUTFDataInputStream.close();
                    return null;
                }
                StringPool stringPool = new StringPool("pointer", "unk");
                stringPool.readFrom(longUTFDataInputStream);
                String strStringForCode = stringPool.stringForCode(longUTFDataInputStream.readShort());
                longUTFDataInputStream.close();
                return strStringForCode;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    static /* synthetic */ SchemaComponent.Ref d(SchemaComponent.Ref ref, SchemaComponent.Ref ref2) {
        return ref2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(BiConsumer biConsumer, QName qName, SchemaComponent.Ref ref) {
        biConsumer.accept(getContainerNonNull(qName.getNamespaceURI()), ref);
    }

    private void fixupContainers() {
        for (SchemaContainer schemaContainer : this._containers.values()) {
            schemaContainer.setTypeSystem(this);
            schemaContainer.setImmutable();
        }
    }

    public static SchemaTypeSystemImpl forName(String str, ClassLoader classLoader) {
        try {
            return (SchemaTypeSystemImpl) Class.forName(str + ".TypeSystemHolder", true, classLoader).getField("typeSystem").get(null);
        } catch (Throwable th) {
            if (ExceptionUtil.isFatal(th)) {
                ExceptionUtil.rethrow(th);
            }
            return null;
        }
    }

    static /* synthetic */ SchemaType[] g(int i2) {
        return new SchemaType[i2];
    }

    static /* synthetic */ SchemaGlobalAttribute[] h(int i2) {
        return new SchemaGlobalAttribute[i2];
    }

    static /* synthetic */ SchemaGlobalElement[] i(int i2) {
        return new SchemaGlobalElement[i2];
    }

    private void initFromHeader() throws Throwable {
        XsbReader xsbReader;
        Throwable th;
        XBeanDebug.LOG.atTrace().log("Reading unresolved handles for type system {}", this._name);
        try {
            xsbReader = new XsbReader(getTypeSystem(), "index", 1);
            try {
                SchemaTypePool schemaTypePool = new SchemaTypePool(getTypeSystem());
                this._localHandles = schemaTypePool;
                schemaTypePool.readHandlePool(xsbReader);
                this._globalElements = xsbReader.readQNameRefMap();
                this._globalAttributes = xsbReader.readQNameRefMap();
                this._modelGroups = xsbReader.readQNameRefMap();
                this._attributeGroups = xsbReader.readQNameRefMap();
                this._identityConstraints = xsbReader.readQNameRefMap();
                this._globalTypes = xsbReader.readQNameRefMap();
                this._documentTypes = xsbReader.readQNameRefMap();
                this._attributeTypes = xsbReader.readQNameRefMap();
                this._typeRefsByClassname = xsbReader.readClassnameRefMap();
                this._namespaces = xsbReader.readNamespaces();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (xsbReader.atLeast(2, 15, 0)) {
                    this._redefinedGlobalTypes = xsbReader.readQNameRefMapAsList(arrayList);
                    this._redefinedModelGroups = xsbReader.readQNameRefMapAsList(arrayList2);
                    this._redefinedAttributeGroups = xsbReader.readQNameRefMapAsList(arrayList3);
                }
                if (xsbReader.atLeast(2, 19, 0)) {
                    this._annotations = xsbReader.readAnnotations();
                }
                buildContainers(arrayList, arrayList2, arrayList3);
                xsbReader.readEnd();
            } catch (Throwable th2) {
                th = th2;
                if (xsbReader != null) {
                    xsbReader.readEnd();
                }
                throw th;
            }
        } catch (Throwable th3) {
            xsbReader = null;
            th = th3;
        }
    }

    static /* synthetic */ SchemaType[] j(int i2) {
        return new SchemaType[i2];
    }

    static /* synthetic */ SchemaIdentityConstraint[] k(int i2) {
        return new SchemaIdentityConstraint[i2];
    }

    static /* synthetic */ SchemaModelGroup[] m(int i2) {
        return new SchemaModelGroup[i2];
    }

    static /* synthetic */ SchemaAttributeGroup[] n(int i2) {
        return new SchemaAttributeGroup[i2];
    }

    static String nameToPathString(String str) {
        String strReplace = str.replace(NameUtil.PERIOD, '/');
        if (strReplace.endsWith("/") || strReplace.length() <= 0) {
            return strReplace;
        }
        return strReplace + "/";
    }

    private static synchronized void nextBytes(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        LongUTFDataOutputStream longUTFDataOutputStream;
        if (_random == null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    longUTFDataOutputStream = new LongUTFDataOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                XBeanDebug.LOG.atDebug().withThrowable(e).log(e.getMessage());
            }
            try {
                longUTFDataOutputStream.writeInt(System.identityHashCode(SchemaTypeSystemImpl.class));
                String[] strArr = {"user.name", "user.dir", "user.timezone", "user.country", "java.class.path", "java.home", "java.vendor", "java.version", "os.version"};
                for (int i2 = 0; i2 < 9; i2++) {
                    String property = SystemProperties.getProperty(strArr[i2]);
                    if (property != null) {
                        longUTFDataOutputStream.writeUTF(property);
                        longUTFDataOutputStream.writeInt(System.identityHashCode(property));
                    }
                }
                longUTFDataOutputStream.writeLong(Runtime.getRuntime().freeMemory());
                longUTFDataOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                for (int i3 = 0; i3 < byteArray.length; i3++) {
                    byte[] bArr2 = _mask;
                    int length = i3 % bArr2.length;
                    bArr2[length] = (byte) (bArr2[length] * 21);
                    bArr2[length] = (byte) (bArr2[length] + ((byte) i3));
                }
                byteArrayOutputStream.close();
                _random = new Random(System.currentTimeMillis());
            } finally {
            }
        }
        _random.nextBytes(bArr);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte[] bArr3 = _mask;
            bArr[i4] = (byte) (bArr3[bArr3.length & i4] ^ bArr[i4]);
        }
    }

    static /* synthetic */ SchemaType[] o(int i2) {
        return new SchemaType[i2];
    }

    static /* synthetic */ SchemaModelGroup[] p(int i2) {
        return new SchemaModelGroup[i2];
    }

    static /* synthetic */ Object q(SchemaComponent.Ref ref) {
        return ref;
    }

    private static <T, U> U[] refHelper(Map<QName, SchemaComponent.Ref> map, Function<T, U> function, IntFunction<U[]> intFunction, U[] uArr) {
        return (U[]) refHelper(map == null ? null : map.values(), function, intFunction, uArr);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        List<SchemaAnnotation> list = this._annotations;
        return (list == null || list.isEmpty()) ? EMPTY_ANN_ARRAY : (SchemaAnnotation[]) this._annotations.toArray(EMPTY_ANN_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        return (SchemaAttributeGroup[]) refHelper(this._attributeGroups, n.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.m0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.b(i2);
            }
        }, EMPTY_AG_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        return (SchemaType[]) refHelper(this._attributeTypes, d2.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.g0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.c(i2);
            }
        }, EMPTY_ST_ARRAY);
    }

    SchemaContainer[] containers() {
        return (SchemaContainer[]) this._containers.values().toArray(new SchemaContainer[0]);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        return (SchemaType[]) refHelper(this._documentTypes, d2.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.f0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.g(i2);
            }
        }, EMPTY_ST_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return (SchemaAttributeGroup.Ref) this._attributeGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return (SchemaGlobalAttribute.Ref) this._globalAttributes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return (SchemaType.Ref) this._attributeTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return (SchemaType.Ref) this._documentTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return (SchemaGlobalElement.Ref) this._globalElements.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return (SchemaIdentityConstraint.Ref) this._identityConstraints.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return (SchemaModelGroup.Ref) this._modelGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        return (SchemaType.Ref) this._globalTypes.get(qName);
    }

    String getBasePackage() {
        return nameToPathString(this._name);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return this._classloader;
    }

    SchemaContainer getContainer(String str) {
        return this._containers.get(str);
    }

    SchemaContainer getContainerNonNull(String str) {
        SchemaContainer container = getContainer(str);
        if (container != null) {
            return container;
        }
        addContainer(str);
        return getContainer(str);
    }

    SchemaDependencies getDependencies() {
        return this._deps;
    }

    SchemaTypeLoader getLinker() {
        return this._linker;
    }

    InputStream getLoaderStream(String str) {
        return this._resourceLoader.getResourceAsStream(str);
    }

    public String getMetadataPath() {
        Matcher matcher = packPat.matcher(this._name);
        return (matcher.find() ? matcher.group(1) : this._name).replace(NameUtil.PERIOD, '/');
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return this._name;
    }

    Set<String> getNamespaces() {
        return this._namespaces;
    }

    OutputStream getSaverStream(String str, String str2) {
        try {
            return this._filer.createBinaryFile(str);
        } catch (IOException e) {
            throw new SchemaTypeLoaderException(e.getMessage(), getName(), str2, 9, e);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return this._resourceLoader.getResourceAsStream(getMetadataPath() + "/src" + str);
    }

    String getSourceCodeEncoding() {
        return this._sourceCodeEncoding;
    }

    SchemaTypePool getTypePool() {
        return this._localHandles;
    }

    Map<String, SchemaComponent.Ref> getTypeRefsByClassname() {
        return this._typeRefsByClassname;
    }

    final SchemaTypeSystemImpl getTypeSystem() {
        return this;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        return (SchemaGlobalAttribute[]) refHelper(this._globalAttributes, p1.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.h0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.h(i2);
            }
        }, EMPTY_GA_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        return (SchemaGlobalElement[]) refHelper(this._globalElements, t.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.n0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.i(i2);
            }
        }, EMPTY_GE_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        return (SchemaType[]) refHelper(this._globalTypes, d2.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.q0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.j(i2);
            }
        }, EMPTY_ST_ARRAY);
    }

    public String handleForType(SchemaType schemaType) {
        return this._localHandles.handleForType(schemaType);
    }

    public SchemaIdentityConstraint[] identityConstraints() {
        return (SchemaIdentityConstraint[]) refHelper(this._identityConstraints, u1.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.k0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.k(i2);
            }
        }, EMPTY_IC_ARRAY);
    }

    public boolean isIncomplete() {
        return this._incomplete;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return this._namespaces.contains(str);
    }

    public void loadFromStscState(StscState stscState) {
        this._localHandles = new SchemaTypePool(getTypeSystem());
        this._globalElements = buildComponentRefMap(stscState.globalElements());
        this._globalAttributes = buildComponentRefMap(stscState.globalAttributes());
        this._modelGroups = buildComponentRefMap(stscState.modelGroups());
        this._redefinedModelGroups = buildComponentRefList(stscState.redefinedModelGroups());
        this._attributeGroups = buildComponentRefMap(stscState.attributeGroups());
        this._redefinedAttributeGroups = buildComponentRefList(stscState.redefinedAttributeGroups());
        this._globalTypes = buildComponentRefMap(stscState.globalTypes());
        this._redefinedGlobalTypes = buildComponentRefList(stscState.redefinedGlobalTypes());
        this._documentTypes = buildDocumentMap(stscState.documentTypes());
        this._attributeTypes = buildAttributeTypeMap(stscState.attributeTypes());
        this._typeRefsByClassname = buildTypeRefsByClassname(stscState.typesByClassname());
        this._identityConstraints = buildComponentRefMap(stscState.idConstraints());
        this._annotations = stscState.annotations();
        this._namespaces = new HashSet(Arrays.asList(stscState.getNamespaces()));
        this._containers = stscState.getContainerMap();
        this._sourceCodeEncoding = stscState.sourceCodeEncoding();
        fixupContainers();
        assertContainersSynchronized();
        setDependencies(stscState.getDependencies());
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        return (SchemaModelGroup[]) refHelper(this._modelGroups, t1.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.s0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.m(i2);
            }
        }, EMPTY_MG_ARRAY);
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        return (SchemaAttributeGroup[]) refHelper(this._redefinedAttributeGroups, n.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.p0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.n(i2);
            }
        }, EMPTY_AG_ARRAY);
    }

    public SchemaType[] redefinedGlobalTypes() {
        return (SchemaType[]) refHelper(this._redefinedGlobalTypes, d2.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.o0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.o(i2);
            }
        }, EMPTY_ST_ARRAY);
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        return (SchemaModelGroup[]) refHelper(this._redefinedModelGroups, t1.a, new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.t0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return SchemaTypeSystemImpl.p(i2);
            }
        }, EMPTY_MG_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
        Logger logger = XBeanDebug.LOG;
        logger.atTrace().log("Resolve called type system {}", this._name);
        if (this._allNonGroupHandlesResolved) {
            return;
        }
        logger.atTrace().log("Resolving all handles for type system {}", this._name);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._globalElements.values());
        arrayList.addAll(this._globalAttributes.values());
        arrayList.addAll(this._globalTypes.values());
        arrayList.addAll(this._documentTypes.values());
        arrayList.addAll(this._attributeTypes.values());
        arrayList.addAll(this._identityConstraints.values());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SchemaComponent.Ref) it.next()).getComponent();
        }
        XBeanDebug.LOG.atTrace().log("Finished resolving type system {}", this._name);
        this._allNonGroupHandlesResolved = true;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        SchemaComponent schemaComponent;
        SchemaComponent schemaComponentFinishLoadingType;
        synchronized (this._resolvedHandles) {
            schemaComponent = this._resolvedHandles.get(str);
        }
        if (schemaComponent == null) {
            XsbReader xsbReader = new XsbReader(getTypeSystem(), str, 65535);
            int actualFiletype = xsbReader.getActualFiletype();
            if (actualFiletype == 2) {
                XBeanDebug.LOG.atTrace().log("Resolving type for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingType();
            } else if (actualFiletype == 3) {
                XBeanDebug.LOG.atTrace().log("Resolving element for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingElement();
            } else if (actualFiletype == 4) {
                XBeanDebug.LOG.atTrace().log("Resolving attribute for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingAttribute();
            } else if (actualFiletype == 6) {
                XBeanDebug.LOG.atTrace().log("Resolving model group for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingModelGroup();
            } else if (actualFiletype == 7) {
                XBeanDebug.LOG.atTrace().log("Resolving attribute group for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingAttributeGroup();
            } else {
                if (actualFiletype != 8) {
                    throw new IllegalStateException("Illegal handle type");
                }
                XBeanDebug.LOG.atTrace().log("Resolving id constraint for handle {}", str);
                schemaComponentFinishLoadingType = xsbReader.finishLoadingIdentityConstraint();
            }
            synchronized (this._resolvedHandles) {
                if (this._resolvedHandles.containsKey(str)) {
                    schemaComponent = this._resolvedHandles.get(str);
                } else {
                    this._resolvedHandles.put(str, schemaComponentFinishLoadingType);
                    schemaComponent = schemaComponentFinishLoadingType;
                }
            }
        }
        return schemaComponent;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        if (this._incomplete) {
            throw new IllegalStateException("Incomplete SchemaTypeSystems cannot be saved.");
        }
        if (filer == null) {
            throw new IllegalArgumentException("filer must not be null");
        }
        this._filer = filer;
        this._localHandles.startWriteMode();
        saveTypesRecursively(globalTypes());
        saveTypesRecursively(documentTypes());
        saveTypesRecursively(attributeTypes());
        saveGlobalElements(globalElements());
        saveGlobalAttributes(globalAttributes());
        saveModelGroups(modelGroups());
        saveAttributeGroups(attributeGroups());
        saveIdentityConstraints(identityConstraints());
        saveTypesRecursively(redefinedGlobalTypes());
        saveModelGroups(redefinedModelGroups());
        saveAttributeGroups(redefinedAttributeGroups());
        saveIndex();
        savePointers();
    }

    public void saveAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttributeGroup = this._localHandles.handleForAttributeGroup(schemaAttributeGroup);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForAttributeGroup);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeRealHeader(strHandleForAttributeGroup, 7);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeEnd();
    }

    public void saveAttributeGroups(SchemaAttributeGroup[] schemaAttributeGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaAttributeGroup schemaAttributeGroup : schemaAttributeGroupArr) {
            saveAttributeGroup(schemaAttributeGroup);
        }
    }

    public void saveGlobalAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForAttribute = this._localHandles.handleForAttribute(schemaGlobalAttribute);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForAttribute);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeRealHeader(strHandleForAttribute, 4);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveGlobalAttributes(SchemaGlobalAttribute[] schemaGlobalAttributeArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalAttribute schemaGlobalAttribute : schemaGlobalAttributeArr) {
            saveGlobalAttribute(schemaGlobalAttribute);
        }
    }

    public void saveGlobalElement(SchemaGlobalElement schemaGlobalElement) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForElement = this._localHandles.handleForElement(schemaGlobalElement);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForElement);
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeRealHeader(strHandleForElement, 3);
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveGlobalElements(SchemaGlobalElement[] schemaGlobalElementArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            saveGlobalElement(schemaGlobalElement);
        }
    }

    public void saveIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForIdentityConstraint = this._localHandles.handleForIdentityConstraint(schemaIdentityConstraint);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForIdentityConstraint);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeRealHeader(strHandleForIdentityConstraint, 8);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeEnd();
    }

    public void saveIdentityConstraints(SchemaIdentityConstraint[] schemaIdentityConstraintArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaIdentityConstraintArr) {
            saveIdentityConstraint(schemaIdentityConstraint);
        }
    }

    void saveIndex() {
        XsbReader xsbReader = new XsbReader(getTypeSystem(), "index");
        xsbReader.writeIndexData();
        xsbReader.writeRealHeader("index", 1);
        xsbReader.writeIndexData();
        xsbReader.writeEnd();
    }

    public void saveModelGroup(SchemaModelGroup schemaModelGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String strHandleForModelGroup = this._localHandles.handleForModelGroup(schemaModelGroup);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForModelGroup);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeRealHeader(strHandleForModelGroup, 6);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeEnd();
    }

    public void saveModelGroups(SchemaModelGroup[] schemaModelGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaModelGroup schemaModelGroup : schemaModelGroupArr) {
            saveModelGroup(schemaModelGroup);
        }
    }

    void savePointerFile(String str, String str2) {
        XsbReader xsbReader = new XsbReader(getTypeSystem(), str);
        xsbReader.writeString(str2);
        xsbReader.writeRealHeader(str, 5);
        xsbReader.writeString(str2);
        xsbReader.writeEnd();
    }

    void savePointers() {
        savePointersForComponents(globalElements(), getMetadataPath() + "/element/");
        savePointersForComponents(globalAttributes(), getMetadataPath() + "/attribute/");
        savePointersForComponents(modelGroups(), getMetadataPath() + "/modelgroup/");
        savePointersForComponents(attributeGroups(), getMetadataPath() + "/attributegroup/");
        savePointersForComponents(globalTypes(), getMetadataPath() + "/type/");
        savePointersForComponents(identityConstraints(), getMetadataPath() + "/identityconstraint/");
        savePointersForNamespaces(this._namespaces, getMetadataPath() + "/namespace/");
        savePointersForClassnames(this._typeRefsByClassname.keySet(), getMetadataPath() + "/javaname/");
        savePointersForComponents(redefinedModelGroups(), getMetadataPath() + "/redefinedmodelgroup/");
        savePointersForComponents(redefinedAttributeGroups(), getMetadataPath() + "/redefinedattributegroup/");
        savePointersForComponents(redefinedGlobalTypes(), getMetadataPath() + "/redefinedtype/");
    }

    void savePointersForClassnames(Set<String> set, String str) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(str + it.next().replace(NameUtil.PERIOD, '/'), this._name);
        }
    }

    void savePointersForComponents(SchemaComponent[] schemaComponentArr, String str) {
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            savePointerFile(str + QNameHelper.hexsafedir(schemaComponent.getName()), this._name);
        }
    }

    void savePointersForNamespaces(Set<String> set, String str) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(str + QNameHelper.hexsafedir(new QName(it.next(), "xmlns")), this._name);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        save(new FilerImpl(file, null, null, false, false));
    }

    void saveType(SchemaType schemaType) {
        String strHandleForType = this._localHandles.handleForType(schemaType);
        XsbReader xsbReader = new XsbReader(getTypeSystem(), strHandleForType);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeRealHeader(strHandleForType, 2);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeEnd();
    }

    void saveTypesRecursively(SchemaType[] schemaTypeArr) {
        for (SchemaType schemaType : schemaTypeArr) {
            if (schemaType.getTypeSystem() == getTypeSystem()) {
                saveType(schemaType);
                saveTypesRecursively(schemaType.getAnonymousTypes());
            }
        }
    }

    void setDependencies(SchemaDependencies schemaDependencies) {
        this._deps = schemaDependencies;
    }

    void setIncomplete(boolean z) {
        this._incomplete = z;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        SchemaType.Ref ref = (SchemaType.Ref) this._typeRefsByClassname.get(str);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        SchemaType schemaType;
        synchronized (this._resolvedHandles) {
            schemaType = (SchemaType) this._resolvedHandles.get(str);
        }
        return schemaType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<SchemaComponent.Ref> buildComponentRefList(List<? extends SchemaComponent> list) {
        return (List) list.stream().map(r.a).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<QName, SchemaComponent.Ref> buildComponentRefMap(List<? extends SchemaComponent> list) {
        return (Map) list.stream().collect(Collectors.toMap(new Function() { // from class: org.apache.xmlbeans.impl.schema.o1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SchemaComponent) obj).getName();
            }
        }, r.a, new BinaryOperator() { // from class: org.apache.xmlbeans.impl.schema.l0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SchemaComponent.Ref ref = (SchemaComponent.Ref) obj2;
                SchemaTypeSystemImpl.d((SchemaComponent.Ref) obj, ref);
                return ref;
            }
        }, x.a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends SchemaComponent.Ref> void buildContainersHelper(List<SchemaComponent.Ref> list, List<QName> list2, BiConsumer<SchemaContainer, T> biConsumer) {
        Iterator<SchemaComponent.Ref> it = list.iterator();
        Iterator<QName> it2 = list2.iterator();
        while (it.hasNext()) {
            biConsumer.accept(getContainerNonNull(it2.next().getNamespaceURI()), it.next());
        }
    }

    private static Map<QName, SchemaComponent.Ref> buildDocumentMap(List<? extends SchemaComponent> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends SchemaComponent> it = list.iterator();
        while (it.hasNext()) {
            SchemaType schemaType = (SchemaType) it.next();
            linkedHashMap.put(schemaType.getDocumentElementName(), schemaType.getRef());
        }
        return linkedHashMap;
    }

    private static <T, U> U[] refHelper(Collection<SchemaComponent.Ref> collection, Function<T, U> function, IntFunction<U[]> intFunction, U[] uArr) {
        return (collection == null || collection.isEmpty()) ? uArr : (U[]) collection.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.schema.e0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                SchemaComponent.Ref ref = (SchemaComponent.Ref) obj;
                SchemaTypeSystemImpl.q(ref);
                return ref;
            }
        }).map(function).toArray(intFunction);
    }

    private static Map<QName, SchemaComponent.Ref> buildAttributeTypeMap(List<? extends SchemaComponent> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends SchemaComponent> it = list.iterator();
        while (it.hasNext()) {
            SchemaType schemaType = (SchemaType) it.next();
            linkedHashMap.put(schemaType.getAttributeTypeAttributeName(), schemaType.getRef());
        }
        return linkedHashMap;
    }

    private void assertContainersHelper(List<? extends SchemaComponent.Ref> list, Function<SchemaContainer, List<? extends SchemaComponent>> function) {
    }

    public SchemaTypeSystemImpl(Class<?> cls) {
        String name = cls.getName();
        String strSubstring = name.substring(0, name.lastIndexOf(46));
        this._name = strSubstring;
        Logger logger = XBeanDebug.LOG;
        logger.atTrace().log("Loading type system {}", strSubstring);
        this._classloader = cls.getClassLoader();
        this._linker = SchemaTypeLoaderImpl.build(null, new DefaultClassLoaderResourceLoader(), this._classloader, getMetadataPath());
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        try {
            initFromHeader();
            logger.atTrace().log("Finished loading type system {}", strSubstring);
        } catch (Error | RuntimeException e) {
            XBeanDebug.LOG.atDebug().withThrowable(e).log(e.getMessage());
            throw e;
        }
    }

    public SchemaTypeSystemImpl(ResourceLoader resourceLoader, String str, SchemaTypeLoader schemaTypeLoader) {
        this._name = str;
        this._linker = schemaTypeLoader;
        this._resourceLoader = resourceLoader;
        try {
            initFromHeader();
        } catch (Error | RuntimeException e) {
            XBeanDebug.LOG.atDebug().withThrowable(e).log(e.getMessage());
            throw e;
        }
    }

    public SchemaTypeSystemImpl(String str) {
        if (str == null) {
            byte[] bArr = new byte[16];
            nextBytes(bArr);
            str = "s" + new String(HexBin.encode(bArr), StandardCharsets.ISO_8859_1);
        }
        this._name = METADATA_PACKAGE_GEN.replace('/', NameUtil.PERIOD) + ".system." + str;
        this._classloader = null;
    }
}
