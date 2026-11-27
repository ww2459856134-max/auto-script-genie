package com.v;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ClickConfigAdapter;
import com.v.ItemChooseDialogView;
import com.v.item.CoordItem;
import com.v.item.RunConditionItem;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ClickConfigDialogView extends RelativeLayout implements View.OnClickListener {
    private lt c;
    protected TextView d;
    protected TextView e;
    private CoordItem f;
    private RecyclerView g;

    /* renamed from: h, reason: collision with root package name */
    private ClickConfigAdapter f918h;

    /* renamed from: i, reason: collision with root package name */
    private RunConditionItem f919i;

    /* renamed from: j, reason: collision with root package name */
    private Node f920j;

    public ClickConfigDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f1764o, (ViewGroup) this, true);
        this.d = (TextView) findViewById(j.b.e.P);
        this.e = (TextView) findViewById(j.b.e.g);
        this.f = (CoordItem) findViewById(j.b.e.i2);
        this.g = (RecyclerView) findViewById(j.b.e.O4);
        this.f918h = new ClickConfigAdapter(null);
        this.g.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        this.g.setAdapter(this.f918h);
        this.g.setVisibility(8);
        this.f918h.addFooterView(a());
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.f919i = runConditionItem;
        runConditionItem.setAttachView(this);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.v.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(ClickConfigDialogView.class);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.v.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.f(view);
            }
        });
    }

    private View a() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClickConfigDialogView.c(view);
            }
        });
        return viewInflate;
    }

    static /* synthetic */ void c(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择坐标");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("是否包含图片,是否包含控件,是否包含颜色,是否变量为真,是否包含图集,是否包含文字".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.z2
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                com.frame.s0.g().d(ItemChooseDialogView.class);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        if (TextUtils.isEmpty(this.f.getParamName())) {
            this.f920j.text = null;
            Point value = this.f.getValue();
            if (value == null) {
                FloatToast.i("请选择坐标");
                this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            } else {
                this.f920j.pathPoints = new ArrayList<>();
                this.f920j.pathPoints.add(Integer.valueOf(value.x));
                this.f920j.pathPoints.add(Integer.valueOf(value.y));
            }
        } else {
            this.f920j.text = this.f.getParamName();
            this.f920j.pathPoints = null;
        }
        com.frame.s0.g().d(ClickConfigDialogView.class);
        lt ltVar = this.c;
        if (ltVar != null) {
            ltVar.a(this.f920j);
        }
    }

    private ClickConfigDialogView h(String str) {
        this.f.l(str);
        return this;
    }

    private ClickConfigDialogView i(Point point) {
        this.f.setValue(point);
        return this;
    }

    public ClickConfigDialogView g(lt ltVar) {
        this.c = ltVar;
        return this;
    }

    public ClickConfigDialogView j(Task task, Node node) {
        this.f920j = node;
        this.f919i.setTaskNode(task, node);
        if (TextUtils.isEmpty(node.text)) {
            i(new Point(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue()));
        } else {
            h(node.text);
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }
}
