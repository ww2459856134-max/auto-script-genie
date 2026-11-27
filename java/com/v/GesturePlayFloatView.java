package com.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.yl.model.GesturePath;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/* loaded from: classes.dex */
public class GesturePlayFloatView extends FingerLine {
    DecelerateInterpolator A;
    AnimatorListenerAdapter C;

    /* renamed from: i, reason: collision with root package name */
    ConcurrentLinkedDeque<d> f966i;

    /* renamed from: j, reason: collision with root package name */
    Rect f967j;

    /* renamed from: k, reason: collision with root package name */
    ImageView f968k;
    private final Runnable t;

    class a implements Animation.AnimationListener {
        final /* synthetic */ View c;
        final /* synthetic */ ImageView d;

        a(View view, ImageView imageView) {
            this.c = view;
            this.d = imageView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.c;
            if (view != null) {
                GesturePlayFloatView.this.removeView(view);
            }
            GesturePlayFloatView.this.removeView(this.d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b implements Animation.AnimationListener {
        final /* synthetic */ TextView c;

        b(TextView textView) {
            this.c = textView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            GesturePlayFloatView.this.removeView(this.c);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            GesturePlayFloatView.this.f968k.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            GesturePlayFloatView.this.f968k.setVisibility(8);
        }
    }

    interface d {
        void a(Canvas canvas);

        boolean b();
    }

    public static class e extends Point implements d {
        private long c;

        public e(int i2, int i3, long j2) {
            super(i2, i3);
            this.c = j2;
        }

        @Override // com.v.GesturePlayFloatView.d
        public void a(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#44CD0C0C"));
            canvas.drawCircle(((Point) this).x, ((Point) this).y, com.frame.p1.c(5.0f), paint);
        }

        @Override // com.v.GesturePlayFloatView.d
        public boolean b() {
            return System.currentTimeMillis() > this.c;
        }
    }

    public static class f extends RectF implements d {
        private long c;

        public f(Rect rect, long j2) {
            super(rect);
            this.c = j2;
        }

        @Override // com.v.GesturePlayFloatView.d
        public void a(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#44CD0C0C"));
            canvas.drawRect(this, paint);
        }

        @Override // com.v.GesturePlayFloatView.d
        public boolean b() {
            return System.currentTimeMillis() > this.c;
        }
    }

    public GesturePlayFloatView() {
        super((Context) com.frame.v0.g(), false);
        this.f966i = new ConcurrentLinkedDeque<>();
        this.f967j = new Rect();
        this.t = new Runnable() { // from class: com.v.pj
            @Override // java.lang.Runnable
            public final void run() {
                this.c.postInvalidate();
            }
        };
        this.A = new DecelerateInterpolator(1.5f);
        this.C = new c();
        setAlpha(0.3f);
    }

    public static void B(Rect rect) {
        GesturePlayFloatView gesturePlayFloatView;
        if (i.b.da.B().M().isShowGesturePath && (gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().f(GesturePlayFloatView.class)) != null) {
            gesturePlayFloatView.E(new f(rect, System.currentTimeMillis() + 500));
        }
    }

    public static void C(AccessibilityNodeInfo accessibilityNodeInfo) {
        GesturePlayFloatView gesturePlayFloatView;
        if (i.b.da.B().M().isShowGesturePath && (gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().f(GesturePlayFloatView.class)) != null) {
            try {
                accessibilityNodeInfo.getBoundsInScreen(gesturePlayFloatView.f967j);
                gesturePlayFloatView.E(new f(gesturePlayFloatView.f967j, System.currentTimeMillis() + 500));
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    public static void D(String str) {
        GesturePlayFloatView gesturePlayFloatView;
        if (i.b.da.B().M().isShowGesturePath && (gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().f(GesturePlayFloatView.class)) != null) {
            try {
                gesturePlayFloatView.E(new f(Node.getRectByString(str), System.currentTimeMillis() + 500));
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    private void E(d dVar) {
        this.f966i.addLast(dVar);
        while (this.f966i.size() > 5) {
            this.f966i.pollFirst();
        }
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(float[] fArr, long j2, float[] fArr2) {
        if (this.f968k == null) {
            ImageView imageView = new ImageView(com.frame.v0.g());
            this.f968k = imageView;
            imageView.setImageResource(j.b.d.w);
            this.f968k.setAdjustViewBounds(true);
            addView(this.f968k, com.frame.p1.c(40.0f), com.frame.p1.c(40.0f));
        }
        if (this.f968k.getVisibility() != 0) {
            this.f968k.setVisibility(0);
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f968k, "x", fArr);
        float f2 = j2;
        long j3 = (long) (1.1f * f2);
        objectAnimatorOfFloat.setDuration(j3);
        objectAnimatorOfFloat.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f968k, "y", fArr2);
        objectAnimatorOfFloat2.setDuration(j3);
        objectAnimatorOfFloat2.start();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f968k, "alpha", 1.0f, 0.7f);
        objectAnimatorOfFloat3.addListener(this.C);
        objectAnimatorOfFloat3.setInterpolator(this.A);
        objectAnimatorOfFloat3.setDuration((long) (f2 * 1.5f));
        objectAnimatorOfFloat3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(ArrayList arrayList, final long j2) {
        try {
            int size = arrayList.size() / 2;
            final float[] fArr = new float[size];
            final float[] fArr2 = new float[size];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 % 2 != 0) {
                    fArr2[i2 / 2] = ((Integer) arrayList.get(i2)).intValue();
                } else {
                    fArr[i2 / 2] = ((Integer) arrayList.get(i2)).intValue();
                }
            }
            if (size != 0) {
                com.frame.l1.e(new Runnable() { // from class: com.v.n9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.G(fArr, j2, fArr2);
                    }
                });
            }
        } catch (Exception e2) {
            com.frame.y0.l(e2);
        }
    }

    public static void v(int i2, int i3) {
        GesturePlayFloatView gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().f(GesturePlayFloatView.class);
        if (gesturePlayFloatView != null) {
            try {
                gesturePlayFloatView.E(new e(i2, i3, System.currentTimeMillis() + 500));
            } catch (Exception e2) {
                com.frame.k0.r(e2);
            }
        }
    }

    public static void w(Node node) {
        GesturePlayFloatView gesturePlayFloatView;
        ArrayList<Integer> arrayList;
        if (!i.b.da.B().M().isShowGesturePath || (gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().f(GesturePlayFloatView.class)) == null || (arrayList = node.pathPoints) == null || arrayList.isEmpty()) {
            return;
        }
        try {
            gesturePlayFloatView.E(new e(node.pathPoints.get(0).intValue(), node.pathPoints.get(1).intValue(), System.currentTimeMillis() + 500));
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void A(int i2, Node node) throws Resources.NotFoundException {
        int i3 = node.type;
        if (i3 == 1) {
            x(i2, node);
            return;
        }
        if (i3 == 2) {
            y(node);
            return;
        }
        if (i3 == 10) {
            if (node.getSrcRect() != null) {
                B(node.getSrcRect());
            }
        } else if (i3 == 4) {
            if (node.getSrcRect() != null) {
                B(node.getSrcRect());
            }
        } else if (i3 == 19) {
            if (node.getSrcRect() != null) {
                B(node.getSrcRect());
            }
        } else if (i3 == 3) {
            z(node);
        }
    }

    public void J(final ArrayList<Integer> arrayList, final long j2) {
        com.frame.l1.g(new Runnable() { // from class: com.v.o9
            @Override // java.lang.Runnable
            public final void run() {
                this.c.I(arrayList, j2);
            }
        });
    }

    @Override // com.v.FingerLine, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<d> it = this.f966i.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.a(canvas);
                if (next.b()) {
                    arrayList.add(next);
                }
            }
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
        try {
            this.f966i.removeAll(arrayList);
            removeCallbacks(this.t);
            if (this.f966i.isEmpty()) {
                return;
            }
            postDelayed(this.t, 800L);
        } catch (Exception e3) {
            com.frame.k0.r(e3);
        }
    }

    @Override // com.v.FingerLine, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.frame.l1.i(123123);
        removeCallbacks(this.t);
        this.f966i.clear();
    }

    public void x(int i2, Node node) throws Resources.NotFoundException {
        try {
            TextView textView = new TextView(com.frame.v0.g());
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.c);
            animationLoadAnimation.setDuration(3000L);
            textView.setAnimation(animationLoadAnimation);
            textView.setBackgroundResource(j.b.d.f);
            textView.setText((i2 + 1) + "");
            textView.setGravity(17);
            textView.setTextColor(-1);
            textView.setTextSize(9.0f);
            int iC = com.frame.p1.c(20.0f);
            textView.setX(node.pathPoints.get(0).intValue());
            textView.setY(node.pathPoints.get(1).intValue());
            addView(textView, iC, iC);
            animationLoadAnimation.setAnimationListener(new b(textView));
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void y(Node node) {
        if (node.pathPoints != null) {
            c();
            e(node.duration, node.pathPoints);
            J(node.pathPoints, node.duration);
            return;
        }
        ArrayList<GesturePath> arrayList = node.paths;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (node.paths.size() == 1) {
            c();
            e(node.duration, node.paths.get(0).points);
        } else {
            Iterator<GesturePath> it = node.paths.iterator();
            while (it.hasNext()) {
                e(node.duration, it.next().points);
            }
        }
    }

    public void z(Node node) throws Resources.NotFoundException {
        View view;
        if (node.getSrcRect() == null) {
            FloatToast.g(j.b.d.g0, "图集无法预览");
            return;
        }
        if (node.getArea() != null) {
            Rect area = node.getArea();
            view = new View(com.frame.v0.g());
            view.setX(area.left);
            view.setY(area.top);
            view.setBackgroundColor(Color.parseColor("#55F72B2B"));
            addView(view, area.width(), area.height());
        } else {
            view = new View(com.frame.v0.g());
            view.setX(0.0f);
            view.setY(0.0f);
            view.setBackgroundColor(Color.parseColor("#55F72B2B"));
            addView(view, com.frame.k0.c().e(), com.frame.k0.c().d());
        }
        ImageView imageView = new ImageView(com.frame.v0.g());
        com.bumptech.glide.c.u(imageView).w(node.url).q0(imageView);
        Rect srcRect = node.getSrcRect();
        imageView.setX(srcRect.left);
        imageView.setY(srcRect.top);
        addView(imageView, srcRect.width(), srcRect.height());
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.c);
        animationLoadAnimation.setDuration(3000L);
        imageView.setAnimation(animationLoadAnimation);
        animationLoadAnimation.setAnimationListener(new a(view, imageView));
    }
}
