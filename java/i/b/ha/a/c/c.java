package i.b.ha.a.c;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class c {
    static {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.put(StandardCharsets.ISO_8859_1.name(), StandardCharsets.ISO_8859_1);
        treeMap.put(StandardCharsets.US_ASCII.name(), StandardCharsets.US_ASCII);
        treeMap.put(StandardCharsets.UTF_16.name(), StandardCharsets.UTF_16);
        treeMap.put(StandardCharsets.UTF_16BE.name(), StandardCharsets.UTF_16BE);
        treeMap.put(StandardCharsets.UTF_16LE.name(), StandardCharsets.UTF_16LE);
        treeMap.put(StandardCharsets.UTF_8.name(), StandardCharsets.UTF_8);
        Collections.unmodifiableSortedMap(treeMap);
        Charset charset = StandardCharsets.ISO_8859_1;
        Charset charset2 = StandardCharsets.US_ASCII;
        Charset charset3 = StandardCharsets.UTF_16;
        Charset charset4 = StandardCharsets.UTF_16BE;
        Charset charset5 = StandardCharsets.UTF_16LE;
        Charset charset6 = StandardCharsets.UTF_8;
    }

    public static Charset a(String str) throws UnsupportedCharsetException {
        return b(str, Charset.defaultCharset());
    }

    public static Charset b(String str, Charset charset) throws UnsupportedCharsetException {
        return str == null ? charset : Charset.forName(str);
    }

    public static Charset c(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset d(Charset charset, Charset charset2) {
        return charset == null ? charset2 : charset;
    }
}
