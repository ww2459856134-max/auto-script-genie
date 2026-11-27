package org.apache.xmlbeans.impl.config;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ClassLoaderTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
class Parser {
    private final File[] classpath;
    private final CombinedTypeSolver combinedTypeSolver;
    private final File[] javaFiles;
    private final ParserConfiguration pc;
    private final ProjectRoot projectRoot;

    public Parser(File[] fileArr, File[] fileArr2) {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver(new TypeSolver[0]);
        this.combinedTypeSolver = combinedTypeSolver;
        File[] fileArr3 = fileArr != null ? (File[]) fileArr.clone() : new File[0];
        this.javaFiles = fileArr3;
        File[] fileArr4 = fileArr2 != null ? (File[]) fileArr2.clone() : new File[0];
        this.classpath = fileArr4;
        ParserConfiguration parserConfiguration = new ParserConfiguration();
        this.pc = parserConfiguration;
        parserConfiguration.setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
        combinedTypeSolver.add(new ClassLoaderTypeSolver(new URLClassLoader((URL[]) Stream.of((Object[]) fileArr4).map(new Function() { // from class: org.apache.xmlbeans.impl.config.e0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Parser.fileToURL((File) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((URL) obj);
            }
        }).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.config.l0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return Parser.h(i2);
            }
        }), getClass().getClassLoader())));
        combinedTypeSolver.add(new ReflectionTypeSolver());
        parserConfiguration.setSymbolResolver(new JavaSymbolSolver(combinedTypeSolver));
        if (fileArr3.length <= 0) {
            this.projectRoot = null;
            return;
        }
        final ChildSolverCollectionStrategy childSolverCollectionStrategy = new ChildSolverCollectionStrategy(parserConfiguration, combinedTypeSolver);
        Stream.of((Object[]) fileArr3).map(new Function() { // from class: org.apache.xmlbeans.impl.config.h0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Parser.i((File) obj);
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((File) obj).toPath();
            }
        }).distinct().forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.config.o0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws IOException {
                childSolverCollectionStrategy.collect((Path) obj);
            }
        });
        this.projectRoot = childSolverCollectionStrategy.collectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    static /* synthetic */ URL[] h(int i2) {
        return new URL[i2];
    }

    static /* synthetic */ File i(File file) {
        return file.isDirectory() ? file : file.getParentFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: parseOrNull, reason: merged with bridge method [inline-methods] */
    public ParseResult<CompilationUnit> e(SourceRoot sourceRoot, String str) {
        try {
            return sourceRoot.tryToParse("", str, this.pc);
        } catch (IOException unused) {
            return null;
        }
    }

    public ClassOrInterfaceDeclaration loadSource(final String str) {
        final String str2 = str.replace(NameUtil.PERIOD, '/') + ".java";
        ProjectRoot projectRoot = this.projectRoot;
        if (projectRoot == null) {
            return null;
        }
        Stream streamFlatMap = projectRoot.getSourceRoots().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.i0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.e(str2, (SourceRoot) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.q0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((ParseResult) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.f0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ParseResult) obj).isSuccessful();
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.g0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ParseResult) obj).getResult();
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.config.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (CompilationUnit) ((Optional) obj).get();
            }
        }).flatMap(new Function() { // from class: org.apache.xmlbeans.impl.config.k0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CompilationUnit) obj).getTypes().stream();
            }
        });
        final Class<ClassOrInterfaceDeclaration> cls = ClassOrInterfaceDeclaration.class;
        Stream streamFilter = streamFlatMap.filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.p0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((TypeDeclaration) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.j0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals(((TypeDeclaration) obj).getFullyQualifiedName().orElse(null));
            }
        });
        final Class<ClassOrInterfaceDeclaration> cls2 = ClassOrInterfaceDeclaration.class;
        return (ClassOrInterfaceDeclaration) streamFilter.map(new Function() { // from class: org.apache.xmlbeans.impl.config.t0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (ClassOrInterfaceDeclaration) cls2.cast((TypeDeclaration) obj);
            }
        }).findFirst().orElse(null);
    }
}
