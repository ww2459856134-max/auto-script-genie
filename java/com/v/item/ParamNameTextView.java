package com.v.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.v.FlowLayout;
import com.v.NodeListDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParamNameTextView extends TextView implements View.OnClickListener {
    private String c;
    private String d;
    private String e;
    private boolean f;

    public ParamNameTextView(Context context) {
        super(context);
        this.c = "文本输入";
        this.d = "请输入文本";
        this.e = null;
    }

    private void a(Set<String> set) {
        try {
            b(set, v8.m().p());
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        try {
            NodeListDialogView nodeListDialogView = (NodeListDialogView) com.frame.s0.g().f(NodeListDialogView.class);
            if (nodeListDialogView != null) {
                b(set, nodeListDialogView.getTask());
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
        try {
            if (da.B().N() != null) {
                b(set, da.B().N().l());
            }
        } catch (Exception e3) {
            com.frame.k0.r(e3);
        }
    }

    private void b(Set<String> set, Task task) {
        if (task == null) {
            return;
        }
        Set<String> set2 = task.params;
        if (set2 != null) {
            set.addAll(set2);
        }
        if (TextUtils.isEmpty(task.getArgumentJson())) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(task.getArgumentJson());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("key"))) {
                    set.add(jSONObjectOptJSONObject.optString("key"));
                }
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean d(String str) {
        setText(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(String str) {
        setText(str);
        return true;
    }

    static /* synthetic */ void g(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是变量值");
        dingMsgView.h("有的时候我们需要输入的文本是动态的，这时就需要使用到变量值，变量值使用${xx}来表示，比如你要输入的是'我是小白'，而这个'小白'可以通过脚本的变量改变，你就可以新建一个变量为'名字'，然后在这里输入'我是${名字}',之后只要修改'名字'这个变量的值，这句话的内容就会相应的做出改变，如：'名字'='小黑'，这句文本就变成'我是小黑'。更多详情可以私信技术小哥~");
        dingMsgView.i("知道了", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(FlowLayout flowLayout, InputDialogView inputDialogView, String str, View view) {
        if (flowLayout.getTag() != null) {
            ((View) flowLayout.getTag()).setSelected(false);
        }
        flowLayout.setTag(view);
        view.setSelected(true);
        if (this.f) {
            inputDialogView.w(str);
            return;
        }
        inputDialogView.o("${" + str + "}");
    }

    public void j() {
        k(new InputDialogView.a() { // from class: com.v.item.l1
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.f(str);
            }
        });
    }

    public void k(InputDialogView.a aVar) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.w(this.e);
        inputDialogView.l(this.c);
        inputDialogView.s(this.d);
        if (this.f || !TextUtils.isEmpty(getText().toString())) {
            inputDialogView.w(getText().toString());
        }
        final FlowLayout flowLayout = new FlowLayout(com.frame.v0.g());
        flowLayout.setPadding(com.frame.p1.c(20.0f), 0, com.frame.p1.c(20.0f), 0);
        flowLayout.setHorizontalSpacing(com.frame.p1.c(5.0f));
        flowLayout.setVerticalSpacing(com.frame.p1.c(10.0f));
        int iC = com.frame.p1.c(6.0f);
        com.frame.v0 v0VarG = com.frame.v0.g();
        int i2 = j.b.c.f;
        int color = v0VarG.getColor(i2);
        TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(com.frame.v0.g().getResources().getColor(i2));
        if (this.f) {
            textView.setText("已有的变量：");
        } else {
            textView.setText("使用变量的值：");
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(j.b.d.L0, 0, 0, 0);
            textView.setCompoundDrawablePadding(com.frame.p1.c(3.0f));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ParamNameTextView.g(view);
                }
            });
        }
        int i3 = iC / 2;
        textView.setPadding(iC, i3, iC, i3);
        textView.setTextSize(10.0f);
        flowLayout.addView(textView);
        HashSet hashSet = new HashSet(da.B().E());
        a(hashSet);
        if (hashSet.isEmpty()) {
            TextView textView2 = new TextView(com.frame.v0.g());
            textView2.setText("无变量，可先新建变量");
            textView2.setPadding(iC, i3, iC, i3);
            textView2.setTextSize(10.0f);
            textView2.setBackgroundResource(j.b.d.D0);
            textView2.setTextColor(color);
            flowLayout.addView(textView2);
        } else {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                final String str = (String) it.next();
                TextView textView3 = new TextView(com.frame.v0.g());
                textView3.setText(str);
                textView3.setPadding(iC, i3, iC, i3);
                textView3.setTextSize(10.0f);
                textView3.setBackgroundResource(j.b.d.D0);
                textView3.setTextColor(color);
                flowLayout.addView(textView3);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.j1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.i(flowLayout, inputDialogView, str, view);
                    }
                });
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.frame.p1.c(5.0f);
        inputDialogView.b(flowLayout, layoutParams);
        inputDialogView.t(aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k(new InputDialogView.a() { // from class: com.v.item.k1
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.d(str);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this);
    }

    public void setChooseParamNameType() {
        this.f = true;
    }

    public void setInputDefaultValue(String str) {
        this.e = str;
    }

    public void setInputHint(String str) {
        this.d = str;
    }

    public void setInputLabel(String str) {
        this.c = str;
    }

    public ParamNameTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = "文本输入";
        this.d = "请输入文本";
        this.e = null;
    }

    public ParamNameTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = "文本输入";
        this.d = "请输入文本";
        this.e = null;
    }
}
