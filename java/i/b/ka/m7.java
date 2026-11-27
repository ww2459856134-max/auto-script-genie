package i.b.ka;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.TextView;
import com.s.BoxService;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.PageScanFloatView;
import com.v.TextChooseDialogViewNew;
import com.v.lt;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONException;

/* loaded from: classes.dex */
public class m7 extends x5 {
    private Node e;

    private String T(Node node) throws Throwable {
        String strH;
        int i2 = 0;
        if ("从文件中获取文字输入".equals(node.text)) {
            strH = com.frame.r0.x(node.arg2);
            if (!TextUtils.isEmpty(node.arg3)) {
                String[] strArrSplit = strH.split(node.arg3);
                if ("顺序输入".equals(node.arg1)) {
                    try {
                        i2 = Integer.parseInt(da.B().A().get("textLoop:" + node.id).toString());
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                    strH = strArrSplit[i2 % strArrSplit.length];
                    da.B().A().put("textLoop:" + node.id, Integer.valueOf(i2 + 1));
                } else if ("随机输入".equals(node.arg1)) {
                    strH = strArrSplit[new Random().nextInt(strArrSplit.length)];
                }
            }
        } else if ("从变量取值输入".equals(node.text)) {
            strH = da.B().H(node.arg2);
        } else if ("从剪切板粘贴".equals(node.text)) {
            strH = "$$-2";
        } else if ("随机选择以下文本输入".equals(node.text)) {
            String[] strArrSplit2 = node.arg1.split("&&");
            strH = strArrSplit2[new Random().nextInt(strArrSplit2.length)];
        } else if ("按顺序输入以下文本".equals(node.text)) {
            try {
                i2 = Integer.parseInt(da.B().A().get("textLoop").toString());
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
            String[] strArrSplit3 = node.arg1.split("&&");
            int i3 = i2 + 1;
            da.B().A().put("textLoop", Integer.valueOf(i3));
            strH = strArrSplit3[i3 % strArrSplit3.length];
        } else if ("输入文字".equals(node.text)) {
            String[] strArrSplit4 = node.arg1.split("&&");
            int length = node.what;
            if (length >= strArrSplit4.length) {
                length = strArrSplit4.length - 1;
            }
            strH = strArrSplit4[length];
        } else {
            strH = "";
        }
        return da.B().G(strH);
    }

    private String U(Node node, int i2, String str) throws NumberFormatException {
        String[] strArrSplit = str.split("&&");
        if (i2 == -1) {
            return strArrSplit[new Random().nextInt(strArrSplit.length)];
        }
        if (i2 != -3) {
            return i2 == -2 ? "$$-2" : strArrSplit[i2];
        }
        int i3 = 0;
        try {
            i3 = Integer.parseInt(da.B().A().get("textLoop:" + node.id).toString());
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        String str2 = strArrSplit[i3 % strArrSplit.length];
        da.B().A().put("textLoop:" + node.id, Integer.valueOf(i3 + 1));
        return str2;
    }

    private boolean V(String str, int i2, String str2, String str3, Runnable runnable) {
        AccessibilityNodeInfo root;
        AccessibilityNodeInfo accessibilityNodeInfoI;
        try {
            List<AccessibilityWindowInfo> windows = BoxService.m().getWindows();
            int size = windows.size() - 1;
            while (true) {
                if (size < 0) {
                    root = null;
                    break;
                }
                AccessibilityWindowInfo accessibilityWindowInfo = windows.get(size);
                if (accessibilityWindowInfo.isActive() && (root = accessibilityWindowInfo.getRoot()) != null && (!this.e.isTextInputPackageMatchEnabled() || str.contentEquals(root.getPackageName()))) {
                    break;
                }
                size--;
            }
            if (root == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Node node = this.e;
            if (node.argInt1 == 1) {
                accessibilityNodeInfoI = root.findAccessibilityNodeInfosByViewId(node.arg5).get(0);
            } else if (str2 == null) {
                List<AccessibilityNodeInfo> listR = com.frame.g0.v().r(null, root);
                if (listR.isEmpty() || i2 >= listR.size()) {
                    return false;
                }
                accessibilityNodeInfoI = listR.get(i2);
            } else {
                accessibilityNodeInfoI = str2.contains(":id/") ? com.frame.g0.v().i(root, str2, false) : com.frame.g0.v().m(root, str2, false);
            }
            if (accessibilityNodeInfoI == null) {
                return false;
            }
            if ("$$-2".equals(str3)) {
                accessibilityNodeInfoI.performAction(1);
                accessibilityNodeInfoI.performAction(32768);
                return true;
            }
            Bundle bundle = new Bundle();
            if ("叠加输入".equals(this.e.arg4) && accessibilityNodeInfoI.getText() != null) {
                str3 = ((Object) accessibilityNodeInfoI.getText()) + str3;
            }
            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str3);
            accessibilityNodeInfoI.performAction(2097152, bundle);
            for (int i3 = 0; i3 < 20 && accessibilityNodeInfoI.getText() != null && !str3.contentEquals(accessibilityNodeInfoI.getText()); i3++) {
                accessibilityNodeInfoI.performAction(2097152, bundle);
            }
            GesturePlayFloatView.C(accessibilityNodeInfoI);
            Log.e("文字输入耗时:", (System.currentTimeMillis() - jCurrentTimeMillis) + "");
            return true;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(lt ltVar, Node node) {
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(lt ltVar, Node node) {
        Node nodeE0 = v8.m().e0(node);
        MultiGestureRecordFloatView.c(0L);
        Q(ltVar, nodeE0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(final lt ltVar, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(PageScanFloatView.class);
        Node nodeL = v8.m().l(-1, null);
        TextChooseDialogViewNew textChooseDialogViewNew = (TextChooseDialogViewNew) com.frame.s0.g().x(TextChooseDialogViewNew.class);
        textChooseDialogViewNew.setTaskNode(v8.m().p(), nodeL);
        textChooseDialogViewNew.setNodeCallback(new lt() { // from class: i.b.ka.x4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.b0(ltVar, node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(final lt ltVar) {
        com.frame.s0.g().d(PageScanFloatView.class);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("未找到输入框元素。你可以点击下面，将文字复制到剪切板，然后用点击输入法粘贴输入。");
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: i.b.ka.a5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("点击这里将文字复制到剪切板");
        textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(10.0f), 0, com.frame.p1.c(2.0f));
        textView.setTextSize(12.0f);
        textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.I0, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: i.b.ka.c5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.d0(ltVar, view);
            }
        });
        dingMsgView.m(textView);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 10;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        TextChooseDialogViewNew textChooseDialogViewNew = (TextChooseDialogViewNew) com.frame.s0.g().x(TextChooseDialogViewNew.class);
        textChooseDialogViewNew.setTaskNode(task, node);
        textChooseDialogViewNew.setNodeCallback(new lt() { // from class: i.b.ka.z4
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.Y(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        MultiGestureRecordFloatView.E();
        FloatToast.g(j.b.d.P, "请从屏幕上选择输入框");
        da.B().B1("textinput.mp4");
        PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
        pageScanFloatView.setOnNoFindCallback(new Runnable() { // from class: i.b.ka.y4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.f0(ltVar);
            }
        });
        pageScanFloatView.f(new l7(this, ltVar));
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException {
        com.frame.y0.g("输入文字：" + node.getStepAndName());
        this.e = node;
        String strT = !TextUtils.isEmpty(node.text) ? T(node) : U(node, node.what, node.arg1);
        if (node.url == null) {
            if (!"$$-2".equals(strT)) {
                com.frame.m0.a(strT);
            }
            this.c.W(runnable);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = node.timeOut;
        if (j2 == 0) {
            j2 = 5000;
        }
        long j3 = j2;
        while (true) {
            if (!this.c.q()) {
                break;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis > j3) {
                O(node, jCurrentTimeMillis);
                com.frame.l1.e(new Runnable() { // from class: i.b.ka.b5
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatToast.g(j.b.d.P, "未找到指定的输入框");
                    }
                });
                k(node, runnable);
                break;
            }
            Object obj = node.extra;
            if (V(node.url, node.whatIndex, obj == null ? null : obj.toString(), strT, runnable)) {
                this.c.W(runnable);
                break;
            }
        }
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.P;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "文字输入";
    }
}
