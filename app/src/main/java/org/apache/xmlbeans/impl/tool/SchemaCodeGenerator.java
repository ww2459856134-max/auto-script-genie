package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.util.FilerImpl;

/* loaded from: classes.dex */
public class SchemaCodeGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Set<File> deleteFileQueue = new HashSet();
    private static int triesRemaining = 0;

    protected static File createTempDir() throws IOException {
        String string;
        try {
            IOUtil.getTempDir().toFile().mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i2 = 0;
        File file = Files.createTempFile(IOUtil.getTempDir(), "xbean", ".tmp", new FileAttribute[0]).toFile();
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(".tmp")) {
            throw new IOException("Error: createTempFile did not create a file ending with .tmp");
        }
        String strSubstring = absolutePath.substring(0, absolutePath.length() - 4);
        File file2 = null;
        while (true) {
            if (i2 >= 100) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strSubstring);
            sb.append(".d");
            if (i2 == 0) {
                string = "";
            } else {
                string = Integer.toString(i2);
                i2++;
            }
            sb.append(string);
            File file3 = new File(sb.toString());
            if (!file3.exists()) {
                file3.mkdirs();
                file2 = file3;
                break;
            }
            i2++;
            file2 = file3;
        }
        file.deleteOnExit();
        return file2;
    }

    private static void deleteDirRecursively(File file, File file2) {
        String[] list = file2.list();
        while (list != null && list.length == 0 && !file2.equals(file)) {
            file2.delete();
            file2 = file2.getParentFile();
            list = file2.list();
        }
    }

    static void deleteObsoleteFiles(File file, File file2, Set set) {
        if (!file.isDirectory() || !file2.isDirectory()) {
            throw new IllegalArgumentException();
        }
        String absolutePath = file2.getAbsolutePath();
        if (absolutePath.length() <= 5) {
            return;
        }
        if (!absolutePath.startsWith("/home/") || (absolutePath.indexOf("/", 6) < absolutePath.length() - 1 && absolutePath.indexOf("/", 6) >= 0)) {
            File[] fileArrListFiles = file2.listFiles();
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                if (fileArrListFiles[i2].isDirectory()) {
                    deleteObsoleteFiles(file, fileArrListFiles[i2], set);
                } else if (!set.contains(fileArrListFiles[i2])) {
                    deleteXmlBeansFile(fileArrListFiles[i2]);
                    deleteDirRecursively(file, fileArrListFiles[i2].getParentFile());
                }
            }
        }
    }

    private static void deleteXmlBeansFile(File file) {
        if (file.getName().endsWith(".java")) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void giveUp() {
        synchronized (deleteFileQueue) {
            deleteFileQueue.clear();
            triesRemaining = 0;
        }
    }

    public static void saveTypeSystem(SchemaTypeSystem schemaTypeSystem, File file, File file2, Repackager repackager, XmlOptions xmlOptions) throws IOException {
        schemaTypeSystem.save(new FilerImpl(file, null, repackager, false, false));
    }

    protected static void tryHardToDelete(File file) {
        tryToDelete(file);
        if (file.exists()) {
            tryToDeleteLater(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tryNowThatItsLater() {
        ArrayList<File> arrayList;
        boolean z;
        synchronized (deleteFileQueue) {
            arrayList = new ArrayList(deleteFileQueue);
            deleteFileQueue.clear();
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file : arrayList) {
            tryToDelete(file);
            if (file.exists()) {
                arrayList2.add(file);
            }
        }
        synchronized (deleteFileQueue) {
            int i2 = triesRemaining;
            z = true;
            if (i2 > 0) {
                triesRemaining = i2 - 1;
            }
            if (triesRemaining <= 0 || arrayList2.isEmpty()) {
                triesRemaining = 0;
            } else {
                deleteFileQueue.addAll(arrayList2);
            }
            if (triesRemaining > 0) {
                z = false;
            }
        }
        return z;
    }

    private static void tryToDelete(File file) {
        String[] list;
        if (file.exists()) {
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    tryToDelete(new File(file, str));
                }
            }
            if (!file.delete()) {
            }
        }
    }

    private static void tryToDeleteLater(File file) {
        synchronized (deleteFileQueue) {
            deleteFileQueue.add(file);
            if (triesRemaining == 0) {
                new Thread() { // from class: org.apache.xmlbeans.impl.tool.SchemaCodeGenerator.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() throws InterruptedException {
                        while (!SchemaCodeGenerator.tryNowThatItsLater()) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused) {
                                SchemaCodeGenerator.giveUp();
                                return;
                            }
                        }
                    }
                };
            }
            if (triesRemaining < 10) {
                triesRemaining = 10;
            }
        }
    }
}
