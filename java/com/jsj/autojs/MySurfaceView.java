package com.jsj.autojs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap A;
    private boolean C;
    private Paint D;
    private Canvas G;
    private int H;
    private int I;
    private View.OnTouchListener J;
    private volatile boolean K;
    private final Object M;
    private Thread O;
    private ArrayList<Float> P;
    private float c;
    private float d;
    private SurfaceHolder e;
    private float f;
    private float g;

    /* renamed from: h, reason: collision with root package name */
    private final Path f771h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f772i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f773j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f774k;
    private Paint t;

    public MySurfaceView(Context context) {
        super(context);
        this.f771h = new Path();
        this.f772i = new Rect();
        this.I = -16777216;
        this.M = new Object();
        this.P = new ArrayList<>();
        SurfaceHolder holder = getHolder();
        this.e = holder;
        holder.addCallback(this);
        this.A = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);
        this.G = new Canvas(this.A);
        Paint paint = new Paint();
        this.D = paint;
        paint.setStrokeWidth(24.0f);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeJoin(Paint.Join.ROUND);
        this.D.setStrokeCap(Paint.Cap.ROUND);
        this.D.setMaskFilter(new BlurMaskFilter(13.0f, BlurMaskFilter.Blur.SOLID));
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.t = paint2;
        paint2.setColor(Color.parseColor("#FFFFFF"));
        this.t.setStrokeWidth(5.0f);
        this.t.setStyle(Paint.Style.STROKE);
        this.t.setAntiAlias(true);
        this.t.setStrokeJoin(Paint.Join.ROUND);
        this.t.setMaskFilter(new BlurMaskFilter(4.0f, BlurMaskFilter.Blur.SOLID));
        this.t.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint();
        this.f774k = paint3;
        paint3.setStrokeJoin(Paint.Join.ROUND);
        this.f774k.setAntiAlias(true);
        this.f774k.setColor(Color.parseColor("#eeFF0000"));
        this.f774k.setStyle(Paint.Style.STROKE);
        this.f774k.setStrokeWidth(16.0f);
        this.f774k.setStrokeCap(Paint.Cap.ROUND);
        this.f774k.setMaskFilter(new BlurMaskFilter(13.0f, BlurMaskFilter.Blur.SOLID));
    }

    private Bitmap a(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width;
        float f2 = height;
        float f3 = i2;
        float f4 = i3;
        float f5 = f / f2 > f3 / f4 ? f3 / f : f4 / f2;
        Matrix matrix = new Matrix();
        matrix.postScale(f5, f5);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private void c(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    private void d() throws InterruptedException {
        Thread thread = this.O;
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
            try {
                thread.join(500L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.O = null;
    }

    private void e(MotionEvent motionEvent) {
        this.f773j = true;
        this.f771h.reset();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.c = x;
        this.d = y;
        this.f771h.moveTo(x, y);
        int i2 = (int) x;
        int i3 = (int) y;
        this.f772i.set(i2, i3, i2, i3);
        this.f = x;
        this.g = y;
        synchronized (this.M) {
            this.P.add(Float.valueOf(Float.MAX_VALUE));
            this.P.add(Float.valueOf(x));
            this.P.add(Float.valueOf(y));
        }
    }

    private Rect f(MotionEvent motionEvent) {
        Rect rect;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.c;
        float f2 = this.d;
        float fAbs = Math.abs(x - f);
        float fAbs2 = Math.abs(y - f2);
        if (fAbs >= 6.0f || fAbs2 >= 6.0f) {
            rect = this.f772i;
            float f3 = this.f;
            float f4 = this.g;
            rect.set((int) f3, (int) f4, (int) f3, (int) f4);
            float f5 = (x + f) / 2.0f;
            this.f = f5;
            float f6 = (y + f2) / 2.0f;
            this.g = f6;
            this.f771h.quadTo(f, f2, f5, f6);
            synchronized (this.M) {
                this.P.add(Float.valueOf(x));
                this.P.add(Float.valueOf(y));
            }
            int i2 = (int) f;
            int i3 = (int) f2;
            rect.union(i2, i3, i2, i3);
            int i4 = (int) f5;
            int i5 = (int) f6;
            rect.union(i4, i5, i4, i5);
            this.c = x;
            this.d = y;
            b();
        } else {
            rect = null;
        }
        if (rect == null) {
            return null;
        }
        return new Rect(rect);
    }

    private void g(MotionEvent motionEvent) {
        this.f773j = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r0 = r6.M;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0066, code lost:
    
        if (r2 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0068, code lost:
    
        r6.e.unlockCanvasAndPost(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        Object obj;
        if (this.K) {
            Canvas canvas = null;
            try {
                synchronized (this.M) {
                    try {
                        if (!this.K) {
                            synchronized (this.M) {
                            }
                            return;
                        }
                        if (!this.e.getSurface().isValid()) {
                            synchronized (this.M) {
                            }
                            return;
                        }
                        Canvas canvasLockCanvas = this.e.lockCanvas();
                        if (canvasLockCanvas != null) {
                            try {
                                Bitmap bitmap = this.A;
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    canvasLockCanvas.drawColor(this.I);
                                    canvasLockCanvas.drawBitmap(this.A, 0.0f, 0.0f, (Paint) null);
                                    if (this.C) {
                                        canvasLockCanvas.drawPath(this.f771h, this.D);
                                    } else {
                                        canvasLockCanvas.drawPath(this.f771h, this.f774k);
                                        canvasLockCanvas.drawPath(this.f771h, this.t);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                canvas = canvasLockCanvas;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            } catch (Exception unused) {
                synchronized (this.M) {
                    if (canvas != null) {
                        try {
                            this.e.unlockCanvasAndPost(canvas);
                        } catch (Exception unused2) {
                        }
                    }
                    return;
                }
            } catch (Throwable th3) {
                synchronized (this.M) {
                    if (canvas != null) {
                        try {
                            this.e.unlockCanvasAndPost(canvas);
                        } catch (Exception unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
        return;
    }

    public Bitmap getBimap() {
        return this.A;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        this.K = false;
        d();
        try {
            SurfaceHolder surfaceHolder = this.e;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this);
            }
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (!this.K) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            View.OnTouchListener onTouchListener = this.J;
            if (onTouchListener != null) {
                onTouchListener.onTouch(this, motionEvent);
            }
            int i2 = this.H;
            if (i2 != 0) {
                this.f774k.setColor(i2);
            }
            e(motionEvent);
            invalidate();
            return true;
        }
        if (action == 1) {
            View.OnTouchListener onTouchListener2 = this.J;
            if (onTouchListener2 != null) {
                onTouchListener2.onTouch(this, motionEvent);
            }
            if (this.C) {
                synchronized (this.M) {
                    if (this.K && this.G != null && (bitmap = this.A) != null && !bitmap.isRecycled()) {
                        this.G.drawPath(this.f771h, this.D);
                    }
                }
            } else {
                synchronized (this.M) {
                    if (this.K && this.G != null && (bitmap2 = this.A) != null && !bitmap2.isRecycled()) {
                        this.G.drawPath(this.f771h, this.f774k);
                        this.G.drawPath(this.f771h, this.t);
                    }
                }
            }
            if (this.f773j) {
                g(motionEvent);
                invalidate();
                return true;
            }
        } else if (action == 2 && this.f773j) {
            Rect rectF = f(motionEvent);
            if (rectF != null) {
                invalidate(rectF);
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackGroupColor(int i2) {
        this.I = i2;
    }

    public void setColor(int i2) {
        this.H = i2;
    }

    public void setImage(Bitmap bitmap) {
        try {
            c(this.A);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setupImage(a(bitmap, getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels));
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.J = onTouchListener;
    }

    public void setRubber(boolean z) {
        this.C = z;
    }

    public void setStrokeWidth(int i2) {
        float f = i2;
        this.t.setStrokeWidth(f);
        this.t.setMaskFilter(new BlurMaskFilter(f, BlurMaskFilter.Blur.SOLID));
        this.f774k.setStrokeWidth(i2 * 3);
        this.f774k.setMaskFilter(new BlurMaskFilter((i2 * 2) + 3, BlurMaskFilter.Blur.SOLID));
    }

    public void setupImage(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        try {
            c(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.A = bitmapCopy;
        this.f771h.reset();
        this.G = new Canvas(bitmapCopy);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.K = true;
        b();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.K = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws InterruptedException {
        this.K = false;
        d();
    }
}
