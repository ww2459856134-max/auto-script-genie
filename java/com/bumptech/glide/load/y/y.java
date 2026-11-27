package com.bumptech.glide.load.y;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public interface y<Data> {
    Class<Data> a();

    void b(Data data) throws IOException;

    Data c(File file) throws FileNotFoundException;
}
