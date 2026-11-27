package l.a.a.i;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
class c implements FilenameFilter {
    final /* synthetic */ String a;

    c(String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.startsWith(this.a + ".");
    }
}
