package androidx.appcompat.widget;

import android.app.Activity;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
abstract class v {
    static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            h.e.j.s0.S(textView, new h.e.j.f(dragEvent.getClipData(), 3).a());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    static boolean b(DragEvent dragEvent, View view, Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        h.e.j.s0.S(view, new h.e.j.f(dragEvent.getClipData(), 3).a());
        return true;
    }
}
