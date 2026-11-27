package i.b.ga;

import android.content.Context;
import android.net.Uri;
import android.system.ErrnoException;
import android.system.Os;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import k.a0.a.d;
import k.b0.g;
import k.b0.s;
import k.b0.t;
import k.b0.u;
import k.v;
import n.a.a.n.d.e;
import n.a.a.n.d.j;
import n.a.a.n.d.o0;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.i2;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public abstract class a {
    public static synchronized void a(Context context, String str, String[] strArr) throws u, d, IOException {
        f(context, str, strArr, -1);
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[XMLEvent.ENTITY_REFERENCE];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            }
            j2 += i2;
            if (j2 > 26214400) {
                throw new IOException("Excel文件超过25MB限制");
            }
            outputStream.write(bArr, 0, i2);
        }
    }

    private static InputStream c(Context context, String str) throws IOException {
        File fileD = d(str);
        InputStream inputStreamOpenInputStream = fileD == null ? context.getContentResolver().openInputStream(Uri.parse(str)) : new FileInputStream(fileD);
        if (inputStreamOpenInputStream != null) {
            return inputStreamOpenInputStream;
        }
        throw new IOException("无法读取Excel文件");
    }

    private static File d(String str) {
        Uri uri = Uri.parse(str);
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if (uri.getScheme() == null) {
            return new File(str);
        }
        return null;
    }

    public static b e(Context context, String str) throws d, IOException {
        File fileD = d(str);
        if (fileD != null) {
            return b.m(fileD);
        }
        File fileCreateTempFile = File.createTempFile("excel-read-", ".tmp", context.getCacheDir());
        try {
            InputStream inputStreamC = c(context, str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    b(inputStreamC, fileOutputStream);
                    fileOutputStream.close();
                    if (inputStreamC != null) {
                        inputStreamC.close();
                    }
                    return b.n(fileCreateTempFile, fileCreateTempFile);
                } finally {
                }
            } catch (Throwable th) {
                if (inputStreamC != null) {
                    try {
                        inputStreamC.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException | d e) {
            fileCreateTempFile.delete();
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void f(Context context, String str, String[] strArr, int i2) throws u, d, IOException {
        File fileD = d(str);
        File fileCreateTempFile = File.createTempFile("excel-backup-", ".tmp", context.getCacheDir());
        File fileCreateTempFile2 = null;
        try {
            InputStream inputStreamC = c(context, str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    b(inputStreamC, fileOutputStream);
                    fileOutputStream.close();
                    if (inputStreamC != null) {
                        inputStreamC.close();
                    }
                    fileCreateTempFile2 = File.createTempFile(".excel-write-", ".tmp", fileD == null ? context.getCacheDir() : fileD.getAbsoluteFile().getParentFile());
                    h(fileCreateTempFile, fileCreateTempFile2, strArr, i2);
                    b bVarM = b.m(fileCreateTempFile2);
                    try {
                        if (bVarM.d() == 0) {
                            throw new IOException("写入后Excel验证失败");
                        }
                        if (bVarM != null) {
                            bVarM.close();
                        }
                        if (fileD != null) {
                            try {
                                Os.rename(fileCreateTempFile2.getAbsolutePath(), fileD.getAbsolutePath());
                            } catch (ErrnoException e) {
                                throw new IOException("无法替换Excel，原文件未改动", e);
                            }
                        } else {
                            try {
                                g(context, str, fileCreateTempFile2);
                            } catch (IOException | RuntimeException e2) {
                                try {
                                    g(context, str, fileCreateTempFile);
                                    throw new IOException("Excel写回失败，已恢复原文件", e2);
                                } catch (IOException e3) {
                                    e = e3;
                                    throw new IOException("写回及恢复失败，原文件备份保留在：" + fileCreateTempFile.getAbsolutePath(), e);
                                } catch (RuntimeException e4) {
                                    e = e4;
                                    throw new IOException("写回及恢复失败，原文件备份保留在：" + fileCreateTempFile.getAbsolutePath(), e);
                                }
                            }
                        }
                        if (fileCreateTempFile2 != null) {
                            fileCreateTempFile2.delete();
                        }
                        fileCreateTempFile.delete();
                        return;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            if (fileCreateTempFile2 != null) {
            }
            if (0 == 0) {
            }
            throw th;
        }
        if (fileCreateTempFile2 != null) {
            fileCreateTempFile2.delete();
        }
        if (0 == 0) {
            fileCreateTempFile.delete();
        }
        throw th;
    }

    private static void g(Context context, String str, File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(Uri.parse(str), "rwt");
            try {
                if (outputStreamOpenOutputStream == null) {
                    throw new IOException("无法打开Excel写入权限");
                }
                b(fileInputStream, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.flush();
                if (outputStreamOpenOutputStream != null) {
                    outputStreamOpenOutputStream.close();
                }
                fileInputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void h(File file, File file2, String[] strArr, int i2) throws Throwable {
        if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            throw new IOException("禁止直接覆盖读取中的工作簿");
        }
        t tVar = null;
        int i3 = 0;
        if (b.j(file)) {
            XSSFWorkbook xSSFWorkbookO = b.o(file);
            try {
                if (xSSFWorkbookO.getNumberOfSheets() == 0) {
                    throw new IOException("Excel没有工作表");
                }
                i2 sheetAt = xSSFWorkbookO.getSheetAt(0);
                if (i2 < 0) {
                    i2 = sheetAt.m() == 0 ? 0 : sheetAt.d() + 1;
                }
                if (i2 >= 1048576) {
                    throw new IOException("XLSX行号不能超过1048576");
                }
                o0 o0VarF = sheetAt.f(i2);
                if (o0VarF == null) {
                    o0VarF = sheetAt.B(i2);
                }
                while (i3 < strArr.length) {
                    e eVarX = o0VarF.x(i3);
                    if (eVarX == null) {
                        eVarX = o0VarF.i(i3);
                    }
                    if (eVarX.b() == j.FORMULA) {
                        eVarX.r(null);
                    }
                    eVarX.s(strArr[i3]);
                    i3++;
                }
                xSSFWorkbookO.setForceFormulaRecalculation(true);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    xSSFWorkbookO.write(fileOutputStream);
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    if (xSSFWorkbookO != null) {
                        xSSFWorkbookO.close();
                        return;
                    }
                    return;
                } finally {
                }
            } catch (Throwable th) {
                if (xSSFWorkbookO != null) {
                    try {
                        xSSFWorkbookO.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        v vVarL = v.l(file);
        try {
            if (vVarL.i() == 0) {
                throw new IOException("Excel没有工作表");
            }
            t tVarG = v.g(file2, vVarL);
            try {
                s sVarG = tVarG.g(0);
                if (i2 < 0) {
                    i2 = sVarG.b();
                }
                if (i2 >= 65536) {
                    throw new IOException("XLS行号不能超过65536");
                }
                while (i3 < strArr.length) {
                    k.z.d dVarE = (i2 >= sVarG.b() || i3 >= sVarG.d()) ? null : sVarG.a(i3, i2).e();
                    g gVar = new g(i3, i2, strArr[i3]);
                    if (dVarE != null) {
                        gVar.o(dVarE);
                    }
                    sVarG.c(gVar);
                    i3++;
                }
                tVarG.h();
                if (tVarG != null) {
                    try {
                        tVarG.f();
                    } finally {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                tVar = tVarG;
                if (tVar != null) {
                    try {
                        tVar.f();
                    } finally {
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static synchronized void i(Context context, String str, String[] strArr, int i2) throws u, d, IOException {
        if (i2 < 1) {
            throw new IOException("Excel行号必须是大于0的整数");
        }
        f(context, str, strArr, i2 - 1);
    }
}
