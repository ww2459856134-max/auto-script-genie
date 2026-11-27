package n.a.a.n.c;

import java.util.Stack;
import n.a.a.n.c.u1.g2;
import n.a.a.n.c.u1.h2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.x1;
import n.a.a.n.c.u1.y1;

/* loaded from: classes.dex */
public abstract class d0 {
    private static String[] a(Stack<String> stack, int i2) {
        String[] strArr = new String[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (stack.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Too few arguments supplied to operation. Expected (");
                sb.append(i2);
                sb.append(") operands but got (");
                sb.append((i2 - i3) - 1);
                sb.append(")");
                throw new IllegalStateException(sb.toString());
            }
            strArr[i3] = stack.pop();
        }
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b(e0 e0Var, k2[] k2VarArr) {
        if (k2VarArr == 0 || k2VarArr.length == 0) {
            throw new IllegalArgumentException("ptgs must not be null");
        }
        Stack stack = new Stack();
        for (n.a.a.n.c.u1.f1 f1Var : k2VarArr) {
            if (!(f1Var instanceof x1) && !(f1Var instanceof y1)) {
                if (f1Var instanceof h2) {
                    stack.push("(" + ((String) stack.pop()) + ")");
                } else if (f1Var instanceof n.a.a.n.c.u1.h1) {
                    n.a.a.n.c.u1.h1 h1Var = (n.a.a.n.c.u1.h1) f1Var;
                    if (!h1Var.x() && !h1Var.w() && !h1Var.z() && !h1Var.A() && !h1Var.y()) {
                        if (!h1Var.B()) {
                            throw new IllegalStateException("Unexpected tAttr: " + h1Var);
                        }
                        stack.push(h1Var.I(a(stack, h1Var.u())));
                    }
                } else if (f1Var instanceof l1) {
                    stack.push(((l1) f1Var).b(e0Var));
                } else if (f1Var instanceof g2) {
                    g2 g2Var = (g2) f1Var;
                    stack.push(g2Var.q(a(stack, g2Var.p())));
                } else {
                    stack.push(f1Var.o());
                }
            }
        }
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String str = (String) stack.pop();
        if (stack.isEmpty()) {
            return str;
        }
        throw new IllegalStateException("too much stuff left on the stack");
    }
}
