package com.v;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;

/* loaded from: classes.dex */
public class ImagePreviewView extends RelativeLayout {
    public ImagePreviewView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.B, this);
        findViewById(j.b.e.r1).setOnClickListener(new View.OnClickListener() { // from class: com.v.ha
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(ImagePreviewView.class);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039 A[Catch: Exception -> 0x0051, TRY_LEAVE, TryCatch #0 {Exception -> 0x0051, blocks: (B:4:0x0012, B:6:0x001a, B:9:0x002a, B:10:0x0039), top: B:16:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPath(String str) {
        TextView textView = (TextView) findViewById(j.b.e.r5);
        ImageView imageView = (ImageView) findViewById(j.b.e.D3);
        if (str != null) {
            try {
                if (str.contains("://")) {
                    Uri uri = Uri.parse(str);
                    String strT = com.frame.r0.t(com.frame.v0.g(), uri);
                    if (strT == null) {
                        strT = "图片预览";
                    }
                    textView.setText(strT);
                    com.bumptech.glide.c.u(this).t(uri).q0(imageView);
                } else {
                    File file = new File(str);
                    textView.setText(file.getName());
                    com.bumptech.glide.c.u(this).u(file).q0(imageView);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                FloatToast.i("图片加载失败");
                com.frame.s0.g().d(ImagePreviewView.class);
            }
        }
    }
}
