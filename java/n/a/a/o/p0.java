package n.a.a.o;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class p0 implements l1 {
    private volatile File a;
    private final File b;
    private final Lock c;

    public p0() {
        this(null);
    }

    private void b() throws IOException {
        if (this.a != null && !this.a.exists()) {
            this.a = null;
        }
        if (this.a == null) {
            this.c.lock();
            try {
                if (this.a == null) {
                    Path pathD = d();
                    File file = pathD.toFile();
                    if (!file.exists()) {
                        this.a = Files.createDirectories(pathD, new FileAttribute[0]).toFile();
                    } else {
                        if (!file.isDirectory()) {
                            throw new IOException("Could not create temporary directory. '" + file + "' exists but is not a directory.");
                        }
                        this.a = file;
                    }
                }
            } finally {
                this.c.unlock();
            }
        }
    }

    @Override // n.a.a.o.l1
    public File a(String str, String str2) throws IOException {
        b();
        File file = Files.createTempFile(this.a.toPath(), str, str2, new FileAttribute[0]).toFile();
        if (System.getProperty("poi.delete.tmp.files.on.exit") != null) {
            file.deleteOnExit();
        }
        return file;
    }

    protected String c() throws IOException {
        String property = System.getProperty("java.io.tmpdir");
        if (property != null) {
            return property;
        }
        throw new IOException("System's temporary directory not defined - set the -Djava.io.tmpdir jvm property!");
    }

    protected Path d() throws IOException {
        File file = this.b;
        return file == null ? Paths.get(c(), "poifiles") : file.toPath();
    }

    public p0(File file) {
        this.c = new ReentrantLock();
        this.b = file;
        this.a = file;
        if (file == null || !file.exists() || file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException("The provided file is not a directory: " + file);
    }
}
