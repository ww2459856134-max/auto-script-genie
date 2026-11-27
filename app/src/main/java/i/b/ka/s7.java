package i.b.ka;

import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.gson.Gson;
import com.s.BoxService;
import com.user.AccountTool;
import com.v.FloatToast;
import com.v.MultiGestureRecordFloatView;
import com.v.PageScanFloatView;
import com.v.WidgetScanDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.WidgetFeature;
import i.b.da;
import i.b.v8;
import i.b.x7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.json.JSONException;

/* loaded from: classes.dex */
public class s7 extends x5 {
    WidgetFeature f;
    protected r7 g;
    private List<AccessibilityNodeInfo> e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private HashMap<AccessibilityNodeInfo, AccessibilityNodeInfo> f1535h = new HashMap<>();

    private List<AccessibilityNodeInfo> U(int i2, AccessibilityNodeInfo accessibilityNodeInfo, List<AccessibilityNodeInfo> list, com.frame.h0 h0Var) {
        if (i2 > 100) {
            return null;
        }
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount() && this.c.q(); i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                if (child != null) {
                    try {
                        if (child.getChildCount() != 0) {
                            U(i2 + 1, child, list, h0Var);
                        } else if (h0Var.a(child)) {
                            list.add(child);
                        }
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                }
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
        return null;
    }

    public static WidgetFeature V(String str) {
        try {
            WidgetFeature widgetFeature = (WidgetFeature) new Gson().j(str, WidgetFeature.class);
            if (widgetFeature != null) {
                return widgetFeature;
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        new WidgetFeature();
        String[] strArrSplit = str.replace("||", "|").split("\\|");
        WidgetFeature widgetFeature2 = new WidgetFeature();
        String[] strArrSplit2 = strArrSplit[0].split("##");
        widgetFeature2.id = strArrSplit2[0];
        widgetFeature2.idToggle = "1".equals(strArrSplit2[1]);
        String[] strArrSplit3 = strArrSplit[1].split("##");
        widgetFeature2.className = strArrSplit3[0];
        widgetFeature2.classToggle = "1".equals(strArrSplit3[1]);
        String[] strArrSplit4 = strArrSplit[2].split("##");
        widgetFeature2.text = strArrSplit4[0];
        widgetFeature2.textToggle = "1".equals(strArrSplit4[1]);
        widgetFeature2.textType = "1".equals(strArrSplit4[1]) ? 1 : 2;
        String[] strArrSplit5 = strArrSplit[3].split("##");
        widgetFeature2.desc = strArrSplit5[0];
        widgetFeature2.descToggle = "1".equals(strArrSplit5[1]);
        widgetFeature2.descType = "1".equals(strArrSplit5[1]) ? 1 : 2;
        String[] strArrSplit6 = strArrSplit[4].split("##");
        widgetFeature2.path = strArrSplit6[0];
        widgetFeature2.pathToggle = "1".equals(strArrSplit6[1]);
        return widgetFeature2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(lt ltVar) {
        c(ltVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(int i2, lt ltVar, Node node) {
        if (i2 != 1) {
            v8.m().g0(node, null);
        }
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 19;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        WidgetScanDialogView widgetScanDialogView = (WidgetScanDialogView) com.frame.s0.g().B(WidgetScanDialogView.class);
        widgetScanDialogView.B(i2 == 1);
        widgetScanDialogView.D(v8.m().p(), node);
        widgetScanDialogView.C(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(final int i2, final lt ltVar) {
        MultiGestureRecordFloatView.F(null);
        PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
        pageScanFloatView.d(null);
        pageScanFloatView.setOnCancelListener(new Runnable() { // from class: i.b.ka.m5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a0(ltVar);
            }
        });
        if (i2 == 1) {
            pageScanFloatView.setMiniModel(true);
        }
        pageScanFloatView.setNodeCallback(new lt() { // from class: i.b.ka.l5
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.c0(i2, ltVar, node);
            }
        });
        if (da.B().C().size() >= 4 || !com.frame.n0.a("guideAudio", true)) {
            return;
        }
        da.B().B1("record_text.mp4");
    }

    public void T(String str) throws Exception {
        if (str == null) {
            return;
        }
        String strX = da.x();
        if (TextUtils.isEmpty(strX)) {
            return;
        }
        for (String str2 : strX.split(",")) {
            if (str != null && str.contains(str2)) {
                throw new Exception(com.frame.a1.b().e("ignoreAlert", "未知错误"));
            }
        }
    }

    public void W(Node node) {
        this.a = System.currentTimeMillis();
        this.f = V(node.arg1);
        this.g = new r7(this, node, !"0".equals(node.arg5));
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0118: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:73:0x0118 */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e0 A[Catch: Exception -> 0x0103, all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:12:0x0023, B:16:0x002e, B:19:0x003c, B:21:0x0044, B:23:0x0058, B:52:0x00d8, B:54:0x00e0, B:58:0x00ec, B:28:0x0065, B:29:0x0075, B:31:0x007b, B:34:0x008a, B:35:0x0090, B:37:0x0098, B:40:0x009d, B:42:0x00a1, B:44:0x00b5, B:47:0x00bf, B:49:0x00d3, B:67:0x0109), top: B:78:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<AccessibilityNodeInfo> d0(Node node, String str) {
        AccessibilityNodeInfo accessibilityNodeInfoY;
        AccessibilityNodeInfo accessibilityNodeInfo;
        List<AccessibilityNodeInfo> list;
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        try {
            try {
                accessibilityNodeInfoY = this.f.isPackageMatchEnabled() ? y(str) : BoxService.m().getRootInActiveWindow();
                if (accessibilityNodeInfoY != null) {
                    try {
                        if (this.c.q()) {
                            this.e.clear();
                            WidgetFeature widgetFeature = this.f;
                            if (widgetFeature.idToggle) {
                                if ("1".equals(node.arg3)) {
                                    U(0, accessibilityNodeInfoY, this.e, this.g);
                                    this.f1535h.clear();
                                    if (!this.e.isEmpty()) {
                                        list = this.e;
                                        if (accessibilityNodeInfoY != null) {
                                            accessibilityNodeInfoY.recycle();
                                        }
                                        this.f1535h.clear();
                                        return list;
                                    }
                                    if ("1".equals(node.arg2)) {
                                        if (this.c.q()) {
                                            com.frame.g0.v().S(accessibilityNodeInfoY, XMLEvent.CHANGE_PREFIX_MAPPING);
                                            x7.d().b(node.argInt1);
                                            if (accessibilityNodeInfoY != null) {
                                            }
                                        } else if (accessibilityNodeInfoY != null) {
                                            accessibilityNodeInfoY.recycle();
                                        }
                                    } else if (accessibilityNodeInfoY != null) {
                                    }
                                } else {
                                    for (AccessibilityNodeInfo accessibilityNodeInfo3 : accessibilityNodeInfoY.findAccessibilityNodeInfosByViewId(String.valueOf(this.f.id))) {
                                        if (this.g.a(accessibilityNodeInfo3)) {
                                            this.e.add(accessibilityNodeInfo3);
                                        }
                                    }
                                    if (!this.e.isEmpty()) {
                                        list = this.e;
                                        if (accessibilityNodeInfoY != null) {
                                            accessibilityNodeInfoY.recycle();
                                        }
                                        this.f1535h.clear();
                                        return list;
                                    }
                                    if ("1".equals(node.arg2)) {
                                    }
                                }
                            } else if (widgetFeature.pathToggle) {
                                AccessibilityNodeInfo accessibilityNodeInfoJ = com.frame.g0.v().j(str, String.valueOf(this.f.path), accessibilityNodeInfoY, this.g);
                                if (accessibilityNodeInfoJ != null) {
                                    this.e.add(accessibilityNodeInfoJ);
                                    list = this.e;
                                    if (accessibilityNodeInfoY != null) {
                                        accessibilityNodeInfoY.recycle();
                                    }
                                    this.f1535h.clear();
                                    return list;
                                }
                                if ("1".equals(node.arg2)) {
                                }
                            } else {
                                U(0, accessibilityNodeInfoY, this.e, this.g);
                                this.f1535h.clear();
                                if (!this.e.isEmpty()) {
                                    list = this.e;
                                    if (accessibilityNodeInfoY != null) {
                                        accessibilityNodeInfoY.recycle();
                                    }
                                    this.f1535h.clear();
                                    return list;
                                }
                                if ("1".equals(node.arg2)) {
                                }
                            }
                        } else if (accessibilityNodeInfoY != null) {
                            accessibilityNodeInfoY.recycle();
                        }
                    } catch (Exception e) {
                        e = e;
                        com.frame.k0.r(e);
                        if (accessibilityNodeInfoY != null) {
                            accessibilityNodeInfoY.recycle();
                        }
                        this.f1535h.clear();
                        return null;
                    }
                } else if (accessibilityNodeInfoY != null) {
                    accessibilityNodeInfoY.recycle();
                }
                this.f1535h.clear();
                return null;
            } catch (Throwable th) {
                th = th;
                accessibilityNodeInfo2 = accessibilityNodeInfo;
                if (accessibilityNodeInfo2 != null) {
                    accessibilityNodeInfo2.recycle();
                }
                this.f1535h.clear();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            accessibilityNodeInfoY = null;
        } catch (Throwable th2) {
            th = th2;
            if (accessibilityNodeInfo2 != null) {
            }
            this.f1535h.clear();
            throw th;
        }
    }

    public void e0(long j2) {
        this.a = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f0, code lost:
    
        return false;
     */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, Runnable runnable) throws JSONException {
        com.frame.y0.g("控件识别：" + node.getStepAndName());
        long j2 = node.timeOut;
        if (runnable != null && !AccountTool.d().m() && this.c.l().getCreateUserId() != null && !AccountTool.d().g().equals(this.c.l().getCreateUserId()) && !AccountTool.d().m()) {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.n5
                @Override // java.lang.Runnable
                public final void run() {
                    da.B().a2();
                }
            });
            return false;
        }
        if (System.currentTimeMillis() - com.frame.k0.b() > 4048000000L && AccountTool.d().l() && AccountTool.d().c().getVipStartTime() == null) {
            String str = null;
            str.toString();
            return false;
        }
        W(node);
        while (true) {
            if (!this.c.q()) {
                break;
            }
            List<AccessibilityNodeInfo> listD0 = d0(node, node.url);
            if (listD0 != null) {
                N(node, this.a);
                x7.d().b(node.getNextDelay());
                try {
                    if (this.f.isPackageMatchEnabled()) {
                        T(node.url);
                    }
                } catch (Exception e) {
                    da.B().w1(e.getMessage());
                }
                n(node, listD0, runnable);
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j3 = this.a;
            if (jCurrentTimeMillis - j3 > j2) {
                O(node, j3);
                com.frame.l1.e(new Runnable() { // from class: i.b.ka.o5
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatToast.g(j.b.d.a0, "「" + node.getStepAndName() + "」控件找不到");
                    }
                });
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                break;
            }
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.a0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "控件识别";
    }
}
