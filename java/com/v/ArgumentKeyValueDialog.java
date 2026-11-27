package com.v;

import android.content.DialogInterface;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.v.ItemChooseDialogView;
import com.v.item.FileItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ArgumentKeyValueDialog extends DingMsgView implements View.OnClickListener {
    private EditText A;
    private EditText C;
    private EditText D;
    private TextView G;
    private TextView H;
    private TextView I;
    private FileItem J;
    private a K;

    /* renamed from: h, reason: collision with root package name */
    private View f911h;

    /* renamed from: i, reason: collision with root package name */
    private View f912i;

    /* renamed from: j, reason: collision with root package name */
    private View f913j;

    /* renamed from: k, reason: collision with root package name */
    private View f914k;
    private View t;

    public interface a {
        void a(JSONObject jSONObject);
    }

    public ArgumentKeyValueDialog() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.f1758i, null);
        this.H = (TextView) viewInflate.findViewById(j.b.e.b);
        this.I = (TextView) viewInflate.findViewById(j.b.e.N4);
        this.C = (EditText) viewInflate.findViewById(j.b.e.K1);
        this.D = (EditText) viewInflate.findViewById(j.b.e.H1);
        this.G = (TextView) viewInflate.findViewById(j.b.e.D);
        this.A = (EditText) viewInflate.findViewById(j.b.e.G1);
        this.f911h = viewInflate.findViewById(j.b.e.a4);
        this.f912i = viewInflate.findViewById(j.b.e.V3);
        this.f913j = viewInflate.findViewById(j.b.e.R3);
        this.f914k = viewInflate.findViewById(j.b.e.g4);
        this.t = viewInflate.findViewById(j.b.e.X3);
        this.J = (FileItem) viewInflate.findViewById(j.b.e.N1);
        a(viewInflate);
        this.f913j.setOnClickListener(new View.OnClickListener() { // from class: com.v.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.s(view);
            }
        });
        this.f914k.setOnClickListener(new View.OnClickListener() { // from class: com.v.w1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.w(view);
            }
        });
        i("取消", new View.OnClickListener() { // from class: com.v.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(ArgumentKeyValueDialog.class);
            }
        });
        k("确定", new View.OnClickListener() { // from class: com.v.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                this.c.z(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.v.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.D(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        String str = (String) list.get(i2);
        E(str);
        this.G.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("数字");
        arrayList.add("文字");
        arrayList.add("单选");
        arrayList.add("多选");
        arrayList.add("区域");
        arrayList.add("坐标");
        arrayList.add("文件路径");
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("参数类型");
        itemChooseDialogView.setDefaultData(arrayList.indexOf(this.G.getText().toString()), arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.v1
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.B(i2, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(RectChooseView rectChooseView, View view) {
        this.H.setText(Node.getStringByRect(rectChooseView.getRect()));
        com.frame.s0.g().d(RectChooseView.class);
        com.frame.s0.g().u(ArgumentDialogView.class);
        com.frame.s0.g().u(ArgumentKeyValueDialog.class);
    }

    static /* synthetic */ void q(DialogInterface dialogInterface) {
        com.frame.s0.g().d(RectChooseView.class);
        com.frame.s0.g().u(ArgumentDialogView.class);
        com.frame.s0.g().u(ArgumentKeyValueDialog.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) {
        com.frame.s0.g().i(ArgumentDialogView.class);
        com.frame.s0.g().i(ArgumentKeyValueDialog.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setHit("滑动选取区域");
        String string = this.H.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            rectChooseView.setRect(Node.getRectByString(string));
        }
        rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.p(rectChooseView, view2);
            }
        });
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.x1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ArgumentKeyValueDialog.q(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(MultiClickChooseView multiClickChooseView, View view) {
        com.frame.s0.g().u(ArgumentDialogView.class);
        com.frame.s0.g().u(ArgumentKeyValueDialog.class);
        this.I.setText(Node.getStringByPoint(multiClickChooseView.getPoint()));
        com.frame.s0.g().d(MultiClickChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(View view) {
        com.frame.s0.g().i(ArgumentDialogView.class);
        com.frame.s0.g().i(ArgumentKeyValueDialog.class);
        final MultiClickChooseView multiClickChooseView = (MultiClickChooseView) com.frame.s0.g().x(MultiClickChooseView.class);
        if (!TextUtils.isEmpty(this.I.getText())) {
            Point pointByString = Node.getPointByString(this.I.getText().toString());
            multiClickChooseView.setDefaultPoint(pointByString.x, pointByString.y);
        }
        multiClickChooseView.setOnClickListener(new View.OnClickListener() { // from class: com.v.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.u(multiClickChooseView, view2);
            }
        });
        multiClickChooseView.setHit("请选择坐标");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(View view) throws JSONException {
        if (this.K != null) {
            if (TextUtils.isEmpty(this.D.getText().toString())) {
                this.D.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            if (this.f913j.getVisibility() == 0 && TextUtils.isEmpty(this.H.getText().toString())) {
                this.H.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            if (TextUtils.isEmpty(this.G.getText().toString())) {
                this.G.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            if (this.f911h.getVisibility() == 0 && TextUtils.isEmpty(this.A.getText().toString())) {
                this.A.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            com.frame.s0.g().d(ArgumentKeyValueDialog.class);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key", this.D.getText().toString());
                if (this.f912i.getVisibility() == 0) {
                    jSONObject.put("value", this.C.getText().toString());
                } else if (this.f913j.getVisibility() == 0) {
                    jSONObject.put("value", this.H.getText().toString());
                } else if (this.f914k.getVisibility() == 0) {
                    jSONObject.put("value", this.I.getText().toString());
                } else if (this.t.getVisibility() == 0) {
                    jSONObject.put("value", this.J.getValue());
                }
                jSONObject.put("option", this.G.getText().toString());
                jSONObject.put("items", this.A.getText().toString());
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            this.K.a(jSONObject);
        }
    }

    public void E(String str) {
        if ("数字".equals(str)) {
            this.C.setInputType(8194);
        } else {
            this.C.setInputType(1);
        }
        if ("单选".equals(str) || "多选".equals(str)) {
            this.f911h.setVisibility(0);
        } else {
            this.f911h.setVisibility(8);
        }
        if ("区域".equals(str)) {
            this.f912i.setVisibility(8);
            this.f914k.setVisibility(8);
            this.f913j.setVisibility(0);
            return;
        }
        if ("坐标".equals(str)) {
            this.f912i.setVisibility(8);
            this.f913j.setVisibility(8);
            this.f914k.setVisibility(0);
            this.t.setVisibility(8);
            return;
        }
        if ("文件路径".equals(str)) {
            this.f912i.setVisibility(8);
            this.f913j.setVisibility(8);
            this.f914k.setVisibility(8);
            this.t.setVisibility(0);
            return;
        }
        this.f912i.setVisibility(0);
        this.f914k.setVisibility(8);
        this.f913j.setVisibility(8);
        this.t.setVisibility(8);
    }

    public ArgumentKeyValueDialog F(a aVar) {
        this.K = aVar;
        return this;
    }

    @Override // com.yl.float_ui.DingMsgView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    public void setDefault(JSONObject jSONObject) {
        this.C.setText(jSONObject.optString("value"));
        this.D.setText(jSONObject.optString("key"));
        this.A.setText(jSONObject.optString("items"));
        this.G.setText(jSONObject.optString("option"));
        this.H.setText(jSONObject.optString("value"));
        this.I.setText(jSONObject.optString("value"));
        this.J.setValue(jSONObject.optString("value"));
        E(this.G.getText().toString());
    }
}
