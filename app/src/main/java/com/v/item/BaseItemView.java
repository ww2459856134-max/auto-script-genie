package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.yl.float_ui.DingMsgView;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaseItemView extends RelativeLayout {
    public BaseItemView(Context context) {
        super(context);
    }

    public void b(String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(str);
        dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.item.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public Object getValue() {
        return null;
    }

    public void setRule(JSONObject jSONObject) {
    }

    public BaseItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
