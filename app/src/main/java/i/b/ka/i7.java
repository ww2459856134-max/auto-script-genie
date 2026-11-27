package i.b.ka;

import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import com.v.FloatToast;
import com.v.PageScrollDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.LinkedHashMap;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class i7 extends x5 {
    static /* synthetic */ void T(Node node) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(lt ltVar, Node node) {
        Node nodeZ = v8.m().Z(node);
        FloatToast.g(j.b.d.p, Html.fromHtml("触发<font color='#E73030'>『页面翻页』</font>操作"));
        Q(ltVar, nodeZ);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 16;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        PageScrollDialogView pageScrollDialogView = (PageScrollDialogView) com.frame.s0.g().B(PageScrollDialogView.class);
        pageScrollDialogView.h(task, node);
        pageScrollDialogView.g(new lt() { // from class: i.b.ka.q4
            @Override // com.v.lt
            public final void a(Node node2) {
                i7.T(node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        PageScrollDialogView pageScrollDialogView = (PageScrollDialogView) com.frame.s0.g().B(PageScrollDialogView.class);
        pageScrollDialogView.h(v8.m().p(), nodeQ);
        pageScrollDialogView.g(new lt() { // from class: i.b.ka.r4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.V(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 28 && da.B().O()) {
            String str = node.arg1;
            int i3 = 80;
            if (str == null || !str.equals("1")) {
                String str2 = node.arg1;
                if (str2 == null || !str2.equals("2")) {
                    String str3 = node.arg1;
                    if (str3 == null || !str3.equals("3")) {
                        com.frame.y0.g("HID向下滚动屏幕：" + node.getName());
                        i3 = -80;
                    } else {
                        com.frame.y0.g("HID向右滚动屏幕：" + node.getName());
                        i3 = 0;
                        i2 = -80;
                    }
                } else {
                    com.frame.y0.g("HID向左滚动屏幕：" + node.getName());
                    i3 = 0;
                    i2 = 80;
                }
            } else {
                com.frame.y0.g("HID向上滚动屏幕：" + node.getName());
            }
            com.bluetooth.cursor.w.q.g().E(i2, i3);
            this.c.W(runnable);
            return true;
        }
        String str4 = node.arg2;
        if (str4 == null || "滚动一页".equals(str4)) {
            String str5 = node.arg1;
            if (str5 == null || !str5.equals("1")) {
                String str6 = node.arg1;
                if (str6 == null || !str6.equals("2")) {
                    String str7 = node.arg1;
                    if (str7 == null || !str7.equals("3")) {
                        com.frame.y0.g("向下滚动屏幕：" + node.getName());
                        com.frame.g0.v().P(com.frame.g0.v().x(com.frame.w0.b()));
                    } else {
                        com.frame.y0.g("向右滚动屏幕：" + node.getName());
                        com.frame.g0.v().Q(com.frame.g0.v().x(com.frame.w0.b()), XMLEvent.CHANGE_PREFIX_MAPPING);
                    }
                } else {
                    com.frame.y0.g("向左滚动屏幕：" + node.getName());
                    com.frame.g0.v().Q(com.frame.g0.v().x(com.frame.w0.b()), XMLEvent.ENTITY_REFERENCE);
                }
            } else {
                com.frame.y0.g("向上滚动屏幕：" + node.getName());
                com.frame.g0.v().O(0, com.frame.g0.v().x(com.frame.w0.b()), XMLEvent.ENTITY_REFERENCE);
            }
        } else if (node.arg2.equals("滚动一条")) {
            if (TextUtils.isEmpty(node.arg3)) {
                String str8 = "滚动条" + node.id;
                String strG = da.B().G(node.arg4);
                da daVarB = da.B();
                if (TextUtils.isEmpty(strG)) {
                    strG = "0";
                }
                int iIntValue = Integer.valueOf(daVarB.I(str8, strG)).intValue();
                com.frame.g0.v().T(com.frame.g0.v().x(com.frame.w0.b()), iIntValue);
                da.B().E1(str8, Integer.valueOf(iIntValue + 1));
                com.frame.y0.g("滚动到第<font color='#00ff00'>" + iIntValue + "</font>条");
            } else {
                try {
                    int iIntValue2 = Integer.valueOf(da.B().G(node.arg3)).intValue();
                    com.frame.g0.v().T(com.frame.g0.v().x(com.frame.w0.b()), iIntValue2);
                    com.frame.y0.g("滚动到第<font color='#00ff00'>" + iIntValue2 + "</font>条");
                } catch (Exception unused) {
                    com.frame.y0.j("滚动条数：变量值不是整数");
                }
            }
        }
        this.c.W(runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.b0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "页面滚动";
    }
}
