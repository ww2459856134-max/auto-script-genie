package org.opencv.android;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.util.List;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes2.dex */
public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {
    private byte[] H;
    private Mat[] I;
    private int J;
    private Thread K;
    private boolean M;
    protected Camera O;
    protected c[] P;
    private SurfaceTexture Q;
    private int U;
    private boolean V;

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.V && !JavaCameraView.this.M) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    z = false;
                    if (JavaCameraView.this.V) {
                        JavaCameraView javaCameraView = JavaCameraView.this;
                        javaCameraView.J = 1 - javaCameraView.J;
                        JavaCameraView.this.V = false;
                        z = true;
                    }
                }
                if (!JavaCameraView.this.M && z && !JavaCameraView.this.I[1 - JavaCameraView.this.J].d()) {
                    JavaCameraView javaCameraView2 = JavaCameraView.this;
                    javaCameraView2.e(javaCameraView2.P[1 - javaCameraView2.J]);
                }
            } while (!JavaCameraView.this.M);
            Log.d("JavaCameraView", "Finish processing thread");
        }
    }

    private class c implements CameraBridgeViewBase.b {
        private Mat a;
        private Mat b = new Mat();
        private int c;
        private int d;

        public c(Mat mat, int i2, int i3) {
            this.c = i2;
            this.d = i3;
            this.a = mat;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.b
        public Mat a() {
            return this.a.j(0, this.d, 0, this.c);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.b
        public Mat b() {
            if (JavaCameraView.this.U == 17) {
                Imgproc.c(this.a, this.b, 96, 4);
            } else {
                if (JavaCameraView.this.U != 842094169) {
                    throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
                }
                Imgproc.c(this.a, this.b, 100, 4);
            }
            return this.b;
        }

        public void c() {
            this.b.h();
        }
    }

    public static class d implements CameraBridgeViewBase.f {
        @Override // org.opencv.android.CameraBridgeViewBase.f
        public int a(Object obj) {
            return ((Camera.Size) obj).height;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.f
        public int b(Object obj) {
            return ((Camera.Size) obj).width;
        }
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = 0;
        this.U = 17;
        this.V = false;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected boolean d(int i2, int i3) {
        Log.d("JavaCameraView", "Connecting to camera");
        if (!u(i2, i3)) {
            return false;
        }
        this.V = false;
        Log.d("JavaCameraView", "Starting processing thread");
        this.M = false;
        Thread thread = new Thread(new b());
        this.K = thread;
        thread.start();
        return true;
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected void f() {
        Log.d("JavaCameraView", "Disconnecting from camera");
        try {
            try {
                this.M = true;
                Log.d("JavaCameraView", "Notify thread");
                synchronized (this) {
                    notify();
                }
                Log.d("JavaCameraView", "Waiting for thread");
                Thread thread = this.K;
                if (thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.K = null;
            v();
            this.V = false;
        } catch (Throwable th) {
            this.K = null;
            throw th;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.I[this.J].g(0, 0, bArr);
            this.V = true;
            notify();
        }
        Camera camera2 = this.O;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.H);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0269 A[Catch: Exception -> 0x0300, all -> 0x0306, TryCatch #0 {Exception -> 0x0300, blocks: (B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf), top: B:114:0x014a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02de A[Catch: Exception -> 0x0300, all -> 0x0306, TryCatch #0 {Exception -> 0x0300, blocks: (B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf), top: B:114:0x014a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ed A[Catch: Exception -> 0x0300, all -> 0x0306, TryCatch #0 {Exception -> 0x0300, blocks: (B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf), top: B:114:0x014a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9 A[Catch: all -> 0x0306, TryCatch #3 {, blocks: (B:5:0x0009, B:7:0x0014, B:8:0x001b, B:12:0x003d, B:14:0x0041, B:17:0x0047, B:19:0x004d, B:20:0x006c, B:26:0x009b, B:23:0x0075, B:55:0x0144, B:57:0x0148, B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf, B:109:0x0304, B:108:0x0301, B:11:0x0023, B:27:0x009e, B:31:0x00a8, B:32:0x00b5, B:34:0x00bb, B:37:0x00c3, B:47:0x00e9, B:49:0x00f3, B:50:0x00fb, B:51:0x011a, B:54:0x0122, B:39:0x00c8, B:40:0x00d5, B:42:0x00db, B:45:0x00e4), top: B:120:0x0009, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0144 A[Catch: all -> 0x0306, EDGE_INSN: B:25:0x0099->B:55:0x0144 BREAK  A[LOOP:0: B:17:0x0047->B:26:0x009b], TryCatch #3 {, blocks: (B:5:0x0009, B:7:0x0014, B:8:0x001b, B:12:0x003d, B:14:0x0041, B:17:0x0047, B:19:0x004d, B:20:0x006c, B:26:0x009b, B:23:0x0075, B:55:0x0144, B:57:0x0148, B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf, B:109:0x0304, B:108:0x0301, B:11:0x0023, B:27:0x009e, B:31:0x00a8, B:32:0x00b5, B:34:0x00bb, B:37:0x00c3, B:47:0x00e9, B:49:0x00f3, B:50:0x00fb, B:51:0x011a, B:54:0x0122, B:39:0x00c8, B:40:0x00d5, B:42:0x00db, B:45:0x00e4), top: B:120:0x0009, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148 A[Catch: all -> 0x0306, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {, blocks: (B:5:0x0009, B:7:0x0014, B:8:0x001b, B:12:0x003d, B:14:0x0041, B:17:0x0047, B:19:0x004d, B:20:0x006c, B:26:0x009b, B:23:0x0075, B:55:0x0144, B:57:0x0148, B:59:0x014a, B:61:0x015b, B:63:0x016e, B:65:0x0176, B:67:0x0180, B:69:0x0188, B:71:0x0190, B:73:0x019a, B:75:0x01a4, B:77:0x01ae, B:80:0x01b9, B:82:0x01c5, B:84:0x0206, B:86:0x0210, B:87:0x0213, B:89:0x0219, B:91:0x0221, B:92:0x0226, B:94:0x0249, B:96:0x0251, B:98:0x0265, B:100:0x0269, B:101:0x0270, B:103:0x02de, B:105:0x02f2, B:104:0x02ed, B:97:0x0262, B:81:0x01bf, B:109:0x0304, B:108:0x0301, B:11:0x0023, B:27:0x009e, B:31:0x00a8, B:32:0x00b5, B:34:0x00bb, B:37:0x00c3, B:47:0x00e9, B:49:0x00f3, B:50:0x00fb, B:51:0x011a, B:54:0x0122, B:39:0x00c8, B:40:0x00d5, B:42:0x00db, B:45:0x00e4), top: B:120:0x0009, inners: #0, #1, #2, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean u(int i2, int i3) {
        int i4;
        Camera camera;
        int i5;
        List<String> supportedFocusModes;
        t tVar;
        Log.d("JavaCameraView", "Initialize java camera");
        synchronized (this) {
            this.O = null;
            int i6 = this.C;
            boolean z = false;
            if (i6 == -1) {
                Log.d("JavaCameraView", "Trying to open camera with old open()");
                try {
                    this.O = Camera.open();
                } catch (Exception e) {
                    Log.e("JavaCameraView", "Camera is not available (in use or does not exist): " + e.getLocalizedMessage());
                }
                if (this.O != null || Build.VERSION.SDK_INT < 9) {
                    camera = this.O;
                    if (camera != null) {
                        return false;
                    }
                    try {
                        Camera.Parameters parameters = camera.getParameters();
                        Log.d("JavaCameraView", "getSupportedPreviewSizes()");
                        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                        if (supportedPreviewSizes != null) {
                            org.opencv.core.d dVarB = b(supportedPreviewSizes, new d(), i2, i3);
                            String str = Build.FINGERPRINT;
                            if (!str.startsWith("generic") && !str.startsWith("unknown")) {
                                String str2 = Build.MODEL;
                                if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                                    parameters.setPreviewFormat(17);
                                }
                                this.U = parameters.getPreviewFormat();
                                Log.d("JavaCameraView", "Set preview size to " + Integer.valueOf((int) dVarB.a) + "x" + Integer.valueOf((int) dVarB.b));
                                parameters.setPreviewSize((int) dVarB.a, (int) dVarB.b);
                                i5 = Build.VERSION.SDK_INT;
                                if (i5 >= 14 && !Build.MODEL.equals("GT-I9100")) {
                                    parameters.setRecordingHint(true);
                                }
                                supportedFocusModes = parameters.getSupportedFocusModes();
                                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                    parameters.setFocusMode("continuous-video");
                                }
                                this.O.setParameters(parameters);
                                Camera.Parameters parameters2 = this.O.getParameters();
                                this.f2573h = parameters2.getPreviewSize().width;
                                this.f2574i = parameters2.getPreviewSize().height;
                                if (getLayoutParams().width == -1 || getLayoutParams().height != -1) {
                                    this.t = 0.0f;
                                } else {
                                    this.t = Math.min(i3 / this.f2574i, i2 / this.f2573h);
                                }
                                tVar = this.G;
                                if (tVar != null) {
                                    tVar.d(this.f2573h, this.f2574i);
                                }
                                byte[] bArr = new byte[((this.f2573h * this.f2574i) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8];
                                this.H = bArr;
                                this.O.addCallbackBuffer(bArr);
                                this.O.setPreviewCallbackWithBuffer(this);
                                Mat[] matArr = new Mat[2];
                                this.I = matArr;
                                int i7 = this.f2574i;
                                int i8 = this.f2573h;
                                int i9 = org.opencv.core.b.a;
                                matArr[0] = new Mat(i7 + (i7 / 2), i8, i9);
                                Mat[] matArr2 = this.I;
                                int i10 = this.f2574i;
                                matArr2[1] = new Mat(i10 + (i10 / 2), this.f2573h, i9);
                                a();
                                c[] cVarArr = new c[2];
                                this.P = cVarArr;
                                cVarArr[0] = new c(this.I[0], this.f2573h, this.f2574i);
                                this.P[1] = new c(this.I[1], this.f2573h, this.f2574i);
                                if (i5 < 11) {
                                    SurfaceTexture surfaceTexture = new SurfaceTexture(10);
                                    this.Q = surfaceTexture;
                                    this.O.setPreviewTexture(surfaceTexture);
                                } else {
                                    this.O.setPreviewDisplay(null);
                                }
                                Log.d("JavaCameraView", "startPreview");
                                this.O.startPreview();
                                z = true;
                            }
                            parameters.setPreviewFormat(842094169);
                            this.U = parameters.getPreviewFormat();
                            Log.d("JavaCameraView", "Set preview size to " + Integer.valueOf((int) dVarB.a) + "x" + Integer.valueOf((int) dVarB.b));
                            parameters.setPreviewSize((int) dVarB.a, (int) dVarB.b);
                            i5 = Build.VERSION.SDK_INT;
                            if (i5 >= 14) {
                                parameters.setRecordingHint(true);
                            }
                            supportedFocusModes = parameters.getSupportedFocusModes();
                            if (supportedFocusModes != null) {
                                parameters.setFocusMode("continuous-video");
                            }
                            this.O.setParameters(parameters);
                            Camera.Parameters parameters22 = this.O.getParameters();
                            this.f2573h = parameters22.getPreviewSize().width;
                            this.f2574i = parameters22.getPreviewSize().height;
                            if (getLayoutParams().width == -1) {
                            }
                            this.t = 0.0f;
                            tVar = this.G;
                            if (tVar != null) {
                            }
                            byte[] bArr2 = new byte[((this.f2573h * this.f2574i) * ImageFormat.getBitsPerPixel(parameters22.getPreviewFormat())) / 8];
                            this.H = bArr2;
                            this.O.addCallbackBuffer(bArr2);
                            this.O.setPreviewCallbackWithBuffer(this);
                            Mat[] matArr3 = new Mat[2];
                            this.I = matArr3;
                            int i72 = this.f2574i;
                            int i82 = this.f2573h;
                            int i92 = org.opencv.core.b.a;
                            matArr3[0] = new Mat(i72 + (i72 / 2), i82, i92);
                            Mat[] matArr22 = this.I;
                            int i102 = this.f2574i;
                            matArr22[1] = new Mat(i102 + (i102 / 2), this.f2573h, i92);
                            a();
                            c[] cVarArr2 = new c[2];
                            this.P = cVarArr2;
                            cVarArr2[0] = new c(this.I[0], this.f2573h, this.f2574i);
                            this.P[1] = new c(this.I[1], this.f2573h, this.f2574i);
                            if (i5 < 11) {
                            }
                            Log.d("JavaCameraView", "startPreview");
                            this.O.startPreview();
                            z = true;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return z;
                }
                boolean z2 = false;
                for (int i11 = 0; i11 < Camera.getNumberOfCameras(); i11++) {
                    Log.d("JavaCameraView", "Trying to open camera with new open(" + Integer.valueOf(i11) + ")");
                    try {
                        this.O = Camera.open(i11);
                        z2 = true;
                    } catch (RuntimeException e3) {
                        Log.e("JavaCameraView", "Camera #" + i11 + "failed to open: " + e3.getLocalizedMessage());
                    }
                    if (z2) {
                        break;
                    }
                }
                camera = this.O;
                if (camera != null) {
                }
            } else if (Build.VERSION.SDK_INT >= 9) {
                if (i6 == 99) {
                    Log.i("JavaCameraView", "Trying to open back camera");
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    i4 = 0;
                    while (i4 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i4, cameraInfo);
                        if (cameraInfo.facing == 0) {
                            i6 = i4;
                            break;
                        }
                        i4++;
                    }
                    if (i6 != 99) {
                        Log.e("JavaCameraView", "Back camera not found!");
                    } else if (i6 == 98) {
                        Log.e("JavaCameraView", "Front camera not found!");
                    } else {
                        Log.d("JavaCameraView", "Trying to open camera with new open(" + Integer.valueOf(i6) + ")");
                        try {
                            this.O = Camera.open(i6);
                        } catch (RuntimeException e4) {
                            Log.e("JavaCameraView", "Camera #" + i6 + "failed to open: " + e4.getLocalizedMessage());
                        }
                    }
                    camera = this.O;
                    if (camera != null) {
                    }
                } else {
                    if (i6 == 98) {
                        Log.i("JavaCameraView", "Trying to open front camera");
                        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                        i4 = 0;
                        while (i4 < Camera.getNumberOfCameras()) {
                            Camera.getCameraInfo(i4, cameraInfo2);
                            if (cameraInfo2.facing == 1) {
                                i6 = i4;
                                break;
                            }
                            i4++;
                        }
                    }
                    if (i6 != 99) {
                    }
                    camera = this.O;
                    if (camera != null) {
                    }
                }
            }
        }
    }

    protected void v() {
        synchronized (this) {
            Camera camera = this.O;
            if (camera != null) {
                camera.stopPreview();
                this.O.setPreviewCallback(null);
                this.O.release();
            }
            this.O = null;
            Mat[] matArr = this.I;
            if (matArr != null) {
                matArr[0].h();
                this.I[1].h();
            }
            c[] cVarArr = this.P;
            if (cVarArr != null) {
                cVarArr[0].c();
                this.P[1].c();
            }
        }
    }
}
