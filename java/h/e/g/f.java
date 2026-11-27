package h.e.g;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
abstract class f {
    private static final Comparator<byte[]> a = new e();

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> c(g gVar, Resources resources) {
        return gVar.b() != null ? gVar.b() : androidx.core.content.c.g.c(resources, gVar.c());
    }

    static n d(Context context, g gVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoE = e(context.getPackageManager(), gVar, context.getResources());
        return providerInfoE == null ? n.a(1, null) : n.a(0, f(context, gVar, providerInfoE.authority, cancellationSignal));
    }

    static ProviderInfo e(PackageManager packageManager, g gVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = gVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(gVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + gVar.f());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, a);
        List<List<byte[]>> listC = c(gVar, resources);
        for (int i2 = 0; i2 < listC.size(); i2++) {
            ArrayList arrayList = new ArrayList(listC.get(i2));
            Collections.sort(arrayList, a);
            if (b(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    static o[] f(Context context, g gVar, String str, CancellationSignal cancellationSignal) {
        int i2;
        Uri uriWithAppendedId;
        boolean z;
        int i3;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            int i4 = 0;
            cursorQuery = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, strArr, "query = ?", new String[]{gVar.g()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, strArr, "query = ?", new String[]{gVar.g()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int i5 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : i4;
                    int i6 = columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : i4;
                    if (columnIndex3 == -1) {
                        i2 = i5;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2));
                    } else {
                        i2 = i5;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3));
                    }
                    int i7 = columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursorQuery.getInt(columnIndex6) != 1) {
                        z = false;
                        i3 = i2;
                    } else {
                        i3 = i2;
                        z = true;
                    }
                    arrayList2.add(o.a(uriWithAppendedId, i6, i7, z, i3));
                    i4 = 0;
                }
                arrayList = arrayList2;
            }
            return (o[]) arrayList.toArray(new o[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}
