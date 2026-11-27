package com.bumptech.glide.load.z.f;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.u<Bitmap> {
    public static final com.bumptech.glide.load.q<Integer> b = com.bumptech.glide.load.q.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.bumptech.glide.load.q<Bitmap.CompressFormat> c = com.bumptech.glide.load.q.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final com.bumptech.glide.load.x.g1.b a;

    public c(com.bumptech.glide.load.x.g1.b bVar) {
        this.a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, com.bumptech.glide.load.r rVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) rVar.c(c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.u
    public com.bumptech.glide.load.c b(com.bumptech.glide.load.r rVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:46|3|4|(2:44|5)|(5:50|6|(2:8|9)(1:10)|11|12)|42|13|28|29|(1:31)|32|33) */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #2 {all -> 0x00c0, blocks: (B:3:0x0021, B:13:0x004d, B:29:0x006a, B:31:0x0070, B:35:0x00bc, B:36:0x00bf), top: B:46:0x0021 }] */
    @Override // com.bumptech.glide.load.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.bumptech.glide.load.x.z0<Bitmap> z0Var, File file, com.bumptech.glide.load.r rVar) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap = z0Var.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, rVar);
        com.bumptech.glide.b0.q.i.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = com.bumptech.glide.b0.j.b();
            int iIntValue = ((Integer) rVar.c(b)).intValue();
            boolean z = false;
            OutputStream cVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                cVar = this.a != null ? new com.bumptech.glide.load.w.c(fileOutputStream, this.a) : fileOutputStream;
                bitmap.compress(compressFormatD, iIntValue, cVar);
                cVar.close();
                z = true;
            } catch (IOException e2) {
                e = e2;
                cVar = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (cVar != null) {
                    cVar.close();
                }
                if (Log.isLoggable("BitmapEncoder", 2)) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            cVar.close();
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + com.bumptech.glide.b0.p.g(bitmap) + " in " + com.bumptech.glide.b0.j.a(jB) + ", options format: " + rVar.c(c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } finally {
            com.bumptech.glide.b0.q.i.d();
        }
    }
}
