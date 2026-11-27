package n.a.a.n.c.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import n.a.a.o.w0;

/* loaded from: classes.dex */
abstract class c {
    private static int a = 100000;
    private static final Pattern b = Pattern.compile("\t");
    private static final Pattern c = Pattern.compile(" ");
    private static final byte[] d = new byte[0];
    private static final String[] e;
    private static final Set<String> f;

    static {
        String[] strArr = {"LOG10", "ATAN2", "DAYS360", "SUMXMY2", "SUMX2MY2", "SUMX2PY2", "A1.R1C1"};
        e = strArr;
        f = new HashSet(Arrays.asList(strArr));
    }

    public static d a() throws IOException {
        a aVar = new a(800);
        j(aVar, "functionMetadata.txt");
        return aVar.b();
    }

    public static d b() throws IOException {
        a aVar = new a(800);
        j(aVar, "functionMetadataCetab.txt");
        return aVar.b();
    }

    public static int c() {
        return a;
    }

    private static boolean d(String str) {
        return str.length() == 1 && str.charAt(0) == '-';
    }

    private static int e(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalStateException("Value '" + str + "' could not be parsed as an integer");
        }
    }

    private static byte f(String str) {
        if (str.length() != 1) {
            throw new IllegalStateException("Bad operand type code format '" + str + "' expected single char");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'A') {
            return (byte) 64;
        }
        if (cCharAt == 'R') {
            return (byte) 0;
        }
        if (cCharAt == 'V') {
            return (byte) 32;
        }
        throw new IllegalArgumentException("Unexpected operand type code '" + str + "' (" + ((int) str.charAt(0)) + ")");
    }

    private static byte[] g(String str) {
        if (str.length() < 1) {
            return d;
        }
        if (d(str)) {
            return d;
        }
        String[] strArrSplit = c.split(str);
        int length = strArrSplit.length;
        if ("...".equals(strArrSplit[length - 1])) {
            length--;
        }
        byte[] bArrL = w0.l(length, c());
        for (int i2 = 0; i2 < length; i2++) {
            bArrL[i2] = f(strArrSplit[i2]);
        }
        return bArrL;
    }

    private static byte h(String str) {
        if (str.isEmpty()) {
            return (byte) 0;
        }
        return f(str);
    }

    private static void i(a aVar, String str) {
        String[] strArrSplit = b.split(str, -2);
        if (strArrSplit.length != 8) {
            throw new IllegalStateException("Bad line format '" + str + "' - expected 8 data fields delimited by tab, but had " + strArrSplit.length + ": " + Arrays.toString(strArrSplit));
        }
        int iE = e(strArrSplit[0]);
        String str2 = strArrSplit[1];
        int iE2 = e(strArrSplit[2]);
        int iE3 = e(strArrSplit[3]);
        byte bH = h(strArrSplit[4]);
        byte[] bArrG = g(strArrSplit[5]);
        boolean z = !strArrSplit[7].isEmpty();
        k(str2);
        aVar.a(iE, str2, iE2, iE3, bH, bArrG, z);
    }

    /* JADX WARN: Finally extract failed */
    private static void j(a aVar, String str) throws IOException {
        try {
            InputStream resourceAsStream = c.class.getResourceAsStream(str);
            try {
                if (resourceAsStream == null) {
                    throw new IllegalStateException("resource '" + str + "' not found");
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.length() >= 1 && line.charAt(0) != '#' && line.trim().length() >= 1) {
                            i(aVar, line);
                        }
                    } finally {
                    }
                }
                bufferedReader.close();
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static void k(String str) {
        int length = str.length() - 1;
        if (Character.isDigit(str.charAt(length))) {
            while (length >= 0 && Character.isDigit(str.charAt(length))) {
                length--;
            }
            if (f.contains(str)) {
                return;
            }
            throw new IllegalStateException("Invalid function name '" + str + "' (is footnote number incorrectly appended)");
        }
    }
}
