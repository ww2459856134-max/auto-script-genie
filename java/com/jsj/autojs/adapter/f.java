package com.jsj.autojs.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.cursor.R;
import java.util.List;

/* loaded from: classes.dex */
public class f extends androidx.viewpager.widget.a {
    private List<Integer> c;
    private Context d;
    private boolean e;
    private int[] f = {-1, -1, -1};

    public f(Context context, boolean z, List<Integer> list) {
        this.c = list;
        this.d = context;
        this.e = z;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        List<Integer> list = this.c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        View viewInflate = View.inflate(this.d, 2131493048, null);
        int[] iArr = this.f;
        viewInflate.setBackgroundColor(iArr[i2 % iArr.length]);
        ((ImageView) viewInflate.findViewById(R.id.image)).setImageResource(this.c.get(i2).intValue());
        viewGroup.addView(viewInflate);
        if (i2 == this.c.size() - 1) {
            TextView textView = (TextView) viewInflate.findViewById(2131296526);
            textView.setVisibility(0);
            textView.setText(this.e ? "分享好友" : "立即体验");
            viewInflate.setOnClickListener(new e(this));
        } else {
            viewInflate.findViewById(R.id.animation_view).setVisibility(0);
        }
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return view == obj;
    }
}
