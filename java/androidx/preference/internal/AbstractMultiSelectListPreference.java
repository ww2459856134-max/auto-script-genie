package androidx.preference.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.DialogPreference;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class AbstractMultiSelectListPreference extends DialogPreference {
    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public abstract CharSequence[] E0();

    public abstract CharSequence[] F0();

    public abstract Set<String> G0();

    public abstract void H0(Set<String> set);

    public AbstractMultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
