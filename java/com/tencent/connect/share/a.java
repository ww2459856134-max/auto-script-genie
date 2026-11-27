package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i6 > i3 || i4 > i2;
    }

    public static final void a(final Context context, final String str, final d dVar) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(str)) {
            dVar.a(1, (String) null);
        } else if (!l.a()) {
            dVar.a(2, (String) null);
        } else {
            final Handler handler = new Handler(context.getMainLooper()) { // from class: com.tencent.connect.share.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i2 = message.what;
                    if (i2 == 101) {
                        dVar.a(0, (ArrayList<String>) message.obj);
                    } else if (i2 != 102) {
                        super.handleMessage(message);
                    } else {
                        dVar.a(message.arg1, (String) null);
                    }
                }
            };
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    String string;
                    try {
                        Bitmap bitmapA = a.a(str, 840);
                        if (bitmapA != null) {
                            File fileA = f.a("Images");
                            String str3 = null;
                            if (fileA != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(fileA.getAbsolutePath());
                                String str4 = File.separator;
                                sb.append(str4);
                                sb.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb.append(str4);
                                string = sb.toString();
                                str2 = null;
                            } else {
                                File fileD = f.d();
                                if (fileD == null) {
                                    SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() getCacheDir = null,return error");
                                    Message messageObtainMessage = handler.obtainMessage();
                                    messageObtainMessage.arg1 = 102;
                                    handler.sendMessage(messageObtainMessage);
                                    return;
                                }
                                String absolutePath = fileD.getAbsolutePath();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(absolutePath);
                                String str5 = File.separator;
                                sb2.append(str5);
                                sb2.append(Constants.QQ_SHARE_TEMP_DIR);
                                sb2.append(str5);
                                String string2 = sb2.toString();
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() use cache dir=" + string2);
                                str2 = absolutePath;
                                string = string2;
                            }
                            String str6 = "share2qq_temp" + l.f(str) + ".jpg";
                            String str7 = str;
                            if (a.b(str7, 840, 840)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() out of bound,compress!");
                                String strA = a.a(bitmapA, string, str6);
                                if (!TextUtils.isEmpty(strA)) {
                                    str7 = strA;
                                }
                            } else {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() not out of bound,not compress!");
                            }
                            boolean zN = l.n(str7);
                            SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() check file isAppSpecificDir=" + zN);
                            ArrayList arrayList = new ArrayList(2);
                            if (zN) {
                                str3 = str7;
                            } else if (TextUtils.isEmpty(str2)) {
                                String str8 = string + str6;
                                boolean zA = l.a(context, str7, str8);
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() sd permission not denied. copy to app sepcific:" + str8 + ",isSuccess=" + zA);
                                if (zA) {
                                    str3 = str8;
                                }
                            }
                            arrayList.add(str7);
                            arrayList.add(str3);
                            if (arrayList.size() >= 2 && (arrayList.get(0) != null || arrayList.get(1) != null)) {
                                SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return success ! destFilePath=[" + ((String) arrayList.get(0)) + "," + ((String) arrayList.get(1)) + "]");
                                Message messageObtainMessage2 = handler.obtainMessage(101);
                                messageObtainMessage2.obj = arrayList;
                                handler.sendMessage(messageObtainMessage2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage runnable exception e:", e);
                    }
                    SLog.d("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage() return failed!");
                    Message messageObtainMessage3 = handler.obtainMessage(102);
                    messageObtainMessage3.arg1 = 3;
                    handler.sendMessage(messageObtainMessage3);
                }
            }).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = i2 / width;
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static int b(BitmapFactory.Options options, int i2, int i3) {
        int iMin;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int iCeil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i3));
        if (i2 == -1) {
            iMin = 128;
        } else {
            double d3 = i2;
            iMin = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? iCeil : iMin;
    }

    protected static final String a(Bitmap bitmap, String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String string = stringBuffer.toString();
        File file2 = new File(string);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return string;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap a(String str, int i2) {
        Bitmap bitmapDecodeFile;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return null;
        }
        if (i3 <= i4) {
            i3 = i4;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 > i2) {
            options.inSampleSize = a(options, -1, i2 * i2);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e2);
            bitmapDecodeFile = null;
            if (bitmapDecodeFile == null) {
            }
        } catch (OutOfMemoryError e3) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e3);
            bitmapDecodeFile = null;
            if (bitmapDecodeFile == null) {
            }
        }
        if (bitmapDecodeFile == null) {
            SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
            return null;
        }
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        if (i5 <= i6) {
            i5 = i6;
        }
        return i5 > i2 ? a(bitmapDecodeFile, i2) : bitmapDecodeFile;
    }

    public static final int a(BitmapFactory.Options options, int i2, int i3) {
        int iB = b(options, i2, i3);
        if (iB > 8) {
            return 8 * ((iB + 7) / 8);
        }
        int i4 = 1;
        while (i4 < iB) {
            i4 <<= 1;
        }
        return i4;
    }
}
