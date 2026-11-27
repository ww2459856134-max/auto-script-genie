package wallpaper;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.service.wallpaper.WallpaperService;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Toast;
import com.frame.j1;
import com.frame.k0;
import com.frame.l0;
import com.frame.l1;
import com.frame.p1;
import com.frame.v0;
import com.frame.y0;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public class WallpaperSetting extends WallpaperService {
    public static WallpaperSetting C;

    /* renamed from: i, reason: collision with root package name */
    private static String f2588i;

    /* renamed from: j, reason: collision with root package name */
    private static Runnable f2589j;

    /* renamed from: k, reason: collision with root package name */
    private static Runnable f2590k;
    private static Runnable t;
    private boolean c = false;
    private Bitmap d;
    private a e;
    private static final int f = Color.rgb(220, 238, 255);
    public static final Object g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static boolean f2587h = false;
    public static final String A = v0.g().getFilesDir().getAbsolutePath();

    class a extends WallpaperService.Engine {
        a(WallpaperSetting wallpaperSetting) {
            super(wallpaperSetting);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            try {
                if (isPreview()) {
                    if (WallpaperSetting.t != null) {
                        WallpaperSetting.t.run();
                    }
                } else if (WallpaperSetting.f2589j != null) {
                    WallpaperSetting.f2589j.run();
                }
            } catch (Exception e) {
                k0.r(e);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onDestroy() {
            if (WallpaperSetting.f2590k != null && isPreview()) {
                WallpaperSetting.f2590k.run();
                Runnable unused = WallpaperSetting.t = null;
            }
            try {
                super.onDestroy();
            } catch (Exception e) {
                k0.r(e);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
            if (!isPreview()) {
                WallpaperSetting.f2587h = true;
            }
            super.onSurfaceCreated(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (!isPreview()) {
                WallpaperSetting.f2587h = false;
            }
            super.onSurfaceDestroyed(surfaceHolder);
        }
    }

    class b extends a {
        private BroadcastReceiver a;
        private SurfaceHolder b;
        private int c;
        private int d;

        b() {
            super(WallpaperSetting.this);
            this.a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(SurfaceHolder surfaceHolder) {
            Canvas canvasLockCanvas;
            int iWidth;
            int iHeight;
            synchronized (WallpaperSetting.g) {
                Bitmap bitmap = WallpaperSetting.this.d;
                if (bitmap == null || bitmap.isRecycled() || surfaceHolder == null || surfaceHolder.getSurface() == null || !surfaceHolder.getSurface().isValid()) {
                    return;
                }
                Canvas canvas = null;
                try {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            try {
                                canvasLockCanvas = surfaceHolder.lockHardwareCanvas();
                            } catch (Exception unused) {
                                canvasLockCanvas = surfaceHolder.lockCanvas();
                            }
                        } else {
                            canvasLockCanvas = surfaceHolder.lockCanvas();
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                }
                if (canvasLockCanvas == null) {
                    if (canvasLockCanvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                        } catch (Exception e2) {
                            k0.r(e2);
                        }
                    }
                    return;
                }
                try {
                    Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                    iWidth = surfaceFrame.width();
                    iHeight = surfaceFrame.height();
                } catch (Exception e3) {
                    e = e3;
                    canvas = canvasLockCanvas;
                    k0.r(e);
                    if (canvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e4) {
                            e = e4;
                            k0.r(e);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    canvas = canvasLockCanvas;
                    if (canvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        } catch (Exception e5) {
                            k0.r(e5);
                        }
                    }
                    throw th;
                }
                if (iWidth > 0 && iHeight > 0) {
                    float width = bitmap.getWidth();
                    float height = bitmap.getHeight();
                    float f = iWidth;
                    float f2 = iHeight;
                    float fMax = Math.max(f / width, f2 / height);
                    float fMax2 = Math.max(f, width * fMax);
                    float fMax3 = Math.max(f2, height * fMax);
                    float f3 = (-Math.max(0.0f, fMax2 - f)) / 2.0f;
                    float f4 = f3 + fMax2;
                    canvasLockCanvas.drawBitmap(bitmap, (Rect) null, new RectF(f3, 0.0f, f4, fMax3), (Paint) null);
                    if (isPreview()) {
                        b(canvasLockCanvas, f3, fMax3 - p1.c(130.0f), f4, fMax3);
                    }
                    if (canvasLockCanvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                        } catch (Exception e6) {
                            e = e6;
                            k0.r(e);
                            return;
                        }
                    }
                    return;
                }
                if (canvasLockCanvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvasLockCanvas);
                    } catch (Exception e7) {
                        k0.r(e7);
                    }
                }
                return;
            }
        }

        private void b(Canvas canvas, float f, float f2, float f3, float f4) {
            RectF rectF = new RectF(f, f2, f3, f4);
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, f2, 0.0f, f4, new int[]{0, Color.parseColor("#aa000000")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            canvas.drawRect(rectF, paint);
        }

        private Bitmap c(WallpaperManager wallpaperManager) {
            Drawable drawable;
            try {
                drawable = wallpaperManager.getDrawable();
            } catch (Exception e) {
                k0.r(e);
                drawable = null;
            }
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = this.c;
            int intrinsicHeight = this.d;
            if (drawable != null) {
                if (intrinsicWidth <= 0) {
                    intrinsicWidth = drawable.getIntrinsicWidth();
                }
                if (intrinsicHeight <= 0) {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                }
            }
            int iMax = Math.max(1, intrinsicWidth);
            int iMax2 = Math.max(1, intrinsicHeight);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(-3355444);
            if (drawable != null) {
                drawable.setBounds(0, 0, iMax, iMax2);
                drawable.draw(canvas);
            }
            return bitmapCreateBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e() {
            try {
                v0.g().unregisterReceiver(this.a);
            } catch (Exception e) {
                k0.r(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j(SurfaceHolder surfaceHolder) {
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(v0.g());
                if (isPreview()) {
                    boolean z = !TextUtils.isEmpty(WallpaperSetting.f2588i) && new File(WallpaperSetting.f2588i).isFile();
                    if (v0.f().getBoolean("lockWallpaper", false) && z) {
                        WallpaperSetting.this.d = j1.c().a(WallpaperSetting.f2588i);
                    } else {
                        q(wallpaperManager);
                    }
                } else {
                    try {
                        if (WallpaperSetting.this.d == null || WallpaperSetting.this.d.isRecycled()) {
                            WallpaperSetting.this.d = j1.c().a(WallpaperSetting.f2588i);
                        }
                    } catch (Exception e) {
                        k0.r(e);
                    }
                }
                if (WallpaperSetting.f2588i == null) {
                    y0.o("WallpaperSetting----mDirPath=null");
                }
                if (WallpaperSetting.this.d == null) {
                    WallpaperSetting.this.d = c(wallpaperManager);
                    l1.e(new Runnable() { // from class: wallpaper.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            Toast.makeText(v0.g(), "壁纸图片已失效，已使用系统壁纸", 0).show();
                        }
                    });
                }
                f(surfaceHolder);
            } catch (Exception e2) {
                k0.r(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void l() {
            f(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void n(String str, Bitmap bitmap) {
            try {
                l0.d(bitmap, new File(str));
                WallpaperSetting.this.c = true;
                v0.f().edit().putString("default_wallpaper", str).apply();
                j1.c().d(bitmap, str);
            } catch (Exception e) {
                k0.r(e);
            }
        }

        public void o() {
            SurfaceHolder surfaceHolder = this.b;
            if (surfaceHolder != null) {
                f(surfaceHolder);
            }
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onDestroy() {
            try {
                super.onDestroy();
            } catch (Exception e) {
                k0.r(e);
            }
            try {
                if (this.a == null || isPreview()) {
                    return;
                }
                l1.g(new Runnable() { // from class: wallpaper.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.e();
                    }
                });
            } catch (Exception e2) {
                k0.r(e2);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceChanged(final SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            super.onSurfaceChanged(surfaceHolder, i2, i3, i4);
            this.c = i3;
            this.d = i4;
            if (!isVisible() || WallpaperSetting.this.d == null) {
                return;
            }
            l1.g(new Runnable() { // from class: wallpaper.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.g(surfaceHolder);
                }
            });
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(final SurfaceHolder surfaceHolder) {
            super.onSurfaceCreated(surfaceHolder);
            this.b = surfaceHolder;
            this.c = 0;
            this.d = 0;
            l1.g(new Runnable() { // from class: wallpaper.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.j(surfaceHolder);
                }
            });
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (this.b == surfaceHolder) {
                this.b = null;
                this.c = 0;
                this.d = 0;
            }
            super.onSurfaceDestroyed(surfaceHolder);
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
            super.onSurfaceRedrawNeeded(surfaceHolder);
            if (WallpaperSetting.this.d != null) {
                f(surfaceHolder);
            }
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z) {
            super.onVisibilityChanged(z);
            if (!z || this.b == null || WallpaperSetting.this.d == null) {
                return;
            }
            l1.g(new Runnable() { // from class: wallpaper.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.l();
                }
            });
        }

        public void p(final Bitmap bitmap, final String str) {
            if (WallpaperSetting.this.c) {
                return;
            }
            new Thread(new Runnable() { // from class: wallpaper.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n(str, bitmap);
                }
            }).start();
        }

        public void q(WallpaperManager wallpaperManager) {
            WallpaperSetting.this.d = c(wallpaperManager);
            String unused = WallpaperSetting.f2588i = WallpaperSetting.A + File.separator + UUID.randomUUID().toString() + ".jpg";
            p(WallpaperSetting.this.d, WallpaperSetting.f2588i);
        }
    }

    class c extends a {
        private MediaPlayer a;

        c(WallpaperSetting wallpaperSetting) {
            super(wallpaperSetting);
        }

        private void a() {
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            if (isPreview()) {
                return;
            }
            a();
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onDestroy() {
            try {
                super.onDestroy();
            } catch (Exception e) {
                k0.r(e);
            }
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceCreated(SurfaceHolder surfaceHolder) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            super.onSurfaceCreated(surfaceHolder);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            if (Build.VERSION.SDK_INT >= 14) {
                mediaPlayer.setSurface(surfaceHolder.getSurface());
            }
            try {
                String str = WallpaperSetting.f2588i;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strReplace = str.replace("$$video", "");
                Log.e(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "onSurfaceCreated: " + strReplace);
                this.a.setDataSource(strReplace);
                this.a.setLooping(true);
                this.a.setVolume(0.0f, 0.0f);
                this.a.prepare();
                this.a.start();
            } catch (IOException e) {
                k0.r(e);
            }
        }

        @Override // wallpaper.WallpaperSetting.a, android.service.wallpaper.WallpaperService.Engine
        public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) {
            super.onSurfaceDestroyed(surfaceHolder);
            this.a.release();
            this.a = null;
        }

        @Override // android.service.wallpaper.WallpaperService.Engine
        public void onVisibilityChanged(boolean z) throws IllegalStateException {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null) {
                super.onVisibilityChanged(z);
            } else if (z) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        }
    }

    public static void A() {
        a aVar;
        WallpaperSetting wallpaperSetting = C;
        if (wallpaperSetting == null || (aVar = wallpaperSetting.e) == null) {
            return;
        }
        if (aVar instanceof b) {
            l1.g(new Runnable() { // from class: wallpaper.h
                @Override // java.lang.Runnable
                public final void run() {
                    WallpaperSetting.t();
                }
            });
        } else {
            boolean z = aVar instanceof c;
        }
    }

    public static boolean B(String str) {
        if (r(str)) {
            f2588i = str;
            v0.f().edit().putString("default_wallpaper", str).apply();
            u();
            return true;
        }
        y0.o("WallpaperSetting invalid picture: " + str);
        return false;
    }

    public static boolean k() {
        try {
            if (f2588i == null) {
                f2588i = o();
            }
            v0.f().edit().remove("lockWallpaper").remove("default_wallpaper").apply();
            File file = new File(f2588i);
            f2588i = null;
            z();
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            k0.r(e);
            return false;
        }
    }

    public static String l() {
        File file = new File(A, "default_wallpaper_light_blue.png");
        if (r(file.getAbsolutePath())) {
            return file.getAbsolutePath();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.RGB_565);
        bitmapCreateBitmap.eraseColor(f);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                if (!bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    throw new IOException("failed to create default blue wallpaper");
                }
                String absolutePath = file.getAbsolutePath();
                fileOutputStream.close();
                return absolutePath;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            k0.r(e);
            return null;
        } finally {
            bitmapCreateBitmap.recycle();
        }
    }

    private static Class m() throws PackageManager.NameNotFoundException, ClassNotFoundException {
        return Class.forName(n(v0.g().getPackageName()));
    }

    private static String n(String str) throws PackageManager.NameNotFoundException {
        ResolveInfo resolveInfo;
        v0 v0VarG = v0.g();
        PackageInfo packageInfo = v0VarG.getPackageManager().getPackageInfo(str, 0);
        Intent intent = new Intent("android.service.wallpaper.WallpaperService", (Uri) null);
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentServices = v0VarG.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (resolveInfo = listQueryIntentServices.get(0)) == null) {
            return null;
        }
        return resolveInfo.serviceInfo.name;
    }

    public static String o() {
        return v0.f().getString("default_wallpaper", A + "/desktopDir/desktopBg.png");
    }

    public static boolean p(String str) {
        return !TextUtils.isEmpty(str) && str.equals(new File(A, "default_wallpaper_light_blue.png").getAbsolutePath());
    }

    public static boolean q() {
        return f2587h;
    }

    private static boolean r(String str) {
        if (TextUtils.isEmpty(str) || str.contains("$$video")) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile() || file.length() == 0) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth > 0 && options.outHeight > 0;
    }

    static /* synthetic */ void s() {
        try {
            Bitmap bitmapA = j1.c().a(f2588i);
            if (bitmapA != null) {
                C.d = bitmapA;
            }
            ((b) C.e).o();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    static /* synthetic */ void t() {
        try {
            ((b) C.e).q(WallpaperManager.getInstance(v0.g()));
            ((b) C.e).o();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public static void u() {
        v0.f().edit().putBoolean("lockWallpaper", true).apply();
        z();
    }

    public static void v(Runnable runnable) {
        f2590k = runnable;
    }

    public static void w(Runnable runnable) {
        t = runnable;
    }

    public static void x(Runnable runnable) {
        f2589j = runnable;
    }

    public static void y(String str) throws IOException {
        if (!str.contains("$$video")) {
            str = str + "$$video";
        }
        f2588i = str;
        v0.f().edit().putString("default_wallpaper", str).apply();
        z();
    }

    @SuppressLint({"MissingPermission"})
    public static void z() throws IOException {
        WallpaperSetting wallpaperSetting;
        a aVar;
        x(null);
        v(null);
        w(null);
        boolean z = !TextUtils.isEmpty(f2588i) && f2588i.contains("$$video");
        if (q() && (wallpaperSetting = C) != null && (aVar = wallpaperSetting.e) != null) {
            if (aVar instanceof b) {
                if (!z) {
                    l1.g(new Runnable() { // from class: wallpaper.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            WallpaperSetting.s();
                        }
                    });
                    return;
                } else {
                    try {
                        WallpaperManager.getInstance(v0.g()).clear();
                    } catch (Exception e) {
                        k0.r(e);
                    }
                }
            } else if (aVar instanceof c) {
                if (z) {
                    try {
                        WallpaperManager.getInstance(v0.g()).clear();
                    } catch (Exception e2) {
                        k0.r(e2);
                    }
                } else {
                    try {
                        WallpaperManager.getInstance(v0.g()).clear();
                    } catch (Exception e3) {
                        k0.r(e3);
                    }
                }
            }
        }
        try {
            Log.e("WallpaperSettingting", "setWallpaper: ");
            Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(v0.g(), (Class<?>) m()));
            v0.g().t(intent, 10011);
        } catch (Exception e4) {
            k0.r(e4);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f2588i = o();
        C = this;
    }

    @Override // android.service.wallpaper.WallpaperService
    public WallpaperService.Engine onCreateEngine() {
        String str = f2588i;
        if (str == null || !str.contains("$$video")) {
            this.e = new b();
        } else {
            this.e = new c(this);
        }
        return this.e;
    }

    @Override // android.service.wallpaper.WallpaperService, android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e) {
            k0.r(e);
        }
        f2587h = false;
        C = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
