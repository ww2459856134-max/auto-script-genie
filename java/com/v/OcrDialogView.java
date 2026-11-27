package com.v;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.v.item.CheckItem;
import com.v.item.ImageAreaChooseItem;
import com.v.item.InputItem;
import com.v.item.ParamLabelItem;
import com.v.item.SelectItem;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.widget.TabLinearLayout;
import java.io.File;

/* loaded from: classes.dex */
public class OcrDialogView extends RelativeLayout {
    protected TextView A;
    protected TextView C;
    private final TabLinearLayout D;
    private ImageView G;
    private Rect H;
    private Task I;
    private Node J;
    private final SeekBar K;
    private SeekBar M;
    private lt O;
    private DialogInterface.OnCancelListener P;
    private final ParamLabelItem Q;
    private final CheckItem U;
    private final View V;
    private final View W;
    private final ImageAreaChooseItem c;
    private final InputItem d;
    private InputItem e;
    private InputItem f;
    private final SelectItem g;

    /* renamed from: h, reason: collision with root package name */
    private final SelectItem f1016h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f1017i;

    /* renamed from: j, reason: collision with root package name */
    protected TextView f1018j;

    /* renamed from: k, reason: collision with root package name */
    protected TextView f1019k;
    protected TextView t;

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            OcrDialogView.this.t.setText("原图的" + i2 + "%");
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
            OcrDialogView.this.G.setImageBitmap(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(int i2) {
            if (OcrDialogView.this.J == null) {
                return;
            }
            try {
                final Bitmap bitmapE = OcrDialogView.this.e(i2);
                com.frame.l1.e(new Runnable() { // from class: com.v.hh
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
                OcrDialogView.this.A.setText("灰度值：" + i2);
                com.frame.l1.g(new Runnable() { // from class: com.v.ih
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
            OcrDialogView ocrDialogView = OcrDialogView.this;
            ocrDialogView.V(ocrDialogView.e.getValue(), OcrDialogView.this.f.getValue(), com.frame.j1.c().a(OcrDialogView.this.J.url));
        }
    }

    class c implements SelectItem.a {
        c() {
        }

        @Override // com.v.item.SelectItem.a
        public void a(boolean z, int i2, Object obj, String str) {
            if ("识别中文".equals(str)) {
                OcrDialogView.this.f.setValue("chi_sim");
                OcrDialogView.this.e.setValue("chi_sim.traineddata");
                OcrDialogView.this.e.setVisibility(8);
                OcrDialogView.this.f.setVisibility(8);
                return;
            }
            if ("识别英文".equals(str)) {
                OcrDialogView.this.f.setValue("eng");
                OcrDialogView.this.e.setValue("eng.traineddata");
                OcrDialogView.this.e.setVisibility(8);
                OcrDialogView.this.f.setVisibility(8);
                return;
            }
            if ("识别数字".equals(str)) {
                OcrDialogView.this.f.setValue("number");
                OcrDialogView.this.e.setValue("number.traineddata");
                OcrDialogView.this.e.setVisibility(8);
                OcrDialogView.this.f.setVisibility(8);
                return;
            }
            if ("自定义模型".equals(str)) {
                OcrDialogView.this.e.setVisibility(0);
                OcrDialogView.this.f.setVisibility(0);
            }
        }
    }

    public OcrDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.O, (ViewGroup) this, true);
        findViewById(j.b.e.s).setOnClickListener(new View.OnClickListener() { // from class: com.v.xh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u(view);
            }
        });
        TabLinearLayout tabLinearLayout = (TabLinearLayout) findViewById(j.b.e.i5);
        this.D = tabLinearLayout;
        CheckItem checkItem = (CheckItem) findViewById(j.b.e.v2);
        this.U = checkItem;
        this.V = findViewById(j.b.e.Y3);
        this.W = findViewById(j.b.e.b4);
        checkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.v.zh
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.A(compoundButton, z);
            }
        });
        tabLinearLayout.setTabClickListener(new View.OnClickListener() { // from class: com.v.di
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.G(view);
            }
        });
        this.C = (TextView) findViewById(j.b.e.Q);
        this.Q = (ParamLabelItem) findViewById(j.b.e.O2);
        ImageView imageView = (ImageView) findViewById(com.yl.ui.a0.f1134l);
        this.G = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.v.qh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.g(view);
            }
        });
        this.g = (SelectItem) findViewById(j.b.e.l4);
        SelectItem selectItem = (SelectItem) findViewById(j.b.e.k4);
        this.f1016h = selectItem;
        if (!i.b.ja.i.b(getContext().getPackageName())) {
            selectItem.setItems(new String[]{"默认OCR（内置）"});
            selectItem.setVisibility(8);
        }
        selectItem.setOnItemClick(new SelectItem.a() { // from class: com.v.rh
            @Override // com.v.item.SelectItem.a
            public final void a(boolean z, int i2, Object obj, String str) {
                this.a.i(z, i2, obj, str);
            }
        });
        this.e = (InputItem) findViewById(j.b.e.q4);
        this.f = (InputItem) findViewById(j.b.e.r4);
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.v.oh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.k(view);
            }
        });
        InputItem inputItem = (InputItem) findViewById(j.b.e.p4);
        this.d = inputItem;
        inputItem.setInputType(2);
        this.f1019k = (TextView) findViewById(j.b.e.K);
        this.t = (TextView) findViewById(j.b.e.P5);
        this.f1017i = (TextView) findViewById(j.b.e.P);
        this.f1018j = (TextView) findViewById(j.b.e.g);
        this.c = (ImageAreaChooseItem) findViewById(j.b.e.Q3);
        SeekBar seekBar = (SeekBar) findViewById(j.b.e.W4);
        this.K = seekBar;
        seekBar.setOnSeekBarChangeListener(new a());
        this.A = (TextView) findViewById(j.b.e.C5);
        SeekBar seekBar2 = (SeekBar) findViewById(j.b.e.U4);
        this.M = seekBar2;
        seekBar2.setMax(255);
        this.M.setOnSeekBarChangeListener(new b());
        this.M.setProgress(127);
        this.f1019k.setOnClickListener(new View.OnClickListener() { // from class: com.v.uh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m(view);
            }
        });
        this.f1017i.setOnClickListener(new View.OnClickListener() { // from class: com.v.kh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o(view);
            }
        });
        this.f1018j.setOnClickListener(new View.OnClickListener() { // from class: com.v.ei
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                this.c.s(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(Bitmap bitmap) {
        this.G.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        if (this.J == null) {
            return;
        }
        try {
            final Bitmap bitmapE = e(this.M.getProgress());
            com.frame.l1.e(new Runnable() { // from class: com.v.sh
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.C(bitmapE);
                }
            });
            V(this.e.getValue(), this.f.getValue(), com.frame.j1.c().a(this.J.url));
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(View view) {
        com.frame.l1.g(new Runnable() { // from class: com.v.gh
            @Override // java.lang.Runnable
            public final void run() {
                this.c.E();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(String str) {
        this.C.setText("测试结果：" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(String str, String str2, Bitmap bitmap) {
        try {
            final String strX0 = ((i.b.ka.x6) i.b.x7.d().e(31)).x0(getSelectedEngine(), str, str2, bitmap, this.M.getProgress(), i.b.c8.b(getBlurSizeString()), this.U.getValue().booleanValue());
            com.frame.l1.e(new Runnable() { // from class: com.v.lh
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.I(strX0);
                }
            });
        } catch (i.b.ja.n e) {
            i.b.ja.o.l(e);
            com.frame.k0.r(e);
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    static /* synthetic */ void L(DialogInterface dialogInterface) {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
        com.frame.s0.g().u(ImageScanDialogView.class);
        com.frame.s0.g().u(FloatHandler.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N() {
        this.G.setImageBitmap(e(this.M.getProgress()));
    }

    static /* synthetic */ void P() {
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(OcrDialogView.class);
        com.frame.s0.g().u(FloatHandler.class);
        com.frame.s0.g().d(RectChooseView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(Rect rect) {
        Bitmap bitmapB = null;
        for (int i2 = 0; i2 < 10; i2++) {
            try {
                Log.e("图片截取", rect.toString());
                SystemClock.sleep(200L);
                Bitmap bitmapX = i.b.i9.v().x();
                if (bitmapX != null) {
                    bitmapB = com.frame.l0.b(bitmapX, rect, 1.0f);
                    com.frame.l0.c(bitmapX);
                    if (bitmapB != null) {
                        File file = new File(i.b.da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        com.frame.l0.d(bitmapB, file);
                        this.J.url = file.getAbsolutePath();
                        com.frame.l1.e(new Runnable() { // from class: com.v.jh
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.N();
                            }
                        });
                        return;
                    }
                }
                com.frame.l0.c(bitmapB);
                com.frame.l1.e(new Runnable() { // from class: com.v.nh
                    @Override // java.lang.Runnable
                    public final void run() {
                        OcrDialogView.P();
                    }
                });
            } catch (Exception e) {
                com.frame.k0.r(e);
                com.frame.l1.e(new Runnable() { // from class: com.v.bi
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g(), "可能超出边界，图片截取失败", 0).show();
                    }
                });
                return;
            } finally {
                com.frame.l0.c(bitmapB);
                com.frame.l1.e(new Runnable() { // from class: com.v.nh
                    @Override // java.lang.Runnable
                    public final void run() {
                        OcrDialogView.P();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(RectChooseView rectChooseView, View view) {
        final Rect rect = rectChooseView.getRect();
        this.H = rect;
        if (this.c.getValue() == null || !this.c.getValue().equals(this.H)) {
            this.c.setValue(this.H, rect, null);
        } else {
            this.c.setValue(this.H, new Rect(this.H), null);
        }
        i.b.i9.v().n();
        com.frame.l1.g(new Runnable() { // from class: com.v.wh
            @Override // java.lang.Runnable
            public final void run() {
                this.c.R(rect);
            }
        });
    }

    private void Z(boolean z) {
        String selectLabel = this.g.getSelectLabel();
        this.g.setItems(getResources().getStringArray(z ? j.b.b.b : j.b.b.a));
        if (z && "自定义模型".equals(selectLabel)) {
            selectLabel = "识别中文";
        }
        this.g.setSelectLabel(TextUtils.isEmpty(selectLabel) ? "识别中文" : selectLabel);
    }

    private void a0(boolean z) {
        this.V.setVisibility(z ? 0 : 8);
        this.W.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        W();
    }

    private String getSelectedEngine() {
        return i.b.ja.i.c(this.f1016h.getSelectLabel().startsWith("Paddle") ? "paddle" : i.b.ja.i.a, getContext().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(boolean z, int i2, Object obj, String str) {
        boolean zStartsWith = str.startsWith("Paddle");
        if (z && zStartsWith && !i.b.ja.o.a()) {
            this.f1016h.setSelectLabel("默认OCR（内置）");
        } else {
            Z(zStartsWith);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        V(this.e.getValue(), this.f.getValue(), com.frame.j1.c().a(this.J.url));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            findViewById(j.b.e.j4).setVisibility(8);
        } else {
            view.setSelected(true);
            findViewById(j.b.e.j4).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(View view) {
        com.frame.s0.g().d(OcrDialogView.class);
        DialogInterface.OnCancelListener onCancelListener = this.P;
        if (onCancelListener != null) {
            onCancelListener.onCancel(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        this.O.a(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(View view) throws NumberFormatException {
        if (this.O != null) {
            try {
                long j2 = Long.parseLong(this.d.getValue());
                this.J.arg4 = this.e.getValue();
                this.J.arg5 = this.f.getValue();
                this.J.arg6 = getBlurSizeString();
                this.J.arg2 = this.U.getValue().booleanValue() ? "1" : "0";
                String selectedEngine = getSelectedEngine();
                if (i.b.ja.i.a(selectedEngine) && !i.b.ja.o.a()) {
                    this.f1016h.setSelectLabel("默认OCR（内置）");
                    return;
                }
                Node node = this.J;
                node.ocrEngine = selectedEngine;
                node.arg3 = this.Q.getValue();
                if (TextUtils.isEmpty(this.J.arg3)) {
                    this.Q.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                    return;
                }
                this.c.p(this.J);
                Node node2 = this.J;
                node2.timeOut = j2;
                node2.setSrcRectNew(this.H);
                this.J.what = this.M.getProgress();
                if (this.f1019k.isSelected()) {
                    this.J.arg1 = this.K.getProgress() + "";
                } else {
                    this.J.arg1 = null;
                }
                com.frame.s0.g().d(OcrDialogView.class);
                post(new Runnable() { // from class: com.v.mh
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.q();
                    }
                });
            } catch (Exception unused) {
                this.d.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                FloatToast.i("请输入正确的超时时间");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(View view) {
        Y("拖动进度条，将图片去除背景干扰，可增强识别的正确性，调整进度后，请点击测试查看一下结果是否准确。");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(Bitmap bitmap) {
        this.G.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y() {
        final Bitmap bitmapE = e(this.M.getProgress());
        com.frame.l1.e(new Runnable() { // from class: com.v.vh
            @Override // java.lang.Runnable
            public final void run() {
                this.c.w(bitmapE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(CompoundButton compoundButton, boolean z) {
        a0(z);
        if (this.J != null) {
            com.frame.l1.g(new Runnable() { // from class: com.v.ci
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.y();
                }
            });
        }
    }

    public void V(final String str, final String str2, final Bitmap bitmap) {
        com.frame.l1.g(new Runnable() { // from class: com.v.yh
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K(str, str2, bitmap);
            }
        });
    }

    public void W() {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.s0.g().i(FloatHandlerRecord.class);
        com.frame.s0.g().i(NodeListDialogView.class);
        com.frame.s0.g().i(OcrDialogView.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setHit("滑动选取识别图片");
        rectChooseView.q(null, null);
        rectChooseView.p(null, null);
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.v.ai
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                OcrDialogView.L(dialogInterface);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: com.v.ph
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.T(rectChooseView, view);
            }
        });
    }

    public OcrDialogView X(lt ltVar) {
        this.O = ltVar;
        return this;
    }

    public void Y(String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(str);
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.th
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public Bitmap e(int i2) {
        Bitmap bitmapA = com.frame.j1.c().a(this.J.url);
        return this.U.getValue().booleanValue() ? i.b.c8.a(bitmapA, i2, i.b.c8.b(getBlurSizeString())) : bitmapA;
    }

    public String getBlurSizeString() {
        if (this.D.getSelectedTabViewId() == j.b.e.k5) {
            return "轻度";
        }
        if (this.D.getSelectedTabViewId() == j.b.e.l5) {
            return "中度";
        }
        if (this.D.getSelectedTabViewId() == j.b.e.m5) {
            return "高度";
        }
        return null;
    }

    public void setIcon(Bitmap bitmap) {
        this.G.setImageBitmap(bitmap);
        this.G.setVisibility(0);
    }

    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.P = onCancelListener;
    }

    public void setTaskNode(Task task, Node node) {
        this.I = task;
        this.J = node;
        this.H = new Rect(this.J.getSrcRect());
        this.e.setValue(this.J.arg4);
        this.f.setValue(this.J.arg5);
        this.f1016h.setSelectLabel(i.b.ja.i.a(i.b.ja.i.c(this.J.ocrEngine, getContext().getPackageName())) ? "Paddle OCR（插件内测）" : "默认OCR（内置）");
        this.g.setOnItemClick(new c());
        if ("chi_sim".equals(this.J.arg5)) {
            this.g.setSelectLabel("识别中文");
        } else if ("eng".equals(this.J.arg5)) {
            this.g.setSelectLabel("识别英文");
        } else if ("number".equals(this.J.arg5)) {
            this.g.setSelectLabel("识别数字");
        } else {
            this.g.setSelectLabel("自定义模型");
        }
        String str = this.J.arg6;
        if (str == null) {
            this.D.b(j.b.e.j5);
        } else if ("轻度".equals(str)) {
            this.D.b(j.b.e.k5);
        } else if ("中度".equals(this.J.arg6)) {
            this.D.b(j.b.e.l5);
        } else if ("高度".equals(this.J.arg6)) {
            this.D.b(j.b.e.m5);
        }
        this.U.setValue(i.b.ka.x6.V(this.J));
        a0(this.U.getValue().booleanValue());
        this.d.setValue(String.valueOf(this.J.timeOut));
        this.Q.setParamKeys(this.I.params);
        this.Q.setValue(this.J.arg3);
        this.G.setImageBitmap(com.frame.j1.c().a(node.url));
        this.c.setValue(this.H, this.J.getArea(), node.areaParam);
        this.M.setProgress(this.J.what);
        String str2 = this.J.arg1;
        if (str2 == null || "100".equals(str2)) {
            this.f1019k.setSelected(false);
            findViewById(j.b.e.j4).setVisibility(8);
            this.K.setMax(100);
            this.K.setProgress(100);
            this.t.setText("原图的100%");
            return;
        }
        this.f1019k.setSelected(true);
        findViewById(j.b.e.j4).setVisibility(0);
        this.K.setMax(100);
        this.K.setProgress(Integer.parseInt(this.J.arg1));
        this.t.setText("原图的" + this.J.arg1 + "%");
    }
}
