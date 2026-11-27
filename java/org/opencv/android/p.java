package org.opencv.android;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;

/* loaded from: classes2.dex */
class p extends CameraCaptureSession.StateCallback {
    final /* synthetic */ q a;

    p(q qVar) {
        this.a = qVar;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        Log.e("Camera2Renderer", "createCameraPreviewSession failed");
        this.a.L.release();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
        this.a.F = cameraCaptureSession;
        try {
            this.a.G.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.a.G.set(CaptureRequest.CONTROL_AE_MODE, 2);
            this.a.F.setRepeatingRequest(this.a.G.build(), null, this.a.K);
            Log.i("Camera2Renderer", "CameraPreviewSession has been started");
        } catch (CameraAccessException unused) {
            Log.e("Camera2Renderer", "createCaptureSession failed");
        }
        this.a.L.release();
    }
}
