package com.bumptech.glide.load.x.i1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
class g implements FilenameFilter {
    final /* synthetic */ Pattern a;

    g(Pattern pattern) {
        this.a = pattern;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.a.matcher(str).matches();
    }
}
