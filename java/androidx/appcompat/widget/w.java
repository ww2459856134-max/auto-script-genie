package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import h.e.j.s1.e;

/* loaded from: classes.dex */
abstract class w {
    static e.a a(View view) {
        return new u(view);
    }

    static boolean b(View view, DragEvent dragEvent) {
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && h.e.j.s0.z(view) != null) {
            Activity activityD = d(view);
            if (activityD == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? v.a(dragEvent, (TextView) view, activityD) : v.b(dragEvent, view, activityD);
            }
        }
        return false;
    }

    static boolean c(TextView textView, int i2) {
        if ((i2 != 16908322 && i2 != 16908337) || h.e.j.s0.z(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            h.e.j.f fVar = new h.e.j.f(primaryClip, 1);
            fVar.c(i2 != 16908322 ? 1 : 0);
            h.e.j.s0.S(textView, fVar.a());
        }
        return true;
    }

    static Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
