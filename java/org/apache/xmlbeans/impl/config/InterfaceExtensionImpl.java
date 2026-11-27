package org.apache.xmlbeans.impl.config;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.MethodUsage;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.config.InterfaceExtensionImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;

/* loaded from: classes.dex */
public class InterfaceExtensionImpl implements InterfaceExtension {
    private String _delegateToClassName;
    private String _interfaceClassName;
    private MethodSignatureImpl[] _methods;
    private NameSet _xbeanSet;

    static class MethodSignatureImpl implements InterfaceExtension.MethodSignature {
        private final String[] _exceptions;
        private final String _intfName;
        private final String _name;
        private final String[] _paramNames;
        private final String[] _params;
        private final String _return;
        private String _signature;
        private final int NOTINITIALIZED = -1;
        private int _hashCode = -1;

        MethodSignatureImpl(String str, MethodDeclaration methodDeclaration) {
            String str2;
            if (str == null || methodDeclaration == null) {
                throw new IllegalArgumentException("Interface: " + str + " method: " + methodDeclaration);
            }
            this._intfName = str;
            this._signature = null;
            this._name = methodDeclaration.getName().asString();
            String str3 = (String) methodDeclaration.getTypeParameters().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.t
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((TypeParameter) obj).toString();
                }
            }).collect(Collectors.joining(", "));
            StringBuilder sb = new StringBuilder();
            if (str3.isEmpty()) {
                str2 = "";
            } else {
                str2 = " <" + str3 + "> ";
            }
            sb.append(str2);
            sb.append(replaceInner(methodDeclaration.getType().resolve().describe()));
            this._return = sb.toString();
            Stream map = methodDeclaration.getParameters().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Parameter) obj).getType().resolve().describe();
                }
            });
            w wVar = new Function() { // from class: org.apache.xmlbeans.impl.config.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return InterfaceExtensionImpl.MethodSignatureImpl.replaceInner((String) obj);
                }
            };
            this._params = (String[]) map.map(wVar).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.s
                @Override // java.util.function.IntFunction
                public final Object apply(int i2) {
                    return InterfaceExtensionImpl.MethodSignatureImpl.c(i2);
                }
            });
            this._exceptions = (String[]) methodDeclaration.getThrownExceptions().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((ReferenceType) obj).resolve().describe();
                }
            }).map(wVar).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.u
                @Override // java.util.function.IntFunction
                public final Object apply(int i2) {
                    return InterfaceExtensionImpl.MethodSignatureImpl.e(i2);
                }
            });
            this._paramNames = (String[]) methodDeclaration.getParameters().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Parameter) obj).getNameAsString();
                }
            }).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.q
                @Override // java.util.function.IntFunction
                public final Object apply(int i2) {
                    return InterfaceExtensionImpl.MethodSignatureImpl.g(i2);
                }
            });
        }

        static /* synthetic */ String[] c(int i2) {
            return new String[i2];
        }

        static /* synthetic */ String[] e(int i2) {
            return new String[i2];
        }

        static /* synthetic */ String[] g(int i2) {
            return new String[i2];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String replaceInner(String str) {
            return str.replace('$', NameUtil.PERIOD);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodSignatureImpl)) {
                return false;
            }
            MethodSignatureImpl methodSignatureImpl = (MethodSignatureImpl) obj;
            return methodSignatureImpl.getName().equals(getName()) && this._intfName.equals(methodSignatureImpl._intfName) && Arrays.equals(getParameterTypes(), methodSignatureImpl.getParameterTypes());
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getExceptionTypes() {
            return this._exceptions;
        }

        String getInterfaceName() {
            return this._intfName;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getName() {
            return this._name;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getParameterNames() {
            return this._paramNames;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String[] getParameterTypes() {
            return this._params;
        }

        @Override // org.apache.xmlbeans.InterfaceExtension.MethodSignature
        public String getReturnType() {
            return this._return;
        }

        String getSignature() {
            String str = this._signature;
            if (str != null) {
                return str;
            }
            String str2 = this._name + "(" + defpackage.f.a(" ,", this._params) + ")";
            this._signature = str2;
            return str2;
        }

        public int hashCode() {
            int i2 = this._hashCode;
            if (i2 != -1) {
                return i2;
            }
            int iHash = Objects.hash(getName(), Integer.valueOf(Arrays.hashCode(getParameterTypes())), this._intfName);
            this._hashCode = iHash;
            return iHash;
        }

        public String toString() {
            return getReturnType() + " " + getSignature();
        }
    }

    static /* synthetic */ String c(Node node) {
        return node instanceof Parameter ? ((Parameter) node).getType().resolve().describe() : node instanceof TypeParameter ? ((TypeParameter) node).getNameAsString() : "unknown";
    }

    static /* synthetic */ String[] d(int i2) {
        return new String[i2];
    }

    static /* synthetic */ String[] f(int i2) {
        return new String[i2];
    }

    static /* synthetic */ String[] g(int i2) {
        return new String[i2];
    }

    static MethodDeclaration getMethod(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, String str, final String[] strArr) {
        return (MethodDeclaration) classOrInterfaceDeclaration.getMethodsByName(str).stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.n
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InterfaceExtensionImpl.parameterMatches(InterfaceExtensionImpl.paramStrings(((MethodDeclaration) obj).getParameters()), strArr);
            }
        }).findFirst().orElse(null);
    }

    static /* synthetic */ boolean h(MethodUsage methodUsage) {
        return !Object.class.getName().equals(methodUsage.declaringType().getQualifiedName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ MethodSignatureImpl l(MethodDeclaration methodDeclaration) {
        if (methodDeclaration == null) {
            return null;
        }
        return new MethodSignatureImpl(getStaticHandler(), methodDeclaration);
    }

    static /* synthetic */ MethodSignatureImpl[] m(int i2) {
        return new MethodSignatureImpl[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean matchParams(MethodUsage methodUsage, MethodDeclaration methodDeclaration) {
        List paramTypes = methodUsage.getParamTypes();
        NodeList parameters = methodDeclaration.getParameters();
        if (parameters.size() != paramTypes.size() + 1 || !XmlObject.class.getName().equals(parameters.get(0).resolve().describeType())) {
            return false;
        }
        Iterator it = paramTypes.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            if (!((ResolvedType) it.next()).describe().equals(parameters.get(i2).resolve().describeType())) {
                return false;
            }
            i2 = i3;
        }
        return true;
    }

    static InterfaceExtensionImpl newInstance(Parser parser, NameSet nameSet, Extensionconfig.Interface r5) {
        InterfaceExtensionImpl interfaceExtensionImpl = new InterfaceExtensionImpl();
        interfaceExtensionImpl._xbeanSet = nameSet;
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationValidateInterface = validateInterface(parser, r5.getName(), r5);
        if (classOrInterfaceDeclarationValidateInterface == null) {
            BindingConfigImpl.error("Interface '" + r5.getStaticHandler() + "' not found.", r5);
            return null;
        }
        interfaceExtensionImpl._interfaceClassName = (String) classOrInterfaceDeclarationValidateInterface.getFullyQualifiedName().get();
        String staticHandler = r5.getStaticHandler();
        interfaceExtensionImpl._delegateToClassName = staticHandler;
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationValidateClass = validateClass(parser, staticHandler, r5);
        if (classOrInterfaceDeclarationValidateClass != null) {
            if (interfaceExtensionImpl.validateMethods(parser, classOrInterfaceDeclarationValidateInterface, classOrInterfaceDeclarationValidateClass, r5)) {
                return interfaceExtensionImpl;
            }
            return null;
        }
        BindingConfigImpl.warning("Handler class '" + r5.getStaticHandler() + "' not found on classpath, skip validation.", r5);
        return interfaceExtensionImpl;
    }

    private static String[] paramStrings(NodeList<?> nodeList) {
        return (String[]) nodeList.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.d0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return InterfaceExtensionImpl.c((Node) obj);
            }
        }).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.m
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return InterfaceExtensionImpl.d(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean parameterMatches(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            String str2 = strArr2[i2];
            if (!str.contains(".")) {
                str2 = str;
                str = str2;
            }
            if (!str.endsWith(str2)) {
                return false;
            }
        }
        return true;
    }

    static ClassOrInterfaceDeclaration validateClass(Parser parser, String str, XmlObject xmlObject) {
        return validateJava(parser, str, false, xmlObject);
    }

    private static ClassOrInterfaceDeclaration validateInterface(Parser parser, String str, XmlObject xmlObject) {
        return validateJava(parser, str, true, xmlObject);
    }

    static ClassOrInterfaceDeclaration validateJava(Parser parser, String str, boolean z, XmlObject xmlObject) {
        if (parser == null) {
            return null;
        }
        String str2 = z ? "Interface" : "Class";
        ClassOrInterfaceDeclaration classOrInterfaceDeclarationLoadSource = parser.loadSource(str);
        if (classOrInterfaceDeclarationLoadSource == null) {
            BindingConfigImpl.error(str2 + " '" + str + "' not found.", xmlObject);
            return null;
        }
        if (z != classOrInterfaceDeclarationLoadSource.isInterface()) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(str);
            sb.append("' must be ");
            sb.append(z ? "an interface" : "a class");
            sb.append(".");
            BindingConfigImpl.error(sb.toString(), xmlObject);
        }
        if (!classOrInterfaceDeclarationLoadSource.isPublic()) {
            BindingConfigImpl.error(str2 + " '" + str + "' is not public.", xmlObject);
        }
        return classOrInterfaceDeclarationLoadSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateMethod, reason: merged with bridge method [inline-methods] */
    public MethodDeclaration j(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, ClassOrInterfaceDeclaration classOrInterfaceDeclaration2, final MethodUsage methodUsage, XmlObject xmlObject) {
        String name = methodUsage.getName();
        MethodDeclaration methodDeclaration = (MethodDeclaration) classOrInterfaceDeclaration2.getMethodsByName(name).stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InterfaceExtensionImpl.matchParams(methodUsage, (MethodDeclaration) obj);
            }
        }).findFirst().orElse(null);
        String str = (String) classOrInterfaceDeclaration2.getFullyQualifiedName().orElse("");
        String str2 = name + "(" + methodUsage.getParamTypes().toString() + ")";
        String str3 = (String) classOrInterfaceDeclaration.getFullyQualifiedName().orElse("");
        if (methodDeclaration == null) {
            BindingConfigImpl.error("Handler class '" + str + "' does not contain method " + str2, xmlObject);
            return null;
        }
        Stream stream = methodUsage.getDeclaration().getSpecifiedExceptions().stream();
        r0 r0Var = new Function() { // from class: org.apache.xmlbeans.impl.config.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ResolvedType) obj).describe();
            }
        };
        if (!Arrays.equals((String[]) stream.map(r0Var).sorted().toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.y
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return InterfaceExtensionImpl.f(i2);
            }
        }), (String[]) methodDeclaration.getThrownExceptions().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ReferenceType) obj).resolve();
            }
        }).map(r0Var).sorted().toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.o
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return InterfaceExtensionImpl.g(i2);
            }
        }))) {
            BindingConfigImpl.error("Handler method '" + str + "." + name + "' must declare the same exceptions as the interface method '" + str3 + "." + str2, xmlObject);
            return null;
        }
        if (!methodDeclaration.isPublic() || !methodDeclaration.isStatic()) {
            BindingConfigImpl.error("Method '" + str + "." + str2 + "' must be declared public and static.", xmlObject);
            return null;
        }
        if (methodUsage.getDeclaration().getReturnType().equals(methodDeclaration.resolve().getReturnType())) {
            return methodDeclaration;
        }
        String strDescribe = methodUsage.getDeclaration().getReturnType().describe();
        BindingConfigImpl.error("Return type for method '" + strDescribe + " " + str + "." + name + "(...)' does not match the return type of the interface method :'" + strDescribe + "'.", xmlObject);
        return null;
    }

    private boolean validateMethods(Parser parser, final ClassOrInterfaceDeclaration classOrInterfaceDeclaration, final ClassOrInterfaceDeclaration classOrInterfaceDeclaration2, final XmlObject xmlObject) {
        MethodSignatureImpl[] methodSignatureImplArr = (MethodSignatureImpl[]) classOrInterfaceDeclaration.resolve().getAllMethods().stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.b0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return InterfaceExtensionImpl.h((MethodUsage) obj);
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.j(classOrInterfaceDeclaration, classOrInterfaceDeclaration2, xmlObject, (MethodUsage) obj);
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.c0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.l((MethodDeclaration) obj);
            }
        }).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.a0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return InterfaceExtensionImpl.m(i2);
            }
        });
        this._methods = methodSignatureImplArr;
        return Stream.of((Object[]) methodSignatureImplArr).allMatch(new Predicate() { // from class: org.apache.xmlbeans.impl.config.s0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((InterfaceExtensionImpl.MethodSignatureImpl) obj);
            }
        });
    }

    public boolean contains(String str) {
        return this._xbeanSet.contains(str);
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getInterface() {
        return this._interfaceClassName;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public InterfaceExtension.MethodSignature[] getMethods() {
        return this._methods;
    }

    @Override // org.apache.xmlbeans.InterfaceExtension
    public String getStaticHandler() {
        return this._delegateToClassName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  static handler: ");
        sb.append(this._delegateToClassName);
        sb.append("\n");
        sb.append("  interface: ");
        sb.append(this._interfaceClassName);
        sb.append("\n");
        sb.append("  name set: ");
        sb.append(this._xbeanSet);
        sb.append("\n");
        for (int i2 = 0; i2 < this._methods.length; i2++) {
            sb.append("  method[");
            sb.append(i2);
            sb.append("]=");
            sb.append(this._methods[i2]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
