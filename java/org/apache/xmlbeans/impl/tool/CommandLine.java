package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.common.DefaultClassLoaderResourceLoader;
import org.apache.xmlbeans.impl.common.IOUtil;

/* loaded from: classes.dex */
public class CommandLine {
    private static final File[] EMPTY_FILEARRAY = new File[0];
    private static final URL[] EMPTY_URLARRAY = new URL[0];
    private String[] _args;
    private String[] _badopts;
    private File _baseDir;
    private List<File> _files;
    private Map<String, String> _options;
    private List<URL> _urls;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommandLine(String[] strArr, Collection<String> collection, Collection<String> collection2) {
        if (collection == null || collection2 == null) {
            throw new IllegalArgumentException("collection required (use Collections.EMPTY_SET if no options)");
        }
        this._options = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (i2 < strArr.length) {
            if (strArr[i2].indexOf(45) == 0) {
                String strSubstring = strArr[i2].substring(1);
                String str = null;
                if (!collection.contains(strSubstring)) {
                    if (collection2.contains(strSubstring)) {
                        int i3 = i2 + 1;
                        if (i3 < strArr.length) {
                            str = strArr[i3];
                            i2 = i3;
                        } else {
                            str = "";
                        }
                    } else {
                        arrayList.add(strArr[i2]);
                    }
                    this._options.put(strSubstring, str);
                }
            } else {
                arrayList2.add(strArr[i2]);
            }
            i2++;
        }
        this._badopts = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this._args = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
    }

    private static List<File> collectFiles(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            if (file.isDirectory()) {
                arrayList.addAll(collectFiles(file.listFiles()));
            } else {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private List<File> getFileList() {
        if (this._files == null) {
            String[] strArrArgs = args();
            File[] fileArr = new File[strArrArgs.length];
            boolean z = false;
            for (int i2 = 0; i2 < strArrArgs.length; i2++) {
                fileArr[i2] = new File(strArrArgs[i2]);
                if (z || this._baseDir != null) {
                    URI uri = fileArr[i2].toURI();
                    File file = this._baseDir;
                    if (file != null && file.toURI().relativize(uri).equals(uri)) {
                        this._baseDir = null;
                        z = true;
                    }
                } else if (fileArr[i2].isDirectory()) {
                    this._baseDir = fileArr[i2];
                } else {
                    this._baseDir = fileArr[i2].getParentFile();
                }
            }
            this._files = Collections.unmodifiableList(collectFiles(fileArr));
        }
        return this._files;
    }

    private List<URL> getUrlList() {
        if (this._urls == null) {
            String[] strArrArgs = args();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArrArgs.length; i2++) {
                if (looksLikeURL(strArrArgs[i2])) {
                    try {
                        arrayList.add(new URL(strArrArgs[i2]));
                    } catch (MalformedURLException e) {
                        System.err.println("ignoring invalid url: " + strArrArgs[i2] + ": " + e.getMessage());
                    }
                }
            }
            this._urls = Collections.unmodifiableList(arrayList);
        }
        return this._urls;
    }

    private static boolean looksLikeURL(String str) {
        return str.startsWith("http:") || str.startsWith("https:") || str.startsWith("ftp:") || str.startsWith("file:");
    }

    public static void printLicense() {
        try {
            IOUtil.copyCompletely(new DefaultClassLoaderResourceLoader().getResourceAsStream("LICENSE.txt"), System.out);
        } catch (Exception unused) {
            System.out.println("License available in this JAR in LICENSE.txt");
        }
    }

    public static void printVersion() {
        System.out.println(XmlBeans.getVendor() + ", " + XmlBeans.getTitle() + ".XmlBeans version " + XmlBeans.getVersion());
    }

    public String[] args() {
        String[] strArr = this._args;
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public File[] filesEndingWith(String str) {
        ArrayList arrayList = new ArrayList();
        for (File file : getFileList()) {
            if (file.getName().endsWith(str) && !looksLikeURL(file.getPath())) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(EMPTY_FILEARRAY);
    }

    public String[] getBadOpts() {
        return this._badopts;
    }

    public File getBaseDir() {
        return this._baseDir;
    }

    public File[] getFiles() {
        return (File[]) getFileList().toArray(EMPTY_FILEARRAY);
    }

    public String getOpt(String str) {
        return this._options.get(str);
    }

    public URL[] getURLs() {
        return (URL[]) getUrlList().toArray(EMPTY_URLARRAY);
    }
}
