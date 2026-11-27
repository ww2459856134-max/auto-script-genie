package com.bumptech.glide.load.y;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class l implements com.bumptech.glide.load.d<ByteBuffer> {
    @Override // com.bumptech.glide.load.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, File file, com.bumptech.glide.load.r rVar) throws Throwable {
        try {
            com.bumptech.glide.b0.c.e(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
