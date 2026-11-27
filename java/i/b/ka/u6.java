package i.b.ka;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.Gson;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.MultiGestureRecordFloatView;
import com.v.MultiLogicJumpDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.i9;
import i.b.v8;
import i.b.x7;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.opencv.core.Mat;

/* loaded from: classes.dex */
public class u6 extends x5 {
    private long e;
    private int f;

    public u6() {
        new HashSet();
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(Node node) {
        FloatToast.g(j.b.d.g0, O(node, this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X() throws JSONException {
        da.B().x1(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(Node node, Runnable runnable) {
        if (this.c.q()) {
            this.c.U(node.nextId, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(Node node, Node node2) throws JSONException {
        if (this.c.q()) {
            E(node, Long.valueOf(node2.nextTaskId), node2.successJumpBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(lt ltVar, Node node) {
        if (v8.m().p() != null && D(node, (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e()))) {
            v8.m().p().setNeedScan(true);
        }
        v8.m().X(node);
        com.frame.l1.e(s5.c);
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.n1
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(FloatHandlerRecord.class);
            }
        });
        MultiGestureRecordFloatView.c(200L);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 34;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        MultiLogicJumpDialogView multiLogicJumpDialogView = (MultiLogicJumpDialogView) com.frame.s0.g().B(MultiLogicJumpDialogView.class);
        multiLogicJumpDialogView.setTaskNode(task, node);
        multiLogicJumpDialogView.Z(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.what = 1;
        nodeQ.type = 34;
        nodeQ.timeOut = 5000L;
        nodeQ.nextType = 2;
        nodeQ.errorType = 2;
        nodeQ.delay = "500";
        MultiLogicJumpDialogView multiLogicJumpDialogView = (MultiLogicJumpDialogView) com.frame.s0.g().B(MultiLogicJumpDialogView.class);
        multiLogicJumpDialogView.setTaskNode(v8.m().p(), nodeQ);
        multiLogicJumpDialogView.Z(new lt() { // from class: i.b.ka.l1
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.e0(ltVar, node);
            }
        });
    }

    public void T(final Node node, final Node node2, Rect rect, final Runnable runnable) throws JSONException {
        if (this.c.q()) {
            int i2 = node2.nextType;
            if (i2 == 2) {
                try {
                    Node nextNodeAtIndex = node.getNextNodeAtIndex(this.c.l());
                    if (nextNodeAtIndex != null) {
                        this.c.V(nextNodeAtIndex, runnable);
                    } else {
                        com.frame.l1.e(new Runnable() { // from class: i.b.ka.j1
                            @Override // java.lang.Runnable
                            public final void run() throws JSONException {
                                this.c.X();
                            }
                        });
                    }
                    return;
                } catch (Exception e) {
                    com.frame.y0.j("跳转下一个节点失败1");
                    com.frame.y0.l(e);
                    return;
                }
            }
            if (i2 == 13) {
                com.frame.y0.g(" 点击后跳转节点");
                Runnable runnable2 = new Runnable() { // from class: i.b.ka.m1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.Z(node2, runnable);
                    }
                };
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node2.getPoint(), runnable2);
                    return;
                } else {
                    runnable2.run();
                    return;
                }
            }
            if (i2 == 12) {
                com.frame.y0.g(" 点击后跳转任务");
                Runnable runnable3 = new Runnable() { // from class: i.b.ka.k1
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        this.c.b0(node, node2);
                    }
                };
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node2.getPoint(), runnable3);
                    return;
                } else {
                    runnable3.run();
                    return;
                }
            }
            if (i2 == 0) {
                if (rect != null) {
                    f(rect, da.B().M().getClickDuration(), node2.getPoint(), runnable);
                    return;
                } else {
                    this.c.Z(runnable);
                    return;
                }
            }
            if (i2 == 4) {
                E(node, Long.valueOf(node2.nextTaskId), node2.successJumpBack);
                return;
            }
            if (i2 == -3) {
                com.frame.y0.j("跳转终止脚本");
                da.B().h2();
            } else if (i2 == -4) {
                da.B().u(this.c);
            } else if (i2 == 3) {
                this.c.U(node2.nextId, runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0358, code lost:
    
        com.frame.l0.c(r4);
        r7 = r5;
        r12 = r14;
        r15 = 13;
        r14 = r9;
        r9 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0366, code lost:
    
        android.os.SystemClock.sleep(200);
     */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, Runnable runnable) throws Throwable {
        e7 e7Var;
        s7 s7Var;
        Bitmap bitmapW;
        boolean z;
        e7 e7Var2;
        s7 s7Var2;
        boolean z2;
        this.f = 0;
        com.frame.y0.g("分流跳转：" + node.delay);
        this.e = System.currentTimeMillis();
        boolean z3 = true;
        List<Node> list = (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        i9.v().E();
        boolean zD = D(node, list);
        if (zD) {
            i9.v().n();
            for (int i2 = 0; i2 < 10 && !i9.v().B(); i2++) {
                SystemClock.sleep(200L);
            }
        }
        e7 e7Var3 = (e7) z(3);
        s7 s7Var3 = (s7) z(19);
        int i3 = 13;
        i6 i6Var = (i6) z(13);
        int i4 = 4;
        g7 g7Var = (g7) z(4);
        e7Var3.X0(this.e);
        s7Var3.S(this.c);
        i6Var.S(this.c);
        g7Var.S(this.c);
        e7Var3.S(this.c);
        while (true) {
            if (!this.c.q()) {
                break;
            }
            if (this.f > 0) {
                e7Var = e7Var3;
                if (System.currentTimeMillis() - this.e > node.timeOut) {
                    i9.v().h0();
                    com.frame.l1.e(new Runnable() { // from class: i.b.ka.i1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.V(node);
                        }
                    });
                    x7.d().b(node.getErrorDelay());
                    k(node, runnable);
                    break;
                }
            } else {
                e7Var = e7Var3;
            }
            if (zD) {
                s7Var = s7Var3;
                bitmapW = i9.v().w(this.e + node.timeOut, this.f == 0 ? z3 ? 1 : 0 : false);
                if (bitmapW == null && this.f == 0 && i9.v().F()) {
                    return false;
                }
                if (!this.c.q()) {
                    com.frame.l0.c(bitmapW);
                    return false;
                }
                if (bitmapW == null) {
                    Log.e("", "bitmap == null");
                    try {
                        Thread.sleep(s());
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                    e7Var3 = e7Var;
                    s7Var3 = s7Var;
                }
            } else {
                s7Var = s7Var3;
                bitmapW = null;
            }
            this.f += z3 ? 1 : 0;
            Iterator<Node> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = z3;
                    e7Var2 = e7Var;
                    s7Var2 = s7Var;
                    break;
                }
                Node next = it.next();
                int i5 = next.type;
                if (i4 == i5) {
                    g7Var.W(next);
                    List<AccessibilityNodeInfo> listD0 = g7Var.d0(next, next.url);
                    if (listD0 != null && !listD0.isEmpty()) {
                        com.frame.y0.n("「" + node.getStepAndName() + "：" + next.getStepAndName() + "」找到控件，耗时：" + (System.currentTimeMillis() - this.e));
                        x7.d().b(node.getNextDelay());
                        node.setPointNew(next.getPoint());
                        Rect rect = new Rect();
                        listD0.get(0).getBoundsInScreen(rect);
                        T(node, next, rect, runnable);
                        return z3;
                    }
                    z2 = z3;
                    e7Var2 = e7Var;
                    s7Var2 = s7Var;
                } else {
                    if (19 == i5) {
                        s7Var2 = s7Var;
                        s7Var2.W(next);
                        List<AccessibilityNodeInfo> listD02 = s7Var2.d0(next, next.url);
                        if (listD02 != null && !listD02.isEmpty()) {
                            com.frame.y0.n("「" + node.getStepAndName() + "：" + next.getStepAndName() + "」找到控件，耗时：" + (System.currentTimeMillis() - this.e));
                            x7.d().b(node.getNextDelay());
                            node.setPointNew(next.getPoint());
                            Rect rect2 = new Rect();
                            listD02.get(0).getBoundsInScreen(rect2);
                            T(node, next, rect2, runnable);
                            return z3;
                        }
                    } else {
                        s7Var2 = s7Var;
                        if (3 == i5 || 22 == i5) {
                            e7Var2 = e7Var;
                            Bitmap[] bitmapArrX = e7Var2.X(next.url, e7Var2.d0(next), next.argInt1);
                            Rect areaOrParam = next.getAreaOrParam();
                            if (next.hasAreaResolveError()) {
                                k(node, runnable);
                                com.frame.l0.c(bitmapW);
                                return false;
                            }
                            Mat matE0 = e7Var2.e0(bitmapW, next, areaOrParam);
                            if (matE0 == null) {
                                z = true;
                                break;
                            }
                            Rect rectV0 = e7Var2.V0(next, matE0, areaOrParam, bitmapArrX);
                            if (rectV0 != null) {
                                com.frame.y0.n("「" + node.getStepAndName() + "：" + next.getStepAndName() + "」找到图片，耗时：" + (System.currentTimeMillis() - this.e));
                                x7.d().b(node.getNextDelay());
                                node.setPointNew(next.getPoint());
                                i9.v().h0();
                                com.frame.l0.c(bitmapW);
                                matE0.h();
                                T(node, next, rectV0, runnable);
                                return true;
                            }
                            z2 = true;
                            matE0.h();
                        } else if (i3 == i5) {
                            Point pointV = i6Var.V(bitmapW, next);
                            if (pointV != null) {
                                com.frame.y0.n("「" + node.getStepAndName() + "：" + next.getStepAndName() + "」找到颜色，耗时：" + (System.currentTimeMillis() - this.e));
                                x7.d().b(node.getNextDelay());
                                i9.v().h0();
                                com.frame.l0.c(bitmapW);
                                int i6 = pointV.x;
                                int i7 = pointV.y;
                                Rect rect3 = new Rect(i6 + (-10), i7 + (-10), i6 + 10, i7 + 10);
                                node.setPointNew(next.getPoint());
                                T(node, next, rect3, runnable);
                                return z3;
                            }
                        } else if (24 == i5 && ((a7) z(24)).n0(next)) {
                            T(node, next, null, runnable);
                            return z3;
                        }
                    }
                    z2 = z3;
                    e7Var2 = e7Var;
                }
                z3 = z2;
                s7Var = s7Var2;
                e7Var = e7Var2;
                i4 = 4;
                i3 = 13;
            }
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.X;
    }

    @Override // i.b.ka.x5
    public long s() {
        long j2 = da.B().M().imgScanDelay;
        if (j2 < 10) {
            return 10L;
        }
        return j2;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "分流跳转";
    }
}
