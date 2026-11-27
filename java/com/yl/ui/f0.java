package com.yl.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.frame.k0;
import com.frame.p1;
import com.frame.v0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class f0 extends Dialog {
    private static View c;

    public static class a implements View.OnClickListener {
        private Context c;
        private DialogInterface.OnCancelListener f;
        private b g;

        /* renamed from: h, reason: collision with root package name */
        private Bitmap f1143h;

        /* renamed from: j, reason: collision with root package name */
        private f0 f1145j;
        private boolean d = true;
        private boolean e = true;

        /* renamed from: i, reason: collision with root package name */
        private int f1144i = 1;

        public a(Context context) {
            this.c = context;
        }

        private void d() throws IOException {
            Bitmap bitmap = this.f1143h;
            if (bitmap == null || bitmap.isRecycled()) {
                Toast.makeText(this.c, "分享图片生成失败，请稍后重试", 0).show();
                return;
            }
            File file = new File(this.c.getCacheDir(), "share_images");
            if (!file.exists() && !file.mkdirs()) {
                Toast.makeText(this.c, "分享图片生成失败，请稍后重试", 0).show();
                return;
            }
            File file2 = new File(file, "share_" + System.currentTimeMillis() + ".png");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    if (!this.f1143h.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                        throw new IllegalStateException("Bitmap compress failed");
                    }
                    fileOutputStream.close();
                    try {
                        Uri uriE = FileProvider.e(this.c, this.c.getPackageName() + ".share_file_provider", file2);
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("image/png");
                        intent.putExtra("android.intent.extra.STREAM", uriE);
                        intent.addFlags(1);
                        if (Build.VERSION.SDK_INT >= 16) {
                            intent.setClipData(ClipData.newRawUri("share_image", uriE));
                        }
                        Intent intentCreateChooser = Intent.createChooser(intent, "分享图片");
                        if (!(this.c instanceof Activity)) {
                            intentCreateChooser.addFlags(268435456);
                        }
                        this.c.startActivity(intentCreateChooser);
                    } catch (Exception e) {
                        k0.r(e);
                        Toast.makeText(this.c, "未找到可分享图片的应用", 0).show();
                    }
                } finally {
                }
            } catch (Exception e2) {
                k0.r(e2);
                Toast.makeText(this.c, "分享图片生成失败，请稍后重试", 0).show();
            }
        }

        public f0 a() throws Resources.NotFoundException {
            try {
                this.f1145j = new f0(this.c, d0.b);
                View unused = f0.c = View.inflate(this.c.getApplicationContext(), b0.f1140j, null);
                TextView textView = (TextView) f0.c.findViewById(a0.y);
                TextView textView2 = (TextView) f0.c.findViewById(a0.x);
                TextView textView3 = (TextView) f0.c.findViewById(a0.u);
                TextView textView4 = (TextView) f0.c.findViewById(a0.v);
                TextView textView5 = (TextView) f0.c.findViewById(a0.w);
                View viewFindViewById = f0.c.findViewById(a0.t);
                ImageView imageView = (ImageView) f0.c.findViewById(a0.p);
                Bitmap bitmap = this.f1143h;
                if (bitmap != null && !bitmap.isRecycled()) {
                    imageView.setImageBitmap(this.f1143h);
                }
                Bitmap bitmap2 = this.f1143h;
                int i2 = 0;
                boolean z = this.f1144i == 1 && (bitmap2 != null && !bitmap2.isRecycled());
                textView5.setVisibility(z ? 0 : 8);
                viewFindViewById.setVisibility(z ? 8 : 0);
                textView3.setVisibility(this.d ? 0 : 8);
                textView4.setVisibility(this.d ? 0 : 8);
                textView.setVisibility(this.e ? 0 : 8);
                if (!this.e) {
                    i2 = 8;
                }
                textView2.setVisibility(i2);
                View view = f0.c;
                v0 v0VarG = v0.g();
                int i3 = x.a;
                view.startAnimation(AnimationUtils.loadAnimation(v0VarG, i3));
                if (z) {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(v0.g(), i3);
                    animationLoadAnimation.setStartOffset(80L);
                    textView5.startAnimation(animationLoadAnimation);
                } else {
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(v0.g(), i3);
                    animationLoadAnimation2.setStartOffset(80L);
                    textView.startAnimation(animationLoadAnimation2);
                    Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(v0.g(), i3);
                    animationLoadAnimation3.setStartOffset(160L);
                    textView2.startAnimation(animationLoadAnimation3);
                    Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(v0.g(), i3);
                    animationLoadAnimation4.setStartOffset(240L);
                    textView3.startAnimation(animationLoadAnimation4);
                    Animation animationLoadAnimation5 = AnimationUtils.loadAnimation(v0.g(), i3);
                    animationLoadAnimation5.setStartOffset(320L);
                    textView4.startAnimation(animationLoadAnimation5);
                }
                b(textView);
                b(textView2);
                b(textView3);
                b(textView4);
                textView.setOnClickListener(this);
                textView2.setOnClickListener(this);
                textView3.setOnClickListener(this);
                textView4.setOnClickListener(this);
                textView5.setOnClickListener(this);
                this.f1145j.addContentView(f0.c, new ViewGroup.LayoutParams(-1, -2));
                this.f1145j.setCanceledOnTouchOutside(true);
                if (this.f != null) {
                    this.f1145j.setCancelable(true);
                    this.f1145j.setOnCancelListener(this.f);
                }
                return this.f1145j;
            } catch (Exception e) {
                k0.r(e);
                return null;
            }
        }

        public void b(TextView textView) {
            Drawable drawable = textView.getCompoundDrawables()[1];
            drawable.setBounds(0, 0, p1.c(50.0f), p1.c(50.0f));
            textView.setCompoundDrawables(null, drawable, null, null);
        }

        public a c(b bVar) {
            this.g = bVar;
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (view.getId() == a0.w) {
                    d();
                    this.f1145j.dismiss();
                    return;
                }
                if (this.g == null) {
                    this.f1145j.dismiss();
                    return;
                }
                if (view.getId() == a0.y) {
                    this.g.c(this.f1145j);
                } else if (view.getId() == a0.x) {
                    this.g.d(this.f1145j);
                } else if (view.getId() == a0.u) {
                    this.g.b(this.f1145j);
                } else if (view.getId() == a0.v) {
                    this.g.a(this.f1145j);
                }
                this.f1145j.dismiss();
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public interface b {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public f0(Context context, int i2) {
        super(context, i2);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            try {
                window.getDecorView().setBackgroundColor(0);
            } catch (Exception e) {
                k0.r(e);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            attributes.width = -1;
            attributes.height = -2;
            window.setGravity(80);
            window.addFlags(2);
            window.setAttributes(attributes);
        } catch (Exception e2) {
            k0.r(e2);
        }
    }
}
