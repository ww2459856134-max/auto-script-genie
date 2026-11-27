package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.CalculateDialogView;
import com.v.ItemChooseDialogView;
import com.v.item.ParamNameTextView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CalculateDialogView extends RelativeLayout {
    private ViewGroup c;
    private c d;

    class a implements View.OnClickListener {
        a() {
        }

        static /* synthetic */ boolean a(EditText editText, String str) {
            editText.setText(str);
            return true;
        }

        static /* synthetic */ void b(final EditText editText, View view) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入值~");
            paramNameTextView.setInputLabel("请输入值");
            paramNameTextView.setText(editText.getText().toString());
            paramNameTextView.k(new InputDialogView.a() { // from class: com.v.l2
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return CalculateDialogView.a.a(editText, str);
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CalculateDialogView.this.c != null) {
                CalculateDialogView.this.c.setBackgroundResource(j.b.d.e);
                CalculateDialogView.this.c.setSelected(false);
                if (CalculateDialogView.this.c.getChildCount() != 1) {
                    if (CalculateDialogView.this.c.getChildCount() > 3) {
                        CalculateDialogView.this.c.getChildAt(1).setVisibility(8);
                        TextView textView = (TextView) CalculateDialogView.this.c.getChildAt(2);
                        textView.setEnabled(false);
                        textView.setVisibility(8);
                        textView.setText((CharSequence) null);
                        TextView textView2 = (TextView) CalculateDialogView.this.c.getChildAt(3);
                        textView2.setEnabled(false);
                        textView2.setVisibility(8);
                        textView2.setText((CharSequence) null);
                    } else {
                        TextView textView3 = (TextView) CalculateDialogView.this.c.getChildAt(1);
                        textView3.setEnabled(false);
                        textView3.setVisibility(8);
                        textView3.setText((CharSequence) null);
                        CalculateDialogView.this.c.getChildAt(2).setVisibility(8);
                    }
                }
            }
            view.setBackgroundResource(j.b.d.f1742i);
            CalculateDialogView.this.c = (ViewGroup) view;
            CalculateDialogView.this.c.setSelected(true);
            if (CalculateDialogView.this.c.getChildCount() == 1) {
                return;
            }
            if (CalculateDialogView.this.c.getChildCount() <= 3) {
                final EditText editText = (EditText) CalculateDialogView.this.c.getChildAt(1);
                editText.setText((CharSequence) null);
                editText.setHint("请输入值");
                editText.setEnabled(true);
                editText.setVisibility(0);
                com.frame.p1.a(editText, 100);
                View childAt = CalculateDialogView.this.c.getChildAt(2);
                childAt.setVisibility(0);
                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.v.m2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CalculateDialogView.a.b(editText, view2);
                    }
                });
                return;
            }
            CalculateDialogView.this.c.getChildAt(1).setVisibility(0);
            TextView textView4 = (TextView) CalculateDialogView.this.c.getChildAt(2);
            textView4.setText((CharSequence) null);
            textView4.setEnabled(true);
            textView4.setVisibility(0);
            com.frame.p1.a(textView4, 100);
            TextView textView5 = (TextView) CalculateDialogView.this.c.getChildAt(3);
            textView5.setText((CharSequence) null);
            textView5.setEnabled(true);
            textView5.setVisibility(0);
            if (view.getId() == j.b.e.Y1) {
                textView5.setOnClickListener(new jt(this, textView5));
            }
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ TextView c;

        b(CalculateDialogView calculateDialogView, TextView textView) {
            this.c = textView;
        }

        static /* synthetic */ void a(TextView textView, ArrayList arrayList, int i2, List list) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            textView.setText((CharSequence) arrayList.get(i2));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final ArrayList arrayList = new ArrayList();
            arrayList.add("顺序取值");
            arrayList.add("随机取值");
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setDefaultData(-1, arrayList);
            final TextView textView = this.c;
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.n2
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i2, List list) {
                    CalculateDialogView.b.a(textView, arrayList, i2, list);
                }
            });
        }
    }

    public interface c {
        void a(String str, String str2);
    }

    public CalculateDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f1763n, (ViewGroup) this, true);
        a aVar = new a();
        findViewById(j.b.e.R5).setOnClickListener(new View.OnClickListener() { // from class: com.v.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.c(view);
            }
        });
        findViewById(j.b.e.S5).setOnClickListener(new View.OnClickListener() { // from class: com.v.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.d(view);
            }
        });
        findViewById(j.b.e.N5).setOnClickListener(new View.OnClickListener() { // from class: com.v.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.e(view);
            }
        });
        findViewById(j.b.e.z5).setOnClickListener(new View.OnClickListener() { // from class: com.v.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.f(view);
            }
        });
        findViewById(j.b.e.v5).setOnClickListener(new View.OnClickListener() { // from class: com.v.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.g(view);
            }
        });
        findViewById(j.b.e.X5).setOnClickListener(new View.OnClickListener() { // from class: com.v.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.h(view);
            }
        });
        findViewById(j.b.e.w5).setOnClickListener(new View.OnClickListener() { // from class: com.v.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CalculateDialogView.i(view);
            }
        });
        findViewById(j.b.e.D2).setOnClickListener(aVar);
        findViewById(j.b.e.E2).setOnClickListener(aVar);
        findViewById(j.b.e.d2).setOnClickListener(aVar);
        findViewById(j.b.e.e2).setOnClickListener(aVar);
        findViewById(j.b.e.T1).setOnClickListener(aVar);
        findViewById(j.b.e.U1).setOnClickListener(aVar);
        findViewById(j.b.e.S2).setOnClickListener(aVar);
        findViewById(j.b.e.f3).setOnClickListener(aVar);
        findViewById(j.b.e.e3).setOnClickListener(aVar);
        findViewById(j.b.e.U2).setOnClickListener(aVar);
        findViewById(j.b.e.T2).setOnClickListener(aVar);
        findViewById(j.b.e.i2).setOnClickListener(aVar);
        findViewById(j.b.e.X1).setOnClickListener(aVar);
        findViewById(j.b.e.i3).setOnClickListener(aVar);
        findViewById(j.b.e.L2).setOnClickListener(aVar);
        findViewById(j.b.e.Y1).setOnClickListener(aVar);
        findViewById(j.b.e.A).setOnClickListener(new View.OnClickListener() { // from class: com.v.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(CalculateDialogView.class);
            }
        });
        findViewById(j.b.e.B).setOnClickListener(new View.OnClickListener() { // from class: com.v.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l(view);
            }
        });
    }

    static /* synthetic */ void c(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是文字分割");
        dingMsgView.h("将文字分割，例如：从'我是点击器啊'中分割出'点击'，可以填入'我是'与'啊'，就可以分离出'点击'，如'1234'中分离'34'可以只填前部分的'12'");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void d(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是长度分割");
        dingMsgView.h("将文字按长度分割，例如：从'我是点击器啊'中分割出'点击'，可以填入'2'与'4'，就可以从文字的第2个到底4个分离出'点击'文字，如果想重第2个字到最后，就填入'2'与''，第二个不要填数字就可以。");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void e(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是文字替换");
        dingMsgView.h("将文字中的内容替换成其他内容，例如：将'66,66,55'变成'666655'就需要将','替换成''，可以填入','与''，就可以得到'666655'");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void f(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是坐标偏移");
        dingMsgView.h("仅在变量为坐标的情况可用，变量值是x,y，比如要坐标向左移动那么就输入<strong><font color='#F45075'>-100,0</font></strong> ，坐标向上移动那么就输入<strong><font color='#F45075'>0,-100</font></strong>，向右下移动就输入<strong><font color='#F45075'>100,200</font></strong> ，当然你的偏移值也可以是变量如${xx},${yy}");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void g(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是区域扩大");
        dingMsgView.h("仅在变量为区域的情况可用，变量值是x,y-x2,y2，起始点坐标是左上角坐标，结束点坐标是右下角坐标，两个对角点产生一个矩形区域。比如要向左扩大区域那么就输入<strong><font color='#F45075'>-100,0-0,0</font></strong> ，坐标向下扩大区域那么就输入<strong><font color='#F45075'>0,0-0,100</font></strong>，左边和向下同时扩大就输入<strong><font color='#F45075'>100,0-0,200</font></strong> ，当然你的扩大值也可以是变量如${start}-${end}");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void h(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是时间格式化");
        dingMsgView.h("将时间格式化，例如填入yyyy-MM-dd HH:mm:ss，就会将你的时间转换成这个格式时间。");
        dingMsgView.i("知道了", null);
    }

    static /* synthetic */ void i(View view) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("什么是数组分割");
        dingMsgView.h("在实际工作场景中会遇到，按顺序读取一些文字，或随机读取一些文字，这是就可以用到数组分割，比如'aaa,bbb,ccc'，分割符号是逗号，那么按顺序读取时，第一次执行到这个节点读取出来的就是aaa,得二次执行到这个节点读取出来的就是bbb。");
        dingMsgView.i("知道了", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        ViewGroup viewGroup = this.c;
        if (viewGroup == null) {
            FloatToast.i("请先选择一项运算");
            return;
        }
        String string = null;
        if (viewGroup.getChildCount() != 1) {
            if (this.c.getChildCount() > 3) {
                string = ((TextView) this.c.getChildAt(2)).getText().toString() + "&&~" + ((TextView) this.c.getChildAt(3)).getText().toString();
            } else {
                string = ((TextView) this.c.getChildAt(1)).getText().toString();
            }
        }
        String string2 = ((TextView) this.c.getChildAt(0)).getText().toString();
        if (!"提取数字".equals(string2) && (TextUtils.isEmpty(string) || string.equals("&&~"))) {
            FloatToast.i("请先输入值");
            this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        com.frame.s0.g().d(CalculateDialogView.class);
        c cVar = this.d;
        if (cVar != null) {
            cVar.a(string2, string);
        }
    }

    public void setOnJudgeChooseListener(c cVar) {
        this.d = cVar;
    }

    public void setSelectValue(String str, String str2) {
        int[] iArr = {j.b.e.D2, j.b.e.E2, j.b.e.d2, j.b.e.e2, j.b.e.T1, j.b.e.S2, j.b.e.f3, j.b.e.e3, j.b.e.U2, j.b.e.T2, j.b.e.i2, j.b.e.X1, j.b.e.i3, j.b.e.L2, j.b.e.Y1};
        for (int i2 = 0; i2 < 15; i2++) {
            int i3 = iArr[i2];
            ViewGroup viewGroup = (ViewGroup) findViewById(i3);
            if (str.equals(((TextView) viewGroup.getChildAt(0)).getText().toString())) {
                viewGroup.callOnClick();
                if (viewGroup.getChildCount() == 1) {
                    return;
                }
                if (viewGroup.getChildCount() <= 3) {
                    ((EditText) viewGroup.getChildAt(1)).setText(str2);
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                String[] strArrSplit = str2.split("&&~", -1);
                ((TextView) viewGroup.getChildAt(2)).setText(strArrSplit[0]);
                ((TextView) viewGroup.getChildAt(3)).setText(strArrSplit.length > 1 ? strArrSplit[1] : "");
                if (j.b.e.Y1 == i3) {
                    TextView textView = (TextView) viewGroup.getChildAt(3);
                    textView.setOnClickListener(new b(this, textView));
                    return;
                }
                return;
            }
        }
    }
}
