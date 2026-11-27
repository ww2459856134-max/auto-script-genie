package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.xmlbeans.ResourceLoader;

/* loaded from: classes.dex */
public class FileResourceLoader implements ResourceLoader {
    private File _directory;
    private ZipFile _zipfile;

    public FileResourceLoader(File file) throws IOException {
        if (file.isDirectory()) {
            this._directory = file;
        } else {
            this._zipfile = new ZipFile(file);
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() throws IOException {
        ZipFile zipFile = this._zipfile;
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
            this._zipfile = null;
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        try {
            ZipFile zipFile = this._zipfile;
            if (zipFile == null) {
                return Files.newInputStream(new File(this._directory, str).toPath(), new OpenOption[0]);
            }
            ZipEntry entry = zipFile.getEntry(str);
            if (entry == null) {
                return null;
            }
            return this._zipfile.getInputStream(entry);
        } catch (IOException unused) {
            return null;
        }
    }
}
