package org.apache.xmlbeans.impl.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

/* loaded from: classes.dex */
public class JarHelper {
    private static final int BUFFER_SIZE = 2156;
    private static final char SEP = '/';
    private final byte[] mBuffer = new byte[BUFFER_SIZE];
    private boolean mVerbose = false;
    private String mDestJarName = "";

    public void jarDir(File file, File file2) throws IOException {
        if (file == null || file2 == null) {
            throw new IllegalArgumentException();
        }
        this.mDestJarName = file2.getCanonicalPath();
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(file2.toPath(), new OpenOption[0]);
        try {
            JarOutputStream jarOutputStream = new JarOutputStream(outputStreamNewOutputStream);
            try {
                jarDir(file, jarOutputStream, null);
                jarOutputStream.close();
                if (outputStreamNewOutputStream != null) {
                    outputStreamNewOutputStream.close();
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamNewOutputStream != null) {
                    try {
                        outputStreamNewOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void setVerbose(boolean z) {
        this.mVerbose = z;
    }

    private void jarDir(File file, JarOutputStream jarOutputStream, String str) throws IOException {
        if (this.mVerbose) {
            System.out.println("checking " + file);
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            String str2 = str == null ? "" : str + file.getName() + SEP;
            if (str != null) {
                JarEntry jarEntry = new JarEntry(str2);
                jarEntry.setTime(file.lastModified());
                jarOutputStream.putNextEntry(jarEntry);
                jarOutputStream.flush();
                jarOutputStream.closeEntry();
            }
            if (list != null) {
                for (String str3 : list) {
                    jarDir(new File(file, str3), jarOutputStream, str2);
                }
                return;
            }
            return;
        }
        if (file.getCanonicalPath().equals(this.mDestJarName)) {
            if (this.mVerbose) {
                System.out.println("skipping " + file.getPath());
                return;
            }
            return;
        }
        if (this.mVerbose) {
            System.out.println("adding " + file.getPath());
        }
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            JarEntry jarEntry2 = new JarEntry(str + file.getName());
            jarEntry2.setTime(file.lastModified());
            jarOutputStream.putNextEntry(jarEntry2);
            while (true) {
                int i2 = inputStreamNewInputStream.read(this.mBuffer);
                if (i2 == -1) {
                    break;
                }
                jarOutputStream.write(this.mBuffer, 0, i2);
                if (this.mVerbose) {
                    System.out.println("wrote " + i2 + " bytes");
                }
            }
            jarOutputStream.flush();
            jarOutputStream.closeEntry();
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
