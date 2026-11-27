package n.a.a.n.c;

import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.n2;
import n.a.a.n.c.u1.q1;
import n.a.a.n.c.u1.u1;
import n.a.a.n.c.u1.x1;
import n.a.a.n.c.u1.x2;
import n.a.a.n.c.u1.y1;
import n.a.a.n.c.u1.y2;

/* loaded from: classes.dex */
final class r0 {
    private final f0 a;

    public r0(f0 f0Var) {
        this.a = f0Var;
    }

    private static boolean a(k2 k2Var) {
        if (!(k2Var instanceof n.a.a.n.c.u1.y0)) {
            return false;
        }
        n.a.a.n.c.u1.y0 y0Var = (n.a.a.n.c.u1.y0) k2Var;
        if (y0Var.s() != 32) {
            return false;
        }
        for (int iP = y0Var.p() - 1; iP >= 0; iP--) {
            if (y0Var.v(iP) != 32) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(k2 k2Var) {
        if (k2Var instanceof n.a.a.n.c.u1.h1) {
            return ((n.a.a.n.c.u1.h1) k2Var).B();
        }
        return false;
    }

    private void c(n.a.a.n.c.u1.y0 y0Var, byte b, boolean z) {
        if (z || b == 64) {
            y0Var.n((byte) 64);
        } else {
            y0Var.n((byte) 32);
        }
    }

    private byte d(byte b, byte b2, boolean z) {
        if (b2 == 0) {
            if (z) {
                return (byte) 0;
            }
            return b;
        }
        if (b2 != 32) {
            if (b2 != 64) {
                throw new IllegalStateException("Unexpected operand class (" + ((int) b2) + ")");
            }
        } else if (!z) {
            return (byte) 32;
        }
        return (byte) 64;
    }

    private void f(n.a.a.n.c.u1.y0 y0Var, w0[] w0VarArr, byte b, boolean z) {
        byte bS = y0Var.s();
        boolean z2 = true;
        if (z) {
            if (bS != 0) {
                if (bS == 32) {
                    y0Var.n((byte) 64);
                } else {
                    if (bS != 64) {
                        throw new IllegalStateException("Unexpected operand class (" + ((int) bS) + ")");
                    }
                    y0Var.n((byte) 64);
                }
            } else if (b == 0) {
                y0Var.n((byte) 0);
            } else {
                y0Var.n((byte) 64);
            }
            z2 = false;
        } else {
            if (bS == b) {
                y0Var.n(bS);
            } else if (b != 0) {
                if (b == 32) {
                    y0Var.n((byte) 32);
                } else {
                    if (b != 64) {
                        throw new IllegalStateException("Unexpected operand class (" + ((int) b) + ")");
                    }
                    if (bS == 0) {
                        y0Var.n((byte) 0);
                    } else {
                        if (bS != 32) {
                            throw new IllegalStateException("Unexpected operand class (" + ((int) bS) + ")");
                        }
                        y0Var.n((byte) 64);
                    }
                    if (bS != 32) {
                    }
                }
            } else if (bS == 32) {
                y0Var.n((byte) 32);
            } else {
                if (bS != 64) {
                    throw new IllegalStateException("Unexpected operand class (" + ((int) bS) + ")");
                }
                y0Var.n((byte) 64);
            }
            z2 = false;
        }
        for (int i2 = 0; i2 < w0VarArr.length; i2++) {
            g(w0VarArr[i2], y0Var.v(i2), z2);
        }
    }

    private void g(w0 w0Var, byte b, boolean z) {
        k2 k2VarE = w0Var.e();
        w0[] w0VarArrC = w0Var.c();
        int i2 = 0;
        if (a(k2VarE)) {
            boolean z2 = b == 64;
            int length = w0VarArrC.length;
            while (i2 < length) {
                g(w0VarArrC[i2], b, z2);
                i2++;
            }
            c((n.a.a.n.c.u1.y0) k2VarE, b, z);
            return;
        }
        if (b(k2VarE)) {
            k2VarE = q1.f2447j;
        }
        if ((k2VarE instanceof y2) || (k2VarE instanceof n.a.a.n.c.u1.k1) || (k2VarE instanceof y1) || (k2VarE instanceof x1) || (k2VarE instanceof x2) || (k2VarE instanceof u1)) {
            if (b == 0) {
                b = 32;
            }
            int length2 = w0VarArrC.length;
            while (i2 < length2) {
                g(w0VarArrC[i2], b, z);
                i2++;
            }
            return;
        }
        if (k2VarE instanceof n.a.a.n.c.u1.y0) {
            f((n.a.a.n.c.u1.y0) k2VarE, w0VarArrC, b, z);
            return;
        }
        if (w0VarArrC.length > 0) {
            if (k2VarE != n2.d) {
                throw new IllegalStateException("Node should not have any children");
            }
        } else {
            if (k2VarE.m()) {
                return;
            }
            k2VarE.n(d(k2VarE.i(), b, z));
        }
    }

    public void e(w0 w0Var) {
        byte b;
        int i2 = q0.a[this.a.ordinal()];
        if (i2 == 1) {
            b = 32;
        } else if (i2 == 2) {
            b = 64;
        } else {
            if (i2 != 3 && i2 != 4) {
                throw new IllegalStateException("Incomplete code - formula type (" + this.a + ") not supported yet");
            }
            b = 0;
        }
        g(w0Var, b, false);
    }
}
