package com.v;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.v.AppChooseView;
import com.v.item.CheckItem;
import com.yl.float_ui.InputDialogView;
import com.yl.model.AutoNotify;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AutoNotifyConfigDialogView extends RelativeLayout implements View.OnClickListener {
    private AutoNotify c;
    private a d;
    protected TextView e;
    protected TextView f;
    private FlowLayout g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f915h;

    /* renamed from: i, reason: collision with root package name */
    private CheckItem f916i;

    /* renamed from: j, reason: collision with root package name */
    private CheckItem f917j;

    public interface a {
        void a(AutoNotify autoNotify);
    }

    public AutoNotifyConfigDialogView() {
        super(com.frame.v0.g());
        this.f915h = new ArrayList<>();
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.f1762m, (ViewGroup) this, true);
        this.f916i = (CheckItem) findViewById(j.b.e.k1);
        this.f917j = (CheckItem) findViewById(j.b.e.P1);
        findViewById(j.b.e.g).setOnClickListener(this);
        TextView textView = (TextView) findViewById(j.b.e.P);
        this.e = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(j.b.e.c6);
        this.f = textView2;
        textView2.setOnClickListener(this);
        FlowLayout flowLayout = (FlowLayout) findViewById(j.b.e.O1);
        this.g = flowLayout;
        flowLayout.setHorizontalSpacing(com.frame.p1.c(2.0f));
        this.g.setVerticalSpacing(com.frame.p1.c(10.0f));
        p(this.f915h);
    }

    private View a() {
        ImageView imageView = new ImageView(com.frame.v0.g());
        imageView.setImageResource(j.b.d.a);
        int iH = com.frame.p1.h(6.0f);
        imageView.setPadding(iH, iH, iH, iH);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.v.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(view);
            }
        });
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean c(String str) {
        this.f915h.add(str);
        p(this.f915h);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.s("请输入关键词");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.g2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean g(int i2, ArrayList arrayList, View view) {
        this.g.removeViewAt(i2);
        arrayList.remove(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean i(int i2, ArrayList arrayList, String str) {
        ((TextView) this.g.getChildAt(i2).findViewById(j.b.e.n6)).setText(str);
        arrayList.remove(i2);
        arrayList.add(i2, str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(String str, final int i2, final ArrayList arrayList, View view) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.w(str);
        inputDialogView.s("请输入关键词");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.i2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str2) {
                return this.a.i(i2, arrayList, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(String str) {
        this.f.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(String str) {
        try {
            PackageManager packageManager = com.frame.v0.g().getPackageManager();
            final String string = packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
            com.frame.l1.e(new Runnable() { // from class: com.v.h2
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.m(string);
                }
            });
        } catch (PackageManager.NameNotFoundException e) {
            com.frame.k0.r(e);
        }
    }

    private void p(final ArrayList<String> arrayList) {
        this.f915h = arrayList;
        this.g.removeAllViews();
        for (final int i2 = 0; i2 < arrayList.size(); i2++) {
            final String str = arrayList.get(i2);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, com.frame.p1.c(30.0f));
            View viewInflate = LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.w0, (ViewGroup) null);
            viewInflate.findViewById(j.b.e.M3).setVisibility(8);
            viewInflate.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.v.f2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.c.g(i2, arrayList, view);
                }
            });
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.d2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.k(str, i2, arrayList, view);
                }
            });
            ((TextView) viewInflate.findViewById(j.b.e.n6)).setText(str);
            if (i2 == arrayList.size() - 1) {
                viewInflate.findViewById(j.b.e.j6).setVisibility(8);
            }
            this.g.addView(viewInflate, layoutParams);
        }
        this.g.addView(a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            if (TextUtils.isEmpty(this.c.pn)) {
                com.frame.s0.g().d(AutoNotifyConfigDialogView.class);
                return;
            }
            com.frame.s0.g().d(AutoNotifyConfigDialogView.class);
            i.b.l7.b().c().remove(this.c);
            i.b.l7.b().d();
            com.yl.ui.i0.j();
            return;
        }
        if (id != j.b.e.g) {
            if (id == j.b.e.c6) {
                AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
                appChooseView.u(this.c.pn);
                appChooseView.setCallback(new AppChooseView.a() { // from class: com.v.dt
                    @Override // com.v.AppChooseView.a
                    public final void a(String str) {
                        this.a.setPn(str);
                    }
                });
                return;
            }
            return;
        }
        com.frame.s0.g().o(this);
        AutoNotify autoNotify = this.c;
        autoNotify.keyword = this.f915h;
        autoNotify.clickNotify = this.f916i.getValue().booleanValue();
        this.c.lastTaskRunGoOn = this.f917j.getValue().booleanValue();
        this.c.pn = (String) this.f.getTag();
        if (this.c.pn == null) {
            this.f.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        com.yl.ui.i0.j();
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.c);
        }
    }

    public AutoNotifyConfigDialogView q(AutoNotify autoNotify) {
        this.c = autoNotify;
        setPn(autoNotify.pn);
        if (autoNotify.keyword != null) {
            p(new ArrayList<>(autoNotify.keyword));
        }
        this.f916i.setValue(autoNotify.clickNotify);
        this.f917j.setValue(autoNotify.lastTaskRunGoOn);
        if (!TextUtils.isEmpty(autoNotify.pn)) {
            this.e.setBackgroundResource(j.b.d.f1745l);
            this.e.setText("清除设置");
            this.e.setTextColor(-1);
        }
        return this;
    }

    public AutoNotifyConfigDialogView r(a aVar) {
        this.d = aVar;
        return this;
    }

    public void setPn(final String str) {
        if (str == null) {
            this.f.setText((CharSequence) null);
            this.f.setTag(null);
        } else {
            this.f.setTag(str);
            com.frame.l1.g(new Runnable() { // from class: com.v.j2
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o(str);
                }
            });
        }
    }
}
