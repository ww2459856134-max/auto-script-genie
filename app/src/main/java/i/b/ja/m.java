package i.b.ja;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.frame.v0;
import com.user.AccountTool;
import i.b.p8;
import i.b.q8;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class m {
    private static final m f = new m();
    private volatile com.jsj.autojs.k.c b;
    private CountDownLatch c;
    private boolean d;
    private final Object a = new Object();
    private final ServiceConnection e = new j(this);

    private m() {
    }

    private static Set<String> e(PackageInfo packageInfo) throws CertificateEncodingException {
        SigningInfo signingInfo;
        Signature[] apkContentsSigners = (Build.VERSION.SDK_INT < 28 || (signingInfo = packageInfo.signingInfo) == null) ? packageInfo.signatures : signingInfo.hasMultipleSigners() ? packageInfo.signingInfo.getApkContentsSigners() : packageInfo.signingInfo.getSigningCertificateHistory();
        HashSet hashSet = new HashSet();
        if (apkContentsSigners == null) {
            return hashSet;
        }
        for (Signature signature : apkContentsSigners) {
            try {
                hashSet.add(Arrays.toString(MessageDigest.getInstance("SHA-256").digest(signature.toByteArray())));
            } catch (Exception e) {
                throw new CertificateEncodingException(e);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this.a) {
            this.b = null;
            CountDownLatch countDownLatch = this.c;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            this.c = null;
            if (this.d) {
                try {
                    v0.g().unbindService(this.e);
                } catch (RuntimeException unused) {
                }
                this.d = false;
            }
        }
    }

    private com.jsj.autojs.k.c g() throws n {
        synchronized (this.a) {
            if (this.b != null && this.b.asBinder().isBinderAlive()) {
                com.jsj.autojs.k.c cVar = this.b;
                p(cVar);
                return cVar;
            }
            CountDownLatch countDownLatch = this.c;
            if (countDownLatch == null || countDownLatch.getCount() == 0) {
                this.c = new CountDownLatch(1);
                try {
                    boolean zBindService = v0.g().bindService(n(), this.e, 1);
                    this.d = zBindService;
                    if (!zBindService) {
                        this.c.countDown();
                    }
                } catch (RuntimeException e) {
                    throw new n(l.SERVICE_UNAVAILABLE, "无法绑定 Paddle OCR 插件", e);
                }
            }
            CountDownLatch countDownLatch2 = this.c;
            try {
                if (!countDownLatch2.await(5L, TimeUnit.SECONDS)) {
                    f();
                    throw new n(l.SERVICE_UNAVAILABLE, "连接 Paddle OCR 插件超时");
                }
                com.jsj.autojs.k.c cVar2 = this.b;
                if (cVar2 == null) {
                    throw new n(l.SERVICE_UNAVAILABLE, "Paddle OCR 插件未返回服务");
                }
                p(cVar2);
                return cVar2;
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new n(l.SERVICE_UNAVAILABLE, "连接 Paddle OCR 插件被中断", e2);
            }
        }
    }

    public static m i() {
        return f;
    }

    private static PackageInfo j(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(str, (Build.VERSION.SDK_INT >= 28 ? 134217728 : 64) | 128);
    }

    static q8 k(Bundle bundle) throws n {
        if (bundle == null) {
            throw new n(l.RECOGNITION_FAILED, "Paddle OCR 插件返回结果为空");
        }
        if (bundle.getInt("status", 3) != 0) {
            throw new n(l.RECOGNITION_FAILED, bundle.getString("message", "Paddle OCR 识别失败"));
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("texts");
        float[] floatArray = bundle.getFloatArray("confidences");
        int[] intArray = bundle.getIntArray("boxes");
        int size = stringArrayList == null ? 0 : stringArrayList.size();
        if (floatArray == null || floatArray.length != size || intArray == null || intArray.length != size * 4) {
            throw new n(l.INCOMPATIBLE, "Paddle OCR 插件返回的数据格式不兼容");
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * 4;
            arrayList.add(new p8(stringArrayList.get(i2), floatArray[i2], intArray[i3], intArray[i3 + 1], intArray[i3 + 2], intArray[i3 + 3]));
        }
        return new q8(bundle.getString("text"), arrayList);
    }

    private static String m(Throwable th) {
        String message = th.getMessage();
        return (message == null || message.trim().isEmpty()) ? th.getClass().getSimpleName() : message;
    }

    private static Intent n() {
        Intent intent = new Intent("com.jsj.autojs.paddleocr.BIND");
        intent.setComponent(new ComponentName("com.jsj.autojs.paddleocr", "com.jsj.autojs.paddleocr.PaddleOcrService"));
        return intent;
    }

    private static boolean o() {
        for (String str : Build.SUPPORTED_ABIS) {
            if ("armeabi-v7a".equals(str) || "arm64-v8a".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private com.jsj.autojs.k.c p(com.jsj.autojs.k.c cVar) throws n {
        try {
            if (cVar.a() == 1) {
                return cVar;
            }
            f();
            throw new n(l.INCOMPATIBLE, "Paddle OCR 插件 API 版本不兼容");
        } catch (RemoteException e) {
            f();
            throw new n(l.SERVICE_UNAVAILABLE, "Paddle OCR 插件版本检查失败", e);
        }
    }

    public k h() {
        if (!AccountTool.d().l()) {
            return new k(l.NOT_SUPER_VIP, "Paddle OCR 插件仅向 SVIP 用户提供");
        }
        if (!o()) {
            return new k(l.UNSUPPORTED_ABI, "Paddle OCR 插件仅支持 ARM32/ARM64 设备");
        }
        v0 v0VarG = v0.g();
        PackageManager packageManager = v0VarG.getPackageManager();
        try {
            PackageInfo packageInfoJ = j(packageManager, "com.jsj.autojs.paddleocr");
            ApplicationInfo applicationInfo = packageInfoJ.applicationInfo;
            if (applicationInfo != null && applicationInfo.enabled) {
                Bundle bundle = applicationInfo.metaData;
                int i2 = 0;
                if (bundle != null) {
                    i2 = bundle.getInt("paddleOcrApiVersion", 0);
                }
                if (i2 != 1) {
                    return new k(l.INCOMPATIBLE, "Paddle OCR 插件版本与当前应用不兼容");
                }
                PackageInfo packageInfoJ2 = j(packageManager, v0VarG.getPackageName());
                Set<String> setE = e(packageInfoJ);
                Set<String> setE2 = e(packageInfoJ2);
                if (!setE.isEmpty() && setE.equals(setE2)) {
                    ResolveInfo resolveInfoResolveService = packageManager.resolveService(n(), 512);
                    ServiceInfo serviceInfo = resolveInfoResolveService == null ? null : resolveInfoResolveService.serviceInfo;
                    if (serviceInfo != null && "com.jsj.autojs.paddleocr.permission.BIND_OCR".equals(serviceInfo.permission)) {
                        return new k(l.AVAILABLE, "Paddle OCR 插件可用");
                    }
                    return new k(l.INCOMPATIBLE, "Paddle OCR 插件服务配置不兼容");
                }
                return new k(l.SIGNATURE_MISMATCH, "Paddle OCR 插件签名校验失败");
            }
            return new k(l.DISABLED, "Paddle OCR 插件已被停用");
        } catch (PackageManager.NameNotFoundException unused) {
            return new k(l.NOT_INSTALLED, "未安装 Paddle OCR 插件");
        } catch (Exception e) {
            return new k(l.INCOMPATIBLE, "Paddle OCR 插件检查失败：" + m(e));
        }
    }

    public q8 l(Bitmap bitmap, String str) throws n {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new n(l.RECOGNITION_FAILED, "Paddle OCR 不能在主线程执行");
        }
        k kVarH = h();
        if (!kVarH.e()) {
            throw new n(kVarH.a, kVarH.b);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            throw new n(l.RECOGNITION_FAILED, "OCR 图片为空");
        }
        File file = null;
        try {
            try {
                try {
                    File file2 = new File(v0.g().getCacheDir(), "paddle-ocr-ipc");
                    if (!file2.isDirectory() && !file2.mkdirs()) {
                        throw new IOException("无法创建 OCR 临时目录");
                    }
                    File fileCreateTempFile = File.createTempFile("ocr-", ".png", file2);
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                            throw new IOException("OCR 图片写入失败");
                        }
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                        for (int i2 = 0; i2 < 2; i2++) {
                            try {
                                ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                                try {
                                    q8 q8VarK = k(g().f(parcelFileDescriptorOpen, str));
                                    if (parcelFileDescriptorOpen != null) {
                                        parcelFileDescriptorOpen.close();
                                    }
                                    if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                                        fileCreateTempFile.delete();
                                    }
                                    return q8VarK;
                                } catch (Throwable th) {
                                    if (parcelFileDescriptorOpen != null) {
                                        try {
                                            parcelFileDescriptorOpen.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (RemoteException e) {
                                f();
                                if (i2 == 1) {
                                    throw new n(l.SERVICE_UNAVAILABLE, "Paddle OCR 插件连接已中断", e);
                                }
                            } catch (n e2) {
                                if (e2.a() != l.SERVICE_UNAVAILABLE || i2 == 1) {
                                    throw e2;
                                }
                                f();
                            }
                        }
                        throw new n(l.SERVICE_UNAVAILABLE, "Paddle OCR 插件连接失败");
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (n e3) {
                    throw e3;
                }
            } catch (Exception e4) {
                throw new n(l.RECOGNITION_FAILED, "Paddle OCR 识别失败：" + m(e4), e4);
            }
        } catch (Throwable th5) {
            if (0 != 0 && file.exists()) {
                file.delete();
            }
            throw th5;
        }
    }
}
