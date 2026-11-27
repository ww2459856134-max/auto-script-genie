package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import h.e.j.b0;

/* loaded from: classes.dex */
public final class p implements b0 {
    private static CharSequence b(ClipData clipData, Context context, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
            CharSequence charSequenceC = c(context, clipData.getItemAt(i3), i2);
            if (charSequenceC != null) {
                spannableStringBuilder.append(charSequenceC);
            }
        }
        return spannableStringBuilder;
    }

    private static CharSequence c(Context context, ClipData.Item item, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? n.a(context, item, i2) : o.a(context, item, i2);
    }

    private static void d(TextView textView, h.e.j.g gVar) {
        e((Editable) textView.getText(), b(gVar.b(), textView.getContext(), gVar.c()));
    }

    private static void e(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // h.e.j.b0
    public h.e.j.g a(View view, h.e.j.g gVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + gVar);
        }
        int iD = gVar.d();
        if (iD == 2) {
            return gVar;
        }
        if (iD == 3) {
            d((TextView) view, gVar);
            return null;
        }
        ClipData clipDataB = gVar.b();
        int iC = gVar.c();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i2 = 0; i2 < clipDataB.getItemCount(); i2++) {
            CharSequence charSequenceC = c(context, clipDataB.getItemAt(i2), iC);
            if (charSequenceC != null) {
                if (z) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceC);
                } else {
                    e(editable, charSequenceC);
                    z = true;
                }
            }
        }
        return null;
    }
}
