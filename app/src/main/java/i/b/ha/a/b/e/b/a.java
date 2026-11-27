package i.b.ha.a.b.e.b;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
final class a {
    final boolean[] a = new boolean[256];
    final byte[] b = new byte[256];
    final byte[] c = new byte[18002];
    final byte[] d = new byte[18002];
    final int[] e = new int[256];
    final int[][] f = (int[][]) Array.newInstance((Class<?>) int.class, 6, 258);
    final int[][] g = (int[][]) Array.newInstance((Class<?>) int.class, 6, 258);

    /* renamed from: h, reason: collision with root package name */
    final int[][] f1450h = (int[][]) Array.newInstance((Class<?>) int.class, 6, 258);

    /* renamed from: i, reason: collision with root package name */
    final int[] f1451i = new int[6];

    /* renamed from: j, reason: collision with root package name */
    final int[] f1452j = new int[257];

    /* renamed from: k, reason: collision with root package name */
    final char[] f1453k = new char[256];

    /* renamed from: l, reason: collision with root package name */
    final char[][] f1454l = (char[][]) Array.newInstance((Class<?>) char.class, 6, 258);

    /* renamed from: m, reason: collision with root package name */
    final byte[] f1455m = new byte[6];

    /* renamed from: n, reason: collision with root package name */
    int[] f1456n;

    /* renamed from: o, reason: collision with root package name */
    final byte[] f1457o;

    a(int i2) {
        this.f1457o = new byte[i2 * 100000];
    }

    int[] a(int i2) {
        int[] iArr = this.f1456n;
        if (iArr != null && iArr.length >= i2) {
            return iArr;
        }
        int[] iArr2 = new int[i2];
        this.f1456n = iArr2;
        return iArr2;
    }
}
