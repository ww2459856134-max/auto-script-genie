package com.frame;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class l0 {
    public static byte[] a(Bitmap bitmap, double d, boolean z) throws IOException {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double dSqrt = Math.sqrt(d / (width * height));
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.floor(width * dSqrt), (int) Math.floor(height * dSqrt), true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.toByteArray().length > d) {
            int iCeil = (int) Math.ceil((d / byteArrayOutputStream.toByteArray().length) * 100.0d);
            byteArrayOutputStream.reset();
            bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iCeil, byteArrayOutputStream);
            while (byteArrayOutputStream.toByteArray().length > d) {
                byteArrayOutputStream.reset();
                iCeil = (int) (iCeil - 1.5d);
                bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iCeil, byteArrayOutputStream);
            }
            c(bitmapCreateScaledBitmap);
            if (z) {
                c(bitmap);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            k0.r(e);
        }
        return byteArray;
    }

    public static Bitmap b(Bitmap bitmap, Rect rect, float f) {
        if (bitmap == null) {
            return null;
        }
        try {
            if (!bitmap.isRecycled() && rect != null && rect.width() > 0 && rect.height() > 0) {
                Log.e("图片截取", rect.toString());
                return Bitmap.createBitmap(bitmap, (int) (rect.left * f), (int) (rect.top * f), (int) (rect.width() * f), (int) (rect.height() * f), (Matrix) null, false);
            }
            return null;
        } catch (Exception e) {
            k0.r(e);
            return null;
        }
    }

    public static void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public static void d(Bitmap bitmap, File file) {
        if (bitmap == null) {
            y0.j("saveBitmap失败：Bitmap为空");
            return;
        }
        if (file == null) {
            y0.j("saveBitmap失败：目标文件为空");
            return;
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            k0.r(e);
        } catch (IOException e2) {
            k0.r(e2);
        }
    }
}
