package i.b.ka;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import com.v.ColorChooseView;
import com.v.ColorScanDialogView;
import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.MultiLogicDialogView;
import com.v.RectChooseView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.i9;
import i.b.v8;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.json.JSONException;

/* loaded from: classes.dex */
public class i6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(lt ltVar, Node node) {
        Q(ltVar, node);
    }

    static /* synthetic */ void c0(DialogInterface dialogInterface) {
        com.frame.s0.g().d(RectChooseView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
        com.frame.s0.g().u(MultiLogicDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(int i2, lt ltVar, Node node) {
        if (i2 != 1) {
            com.frame.l1.f(new Runnable() { // from class: i.b.ka.d0
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandlerRecord.class);
                }
            }, 600L);
            v8.m().P(node);
        }
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 13;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        ColorScanDialogView colorScanDialogView = (ColorScanDialogView) com.frame.s0.g().B(ColorScanDialogView.class);
        colorScanDialogView.setTaskNode(task, node);
        if (i2 == 1) {
            colorScanDialogView.setMiniModel();
        }
        colorScanDialogView.setNodeCallback(new lt() { // from class: i.b.ka.f0
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.Z(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(final int i2, final lt ltVar) {
        if (i9.v().B()) {
            a0(i2, ltVar);
        } else {
            i9.v().q0();
            i9.v().n0(new Runnable() { // from class: i.b.ka.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.b0(i2, ltVar);
                }
            });
        }
    }

    public o.a.e T(Bitmap bitmap, String str, int i2) {
        System.currentTimeMillis();
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        String[] strArrSplit = str.split(",");
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int color = Color.parseColor("#" + strArrSplit[0]);
        for (int i3 = 0; i3 < width; i3++) {
            int width2 = i3 / bitmap.getWidth();
            int width3 = i3 % bitmap.getWidth();
            if (color == iArr[i3]) {
                for (int i4 = 1; i4 < strArrSplit.length; i4++) {
                    strArrSplit[i4] = strArrSplit[i4].replace("\"", "");
                    String[] strArrSplit2 = strArrSplit[i4].split("\\|");
                    int i5 = Integer.parseInt(strArrSplit2[0]) + width3;
                    int i6 = Integer.parseInt(strArrSplit2[1]) + width2;
                    if (i5 < 0 || i6 < 0 || i5 > bitmap.getWidth() || i6 > bitmap.getHeight() || !W(bitmap, i5, i6).equals(strArrSplit2[2])) {
                        break;
                    }
                    if (i4 == strArrSplit.length - 1) {
                        return new o.a.e(width3, width2);
                    }
                }
            }
        }
        return new o.a.e(-1, -1);
    }

    public Point U(Bitmap bitmap, Node node) {
        o.a.e eVar;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            if (node.arg1.contains("|")) {
                Rect areaOrParam = node.getAreaOrParam();
                if (node.hasAreaResolveError()) {
                    return null;
                }
                if (areaOrParam != null) {
                    eVar = T(bitmap, node.arg1, 10);
                    if (eVar != null && eVar.a() != -1) {
                        eVar.c(eVar.a() + areaOrParam.left);
                        eVar.d(eVar.b() + areaOrParam.top);
                    }
                } else {
                    eVar = X(node, bitmap).equals(node.arg1) ? new o.a.e(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue()) : T(bitmap, node.arg1, 10);
                }
            } else {
                Rect areaOrParam2 = node.getAreaOrParam();
                if (node.hasAreaResolveError()) {
                    return null;
                }
                if (areaOrParam2 != null) {
                    LinkedList<o.a.e> linkedListC = o.a.d.c(bitmap, new o.a.a(Color.parseColor("#" + node.arg1)));
                    eVar = linkedListC.size() > 0 ? linkedListC.get(0) : null;
                    if (eVar != null && eVar.a() != -1) {
                        eVar.c(eVar.a() + areaOrParam2.left);
                        eVar.d(eVar.b() + areaOrParam2.top);
                    }
                } else if (X(node, bitmap).equals(node.arg1)) {
                    eVar = new o.a.e(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue());
                } else {
                    LinkedList<o.a.e> linkedListC2 = o.a.d.c(bitmap, new o.a.a(Color.parseColor("#" + node.arg1)));
                    eVar = linkedListC2.size() > 0 ? linkedListC2.get(0) : null;
                }
            }
            if (eVar != null && eVar.a() != -1) {
                return new Point(eVar.a(), eVar.b());
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Point V(Bitmap bitmap, Node node) throws Throwable {
        Bitmap bitmapCreateBitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                Rect areaOrParam = node.getAreaOrParam();
                if (node.hasAreaResolveError()) {
                    if (bitmap != null) {
                        com.frame.l0.c(null);
                    }
                    return null;
                }
                bitmapCreateBitmap = areaOrParam == null ? bitmap : bitmap != null ? Bitmap.createBitmap(bitmap, areaOrParam.left, areaOrParam.top, areaOrParam.width(), areaOrParam.height(), (Matrix) null, false) : null;
                try {
                    Point pointU = U(bitmapCreateBitmap, node);
                    if (bitmapCreateBitmap != bitmap) {
                        com.frame.l0.c(bitmapCreateBitmap);
                    }
                    return pointU;
                } catch (Exception e) {
                    e = e;
                    com.frame.k0.r(e);
                    if (bitmapCreateBitmap != bitmap) {
                        com.frame.l0.c(bitmapCreateBitmap);
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bitmap2 = bitmapCreateBitmap;
                if (bitmap2 != bitmap) {
                    com.frame.l0.c(bitmap2);
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bitmapCreateBitmap = null;
        } catch (Throwable th2) {
            th = th2;
            if (bitmap2 != bitmap) {
            }
            throw th;
        }
    }

    public String W(Bitmap bitmap, int i2, int i3) {
        int pixel = bitmap.getPixel(i2, i3);
        return o.a.d.d(Color.rgb(Color.red(pixel), Color.green(pixel), Color.blue(pixel)));
    }

    public String X(Node node, Bitmap bitmap) {
        o.a.e eVar = new o.a.e(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(W(bitmap, eVar.a(), eVar.b()));
        String[] strArrSplit = node.arg1.split(",");
        for (int i2 = 1; i2 < strArrSplit.length; i2++) {
            strArrSplit[i2] = strArrSplit[i2].replace("\"", "");
            String[] strArrSplit2 = strArrSplit[i2].split("\\|");
            int iA = eVar.a() + Integer.parseInt(strArrSplit2[0]);
            int iB = eVar.b() + Integer.parseInt(strArrSplit2[1]);
            if (iA < 0 || iB < 0 || iA > bitmap.getWidth() || iB > bitmap.getHeight()) {
                break;
            }
            stringBuffer.append(",");
            stringBuffer.append(strArrSplit2[0]);
            stringBuffer.append("|");
            stringBuffer.append(strArrSplit2[1]);
            stringBuffer.append("|");
            stringBuffer.append(W(bitmap, iA, iB));
        }
        return stringBuffer.toString();
    }

    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void b0(final int i2, final lt ltVar) {
        com.frame.s0.g().i(FloatHandlerRecord.class);
        ColorChooseView colorChooseView = (ColorChooseView) com.frame.s0.g().x(ColorChooseView.class);
        colorChooseView.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: i.b.ka.e0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                i6.c0(dialogInterface);
            }
        });
        if (i2 == 1) {
            colorChooseView.setMiniModel(true);
        }
        colorChooseView.o(new lt() { // from class: i.b.ka.g0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.f0(i2, ltVar, node);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0154 A[SYNTHETIC] */
    @Override // i.b.ka.x5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException {
        Bitmap bitmapCreateBitmap;
        com.frame.y0.g("颜色识别:" + node.getStepAndName());
        if (!i9.v().n()) {
            int i2 = 0;
            while (true) {
                if (i2 >= 10) {
                    break;
                }
                if (!this.c.q()) {
                    return false;
                }
                if (i9.v().B()) {
                    SystemClock.sleep(200L);
                    break;
                }
                SystemClock.sleep(250L);
                i2++;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        while (true) {
            if (!this.c.q()) {
                break;
            }
            if (!(z && i9.v().F()) && System.currentTimeMillis() - jCurrentTimeMillis > node.timeOut) {
                FloatToast.i("颜色识别超时");
                O(node, jCurrentTimeMillis);
                i9.v().h0();
                k(node, runnable);
                break;
            }
            Bitmap bitmapW = i9.v().w(node.timeOut + jCurrentTimeMillis, z);
            if (bitmapW == null && z && i9.v().F()) {
                return false;
            }
            boolean z2 = bitmapW != null ? false : z;
            if (!this.c.q()) {
                com.frame.l0.c(bitmapW);
                return false;
            }
            Rect areaOrParam = node.getAreaOrParam();
            if (node.hasAreaResolveError()) {
                k(node, runnable);
                break;
            }
            if (areaOrParam == null) {
                bitmapCreateBitmap = bitmapW;
            } else {
                bitmapCreateBitmap = bitmapW != null ? Bitmap.createBitmap(bitmapW, areaOrParam.left, areaOrParam.top, areaOrParam.width(), areaOrParam.height(), (Matrix) null, false) : null;
            }
            if (bitmapCreateBitmap != null) {
                try {
                    try {
                        if (Color.alpha(bitmapCreateBitmap.getPixel(bitmapCreateBitmap.getWidth() / 2, bitmapCreateBitmap.getHeight() / 2)) != 0) {
                            Point pointU = U(bitmapCreateBitmap, node);
                            if (!this.c.q()) {
                                com.frame.l0.c(bitmapCreateBitmap);
                                if (bitmapCreateBitmap != bitmapW) {
                                    com.frame.l0.c(bitmapW);
                                }
                                return false;
                            }
                            if (pointU != null) {
                                N(node, jCurrentTimeMillis);
                                i9.v().h0();
                                int i3 = pointU.x;
                                int i4 = pointU.y;
                                Rect rect = new Rect(i3 - 10, i4 - 10, i3 + 10, i4 + 10);
                                N(node, jCurrentTimeMillis);
                                l(node, rect, runnable);
                                com.frame.l0.c(bitmapCreateBitmap);
                                if (bitmapCreateBitmap != bitmapW) {
                                    com.frame.l0.c(bitmapW);
                                }
                            }
                        }
                        com.frame.l0.c(bitmapCreateBitmap);
                    } catch (Exception e) {
                        com.frame.k0.r(e);
                        com.frame.l0.c(bitmapCreateBitmap);
                        if (bitmapCreateBitmap != bitmapW) {
                        }
                    }
                    if (bitmapCreateBitmap == bitmapW) {
                        com.frame.l0.c(bitmapW);
                    }
                } catch (Throwable th) {
                    com.frame.l0.c(bitmapCreateBitmap);
                    if (bitmapCreateBitmap != bitmapW) {
                        com.frame.l0.c(bitmapW);
                    }
                    throw th;
                }
            } else {
                com.frame.l0.c(bitmapCreateBitmap);
                if (bitmapCreateBitmap == bitmapW) {
                }
            }
            SystemClock.sleep(200L);
            z = z2;
        }
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.H;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "颜色识别";
    }
}
