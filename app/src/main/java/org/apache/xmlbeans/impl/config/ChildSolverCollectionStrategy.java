package org.apache.xmlbeans.impl.config;

import com.auto.exceldeps.log4j.Logger;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.utils.CollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;

/* loaded from: classes.dex */
class ChildSolverCollectionStrategy implements CollectionStrategy {
    private static final Logger LOG = XmlBeansLogManager.getLogger(ChildSolverCollectionStrategy.class);
    private final CombinedTypeSolver combinedTypeSolver;
    private final ParserConfiguration config;
    private final PathMatcher javaMatcher = getPathMatcher("glob:**.java");
    private final PathMatcher jarMatcher = getPathMatcher("glob:**.jar");
    private final List<Path> roots = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    class FileVisitor extends SimpleFileVisitor<Path> {
        private FileVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Path path) {
            ChildSolverCollectionStrategy.this.getSolver().add(new JavaParserTypeSolver(path, ChildSolverCollectionStrategy.this.getParserConfiguration()));
            ChildSolverCollectionStrategy.this.roots.add(path);
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            return Files.isHidden(path) ? FileVisitResult.SKIP_SUBTREE : FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            if (ChildSolverCollectionStrategy.this.javaMatcher.matches(path)) {
                Stream map = ChildSolverCollectionStrategy.this.roots.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.m0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((Path) obj).toAbsolutePath();
                    }
                });
                final Path absolutePath = path.toAbsolutePath();
                absolutePath.getClass();
                if (map.noneMatch(new Predicate() { // from class: org.apache.xmlbeans.impl.config.c
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return absolutePath.startsWith((Path) obj);
                    }
                })) {
                    ChildSolverCollectionStrategy.this.getRoot(path).ifPresent(new Consumer() { // from class: org.apache.xmlbeans.impl.config.i
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            this.a.b((Path) obj);
                        }
                    });
                }
            } else if (ChildSolverCollectionStrategy.this.jarMatcher.matches(path)) {
                ChildSolverCollectionStrategy.this.getSolver().add(new JarTypeSolver(path));
            }
            return FileVisitResult.CONTINUE;
        }
    }

    ChildSolverCollectionStrategy(ParserConfiguration parserConfiguration, CombinedTypeSolver combinedTypeSolver) {
        this.config = parserConfiguration;
        this.combinedTypeSolver = combinedTypeSolver;
    }

    private static Path commonRoot(Path path, Path path2) {
        final ArrayList arrayList = new ArrayList();
        path.toAbsolutePath().iterator().forEachRemaining(new Consumer() { // from class: org.apache.xmlbeans.impl.config.n0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add((Path) obj);
            }
        });
        final ArrayList arrayList2 = new ArrayList();
        path2.toAbsolutePath().iterator().forEachRemaining(new Consumer() { // from class: org.apache.xmlbeans.impl.config.n0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList2.add((Path) obj);
            }
        });
        arrayList.retainAll(arrayList2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Path) arrayList.get(arrayList.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CombinedTypeSolver getSolver() {
        return this.combinedTypeSolver;
    }

    public ProjectRoot collect(Path path) throws IOException {
        try {
            Files.walkFileTree(path, new FileVisitor());
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Unable to walk {}", path);
        }
        if (this.roots.isEmpty()) {
            return null;
        }
        return new ProjectRoot(this.roots.get(r4.size() - 1), this.config);
    }

    public ProjectRoot collectAll() {
        Path pathCommonRoot = null;
        for (Path path : this.roots) {
            if (pathCommonRoot != null) {
                pathCommonRoot = commonRoot(pathCommonRoot, path);
                if (pathCommonRoot == null) {
                    break;
                }
            } else {
                pathCommonRoot = path;
            }
        }
        if (pathCommonRoot == null) {
            throw new IllegalStateException("Unable to construct a common project root - giving up.");
        }
        final ProjectRoot projectRoot = new ProjectRoot(pathCommonRoot, this.config);
        this.roots.forEach(new Consumer() { // from class: org.apache.xmlbeans.impl.config.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                projectRoot.addSourceRoot((Path) obj);
            }
        });
        return projectRoot;
    }

    public ParserConfiguration getParserConfiguration() {
        return this.config;
    }
}
