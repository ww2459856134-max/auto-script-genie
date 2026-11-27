package n.a.a.q.c;

/* loaded from: classes.dex */
public abstract class d {
    public static long[] a(long[] jArr, long[] jArr2) {
        int iB = b(jArr, jArr2);
        return iB != 0 ? iB != 1 ? iB != 2 ? iB != 3 ? new long[]{-1, -1} : jArr : jArr2 : new long[]{jArr[0], jArr2[1]} : new long[]{jArr2[0], jArr[1]};
    }

    public static int b(long[] jArr, long[] jArr2) {
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr2[0];
        long j5 = jArr2[1];
        if (j2 >= j4) {
            if (j3 <= j5) {
                return 3;
            }
            return j2 <= j5 ? 1 : -1;
        }
        if (j3 >= j5) {
            return 2;
        }
        return j3 >= j4 ? 0 : -1;
    }
}
