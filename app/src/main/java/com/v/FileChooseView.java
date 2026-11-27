package com.v;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.a.FileChooseSafAct;
import com.adapter.FileItemAdapter;
import com.adapter.FilePathItemAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.ItemChooseDialogView;
import com.yl.float_ui.InputDialogView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class FileChooseView extends LinearLayout implements BaseQuickAdapter.OnItemClickListener, SwipeRefreshLayout.j, View.OnClickListener {
    private boolean A;
    private String C;
    private c D;
    private b G;
    private d H;
    private e I;
    private FilePathItemAdapter c;
    private FileItemAdapter d;
    private RecyclerView e;
    private SwipeRefreshLayout f;
    private View g;

    /* renamed from: h, reason: collision with root package name */
    private View f947h;

    /* renamed from: i, reason: collision with root package name */
    private View f948i;

    /* renamed from: j, reason: collision with root package name */
    private View f949j;

    /* renamed from: k, reason: collision with root package name */
    private View f950k;
    private File t;

    class a implements ItemChooseDialogView.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean c(String str) {
            File file = FileChooseView.this.t;
            if (!str.contains(".")) {
                str = str + ".txt";
            }
            com.frame.r0.z(new File(file, str).getAbsolutePath(), "", true);
            FileChooseView fileChooseView = FileChooseView.this;
            fileChooseView.w(fileChooseView.t);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean e(String str) {
            new File(FileChooseView.this.t, str).mkdirs();
            FileChooseView fileChooseView = FileChooseView.this;
            fileChooseView.w(fileChooseView.t);
            return true;
        }

        @Override // com.v.ItemChooseDialogView.b
        public void a(int i2, List<String> list) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
            inputDialogView.v(1);
            inputDialogView.l("文件名称");
            if (i2 == 0) {
                inputDialogView.s("请输入文件名称");
                inputDialogView.t(new InputDialogView.a() { // from class: com.v.u4
                    @Override // com.yl.float_ui.InputDialogView.a
                    public final boolean a(String str) {
                        return this.a.c(str);
                    }
                });
            } else if (1 == i2) {
                inputDialogView.s("请输入文件夹名称");
                inputDialogView.t(new InputDialogView.a() { // from class: com.v.t4
                    @Override // com.yl.float_ui.InputDialogView.a
                    public final boolean a(String str) {
                        return this.a.e(str);
                    }
                });
            }
        }
    }

    public interface b {
        void a(File file);
    }

    public interface c {
        void a(Uri uri);
    }

    public interface d {
        void a(List<File> list);
    }

    public interface e {
        void a(List<Uri> list);
    }

    public FileChooseView() {
        super(com.frame.v0.g());
        this.C = "*/*";
        View.inflate(com.frame.v0.g(), j.b.f.o0, this);
        e();
    }

    private void A() {
        if (this.A) {
            return;
        }
        this.A = true;
        com.frame.l1.e(new Runnable() { // from class: com.v.w4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.v();
            }
        });
    }

    private void B() {
        boolean zL = i.b.t7.l();
        this.g.setVisibility(zL ? 8 : 0);
        this.f.setVisibility(zL ? 0 : 8);
        this.f.setEnabled(zL);
        this.f950k.setVisibility(zL ? 0 : 8);
        this.f948i.setVisibility(zL ? 0 : 8);
        this.f949j.setVisibility(zL ? 0 : 8);
        if (zL) {
            return;
        }
        this.f.setRefreshing(false);
    }

    private void d() {
        B();
        if (i.b.t7.l() && this.d.getData().isEmpty()) {
            if (this.t == null) {
                this.t = Environment.getExternalStorageDirectory();
            }
            w(this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        w(this.c.getItem(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!this.d.getItem(i2).getAbsolutePath().toLowerCase().endsWith(".txt")) {
            return true;
        }
        ((TxtEditView) com.frame.s0.g().B(TxtEditView.class)).setFile(this.d.getItem(i2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(List list) {
        this.c.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(ArrayList arrayList) {
        this.c.setNewData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(File file) {
        this.c.addData((FilePathItemAdapter) file);
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(List list) {
        this.d.setNewData(list);
        this.f.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(final File file) {
        File[] fileArrListFiles = file.listFiles();
        final List arrayList = fileArrListFiles == null ? new ArrayList() : Arrays.asList(fileArrListFiles);
        int iIndexOf = this.c.getData().indexOf(file);
        if (iIndexOf != -1) {
            final List<File> listSubList = this.c.getData().subList(0, iIndexOf + 1);
            com.frame.l1.e(new Runnable() { // from class: com.v.x4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l(listSubList);
                }
            });
        } else if (this.c.getData().isEmpty()) {
            final ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(0, file);
                if (file.equals(Environment.getExternalStorageDirectory())) {
                    break;
                } else {
                    file = file.getParentFile();
                }
            } while (file != null);
            com.frame.l1.e(new Runnable() { // from class: com.v.b5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n(arrayList2);
                }
            });
        } else {
            com.frame.l1.e(new Runnable() { // from class: com.v.c5
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.p(file);
                }
            });
        }
        com.frame.l1.e(new Runnable() { // from class: com.v.a5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        if (isAttachedToWindow()) {
            FileChooseSafAct.v0((this.H == null && this.I == null) ? false : true, this.C);
        } else {
            this.A = false;
        }
    }

    private void z() {
        if (!(this.G == null && this.D == null && this.I == null && this.H == null) && isAttachedToWindow()) {
            A();
        }
    }

    public void b(List<File> list) {
        if (list == null || list.isEmpty()) {
            this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请先选择文件~");
            d();
            return;
        }
        d dVar = this.H;
        if (dVar != null) {
            dVar.a(list);
        }
        b bVar = this.G;
        if (bVar != null) {
            bVar.a(list.get(0));
        }
        com.frame.s0.g().d(FileChooseView.class);
    }

    public void c(List<Uri> list) {
        if (list == null || list.isEmpty()) {
            this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            FloatToast.i("请先选择文件~");
            d();
            return;
        }
        e eVar = this.I;
        if (eVar != null) {
            eVar.a(list);
        } else {
            c cVar = this.D;
            if (cVar != null) {
                cVar.a(list.get(0));
            }
        }
        com.frame.s0.g().d(FileChooseView.class);
    }

    public void e() {
        findViewById(j.b.e.P).setOnClickListener(this);
        View viewFindViewById = findViewById(j.b.e.g);
        this.f949j = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = findViewById(j.b.e.e);
        this.f948i = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.f950k = findViewById(j.b.e.R4);
        this.g = findViewById(j.b.e.d4);
        View viewFindViewById3 = findViewById(j.b.e.C);
        this.f947h = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        ((TextView) this.f947h).setText("去选择文件");
        this.e = (RecyclerView) findViewById(j.b.e.O4);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(j.b.e.Z4);
        this.f = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.f.setOnRefreshListener(this);
        this.e.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 3));
        RecyclerView recyclerView = this.e;
        FileItemAdapter fileItemAdapter = new FileItemAdapter(null, false);
        this.d = fileItemAdapter;
        recyclerView.setAdapter(fileItemAdapter);
        this.d.setOnItemClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(com.frame.v0.g());
        linearLayoutManager.B2(0);
        ((RecyclerView) this.f950k).setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = (RecyclerView) this.f950k;
        FilePathItemAdapter filePathItemAdapter = new FilePathItemAdapter(null);
        this.c = filePathItemAdapter;
        recyclerView2.setAdapter(filePathItemAdapter);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.y4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.g(baseQuickAdapter, view, i2);
            }
        });
        this.d.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.v.v4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.j(baseQuickAdapter, view, i2);
            }
        });
    }

    public b getCallback() {
        return this.G;
    }

    public d getMultiFileChooseCallback() {
        return this.H;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        B();
        if (i.b.t7.l()) {
            w(this.t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        B();
        if (this.G == null && this.D == null && this.H == null && this.I == null) {
            return;
        }
        A();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.g) {
            if (this.d.e() != null && !this.d.e().isEmpty()) {
                b(this.d.e());
                return;
            } else {
                this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请先选择文件~");
                return;
            }
        }
        if (id == j.b.e.P) {
            try {
                com.frame.s0.g().d(FileChooseView.class);
                ((ViewGroup) getParent()).removeView(this);
                return;
            } catch (Exception e2) {
                com.frame.k0.r(e2);
                return;
            }
        }
        if (id == j.b.e.C) {
            A();
        } else if (id == j.b.e.e) {
            ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.setTitle("选择菜单");
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("新建空文本,新建文件夹".split(","))));
            itemChooseDialogView.setOnTextChoose(new a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A = false;
        this.C = "*/*";
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        File item = this.d.getItem(i2);
        if (item.isDirectory()) {
            w(item);
            return;
        }
        if (this.H == null) {
            this.d.c();
        }
        this.d.j(i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            B();
            if (i.b.t7.l() && this.d.getData().isEmpty()) {
                if (this.t == null) {
                    this.t = Environment.getExternalStorageDirectory();
                }
                w(this.t);
            }
        }
    }

    public void setCallback(b bVar) {
        this.G = bVar;
        z();
    }

    public void setChooseFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        this.t = file.getParentFile();
        this.d.i(file);
    }

    public void setMultiFileChooseCallback(d dVar) {
        this.H = dVar;
        z();
    }

    public void setMultiUriCallback(e eVar) {
        this.I = eVar;
        z();
    }

    public void setPickMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.C = str;
    }

    public void setUriCallback(c cVar) {
        this.D = cVar;
        z();
    }

    public void w(final File file) {
        this.t = file;
        this.f.setRefreshing(true);
        com.frame.l1.g(new Runnable() { // from class: com.v.z4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.t(file);
            }
        });
    }

    public void x() {
        com.frame.s0.g().d(FileChooseView.class);
    }

    public void y() {
        B();
        if (i.b.t7.l()) {
            if (this.t == null) {
                this.t = Environment.getExternalStorageDirectory();
            }
            w(this.t);
        }
    }

    public FileChooseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = "*/*";
    }

    public FileChooseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C = "*/*";
    }
}
