package i.b.ka;

import android.graphics.Rect;
import com.v.Watermark;
import com.v.WatermarkDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* loaded from: classes.dex */
public class q7 extends x5 {
    static /* synthetic */ void T(Rect rect, Node node) {
        Watermark watermark = (Watermark) com.frame.s0.g().F(Watermark.class, rect.left, rect.top, rect.width(), rect.height());
        watermark.setAlpha(node.argInt1 / 100.0f);
        com.bumptech.glide.c.t(com.frame.v0.g()).w(node.url).q0(watermark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 42;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        WatermarkDialogView watermarkDialogView = (WatermarkDialogView) com.frame.s0.g().B(WatermarkDialogView.class);
        watermarkDialogView.setTaskNode(task, node);
        watermarkDialogView.e(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 42;
        nodeQ.timeOut = 500L;
        nodeQ.delay = "500";
        nodeQ.argInt1 = 50;
        WatermarkDialogView watermarkDialogView = (WatermarkDialogView) com.frame.s0.g().B(WatermarkDialogView.class);
        watermarkDialogView.setTaskNode(v8.m().p(), nodeQ);
        watermarkDialogView.e(new lt() { // from class: i.b.ka.i5
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.W(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, Runnable runnable) throws JSONException {
        if (node.what == 0) {
            final Rect areaOrParam = node.getAreaOrParam();
            if (node.hasAreaResolveError() || areaOrParam == null) {
                k(node, runnable);
                return false;
            }
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.k5
                @Override // java.lang.Runnable
                public final void run() {
                    q7.T(areaOrParam, node);
                }
            });
        } else {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.j5
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().d(Watermark.class);
                }
            });
        }
        this.c.Z(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.H;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "打水印";
    }
}
