package com.v;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.v.JudgeDialogView;
import com.v.item.ParamNameTextView;
import com.yl.float_ui.InputDialogView;

/* loaded from: classes.dex */
public class JudgeDialogView extends FrameLayout {
    private ViewGroup c;
    private b d;

    class a implements View.OnClickListener {
        a() {
        }

        static /* synthetic */ boolean a(EditText editText, String str) {
            editText.setText(str);
            return true;
        }

        static /* synthetic */ void b(final EditText editText, View view) {
            ParamNameTextView paramNameTextView = new ParamNameTextView(com.frame.v0.g());
            paramNameTextView.setInputHint("请输入值~");
            paramNameTextView.setInputLabel("请输入值");
            paramNameTextView.setText(editText.getText().toString());
            paramNameTextView.k(new InputDialogView.a() { // from class: com.v.mb
                @Override // com.yl.float_ui.InputDialogView.a
                public final boolean a(String str) {
                    return JudgeDialogView.a.a(editText, str);
                }
            });
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (JudgeDialogView.this.c != null) {
                JudgeDialogView.this.c.setBackgroundResource(j.b.d.e);
                EditText editText = (EditText) JudgeDialogView.this.c.getChildAt(1);
                editText.setEnabled(false);
                editText.setVisibility(8);
                editText.setText((CharSequence) null);
                editText.setHint((CharSequence) null);
                JudgeDialogView.this.c.getChildAt(2).setVisibility(8);
            }
            view.setBackgroundResource(j.b.d.f1742i);
            JudgeDialogView.this.c = (ViewGroup) view;
            final EditText editText2 = (EditText) JudgeDialogView.this.c.getChildAt(1);
            editText2.setText((CharSequence) null);
            editText2.setHint("请输入值");
            editText2.setEnabled(true);
            editText2.setVisibility(0);
            com.frame.p1.a(editText2, 100);
            View childAt = JudgeDialogView.this.c.getChildAt(2);
            childAt.setVisibility(0);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.v.nb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    JudgeDialogView.a.b(editText2, view2);
                }
            });
        }
    }

    public interface b {
        void a(String str, String str2);
    }

    public JudgeDialogView() {
        super(com.frame.v0.g());
        LayoutInflater.from(com.frame.v0.g()).inflate(j.b.f.F, (ViewGroup) this, true);
        a aVar = new a();
        findViewById(j.b.e.m2).setOnClickListener(aVar);
        findViewById(j.b.e.j2).setOnClickListener(aVar);
        findViewById(j.b.e.p3).setOnClickListener(aVar);
        findViewById(j.b.e.f2).setOnClickListener(aVar);
        findViewById(j.b.e.K2).setOnClickListener(aVar);
        findViewById(j.b.e.a2).setOnClickListener(aVar);
        findViewById(j.b.e.P).setOnClickListener(new View.OnClickListener() { // from class: com.v.kb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(JudgeDialogView.class);
            }
        });
        findViewById(j.b.e.g).setOnClickListener(new View.OnClickListener() { // from class: com.v.lb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.e(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        ViewGroup viewGroup = this.c;
        if (viewGroup == null) {
            FloatToast.i("请先选择一项逻辑");
            return;
        }
        String string = ((EditText) viewGroup.getChildAt(1)).getText().toString();
        String string2 = ((TextView) this.c.getChildAt(0)).getText().toString();
        if (this.c.getId() != j.b.e.m2 && TextUtils.isEmpty(string)) {
            FloatToast.i("请先输入值");
            this.c.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        com.frame.s0.g().d(JudgeDialogView.class);
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(string2, string);
        }
    }

    public void setOnJudgeChooseListener(b bVar) {
        this.d = bVar;
    }

    public void setSelectValue(String str, String str2) {
        int[] iArr = {j.b.e.m2, j.b.e.j2, j.b.e.p3};
        for (int i2 = 0; i2 < 3; i2++) {
            ViewGroup viewGroup = (ViewGroup) findViewById(iArr[i2]);
            if (str.equals(((TextView) viewGroup.getChildAt(0)).getText().toString())) {
                viewGroup.callOnClick();
                ((EditText) viewGroup.getChildAt(1)).setText(str2);
                return;
            }
        }
    }
}
