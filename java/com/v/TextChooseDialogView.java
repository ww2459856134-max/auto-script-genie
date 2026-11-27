package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.TextAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.float_ui.InputDialogView;
import java.util.List;

/* loaded from: classes.dex */
public class TextChooseDialogView extends RelativeLayout implements View.OnClickListener {
    private d c;
    private CheckBox d;
    private TextAdapter e;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                TextChooseDialogView.this.e.c(-1);
            } else {
                if (TextChooseDialogView.this.e.getData().isEmpty()) {
                    return;
                }
                TextChooseDialogView.this.e.c(0);
            }
        }
    }

    class b implements BaseQuickAdapter.OnItemChildClickListener {
        b() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (view.getId() == j.b.e.O0) {
                i.b.i7.p().k().remove(TextChooseDialogView.this.e.getItem(i2));
                TextChooseDialogView.this.e.remove(i2);
                i.b.i7.p().d();
            }
        }
    }

    class c implements BaseQuickAdapter.OnItemClickListener {
        c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            TextChooseDialogView.this.e.c(i2);
            TextChooseDialogView.this.d.setChecked(false);
        }
    }

    public interface d {
        void a(int i2, List<String> list);
    }

    public TextChooseDialogView() {
        this(com.frame.v0.g());
    }

    private View c() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.z0, null);
        viewInflate.findViewById(j.b.e.O0).setVisibility(8);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.v6);
        textView.setText("添加文字");
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
        return viewInflate;
    }

    private void d() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        CheckBox checkBox = (CheckBox) findViewById(j.b.e.K0);
        this.d = checkBox;
        checkBox.setOnCheckedChangeListener(new a());
        this.e = new TextAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.e);
        ((TextView) findViewById(j.b.e.w6)).setText("添加文字");
        findViewById(j.b.e.P).setOnClickListener(this);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        ((TextView) findViewById(i2)).setText("确定");
        this.e.setOnItemChildClickListener(new b());
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText("还未添文案~");
        textView.setGravity(17);
        textView.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.e.addFooterView(c());
        this.e.setOnItemClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean h(String str) {
        this.e.addData(0, (int) str);
        return true;
    }

    public void i() {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(3);
        inputDialogView.s("请输入文案~");
        inputDialogView.l("文本内容");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.yo
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.h(str);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(TextChooseDialogView.class);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(TextChooseDialogView.class);
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(this.e.e(), this.e.getData());
            }
        }
    }

    public void setDefaultData(int i2, List<String> list) {
        this.e.setNewData(list);
        this.e.c(i2);
        this.d.setVisibility(8);
    }

    public void setOnTextChoose(d dVar) {
        this.c = dVar;
    }

    public TextChooseDialogView(Context context) {
        this(context, null);
    }

    public TextChooseDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public void setDefaultData(int i2) {
        this.e.c(i2);
        this.d.setVisibility(8);
    }
}
