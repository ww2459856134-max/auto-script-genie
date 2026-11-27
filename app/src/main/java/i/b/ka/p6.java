package i.b.ka;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.FlowView;
import com.v.LengthScrollChooseView;
import com.v.LengthScrollDialogView;
import com.v.MultiGestureRecordFloatView;
import com.v.NodeListDialogView;
import com.v.kt;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.t9;
import i.b.v8;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class p6 extends z6 {
    static /* synthetic */ void W(Node node) {
        com.frame.s0.g().d(LengthScrollDialogView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
    }

    static /* synthetic */ void X(Node node) {
        com.frame.s0.g().d(LengthScrollChooseView.class);
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
    }

    static /* synthetic */ void Y() {
        com.frame.s0.g().d(LengthScrollDialogView.class);
        com.frame.s0.g().d(LengthScrollChooseView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    static /* synthetic */ void a0(Node node) {
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.t0
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(FloatHandlerRecord.class);
            }
        });
        MultiGestureRecordFloatView.c(node.getDelay() + 500);
    }

    static /* synthetic */ void b0(final Node node) {
        SystemClock.sleep(200L);
        new t9(v8.m().p()).t(node, new Runnable() { // from class: i.b.ka.u0
            @Override // java.lang.Runnable
            public final void run() {
                p6.a0(node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(lt ltVar, final Node node) {
        if (node == null) {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.z0
                @Override // java.lang.Runnable
                public final void run() {
                    p6.Y();
                }
            });
            return;
        }
        v8.m().a(node);
        MultiGestureRecordFloatView.F(new Runnable() { // from class: i.b.ka.x0
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.l1.g(new Runnable() { // from class: i.b.ka.a1
                    @Override // java.lang.Runnable
                    public final void run() {
                        p6.b0(node);
                    }
                });
            }
        });
        FloatToast.g(j.b.d.p, Html.fromHtml("触发<font color='#E73030'>『滑动固定距离』</font>操作"));
        Q(ltVar, node);
    }

    private String f0(String str) {
        String strH = da.B().H(str);
        if (strH == null) {
            strH = "null";
        }
        if (strH.contains(",") && strH.contains(ProcessIdUtil.DEFAULT_PROCESSID)) {
            Rect rectByString = Node.getRectByString(strH);
            strH = rectByString.centerX() + "," + rectByString.centerY();
        }
        return ("null".equals(strH) && str.contains(",")) ? str : strH;
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public int B() {
        return 27;
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(FlowView.class);
        if (((TextUtils.isEmpty(node.arg1) && TextUtils.isEmpty(node.text)) ? false : true) || node.pathPoints == null) {
            LengthScrollDialogView lengthScrollDialogView = (LengthScrollDialogView) com.frame.s0.g().x(LengthScrollDialogView.class);
            lengthScrollDialogView.l(task, node);
            lengthScrollDialogView.k(new lt() { // from class: i.b.ka.w0
                @Override // com.v.lt
                public final void a(Node node2) {
                    p6.W(node2);
                }
            });
        } else {
            LengthScrollChooseView lengthScrollChooseView = (LengthScrollChooseView) com.frame.s0.g().x(LengthScrollChooseView.class);
            lengthScrollChooseView.setTaskNode(task, node);
            lengthScrollChooseView.setCallback(new lt() { // from class: i.b.ka.y0
                @Override // com.v.lt
                public final void a(Node node2) {
                    p6.X(node2);
                }
            });
        }
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        da.B().B1("record_scroll.mp4");
        Node nodeQ = v8.m().Q();
        nodeQ.duration = 200L;
        LengthScrollChooseView lengthScrollChooseView = (LengthScrollChooseView) com.frame.s0.g().x(LengthScrollChooseView.class);
        lengthScrollChooseView.setTaskNode(v8.m().p(), nodeQ);
        lengthScrollChooseView.setCallback(new lt() { // from class: i.b.ka.v0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.e0(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        if (TextUtils.isEmpty(node.arg1) && TextUtils.isEmpty(node.text)) {
            return super.p(linkedHashMap, node, runnable);
        }
        ArrayList<String> arrayListC = kt.c(node.arg1, node.text);
        if (arrayListC.isEmpty()) {
            da.B().w1("定长滑动变量坐标配置错误，请重新设置");
            return false;
        }
        ArrayList arrayList = new ArrayList(arrayListC.size() * 2);
        int i2 = 0;
        while (i2 < arrayListC.size()) {
            String strValueOf = i2 < 26 ? String.valueOf((char) (i2 + 65)) : String.valueOf(i2 + 1);
            String str = arrayListC.get(i2);
            try {
                String strF0 = f0(str);
                if ("null".equals(strF0)) {
                    da.B().w1("定长滑动的" + strValueOf + "点坐标没有坐标值，或变量值为空");
                    return false;
                }
                String[] strArrSplit = strF0.split(",");
                arrayList.add(Integer.valueOf(Integer.parseInt(strArrSplit[0].trim())));
                arrayList.add(Integer.valueOf(Integer.parseInt(strArrSplit[1].trim())));
                i2++;
            } catch (Exception unused) {
                com.frame.y0.j("定长滑动的" + strValueOf + "点变量坐标错误:" + str);
                da.B().w1("定长滑动的" + strValueOf + "点坐标格式错误，请检查变量值");
                return false;
            }
        }
        Node node2 = new Node();
        node2.type = node.type;
        node2.duration = node.duration;
        node2.maxDuration = node.maxDuration;
        node2.pathPoints = kt.d(arrayList);
        com.frame.y0.j("定长滑动变量路径:" + node2.pathPoints);
        return super.p(linkedHashMap, node2, runnable);
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public int r() {
        return j.b.d.i0;
    }

    @Override // i.b.ka.z6, i.b.ka.x5
    public String t() {
        return "定长滑动";
    }
}
