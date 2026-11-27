package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;

/* loaded from: classes.dex */
abstract class o {
    static CharSequence a(Context context, ClipData.Item item, int i2) {
        CharSequence charSequenceCoerceToText = item.coerceToText(context);
        return ((i2 & 1) == 0 || !(charSequenceCoerceToText instanceof Spanned)) ? charSequenceCoerceToText : charSequenceCoerceToText.toString();
    }
}
