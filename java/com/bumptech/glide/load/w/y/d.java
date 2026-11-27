package com.bumptech.glide.load.w.y;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* loaded from: classes.dex */
class d implements f {
    private static final String[] b = {"_data"};
    private final ContentResolver a;

    d(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    @Override // com.bumptech.glide.load.w.y.f
    public Cursor a(Uri uri) {
        return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
    }
}
