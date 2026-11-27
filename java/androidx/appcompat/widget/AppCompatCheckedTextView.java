package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] d = {R.attr.checkMark};
    private final f0 c;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f0 f0Var = this.c;
        if (f0Var != null) {
            f0Var.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        q.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(h.a.k.a.b.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.n(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f0 f0Var = this.c;
        if (f0Var != null) {
            f0Var.q(context, i2);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(q1.b(context), attributeSet, i2);
        p1.a(this, getContext());
        f0 f0Var = new f0(this);
        this.c = f0Var;
        f0Var.m(attributeSet, i2);
        f0Var.b();
        t1 t1VarU = t1.u(getContext(), attributeSet, d, i2, 0);
        setCheckMarkDrawable(t1VarU.f(0));
        t1VarU.v();
    }
}
