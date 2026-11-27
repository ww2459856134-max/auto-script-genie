package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.item.InputItem;
import com.v.item.ParamNameTextView;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;

/* loaded from: classes.dex */
public class PageScrollDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    protected TextView d;
    protected TextView e;
    private SelectItem f;
    private SelectItem g;

    /* renamed from: h, reason: collision with root package name */
    private SelectItem f1028h;

    /* renamed from: i, reason: collision with root package name */
    private InputItem f1029i;

    /* renamed from: j, reason: collision with root package name */
    private Node f1030j;

    class a implements SelectItem.a {
        a() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if ("滚动到第n条".equals(str)) {
                PageScrollDialogView.this.f1029i.setVisibility(8);
                PageScrollDialogView.this.f1028h.setSelectSubLabel("0");
            } else if ("每次递进一条".equals(str)) {
                PageScrollDialogView.this.f1029i.setVisibility(0);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputLabel("滚动条数/变量");
            paramNameTextView.setInputHint("请输入滚动条数/变量");
            paramNameTextView.setInputDefaultValue(PageScrollDialogView.this.f1028h.getSelectSubLabel());
            paramNameTextView.k(new mt(this));
        }
    }

    class c implements SelectItem.a {
        c() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            PageScrollDialogView.this.f1029i.setVisibility(8);
            if ("滚动一条".equals(str)) {
                PageScrollDialogView.this.f.setVisibility(8);
                PageScrollDialogView.this.f1028h.setVisibility(0);
            } else {
                PageScrollDialogView.this.f.setVisibility(0);
                PageScrollDialogView.this.f1028h.setVisibility(8);
            }
        }
    }

    public PageScrollDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.Q, (ViewGroup) this, true);
        this.e = (TextView) findViewById(j.b.e.g);
        this.d = (TextView) findViewById(j.b.e.P);
        this.f1029i = (InputItem) findViewById(j.b.e.R2);
        SelectItem selectItem = (SelectItem) findViewById(j.b.e.W2);
        this.g = selectItem;
        selectItem.setSelectLabel("滚动一页");
        SelectItem selectItem2 = (SelectItem) findViewById(j.b.e.Q2);
        this.f1028h = selectItem2;
        selectItem2.setSelectLabel("每次递进一条");
        SelectItem selectItem3 = (SelectItem) findViewById(j.b.e.l2);
        this.f = selectItem3;
        selectItem3.setSelectLabel("向下翻页");
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.zi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(PageScrollDialogView.class);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.yi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        com.frame.s0.g().d(PageScrollDialogView.class);
        com.frame.s0.g().o(this);
        String selectLabel = this.f.getSelectLabel();
        if ("向下翻页".equals(selectLabel)) {
            this.f1030j.arg1 = "0";
        } else if ("向上翻页".equals(selectLabel)) {
            this.f1030j.arg1 = "1";
        } else if ("向左翻页".equals(selectLabel)) {
            this.f1030j.arg1 = "2";
        } else if ("向右翻页".equals(selectLabel)) {
            this.f1030j.arg1 = "3";
        }
        this.f1030j.arg2 = this.g.getSelectLabel();
        if ("滚动一条".equals(this.f1030j.arg2)) {
            if ("每次递进一条".equals(this.f1028h.getSelectLabel())) {
                Node node = this.f1030j;
                node.arg3 = null;
                node.arg4 = this.f1029i.getValue();
            } else {
                this.f1030j.arg3 = this.f1028h.getSelectSubLabel();
                this.f1029i.setVisibility(8);
            }
        }
        lt ltVar = this.c;
        if (ltVar != null) {
            ltVar.a(this.f1030j);
        }
    }

    public PageScrollDialogView g(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    public PageScrollDialogView h(Task task, Node node) {
        this.f1030j = node;
        this.f1028h.setOnItemClick(new a());
        this.f1028h.setOnSubClickListener(new b());
        this.g.setOnItemClick(new c());
        if ("0".equals(this.f1030j.arg1)) {
            this.f.setSelectLabel("向下翻页");
        } else if ("1".equals(this.f1030j.arg1)) {
            this.f.setSelectLabel("向上翻页");
        } else if ("2".equals(this.f1030j.arg1)) {
            this.f.setSelectLabel("向左翻页");
        } else if ("3".equals(this.f1030j.arg1)) {
            this.f.setSelectLabel("向右翻页");
        } else {
            this.f.setSelectLabel("向下翻页");
        }
        this.g.setSelectLabel(this.f1030j.arg2);
        if ("滚动一条".equals(this.f1030j.arg2)) {
            if (TextUtils.isEmpty(this.f1030j.arg3)) {
                this.f1028h.setSelectLabel("每次递进一条");
                this.f1029i.setValue(this.f1030j.arg4);
            } else {
                this.f1028h.setSelectLabel("滚动到第n条");
                this.f1028h.setSelectSubLabel(this.f1030j.arg3);
            }
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }
}
