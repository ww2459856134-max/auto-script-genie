package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements h.e.j.e0, h.e.j.c0 {
    private final m c;
    private final f0 d;
    private final c0 e;
    private final androidx.core.widget.p f;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    @Override // h.e.j.c0
    public h.e.j.g a(h.e.j.g gVar) {
        return this.f.a(this, gVar);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.c;
        if (mVar != null) {
            mVar.b();
        }
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.b();
        }
    }

    @Override // h.e.j.e0
    public ColorStateList getSupportBackgroundTintList() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    @Override // h.e.j.e0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m mVar = this.c;
        if (mVar != null) {
            return mVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        c0 c0Var;
        return (Build.VERSION.SDK_INT >= 28 || (c0Var = this.e) == null) ? super.getTextClassifier() : c0Var.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.d.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        q.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        String[] strArrZ = h.e.j.s0.z(this);
        if (inputConnectionOnCreateInputConnection == null || strArrZ == null) {
            return inputConnectionOnCreateInputConnection;
        }
        h.e.j.s1.b.d(editorInfo, strArrZ);
        return h.e.j.s1.e.a(inputConnectionOnCreateInputConnection, editorInfo, w.a(this));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (w.b(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        if (w.c(this, i2)) {
            return true;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m mVar = this.c;
        if (mVar != null) {
            mVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        m mVar = this.c;
        if (mVar != null) {
            mVar.g(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.n(this, callback));
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.i(colorStateList);
        }
    }

    @Override // h.e.j.e0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar != null) {
            mVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        f0 f0Var = this.d;
        if (f0Var != null) {
            f0Var.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        c0 c0Var;
        if (Build.VERSION.SDK_INT >= 28 || (c0Var = this.e) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0Var.b(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, h.a.a.B);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i2) {
        super(q1.b(context), attributeSet, i2);
        p1.a(this, getContext());
        m mVar = new m(this);
        this.c = mVar;
        mVar.e(attributeSet, i2);
        f0 f0Var = new f0(this);
        this.d = f0Var;
        f0Var.m(attributeSet, i2);
        f0Var.b();
        this.e = new c0(this);
        this.f = new androidx.core.widget.p();
    }
}
