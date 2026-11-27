package i.b.ka;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.google.gson.Gson;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.MultiGestureRecordFloatView;
import com.v.MultiLogicDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.i9;
import i.b.t9;
import i.b.v8;
import i.b.x7;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.opencv.core.Mat;

/* loaded from: classes.dex */
public class v6 extends x5 {
    private long e;
    private final HashSet<Rect> f = new HashSet<>();
    private int g = 0;

    private Bitmap[] A(IdentityHashMap<Node, Bitmap[]> identityHashMap, e7 e7Var, Node node) {
        Bitmap[] bitmapArr = identityHashMap.get(node);
        if (bitmapArr != null || identityHashMap.containsKey(node)) {
            return bitmapArr;
        }
        Bitmap[] bitmapArrX = e7Var.X(node.url, e7Var.d0(node), node.argInt1);
        identityHashMap.put(node, bitmapArrX);
        return bitmapArrX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(Node node) {
        FloatToast.g(j.b.d.g0, O(node, this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(Node node) throws JSONException {
        E(node, Long.valueOf(node.nextTaskId), node.successJumpBack);
    }

    static /* synthetic */ void b0(Node node) {
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.r1
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(FloatHandlerRecord.class);
            }
        });
        MultiGestureRecordFloatView.c(node.getDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(lt ltVar, final Node node) {
        if (v8.m().p() != null && D(node, (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e()))) {
            v8.m().p().setNeedScan(true);
        }
        v8.m().X(node);
        com.frame.l1.e(s5.c);
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.s1
            @Override // java.lang.Runnable
            public final void run() {
                Node node2 = node;
                new t9(v8.m().p()).t(node2, new Runnable() { // from class: i.b.ka.t1
                    @Override // java.lang.Runnable
                    public final void run() {
                        v6.b0(node2);
                    }
                });
            }
        });
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 23;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        MultiLogicDialogView multiLogicDialogView = (MultiLogicDialogView) com.frame.s0.g().B(MultiLogicDialogView.class);
        multiLogicDialogView.setTaskNode(task, node);
        multiLogicDialogView.W(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.what = 1;
        nodeQ.type = 23;
        nodeQ.timeOut = 5000L;
        nodeQ.nextType = 0;
        nodeQ.errorType = 2;
        nodeQ.delay = "500";
        MultiLogicDialogView multiLogicDialogView = (MultiLogicDialogView) com.frame.s0.g().B(MultiLogicDialogView.class);
        multiLogicDialogView.setTaskNode(v8.m().p(), nodeQ);
        multiLogicDialogView.W(new lt() { // from class: i.b.ka.u1
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.e0(ltVar, node);
            }
        });
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void V(final Node node, final Runnable runnable) throws JSONException {
        HashSet<Rect> hashSet = this.f;
        if (hashSet == null || !hashSet.iterator().hasNext()) {
            this.c.W(runnable);
            return;
        }
        Rect next = this.f.iterator().next();
        this.f.remove(next);
        l(node, next, new Runnable() { // from class: i.b.ka.o1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.V(node, runnable);
            }
        });
    }

    public String f0(x5 x5Var, Node node, Node node2, long j2) {
        String str = t() + ParameterizedMessage.ERROR_MSG_SEPARATOR + x5Var.t() + "「" + node.getStepAndName() + "：" + node2.getStepAndName() + "」成功耗时:" + (System.currentTimeMillis() - j2) + "毫秒，执行操作：" + w(node.nextType);
        com.frame.y0.n(str);
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(3:223|13|(2:15|(1:230))(1:18))|(4:20|(1:22)(1:23)|24|(6:32|(4:233|34|35|36)(1:(7:235|38|221|39|43|247|245)(2:234|44))|212|213|214|215)(3:232|30|31))(2:231|45)|220|46|(5:48|(3:51|(2:250|53)(5:54|(2:56|(4:236|58|59|60)(1:61))(2:63|(3:65|66|(4:237|68|69|70))(2:71|(2:90|(4:240|92|93|94)(2:95|(2:248|97)(3:225|98|(5:241|100|101|102|103)(1:104))))(2:76|(2:78|(4:238|80|81|82))(2:83|(2:253|105)(4:239|87|88|89)))))|62|251|105)|49)|249|109|(4:242|111|112|113)(1:114))(7:115|(6:117|(3:120|(2:260|122)(2:123|(2:125|(2:261|127)(3:128|129|(2:263|169)(4:243|166|167|168)))(2:130|(2:132|(3:254|134|127)(4:135|129|(1:263)(1:262)|169))(2:136|(3:152|(3:218|158|(2:258|160)(5:162|163|129|(0)(0)|169))(0)|127)(2:141|(2:143|(3:255|145|127)(4:146|129|(0)(0)|169))(4:147|(1:151)|(0)(0)|169)))))|118)|259|173|174|(7:244|176|(1:180)|181|(2:183|(1:198)(2:188|(1:197)(1:196)))|199|200))|202|203|204|246|245)|201|202|203|204|246|245) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c7, code lost:
    
        i.b.i9.v().h0();
        com.frame.l1.e(new i.b.ka.q1(r21, r23));
        i.b.x7.d().b(r23.getErrorDelay());
        k(r23, r24);
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0488, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0489, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0490, code lost:
    
        com.frame.l0.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0494, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03e3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, Runnable runnable) throws Throwable {
        Bitmap bitmap;
        s7 s7Var;
        g7 g7Var;
        Bitmap bitmap2;
        s7 s7Var2;
        g7 g7Var2;
        List<Node> list;
        Mat matE0;
        boolean z = false;
        this.g = 0;
        com.frame.y0.g("逻辑判断：" + node.delay);
        this.e = System.currentTimeMillis();
        List<Node> list2 = (List) new Gson().k(node.arg1, com.google.gson.k0.a.c(List.class, Node.class).e());
        boolean zD = D(node, list2);
        if (zD) {
            i9.v().n();
            for (int i2 = 0; i2 < 10 && !i9.v().B(); i2++) {
                SystemClock.sleep(200L);
            }
        }
        e7 e7Var = (e7) z(3);
        s7 s7Var3 = (s7) z(19);
        i6 i6Var = (i6) z(13);
        g7 g7Var3 = (g7) z(4);
        e7Var.X0(this.e);
        s7Var3.S(this.c);
        i6Var.S(this.c);
        g7Var3.S(this.c);
        e7Var.S(this.c);
        IdentityHashMap<Node, Bitmap[]> identityHashMap = new IdentityHashMap<>();
        Bitmap bitmapW = null;
        while (true) {
            try {
            } catch (Throwable th) {
                th = th;
                bitmap = bitmapW;
            }
            if (!this.c.q()) {
                Bitmap bitmap3 = bitmapW;
                break;
            }
            try {
                if (this.g > 0) {
                    s7Var = s7Var3;
                    if (System.currentTimeMillis() - this.e > node.timeOut) {
                        break;
                    }
                } else {
                    s7Var = s7Var3;
                }
            } catch (Throwable th2) {
                th = th2;
                bitmap = null;
            }
            if (zD) {
                g7Var = g7Var3;
                bitmapW = i9.v().w(this.e + node.timeOut, this.g == 0 ? true : z);
                if (bitmapW == null && this.g == 0 && i9.v().F()) {
                    com.frame.l0.c(bitmapW);
                    return z;
                }
                if (!this.c.q()) {
                    com.frame.l0.c(bitmapW);
                    com.frame.l0.c(bitmapW);
                    return z;
                }
                if (bitmapW == null) {
                    Log.e("", "bitmap == null");
                    try {
                        Thread.sleep(s());
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                    s7Var3 = s7Var;
                    g7Var3 = g7Var;
                } else {
                    bitmap2 = bitmapW;
                }
                th = th;
                bitmap = bitmapW;
                com.frame.l0.c(bitmap);
                throw th;
            }
            g7Var = g7Var3;
            bitmap2 = null;
            this.g++;
            int i3 = node.what;
            if (i3 == 1) {
                boolean z2 = z;
                for (Node node2 : list2) {
                    if (!this.c.q()) {
                        break;
                    }
                    int i4 = node2.type;
                    if (4 == i4) {
                        g7Var2 = g7Var;
                        g7Var2.W(node2);
                        List<AccessibilityNodeInfo> listD0 = g7Var2.d0(node2, node2.url);
                        if (listD0 != null) {
                            f0(g7Var2, node, node2, this.e);
                            x7.d().b(node.getNextDelay());
                            node.setPointNew(node2.getPoint());
                            n(node, listD0, runnable);
                            com.frame.l0.c(bitmap2);
                            return true;
                        }
                        s7Var2 = s7Var;
                    } else {
                        g7Var2 = g7Var;
                        if (19 == i4) {
                            s7Var2 = s7Var;
                            s7Var2.W(node2);
                            List<AccessibilityNodeInfo> listD02 = s7Var2.d0(node2, node2.url);
                            if (listD02 != null) {
                                f0(s7Var2, node, node2, this.e);
                                x7.d().b(node.getNextDelay());
                                node.setPointNew(node2.getPoint());
                                n(node, listD02, runnable);
                                com.frame.l0.c(bitmap2);
                                return true;
                            }
                        } else {
                            s7Var2 = s7Var;
                            if (3 == i4 || 22 == i4) {
                                Bitmap[] bitmapArrA = A(identityHashMap, e7Var, node2);
                                Rect areaOrParam = node2.getAreaOrParam();
                                if (node2.hasAreaResolveError()) {
                                    k(node, runnable);
                                    com.frame.l0.c(bitmap2);
                                    return false;
                                }
                                matE0 = e7Var.e0(bitmap2, node2, areaOrParam);
                                if (matE0 == null) {
                                    z2 = true;
                                    break;
                                }
                                try {
                                    Rect rectV0 = e7Var.V0(node2, matE0, areaOrParam, bitmapArrA);
                                    if (rectV0 != null) {
                                        f0(e7Var, node, node2, this.e);
                                        x7.d().b(node.getNextDelay());
                                        node.setPointNew(node2.getPoint());
                                        i9.v().h0();
                                        l(node, rectV0, runnable);
                                        com.frame.l0.c(bitmap2);
                                        return true;
                                    }
                                    matE0.h();
                                } finally {
                                }
                            } else if (13 == i4) {
                                Point pointV = i6Var.V(bitmap2, node2);
                                if (pointV != null) {
                                    f0(i6Var, node, node2, this.e);
                                    x7.d().b(node.getNextDelay());
                                    i9.v().h0();
                                    com.frame.l0.c(bitmap2);
                                    int i5 = pointV.x;
                                    int i6 = pointV.y;
                                    Rect rect = new Rect(i5 - 10, i6 - 10, i5 + 10, i6 + 10);
                                    node.setPointNew(node2.getPoint());
                                    l(node, rect, runnable);
                                    com.frame.l0.c(bitmap2);
                                    return true;
                                }
                            } else {
                                if (24 == i4 && ((a7) z(24)).n0(node2)) {
                                    f0(i6Var, node, node2, this.e);
                                    m(node, runnable);
                                    com.frame.l0.c(bitmap2);
                                    return true;
                                }
                                g7Var = g7Var2;
                                s7Var = s7Var2;
                            }
                        }
                    }
                    z2 = true;
                    g7Var = g7Var2;
                    s7Var = s7Var2;
                }
                s7Var2 = s7Var;
                g7Var2 = g7Var;
                if (!z2) {
                    com.frame.l0.c(bitmap2);
                    k(node, runnable);
                    com.frame.l0.c(bitmap2);
                    return false;
                }
                com.frame.l0.c(bitmap2);
            } else {
                s7Var2 = s7Var;
                g7Var2 = g7Var;
                if (i3 == 2) {
                    this.f.clear();
                    boolean z3 = false;
                    boolean z4 = true;
                    for (Node node3 : list2) {
                        if (!this.c.q()) {
                            break;
                        }
                        int i7 = node3.type;
                        list = list2;
                        if (4 == i7) {
                            g7Var2.W(node3);
                            List<AccessibilityNodeInfo> listD03 = g7Var2.d0(node3, node3.url);
                            if (listD03 == null) {
                                z4 = false;
                                break;
                            }
                            node.setPointNew(node3.getPoint());
                            Rect rect2 = new Rect();
                            listD03.get(0).getBoundsInScreen(rect2);
                            this.f.add(rect2);
                            z3 = true;
                            if (!z3 && !z4) {
                                k(node, runnable);
                                com.frame.l0.c(bitmap2);
                                com.frame.l0.c(bitmap2);
                                return false;
                            }
                            list2 = list;
                        } else if (19 == i7) {
                            s7Var2.W(node3);
                            List<AccessibilityNodeInfo> listD04 = s7Var2.d0(node3, node3.url);
                            if (listD04 == null) {
                                z4 = false;
                                break;
                            }
                            node.setPointNew(node3.getPoint());
                            Rect rect3 = new Rect();
                            listD04.get(0).getBoundsInScreen(rect3);
                            this.f.add(rect3);
                            z3 = true;
                            if (!z3) {
                            }
                            list2 = list;
                        } else {
                            if (3 == i7 || 22 == i7) {
                                Bitmap[] bitmapArrA2 = A(identityHashMap, e7Var, node3);
                                Rect areaOrParam2 = node3.getAreaOrParam();
                                if (!node3.hasAreaResolveError() && (matE0 = e7Var.e0(bitmap2, node3, areaOrParam2)) != null) {
                                    try {
                                        Rect rectV02 = e7Var.V0(node3, matE0, areaOrParam2, bitmapArrA2);
                                        if (rectV02 != null) {
                                            node.setPointNew(node3.getPoint());
                                            this.f.add(new Rect(rectV02));
                                            matE0.h();
                                            z3 = true;
                                            if (!z3) {
                                            }
                                            list2 = list;
                                        }
                                    } finally {
                                    }
                                }
                                z4 = false;
                                break;
                            }
                            if (13 == i7) {
                                Point pointV2 = i6Var.V(bitmap2, node3);
                                if (pointV2 == null) {
                                    z4 = false;
                                    break;
                                }
                                node.setPointNew(node3.getPoint());
                                int i8 = pointV2.x;
                                int i9 = pointV2.y;
                                this.f.add(new Rect(i8, i9, i8, i9));
                                z3 = true;
                                if (!z3) {
                                }
                                list2 = list;
                            } else {
                                if (24 == i7 && !((a7) z(24)).n0(node3)) {
                                    z4 = false;
                                }
                                if (!z3) {
                                }
                                list2 = list;
                            }
                        }
                    }
                    list = list2;
                    com.frame.l0.c(bitmap2);
                    if (z4) {
                        com.frame.y0.n("「" + node.getStepAndName() + "」逻辑判断（成功），耗时：" + (System.currentTimeMillis() - this.e));
                        if (zD && i9.J()) {
                            i9.v().h0();
                        }
                        x7.d().b(node.getNextDelay());
                        if (this.c.q()) {
                            int i10 = node.nextType;
                            if (i10 == 12 || i10 == 13) {
                                U(node, new Runnable() { // from class: i.b.ka.p1
                                    @Override // java.lang.Runnable
                                    public final void run() throws JSONException {
                                        this.c.Z(node);
                                    }
                                });
                            } else if (i10 == 11 || i10 == 0 || i10 == 5 || i10 == 10) {
                                U(node, runnable);
                            } else {
                                N(node, this.e);
                                m(node, runnable);
                            }
                        }
                        com.frame.l0.c(bitmap2);
                        return true;
                    }
                }
                SystemClock.sleep(200L);
                bitmapW = bitmap2;
                s7Var3 = s7Var2;
                g7Var3 = g7Var2;
                list2 = list;
                z = false;
            }
            list = list2;
            SystemClock.sleep(200L);
            bitmapW = bitmap2;
            s7Var3 = s7Var2;
            g7Var3 = g7Var2;
            list2 = list;
            z = false;
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.U;
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
        return "逻辑判断";
    }
}
