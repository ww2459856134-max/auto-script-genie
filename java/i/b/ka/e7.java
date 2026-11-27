package i.b.ka;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.user.AccountTool;
import com.v.FileChooseView;
import com.v.FloatHandler;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.ImageScanDialogView;
import com.v.MultiLogicDialogView;
import com.v.NodeListDialogView;
import com.v.RectChooseView;
import com.v.RunConditionDialogView;
import com.v.TaskChooseDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.a9;
import i.b.b8;
import i.b.da;
import i.b.i9;
import i.b.t9;
import i.b.v8;
import i.b.x7;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes.dex */
public class e7 extends x5 {
    private long e;
    private Node f;
    private Mat g;

    /* renamed from: j, reason: collision with root package name */
    Paint f1525j;

    /* renamed from: h, reason: collision with root package name */
    private int f1523h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f1524i = 50;

    /* renamed from: k, reason: collision with root package name */
    Rect f1526k = new Rect();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(final Bitmap bitmap, final int i2, final Runnable runnable, final lt ltVar, final Node node) {
        new t9(v8.m().p()).W(new Runnable() { // from class: i.b.ka.n3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z0(node, bitmap, i2, runnable, ltVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(final int i2, final Runnable runnable, final lt ltVar, Node node, final Bitmap bitmap) {
        ImageScanDialogView imageScanDialogView = (ImageScanDialogView) com.frame.s0.g().B(ImageScanDialogView.class);
        if (i2 == 1) {
            imageScanDialogView.setMiniModel();
        }
        imageScanDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.j3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.c.w0(runnable, ltVar, dialogInterface);
            }
        });
        imageScanDialogView.setTaskNode(v8.m().p(), node);
        imageScanDialogView.setIcon(bitmap);
        imageScanDialogView.Z(new lt() { // from class: i.b.ka.r3
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.B0(bitmap, i2, runnable, ltVar, node2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G0(RectChooseView rectChooseView, final int i2, final Runnable runnable, final lt ltVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        for (int i3 = 0; i3 < 10; i3++) {
            SystemClock.sleep(300L);
            Bitmap bitmapY = i9.v().y(true);
            if (bitmapY != null) {
                if (bitmapY.getHeight() == 0 && bitmapY.getWidth() == 0) {
                    a9.b();
                    i9.v().s();
                    i9.v().n();
                    return;
                }
                Rect rect = rectChooseView.getRect();
                if (rect.right > bitmapY.getWidth() || rect.bottom > bitmapY.getHeight()) {
                    a9.b();
                    i9.v().s();
                    i9.v().n();
                }
                final Bitmap bitmapB = com.frame.l0.b(bitmapY, rect, 1.0f);
                com.frame.l0.c(bitmapY);
                if (bitmapB != null) {
                    if ((bitmapB.getHeight() <= 0 && bitmapB.getWidth() <= 0) || Color.alpha(bitmapB.getPixel(bitmapB.getWidth() / 2, bitmapB.getHeight() / 2)) != 0) {
                        final Node nodeH = v8.m().h(rect);
                        com.frame.l1.e(new Runnable() { // from class: i.b.ka.m3
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.c.E0(i2, runnable, ltVar, nodeH, bitmapB);
                            }
                        });
                        return;
                    } else {
                        a9.b();
                        i9.v().s();
                        i9.v().n();
                        return;
                    }
                }
            }
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(final RectChooseView rectChooseView, final int i2, final Runnable runnable, final lt ltVar, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        i9.v().n();
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.g3
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                this.c.G0(rectChooseView, i2, runnable, ltVar);
            }
        });
    }

    static /* synthetic */ void J0(boolean z) {
        if (z) {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.c3
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandler.class);
                }
            });
        }
    }

    static /* synthetic */ void K0(Rect rect) {
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.s0.g().i(FloatHandlerRecord.class);
        for (Class<? extends NodeListDialogView> cls : NodeListDialogView.I) {
            com.frame.s0.g().i(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0(Runnable runnable, lt ltVar, DialogInterface dialogInterface) {
        com.frame.s0.g().d(RectChooseView.class);
        runnable.run();
        c(ltVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O0(Runnable runnable, lt ltVar, DialogInterface dialogInterface) {
        runnable.run();
        c(ltVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0(Node node, File file, Runnable runnable, lt ltVar) {
        v8.m().g(node, file);
        if (!com.frame.s0.g().b(MultiLogicDialogView.class) && !com.frame.s0.g().b(RunConditionDialogView.class)) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.h3
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().R(node);
        }
        runnable.run();
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T0(final File file, final Runnable runnable, final lt ltVar, final Node node) {
        new t9(v8.m().p()).W(new Runnable() { // from class: i.b.ka.t3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.R0(node, file, runnable, ltVar);
            }
        });
    }

    private void U0(Node node, List<Rect> list) {
        boolean z = node.nextType == 17;
        StringBuilder sb = new StringBuilder();
        for (Rect rect : list) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            if (z) {
                sb.append(Node.getStringByRect(rect));
            } else {
                sb.append(rect.centerX());
                sb.append(",");
                sb.append(rect.centerY());
            }
        }
        da.B().E1(da.B().G(node.arg3), sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("图片识别成功");
        sb2.append(z ? "区域" : "中心点");
        sb2.append("写入变量（");
        sb2.append(node.arg3);
        sb2.append("）：");
        sb2.append((Object) sb);
        com.frame.y0.g(sb2.toString());
    }

    private List<Rect> V(Node node, Bitmap bitmap, Rect rect, Bitmap... bitmapArr) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (rect == null || !this.c.q()) {
                break;
            }
            Rect rect2 = new Rect(rect);
            arrayList.add(rect2);
            GesturePlayFloatView.B(rect2);
            if (arrayList.size() >= 100) {
                com.frame.y0.g("图片匹配结果达到100个，仅写入前100个坐标");
                break;
            }
            rect = a0(node, bitmap, rect, bitmapArr);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public void k0(final int i2, final lt ltVar, final boolean z) {
        final Runnable runnable = new Runnable() { // from class: i.b.ka.v3
            @Override // java.lang.Runnable
            public final void run() {
                e7.J0(z);
            }
        };
        com.frame.s0.g().i(TaskChooseDialogView.class);
        com.frame.s0.g().i(FloatHandler.class);
        com.frame.s0.g().i(FloatHandlerRecord.class);
        for (Class<? extends NodeListDialogView> cls : NodeListDialogView.I) {
            com.frame.s0.g().i(cls);
        }
        final RectChooseView rectChooseView = (RectChooseView) com.frame.s0.g().x(RectChooseView.class);
        rectChooseView.setHit("滑动选取识别图片");
        rectChooseView.setCallBack(new RectChooseView.a() { // from class: i.b.ka.f3
            @Override // com.v.RectChooseView.a
            public final void a(Rect rect) {
                e7.K0(rect);
            }
        });
        rectChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.x3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.c.M0(runnable, ltVar, dialogInterface);
            }
        });
        rectChooseView.a(new View.OnClickListener() { // from class: i.b.ka.a4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o0(i2, runnable, ltVar, view);
            }
        });
        rectChooseView.r("确定", new View.OnClickListener() { // from class: i.b.ka.y3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u0(rectChooseView, runnable, ltVar, i2, view);
            }
        });
        rectChooseView.q("更多", new View.OnClickListener() { // from class: i.b.ka.e3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.I0(rectChooseView, i2, runnable, ltVar, view);
            }
        });
    }

    private Rect c0(o.a.e eVar, Bitmap bitmap, float f) {
        this.f1526k.left = eVar.a();
        this.f1526k.top = eVar.b();
        this.f1526k.right = eVar.a() + bitmap.getWidth();
        this.f1526k.bottom = eVar.b() + bitmap.getHeight();
        if (f != 1.0f) {
            Rect rect = this.f1526k;
            rect.left = (int) (rect.left / f);
            rect.top = (int) (rect.top / f);
            rect.right = (int) (rect.right / f);
            rect.bottom = (int) (rect.bottom / f);
        }
        return this.f1526k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0(Node node) {
        FloatToast.g(j.b.d.g0, O(node, this.e));
    }

    static /* synthetic */ void i0(lt ltVar, DialogInterface dialogInterface) {
        if (ltVar != null) {
            ltVar.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(int i2, final Runnable runnable, final lt ltVar, Uri uri) throws Throwable {
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
        imageScanDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.d3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.c.O0(runnable, ltVar, dialogInterface);
            }
        });
        imageScanDialogView.setTaskNode(v8.m().p(), v8.m().h(null));
        imageScanDialogView.setIcon(file.getAbsolutePath());
        imageScanDialogView.Z(new lt() { // from class: i.b.ka.z3
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.T0(file, runnable, ltVar, node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(final int i2, final Runnable runnable, final lt ltVar, View view) {
        ((FileChooseView) com.frame.s0.g().B(FileChooseView.class)).setUriCallback(new FileChooseView.c() { // from class: i.b.ka.p3
            @Override // com.v.FileChooseView.c
            public final void a(Uri uri) throws Throwable {
                this.a.m0(i2, runnable, ltVar, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(Rect rect, int i2, Runnable runnable, lt ltVar) {
        for (int i3 = 0; i3 < 10; i3++) {
            SystemClock.sleep(200L);
            Bitmap bitmapX = i9.v().x();
            if (bitmapX != null) {
                Bitmap bitmapB = com.frame.l0.b(bitmapX, rect, 1.0f);
                com.frame.l0.c(bitmapX);
                if (bitmapB != null) {
                    v8 v8VarM = v8.m();
                    Node nodeH = v8.m().h(rect);
                    v8VarM.f(nodeH, bitmapB);
                    if (i2 != 1) {
                        com.frame.l1.f(new Runnable() { // from class: i.b.ka.s3
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.frame.s0.g().u(FloatHandlerRecord.class);
                            }
                        }, 600L);
                        v8.m().R(nodeH);
                    }
                    runnable.run();
                    Q(ltVar, nodeH);
                    return;
                }
            }
        }
        i9.v().s();
        FloatToast.i(Html.fromHtml("录屏权限可能被占用，也可以去检查一下<strong><font color='#F45075'>兼容设置</font></strong>-<strong><font color='#F45075'>屏幕默认方向</font></strong>选项"));
        com.frame.l1.e(new Runnable() { // from class: i.b.ka.o3
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(FloatHandlerRecord.class);
            }
        });
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(RectChooseView rectChooseView, final Runnable runnable, final lt ltVar, final int i2, View view) {
        com.frame.s0.g().d(RectChooseView.class);
        final Rect rect = rectChooseView.getRect();
        if (rect.height() > 0 && rect.width() > 0) {
            i9.v().n();
            com.frame.l1.g(new Runnable() { // from class: i.b.ka.q3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.s0(rect, i2, runnable, ltVar);
                }
            });
        } else {
            com.frame.s0.g().d(RectChooseView.class);
            runnable.run();
            c(ltVar);
            FloatToast.i("请滑动选取需要匹配的图片");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(Runnable runnable, lt ltVar, DialogInterface dialogInterface) {
        runnable.run();
        c(ltVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(Node node, Bitmap bitmap, int i2, Runnable runnable, lt ltVar) {
        v8.m().f(node, bitmap);
        if (i2 != 1) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.i3
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().R(node);
        }
        runnable.run();
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 3;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, final lt ltVar) {
        ImageScanDialogView imageScanDialogView = (ImageScanDialogView) com.frame.s0.g().B(ImageScanDialogView.class);
        if (i2 == 1) {
            imageScanDialogView.setMiniModel();
        }
        imageScanDialogView.setOnImageChangeListener(new ImageScanDialogView.c() { // from class: i.b.ka.w3
            @Override // com.v.ImageScanDialogView.c
            public final void a(String str) {
                node.url = str;
            }
        });
        imageScanDialogView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.u3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e7.i0(ltVar, dialogInterface);
            }
        });
        imageScanDialogView.Z(ltVar);
        imageScanDialogView.setTaskNode(task, node.getCompatibility());
    }

    @Override // i.b.ka.x5
    public void R(final int i2, final lt ltVar) {
        final boolean zM = com.frame.s0.g().m(FloatHandler.class);
        if (i9.v().B()) {
            j0(i2, ltVar, zM);
        } else {
            i9.v().q0();
            i9.v().n0(new Runnable() { // from class: i.b.ka.l3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.k0(i2, ltVar, zM);
                }
            });
        }
    }

    public Mat T(Bitmap bitmap, Mat mat) {
        if (mat == null) {
            mat = new Mat();
            this.g = mat;
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            com.frame.y0.j("图片识别失败：bitmapToMat 收到空图或已回收图片");
            return null;
        }
        try {
            if (Color.alpha(bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2)) == 0) {
                com.frame.y0.j("图片识别失败：截图中心像素透明");
                return null;
            }
            Utils.a(bitmap, mat);
            return mat;
        } catch (RuntimeException e) {
            com.frame.y0.j("图片识别失败：图片转换OpenCV数据失败，请检查截图权限、识别区域和横竖屏状态");
            com.frame.k0.r(e);
            return null;
        }
    }

    public boolean U(Bitmap bitmap, Node node, Rect rect, Runnable runnable, Bitmap... bitmapArr) {
        int i2;
        try {
            try {
                i2 = node.nextType;
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
            if (i2 == 15) {
                GesturePlayFloatView.B(rect);
                int i3 = 1;
                while (true) {
                    rect = a0(node, bitmap, rect, bitmapArr);
                    if (rect == null) {
                        break;
                    }
                    GesturePlayFloatView.B(rect);
                    if (!this.c.q()) {
                        break;
                    }
                    i3++;
                }
                da.B().E1(da.B().G(node.arg3), Integer.valueOf(i3));
                com.frame.y0.g("图片计数（" + node.arg3 + "）：" + i3);
                this.c.W(runnable);
                return true;
            }
            if (i2 != 11 && i2 != 17) {
                if (i2 != 14) {
                    i9.v().h0();
                    x7.d().b(node.getNextDelay());
                    N(node, this.e);
                    l(node, rect, runnable);
                    return true;
                }
                return false;
            }
            List<Rect> listV = V(node, bitmap, rect, bitmapArr);
            if (!this.c.q()) {
                return false;
            }
            i9.v().h0();
            x7.d().b(node.getNextDelay());
            N(node, this.e);
            U0(node, listV);
            this.c.W(runnable);
            return true;
        } finally {
            com.frame.l0.c(bitmap);
        }
    }

    public Rect V0(Node node, Mat mat, Rect rect, Bitmap... bitmapArr) {
        if (!i9.v().m()) {
            return null;
        }
        float fD0 = d0(node);
        int i2 = node.what;
        for (int i3 = 0; i3 < bitmapArr.length; i3++) {
            Bitmap bitmap = bitmapArr[i3];
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        if (rect == null || (bitmap.getWidth() <= rect.width() && bitmap.getHeight() <= rect.height())) {
                            o.a.e eVarR = this.c.R(mat, bitmap, i2 / 100.0f);
                            if (eVarR.a() != -1 || eVarR.b() != -1) {
                                Rect rectC0 = c0(eVarR, bitmap, fD0);
                                com.frame.y0.n("图识成功(" + i3 + ")，耗时：" + (System.currentTimeMillis() - this.e) + "    " + rectC0);
                                if (rect != null) {
                                    rectC0.offset(rect.left, rect.top);
                                }
                                return rectC0;
                            }
                        } else {
                            com.frame.y0.j("第" + (i3 + 1) + "图:图片尺寸大于识别区域，排查是否是分享后分辨率不同导致");
                        }
                    }
                } catch (Exception e) {
                    com.frame.y0.l(e);
                }
            }
        }
        return null;
    }

    public Bitmap W(String str, float f, int i2) {
        String str2 = str + ParameterizedMessage.ERROR_MSG_SEPARATOR + f + ParameterizedMessage.ERROR_MSG_SEPARATOR + i2;
        Bitmap bitmapB = com.frame.j1.c().b(str2);
        if (bitmapB != null && !bitmapB.isRecycled()) {
            return bitmapB;
        }
        Bitmap bitmapA = com.frame.j1.c().a(str);
        if (bitmapA == null) {
            return null;
        }
        if (f != 1.0f) {
            bitmapA = Bitmap.createScaledBitmap(bitmapA, (int) (bitmapA.getWidth() * f), (int) (bitmapA.getHeight() * f), false);
        }
        if (i2 > 0) {
            Bitmap bitmapB0 = b0(bitmapA, i2);
            com.frame.l0.c(bitmapA);
            bitmapA = bitmapB0;
        }
        com.frame.j1.c().d(bitmapA, str2);
        return bitmapA;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(6:(5:95|19|(0)|22|111)|92|32|(2:34|(3:109|36|(3:97|38|116)(1:115))(8:44|(1:46)|47|48|93|49|110|(3:101|51|118)(1:117)))|22|111)|90|27|(1:29)|30|31) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0190, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean W0(Bitmap bitmap, Node node, Rect rect, Runnable runnable, Bitmap... bitmapArr) throws Throwable {
        Mat matE0;
        Mat mat;
        Throwable th;
        Rect rectC0;
        StringBuilder sb;
        if (!i9.v().m() || (matE0 = e0(bitmap, node, rect)) == null) {
            return false;
        }
        float fD0 = d0(node);
        int i2 = node.what;
        int i3 = 0;
        while (i3 < bitmapArr.length) {
            try {
                Bitmap bitmap2 = bitmapArr[i3];
                if (bitmap2 != null) {
                    try {
                        if (!bitmap2.isRecycled()) {
                            o.a.e eVarR = this.c.R(matE0, bitmap2, i2 / 100.0f);
                            try {
                                try {
                                    if (eVarR.a() == -1) {
                                        try {
                                            if (eVarR.b() == -1) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            mat = matE0;
                                            if (mat != null) {
                                                throw th;
                                            }
                                            try {
                                                mat.h();
                                                throw th;
                                            } catch (Exception e) {
                                                com.frame.k0.r(e);
                                                throw th;
                                            }
                                        }
                                    }
                                    Rect rectA0 = a0(node, bitmap, rectC0, bitmap2);
                                    if (rectA0 != null) {
                                        i9.v().h0();
                                        com.frame.y0.n("图片连连看(" + i3 + ")，耗时：" + (System.currentTimeMillis() - this.e) + "    " + rectC0);
                                        if (rectC0.equals(rectA0)) {
                                            com.frame.y0.j("图片连连看，应该出错了，两个坐标重叠了");
                                            if (mat == null) {
                                                return false;
                                            }
                                            try {
                                                mat.h();
                                                return false;
                                            } catch (Exception e2) {
                                                com.frame.k0.r(e2);
                                                return false;
                                            }
                                        }
                                        GesturePlayFloatView.B(rectA0);
                                        Node node2 = new Node();
                                        node2.duration = 150L;
                                        ArrayList<Integer> arrayList = new ArrayList<>();
                                        node2.pathPoints = arrayList;
                                        arrayList.add(Integer.valueOf(rectC0.centerX()));
                                        node2.pathPoints.add(Integer.valueOf(rectC0.centerY()));
                                        node2.pathPoints.add(Integer.valueOf(rectA0.centerX()));
                                        node2.pathPoints.add(Integer.valueOf(rectA0.centerY()));
                                        node2.pathPoints.add(Integer.valueOf(rectA0.centerX()));
                                        node2.pathPoints.add(Integer.valueOf(rectA0.centerY()));
                                        if (da.B().M().isShowGesturePath) {
                                            ((GesturePlayFloatView) com.frame.s0.g().h(GesturePlayFloatView.class)).y(node2);
                                        }
                                        x7.d().b(node.getNextDelay());
                                        try {
                                            g(node2, runnable);
                                            com.frame.l0.c(bitmap);
                                            if (mat == null) {
                                                return true;
                                            }
                                            try {
                                                mat.h();
                                                return true;
                                            } catch (Exception e3) {
                                                com.frame.k0.r(e3);
                                                return true;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            com.frame.y0.l(e);
                                            i3++;
                                            matE0 = mat;
                                        }
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    com.frame.y0.l(e);
                                    i3++;
                                    matE0 = mat;
                                }
                                sb.append(System.currentTimeMillis() - this.e);
                                sb.append("    ");
                                sb.append(rectC0);
                                com.frame.y0.n(sb.toString());
                                GesturePlayFloatView.B(rectC0);
                                if (rect != null) {
                                    rectC0.offset(rect.left, rect.top);
                                }
                                this.f1526k = new Rect();
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                if (mat != null) {
                                }
                            }
                            rectC0 = c0(eVarR, bitmap2, fD0);
                            sb = new StringBuilder();
                            sb.append("图识成功(");
                            sb.append(i3);
                            sb.append(")，耗时：");
                            mat = matE0;
                        }
                        mat = matE0;
                    } catch (Exception e6) {
                        e = e6;
                        mat = matE0;
                    }
                } else {
                    mat = matE0;
                }
                i3++;
                matE0 = mat;
            } catch (Throwable th4) {
                th = th4;
                mat = matE0;
            }
        }
        Mat mat2 = matE0;
        if (mat2 == null) {
            return false;
        }
        try {
            mat2.h();
            return false;
        } catch (Exception e7) {
            com.frame.k0.r(e7);
            return false;
        }
    }

    public Bitmap[] X(String str, float f, int i2) {
        List<String> listAsList;
        Bitmap[] bitmapArr = null;
        if (str.startsWith("1")) {
            try {
                listAsList = b8.c().a(Long.parseLong(str)).urls;
            } catch (Exception unused) {
                com.frame.y0.j("未找到指定图集，该图集是否已被删除");
                listAsList = null;
            }
        } else {
            listAsList = Arrays.asList(str.split(","));
        }
        if (listAsList != null) {
            bitmapArr = new Bitmap[listAsList.size()];
            for (int i3 = 0; i3 < listAsList.size(); i3++) {
                String str2 = listAsList.get(i3);
                Bitmap bitmapW = W(str2, f, i2);
                if (bitmapW == null) {
                    com.frame.y0.j("图片识别失败，未找到图片：" + str2);
                    FloatToast.g(j.b.d.g0, "未找到图片:" + str2);
                }
                bitmapArr[i3] = bitmapW;
            }
        }
        return bitmapArr;
    }

    public void X0(long j2) {
        this.e = j2;
    }

    public int Y(Node node) {
        return node.argInt1;
    }

    public Mat Z(Node node, Bitmap bitmap, Rect rect, Rect rect2) {
        if (this.f1525j == null) {
            Paint paint = new Paint();
            this.f1525j = paint;
            paint.setColor(-16777216);
        }
        new Canvas(bitmap).drawRect(rect, this.f1525j);
        return e0(bitmap, node, rect2);
    }

    public Rect a0(Node node, Bitmap bitmap, Rect rect, Bitmap... bitmapArr) {
        Rect rectV0;
        Rect areaOrParam = node.areaParam != null ? node.getAreaOrParam() : (node.getArea() == null || !node.getArea().equals(node.getSrcRect())) ? node.getArea() : null;
        Mat matZ = Z(node, bitmap, rect, areaOrParam);
        if (matZ != null && (rectV0 = V0(node, matZ, areaOrParam, bitmapArr)) != null) {
            matZ.h();
            return rectV0;
        }
        if (matZ != null) {
            matZ.h();
        }
        return null;
    }

    public Bitmap b0(Bitmap bitmap, int i2) {
        if (!i9.v().m()) {
            return null;
        }
        for (int i3 = 0; i3 < 5 && !i9.v().G(); i3++) {
            SystemClock.sleep(100L);
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

    public float d0(Node node) {
        if (node.arg1 == null) {
            return 1.0f;
        }
        return Integer.parseInt(r2) / 100.0f;
    }

    public Mat e0(Bitmap bitmap, Node node, Rect rect) {
        if (!i9.v().m()) {
            return null;
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            com.frame.y0.j("图片识别失败：截图为空或已被回收");
            return null;
        }
        float fD0 = d0(node);
        int iY = Y(node);
        if (rect == null) {
            if (fD0 == 1.0f && iY <= 0) {
                return T(bitmap, this.g);
            }
            Bitmap bitmapCreateScaledBitmap = fD0 != 1.0f ? Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fD0), (int) (bitmap.getHeight() * fD0), false) : bitmap;
            if (iY > 0) {
                Bitmap bitmapB0 = b0(bitmapCreateScaledBitmap, iY);
                if (bitmapCreateScaledBitmap != bitmap) {
                    com.frame.l0.c(bitmapCreateScaledBitmap);
                }
                bitmapCreateScaledBitmap = bitmapB0;
            }
            Mat matT = T(bitmapCreateScaledBitmap, this.g);
            if (bitmapCreateScaledBitmap == bitmap) {
                return matT;
            }
            com.frame.l0.c(bitmapCreateScaledBitmap);
            return matT;
        }
        Rect rect2 = new Rect(rect);
        if (rect2.width() <= 0 || rect2.height() <= 0) {
            com.frame.y0.j("图片识别失败：识别区域宽高异常 " + rect2);
            return null;
        }
        if (rect2.left >= bitmap.getWidth() || rect2.top >= bitmap.getHeight()) {
            com.frame.y0.j("图片识别失败：识别区域起点超出截图范围 " + rect2 + " / " + bitmap.getWidth() + "x" + bitmap.getHeight());
            return null;
        }
        if (rect2.bottom > bitmap.getHeight()) {
            com.frame.y0.j("检查是否是竖屏时截图（当前是横屏状态？）或者是识别区域底部已超出屏幕边界");
            return null;
        }
        if (rect2.right > bitmap.getWidth()) {
            com.frame.y0.j("检查是否是横屏时截图（当前是竖屏状态？）或者是识别区域右边已超出屏幕边界");
            return null;
        }
        if (rect2.left < 0) {
            rect2.left = 0;
            com.frame.y0.j("你的【识别区域】左边小于0 默认帮你改成0了");
        } else if (rect2.top < 0) {
            rect2.top = 0;
            com.frame.y0.j("你的【识别区域】上边小于0 默认帮你改成0了");
        }
        if (rect2.width() <= 0 || rect2.height() <= 0) {
            com.frame.y0.j("图片识别失败：识别区域修正后宽高异常 " + rect2);
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect2.left, rect2.top, rect2.width(), rect2.height(), (Matrix) null, false);
        if (fD0 != 1.0f) {
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (bitmapCreateBitmap.getWidth() * fD0), (int) (bitmapCreateBitmap.getHeight() * fD0), false);
            com.frame.l0.c(bitmapCreateBitmap);
            bitmapCreateBitmap = bitmapCreateScaledBitmap2;
        }
        if (iY > 0) {
            Bitmap bitmapB02 = b0(bitmapCreateBitmap, iY);
            com.frame.l0.c(bitmapCreateBitmap);
            bitmapCreateBitmap = bitmapB02;
        }
        Mat matT2 = T(bitmapCreateBitmap, this.g);
        com.frame.l0.c(bitmapCreateBitmap);
        return matT2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, Runnable runnable) throws JSONException {
        Rect rectV0;
        this.f1523h = 0;
        if (TextUtils.isEmpty(node.srcRectS)) {
            com.frame.y0.j("图片识别：" + node.getStepAndName() + "(没有原始识别区域)");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("图片识别：");
            sb.append(node.getStepAndName());
            sb.append("(");
            sb.append(TextUtils.isEmpty(node.areaParam) ? node.areaS : node.areaParam);
            sb.append(")");
            com.frame.y0.g(sb.toString());
        }
        Bitmap bitmapW = null;
        if (System.currentTimeMillis() - com.frame.k0.b() > 259200000 && AccountTool.d().l() && AccountTool.d().c().getInsertTime() == null) {
            (null == true ? 1 : 0).setText(null);
            return false;
        }
        this.e = System.currentTimeMillis();
        this.f = node.getCompatibility();
        if (node.nextType == 15) {
            da.B().E1(da.B().G(node.arg3), 0);
        }
        Bitmap[] bitmapArrX = X(node.url, d0(node), node.argInt1);
        if (bitmapArrX == null || bitmapArrX.length == 0) {
            com.frame.y0.j("图片识别失败，未找到所有图片");
            da.B().w1("图片识别失败，未找到所有图片");
            return false;
        }
        long j2 = this.f.timeOut;
        if (!i9.v().n()) {
            int i2 = 0;
            while (true) {
                if (i2 >= 15) {
                    break;
                }
                if (i9.v().B()) {
                    SystemClock.sleep(200L);
                    break;
                }
                SystemClock.sleep(250L);
                i2++;
            }
        }
        if (!i9.v().B()) {
            com.frame.y0.j("opencv初始化未成功，请排查一下问题。");
            k(node, runnable);
        }
        Mat matE0 = null;
        while (this.c.q()) {
            try {
                try {
                } finally {
                    com.frame.l0.c(bitmapW);
                    if (matE0 != null) {
                        matE0.h();
                    }
                }
            } catch (Exception e) {
                SystemClock.sleep(150L);
                com.frame.y0.l(e);
                com.frame.y0.j("图片识别错误，联系技术小哥2");
                com.frame.l0.c(bitmapW);
                if (matE0 != null) {
                }
            }
            if (this.f1523h > 0 && System.currentTimeMillis() - this.e > j2) {
                com.frame.l0.c(bitmapW);
                com.frame.l1.e(new Runnable() { // from class: i.b.ka.k3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.g0(node);
                    }
                });
                i9.v().h0();
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                return false;
            }
            bitmapW = i9.v().w(this.e + j2, this.f1523h == 0);
            if (bitmapW == null && this.f1523h == 0 && i9.v().F()) {
                com.frame.l0.c(bitmapW);
                if (matE0 != null) {
                    matE0.h();
                }
                return false;
            }
            if (!this.c.q()) {
                com.frame.l0.c(bitmapW);
                com.frame.l0.c(bitmapW);
                if (matE0 != null) {
                    matE0.h();
                }
                return false;
            }
            if (bitmapW == null) {
                if (System.currentTimeMillis() - this.e > 3000) {
                    this.f1523h++;
                }
                try {
                    Thread.sleep(s());
                } catch (Exception e2) {
                    com.frame.k0.r(e2);
                }
                com.frame.l0.c(bitmapW);
                if (matE0 != null) {
                    matE0.h();
                }
            } else {
                this.f1523h++;
                if (node.nextType != 14) {
                    matE0 = e0(bitmapW, node, node.getAreaOrParam());
                    if (matE0 == null || (rectV0 = V0(node, matE0, node.getAreaOrParam(), bitmapArrX)) == null) {
                        try {
                            Thread.sleep(s());
                        } catch (Exception e3) {
                            com.frame.k0.r(e3);
                        }
                    } else if (U(bitmapW, node, rectV0, runnable, bitmapArrX)) {
                        com.frame.l0.c(bitmapW);
                        if (matE0 != null) {
                            matE0.h();
                        }
                        return true;
                    }
                } else if (W0(bitmapW, node, node.getAreaOrParam(), runnable, bitmapArrX)) {
                    com.frame.l0.c(bitmapW);
                    if (matE0 != null) {
                        matE0.h();
                    }
                    return true;
                }
                com.frame.l0.c(bitmapW);
                if (matE0 != null) {
                    matE0.h();
                }
            }
        }
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.g0;
    }

    @Override // i.b.ka.x5
    public long s() {
        long j2 = da.B().M().imgScanDelay;
        this.f1524i = j2;
        if (j2 < 10) {
            this.f1524i = 10L;
        }
        return this.f1524i;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "图片识别";
    }
}
