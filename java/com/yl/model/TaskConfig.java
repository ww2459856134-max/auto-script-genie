package com.yl.model;

import com.frame.q1;

/* loaded from: classes.dex */
public class TaskConfig {
    public long hidScreenCapturePermissionTaskId;
    public boolean useAccessibilityScreenshot = false;
    public boolean captureModeConfirmed = false;
    public float scanNum = 2.0f;
    public boolean isAutoClickScanPermission = true;
    public boolean isAutoWallpaperSafe = false;
    public boolean isAutoOffscreen = true;
    public boolean isResetParamsAfterTaskFinish = false;
    public boolean isResetRepeatCountAfterTaskFinish = true;
    public long clickDuration = 100;
    public long imgDefaultTimeout = 5000;
    public long maxClickDuration = 0;
    public long longClickDuration = 1500;
    public String scanButtonText = "立即";
    public boolean isFinishAlert = true;
    public boolean isFinishSound = true;
    public boolean isShowTimeDown = true;
    public boolean isCanVolumeButton = true;
    public boolean isAutoCover = false;
    public boolean isUnlockNoView = false;
    public boolean isFinishVibrator = false;
    public boolean isShowGesturePath = true;
    public boolean isShowHandlerWithAutoRun = true;
    public boolean isReleaseScreenCapAfterStop = false;
    public boolean stopScreenCapAfterFinish = false;
    public boolean noNotificationWithTaskRun = false;
    public String alarmTaskSoundFile = "default";
    public long imgScanDelay = 50;
    public long needResetOfferTimeByBrokenRun = 60000;

    public long getClickDuration() {
        try {
            return this.maxClickDuration == 0 ? this.clickDuration : q1.m((int) this.clickDuration, (int) r0);
        } catch (Exception unused) {
            return 1L;
        }
    }
}
