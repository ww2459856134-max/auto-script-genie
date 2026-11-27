package h.d;

import com.auto.exceldeps.log4j.util.Chars;

/* loaded from: classes.dex */
public class j<E> implements Cloneable {
    private static final Object g = new Object();
    private boolean c;
    private int[] d;
    private Object[] e;
    private int f;

    public j() {
        this(10);
    }

    private void d() {
        int i2 = this.f;
        int[] iArr = this.d;
        Object[] objArr = this.e;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != g) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.c = false;
        this.f = i3;
    }

    public void a(int i2, E e) {
        int i3 = this.f;
        if (i3 != 0 && i2 <= this.d[i3 - 1]) {
            h(i2, e);
            return;
        }
        if (this.c && i3 >= this.d.length) {
            d();
        }
        int i4 = this.f;
        if (i4 >= this.d.length) {
            int iE = e.e(i4 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.e;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.d = iArr;
            this.e = objArr;
        }
        this.d[i4] = i2;
        this.e[i4] = e;
        this.f = i4 + 1;
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
    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.d = (int[]) this.d.clone();
            jVar.e = (Object[]) this.e.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E e(int i2) {
        return f(i2, null);
    }

    public E f(int i2, E e) {
        int iA = e.a(this.d, this.f, i2);
        if (iA >= 0) {
            Object[] objArr = this.e;
            if (objArr[iA] != g) {
                return (E) objArr[iA];
            }
        }
        return e;
    }

    public int g(int i2) {
        if (this.c) {
            d();
        }
        return this.d[i2];
    }

    public void h(int i2, E e) {
        int iA = e.a(this.d, this.f, i2);
        if (iA >= 0) {
            this.e[iA] = e;
            return;
        }
        int i3 = ~iA;
        int i4 = this.f;
        if (i3 < i4) {
            Object[] objArr = this.e;
            if (objArr[i3] == g) {
                this.d[i3] = i2;
                objArr[i3] = e;
                return;
            }
        }
        if (this.c && i4 >= this.d.length) {
            d();
            i3 = ~e.a(this.d, this.f, i2);
        }
        int i5 = this.f;
        if (i5 >= this.d.length) {
            int iE = e.e(i5 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.d;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.e;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = iArr;
            this.e = objArr2;
        }
        int i6 = this.f;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.d;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.e;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f - i3);
        }
        this.d[i3] = i2;
        this.e[i3] = e;
        this.f++;
    }

    public int i() {
        if (this.c) {
            d();
        }
        return this.f;
    }

    public E j(int i2) {
        if (this.c) {
            d();
        }
        return (E) this.e[i2];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append(Chars.EQ);
            E eJ = j(i2);
            if (eJ != this) {
                sb.append(eJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i2) {
        this.c = false;
        if (i2 == 0) {
            this.d = e.a;
            this.e = e.c;
        } else {
            int iE = e.e(i2);
            this.d = new int[iE];
            this.e = new Object[iE];
        }
    }
}
