package i.b;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.a.ScreenshotAct;
import com.frame.g0;
import com.s.BoxService;
import com.user.AccountTool;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.xmlbeans.XmlValidationError;

@TargetApi(21)
/* loaded from: classes.dex */
public class i9 implements ImageReader.OnImageAvailableListener {
    private static i9 y;
    private Runnable b;
    private Activity c;
    int d;
    private ImageReader e;

    /* renamed from: h, reason: collision with root package name */
    private MediaProjectionManager f1497h;

    /* renamed from: i, reason: collision with root package name */
    private MediaProjection f1498i;

    /* renamed from: j, reason: collision with root package name */
    private VirtualDisplay f1499j;

    /* renamed from: k, reason: collision with root package name */
    private ImageReader f1500k;

    /* renamed from: m, reason: collision with root package name */
    private Intent f1502m;

    /* renamed from: o, reason: collision with root package name */
    private int f1504o;
    private int p;
    private h7 r;
    public final String a = i9.class.getSimpleName();
    private boolean f = false;
    private volatile boolean s = false;
    private volatile boolean t = false;
    private org.opencv.android.n u = new c9(this, com.frame.v0.g());
    int v = 0;
    public Runnable w = new Runnable() { // from class: i.b.a3
        @Override // java.lang.Runnable
        public final void run() {
            this.c.O();
        }
    };
    private MediaProjection.Callback x = new d9(this);
    public h9 g = h9.IDLE;

    /* renamed from: l, reason: collision with root package name */
    private int f1501l = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1503n = false;
    private Handler q = new b9(this, Looper.getMainLooper());

    private i9() {
    }

    private Bitmap A(long j2, boolean z) {
        if (!F()) {
            return y(false);
        }
        t9 t9VarD = t9.d();
        if (t9VarD != null && !t9VarD.q()) {
            return null;
        }
        String strU = u();
        if (strU != null) {
            i0(strU);
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.frame.y0.j("无障碍截图需在工作线程获取");
            return null;
        }
        long jMin = Math.min(2000L, j2 - System.currentTimeMillis());
        if (jMin <= 0) {
            return null;
        }
        g7 g7VarI = k().i(BoxService.m(), SystemClock.uptimeMillis() + jMin, t9VarD);
        Bitmap bitmapD = g7VarI.d();
        if (j0()) {
            if (bitmapD != null) {
                bitmapD.recycle();
            }
            i0(u());
            return null;
        }
        String str = g7VarI.e;
        if (str != null) {
            if (z) {
                str = "首次截图获取失败，尚未执行识别：" + g7VarI.e;
            }
            i0(str);
        } else if (z && bitmapD == null && (t9VarD == null || t9VarD.q())) {
            i0("首次截图获取失败或超时（最多等待2000毫秒），尚未执行识别");
        } else if (!z && g7VarI.f && ((t9VarD == null || t9VarD.q()) && System.currentTimeMillis() >= j2)) {
            com.frame.y0.o("无障碍截图：等待下一帧时节点已超时，执行超时处理");
        }
        return bitmapD;
    }

    public static boolean J() {
        i9 i9Var = y;
        if (i9Var != null) {
            return i9Var.g == h9.RUNNING || y.f1498i == null;
        }
        return false;
    }

    static /* synthetic */ void L(Rect rect, int i2, float f) {
        try {
            GesturePlayFloatView.B(rect);
            GesturePlayFloatView.v(i2, (int) f);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void M(Rect rect, int i2, int i3) {
        try {
            GesturePlayFloatView.B(rect);
            GesturePlayFloatView.v(i2, i3);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O() {
        if (com.frame.v0.g().d() == null || !com.frame.v0.g().d().getClass().equals(ScreenshotAct.class)) {
            k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(final String str) {
        SystemClock.sleep(300L);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i2 = 0; i2 < 20; i2++) {
            try {
                SystemClock.sleep(250L);
                ArrayList arrayList = new ArrayList();
                AccessibilityWindowInfo accessibilityWindowInfo = BoxService.m().getWindows().get(r6.size() - 1);
                if (accessibilityWindowInfo != null) {
                    AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                    if (root != null) {
                        r(0, root, arrayList, new com.frame.h0() { // from class: i.b.c3
                            @Override // com.frame.h0
                            public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
                                return i9.R(atomicReference2, str, atomicReference, atomicBoolean, accessibilityNodeInfo);
                            }
                        });
                    }
                    if (atomicReference2.get() != null) {
                        s0((AccessibilityNodeInfo) atomicReference2.get());
                        return;
                    }
                    if (!arrayList.isEmpty()) {
                        try {
                            com.frame.g0.v().f(arrayList.get(0), 2).performAction(16);
                            return;
                        } catch (Exception e) {
                            com.frame.y0.l(e);
                            com.frame.y0.j("自动触发权限点击：失败");
                            return;
                        }
                    }
                    if (atomicBoolean.get() && atomicReference.get() != null) {
                        x7.d().b(200L);
                        com.frame.g0.v().p(null, com.frame.g0.v().b(((AccessibilityNodeInfo) atomicReference.get()).getText().toString()), new g0.a() { // from class: i.b.x2
                            @Override // com.frame.g0.a
                            public final void a(AccessibilityNodeInfo accessibilityNodeInfo) {
                                this.a.T(accessibilityNodeInfo);
                            }
                        });
                        return;
                    }
                }
            } catch (Exception e2) {
                com.frame.y0.l(e2);
            }
        }
    }

    static /* synthetic */ boolean R(AtomicReference atomicReference, String str, AtomicReference atomicReference2, AtomicBoolean atomicBoolean, AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null && (text.toString().contains("单个") || text.toString().contains("共享一个应用"))) {
            atomicReference.set(accessibilityNodeInfo);
            return true;
        }
        if (accessibilityNodeInfo.getContentDescription() != null) {
            String string = accessibilityNodeInfo.getContentDescription().toString();
            return string.contains(str) && string.length() <= 4;
        }
        if (text == null) {
            return false;
        }
        String string2 = text.toString();
        if (string2.contains(str) && string2.length() <= 4) {
            return true;
        }
        if ((string2.equals("取消") || string2.equals("禁止")) && accessibilityNodeInfo.isVisibleToUser()) {
            atomicReference2.set(accessibilityNodeInfo);
            com.frame.y0.o("找到取消按钮");
            return false;
        }
        if (!string2.contains("录制")) {
            return false;
        }
        atomicBoolean.set(true);
        com.frame.y0.o("录制权限页面");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(AccessibilityNodeInfo accessibilityNodeInfo) {
        int iE;
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        a9.g();
        try {
            iE = com.frame.v0.g().d().getWindow().getDecorView().getWidth() / 2;
        } catch (Exception unused) {
            iE = com.frame.k0.c().e() / 2;
        }
        if (Math.abs(iE - rect.centerX()) < 20) {
            com.frame.y0.o("横屏点击上面的按钮（按钮是上下分布的）");
            q(rect);
        } else {
            com.frame.y0.o("竖屏点击有边按钮（按钮是左右分布的）");
            p(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(t9 t9Var, String str) {
        if (da.B().N() == t9Var) {
            da.B().h2();
            W(str);
        }
    }

    static /* synthetic */ AccessibilityNodeInfo Y(AccessibilityNodeInfo accessibilityNodeInfo) {
        String[] strArr = {"开始", "共享屏幕", "继续", "允许"};
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                String str = strArr[i2];
                for (AccessibilityNodeInfo accessibilityNodeInfo2 : accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) {
                    if (accessibilityNodeInfo2.getText() != null && accessibilityNodeInfo2.getText().toString().length() < 5 && accessibilityNodeInfo2.getText().toString().contains(str)) {
                        return accessibilityNodeInfo2;
                    }
                    if (accessibilityNodeInfo2.getContentDescription() != null && accessibilityNodeInfo2.getContentDescription().toString().length() < 5 && accessibilityNodeInfo2.getContentDescription().toString().contains(str)) {
                        return accessibilityNodeInfo2;
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 36) {
            Z(accessibilityNodeInfo);
            SystemClock.sleep(500L);
            com.frame.g0.v().p(null, com.frame.g0.v().a(6, "立即开始", "开始"), new g0.a() { // from class: i.b.v2
                @Override // com.frame.g0.a
                public final void a(AccessibilityNodeInfo accessibilityNodeInfo2) {
                    this.a.a0(accessibilityNodeInfo2);
                }
            });
        } else {
            if (accessibilityNodeInfo.performAction(16)) {
                return;
            }
            try {
                if (com.frame.g0.v().f(accessibilityNodeInfo, 2).performAction(16)) {
                    return;
                }
                Z(accessibilityNodeInfo);
            } catch (Exception e) {
                Z(accessibilityNodeInfo);
                com.frame.k0.r(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!accessibilityNodeInfo.performAction(16)) {
            try {
                if (!com.frame.g0.v().f(accessibilityNodeInfo, 3).performAction(16)) {
                    Z(accessibilityNodeInfo);
                }
            } catch (Exception e) {
                Z(accessibilityNodeInfo);
                com.frame.k0.r(e);
            }
        }
        com.frame.g0.v().p(null, new g0.b() { // from class: i.b.w2
            @Override // com.frame.g0.b
            public final AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo2) {
                return i9.Y(accessibilityNodeInfo2);
            }
        }, new g0.a() { // from class: i.b.e3
            @Override // com.frame.g0.a
            public final void a(AccessibilityNodeInfo accessibilityNodeInfo2) {
                this.a.c0(accessibilityNodeInfo2);
            }
        });
    }

    private void i0(final String str) {
        com.frame.y0.j(str);
        t9 t9VarD = t9.d();
        final t9 t9VarN = da.B().N();
        if (t9VarD == null) {
            com.frame.l1.e(new Runnable() { // from class: i.b.u2
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.X(str);
                }
            });
        } else if (t9VarD.q()) {
            t9VarD.l0();
            if (t9VarN != null) {
                t9VarN.l0();
            }
            com.frame.l1.e(new Runnable() { // from class: i.b.b3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.V(t9VarN, str);
                }
            });
        }
    }

    private synchronized h7 k() {
        if (this.r == null) {
            this.r = new h7();
        }
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void X(String str) {
        FloatToast.i(str);
        if (j0()) {
            this.b = null;
            q0();
        }
    }

    private void s0(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            com.frame.g0.v().f(accessibilityNodeInfo, 3).performAction(16);
            com.frame.g0.v().p(null, com.frame.g0.v().a(7, "共享整个屏幕", "整个", "全", "屏幕"), new g0.a() { // from class: i.b.y2
                @Override // com.frame.g0.a
                public final void a(AccessibilityNodeInfo accessibilityNodeInfo2) {
                    this.a.e0(accessibilityNodeInfo2);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public static synchronized i9 v() {
        if (y == null) {
            y = new i9();
        }
        return y;
    }

    public boolean B() {
        return F() ? u() == null : (!this.t || this.f1498i == null || this.g == h9.IDLE) ? false : true;
    }

    public void C() {
        MediaProjection mediaProjection = this.f1498i;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.f1498i = null;
        }
        VirtualDisplay virtualDisplay = this.f1499j;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.f1499j = null;
        }
        ImageReader imageReader = this.f1500k;
        if (imageReader != null) {
            imageReader.setOnImageAvailableListener(null, null);
            this.f1500k.close();
            this.f1500k = null;
        }
        this.e = null;
        this.g = h9.IDLE;
        this.c = null;
    }

    public void D(Activity activity) {
        if (F()) {
            q0();
            activity.finish();
            return;
        }
        com.frame.y0.j("ScreenCaptureManager.init()");
        C();
        this.c = activity;
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) activity.getSystemService("media_projection");
        this.f1497h = mediaProjectionManager;
        if (mediaProjectionManager == null || this.g != h9.IDLE) {
            return;
        }
        activity.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), XmlValidationError.INCORRECT_ATTRIBUTE);
        this.g = h9.RUNNING;
    }

    public synchronized void E() {
        if (!this.s && !this.t) {
            this.s = true;
            try {
                if (org.opencv.android.w.b()) {
                    this.u.b(0);
                } else if (!org.opencv.android.w.a("3.4.1", com.frame.v0.g(), this.u)) {
                    this.s = false;
                    com.frame.y0.j("OpenCV初始化失败：原生库未加载，无法启动异步初始化");
                }
            } catch (LinkageError | RuntimeException e) {
                this.t = false;
                this.s = false;
                com.frame.y0.j("OpenCV初始化失败：" + e);
            }
        }
    }

    public boolean F() {
        return !da.B().O() && da.B().M().useAccessibilityScreenshot;
    }

    public boolean G() {
        return this.t;
    }

    public boolean H() {
        boolean zA = com.frame.n0.a("ifca", true);
        if (zA) {
            return false;
        }
        return com.frame.w0.d() && !(zA && com.frame.s0.g().m(FloatHandlerRecord.class)) && da.B().M().isAutoClickScanPermission;
    }

    public boolean I() {
        return !this.s && this.t;
    }

    public boolean K(Image image) {
        try {
            if (com.frame.k0.c().d() == image.getHeight() && com.frame.k0.c().e() == image.getWidth()) {
                return true;
            }
            com.frame.y0.o("横竖屏切换:（截图：" + image.getWidth() + "," + image.getHeight() + "）-->（屏幕：" + com.frame.k0.c().e() + "," + com.frame.k0.c().d() + "）");
            return false;
        } catch (Exception e) {
            com.frame.y0.l(e);
            return false;
        }
    }

    public void f0() {
        final String str = da.B().M().scanButtonText;
        com.frame.y0.o("触发点击：" + str);
        com.frame.l1.g(new Runnable() { // from class: i.b.f3
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Q(str);
            }
        });
    }

    public void g0() {
        if (F()) {
            return;
        }
        this.q.removeMessages(1993);
        this.q.sendEmptyMessageDelayed(1993, 5000L);
    }

    public void h0() {
        this.q.removeMessages(1993);
    }

    public boolean j0() {
        return F() && !AccountTool.d().m();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {, blocks: (B:7:0x000a, B:9:0x001a, B:13:0x0025, B:16:0x002b, B:19:0x0030, B:20:0x0033, B:22:0x0039, B:26:0x0041, B:27:0x0043, B:28:0x0078, B:30:0x007c, B:32:0x009c, B:37:0x00b1, B:33:0x00a0, B:36:0x00a7, B:25:0x003e, B:12:0x0022), top: B:46:0x000a, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {, blocks: (B:7:0x000a, B:9:0x001a, B:13:0x0025, B:16:0x002b, B:19:0x0030, B:20:0x0033, B:22:0x0039, B:26:0x0041, B:27:0x0043, B:28:0x0078, B:30:0x007c, B:32:0x009c, B:37:0x00b1, B:33:0x00a0, B:36:0x00a7, B:25:0x003e, B:12:0x0022), top: B:46:0x000a, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[Catch: Exception -> 0x00a6, all -> 0x00b3, TryCatch #3 {Exception -> 0x00a6, blocks: (B:28:0x0078, B:30:0x007c, B:32:0x009c, B:33:0x00a0), top: B:49:0x0078, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0 A[Catch: Exception -> 0x00a6, all -> 0x00b3, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a6, blocks: (B:28:0x0078, B:30:0x007c, B:32:0x009c, B:33:0x00a0), top: B:49:0x0078, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k0() {
        ImageReader imageReader;
        VirtualDisplay virtualDisplay;
        MediaProjection mediaProjection;
        if (F()) {
            return;
        }
        synchronized (this.a) {
            this.g = h9.RUNNING;
            com.frame.y0.j("resetVirtualDisplay");
            ImageReader imageReader2 = this.f1500k;
            this.f1500k = null;
            if (imageReader2 != null) {
                try {
                    imageReader2.setOnImageAvailableListener(null, null);
                    imageReader2.close();
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
                imageReader = this.e;
                if (imageReader != null || imageReader == imageReader2) {
                    this.e = null;
                    virtualDisplay = this.f1499j;
                    if (virtualDisplay != null) {
                        try {
                            virtualDisplay.release();
                        } catch (Exception e2) {
                            com.frame.k0.r(e2);
                        }
                        this.f1499j = null;
                        a9.g();
                        this.d = com.frame.v0.g().getResources().getDisplayMetrics().densityDpi;
                        this.f1504o = com.frame.k0.c().e();
                        int iD = com.frame.k0.c().d();
                        this.p = iD;
                        ImageReader imageReaderNewInstance = ImageReader.newInstance(this.f1504o, iD, 1, 1);
                        this.f1500k = imageReaderNewInstance;
                        imageReaderNewInstance.setOnImageAvailableListener(this, null);
                        try {
                            mediaProjection = this.f1498i;
                            if (mediaProjection == null) {
                                this.f1499j = mediaProjection.createVirtualDisplay("AutoScreenshot", this.f1504o, this.p, this.d, 16, this.f1500k.getSurface(), null, null);
                                this.g = h9.RUNNING;
                                if (H()) {
                                    f0();
                                }
                            } else {
                                com.frame.y0.j("录屏权限重启失败：mediaProjection=null");
                            }
                        } catch (Exception e3) {
                            com.frame.y0.l(e3);
                            p0(this.f1501l, this.f1502m);
                        }
                    } else {
                        a9.g();
                        this.d = com.frame.v0.g().getResources().getDisplayMetrics().densityDpi;
                        this.f1504o = com.frame.k0.c().e();
                        int iD2 = com.frame.k0.c().d();
                        this.p = iD2;
                        ImageReader imageReaderNewInstance2 = ImageReader.newInstance(this.f1504o, iD2, 1, 1);
                        this.f1500k = imageReaderNewInstance2;
                        imageReaderNewInstance2.setOnImageAvailableListener(this, null);
                        mediaProjection = this.f1498i;
                        if (mediaProjection == null) {
                        }
                    }
                } else {
                    try {
                        imageReader.close();
                    } catch (Exception e4) {
                        com.frame.k0.r(e4);
                    }
                    this.e = null;
                    virtualDisplay = this.f1499j;
                    if (virtualDisplay != null) {
                    }
                }
            } else {
                imageReader = this.e;
                if (imageReader != null) {
                    this.e = null;
                    virtualDisplay = this.f1499j;
                    if (virtualDisplay != null) {
                    }
                }
            }
        }
    }

    public synchronized void l() {
        h7 h7Var = this.r;
        if (h7Var != null) {
            h7Var.h();
        }
    }

    public void l0() {
        if (F()) {
            return;
        }
        com.frame.y0.g("ScreenCaptureManager.getInstance().resume()");
        if (!this.f) {
            p0(this.f1501l, this.f1502m);
        } else {
            this.f = false;
            k0();
        }
    }

    public boolean m() {
        if (!I()) {
            E();
            if (this.s) {
                SystemClock.sleep(500L);
            }
        }
        return I();
    }

    public void m0(boolean z) {
        this.f = z;
    }

    public boolean n() {
        if (j0()) {
            q0();
            return false;
        }
        E();
        if (F()) {
            String strU = u();
            if (strU != null) {
                i0(strU);
            }
            return strU == null;
        }
        this.v = 0;
        com.frame.l1.i(1994);
        if (!v().B()) {
            q0();
            return false;
        }
        if (this.g == h9.IDLE || this.f) {
            com.frame.l1.e(new Runnable() { // from class: i.b.a7
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l0();
                }
            });
        } else {
            g0();
        }
        return true;
    }

    public void n0(Runnable runnable) {
        this.b = runnable;
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a0(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int iCenterX = rect.centerX();
        float fCenterY = rect.centerY();
        Path path = new Path();
        float f = iCenterX;
        path.moveTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        try {
            com.frame.w0.b().dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 120L)).build(), new e9(this), null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        if (imageReader == this.f1500k) {
            this.e = imageReader;
        }
    }

    public void p(final Rect rect) {
        final int iE = com.frame.k0.c().e() - rect.centerX();
        final float fCenterY = rect.centerY();
        Path path = new Path();
        float f = iE;
        path.moveTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        com.frame.l1.e(new Runnable() { // from class: i.b.z2
            @Override // java.lang.Runnable
            public final void run() {
                i9.L(rect, iE, fCenterY);
            }
        });
        try {
            com.frame.w0.b().dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 120L)).build(), new f9(this), null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void p0(int i2, Intent intent) {
        if (F()) {
            Activity activity = this.c;
            if (activity != null) {
                activity.finish();
            }
            this.c = null;
            return;
        }
        com.frame.y0.j("ScreenCaptureManager.start()");
        MediaProjectionManager mediaProjectionManager = this.f1497h;
        if (mediaProjectionManager != null) {
            try {
                MediaProjection mediaProjection = mediaProjectionManager.getMediaProjection(i2, intent);
                this.f1498i = mediaProjection;
                if (mediaProjection != null) {
                    this.f1501l = i2;
                    this.f1502m = intent;
                    k0();
                    Activity activity2 = this.c;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    this.c = null;
                    this.f1498i.registerCallback(this.x, null);
                } else {
                    com.frame.y0.j("可能出错了：mediaProjection=null");
                }
                com.frame.y0.n("Capture screen start success!");
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                    this.b = null;
                }
            } catch (Exception e) {
                com.frame.y0.l(e);
                q0();
            }
        } else {
            com.frame.y0.j("Capture screen start failed! ProjectionManager is null");
        }
        this.g = h9.RUNNING;
    }

    public void q(final Rect rect) {
        final int iCenterX = rect.centerX();
        final int iCenterY = rect.centerY() - (rect.height() * 3);
        Path path = new Path();
        float f = iCenterX;
        float f2 = iCenterY;
        path.moveTo(f, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2);
        com.frame.l1.e(new Runnable() { // from class: i.b.d3
            @Override // java.lang.Runnable
            public final void run() {
                i9.M(rect, iCenterX, iCenterY);
            }
        });
        try {
            com.frame.w0.b().dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 120L)).build(), new g9(this), null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public synchronized void q0() {
        E();
        if (j0()) {
            l();
        } else if (F()) {
            String strU = u();
            if (strU != null) {
                this.b = null;
                i0(strU);
            } else {
                Runnable runnable = this.b;
                if (runnable != null) {
                    this.b = null;
                    com.frame.l1.e(runnable);
                }
            }
            return;
        }
        if (com.frame.v0.g().d() == null || !com.frame.v0.g().d().getClass().equals(ScreenshotAct.class)) {
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ScreenshotAct.class);
            if (!com.frame.v0.g().k()) {
                intent.setFlags(268468224);
            }
            com.frame.v0.g().startActivity(intent);
        }
    }

    public List<AccessibilityNodeInfo> r(int i2, AccessibilityNodeInfo accessibilityNodeInfo, List<AccessibilityNodeInfo> list, com.frame.h0 h0Var) {
        if (i2 > 100) {
            return null;
        }
        for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                if (child != null && !child.equals(accessibilityNodeInfo)) {
                    try {
                        if (child.getChildCount() != 0) {
                            r(i2 + 1, child, list, h0Var);
                        } else if (h0Var.a(child)) {
                            list.add(child);
                        }
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                    }
                }
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
        return null;
    }

    public void r0() {
        if (F()) {
            l();
            return;
        }
        com.frame.y0.o("ScreenCaptureManager.getInstance().stop()");
        synchronized (this.a) {
            com.frame.l1.i(1993);
            if (da.B().M().isReleaseScreenCapAfterStop) {
                com.frame.y0.o("释放录屏资源");
                s();
            }
        }
    }

    public void s() {
        l();
        com.frame.y0.j("ScreenCaptureManager.getInstance().forceStop()");
        com.frame.l1.i(1993);
        this.f = true;
        this.f1503n = false;
        this.g = h9.IDLE;
        VirtualDisplay virtualDisplay = this.f1499j;
        if (virtualDisplay != null) {
            try {
                virtualDisplay.release();
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        MediaProjection mediaProjection = this.f1498i;
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(this.x);
            this.f1498i.stop();
            this.f1498i = null;
        }
        ImageReader imageReader = this.f1500k;
        if (imageReader != null) {
            imageReader.setOnImageAvailableListener(null, null);
            this.f1500k.close();
            this.f1500k = null;
        }
        this.e = null;
        this.f1499j = null;
    }

    public String t() {
        if (da.B().O()) {
            return "当前为 HID 模式，仅支持录屏模式";
        }
        if (Build.VERSION.SDK_INT < 30) {
            return "无障碍截图需要 Android 11 及以上";
        }
        return null;
    }

    public String u() {
        String strT = t();
        if (strT != null) {
            return strT;
        }
        if (!AccountTool.d().m()) {
            return "无障碍截图模式需要 VIP，请先开通 VIP 或选择录屏权限模式";
        }
        if (!com.frame.w0.d() || BoxService.m() == null) {
            return "截图模式需要先开启无障碍服务";
        }
        AccessibilityServiceInfo serviceInfo = BoxService.m().getServiceInfo();
        if (serviceInfo == null || (serviceInfo.getCapabilities() & 128) == 0) {
            return "无障碍截图能力未生效，请关闭后重新开启无障碍服务";
        }
        return null;
    }

    public Bitmap w(long j2, boolean z) {
        if (z && F()) {
            j2 = System.currentTimeMillis() + 2000;
        }
        return A(j2, z);
    }

    public Bitmap x() {
        return y(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap y(boolean z) {
        Throwable th;
        Image imageAcquireNextImage;
        Bitmap bitmapCreateBitmap;
        int width;
        int height;
        Bitmap bitmapCreateBitmap2;
        if (F()) {
            return z(System.currentTimeMillis() + 2000);
        }
        synchronized (this.a) {
            ImageReader imageReader = this.e;
            Bitmap bitmap = null;
            if (imageReader != null && this.g != h9.IDLE) {
                if (this.v > 7) {
                    com.frame.y0.j("错误次数：=" + this.v + "，录屏触发重置");
                    this.v = 0;
                    this.q.post(this.w);
                    return null;
                }
                try {
                    imageAcquireNextImage = imageReader.acquireNextImage();
                } catch (Exception e) {
                    e = e;
                    imageAcquireNextImage = null;
                    bitmapCreateBitmap = null;
                } catch (Throwable th2) {
                    th = th2;
                    imageAcquireNextImage = null;
                }
                if (imageAcquireNextImage == null) {
                    if (imageAcquireNextImage != null) {
                        try {
                            imageAcquireNextImage.close();
                        } catch (Exception e2) {
                            com.frame.k0.r(e2);
                        }
                    }
                    return null;
                }
                try {
                    try {
                        if (K(imageAcquireNextImage)) {
                            try {
                                Image.Plane plane = imageAcquireNextImage.getPlanes()[0];
                                ByteBuffer buffer = plane.getBuffer();
                                width = imageAcquireNextImage.getWidth();
                                height = imageAcquireNextImage.getHeight();
                                int pixelStride = plane.getPixelStride();
                                int rowStride = (plane.getRowStride() - (pixelStride * width)) / pixelStride;
                                bitmapCreateBitmap2 = Bitmap.createBitmap(width + rowStride, height, Bitmap.Config.ARGB_8888);
                                bitmapCreateBitmap2.copyPixelsFromBuffer(buffer);
                                if (rowStride > 0) {
                                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap2, 0, 0, width, height);
                                    try {
                                        com.frame.l0.c(bitmapCreateBitmap2);
                                        bitmapCreateBitmap2 = bitmapCreateBitmap;
                                    } catch (Exception e3) {
                                        e = e3;
                                        try {
                                            this.v++;
                                            com.frame.y0.l(e);
                                            bitmap = bitmapCreateBitmap;
                                            if (imageAcquireNextImage != null) {
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            this.v++;
                                            com.frame.y0.l(e);
                                            if (this.e != null && e.getMessage() != null && e.getMessage().contains("maxImages")) {
                                                this.e.close();
                                                this.e = null;
                                            }
                                            if (imageAcquireNextImage != null) {
                                                try {
                                                    imageAcquireNextImage.close();
                                                } catch (Exception e5) {
                                                    com.frame.k0.r(e5);
                                                }
                                            }
                                            bitmap = bitmapCreateBitmap;
                                            return bitmap;
                                        }
                                        return bitmap;
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                bitmapCreateBitmap = null;
                            }
                            try {
                                int pixel = bitmapCreateBitmap2.getPixel(width / 2, height / 2);
                                if (bitmapCreateBitmap2.getWidth() == 0 || Color.alpha(pixel) == 0) {
                                    com.frame.y0.j("录屏图片没有颜色特征，触发重置(width=" + width + ",height=" + height + ")");
                                    this.v = this.v + 2;
                                    if (imageAcquireNextImage != null) {
                                        try {
                                            imageAcquireNextImage.close();
                                        } catch (Exception e7) {
                                            com.frame.k0.r(e7);
                                        }
                                    }
                                    return null;
                                }
                                h0();
                                this.v = 0;
                                bitmap = bitmapCreateBitmap2;
                            } catch (Exception e8) {
                                e = e8;
                                bitmapCreateBitmap = bitmapCreateBitmap2;
                                this.v++;
                                com.frame.y0.l(e);
                                bitmap = bitmapCreateBitmap;
                                if (imageAcquireNextImage != null) {
                                }
                                return bitmap;
                            }
                        } else {
                            this.v = 0;
                            if (Build.VERSION.SDK_INT >= 33 && this.f1499j != null) {
                                com.frame.y0.j("virtualDisplay.release()");
                                this.f1499j.release();
                                this.f1499j = null;
                            }
                            com.frame.y0.j("横竖屏不一致，触发重置");
                            this.q.post(this.w);
                        }
                        if (imageAcquireNextImage != null) {
                            try {
                                imageAcquireNextImage.close();
                            } catch (Exception e9) {
                                com.frame.k0.r(e9);
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        bitmapCreateBitmap = null;
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    if (imageAcquireNextImage != null) {
                        try {
                            imageAcquireNextImage.close();
                        } catch (Exception e11) {
                            com.frame.k0.r(e11);
                        }
                    }
                    throw th;
                }
            }
            return null;
        }
    }

    public Bitmap z(long j2) {
        return A(j2, false);
    }
}
