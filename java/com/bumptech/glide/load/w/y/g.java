package com.bumptech.glide.load.w.y;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
class g {
    private static final a f = new a();
    private final a a;
    private final f b;
    private final com.bumptech.glide.load.x.g1.b c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;

    g(List<ImageHeaderParser> list, f fVar, com.bumptech.glide.load.x.g1.b bVar, ContentResolver contentResolver) {
        this(list, f, fVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Uri uri) throws Throwable {
        Cursor cursorA;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                cursorA = this.b.a(uri);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToFirst()) {
                            String string = cursorA.getString(0);
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return string;
                        }
                    } catch (SecurityException e) {
                        e = e;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        return null;
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SecurityException e2) {
            e = e2;
            cursorA = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private boolean c(File file) {
        return this.a.a(file) && 0 < this.a.c(file);
    }

    int a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.d.openInputStream(uri);
                int iB = m.b(this.e, inputStreamOpenInputStream, this.c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iB;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.d.openInputStream(uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    g(List<ImageHeaderParser> list, a aVar, f fVar, com.bumptech.glide.load.x.g1.b bVar, ContentResolver contentResolver) {
        this.a = aVar;
        this.b = fVar;
        this.c = bVar;
        this.d = contentResolver;
        this.e = list;
    }
}
