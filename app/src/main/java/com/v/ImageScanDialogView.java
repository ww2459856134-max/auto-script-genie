package com.v;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ImageHorizontalAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.FileChooseView;
import com.v.ImageBoxSelectDialogView;
import com.v.ItemChooseDialogView;
import com.v.item.ImageAreaChooseItem;
import com.v.item.InputItem;
import com.v.item.OffersetChooseItem;
import com.v.item.RunConditionItem;
import com.v.item.SelectAndDelayItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes.dex */
public class ImageScanDialogView extends RelativeLayout {
    protected TextView A;
    protected TextView C;
    protected TextView D;
    protected TextView G;
    private final ImageView H;
    private Rect I;
    private Task J;
    private Node K;
    private final SeekBar M;
    private final SeekBar O;
    private c P;
    private lt Q;
    private DialogInterface.OnCancelListener U;
    private final RunConditionItem V;
    private final ImageAreaChooseItem c;
    private final InputItem d;
    private final InputItem e;
    private final OffersetChooseItem f;
    private final SelectAndDelayItem g;

    /* renamed from: h, reason: collision with root package name */
    private final SelectAndDelayItem f969h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f970i;

    /* renamed from: j, reason: collision with root package name */
    protected TextView f971j;

    /* renamed from: k, reason: collision with root package name */
    protected TextView f972k;
    protected TextView t;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            ImageScanDialogView.this.C.setText("原图的" + i2 + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Bitmap bitmap) {
            ImageScanDialogView.this.H.setImageBitmap(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(int i2) {
            try {
                if (ImageScanDialogView.this.f970i == null) {
                    return;
                }
                ImageScanDialogView imageScanDialogView = ImageScanDialogView.this;
                final Bitmap bitmapE = imageScanDialogView.e(imageScanDialogView.f970i, i2);
                com.frame.l1.e(new Runnable() { // from class: com.v.ma
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.b(bitmapE);
                    }
                });
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, final int i2, boolean z) {
            try {
                TextView textView = ImageScanDialogView.this.D;
                StringBuilder sb = new StringBuilder();
                sb.append("灰度值：");
                sb.append(i2 - 127);
                textView.setText(sb.toString());
                com.frame.l1.g(new Runnable() { // from class: com.v.la
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.d(i2);
                    }
                });
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public interface c {
        void a(String str);
    }

    public ImageScanDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.D, (ViewGroup) this, true);
        findViewById(j.b.e.s).setOnClickListener(new View.OnClickListener() { // from class: com.v.cb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(view);
            }
        });
        this.H = (ImageView) findViewById(com.yl.ui.a0.f1134l);
        RunConditionItem runConditionItem = (RunConditionItem) findViewById(j.b.e.h4);
        this.V = runConditionItem;
        runConditionItem.setAttachView(this);
        InputItem inputItem = (InputItem) findViewById(j.b.e.f4);
        this.d = inputItem;
        InputItem inputItem2 = (InputItem) findViewById(j.b.e.p4);
        this.e = inputItem2;
        inputItem.setInputType(2);
        inputItem2.setInputType(2);
        this.f971j = (TextView) findViewById(j.b.e.w6);
        this.A = (TextView) findViewById(j.b.e.K);
        this.G = (TextView) findViewById(j.b.e.t);
        this.C = (TextView) findViewById(j.b.e.P5);
        this.D = (TextView) findViewById(j.b.e.E5);
        this.f972k = (TextView) findViewById(j.b.e.P);
        this.t = (TextView) findViewById(j.b.e.g);
        this.c = (ImageAreaChooseItem) findViewById(j.b.e.Q3);
        this.f = (OffersetChooseItem) findViewById(j.b.e.e4);
        SeekBar seekBar = (SeekBar) findViewById(j.b.e.W4);
        this.M = seekBar;
        SeekBar seekBar2 = (SeekBar) findViewById(j.b.e.V4);
        this.O = seekBar2;
        SelectAndDelayItem selectAndDelayItem = (SelectAndDelayItem) findViewById(j.b.e.h3);
        this.g = selectAndDelayItem;
        SelectAndDelayItem selectAndDelayItem2 = (SelectAndDelayItem) findViewById(j.b.e.j3);
        this.f969h = selectAndDelayItem2;
        selectAndDelayItem.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.qa
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.s();
            }
        });
        selectAndDelayItem.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.gb
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.u();
            }
        });
        selectAndDelayItem.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.hb
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.w(str, str2);
            }
        });
        selectAndDelayItem2.setLowDelay(new SelectAndDelayItem.a() { // from class: com.v.ya
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.y();
            }
        });
        selectAndDelayItem2.setMaxDelay(new SelectAndDelayItem.a() { // from class: com.v.fb
            @Override // com.v.item.SelectAndDelayItem.a
            public final String a() {
                return this.a.A();
            }
        });
        selectAndDelayItem2.setISetDelay(new SelectAndDelayItem.b() { // from class: com.v.za
            @Override // com.v.item.SelectAndDelayItem.b
            public final void a(String str, String str2) {
                this.a.C(str, str2);
            }
        });
        seekBar.setOnSeekBarChangeListener(new a());
        seekBar2.setMax(255);
        seekBar2.setOnSeekBarChangeListener(new b());
        seekBar2.setProgress(127);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.v.ua
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.E(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.v.pa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.G(view);
            }
        });
        this.f972k.setOnClickListener(new View.OnClickListener() { // from class: com.v.va
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.v.ka
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.q(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(String str, String str2) {
        Node node = this.K;
        node.errorDelay = str;
        node.errorMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            findViewById(j.b.e.j4).setVisibility(8);
        } else {
            view.setSelected(true);
            findViewById(j.b.e.j4).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            findViewById(j.b.e.Z3).setVisibility(8);
        } else {
            view.setSelected(true);
            findViewById(j.b.e.Z3).setVisibility(0);
        }
    }

    static /* synthetic */ void H(DialogInterface dialogInterface) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(FloatHandler.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(File file) {
        setIcon(file.getAbsolutePath());
    }

    static /* synthetic */ void L() {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(FloatHandler.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Rect rect) {
        Bitmap bitmapB = null;
        for (int i2 = 0; i2 < 10; i2++) {
            if (i.b.i9.v().B()) {
                try {
                    SystemClock.sleep(200L);
                    Bitmap bitmapX = i.b.i9.v().x();
                    if (bitmapX != null) {
                        bitmapB = com.frame.l0.b(bitmapX, rect, 1.0f);
                        com.frame.l0.c(bitmapX);
                        if (bitmapB != null) {
                            final File file = new File(i.b.da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
                            if (!file.getParentFile().exists()) {
                                file.getParentFile().mkdirs();
                            }
                            com.frame.l0.d(bitmapB, file);
                            com.frame.l1.e(new Runnable() { // from class: com.v.ra
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.c.J(file);
                                }
                            });
                            this.P.a(file.getAbsolutePath());
                            return;
                        }
                    }
                } catch (Exception e) {
                    com.frame.k0.r(e);
                    com.frame.l1.e(new Runnable() { // from class: com.v.ab
                        @Override // java.lang.Runnable
                        public final void run() {
                            Toast.makeText(com.frame.v0.g(), "可能超出边界，图片截取失败", 0).show();
                        }
                    });
                    return;
                } finally {
                    com.frame.l0.c(bitmapB);
                    com.frame.l1.e(new Runnable() { // from class: com.v.oa
                        @Override // java.lang.Runnable
                        public final void run() {
                            ImageScanDialogView.L();
                        }
                    });
                }
            } else {
                SystemClock.sleep(500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(RectChooseView rectChooseView, View view) {
        final Rect rect = new Rect(rectChooseView.getRect());
        this.I = rect;
        this.c.setOriginalRect(rect);
        i.b.i9.v().n();
        com.frame.l1.g(new Runnable() { // from class: com.v.db
            @Override // java.lang.Runnable
            public final void run() {
                this.c.N(rect);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        d(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(int i2, List list) {
        com.frame.s0.g().d(ImageBoxSelectDialogView.class);
        if (list.isEmpty() || i2 >= list.size()) {
            return;
        }
        this.P.a(((ImageBox) list.get(i2)).id + "");
        ((ImageView) findViewById(com.yl.ui.a0.f1134l)).setVisibility(8);
        final RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setVisibility(0);
        ImageHorizontalAdapter imageHorizontalAdapter = new ImageHorizontalAdapter(((ImageBox) list.get(i2)).urls);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g(), 0, false));
        recyclerView.setAdapter(imageHorizontalAdapter);
        imageHorizontalAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.na
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.R(recyclerView, baseQuickAdapter, view, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(View view) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Uri uri) throws Throwable {
        File file = new File(i.b.da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        com.frame.r0.A(uri, file);
        setIcon(file.getAbsolutePath());
        this.P.a(file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            X();
        } else if (i2 == 1) {
            Y();
        } else {
            if (i2 != 2) {
                return;
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        a0("拖动进度条，将图片去除背景干扰，突出图片轮廓，对于识别图片的背景常出现变化的情况可有效的增强识别效果。（开启后识图会多一层处理操作，会影响到识别速度）");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        com.frame.s0.g().d(ImageScanDialogView.class);
        DialogInterface.OnCancelListener onCancelListener = this.U;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
        com.frame.s0.g().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        this.Q.a(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(View view) throws NumberFormatException {
        if (this.Q != null) {
            try {
                long j2 = Long.parseLong(this.e.getValue());
                try {
                    int i2 = Integer.parseInt(this.d.getValue());
                    if (this.g.getVisibility() == 0 && this.f969h.getVisibility() == 0) {
                        if (!this.g.c() || !this.f969h.c()) {
                            return;
                        }
                        this.K.nextType = ((Integer) this.g.getValue()).intValue();
                        this.K.errorType = ((Integer) this.f969h.getValue()).intValue();
                        if (this.K.isJumOtherType()) {
                            this.K.nextTaskId = ((Long) this.g.getSubValue()).longValue();
                        } else if (this.K.isHashJumpNodeType()) {
                            this.K.nextTaskId = ((Long) this.g.getSubValue()).longValue();
                        } else {
                            Node node = this.K;
                            int i3 = node.nextType;
                            if (i3 == 16) {
                                node.arg3 = this.g.getSelectSubLabel();
                            } else if (i3 == 9 || i3 == 11 || i3 == 17 || i3 == 15) {
                                node.arg3 = this.g.getSelectSubLabel();
                                this.K.lineNextNodeAtIndex(this.J);
                            } else {
                                node.lineNextNodeAtIndex(this.J);
                                this.K.arg3 = null;
                            }
                        }
                        if (this.f969h.getSubValue() != null) {
                            this.K.errorId = ((Long) this.f969h.getSubValue()).longValue();
                        }
                    }
                    this.K.setPointNew(this.f.getValue());
                    this.c.p(this.K);
                    Node node2 = this.K;
                    node2.type = 3;
                    node2.timeOut = j2;
                    node2.what = i2;
                    node2.setSrcRectNew(this.I);
                    if (this.A.isSelected()) {
                        this.K.arg1 = this.M.getProgress() + "";
                    } else {
                        this.K.arg1 = null;
                    }
                    if (this.G.isSelected()) {
                        this.K.argInt1 = this.O.getProgress();
                    } else {
                        this.K.argInt1 = -1;
                    }
                    this.K.what = i2;
                    com.frame.s0.g().d(ImageScanDialogView.class);
                    post(new Runnable() { // from class: com.v.ia
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.o();
                        }
                    });
                } catch (Exception unused) {
                    this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    FloatToast.i("请输入正确的超时时间");
                }
            } catch (Exception unused2) {
                this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入正确的超时时间");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String s() {
        return this.K.nextDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String u() {
        return this.K.nextMaxDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String str, String str2) {
        Node node = this.K;
        node.nextDelay = str;
        node.nextMaxDelay = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String y() {
        return this.K.errorDelay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String A() {
        return this.K.errorMaxDelay;
    }

    public void X() {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.s0.g().i(FloatHandlerRecord.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(ImageScanDialogView.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setRect(new Rect(this.I));
        rectChooseView.setHit("滑动选取识别图片");
        rectChooseView.q(null, null);
        rectChooseView.p(null, null);
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.xa
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ImageScanDialogView.H(dialogInterface);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.wa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.P(rectChooseView, view);
            }
        });
    }

    public void Y() {
        ((ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class)).setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: com.v.bb
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i2, List list) {
                this.a.T(i2, list);
            }
        });
    }

    public ImageScanDialogView Z(lt ltVar) {
        this.Q = ltVar;
        return this;
    }

    public void a0(String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(str);
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.sa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void c() {
        ((FileChooseView) com.frame.s0.g().B(FileChooseView.class)).setUriCallback(new FileChooseView.c() { // from class: com.v.eb
            @Override // com.v.FileChooseView.c
            public final void a(Uri uri) throws Throwable {
                this.a.g(uri);
            }
        });
    }

    public void d(View view) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择菜单");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("重新截图,选择图集,选择图片文件".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.ta
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.i(i2, list);
            }
        });
    }

    public Bitmap e(Bitmap bitmap, int i2) {
        if (!i.b.i9.v().m()) {
            return null;
        }
        Mat mat = new Mat(bitmap.getWidth(), bitmap.getHeight(), org.opencv.core.b.a);
        Utils.a(bitmap, mat);
        Mat mat2 = new Mat();
        Imgproc.b(mat, mat2, 6);
        Mat mat3 = new Mat();
        Imgproc.f(mat2, mat3, i2, 255.0d, 1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Utils.c(mat3, bitmapCreateBitmap);
        mat2.h();
        mat.h();
        mat3.h();
        return bitmapCreateBitmap;
    }

    public void setIcon(Bitmap bitmap) {
        this.f970i = bitmap;
        ImageView imageView = (ImageView) findViewById(com.yl.ui.a0.f1134l);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(0);
        recyclerView.setVisibility(8);
    }

    public void setMiniModel() {
        this.g.setVisibility(8);
        this.f969h.setVisibility(8);
        this.e.setVisibility(8);
        this.V.setVisibility(8);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.U = onCancelListener;
    }

    public void setOnImageChangeListener(c cVar) {
        this.P = cVar;
    }

    public void setTaskNode(Task task, Node node) {
        this.J = task;
        this.K = node;
        this.V.setTaskNode(task, node);
        this.f971j.setText(node.step == null ? node.getName() : node.getStepAndName());
        this.I = new Rect(this.K.getSrcRect());
        this.d.setValue(String.valueOf(this.K.what));
        this.e.setValue(String.valueOf(this.K.timeOut));
        setIcon(this.K.url);
        LinkedHashMap<String, LinkedHashMap> linkedHashMap = new LinkedHashMap<>();
        try {
            linkedHashMap.put("跳转任务", null);
            linkedHashMap.put("点击后跳任务", null);
            linkedHashMap.put("跳转节点", null);
            linkedHashMap.put("点击后跳节点", null);
            linkedHashMap.put("将坐标给变量", null);
            linkedHashMap.put("图片计数", null);
            linkedHashMap.put("连续点击", null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("点击图片", 0);
        linkedHashMap2.put("点击图片内随机坐标", 10);
        linkedHashMap2.put("连续点击", 16);
        linkedHashMap2.put("点击后跳任务", 12);
        linkedHashMap2.put("点击后跳节点", 13);
        linkedHashMap2.put("将坐标给变量", 11);
        linkedHashMap2.put("将区域坐标给变量", 17);
        linkedHashMap2.put("长按图片", 5);
        linkedHashMap2.put("连连看（相同图拖动）", 14);
        linkedHashMap2.put("图片计数", 15);
        linkedHashMap2.put("跳转节点", 3);
        linkedHashMap2.put("跳转任务", 4);
        linkedHashMap2.put("结束任务", -3);
        linkedHashMap2.put("结束子任务/循环", -4);
        linkedHashMap2.put("跳转下一个节点", 2);
        this.g.setItems(linkedHashMap2, linkedHashMap);
        this.g.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem = this.g;
        selectAndDelayItem.setOnItemClick(new com.v.item.k2(this.J, this.K, selectAndDelayItem, this.f));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("跳转节点", 3);
        linkedHashMap3.put("跳转任务", 4);
        linkedHashMap3.put("结束任务", -3);
        linkedHashMap3.put("结束子任务/循环", -4);
        linkedHashMap3.put("弹窗报错", -2);
        linkedHashMap3.put("跳转下一个节点", 2);
        this.f969h.setItems(linkedHashMap3, linkedHashMap);
        this.f969h.setSubHint("请选择");
        SelectAndDelayItem selectAndDelayItem2 = this.f969h;
        selectAndDelayItem2.setOnItemClick(new com.v.item.j2(this.J, this.K, selectAndDelayItem2));
        this.g.setSelectValue(Integer.valueOf(node.nextType));
        this.f969h.setSelectValue(Integer.valueOf(node.errorType));
        this.c.setValue(this.I, this.K.getArea(), this.K.areaParam);
        this.f.setValue(this.I, this.K.getPoint());
        if (this.K.argInt1 <= 0) {
            this.G.setSelected(false);
            findViewById(j.b.e.Z3).setVisibility(8);
            this.O.setMax(255);
            this.O.setProgress(127);
            this.D.setText("灰度值50");
        } else {
            this.G.setSelected(true);
            findViewById(j.b.e.Z3).setVisibility(0);
            this.O.setMax(255);
            this.O.setProgress(this.K.argInt1);
        }
        String str = this.K.arg1;
        if (str == null || "100".equals(str)) {
            this.A.setSelected(false);
            findViewById(j.b.e.j4).setVisibility(8);
            this.M.setMax(100);
            this.M.setProgress(100);
            this.C.setText("原图的100%");
            return;
        }
        this.A.setSelected(true);
        findViewById(j.b.e.j4).setVisibility(0);
        this.M.setMax(100);
        this.M.setProgress(Integer.parseInt(this.K.arg1));
        this.C.setText("原图的" + this.K.arg1 + "%");
    }

    public void setIcon(String str) {
        if (str == null) {
            return;
        }
        ImageView imageView = (ImageView) findViewById(com.yl.ui.a0.f1134l);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        if (!str.contains(",") && !str.startsWith("1")) {
            recyclerView.setVisibility(8);
            imageView.setVisibility(0);
            Bitmap bitmapA = com.frame.j1.c().a(str);
            this.f970i = bitmapA;
            imageView.setImageBitmap(bitmapA);
            if (this.P != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.v.ht
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.c.d(view);
                    }
                });
                return;
            }
            return;
        }
        recyclerView.setVisibility(0);
        imageView.setVisibility(8);
        List arrayList = null;
        if (str.startsWith("1")) {
            try {
                arrayList = i.b.b8.c().a(Long.parseLong(str)).urls;
            } catch (Exception e) {
                FloatToast.i("未找到指定图集，该图集是否已被删除");
                com.frame.k0.r(e);
            }
        } else {
            arrayList = new ArrayList(Arrays.asList(str.split(",")));
        }
        ImageHorizontalAdapter imageHorizontalAdapter = new ImageHorizontalAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g(), 0, false));
        recyclerView.setAdapter(imageHorizontalAdapter);
        if (this.P != null) {
            TextView textView = new TextView(com.frame.v0.g());
            textView.setText("更换图集");
            textView.setBackgroundResource(j.b.d.d);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(com.frame.p1.c(90.0f), com.frame.p1.c(60.0f));
            textView.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.b));
            textView.setGravity(17);
            textView.setLayoutParams(layoutParams);
            imageHorizontalAdapter.addFooterView(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.ja
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.V(view);
                }
            });
        }
    }
}
