package org.opencv.android;

import android.hardware.camera2.CameraDevice;

/* loaded from: classes2.dex */
class o extends CameraDevice.StateCallback {
    final /* synthetic */ q a;

    o(q qVar) {
        this.a = qVar;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onDisconnected(CameraDevice cameraDevice) {
        cameraDevice.close();
        this.a.E = null;
        this.a.L.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onError(CameraDevice cameraDevice, int i2) {
        cameraDevice.close();
        this.a.E = null;
        this.a.L.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onOpened(CameraDevice cameraDevice) {
        this.a.E = cameraDevice;
        this.a.L.release();
        this.a.E();
    }
}
