package i.b.ka;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Toast;
import com.s.BoxService;
import com.v.AppChooseView;
import com.v.FloatToast;
import com.v.LaunchAppEditView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class c6 extends x5 {
    static /* synthetic */ void T(Node node, lt ltVar, String str) {
        node.url = str;
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    static /* synthetic */ void U(lt ltVar, String str) {
        MultiGestureRecordFloatView.c(500L);
        Node nodeD0 = v8.m().d0(str);
        if (ltVar != null) {
            ltVar.a(nodeD0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(String str, Runnable runnable) {
        for (int i2 = 0; i2 < 20; i2++) {
            try {
                try {
                    if (!this.c.q()) {
                        return;
                    }
                    try {
                        if (str.equals(com.frame.g0.v().x(BoxService.m()).getPackageName())) {
                            break;
                        }
                    } catch (Exception unused) {
                    }
                    SystemClock.sleep(500L);
                } finally {
                    this.c.W(runnable);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(final String str, final Runnable runnable) throws PendingIntent.CanceledException {
        try {
            Intent intentC = com.frame.i0.c(str);
            try {
                com.frame.y0.g("PendingIntent.getActivity.send:" + str);
                com.frame.i0.e(0, intentC).send();
            } catch (Exception e) {
                com.frame.k0.r(e);
                com.frame.y0.g("FrameApp.getInstance().startActivity:" + str);
                com.frame.v0.g().startActivity(intentC);
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            FloatToast.i("启动应用出错");
        }
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.r
            @Override // java.lang.Runnable
            public final void run() {
                this.c.W(str, runnable);
            }
        });
    }

    @Override // i.b.ka.x5
    public int B() {
        return 8;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, final lt ltVar) {
        LaunchAppEditView launchAppEditView = (LaunchAppEditView) com.frame.s0.g().B(LaunchAppEditView.class);
        launchAppEditView.u(node.url);
        launchAppEditView.t(task, node);
        launchAppEditView.setCallback(new AppChooseView.a() { // from class: i.b.ka.q
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                c6.T(node, ltVar, str);
            }
        });
        Toast.makeText(com.frame.v0.g(), "启动app", 0).show();
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ((AppChooseView) com.frame.s0.g().B(AppChooseView.class)).setCallback(new AppChooseView.a() { // from class: i.b.ka.s
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                c6.U(ltVar, str);
            }
        });
    }

    public void Z(final String str, final Runnable runnable) {
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.t
            @Override // java.lang.Runnable
            public final void run() throws PendingIntent.CanceledException {
                this.c.Y(str, runnable);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("启动app：" + node.url);
        Z(node.url, runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.R;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "开启应用";
    }
}
