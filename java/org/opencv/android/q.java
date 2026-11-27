package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
/* loaded from: classes2.dex */
public class q extends r {
    private CameraDevice E;
    private CameraCaptureSession F;
    private CaptureRequest.Builder G;
    private String H;
    private Size I;
    private HandlerThread J;
    private Handler K;
    private Semaphore L;
    private final CameraDevice.StateCallback M;

    q(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
        this.I = new Size(-1, -1);
        this.L = new Semaphore(1);
        this.M = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        int width = this.I.getWidth();
        int height = this.I.getHeight();
        Log.i("Camera2Renderer", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0) {
            if (height < 0) {
                return;
            }
            try {
                this.L.acquire();
                if (this.E == null) {
                    this.L.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                    return;
                }
                if (this.F != null) {
                    this.L.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: mCaptureSession is already started");
                    return;
                }
                SurfaceTexture surfaceTexture = this.x;
                if (surfaceTexture == null) {
                    this.L.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
                    return;
                }
                surfaceTexture.setDefaultBufferSize(width, height);
                Surface surface = new Surface(this.x);
                CaptureRequest.Builder builderCreateCaptureRequest = this.E.createCaptureRequest(1);
                this.G = builderCreateCaptureRequest;
                builderCreateCaptureRequest.addTarget(surface);
                this.E.createCaptureSession(Arrays.asList(surface), new p(this), this.K);
            } catch (CameraAccessException unused) {
                Log.e("Camera2Renderer", "createCameraPreviewSession");
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while createCameraPreviewSession", e);
            }
        }
    }

    private void F() {
        Log.i("Camera2Renderer", "startBackgroundThread");
        G();
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.J = handlerThread;
        handlerThread.start();
        this.K = new Handler(this.J.getLooper());
    }

    private void G() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        HandlerThread handlerThread = this.J;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.J.join();
            this.J = null;
            this.K = null;
        } catch (InterruptedException unused) {
            Log.e("Camera2Renderer", "stopBackgroundThread");
        }
    }

    boolean D(int i2, int i3) {
        Log.i("Camera2Renderer", "cacPreviewSize: " + i2 + "x" + i3);
        if (this.H == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        try {
            float f = i2 / i3;
            int i4 = 0;
            int i5 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.D.getContext().getSystemService("camera")).getCameraCharacteristics(this.H).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                if (i2 >= width && i3 >= height && i4 <= width && i5 <= height && Math.abs(f - (width / height)) < 0.2d) {
                    i5 = height;
                    i4 = width;
                }
            }
            Log.i("Camera2Renderer", "best size: " + i4 + "x" + i5);
            if (i4 != 0 && i5 != 0 && (this.I.getWidth() != i4 || this.I.getHeight() != i5)) {
                this.I = new Size(i4, i5);
                return true;
            }
            return false;
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "cacPreviewSize - Camera Access Exception");
            return false;
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "cacPreviewSize - Illegal Argument Exception");
            return false;
        } catch (SecurityException unused3) {
            Log.e("Camera2Renderer", "cacPreviewSize - Security Exception");
            return false;
        }
    }

    @Override // org.opencv.android.r
    protected void a() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            try {
                this.L.acquire();
                CameraCaptureSession cameraCaptureSession = this.F;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.F = null;
                }
                CameraDevice cameraDevice = this.E;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.E = null;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
            }
        } finally {
            this.L.release();
        }
    }

    @Override // org.opencv.android.r
    protected void f() {
        Log.d("Camera2Renderer", "doStart");
        F();
        super.f();
    }

    @Override // org.opencv.android.r
    protected void g() {
        Log.d("Camera2Renderer", "doStop");
        super.g();
        G();
    }

    @Override // org.opencv.android.r
    protected void q(int i2) throws CameraAccessException {
        Log.i("Camera2Renderer", "openCamera");
        CameraManager cameraManager = (CameraManager) this.D.getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("Camera2Renderer", "Error: camera isn't detected.");
                return;
            }
            if (i2 != -1) {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if ((i2 == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (i2 == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                        this.H = str;
                        break;
                    }
                }
            } else {
                this.H = cameraIdList[0];
            }
            if (this.H != null) {
                if (!this.L.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                    throw new RuntimeException("Time out waiting to lock camera opening.");
                }
                Log.i("Camera2Renderer", "Opening camera: " + this.H);
                cameraManager.openCamera(this.H, this.M, this.K);
            }
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "OpenCamera - Camera Access Exception");
        } catch (IllegalArgumentException unused2) {
            Log.e("Camera2Renderer", "OpenCamera - Illegal Argument Exception");
        } catch (InterruptedException unused3) {
            Log.e("Camera2Renderer", "OpenCamera - Interrupted Exception");
        } catch (SecurityException unused4) {
            Log.e("Camera2Renderer", "OpenCamera - Security Exception");
        }
    }

    @Override // org.opencv.android.r
    protected void s(int i2, int i3) throws InterruptedException {
        Log.i("Camera2Renderer", "setCameraPreviewSize(" + i2 + "x" + i3 + ")");
        int i4 = this.u;
        if (i4 > 0 && i4 < i2) {
            i2 = i4;
        }
        int i5 = this.v;
        if (i5 > 0 && i5 < i3) {
            i3 = i5;
        }
        try {
            this.L.acquire();
            boolean zD = D(i2, i3);
            this.q = this.I.getWidth();
            this.r = this.I.getHeight();
            if (!zD) {
                this.L.release();
                return;
            }
            if (this.F != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.F.close();
                this.F = null;
            }
            this.L.release();
            E();
        } catch (InterruptedException e) {
            this.L.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }
}
