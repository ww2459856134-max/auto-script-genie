package h.e.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class l extends p {
    @Override // h.e.d.p
    public Typeface b(Context context, androidx.core.content.c.d dVar, Resources resources, int i2) throws IOException {
        try {
            androidx.core.content.c.e[] eVarArrA = dVar.a();
            int length = eVarArrA.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                androidx.core.content.c.e eVar = eVarArrA[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, eVar.b()).setWeight(eVar.e());
                    if (!eVar.f()) {
                        i4 = 0;
                    }
                    Font fontBuild = weight.setSlant(i4).setTtcIndex(eVar.c()).setFontVariationSettings(eVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[Catch: IOException -> 0x0060, Exception -> 0x008b, PHI: r4
      0x001c: PHI (r4v5 android.graphics.fonts.FontFamily$Builder) = (r4v3 android.graphics.fonts.FontFamily$Builder), (r4v1 android.graphics.fonts.FontFamily$Builder) binds: [B:20:0x0051, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x008b, blocks: (B:3:0x0005, B:6:0x000c, B:7:0x000e, B:10:0x001c, B:28:0x005f, B:27:0x005c, B:32:0x0066, B:36:0x0071, B:39:0x0076), top: B:45:0x0005 }] */
    @Override // h.e.d.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Typeface c(Context context, CancellationSignal cancellationSignal, h.e.g.o[] oVarArr, int i2) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = oVarArr.length;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
                }
                h.e.g.o oVar = oVarArr[i3];
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(oVar.d(), "r", cancellationSignal);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Font.Builder weight = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(oVar.e());
                            if (!oVar.f()) {
                                i4 = 0;
                            }
                            Font fontBuild = weight.setSlant(i4).setTtcIndex(oVar.c()).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                            }
                        } catch (Throwable th) {
                            if (parcelFileDescriptorOpenFileDescriptor != null) {
                                try {
                                    parcelFileDescriptorOpenFileDescriptor.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } else if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // h.e.d.p
    protected Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // h.e.d.p
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // h.e.d.p
    protected h.e.g.o h(h.e.g.o[] oVarArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
