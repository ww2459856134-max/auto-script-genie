package i.b.ka;

import android.view.View;
import com.v.MultiClickDialogView;
import com.v.RectChooseView;
import com.v.lt;
import com.yl.model.Node;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class b7 extends r6 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(lt ltVar, Node node, final Node node2) {
        com.frame.s0.g().d(MultiClickDialogView.class);
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.x2
            @Override // java.lang.Runnable
            public final void run() {
                v8.m().V(node2);
            }
        });
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(final Node node, RectChooseView rectChooseView, final lt ltVar, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        node.setAreaNew(rectChooseView.getRect());
        node.what = 1;
        MultiClickDialogView multiClickDialogView = (MultiClickDialogView) com.frame.s0.g().B(MultiClickDialogView.class);
        multiClickDialogView.h(v8.m().p(), node);
        multiClickDialogView.f(new lt() { // from class: i.b.ka.w2
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.h0(ltVar, node, node2);
            }
        });
        multiClickDialogView.d();
    }

    @Override // i.b.ka.r6, i.b.ka.x5
    public int B() {
        return 17;
    }

    @Override // i.b.ka.r6, i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setHit("滑动选取随机点击区域");
        rectChooseView.q("取消", new View.OnClickListener() { // from class: i.b.ka.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().o(rectChooseView);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: i.b.ka.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j0(nodeQ, rectChooseView, ltVar, view);
            }
        });
    }

    @Override // i.b.ka.r6, i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("触发区域随机点击：" + node.getStepAndName());
        return super.p(linkedHashMap, node, runnable);
    }

    @Override // i.b.ka.r6, i.b.ka.x5
    public int r() {
        return j.b.d.e0;
    }

    @Override // i.b.ka.r6, i.b.ka.x5
    public String t() {
        return "随机点击";
    }
}
