package com.v;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.v.item.AreaChooseItem;
import com.v.item.BaseItemView;
import com.v.item.CoordItem;
import com.v.item.FileItem;
import com.v.item.InputItem;
import com.v.item.MultiSelectItem;
import com.v.item.SelectItem;
import com.yl.model.Node;
import com.yl.model.Task;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ArgumentSetDialogView extends RelativeLayout implements View.OnClickListener {
    private LinearLayout c;
    private Task d;
    private JSONArray e;

    public ArgumentSetDialogView(Context context) {
        super(context);
    }

    private View a(JSONObject jSONObject) {
        AreaChooseItem areaChooseItem = new AreaChooseItem(com.frame.v0.g());
        areaChooseItem.setLabel(jSONObject.optString("key"));
        areaChooseItem.setValue(Node.getRectByString(jSONObject.optString("value")), null);
        return areaChooseItem;
    }

    private View b(JSONObject jSONObject) {
        FileItem fileItem = new FileItem(com.frame.v0.g());
        fileItem.setLabel(jSONObject.optString("key"));
        fileItem.setValue(jSONObject.optString("value"));
        return fileItem;
    }

    private View c(JSONObject jSONObject) {
        MultiSelectItem multiSelectItem = new MultiSelectItem(com.frame.v0.g());
        multiSelectItem.setLabel(jSONObject.optString("key"));
        multiSelectItem.setItems(i.b.da.B().G(jSONObject.optString("items")).split("@@"));
        multiSelectItem.setValue(jSONObject.optString("value"));
        return multiSelectItem;
    }

    private View d(JSONObject jSONObject) {
        InputItem inputItem = new InputItem(com.frame.v0.g());
        inputItem.setLabel(jSONObject.optString("key"));
        inputItem.setValue(jSONObject.optString("value"));
        inputItem.setInputType(8194);
        return inputItem;
    }

    private View e(JSONObject jSONObject) {
        CoordItem coordItem = new CoordItem(com.frame.v0.g());
        coordItem.setLabel(jSONObject.optString("key"));
        if (!TextUtils.isEmpty(jSONObject.optString("value"))) {
            coordItem.setValue(Node.getPointByString(jSONObject.optString("value")));
        }
        return coordItem;
    }

    private View f(JSONObject jSONObject) {
        SelectItem selectItem = new SelectItem(com.frame.v0.g());
        selectItem.setLabel(jSONObject.optString("key"));
        selectItem.setItems(i.b.da.B().G(jSONObject.optString("items")).split("@@"));
        selectItem.setSelectLabel(jSONObject.optString("value"));
        return selectItem;
    }

    private View g(JSONObject jSONObject) {
        InputItem inputItem = new InputItem(com.frame.v0.g());
        inputItem.setLabel(jSONObject.optString("key"));
        inputItem.setValue(i.b.da.B().G(jSONObject.optString("value")));
        inputItem.setInputType(1);
        return inputItem;
    }

    public void h() {
        for (int i2 = 0; i2 < this.e.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = this.e.optJSONObject(i2);
            String strOptString = jSONObjectOptJSONObject.optString("option");
            if ("数字".equals(strOptString)) {
                this.c.addView(d(jSONObjectOptJSONObject));
            } else if ("文字".equals(strOptString)) {
                this.c.addView(g(jSONObjectOptJSONObject));
            } else if ("多选".equals(strOptString)) {
                this.c.addView(c(jSONObjectOptJSONObject));
            } else if ("单选".equals(strOptString)) {
                this.c.addView(f(jSONObjectOptJSONObject));
            } else if ("区域".equals(strOptString)) {
                this.c.addView(a(jSONObjectOptJSONObject));
            } else if ("坐标".equals(strOptString)) {
                this.c.addView(e(jSONObjectOptJSONObject));
            } else if ("文件路径".equals(strOptString)) {
                this.c.addView(b(jSONObjectOptJSONObject));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        if (view.getId() == j.b.e.A) {
            com.frame.s0.g().o(this);
            return;
        }
        if (view.getId() == j.b.e.B) {
            for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
                try {
                    JSONObject jSONObject = this.e.getJSONObject(i2);
                    BaseItemView baseItemView = (BaseItemView) this.c.getChildAt(i2);
                    if (baseItemView instanceof SelectItem) {
                        jSONObject.put("value", ((SelectItem) baseItemView).getSelectLabel());
                    } else if (baseItemView instanceof AreaChooseItem) {
                        if (baseItemView.getValue() != null) {
                            jSONObject.put("value", Node.getStringByRect((Rect) baseItemView.getValue()));
                        }
                    } else if (baseItemView instanceof CoordItem) {
                        if (baseItemView.getValue() != null) {
                            jSONObject.put("value", Node.getStringByPoint((Point) baseItemView.getValue()));
                        }
                    } else if (baseItemView.getValue() != null) {
                        jSONObject.put("value", baseItemView.getValue().toString());
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            this.d.setArgumentJson(this.e.toString());
            i.b.da.B().z1(this.d);
            com.frame.s0.g().o(this);
        }
    }

    public void setJsonArray(JSONArray jSONArray) {
    }

    public void setTask(Task task) {
        this.d = task;
        try {
            this.e = new JSONArray(task.getArgumentJson());
            h();
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public ArgumentSetDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArgumentSetDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ArgumentSetDialogView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.f1760k, this);
        this.c = (LinearLayout) findViewById(j.b.e.T3);
        findViewById(j.b.e.A).setOnClickListener(this);
        findViewById(j.b.e.B).setOnClickListener(this);
    }
}
