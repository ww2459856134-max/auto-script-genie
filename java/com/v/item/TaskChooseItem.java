package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.v.TaskChooseDialogView;
import com.yl.model.TaskSimple;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TaskChooseItem extends BaseItemView implements View.OnClickListener {
    private TextView c;

    public TaskChooseItem(Context context) {
        super(context);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(TaskSimple taskSimple) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        this.c.setText(taskSimple.getName());
    }

    public void c() {
        View.inflate(getContext(), j.b.f.Y0, this);
    }

    @Override // com.v.item.BaseItemView
    public Object getValue() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == j.b.e.Z5) {
            TaskChooseDialogView.show().setOnChooseListener(new TaskChooseDialogView.b() { // from class: com.v.item.y1
                @Override // com.v.TaskChooseDialogView.b
                public final void a(TaskSimple taskSimple) {
                    this.a.e(taskSimple);
                }
            });
        }
    }

    @Override // com.v.item.BaseItemView
    public void setRule(JSONObject jSONObject) {
        super.setRule(jSONObject);
        String strOptString = jSONObject.optString("label");
        jSONObject.optString(SocialConstants.PARAM_TYPE);
        jSONObject.optString("defaultValue");
        jSONObject.optString("hint");
        jSONObject.optString("unit");
        jSONObject.optString("inputType");
        jSONObject.optJSONArray("item");
        ((TextView) findViewById(j.b.e.K5)).setText(strOptString);
        TextView textView = (TextView) findViewById(j.b.e.Z5);
        this.c = textView;
        textView.setOnClickListener(this);
    }

    public TaskChooseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskChooseItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
