package com.v;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.OptionSectionAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.model.Node;
import com.yl.model.OptionCategory;
import com.yl.ui.BottomImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class OptionListDialogView extends RelativeLayout implements BaseQuickAdapter.OnItemLongClickListener, BaseQuickAdapter.OnItemClickListener, View.OnClickListener, View.OnLongClickListener {
    private lt c;
    private RecyclerView d;
    private TextView e;
    private OptionSectionAdapter f;
    boolean g;

    class a implements Comparator<i.b.ka.x5> {
        a(OptionListDialogView optionListDialogView) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i.b.ka.x5 x5Var, i.b.ka.x5 x5Var2) {
            return x5Var.q().hashCode() - x5Var2.q().hashCode();
        }
    }

    class b extends RecyclerView.n {
        final /* synthetic */ int a;

        b(OptionListDialogView optionListDialogView, int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2 = this.a;
            rect.left = i2;
            rect.right = i2;
            rect.bottom = i2;
            rect.top = i2;
        }
    }

    public OptionListDialogView() {
        this(com.frame.v0.g());
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, i.b.ka.x5] */
    private void b() {
        View.inflate(com.frame.v0.g(), j.b.f.P, this);
        setGravity(17);
        HashMap<Integer, i.b.ka.x5> mapC = i.b.x7.d().c();
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.d = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 3));
        ArrayList arrayList = new ArrayList(mapC.values());
        arrayList.sort(new a(this));
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ?? r3 = (i.b.ka.x5) it.next();
            if (map.containsKey(r3.q())) {
                OptionCategory optionCategory = new OptionCategory(false, r3.q());
                optionCategory.t = r3;
                arrayList2.add(optionCategory);
            } else {
                OptionCategory optionCategory2 = new OptionCategory(true, r3.q());
                map.put(r3.q(), optionCategory2);
                arrayList2.add(optionCategory2);
                OptionCategory optionCategory3 = new OptionCategory(false, r3.q());
                optionCategory3.t = r3;
                arrayList2.add(optionCategory3);
            }
        }
        OptionSectionAdapter optionSectionAdapter = new OptionSectionAdapter(arrayList2);
        this.f = optionSectionAdapter;
        this.d.setAdapter(optionSectionAdapter);
        this.d.g(new b(this, com.frame.p1.c(2.0f)));
        this.f.setOnItemLongClickListener(this);
        this.f.setOnItemClickListener(this);
        TextView textView = (TextView) findViewById(j.b.e.g);
        this.e = textView;
        textView.setOnClickListener(this);
        findViewById(j.b.e.s0).setOnClickListener(this);
        findViewById(j.b.e.P).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Node node) {
        this.c.a(node);
    }

    private void e(final Node node) {
        if (this.c != null) {
            com.frame.l1.e(new Runnable() { // from class: com.v.fi
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.d(node);
                }
            });
        }
    }

    public void a(int i2) {
        i.b.ka.x5 x5VarE = i.b.x7.d().e(i2);
        if (x5VarE != null) {
            x5VarE.R(0, this.c);
        } else {
            i.b.da.B().w1("未找到录制操作...");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.s0) {
            ((BottomImageView) com.frame.s0.g().x(BottomImageView.class)).b("file:///android_asset/help_toolbar.webp");
            return;
        }
        if (id == j.b.e.P) {
            com.frame.s0.g().d(OptionListDialogView.class);
            e(null);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(OptionListDialogView.class);
            e(null);
            if (this.g) {
                com.frame.n0.k("optToolBar", TextUtils.join(",", this.f.e()));
                FloatHandlerRecord floatHandlerRecord = (FloatHandlerRecord) com.frame.s0.g().u(FloatHandlerRecord.class);
                if (floatHandlerRecord != null) {
                    floatHandlerRecord.v();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        i.b.ka.x5 x5Var;
        if (this.f.getItem(i2) == 0 || (x5Var = (i.b.ka.x5) ((OptionCategory) this.f.getItem(i2)).t) == null) {
            return;
        }
        int iB = x5Var.B();
        if (this.g) {
            this.f.g(iB);
        } else {
            com.frame.s0.g().d(OptionListDialogView.class);
            a(iB);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        setOptionToolBarConfig(true);
        return true;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getTag() != null) {
            setOptionToolBarConfig(true);
        }
        return true;
    }

    public void setCallback(lt ltVar) {
        this.c = ltVar;
    }

    public void setOptionToolBarConfig(boolean z) {
        this.e.setText("添加至工具条");
        this.g = true;
        String[] strArrSplit = com.frame.n0.f("optToolBar", "3,4,10,19").split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : strArrSplit) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(Integer.valueOf(str));
            }
        }
        this.f.f(arrayList);
        this.f.notifyDataSetChanged();
    }

    public OptionListDialogView(Context context) {
        this(context, null);
    }

    public OptionListDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
