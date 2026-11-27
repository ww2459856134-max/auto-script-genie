package androidx.appcompat.app;

import android.content.Context;
import android.widget.ArrayAdapter;

/* loaded from: classes.dex */
class o extends ArrayAdapter<CharSequence> {
    public o(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
        super(context, i2, i3, charSequenceArr);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
