package com.jsj.autojs.activity;

import android.view.View;
import android.widget.TextView;
import com.v.FloatHandler;
import com.v.OptionListDialogView;
import com.yl.widget.TabLinearLayout;

/* loaded from: classes.dex */
public class A279c88ed4f extends com.yl.ui.p implements View.OnClickListener {
    private i.b.t7 P;
    private TabLinearLayout Q;

    class a implements View.OnClickListener {
        a(A279c88ed4f a279c88ed4f) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case 2131297134:
                    i.b.j7.a().i(0);
                    break;
                case 2131297135:
                    i.b.j7.a().i(1);
                    break;
                case 2131297136:
                    i.b.j7.a().i(2);
                    break;
            }
        }
    }

    static /* synthetic */ void l0(View view) {
        int id = view.getId();
        if (id == 2131297052) {
            i.b.j7.a().k("small");
        } else if (id == 2131297053) {
            i.b.j7.a().k("custom");
        } else if (id == 2131297054) {
            i.b.j7.a().k("big");
        }
        FloatHandler floatHandler = (FloatHandler) com.frame.s0.g().u(FloatHandler.class);
        if (floatHandler != null) {
            floatHandler.O(i.b.j7.a().c());
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492901;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("自定义悬浮条");
        TextView textView = (TextView) findViewById(2131296763);
        textView.setOnClickListener(this);
        textView.setSelected(i.b.j7.a().d());
        TextView textView2 = (TextView) findViewById(2131296762);
        textView2.setOnClickListener(this);
        textView2.setSelected(i.b.j7.a().e());
        String strC = i.b.j7.a().c();
        findViewById(2131296751).setOnClickListener(this);
        TabLinearLayout tabLinearLayout = (TabLinearLayout) findViewById(2131297104);
        if (strC.equals("custom")) {
            tabLinearLayout.b(2131297053);
        } else if (strC.equals("small")) {
            tabLinearLayout.b(2131297052);
        } else if (strC.equals("big")) {
            tabLinearLayout.b(2131297054);
        }
        tabLinearLayout.setTabClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                A279c88ed4f.l0(view);
            }
        });
        TabLinearLayout tabLinearLayout2 = (TabLinearLayout) findViewById(2131297106);
        this.Q = tabLinearLayout2;
        tabLinearLayout2.setTabClickListener(new a(this));
        int iB = i.b.j7.a().b();
        if (iB == 0) {
            this.Q.b(2131297134);
        } else if (iB == 1) {
            this.Q.b(2131297135);
        } else {
            if (iB != 2) {
                return;
            }
            this.Q.b(2131297136);
        }
    }

    public void k0(Runnable runnable) {
        if (this.P == null) {
            this.P = new i.b.t7();
        }
        this.P.z0(runnable);
        this.P.d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296751:
                k0(new Runnable() { // from class: com.jsj.autojs.activity.a1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((OptionListDialogView) com.frame.s0.g().x(OptionListDialogView.class)).setOptionToolBarConfig(true);
                    }
                });
                break;
            case 2131296762:
                view.setSelected(!view.isSelected());
                i.b.j7.a().h(view.isSelected());
                FloatHandler floatHandler = (FloatHandler) com.frame.s0.g().u(FloatHandler.class);
                if (floatHandler != null) {
                    floatHandler.setToolbarBorder(view.isSelected());
                    break;
                }
                break;
            case 2131296763:
                view.setSelected(!view.isSelected());
                i.b.j7.a().j(view.isSelected());
                FloatHandler floatHandler2 = (FloatHandler) com.frame.s0.g().u(FloatHandler.class);
                if (floatHandler2 != null) {
                    floatHandler2.findViewById(2131296478).setVisibility(view.isSelected() ? 0 : 8);
                    break;
                }
                break;
        }
    }
}
