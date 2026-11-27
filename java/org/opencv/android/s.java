package org.opencv.android;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.List;

@TargetApi(15)
/* loaded from: classes2.dex */
public class s extends r {
    private Camera E;
    private boolean F;

    s(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.F = false;
    }

    @Override // org.opencv.android.r
    protected synchronized void a() {
        Log.i("CameraRenderer", "closeCamera");
        Camera camera = this.E;
        if (camera != null) {
            camera.stopPreview();
            this.F = false;
            this.E.release();
            this.E = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e2 A[Catch: all -> 0x0187, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:53:0x0139, B:55:0x013d, B:58:0x0146, B:60:0x0150, B:62:0x0158, B:63:0x015d, B:64:0x0162, B:67:0x016b, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a3, B:30:0x00af, B:32:0x00b5, B:35:0x00bd, B:45:0x00e2, B:47:0x00ec, B:48:0x00f4, B:49:0x010f, B:52:0x0117, B:37:0x00c2, B:38:0x00ce, B:40:0x00d4, B:43:0x00dd), top: B:79:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0139 A[Catch: all -> 0x0187, EDGE_INSN: B:23:0x0092->B:53:0x0139 BREAK  A[LOOP:0: B:15:0x0044->B:24:0x0094], TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:53:0x0139, B:55:0x013d, B:58:0x0146, B:60:0x0150, B:62:0x0158, B:63:0x015d, B:64:0x0162, B:67:0x016b, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a3, B:30:0x00af, B:32:0x00b5, B:35:0x00bd, B:45:0x00e2, B:47:0x00ec, B:48:0x00f4, B:49:0x010f, B:52:0x0117, B:37:0x00c2, B:38:0x00ce, B:40:0x00d4, B:43:0x00dd), top: B:79:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:53:0x0139, B:55:0x013d, B:58:0x0146, B:60:0x0150, B:62:0x0158, B:63:0x015d, B:64:0x0162, B:67:0x016b, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a3, B:30:0x00af, B:32:0x00b5, B:35:0x00bd, B:45:0x00e2, B:47:0x00ec, B:48:0x00f4, B:49:0x010f, B:52:0x0117, B:37:0x00c2, B:38:0x00ce, B:40:0x00d4, B:43:0x00dd), top: B:79:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146 A[Catch: all -> 0x0187, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0019, B:10:0x003b, B:12:0x003f, B:15:0x0044, B:17:0x004a, B:18:0x0065, B:24:0x0094, B:21:0x006e, B:53:0x0139, B:55:0x013d, B:58:0x0146, B:60:0x0150, B:62:0x0158, B:63:0x015d, B:64:0x0162, B:67:0x016b, B:9:0x0021, B:25:0x0097, B:27:0x009b, B:29:0x00a3, B:30:0x00af, B:32:0x00b5, B:35:0x00bd, B:45:0x00e2, B:47:0x00ec, B:48:0x00f4, B:49:0x010f, B:52:0x0117, B:37:0x00c2, B:38:0x00ce, B:40:0x00d4, B:43:0x00dd), top: B:79:0x0001, inners: #0, #1, #2, #4 }] */
    @Override // org.opencv.android.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected synchronized void q(int i2) {
        Camera camera;
        Log.i("CameraRenderer", "openCamera");
        a();
        int i3 = 0;
        if (i2 == -1) {
            Log.d("CameraRenderer", "Trying to open camera with old open()");
            try {
                this.E = Camera.open();
            } catch (Exception e) {
                Log.e("CameraRenderer", "Camera is not available (in use or does not exist): " + e.getLocalizedMessage());
            }
            if (this.E != null || Build.VERSION.SDK_INT < 9) {
                camera = this.E;
                if (camera != null) {
                    Log.e("CameraRenderer", "Error: can't open camera");
                    return;
                }
                Camera.Parameters parameters = camera.getParameters();
                List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                    parameters.setFocusMode("continuous-video");
                }
                this.E.setParameters(parameters);
                try {
                    this.E.setPreviewTexture(this.x);
                } catch (IOException e2) {
                    Log.e("CameraRenderer", "setPreviewTexture() failed: " + e2.getMessage());
                }
                return;
            }
            boolean z = false;
            while (i3 < Camera.getNumberOfCameras()) {
                Log.d("CameraRenderer", "Trying to open camera with new open(" + i3 + ")");
                try {
                    this.E = Camera.open(i3);
                    z = true;
                } catch (RuntimeException e3) {
                    Log.e("CameraRenderer", "Camera #" + i3 + "failed to open: " + e3.getLocalizedMessage());
                }
                if (z) {
                    break;
                } else {
                    i3++;
                }
            }
            camera = this.E;
            if (camera != null) {
            }
        } else if (Build.VERSION.SDK_INT >= 9) {
            int i4 = this.w;
            if (i4 == 99) {
                Log.i("CameraRenderer", "Trying to open BACK camera");
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                while (i3 < Camera.getNumberOfCameras()) {
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        i4 = i3;
                        break;
                    }
                    i3++;
                }
                if (i4 != 99) {
                    Log.e("CameraRenderer", "Back camera not found!");
                } else if (i4 == 98) {
                    Log.e("CameraRenderer", "Front camera not found!");
                } else {
                    Log.d("CameraRenderer", "Trying to open camera with new open(" + i4 + ")");
                    try {
                        this.E = Camera.open(i4);
                    } catch (RuntimeException e4) {
                        Log.e("CameraRenderer", "Camera #" + i4 + "failed to open: " + e4.getLocalizedMessage());
                    }
                }
                camera = this.E;
                if (camera != null) {
                }
            } else {
                if (i4 == 98) {
                    Log.i("CameraRenderer", "Trying to open FRONT camera");
                    Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                    while (i3 < Camera.getNumberOfCameras()) {
                        Camera.getCameraInfo(i3, cameraInfo2);
                        if (cameraInfo2.facing == 1) {
                            i4 = i3;
                            break;
                        }
                        i3++;
                    }
                }
                if (i4 != 99) {
                }
                camera = this.E;
                if (camera != null) {
                }
            }
        }
    }

    @Override // org.opencv.android.r
    public synchronized void s(int i2, int i3) {
        Log.i("CameraRenderer", "setCameraPreviewSize: " + i2 + "x" + i3);
        Camera camera = this.E;
        if (camera == null) {
            Log.e("CameraRenderer", "Camera isn't initialized!");
            return;
        }
        int i4 = this.u;
        if (i4 > 0 && i4 < i2) {
            i2 = i4;
        }
        int i5 = this.v;
        if (i5 > 0 && i5 < i3) {
            i3 = i5;
        }
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes.size() > 0) {
            float f = i2 / i3;
            int i6 = 0;
            int i7 = 0;
            for (Camera.Size size : supportedPreviewSizes) {
                int i8 = size.width;
                int i9 = size.height;
                Log.d("CameraRenderer", "checking camera preview size: " + i8 + "x" + i9);
                if (i8 <= i2 && i9 <= i3 && i8 >= i6 && i9 >= i7 && Math.abs(f - (i8 / i9)) < 0.2d) {
                    i7 = i9;
                    i6 = i8;
                }
            }
            if (i6 <= 0 || i7 <= 0) {
                i6 = supportedPreviewSizes.get(0).width;
                i7 = supportedPreviewSizes.get(0).height;
                Log.e("CameraRenderer", "Error: best size was not selected, using " + i6 + " x " + i7);
            } else {
                Log.i("CameraRenderer", "Selected best size: " + i6 + " x " + i7);
            }
            if (this.F) {
                this.E.stopPreview();
                this.F = false;
            }
            this.q = i6;
            this.r = i7;
            parameters.setPreviewSize(i6, i7);
        }
        parameters.set("orientation", "landscape");
        this.E.setParameters(parameters);
        this.E.startPreview();
        this.F = true;
    }
}
