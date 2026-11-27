package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.impl.common.IOUtil;

/* loaded from: classes.dex */
public class SchemaResourceManager extends BaseSchemaResourceManager {
    private File _directory;

    public SchemaResourceManager(File file) {
        this._directory = file;
        init();
    }

    private static List collectXSDFiles(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (file.isDirectory()) {
                arrayList.addAll(collectXSDFiles(file.listFiles(new FileFilter() { // from class: org.apache.xmlbeans.impl.tool.SchemaResourceManager.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        return file2.isDirectory() || (file2.isFile() && file2.getName().endsWith(".xsd"));
                    }
                })));
            } else {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private static boolean isInDirectory(File file, File file2) {
        if (file == null) {
            return false;
        }
        if (file.equals(file2)) {
            return true;
        }
        return isInDirectory(file.getParentFile(), file2);
    }

    private static boolean looksLikeURL(String str) {
        return str.startsWith("http:") || str.startsWith("https:") || str.startsWith("ftp:") || str.startsWith("file:");
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("sync");
        hashSet.add("refresh");
        hashSet.add("recurse");
        HashSet hashSet2 = new HashSet();
        hashSet2.add("dir");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        String[] strArrArgs = commandLine.args();
        boolean z = commandLine.getOpt("sync") != null;
        boolean z2 = commandLine.getOpt("refresh") != null;
        boolean z3 = commandLine.getOpt("recurse") != null;
        String opt = commandLine.getOpt("dir");
        if (opt == null) {
            opt = ".";
        }
        File file = new File(opt);
        try {
            SchemaResourceManager schemaResourceManager = new SchemaResourceManager(file);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < strArrArgs.length; i2++) {
                if (looksLikeURL(strArrArgs[i2])) {
                    arrayList.add(strArrArgs[i2]);
                } else {
                    arrayList2.add(new File(file, strArrArgs[i2]));
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                if (!isInDirectory(file2, file)) {
                    System.err.println("File not within directory: " + file2);
                    it.remove();
                }
            }
            List listCollectXSDFiles = collectXSDFiles((File[]) arrayList2.toArray(new File[0]));
            String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
            String[] strArrRelativeFilenames = relativeFilenames((File[]) listCollectXSDFiles.toArray(new File[0]), file);
            if (strArr2.length + strArrRelativeFilenames.length > 0) {
                schemaResourceManager.process(strArr2, strArrRelativeFilenames, z, z2, z3);
            } else {
                schemaResourceManager.processAll(z, z2, z3);
            }
            schemaResourceManager.writeCache();
            System.exit(0);
        } catch (IllegalStateException e) {
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
            System.exit(1);
        }
    }

    public static void printUsage() {
        System.out.println("Maintains \"xsdownload.xml\", an index of locally downloaded .xsd files");
        System.out.println("usage: sdownload [-dir directory] [-refresh] [-recurse] [-sync] [url/file...]");
        System.out.println("");
        System.out.println("URLs that are specified are downloaded if they aren't already cached.");
        System.out.println("In addition:");
        System.out.println("  -dir specifies the directory for the xsdownload.xml file (default .).");
        System.out.println("  -sync synchronizes the index to any local .xsd files in the tree.");
        System.out.println("  -recurse recursively downloads imported and included .xsd files.");
        System.out.println("  -refresh redownloads all indexed .xsd files.");
        System.out.println("If no files or URLs are specified, all indexed files are relevant.");
    }

    private static String relativeFilename(File file, File file2) {
        if (file == null || file.equals(file2)) {
            return ".";
        }
        return relativeFilename(file.getParentFile(), file2) + "/" + file.getName();
    }

    private static String[] relativeFilenames(File[] fileArr, File file) {
        String[] strArr = new String[fileArr.length];
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            strArr[i2] = relativeFilename(fileArr[i2], file);
        }
        return strArr;
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected void deleteFile(String str) {
        new File(this._directory, str).delete();
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected boolean fileExists(String str) {
        return new File(this._directory, str).exists();
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected String[] getAllXSDFilenames() {
        return relativeFilenames((File[]) collectXSDFiles(new File[]{this._directory}).toArray(new File[0]), this._directory);
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected InputStream inputStreamForFile(String str) throws IOException {
        return Files.newInputStream(new File(this._directory, str).toPath(), new OpenOption[0]);
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected void warning(String str) {
        System.out.println(str);
    }

    @Override // org.apache.xmlbeans.impl.tool.BaseSchemaResourceManager
    protected void writeInputStreamToFile(InputStream inputStream, String str) throws IOException {
        File file = new File(this._directory, str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        IOUtil.copyCompletely(inputStream, Files.newOutputStream(file.toPath(), new OpenOption[0]));
    }
}
