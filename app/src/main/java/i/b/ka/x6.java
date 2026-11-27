package i.b.ka;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.v.FileChooseView;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.ImageScanDialogView;
import com.v.MultiLogicDialogView;
import com.v.OcrDialogView;
import com.v.RectChooseView;
import com.v.RunConditionDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.c8;
import i.b.da;
import i.b.i9;
import i.b.q8;
import i.b.q9;
import i.b.r8;
import i.b.t9;
import i.b.v8;
import i.b.x7;
import java.io.File;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class x6 extends x5 {
    private long e;
    private int f = 0;

    static Bitmap T(Bitmap bitmap, Rect rect, float f) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), (Matrix) null, false);
        if (f == 1.0f) {
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, Math.round(bitmapCreateBitmap.getWidth() * f), Math.round(bitmapCreateBitmap.getHeight() * f), false);
        com.frame.l0.c(bitmapCreateBitmap);
        return bitmapCreateScaledBitmap;
    }

    public static boolean V(Node node) {
        return !"0".equals(node.arg2);
    }

    static /* synthetic */ void Z(DialogInterface dialogInterface) {
        com.frame.s0.g().d(RectChooseView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(Node node, lt ltVar) {
        if (!com.frame.s0.g().b(MultiLogicDialogView.class) && !com.frame.s0.g().b(RunConditionDialogView.class)) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.e2
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().X(node);
        }
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(final Node node, final lt ltVar, Node node2) {
        new t9(v8.m().p()).W(new Runnable() { // from class: i.b.ka.c2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b0(node, ltVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(final File file, final Node node, final lt ltVar) {
        OcrDialogView ocrDialogView = (OcrDialogView) com.frame.s0.g().B(OcrDialogView.class);
        ocrDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.j2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                x6.u0(file, dialogInterface);
            }
        });
        ocrDialogView.setTaskNode(v8.m().p(), node);
        ocrDialogView.X(new lt() { // from class: i.b.ka.z1
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.d0(node, ltVar, node2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(Rect rect, final lt ltVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            SystemClock.sleep(200L);
            Bitmap bitmapX = i9.v().x();
            if (bitmapX != null) {
                Bitmap bitmapB = com.frame.l0.b(bitmapX, rect, 1.0f);
                com.frame.l0.c(bitmapX);
                if (bitmapB != null) {
                    final File file = new File(da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    com.frame.l0.d(bitmapB, file);
                    com.frame.l0.c(bitmapB);
                    final Node nodeI = v8.m().i(rect);
                    nodeI.url = file.getAbsolutePath();
                    com.frame.l1.e(new Runnable() { // from class: i.b.ka.h2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.f0(file, nodeI, ltVar);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(RectChooseView rectChooseView, final lt ltVar, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        final Rect rect = rectChooseView.getRect();
        if (rect.height() > 0 && rect.width() > 0) {
            i9.v().n();
            com.frame.l1.g(new Runnable() { // from class: i.b.ka.k2
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.h0(rect, ltVar);
                }
            });
        } else {
            com.frame.s0.g().d(RectChooseView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            com.frame.s0.g().u(MultiLogicDialogView.class);
            FloatToast.i("请滑动选取需要匹配的图片");
        }
    }

    static /* synthetic */ void k0(DialogInterface dialogInterface) {
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(Node node, File file, lt ltVar) {
        v8.m().g(node, file);
        if (!com.frame.s0.g().b(MultiLogicDialogView.class) && !com.frame.s0.g().b(RunConditionDialogView.class)) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.g2
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().R(node);
        }
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(final File file, final lt ltVar, final Node node) {
        new t9(v8.m().p()).W(new Runnable() { // from class: i.b.ka.x1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n0(node, file, ltVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(int i2, final lt ltVar, Uri uri) throws Throwable {
        com.frame.s0.g().d(RectChooseView.class);
        final File file = new File(da.z(), "/img/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        com.frame.r0.A(uri, file);
        ImageScanDialogView imageScanDialogView = (ImageScanDialogView) com.frame.s0.g().B(ImageScanDialogView.class);
        if (i2 == 1) {
            imageScanDialogView.setMiniModel();
        }
        imageScanDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.a2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                x6.k0(dialogInterface);
            }
        });
        imageScanDialogView.setTaskNode(v8.m().p(), v8.m().h(null));
        imageScanDialogView.setIcon(file.getAbsolutePath());
        imageScanDialogView.Z(new lt() { // from class: i.b.ka.y1
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.p0(file, ltVar, node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(final int i2, final lt ltVar, View view) {
        ((FileChooseView) com.frame.s0.g().B(FileChooseView.class)).setUriCallback(new FileChooseView.c() { // from class: i.b.ka.i2
            @Override // com.v.FileChooseView.c
            public final void a(Uri uri) throws Throwable {
                this.a.r0(i2, ltVar, uri);
            }
        });
    }

    static /* synthetic */ void u0(File file, DialogInterface dialogInterface) {
        com.frame.s0.g().u(FloatHandlerRecord.class);
        try {
            file.delete();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    private String w0(t9 t9Var, String str, String str2, String str3, Bitmap bitmap, int i2, int i3, boolean z) {
        q8 q8VarA0;
        Bitmap bitmapA = null;
        if (!i9.v().m()) {
            return null;
        }
        try {
            if (z) {
                try {
                    bitmapA = c8.a(bitmap, i2, i3);
                } catch (Throwable th) {
                    com.frame.l0.c(bitmapA);
                    throw th;
                }
            }
            if (t9Var == null) {
                if (z) {
                    bitmap = bitmapA;
                }
                q8VarA0 = q9.m(str, str2, str3, bitmap);
            } else {
                if (z) {
                    bitmap = bitmapA;
                }
                q8VarA0 = t9Var.a0(str, str2, str3, bitmap);
            }
            String strA = r8.a(q8VarA0.b(), str3);
            com.frame.l0.c(bitmapA);
            return strA;
        } catch (i.b.ja.n e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException("OCR识别失败", e2);
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 31;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        try {
            OcrDialogView ocrDialogView = (OcrDialogView) com.frame.s0.g().B(OcrDialogView.class);
            ocrDialogView.setTaskNode(task, node);
            ocrDialogView.X(ltVar);
        } catch (Exception unused) {
            com.frame.y0.j("图片识别错误，联系技术小哥1");
        }
    }

    @Override // i.b.ka.x5
    public void R(final int i2, final lt ltVar) {
        if (i9.v().B()) {
            W(i2, ltVar);
        } else {
            i9.v().q0();
            i9.v().n0(new Runnable() { // from class: i.b.ka.v1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.X(i2, ltVar);
                }
            });
        }
    }

    public float U(Node node) {
        if (node.arg1 == null) {
            return 1.0f;
        }
        return Integer.parseInt(r2) / 100.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b7, code lost:
    
        throw new java.lang.IllegalArgumentException("OCR识别区域超出截图范围：" + r0 + " / " + r9.getWidth() + "x" + r9.getHeight());
     */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws Throwable {
        Bitmap bitmap;
        Bitmap bitmapT;
        this.f = 0;
        this.e = System.currentTimeMillis();
        long j2 = node.timeOut;
        i9.v().n();
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = null;
        while (true) {
            if (!this.c.q()) {
                break;
            }
            if (this.f > 0 && System.currentTimeMillis() - this.e > j2) {
                com.frame.l0.c(bitmap3);
                FloatToast.g(j.b.d.g0, O(node, this.e));
                i9.v().h0();
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                return false;
            }
            Rect areaOrParam = node.getAreaOrParam();
            if (node.hasAreaResolveError()) {
                FloatToast.g(j.b.d.g0, node.getAreaResolveErrorMessage());
                i9.v().h0();
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                return false;
            }
            com.frame.y0.o("OCR识别区域" + areaOrParam);
            Bitmap bitmapW = i9.v().w(this.e + j2, this.f == 0);
            if (bitmapW == null && this.f == 0 && i9.v().F()) {
                return false;
            }
            if (!this.c.q()) {
                com.frame.l0.c(bitmapW);
                return false;
            }
            if (bitmapW == null) {
                if (System.currentTimeMillis() - this.e > 3000) {
                    this.f++;
                }
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
                bitmap = bitmapW;
            } else {
                this.f++;
                try {
                    try {
                        if (areaOrParam == null) {
                            throw new IllegalArgumentException("OCR识别区域为空");
                        }
                        try {
                            if (areaOrParam.left < 0 || areaOrParam.top < 0 || areaOrParam.right > bitmapW.getWidth() || areaOrParam.bottom > bitmapW.getHeight()) {
                                break;
                            }
                            bitmapT = T(bitmapW, areaOrParam, U(node));
                            try {
                                String strG = da.B().G(node.arg3);
                                bitmap = bitmapW;
                                try {
                                    String strW0 = w0(this.c, node.ocrEngine, node.arg4, TextUtils.isEmpty(node.arg5) ? "chi_sim" : node.arg5, bitmapT, node.what, c8.b(node.arg6), V(node));
                                    com.frame.y0.n("图片文字识别（" + strG + "）：" + strW0);
                                    da.B().E1(strG, strW0);
                                    this.c.W(runnable);
                                    com.frame.l0.c(bitmap);
                                    com.frame.l0.c(bitmapT);
                                    break;
                                } catch (i.b.ja.n e2) {
                                    e = e2;
                                    bitmap2 = bitmapT;
                                    i.b.ja.o.l(e);
                                    com.frame.y0.j(e.getMessage());
                                    i9.v().h0();
                                    x7.d().b(node.getErrorDelay());
                                    k(node, runnable);
                                    com.frame.l0.c(bitmap);
                                    com.frame.l0.c(bitmap2);
                                    return false;
                                } catch (Exception e3) {
                                    e = e3;
                                    try {
                                        com.frame.k0.r(e);
                                        com.frame.l0.c(bitmap);
                                        com.frame.l0.c(bitmapT);
                                        bitmap3 = bitmap;
                                    } catch (Throwable th) {
                                        th = th;
                                        bitmap2 = bitmapT;
                                        com.frame.l0.c(bitmap);
                                        com.frame.l0.c(bitmap2);
                                        throw th;
                                    }
                                }
                            } catch (i.b.ja.n e4) {
                                e = e4;
                                bitmap = bitmapW;
                            } catch (Exception e5) {
                                e = e5;
                                bitmap = bitmapW;
                            } catch (Throwable th2) {
                                th = th2;
                                bitmap = bitmapW;
                                bitmap2 = bitmapT;
                                com.frame.l0.c(bitmap);
                                com.frame.l0.c(bitmap2);
                                throw th;
                            }
                        } catch (i.b.ja.n e6) {
                            e = e6;
                            bitmap = bitmapW;
                        } catch (Exception e7) {
                            e = e7;
                            bitmap = bitmapW;
                            bitmapT = null;
                            com.frame.k0.r(e);
                            com.frame.l0.c(bitmap);
                            com.frame.l0.c(bitmapT);
                            bitmap3 = bitmap;
                        } catch (Throwable th3) {
                            th = th3;
                            bitmap = bitmapW;
                            com.frame.l0.c(bitmap);
                            com.frame.l0.c(bitmap2);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (i.b.ja.n e8) {
                    e = e8;
                } catch (Exception e9) {
                    e = e9;
                }
            }
            bitmap3 = bitmap;
        }
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.Z;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "文字识别（OCR）";
    }

    public String x0(String str, String str2, String str3, Bitmap bitmap, int i2, int i3, boolean z) {
        return w0(null, str, str2, str3, bitmap, i2, i3, z);
    }

    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public void X(final int i2, final lt ltVar) {
        com.frame.s0.g().i(FloatHandlerRecord.class);
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setHit("滑动选取识别文字区域");
        rectChooseView.setCallBack(new RectChooseView.a() { // from class: i.b.ka.w1
            @Override // com.v.RectChooseView.a
            public final void a(Rect rect) {
                com.frame.s0.g().i(FloatHandlerRecord.class);
            }
        });
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.b2
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                x6.Z(dialogInterface);
            }
        });
        rectChooseView.a(new View.OnClickListener() { // from class: i.b.ka.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.t0(i2, ltVar, view);
            }
        });
        rectChooseView.q(null, null);
        rectChooseView.r("确定", new View.OnClickListener() { // from class: i.b.ka.f2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.j0(rectChooseView, ltVar, view);
            }
        });
    }
}
