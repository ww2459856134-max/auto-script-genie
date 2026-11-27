package com.jsj.autojs.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.jsj.autojs.activity.Aedaedea51a;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public class Aedaedea51a extends com.yl.ui.p implements View.OnClickListener, AdapterView.OnItemClickListener, TextWatcher {
    private ListView P;
    private EditText Q;
    private PackageManager U;
    private a V;
    private List<PackageInfo> W;
    private i.d.a.a Z;

    class a extends BaseAdapter {
        List<PackageInfo> c;
        PackageManager d;

        a() {
        }

        static /* synthetic */ void a(p8 p8Var, Drawable drawable, String str) {
            p8Var.a.setImageDrawable(drawable);
            p8Var.b.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(PackageInfo packageInfo, final p8 p8Var) {
            final Drawable drawableLoadIcon = packageInfo.applicationInfo.loadIcon(this.d);
            final String strTrim = packageInfo.applicationInfo.loadLabel(Aedaedea51a.this.U).toString().trim();
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.b8
                @Override // java.lang.Runnable
                public final void run() {
                    Aedaedea51a.a.a(p8Var, drawableLoadIcon, strTrim);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e(List list, PackageManager packageManager) {
            this.c = list;
            this.d = packageManager;
            notifyDataSetChanged();
        }

        public void f(final List<PackageInfo> list, final PackageManager packageManager) {
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.z7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.e(list, packageManager);
                }
            });
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<PackageInfo> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.c.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            final p8 p8Var;
            if (view == null) {
                view = LayoutInflater.from(Aedaedea51a.this).inflate(2131493106, (ViewGroup) null);
                p8Var = new p8(this);
                p8Var.a = (ImageView) view.findViewById(2131296648);
                p8Var.b = (TextView) view.findViewById(2131297255);
                view.setTag(p8Var);
            } else {
                p8Var = (p8) view.getTag();
            }
            final PackageInfo packageInfo = this.c.get(i2);
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.a8
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.c(packageInfo, p8Var);
                }
            });
            return view;
        }
    }

    private List<PackageInfo> l0() {
        PackageManager packageManager = getPackageManager();
        this.U = packageManager;
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(XMLEvent.ENTITY_REFERENCE);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < installedPackages.size(); i2++) {
            PackageInfo packageInfo = installedPackages.get(i2);
            if ((packageInfo.applicationInfo.flags & 1) == 0 && !packageInfo.packageName.equals("com.jsj.autojs")) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0() {
        if (this.Z.d0()) {
            return;
        }
        this.Z.j2(x(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0() {
        this.Z.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(Editable editable) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.x7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n0();
            }
        });
        this.W = l0();
        if (TextUtils.isEmpty(editable)) {
            this.V.f(this.W, this.U);
        } else {
            ArrayList arrayList = new ArrayList();
            for (PackageInfo packageInfo : this.W) {
                if (packageInfo.applicationInfo.loadLabel(this.U).toString().trim().contains(editable)) {
                    arrayList.add(packageInfo);
                }
            }
            this.V.f(arrayList, this.U);
        }
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.y7
            @Override // java.lang.Runnable
            public final void run() {
                this.c.p0();
            }
        });
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(final Editable editable) {
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.c8
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r0(editable);
            }
        });
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296532) {
            return;
        }
        finish();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492896);
        findViewById(2131296532).setOnClickListener(this);
        ListView listView = (ListView) findViewById(2131296865);
        this.P = listView;
        listView.setOnItemClickListener(this);
        EditText editText = (EditText) findViewById(2131297014);
        this.Q = editText;
        editText.addTextChangedListener(this);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, 220));
        this.P.addFooterView(textView);
        a aVar = new a();
        this.V = aVar;
        this.P.setAdapter((ListAdapter) aVar);
        List<PackageInfo> listL0 = l0();
        this.W = listL0;
        this.V.f(listL0, this.U);
        this.Z = new i.d.a.a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Intent intent = new Intent();
        intent.putExtra("packageName", ((PackageInfo) this.V.getItem(i2)).packageName);
        intent.putExtra("name", ((PackageInfo) this.V.getItem(i2)).applicationInfo.loadLabel(getPackageManager()).toString().trim());
        setResult(-1, intent);
        finish();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
