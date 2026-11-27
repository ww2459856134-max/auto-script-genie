package i.b.ga;

import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import k.a0.a.d;
import k.v;
import n.a.a.k.c.f;
import n.a.a.n.d.o0;
import n.a.a.n.d.w;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.f2;
import org.apache.poi.xssf.usermodel.i2;

/* loaded from: classes.dex */
public final class b implements Closeable {
    private final v c;
    private final XSSFWorkbook d;
    private final w e;
    private final File f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1397h;

    public static final class a {
        private final String a;

        a(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    private b(v vVar, XSSFWorkbook xSSFWorkbook, File file) throws IOException {
        this.c = vVar;
        this.d = xSSFWorkbook;
        this.f = file;
        w wVar = xSSFWorkbook == null ? null : new w();
        this.e = wVar;
        int iMax = 0;
        if (vVar != null) {
            if (vVar.i() == 0) {
                throw new IOException("Excel没有工作表");
            }
            this.g = vVar.j(0).b();
            this.f1397h = vVar.j(0).d();
            return;
        }
        if (xSSFWorkbook.getNumberOfSheets() == 0) {
            throw new IOException("Excel没有工作表");
        }
        wVar.z(true);
        i2 sheetAt = xSSFWorkbook.getSheetAt(0);
        this.g = sheetAt.m() == 0 ? 0 : sheetAt.d() + 1;
        Iterator<o0> it = sheetAt.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, (int) it.next().n());
        }
        this.f1397h = iMax;
    }

    private static synchronized void i() {
        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
        f.M(33554432L);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean j(File file) throws IOException {
        boolean z;
        if (file.length() > 26214400) {
            throw new IOException("Excel文件超过25MB限制");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            if (fileInputStream.read() == 80) {
                z = fileInputStream.read() == 75;
            }
            fileInputStream.close();
            return z;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static b m(File file) throws d, IOException {
        return n(file, null);
    }

    static b n(File file, File file2) throws Throwable {
        XSSFWorkbook xSSFWorkbook;
        XSSFWorkbook xSSFWorkbookO;
        v vVarL = null;
        try {
            if (j(file)) {
                xSSFWorkbookO = o(file);
            } else {
                vVarL = v.l(file);
                xSSFWorkbookO = null;
            }
        } catch (IOException | RuntimeException | d e) {
            e = e;
            xSSFWorkbook = null;
        }
        try {
            return new b(vVarL, xSSFWorkbookO, file2);
        } catch (IOException | RuntimeException | d e2) {
            xSSFWorkbook = xSSFWorkbookO;
            e = e2;
            if (vVarL != null) {
                vVarL.f();
            }
            if (xSSFWorkbook != null) {
                xSSFWorkbook.close();
            }
            throw e;
        }
    }

    static XSSFWorkbook o(File file) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            throw new IOException("XLSX需要Android 8.0或以上；当前系统请使用XLS格式");
        }
        i();
        p(file);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(fileInputStream);
            fileInputStream.close();
            return xSSFWorkbook;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void p(File file) throws IOException {
        HashSet hashSet = new HashSet();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            long j2 = 0;
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!hashSet.add(zipEntryNextElement.getName())) {
                    throw new IOException("XLSX存在重复ZIP条目");
                }
                long size = zipEntryNextElement.getSize();
                if (size < 0 || size > 33554432 || hashSet.size() > 10000) {
                    throw new IOException("XLSX结构超过安全限制");
                }
                j2 += size;
                if (j2 > 134217728) {
                    throw new IOException("XLSX解压大小超过128MB限制");
                }
            }
            if (zipFile.getEntry("xl/workbook.xml") == null) {
                throw new IOException("不是有效的XLSX工作簿");
            }
            if (zipFile.getEntry("xl/vbaProject.bin") != null) {
                throw new IOException("暂不支持带宏的Excel文件");
            }
            zipFile.close();
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public a a(int i2, int i3) {
        if (i2 < 0 || i3 < 0 || i2 >= this.f1397h || i3 >= this.g) {
            throw new IndexOutOfBoundsException("Excel行列超出范围");
        }
        v vVar = this.c;
        if (vVar != null) {
            return new a(vVar.j(0).a(i2, i3).p());
        }
        f2 f2VarF = this.d.getSheetAt(0).f(i3);
        return new a(f2VarF == null ? "" : this.e.l(f2VarF.x(i2)));
    }

    public int c() {
        return this.f1397h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            v vVar = this.c;
            if (vVar != null) {
                vVar.f();
            }
            XSSFWorkbook xSSFWorkbook = this.d;
            if (xSSFWorkbook != null) {
                xSSFWorkbook.close();
            }
        } finally {
            File file = this.f;
            if (file != null) {
                file.delete();
            }
        }
    }

    public int d() {
        return this.g;
    }

    public b f(int i2) {
        if (i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("节点仅读取第一个工作表");
    }
}
