package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes.dex */
final class FileUtil {
    private FileUtil() {
    }

    static /* synthetic */ boolean a(Pattern pattern, Path path, BasicFileAttributes basicFileAttributes) {
        String string = path.getFileName().toString();
        return !string.endsWith(".xsdconfig") && pattern.matcher(string).matches();
    }

    static Collection<File> find(File file, final Pattern pattern, boolean z) throws IOException {
        try {
            Stream<Path> streamFind = Files.find(file.toPath(), z ? Integer.MAX_VALUE : 1, new BiPredicate() { // from class: org.apache.xmlbeans.impl.tool.f
                @Override // java.util.function.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    return FileUtil.a(pattern, (Path) obj, (BasicFileAttributes) obj2);
                }
            }, new FileVisitOption[0]);
            try {
                Collection<File> collection = (Collection) streamFind.map(new Function() { // from class: org.apache.xmlbeans.impl.tool.i
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((Path) obj).toFile();
                    }
                }).collect(Collectors.toList());
                if (streamFind != null) {
                    streamFind.close();
                }
                return collection;
            } finally {
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
