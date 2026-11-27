package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;

/* loaded from: classes.dex */
abstract class n {
    static CharSequence a(Context context, ClipData.Item item, int i2) {
        if ((i2 & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
    }
}
