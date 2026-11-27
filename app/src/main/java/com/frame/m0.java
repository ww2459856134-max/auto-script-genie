package com.frame;

import android.content.ClipData;
import android.content.ClipboardManager;

/* loaded from: classes.dex */
public abstract class m0 {
    public static void a(String str) {
        ((ClipboardManager) v0.g().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", str));
    }
}
