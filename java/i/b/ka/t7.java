package i.b.ka;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.v.lt;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.t9;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class t7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean U(Node node, lt ltVar, String str) {
        node.url = str;
        v8.m().X(node);
        Q(ltVar, node);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean W(Node node, lt ltVar, String str) {
        node.url = str;
        node.delay = "500";
        v8.m().X(node);
        Q(ltVar, node);
        new t9(v8.m().p()).t(node, null);
        return true;
    }

    @Override // i.b.ka.x5
    public int B() {
        return 28;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, final lt ltVar) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.w(node.url);
        inputDialogView.l("启动微信小程序");
        inputDialogView.s("请输入账号原始ID");
        inputDialogView.t(new InputDialogView.a() { // from class: i.b.ka.p5
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.U(node, ltVar, str);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        nodeQ.type = 28;
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("启动微信小程序");
        inputDialogView.s("请输入账号原始ID");
        inputDialogView.t(new InputDialogView.a() { // from class: i.b.ka.q5
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.W(nodeQ, ltVar, str);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(com.frame.v0.g(), com.frame.k0.e);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = node.url;
        req.miniprogramType = 0;
        iwxapiCreateWXAPI.sendReq(req);
        this.c.W(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.n0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "微信小程序";
    }
}
