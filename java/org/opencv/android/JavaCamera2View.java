package org.opencv.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

@TargetApi(21)
/* loaded from: classes2.dex */
public class JavaCamera2View extends CameraBridgeViewBase {
    private ImageReader H;
    private int I;
    private CameraDevice J;
    private CameraCaptureSession K;
    private CaptureRequest.Builder M;
    private String O;
    private Size P;
    private HandlerThread Q;
    private Handler U;
    private final CameraDevice.StateCallback V;

    class a extends CameraDevice.StateCallback {
        a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            JavaCamera2View.this.J = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            cameraDevice.close();
            JavaCamera2View.this.J = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) throws CameraAccessException {
            JavaCamera2View.this.J = cameraDevice;
            JavaCamera2View.this.w();
        }
    }

    class b implements ImageReader.OnImageAvailableListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        b(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image imageAcquireLatestImage = imageReader.acquireLatestImage();
            if (imageAcquireLatestImage == null) {
                return;
            }
            Image.Plane[] planes = imageAcquireLatestImage.getPlanes();
            ByteBuffer buffer = planes[0].getBuffer();
            ByteBuffer buffer2 = planes[1].getBuffer();
            d dVar = JavaCamera2View.this.new d(new Mat(this.a, this.b, org.opencv.core.b.a, buffer), new Mat(this.a / 2, this.b / 2, org.opencv.core.b.b, buffer2), this.b, this.a);
            JavaCamera2View.this.e(dVar);
            dVar.c();
            imageAcquireLatestImage.close();
        }
    }

    class c extends CameraCaptureSession.StateCallback {
        c() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e("JavaCamera2View", "createCameraPreviewSession failed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
            Log.i("JavaCamera2View", "createCaptureSession::onConfigured");
            if (JavaCamera2View.this.J == null) {
                return;
            }
            JavaCamera2View.this.K = cameraCaptureSession;
            try {
                JavaCamera2View.this.M.set(CaptureRequest.CONTROL_AF_MODE, 4);
                JavaCamera2View.this.M.set(CaptureRequest.CONTROL_AE_MODE, 2);
                JavaCamera2View.this.K.setRepeatingRequest(JavaCamera2View.this.M.build(), null, JavaCamera2View.this.U);
                Log.i("JavaCamera2View", "CameraPreviewSession has been started");
            } catch (Exception e) {
                Log.e("JavaCamera2View", "createCaptureSession failed", e);
            }
        }
    }

    private class d implements CameraBridgeViewBase.b {
        private Mat a;
        private Mat b;
        private Mat c = new Mat();
        private int d;
        private int e;

        public d(Mat mat, Mat mat2, int i2, int i3) {
            this.d = i2;
            this.e = i3;
            this.a = mat;
            this.b = mat2;
        }

        @Override // org.opencv.android.CameraBridgeViewBase.b
        public Mat a() {
            return this.a.j(0, this.e, 0, this.d);
        }

        @Override // org.opencv.android.CameraBridgeViewBase.b
        public Mat b() {
            if (JavaCamera2View.this.I == 17) {
                Imgproc.c(this.a, this.c, 96, 4);
            } else if (JavaCamera2View.this.I == 842094169) {
                Imgproc.c(this.a, this.c, 100, 4);
            } else {
                if (JavaCamera2View.this.I != 35) {
                    throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
                }
                Imgproc.d(this.a, this.b, this.c, 96);
            }
            return this.c;
        }

        public void c() {
            this.c.h();
        }
    }

    public JavaCamera2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 35;
        this.P = new Size(-1, -1);
        this.V = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() throws CameraAccessException {
        int width = this.P.getWidth();
        int height = this.P.getHeight();
        Log.i("JavaCamera2View", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width < 0 || height < 0) {
            return;
        }
        try {
            if (this.J == null) {
                Log.e("JavaCamera2View", "createCameraPreviewSession: camera isn't opened");
                return;
            }
            if (this.K != null) {
                Log.e("JavaCamera2View", "createCameraPreviewSession: mCaptureSession is already started");
                return;
            }
            ImageReader imageReaderNewInstance = ImageReader.newInstance(width, height, this.I, 2);
            this.H = imageReaderNewInstance;
            imageReaderNewInstance.setOnImageAvailableListener(new b(height, width), this.U);
            Surface surface = this.H.getSurface();
            CaptureRequest.Builder builderCreateCaptureRequest = this.J.createCaptureRequest(1);
            this.M = builderCreateCaptureRequest;
            builderCreateCaptureRequest.addTarget(surface);
            this.J.createCaptureSession(Arrays.asList(surface), new c(), null);
        } catch (CameraAccessException e) {
            Log.e("JavaCamera2View", "createCameraPreviewSession", e);
        }
    }

    private void y() {
        Log.i("JavaCamera2View", "startBackgroundThread");
        z();
        HandlerThread handlerThread = new HandlerThread("OpenCVCameraBackground");
        this.Q = handlerThread;
        handlerThread.start();
        this.U = new Handler(this.Q.getLooper());
    }

    private void z() {
        Log.i("JavaCamera2View", "stopBackgroundThread");
        HandlerThread handlerThread = this.Q;
        if (handlerThread == null) {
            return;
        }
        handlerThread.quitSafely();
        try {
            this.Q.join();
            this.Q = null;
            this.U = null;
        } catch (InterruptedException e) {
            Log.e("JavaCamera2View", "stopBackgroundThread", e);
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected boolean d(int i2, int i3) throws CameraAccessException {
        Log.i("JavaCamera2View", "setCameraPreviewSize(" + i2 + "x" + i3 + ")");
        y();
        x();
        try {
            boolean zV = v(i2, i3);
            this.f2573h = this.P.getWidth();
            this.f2574i = this.P.getHeight();
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.t = Math.min(i3 / this.f2574i, i2 / this.f2573h);
            } else {
                this.t = 0.0f;
            }
            a();
            if (!zV) {
                return true;
            }
            if (this.K != null) {
                Log.d("JavaCamera2View", "closing existing previewSession");
                this.K.close();
                this.K = null;
            }
            w();
            return true;
        } catch (RuntimeException e) {
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e);
        }
    }

    @Override // org.opencv.android.CameraBridgeViewBase
    protected void f() {
        Log.i("JavaCamera2View", "closeCamera");
        try {
            CameraDevice cameraDevice = this.J;
            this.J = null;
            CameraCaptureSession cameraCaptureSession = this.K;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.K = null;
            }
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            ImageReader imageReader = this.H;
            if (imageReader != null) {
                imageReader.close();
                this.H = null;
            }
        } finally {
            z();
        }
    }

    boolean v(int i2, int i3) {
        Log.i("JavaCamera2View", "calcPreviewSize: " + i2 + "x" + i3);
        if (this.O == null) {
            Log.e("JavaCamera2View", "Camera isn't initialized!");
            return false;
        }
        try {
            float f = i2 / i3;
            Size[] outputSizes = ((StreamConfigurationMap) ((CameraManager) getContext().getSystemService("camera")).getCameraCharacteristics(this.O).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class);
            int width = outputSizes[0].getWidth();
            int height = outputSizes[0].getHeight();
            for (Size size : outputSizes) {
                int width2 = size.getWidth();
                int height2 = size.getHeight();
                Log.d("JavaCamera2View", "trying size: " + width2 + "x" + height2);
                if (i2 >= width2 && i3 >= height2 && width <= width2 && height <= height2 && Math.abs(f - (width2 / height2)) < 0.2d) {
                    height = height2;
                    width = width2;
                }
            }
            Log.i("JavaCamera2View", "best size: " + width + "x" + height);
            if (this.P.getWidth() == width && this.P.getHeight() == height) {
                return false;
            }
            this.P = new Size(width, height);
            return true;
        } catch (CameraAccessException e) {
            Log.e("JavaCamera2View", "calcPreviewSize - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("JavaCamera2View", "calcPreviewSize - Illegal Argument Exception", e2);
            return false;
        } catch (SecurityException e3) {
            Log.e("JavaCamera2View", "calcPreviewSize - Security Exception", e3);
            return false;
        }
    }

    protected boolean x() throws CameraAccessException {
        Log.i("JavaCamera2View", "initializeCamera");
        CameraManager cameraManager = (CameraManager) getContext().getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length == 0) {
                Log.e("JavaCamera2View", "Error: camera isn't detected.");
                return false;
            }
            if (this.C != -1) {
                for (String str : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    if ((this.C == 99 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) || (this.C == 98 && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                        this.O = str;
                        break;
                    }
                }
            } else {
                this.O = cameraIdList[0];
            }
            if (this.O != null) {
                Log.i("JavaCamera2View", "Opening camera: " + this.O);
                cameraManager.openCamera(this.O, this.V, this.U);
            }
            return true;
        } catch (CameraAccessException e) {
            Log.e("JavaCamera2View", "OpenCamera - Camera Access Exception", e);
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e("JavaCamera2View", "OpenCamera - Illegal Argument Exception", e2);
            return false;
        } catch (SecurityException e3) {
            Log.e("JavaCamera2View", "OpenCamera - Security Exception", e3);
            return false;
        }
    }
}
