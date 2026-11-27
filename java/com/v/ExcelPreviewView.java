package com.v;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.k0;
import i.b.ga.b;
import java.io.IOException;

/* loaded from: classes.dex */
public class ExcelPreviewView extends RelativeLayout {
    public ExcelPreviewView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.s, this);
        findViewById(j.b.e.r1).setOnClickListener(new View.OnClickListener() { // from class: com.v.b4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(ExcelPreviewView.class);
            }
        });
    }

    private static String a(i.b.ga.b bVar) {
        if (bVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(bVar.d(), k0.a.DEFAULT_DRAG_ANIMATION_DURATION);
        int iMin2 = Math.min(bVar.c(), 50);
        for (int i2 = 0; i2 < iMin; i2++) {
            for (int i3 = 0; i3 < iMin2; i3++) {
                b.a aVarA = bVar.a(i3, i2);
                sb.append(aVarA.a() == null ? "" : aVarA.a());
                if (i3 < iMin2 - 1) {
                    sb.append('\t');
                }
            }
            if (i2 < iMin - 1) {
                sb.append('\n');
            }
        }
        if (iMin < bVar.d() || iMin2 < bVar.c()) {
            sb.append("\n预览仅显示前200行、50列，节点读取不受此预览限制。");
        }
        return sb.toString();
    }

    static /* synthetic */ void d() {
        FloatToast.i("读取Excel失败");
        com.frame.s0.g().d(ExcelPreviewView.class);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0031 -> B:23:0x0034). Please report as a decompilation issue!!! */
    static /* synthetic */ void e(String str, final TextView textView) {
        i.b.ga.b bVarE = null;
        try {
            try {
                try {
                    bVarE = i.b.ga.a.e(com.frame.v0.g(), str);
                    bVarE.f(0);
                    final String strA = a(bVarE);
                    com.frame.l1.e(new Runnable() { // from class: com.v.a4
                        @Override // java.lang.Runnable
                        public final void run() {
                            textView.setText(strA);
                        }
                    });
                    if (bVarE != null) {
                        bVarE.close();
                    }
                } catch (IOException e) {
                    com.frame.k0.r(e);
                }
            } catch (Exception e2) {
                com.frame.k0.r(e2);
                com.frame.l1.e(new Runnable() { // from class: com.v.c4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExcelPreviewView.d();
                    }
                });
                if (bVarE == null) {
                } else {
                    bVarE.close();
                }
            }
        } catch (Throwable th) {
            if (bVarE != null) {
                try {
                    bVarE.close();
                } catch (IOException e3) {
                    com.frame.k0.r(e3);
                }
            }
            throw th;
        }
    }

    public void setPath(final String str) {
        TextView textView = (TextView) findViewById(j.b.e.r5);
        final TextView textView2 = (TextView) findViewById(j.b.e.y5);
        textView.setText(new i.b.ka.k6().U(com.frame.v0.g(), str));
        textView2.setText("加载中...");
        com.frame.l1.g(new Runnable() { // from class: com.v.z3
            @Override // java.lang.Runnable
            public final void run() {
                ExcelPreviewView.e(str, textView2);
            }
        });
    }
}
