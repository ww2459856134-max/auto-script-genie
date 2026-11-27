package com.frame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class g1 {
    private static BitmapFactory.Options a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        int i6 = 1;
        while (true) {
            if (i4 / i6 <= i2 && i5 / i6 <= i3) {
                options.inSampleSize = i6;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return options;
            }
            i6 *= 2;
        }
    }

    private static BitmapFactory.Options b(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        a(options, i2, i3);
        return options;
    }

    public static boolean c(File file, File file2, int i2, int i3, int i4) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), b(file.getAbsolutePath(), i2, i3));
        try {
            if (bitmapDecodeFile == null) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, i4, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            bitmapDecodeFile.recycle();
        }
    }
}
