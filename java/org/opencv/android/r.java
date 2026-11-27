package org.opencv.android;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.android.CameraGLSurfaceView;

@TargetApi(15)
/* loaded from: classes2.dex */
public abstract class r implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    protected CameraGLSurfaceView D;
    private final float[] a;
    private final float[] b;
    private final float[] c;

    /* renamed from: j, reason: collision with root package name */
    private int f2579j;

    /* renamed from: k, reason: collision with root package name */
    private int f2580k;

    /* renamed from: l, reason: collision with root package name */
    private int f2581l;

    /* renamed from: m, reason: collision with root package name */
    private int f2582m;

    /* renamed from: n, reason: collision with root package name */
    private FloatBuffer f2583n;

    /* renamed from: o, reason: collision with root package name */
    private FloatBuffer f2584o;
    private FloatBuffer p;
    protected SurfaceTexture x;
    private int[] d = {0};
    private int[] e = {0};
    private int[] f = {0};
    private int[] g = {0};

    /* renamed from: h, reason: collision with root package name */
    private int f2577h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f2578i = -1;
    protected int q = -1;
    protected int r = -1;
    protected int s = -1;
    protected int t = -1;
    protected int u = -1;
    protected int v = -1;
    protected int w = -1;
    protected boolean y = false;
    protected boolean z = false;
    protected boolean A = false;
    protected boolean B = true;
    protected boolean C = false;

    public r(CameraGLSurfaceView cameraGLSurfaceView) {
        float[] fArr = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.a = fArr;
        float[] fArr2 = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        this.b = fArr2;
        float[] fArr3 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.c = fArr3;
        this.D = cameraGLSurfaceView;
        int length = (fArr.length * 32) / 8;
        this.f2583n = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2584o = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.p = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2583n.put(fArr).position(0);
        this.f2584o.put(fArr2).position(0);
        this.p.put(fArr3).position(0);
    }

    private void b() {
        Log.d("CameraGLRendererBase", "deleteFBO(" + this.s + "x" + this.t + ")");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, this.g, 0);
        d(this.e);
        d(this.f);
        this.t = 0;
        this.s = 0;
    }

    private void c() {
        Log.d("CameraGLRendererBase", "deleteSurfaceTexture");
        SurfaceTexture surfaceTexture = this.x;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.x = null;
            d(this.d);
        }
    }

    private static void d(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    private void h(int i2, boolean z, int i3) {
        GLES20.glBindFramebuffer(36160, i3);
        if (i3 == 0) {
            GLES20.glViewport(0, 0, this.D.getWidth(), this.D.getHeight());
        } else {
            GLES20.glViewport(0, 0, this.s, this.t);
        }
        GLES20.glClear(16384);
        if (z) {
            GLES20.glUseProgram(this.f2577h);
            GLES20.glVertexAttribPointer(this.f2579j, 2, 5126, false, 8, (Buffer) this.f2583n);
            GLES20.glVertexAttribPointer(this.f2580k, 2, 5126, false, 8, (Buffer) this.f2584o);
        } else {
            GLES20.glUseProgram(this.f2578i);
            GLES20.glVertexAttribPointer(this.f2581l, 2, 5126, false, 8, (Buffer) this.f2583n);
            GLES20.glVertexAttribPointer(this.f2582m, 2, 5126, false, 8, (Buffer) this.p);
        }
        GLES20.glActiveTexture(33984);
        if (z) {
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f2577h, "sTexture"), 0);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f2578i, "sTexture"), 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    private void j(int i2, int i3) {
        Log.d("CameraGLRendererBase", "initFBO(" + i2 + "x" + i3 + ")");
        b();
        GLES20.glGenTextures(1, this.f, 0);
        GLES20.glBindTexture(3553, this.f[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenTextures(1, this.e, 0);
        GLES20.glBindTexture(3553, this.e[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenFramebuffers(1, this.g, 0);
        GLES20.glBindFramebuffer(36160, this.g[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.e[0], 0);
        Log.d("CameraGLRendererBase", "initFBO error status: " + GLES20.glGetError());
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus != 36053) {
            Log.e("CameraGLRendererBase", "initFBO failed, status: " + iGlCheckFramebufferStatus);
        }
        this.s = i2;
        this.t = i3;
    }

    private void k() {
        String strGlGetString = GLES20.glGetString(7938);
        if (strGlGetString != null) {
            Log.i("CameraGLRendererBase", "OpenGL ES version: " + strGlGetString);
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        int iN = n("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.f2577h = iN;
        this.f2579j = GLES20.glGetAttribLocation(iN, "vPosition");
        this.f2580k = GLES20.glGetAttribLocation(this.f2577h, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.f2579j);
        GLES20.glEnableVertexAttribArray(this.f2580k);
        int iN2 = n("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.f2578i = iN2;
        this.f2581l = GLES20.glGetAttribLocation(iN2, "vPosition");
        this.f2582m = GLES20.glGetAttribLocation(this.f2578i, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.f2581l);
        GLES20.glEnableVertexAttribArray(this.f2582m);
    }

    private void l() {
        Log.d("CameraGLRendererBase", "initSurfaceTexture");
        c();
        m(this.d);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.d[0]);
        this.x = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    private void m(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
        }
    }

    private static int n(String str, String str2) {
        Log.d("CameraGLRendererBase", "loadShader");
        int iGlCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile vertex shader: " + GLES20.glGetShaderInfoLog(iGlCreateShader));
            GLES20.glDeleteShader(iGlCreateShader);
            return 0;
        }
        int iGlCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(iGlCreateShader2, str2);
        GLES20.glCompileShader(iGlCreateShader2);
        GLES20.glGetShaderiv(iGlCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile fragment shader:" + GLES20.glGetShaderInfoLog(iGlCreateShader2));
            GLES20.glDeleteShader(iGlCreateShader);
            GLES20.glDeleteShader(iGlCreateShader2);
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader);
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader2);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glDeleteShader(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader2);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not link shader program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
            return 0;
        }
        GLES20.glValidateProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35715, iArr, 0);
        if (iArr[0] != 0) {
            Log.d("CameraGLRendererBase", "Shader program is built OK");
            return iGlCreateProgram;
        }
        Log.e("CameraGLRendererBase", "Shader program validation error: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    protected abstract void a();

    public synchronized void e() {
        Log.d("CameraGLRendererBase", "disableView");
        this.B = false;
        v();
    }

    protected synchronized void f() {
        int i2;
        Log.d("CameraGLRendererBase", "doStart");
        l();
        q(this.w);
        this.C = true;
        int i3 = this.q;
        if (i3 > 0 && (i2 = this.r) > 0) {
            u(i3, i2);
        }
    }

    protected void g() {
        Log.d("CameraGLRendererBase", "doStop");
        synchronized (this) {
            this.A = false;
            this.C = false;
            this.z = false;
            a();
            c();
        }
        CameraGLSurfaceView.a cameraTextureListener = this.D.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.b();
        }
    }

    public synchronized void i() {
        Log.d("CameraGLRendererBase", "enableView");
        this.B = true;
        v();
    }

    public void o() {
        Log.i("CameraGLRendererBase", "onPause");
        this.y = false;
        v();
        this.r = -1;
        this.q = -1;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.z) {
            synchronized (this) {
                if (this.A) {
                    this.x.updateTexImage();
                    this.A = false;
                }
                GLES20.glClear(16384);
                CameraGLSurfaceView.a cameraTextureListener = this.D.getCameraTextureListener();
                if (cameraTextureListener != null) {
                    h(this.d[0], true, this.g[0]);
                    if (cameraTextureListener.c(this.e[0], this.f[0], this.q, this.r)) {
                        h(this.f[0], false, 0);
                    } else {
                        h(this.e[0], false, 0);
                    }
                } else {
                    Log.d("CameraGLRendererBase", "texCamera(OES) -> screen");
                    h(this.d[0], true, 0);
                }
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.A = true;
        this.D.requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Log.i("CameraGLRendererBase", "onSurfaceChanged(" + i2 + "x" + i3 + ")");
        this.y = true;
        v();
        u(i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("CameraGLRendererBase", "onSurfaceCreated");
        k();
    }

    public void p() {
        Log.i("CameraGLRendererBase", "onResume");
    }

    protected abstract void q(int i2);

    public void r(int i2) {
        e();
        this.w = i2;
        i();
    }

    protected abstract void s(int i2, int i3);

    public void t(int i2, int i3) {
        e();
        this.u = i2;
        this.v = i3;
        i();
    }

    protected void u(int i2, int i3) {
        synchronized (this) {
            this.z = false;
            this.q = i2;
            this.r = i3;
            s(i2, i3);
            j(this.q, this.r);
            this.z = true;
        }
        CameraGLSurfaceView.a cameraTextureListener = this.D.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.a(this.q, this.r);
        }
    }

    protected void v() {
        Log.d("CameraGLRendererBase", "updateState");
        Log.d("CameraGLRendererBase", "mEnabled=" + this.B + ", mHaveSurface=" + this.y);
        boolean z = this.B && this.y && this.D.getVisibility() == 0;
        if (z == this.C) {
            Log.d("CameraGLRendererBase", "keeping State unchanged");
        } else if (z) {
            f();
        } else {
            g();
        }
        Log.d("CameraGLRendererBase", "updateState end");
    }
}
