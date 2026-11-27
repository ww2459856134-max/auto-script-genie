package com.v;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.TextAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.ItemChooseDialogView;
import com.v.PageScanFloatView;
import com.v.item.FileItem;
import com.v.item.InputSelectItem;
import com.v.item.ParamLabelItem;
import com.v.item.ParamNameTextView;
import com.v.item.RunConditionItem;
import com.v.item.SelectItem;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class TextChooseDialogViewNew extends RelativeLayout implements View.OnClickListener {
    private ParamLabelItem A;
    private RecyclerView C;
    private FileItem D;
    private TextView G;
    private RunConditionItem H;
    private CheckBox I;
    private Task c;
    private TextAdapter d;
    String[] e;
    private Node f;
    private lt g;

    /* renamed from: h, reason: collision with root package name */
    private SelectItem f1066h;

    /* renamed from: i, reason: collision with root package name */
    private SelectItem f1067i;

    /* renamed from: j, reason: collision with root package name */
    private SelectItem f1068j;

    /* renamed from: k, reason: collision with root package name */
    private SelectItem f1069k;
    private InputSelectItem t;

    class a implements SelectItem.a {
        a() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            TextChooseDialogViewNew.this.A.setVisibility(8);
            TextChooseDialogViewNew.this.D.setVisibility(8);
            TextChooseDialogViewNew.this.C.setVisibility(8);
            TextChooseDialogViewNew.this.G.setVisibility(8);
            TextChooseDialogViewNew.this.f1067i.setVisibility(8);
            TextChooseDialogViewNew.this.t.setVisibility(8);
            if (i2 == 0) {
                TextChooseDialogViewNew.this.C.setVisibility(0);
                TextChooseDialogViewNew.this.d.c(0);
                return;
            }
            if (i2 == 1) {
                TextChooseDialogViewNew.this.A.setVisibility(0);
                if (TextChooseDialogViewNew.this.c.params == null) {
                    TextChooseDialogViewNew.this.A.setParamKeys(new HashSet());
                } else {
                    String[] strArr = new String[TextChooseDialogViewNew.this.c.params.size()];
                    TextChooseDialogViewNew textChooseDialogViewNew = TextChooseDialogViewNew.this;
                    textChooseDialogViewNew.e = (String[]) textChooseDialogViewNew.c.params.toArray(strArr);
                    TextChooseDialogViewNew.this.A.setParamKeys(TextChooseDialogViewNew.this.c.params);
                }
                if (!z) {
                    TextChooseDialogViewNew.this.A.setValue(TextChooseDialogViewNew.this.f.arg2);
                    return;
                } else {
                    TextChooseDialogViewNew.this.A.setValue(null);
                    TextChooseDialogViewNew.this.A.d();
                    return;
                }
            }
            if (i2 == 3) {
                TextChooseDialogViewNew.this.C.setVisibility(0);
                TextChooseDialogViewNew.this.d.c(-1);
                return;
            }
            if (i2 == 4) {
                TextChooseDialogViewNew.this.C.setVisibility(0);
                TextChooseDialogViewNew.this.d.c(-3);
                return;
            }
            if (i2 != 5) {
                return;
            }
            TextChooseDialogViewNew.this.D.setVisibility(0);
            if (TextChooseDialogViewNew.this.f.arg2 != null) {
                TextChooseDialogViewNew.this.D.setValue(TextChooseDialogViewNew.this.f.arg2);
            }
            TextChooseDialogViewNew.this.G.setVisibility(0);
            if (TextChooseDialogViewNew.this.f.arg3 == null || TextUtils.isEmpty(TextChooseDialogViewNew.this.f.arg1)) {
                return;
            }
            TextChooseDialogViewNew.this.t.setVisibility(0);
            TextChooseDialogViewNew.this.f1067i.setVisibility(0);
            TextChooseDialogViewNew.this.t.f(TextChooseDialogViewNew.this.f.arg3);
            TextChooseDialogViewNew.this.f1067i.setSelectLabel(TextChooseDialogViewNew.this.f.arg1);
            TextChooseDialogViewNew.this.G.setSelected(true);
        }
    }

    class b implements BaseQuickAdapter.OnItemLongClickListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(int i2, int i3, List list) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            if (i3 == 0) {
                TextChooseDialogViewNew.this.B(i2);
            } else if (i3 == 1) {
                TextChooseDialogViewNew.this.C(i2);
            } else {
                if (i3 != 2) {
                    return;
                }
                TextChooseDialogViewNew.this.E(i2);
            }
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
        public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("复制,编辑,删除".split(","))));
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.ap
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i3, List list) {
                    this.a.b(i2, i3, list);
                }
            });
            return true;
        }
    }

    class c implements PageScanFloatView.b {
        c() {
        }

        @Override // com.v.PageScanFloatView.b
        public void a(int i2, Rect rect, String str, AccessibilityNodeInfo accessibilityNodeInfo) {
            com.frame.s0.g().d(PageScanFloatView.class);
            i.b.v8.m().i0(TextChooseDialogViewNew.this.f, i2, accessibilityNodeInfo);
            TextChooseDialogViewNew.this.I.setEnabled(TextChooseDialogViewNew.this.f.url != null);
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(TextChooseDialogViewNew.class);
        }

        @Override // com.v.PageScanFloatView.b
        public void cancel() {
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(TextChooseDialogViewNew.class);
        }
    }

    public TextChooseDialogViewNew() {
        this(com.frame.v0.g());
    }

    private View k() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.z0, null);
        viewInflate.findViewById(j.b.e.O0).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.v6);
        textView.setText("添加文字");
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.ip
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n(view);
            }
        });
        return viewInflate;
    }

    private void l() {
        View.inflate(com.frame.v0.g(), j.b.f.E, this);
        this.I = (CheckBox) findViewById(j.b.e.q5);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.H = runConditionItem;
        runConditionItem.setAttachView(this);
        findViewById(j.b.e.L0).setOnClickListener(this);
        this.f1069k = (SelectItem) findViewById(j.b.e.n2);
        this.f1068j = (SelectItem) findViewById(j.b.e.W1);
        SelectItem selectItem = (SelectItem) findViewById(j.b.e.B2);
        this.f1066h = selectItem;
        selectItem.setOnItemClick(new a());
        this.A = (ParamLabelItem) findViewById(j.b.e.N2);
        this.D = (FileItem) findViewById(j.b.e.s2);
        this.G = (TextView) findViewById(j.b.e.O);
        this.f1067i = (SelectItem) findViewById(j.b.e.r2);
        this.t = (InputSelectItem) findViewById(j.b.e.e3);
        HashMap<String, String> map = new HashMap<>();
        map.put("逗号", ",");
        map.put("换行", "\n");
        this.t.setMap(map);
        this.d = new TextAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.C = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.C.setAdapter(this.d);
        ((TextView) findViewById(j.b.e.w6)).setText("添加文字");
        findViewById(j.b.e.P).setOnClickListener(this);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        ((TextView) findViewById(i2)).setText("确定");
        this.d.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.fp
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.p(baseQuickAdapter, view, i3);
            }
        });
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText("还未添文案~");
        textView.setGravity(17);
        textView.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.addFooterView(k());
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.zo
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.r(baseQuickAdapter, view, i3);
            }
        });
        this.d.setOnItemLongClickListener(new b());
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.v.cp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.O0) {
            E(i2);
        } else if (view.getId() == j.b.e.k0) {
            C(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (this.d.e() > -1) {
            this.d.c(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View view) {
        view.setSelected(!view.isSelected());
        int i2 = view.isSelected() ? 0 : 8;
        this.f1067i.setVisibility(i2);
        this.t.setVisibility(i2);
        if (view.isSelected()) {
            return;
        }
        Node node = this.f;
        node.arg1 = null;
        node.arg3 = null;
    }

    static /* synthetic */ void u(View view) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(TextChooseDialogViewNew.class);
        com.frame.s0.g().d(DingMsgView.class);
    }

    static /* synthetic */ void v(View view) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(PageScanFloatView.class);
        com.frame.s0.g().u(TextChooseDialogViewNew.class);
    }

    static /* synthetic */ void w() {
        com.frame.s0.g().d(PageScanFloatView.class);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("未找到输入框元素。你可以点击下面，将文字复制到剪切板，然后用点击输入法粘贴输入。");
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.hp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextChooseDialogViewNew.u(view);
            }
        });
        dingMsgView.l("温馨提示");
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("点击这里将文字复制到剪切板");
        textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(10.0f), 0, com.frame.p1.c(2.0f));
        textView.setTextSize(12.0f);
        textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.I0, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.gp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextChooseDialogViewNew.v(view);
            }
        });
        dingMsgView.m(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean y(int i2, String str) {
        this.d.remove(i2);
        this.d.addData(i2, (int) str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean A(String str) {
        this.d.addData(0, (int) str);
        return true;
    }

    public void B(int i2) {
        this.d.addData(0, (int) this.d.getItem(i2));
    }

    public void C(final int i2) {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setInputHint("请输入文案~");
        paramNameTextView.setInputLabel("文本内容");
        paramNameTextView.setText(this.d.getItem(i2));
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.bp
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.y(i2, str);
            }
        });
    }

    public void D() {
        ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
        paramNameTextView.setInputHint("请输入文案~");
        paramNameTextView.setInputLabel("文本内容");
        paramNameTextView.k(new InputDialogView.a() { // from class: com.v.dp
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.A(str);
            }
        });
    }

    public void E(int i2) {
        i.b.i7.p().k().remove(this.d.getItem(i2));
        this.d.remove(i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(TextChooseDialogViewNew.class);
            return;
        }
        if (id == j.b.e.L0) {
            com.frame.s0.g().i(NodeListDialogView.class);
            com.frame.s0.g().i(FlowView.class);
            com.frame.s0.g().i(TextChooseDialogViewNew.class);
            MultiGestureRecordFloatView.E();
            FloatToast.g(j.b.d.P, "请从屏幕上选择输入框");
            i.b.da.B().B1("textinput.mp4");
            PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
            pageScanFloatView.setOnNoFindCallback(new Runnable() { // from class: com.v.ep
                @Override // java.lang.Runnable
                public final void run() {
                    TextChooseDialogViewNew.w();
                }
            });
            pageScanFloatView.f(new c());
            return;
        }
        if (id == j.b.e.g) {
            this.f.text = this.f1066h.getSelectLabel();
            this.f.arg4 = this.f1068j.getSelectLabel();
            this.f.argInt1 = ((Integer) this.f1069k.getValue()).intValue();
            if (!"从剪切板粘贴".equals(this.f.text)) {
                if ("从变量取值输入".equals(this.f.text)) {
                    if (TextUtils.isEmpty(this.A.getValue().toString())) {
                        this.A.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    } else {
                        this.f.arg2 = this.A.getValue().toString();
                    }
                } else if ("从文件中获取文字输入".equals(this.f.text)) {
                    if (TextUtils.isEmpty(this.D.getValue())) {
                        this.D.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                    this.f.arg2 = this.D.getValue();
                    if (!this.G.isSelected()) {
                        Node node = this.f;
                        node.arg3 = null;
                        node.arg1 = null;
                    } else {
                        if (this.t.getValue() == null || TextUtils.isEmpty(this.t.getValue().toString())) {
                            this.t.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                            return;
                        }
                        if (this.f1067i.getValue() == null || TextUtils.isEmpty(this.f1067i.getValue().toString())) {
                            this.f1067i.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                            return;
                        }
                        this.f.arg3 = this.t.getValue().toString();
                        this.f.arg1 = this.f1067i.getSelectLabel();
                    }
                } else {
                    if (this.d.getData().isEmpty()) {
                        this.C.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                        return;
                    }
                    this.f.what = this.d.e();
                    this.f.arg1 = TextUtils.join("&&", this.d.getData());
                }
            }
            this.f.textInputPackageMatch = Boolean.valueOf(this.I.isChecked());
            com.frame.s0.g().d(TextChooseDialogViewNew.class);
            lt ltVar = this.g;
            if (ltVar != null) {
                ltVar.a(this.f);
            }
        }
    }

    public void setDefaultData(int i2, List<String> list) {
        this.d.setNewData(list);
        this.d.c(i2);
    }

    public void setNodeCallback(lt ltVar) {
        this.g = ltVar;
    }

    public void setTaskNode(Task task, Node node) {
        this.c = task;
        this.f = node;
        this.I.setChecked(node.isTextInputPackageMatchEnabled());
        this.I.setEnabled(node.url != null);
        this.H.setTaskNode(task, node);
        this.f1066h.setSelectLabel(node.text);
        this.f1068j.setSelectLabel(this.f.arg4);
        this.f1069k.setSelectValue(Integer.valueOf(this.f.argInt1));
        if (this.f.arg1 != null) {
            this.d.setNewData(new ArrayList(Arrays.asList(this.f.arg1.split("&&"))));
        }
    }

    public TextChooseDialogViewNew(Context context) {
        this(context, null);
    }

    public TextChooseDialogViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l();
    }

    public void setDefaultData(int i2) {
        this.d.c(i2);
    }
}
