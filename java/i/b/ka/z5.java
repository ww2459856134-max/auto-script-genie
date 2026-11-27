package i.b.ka;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import com.v.AlertOptionDialogView;
import com.v.AlertOptionSetDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class z5 extends x5 {
    private CountDownTimer e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(Runnable runnable) {
        com.frame.s0.g().d(AlertOptionSetDialogView.class);
        this.c.Z(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(Runnable runnable, View view) {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(View view) {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        da.B().h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(final Runnable runnable, Node node) {
        final Runnable runnable2 = new Runnable() { // from class: i.b.ka.h
            @Override // java.lang.Runnable
            public final void run() {
                this.c.U(runnable);
            }
        };
        AlertOptionSetDialogView alertOptionSetDialogView = (AlertOptionSetDialogView) com.frame.s0.g().B(AlertOptionSetDialogView.class);
        alertOptionSetDialogView.setTask(this.c.l(), node);
        alertOptionSetDialogView.setOnContinueListener(new View.OnClickListener() { // from class: i.b.ka.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.W(runnable2, view);
            }
        });
        alertOptionSetDialogView.setOnStopListener(new View.OnClickListener() { // from class: i.b.ka.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.Y(view);
            }
        });
        if (node.timeOut > 0) {
            y5 y5Var = new y5(this, node.timeOut, 1000L, (TextView) alertOptionSetDialogView.findViewById(j.b.e.B));
            this.e = y5Var;
            y5Var.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 41;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        AlertOptionDialogView alertOptionDialogView = (AlertOptionDialogView) com.frame.s0.g().B(AlertOptionDialogView.class);
        alertOptionDialogView.setTaskNode(task, node);
        alertOptionDialogView.p(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 41;
        nodeQ.timeOut = 0L;
        nodeQ.delay = "100";
        AlertOptionDialogView alertOptionDialogView = (AlertOptionDialogView) com.frame.s0.g().B(AlertOptionDialogView.class);
        alertOptionDialogView.setTaskNode(v8.m().p(), nodeQ);
        alertOptionDialogView.p(new lt() { // from class: i.b.ka.g
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.c0(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, final Runnable runnable) {
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.j
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a0(runnable, node);
            }
        });
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
        return "弹窗确认";
    }
}
