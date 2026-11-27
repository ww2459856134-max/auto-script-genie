package com.yl.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.frame.l0;
import java.io.File;

/* loaded from: classes.dex */
public class CropActivity extends p {
    private FrameLayout P;
    private ImageView Q;
    private Button U;
    private b V;
    private GestureDetector W;
    private final Matrix Z = new Matrix();
    private final Matrix a0 = new Matrix();
    private int b0 = 0;
    private float c0;
    private float d0;
    private float e0;
    private float f0;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    private int k0;
    private int l0;
    private float m0;
    private int n0;
    private int o0;
    private int p0;
    private int q0;
    private int r0;
    private int s0;
    private boolean t0;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            CropActivity.this.x0();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }
    }

    private class b extends View {
        private final Paint c;
        private final Paint d;
        private final Paint e;
        private final Paint f;

        b(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.c = paint;
            Paint paint2 = new Paint(1);
            this.d = paint2;
            Paint paint3 = new Paint(1);
            this.e = paint3;
            Paint paint4 = new Paint(1);
            this.f = paint4;
            setContentDescription(CropActivity.this.getString(c0.d));
            paint.setColor(-1207959552);
            paint.setStyle(Paint.Style.FILL);
            paint2.setColor(-855638017);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(CropActivity.this.v0(1.0f));
            paint3.setColor(1442840575);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(CropActivity.this.v0(1.0f));
            paint4.setColor(-1);
            paint4.setStyle(Paint.Style.STROKE);
            paint4.setStrokeWidth(CropActivity.this.v0(3.0f));
            paint4.setStrokeCap(Paint.Cap.SQUARE);
        }

        private void a(Canvas canvas, float f, float f2, float f3, int i2, int i3) {
            canvas.drawLine(f, f2, f + (i2 * f3), f2, this.f);
            canvas.drawLine(f, f2, f, f2 + (f3 * i3), this.f);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), CropActivity.this.q0, this.c);
            canvas.drawRect(0.0f, CropActivity.this.q0, CropActivity.this.p0, CropActivity.this.s0, this.c);
            canvas.drawRect(CropActivity.this.r0, CropActivity.this.q0, getWidth(), CropActivity.this.s0, this.c);
            canvas.drawRect(0.0f, CropActivity.this.s0, getWidth(), getHeight(), this.c);
            float f = CropActivity.this.n0 / 3.0f;
            float f2 = CropActivity.this.o0 / 3.0f;
            canvas.drawLine(CropActivity.this.p0 + f, CropActivity.this.q0, CropActivity.this.p0 + f, CropActivity.this.s0, this.e);
            float f3 = f * 2.0f;
            canvas.drawLine(CropActivity.this.p0 + f3, CropActivity.this.q0, CropActivity.this.p0 + f3, CropActivity.this.s0, this.e);
            canvas.drawLine(CropActivity.this.p0, CropActivity.this.q0 + f2, CropActivity.this.r0, CropActivity.this.q0 + f2, this.e);
            float f4 = f2 * 2.0f;
            canvas.drawLine(CropActivity.this.p0, CropActivity.this.q0 + f4, CropActivity.this.r0, CropActivity.this.q0 + f4, this.e);
            canvas.drawRect(CropActivity.this.p0, CropActivity.this.q0, CropActivity.this.r0, CropActivity.this.s0, this.d);
            float fMin = Math.min(CropActivity.this.v0(20.0f), Math.min(CropActivity.this.n0, CropActivity.this.o0) / 4.0f);
            a(canvas, CropActivity.this.p0, CropActivity.this.q0, fMin, 1, 1);
            a(canvas, CropActivity.this.r0, CropActivity.this.q0, fMin, -1, 1);
            a(canvas, CropActivity.this.p0, CropActivity.this.s0, fMin, 1, -1);
            a(canvas, CropActivity.this.r0, CropActivity.this.s0, fMin, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0() {
        if (this.Q.getDrawable() == null || this.P.getWidth() == 0 || this.P.getHeight() == 0) {
            Y(getString(c0.c));
            finish();
            return;
        }
        s0();
        b bVar = new b(this);
        this.V = bVar;
        this.P.addView(bVar, new FrameLayout.LayoutParams(-1, -1));
        H0();
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ boolean D0(View view, MotionEvent motionEvent) {
        int actionIndex;
        this.W.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.b0 = 0;
            } else if (actionMasked == 2) {
                int i2 = this.b0;
                if (i2 == 1) {
                    this.Z.set(this.a0);
                    this.Z.postTranslate(motionEvent.getX() - this.c0, motionEvent.getY() - this.d0);
                    E0();
                } else if (i2 == 2 && motionEvent.getPointerCount() >= 2) {
                    float fI0 = I0(motionEvent);
                    if (fI0 > 10.0f) {
                        float f = this.f0;
                        if (f > 0.0f) {
                            float fT0 = t0((f * fI0) / this.e0, this.i0, this.j0) / this.f0;
                            this.Z.set(this.a0);
                            this.Z.postScale(fT0, fT0, this.g0, this.h0);
                            this.Z.postTranslate(F0(motionEvent) - this.g0, G0(motionEvent) - this.h0);
                            E0();
                        }
                    }
                }
                this.Q.setImageMatrix(this.Z);
            } else if (actionMasked != 3) {
                if (actionMasked == 5) {
                    float fI02 = I0(motionEvent);
                    this.e0 = fI02;
                    if (fI02 > 10.0f) {
                        this.a0.set(this.Z);
                        this.f0 = w0(this.a0);
                        this.g0 = F0(motionEvent);
                        this.h0 = G0(motionEvent);
                        this.b0 = 2;
                    }
                } else if (actionMasked == 6) {
                    if (motionEvent.getPointerCount() > 1 && (actionIndex = motionEvent.getActionIndex()) >= 0 && actionIndex < motionEvent.getPointerCount()) {
                        int i3 = actionIndex == 0 ? 1 : 0;
                        int i4 = i3 < motionEvent.getPointerCount() ? i3 : 0;
                        this.a0.set(this.Z);
                        this.c0 = motionEvent.getX(i4);
                        this.d0 = motionEvent.getY(i4);
                        this.b0 = 1;
                    } else {
                        this.b0 = 0;
                    }
                }
            }
        } else {
            this.a0.set(this.Z);
            this.c0 = motionEvent.getX();
            this.d0 = motionEvent.getY();
            this.b0 = 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045 A[PHI: r0 r2
      0x0045: PHI (r0v9 float) = (r0v6 float), (r0v7 float) binds: [B:9:0x0043, B:12:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0045: PHI (r2v4 int) = (r2v2 int), (r2v3 int) binds: [B:9:0x0043, B:12:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E0() {
        float fCenterX;
        float fCenterY;
        float f;
        if (this.Q.getDrawable() == null) {
            return;
        }
        RectF rectF = new RectF();
        float f2 = 0.0f;
        this.Z.mapRect(rectF, new RectF(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight()));
        float fWidth = rectF.width();
        int i2 = this.n0;
        if (fWidth <= i2) {
            fCenterX = (this.p0 + (i2 / 2.0f)) - rectF.centerX();
        } else {
            float f3 = rectF.left;
            int i3 = this.p0;
            if (f3 > i3) {
                fCenterX = i3 - f3;
            } else {
                f3 = rectF.right;
                i3 = this.r0;
                if (f3 >= i3) {
                    fCenterX = 0.0f;
                }
            }
        }
        float fHeight = rectF.height();
        int i4 = this.o0;
        if (fHeight > i4) {
            float f4 = rectF.top;
            int i5 = this.q0;
            if (f4 > i5) {
                f2 = i5 - f4;
            } else {
                fCenterY = rectF.bottom;
                int i6 = this.s0;
                if (fCenterY < i6) {
                    f = i6;
                }
            }
            this.Z.postTranslate(fCenterX, f2);
        }
        f = this.q0 + (i4 / 2.0f);
        fCenterY = rectF.centerY();
        f2 = f - fCenterY;
        this.Z.postTranslate(fCenterX, f2);
    }

    private float F0(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        return (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
    }

    private float G0(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        return (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    private void H0() {
        this.W = new GestureDetector(this, new a());
        this.V.setOnTouchListener(new View.OnTouchListener() { // from class: com.yl.ui.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.c.D0(view, motionEvent);
            }
        });
    }

    private float I0(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void s0() {
        int iMax = Math.max(1, this.P.getWidth() - v0(32.0f));
        int iMax2 = Math.max(1, this.P.getHeight() - v0(32.0f));
        float f = iMax / iMax2;
        float f2 = this.m0;
        if (f > f2) {
            this.o0 = iMax2;
            this.n0 = Math.max(1, Math.round(iMax2 * f2));
        } else {
            this.n0 = iMax;
            this.o0 = Math.max(1, Math.round(iMax / f2));
        }
        this.p0 = (this.P.getWidth() - this.n0) / 2;
        int height = this.P.getHeight();
        int i2 = this.o0;
        int i3 = (height - i2) / 2;
        this.q0 = i3;
        this.r0 = this.p0 + this.n0;
        this.s0 = i3 + i2;
    }

    private float t0(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private void u0() {
        File file;
        if (this.t0 || this.Q.getDrawable() == null || this.n0 <= 0 || this.o0 <= 0) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("output");
        if (TextUtils.isEmpty(stringExtra)) {
            Y(getString(c0.e));
            return;
        }
        this.t0 = true;
        this.U.setEnabled(false);
        this.U.setText(c0.f);
        this.U.performHapticFeedback(3);
        Bitmap bitmapCreateBitmap = null;
        try {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(this.k0, this.l0, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.scale(this.k0 / this.n0, this.l0 / this.o0);
                canvas.translate(-this.p0, -this.q0);
                this.Q.draw(canvas);
                file = new File(stringExtra);
                l0.d(bitmapCreateBitmap, file);
            } catch (Exception e) {
                this.t0 = false;
                this.U.setEnabled(true);
                this.U.setText(c0.b);
                Y(getString(c0.e));
                e.printStackTrace();
                if (0 == 0 || bitmapCreateBitmap.isRecycled()) {
                    return;
                }
            }
            if (!file.isFile() || file.length() == 0) {
                throw new IllegalStateException("Crop output was not written");
            }
            Intent intent = new Intent();
            intent.putExtra("output", file.getAbsolutePath());
            setResult(-1, intent);
            finish();
            if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled()) {
                return;
            }
            bitmapCreateBitmap.recycle();
        } catch (Throwable th) {
            if (0 != 0 && !bitmapCreateBitmap.isRecycled()) {
                bitmapCreateBitmap.recycle();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v0(float f) {
        return Math.round(f * getResources().getDisplayMetrics().density);
    }

    private float w0(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Drawable drawable = this.Q.getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fMax = Math.max(this.n0 / intrinsicWidth, this.o0 / intrinsicHeight);
        this.i0 = fMax;
        this.j0 = 4.0f * fMax;
        this.Z.setScale(fMax, fMax);
        Matrix matrix = this.Z;
        float f = this.p0;
        float f2 = this.n0;
        float f3 = this.i0;
        matrix.postTranslate(f + ((f2 - (intrinsicWidth * f3)) / 2.0f), this.q0 + ((this.o0 - (intrinsicHeight * f3)) / 2.0f));
        this.Q.setImageMatrix(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(View view) {
        u0();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0(getString(c0.g));
        this.K.findViewById(a0.f1130h).setContentDescription(getString(c0.a));
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(-15921388);
        }
        setContentView(b0.a);
        this.P = (FrameLayout) findViewById(a0.f);
        this.Q = (ImageView) findViewById(a0.f1132j);
        this.U = (Button) findViewById(a0.c);
        this.Q.setScaleType(ImageView.ScaleType.MATRIX);
        this.k0 = Math.max(1, getIntent().getIntExtra("outputX", 1080));
        int iMax = Math.max(1, getIntent().getIntExtra("outputY", 1920));
        this.l0 = iMax;
        this.m0 = this.k0 / iMax;
        Uri data = getIntent().getData();
        if (data == null) {
            Y(getString(c0.c));
            finish();
            return;
        }
        try {
            this.Q.setImageURI(data);
            this.U.setOnClickListener(new View.OnClickListener() { // from class: com.yl.ui.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.z0(view);
                }
            });
            this.P.post(new Runnable() { // from class: com.yl.ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.B0();
                }
            });
        } catch (Exception unused) {
            Y(getString(c0.c));
            finish();
        }
    }
}
