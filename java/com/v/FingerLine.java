package com.v;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.widget.FrameLayout;
import com.v.FingerLine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class FingerLine extends FrameLayout {
    private Paint c;
    protected final CopyOnWriteArrayList<c> d;
    protected final CopyOnWriteArrayList<c> e;
    private final CopyOnWriteArrayList<a> f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private final Choreographer.FrameCallback f951h;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        final List<b> a;
        final long b = SystemClock.uptimeMillis();
        final long c;
        int d;
        int e;

        a(List<b> list, long j2) {
            this.a = list;
            this.c = j2;
        }
    }

    protected static final class b {
        final float a;
        final float b;
        final float c;
        final float d;
        final float e;
        final float f;

        b(float f, float f2, float f3, float f4, float f5, float f6) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
        }
    }

    static final class c {
        final b a;
        final long b;

        c(b bVar, long j2) {
            this.a = bVar;
            this.b = j2;
        }
    }

    public FingerLine(Context context, boolean z) {
        super(context);
        this.d = new CopyOnWriteArrayList<>();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new CopyOnWriteArrayList<>();
        this.f951h = new Choreographer.FrameCallback() { // from class: com.v.g5
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
        if (z) {
            getStatusBarHeight();
        }
    }

    static void a(Paint paint, float f, float f2) {
        paint.setAlpha((int) (((0.75f * f2) + 0.25f) * f * 200.0f));
        paint.setStrokeWidth(com.frame.p1.c(14.0f) * ((f2 * 0.88f) + 0.12f) * ((f * 0.65f) + 0.35f));
    }

    static List<b> b(List<Integer> list) {
        if (list == null || list.size() < 4) {
            return Collections.emptyList();
        }
        int size = list.size() / 2;
        ArrayList arrayList = new ArrayList(size - 1);
        float fIntValue = list.get(0).intValue();
        float fIntValue2 = list.get(1).intValue();
        int iIntValue = list.get(0).intValue();
        int i2 = 1;
        float f = fIntValue2;
        float f2 = fIntValue;
        int iIntValue2 = list.get(1).intValue();
        while (i2 < size) {
            int i3 = i2 * 2;
            int iIntValue3 = list.get(i3).intValue();
            int iIntValue4 = list.get(i3 + 1).intValue();
            float f3 = (iIntValue + iIntValue3) / 2.0f;
            float f4 = (iIntValue2 + iIntValue4) / 2.0f;
            arrayList.add(new b(f2, f, iIntValue, iIntValue2, f3, f4));
            i2++;
            iIntValue = iIntValue3;
            iIntValue2 = iIntValue4;
            f2 = f3;
            f = f4;
        }
        return arrayList;
    }

    private void d(Canvas canvas, CopyOnWriteArrayList<c> copyOnWriteArrayList) {
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        Iterator<c> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            c next = it.next();
            float f = (jUptimeMillis - next.b) / 400.0f;
            if (f < 1.0f) {
                a(this.c, 1.0f - f, (i2 + 1.0f) / size);
                f(canvas, this.c, next.a);
            }
            i2++;
        }
    }

    static void f(Canvas canvas, Paint paint, b bVar) {
        int i2 = 1;
        float f = bVar.a;
        float f2 = bVar.b;
        while (i2 <= 8) {
            float f3 = i2 / 8.0f;
            float f4 = 1.0f - f3;
            float f5 = f4 * f4;
            float f6 = f4 * 2.0f * f3;
            float f7 = f3 * f3;
            float f8 = (bVar.a * f5) + (bVar.c * f6) + (bVar.e * f7);
            float f9 = (f5 * bVar.b) + (f6 * bVar.d) + (f7 * bVar.f);
            canvas.drawLine(f, f2, f8, f9, paint);
            i2++;
            f2 = f9;
            f = f8;
        }
    }

    private void g() {
        if (this.c == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setColor(-65536);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeCap(Paint.Cap.ROUND);
            this.c.setStrokeJoin(Paint.Join.ROUND);
        }
    }

    private int getStatusBarHeight() {
        Resources resources = com.frame.v0.g().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(a aVar) {
        if (isAttachedToWindow()) {
            this.f.add(aVar);
            postInvalidate();
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(List list, long j2) {
        List<b> listB = b(list);
        if (listB.isEmpty()) {
            return;
        }
        final a aVar = new a(listB, Math.max(1L, j2));
        com.frame.l1.e(new Runnable() { // from class: com.v.e5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.i(aVar);
            }
        });
    }

    static /* synthetic */ boolean l(a aVar) {
        return aVar.d >= aVar.a.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(long j2) {
        boolean z = false;
        this.g = false;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z2 = true;
        if (!this.f.isEmpty()) {
            Iterator<a> it = this.f.iterator();
            while (it.hasNext()) {
                a next = it.next();
                u(next, jUptimeMillis);
                t(next, jUptimeMillis);
            }
            q(this.f, new Predicate() { // from class: com.v.f5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return FingerLine.l((FingerLine.a) obj);
                }
            });
            if (!this.f.isEmpty()) {
                z = true;
            }
        }
        if (p(this.d, jUptimeMillis) || !this.d.isEmpty()) {
            z = true;
        }
        if (!p(this.e, jUptimeMillis) && this.e.isEmpty()) {
            z2 = z;
        }
        if (z2) {
            postInvalidate();
            r();
        }
    }

    static /* synthetic */ boolean o(long j2, c cVar) {
        return j2 - cVar.b >= 400;
    }

    private static boolean p(CopyOnWriteArrayList<c> copyOnWriteArrayList, final long j2) {
        return q(copyOnWriteArrayList, new Predicate() { // from class: com.v.d5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return FingerLine.o(j2, (FingerLine.c) obj);
            }
        });
    }

    static <T> boolean q(CopyOnWriteArrayList<T> copyOnWriteArrayList, Predicate<T> predicate) {
        Iterator<T> it = copyOnWriteArrayList.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.test(next)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        return arrayList != null && copyOnWriteArrayList.removeAll(arrayList);
    }

    private void r() {
        if (this.g) {
            return;
        }
        this.g = true;
        Choreographer.getInstance().postFrameCallback(this.f951h);
    }

    private void s() {
        this.g = false;
        Choreographer.getInstance().removeFrameCallback(this.f951h);
    }

    private void t(a aVar, long j2) {
        while (true) {
            int i2 = aVar.e;
            if (i2 >= aVar.d || i2 >= aVar.a.size()) {
                return;
            }
            this.d.add(new c(aVar.a.get(aVar.e), j2));
            aVar.e++;
        }
    }

    private static void u(a aVar, long j2) {
        long j3 = j2 - aVar.b;
        int size = aVar.a.size();
        long j4 = aVar.c;
        if (j3 >= j4) {
            aVar.d = size;
        } else {
            aVar.d = (int) ((size * j3) / j4);
        }
    }

    protected void c() {
        this.d.clear();
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        g();
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        canvas.drawColor(0);
        d(canvas, this.e);
        d(canvas, this.d);
    }

    public void e(final long j2, final List<Integer> list) {
        com.frame.l1.g(new Runnable() { // from class: com.v.h5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.k(list, j2);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        this.f.clear();
        this.d.clear();
        this.e.clear();
    }

    public FingerLine(Context context) {
        super(context);
        this.d = new CopyOnWriteArrayList<>();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new CopyOnWriteArrayList<>();
        this.f951h = new Choreographer.FrameCallback() { // from class: com.v.g5
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
    }

    public FingerLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new CopyOnWriteArrayList<>();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new CopyOnWriteArrayList<>();
        this.f951h = new Choreographer.FrameCallback() { // from class: com.v.g5
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
        getStatusBarHeight();
    }

    public FingerLine(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = new CopyOnWriteArrayList<>();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new CopyOnWriteArrayList<>();
        this.f951h = new Choreographer.FrameCallback() { // from class: com.v.g5
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j2) {
                this.c.n(j2);
            }
        };
        getStatusBarHeight();
    }
}
