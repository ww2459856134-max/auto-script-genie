package com.jsj.autojs.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class Ae029968deb extends Activity {
    private Size A;
    private Size C;
    private String D;
    private boolean G;
    private boolean H;
    private boolean I;
    private volatile boolean J;
    private long K;
    private int M = 90;
    private final TextureView.SurfaceTextureListener O = new a();
    private final CameraDevice.StateCallback P = new b();
    private TextureView c;
    private TextView d;
    private HandlerThread e;
    private Handler f;
    private ExecutorService g;

    /* renamed from: h, reason: collision with root package name */
    private i.f.a.j f775h;

    /* renamed from: i, reason: collision with root package name */
    private CameraDevice f776i;

    /* renamed from: j, reason: collision with root package name */
    private CameraCaptureSession f777j;

    /* renamed from: k, reason: collision with root package name */
    private CaptureRequest.Builder f778k;
    private ImageReader t;

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) throws CameraAccessException {
            Ae029968deb.this.M(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ae029968deb.this.q(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class b extends CameraDevice.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Ae029968deb.this.p();
            Ae029968deb.this.finish();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            Ae029968deb.this.p();
            Ae029968deb.this.P("相机打开失败");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) throws CameraAccessException {
            Ae029968deb.this.f776i = cameraDevice;
            Ae029968deb.this.s();
        }
    }

    class c extends CameraCaptureSession.StateCallback {
        c() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Ae029968deb.this.P("相机预览失败");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
            if (Ae029968deb.this.f776i == null) {
                return;
            }
            Ae029968deb.this.f777j = cameraCaptureSession;
            try {
                Ae029968deb.this.f777j.setRepeatingRequest(Ae029968deb.this.f778k.build(), null, Ae029968deb.this.f);
            } catch (CameraAccessException unused) {
                Ae029968deb.this.P("相机预览失败");
            }
        }
    }

    private static class d extends View {
        private final Paint c;
        private final Paint d;
        private final Paint e;
        private final Paint f;
        private final Paint g;

        /* renamed from: h, reason: collision with root package name */
        private final RectF f779h;

        d(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.c = paint;
            Paint paint2 = new Paint(1);
            this.d = paint2;
            Paint paint3 = new Paint(1);
            this.e = paint3;
            Paint paint4 = new Paint(1);
            this.f = paint4;
            Paint paint5 = new Paint(1);
            this.g = paint5;
            this.f779h = new RectF();
            paint.setColor(-1728053248);
            paint2.setColor(1728053247);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(a(context, 1));
            paint3.setColor(-1);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(a(context, 4));
            paint3.setStrokeCap(Paint.Cap.SQUARE);
            paint4.setColor(-1510310);
            paint4.setStrokeWidth(a(context, 2));
            paint5.setColor(-1);
            paint5.setTextSize(a(context, 14));
            paint5.setTextAlign(Paint.Align.CENTER);
        }

        private int a(Context context, int i2) {
            return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        private void b(Canvas canvas, float f, float f2, float f3, boolean z, boolean z2) {
            float f4 = z ? f + f3 : f - f3;
            float f5 = z2 ? f2 + f3 : f2 - f3;
            canvas.drawLine(f, f2, f4, f2, this.e);
            canvas.drawLine(f, f2, f, f5, this.e);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float width = getWidth();
            float height = getHeight();
            float fMin = Math.min(0.72f * width, 0.42f * height);
            float f = (width - fMin) / 2.0f;
            float fMax = Math.max(0.24f * height, ((height - fMin) / 2.0f) - a(getContext(), 48));
            this.f779h.set(f, fMax, f + fMin, fMin + fMax);
            canvas.drawRect(0.0f, 0.0f, width, this.f779h.top, this.c);
            canvas.drawRect(0.0f, this.f779h.bottom, width, height, this.c);
            RectF rectF = this.f779h;
            canvas.drawRect(0.0f, rectF.top, rectF.left, rectF.bottom, this.c);
            RectF rectF2 = this.f779h;
            canvas.drawRect(rectF2.right, rectF2.top, width, rectF2.bottom, this.c);
            canvas.drawRoundRect(this.f779h, a(getContext(), 6), a(getContext(), 6), this.d);
            float fA = a(getContext(), 26);
            RectF rectF3 = this.f779h;
            b(canvas, rectF3.left, rectF3.top, fA, true, true);
            RectF rectF4 = this.f779h;
            b(canvas, rectF4.right, rectF4.top, fA, false, true);
            RectF rectF5 = this.f779h;
            b(canvas, rectF5.left, rectF5.bottom, fA, true, false);
            RectF rectF6 = this.f779h;
            b(canvas, rectF6.right, rectF6.bottom, fA, false, false);
            RectF rectF7 = this.f779h;
            float fHeight = rectF7.top + (rectF7.height() * ((SystemClock.uptimeMillis() % 1600) / 1600.0f));
            canvas.drawLine(a(getContext(), 14) + this.f779h.left, fHeight, this.f779h.right - a(getContext(), 14), fHeight, this.f);
            canvas.drawText("将二维码放入框内", width / 2.0f, this.f779h.bottom + a(getContext(), 36), this.g);
            postInvalidateDelayed(16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(View view) throws CameraAccessException {
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int E(Size size, Size size2) {
        return Long.compare(m(size2), m(size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(String str) {
        Intent intent = new Intent();
        intent.putExtra("qrcode_result", str);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(String str) {
        Toast.makeText(this, str, 0).show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(ImageReader imageReader) {
        ExecutorService executorService;
        Image imageAcquireLatestImage = null;
        try {
            try {
                imageAcquireLatestImage = imageReader.acquireLatestImage();
            } catch (Exception unused) {
                this.J = false;
                if (imageAcquireLatestImage != null) {
                }
            }
            if (imageAcquireLatestImage != null && !this.I && !this.J && (executorService = this.g) != null && !executorService.isShutdown()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jElapsedRealtime - this.K < 180) {
                    if (imageAcquireLatestImage != null) {
                        imageAcquireLatestImage.close();
                        return;
                    }
                    return;
                }
                this.K = jElapsedRealtime;
                final byte[] bArrR = r(imageAcquireLatestImage);
                final int width = imageAcquireLatestImage.getWidth();
                final int height = imageAcquireLatestImage.getHeight();
                this.J = true;
                this.g.execute(new Runnable() { // from class: com.jsj.autojs.activity.h6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.I(bArrR, width, height);
                    }
                });
                if (imageAcquireLatestImage != null) {
                    imageAcquireLatestImage.close();
                }
                return;
            }
            if (imageAcquireLatestImage != null) {
                imageAcquireLatestImage.close();
            }
        } catch (Throwable th) {
            if (imageAcquireLatestImage != null) {
                imageAcquireLatestImage.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i2, int i3) throws CameraAccessException {
        if (checkSelfPermission("android.permission.CAMERA") != 0) {
            P("未获得相机权限");
            return;
        }
        try {
            if (!O()) {
                P("未找到可用相机");
                return;
            }
            q(i2, i3);
            CameraManager cameraManager = (CameraManager) getSystemService("camera");
            if (cameraManager != null) {
                cameraManager.openCamera(this.D, this.P, this.f);
            }
        } catch (Exception unused) {
            P("相机打开失败");
        }
    }

    private int N(int i2) {
        if (i2 == 1) {
            return 90;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 270;
        }
        return 180;
    }

    private boolean O() throws CameraAccessException {
        StreamConfigurationMap streamConfigurationMap;
        CameraManager cameraManager = (CameraManager) getSystemService("camera");
        if (cameraManager == null) {
            return false;
        }
        String[] cameraIdList = cameraManager.getCameraIdList();
        int length = cameraIdList.length;
        String str = null;
        int i2 = 0;
        CameraCharacteristics cameraCharacteristics = null;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str2 = cameraIdList[i2];
            CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(str2);
            Integer num = (Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING);
            if (num == null || num.intValue() != 0) {
                if (num != null && num.intValue() == 1) {
                    str = str2;
                    cameraCharacteristics = cameraCharacteristics2;
                    break;
                }
                str = str2;
                cameraCharacteristics = cameraCharacteristics2;
            }
            i2++;
        }
        if (str == null || cameraCharacteristics == null || (streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) == null) {
            return false;
        }
        this.A = o(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), 1280, 720);
        Size sizeO = o(streamConfigurationMap.getOutputSizes(35), 1280, 720);
        this.C = sizeO;
        if (this.A != null && sizeO != null) {
            this.D = str;
            Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
            this.G = bool != null && bool.booleanValue();
            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
            if (num2 != null) {
                this.M = num2.intValue();
            }
            this.d.setVisibility(this.G ? 0 : 8);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(final String str) {
        runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.g6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K(str);
            }
        });
    }

    private void Q() {
        HandlerThread handlerThread = new HandlerThread("qr-camera");
        this.e = handlerThread;
        handlerThread.start();
        this.f = new Handler(this.e.getLooper());
        this.g = Executors.newSingleThreadExecutor();
        i.f.a.j jVar = new i.f.a.j();
        this.f775h = jVar;
        jVar.e(com.jsj.autojs.l.f0.d());
    }

    private void R() {
        ExecutorService executorService = this.g;
        if (executorService != null) {
            executorService.shutdownNow();
            this.g = null;
        }
        this.f775h = null;
        HandlerThread handlerThread = this.e;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.e.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            this.e = null;
            this.f = null;
        }
    }

    private void S() throws CameraAccessException {
        if (!this.G || this.f777j == null || this.f778k == null) {
            return;
        }
        this.H = !this.H;
        l();
        this.d.setText(this.H ? "关灯" : "开灯");
        try {
            this.f777j.setRepeatingRequest(this.f778k.build(), null, this.f);
        } catch (CameraAccessException unused) {
        }
    }

    private void l() {
        CaptureRequest.Builder builder = this.f778k;
        if (builder == null) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        this.f778k.set(CaptureRequest.CONTROL_AF_MODE, 4);
        this.f778k.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.f778k.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.H ? 2 : 0));
    }

    private long m(Size size) {
        return size.getWidth() * size.getHeight();
    }

    private void n() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16777216);
        TextureView textureView = new TextureView(this);
        this.c = textureView;
        frameLayout.addView(textureView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(new d(this), new FrameLayout.LayoutParams(-1, -1));
        TextView textViewT = t("返回");
        textViewT.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.i6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.A(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(x(80), x(48), 8388659);
        layoutParams.topMargin = x(24);
        frameLayout.addView(textViewT, layoutParams);
        TextView textViewT2 = t("开灯");
        this.d = textViewT2;
        textViewT2.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.j6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws CameraAccessException {
                this.c.C(view);
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(x(80), x(48), 8388661);
        layoutParams2.topMargin = x(24);
        frameLayout.addView(this.d, layoutParams2);
        setContentView(frameLayout);
    }

    private Size o(Size[] sizeArr, int i2, int i3) {
        if (sizeArr == null || sizeArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (size.getWidth() <= i2 && size.getHeight() <= i3) {
                arrayList.add(size);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(Arrays.asList(sizeArr));
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.jsj.autojs.activity.f6
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.c.E((Size) obj, (Size) obj2);
            }
        });
        return (Size) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        CameraCaptureSession cameraCaptureSession = this.f777j;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.f777j = null;
        }
        CameraDevice cameraDevice = this.f776i;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.f776i = null;
        }
        ImageReader imageReader = this.t;
        if (imageReader != null) {
            imageReader.close();
            this.t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i2, int i3) {
        if (this.c == null || this.A == null || i2 == 0 || i3 == 0) {
            return;
        }
        int iN = ((this.M - N(getWindowManager().getDefaultDisplay().getRotation())) + 360) % 360;
        boolean z = iN == 90 || iN == 270;
        float f = i2;
        float f2 = i3;
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        RectF rectF2 = z ? new RectF(0.0f, 0.0f, this.A.getHeight(), this.A.getWidth()) : new RectF(0.0f, 0.0f, this.A.getWidth(), this.A.getHeight());
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        rectF2.offset(fCenterX - rectF2.centerX(), fCenterY - rectF2.centerY());
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        float fMax = Math.max(f2 / rectF2.height(), f / rectF2.width());
        matrix.postScale(fMax, fMax, fCenterX, fCenterY);
        matrix.postRotate(iN, fCenterX, fCenterY);
        this.c.setTransform(matrix);
    }

    private byte[] r(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane plane = image.getPlanes()[0];
        ByteBuffer buffer = plane.getBuffer();
        int rowStride = plane.getRowStride();
        int pixelStride = plane.getPixelStride();
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        if (pixelStride == 1 && rowStride == width) {
            buffer.get(bArr, 0, i2);
            return bArr;
        }
        int iLimit = buffer.limit();
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            int i5 = i4 * rowStride;
            for (int i6 = 0; i6 < width; i6++) {
                int i7 = (i6 * pixelStride) + i5;
                bArr[i3 + i6] = i7 < iLimit ? buffer.get(i7) : (byte) 0;
            }
            i3 += width;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() throws CameraAccessException {
        try {
            SurfaceTexture surfaceTexture = this.c.getSurfaceTexture();
            if (surfaceTexture != null && this.f776i != null) {
                surfaceTexture.setDefaultBufferSize(this.A.getWidth(), this.A.getHeight());
                Surface surface = new Surface(surfaceTexture);
                ImageReader imageReaderNewInstance = ImageReader.newInstance(this.C.getWidth(), this.C.getHeight(), 35, 2);
                this.t = imageReaderNewInstance;
                imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.jsj.autojs.activity.d6
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader) {
                        this.a.L(imageReader);
                    }
                }, this.f);
                CaptureRequest.Builder builderCreateCaptureRequest = this.f776i.createCaptureRequest(1);
                this.f778k = builderCreateCaptureRequest;
                builderCreateCaptureRequest.addTarget(surface);
                this.f778k.addTarget(this.t.getSurface());
                l();
                this.f776i.createCaptureSession(Arrays.asList(surface, this.t.getSurface()), new c(), this.f);
            }
        } catch (Exception unused) {
            P("相机预览失败");
        }
    }

    private TextView t(String str) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setBackgroundColor(855638016);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void I(byte[] bArr, int i2, int i3) {
        i.f.a.j jVar;
        try {
            i.f.a.p pVarV = v(new i.f.a.l(bArr, i2, i3, 0, 0, i2, i3, false));
            if (pVarV != null && !TextUtils.isEmpty(pVarV.f())) {
                w(pVarV.f());
            }
            jVar = this.f775h;
        } catch (Exception unused) {
            jVar = this.f775h;
            if (jVar != null) {
            }
        } catch (Throwable th) {
            i.f.a.j jVar2 = this.f775h;
            if (jVar2 != null) {
                jVar2.b();
            }
            this.J = false;
            throw th;
        }
        if (jVar != null) {
            jVar.b();
        }
        this.J = false;
    }

    private i.f.a.p v(i.f.a.i iVar) throws i.f.a.k {
        try {
            return this.f775h.d(new i.f.a.c(new i.f.a.v.j(iVar)));
        } catch (i.f.a.k unused) {
            return this.f775h.d(new i.f.a.c(new i.f.a.v.j(iVar.e())));
        }
    }

    private void w(final String str) {
        if (this.I) {
            return;
        }
        this.I = true;
        runOnUiThread(new Runnable() { // from class: com.jsj.autojs.activity.e6
            @Override // java.lang.Runnable
            public final void run() {
                this.c.G(str);
            }
        });
    }

    private int x(int i2) {
        return (int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(View view) {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(128);
        n();
    }

    @Override // android.app.Activity
    protected void onPause() {
        p();
        R();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() throws CameraAccessException {
        super.onResume();
        this.I = false;
        this.J = false;
        Q();
        if (this.c.isAvailable()) {
            M(this.c.getWidth(), this.c.getHeight());
        } else {
            this.c.setSurfaceTextureListener(this.O);
        }
    }
}
