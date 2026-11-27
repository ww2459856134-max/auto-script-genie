package com.a;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.act.WebAct;
import com.auto.dialog.WallPaperAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.tencent.open.SocialConstants;
import com.yl.ui.CropActivity;
import com.yl.ui.s;
import i.b.t7;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import wallpaper.WallpaperSetting;

/* loaded from: classes.dex */
public class WallpaperSelectAct extends com.yl.ui.p implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemLongClickListener {
    public static String Z;
    private WallPaperAdapter P;
    private View U;
    private File Q = null;
    private final androidx.activity.result.d<Intent> V = u(new androidx.activity.result.l.f(), new androidx.activity.result.c() { // from class: com.a.s1
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.B0((androidx.activity.result.b) obj);
        }
    });
    private final androidx.activity.result.d<Intent> W = u(new androidx.activity.result.l.f(), new androidx.activity.result.c() { // from class: com.a.y1
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.J0((androidx.activity.result.b) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(androidx.activity.result.b bVar) {
        if (bVar.b() != -1) {
            return;
        }
        o0(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0() {
        Y("读取图片失败，请重新选择");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0() {
        Y("读取图片失败，请重新选择");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(Uri uri) {
        try {
            File file = this.Q;
            S0(uri, file);
            o0(file);
        } catch (IOException e) {
            com.frame.k0.r(e);
            com.frame.l1.e(new Runnable() { // from class: com.a.t1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.D0();
                }
            });
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            com.frame.l1.e(new Runnable() { // from class: com.a.w1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.F0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0(androidx.activity.result.b bVar) {
        if (bVar.b() != -1) {
            return;
        }
        Intent intentA = bVar.a();
        if (intentA == null || intentA.getData() == null) {
            Y("未选中可用图片，请重试");
            return;
        }
        final Uri data = intentA.getData();
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                getContentResolver().takePersistableUriPermission(data, intentA.getFlags() & 3);
            } catch (Exception unused) {
            }
        }
        try {
            this.Q = File.createTempFile("crop_", ".jpg", getFilesDir());
            if (this.P.getData().isEmpty()) {
                com.frame.l1.g(new Runnable() { // from class: com.a.r1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.H0(data);
                    }
                });
            } else {
                m0(intentA);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void K0() {
        SystemClock.sleep(400L);
        if (com.frame.v0.g().k() || !com.frame.w0.d()) {
            return;
        }
        com.frame.w0.b().performGlobalAction(1);
    }

    static /* synthetic */ void L0() {
        try {
            com.yl.ui.i0.l(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.frame.l1.g(new Runnable() { // from class: com.a.u1
            @Override // java.lang.Runnable
            public final void run() {
                WallpaperSelectAct.K0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(int i2, DialogInterface dialogInterface, int i3) {
        this.P.remove(i2);
        this.P.notifyDataSetChanged();
        Q0();
    }

    private void O0() {
        WallpaperSetting.x(new Runnable() { // from class: com.a.a2
            @Override // java.lang.Runnable
            public final void run() {
                WallpaperSelectAct.L0();
            }
        });
    }

    private InputStream P0(Uri uri) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                return inputStreamOpenInputStream;
            }
            File fileK = com.frame.r0.k(uri);
            if (fileK == null) {
                String strG = com.frame.r0.g(this, uri);
                if (TextUtils.isEmpty(strG)) {
                    throw new IOException("resolve file path failed");
                }
                fileK = new File(strG);
            }
            if (fileK.exists() && fileK.canRead()) {
                return new FileInputStream(fileK);
            }
            throw new IOException("source file not readable: " + fileK.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e = e;
            com.frame.k0.r(e);
            throw new IOException("open source uri failed", e);
        } catch (IllegalStateException e2) {
            e = e2;
            com.frame.k0.r(e);
            throw new IOException("open source uri failed", e);
        } catch (SecurityException e3) {
            com.frame.k0.r(e3);
            throw new IOException("no permission to read source uri", e3);
        }
    }

    private File S0(Uri uri, File file) throws IOException {
        if (uri == null) {
            throw new IOException("wallpaper uri is null");
        }
        InputStream inputStreamP0 = P0(uri);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[XMLEvent.CHANGE_PREFIX_MAPPING];
                while (true) {
                    int i2 = inputStreamP0.read(bArr);
                    if (i2 <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                if (inputStreamP0 != null) {
                    inputStreamP0.close();
                }
                return file;
            } finally {
            }
        } catch (Throwable th) {
            if (inputStreamP0 != null) {
                try {
                    inputStreamP0.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void m0(Intent intent) throws IOException {
        Uri data = intent.getData();
        if (data == null) {
            throw new IOException("crop uri is null");
        }
        Intent intent2 = new Intent(this, (Class<?>) CropActivity.class);
        intent2.setData(data);
        intent2.putExtra("outputX", com.frame.k0.c().e());
        intent2.putExtra("outputY", com.frame.k0.c().d());
        intent2.putExtra("output", this.Q.getAbsolutePath());
        this.V.a(intent2);
    }

    private void n0() {
        Intent intent;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
            } else {
                intent = new Intent("android.intent.action.PICK", (Uri) null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            }
            intent.addFlags(STBorder.INT_CUSTOM);
            this.W.a(intent);
        } catch (Exception e) {
            Y("打开相册失败，无法选择壁纸");
            com.frame.k0.r(e);
        }
    }

    private void o0(final File file) {
        if (file == null) {
            com.frame.l1.e(new Runnable() { // from class: com.a.p1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.s0();
                }
            });
            return;
        }
        file.length();
        com.frame.g1.c(file, file, com.frame.k0.c().e(), com.frame.k0.c().d(), 90);
        com.frame.l1.e(new Runnable() { // from class: com.a.v1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.u0(file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(View view) {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0() {
        try {
            s.a aVar = new s.a(this);
            aVar.g(j.b.d.q0);
            aVar.r("知道了", null);
            aVar.j("出错啦，请用系统相册选择器来选择壁纸，或者忽略壁纸守护开启其他权限保证后台稳定，你还可以进群反馈问题哦~");
            aVar.t("温馨提示");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(File file) {
        R0(file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(View view) {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(View view) {
        try {
            Intent intent = new Intent(this, (Class<?>) WebAct.class);
            intent.putExtra(SocialConstants.PARAM_URL, Z);
            intent.putExtra("title", "壁纸守护使用教程");
            startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void Q0() {
        com.frame.v0.f().edit().putString("wlpp", new Gson().s(this.P.getData())).apply();
    }

    void R0(String str) {
        this.P.addData((WallPaperAdapter) str);
        Q0();
        this.P.e(str);
        WallpaperSetting.B(str);
        O0();
        this.P.notifyDataSetChanged();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return j.b.f.c;
    }

    @Override // com.yl.ui.p
    public void b0() throws IllegalStateException, IOException, IllegalArgumentException {
        j0("壁纸守护");
        this.P = new WallPaperAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setAdapter(this.P);
        this.P.setOnItemClickListener(this);
        this.P.setOnItemLongClickListener(this);
        List<String> listL0 = l0();
        if (listL0 == null) {
            listL0 = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList(listL0);
        String strL = WallpaperSetting.l();
        if (!TextUtils.isEmpty(strL)) {
            arrayList.remove(strL);
            arrayList.add(0, strL);
        }
        boolean z = arrayList.size() == 1 && WallpaperSetting.p((String) arrayList.get(0));
        if (WallpaperSetting.q()) {
            this.P.e(WallpaperSetting.o());
        }
        this.P.setNewData(arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        recyclerView.g(new com.auto.dialog.a(com.frame.p1.c(10.0f), 0, 0, 0));
        k0();
        View viewFindViewById = findViewById(j.b.e.z);
        if (!(com.permission.a1.g().h() instanceof com.permission.i0) || Build.VERSION.SDK_INT < 32) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.a.b2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.permission.x0.m().e();
                }
            });
            if (z) {
                viewFindViewById.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            }
        }
        if (z) {
            com.frame.k0.c().p("wallpaper.mp4");
        }
        this.U = findViewById(j.b.e.E4);
        if (arrayList.isEmpty()) {
            this.U.setVisibility(0);
            this.U.setOnClickListener(new View.OnClickListener() { // from class: com.a.x1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.x0(view);
                }
            });
            recyclerView.setVisibility(8);
        } else {
            this.U.setVisibility(8);
        }
        if (TextUtils.isEmpty(Z)) {
            return;
        }
        TextView textView = (TextView) findViewById(j.b.e.A5);
        textView.setVisibility(0);
        textView.setText(Html.fromHtml("壁纸守护介绍及使用教程，点击这里查看<strong><font color='#F45075'>『视频教程』</font></strong>"));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.a.z1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.z0(view);
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, j.b.a.a);
    }

    public void k0() {
        this.P.setFooterViewAsFlow(true);
        View viewInflate = View.inflate(getApplicationContext(), j.b.f.r1, null);
        ((ImageView) viewInflate.findViewById(j.b.e.R1)).setImageResource(j.b.d.N0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.a.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q0(view);
            }
        });
        this.P.addFooterView(viewInflate);
    }

    public List<String> l0() {
        return (List) new Gson().k(com.frame.v0.f().getString("wlpp", null), com.google.gson.k0.a.c(List.class, String.class).e());
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10011) {
            if (i3 == -1) {
                setResult(-1);
                finish();
            } else if (!WallpaperSetting.q()) {
                new t7().F0();
            } else {
                setResult(-1);
                finish();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws IOException {
        String item = this.P.getItem(i2);
        this.P.e(item);
        if (item.contains("$$video")) {
            WallpaperSetting.y(item);
        } else {
            WallpaperSetting.B(item);
        }
        O0();
        this.P.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        if (WallpaperSetting.p(this.P.getItem(i2))) {
            Y("默认浅蓝壁纸会一直保留，方便随时使用");
            return true;
        }
        if (this.P.getItem(i2).equals(this.P.d())) {
            Y("不能删除当前壁纸");
            return true;
        }
        try {
            s.a aVar = new s.a(com.frame.v0.g().d());
            aVar.m("取消", null);
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.a.c2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.N0(i2, dialogInterface, i3);
                }
            });
            aVar.s(j.b.g.b);
            aVar.g(j.b.d.q0);
            aVar.j("您确认删除该壁纸吗？");
            aVar.e().show();
            return false;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return false;
        }
    }
}
