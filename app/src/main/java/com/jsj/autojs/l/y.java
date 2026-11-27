package com.jsj.autojs.l;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.frame.v0;

/* loaded from: classes.dex */
public abstract class y {
    public static void a(String str) {
        ((ClipboardManager) v0.g().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", str));
    }
}
