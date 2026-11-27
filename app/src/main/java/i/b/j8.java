package i.b;

import android.view.accessibility.AccessibilityEvent;
import com.frame.w0;
import com.yl.model.Node;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class j8 implements w0.a {
    private static j8 e;
    private long a;
    private t8 b;
    private Node c;
    private ExecutorService d = Executors.newFixedThreadPool(4);

    private j8() {
    }

    public static j8 b() {
        j8 j8Var = e;
        if (j8Var != null) {
            return j8Var;
        }
        j8 j8Var2 = new j8();
        e = j8Var2;
        return j8Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str) {
        try {
            e(str);
            try {
                w7.g().b(com.frame.w0.b().getRootInActiveWindow().getPackageName().toString());
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    @Override // com.frame.w0.a
    public void a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getPackageName() == null || accessibilityEvent.getClassName() == null) {
            return;
        }
        final String string = accessibilityEvent.getPackageName().toString();
        if (da.B().U()) {
            return;
        }
        this.d.execute(new Runnable() { // from class: i.b.c2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d(string);
            }
        });
    }

    public synchronized void e(String str) {
        if (str != null) {
            List<Node> list = k8.d().h().get(str);
            if (list != null && !list.isEmpty()) {
                if (this.b == null) {
                    this.b = new t8();
                    t9 t9Var = new t9(null);
                    t9Var.g0(true);
                    this.b.S(t9Var);
                }
                Iterator<Node> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Node next = it.next();
                    this.b.W(next);
                    if (this.b.d0(next, next.url) != null && next != this.c && System.currentTimeMillis() - this.a > 1000) {
                        this.a = System.currentTimeMillis();
                        this.c = next;
                        this.b.E(next, Long.valueOf(next.getJumpNodeId()), false);
                        break;
                    }
                }
            } else if (!str.equals(com.frame.v0.g().getPackageName())) {
                this.c = null;
            }
        }
    }
}
