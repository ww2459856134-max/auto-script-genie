package i.b.ka;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.s.BoxService;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.TextScanDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.WidgetFeature;
import i.b.da;
import i.b.i9;
import i.b.p8;
import i.b.t9;
import i.b.v8;
import i.b.x7;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes.dex */
public class g7 extends s7 {

    /* renamed from: i, reason: collision with root package name */
    private Node f1527i;

    /* renamed from: j, reason: collision with root package name */
    private long f1528j;

    /* renamed from: k, reason: collision with root package name */
    private int f1529k = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0(int i2, lt ltVar, Node node) {
        if (i2 != 1) {
            v8.m().f0(node);
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.f4
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 1000L);
        }
        Q(ltVar, node);
    }

    static /* synthetic */ void i0(Rect rect) {
        com.frame.s0.g().E(GesturePlayFloatView.class);
        GesturePlayFloatView.B(rect);
    }

    private boolean l0(t9 t9Var, String str, String str2, String str3, Bitmap bitmap, Node node, Rect rect, float f, Runnable runnable) {
        if (!i9.v().m() || t9Var == null || bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        try {
            p8 p8VarA = t9Var.a0(node.ocrEngine, str2, str3, bitmap).a(str);
            if (p8VarA == null) {
                return false;
            }
            String strF = p8VarA.f();
            final Rect rect2 = new Rect(p8VarA.d(), p8VarA.g(), p8VarA.e(), p8VarA.b());
            m0(rect2, rect, f);
            com.frame.y0.i(String.format(Locale.ROOT, "单词: '%s' | 置信度: %.2f | 位置: [%d,%d,%d,%d]", strF, Float.valueOf(p8VarA.c() * 100.0f), Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.right), Integer.valueOf(rect2.bottom)));
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.h4
                @Override // java.lang.Runnable
                public final void run() {
                    g7.i0(rect2);
                }
            });
            if (node.nextType == 7) {
                node.nextType = 0;
            }
            if (node.nextType != 9) {
                l(node, rect2, runnable);
                return true;
            }
            com.frame.y0.g("OCR文本写入变量：" + node.arg3);
            da.B().E1(da.B().G(node.arg3), strF);
            t9Var.W(runnable);
            return true;
        } catch (i.b.ja.n e) {
            throw e;
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            return false;
        }
    }

    static Rect m0(Rect rect, Rect rect2, float f) {
        if (f != 1.0f) {
            rect.set(Math.round(rect.left / f), Math.round(rect.top / f), Math.round(rect.right / f), Math.round(rect.bottom / f));
        }
        if (rect2 != null) {
            rect.offset(rect2.left, rect2.top);
        }
        return rect;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public int B() {
        return 4;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        TextScanDialogView textScanDialogView = (TextScanDialogView) com.frame.s0.g().B(TextScanDialogView.class);
        textScanDialogView.Z(task, node.getCompatibility());
        textScanDialogView.setNeedAcceptScan(false);
        textScanDialogView.Y(ltVar);
        if (i2 == 1) {
            textScanDialogView.setMiniModel();
        }
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public void R(final int i2, final lt ltVar) {
        MultiGestureRecordFloatView.E();
        Node nodeQ = v8.m().Q();
        nodeQ.text = null;
        nodeQ.timeOut = 5000L;
        nodeQ.nextDelay = "0";
        nodeQ.nextType = 7;
        nodeQ.errorType = 2;
        nodeQ.arg2 = "0";
        nodeQ.type = 4;
        nodeQ.duration = 50L;
        nodeQ.delay = "500";
        TextScanDialogView textScanDialogView = (TextScanDialogView) com.frame.s0.g().B(TextScanDialogView.class);
        textScanDialogView.Z(v8.m().p(), nodeQ);
        textScanDialogView.Y(new lt() { // from class: i.b.ka.g4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.k0(i2, ltVar, node);
            }
        });
        if (i2 == 1) {
            textScanDialogView.setMiniModel();
        }
        if (da.B().C().size() >= 4 || !com.frame.n0.a("guideAudio", true)) {
            return;
        }
        da.B().B1("record_text.mp4");
    }

    @Override // i.b.ka.s7
    public void W(Node node) {
        this.f1528j = System.currentTimeMillis();
        this.f1527i = node;
        WidgetFeature widgetFeature = new WidgetFeature();
        this.f = widgetFeature;
        widgetFeature.pathToggle = false;
        widgetFeature.classToggle = false;
        widgetFeature.textToggle = true;
        widgetFeature.idToggle = false;
        widgetFeature.textType = node.what == 0 ? 2 : 1;
        widgetFeature.text = da.B().G(node.text);
        WidgetFeature widgetFeature2 = this.f;
        widgetFeature2.desc = widgetFeature2.text;
        if ("1".equals(this.f1527i.arg4)) {
            WidgetFeature widgetFeature3 = this.f;
            widgetFeature3.descToggle = true;
            widgetFeature3.descType = node.what != 0 ? 1 : 2;
            widgetFeature3.textToggle = false;
        } else {
            WidgetFeature widgetFeature4 = this.f;
            widgetFeature4.descToggle = false;
            widgetFeature4.textToggle = true;
        }
        this.g = new r7(this, node, !"0".equals(node.arg5));
    }

    public boolean f0(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws Throwable {
        Bitmap bitmap;
        long j2;
        Bitmap bitmapH0;
        Rect areaOrParam;
        t9 t9Var = this.c;
        this.f1529k = 0;
        this.f1528j = System.currentTimeMillis();
        long j3 = node.timeOut;
        i9.v().n();
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = null;
        while (this.c.q()) {
            if (this.f1529k > 0 && System.currentTimeMillis() - this.f1528j > j3) {
                com.frame.l0.c(bitmap3);
                FloatToast.g(j.b.d.g0, O(node, this.f1528j));
                i9.v().h0();
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                return false;
            }
            Bitmap bitmapW = i9.v().w(this.f1528j + j3, this.f1529k == 0);
            if (bitmapW == null && this.f1529k == 0 && i9.v().F()) {
                return false;
            }
            if (!this.c.q()) {
                com.frame.l0.c(bitmapW);
                return false;
            }
            if (bitmapW == null) {
                if (System.currentTimeMillis() - this.f1528j > 3000) {
                    this.f1529k++;
                }
                try {
                    Thread.sleep(50L);
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            } else {
                try {
                    areaOrParam = node.getAreaOrParam();
                } catch (i.b.ja.n e2) {
                    e = e2;
                    bitmap = bitmapW;
                } catch (Exception e3) {
                    e = e3;
                    bitmap = bitmapW;
                    j2 = j3;
                    bitmapH0 = null;
                } catch (Throwable th) {
                    th = th;
                    bitmap = bitmapW;
                }
                if (node.hasAreaResolveError()) {
                    i9.v().h0();
                    x7.d().b(node.getErrorDelay());
                    k(node, runnable);
                    com.frame.l0.c(bitmapW);
                    com.frame.l0.c(null);
                    return false;
                }
                bitmapH0 = h0(bitmapW, node, areaOrParam);
                try {
                    this.f1529k++;
                } catch (i.b.ja.n e4) {
                    e = e4;
                    bitmap = bitmapW;
                } catch (Exception e5) {
                    e = e5;
                    bitmap = bitmapW;
                    j2 = j3;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = bitmapW;
                }
                if (bitmapH0 == null) {
                    com.frame.l0.c(bitmapW);
                    com.frame.l0.c(bitmapH0);
                } else {
                    bitmap = bitmapW;
                    j2 = j3;
                    try {
                        try {
                            if (l0(t9Var, da.B().G(node.text), null, "chi_sim", bitmapH0, node, areaOrParam, g0(node), runnable)) {
                                com.frame.l0.c(bitmap);
                                com.frame.l0.c(bitmapH0);
                                return true;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bitmap2 = bitmapH0;
                            com.frame.l0.c(bitmap);
                            com.frame.l0.c(bitmap2);
                            throw th;
                        }
                    } catch (i.b.ja.n e6) {
                        e = e6;
                        bitmap2 = bitmapH0;
                        try {
                            i.b.ja.o.l(e);
                            com.frame.y0.j(e.getMessage());
                            i9.v().h0();
                            x7.d().b(node.getErrorDelay());
                            k(node, runnable);
                            com.frame.l0.c(bitmap);
                            com.frame.l0.c(bitmap2);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            com.frame.l0.c(bitmap);
                            com.frame.l0.c(bitmap2);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        com.frame.k0.r(e);
                        com.frame.l0.c(bitmap);
                        com.frame.l0.c(bitmapH0);
                        bitmap3 = bitmap;
                        j3 = j2;
                    }
                    com.frame.l0.c(bitmap);
                    com.frame.l0.c(bitmapH0);
                    bitmap3 = bitmap;
                    j3 = j2;
                }
            }
            bitmap = bitmapW;
            j2 = j3;
            bitmap3 = bitmap;
            j3 = j2;
        }
        return false;
    }

    public float g0(Node node) {
        if (node.arg1 == null) {
            return 1.0f;
        }
        return Integer.parseInt(r2) / 100.0f;
    }

    public Bitmap h0(Bitmap bitmap, Node node, Rect rect) {
        if (!i9.v().m()) {
            return null;
        }
        float fG0 = g0(node);
        if (rect == null) {
            return (fG0 == 1.0f || fG0 == 1.0f) ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * fG0), (int) (bitmap.getHeight() * fG0), false);
        }
        if (rect.left >= bitmap.getWidth() || rect.width() > bitmap.getWidth() || rect.height() > bitmap.getHeight() || rect.top >= bitmap.getHeight()) {
            com.frame.y0.j("文字匹配OCR：识别区域超出截图范围 " + rect + " / " + bitmap.getWidth() + "x" + bitmap.getHeight());
            return null;
        }
        if (rect.bottom > bitmap.getHeight()) {
            com.frame.y0.j("检查是否是竖屏时截图（当前是横屏状态？）或者是识别区域底部已超出屏幕边界");
            return null;
        }
        if (rect.right > bitmap.getWidth()) {
            com.frame.y0.j("检查是否是横屏时截图（当前是竖屏状态？）或者是识别区域右边已超出屏幕边界");
            return null;
        }
        if (rect.left < 0) {
            rect.left = 0;
            com.frame.y0.j("你的【识别区域】左边小于0 默认帮你改成0了");
        } else if (rect.top < 0) {
            rect.top = 0;
            com.frame.y0.j("你的【识别区域】上边小于0 默认帮你改成0了");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), (Matrix) null, false);
        if (fG0 == 1.0f) {
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (bitmapCreateBitmap.getWidth() * fG0), (int) (bitmapCreateBitmap.getHeight() * fG0), false);
        com.frame.l0.c(bitmapCreateBitmap);
        return bitmapCreateScaledBitmap;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException {
        com.frame.y0.g("文字控件识别：" + node.text);
        if (node.whatIndex == 1) {
            return f0(linkedHashMap, node, runnable);
        }
        W(node);
        long j2 = node.timeOut;
        while (this.c.q()) {
            List<AccessibilityNodeInfo> listD0 = d0(node, null);
            if (listD0 != null) {
                N(node, this.f1528j);
                x7.d().b(node.getNextDelay());
                n(node, listD0, runnable);
                return true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j3 = this.f1528j;
            if (jCurrentTimeMillis - j3 > j2) {
                O(node, j3);
                com.frame.l1.e(new Runnable() { // from class: i.b.ka.e4
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatToast.g(j.b.d.a0, "未找到文字");
                    }
                });
                x7.d().b(node.getErrorDelay());
                k(node, runnable);
                return false;
            }
        }
        return false;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public int r() {
        return j.b.d.l0;
    }

    @Override // i.b.ka.s7, i.b.ka.x5
    public String t() {
        return "文字匹配";
    }

    @Override // i.b.ka.x5
    public AccessibilityNodeInfo y(String str) {
        AccessibilityNodeInfo rootInActiveWindow = BoxService.m().getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            List<AccessibilityWindowInfo> windows = BoxService.m().getWindows();
            for (int size = windows.size() - 1; size >= 0; size--) {
                rootInActiveWindow = windows.get(size).getRoot();
                if (rootInActiveWindow != null) {
                    break;
                }
                rootInActiveWindow = null;
            }
        }
        return rootInActiveWindow;
    }
}
