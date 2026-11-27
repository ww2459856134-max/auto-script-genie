package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import com.v.item.InputItem;
import com.v.item.KeyValueItem;
import com.v.item.ParamLabelItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes.dex */
public class ApiDialogView extends RelativeLayout implements View.OnClickListener {
    private TextView A;
    private SelectAndDelayItem C;
    private InputItem D;
    private RunConditionItem G;
    private lt c;
    private Task d;
    private Node e;
    private InputItem f;
    private InputItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectItem f903h;

    /* renamed from: i, reason: collision with root package name */
    private SelectItem f904i;

    /* renamed from: j, reason: collision with root package name */
    private KeyValueItem f905j;

    /* renamed from: k, reason: collision with root package name */
    private KeyValueItem f906k;
    private ParamLabelItem t;

    class a implements SelectItem.a {
        a() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if (!Constants.HTTP_POST.equalsIgnoreCase(str)) {
                ApiDialogView.this.f904i.setVisibility(8);
                ApiDialogView.this.g.setVisibility(8);
                ApiDialogView.this.f905j.setVisibility(8);
                ApiDialogView.this.f906k.setVisibility(8);
                return;
            }
            ApiDialogView.this.f904i.setVisibility(0);
            ApiDialogView.this.f906k.setVisibility(0);
            if (ApiDialogView.this.f904i.getValue() == null || ((Integer) ApiDialogView.this.f904i.getValue()).intValue() == 0) {
                ApiDialogView.this.f905j.setVisibility(0);
                ApiDialogView.this.g.setVisibility(8);
            } else {
                ApiDialogView.this.f905j.setVisibility(8);
                ApiDialogView.this.g.setVisibility(0);
            }
        }
    }

    class b implements SelectItem.a {
        b() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if (obj.equals(0)) {
                ApiDialogView.this.g.setVisibility(8);
                ApiDialogView.this.f905j.setVisibility(0);
            } else {
                ApiDialogView.this.g.setVisibility(0);
                ApiDialogView.this.f905j.setVisibility(8);
            }
        }
    }

    public ApiDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f1757h, (ViewGroup) this, true);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.G = runConditionItem;
        runConditionItem.setAttachView(this);
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.g).setOnClickListener(this);
        this.C = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.D = (InputItem) findViewById(j.b.e.p4);
        this.C.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.c1
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.k();
            }
        });
        this.C.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.a1
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.m();
            }
        });
        this.C.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.w0
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.o(str, str2);
            }
        });
        this.f904i = (SelectItem) findViewById(j.b.e.h2);
        this.t = (ParamLabelItem) findViewById(j.b.e.O2);
        this.g = (InputItem) findViewById(j.b.e.F2);
        this.f = (InputItem) findViewById(j.b.e.m3);
        this.f903h = (SelectItem) findViewById(j.b.e.J2);
        KeyValueItem keyValueItem = (KeyValueItem) findViewById(j.b.e.P2);
        this.f905j = keyValueItem;
        keyValueItem.setBtnAddName("添加参数（params）");
        KeyValueItem keyValueItem2 = (KeyValueItem) findViewById(j.b.e.w2);
        this.f906k = keyValueItem2;
        keyValueItem2.setBtnAddName("添加请求头（headers）");
        TextView textView = (TextView) findViewById(j.b.e.I);
        this.A = textView;
        textView.setOnClickListener(this);
        this.f903h.setOnItemClick(new a());
        this.f904i.setOnItemClick(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Exception exc) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(exc.getMessage());
    }

    private void D(String str) {
        List<String> value = this.f905j.getValue();
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        for (String str2 : value) {
            arrayList.add(new BasicNameValuePair(str2.split("=")[0], str2.split("=")[1]));
        }
        try {
            final String strQ = com.frame.p0.h().q(str, arrayList, null);
            com.frame.l1.e(new Runnable() { // from class: com.v.t0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w(strQ);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.v.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.y(e);
                }
            });
        }
    }

    private void E(String str, String str2) {
        try {
            final String strX = com.frame.p0.h().x(str, str2, null);
            com.frame.l1.e(new Runnable() { // from class: com.v.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.A(strX);
                }
            });
        } catch (Exception e) {
            try {
                com.frame.k0.r(e);
                com.frame.l1.e(new Runnable() { // from class: com.v.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.C(e);
                    }
                });
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    private void e(String str) throws Throwable {
        try {
            final String strD = com.frame.p0.h().d(str);
            com.frame.l1.e(new Runnable() { // from class: com.v.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g(strD);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.v.v0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.i(e);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Exception exc) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String k() {
        return this.e.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String m() {
        return this.e.errorMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(String str, String str2) {
        Node node = this.e;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        this.D.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        FloatToast.i("请输入正确的超时时间");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        this.c.a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(String str) throws Throwable {
        if (!Constants.HTTP_POST.equals(this.f903h.getSelectLabel()) && !TextUtils.isEmpty(this.f903h.getSelectLabel())) {
            if (Constants.HTTP_GET.equals(this.f903h.getSelectLabel())) {
                e(str);
            }
        } else {
            if ((this.f904i.getValue() == null ? 0 : ((Integer) this.f904i.getValue()).intValue()) == 0) {
                D(str);
            } else {
                E(str, this.g.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(Exception exc) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String str) {
        this.A.setText("api结果（点击可重新发起请求）：");
        this.A.append("\n");
        this.A.append(str);
    }

    public ApiDialogView F(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    public LinkedHashMap<String, Object> getNodeListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Long l2 : this.d.getNodeMap().keySet()) {
            Node node = this.d.getNodeMap().get(l2);
            if (node != null) {
                linkedHashMap.put(node.getStepAndName(), l2);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getParamListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        Set<String> set = this.d.params;
        if (set != null) {
            for (String str : set) {
                linkedHashMap.put(str, str);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, Object> getTaskListMap() {
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (TaskSimple taskSimple : i.b.da.B().C()) {
            linkedHashMap.put(taskSimple.getName(), Long.valueOf(taskSimple.getId()));
        }
        return linkedHashMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (view.getId() != j.b.e.g) {
            if (view.getId() == j.b.e.P) {
                com.frame.s0.g().o(this);
                return;
            }
            if (view.getId() == j.b.e.I) {
                final String strG = i.b.da.B().G(this.f.getValue().toString());
                if (TextUtils.isEmpty(strG)) {
                    this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                } else {
                    com.frame.l1.g(new Runnable() { // from class: com.v.x0
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            this.c.u(strG);
                        }
                    });
                    return;
                }
            }
            return;
        }
        String strTrim = this.f.getValue() == null ? "" : this.f.getValue().toString().trim();
        if (strTrim.regionMatches(true, 0, "http://", 0, 7)) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.t("温馨提示");
            aVar.j("API地址仅支持HTTPS，请使用HTTPS地址");
            aVar.r("知道了", null);
            aVar.e().show();
            return;
        }
        if (TextUtils.isEmpty(strTrim) || !(strTrim.regionMatches(true, 0, "https://", 0, 8) || strTrim.contains("${"))) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        this.e.arg1 = this.f903h.getSelectLabel();
        Node node = this.e;
        node.url = strTrim;
        node.arg3 = this.t.getValue().toString();
        this.e.what = this.f904i.getValue() == null ? 0 : ((Integer) this.f904i.getValue()).intValue();
        Node node2 = this.e;
        if (node2.what == 1) {
            node2.arg2 = this.g.getValue();
        } else {
            node2.arg2 = TextUtils.join("&", this.f905j.getValue());
        }
        this.e.arg4 = TextUtils.join("&", this.f906k.getValue());
        try {
            long j2 = Long.parseLong(this.D.getValue());
            if (this.C.getVisibility() == 0) {
                if (!this.C.c()) {
                    return;
                }
                this.e.errorType = ((Integer) this.C.getValue()).intValue();
                if (this.C.getSubValue() != null) {
                    this.e.errorId = ((Long) this.C.getSubValue()).longValue();
                }
            }
            this.e.timeOut = j2;
            com.frame.s0.g().d(ApiDialogView.class);
            post(new Runnable() { // from class: com.v.y0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.s();
                }
            });
        } catch (Exception unused) {
            com.frame.l1.e(new Runnable() { // from class: com.v.b1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.q();
                }
            });
        }
    }

    public void setTaskNode(Task task, Node node) {
        this.d = task;
        this.e = node;
        this.t.setParamKeys(task.params);
        this.G.setTaskNode(task, node);
        this.f903h.setSelectLabel(this.e.arg1);
        this.f.setValue(this.e.url);
        this.t.setValue(this.e.arg3);
        this.D.setValue(this.e.timeOut + "");
        if (!Constants.HTTP_GET.equalsIgnoreCase(this.f903h.getSelectLabel())) {
            this.f904i.setSelectValue(Integer.valueOf(this.e.what));
            Node node2 = this.e;
            if (node2.what == 1) {
                this.g.setValue(node2.arg2);
                if (!TextUtils.isEmpty(this.e.arg4)) {
                    this.f906k.setValue(new ArrayList(Arrays.asList(this.e.arg4.split("&"))));
                }
            } else {
                if (!TextUtils.isEmpty(node2.arg2)) {
                    this.f905j.setValue(new ArrayList(Arrays.asList(this.e.arg2.split("&"))));
                }
                if (!TextUtils.isEmpty(this.e.arg4)) {
                    this.f906k.setValue(new ArrayList(Arrays.asList(this.e.arg4.split("&"))));
                }
            }
        }
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put("跳转任务", null);
            linkedHashMap.put("点击后跳任务", null);
            linkedHashMap.put("跳转节点", null);
            linkedHashMap.put("点击后跳节点", null);
            LinkedHashMap<String, Object> paramListMap = getParamListMap();
            linkedHashMap.put("将文本给变量", paramListMap);
            linkedHashMap.put("将坐标给变量", paramListMap);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("弹窗报错", -2);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.C.setItems(linkedHashMap2, linkedHashMap);
        this.C.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.C;
        selectAndDelayItem.setOnItemClick(new com.v.item.j2(this.d, this.e, selectAndDelayItem));
        this.C.setSelectValue(Integer.valueOf(node.errorType));
    }
}
