package com.bumptech.glide.load.w;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* loaded from: classes.dex */
final class u {
    private final ParcelFileDescriptor a;

    u(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = parcelFileDescriptor;
    }

    ParcelFileDescriptor a() throws IOException, ErrnoException {
        try {
            Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
            return this.a;
        } catch (ErrnoException e) {
            throw new IOException(e);
        }
    }
}
