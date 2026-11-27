package i.b.ka;

import android.os.Vibrator;
import android.text.TextUtils;
import com.v.AudioDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.io.IOException;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class k7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(lt ltVar, Node node, Node node2) {
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(lt ltVar, Node node, Node node2) {
        v8.m().c0(node2);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 20;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, final lt ltVar) {
        AudioDialogView audioDialogView = (AudioDialogView) com.frame.s0.g().x(AudioDialogView.class);
        audioDialogView.setTaskNode(v8.m().p(), node);
        audioDialogView.f(new lt() { // from class: i.b.ka.u4
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.U(ltVar, node, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        nodeQ.type = 20;
        AudioDialogView audioDialogView = (AudioDialogView) com.frame.s0.g().x(AudioDialogView.class);
        audioDialogView.setTaskNode(v8.m().p(), nodeQ);
        audioDialogView.f(new lt() { // from class: i.b.ka.v4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.W(ltVar, nodeQ, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (node.what == 2) {
            ((Vibrator) com.frame.v0.g().getSystemService("vibrator")).vibrate(new long[]{100, 200, 100, 200, 100, 200}, -1);
        } else if (TextUtils.isEmpty(node.text)) {
            da.B().B1("ding.mp3");
        } else {
            da.B().C1(node.text);
        }
        this.c.Z(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.k0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "播放声音";
    }
}
