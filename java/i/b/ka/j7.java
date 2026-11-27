package i.b.ka;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.v.FloatToast;
import com.v.SendFileDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.t9;
import i.b.v8;
import java.io.File;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class j7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(lt ltVar, Node node) {
        v8.m().X(node);
        new t9(v8.m().p()).t(node, null);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 45;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        SendFileDialogView sendFileDialogView = (SendFileDialogView) com.frame.s0.g().B(SendFileDialogView.class);
        sendFileDialogView.setTaskNode(task, node);
        sendFileDialogView.d(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 45;
        nodeQ.timeOut = 0L;
        nodeQ.delay = "100";
        SendFileDialogView sendFileDialogView = (SendFileDialogView) com.frame.s0.g().B(SendFileDialogView.class);
        sendFileDialogView.setTaskNode(v8.m().p(), nodeQ);
        sendFileDialogView.d(new lt() { // from class: i.b.ka.t4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.V(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws IllegalArgumentException {
        Uri uriFromFile;
        String strH;
        String strG = node.url;
        if (strG != null && strG.contains("${")) {
            strG = da.B().G(strG);
        }
        if (strG.contains("content://")) {
            uriFromFile = Uri.parse(strG);
            strH = "*/*";
        } else {
            File file = new File(strG);
            if (Build.VERSION.SDK_INT >= 24) {
                uriFromFile = FileProvider.e(com.frame.v0.g(), com.frame.v0.g().getPackageName() + ".fileprovider", file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
            strH = com.frame.r0.h(file.getPath());
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uriFromFile);
        intent.setType(strH);
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        if (intent.resolveActivity(com.frame.v0.g().getPackageManager()) != null) {
            com.frame.v0.g().startActivity(intent);
        } else {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.s4
                @Override // java.lang.Runnable
                public final void run() {
                    FloatToast.i("未找到可以处理的应用");
                }
            });
        }
        this.c.Z(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.A;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "发送文件";
    }
}
