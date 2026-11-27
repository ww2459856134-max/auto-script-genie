package com.frame;

import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

/* loaded from: classes.dex */
class o1 extends TimerTask {
    final /* synthetic */ InputMethodManager c;

    o1(InputMethodManager inputMethodManager) {
        this.c = inputMethodManager;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.c.toggleSoftInput(0, 2);
    }
}
