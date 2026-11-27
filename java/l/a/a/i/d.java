package l.a.a.i;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import l.a.a.f.r;
import l.a.a.f.s;

/* loaded from: classes.dex */
public abstract class d {
    public static final byte[] a = {0, 0, -92, -127};
    public static final byte[] b = {0, 0, -19, 65};

    public static void A(Path path, byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (w()) {
            c(path, bArr);
        } else if (s() || v()) {
            b(path, bArr);
        }
    }

    public static void B(Path path, long j2) throws IOException {
        if (j2 <= 0 || !Files.exists(path, new LinkOption[0])) {
            return;
        }
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(i.f(j2)));
        } catch (Exception unused) {
        }
    }

    public static void C(File file, long j2) {
        file.setLastModified(i.f(j2));
    }

    private static void a(byte b2, int i2, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (a.a(b2, i2)) {
            set.add(posixFilePermission);
        }
    }

    private static void b(Path path, byte[] bArr) throws IOException {
        if (bArr[2] == 0 && bArr[3] == 0) {
            return;
        }
        try {
            HashSet hashSet = new HashSet();
            a(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
            a(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
            a(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
            a(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
            a(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
            a(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
            a(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
            a(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
            a(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(path, hashSet);
        } catch (IOException unused) {
        }
    }

    private static void c(Path path, byte[] bArr) throws IOException {
        DosFileAttributeView dosFileAttributeView;
        if (bArr[0] == 0 || (dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)) == null) {
            return;
        }
        try {
            dosFileAttributeView.setReadOnly(a.a(bArr[0], 0));
            dosFileAttributeView.setHidden(a.a(bArr[0], 1));
            dosFileAttributeView.setSystem(a.a(bArr[0], 2));
            dosFileAttributeView.setArchive(a.a(bArr[0], 5));
        } catch (IOException unused) {
        }
    }

    private static void d(File file) throws l.a.a.c.b {
        if (file.exists()) {
            return;
        }
        throw new l.a.a.c.b("File does not exist: " + file);
    }

    public static void e(List<File> list, r rVar) throws l.a.a.c.b {
        for (File file : list) {
            if (!u(file)) {
                d(file);
            } else if (rVar.equals(r.INCLUDE_LINK_AND_LINKED_FILE) || rVar.equals(r.INCLUDE_LINKED_FILE_ONLY)) {
                f(file);
            }
        }
    }

    private static void f(File file) throws l.a.a.c.b {
        if (file.exists()) {
            return;
        }
        throw new l.a.a.c.b("Symlink target '" + y(file) + "' does not exist for link '" + file + "'");
    }

    public static void g(RandomAccessFile randomAccessFile, OutputStream outputStream, long j2, long j3, l.a.a.g.d dVar, int i2) throws InterruptedException, IOException {
        long j4 = 0;
        if (j2 < 0 || j3 < 0 || j2 > j3) {
            throw new l.a.a.c.b("invalid offsets");
        }
        if (j2 == j3) {
            return;
        }
        try {
            randomAccessFile.seek(j2);
            long j5 = j3 - j2;
            byte[] bArr = j5 < ((long) i2) ? new byte[(int) j5] : new byte[i2];
            while (true) {
                int i3 = randomAccessFile.read(bArr);
                if (i3 == -1) {
                    return;
                }
                outputStream.write(bArr, 0, i3);
                long j6 = i3;
                dVar.l(j6);
                if (dVar.e()) {
                    dVar.i(l.a.a.g.a.CANCELLED);
                    return;
                }
                j4 += j6;
                if (j4 == j5) {
                    return;
                }
                if (bArr.length + j4 > j5) {
                    bArr = new byte[(int) (j5 - j4)];
                }
            }
        } catch (IOException e) {
            throw new l.a.a.c.b(e);
        }
    }

    public static File[] h(File file) {
        File[] fileArrListFiles = file.getParentFile().listFiles(new c(l(file.getName())));
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles);
        return fileArrListFiles;
    }

    public static byte[] i(boolean z) {
        byte[] bArr = new byte[4];
        if (v() || s()) {
            if (z) {
                System.arraycopy(b, 0, bArr, 0, 4);
            } else {
                System.arraycopy(a, 0, bArr, 0, 4);
            }
        } else if (w() && z) {
            bArr[0] = a.b(bArr[0], 4);
        }
        return bArr;
    }

    public static byte[] j(File file) {
        if (file != null) {
            try {
                if (Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    Path path = file.toPath();
                    if (w()) {
                        return q(path);
                    }
                    if (!s() && !v()) {
                        return new byte[4];
                    }
                    return o(path);
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static String k(File file) {
        String name = file.getName();
        return !name.contains(".") ? "" : name.substring(name.lastIndexOf(".") + 1);
    }

    public static String l(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public static List<File> m(File file, s sVar) throws l.a.a.c.b {
        if (file == null) {
            throw new l.a.a.c.b("input path is null, cannot read files in the directory");
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && file.canRead() && fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if ((sVar.i() == null || !sVar.i().a(file2)) && (!file2.isHidden() || sVar.r())) {
                    arrayList.add(file2);
                    r rVarN = sVar.n();
                    boolean zU = u(file2);
                    if ((zU && !r.INCLUDE_LINK_ONLY.equals(rVarN)) || (!zU && file2.isDirectory())) {
                        arrayList.addAll(m(file2, sVar));
                    }
                }
            }
        }
        return arrayList;
    }

    private static String n(File file, String str) throws IOException {
        return i.j(str) ? str : u(file) ? file.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).getFileName().toString() : file.getName();
    }

    private static byte[] o(Path path) {
        byte[] bArr = new byte[4];
        try {
            Set<PosixFilePermission> setPermissions = ((PosixFileAttributeView) Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes().permissions();
            boolean zIsSymbolicLink = Files.isSymbolicLink(path);
            if (zIsSymbolicLink) {
                bArr[3] = a.b(bArr[3], 7);
                bArr[3] = a.c(bArr[3], 6);
            } else {
                bArr[3] = z(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
                bArr[3] = z(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            }
            bArr[3] = z(zIsSymbolicLink, bArr[3], 5);
            bArr[3] = z(setPermissions.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = z(setPermissions.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String p(File file, s sVar) throws IOException {
        String strN;
        String strSubstring;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (i.j(sVar.e())) {
                String canonicalPath2 = new File(sVar.e()).getCanonicalPath();
                String str = e.a;
                if (!canonicalPath2.endsWith(str)) {
                    canonicalPath2 = canonicalPath2 + str;
                }
                if (u(file)) {
                    strSubstring = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
                } else if (file.getCanonicalFile().getPath().startsWith(canonicalPath2)) {
                    strSubstring = canonicalPath.substring(canonicalPath2.length());
                } else {
                    strSubstring = file.getCanonicalFile().getParentFile().getName() + str + file.getCanonicalFile().getName();
                }
                if (strSubstring.startsWith(System.getProperty("file.separator"))) {
                    strSubstring = strSubstring.substring(1);
                }
                File file2 = new File(canonicalPath);
                if (file2.isDirectory()) {
                    strN = strSubstring.replaceAll("\\\\", "/") + "/";
                } else {
                    strN = strSubstring.substring(0, strSubstring.lastIndexOf(file2.getName())).replaceAll("\\\\", "/") + n(file2, sVar.k());
                }
            } else {
                File file3 = new File(canonicalPath);
                strN = n(file3, sVar.k());
                if (file3.isDirectory()) {
                    strN = strN + "/";
                }
            }
            String strM = sVar.m();
            if (i.j(strM)) {
                if (!strM.endsWith("\\") && !strM.endsWith("/")) {
                    strM = strM + e.a;
                }
                strM = strM.replaceAll("\\\\", "/");
                strN = strM + strN;
            }
            if (i.j(strN)) {
                return strN;
            }
            String str2 = "fileName to add to zip is empty or null. fileName: '" + strN + "' DefaultFolderPath: '" + sVar.e() + "' FileNameInZip: " + sVar.k();
            if (u(file)) {
                str2 = str2 + "isSymlink: true ";
            }
            if (i.j(strM)) {
                str2 = "rootFolderNameInZip: '" + strM + "' ";
            }
            throw new l.a.a.c.b(str2);
        } catch (IOException e) {
            throw new l.a.a.c.b(e);
        }
    }

    private static byte[] q(Path path) throws IOException {
        DosFileAttributeView dosFileAttributeView;
        byte[] bArr = new byte[4];
        try {
            dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        } catch (IOException unused) {
        }
        if (dosFileAttributeView == null) {
            return bArr;
        }
        DosFileAttributes attributes = dosFileAttributeView.readAttributes();
        bArr[0] = z(attributes.isArchive(), z(attributes.isDirectory(), z(attributes.isSystem(), z(attributes.isHidden(), z(attributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
        return bArr;
    }

    public static String r(String str) throws l.a.a.c.b {
        if (!i.j(str)) {
            throw new l.a.a.c.b("zip file name is empty or null, cannot determine zip file name");
        }
        if (str.contains(System.getProperty("file.separator"))) {
            str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
        }
        return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    public static boolean s() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean t(File file) {
        return file.getName().endsWith(".zip.001");
    }

    public static boolean u(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static boolean v() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    public static boolean w() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean x(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static String y(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    private static byte z(boolean z, byte b2, int i2) {
        return z ? a.b(b2, i2) : b2;
    }
}
