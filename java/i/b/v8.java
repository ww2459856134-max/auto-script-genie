package i.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.Gson;
import com.s.BoxService;
import com.user.AccountTool;
import com.v.FloatToast;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.WidgetFeature;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class v8 {
    private static ArrayList<Node> f;
    private static v8 g;
    public long a;
    public Node b;
    private Task c;
    private Node d;
    boolean e;

    private v8() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        MultiGestureRecordFloatView.c(this.b.getDelay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Node node) {
        new t9(this.c).s(node, new Runnable() { // from class: i.b.l2
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(MultiGestureRecordFloatView.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Node node) {
        new t9(this.c).s(node, new Runnable() { // from class: i.b.q2
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(MultiGestureRecordFloatView.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Node node, Runnable runnable) {
        new t9(this.c).s(node, runnable);
    }

    public static synchronized v8 m() {
        v8 v8Var;
        v8Var = g;
        if (v8Var == null) {
            v8Var = new v8();
            g = v8Var;
        }
        return v8Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        this.c.setCreateUserId(AccountTool.d().g());
        if (!da.B().O() || com.frame.w0.d()) {
            for (int i2 = 0; i2 < 5; i2++) {
                AccessibilityNodeInfo accessibilityNodeInfoU = com.frame.g0.v().u(null, BoxService.m());
                if (accessibilityNodeInfoU != null && accessibilityNodeInfoU.getPackageName() != null) {
                    this.c.setPn(accessibilityNodeInfoU.getPackageName().toString());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Node node) throws JSONException {
        SystemClock.sleep(80L);
        i.b.ka.x5 x5VarE = x7.d().e(3);
        x5VarE.S(new t9(m().p()));
        x5VarE.l(node, node.getSrcRect(), new Runnable() { // from class: i.b.j2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(final Node node) {
        com.frame.l1.g(new Runnable() { // from class: i.b.o2
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                this.c.v(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(final Node node) {
        MultiGestureRecordFloatView.F(new Runnable() { // from class: i.b.n2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x(node);
            }
        });
    }

    public void K(Node node, Node node2) {
        node.nextId = node2.id;
        node2.frontId = node.id;
    }

    public Node L() {
        Node node = this.b;
        long j2 = node == null ? 0L : node.duration;
        Node node2 = new Node();
        this.b = node2;
        node2.id = System.currentTimeMillis();
        this.b.step = String.valueOf(this.c.getNodeMap().size() + 1);
        Node node3 = this.b;
        node3.duration = 100L;
        node3.type = 6;
        node3.nextType = 2;
        node3.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        new t9(this.c).s(this.b, null);
        a(this.b);
        this.a = System.currentTimeMillis();
        return this.b;
    }

    public Node M() {
        Node node = this.b;
        long j2 = node == null ? 0L : node.duration;
        Node node2 = new Node();
        this.b = node2;
        node2.step = String.valueOf(this.c.getNodeMap().size() + 1);
        this.b.id = System.currentTimeMillis();
        Node node3 = this.b;
        node3.duration = 500L;
        node3.type = 5;
        node3.nextType = 2;
        node3.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        this.a = System.currentTimeMillis();
        new t9(this.c).s(this.b, null);
        a(this.b);
        return this.b;
    }

    public Node N() {
        Node node = this.b;
        long j2 = node == null ? 0L : node.duration;
        Node node2 = new Node();
        this.b = node2;
        node2.id = System.currentTimeMillis();
        this.b.step = String.valueOf(this.c.getNodeMap().size() + 1);
        Node node3 = this.b;
        node3.duration = 100L;
        node3.nextType = 2;
        node3.type = 7;
        node3.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        new t9(this.c).s(this.b, null);
        this.a = System.currentTimeMillis();
        a(this.b);
        return this.b;
    }

    public Node O(String str) {
        Q();
        Node node = this.b;
        node.delay = "200";
        node.duration = 300L;
        node.nextType = 2;
        node.url = str;
        node.type = 30;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        MultiGestureRecordFloatView.G(node2, node2.getDelay());
        return this.b;
    }

    public void P(Node node) {
        node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        this.b = node;
        this.a = System.currentTimeMillis();
        a(node);
        MultiGestureRecordFloatView.G(node, node.getDelay());
    }

    public Node Q() {
        Node node = this.b;
        long j2 = node == null ? 0L : node.duration;
        this.b = new Node();
        Task task = this.c;
        if (task != null && task.getNodeMap() != null) {
            this.b.step = String.valueOf(this.c.getNodeMap().size() + 1);
        }
        this.b.id = System.currentTimeMillis();
        Node node2 = this.b;
        node2.nextType = 2;
        node2.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        return this.b;
    }

    public Node R(final Node node) {
        this.b = node;
        Task task = this.c;
        if (task != null) {
            node.step = String.valueOf(task.getNodeMap().size() + 1);
            this.c.setNeedScan(true);
        }
        this.a = System.currentTimeMillis();
        a(this.b);
        com.frame.l1.e(new Runnable() { // from class: i.b.k2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z(node);
            }
        });
        return this.b;
    }

    public void S(Node node) {
        node.duration = 1L;
        node.delay = "100";
        node.type = 15;
        this.b = node;
        this.a = System.currentTimeMillis();
        a(node);
    }

    public Node T(String str) {
        Q();
        Node node = this.b;
        node.delay = "200";
        node.duration = 300L;
        node.nextType = 2;
        node.url = str;
        node.type = 40;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        MultiGestureRecordFloatView.G(node2, node2.getDelay());
        return this.b;
    }

    public Node U() {
        Q();
        this.b.type = 9;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node = this.b;
        MultiGestureRecordFloatView.G(node, node.getDelay());
        return this.b;
    }

    public Node V(final Node node) {
        this.b = node;
        if (node != null) {
            long j2 = node.duration;
        }
        node.type = 11;
        MultiGestureRecordFloatView.G(node, node.duration);
        a(this.b);
        this.a = System.currentTimeMillis() - this.b.duration;
        com.frame.l1.e(w6.c);
        com.frame.l1.g(new Runnable() { // from class: i.b.p2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.E(node);
            }
        });
        return this.b;
    }

    public void W(Node node, String str) {
        this.b = node;
        node.delay = "500";
        node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        this.c.setNeedScan(true);
        Node node2 = this.b;
        node2.duration = 50L;
        node2.url = str;
        node2.type = 22;
        this.a = System.currentTimeMillis();
        a(this.b);
        MultiGestureRecordFloatView.G(node, node.getDelay());
    }

    public void X(Node node) {
        this.b = node;
        if (node.step == null) {
            node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        }
        this.a = System.currentTimeMillis();
        a(this.b);
    }

    public Node Y() {
        Node node = this.b;
        long j2 = node == null ? 0L : node.duration;
        Node node2 = new Node();
        this.b = node2;
        node2.id = System.currentTimeMillis();
        this.b.step = String.valueOf(this.c.getNodeMap().size() + 1);
        Node node3 = this.b;
        node3.duration = 100L;
        node3.type = 29;
        node3.nextType = 2;
        node3.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        new t9(this.c).s(this.b, null);
        a(this.b);
        this.a = System.currentTimeMillis();
        return this.b;
    }

    public Node Z(Node node) {
        this.b = node;
        long j2 = node == null ? 0L : node.duration;
        node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        Node node2 = this.b;
        node2.duration = 400L;
        node2.type = 16;
        node2.delay = String.valueOf((System.currentTimeMillis() - this.a) - j2);
        new t9(this.c).s(this.b, null);
        a(this.b);
        this.a = System.currentTimeMillis();
        return this.b;
    }

    public void a(Node node) {
        if (this.c.getNodeMap().containsKey(Long.valueOf(node.id))) {
            return;
        }
        if (this.e) {
            b(node);
            this.e = false;
        } else {
            q(this.c, this.d, node);
            this.d = node;
        }
    }

    public Node a0(Node node) {
        this.b = node;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        node2.duration = 10L;
        node2.delay = "5";
        MultiGestureRecordFloatView.G(node, node.getDelay());
        Task task = this.c;
        if (task.params == null) {
            task.params = new HashSet();
        }
        this.c.params.add(node.text);
        return this.b;
    }

    public void b(Node node) {
        Node node2 = this.d;
        if (node2 != null) {
            if (node2.errorType == 6 && node2.errorId != 0 && this.c.getNodeMap().containsKey(Long.valueOf(this.d.errorId))) {
                node.nextId = this.d.errorId;
                Node node3 = this.c.getNodeMap().get(Long.valueOf(this.d.errorId));
                if (node3 != null) {
                    node3.frontId = node.id;
                }
            }
            Node node4 = this.d;
            node4.errorId = node.id;
            node4.errorType = 6;
            node.frontId = node4.id;
        } else {
            this.c.setFirstNodeId(node.id);
        }
        this.c.getNodeMap().put(Long.valueOf(node.id), node);
        this.d = node;
    }

    public Node b0(int i2, Rect rect, String str) {
        Q();
        this.c.setNeedScan(true);
        this.b.setAreaNew(rect);
        Node node = this.b;
        node.areaParam = str;
        node.what = i2;
        node.type = 12;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        MultiGestureRecordFloatView.G(node2, node2.getDelay());
        return this.b;
    }

    public void c(Node node) {
        if (f == null) {
            f = new ArrayList<>();
        }
        f.add(node);
    }

    public void c0(final Node node) {
        node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        this.b = node;
        this.a = System.currentTimeMillis();
        a(node);
        com.frame.l1.g(new Runnable() { // from class: i.b.r2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.H(node);
            }
        });
    }

    public void d(Task task, Node node, lt ltVar) {
        x7.d().e(node.type).P(0, task, node, ltVar);
    }

    public Node d0(String str) {
        Q();
        Node node = this.b;
        node.delay = "200";
        node.duration = 300L;
        node.nextType = 2;
        node.url = str;
        node.type = 8;
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        MultiGestureRecordFloatView.G(node2, node2.getDelay());
        return this.b;
    }

    public Node e(int i2, int i3, int i4) {
        Node node = new Node();
        this.b = node;
        node.type = 13;
        node.step = String.valueOf(this.c.getNodeMap().size() + 1);
        this.b.id = System.currentTimeMillis();
        Node node2 = this.b;
        node2.delay = "500";
        node2.arg1 = com.frame.q1.b(i4).replace("#", "");
        Node node3 = this.b;
        node3.timeOut = 5000L;
        node3.pathPoints = new ArrayList<>();
        this.b.pathPoints.add(Integer.valueOf(i2));
        this.b.pathPoints.add(Integer.valueOf(i3));
        Node node4 = this.b;
        node4.errorType = 2;
        node4.nextType = 0;
        this.a = System.currentTimeMillis();
        return this.b;
    }

    public Node e0(Node node) {
        this.a = System.currentTimeMillis();
        a(this.b);
        Node node2 = this.b;
        MultiGestureRecordFloatView.G(node2, node2.getDelay());
        return this.b;
    }

    public Node f(Node node, Bitmap bitmap) {
        File file = new File(da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        com.frame.l0.d(bitmap, file);
        com.frame.l0.c(bitmap);
        g(node, file);
        return node;
    }

    public Node f0(Node node) {
        node.duration = 50L;
        node.delay = "500";
        node.type = 4;
        this.b = node;
        this.a = System.currentTimeMillis();
        a(node);
        MultiGestureRecordFloatView.G(node, node.getDelay());
        return node;
    }

    public Node g(Node node, File file) {
        node.id = System.currentTimeMillis();
        node.delay = "50";
        node.duration = 50L;
        node.url = file.getAbsolutePath();
        node.type = 3;
        return node;
    }

    public Node g0(final Node node, final Runnable runnable) {
        node.duration = 50L;
        node.delay = "500";
        node.type = 19;
        this.b = node;
        this.a = System.currentTimeMillis();
        a(node);
        com.frame.l1.e(w6.c);
        this.a = System.currentTimeMillis();
        MultiGestureRecordFloatView.c(500L);
        com.frame.l1.g(new Runnable() { // from class: i.b.m2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.J(node, runnable);
            }
        });
        return node;
    }

    public Node h(Rect rect) {
        Node nodeQ = Q();
        nodeQ.delay = "500";
        nodeQ.setSrcRectNew(rect);
        nodeQ.setAreaNew(rect);
        nodeQ.nextType = 0;
        nodeQ.errorType = 2;
        nodeQ.timeOut = da.B().M().imgDefaultTimeout;
        nodeQ.what = 80;
        nodeQ.duration = 10L;
        nodeQ.type = 3;
        return nodeQ;
    }

    public void h0(Task task, Node node) {
        Node node2 = task.getNodeMap().get(Long.valueOf(node.frontId));
        Node node3 = task.getNodeMap().get(Long.valueOf(node.nextId));
        if (node2 != null && node3 != null) {
            node2.nextId = node3.id;
            node3.frontId = node2.id;
        } else if (node2 != null) {
            node2.nextId = 0L;
        } else if (node3 != null) {
            node3.frontId = 0L;
            if (task.getFirstNodeId() == node.id) {
                task.setFirstNodeId(node3.id);
            }
        }
        task.getNodeMap().remove(Long.valueOf(node.id));
    }

    public Node i(Rect rect) {
        Node nodeQ = Q();
        nodeQ.delay = "500";
        nodeQ.setSrcRectNew(rect);
        nodeQ.what = 125;
        nodeQ.setAreaNew(rect);
        nodeQ.nextType = 2;
        nodeQ.errorType = 2;
        nodeQ.timeOut = 5000L;
        nodeQ.duration = 10L;
        nodeQ.type = 31;
        nodeQ.arg4 = "chi_sim.traineddata";
        nodeQ.arg5 = "chi_sim";
        return nodeQ;
    }

    public void i0(Node node, int i2, AccessibilityNodeInfo accessibilityNodeInfo) {
        node.whatIndex = i2;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getPackageName() == null) {
            return;
        }
        node.url = accessibilityNodeInfo.getPackageName().toString();
        node.arg5 = accessibilityNodeInfo.getViewIdResourceName();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Node j(boolean z, String str, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, Collection<AccessibilityNodeInfo> collection) {
        boolean z2;
        Iterator<AccessibilityNodeInfo> it;
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId;
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        CharSequence className = accessibilityNodeInfo.getClassName();
        CharSequence text = accessibilityNodeInfo.getText();
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        Node nodeQ = m().Q();
        nodeQ.timeOut = 5000L;
        nodeQ.nextType = 7;
        nodeQ.errorType = 2;
        nodeQ.type = 19;
        nodeQ.url = accessibilityNodeInfo2.getPackageName().toString();
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        nodeQ.setSrcRectNew(rect);
        WidgetFeature widgetFeature = new WidgetFeature();
        if (!TextUtils.isEmpty(viewIdResourceName)) {
            List<AccessibilityNodeInfo> listO = o(collection, viewIdResourceName);
            try {
                listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo2.findAccessibilityNodeInfosByViewId(viewIdResourceName);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            if (listFindAccessibilityNodeInfosByViewId != null) {
                if (!listFindAccessibilityNodeInfosByViewId.isEmpty()) {
                    z2 = false;
                }
                if (listO.size() != 1) {
                    widgetFeature.id = viewIdResourceName;
                    widgetFeature.idToggle = true;
                    widgetFeature.className = String.valueOf(className);
                    widgetFeature.classToggle = false;
                    widgetFeature.textToggle = z && !TextUtils.isEmpty(text);
                    widgetFeature.text = String.valueOf(text);
                    widgetFeature.textType = 1;
                    widgetFeature.desc = String.valueOf(contentDescription);
                    widgetFeature.descToggle = false;
                    widgetFeature.descType = 1;
                    widgetFeature.path = str;
                    widgetFeature.pathToggle = false;
                } else {
                    Iterator<AccessibilityNodeInfo> it2 = listO.iterator();
                    boolean z3 = true;
                    boolean z4 = true;
                    boolean z5 = true;
                    while (it2.hasNext()) {
                        AccessibilityNodeInfo next = it2.next();
                        if (accessibilityNodeInfo != next) {
                            it = it2;
                            if (TextUtils.isEmpty(className) || className.equals(next.getClassName())) {
                                z4 = false;
                            }
                        } else {
                            it = it2;
                        }
                        if (accessibilityNodeInfo != next && (TextUtils.isEmpty(contentDescription) || contentDescription.equals(next.getContentDescription()))) {
                            z3 = false;
                        }
                        if (accessibilityNodeInfo != next && (TextUtils.isEmpty(text) || text.equals(next.getText()))) {
                            z5 = false;
                        }
                        it2 = it;
                    }
                    widgetFeature.id = viewIdResourceName;
                    widgetFeature.idToggle = true;
                    widgetFeature.classToggle = z4;
                    widgetFeature.className = String.valueOf(className);
                    widgetFeature.textToggle = z5;
                    widgetFeature.text = String.valueOf(text);
                    widgetFeature.textType = 1;
                    widgetFeature.descToggle = z3;
                    widgetFeature.desc = String.valueOf(contentDescription);
                    widgetFeature.descType = 1;
                    widgetFeature.path = str;
                    widgetFeature.pathToggle = false;
                    nodeQ.arg1 = new Gson().s(widgetFeature);
                    if (!z4 && !z3 && !z5) {
                        nodeQ.what = -1;
                    }
                }
                nodeQ.arg2 = !r(accessibilityNodeInfo) ? "1" : "0";
                nodeQ.arg3 = z2 ? "1" : "0";
            }
            z2 = true;
            if (listO.size() != 1) {
            }
            nodeQ.arg2 = !r(accessibilityNodeInfo) ? "1" : "0";
            nodeQ.arg3 = z2 ? "1" : "0";
        } else if (TextUtils.isEmpty(text)) {
            widgetFeature.id = viewIdResourceName;
            widgetFeature.idToggle = false;
            widgetFeature.className = String.valueOf(className);
            widgetFeature.classToggle = false;
            widgetFeature.text = String.valueOf(text);
            widgetFeature.textToggle = false;
            widgetFeature.textType = 1;
            widgetFeature.desc = String.valueOf(contentDescription);
            widgetFeature.descToggle = false;
            widgetFeature.descType = 1;
            widgetFeature.path = str;
            widgetFeature.pathToggle = true;
            nodeQ.arg1 = new Gson().s(widgetFeature);
        } else {
            widgetFeature.id = viewIdResourceName;
            widgetFeature.idToggle = false;
            widgetFeature.classToggle = !TextUtils.isEmpty(className);
            widgetFeature.className = String.valueOf(className);
            widgetFeature.text = String.valueOf(text);
            widgetFeature.textToggle = true;
            widgetFeature.textType = 1;
            widgetFeature.descToggle = !TextUtils.isEmpty(contentDescription);
            widgetFeature.desc = String.valueOf(contentDescription);
            widgetFeature.descType = 1;
            widgetFeature.path = str;
            widgetFeature.pathToggle = false;
            nodeQ.arg1 = new Gson().s(widgetFeature);
        }
        widgetFeature.height = rect.height() + "";
        widgetFeature.heightType = 1;
        widgetFeature.heightToggle = false;
        widgetFeature.width = rect.width() + "";
        widgetFeature.widthType = 1;
        widgetFeature.widthToggle = false;
        nodeQ.arg1 = new Gson().s(widgetFeature);
        return nodeQ;
    }

    public void j0(Node node) {
        this.d = node;
    }

    public Task k() {
        this.a = System.currentTimeMillis();
        Task task = new Task();
        this.c = task;
        task.setNodeMap(new LinkedHashMap<>());
        this.c.setId(System.currentTimeMillis());
        com.frame.l1.g(new Runnable() { // from class: i.b.s2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.t();
            }
        });
        return this.c;
    }

    public void k0(Task task) {
        this.a = System.currentTimeMillis();
        this.c = task;
    }

    public Node l(int i2, AccessibilityNodeInfo accessibilityNodeInfo) {
        Q();
        Node node = this.b;
        node.duration = 1L;
        node.delay = "500";
        node.timeOut = 5000L;
        node.errorType = 2;
        node.whatIndex = i2;
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getPackageName() != null) {
            this.b.url = accessibilityNodeInfo.getPackageName().toString();
            this.b.arg5 = accessibilityNodeInfo.getViewIdResourceName();
        }
        Node node2 = this.b;
        node2.type = 10;
        return node2;
    }

    public void l0() {
        Node node;
        Task task = this.c;
        if (task != null && (node = this.d) != null) {
            task.setLastNodeId(node.id);
        }
        this.d = null;
        g = null;
    }

    public ArrayList<Node> n() {
        if (f == null) {
            f = new ArrayList<>();
        }
        return f;
    }

    public List<AccessibilityNodeInfo> o(Collection<AccessibilityNodeInfo> collection, String str) {
        ArrayList arrayList = new ArrayList();
        for (AccessibilityNodeInfo accessibilityNodeInfo : collection) {
            if (str.equals(accessibilityNodeInfo.getViewIdResourceName())) {
                arrayList.add(accessibilityNodeInfo);
            }
        }
        return arrayList;
    }

    public Task p() {
        return this.c;
    }

    public void q(Task task, Node node, Node node2) {
        if (task == null) {
            FloatToast.i("未选中任务，请重试");
            return;
        }
        if (node == null) {
            node2.frontId = 0L;
            if (task.getFirstNodeId() != 0 && task.getNodeMap().containsKey(Long.valueOf(task.getFirstNodeId()))) {
                K(node2, task.getNodeMap().get(Long.valueOf(task.getFirstNodeId())));
            }
            task.setFirstNodeId(node2.id);
        } else {
            Node node3 = task.getNodeMap().get(Long.valueOf(node.nextId));
            if (node3 != null) {
                K(node2, node3);
            } else {
                node2.nextId = 0L;
            }
            K(node, node2);
        }
        task.getNodeMap().put(Long.valueOf(node2.id), node2);
    }

    public boolean r(AccessibilityNodeInfo accessibilityNodeInfo) {
        while (true) {
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
            if (accessibilityNodeInfo == null) {
                return false;
            }
            CharSequence className = accessibilityNodeInfo.getClassName();
            if (className != null && com.frame.g0.v().A(className.toString())) {
                return true;
            }
        }
    }
}
