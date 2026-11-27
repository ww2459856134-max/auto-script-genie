package h.d;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public class f<E> implements Cloneable {
    private static final Object g = new Object();
    private boolean c;
    private long[] d;
    private Object[] e;
    private int f;

    public f() {
        this(10);
    }

    private void e() {
        int i2 = this.f;
        long[] jArr = this.d;
        Object[] objArr = this.e;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != g) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.c = false;
        this.f = i3;
    }

    public void a(long j2, E e) {
        int i2 = this.f;
        if (i2 != 0 && j2 <= this.d[i2 - 1]) {
            j(j2, e);
            return;
        }
        if (this.c && i2 >= this.d.length) {
            e();
        }
        int i3 = this.f;
        if (i3 >= this.d.length) {
            int iF = e.f(i3 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.d = jArr;
            this.e = objArr;
        }
        this.d[i3] = j2;
        this.e[i3] = e;
        this.f = i3 + 1;
    }

    public void b() {
        int i2 = this.f;
        Object[] objArr = this.e;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f = 0;
        this.c = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.d = (long[]) this.d.clone();
            fVar.e = (Object[]) this.e.clone();
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean d(long j2) {
        return h(j2) >= 0;
    }

    public E f(long j2) {
        return g(j2, null);
    }

    public E g(long j2, E e) {
        int iB = e.b(this.d, this.f, j2);
        if (iB >= 0) {
            Object[] objArr = this.e;
            if (objArr[iB] != g) {
                return (E) objArr[iB];
            }
        }
        return e;
    }

    public int h(long j2) {
        if (this.c) {
            e();
        }
        return e.b(this.d, this.f, j2);
    }

    public long i(int i2) {
        if (this.c) {
            e();
        }
        return this.d[i2];
    }

    public void j(long j2, E e) {
        int iB = e.b(this.d, this.f, j2);
        if (iB >= 0) {
            this.e[iB] = e;
            return;
        }
        int i2 = ~iB;
        int i3 = this.f;
        if (i2 < i3) {
            Object[] objArr = this.e;
            if (objArr[i2] == g) {
                this.d[i2] = j2;
                objArr[i2] = e;
                return;
            }
        }
        if (this.c && i3 >= this.d.length) {
            e();
            i2 = ~e.b(this.d, this.f, j2);
        }
        int i4 = this.f;
        if (i4 >= this.d.length) {
            int iF = e.f(i4 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.d;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = jArr;
            this.e = objArr2;
        }
        int i5 = this.f;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.d;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f - i2);
        }
        this.d[i2] = j2;
        this.e[i2] = e;
        this.f++;
    }

    public void k(long j2) {
        int iB = e.b(this.d, this.f, j2);
        if (iB >= 0) {
            Object[] objArr = this.e;
            Object obj = objArr[iB];
            Object obj2 = g;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.c = true;
            }
        }
    }

    public void l(int i2) {
        Object[] objArr = this.e;
        Object obj = objArr[i2];
        Object obj2 = g;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.c = true;
        }
    }

    public int m() {
        if (this.c) {
            e();
        }
        return this.f;
    }

    public E n(int i2) {
        if (this.c) {
            e();
        }
        return (E) this.e[i2];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(i(i2));
            sb.append(Chars.EQ);
            E eN = n(i2);
            if (eN != this) {
                sb.append(eN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i2) {
        this.c = false;
        if (i2 == 0) {
            this.d = e.b;
            this.e = e.c;
        } else {
            int iF = e.f(i2);
            this.d = new long[iF];
            this.e = new Object[iF];
        }
    }
}
